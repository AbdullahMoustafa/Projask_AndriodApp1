package com.zedan.acare.supervisor.ui.messageDialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavArgsLazy;
import com.zedan.acare.supervisor.R;
import com.zedan.acare.supervisor.databinding.MessageDialogsBinding;
import com.zedan.acare.supervisor.extension.NavigationExtensionKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageDialogs;", "Landroidx/fragment/app/DialogFragment;", "()V", "args", "Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageDialogsArgs;", "getArgs", "()Lcom/zedan/acare/supervisor/ui/messageDialogs/MessageDialogsArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "onStart", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: MessageDialogs.kt */
public final class MessageDialogs extends Hilt_MessageDialogs {
    private final NavArgsLazy args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(MessageDialogsArgs.class), new MessageDialogs$$special$$inlined$navArgs$1(this));

    private final MessageDialogsArgs getArgs() {
        return (MessageDialogsArgs) this.args$delegate.getValue();
    }

    public MessageDialogs() {
        super(R.layout.message_dialogs);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MessageDialogsBinding binding = MessageDialogsBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(binding, "MessageDialogsBinding.bind(view)");
        AppCompatImageView appCompatImageView = binding.icEsc;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.icEsc");
        NavigationExtensionKt.back((View) appCompatImageView, (Fragment) this);
        binding.ic.setImageResource(getArgs().getMessage().getIcon());
        AppCompatTextView appCompatTextView = binding.message;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "binding.message");
        appCompatTextView.setText(getArgs().getMessage().getMessage());
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            WindowManager windowManager = requireActivity.getWindowManager();
            Intrinsics.checkNotNullExpressionValue(windowManager, "requireActivity().windowManager");
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels - 80;
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setLayout(width, -2);
            }
        }
    }
}
