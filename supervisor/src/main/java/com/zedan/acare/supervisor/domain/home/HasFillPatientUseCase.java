package com.zedan.acare.supervisor.domain.home;

import com.zedan.acare.supervisor.domain.None;
import com.zedan.acare.supervisor.domain.UseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Singleton
public class HasFillPatientUseCase extends UseCase<None, FillPatientResult> {
    private final HomeRepository repository;

    @Inject
    public HasFillPatientUseCase(HomeRepository repository2) {
        this.repository = repository2;
    }

    @Override
    protected Flowable<FillPatientResult> runnable(None param) {
        return repository.hasFillPatient()
                .startWithItem(FillPatientResult.Loading.LOADING)
                .onErrorReturn(FillPatientResult.Error::new)
                .subscribeOn(Schedulers.io());
    }
}
