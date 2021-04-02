package com.zedan.acare.supervisor.domain.auth;

import com.zedan.acare.supervisor.domain.Result;

import java.util.Objects;

public abstract class LoginStatus implements Result {

    private LoginStatus(){

    }

    public static final class Loading extends LoginStatus {
        public static final Loading LOADING = new Loading();

        private Loading() {
            super();
        }
    }


    public static final class Success extends LoginStatus {
        public static final Success SUCCESS = new Success();

        private Success() {
            super();
        }
    }

    public static abstract class Error extends LoginStatus {

        public static final class InputError extends Error {
            public static final InputError INPUT_ERROR = new InputError();

            private InputError() {
                super();
            }
        }

        private Error() {
            super();
        }


        public static final class Exception extends Error {
            private final Throwable throwable;

            public Exception(Throwable throwable2) {
                super();
                this.throwable = throwable2;
            }


            public final Throwable getThrowable() {
                return this.throwable;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Exception)) return false;
                Exception exception = (Exception) o;
                return Objects.equals(getThrowable(), exception.getThrowable());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getThrowable());
            }
        }
    }
}
