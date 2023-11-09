package com.aeryon.java.event;

import android.util.Log;

public abstract class EventListener<T> {
    public static final String TAG = "ADK_Event_Listener";

    public abstract void handleEvent(T t);

    /* access modifiers changed from: protected */
    public void listen(Object obj) {
        try {
            handleEvent(obj);
        } catch (Exception e) {
            Log.e(TAG, "Error while calling handleEvent from EventListener: ", e);
        }
    }
}
