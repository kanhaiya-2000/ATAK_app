package com.autel.libupdrage.upgrade.entity;

import android.os.Handler;
import java.lang.ref.WeakReference;

public abstract class WeakHandler<T> extends Handler {
    private WeakReference<T> mOwner;

    public WeakHandler(T t) {
        this.mOwner = new WeakReference<>(t);
    }

    public T getOwner() {
        return this.mOwner.get();
    }
}
