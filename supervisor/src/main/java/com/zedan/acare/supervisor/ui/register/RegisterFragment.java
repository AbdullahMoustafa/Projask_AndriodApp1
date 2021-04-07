package com.zedan.acare.supervisor.ui.register;

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
import com.zedan.acare.supervisor.databinding.RegisterFragmentBinding;
import com.zedan.acare.supervisor.domain.auth.RegisterResult;
import com.zedan.acare.supervisor.extension.ViewExtension;

import org.jetbrains.annotations.NotNull;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class RegisterFragment extends Fragment {

    public RegisterFragmentBinding binding;

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable registerBtnRunnable = new Runnable() {
        @Override
        public void run() {
            ButtonBindingAdapter.hideProgress(binding.registerBtn, R.string.register);
        }
    };

    private RegisterViewModel viewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this)
                .get(RegisterViewModel.class);
    }


    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = RegisterFragmentBinding.inflate(inflater);

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

        observeStatusRegister();
    }

    private void observeNavigation() {
        viewModel.getNavigation().observe(getViewLifecycleOwner(), n -> {
            if (n == RegisterNavigation.Login){
                Navigation.findNavController(binding.getRoot())
                        .popBackStack();
            } else if (n == RegisterNavigation.PickImage){
                // TODO: Handle To Image Picker
            }
        });
    }

    private void observeStatusRegister() {

        ProgressButtonHolderKt.bindProgressButton(getViewLifecycleOwner(), binding.registerBtn);

        viewModel.getRegisterResult().observe(getViewLifecycleOwner(), s->{
            if (s instanceof RegisterResult.Loading){
                onLoading();
            } else if (s instanceof RegisterResult.Success){
                onSuccess();
            } else if (s instanceof RegisterResult.Error){
                onError((RegisterResult.Error) s);
            }
        });
    }

    private void onLoading() {
        ButtonBindingAdapter.showWhiteProgress(binding.registerBtn);
    }

    private void onSuccess() {
        Navigation.findNavController(binding.getRoot())
                .setGraph(R.navigation.supervisor_nav_graph_home);
    }

    public final void onError(RegisterResult.Error error) {
        ButtonBindingAdapter.hideProgress(binding.registerBtn, R.string.error);
        if (error instanceof RegisterResult.Error.InputError) {

            RegisterResult.Error.InputError inputError = (RegisterResult.Error.InputError) error;
            ViewExtension.shake(binding.layoutFullName, inputError.isNotName());
            ViewExtension.shake(binding.layoutEmail, inputError.isNotEmail());
            ViewExtension.shake(binding.layoutMobile, inputError.isNotMobile());
            ViewExtension.shake(binding.layoutPassword, inputError.isNotPassword());
            ViewExtension.shake(binding.layoutCountry, inputError.isNotCountry());
            ViewExtension.shake(binding.layoutKinship, inputError.isNotKinship());
            ViewExtension.shake(binding.layoutLocation, inputError.isNotAddress());

        } else if (error instanceof RegisterResult.Error.Exception) {
            //TODO: Handler errors
            ((RegisterResult.Error.Exception) error).getThrowable().printStackTrace();
        }
        ButtonBindingAdapter.hideProgress(binding.registerBtn, R.string.error);
        doRunnableRegisterBtn();
    }

    private void doRunnableRegisterBtn() {
        this.handler.postDelayed(this.registerBtnRunnable, 2000);
    }

    public void onDestroyView() {
        this.registerBtnRunnable.run();
        super.onDestroyView();
        this.handler.removeCallbacks(this.registerBtnRunnable);
    }
}
