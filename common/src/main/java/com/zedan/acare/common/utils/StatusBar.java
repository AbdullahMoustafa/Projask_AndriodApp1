package com.zedan.acare.common.utils;

import android.view.Window;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.zedan.acare.common.R;

public final class StatusBar {
    
    public static void statusColor(@NonNull Fragment fragment, int color) {
        FragmentActivity requireActivity = fragment.requireActivity();
        Window window = requireActivity.getWindow();
        window.setStatusBarColor(color);
    }

    public static void setStatusAsPrimary(@NonNull Fragment fragment) {
        statusColor(fragment, ContextCompat.getColor(fragment.requireContext(), R.color.azul));
    }

    public static void setStatusAsWhite(@NonNull Fragment fragment) {
        statusColor(fragment, ContextCompat.getColor(fragment.requireContext(), R.color.white));
    }
}
