package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class EoIrConfigurationState {
    private static final String TAG = "EoIrConfigurationState";
    private final int stationNum;
    private final int vsmId;

    public EoIrConfigurationState(byte[] bArr) {
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
        this.stationNum = i4;
        Log.d(TAG, "Station Num: " + i4);
        byte[] bArr2 = new byte[14];
        wrap.get(bArr2);
        String str = new String(bArr2);
        Log.d(TAG, "EO/IR Type: " + str);
        byte b = wrap.get();
        Log.d(TAG, "EO/IR Revision Level: " + b);
        short s = wrap.getShort();
        Log.d(TAG, "EO Vertical Image Dimension: " + s);
        short s2 = wrap.getShort();
        Log.d(TAG, "EO Horizontal Image Dimension: " + s2);
        short s3 = wrap.getShort();
        Log.d(TAG, "IR Vertical Image Dimension: " + s3);
        short s4 = wrap.getShort();
        Log.d(TAG, "IR Horizontal Image Dimension: " + s4);
        float f = wrap.getFloat();
        Log.d(TAG, "Field of Regard Elevation Min: " + f);
        float f2 = wrap.getFloat();
        Log.d(TAG, "Field of Regard Elevation Max: " + f2);
        float f3 = wrap.getFloat();
        Log.d(TAG, "Field of Regard Azimuth Min: " + f3);
        float f4 = wrap.getFloat();
        Log.d(TAG, "Field of Regard Azimuth Max: " + f4);
    }
}
