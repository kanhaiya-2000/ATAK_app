package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class InertialStates {
    private static final String TAG = "InertialStates";
    float altitude;
    byte altitudeType;
    double latitude;
    double longitude;

    public InertialStates(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        this.latitude = wrap.getDouble();
        Log.d(TAG, "Latitude: " + this.latitude);
        this.longitude = wrap.getDouble();
        Log.d(TAG, "Longitude: " + this.longitude);
        this.altitude = wrap.getFloat();
        Log.d(TAG, "Altitude: " + this.altitude);
        this.altitudeType = wrap.get();
        Log.d(TAG, "Altitude Type: " + this.altitudeType);
        float f = wrap.getFloat();
        Log.d(TAG, "U Speed: " + f);
        float f2 = wrap.getFloat();
        Log.d(TAG, "V Speed: " + f2);
        float f3 = wrap.getFloat();
        Log.d(TAG, "W Speed: " + f3);
        float f4 = wrap.getFloat();
        Log.d(TAG, "U Accel: " + f4);
        float f5 = wrap.getFloat();
        Log.d(TAG, "V Accel: " + f5);
        float f6 = wrap.getFloat();
        Log.d(TAG, "W Accel: " + f6);
        float f7 = wrap.getFloat();
        Log.d(TAG, "Phi: " + f7);
        float f8 = wrap.getFloat();
        Log.d(TAG, "Theta: " + f8);
        float f9 = wrap.getFloat();
        Log.d(TAG, "Psi: " + f9);
        float f10 = wrap.getFloat();
        Log.d(TAG, "Phi Dot: " + f10);
        float f11 = wrap.getFloat();
        Log.d(TAG, "Theta Dot: " + f11);
        float f12 = wrap.getFloat();
        Log.d(TAG, "Psi Dot: " + f12);
        float f13 = wrap.getFloat();
        Log.d(TAG, "Magnetic Variation: " + f13);
    }
}
