package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class FieldConfigurationEnumeratedResponse {
    private static final String TAG = "FieldConfigurationEnumeratedResponse";
    private final int datalinkId;
    byte fieldSupp;
    byte[] helpBytes;
    String helpStr = new String(this.helpBytes);
    byte reqField;
    int reqMessage;
    byte routeType;
    private final int stationNum;
    private final int vsmId;

    public FieldConfigurationEnumeratedResponse(byte[] bArr) {
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
        byte b = wrap.get();
        Log.d(TAG, "Enumeration Count: " + b);
        byte b2 = wrap.get();
        Log.d(TAG, "Enumeration Index: " + b2);
        byte[] bArr2 = new byte[16];
        wrap.get(bArr2);
        String str = new String(bArr2);
        Log.d(TAG, "Enumeration Text: " + str);
        byte[] bArr3 = new byte[80];
        this.helpBytes = bArr3;
        wrap.get(bArr3);
        Log.d(TAG, "Help Text: " + this.helpStr);
        this.routeType = wrap.get();
        Log.d(TAG, "Route Type: " + this.routeType);
    }
}
