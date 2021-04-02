package com.zedan.acare.common.entities;

import androidx.annotation.NonNull;

public class SelectEntity {
    private final long id;
    @NonNull
    private final String name;

    public SelectEntity(long id2, @NonNull String name2) {
        this.id = id2;
        this.name = name2;
    }

    public long getId() {
        return this.id;
    }

    @NonNull
    public String getName() {
        return this.name;
    }
}