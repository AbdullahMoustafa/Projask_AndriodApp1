package com.zedan.acare.supervisor.ui.profile;

import com.zedan.acare.supervisor.ui.profile.ProfileViewModel_HiltModules;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ProfileViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static ProfileViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(ProfileViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProfileViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ProfileViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
