package com.autel.downloader.utils;

import android.text.TextUtils;
import com.autel.downloader.bean.DownloadTask;
import com.autel.sdk10.utils.Md5Utils;
import com.autel.util.log.AutelLog;
import java.io.File;

public class DownloadUtils {
    public static final int DEFAULT_THREAD_COUNT = 5;
    private static final String TAG = "DownloadUtils";

    public static int getValidNetworkThreadCount(int i) {
        if (i == 0) {
            AutelLog.m15090w(TAG, "requireCount cannot 0 , default count is 5");
            return 5;
        } else if (i > 10) {
            AutelLog.m15090w(TAG, "max count is " + 10);
            return 10;
        } else if (i >= 1) {
            return i;
        } else {
            AutelLog.m15090w(TAG, "min count is " + 1);
            return 1;
        }
    }

    public static int getTaskId(String str, String str2) {
        return Md5Utils.getMD5String(str + str2).hashCode();
    }

    public static int isTaskCanContinue(DownloadTask downloadTask, boolean z) {
        if (downloadTask == null) {
            AutelLog.m15082d(TAG, "can't continue model == null");
            return -1;
        }
        String str = downloadTask.getPath() + ".temp";
        if (TextUtils.equals(str, ".temp")) {
            AutelLog.m15082d(TAG, "can't continue path == null");
            return -2;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (!exists || isDirectory) {
            AutelLog.m15082d(TAG, "file is not exist,can't continue.");
            return -4;
        } else if (file.length() < downloadTask.getTotalLength()) {
            return 0;
        } else {
            if (!z) {
                return 1;
            }
            AutelLog.m15090w(TAG, "this task had download complete, will restart download ");
            AutelLog.m15082d(TAG, "delete file \"" + str + "\":" + file.delete());
            return -5;
        }
    }
}
