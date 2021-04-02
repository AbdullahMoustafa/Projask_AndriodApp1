package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.UseCase;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
public final class RegisterPatientUseCase extends UseCase<RegisterPatientParam, RegisterPatientResult> {

    private final AuthRepository authRepository;

    @Inject
    public RegisterPatientUseCase(AuthRepository authRepository2) {
        this.authRepository = authRepository2;
    }

    @Override
    protected Flowable<RegisterPatientResult> runnable(RegisterPatientParam param) {
        return authRepository.registerPatient(param)
                .startWithItem(RegisterPatientResult.Loading.LOADING)
                .onErrorReturn(RegisterPatientResult.Error.Exception::new)
                .subscribeOn(Schedulers.io());
    }
}
