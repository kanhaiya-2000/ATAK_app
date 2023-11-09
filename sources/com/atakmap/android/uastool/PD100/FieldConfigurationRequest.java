package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class FieldConfigurationRequest {
    private static final String TAG = "FieldConfigurationRequest";
    private final int datalinkId;
    byte reqField;
    int reqMessage;
    private final int stationNum;
    private final int vsmId;

    public FieldConfigurationRequest(byte[] bArr) {
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
        byte b = wrap.get();
        Log.d(TAG, "Request Type: " + b);
        this.reqMessage = wrap.getInt();
        Log.d(TAG, "Requested  Message: " + this.reqMessage);
        this.reqField = wrap.get();
        Log.d(TAG, "Request Field: " + this.reqField);
        int i5 = wrap.getInt();
        this.stationNum = i5;
        Log.d(TAG, "Station Num: " + i5);
        byte b2 = wrap.get();
        Log.d(TAG, "Sensor Select: " + b2);
    }
}
