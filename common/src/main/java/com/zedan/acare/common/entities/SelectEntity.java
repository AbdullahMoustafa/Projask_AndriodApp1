package com.zedan.acare.common.entities;

import androidx.annotation.NonNull;

public class SelectEntity {
    private final long id;
    @NonNull
    private final String name;

    public SelectEntity(long id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    @NonNull
    public String getName() {
        return this.name;
    }
}