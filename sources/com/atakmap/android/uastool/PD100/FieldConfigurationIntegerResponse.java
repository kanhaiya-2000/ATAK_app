package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class FieldConfigurationIntegerResponse {
    private static final String TAG = "FieldConfigurationIntegerResponse";
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

    public FieldConfigurationIntegerResponse(byte[] bArr) {
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
        int i6 = wrap.getInt();
        Log.d(TAG, "Max Value: " + i6);
        int i7 = wrap.getInt();
        Log.d(TAG, "Min Value: " + i7);
        int i8 = wrap.getInt();
        Log.d(TAG, "Max Display Value: " + i8);
        int i9 = wrap.getInt();
        Log.d(TAG, "Min Display Value: " + i9);
        int i10 = wrap.getInt();
        Log.d(TAG, "Min Display Resolution: " + i10);
        int i11 = wrap.getInt();
        Log.d(TAG, "High Caution Limit: " + i11);
        int i12 = wrap.getInt();
        Log.d(TAG, "High Warning Limit: " + i12);
        int i13 = wrap.getInt();
        Log.d(TAG, "Low Caution Limit: " + i13);
        int i14 = wrap.getInt();
        Log.d(TAG, "Low Warning Limit: " + i14);
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
