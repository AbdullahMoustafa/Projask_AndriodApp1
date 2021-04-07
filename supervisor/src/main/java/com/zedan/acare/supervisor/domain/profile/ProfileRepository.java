package com.zedan.acare.supervisor.domain.profile;

import io.reactivex.rxjava3.core.Observable;


public abstract class ProfileRepository {

    public abstract Observable<UserDataBasic> getBasicUserInfo();

    public abstract Observable<ProfileResult> getUserInfo();

    public abstract Observable<EditInputResult> updateInput(EditInputParam param);

    public abstract Observable<UploadImageStatus> updateImage(UploadImageParam param);

}
