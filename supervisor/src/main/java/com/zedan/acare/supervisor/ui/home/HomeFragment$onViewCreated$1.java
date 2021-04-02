package com.zedan.acare.supervisor.ui.home;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.zedan.acare.supervisor.ui.home.HomeFragment$onViewCreated$1", f = "HomeFragment.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeFragment.kt */
final class HomeFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$onViewCreated$1(HomeFragment homeFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new HomeFragment$onViewCreated$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((HomeFragment$onViewCreated$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure($result);
            this.label = 1;
            if (this.this$0.getViewModel().getStatusFill().collect(new HomeFragment$onViewCreated$1$invokeSuspend$$inlined$collect$1(this), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure($result);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
