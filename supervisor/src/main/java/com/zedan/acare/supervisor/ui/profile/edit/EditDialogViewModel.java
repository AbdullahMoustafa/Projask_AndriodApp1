package com.zedan.acare.supervisor.ui.profile.edit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zedan.acare.supervisor.domain.profile.EditInputParam;
import com.zedan.acare.supervisor.domain.profile.EditInputResult;
import com.zedan.acare.supervisor.domain.profile.EditInputUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public class EditDialogViewModel extends ViewModel {

    private final MutableLiveData<EditInputResult> result = new MutableLiveData<>();

    private final CompositeDisposable disposable = new CompositeDisposable();

    private final EditInputUseCase useCase;

    @Inject
    public EditDialogViewModel(EditInputUseCase useCase){
        super();
        this.useCase = useCase;
    }

    void editInput(EditInputParam param){
        Disposable d = useCase
                .execute(param)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        disposable.add(d);
    }

    private void onSuccess(EditInputResult result){
        this.result.postValue(result);
    }

    private void onError(Throwable throwable){
        this.result.postValue(new EditInputResult.Error.Exception(throwable));
    }

    public LiveData<EditInputResult> getResult() {
        return result;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}