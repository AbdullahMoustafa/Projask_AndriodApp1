package com.zedan.acare.supervisor.domain.tasks;

import com.zedan.acare.supervisor.domain.UseCase;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Singleton
public final class AddTaskUseCase extends UseCase<AddTaskParam, AddTaskResult> {
    private final TaskRepository taskRepository;

    @Inject
    public AddTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    protected Observable<AddTaskResult> runnable(AddTaskParam param) {
        return taskRepository.addTask(param)
                .startWithItem(AddTaskResult.Loading.LOADING)
                .onErrorReturn(AddTaskResult.Error.Exception::new)
                .subscribeOn(Schedulers.io());
    }
}
