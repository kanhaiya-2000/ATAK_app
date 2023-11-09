package com.autel.internal.sdk.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.autel.internal.sdk.AutelBaseApplication;
import java.io.File;

public class AutelDirPathUtils {
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setAppDirPath(String str) {
        AutelSharedPreferencesUtils.setSpValueForString(AutelBaseApplication.getAppContext(), "AppDirName", str);
    }

    public static String getAppDir() {
        String packageName = AutelBaseApplication.getAppContext().getPackageName();
        Context appContext = AutelBaseApplication.getAppContext();
        String spValueForString = AutelSharedPreferencesUtils.getSpValueForString(appContext, "AppDirName", Environment.getExternalStorageDirectory() + "/" + packageName.substring(packageName.lastIndexOf(".") + 1));
        File file = new File(spValueForString);
        if (!file.exists()) {
            file.mkdirs();
        }
        return spValueForString;
    }

    public static String getLogCatPath() {
        return getAppDir() + "/LogCat/";
    }
}
