package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {
    /* access modifiers changed from: protected */
    public abstract Future<? extends V> delegate();

    protected ForwardingFuture() {
    }

    public boolean cancel(boolean z) {
        return delegate().cancel(z);
    }

    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    public boolean isDone() {
        return delegate().isDone();
    }

    public V get() {
        return delegate().get();
    }

    public V get(long j, TimeUnit timeUnit) {
        return delegate().get(j, timeUnit);
    }

    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {
        private final Future<V> delegate;

        protected SimpleForwardingFuture(Future<V> future) {
            this.delegate = (Future) Preconditions.checkNotNull(future);
        }

        /* access modifiers changed from: protected */
        public final Future<V> delegate() {
            return this.delegate;
        }
    }
}
