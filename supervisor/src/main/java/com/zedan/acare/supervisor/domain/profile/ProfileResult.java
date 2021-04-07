package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.Result;
import com.zedan.acare.supervisor.domain.auth.RegisterParam;
import com.zedan.acare.supervisor.domain.auth.RegisterPatientParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

public abstract class ProfileResult implements Result {

    private ProfileResult() {
    }

    public static final class None extends ProfileResult {
        public static final None NONE = new None();

        private None() {
            super();
        }
    }

    public static final class Loading extends ProfileResult {
        public static final Loading LOADING = new Loading();

        private Loading() {
            super();
        }
    }

    public static final class Success extends ProfileResult {
        private final RegisterPatientParam patient;
        private final RegisterParam supervisor;
        private final String patientPath;
        private final String supervisorPath;

        public Success() {
            this(null, null, null, null);
        }


        public Success(RegisterParam supervisor2, RegisterPatientParam patient2, String supervisorPath, String patientPath) {
            super();
            this.supervisor = supervisor2;
            this.patient = patient2;
            this.supervisorPath = supervisorPath;
            this.patientPath = patientPath;
        }

        public final RegisterParam getSupervisor() {
            return this.supervisor;
        }

        public final RegisterPatientParam getPatient() {
            return this.patient;
        }

        public String getPatientPath() {
            return patientPath;
        }

        public String getSupervisorPath() {
            return supervisorPath;
        }
    }


    public static final class Error extends ProfileResult {
        private final Throwable throwable;

        public Error(Throwable throwable2) {
            super();
            this.throwable = throwable2;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }
}
