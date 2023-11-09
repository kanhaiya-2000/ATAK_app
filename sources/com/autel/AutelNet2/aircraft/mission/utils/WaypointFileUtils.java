package com.autel.AutelNet2.aircraft.mission.utils;

import android.text.TextUtils;
import com.autel.internal.sdk.util.AutelDirPathUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WaypointFileUtils {
    public static String S_WAYPOINT_FILE_NAME = "waypoint";
    public static String WAYPOINT_PATH = (AutelDirPathUtils.getAppDir() + "/Waypoint");

    public static boolean writeFile(String str) {
        try {
            String waypointPath = getWaypointPath(S_WAYPOINT_FILE_NAME);
            if (TextUtils.isEmpty(waypointPath)) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(waypointPath), true);
            fileOutputStream.write((str + "\n").getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getWaypointPath(String str) {
        File file = new File(WAYPOINT_PATH);
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
}
