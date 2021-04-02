package com.zedan.acare.supervisor.utils;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b¨\u0006\t"}, d2 = {"showToast", "", "Landroid/content/Context;", "message", "", "type", "Lcom/zedan/acare/supervisor/utils/ToastType;", "onDone", "Lkotlin/Function0;", "supervisor_debug"}, k = 2, mv = {1, 4, 2})
/* compiled from: Toast.kt */
public final class ToastKt {
    public static /* synthetic */ void showToast$default(Context context, String str, ToastType toastType, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = ToastKt$showToast$1.INSTANCE;
        }
        showToast(context, str, toastType, function0);
    }

    public static final void showToast(Context $this$showToast, String message, ToastType type, Function0<Unit> onDone) {
        Intrinsics.checkNotNullParameter($this$showToast, "$this$showToast");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        Toast.makeText($this$showToast, message, 0).show();
    }
}
