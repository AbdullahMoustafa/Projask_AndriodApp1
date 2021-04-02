package com.zedan.acare.supervisor.ui.home;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.zedan.acare.supervisor.domain.home.FillPatientResult;
import com.zedan.acare.supervisor.domain.home.HasFillPatientUseCase;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/zedan/acare/supervisor/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lcom/zedan/acare/supervisor/domain/home/HasFillPatientUseCase;", "(Lcom/zedan/acare/supervisor/domain/home/HasFillPatientUseCase;)V", "_statusFill", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/zedan/acare/supervisor/domain/home/FillPatientResult;", "statusFill", "Lkotlinx/coroutines/flow/StateFlow;", "getStatusFill", "()Lkotlinx/coroutines/flow/StateFlow;", "checkFillPatient", "", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: HomeViewModel.kt */
public final class HomeViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final MutableStateFlow<FillPatientResult> _statusFill = StateFlowKt.MutableStateFlow(FillPatientResult.Loading.INSTANCE);
    /* access modifiers changed from: private */
    public final HasFillPatientUseCase useCase;

    @Inject
    public HomeViewModel(HasFillPatientUseCase useCase2) {
        Intrinsics.checkNotNullParameter(useCase2, "useCase");
        this.useCase = useCase2;
        checkFillPatient();
    }

    public final StateFlow<FillPatientResult> getStatusFill() {
        return this._statusFill;
    }

    public final void checkFillPatient() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new HomeViewModel$checkFillPatient$1(this, (Continuation) null), 3, (Object) null);
    }
}
