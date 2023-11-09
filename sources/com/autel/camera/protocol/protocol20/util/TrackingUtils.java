package com.autel.camera.protocol.protocol20.util;

import android.text.TextUtils;
import com.autel.common.camera.visual.TrackingArea;
import com.autel.internal.sdk.util.AutelDirPathUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TrackingUtils {
    private static String TRACKING_PATH = (AutelDirPathUtils.getAppDir() + "/TrackCache");
    public static int index = 0;
    public static volatile boolean isFlag = true;
    public static boolean isRecording = false;
    public static volatile boolean isStart = false;
    private static String mFileName = (getTimeStamp() + "_ActiveTrack");
    private static Timer timer;

    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss", Locale.US).format(new Date());
    }

    public static boolean isCacheTracking() {
        return new File(TRACKING_PATH).exists();
    }

    public static void writeTrackingData(TrackingArea trackingArea) {
        if (isRecording) {
            if (!isStart) {
                mFileName = getTimeStamp() + "_ActiveTrack";
                isStart = true;
                Timer timer2 = new Timer();
                timer = timer2;
                timer2.schedule(new TimerTask() {
                    public void run() {
                        if (TrackingUtils.isStart) {
                            TrackingUtils.index++;
                        }
                    }
                }, 0, 33);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{\n");
            sb.append("     \"ActiveTrack_info\"  = ");
            sb.append(" {\n");
            sb.append("         trackingRect = ");
            sb.append(" { ");
            sb.append(" { ");
            sb.append(trackingArea.getAreaXRatio());
            sb.append("," + trackingArea.getAreaYRatio());
            sb.append(" },");
            sb.append(" { ");
            sb.append(trackingArea.getWidthRatio());
            sb.append("," + trackingArea.getHeightRatio());
            sb.append(" } ");
            sb.append(" } \n");
            sb.append("     }; \n");
            sb.append("     \"Record_index\" = " + index + ";");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n     Time = ");
            sb2.append(getTimeStamp());
            sb.append(sb2.toString());
            sb.append("\n};\n");
            writeLog(mFileName, sb.toString());
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

    public static String getLogPath(String str) {
        File file = new File(TRACKING_PATH);
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

    public static void stopRecordData() {
        index = 0;
        isStart = false;
        isFlag = false;
        Timer timer2 = timer;
        if (timer2 != null) {
            timer2.cancel();
        }
    }
}
