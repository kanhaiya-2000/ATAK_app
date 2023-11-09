package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class FieldConfigurationDoubleResponse {
    private static final String TAG = "FieldConfigurationDoubleResponse";
    private final int datalinkId;
    byte fieldSupp;
    byte[] helpBytes;
    String helpStr = new String(this.helpBytes);
    byte reqField;
    int reqMessage;
    byte routeType;
    private final int stationNum;
    byte subSysId;
    private final int vsmId;

    public FieldConfigurationDoubleResponse(byte[] bArr) {
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
        this.reqMessage = wrap.getInt();
        Log.d(TAG, "Requested Message: " + this.reqMessage);
        this.reqField = wrap.get();
        Log.d(TAG, "Requested Field: " + this.reqField);
        this.fieldSupp = wrap.get();
        Log.d(TAG, "Field Supported: " + this.fieldSupp);
        double d = wrap.getDouble();
        Log.d(TAG, "Max Value: " + d);
        double d2 = wrap.getDouble();
        Log.d(TAG, "Min Value: " + d2);
        double d3 = wrap.getDouble();
        Log.d(TAG, "Max Display Value: " + d3);
        double d4 = wrap.getDouble();
        Log.d(TAG, "Min Display Value: " + d4);
        double d5 = wrap.getDouble();
        Log.d(TAG, "Min Display Resolution: " + d5);
        double d6 = wrap.getDouble();
        Log.d(TAG, "High Caution Limit: " + d6);
        double d7 = wrap.getDouble();
        Log.d(TAG, "High Warning Limit: " + d7);
        double d8 = wrap.getDouble();
        Log.d(TAG, "Low Caution Limit: " + d8);
        double d9 = wrap.getDouble();
        Log.d(TAG, "Low Warning Limit: " + d9);
        byte[] bArr2 = new byte[80];
        this.helpBytes = bArr2;
        wrap.get(bArr2);
        Log.d(TAG, "Help Text: " + this.helpStr);
        this.subSysId = wrap.get();
        Log.d(TAG, "Subsystem ID: " + this.subSysId);
        this.routeType = wrap.get();
        Log.d(TAG, "Route Type: " + this.routeType);
    }
}
