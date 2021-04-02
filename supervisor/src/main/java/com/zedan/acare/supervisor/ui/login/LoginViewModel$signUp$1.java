package com.zedan.acare.supervisor.ui.login;

import androidx.navigation.NavDirections;
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
@DebugMetadata(c = "com.zedan.acare.supervisor.ui.login.LoginViewModel$signUp$1", f = "LoginViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LoginViewModel.kt */
final class LoginViewModel$signUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LoginViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginViewModel$signUp$1(LoginViewModel loginViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = loginViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new LoginViewModel$signUp$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LoginViewModel$signUp$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        LoginViewModel$signUp$1 loginViewModel$signUp$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure($result);
            BroadcastChannel access$get_navigation$p = this.this$0._navigation;
            NavDirections actionLoginFragmentToRegisterFragment = LoginFragmentDirections.Companion.actionLoginFragmentToRegisterFragment();
            this.label = 1;
            if (access$get_navigation$p.send(actionLoginFragmentToRegisterFragment, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            loginViewModel$signUp$1 = this;
        } else if (i == 1) {
            loginViewModel$signUp$1 = this;
            ResultKt.throwOnFailure($result);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        loginViewModel$signUp$1.this$0.loginCancel();
        return Unit.INSTANCE;
    }
}
