package com.zedan.acare.supervisor.ui.register;

import android.widget.TextView;
import com.github.razir.progressbutton.DrawableButtonExtensionsKt;
import com.google.android.material.button.MaterialButton;
import com.zedan.acare.supervisor.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: RegisterFragment.kt */
final class RegisterFragment$registerBtnRunnable$1 implements Runnable {
    final /* synthetic */ RegisterFragment this$0;

    RegisterFragment$registerBtnRunnable$1(RegisterFragment registerFragment) {
        this.this$0 = registerFragment;
    }

    public final void run() {
        MaterialButton materialButton = RegisterFragment.access$getBinding$p(this.this$0).registerBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.registerBtn");
        DrawableButtonExtensionsKt.hideProgress((TextView) materialButton, (int) R.string.register);
    }
}
