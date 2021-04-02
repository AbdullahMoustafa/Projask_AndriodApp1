package com.zedan.acare.supervisor.di;

import android.content.Context;

import com.zedan.acare.common.local.LocalSharedPreference;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class LocalShared {

    @Singleton
    @Provides
    public static LocalSharedPreference provideLocalPreference(
            @ApplicationContext Context applicationContext
    ){
        return new LocalSharedPreference(
                applicationContext
                        .getSharedPreferences(
                                BuildConfig.APPLICATION_ID + ".local.shared",
                                Context.MODE_PRIVATE
                        )
        );
    }
}
