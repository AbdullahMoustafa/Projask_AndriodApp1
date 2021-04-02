package com.zedan.acare.supervisor.ui.registerPatient;

import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
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
@DebugMetadata(c = "com.zedan.acare.supervisor.ui.registerPatient.RegisterPatientViewModel$registerPatient$1", f = "RegisterPatientViewModel.kt", i = {}, l = {37, 54}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RegisterPatientViewModel.kt */
final class RegisterPatientViewModel$registerPatient$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $age;
    final /* synthetic */ String $country;
    final /* synthetic */ String $homeLocation;
    final /* synthetic */ String $mobile;
    final /* synthetic */ String $name;
    final /* synthetic */ String $password;
    final /* synthetic */ String $status;
    final /* synthetic */ String $statusType;
    int label;
    final /* synthetic */ RegisterPatientViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RegisterPatientViewModel$registerPatient$1(RegisterPatientViewModel registerPatientViewModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Continuation continuation) {
        super(2, continuation);
        this.this$0 = registerPatientViewModel;
        this.$name = str;
        this.$mobile = str2;
        this.$password = str3;
        this.$age = str4;
        this.$homeLocation = str5;
        this.$status = str6;
        this.$statusType = str7;
        this.$country = str8;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new RegisterPatientViewModel$registerPatient$1(this.this$0, this.$name, this.$mobile, this.$password, this.$age, this.$homeLocation, this.$status, this.$statusType, this.$country, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RegisterPatientViewModel$registerPatient$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        RegisterPatientViewModel$registerPatient$1 registerPatientViewModel$registerPatient$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure($result);
            registerPatientViewModel$registerPatient$1 = this;
            Object $result4 = $result;
            registerPatientViewModel$registerPatient$1.label = 1;
            Object execute = registerPatientViewModel$registerPatient$1.this$0.registerPatientUseCase.execute(new RegisterPatientParam(registerPatientViewModel$registerPatient$1.$name, registerPatientViewModel$registerPatient$1.$mobile, registerPatientViewModel$registerPatient$1.$password, registerPatientViewModel$registerPatient$1.$age, registerPatientViewModel$registerPatient$1.$homeLocation, registerPatientViewModel$registerPatient$1.$status, registerPatientViewModel$registerPatient$1.$statusType, registerPatientViewModel$registerPatient$1.$country, (String) null, 256, (DefaultConstructorMarker) null), registerPatientViewModel$registerPatient$1);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj = execute;
            $result2 = $result4;
            $result3 = obj;
        } else if (i == 1) {
            registerPatientViewModel$registerPatient$1 = this;
            $result3 = $result;
            ResultKt.throwOnFailure($result3);
            $result2 = $result3;
        } else if (i == 2) {
            ResultKt.throwOnFailure($result);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        registerPatientViewModel$registerPatient$1.label = 2;
        if (((Flow) $result3).collect(new RegisterPatientViewModel$registerPatient$1$invokeSuspend$$inlined$collect$1(registerPatientViewModel$registerPatient$1), registerPatientViewModel$registerPatient$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        RegisterPatientViewModel$registerPatient$1 registerPatientViewModel$registerPatient$12 = registerPatientViewModel$registerPatient$1;
        Object obj2 = $result2;
        return Unit.INSTANCE;
    }
}
