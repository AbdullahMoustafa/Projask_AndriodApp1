package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.Result;

public abstract class EditInputResult implements Result {

    private EditInputResult() {

    }

    public static final class Loading extends EditInputResult {
        public static final Loading LOADING = new Loading();

        private Loading() {
            super();
        }
    }

    public static final class Success extends EditInputResult {
        public static final Success SUCCESS = new Success();

        private Success() {
            super();
        }
    }

    public static abstract class Error extends EditInputResult {
        private Error() { super(); }

        public static final class InputError extends Error {
            public static final InputError INPUT_ERROR = new InputError();

            private InputError() {
                super();
            }
        }

        public static final class Exception extends Error {
            private final Throwable throwable;

            public Exception(Throwable throwable) {
                super();
                this.throwable = throwable;
            }

            public Throwable getThrowable() {
                return throwable;
            }
        }
    }
}
