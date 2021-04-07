package com.zedan.acare.supervisor.domain.tasks;

import io.reactivex.rxjava3.core.Observable;


public abstract class TaskRepository {

    public abstract Observable<AddTaskResult> addTask(
            AddTaskParam param
    );

    public abstract Observable<GetTasksResult> getTasks();

}
