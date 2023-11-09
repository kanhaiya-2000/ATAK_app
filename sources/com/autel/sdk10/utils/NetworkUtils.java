package com.autel.sdk10.utils;

import android.net.ConnectivityManager;
import com.autel.internal.sdk.AutelBaseApplication;

public final class NetworkUtils {
    private static final String baiduIp = " 202.108.22.5";

    private NetworkUtils() {
    }

    public static boolean checkNetWork(String str) {
        ConnectivityManager connectivityManager = (ConnectivityManager) AutelBaseApplication.getAppContext().getSystemService("connectivity");
        try {
            Runtime runtime = Runtime.getRuntime();
            int waitFor = runtime.exec("/system/bin/ping -c 1" + str).waitFor();
            if (connectivityManager.getActiveNetworkInfo() == null || waitFor != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
