package com.zedan.acare.supervisor.ui.registerPatient;

import android.widget.TextView;
import com.github.razir.progressbutton.DrawableButtonExtensionsKt;
import com.google.android.material.button.MaterialButton;
import com.zedan.acare.supervisor.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: RegisterPatientFragment.kt */
final class RegisterPatientFragment$saveBtnCallback$1 implements Runnable {
    final /* synthetic */ RegisterPatientFragment this$0;

    RegisterPatientFragment$saveBtnCallback$1(RegisterPatientFragment registerPatientFragment) {
        this.this$0 = registerPatientFragment;
    }

    public final void run() {
        MaterialButton materialButton = RegisterPatientFragment.access$getBinding$p(this.this$0).saveDataBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.saveDataBtn");
        DrawableButtonExtensionsKt.hideProgress((TextView) materialButton, (int) R.string.login);
    }
}
