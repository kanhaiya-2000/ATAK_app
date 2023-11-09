package com.autel.camera.protocol.protocol10.engine;

import android.text.TextUtils;

public class CameraRecMsgDecoder {
    private CameraRecMsgDecoder() {
    }

    public static int[] getCameraHistoResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int[] iArr = new int[64];
        String[] split = str.split(",");
        int i = 0;
        while (i < split.length && i < 64) {
            iArr[i] = Integer.valueOf(split[i]).intValue();
            i++;
        }
        return iArr;
    }
}
