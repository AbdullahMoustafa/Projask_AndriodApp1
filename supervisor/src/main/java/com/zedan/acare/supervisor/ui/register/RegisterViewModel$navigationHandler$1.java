package com.zedan.acare.supervisor.ui.register;

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
import kotlinx.coroutines.channels.BroadcastChannel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.zedan.acare.supervisor.ui.register.RegisterViewModel$navigationHandler$1", f = "RegisterViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RegisterViewModel.kt */
final class RegisterViewModel$navigationHandler$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RegisterNavigation $navigation;
    int label;
    final /* synthetic */ RegisterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterViewModel$navigationHandler$1(RegisterViewModel registerViewModel, RegisterNavigation registerNavigation, Continuation continuation) {
        super(2, continuation);
        this.this$0 = registerViewModel;
        this.$navigation = registerNavigation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new RegisterViewModel$navigationHandler$1(this.this$0, this.$navigation, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RegisterViewModel$navigationHandler$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        RegisterViewModel$navigationHandler$1 registerViewModel$navigationHandler$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure($result);
            BroadcastChannel access$get_navigation$p = this.this$0._navigation;
            RegisterNavigation registerNavigation = this.$navigation;
            this.label = 1;
            if (access$get_navigation$p.send(registerNavigation, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            registerViewModel$navigationHandler$1 = this;
        } else if (i == 1) {
            registerViewModel$navigationHandler$1 = this;
            ResultKt.throwOnFailure($result);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        registerViewModel$navigationHandler$1.this$0.cancelRegister();
        return Unit.INSTANCE;
    }
}
