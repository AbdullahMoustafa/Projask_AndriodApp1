package com.zedan.acare.supervisor.ui.tasks;

import com.zedan.acare.supervisor.domain.profile.UserInfoBasicUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class TasksViewModel_Factory implements Factory<TasksViewModel> {
    private final Provider<UserInfoBasicUseCase> basicUserInfoProvider;

    public TasksViewModel_Factory(Provider<UserInfoBasicUseCase> basicUserInfoProvider2) {
        this.basicUserInfoProvider = basicUserInfoProvider2;
    }

    public TasksViewModel get() {
        return newInstance(this.basicUserInfoProvider.get());
    }

    public static TasksViewModel_Factory create(Provider<UserInfoBasicUseCase> basicUserInfoProvider2) {
        return new TasksViewModel_Factory(basicUserInfoProvider2);
    }

    public static TasksViewModel newInstance(UserInfoBasicUseCase basicUserInfo) {
        return new TasksViewModel(basicUserInfo);
    }
}
