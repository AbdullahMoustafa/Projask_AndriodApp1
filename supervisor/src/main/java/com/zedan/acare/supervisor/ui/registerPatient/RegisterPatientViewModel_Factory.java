package com.zedan.acare.supervisor.ui.registerPatient;

import com.zedan.acare.supervisor.domain.auth.RegisterPatientUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RegisterPatientViewModel_Factory implements Factory<RegisterPatientViewModel> {
    private final Provider<RegisterPatientUseCase> registerPatientUseCaseProvider;

    public RegisterPatientViewModel_Factory(Provider<RegisterPatientUseCase> registerPatientUseCaseProvider2) {
        this.registerPatientUseCaseProvider = registerPatientUseCaseProvider2;
    }

    public RegisterPatientViewModel get() {
        return newInstance(this.registerPatientUseCaseProvider.get());
    }

    public static RegisterPatientViewModel_Factory create(Provider<RegisterPatientUseCase> registerPatientUseCaseProvider2) {
        return new RegisterPatientViewModel_Factory(registerPatientUseCaseProvider2);
    }

    public static RegisterPatientViewModel newInstance(RegisterPatientUseCase registerPatientUseCase) {
        return new RegisterPatientViewModel(registerPatientUseCase);
    }
}
