package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.None;
import com.zedan.acare.supervisor.domain.UseCase;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Singleton
public final class UserInfoBasicUseCase extends UseCase<None, UserDataBasic> {
    private final ProfileRepository repository;

    @Inject
    public UserInfoBasicUseCase(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Observable<UserDataBasic> runnable(None param) {
        return repository.getBasicUserInfo();
    }
}
