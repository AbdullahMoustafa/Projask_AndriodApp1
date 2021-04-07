package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.UseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Singleton
public class UploadImageUseCase extends UseCase<UploadImageParam, UploadImageStatus> {

    private final ProfileRepository repository;

    @Inject
    public UploadImageUseCase(ProfileRepository repository){
        this.repository = repository;
    }

    @Override
    protected Observable<UploadImageStatus> runnable(UploadImageParam param) {
        return repository
                .updateImage(param)
                .startWithItem(UploadImageStatus.Loading.LOADING)
                .onErrorReturn(UploadImageStatus.Error::new)
                .subscribeOn(Schedulers.io());
    }
}
