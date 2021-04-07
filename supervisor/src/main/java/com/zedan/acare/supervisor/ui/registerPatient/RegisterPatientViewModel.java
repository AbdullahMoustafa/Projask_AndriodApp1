package com.zedan.acare.supervisor.ui.registerPatient;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientResult;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public final class RegisterPatientViewModel extends ViewModel {

    private final MutableLiveData<RegisterPatientResult> statusRegister =
            new MutableLiveData<>(RegisterPatientResult.None.NONE);

    private final CompositeDisposable disposable = new CompositeDisposable();

    public final RegisterPatientUseCase registerPatientUseCase;

    @Inject
    public RegisterPatientViewModel(RegisterPatientUseCase registerPatientUseCase) {
        this.registerPatientUseCase = registerPatientUseCase;
    }

    public final void registerPatient(String name, String mobile, String password, String age, String homeLocation, String status, String statusType, String country) {
        Disposable d = registerPatientUseCase
                .execute(new RegisterPatientParam(
                        name, mobile, password, age,
                        homeLocation, status, statusType, country
                ))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        this.disposable.add(d);
    }

    private void onSuccess(RegisterPatientResult result){
        this.statusRegister.postValue(result);
    }

    private void onError(Throwable throwable){
        this.statusRegister.postValue(new RegisterPatientResult.Error.Exception(throwable));
    }

    public final LiveData<RegisterPatientResult> getStatusRegister() {
        return this.statusRegister;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
