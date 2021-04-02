package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.UseCase;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
public final class LoginUseCase extends UseCase<LoginParam, LoginStatus> {

    private final AuthRepository repository;

    @Inject
    public LoginUseCase(AuthRepository repository2) {
        this.repository = repository2;
    }

    @Override
    protected Flowable<LoginStatus> runnable(LoginParam param) {
        return this.repository.signIn(param)
                .startWithItem(LoginStatus.Loading.LOADING)
                .onErrorReturn(LoginStatus.Error.Exception::new)
                .subscribeOn(Schedulers.io());
    }
}
