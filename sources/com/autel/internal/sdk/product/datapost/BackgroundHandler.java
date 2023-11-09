package com.autel.internal.sdk.product.datapost;

import android.os.Handler;
import android.os.HandlerThread;

public class BackgroundHandler {
    private Handler handler = new Handler(this.handlerThread.getLooper());
    private HandlerThread handlerThread;

    public BackgroundHandler() {
        HandlerThread handlerThread2 = new HandlerThread("background handler thread");
        this.handlerThread = handlerThread2;
        handlerThread2.start();
    }

    public Handler handler() {
        return this.handler;
    }

    public boolean destroy() {
        return this.handlerThread.quit();
    }
}
