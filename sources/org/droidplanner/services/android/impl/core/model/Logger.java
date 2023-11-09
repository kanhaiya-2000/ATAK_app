package org.droidplanner.services.android.impl.core.model;

public interface Logger {
    void logDebug(String str, String str2);

    void logErr(String str, Exception exc);

    void logErr(String str, String str2);

    void logErr(String str, String str2, Exception exc);

    void logInfo(String str, String str2);

    void logVerbose(String str, String str2);

    void logWarning(String str, Exception exc);

    void logWarning(String str, String str2);

    void logWarning(String str, String str2, Exception exc);
}
