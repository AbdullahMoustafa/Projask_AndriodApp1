package com.zedan.acare.supervisor.domain.tasks;

import com.zedan.acare.supervisor.domain.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;


public abstract class AddTaskResult implements Result {

    private AddTaskResult() {
    }

    public static final class None extends AddTaskResult {
        public static final None INSTANCE = new None();

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

            public InputError(boolean isNotTitle2, boolean isNotDesc2, boolean isNotStartDate2, boolean isNotStartHour2, boolean isNotEndDate2, boolean isNotEndHour2, boolean isNotColor2) {
                super();
                this.isNotTitle = isNotTitle2;
                this.isNotDesc = isNotDesc2;
                this.isNotStartDate = isNotStartDate2;
                this.isNotStartHour = isNotStartHour2;
                this.isNotEndDate = isNotEndDate2;
                this.isNotEndHour = isNotEndHour2;
                this.isNotColor = isNotColor2;
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


            public Exception(Throwable throwable2) {
                super();
                this.throwable = throwable2;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }
        }
    }
}
