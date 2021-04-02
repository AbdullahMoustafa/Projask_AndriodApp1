package com.zedan.acare.supervisor.domain.profile;

import com.google.firebase.database.ValueEventListener;
import com.zedan.acare.supervisor.domain.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

public final class ProfileParam implements Param {
    private final ValueEventListener patientListener;
    private final ValueEventListener supervisorListener;

    public ProfileParam(ValueEventListener supervisorListener2, ValueEventListener patientListener2) {
        this.supervisorListener = supervisorListener2;
        this.patientListener = patientListener2;
    }

    public final ValueEventListener getSupervisorListener() {
        return this.supervisorListener;
    }

    public final ValueEventListener getPatientListener() {
        return this.patientListener;
    }
}
