package com.zedan.acare.supervisor.ui.login;

import com.zedan.acare.supervisor.ui.login.LoginViewModel_HiltModules;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class LoginViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static LoginViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(LoginViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LoginViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new LoginViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
