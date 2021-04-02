package com.zedan.acare.supervisor.domain.profile;

import io.reactivex.rxjava3.core.Flowable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;


public abstract class ProfileRepository {

    abstract Flowable<UserDataBasic> getBasicUserInfo();

    abstract Flowable<ProfileResult> getUserInfo(ProfileParam param);

}
