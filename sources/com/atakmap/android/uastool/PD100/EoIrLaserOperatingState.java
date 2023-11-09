package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class EoIrLaserOperatingState {
    private static final String TAG = "EoIrLaserOperatingState";
    private final int stationNum;

    public EoIrLaserOperatingState(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        int i3 = wrap.getInt();
        this.stationNum = i3;
        Log.d(TAG, "Station Num: " + i3);
        byte b = wrap.get();
        Log.d(TAG, "Addressed Sensor: " + b);
        byte b2 = wrap.get();
        Log.d(TAG, "System Operating Mode State: " + b2);
        byte b3 = wrap.get();
        Log.d(TAG, "EO Camera Status: " + b3);
        byte b4 = wrap.get();
        Log.d(TAG, "IR Polarity Status: " + b4);
        byte b5 = wrap.get();
        Log.d(TAG, "Image Output State: " + b5);
        float f = wrap.getFloat();
        Log.d(TAG, "Actual Centerline Elevation Angle: " + f);
        float f2 = wrap.getFloat();
        Log.d(TAG, "Actual Vertical Field of View: " + f2);
        float f3 = wrap.getFloat();
        Log.d(TAG, "Actual Centerline Azimuth Angle: " + f3);
        float f4 = wrap.getFloat();
        Log.d(TAG, "Actual Horizontal Field of View: " + f4);
        float f5 = wrap.getFloat();
        Log.d(TAG, "Actual Sensor Rotation Angle: " + f5);
        byte b6 = wrap.get();
        Log.d(TAG, "Image Position: " + b6);
        double d = wrap.getDouble();
        Log.d(TAG, "Image Center Latitude: " + d);
        double d2 = wrap.getDouble();
        Log.d(TAG, "Image Center Longitude: " + d2);
        float f6 = wrap.getFloat();
        Log.d(TAG, "Image Center Altitude: " + f6);
        byte b7 = wrap.get();
        Log.d(TAG, "Pointing Mode State: " + b7);
        byte b8 = wrap.get();
        Log.d(TAG, "Preplan Mode: " + b8);
        float f7 = wrap.getFloat();
        Log.d(TAG, "Reported Range: " + f7);
        byte b9 = wrap.get();
        Log.d(TAG, "Fire Laser Pointer/Rangefinder Status: " + b9);
        byte b10 = wrap.get();
        Log.d(TAG, "Selected Laser Rangefinder First/Last Pulse: " + b10);
        short s = wrap.getShort();
        Log.d(TAG, "Laser Designator Code: " + s);
        byte b11 = wrap.get();
        Log.d(TAG, "Laser Designator Status: " + b11);
    }
}
