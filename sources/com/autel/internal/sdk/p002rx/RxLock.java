package com.autel.internal.sdk.p002rx;

import com.autel.common.error.AutelError;
import com.autel.common.error.RxException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/* renamed from: com.autel.internal.sdk.rx.RxLock */
public abstract class RxLock<T> {
    private static final int TIME_OUT_MS = 7000;
    volatile T data;
    final Object dataLock = new Object();
    long end;
    volatile RxException exception;
    volatile boolean locked = true;
    int timeOut = TIME_OUT_MS;

    /* access modifiers changed from: protected */
    public abstract void run();

    public RxLock() {
    }

    public RxLock(int i) {
        this.timeOut = i;
    }

    /* access modifiers changed from: private */
    public void waitRx(long j) {
        long currentTimeMillis = j - System.currentTimeMillis();
        if (j >= 0 || !this.locked) {
            synchronized (this.dataLock) {
                if (this.locked) {
                    this.dataLock.wait(currentTimeMillis);
                }
            }
            if (this.locked) {
                throw new InterruptedException();
            }
            return;
        }
        throw new InterruptedException();
    }

    private void notifyRx() {
        synchronized (this.dataLock) {
            if (this.locked) {
                this.locked = false;
                this.dataLock.notify();
            }
        }
    }

    public Observable<T> fire() {
        return Observable.just(Long.valueOf(this.end)).flatMap(new Function<Long, ObservableSource<T>>() {
            public ObservableSource<T> apply(Long l) {
                RxLock.this.end = System.currentTimeMillis() + ((long) RxLock.this.timeOut);
                RxLock.this.run();
                try {
                    RxLock rxLock = RxLock.this;
                    rxLock.waitRx(rxLock.end);
                } catch (InterruptedException unused) {
                    RxLock.this.setException(new RxException(AutelError.COMMON_TIMEOUT));
                }
                if (RxLock.this.getException() != null) {
                    return Observable.error(RxLock.this.getException());
                }
                return Observable.just(RxLock.this.getData());
            }
        });
    }

    private Observable<T> start() {
        return Observable.just(Long.valueOf(this.end)).flatMap(new Function<Long, ObservableSource<T>>() {
            public ObservableSource<T> apply(Long l) {
                RxLock.this.end = System.currentTimeMillis() + ((long) RxLock.this.timeOut);
                RxLock.this.run();
                try {
                    RxLock.this.waitRx(l.longValue());
                } catch (InterruptedException unused) {
                    RxLock.this.setException(new RxException(AutelError.COMMON_TIMEOUT));
                }
                if (RxLock.this.getException() != null) {
                    return Observable.error(RxLock.this.getException());
                }
                return Observable.just(RxLock.this.getData());
            }
        });
    }

    private Observable<T> start(int i) {
        this.timeOut = i;
        return fire();
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
        notifyRx();
    }

    public RxException getException() {
        return this.exception;
    }

    public void setException(RxException rxException) {
        this.exception = rxException;
        notifyRx();
    }

    public void setException(AutelError autelError) {
        this.exception = new RxException(autelError);
        notifyRx();
    }
}
