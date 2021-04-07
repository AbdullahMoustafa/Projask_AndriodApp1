package com.zedan.acare.supervisor.ui.messageDialogs;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.Navigation;

import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.MessageDialogsBinding;

import org.jetbrains.annotations.NotNull;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class MessageDialogs extends DialogFragment {

    public MessageDialogs() {
        super(R.layout.message_dialogs);
    }

    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MessageDialogsBinding binding = MessageDialogsBinding.bind(view);

        Navigation
                .findNavController(binding.getRoot())
                .popBackStack();
        // TODO: Pass Args To Views

    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null){
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            int width = (int) (((double) requireActivity().getResources()
                    .getDisplayMetrics().widthPixels) * 0.9d);
            getDialog().getWindow()
                    .setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
