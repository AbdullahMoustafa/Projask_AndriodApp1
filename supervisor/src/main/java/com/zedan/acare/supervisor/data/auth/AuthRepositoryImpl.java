package com.zedan.acare.supervisor.data.auth;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
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
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.utils.Validator;

import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
            @PatientUnderSupervisorKey String patientUnderSupervisorKey) {
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
    public Flowable<LoginStatus> signIn(LoginParam param) {
        return Flowable.create(emitter -> {
            // Check Inputs
            boolean isEmail = Validator.isEmail(param.getEmail());
            boolean isPassword = Validator.isLargeThan(param.getPassword(), 7);
            if (!isEmail || !isPassword) {
                emitter.onNext(LoginStatus.Error.InputError.INPUT_ERROR);
                return;
            }

            // Create New User
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
                            emitter.onComplete();
                        }
                    })
                    .addOnFailureListener(emitter::onError);

        }, BackpressureStrategy.BUFFER);
    }

    @Override
    public Flowable<RegisterResult> register(RegisterParam param) {
        return Flowable.create(emitter -> {

            // Check Inputs
            Map<String, Boolean> validations = registerMapperValidation.map(param);
            if (!validations.values().stream().allMatch(t -> t)) {
                emitter.onNext(registerMapperErrorInput.map(validations));
                return;
            }

            firebaseAuth.createUserWithEmailAndPassword(
                    param.getEmail(),
                    param.getPassword()
            ).addOnSuccessListener(r -> {}).addOnFailureListener(emitter::onError);

            if (param.getProfileImage() != null){
                File file = new File(param.getProfileImage());
                StorageReference ref = personalStorage
                        .child(param.getEmail() + "." + file.getAbsolutePath());

                ref.putFile(Uri.fromFile(file))
                        .continueWithTask(c -> {
                            if (!c.isSuccessful()) {
                                if (c.getException() != null){
                                    emitter.onError(c.getException());
                                }
                            }
                            return ref.getDownloadUrl();
                        })
                        .addOnSuccessListener(u -> {
                            param.setProfileImage(u.toString());
                        })
                        .addOnFailureListener(emitter::onError);


            }

        }, BackpressureStrategy.BUFFER);
    }

    @Override
    public Flowable<RegisterPatientResult> registerPatient(RegisterPatientParam param) {
        return null;
    }
}
