package com.zedan.acare.supervisor.ui.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.auth.RegisterResult;
import com.zedan.acare.supervisor.domain.auth.RegisterUseCase;
import com.zedan.acare.supervisor.utils.SingleLiveEvent;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public final class RegisterViewModel extends ViewModel {

    private final SingleLiveEvent<RegisterNavigation> navigation = new SingleLiveEvent<>();

    private final SingleLiveEvent<RegisterResult> registerResult = new SingleLiveEvent<>();

    private final CompositeDisposable registerDisable = new CompositeDisposable();

    private String imagePath;

    public final RegisterUseCase registerUseCase;

    @Inject
    public RegisterViewModel(RegisterUseCase registerUseCase) {
        this.registerUseCase = registerUseCase;
    }

    public final void navigationHandler(RegisterNavigation navigation) {
        this.navigation.postValue(navigation);
        cancelRegister();
    }

    public final void register(
            String fullName,
            String phone,
            String email,
            String password,
            String kinship,
            String address,
            String country
    ) {
        Disposable d = registerUseCase.execute(
                new RegisterParam(
                        fullName,
                        phone,
                        email,
                        password,
                        kinship,
                        address,
                        country,
                        imagePath,
                        false,
                        ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
        registerDisable.add(d);
    }

    private void onSuccess(RegisterResult result) {
        registerResult.postValue(result);
    }

    private void onError(Throwable error) {
        registerResult.postValue(new RegisterResult.Error.Exception(error));
    }

    public final LiveData<RegisterNavigation> getNavigation() {
        return this.navigation;
    }

    public final LiveData<RegisterResult> getRegisterResult() {
        return this.registerResult;
    }

    public final String getImagePath() {
        return this.imagePath;
    }

    public final void setImagePath(String str) {
        this.imagePath = str;
    }

    private void cancelRegister() {
        registerDisable.dispose();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        cancelRegister();
    }
}
