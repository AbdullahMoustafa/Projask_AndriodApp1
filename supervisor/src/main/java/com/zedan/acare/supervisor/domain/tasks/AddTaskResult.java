package com.zedan.acare.supervisor.domain.tasks;

import com.zedan.acare.supervisor.domain.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;


public abstract class AddTaskResult implements Result {

    private AddTaskResult() {
    }

    public static final class None extends AddTaskResult {
        public static final None NONE = new None();

        private None() {
            super();
        }
    }

    public static final class Loading extends AddTaskResult {
        public static final Loading LOADING = new Loading();

        private Loading() {
            super();
        }
    }

    public static final class Success extends AddTaskResult {
        public static final Success SUCCESS = new Success();

        private Success() {
            super();
        }
    }

    public static abstract class Error extends AddTaskResult {

        private Error() {
            super();
        }

        public static final class InputError extends Error {
            private final boolean isNotColor;
            private final boolean isNotDesc;
            private final boolean isNotEndDate;
            private final boolean isNotEndHour;
            private final boolean isNotStartDate;
            private final boolean isNotStartHour;
            private final boolean isNotTitle;

            public InputError() {
                this(false, false, false, false, false, false, false);
            }

            public InputError(boolean isNotTitle, boolean isNotDesc, boolean isNotStartDate, boolean isNotStartHour, boolean isNotEndDate, boolean isNotEndHour, boolean isNotColor) {
                super();
                this.isNotTitle = isNotTitle;
                this.isNotDesc = isNotDesc;
                this.isNotStartDate = isNotStartDate;
                this.isNotStartHour = isNotStartHour;
                this.isNotEndDate = isNotEndDate;
                this.isNotEndHour = isNotEndHour;
                this.isNotColor = isNotColor;
            }

            public final boolean isNotTitle() {
                return this.isNotTitle;
            }

            public final boolean isNotDesc() {
                return this.isNotDesc;
            }

            public final boolean isNotStartDate() {
                return this.isNotStartDate;
            }

            public final boolean isNotStartHour() {
                return this.isNotStartHour;
            }

            public final boolean isNotEndDate() {
                return this.isNotEndDate;
            }

            public final boolean isNotEndHour() {
                return this.isNotEndHour;
            }

            public final boolean isNotColor() {
                return this.isNotColor;
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
