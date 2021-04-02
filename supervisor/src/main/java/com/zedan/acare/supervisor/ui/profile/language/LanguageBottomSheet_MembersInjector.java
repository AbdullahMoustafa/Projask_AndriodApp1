package com.zedan.acare.supervisor.ui.profile.language;

import com.zedan.acare.common.local.C0009LocalSharedPreference;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LanguageBottomSheet_MembersInjector implements MembersInjector<LanguageBottomSheet> {
    private final Provider<C0009LocalSharedPreference> preferenceProvider;

    public LanguageBottomSheet_MembersInjector(Provider<C0009LocalSharedPreference> preferenceProvider2) {
        this.preferenceProvider = preferenceProvider2;
    }

    public static MembersInjector<LanguageBottomSheet> create(Provider<C0009LocalSharedPreference> preferenceProvider2) {
        return new LanguageBottomSheet_MembersInjector(preferenceProvider2);
    }

    public void injectMembers(LanguageBottomSheet instance) {
        injectPreference(instance, this.preferenceProvider.get());
    }

    public static void injectPreference(LanguageBottomSheet instance, C0009LocalSharedPreference preference) {
        instance.preference = preference;
    }
}
