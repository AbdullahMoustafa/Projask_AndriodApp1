package com.zedan.acare.supervisor.ui.addTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zedan.acare.supervisor.domain.tasks.AddTaskParam;
import com.zedan.acare.supervisor.domain.tasks.AddTaskResult;
import com.zedan.acare.supervisor.domain.tasks.AddTaskUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public final class AddTaskViewModel extends ViewModel {

    private final MutableLiveData<AddTaskResult> statusAddTask = new MutableLiveData<>(AddTaskResult.None.NONE);

    private final CompositeDisposable disposable = new CompositeDisposable();
    private final AddTaskUseCase addTaskUseCase;
    private int selectedColor = -1;

    @Inject
    public AddTaskViewModel(AddTaskUseCase addTaskUseCase) {
        this.addTaskUseCase = addTaskUseCase;
    }

    public final LiveData<AddTaskResult> getStatusAddTask() {
        return this.statusAddTask;
    }

    public final void setSelectedColor(int i) {
        this.selectedColor = i;
    }

    public final void addNewTask(String title, String desc, String startDate, String startHour, String endDate, String endHour) {
        Disposable d = addTaskUseCase
                .execute(new AddTaskParam(
                        title, desc, startDate + "-" + startHour, endDate + "-" + endHour,
                        startDate, startHour, endDate, endHour, this.selectedColor
                ))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        disposable.add(d);
    }

    private void onSuccess(AddTaskResult result){
        statusAddTask.postValue(result);
    }

    private void onError(Throwable throwable){
        statusAddTask.postValue(new AddTaskResult.Error.Exception(throwable));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
