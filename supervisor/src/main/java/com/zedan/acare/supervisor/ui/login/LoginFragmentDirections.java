package com.zedan.acare.supervisor.ui.login;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.zedan.acare.supervisor.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/zedan/acare/supervisor/ui/login/LoginFragmentDirections;", "", "()V", "Companion", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: LoginFragmentDirections.kt */
public final class LoginFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/zedan/acare/supervisor/ui/login/LoginFragmentDirections$Companion;", "", "()V", "actionLoginFragmentToForgetPasswordFragment", "Landroidx/navigation/NavDirections;", "actionLoginFragmentToLanguageNav", "actionLoginFragmentToRegisterFragment", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LoginFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final NavDirections actionLoginFragmentToForgetPasswordFragment() {
            return new ActionOnlyNavDirections(R.id.action_loginFragment_to_forgetPasswordFragment);
        }

        public final NavDirections actionLoginFragmentToRegisterFragment() {
            return new ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment);
        }

        public final NavDirections actionLoginFragmentToLanguageNav() {
            return new ActionOnlyNavDirections(R.id.action_loginFragment_to_language_nav);
        }
    }

    private LoginFragmentDirections() {
    }
}
