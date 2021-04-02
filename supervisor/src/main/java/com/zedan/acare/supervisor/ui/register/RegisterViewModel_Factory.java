package com.zedan.acare.supervisor.ui.register;

import com.zedan.acare.supervisor.domain.auth.RegisterUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RegisterViewModel_Factory implements Factory<RegisterViewModel> {
    private final Provider<RegisterUseCase> registerUseCaseProvider;

    public RegisterViewModel_Factory(Provider<RegisterUseCase> registerUseCaseProvider2) {
        this.registerUseCaseProvider = registerUseCaseProvider2;
    }

    public RegisterViewModel get() {
        return newInstance(this.registerUseCaseProvider.get());
    }

    public static RegisterViewModel_Factory create(Provider<RegisterUseCase> registerUseCaseProvider2) {
        return new RegisterViewModel_Factory(registerUseCaseProvider2);
    }

    public static RegisterViewModel newInstance(RegisterUseCase registerUseCase) {
        return new RegisterViewModel(registerUseCase);
    }
}
