package com.zedan.acare.supervisor.domain;

import io.reactivex.rxjava3.core.Flowable;

public abstract class UseCase<P extends Param, R extends Result> {

    protected abstract Flowable<R> runnable(P param);

    Flowable<R> execute(P param) {
        return runnable(param);
    }
}
