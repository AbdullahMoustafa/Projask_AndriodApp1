package com.zedan.acare.supervisor.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.HomeFragmentBinding;
import com.zedan.acare.supervisor.domain.exceptions.UserNullException;
import com.zedan.acare.supervisor.domain.home.FillPatientResult;
import com.zedan.acare.supervisor.extension.ViewExtension;

import org.jetbrains.annotations.NotNull;

import dagger.hilt.android.AndroidEntryPoint;
import kotlin.jvm.internal.Intrinsics;

@AndroidEntryPoint
public final class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;

    private HomeViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this)
                .get(HomeViewModel.class);
    }


    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.binding = HomeFragmentBinding.inflate(inflater);

        this.binding.icRefresh.setOnClickListener(v -> {
            viewModel.checkFillPatient();
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getStatusFill().observe(getViewLifecycleOwner(), s -> {
            if (s instanceof FillPatientResult.Loading){
                onLoading();
            } else if (s instanceof FillPatientResult.Success){
                onSuccess(((FillPatientResult.Success) s).getHasFill());
            } else if (s instanceof FillPatientResult.Error){
                onError((FillPatientResult.Error) s);
            }
        });
    }

    private void onLoading() {
        ViewExtension.show(binding.progressCircular);
        ViewExtension.hide(binding.icRefresh);
    }

    private void onSuccess(boolean fill) {
        ViewExtension.hide(binding.icRefresh);
        ViewExtension.hide(binding.progressCircular);
        Navigation.findNavController(binding.getRoot())
                .setGraph(fill ? R.navigation.tasks_graph : R.navigation.register_patient_nav);
    }

    private void onError(FillPatientResult.Error error) {
        if (error.getException() instanceof UserNullException) {
            Navigation.findNavController(binding.getRoot())
                    .setGraph(R.navigation.supervisor_nav_graph);
            return;
        }
        error.getException().printStackTrace();
        ViewExtension.hide(binding.progressCircular);
        ViewExtension.show(binding.icRefresh);
    }

}
