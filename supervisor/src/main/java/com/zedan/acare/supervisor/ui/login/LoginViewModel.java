package com.zedan.acare.supervisor.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.NavDirections;
import com.zedan.acare.supervisor.domain.auth.LoginStatus;
import com.zedan.acare.supervisor.domain.auth.LoginUseCase;
import com.zedan.acare.supervisor.utils.SingleLiveEvent;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0014J\u0006\u0010\u001d\u001a\u00020\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/zedan/acare/supervisor/ui/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lcom/zedan/acare/supervisor/domain/auth/LoginUseCase;", "(Lcom/zedan/acare/supervisor/domain/auth/LoginUseCase;)V", "_navigation", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Landroidx/navigation/NavDirections;", "_statusLogin", "Lcom/zedan/acare/supervisor/utils/SingleLiveEvent;", "Lcom/zedan/acare/supervisor/domain/auth/LoginStatus;", "loginJob", "Lkotlinx/coroutines/Job;", "navigation", "Lkotlinx/coroutines/flow/Flow;", "getNavigation", "()Lkotlinx/coroutines/flow/Flow;", "statusLogin", "Landroidx/lifecycle/LiveData;", "getStatusLogin", "()Landroidx/lifecycle/LiveData;", "forgetPassword", "", "login", "email", "", "password", "loginCancel", "onCleared", "signUp", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoginViewModel.kt */
public final class LoginViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final BroadcastChannel<NavDirections> _navigation;
    /* access modifiers changed from: private */
    public final SingleLiveEvent<LoginStatus> _statusLogin;
    private Job loginJob;
    private final Flow<NavDirections> navigation;
    private final LiveData<LoginStatus> statusLogin;
    /* access modifiers changed from: private */
    public final LoginUseCase useCase;

    @Inject
    public LoginViewModel(LoginUseCase useCase2) {
        Intrinsics.checkNotNullParameter(useCase2, "useCase");
        this.useCase = useCase2;
        BroadcastChannel<NavDirections> BroadcastChannel = BroadcastChannelKt.BroadcastChannel(-2);
        this._navigation = BroadcastChannel;
        this.navigation = FlowKt.asFlow(BroadcastChannel);
        SingleLiveEvent<LoginStatus> singleLiveEvent = new SingleLiveEvent<>();
        this._statusLogin = singleLiveEvent;
        this.statusLogin = singleLiveEvent;
    }

    public final Flow<NavDirections> getNavigation() {
        return this.navigation;
    }

    public final LiveData<LoginStatus> getStatusLogin() {
        return this.statusLogin;
    }

    public final void forgetPassword() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoginViewModel$forgetPassword$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void signUp() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoginViewModel$signUp$1(this, (Continuation) null), 3, (Object) null);
    }

    public final void login(String email, String password) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        this.loginJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoginViewModel$login$1(this, email, password, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        loginCancel();
    }

    /* access modifiers changed from: private */
    public final void loginCancel() {
        Job job = this.loginJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
