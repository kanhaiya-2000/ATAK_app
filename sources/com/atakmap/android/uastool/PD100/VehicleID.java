package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class VehicleID {
    private static final String TAG = "VehicleID";
    byte[] missIdBytes;
    String missIdStr = new String(this.missIdBytes);
    private final short vehicleSubType;
    private final short vehicleType;
    private final int vsmId;

    public VehicleID(byte[] bArr) {
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
        Log.d(TAG, "Vehicle ID Update: " + i4);
        short s = wrap.getShort();
        this.vehicleType = s;
        Log.d(TAG, "Vehicle Type: " + s);
        short s2 = wrap.getShort();
        this.vehicleSubType = s2;
        Log.d(TAG, "Vehicle SubType: " + s2);
        byte b = wrap.get();
        Log.d(TAG, "Owned Country Code: " + Stanag4586Server.byteToHex(b));
        byte[] bArr2 = new byte[16];
        wrap.get(bArr2);
        String str = new String(bArr2);
        Log.d(TAG, "Tail Number: " + str);
        byte[] bArr3 = new byte[20];
        this.missIdBytes = bArr3;
        wrap.get(bArr3);
        Log.d(TAG, "Mission ID: " + this.missIdStr);
        byte[] bArr4 = new byte[32];
        wrap.get(bArr4);
        String str2 = new String(bArr4);
        Log.d(TAG, "ATC Callsign: " + str2);
        short s3 = wrap.getShort();
        Log.d(TAG, "Configuration Checksum: " + s3);
    }
}
