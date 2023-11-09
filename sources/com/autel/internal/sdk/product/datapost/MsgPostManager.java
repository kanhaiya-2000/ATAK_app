package com.autel.internal.sdk.product.datapost;

import android.os.Handler;
import android.os.Looper;

public class MsgPostManager implements HandlerPost {
    private static MsgPostManager postManager;
    private static boolean postOnUIThread;
    BackgroundHandler backgroundHandler = new BackgroundHandler();
    private Handler bgHandler = this.backgroundHandler.handler();
    private Handler uiHandler = new Handler(Looper.getMainLooper());

    public static MsgPostManager instance() {
        if (postManager == null) {
            synchronized (MsgPostManager.class) {
                if (postManager == null) {
                    postManager = new MsgPostManager();
                }
            }
        }
        return postManager;
    }

    private MsgPostManager() {
    }

    public static void setPostOnUIThread(boolean z) {
        postOnUIThread = z;
    }

    public boolean post(PostRunnable postRunnable) {
        Handler handler = getHandler(postRunnable);
        if (handler != null) {
            return handler.post(postRunnable);
        }
        return false;
    }

    public boolean postAtFrontOfQueue(PostRunnable postRunnable) {
        Handler handler = getHandler(postRunnable);
        if (handler != null) {
            return handler.postAtFrontOfQueue(postRunnable);
        }
        return false;
    }

    public boolean postDelayed(PostRunnable postRunnable, long j) {
        Handler handler = getHandler(postRunnable);
        if (handler != null) {
            return handler.postDelayed(postRunnable, j);
        }
        return false;
    }

    public boolean postAtTime(PostRunnable postRunnable, long j) {
        Handler handler = getHandler(postRunnable);
        if (handler != null) {
            return handler.postAtTime(postRunnable, j);
        }
        return false;
    }

    public boolean postAtTime(PostRunnable postRunnable, Object obj, long j) {
        Handler handler = getHandler(postRunnable);
        if (handler != null) {
            return handler.postAtTime(postRunnable, obj, j);
        }
        return false;
    }

    private Handler getHandler(PostRunnable postRunnable) {
        if (postRunnable == null) {
            return null;
        }
        if (!postOnUIThread || !postRunnable.isRunOnUiThread()) {
            return this.bgHandler;
        }
        return this.uiHandler;
    }

    public void destroy() {
        this.backgroundHandler.destroy();
    }

    public void removeCallbacks(PostRunnable postRunnable) {
        Handler handler = this.uiHandler;
        if (handler != null) {
            handler.removeCallbacks(postRunnable);
        }
        Handler handler2 = this.bgHandler;
        if (handler2 != null) {
            handler2.removeCallbacks(postRunnable);
        }
    }

    public void removeCallbacks() {
        Handler handler = this.uiHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        Handler handler2 = this.bgHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }
}
