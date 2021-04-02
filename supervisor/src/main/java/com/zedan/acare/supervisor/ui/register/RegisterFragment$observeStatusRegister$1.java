package com.zedan.acare.supervisor.ui.register;

import androidx.lifecycle.Observer;
import com.zedan.acare.supervisor.domain.auth.RegisterResult;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "s", "Lcom/zedan/acare/supervisor/domain/auth/RegisterResult;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 2})
/* compiled from: RegisterFragment.kt */
final class RegisterFragment$observeStatusRegister$1<T> implements Observer<RegisterResult> {
    final /* synthetic */ RegisterFragment this$0;

    RegisterFragment$observeStatusRegister$1(RegisterFragment registerFragment) {
        this.this$0 = registerFragment;
    }

    public final void onChanged(RegisterResult s) {
        if (s instanceof RegisterResult.Loading) {
            this.this$0.onLoading();
        } else if (s instanceof RegisterResult.Success) {
            this.this$0.onSuccess();
        } else if (s instanceof RegisterResult.Error) {
            this.this$0.onError((RegisterResult.Error) s);
        }
    }
}
