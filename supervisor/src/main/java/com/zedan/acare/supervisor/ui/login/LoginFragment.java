package com.zedan.acare.supervisor.ui.login;

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
import com.google.android.material.textfield.TextInputEditText;
import com.zedan.acare.common.utils.StatusBar;
import com.zedan.acare.common.widget.C0012ShapeCutBottom;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.bindingAdapter.ButtonExtKt;
import com.zedan.acare.supervisor.databinding.LoginFragmentBinding;
import com.zedan.acare.supervisor.domain.auth.LoginStatus;
import com.zedan.acare.supervisor.extension.ViewExtKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u001a\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/zedan/acare/supervisor/ui/login/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/zedan/acare/supervisor/databinding/LoginFragmentBinding;", "handler", "Landroid/os/Handler;", "loginBtnCallback", "Ljava/lang/Runnable;", "viewModel", "Lcom/zedan/acare/supervisor/ui/login/LoginViewModel;", "getViewModel", "()Lcom/zedan/acare/supervisor/ui/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeNavigation", "", "observeStatusLogin", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onError", "error", "Lcom/zedan/acare/supervisor/domain/auth/LoginStatus$Error;", "onLoading", "onSuccess", "onViewCreated", "view", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: LoginFragment.kt */
public final class LoginFragment extends Hilt_LoginFragment {
    /* access modifiers changed from: private */
    public LoginFragmentBinding binding;
    private final Handler handler;
    private final Runnable loginBtnCallback;
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new LoginFragment$$special$$inlined$viewModels$2(new LoginFragment$$special$$inlined$viewModels$1(this)), (Function0<? extends ViewModelProvider.Factory>) null);

    /* access modifiers changed from: private */
    public final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel$delegate.getValue();
    }

    public LoginFragment() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.handler = new Handler(myLooper);
        this.loginBtnCallback = new LoginFragment$loginBtnCallback$1(this);
    }

    public static final /* synthetic */ LoginFragmentBinding access$getBinding$p(LoginFragment $this) {
        LoginFragmentBinding loginFragmentBinding = $this.binding;
        if (loginFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return loginFragmentBinding;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LoginFragmentBinding inflate = LoginFragmentBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "LoginFragmentBinding.inflate(layoutInflater)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        inflate.setViewModel(getViewModel());
        LoginFragmentBinding loginFragmentBinding = this.binding;
        if (loginFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        loginFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());
        LoginFragmentBinding loginFragmentBinding2 = this.binding;
        if (loginFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        loginFragmentBinding2.executePendingBindings();
        LoginFragmentBinding loginFragmentBinding3 = this.binding;
        if (loginFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AppCompatTextView appCompatTextView = loginFragmentBinding3.appName;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "binding.appName");
        appCompatTextView.setBackground(new ShapeDrawable(new C0012ShapeCutBottom(ContextCompat.getColor(requireContext(), R.color.azul))));
        LoginFragmentBinding loginFragmentBinding4 = this.binding;
        if (loginFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = loginFragmentBinding4.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        StatusBar.setStatusAsPrimary(this);
        observeNavigation();
        observeStatusLogin();
        LoginFragmentBinding loginFragmentBinding = this.binding;
        if (loginFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        loginFragmentBinding.txtLanguage.setOnClickListener(new LoginFragment$onViewCreated$1(this));
    }

    private final void observeNavigation() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new LoginFragment$observeNavigation$1(this, (Continuation) null));
    }

    private final void observeStatusLogin() {
        LoginFragmentBinding loginFragmentBinding = this.binding;
        if (loginFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialButton materialButton = loginFragmentBinding.loginBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.loginBtn");
        ProgressButtonHolderKt.bindProgressButton(this, materialButton);
        getViewModel().getStatusLogin().observe(getViewLifecycleOwner(), new LoginFragment$observeStatusLogin$1(this));
    }

    /* access modifiers changed from: private */
    public final void onLoading() {
        LoginFragmentBinding loginFragmentBinding = this.binding;
        if (loginFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialButton materialButton = loginFragmentBinding.loginBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.loginBtn");
        ButtonExtKt.showWhiteProgress(materialButton);
    }

    /* access modifiers changed from: private */
    public final void onSuccess() {
        FragmentKt.findNavController(this).setGraph((int) R.navigation.supervisor_nav_graph_home);
    }

    /* access modifiers changed from: private */
    public final void onError(LoginStatus.Error error) {
        if (error instanceof LoginStatus.Error.InputError) {
            LoginFragmentBinding loginFragmentBinding = this.binding;
            if (loginFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputEditText textInputEditText = loginFragmentBinding.inputEmail;
            Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.inputEmail");
            ViewExtKt.shake$default(textInputEditText, (Function1) null, 1, (Object) null);
            LoginFragmentBinding loginFragmentBinding2 = this.binding;
            if (loginFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextInputEditText textInputEditText2 = loginFragmentBinding2.inputPassword;
            Intrinsics.checkNotNullExpressionValue(textInputEditText2, "binding.inputPassword");
            ViewExtKt.shake$default(textInputEditText2, (Function1) null, 1, (Object) null);
        } else if (error instanceof LoginStatus.Error.Exception) {
            Timber.e("Exception login", new Object[0]);
            ((LoginStatus.Error.Exception) error).getThrowable().printStackTrace();
        }
        LoginFragmentBinding loginFragmentBinding3 = this.binding;
        if (loginFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        MaterialButton materialButton = loginFragmentBinding3.loginBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.loginBtn");
        DrawableButtonExtensionsKt.hideProgress((TextView) materialButton, (int) R.string.error);
        this.handler.postDelayed(this.loginBtnCallback, 1500);
    }

    public void onDestroyView() {
        this.loginBtnCallback.run();
        super.onDestroyView();
        this.handler.removeCallbacks(this.loginBtnCallback);
    }
}
