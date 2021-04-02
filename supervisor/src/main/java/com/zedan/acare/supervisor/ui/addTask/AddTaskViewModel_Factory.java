package com.zedan.acare.supervisor.ui.addTask;

import com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AddTaskViewModel_Factory implements Factory<AddTaskViewModel> {
    private final Provider<AddTaskUseCase> addTaskUseCaseProvider;

    public AddTaskViewModel_Factory(Provider<AddTaskUseCase> addTaskUseCaseProvider2) {
        this.addTaskUseCaseProvider = addTaskUseCaseProvider2;
    }

    public AddTaskViewModel get() {
        return newInstance(this.addTaskUseCaseProvider.get());
    }

    public static AddTaskViewModel_Factory create(Provider<AddTaskUseCase> addTaskUseCaseProvider2) {
        return new AddTaskViewModel_Factory(addTaskUseCaseProvider2);
    }

    public static AddTaskViewModel newInstance(AddTaskUseCase addTaskUseCase) {
        return new AddTaskViewModel(addTaskUseCase);
    }
}
