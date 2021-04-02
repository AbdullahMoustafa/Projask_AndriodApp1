package com.zedan.acare.supervisor.ui.register;

import com.google.firebase.database.core.ValidationPath;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
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
@DebugMetadata(c = "com.zedan.acare.supervisor.ui.register.RegisterViewModel$register$1", f = "RegisterViewModel.kt", i = {}, l = {57, 83}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RegisterViewModel.kt */
final class RegisterViewModel$register$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $address;
    final /* synthetic */ String $country;
    final /* synthetic */ String $email;
    final /* synthetic */ String $fullName;
    final /* synthetic */ String $kinship;
    final /* synthetic */ String $password;
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ RegisterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterViewModel$register$1(RegisterViewModel registerViewModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, Continuation continuation) {
        super(2, continuation);
        this.this$0 = registerViewModel;
        this.$fullName = str;
        this.$phone = str2;
        this.$email = str3;
        this.$password = str4;
        this.$kinship = str5;
        this.$address = str6;
        this.$country = str7;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new RegisterViewModel$register$1(this.this$0, this.$fullName, this.$phone, this.$email, this.$password, this.$kinship, this.$address, this.$country, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RegisterViewModel$register$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        RegisterViewModel$register$1 registerViewModel$register$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure($result);
            registerViewModel$register$1 = this;
            Object $result4 = $result;
            registerViewModel$register$1.label = 1;
            Object execute = registerViewModel$register$1.this$0.registerUseCase.execute(new RegisterParam(registerViewModel$register$1.$fullName, registerViewModel$register$1.$phone, registerViewModel$register$1.$email, registerViewModel$register$1.$password, registerViewModel$register$1.$kinship, registerViewModel$register$1.$address, registerViewModel$register$1.$country, registerViewModel$register$1.this$0.getImagePath(), false, (String) null, ValidationPath.MAX_PATH_LENGTH_BYTES, (DefaultConstructorMarker) null), registerViewModel$register$1);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj = execute;
            $result2 = $result4;
            $result3 = obj;
        } else if (i == 1) {
            registerViewModel$register$1 = this;
            $result3 = $result;
            ResultKt.throwOnFailure($result3);
            $result2 = $result3;
        } else if (i == 2) {
            ResultKt.throwOnFailure($result);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        registerViewModel$register$1.label = 2;
        if (((Flow) $result3).collect(new RegisterViewModel$register$1$invokeSuspend$$inlined$collect$1(registerViewModel$register$1), registerViewModel$register$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        RegisterViewModel$register$1 registerViewModel$register$12 = registerViewModel$register$1;
        Object obj2 = $result2;
        return Unit.INSTANCE;
    }
}
