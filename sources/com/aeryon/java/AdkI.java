package com.aeryon.java;

import android.content.Context;
import com.aeryon.java.event.BooleanListener;
import com.aeryon.java.event.EventListener;

public interface AdkI {
    String getADKVersion();

    Context getContext();

    void init(Context context, String str);

    boolean isConnected();

    void setDiscoveryListener(EventListener eventListener);

    void setMapViewContext(Context context);

    void setMediaUpdateListener(BooleanListener booleanListener);

    void setTestListener(EventListener eventListener);
}
