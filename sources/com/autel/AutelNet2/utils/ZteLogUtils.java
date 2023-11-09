package com.autel.AutelNet2.utils;

import android.text.TextUtils;
import com.autel.internal.sdk.util.AutelDirPathUtils;
import com.autel.util.log.LocalLogUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ZteLogUtils {
    private static String DSP_CACHE_PATH = (AutelDirPathUtils.getAppDir() + "/ZteLog/");
    private static final long FILE_MAX_SIZE = 419430400;
    private static final String LOCAL_LOG_FILENAME_1 = "zte_log_filename_1";
    private static final String LOCAL_LOG_FILENAME_2 = "zte_log_filename_2";
    private static final String LOCAL_LOG_FILENAME_3 = "zte_log_filename_3";
    public static volatile boolean isFlag = true;
    private static String localPath;

    public static boolean isDspCache() {
        return new File(DSP_CACHE_PATH).exists();
    }

    public static void mkdirNormalPath() {
        localPath = "Normal_" + getTimeStamp() + ".log";
    }

    public static void mkdirRandumpPath() {
        localPath = "Randump_" + getTimeStamp() + ".log";
    }

    public static void getDirPath() {
        File[] listFiles = new File(AutelDirPathUtils.getAppDir() + "/ZteLog/").listFiles();
        if (listFiles.length == 1) {
            localPath = listFiles[0].getName();
        }
    }

    public static void deleteBeforeFile() {
        try {
            File[] listFiles = new File(AutelDirPathUtils.getAppDir() + "/ZteLog/").listFiles();
            if (listFiles == null) {
                return;
            }
            if (listFiles.length != 1) {
                for (int i = 0; i < listFiles.length - 1; i++) {
                    listFiles[i].delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean writeLog(String str, byte[] bArr) {
        try {
            String logPath = getLogPath(str);
            if (TextUtils.isEmpty(logPath)) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(logPath), true);
            fileOutputStream.write(bArr);
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
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

    public static void saveLocalLog(byte[] bArr) {
        long fileSize = LocalLogUtil.getFileSize(getLogPath(LOCAL_LOG_FILENAME_1));
        long logSize = getLogSize(bArr);
        if (fileSize + logSize < FILE_MAX_SIZE) {
            writeLog(LOCAL_LOG_FILENAME_1, bArr);
        } else if (LocalLogUtil.getFileSize(getLogPath(LOCAL_LOG_FILENAME_2)) + logSize < FILE_MAX_SIZE) {
            writeLog(LOCAL_LOG_FILENAME_2, bArr);
        } else if (LocalLogUtil.getFileSize(getLogPath(LOCAL_LOG_FILENAME_3)) + logSize < FILE_MAX_SIZE) {
            writeLog(LOCAL_LOG_FILENAME_3, bArr);
        } else {
            reNameFile();
            saveLocalLog(bArr);
        }
    }

    private static long getLogSize(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        try {
            return (long) bArr.length;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static void reNameFile() {
        try {
            if (new File(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_1)).exists()) {
                delLocalLogFile(LOCAL_LOG_FILENAME_1);
            }
            File file = new File(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_2));
            if (file.exists()) {
                file.renameTo(getFile(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_1)));
            }
            File file2 = new File(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_3));
            if (file2.exists()) {
                file2.renameTo(getFile(LocalLogUtil.getLogPath(LOCAL_LOG_FILENAME_2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File getFile(String str) {
        try {
            return new File(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void delLocalLogFile(String str) {
        try {
            new File(LocalLogUtil.getLogPath(str)).delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
