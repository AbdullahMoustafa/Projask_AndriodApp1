package com.zedan.acare.supervisor.data.home;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.zedan.acare.supervisor.data.utils.ReplaceKeys;
import com.zedan.acare.supervisor.di.qulifier.SupervisorDatabaseReference;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.domain.home.FillPatientResult;
import com.zedan.acare.supervisor.domain.home.HomeRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;

@Singleton

public final class HomeRepositoryImpl extends HomeRepository {

    public final FirebaseAuth firebaseAuth;
    public final DatabaseReference supervisorReference;

    @Inject
    public HomeRepositoryImpl(FirebaseAuth firebaseAuth,
                              @SupervisorDatabaseReference DatabaseReference supervisorReference) {
        this.firebaseAuth = firebaseAuth;
        this.supervisorReference = supervisorReference;
    }

    @Override
    public Observable<FillPatientResult> hasFillPatient() {
        return Observable.create(emitter -> {
            if (firebaseAuth.getCurrentUser() != null &&
                    firebaseAuth.getCurrentUser().getEmail() != null){

                String user = ReplaceKeys.toValidKey(firebaseAuth.getCurrentUser().getEmail());

                supervisorReference
                        .child(user)
                        .child("enterPatientData")
                        .get()
                        .addOnSuccessListener(r -> {
                            boolean value = r.getValue(Boolean.class);
                            emitter.onNext(new FillPatientResult.Success(value));
                        })
                        .addOnFailureListener(emitter::onError);

            } else {
                emitter.onNext(new FillPatientResult.Error(new UserNullException()));
                emitter.onComplete();
            }

        });
    }
}
