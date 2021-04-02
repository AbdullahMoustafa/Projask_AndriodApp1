package com.zedan.acare.supervisor.ui.login;

import com.zedan.acare.supervisor.domain.auth.LoginUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
    private final Provider<LoginUseCase> useCaseProvider;

    public LoginViewModel_Factory(Provider<LoginUseCase> useCaseProvider2) {
        this.useCaseProvider = useCaseProvider2;
    }

    public LoginViewModel get() {
        return newInstance(this.useCaseProvider.get());
    }

    public static LoginViewModel_Factory create(Provider<LoginUseCase> useCaseProvider2) {
        return new LoginViewModel_Factory(useCaseProvider2);
    }

    public static LoginViewModel newInstance(LoginUseCase useCase) {
        return new LoginViewModel(useCase);
    }
}
