package com.zedan.acare.supervisor.ui.profile;

import com.google.firebase.auth.FirebaseAuth;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ProfileFragment_MembersInjector implements MembersInjector<ProfileFragment> {
    private final Provider<FirebaseAuth> authProvider;

    public ProfileFragment_MembersInjector(Provider<FirebaseAuth> authProvider2) {
        this.authProvider = authProvider2;
    }

    public static MembersInjector<ProfileFragment> create(Provider<FirebaseAuth> authProvider2) {
        return new ProfileFragment_MembersInjector(authProvider2);
    }

    public void injectMembers(ProfileFragment instance) {
        injectAuth(instance, this.authProvider.get());
    }

    public static void injectAuth(ProfileFragment instance, FirebaseAuth auth) {
        instance.auth = auth;
    }
}
