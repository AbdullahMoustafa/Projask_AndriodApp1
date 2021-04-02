package com.zedan.acare.supervisor.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.HomeFragmentBinding;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.domain.home.FillPatientResult;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006!"}, d2 = {"Lcom/zedan/acare/supervisor/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/zedan/acare/supervisor/databinding/HomeFragmentBinding;", "binding", "getBinding", "()Lcom/zedan/acare/supervisor/databinding/HomeFragmentBinding;", "viewModel", "Lcom/zedan/acare/supervisor/ui/home/HomeViewModel;", "getViewModel", "()Lcom/zedan/acare/supervisor/ui/home/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onError", "error", "Lcom/zedan/acare/supervisor/domain/home/FillPatientResult$Error;", "onLoading", "onSuccess", "fill", "", "onViewCreated", "view", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: HomeFragment.kt */
public final class HomeFragment extends Hilt_HomeFragment {
    private HomeFragmentBinding _binding;
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HomeViewModel.class), new HomeFragment$$special$$inlined$viewModels$2(new HomeFragment$$special$$inlined$viewModels$1(this)), (Function0<? extends ViewModelProvider.Factory>) null);

    /* access modifiers changed from: private */
    public final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel$delegate.getValue();
    }

    public HomeFragment() {
    }

    private final HomeFragmentBinding getBinding() {
        HomeFragmentBinding homeFragmentBinding = this._binding;
        Intrinsics.checkNotNull(homeFragmentBinding);
        return homeFragmentBinding;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = HomeFragmentBinding.inflate(inflater);
        getBinding().icRefresh.setOnClickListener(new HomeFragment$onCreateView$1(this));
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new HomeFragment$onViewCreated$1(this, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void onLoading() {
        CircularProgressIndicator $this$isVisible$iv = getBinding().progressCircular;
        Intrinsics.checkNotNullExpressionValue($this$isVisible$iv, "binding.progressCircular");
        $this$isVisible$iv.setVisibility(0);
        AppCompatImageView $this$isVisible$iv2 = getBinding().icRefresh;
        Intrinsics.checkNotNullExpressionValue($this$isVisible$iv2, "binding.icRefresh");
        $this$isVisible$iv2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void onSuccess(boolean fill) {
        AppCompatImageView $this$isVisible$iv = getBinding().icRefresh;
        Intrinsics.checkNotNullExpressionValue($this$isVisible$iv, "binding.icRefresh");
        $this$isVisible$iv.setVisibility(8);
        CircularProgressIndicator $this$isVisible$iv2 = getBinding().progressCircular;
        Intrinsics.checkNotNullExpressionValue($this$isVisible$iv2, "binding.progressCircular");
        $this$isVisible$iv2.setVisibility(8);
        FragmentKt.findNavController(this).setGraph(fill ? R.navigation.tasks_graph : R.navigation.register_patient_nav);
    }

    /* access modifiers changed from: private */
    public final void onError(FillPatientResult.Error error) {
        if (error.getThrowable() instanceof UserNullException) {
            FragmentKt.findNavController(this).setGraph((int) R.navigation.supervisor_nav_graph);
            return;
        }
        error.getThrowable().printStackTrace();
        CircularProgressIndicator $this$isVisible$iv = getBinding().progressCircular;
        Intrinsics.checkNotNullExpressionValue($this$isVisible$iv, "binding.progressCircular");
        $this$isVisible$iv.setVisibility(8);
        AppCompatImageView $this$isVisible$iv2 = getBinding().icRefresh;
        Intrinsics.checkNotNullExpressionValue($this$isVisible$iv2, "binding.icRefresh");
        $this$isVisible$iv2.setVisibility(0);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
