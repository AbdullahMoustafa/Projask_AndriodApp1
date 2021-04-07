package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.Param;

public class UploadImageParam implements Param {

    private final String path;
    private final String databasePath;

    public UploadImageParam(String path, String databasePath) {
        this.path = path;
        this.databasePath = databasePath;
    }

    public String getPath() {
        return path;
    }

    public String getDatabasePath() {
        return databasePath;
    }
}
