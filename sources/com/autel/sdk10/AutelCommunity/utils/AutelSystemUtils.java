package com.autel.sdk10.AutelCommunity.utils;

import android.content.pm.PackageManager;
import android.os.Build;
import com.autel.internal.sdk.AutelBaseApplication;
import com.autel.util.okhttp.model.HttpMediaType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutelSystemUtils {
    public static String CONTENT_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
    public static String CONTENT_TYPE_MULTPART = HttpMediaType.MEDIA_TYPE_MULTI_FORM;
    public static Object obj_syn = new Object();
    public static ExecutorService threadPool = Executors.newSingleThreadExecutor();

    public static String getHttpUserAgent() {
        return "Starlink/" + getVersion() + " (" + getOsSystemModel() + "; Android " + getOsSystemVersion() + "; Scale/2.00)";
    }

    public static String getOsSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getOsSystemModel() {
        return Build.MODEL;
    }

    public static String getVersion() {
        try {
            return AutelBaseApplication.getAppContext().getPackageManager().getPackageInfo(AutelBaseApplication.getAppContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void lock(Object obj) {
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unlock(Object obj) {
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
