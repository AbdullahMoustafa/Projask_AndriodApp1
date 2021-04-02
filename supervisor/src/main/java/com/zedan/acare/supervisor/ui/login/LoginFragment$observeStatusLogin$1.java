package com.zedan.acare.supervisor.ui.login;

import androidx.lifecycle.Observer;
import com.zedan.acare.supervisor.domain.auth.LoginStatus;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "s", "Lcom/zedan/acare/supervisor/domain/auth/LoginStatus;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: LoginFragment.kt */
final class LoginFragment$observeStatusLogin$1<T> implements Observer<LoginStatus> {
    final /* synthetic */ LoginFragment this$0;

    LoginFragment$observeStatusLogin$1(LoginFragment loginFragment) {
        this.this$0 = loginFragment;
    }

    public final void onChanged(LoginStatus s) {
        if (s instanceof LoginStatus.Loading) {
            this.this$0.onLoading();
        } else if (s instanceof LoginStatus.Success) {
            this.this$0.onSuccess();
        } else if (s instanceof LoginStatus.Error) {
            this.this$0.onError((LoginStatus.Error) s);
        }
    }
}
