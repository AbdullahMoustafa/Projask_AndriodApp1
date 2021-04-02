package com.zedan.acare.supervisor.ui.loading;

import android.app.Dialog;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zedan.acare.supervisor.R;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/zedan/acare/supervisor/ui/loading/LoadingDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "loadingDialogBroadCast", "com/zedan/acare/supervisor/ui/loading/LoadingDialog$loadingDialogBroadCast$1", "Lcom/zedan/acare/supervisor/ui/loading/LoadingDialog$loadingDialogBroadCast$1;", "onStart", "", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
@AndroidEntryPoint
/* compiled from: LoadingDialog.kt */
public final class LoadingDialog extends Hilt_LoadingDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOCAL_ACTION = "com.zedan.acare.supervisor.LoadingDialog";
    private final LoadingDialog$loadingDialogBroadCast$1 loadingDialogBroadCast = new LoadingDialog$loadingDialogBroadCast$1(this);

    public LoadingDialog() {
        super(R.layout.loading_dialog);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setCancelable(false);
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawableResource(17170445);
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        IntentFilter $this$apply = new IntentFilter();
        $this$apply.addAction(LOCAL_ACTION);
        Unit unit = Unit.INSTANCE;
        LocalBroadcastManager.getInstance(requireActivity.getApplicationContext()).registerReceiver(this.loadingDialogBroadCast, $this$apply);
    }

    public void onStop() {
        super.onStop();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        LocalBroadcastManager.getInstance(requireActivity.getApplicationContext()).unregisterReceiver(this.loadingDialogBroadCast);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/zedan/acare/supervisor/ui/loading/LoadingDialog$Companion;", "", "()V", "LOCAL_ACTION", "", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LoadingDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
