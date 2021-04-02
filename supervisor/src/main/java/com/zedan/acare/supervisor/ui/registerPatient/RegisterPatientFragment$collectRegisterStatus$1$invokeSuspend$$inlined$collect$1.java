package com.zedan.acare.supervisor.ui.registerPatient;

import com.zedan.acare.supervisor.domain.auth.RegisterPatientResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 2})
/* compiled from: Collect.kt */
public final class RegisterPatientFragment$collectRegisterStatus$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<RegisterPatientResult> {
    final /* synthetic */ RegisterPatientFragment$collectRegisterStatus$1 this$0;

    public RegisterPatientFragment$collectRegisterStatus$1$invokeSuspend$$inlined$collect$1(RegisterPatientFragment$collectRegisterStatus$1 registerPatientFragment$collectRegisterStatus$1) {
        this.this$0 = registerPatientFragment$collectRegisterStatus$1;
    }

    public Object emit(Object value, Continuation $completion) {
        RegisterPatientResult it = (RegisterPatientResult) value;
        Continuation continuation = $completion;
        if (it instanceof RegisterPatientResult.Loading) {
            this.this$0.this$0.onLoading();
        } else if (it instanceof RegisterPatientResult.Success) {
            this.this$0.this$0.onSuccess();
        } else if (it instanceof RegisterPatientResult.Error) {
            this.this$0.this$0.onError((RegisterPatientResult.Error) it);
        } else {
            boolean z = it instanceof RegisterPatientResult.None;
        }
        return Unit.INSTANCE;
    }
}
