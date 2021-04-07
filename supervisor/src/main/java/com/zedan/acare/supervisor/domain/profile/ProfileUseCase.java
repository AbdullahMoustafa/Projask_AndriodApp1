package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.None;
import com.zedan.acare.supervisor.domain.UseCase;
import com.zedan.acare.supervisor.domain.home.FillPatientResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
public final class ProfileUseCase extends UseCase<None, ProfileResult> {
    private final ProfileRepository repository;

    @Inject
    public ProfileUseCase(ProfileRepository repository2) {
        this.repository = repository2;
    }

    @Override
    protected Observable<ProfileResult> runnable(None param) {
        return repository.getUserInfo()
                .startWithItem(ProfileResult.Loading.LOADING)
                .onErrorReturn(ProfileResult.Error::new)
                .subscribeOn(Schedulers.io());
    }
}
