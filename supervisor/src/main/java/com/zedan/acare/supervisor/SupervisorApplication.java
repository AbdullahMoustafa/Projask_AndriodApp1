package com.zedan.acare.supervisor;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

@HiltAndroidApp
public class SupervisorApplication extends Application {

    public void onCreate() {
        super.onCreate();
        initTimber();
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
