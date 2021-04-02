package com.zedan.acare.supervisor.ui.tasks;

import com.zedan.acare.supervisor.ui.tasks.TasksViewModel_HiltModules;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class TasksViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static TasksViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(TasksViewModel_HiltModules.KeyModule.provide());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TasksViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new TasksViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
