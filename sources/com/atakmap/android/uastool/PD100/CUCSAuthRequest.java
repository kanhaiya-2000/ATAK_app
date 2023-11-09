package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class CUCSAuthRequest {
    private static final String TAG = "CUCSAuthRequest";
    private final int controlStation;
    private final byte controlStationMode;
    private final int datalinkId;
    private final byte reqHandLOI;
    private final short vehicleSubType;
    private final short vehicleType;
    private final int vsmId;
    private final byte waitCoordMess;

    public CUCSAuthRequest(byte[] bArr) {
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
        short s = wrap.getShort();
        this.vehicleType = s;
        Log.d(TAG, "Vehicle Type: " + s);
        short s2 = wrap.getShort();
        this.vehicleSubType = s2;
        Log.d(TAG, "Vehicle SubType: " + s2);
        byte b = wrap.get();
        this.reqHandLOI = b;
        Log.d(TAG, "Requested Handover LOI: " + getReqHandoverLOI(b));
        int i5 = wrap.getInt();
        this.controlStation = i5;
        Log.d(TAG, "Controlled Station: " + Stanag4586Server.getControlledStation(i5));
        byte b2 = wrap.get();
        this.controlStationMode = b2;
        Log.d(TAG, "Controlled Station Mode: " + Stanag4586Server.getControlledStationMode(b2));
        byte b3 = wrap.get();
        this.waitCoordMess = b3;
        Log.d(TAG, "Wait for Vehicle Datalink Message: " + getWaitForVehMesage(b3));
    }

    private String getReqHandoverLOI(byte b) {
        if (b == 0) {
            return "Unspecified";
        }
        if (b == 1) {
            return "LOI 2";
        }
        if (b == 2) {
            return "LOI 3";
        }
        if (b == 4) {
            return "LOI 4";
        }
        if (b == 8) {
            return "LOI 5";
        }
        return "Unknown LOI: " + Stanag4586Server.byteToHex(b);
    }

    private String getWaitForVehMesage(byte b) {
        if (b == 0) {
            return "Don't Wait";
        }
        if (b == 1) {
            return "Wait for Message";
        }
        return "Unknown Wait for Vehicle Message: " + b;
    }
}
