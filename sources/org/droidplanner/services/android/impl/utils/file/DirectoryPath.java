package org.droidplanner.services.android.impl.utils.file;

import android.content.Context;
import android.os.Environment;

public class DirectoryPath {
    public static String getPrivateDataPath(Context context) {
        return context.getExternalFilesDir((String) null).getAbsolutePath();
    }

    public static String getPublicDataPath(Context context) {
        String path = Environment.getExternalStorageDirectory().getPath();
        return path + "/3DRServices/";
    }

    public static String getCameraInfoPath(Context context) {
        return getPublicDataPath(context) + "/CameraInfo/";
    }

    public static String getCrashLogPath(Context context) {
        return getPrivateDataPath(context) + "/crash_log/";
    }
}
