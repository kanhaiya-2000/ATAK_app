package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class AvRoute {
    private static final String TAG = "AvRoute";
    byte routeType;

    public AvRoute(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        short s = wrap.getShort();
        Log.d(TAG, "Initial Waypoint Number: " + s);
        byte[] bArr2 = new byte[33];
        wrap.get(bArr2);
        String str = new String(bArr2);
        Log.d(TAG, "Route ID: " + str);
        this.routeType = wrap.get();
        Log.d(TAG, "Route Type: " + this.routeType);
    }
}
