package com.zedan.acare.supervisor.ui.login;

import com.zedan.acare.supervisor.domain.auth.LoginParam;
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
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.zedan.acare.supervisor.ui.login.LoginViewModel$login$1", f = "LoginViewModel.kt", i = {}, l = {57, 73}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LoginViewModel.kt */
final class LoginViewModel$login$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $email;
    final /* synthetic */ String $password;
    int label;
    final /* synthetic */ LoginViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginViewModel$login$1(LoginViewModel loginViewModel, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = loginViewModel;
        this.$email = str;
        this.$password = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new LoginViewModel$login$1(this.this$0, this.$email, this.$password, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LoginViewModel$login$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        LoginViewModel$login$1 loginViewModel$login$1;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure($result);
            this.label = 1;
            Object execute = this.this$0.useCase.execute(new LoginParam(this.$email, this.$password), this);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result2 = $result;
            $result = execute;
            loginViewModel$login$1 = this;
        } else if (i == 1) {
            ResultKt.throwOnFailure($result);
            loginViewModel$login$1 = this;
            $result2 = $result;
        } else if (i == 2) {
            ResultKt.throwOnFailure($result);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        loginViewModel$login$1.label = 2;
        if (((Flow) $result).collect(new LoginViewModel$login$1$invokeSuspend$$inlined$collect$1(loginViewModel$login$1), loginViewModel$login$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Object obj = $result2;
        LoginViewModel$login$1 loginViewModel$login$12 = loginViewModel$login$1;
        return Unit.INSTANCE;
    }
}
