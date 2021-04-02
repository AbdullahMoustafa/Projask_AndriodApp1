package com.zedan.acare.common.local;

import androidx.annotation.NonNull;

public enum KeyString {
    Language("language_key");

    @NonNull
    private final String key;

    private KeyString(@NonNull String key2) {
        this.key = key2;
    }

    @NonNull
    public final String getKey() {
        return this.key;
    }
}