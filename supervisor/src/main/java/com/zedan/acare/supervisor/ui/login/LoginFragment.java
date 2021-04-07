package com.zedan.acare.supervisor.ui.login;

import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.github.razir.progressbutton.ProgressButtonHolderKt;
import com.zedan.acare.common.utils.StatusBar;
import com.zedan.acare.common.widget.ShapeCutBottom;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.bindingAdapter.ButtonBindingAdapter;
import com.zedan.acare.supervisor.databinding.LoginFragmentBinding;
import com.zedan.acare.supervisor.domain.auth.LoginStatus;
import com.zedan.acare.supervisor.extension.ViewExtension;

import org.jetbrains.annotations.NotNull;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class LoginFragment extends Fragment {

    private LoginViewModel viewModel;

    private LoginFragmentBinding binding;

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable loginBtnCallback = () -> ButtonBindingAdapter.hideProgress(binding.loginBtn, R.string.login);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this)
                .get(LoginViewModel.class);
    }

    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = LoginFragmentBinding.inflate(getLayoutInflater());

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.executePendingBindings();

        binding.appName.setBackground(
                new ShapeDrawable(
                        new ShapeCutBottom(ContextCompat.getColor(requireContext(), R.color.azul))
                )
        );

        return binding.getRoot();
    }

    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        StatusBar.setStatusAsPrimary(this);

        observeNavigation();

        observeStatusLogin();

        binding.txtLanguage.setOnClickListener(v -> Navigation.findNavController(view)
                .navigate(LoginFragmentDirections.actionLoginFragmentToLanguageNav()));
    }

    private void observeNavigation() {
        viewModel.getNavigation()
                .observe(getViewLifecycleOwner(), t -> {
                    if (t == null)
                        return;
                    Navigation.findNavController(binding.getRoot())
                            .navigate(t);
                });
    }

    private void observeStatusLogin() {
        ProgressButtonHolderKt.bindProgressButton(this, binding.loginBtn);
        viewModel.getStatusLogin()
                .observe(getViewLifecycleOwner(), s -> {
                    if (s instanceof LoginStatus.Loading) {
                        onLoading();
                    } else if (s instanceof LoginStatus.Error) {
                        onError((LoginStatus.Error) s);
                    } else if (s instanceof LoginStatus.Success) {
                        onSuccess();
                    }
                });
    }


    public final void onLoading() {
        ButtonBindingAdapter.showWhiteProgress(binding.loginBtn);
    }


    private void onSuccess() {
        Navigation
                .findNavController(binding.getRoot())
                .setGraph(R.navigation.supervisor_nav_graph_home);
    }


    private void onError(LoginStatus.Error error) {

        if (error instanceof LoginStatus.Error.InputError) {
            // Shake inputs
            ViewExtension.shake(binding.inputEmail);
            ViewExtension.shake(binding.inputPassword);

        } else if (error instanceof LoginStatus.Error.Exception) {
            // Print Error
            ((LoginStatus.Error.Exception) error).getThrowable().printStackTrace();
        }

        ButtonBindingAdapter.hideProgress(binding.loginBtn, R.string.error);
        this.handler.postDelayed(this.loginBtnCallback, 1500);
    }

    public void onDestroyView() {
        this.loginBtnCallback.run();
        super.onDestroyView();
        this.handler.removeCallbacks(this.loginBtnCallback);
    }
}
