package org.droidplanner.services.android.impl.utils;

import android.util.Log;
import org.droidplanner.services.android.impl.core.model.Logger;

public class AndroidLogger implements Logger {
    private static Logger sLogger = new AndroidLogger();

    public static Logger getLogger() {
        return sLogger;
    }

    private AndroidLogger() {
    }

    public void logVerbose(String str, String str2) {
        if (str2 != null) {
            Log.v(str, str2);
        }
    }

    public void logDebug(String str, String str2) {
        if (str2 != null) {
            Log.d(str, str2);
        }
    }

    public void logInfo(String str, String str2) {
        if (str2 != null) {
            Log.i(str, str2);
        }
    }

    public void logWarning(String str, String str2) {
        if (str2 != null) {
            Log.w(str, str2);
        }
    }

    public void logWarning(String str, Exception exc) {
        if (exc != null) {
            Log.w(str, exc);
        }
    }

    public void logWarning(String str, String str2, Exception exc) {
        if (str2 != null && exc != null) {
            Log.w(str, str2, exc);
        }
    }

    public void logErr(String str, String str2) {
        if (str2 != null) {
            Log.e(str, str2);
        }
    }

    public void logErr(String str, Exception exc) {
        if (exc != null) {
            Log.e(str, exc.getMessage(), exc);
        }
    }

    public void logErr(String str, String str2, Exception exc) {
        if (str2 != null && exc != null) {
            Log.e(str, str2, exc);
        }
    }
}
