package com.zedan.acare.supervisor.ui.forget;

import dagger.internal.Factory;

public final class ForgetPasswordViewModel_Factory implements Factory<ForgetPasswordViewModel> {
    public ForgetPasswordViewModel get() {
        return newInstance();
    }

    public static ForgetPasswordViewModel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ForgetPasswordViewModel newInstance() {
        return new ForgetPasswordViewModel();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ForgetPasswordViewModel_Factory INSTANCE = new ForgetPasswordViewModel_Factory();

        private InstanceHolder() {
        }
    }
}
