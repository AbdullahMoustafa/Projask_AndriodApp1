package com.zedan.acare.common.local;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LocalSharedPreference {
    private final SharedPreferences sharedPreferences;

    public LocalSharedPreference(@NonNull SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences2;
    }

    public final void setString(@NonNull KeyString key, @Nullable String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key.getKey(), value);
        editor.apply();
    }

    @Nullable
    public final String getString(@NonNull KeyString key) {
        return this.sharedPreferences.getString(key.getKey(), null);
    }

    public final void setBoolean(@NonNull KeyBoolean key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key.getKey(), value);
        editor.apply();

    }

    public final boolean getBoolean(@NonNull KeyBoolean key) {
        return this.sharedPreferences.getBoolean(key.getKey(), false);
    }
}
