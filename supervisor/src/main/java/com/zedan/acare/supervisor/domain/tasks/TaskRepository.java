package com.zedan.acare.supervisor.domain.tasks;

import io.reactivex.rxjava3.core.Flowable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;


public abstract class TaskRepository {

    abstract Flowable<AddTaskResult> addTask(
            AddTaskParam param
    );

}
