package com.autel.util.log;

import android.os.Environment;
import android.text.TextUtils;
import com.autel.internal.sdk.util.AutelDirPathUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LocalLogUtil {
    public static String getLogPath() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory, AutelDirPathUtils.getAppDir() + "/autel_log");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory() && file.delete()) {
            file.mkdirs();
        }
        File file2 = new File(file.getAbsolutePath() + "/autel_log.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file2.getAbsolutePath();
    }

    public static String getLogPath(String str) {
        File file = new File(AutelDirPathUtils.getAppDir() + "/autel_log");
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

    public static long getFileSize(String str) {
        try {
            return new File(str).length();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean writeLog(String str, String str2) {
        try {
            String logPath = getLogPath(str);
            if (TextUtils.isEmpty(logPath)) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(logPath), true);
            fileOutputStream.write((str2 + "\n").getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean writeExpection(String str) {
        String logPath = getLogPath();
        try {
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
}
