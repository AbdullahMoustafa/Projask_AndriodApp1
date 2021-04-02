package com.zedan.acare.supervisor.ui.register;

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
import com.github.razir.progressbutton.ProgressButtonHolderKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.zedan.acare.common.utils.StatusBar;
import com.zedan.acare.common.widget.C0012ShapeCutBottom;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.bindingAdapter.ButtonExtKt;
import com.zedan.acare.supervisor.databinding.RegisterFragmentBinding;
import com.zedan.acare.supervisor.domain.auth.RegisterResult;
import com.zedan.acare.supervisor.extension.ViewExtKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lcom/zedan/acare/supervisor/ui/register/RegisterFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/zedan/acare/supervisor/databinding/RegisterFragmentBinding;", "handler", "Landroid/os/Handler;", "registerBtnRunnable", "Ljava/lang/Runnable;", "viewModel", "Lcom/zedan/acare/supervisor/ui/register/RegisterViewModel;", "getViewModel", "()Lcom/zedan/acare/supervisor/ui/register/RegisterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "doRunnableRegisterBtn", "", "observeNavigation", "observeStatusRegister", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onError", "error", "Lcom/zedan/acare/supervisor/domain/auth/RegisterResult$Error;", "onLoading", "onSuccess", "onViewCreated", "view", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: RegisterFragment.kt */
public final class RegisterFragment extends Hilt_RegisterFragment {
    /* access modifiers changed from: private */
    public RegisterFragmentBinding binding;
    private final Handler handler;
    private final Runnable registerBtnRunnable = new RegisterFragment$registerBtnRunnable$1(this);
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RegisterViewModel.class), new RegisterFragment$$special$$inlined$viewModels$2(new RegisterFragment$$special$$inlined$viewModels$1(this)), (Function0<? extends ViewModelProvider.Factory>) null);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegisterNavigation.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RegisterNavigation.Login.ordinal()] = 1;
            iArr[RegisterNavigation.PickImage.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final RegisterViewModel getViewModel() {
        return (RegisterViewModel) this.viewModel$delegate.getValue();
    }

    public RegisterFragment() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.handler = new Handler(myLooper);
    }

    public static final /* synthetic */ RegisterFragmentBinding access$getBinding$p(RegisterFragment $this) {
        RegisterFragmentBinding registerFragmentBinding = $this.binding;
        if (registerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return registerFragmentBinding;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        RegisterFragmentBinding inflate = RegisterFragmentBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "RegisterFragmentBinding.inflate(inflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.setViewModel(getViewModel());
        RegisterFragmentBinding registerFragmentBinding = this.binding;
        if (registerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        registerFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());
        RegisterFragmentBinding registerFragmentBinding2 = this.binding;
        if (registerFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        registerFragmentBinding2.executePendingBindings();
        RegisterFragmentBinding registerFragmentBinding3 = this.binding;
        if (registerFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatTextView appCompatTextView = registerFragmentBinding3.appName;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "binding.appName");
        appCompatTextView.setBackground(new ShapeDrawable(new C0012ShapeCutBottom(ContextCompat.getColor(requireContext(), R.color.azul))));
        RegisterFragmentBinding registerFragmentBinding4 = this.binding;
        if (registerFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = registerFragmentBinding4.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        StatusBar.setStatusAsPrimary(this);
        observeNavigation();
        observeStatusRegister();
    }

    private final void observeNavigation() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new RegisterFragment$observeNavigation$1(this, (Continuation) null));
    }

    private final void observeStatusRegister() {
        RegisterFragmentBinding registerFragmentBinding = this.binding;
        if (registerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialButton materialButton = registerFragmentBinding.registerBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.registerBtn");
        ProgressButtonHolderKt.bindProgressButton(this, materialButton);
        getViewModel().getRegisterResult().observe(getViewLifecycleOwner(), new RegisterFragment$observeStatusRegister$1(this));
    }

    /* access modifiers changed from: private */
    public final void onLoading() {
        RegisterFragmentBinding registerFragmentBinding = this.binding;
        if (registerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialButton materialButton = registerFragmentBinding.registerBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.registerBtn");
        ButtonExtKt.showWhiteProgress(materialButton);
    }

    /* access modifiers changed from: private */
    public final void onSuccess() {
        FragmentKt.findNavController(this).setGraph((int) R.navigation.supervisor_nav_graph_home);
    }

    /* access modifiers changed from: private */
    public final void onError(RegisterResult.Error error) {
        RegisterFragmentBinding registerFragmentBinding = this.binding;
        if (registerFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialButton materialButton = registerFragmentBinding.registerBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.registerBtn");
        DrawableButtonExtensionsKt.hideProgress((TextView) materialButton, (int) R.string.error);
        if (error instanceof RegisterResult.Error.InputError) {
            RegisterFragmentBinding registerFragmentBinding2 = this.binding;
            if (registerFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputLayout textInputLayout = registerFragmentBinding2.layoutFullName;
            Intrinsics.checkNotNullExpressionValue(textInputLayout, "binding.layoutFullName");
            boolean isNotName = ((RegisterResult.Error.InputError) error).isNotName();
            String string = getString(R.string.error_name);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error_name)");
            ViewExtKt.shake(textInputLayout, isNotName, string);
            RegisterFragmentBinding registerFragmentBinding3 = this.binding;
            if (registerFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputLayout textInputLayout2 = registerFragmentBinding3.layoutMobile;
            Intrinsics.checkNotNullExpressionValue(textInputLayout2, "binding.layoutMobile");
            boolean isNotMobile = ((RegisterResult.Error.InputError) error).isNotMobile();
            String string2 = getString(R.string.error_phone);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.error_phone)");
            ViewExtKt.shake(textInputLayout2, isNotMobile, string2);
            RegisterFragmentBinding registerFragmentBinding4 = this.binding;
            if (registerFragmentBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputLayout textInputLayout3 = registerFragmentBinding4.layoutEmail;
            Intrinsics.checkNotNullExpressionValue(textInputLayout3, "binding.layoutEmail");
            boolean isNotEmail = ((RegisterResult.Error.InputError) error).isNotEmail();
            String string3 = getString(R.string.error_email);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.error_email)");
            ViewExtKt.shake(textInputLayout3, isNotEmail, string3);
            RegisterFragmentBinding registerFragmentBinding5 = this.binding;
            if (registerFragmentBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputLayout textInputLayout4 = registerFragmentBinding5.layoutPassword;
            Intrinsics.checkNotNullExpressionValue(textInputLayout4, "binding.layoutPassword");
            boolean isNotPassword = ((RegisterResult.Error.InputError) error).isNotPassword();
            String string4 = getString(R.string.error_password);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.error_password)");
            ViewExtKt.shake(textInputLayout4, isNotPassword, string4);
            RegisterFragmentBinding registerFragmentBinding6 = this.binding;
            if (registerFragmentBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputLayout textInputLayout5 = registerFragmentBinding6.layoutKinship;
            Intrinsics.checkNotNullExpressionValue(textInputLayout5, "binding.layoutKinship");
            boolean isNotKinship = ((RegisterResult.Error.InputError) error).isNotKinship();
            String string5 = getString(R.string.error_valid_text);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.error_valid_text)");
            ViewExtKt.shake(textInputLayout5, isNotKinship, string5);
            RegisterFragmentBinding registerFragmentBinding7 = this.binding;
            if (registerFragmentBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputLayout textInputLayout6 = registerFragmentBinding7.layoutLocation;
            Intrinsics.checkNotNullExpressionValue(textInputLayout6, "binding.layoutLocation");
            boolean isNotAddress = ((RegisterResult.Error.InputError) error).isNotAddress();
            String string6 = getString(R.string.error_valid_text);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.error_valid_text)");
            ViewExtKt.shake(textInputLayout6, isNotAddress, string6);
            RegisterFragmentBinding registerFragmentBinding8 = this.binding;
            if (registerFragmentBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputLayout textInputLayout7 = registerFragmentBinding8.layoutCountry;
            Intrinsics.checkNotNullExpressionValue(textInputLayout7, "binding.layoutCountry");
            boolean isNotCountry = ((RegisterResult.Error.InputError) error).isNotCountry();
            String string7 = getString(R.string.error_valid_text);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.error_valid_text)");
            ViewExtKt.shake(textInputLayout7, isNotCountry, string7);
        } else if (error instanceof RegisterResult.Error.Exception) {
            boolean z = ((RegisterResult.Error.Exception) error).getThrowable() instanceof FirebaseAuthUserCollisionException;
            ((RegisterResult.Error.Exception) error).getThrowable().printStackTrace();
            Timber.e("Register Exception.", new Object[0]);
        }
        doRunnableRegisterBtn();
    }

    private final void doRunnableRegisterBtn() {
        this.handler.postDelayed(this.registerBtnRunnable, 2000);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.handler.removeCallbacks(this.registerBtnRunnable);
    }
}
