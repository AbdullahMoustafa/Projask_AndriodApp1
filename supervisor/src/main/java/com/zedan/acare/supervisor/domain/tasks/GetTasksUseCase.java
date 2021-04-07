package com.zedan.acare.supervisor.domain.tasks;

import com.zedan.acare.supervisor.domain.None;
import com.zedan.acare.supervisor.domain.UseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Singleton
public final class GetTasksUseCase extends UseCase<None, GetTasksResult> {

    private final TaskRepository repository;

    @Inject
    public GetTasksUseCase(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    protected Observable<GetTasksResult> runnable(None param) {
        return repository
                .getTasks()
                .startWithItem(GetTasksResult.Loading.LOADING)
                .onErrorReturn(GetTasksResult.Error::new)
                .subscribeOn(Schedulers.io());
    }
}
