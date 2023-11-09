package com.autel.internal.video.core.decoder2.utils;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;

public class HandlerThreadUtils {
    public static void cancelHandlerThread(HandlerThread handlerThread, Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        if (handlerThread != null && handlerThread.isAlive()) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
        }
    }
}
