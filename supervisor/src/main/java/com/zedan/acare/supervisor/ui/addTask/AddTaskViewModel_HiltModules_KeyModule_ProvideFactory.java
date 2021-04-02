package com.zedan.acare.supervisor.ui.addTask;

import com.zedan.acare.supervisor.ui.addTask.AddTaskViewModel_HiltModules;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AddTaskViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static AddTaskViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(AddTaskViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AddTaskViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AddTaskViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
