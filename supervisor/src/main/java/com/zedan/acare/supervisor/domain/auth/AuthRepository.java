package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.Repository;

import io.reactivex.rxjava3.core.Flowable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;


public abstract class AuthRepository extends Repository {

    public abstract Flowable<LoginStatus> signIn(LoginParam param);

    public abstract Flowable<RegisterResult> register(RegisterParam param);

    public abstract Flowable<RegisterPatientResult> registerPatient(RegisterPatientParam param);
}
