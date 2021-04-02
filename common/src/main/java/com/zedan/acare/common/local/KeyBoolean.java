package com.zedan.acare.common.local;

import androidx.annotation.NonNull;


public enum KeyBoolean {
    ;
    @NonNull
    private final String key;

    private KeyBoolean(@NonNull String key2) {
        this.key = key2;
    }

    @NonNull
    public final String getKey() {
        return this.key;
    }
}