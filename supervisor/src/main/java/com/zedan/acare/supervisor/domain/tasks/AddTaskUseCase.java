package com.zedan.acare.supervisor.domain.tasks;

import com.zedan.acare.supervisor.domain.UseCase;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/zedan/acare/supervisor/domain/tasks/AddTaskUseCase;", "Lcom/zedan/acare/supervisor/domain/UseCase;", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskParam;", "Lcom/zedan/acare/supervisor/domain/tasks/AddTaskResult;", "taskRepository", "Lcom/zedan/acare/supervisor/domain/tasks/TaskRepository;", "(Lcom/zedan/acare/supervisor/domain/tasks/TaskRepository;)V", "runnable", "Lkotlinx/coroutines/flow/Flow;", "param", "(Lcom/zedan/acare/supervisor/domain/tasks/AddTaskParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddTaskUseCase.kt */
public final class AddTaskUseCase extends UseCase<AddTaskParam, AddTaskResult> {
    private final TaskRepository taskRepository;

    @Inject
    public AddTaskUseCase(TaskRepository taskRepository2) {
        Intrinsics.checkNotNullParameter(taskRepository2, "taskRepository");
        this.taskRepository = taskRepository2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object runnable(com.zedan.acare.supervisor.domain.tasks.AddTaskParam r6, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.zedan.acare.supervisor.domain.tasks.AddTaskResult>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$1 r0 = (com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$1 r0 = new com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$1
            r0.<init>(r5, r7)
        L_0x0019:
            r7 = r0
            java.lang.Object r0 = r7.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r7.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r0)
            r6 = r0
            goto L_0x0049
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r5
            com.zedan.acare.supervisor.domain.tasks.TaskRepository r4 = r2.taskRepository
            r7.label = r3
            java.lang.Object r6 = r4.addTask(r6, r7)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$2 r1 = new com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$2
            r2 = 0
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.onStart(r6, r1)
            com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$3 r1 = new com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase$runnable$3
            r1.<init>(r2)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.m1356catch(r6, r1)
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.flowOn(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase.runnable(com.zedan.acare.supervisor.domain.tasks.AddTaskParam, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
