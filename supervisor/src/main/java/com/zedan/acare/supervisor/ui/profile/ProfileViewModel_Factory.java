package com.zedan.acare.supervisor.ui.profile;

import com.zedan.acare.supervisor.domain.profile.ProfileUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
    private final Provider<ProfileUseCase> profileUseCaseProvider;

    public ProfileViewModel_Factory(Provider<ProfileUseCase> profileUseCaseProvider2) {
        this.profileUseCaseProvider = profileUseCaseProvider2;
    }

    public ProfileViewModel get() {
        return newInstance(this.profileUseCaseProvider.get());
    }

    public static ProfileViewModel_Factory create(Provider<ProfileUseCase> profileUseCaseProvider2) {
        return new ProfileViewModel_Factory(profileUseCaseProvider2);
    }

    public static ProfileViewModel newInstance(ProfileUseCase profileUseCase) {
        return new ProfileViewModel(profileUseCase);
    }
}
