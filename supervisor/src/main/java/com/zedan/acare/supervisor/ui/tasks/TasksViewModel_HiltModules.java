package com.zedan.acare.supervisor.ui.tasks;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

public final class TasksViewModel_HiltModules {

    @Module
    public static abstract class BindsModule {
        @IntoMap
        @Binds
        @StringKey("com.zedan.acare.supervisor.ui.tasks.TasksViewModel")
        public abstract ViewModel binds(TasksViewModel tasksViewModel);
    }

    private TasksViewModel_HiltModules() {
    }

    @Module
    public static final class KeyModule {
        private KeyModule() {
        }

        @IntoSet
        @Provides
        public static String provide() {
            return "com.zedan.acare.supervisor.ui.tasks.TasksViewModel";
        }
    }
}
