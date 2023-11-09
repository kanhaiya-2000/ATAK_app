package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class MessageAcknowledgement {
    private static final String TAG = "MessageAcknowledgement";
    private final int datalinkId;
    private final int vsmId;

    public MessageAcknowledgement(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        int i3 = wrap.getInt();
        this.vsmId = i3;
        Log.d(TAG, "VSM ID: " + i3);
        int i4 = wrap.getInt();
        this.datalinkId = i4;
        Log.d(TAG, "Data Link ID: " + i4);
        double d = wrap.getDouble();
        Log.d(TAG, "Original Message Time Stamp: " + Stanag4586Server.buildTimestamp(d));
        float f = wrap.getFloat();
        Log.d(TAG, "Original Message Instance Id: " + f);
        float f2 = wrap.getFloat();
        Log.d(TAG, "Original Message Type: " + f2);
    }
}
