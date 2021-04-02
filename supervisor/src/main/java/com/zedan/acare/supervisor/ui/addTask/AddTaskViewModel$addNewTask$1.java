package com.zedan.acare.supervisor.ui.addTask;

import com.zedan.acare.supervisor.domain.tasks.AddTaskParam;
import com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.zedan.acare.supervisor.ui.addTask.AddTaskViewModel$addNewTask$1", f = "AddTaskViewModel.kt", i = {}, l = {35, 52}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddTaskViewModel.kt */
final class AddTaskViewModel$addNewTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $desc;
    final /* synthetic */ String $endDate;
    final /* synthetic */ String $endHour;
    final /* synthetic */ String $startDate;
    final /* synthetic */ String $startHour;
    final /* synthetic */ String $title;
    int label;
    final /* synthetic */ AddTaskViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddTaskViewModel$addNewTask$1(AddTaskViewModel addTaskViewModel, String str, String str2, String str3, String str4, String str5, String str6, Continuation continuation) {
        super(2, continuation);
        this.this$0 = addTaskViewModel;
        this.$title = str;
        this.$desc = str2;
        this.$startDate = str3;
        this.$startHour = str4;
        this.$endDate = str5;
        this.$endHour = str6;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new AddTaskViewModel$addNewTask$1(this.this$0, this.$title, this.$desc, this.$startDate, this.$startHour, this.$endDate, this.$endHour, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AddTaskViewModel$addNewTask$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        AddTaskViewModel$addNewTask$1 addTaskViewModel$addNewTask$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure($result);
            addTaskViewModel$addNewTask$1 = this;
            Object $result4 = $result;
            AddTaskUseCase access$getAddTaskUseCase$p = addTaskViewModel$addNewTask$1.this$0.addTaskUseCase;
            String str = addTaskViewModel$addNewTask$1.$title;
            String str2 = addTaskViewModel$addNewTask$1.$desc;
            String str3 = addTaskViewModel$addNewTask$1.$startDate;
            String str4 = addTaskViewModel$addNewTask$1.$startHour;
            String str5 = addTaskViewModel$addNewTask$1.$endDate;
            String str6 = addTaskViewModel$addNewTask$1.$endHour;
            addTaskViewModel$addNewTask$1.label = 1;
            Object execute = access$getAddTaskUseCase$p.execute(new AddTaskParam(str, str2, addTaskViewModel$addNewTask$1.$startDate + '-' + addTaskViewModel$addNewTask$1.$startHour, addTaskViewModel$addNewTask$1.$endDate + '-' + addTaskViewModel$addNewTask$1.$endHour, str3, str4, str5, str6, Boxing.boxInt(addTaskViewModel$addNewTask$1.this$0.getSelectedColor())), addTaskViewModel$addNewTask$1);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj = execute;
            $result2 = $result4;
            $result3 = obj;
        } else if (i == 1) {
            addTaskViewModel$addNewTask$1 = this;
            $result3 = $result;
            ResultKt.throwOnFailure($result3);
            $result2 = $result3;
        } else if (i == 2) {
            ResultKt.throwOnFailure($result);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        addTaskViewModel$addNewTask$1.label = 2;
        if (((Flow) $result3).collect(new AddTaskViewModel$addNewTask$1$invokeSuspend$$inlined$collect$1(addTaskViewModel$addNewTask$1), addTaskViewModel$addNewTask$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        AddTaskViewModel$addNewTask$1 addTaskViewModel$addNewTask$12 = addTaskViewModel$addNewTask$1;
        Object obj2 = $result2;
        return Unit.INSTANCE;
    }
}
