package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class MissionUploadDownloadStatus {
    private static final String TAG = "MissionUploadDownloadStatus";

    public MissionUploadDownloadStatus(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        byte b = wrap.get();
        Log.d(TAG, "Status: " + b);
        byte b2 = wrap.get();
        Log.d(TAG, "Percent Complete: " + b2);
    }
}
