package com.zedan.acare.supervisor.ui.register;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

public final class RegisterViewModel_HiltModules {

    @Module
    public static abstract class BindsModule {
        @IntoMap
        @Binds
        @StringKey("com.zedan.acare.supervisor.ui.register.RegisterViewModel")
        public abstract ViewModel binds(RegisterViewModel registerViewModel);
    }

    private RegisterViewModel_HiltModules() {
    }

    @Module
    public static final class KeyModule {
        private KeyModule() {
        }

        @IntoSet
        @Provides
        public static String provide() {
            return "com.zedan.acare.supervisor.ui.register.RegisterViewModel";
        }
    }
}
