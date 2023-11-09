package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class FieldConfigurationCommand {
    private static final String TAG = "FieldConfigurationCommand";
    private final int datalinkId;
    byte routeType;
    private final int stationNum;
    private final int vsmId;

    public FieldConfigurationCommand(byte[] bArr) {
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
        int i5 = wrap.getInt();
        this.stationNum = i5;
        Log.d(TAG, "Station Num: " + i5);
        int i6 = wrap.getInt();
        Log.d(TAG, "Reported Message: " + i6);
        byte b = wrap.get();
        Log.d(TAG, "Reported Field: " + b);
        byte b2 = wrap.get();
        Log.d(TAG, "Field Available: " + b2);
        byte b3 = wrap.get();
        Log.d(TAG, "Reported Enumerated Index: " + b3);
        byte b4 = wrap.get();
        Log.d(TAG, "Enumerated Index Enable: " + b4);
        this.routeType = wrap.get();
        Log.d(TAG, "Route Type: " + this.routeType);
    }
}
