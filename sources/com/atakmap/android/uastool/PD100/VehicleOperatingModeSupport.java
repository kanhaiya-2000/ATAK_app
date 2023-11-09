package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class VehicleOperatingModeSupport {
    private static final String TAG = "VehicleOperatingModeSupport";
    byte fltPathControlMode;

    public VehicleOperatingModeSupport(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        this.fltPathControlMode = wrap.get();
        Log.d(TAG, "Select Flight Path Control Mode: " + Stanag4586Server.byteToHex(this.fltPathControlMode));
    }
}
