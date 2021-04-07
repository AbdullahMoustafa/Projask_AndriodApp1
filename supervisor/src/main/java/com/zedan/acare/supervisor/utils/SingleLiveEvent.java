package com.zedan.acare.supervisor.utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicBoolean;

import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public final class SingleLiveEvent<T> extends MutableLiveData<T> {

    public final AtomicBoolean mPending = new AtomicBoolean(false);

    public SingleLiveEvent() {
        super();
    }

    public SingleLiveEvent(T value) {
        super(value);
    }

    public void observe(@NotNull LifecycleOwner owner, @NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (hasActiveObservers()) {
            Timber.e("Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(owner, t -> {

            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t);
            }
        });
    }

    public void setValue(T t) {
        this.mPending.set(true);
        super.setValue(t);
    }

    public final void call() {
        setValue(null);
    }
}
