package com.zedan.acare.supervisor.data.auth;

import android.net.Uri;

import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.zedan.acare.supervisor.data.utils.ReplaceKeys;
import com.zedan.acare.supervisor.di.qulifier.PatientDatabaseReference;
import com.zedan.acare.supervisor.di.qulifier.PatientUnderSupervisorKey;
import com.zedan.acare.supervisor.di.qulifier.PersonalPhotoStorageReference;
import com.zedan.acare.supervisor.di.qulifier.SupervisorDatabaseReference;
import com.zedan.acare.supervisor.domain.auth.AuthRepository;
import com.zedan.acare.supervisor.domain.auth.LoginParam;
import com.zedan.acare.supervisor.domain.auth.LoginStatus;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientResult;
import com.zedan.acare.supervisor.domain.auth.RegisterResult;
import com.zedan.acare.supervisor.domain.exceptions.UserIsUsedException;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.utils.Validator;

import java.io.File;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import timber.log.Timber;

@Singleton
public final class AuthRepositoryImpl extends AuthRepository {

    private final FirebaseAuth firebaseAuth;

    private final RegisterPatientErrorMapper patientErrorInput;

    private final DatabaseReference patientReference;

    private final String patientUnderSupervisorKey;

    private final RegisterPatientValidationMapper patientValidation;

    private final StorageReference personalStorage;

    private final RegisterValidationErrorMapper registerMapperErrorInput;

    private final RegisterParamValidationMapper registerMapperValidation;

    public final DatabaseReference supervisorReference;

    @Inject
    public AuthRepositoryImpl(
            FirebaseAuth firebaseAuth,
            @SupervisorDatabaseReference DatabaseReference supervisorReference,
            @PatientDatabaseReference DatabaseReference patientReference,
            @PersonalPhotoStorageReference StorageReference personalStorage,
            RegisterParamValidationMapper registerMapperValidation,
            RegisterValidationErrorMapper registerMapperErrorInput,
            RegisterPatientValidationMapper patientValidation,
            RegisterPatientErrorMapper patientErrorInput,
            @PatientUnderSupervisorKey String patientUnderSupervisorKey
    ) {
        super();
        this.firebaseAuth = firebaseAuth;
        this.supervisorReference = supervisorReference;
        this.patientReference = patientReference;
        this.personalStorage = personalStorage;
        this.registerMapperValidation = registerMapperValidation;
        this.registerMapperErrorInput = registerMapperErrorInput;
        this.patientValidation = patientValidation;
        this.patientErrorInput = patientErrorInput;
        this.patientUnderSupervisorKey = patientUnderSupervisorKey;
    }


    @Override
    public Observable<LoginStatus> signIn(LoginParam param) {
        return Observable.create(emitter -> {
            // Check Inputs
            boolean isEmail = Validator.isEmail(param.getEmail());
            boolean isPassword = Validator.isLargeThan(param.getPassword(), 7);
            if (!isEmail || !isPassword) {
                emitter.onNext(LoginStatus.Error.InputError.INPUT_ERROR);
                emitter.onComplete();
                return;
            }

            // Sign In User
            firebaseAuth.signInWithEmailAndPassword(
                    param.getEmail(),
                    param.getPassword()
            )
                    .addOnSuccessListener(r -> {
                        if (r.getUser() == null) {
                            emitter.onError(new UserNullException());
                        } else {
                            firebaseAuth.updateCurrentUser(r.getUser());
                            emitter.onNext(LoginStatus.Success.SUCCESS);
                            //emitter.onComplete();
                        }
                    })
                    .addOnFailureListener(emitter::onError);
        });
    }

    @Override
    public Observable<RegisterResult> register(RegisterParam param) {
        return createUser(param)
                .flatMap((Function<RegisterResult, ObservableSource<RegisterResult>>) registerResult -> {
                    Timber.e("Called flat map createUser.");
                    if (registerResult instanceof RegisterResult.Error.InputError)
                        return Observable.just(registerResult);

                    return uploadUserImage(param.getEmail(), param.getProfileImage())
                            .flatMap((Function<String, ObservableSource<RegisterResult>>) s -> {
                                Timber.e("Called flat map uploadUserImage.");
                                param.setProfileImage(s);
                                return createUserDataBase(param);
                            });
                });
    }

    private Observable<RegisterResult> createUser(RegisterParam param) {
        return Observable.create(emitter -> {
            Timber.e("Create user is called.");
            // Check Inputs
            Map<String, Boolean> validations = registerMapperValidation.map(param);
            if (!validations.values().stream().allMatch(t -> t)) {
                emitter.onNext(registerMapperErrorInput.map(validations));
                emitter.onComplete();
                return;
            }
            firebaseAuth.createUserWithEmailAndPassword(
                    param.getEmail(),
                    param.getPassword()
            )
                    .addOnSuccessListener(s -> {
                                emitter.onNext(RegisterResult.Success.SUCCESS);
                                Timber.e("Create user auth is complete.");
                                emitter.onComplete();
                            }
                    )
                    .addOnFailureListener(emitter::onError);
        });
    }

