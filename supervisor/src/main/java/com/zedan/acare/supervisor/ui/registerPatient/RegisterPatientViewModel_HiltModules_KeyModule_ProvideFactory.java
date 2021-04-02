package com.zedan.acare.supervisor.ui.registerPatient;

import com.zedan.acare.supervisor.ui.registerPatient.RegisterPatientViewModel_HiltModules;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RegisterPatientViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static RegisterPatientViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(RegisterPatientViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RegisterPatientViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new RegisterPatientViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
