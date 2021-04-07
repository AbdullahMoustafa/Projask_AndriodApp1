package com.zedan.acare.supervisor.ui.messageDialogs;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

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
                window.setLayout(width, -2);
            }
        }
    }
}
