package com.zedan.acare.supervisor.ui.login;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

public final class LoginViewModel_HiltModules {

    @Module
    public static abstract class BindsModule {
        @IntoMap
        @Binds
        @StringKey("com.zedan.acare.supervisor.ui.login.LoginViewModel")
        public abstract ViewModel binds(LoginViewModel loginViewModel);
    }

    private LoginViewModel_HiltModules() {
    }

    @Module
    public static final class KeyModule {
        private KeyModule() {
        }

        @IntoSet
        @Provides
        public static String provide() {
            return "com.zedan.acare.supervisor.ui.login.LoginViewModel";
        }
    }
}
