package com.zedan.acare.supervisor.domain.profile;

import com.zedan.acare.supervisor.domain.Result;

public abstract class UploadImageStatus implements Result {
    private UploadImageStatus(){

    }

    public static final class Loading extends UploadImageStatus{
        public static final Loading LOADING = new Loading();
        private Loading(){
            super();
        }
    }

    public static final class Success extends UploadImageStatus{
        public static final Success SUCCESS = new Success();
        private Success(){
            super();
        }
    }

    public static final class Error extends UploadImageStatus{
        private final Throwable throwable;

        public Error(Throwable throwable){
            this.throwable = throwable;
        }

        public Throwable getThrowable() {
            return throwable;
        }
    }
}
