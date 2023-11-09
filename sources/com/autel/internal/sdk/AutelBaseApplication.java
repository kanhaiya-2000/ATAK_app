package com.autel.internal.sdk;

import android.content.Context;

public class AutelBaseApplication {
    private static Context instance_;

    public static void setAppContext(Context context) {
        instance_ = context;
    }

    public static Context getAppContext() {
        return instance_;
    }
}
