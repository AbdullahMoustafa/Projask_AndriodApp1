package com.zedan.acare.supervisor.ui.login;

import android.widget.TextView;
import com.github.razir.progressbutton.DrawableButtonExtensionsKt;
import com.google.android.material.button.MaterialButton;
import com.zedan.acare.supervisor.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: LoginFragment.kt */
final class LoginFragment$loginBtnCallback$1 implements Runnable {
    final /* synthetic */ LoginFragment this$0;

    LoginFragment$loginBtnCallback$1(LoginFragment loginFragment) {
        this.this$0 = loginFragment;
    }

    public final void run() {
        MaterialButton materialButton = LoginFragment.access$getBinding$p(this.this$0).loginBtn;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.loginBtn");
        DrawableButtonExtensionsKt.hideProgress((TextView) materialButton, (int) R.string.login);
    }
}
