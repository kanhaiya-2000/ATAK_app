package org.tensorflow.lite.task.core;

import android.util.Log;
import java.io.Closeable;

public abstract class BaseTaskApi implements Closeable {
    private static final String TAG = "BaseTaskApi";
    private boolean closed;
    private final long nativeHandle;

    /* access modifiers changed from: protected */
    public abstract void deinit(long j);

    protected BaseTaskApi(long j) {
        if (j != 0) {
            this.nativeHandle = j;
            return;
        }
        throw new IllegalArgumentException("Failed to load C++ pointer from JNI");
    }

    public boolean isClosed() {
        return this.closed;
    }

    public synchronized void close() {
        if (!this.closed) {
            deinit(this.nativeHandle);
            this.closed = true;
        }
    }

    public long getNativeHandle() {
        return this.nativeHandle;
    }

    /* access modifiers changed from: protected */
    public void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("Internal error: The task lib has already been closed.");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            if (!this.closed) {
                Log.w(TAG, "Closing an already closed native lib");
                close();
            }
        } finally {
            super.finalize();
        }
    }
}
