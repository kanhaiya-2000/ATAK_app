package com.autel.AutelNet2.utils;

import android.text.TextUtils;
import com.autel.internal.sdk.util.AutelDirPathUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CacheUtils {
    private static String DSP_CACHE_PATH = (AutelDirPathUtils.getAppDir() + "/DSP");
    public static volatile boolean isFlag = true;
    private static String localPath = (getTimeStamp() + "_dspCache.txt");

    public static boolean isDspCache() {
        return new File(DSP_CACHE_PATH).exists();
    }

    public static boolean writeLog(String str) {
        try {
            String logPath = getLogPath(localPath);
            if (TextUtils.isEmpty(logPath)) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(logPath), true);
            fileOutputStream.write((str + "\n").getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getLogPath(String str) {
        File file = new File(DSP_CACHE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory() && file.delete()) {
            file.mkdirs();
        }
        File file2 = new File(file.getAbsolutePath() + "/" + str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file2.getAbsolutePath();
    }

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss", Locale.US).format(new Date());
    }
}
