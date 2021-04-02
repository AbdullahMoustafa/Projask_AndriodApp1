package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;


public abstract class RegisterResult implements Result {

    private RegisterResult() {
    }

    public static final class Loading extends RegisterResult {
        public static final Loading LOADING = new Loading();

        private Loading() {
            super();
        }
    }

    public static final class Success extends RegisterResult {
        public static final Success SUCCESS = new Success();

        private Success() {
            super();
        }
    }

    public static abstract class Error extends RegisterResult {

        private Error() {
            super();
        }


        public static final class InputError extends Error {
            private final boolean isNotAddress;
            private final boolean isNotCountry;
            private final boolean isNotEmail;
            private final boolean isNotKinship;
            private final boolean isNotMobile;
            private final boolean isNotName;
            private final boolean isNotPassword;

            public InputError() {
                this(false, false, false, false, false, false, false);
            }

            public InputError(boolean isNotName, boolean isNotMobile, boolean isNotEmail, boolean isNotPassword, boolean isNotKinship, boolean isNotAddress, boolean isNotCountry) {
                super();
                this.isNotName = isNotName;
                this.isNotMobile = isNotMobile;
                this.isNotEmail = isNotEmail;
                this.isNotPassword = isNotPassword;
                this.isNotKinship = isNotKinship;
                this.isNotAddress = isNotAddress;
                this.isNotCountry = isNotCountry;
            }


            public final boolean isNotName() {
                return this.isNotName;
            }

            public final boolean isNotMobile() {
                return this.isNotMobile;
            }

            public final boolean isNotEmail() {
                return this.isNotEmail;
            }

            public final boolean isNotPassword() {
                return this.isNotPassword;
            }

            public final boolean isNotKinship() {
                return this.isNotKinship;
            }

            public final boolean isNotAddress() {
                return this.isNotAddress;
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
