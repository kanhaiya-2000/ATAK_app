package com.autel.internal.sdk.product.datapost;

public interface HandlerPost {
    boolean post(PostRunnable postRunnable);

    boolean postAtFrontOfQueue(PostRunnable postRunnable);

    boolean postAtTime(PostRunnable postRunnable, long j);

    boolean postAtTime(PostRunnable postRunnable, Object obj, long j);

    boolean postDelayed(PostRunnable postRunnable, long j);
}
