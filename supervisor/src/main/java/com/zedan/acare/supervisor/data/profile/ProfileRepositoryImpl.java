package com.zedan.acare.supervisor.data.profile;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.zedan.acare.supervisor.data.utils.ReplaceKeys;
import com.zedan.acare.supervisor.di.qulifier.PatientDatabaseReference;
import com.zedan.acare.supervisor.di.qulifier.SupervisorDatabaseReference;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.domain.profile.ProfileParam;
import com.zedan.acare.supervisor.domain.profile.ProfileRepository;
import com.zedan.acare.supervisor.domain.profile.ProfileResult;
import com.zedan.acare.supervisor.domain.profile.UserDataBasic;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;

@Singleton
public final class ProfileRepositoryImpl extends ProfileRepository {

    public final FirebaseAuth firebaseAuth;

    public final DatabaseReference patientReference;

    public final DatabaseReference supervisorReference;

    @Inject
    public ProfileRepositoryImpl(FirebaseAuth firebaseAuth,
                                 @SupervisorDatabaseReference DatabaseReference supervisorReference,
                                 @PatientDatabaseReference DatabaseReference patientReference) {
        this.firebaseAuth = firebaseAuth;
        this.supervisorReference = supervisorReference;
        this.patientReference = patientReference;
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
    public Observable<ProfileResult> getUserInfo(ProfileParam param) {
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
                        .flatMap((Function<RegisterParam, ObservableSource<ProfileResult>>) this::getPatient);
            }
        });
    }

    ;

    private Observable<RegisterParam> getSupervisor(String supervisorKey) {
        return Observable.create(emitter -> supervisorReference
                .child(supervisorKey)
                .get()
                .addOnSuccessListener(r -> {
                    RegisterParam param = r.getValue(RegisterParam.class);
                    emitter.onNext(param);
                    emitter.onComplete();
                })
                .addOnFailureListener(emitter::onError));
    }

    private Observable<ProfileResult> getPatient(RegisterParam supervisor) {
        return Observable.create(emitter -> {
            if (supervisor.getPatients() != null && !supervisor.getPatients().isEmpty()) {
                String patient = ReplaceKeys.toValidKey(supervisor.getPatients());
                patientReference
                        .child(patient)
                        .get()
                        .addOnSuccessListener(r -> {
                            RegisterPatientParam p = r.getValue(RegisterPatientParam.class);
                            emitter.onNext(new ProfileResult.Success(supervisor, p));
                            emitter.onComplete();
                        })
                        .addOnFailureListener(emitter::onError);
            } else {
                emitter.onNext(new ProfileResult.Success(supervisor, null));
                emitter.onComplete();
            }
        });
    }

}
