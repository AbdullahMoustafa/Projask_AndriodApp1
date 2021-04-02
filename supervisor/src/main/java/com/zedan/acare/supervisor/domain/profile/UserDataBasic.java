package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.Result;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;


public final class UserDataBasic implements Result {
    private final File image;
    private final String name;

    public UserDataBasic() {
        this(null, null);
    }

    public UserDataBasic(String name2, File image2) {
        this.name = name2;
        this.image = image2;
    }

    public final String getName() {
        return this.name;
    }

    public final File getImage() {
        return this.image;
    }
}
