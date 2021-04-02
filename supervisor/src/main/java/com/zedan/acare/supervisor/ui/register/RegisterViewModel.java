package com.zedan.acare.supervisor.ui.register;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.zedan.acare.supervisor.domain.auth.RegisterResult;
import com.zedan.acare.supervisor.domain.auth.RegisterUseCase;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0007J\b\u0010\u001e\u001a\u00020\u001cH\u0014J>\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/zedan/acare/supervisor/ui/register/RegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "registerUseCase", "Lcom/zedan/acare/supervisor/domain/auth/RegisterUseCase;", "(Lcom/zedan/acare/supervisor/domain/auth/RegisterUseCase;)V", "_navigation", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lcom/zedan/acare/supervisor/ui/register/RegisterNavigation;", "_registerResult", "Lcom/zedan/acare/supervisor/utils/SingleLiveEvent;", "Lcom/zedan/acare/supervisor/domain/auth/RegisterResult;", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "jobRegister", "Lkotlinx/coroutines/Job;", "navigation", "Lkotlinx/coroutines/flow/Flow;", "getNavigation", "()Lkotlinx/coroutines/flow/Flow;", "registerResult", "Landroidx/lifecycle/LiveData;", "getRegisterResult", "()Landroidx/lifecycle/LiveData;", "cancelRegister", "", "navigationHandler", "onCleared", "register", "fullName", "phone", "email", "password", "kinship", "address", "country", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: RegisterViewModel.kt */
public final class RegisterViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final BroadcastChannel<RegisterNavigation> _navigation;
    /* access modifiers changed from: private */
    public final SingleLiveEvent<RegisterResult> _registerResult;
    private String imagePath;
    private Job jobRegister;
    private final Flow<RegisterNavigation> navigation;
    private final LiveData<RegisterResult> registerResult;
    /* access modifiers changed from: private */
    public final RegisterUseCase registerUseCase;

    @Inject
    public RegisterViewModel(RegisterUseCase registerUseCase2) {
        Intrinsics.checkNotNullParameter(registerUseCase2, "registerUseCase");
        this.registerUseCase = registerUseCase2;
        BroadcastChannel<RegisterNavigation> BroadcastChannel = BroadcastChannelKt.BroadcastChannel(-2);
        this._navigation = BroadcastChannel;
        this.navigation = FlowKt.asFlow(BroadcastChannel);
        SingleLiveEvent<RegisterResult> singleLiveEvent = new SingleLiveEvent<>();
        this._registerResult = singleLiveEvent;
        this.registerResult = singleLiveEvent;
    }

    public final Flow<RegisterNavigation> getNavigation() {
        return this.navigation;
    }

    public final LiveData<RegisterResult> getRegisterResult() {
        return this.registerResult;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final void setImagePath(String str) {
        this.imagePath = str;
    }

    public final void navigationHandler(RegisterNavigation navigation2) {
        Intrinsics.checkNotNullParameter(navigation2, NotificationCompat.CATEGORY_NAVIGATION);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new RegisterViewModel$navigationHandler$1(this, navigation2, (Continuation) null), 3, (Object) null);
    }

    public final void register(String fullName, String phone, String email, String password, String kinship, String address, String country) {
        Intrinsics.checkNotNullParameter(fullName, "fullName");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(kinship, "kinship");
        Intrinsics.checkNotNullParameter(address, "address");
        String str = country;
        Intrinsics.checkNotNullParameter(str, "country");
        this.jobRegister = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new RegisterViewModel$register$1(this, fullName, phone, email, password, kinship, address, str, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void cancelRegister() {
        Job job = this.jobRegister;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        cancelRegister();
    }
}
