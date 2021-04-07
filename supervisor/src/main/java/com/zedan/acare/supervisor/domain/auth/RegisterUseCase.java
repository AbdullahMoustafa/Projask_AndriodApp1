package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.UseCase;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton

public final class RegisterUseCase extends UseCase<RegisterParam, RegisterResult> {

    private final AuthRepository repository;

    @Inject
    public RegisterUseCase(AuthRepository repository2) {
        Intrinsics.checkNotNullParameter(repository2, "repository");
        this.repository = repository2;
    }

    @Override
    protected Observable<RegisterResult> runnable(RegisterParam param) {
        return repository.register(param)
                .startWithItem(RegisterResult.Loading.LOADING)
                .onErrorReturn(RegisterResult.Error.Exception::new)
                .subscribeOn(Schedulers.io());
    }
}
