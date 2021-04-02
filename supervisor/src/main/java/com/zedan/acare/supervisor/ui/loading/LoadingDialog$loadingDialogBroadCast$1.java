package com.zedan.acare.supervisor.ui.loading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/zedan/acare/supervisor/ui/loading/LoadingDialog$loadingDialogBroadCast$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoadingDialog.kt */
public final class LoadingDialog$loadingDialogBroadCast$1 extends BroadcastReceiver {
    final /* synthetic */ LoadingDialog this$0;

    LoadingDialog$loadingDialogBroadCast$1(LoadingDialog this$02) {
        this.this$0 = this$02;
    }

    public void onReceive(Context context, Intent intent) {
        Timber.e("onReceive: Called.", new Object[0]);
        if (Intrinsics.areEqual((Object) intent != null ? intent.getAction() : null, (Object) LoadingDialog.LOCAL_ACTION)) {
            this.this$0.dismiss();
        }
    }
}
