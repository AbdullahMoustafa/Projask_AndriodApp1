package com.zedan.acare.supervisor.ui.register;

import com.zedan.acare.supervisor.ui.register.RegisterViewModel_HiltModules;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RegisterViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static RegisterViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(RegisterViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RegisterViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new RegisterViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
