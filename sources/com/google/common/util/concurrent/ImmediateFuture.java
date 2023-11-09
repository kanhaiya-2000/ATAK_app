package com.google.common.util.concurrent;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

class ImmediateFuture<V> implements ListenableFuture<V> {
    static final ListenableFuture<?> NULL = new ImmediateFuture((Object) null);
    private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());
    @cij
    private final V value;

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    ImmediateFuture(@cij V v) {
        this.value = v;
    }

    public void addListener(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = log;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
        }
    }

    public V get() {
        return this.value;
    }

    public V get(long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        return get();
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.value + "]]";
    }

    static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateFailedFuture(Throwable th) {
            setException(th);
        }
    }

    static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateCancelledFuture() {
            cancel(false);
        }
    }
}
