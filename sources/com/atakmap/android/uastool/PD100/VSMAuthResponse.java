package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class VSMAuthResponse {
    private static final String TAG = "VSMAuthResponse";
    private final int controlStation;
    private final byte controlStationMode;
    private final int datalinkId;
    private final short vehicleSubType;
    private final short vehicleType;
    private final int vsmId;

    public VSMAuthResponse(byte[] bArr) {
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
        Log.d(TAG, "LOI Authorized: " + Stanag4586Server.byteToHex(b));
        byte b2 = wrap.get();
        Log.d(TAG, "LOI Granted: " + Stanag4586Server.byteToHex(b2));
        int i5 = wrap.getInt();
        this.controlStation = i5;
        Log.d(TAG, "Controlled Station: " + Stanag4586Server.getControlledStation(i5));
        byte b3 = wrap.get();
        this.controlStationMode = b3;
        Log.d(TAG, "Controlled Station Mode: " + Stanag4586Server.getControlledStationMode(b3));
        short s = wrap.getShort();
        this.vehicleType = s;
        Log.d(TAG, "Vehicle Type: " + s);
        short s2 = wrap.getShort();
        this.vehicleSubType = s2;
        Log.d(TAG, "Vehicle SubType: " + s2);
    }
}
