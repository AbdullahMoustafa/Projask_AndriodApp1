package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.UseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Singleton
public final class EditInputUseCase extends UseCase<EditInputParam, EditInputResult> {

    private final ProfileRepository repository;

    @Inject
    public EditInputUseCase(ProfileRepository repository){
        this.repository = repository;
    }

    @Override
    protected Observable<EditInputResult> runnable(EditInputParam param) {
        return repository.updateInput(param)
                .startWithItem(EditInputResult.Loading.LOADING)
                .onErrorReturn(EditInputResult.Error.Exception::new)
                .subscribeOn(Schedulers.io());
    }
}
