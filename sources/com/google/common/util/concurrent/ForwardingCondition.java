package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

abstract class ForwardingCondition implements Condition {
    /* access modifiers changed from: package-private */
    public abstract Condition delegate();

    ForwardingCondition() {
    }

    public void await() {
        delegate().await();
    }

    public boolean await(long j, TimeUnit timeUnit) {
        return delegate().await(j, timeUnit);
    }

    public void awaitUninterruptibly() {
        delegate().awaitUninterruptibly();
    }

    public long awaitNanos(long j) {
        return delegate().awaitNanos(j);
    }

    public boolean awaitUntil(Date date) {
        return delegate().awaitUntil(date);
    }

    public void signal() {
        delegate().signal();
    }

    public void signalAll() {
        delegate().signalAll();
    }
}
