package com.zedan.acare.supervisor.data.profile;

import android.net.Uri;
import android.util.Pair;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.zedan.acare.supervisor.data.utils.ReplaceKeys;
import com.zedan.acare.supervisor.di.qulifier.PatientDatabaseReference;
import com.zedan.acare.supervisor.di.qulifier.PersonalPhotoStorageReference;
import com.zedan.acare.supervisor.di.qulifier.SupervisorDatabaseReference;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.domain.profile.EditInputParam;
import com.zedan.acare.supervisor.domain.profile.EditInputResult;
import com.zedan.acare.supervisor.domain.profile.ProfileRepository;
import com.zedan.acare.supervisor.domain.profile.ProfileResult;
import com.zedan.acare.supervisor.domain.profile.UploadImageParam;
import com.zedan.acare.supervisor.domain.profile.UploadImageStatus;
import com.zedan.acare.supervisor.domain.profile.UserDataBasic;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import timber.log.Timber;

@Singleton
public final class ProfileRepositoryImpl extends ProfileRepository {

    public final FirebaseAuth firebaseAuth;

    public final DatabaseReference patientReference;

    public final DatabaseReference supervisorReference;

    private final FirebaseDatabase database;

    private final StorageReference personalStorage;


    @Inject
    public ProfileRepositoryImpl(
            FirebaseDatabase database,
            FirebaseAuth firebaseAuth,
            @SupervisorDatabaseReference DatabaseReference supervisorReference,
            @PatientDatabaseReference DatabaseReference patientReference,
            @PersonalPhotoStorageReference StorageReference personalStorage
    ) {
        this.firebaseAuth = firebaseAuth;
        this.supervisorReference = supervisorReference;
        this.patientReference = patientReference;
        this.database = database;
        this.personalStorage = personalStorage;
    }

    @Override
    public Observable<UserDataBasic> getBasicUserInfo() {
        File image = firebaseAuth.getCurrentUser() != null &&
                firebaseAuth.getCurrentUser().getPhotoUrl() != null ?
                new File(firebaseAuth.getCurrentUser().getPhotoUrl().getPath()) : null;
        return Observable.just(new UserDataBasic(
                firebaseAuth.getCurrentUser() != null ? firebaseAuth.getCurrentUser().getDisplayName() : "",
                image
        ));
    }

    @Override
    public Observable<ProfileResult> getUserInfo() {
        Observable<String> supervisor = Observable.create(emitter -> {
            if (firebaseAuth.getCurrentUser() != null &&
                    firebaseAuth.getCurrentUser().getEmail() != null) {
                emitter.onNext(ReplaceKeys.toValidKey(firebaseAuth.getCurrentUser().getEmail()));
            } else {
                emitter.onNext("");
            }
            emitter.onComplete();
        });
        return supervisor.flatMap((Function<String, ObservableSource<ProfileResult>>) s -> {
            if (s == null || s.isEmpty()) {
                return Observable.just(
                        new ProfileResult.Error(
                                new UserNullException()
                        ));
            } else {
                return getSupervisor(s)
                        .flatMap((Function<Pair<RegisterParam, String>, ObservableSource<ProfileResult>>) this::getPatient);
            }
        });
    }


    private Observable<Pair<RegisterParam, String>> getSupervisor(String supervisorKey) {
        return Observable.create(emitter -> supervisorReference
                .child(supervisorKey)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        RegisterParam param = snapshot.getValue(RegisterParam.class);
                        emitter.onNext(new Pair<>(param, snapshot.getRef().toString()));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        emitter.onError(error.toException());
                        emitter.onComplete();
                    }
                })
        );
    }

    private Observable<ProfileResult> getPatient(Pair<RegisterParam, String> supervisor) {
        return Observable.create(emitter -> {
            if (supervisor.first.getPatients() != null && !supervisor.first.getPatients().isEmpty()) {
                String patient = ReplaceKeys.toValidKey(supervisor.first.getPatients());
                patientReference
                        .child(patient)
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String path = snapshot.getRef().toString();
                                RegisterPatientParam p = snapshot.getValue(RegisterPatientParam.class);
                                emitter.onNext(new ProfileResult.Success(supervisor.first, p, supervisor.second, path));
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                emitter.onError(error.toException());
                                emitter.onComplete();
                            }
                        });
            } else {
                emitter.onNext(new ProfileResult.Success(supervisor.first, null, supervisor.second, ""));
                emitter.onComplete();
            }
        });
    }

    @Override
    public Observable<EditInputResult> updateInput(EditInputParam param) {
        return Observable.create(emitter -> {
            if (!param.getValidation().validateInput(param.getValue())) {
                emitter.onNext(EditInputResult.Error.InputError.INPUT_ERROR);
                emitter.onComplete();
                return;
            }


            database.getReferenceFromUrl(param.getPath())
                    .setValue(param.getValue())
                    .addOnSuccessListener(r -> {
                        emitter.onNext(EditInputResult.Success.SUCCESS);
                        emitter.onComplete();
                    })
                    .addOnFailureListener(t -> {
                        emitter.onNext(new EditInputResult.Error.Exception(t));
                        emitter.onComplete();
                    });
        });
    }


    @Override
    public Observable<UploadImageStatus> updateImage(UploadImageParam param) {
        return uploadImageToStorage(param)
                .flatMap((Function<String, ObservableSource<UploadImageStatus>>) s -> {
                    if (s == null || s.isEmpty())
                    return Observable.just(new UploadImageStatus.Error(new Throwable()));

                    return updateImageInDB(new UploadImageParam(s, param.getDatabasePath()));
                });
    }

    private Observable<String> uploadImageToStorage(UploadImageParam param){
        return Observable.create(emitter -> {
            if (param.getPath() == null) {
                emitter.onNext("");
                emitter.onComplete();
            } else {
                File file = new File(param.getPath());
                StorageReference ref = personalStorage
                        .child(firebaseAuth.getCurrentUser().getEmail() + "." + file.getAbsolutePath());

                ref.putFile(Uri.fromFile(file))
                        .continueWithTask(c -> {
                            if (!c.isSuccessful()) {
                                if (c.getException() != null) {
                                    emitter.onError(c.getException());
                                }
                            }
                            return ref.getDownloadUrl();
                        })
                        .addOnSuccessListener(u -> {
                            Timber.e("Upload image is complete.");
                            emitter.onNext(u.toString());
                            emitter.onComplete();
                        })
                        .addOnFailureListener(emitter::onError);
            }
        });
    }


    private Observable<UploadImageStatus> updateImageInDB(UploadImageParam param){
        return Observable.create(emitter -> {
            database.getReferenceFromUrl(param.getDatabasePath())
                    .setValue(param.getPath())
                    .addOnSuccessListener(r -> {
                        UserProfileChangeRequest.Builder userProfileBuilder =
                                new UserProfileChangeRequest.Builder();

                        userProfileBuilder.setDisplayName(firebaseAuth.getCurrentUser().getDisplayName());
                        userProfileBuilder.setPhotoUri(Uri.parse(param.getPath()));

                        firebaseAuth.getCurrentUser().updateProfile(userProfileBuilder.build());
                        emitter.onNext(UploadImageStatus.Success.SUCCESS);
                        emitter.onComplete();
                    })
                    .addOnFailureListener(emitter::onError);
        });
    }
}
