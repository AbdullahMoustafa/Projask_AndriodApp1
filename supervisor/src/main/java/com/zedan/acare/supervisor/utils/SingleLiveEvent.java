package com.zedan.acare.supervisor.utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0007J \u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000eH\u0017J\u0019\u0010\u000f\u001a\u00020\t2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/zedan/acare/supervisor/utils/SingleLiveEvent;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "value", "(Ljava/lang/Object;)V", "mPending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "call", "", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "setValue", "t", "supervisor_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: SingleLiveEvent.kt */
public final class SingleLiveEvent<T> extends MutableLiveData<T> {
    /* access modifiers changed from: private */
    public final AtomicBoolean mPending = new AtomicBoolean(false);

    public SingleLiveEvent() {
    }

    public SingleLiveEvent(T value) {
        super(value);
    }

    public void observe(LifecycleOwner owner, Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (hasActiveObservers()) {
            Timber.w("Multiple observers registered but only one will be notified of changes.", new Object[0]);
        }
        super.observe(owner, new SingleLiveEvent$observe$1(this, observer));
    }

    public void setValue(T t) {
        this.mPending.set(true);
        super.setValue(t);
    }

    public final void call() {
        setValue((Object) null);
    }
}
