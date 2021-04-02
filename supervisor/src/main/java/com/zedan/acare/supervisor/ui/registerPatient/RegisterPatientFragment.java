package com.zedan.acare.supervisor.ui.registerPatient;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.FragmentKt;
import com.github.razir.progressbutton.DrawableButtonExtensionsKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.zedan.acare.common.autoComplete.C0002AutoCompleteAdapter;
import com.zedan.acare.common.autoComplete.C0006AutoCompleteListener;
import com.zedan.acare.common.entities.C0007SelectEntity;
import com.zedan.acare.common.utils.StatusBar;
import com.zedan.acare.common.widget.C0012ShapeCutBottom;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.bindingAdapter.AutoCompleteTextKt;
import com.zedan.acare.supervisor.bindingAdapter.ButtonExtKt;
import com.zedan.acare.supervisor.databinding.RegisterPatientFragmentBinding;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientResult;
import com.zedan.acare.supervisor.domain.exceptions.UserIsUsedException;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.extension.ViewExtKt;
import com.zedan.acare.supervisor.utils.ToastKt;
import com.zedan.acare.supervisor.utils.ToastType;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0011H\u0002J\u001a\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006+"}, d2 = {"Lcom/zedan/acare/supervisor/ui/registerPatient/RegisterPatientFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/zedan/acare/common/autoComplete/AutoCompleteListener;", "()V", "binding", "Lcom/zedan/acare/supervisor/databinding/RegisterPatientFragmentBinding;", "handler", "Landroid/os/Handler;", "saveBtnCallback", "Ljava/lang/Runnable;", "viewModel", "Lcom/zedan/acare/supervisor/ui/registerPatient/RegisterPatientViewModel;", "getViewModel", "()Lcom/zedan/acare/supervisor/ui/registerPatient/RegisterPatientViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "collectRegisterStatus", "", "inputError", "status", "Lcom/zedan/acare/supervisor/domain/auth/RegisterPatientResult$Error$ErrorInputs;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onError", "error", "Lcom/zedan/acare/supervisor/domain/auth/RegisterPatientResult$Error;", "onException", "throwable", "", "onLoading", "onSelected", "item", "Lcom/zedan/acare/common/entities/SelectEntity;", "onSuccess", "onViewCreated", "view", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: RegisterPatientFragment.kt */
public final class RegisterPatientFragment extends Hilt_RegisterPatientFragment implements C0006AutoCompleteListener {
    /* access modifiers changed from: private */
    public RegisterPatientFragmentBinding binding;
    private final Handler handler;
    private final Runnable saveBtnCallback;
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RegisterPatientViewModel.class), new RegisterPatientFragment$$special$$inlined$viewModels$2(new RegisterPatientFragment$$special$$inlined$viewModels$1(this)), (Function0<? extends ViewModelProvider.Factory>) null);

    /* access modifiers changed from: private */
    public final RegisterPatientViewModel getViewModel() {
        return (RegisterPatientViewModel) this.viewModel$delegate.getValue();
    }

    public RegisterPatientFragment() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.handler = new Handler(myLooper);
        this.saveBtnCallback = new RegisterPatientFragment$saveBtnCallback$1(this);
    }

    public static final /* synthetic */ RegisterPatientFragmentBinding access$getBinding$p(RegisterPatientFragment $this) {
        RegisterPatientFragmentBinding registerPatientFragmentBinding = $this.binding;
        if (registerPatientFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return registerPatientFragmentBinding;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        RegisterPatientFragmentBinding inflate = RegisterPatientFragmentBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "RegisterPatientFragmentBinding.inflate(inflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.setViewModel(getViewModel());
        RegisterPatientFragmentBinding registerPatientFragmentBinding = this.binding;
        if (registerPatientFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        registerPatientFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());
        RegisterPatientFragmentBinding registerPatientFragmentBinding2 = this.binding;
        if (registerPatientFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        registerPatientFragmentBinding2.executePendingBindings();
        RegisterPatientFragmentBinding registerPatientFragmentBinding3 = this.binding;
        if (registerPatientFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatTextView appCompatTextView = registerPatientFragmentBinding3.appName;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "binding.appName");
        appCompatTextView.setBackground(new ShapeDrawable(new C0012ShapeCutBottom(ContextCompat.getColor(requireContext(), R.color.azul))));
        RegisterPatientFragmentBinding registerPatientFragmentBinding4 = this.binding;
        if (registerPatientFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialAutoCompleteTextView $this$run = registerPatientFragmentBinding4.inputStatusType;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        AutoCompleteTextKt.setAdapterACARE($this$run, new C0002AutoCompleteAdapter(requireContext, CollectionsKt.listOf(new C0007SelectEntity((long) R.string.status_single, getString(R.string.status_single)), new C0007SelectEntity((long) R.string.status_married, getString(R.string.status_married)))));
        AutoCompleteTextKt.addOnSelectedListener($this$run, this);
        RegisterPatientFragmentBinding registerPatientFragmentBinding5 = this.binding;
        if (registerPatientFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = registerPatientFragmentBinding5.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        StatusBar.setStatusAsPrimary(this);
        collectRegisterStatus();
    }

    private final void collectRegisterStatus() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new RegisterPatientFragment$collectRegisterStatus$1(this, (Continuation) null));
    }

    /* access modifiers changed from: private */
    public final void onLoading() {
        RegisterPatientFragmentBinding registerPatientFragmentBinding = this.binding;
        if (registerPatientFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialButton materialButton = registerPatientFragmentBinding.saveDataBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.saveDataBtn");
        ButtonExtKt.showWhiteProgress(materialButton);
    }

    /* access modifiers changed from: private */
    public final void onSuccess() {
        FragmentKt.findNavController(this).setGraph((int) R.navigation.tasks_graph);
    }

    /* access modifiers changed from: private */
    public final void onError(RegisterPatientResult.Error error) {
        if (error instanceof RegisterPatientResult.Error.ErrorInputs) {
            inputError((RegisterPatientResult.Error.ErrorInputs) error);
        } else if (error instanceof RegisterPatientResult.Error.Exception) {
            onException(((RegisterPatientResult.Error.Exception) error).getThrowable());
        }
        RegisterPatientFragmentBinding registerPatientFragmentBinding = this.binding;
        if (registerPatientFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialButton materialButton = registerPatientFragmentBinding.saveDataBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.saveDataBtn");
        DrawableButtonExtensionsKt.hideProgress((TextView) materialButton, (int) R.string.error);
        this.handler.postDelayed(this.saveBtnCallback, 1500);
    }

    private final void inputError(RegisterPatientResult.Error.ErrorInputs status) {
        RegisterPatientFragmentBinding registerPatientFragmentBinding = this.binding;
        if (registerPatientFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout = registerPatientFragmentBinding.layoutFullName;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "binding.layoutFullName");
        ViewExtKt.shake(textInputLayout, status.isNotName());
        RegisterPatientFragmentBinding registerPatientFragmentBinding2 = this.binding;
        if (registerPatientFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout2 = registerPatientFragmentBinding2.layoutAge;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "binding.layoutAge");
        ViewExtKt.shake(textInputLayout2, status.isNotAge());
        RegisterPatientFragmentBinding registerPatientFragmentBinding3 = this.binding;
        if (registerPatientFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout3 = registerPatientFragmentBinding3.layoutStatus;
        Intrinsics.checkNotNullExpressionValue(textInputLayout3, "binding.layoutStatus");
        ViewExtKt.shake(textInputLayout3, status.isNotStatus());
        RegisterPatientFragmentBinding registerPatientFragmentBinding4 = this.binding;
        if (registerPatientFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout4 = registerPatientFragmentBinding4.layoutHomeLocation;
        Intrinsics.checkNotNullExpressionValue(textInputLayout4, "binding.layoutHomeLocation");
        ViewExtKt.shake(textInputLayout4, status.isNotLocation());
        RegisterPatientFragmentBinding registerPatientFragmentBinding5 = this.binding;
        if (registerPatientFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout5 = registerPatientFragmentBinding5.layoutCountry;
        Intrinsics.checkNotNullExpressionValue(textInputLayout5, "binding.layoutCountry");
        ViewExtKt.shake(textInputLayout5, status.isNotCountry());
        RegisterPatientFragmentBinding registerPatientFragmentBinding6 = this.binding;
        if (registerPatientFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout6 = registerPatientFragmentBinding6.layoutMobile;
        Intrinsics.checkNotNullExpressionValue(textInputLayout6, "binding.layoutMobile");
        ViewExtKt.shake(textInputLayout6, status.isNotMobile());
        RegisterPatientFragmentBinding registerPatientFragmentBinding7 = this.binding;
        if (registerPatientFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout7 = registerPatientFragmentBinding7.layoutPassword;
        Intrinsics.checkNotNullExpressionValue(textInputLayout7, "binding.layoutPassword");
        ViewExtKt.shake(textInputLayout7, status.isNotPassword());
        RegisterPatientFragmentBinding registerPatientFragmentBinding8 = this.binding;
        if (registerPatientFragmentBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextInputLayout textInputLayout8 = registerPatientFragmentBinding8.layoutStatusType;
        Intrinsics.checkNotNullExpressionValue(textInputLayout8, "binding.layoutStatusType");
        ViewExtKt.shake(textInputLayout8, status.isNotStatusType());
    }

    private final void onException(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof UserIsUsedException) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            String string = getString(R.string.error_user_used);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error_user_used)");
            ToastKt.showToast$default(requireContext, string, ToastType.Error, (Function0) null, 4, (Object) null);
        } else if (throwable instanceof UserNullException) {
            FragmentKt.findNavController(this).setGraph((int) R.navigation.supervisor_nav_graph);
        }
    }

    public void onDestroyView() {
        this.saveBtnCallback.run();
        super.onDestroyView();
        this.handler.removeCallbacks(this.saveBtnCallback);
    }

    public void onSelected(C0007SelectEntity item) {
        Intrinsics.checkNotNullParameter(item, "item");
        RegisterPatientFragmentBinding registerPatientFragmentBinding = this.binding;
        if (registerPatientFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        registerPatientFragmentBinding.inputStatusType.setText(item.getName());
    }
}
