package com.zedan.acare.supervisor.ui.home;

import com.zedan.acare.supervisor.domain.home.HasFillPatientUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
    private final Provider<HasFillPatientUseCase> useCaseProvider;

    public HomeViewModel_Factory(Provider<HasFillPatientUseCase> useCaseProvider2) {
        this.useCaseProvider = useCaseProvider2;
    }

    public HomeViewModel get() {
        return newInstance(this.useCaseProvider.get());
    }

    public static HomeViewModel_Factory create(Provider<HasFillPatientUseCase> useCaseProvider2) {
        return new HomeViewModel_Factory(useCaseProvider2);
    }

    public static HomeViewModel newInstance(HasFillPatientUseCase useCase) {
        return new HomeViewModel(useCase);
    }
}
