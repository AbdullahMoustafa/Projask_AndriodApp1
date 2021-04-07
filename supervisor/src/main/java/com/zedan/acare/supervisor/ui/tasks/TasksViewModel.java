package com.zedan.acare.supervisor.ui.tasks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.zedan.acare.supervisor.domain.None;
import com.zedan.acare.supervisor.domain.profile.UserDataBasic;
import com.zedan.acare.supervisor.domain.profile.UserInfoBasicUseCase;
import com.zedan.acare.supervisor.domain.tasks.AddTaskParam;
import com.zedan.acare.supervisor.domain.tasks.GetTasksResult;
import com.zedan.acare.supervisor.domain.tasks.GetTasksUseCase;
import com.zedan.acare.supervisor.domain.tasks.TaskEntity;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public final class TasksViewModel extends ViewModel {

    private final MutableLiveData<UserDataBasic> userInfo = new MutableLiveData<>();

    private final MutableLiveData<GetTasksResult> taskResult = new MutableLiveData<>();

    private final CompositeDisposable disposable = new CompositeDisposable();

    private final UserInfoBasicUseCase basicUserInfo;

    private final GetTasksUseCase getTasksUseCase;

    @Inject
    public TasksViewModel(
            UserInfoBasicUseCase basicUserInfo,
            GetTasksUseCase getTasksUseCase
    ) {
        this.basicUserInfo = basicUserInfo;
        this.getTasksUseCase = getTasksUseCase;
        fetchUserInfo();
        fetchTasks();
    }

    private void fetchUserInfo(){
        Disposable d = basicUserInfo
                .execute(new None())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);

        disposable.add(d);
    }

    private void onSuccess(UserDataBasic data){
        userInfo.postValue(data);
    }

    private void onError(Throwable throwable){
        throwable.printStackTrace();
    }

    public final LiveData<UserDataBasic> getUserInfo() {
        return this.userInfo;
    }


    private void fetchTasks(){
        Disposable d = getTasksUseCase
                .execute(new None())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onErrorTaskResult);
        disposable.add(d);
    }

    private void onSuccess(GetTasksResult tasksResult){
        this.taskResult.postValue(tasksResult);
    }

    private void onErrorTaskResult(Throwable throwable){
        this.taskResult.postValue(new GetTasksResult.Error(throwable));
    }

    public LiveData<GetTasksResult> getTaskResult() {
        return taskResult;
    }

    public LiveData<Boolean> taskIsLoading(){
        return Transformations.map(getTaskResult(), r -> r instanceof GetTasksResult.Loading);
    }

    public LiveData<List<TaskEntity>> taskData(){
        return Transformations.map(getTaskResult(), r -> {
            if (r instanceof GetTasksResult.Success){
                return ((GetTasksResult.Success) r).getTasks();
            } else {
                return null;
            }
        });
    }

    public LiveData<GetTasksResult.Error> errorTask(){
        return Transformations.map(getTaskResult(), r -> {
            if (r instanceof GetTasksResult.Error){
                return ((GetTasksResult.Error) r);
            } else {
                return null;
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
