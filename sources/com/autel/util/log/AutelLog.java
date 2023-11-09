package com.autel.util.log;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AutelLog {
    public static final String TMP_CONNECT_ATG = "ConnectDebug";

    /* renamed from: i */
    public static void m15089i(String str, String str2) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                Log.i(str, str2);
                LocallogSave.writeLog(LogTask.LOG_TYPE_INFO, getLogString(str, str2));
            }
        } catch (Exception unused) {
        }
    }

    public static void debug_i(String str, String str2) {
        try {
            Log.i(str, str2);
            LocallogSave.debug_writeNecessaryLog(getLogString(str, str2));
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    public static void m15081d(String str) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                Log.d(AutelLogTags.TAG_APP, str);
                LocallogSave.writeLog(LogTask.LOG_TYPE_DEBUG, getLogString(AutelLogTags.TAG_APP, str));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    public static void m15082d(String str, String str2) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                Log.d(str, str2);
                LocallogSave.writeLog(LogTask.LOG_TYPE_DEBUG, getLogString(str, str2));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: w */
    public static void m15090w(String str, String str2) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                Log.w(str, str2);
                LocallogSave.writeLog(LogTask.LOG_TYPE_WARN, getLogString(str, str2));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: w */
    public static void m15091w(String str, String str2, Throwable th) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                Log.w(str, str2);
                LocallogSave.writeLog(LogTask.LOG_TYPE_WARN, getLogString(str, str2));
                String stackTrace = getStackTrace(th);
                Log.w(str, stackTrace);
                LocallogSave.writeLog(LogTask.LOG_TYPE_ERROR, getLogString(str, stackTrace));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public static void m15083e(String str) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                Log.e(AutelLogTags.TAG_APP, str);
                LocalLogUtil.writeExpection(str);
                LocallogSave.writeLog(LogTask.LOG_TYPE_ERROR, getLogString(AutelLogTags.TAG_APP, str));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public static void m15084e(String str, String str2) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                Log.e(str, str2);
                LocallogSave.writeLog(LogTask.LOG_TYPE_ERROR, getLogString(str, str2));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public static void m15086e(String str, Throwable th, String str2) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                m15087e(str, th, str2, false);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public static void m15085e(String str, Throwable th) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                m15088e(str, th, false);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public static void m15088e(String str, Throwable th, boolean z) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG) {
                m15087e(str, th, (String) null, false);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public static void m15087e(String str, Throwable th, String str2, boolean z) {
        try {
            if (AutelConfig.AUTEL_DEBUG_LOG && str2 != null) {
                Log.e(str, str2);
            }
            String stackTrace = getStackTrace(th);
            if (AutelConfig.AUTEL_DEBUG_LOG && stackTrace != null) {
                Log.e(str, stackTrace);
                LocalLogUtil.writeExpection(stackTrace);
                LocallogSave.writeLog(LogTask.LOG_TYPE_ERROR, getLogString(str, stackTrace));
            }
        } catch (Exception unused) {
        }
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        if (th != null) {
            th.printStackTrace(new PrintWriter(stringWriter, true));
        }
        return stringWriter.toString();
    }

    public static String getLogString(String str, String str2) {
        return str + "   " + str2;
    }

    public static void writeLogs(boolean z) {
        AutelConfig.AUTEL_DEBUG_LOG = z;
    }
}
