package com.zedan.acare.supervisor.ui.loading;

import android.app.Dialog;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zedan.acare.supervisor.R;

import org.jetbrains.annotations.NotNull;

import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@AndroidEntryPoint
public final class LoadingDialog extends DialogFragment {

    public static final String LOCAL_ACTION = "com.zedan.acare.supervisor.LoadingDialog";

    public LoadingDialog() {
        super(R.layout.loading_dialog);
    }

    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setCancelable(false);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        Window window;
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }


    public void onStop() {
        super.onStop();
    }
}
