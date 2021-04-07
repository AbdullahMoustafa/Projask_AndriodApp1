package com.zedan.acare.supervisor.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.zedan.acare.supervisor.domain.None;
import com.zedan.acare.supervisor.domain.home.FillPatientResult;
import com.zedan.acare.supervisor.domain.home.HasFillPatientUseCase;
import com.zedan.acare.supervisor.utils.SingleLiveEvent;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public final class HomeViewModel extends ViewModel {

    private final SingleLiveEvent<FillPatientResult> statusFill = new SingleLiveEvent<>(FillPatientResult.Loading.LOADING);

    private final HasFillPatientUseCase useCase;

    private final CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public HomeViewModel(HasFillPatientUseCase useCase) {
        this.useCase = useCase;
        checkFillPatient();
    }

    public final LiveData<FillPatientResult> getStatusFill() {
        return this.statusFill;
    }

    public final void checkFillPatient() {
        Disposable d = useCase
                .execute(new None())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        disposable.add(d);
    }

    private void onSuccess(FillPatientResult result){
        statusFill.postValue(result);
    }

    private void onError(Throwable throwable){
        statusFill.postValue(new FillPatientResult.Error(throwable));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
