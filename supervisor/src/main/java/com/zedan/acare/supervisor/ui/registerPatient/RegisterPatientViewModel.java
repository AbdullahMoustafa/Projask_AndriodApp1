package com.zedan.acare.supervisor.ui.registerPatient;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientResult;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JF\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/zedan/acare/supervisor/ui/registerPatient/RegisterPatientViewModel;", "Landroidx/lifecycle/ViewModel;", "registerPatientUseCase", "Lcom/zedan/acare/supervisor/domain/auth/RegisterPatientUseCase;", "(Lcom/zedan/acare/supervisor/domain/auth/RegisterPatientUseCase;)V", "_statusRegister", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/zedan/acare/supervisor/domain/auth/RegisterPatientResult;", "statusRegister", "Lkotlinx/coroutines/flow/StateFlow;", "getStatusRegister", "()Lkotlinx/coroutines/flow/StateFlow;", "registerPatient", "", "name", "", "mobile", "password", "age", "homeLocation", "status", "statusType", "country", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: RegisterPatientViewModel.kt */
public final class RegisterPatientViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final MutableStateFlow<RegisterPatientResult> _statusRegister = StateFlowKt.MutableStateFlow(RegisterPatientResult.None.INSTANCE);
    /* access modifiers changed from: private */
    public final RegisterPatientUseCase registerPatientUseCase;

    @Inject
    public RegisterPatientViewModel(RegisterPatientUseCase registerPatientUseCase2) {
        Intrinsics.checkNotNullParameter(registerPatientUseCase2, "registerPatientUseCase");
        this.registerPatientUseCase = registerPatientUseCase2;
    }

    public final StateFlow<RegisterPatientResult> getStatusRegister() {
        return this._statusRegister;
    }

    public final void registerPatient(String name, String mobile, String password, String age, String homeLocation, String status, String statusType, String country) {
        Intrinsics.checkNotNullParameter(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Intrinsics.checkNotNullParameter(mobile, "mobile");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(age, "age");
        Intrinsics.checkNotNullParameter(homeLocation, "homeLocation");
        Intrinsics.checkNotNullParameter(status, NotificationCompat.CATEGORY_STATUS);
        String str = statusType;
        Intrinsics.checkNotNullParameter(str, "statusType");
        Intrinsics.checkNotNullParameter(country, "country");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new RegisterPatientViewModel$registerPatient$1(this, name, mobile, password, age, homeLocation, status, str, country, (Continuation) null), 3, (Object) null);
    }
}
