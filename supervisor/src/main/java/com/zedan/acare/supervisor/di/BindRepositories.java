package com.zedan.acare.supervisor.di;

import com.zedan.acare.supervisor.data.auth.AuthRepositoryImpl;
import com.zedan.acare.supervisor.data.home.HomeRepositoryImpl;
import com.zedan.acare.supervisor.data.profile.ProfileRepositoryImpl;
import com.zedan.acare.supervisor.data.tasks.TasksRepositoryImpl;
import com.zedan.acare.supervisor.domain.auth.AuthRepository;
import com.zedan.acare.supervisor.domain.home.HomeRepository;
import com.zedan.acare.supervisor.domain.profile.ProfileRepository;
import com.zedan.acare.supervisor.domain.tasks.TaskRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public abstract class BindRepositories {

    @Singleton
    @Binds
    public abstract AuthRepository bindAuthRepo(AuthRepositoryImpl authRepositoryImpl);

    @Singleton
    @Binds
    public abstract HomeRepository bindHomeRepo(HomeRepositoryImpl homeRepositoryImpl);

    @Singleton
    @Binds
    public abstract TaskRepository bindTaskRepository(TasksRepositoryImpl tasksRepositoryImpl);

    @Singleton
    @Binds
    public abstract ProfileRepository bindProfileRepository(ProfileRepositoryImpl profileRepositoryImpl);
}
