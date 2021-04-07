package com.zedan.acare.supervisor.domain.tasks;

import com.zedan.acare.supervisor.domain.Result;

import java.util.List;

public abstract class GetTasksResult implements Result {
    private GetTasksResult() {

    }

    public static final class Loading extends GetTasksResult {
        public static final Loading LOADING = new Loading();

        private Loading() {
            super();
        }
    }

    public static final class Success extends GetTasksResult {
        private final List<TaskEntity> tasks;

        public Success(List<TaskEntity> tasks) {
            super();
            this.tasks = tasks;
        }

        public List<TaskEntity> getTasks() {
            return tasks;
        }
    }

    public static final class Error extends GetTasksResult {
        private final Throwable throwable;

        public Error(Throwable throwable) {
            this.throwable = throwable;
        }

        public Throwable getThrowable() {
            return throwable;
        }
    }
}
