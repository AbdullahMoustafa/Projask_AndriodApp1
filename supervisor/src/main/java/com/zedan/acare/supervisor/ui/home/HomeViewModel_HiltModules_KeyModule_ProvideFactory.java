package com.zedan.acare.supervisor.ui.home;

import com.zedan.acare.supervisor.ui.home.HomeViewModel_HiltModules;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class HomeViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static HomeViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(HomeViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HomeViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new HomeViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
