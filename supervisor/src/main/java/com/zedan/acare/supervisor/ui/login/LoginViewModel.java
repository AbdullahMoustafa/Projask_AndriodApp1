package com.zedan.acare.supervisor.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavDirections;

import com.zedan.acare.supervisor.domain.auth.LoginParam;
import com.zedan.acare.supervisor.domain.auth.LoginStatus;
import com.zedan.acare.supervisor.domain.auth.LoginUseCase;
import com.zedan.acare.supervisor.utils.SingleLiveEvent;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public final class LoginViewModel extends ViewModel {

    private final SingleLiveEvent<NavDirections> _navigation = new SingleLiveEvent<>();

    private final SingleLiveEvent<LoginStatus> _statusLogin = new SingleLiveEvent<>();

    private final LoginUseCase useCase;

    private final CompositeDisposable loginDisable = new CompositeDisposable();

    @Inject
    public LoginViewModel(LoginUseCase useCase) {
        this.useCase = useCase;
    }


    public final void forgetPassword() {
        _navigation.postValue(LoginFragmentDirections.actionLoginFragmentToForgetPasswordFragment());
    }

    public final void signUp() {
        _navigation.postValue(LoginFragmentDirections.actionLoginFragmentToRegisterFragment());
    }


    public void login(
            String email,
            String password
    ){
        Disposable d = useCase.execute(new LoginParam(email, password))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onNext, this::onError);

        loginDisable.add(d);
    }

    private void onNext(LoginStatus status){
        _statusLogin.postValue(status);
    }

    private void onError(Throwable throwable){
        _statusLogin.postValue(new LoginStatus.Error.Exception(throwable));
    }

    public LiveData<LoginStatus> getStatusLogin() {
        return _statusLogin;
    }

    public LiveData<NavDirections> getNavigation() {
        return _navigation;
    }

    public void onCleared() {
        super.onCleared();
        loginCancel();
    }

    private void loginCancel() {
        loginDisable.clear();
    }
}