    private Observable<String> uploadUserImage(String email, @Nullable String image) {
        return Observable.create(emitter -> {
            Timber.e("Upload image is called.");
            if (image == null) {
                Timber.e("image is empty.");
                emitter.onNext("");
                emitter.onComplete();
            } else {
                File file = new File(image);
                StorageReference ref = personalStorage
                        .child(email + "." + file.getAbsolutePath());

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

    private Observable<RegisterResult> createUserDataBase(RegisterParam param) {
        return Observable.create(emitter -> {
            Timber.e("create user data base is called.");
            String supervisorKey = ReplaceKeys.toValidKey(param.getEmail());
            supervisorReference
                    .child(supervisorKey)
                    .setValue(param.toMap())
                    .addOnCompleteListener(v -> {
                        UserProfileChangeRequest.Builder userProfileBuilder =
                                new UserProfileChangeRequest.Builder();

                        userProfileBuilder.setDisplayName(param.getFullName());
                        if (param.getProfileImage() != null && !param.getProfileImage().isEmpty()) {
                            userProfileBuilder.setPhotoUri(Uri.parse(param.getProfileImage()));
                        }

                        if (firebaseAuth.getCurrentUser() != null) {
                            firebaseAuth.getCurrentUser().updateProfile(userProfileBuilder.build());
                        }
                        Timber.e("Create user is complete.");
                        emitter.onNext(RegisterResult.Success.SUCCESS);
                        emitter.onComplete();
                    })
                    .addOnFailureListener(emitter::onError);
        });
    }

    @Override
    public Observable<RegisterPatientResult> registerPatient(RegisterPatientParam param) {
        return checkInputsPatients(param)
                .flatMap((Function<RegisterPatientResult, ObservableSource<RegisterPatientResult>>) result -> {
                    if (result instanceof RegisterPatientResult.Error)
                        return Observable.just(result);
                    return patientIsUsed(param)
                            .flatMap((Function<Boolean, ObservableSource<RegisterPatientResult>>) aBoolean -> {
                                if (aBoolean) {
                                    return Observable
                                            .just(new RegisterPatientResult.Error.Exception(
                                                    new UserIsUsedException())
                                            );
                                }
                                if (firebaseAuth.getCurrentUser() == null) {
                                    return Observable.just(
                                            new RegisterPatientResult.Error.Exception(
                                                    new UserNullException()
                                            ));
                                }

                                String email = firebaseAuth.getCurrentUser().getEmail();
                                if (email == null) {
                                    return Observable.just(
                                            new RegisterPatientResult.Error.Exception(
                                                    new UserNullException()
                                            )
                                    );
                                }

                                String supervisorEmail = ReplaceKeys.toValidKey(email);

                                return createPatient(param, supervisorEmail)
                                        .flatMap(r -> {
                                            if (r instanceof RegisterPatientResult.Error)
                                                return Observable.just(result);

                                            return updateSupervisorChild(
                                                    supervisorEmail,
                                                    ReplaceKeys.toValidKey(param.getMobile())
                                            );
                                        });
                            });
                });
    }

    private Observable<RegisterPatientResult> checkInputsPatients(RegisterPatientParam param) {
        return Observable.create(emitter -> {
            Map<String, Boolean> validation = patientValidation.map(param);

            if (!validation.values().stream().allMatch(t -> t)) {
                emitter.onNext(patientErrorInput.map(validation));
                emitter.onComplete();
                return;
            }

            emitter.onNext(RegisterPatientResult.Success.SUCCESS);
            emitter.onComplete();
        });
    }


    private Observable<Boolean> patientIsUsed(RegisterPatientParam param) {
        return Observable.create(emitter -> patientReference
                .get()
                .addOnSuccessListener(s -> {
                    boolean hasChild = s.hasChild(ReplaceKeys.toValidKey(param.getMobile()));
                    emitter.onNext(hasChild);
                    emitter.onComplete();

                }));
    }

    private Observable<RegisterPatientResult> createPatient(
            RegisterPatientParam param,
            String supervisorEmail
    ) {
        return Observable.create(emitter -> {
            String patientKey = ReplaceKeys.toValidKey(param.getMobile());

            param.setSupervisorKey(supervisorEmail);

            patientReference
                    .child(patientKey)
                    .setValue(param.toMap())
                    .addOnSuccessListener(r -> {
                        emitter.onNext(RegisterPatientResult.Success.SUCCESS);
                        emitter.onComplete();
                    })
                    .addOnFailureListener(emitter::onError);
        });
    }

    private Observable<RegisterPatientResult> updateSupervisorChild(
            String supervisorKey,
            String patientKey
    ) {
        return Observable.create(emitter -> supervisorReference
                .child(supervisorKey)
                .child("enterPatientData")
                .setValue(true)
                .addOnSuccessListener(s -> supervisorReference
                        .child(supervisorKey)
                        .child(patientUnderSupervisorKey)
                        .setValue(patientKey)
                        .addOnSuccessListener(r -> {
                            emitter.onNext(RegisterPatientResult.Success.SUCCESS);
                            emitter.onComplete();
                        })
                        .addOnFailureListener(emitter::onError))
                .addOnFailureListener(emitter::onError));
    }
}
