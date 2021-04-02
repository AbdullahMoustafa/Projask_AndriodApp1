package com.zedan.acare.supervisor.ui.forget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import com.zedan.acare.supervisor.R;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/zedan/acare/supervisor/ui/forget/ForgetPasswordFragment;", "Landroidx/fragment/app/Fragment;", "()V", "viewModel", "Lcom/zedan/acare/supervisor/ui/forget/ForgetPasswordViewModel;", "getViewModel", "()Lcom/zedan/acare/supervisor/ui/forget/ForgetPasswordViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: ForgetPasswordFragment.kt */
public final class ForgetPasswordFragment extends Hilt_ForgetPasswordFragment {
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ForgetPasswordViewModel.class), new ForgetPasswordFragment$$special$$inlined$viewModels$2(new ForgetPasswordFragment$$special$$inlined$viewModels$1(this)), (Function0<? extends ViewModelProvider.Factory>) null);

    private final ForgetPasswordViewModel getViewModel() {
        return (ForgetPasswordViewModel) this.viewModel$delegate.getValue();
    }

    public ForgetPasswordFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.forget_password_fragment, container, false);
    }
}
