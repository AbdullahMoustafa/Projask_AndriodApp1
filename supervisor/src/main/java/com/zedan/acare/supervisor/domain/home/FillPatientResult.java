package com.zedan.acare.supervisor.domain.home;

import com.zedan.acare.supervisor.domain.Result;

public abstract class FillPatientResult implements Result {


    private FillPatientResult() {
    }
    
    public static final class Loading extends FillPatientResult {
        public static final Loading LOADING = new Loading();

        private Loading() {
            super();
        }
    }
    
    public static final class Success extends FillPatientResult {
        private final boolean hasFill;
        
        public Success(boolean hasFill2) {
            super();
            this.hasFill = hasFill2;
        }

        public final boolean getHasFill() {
            return this.hasFill;
        }
    }
    public static final class Error extends FillPatientResult {
        private final Throwable Exception;

        public Error(Throwable Exception2) {
            super();
            this.Exception = Exception2;
        }

        public final Throwable getException() {
            return this.Exception;
        }
    }
}

