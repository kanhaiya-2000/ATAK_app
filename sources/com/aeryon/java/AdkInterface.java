package com.aeryon.java;

import android.content.Context;
import com.aeryon.java.event.BooleanListener;
import com.aeryon.java.event.EventListener;

public class AdkInterface {
    private static Context mMapViewContext;

    public static native void destroy();

    public static native String getADKVersion();

    public static native void init();

    public static native boolean isConnected();

    public static native void setDiscoveryListener(EventListener eventListener);

    public static native void setMediaUpdateListener(BooleanListener booleanListener);

    public static native void setTestListener(EventListener eventListener);

    static {
        System.loadLibrary("adkiface");
    }

    public static void setMapViewContext(Context context) {
        mMapViewContext = context;
    }

    public static Context getContext() {
        return mMapViewContext;
    }
}
