package com.zedan.acare.supervisor.data.tasks;

import com.zedan.acare.supervisor.domain.tasks.AddTaskParam;
import com.zedan.acare.supervisor.domain.tasks.AddTaskResult;
import com.zedan.acare.supervisor.domain.tasks.TaskRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/zedan/acare/supervisor/data/tasks/TasksRepositoryImpl;", "Lcom/zedan/acare/supervisor/domain/tasks/TaskRepository;", "addTaskValidationMapper", "Lcom/zedan/acare/supervisor/data/tasks/AddTaskValidationMapper;", "addTaskErrorValidation", "Lcom/zedan/acare/supervisor/data/tasks/AddTaskErrorValidationMapper;", "(Lcom/zedan/acare/supervisor/data/tasks/AddTaskValidationMapper;Lcom/zedan/acare/supervisor/data/tasks/AddTaskErrorValidationMapper;)V", "addTask", "Lkotlinx/coroutines/flow/Flow;", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskResult;", "param", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskParam;", "(Lcom/zedan/acare/supervisor/domain/tasks/AddTaskParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: TasksRepositoryImpl.kt */
public final class TasksRepositoryImpl extends TaskRepository {
    /* access modifiers changed from: private */
    public final AddTaskErrorValidationMapper addTaskErrorValidation;
    /* access modifiers changed from: private */
    public final AddTaskValidationMapper addTaskValidationMapper;

    @Inject
    public TasksRepositoryImpl(AddTaskValidationMapper addTaskValidationMapper2, AddTaskErrorValidationMapper addTaskErrorValidation2) {
        Intrinsics.checkNotNullParameter(addTaskValidationMapper2, "addTaskValidationMapper");
        Intrinsics.checkNotNullParameter(addTaskErrorValidation2, "addTaskErrorValidation");
        this.addTaskValidationMapper = addTaskValidationMapper2;
        this.addTaskErrorValidation = addTaskErrorValidation2;
    }

    public Object addTask(AddTaskParam param, Continuation<? super Flow<? extends AddTaskResult>> $completion) {
        return FlowKt.flow(new TasksRepositoryImpl$addTask$2(this, param, (Continuation) null));
    }
}
