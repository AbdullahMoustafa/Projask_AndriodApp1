package com.zedan.acare.supervisor.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.firebase.auth.FirebaseAuth;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.SupervisorActivity;
import com.zedan.acare.supervisor.databinding.ProfileFragmentBinding;
import com.zedan.acare.supervisor.domain.profile.EditInputParam;
import com.zedan.acare.supervisor.domain.profile.EditInputValidation;
import com.zedan.acare.supervisor.domain.profile.UploadImageStatus;
import com.zedan.acare.supervisor.utils.ImageSelectorUtil;
import com.zedan.acare.supervisor.utils.Validator;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import timber.log.Timber;

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

        this.binding.profileData.icEditPhone.setOnClickListener(v ->
                navigateToEdit(
                        new EditInputParam(
                                viewModel.getSupervisorPath() + "/phone",
                                getString(R.string.hint_mobile),
                                binding.profileData.sPhone.getText().toString().trim(),
                                new EditInputValidation() {
                                    @Override
                                    public boolean validateInput(String input) {
                                        return Validator.isPhone(input);
                                    }
                                }
                        )
                )
        );

        this.binding.profileData.icEditKinship.setOnClickListener(v -> navigateToEdit(
                new EditInputParam(
                        viewModel.getSupervisorPath() + "/kinship",
                        getString(R.string.hint_kinship),
                        binding.profileData.sKinship.getText().toString().trim(),
                        new EditInputValidation() {
                            @Override
                            public boolean validateInput(String input) {
                                return Validator.isLargeThan(input, 2);
                            }
                        }
                )
        ));


        this.binding.profileData.icEditLocation.setOnClickListener(v -> navigateToEdit(
                new EditInputParam(
                        viewModel.getSupervisorPath() + "/address",
                        getString(R.string.hint_home_location),
                        binding.profileData.sLocation.getText().toString().trim(),
                        new EditInputValidation() {
                            @Override
                            public boolean validateInput(String input) {
                                return Validator.isLargeThan(input, 3);
                            }
                        }
                )
        ));

        this.binding.profileData.icEditCountry.setOnClickListener(v -> navigateToEdit(
                new EditInputParam(
                        viewModel.getSupervisorPath() + "/country",
                        getString(R.string.hint_country),
                        binding.profileData.sCountry.getText().toString().trim(),
                        new EditInputValidation() {
                            @Override
                            public boolean validateInput(String input) {
                                return Validator.isLargeThan(input, 3);
                            }
                        }
                )
        ));

        this.binding.profileData.icEditPateintName.setOnClickListener(v -> navigateToEdit(
                new EditInputParam(
                        viewModel.getPatientPath() + "/name",
                        getString(R.string.hint_full_name),
                        binding.profileData.pName.getText().toString().trim(),
                        new EditInputValidation() {
                            @Override
                            public boolean validateInput(String input) {
                                return Validator.isName(input, 2);
                            }
                        }
                )
        ));

        this.binding.profileData.icEditPatientStatus.setOnClickListener(v -> navigateToEdit(
                new EditInputParam(
                        viewModel.getPatientPath() + "/status",
                        getString(R.string.hint_status),
                        binding.profileData.pStatus.getText().toString().trim(),
                        new EditInputValidation() {
                            @Override
                            public boolean validateInput(String input) {
                                return Validator.isStatus(input);
                            }
                        }
                )
        ));

        this.binding.profileData.icEditPatientAge.setOnClickListener(v -> navigateToEdit(
                new EditInputParam(
                        viewModel.getPatientPath() + "/age",
                        getString(R.string.hint_age),
                        binding.profileData.pAge.getText().toString().trim(),
                        new EditInputValidation() {
                            @Override
                            public boolean validateInput(String input) {
                                return Validator.isAge(input);
                            }
                        }
                )
        ));

        this.binding.profileData.icEditPateintLocation.setOnClickListener(v -> navigateToEdit(
                new EditInputParam(
                        viewModel.getPatientPath() + "/homeLocation",
                        getString(R.string.hint_home_location),
                        binding.profileData.pLocation.getText().toString().trim(),
                        new EditInputValidation() {
                            @Override
                            public boolean validateInput(String input) {
                                return Validator.isLargeThan(input, 3);
                            }
                        }
                )
        ));

        this.binding.profileData.icEditPatientCountry.setOnClickListener(v -> navigateToEdit(
                new EditInputParam(
                        viewModel.getPatientPath() + "/country",
                        getString(R.string.hint_country),
                        binding.profileData.pCountry.getText().toString().trim(),
                        new EditInputValidation() {
                            @Override
                            public boolean validateInput(String input) {
                                return Validator.isLargeThan(input, 3);
                            }
                        }
                )
        ));

        this.binding.profileData.icEditProfile.setOnClickListener(v ->
                ImageSelectorUtil.showImageSelectorDialog(requireActivity(), file -> {
                    if (file == null)
                        return;
                    binding.profileData.icUser.setImageURI(Uri.fromFile(file));
                    viewModel.uploadImage(file.getAbsolutePath());
                })
        );
    }

    private void navigateToEdit(EditInputParam param) {
        Navigation.findNavController(binding.getRoot())
                .navigate(ProfileFragmentDirections.actionProfileFragmentToEditDialog(param));
    }


    private void observeUploadImage(UploadImageStatus status){
        if (status instanceof UploadImageStatus.Loading){
            onLoading();
        } else if (status instanceof UploadImageStatus.Success){
            onSuccess();
        } else if (status instanceof UploadImageStatus.Error){
            onError((UploadImageStatus.Error) status);
        }
    }

    private void onLoading(){
        // TODO: On Loading
    }

    private void onSuccess(){
        // TODO: OnSuccess
    }

    private void onError(UploadImageStatus.Error error){
        // TODO: Show message Dialog
    }
}
