package com.zedan.acare.supervisor.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.zedan.acare.supervisor.SupervisorActivity;
import com.zedan.acare.supervisor.databinding.ProfileFragmentBinding;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class ProfileFragment extends Fragment {

    @Inject
    public FirebaseAuth auth;

    private ProfileFragmentBinding binding;

    private ProfileViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this)
                .get(ProfileViewModel.class);
    }

    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = ProfileFragmentBinding.inflate(inflater);


        this.binding.setViewModel(viewModel);
        this.binding.setLifecycleOwner(getViewLifecycleOwner());
        this.binding.executePendingBindings();

        return this.binding.getRoot();
    }

    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViewsListener();

    }

    private void setViewsListener() {
        this.binding.icBack.setOnClickListener(v -> Navigation.findNavController(binding.getRoot())
                .popBackStack());


        this.binding.profileData.language.setOnClickListener(v -> Navigation.findNavController(binding.getRoot())
                .navigate(ProfileFragmentDirections.actionProfileFragmentToLanguageNav()));

        this.binding.profileData.signOut.setOnClickListener(v -> {
            auth.signOut();
            startActivity(new Intent(requireContext(), SupervisorActivity.class));
            requireActivity().finish();
        });

    }
}
