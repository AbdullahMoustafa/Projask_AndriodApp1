package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.Repository;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;


public abstract class AuthRepository extends Repository {

    public abstract Observable<LoginStatus> signIn(LoginParam param);

    public abstract Observable<RegisterResult> register(RegisterParam param);

    public abstract Observable<RegisterPatientResult> registerPatient(RegisterPatientParam param);
}
