package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.util.NoSuchElementException;

public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @cij
    private T nextOrNull;

    /* access modifiers changed from: protected */
    @cij
    public abstract T computeNext(T t);

    protected AbstractSequentialIterator(@cij T t) {
        this.nextOrNull = t;
    }

    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    public final T next() {
        if (hasNext()) {
            try {
                T t = this.nextOrNull;
                this.nextOrNull = computeNext(t);
                return t;
            } catch (Throwable th) {
                this.nextOrNull = computeNext(this.nextOrNull);
                throw th;
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
