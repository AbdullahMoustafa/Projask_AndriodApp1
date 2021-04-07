package com.zedan.acare.supervisor.ui.registerPatient;

import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.zedan.acare.common.autoComplete.AutoCompleteAdapter;
import com.zedan.acare.common.autoComplete.AutoCompleteListener;
import com.zedan.acare.common.entities.SelectEntity;
import com.zedan.acare.common.utils.StatusBar;
import com.zedan.acare.common.widget.ShapeCutBottom;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.bindingAdapter.AutoCompleteTextBindingAdapter;
import com.zedan.acare.supervisor.bindingAdapter.ButtonBindingAdapter;
import com.zedan.acare.supervisor.databinding.RegisterPatientFragmentBinding;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientResult;
import com.zedan.acare.supervisor.domain.exceptions.UserIsUsedException;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.extension.ViewExtension;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public final class RegisterPatientFragment extends Fragment implements AutoCompleteListener {

    private RegisterPatientFragmentBinding binding;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable saveBtnCallback = new Runnable() {
        @Override
        public void run() {
            ButtonBindingAdapter.hideProgress(binding.saveDataBtn, R.string.save_data);
        }
    };

    private RegisterPatientViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this)
                .get(RegisterPatientViewModel.class);
    }

    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = RegisterPatientFragmentBinding.inflate(inflater);

        this.binding.setViewModel(viewModel);
        this.binding.setLifecycleOwner(getViewLifecycleOwner());
        this.binding.executePendingBindings();

        binding.appName.setBackground(
                new ShapeDrawable(
                        new ShapeCutBottom(ContextCompat.getColor(requireContext(), R.color.azul))
                )
        );

        AutoCompleteTextBindingAdapter.setAdapter(
                binding.inputStatusType,
                new AutoCompleteAdapter(
                        requireContext(),
                        Arrays.asList(
                                new SelectEntity(
                                        R.string.status_single,
                                        getString(R.string.status_single)
                                ),
                                new SelectEntity(
                                        R.string.status_married,
                                        getString(R.string.status_married)
                                )
                        )
                )
        );
        AutoCompleteTextBindingAdapter.addOnSelectedListener(binding.inputStatusType, this);


        return binding.getRoot();
    }

    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        StatusBar.setStatusAsPrimary(this);

        viewModel.getStatusRegister().observe(getViewLifecycleOwner(), this::collectRegisterStatus);
    }

    private void collectRegisterStatus(RegisterPatientResult result) {
        if (result instanceof RegisterPatientResult.Loading){
            onLoading();
        } else if (result instanceof RegisterPatientResult.Success){
            onSuccess();
        } else if (result instanceof RegisterPatientResult.Error){
            onError((RegisterPatientResult.Error) result);
        }
    }

    private void onLoading() {
        ButtonBindingAdapter.showWhiteProgress(binding.saveDataBtn);
    }

    private void onSuccess() {
        Navigation.findNavController(binding.getRoot())
                .setGraph(R.navigation.tasks_graph);
    }

    private void onError(RegisterPatientResult.Error error) {
        if (error instanceof RegisterPatientResult.Error.ErrorInputs) {
            inputError((RegisterPatientResult.Error.ErrorInputs) error);
        } else if (error instanceof RegisterPatientResult.Error.Exception) {
            onException(((RegisterPatientResult.Error.Exception) error).getThrowable());
        }
        ButtonBindingAdapter.hideProgress(binding.saveDataBtn, R.string.error);
        this.handler.postDelayed(this.saveBtnCallback, 1500);
    }

    private void inputError(RegisterPatientResult.Error.ErrorInputs status) {
        ViewExtension.shake(binding.layoutFullName, status.isNotName());
        ViewExtension.shake(binding.layoutAge, status.isNotAge());
        ViewExtension.shake(binding.layoutCountry, status.isNotCountry());
        ViewExtension.shake(binding.layoutHomeLocation, status.isNotLocation());
        ViewExtension.shake(binding.layoutMobile, status.isNotMobile());
        ViewExtension.shake(binding.layoutPassword, status.isNotPassword());
        ViewExtension.shake(binding.layoutStatus, status.isNotStatus());
        ViewExtension.shake(binding.layoutStatusType, status.isNotStatusType());
    }

    private void onException(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable instanceof UserIsUsedException) {
            // TODO: Show alert Message with message. getString(R.string.error_user_used);

        } else if (throwable instanceof UserNullException) {
            Navigation.findNavController(binding.getRoot())
                    .setGraph(R.navigation.supervisor_nav_graph);
        }
    }


    @Override
    public void onSelected(@NonNull SelectEntity selectEntity) {
        binding.inputStatusType.setText(selectEntity.getName());
    }

    @Override
    public void onDestroyView() {
        this.saveBtnCallback.run();
        super.onDestroyView();
        this.handler.removeCallbacks(this.saveBtnCallback);
    }

}
