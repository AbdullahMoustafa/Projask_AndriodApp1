package com.zedan.acare.supervisor.ui.profile.edit;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.zedan.acare.supervisor.databinding.EditDialogBinding;
import com.zedan.acare.supervisor.domain.profile.EditInputParam;
import com.zedan.acare.supervisor.domain.profile.EditInputResult;
import com.zedan.acare.supervisor.extension.ViewExtension;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class EditDialog extends DialogFragment {

    private EditInputParam args;

    private EditDialogViewModel viewModel;

    private EditDialogBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this)
                .get(EditDialogViewModel.class);

        args = EditDialogArgs.fromBundle(requireArguments()).getArgs();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = EditDialogBinding.inflate(inflater);

        binding.hintInput.setText(args.getHint());
        binding.inputEditable.setText(args.getValue());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getResult().observe(getViewLifecycleOwner(), this::observerStatus);

        binding.saveBtn.setOnClickListener(v -> {
            if (binding.inputEditable.getText() == null)
                return;

            args.setValue(binding.inputEditable.getText().toString().trim());
            viewModel.editInput(args);
        });
    }

    private void observerStatus(EditInputResult result){
        if (result instanceof EditInputResult.Loading){
            onLoading();
        } else if (result instanceof EditInputResult.Success){
            onSuccess();
        } else if (result instanceof EditInputResult.Error){
            onError((EditInputResult.Error) result);
        }
    }

    private void onLoading(){
        // TODO: Show Loading Dialog
    }

    private void onSuccess(){
        dismiss();
    }

    private void onError(EditInputResult.Error error){
        if (error instanceof EditInputResult.Error.InputError){
            ViewExtension.shake(binding.inputEditable, true);
        } else if (error instanceof EditInputResult.Error.Exception){
            // TODO: Show Error Message.
        }
    }

    public void onStart() {
        super.onStart();
        if (this.getDialog() != null) {
            Window window = this.getDialog().getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(android.R.color.transparent);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = requireActivity().getWindowManager();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels - 80;
            if (window != null) {
                window.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}