package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.Result;

public abstract class RegisterPatientResult implements Result {


    private RegisterPatientResult() {
    }

    public static final class None extends RegisterPatientResult {
        public static final None NONE = new None();

        private None() {
            super();
        }
    }

    public static final class Loading extends RegisterPatientResult {
        public static final Loading LOADING = new Loading();

        private Loading() {
            super();
        }
    }


    public static final class Success extends RegisterPatientResult {
        public static final Success SUCCESS = new Success();

        private Success() {
            super();
        }
    }

    public static abstract class Error extends RegisterPatientResult {

        private Error() {
            super();
        }


        public static final class ErrorInputs extends Error {
            private final boolean isNotAge;
            private final boolean isNotCountry;
            private final boolean isNotLocation;
            private final boolean isNotMobile;
            private final boolean isNotName;
            private final boolean isNotPassword;
            private final boolean isNotStatus;
            private final boolean isNotStatusType;

            public ErrorInputs() {
                this(false, false, false, false, false, false, false, false);
            }


            public ErrorInputs(boolean isNotName, boolean isNotMobile, boolean isNotPassword, boolean isNotAge, boolean isNotLocation, boolean isNotStatus, boolean isNotStatusType, boolean isNotCountry) {
                super();
                this.isNotName = isNotName;
                this.isNotMobile = isNotMobile;
                this.isNotPassword = isNotPassword;
                this.isNotAge = isNotAge;
                this.isNotLocation = isNotLocation;
                this.isNotStatus = isNotStatus;
                this.isNotStatusType = isNotStatusType;
                this.isNotCountry = isNotCountry;
            }


            public final boolean isNotName() {
                return this.isNotName;
            }

            public final boolean isNotMobile() {
                return this.isNotMobile;
            }

            public final boolean isNotPassword() {
                return this.isNotPassword;
            }

            public final boolean isNotAge() {
                return this.isNotAge;
            }

            public final boolean isNotLocation() {
                return this.isNotLocation;
            }

            public final boolean isNotStatus() {
                return this.isNotStatus;
            }

            public final boolean isNotStatusType() {
                return this.isNotStatusType;
            }

            public final boolean isNotCountry() {
                return this.isNotCountry;
            }
        }

        public static final class Exception extends Error {
            private final Throwable throwable;

            public Exception(Throwable throwable) {
                super();
                this.throwable = throwable;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }
        }
    }
}
