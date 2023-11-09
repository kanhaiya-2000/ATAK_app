package com.o3dr.android.client.utils;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.droidplanner.services.android.impl.utils.file.DirectoryPath;

public class FileUtils {
    public static final String CAMERA_FILENAME_EXT = ".xml";
    public static final SimpleDateFormat timestampFormatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS", Locale.US);

    public static File[] getCameraInfoFileList(Context context) {
        return getFileList(DirectoryPath.getCameraInfoPath(context), new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.contains(FileUtils.CAMERA_FILENAME_EXT);
            }
        });
    }

    private static File[] getFileList(String str, FilenameFilter filenameFilter) {
        File file = new File(str);
        if (!file.exists()) {
            return new File[0];
        }
        return file.listFiles(filenameFilter);
    }

    public static FileOutputStream getExceptionFileStream(Context context) {
        File file = new File(DirectoryPath.getCrashLogPath(context));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, getTimeStamp() + ".log");
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    public static String getTimeStamp(long j) {
        return timestampFormatter.format(new Date(j));
    }

    private static String getTimeStamp() {
        return getTimeStamp(System.currentTimeMillis());
    }

    public static String getFilenameWithoutExtension(File file) {
        return getFilenameWithoutExtension(file.getName());
    }

    public static String getFilenameWithoutExtension(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf >= 0 ? str.substring(0, lastIndexOf) : str;
    }

    public static String getFileExtension(File file) {
        return getFileExtension(file.getName());
    }

    public static String getFileExtension(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf >= 0 ? str.substring(lastIndexOf) : "";
    }
}
