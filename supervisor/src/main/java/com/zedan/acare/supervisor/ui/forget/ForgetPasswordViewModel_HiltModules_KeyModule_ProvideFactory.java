package com.zedan.acare.supervisor.ui.forget;

import com.zedan.acare.supervisor.ui.forget.ForgetPasswordViewModel_HiltModules;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ForgetPasswordViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static ForgetPasswordViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(ForgetPasswordViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ForgetPasswordViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ForgetPasswordViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
