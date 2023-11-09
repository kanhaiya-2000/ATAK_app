package com.atakmap.android.uastool.utils;

import android.content.Context;
import android.content.ContextWrapper;
import com.atakmap.coremap.log.Log;

public class AppPluginContext extends ContextWrapper {
    Context atakContext;
    Context pluginContext;

    public AppPluginContext(Context context, Context context2) {
        super(context);
        this.atakContext = context;
        this.pluginContext = context2;
    }

    public Context getApplicationContext() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sb = new StringBuilder();
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            sb.append(stackTraceElement.getMethodName());
            sb.append(".");
            if (stackTraceElement.getMethodName().equals("registerUsbConnectionReceiver")) {
                Log.d("GenericMonitor", sb.toString() + ": Return atak Context");
                return this.atakContext;
            } else if (stackTraceElement.getMethodName().equals("addIAutelWifiConnectStatusListener")) {
                Log.d("GenericMonitor", sb.toString() + ": Return atak Context");
                return this.atakContext;
            } else if (stackTraceElement.getMethodName().equals("beginMonitoring")) {
                Log.d("GenericMonitor", sb.toString() + ": Return atak Context");
                return this.atakContext;
            } else {
                i++;
            }
        }
        Log.d("GenericMonitor", sb.toString() + ": Return this");
        return this;
    }

    public ClassLoader getClassLoader() {
        return this.pluginContext.getClassLoader();
    }

    public Object getSystemService(String str) {
        return this.pluginContext.getSystemService(str);
    }

    public String getPackageName() {
        for (StackTraceElement methodName : Thread.currentThread().getStackTrace()) {
            if (methodName.getMethodName().equals("initAppInfo")) {
                return "com.partech.uastool.evo";
            }
        }
        return super.getPackageName();
    }
}
