package com.autel.internal.video.core.decoder2.utils;

import com.autel.util.log.LocallogSave;

public class VideoDecoderLogUtils {
    private static final String TAG = "VIDEODECODERLOG";
    private static boolean isWriteLogEnable;

    public static void setWriteLogEnable(boolean z) {
        isWriteLogEnable = z;
    }

    public static void writeNecessaryLog(String str, boolean z, boolean z2) {
        if (isWriteLogEnable) {
            LocallogSave.writeNecessaryLog(TAG, str, z, z2);
        }
    }

    public static void writeNecessaryLog(String str) {
        if (isWriteLogEnable) {
            LocallogSave.writeNecessaryLog(TAG, str);
        }
    }
}
