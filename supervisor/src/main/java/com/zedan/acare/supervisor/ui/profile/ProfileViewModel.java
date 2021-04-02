package com.zedan.acare.supervisor.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.database.ValueEventListener;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import com.zedan.acare.supervisor.domain.profile.ProfileResult;
import com.zedan.acare.supervisor.domain.profile.ProfileUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/zedan/acare/supervisor/ui/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "profileUseCase", "Lcom/zedan/acare/supervisor/domain/profile/ProfileUseCase;", "(Lcom/zedan/acare/supervisor/domain/profile/ProfileUseCase;)V", "data", "Landroidx/lifecycle/LiveData;", "Lcom/zedan/acare/supervisor/domain/profile/ProfileResult$Success;", "getData", "()Landroidx/lifecycle/LiveData;", "error", "Lcom/zedan/acare/supervisor/domain/profile/ProfileResult$Error;", "getError", "isLoading", "", "patient", "Lcom/zedan/acare/supervisor/domain/auth/RegisterPatientParam;", "getPatient", "statusProfile", "Landroidx/lifecycle/MutableLiveData;", "Lcom/zedan/acare/supervisor/domain/profile/ProfileResult;", "supervisor", "Lcom/zedan/acare/supervisor/domain/auth/RegisterParam;", "getSupervisor", "getUserInfo", "", "patientListener", "Lcom/google/firebase/database/ValueEventListener;", "supervisorListener", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProfileViewModel.kt */
public final class ProfileViewModel extends ViewModel {
    private final LiveData<ProfileResult.Success> data;
    private final LiveData<ProfileResult.Error> error;
    private final LiveData<Boolean> isLoading;
    private final LiveData<RegisterPatientParam> patient;
    /* access modifiers changed from: private */
    public final ProfileUseCase profileUseCase;
    /* access modifiers changed from: private */
    public final MutableLiveData<ProfileResult> statusProfile;
    private final LiveData<RegisterParam> supervisor;

    @Inject
    public ProfileViewModel(ProfileUseCase profileUseCase2) {
        Intrinsics.checkNotNullParameter(profileUseCase2, "profileUseCase");
        this.profileUseCase = profileUseCase2;
        MutableLiveData<ProfileResult> $this$map$iv = new MutableLiveData<>(ProfileResult.None.INSTANCE);
        this.statusProfile = $this$map$iv;
        LiveData<Boolean> map = Transformations.map($this$map$iv, new ProfileViewModel$$special$$inlined$map$1());
        Intrinsics.checkNotNullExpressionValue(map, "Transformations.map(this) { transform(it) }");
        this.isLoading = map;
        LiveData<ProfileResult.Success> map2 = Transformations.map($this$map$iv, new ProfileViewModel$$special$$inlined$map$2());
        Intrinsics.checkNotNullExpressionValue(map2, "Transformations.map(this) { transform(it) }");
        this.data = map2;
        LiveData<RegisterParam> map3 = Transformations.map(this.data, new ProfileViewModel$$special$$inlined$map$3());
        Intrinsics.checkNotNullExpressionValue(map3, "Transformations.map(this) { transform(it) }");
        this.supervisor = map3;
        LiveData<RegisterPatientParam> map4 = Transformations.map(this.data, new ProfileViewModel$$special$$inlined$map$4());
        Intrinsics.checkNotNullExpressionValue(map4, "Transformations.map(this) { transform(it) }");
        this.patient = map4;
        LiveData<ProfileResult.Error> map5 = Transformations.map($this$map$iv, new ProfileViewModel$$special$$inlined$map$5());
        Intrinsics.checkNotNullExpressionValue(map5, "Transformations.map(this) { transform(it) }");
        this.error = map5;
        getUserInfo();
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final LiveData<ProfileResult.Success> getData() {
        return this.data;
    }

    public final LiveData<RegisterParam> getSupervisor() {
        return this.supervisor;
    }

    public final LiveData<RegisterPatientParam> getPatient() {
        return this.patient;
    }

    public final LiveData<ProfileResult.Error> getError() {
        return this.error;
    }

    public final void getUserInfo() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ProfileViewModel$getUserInfo$1(this, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final ValueEventListener supervisorListener() {
        return new ProfileViewModel$supervisorListener$1();
    }

    /* access modifiers changed from: private */
    public final ValueEventListener patientListener() {
        return new ProfileViewModel$patientListener$1();
    }
}
