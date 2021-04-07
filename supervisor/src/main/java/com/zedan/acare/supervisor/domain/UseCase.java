package com.zedan.acare.supervisor.domain;

import io.reactivex.rxjava3.core.Observable;

public abstract class UseCase<P extends Param, R extends Result> {

    protected abstract Observable<R> runnable(P param);

    public Observable<R> execute(P param) {
        return runnable(param);
    }
}
