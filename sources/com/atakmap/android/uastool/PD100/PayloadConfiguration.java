package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class PayloadConfiguration {
    private static final String TAG = "PayloadConfiguration";
    private final int stationNum;
    private final int vsmId;

    public PayloadConfiguration(byte[] bArr) {
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
        Log.d(TAG, "Payload Stations Avail: " + i4);
        int i5 = wrap.getInt();
        this.stationNum = i5;
        Log.d(TAG, "Station Num: " + i5);
        short s = wrap.getShort();
        Log.d(TAG, "Payload Type: " + s);
        byte b = wrap.get();
        Log.d(TAG, "Station Door: " + b);
        byte b2 = wrap.get();
        Log.d(TAG, "Payload Recording Number: " + b2);
    }
}
