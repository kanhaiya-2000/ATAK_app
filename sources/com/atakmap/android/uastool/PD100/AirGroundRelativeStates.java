package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class AirGroundRelativeStates {
    private static final String TAG = "AirGroundRelativeStates";
    float altimeterSetting;

    public AirGroundRelativeStates(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        float f = wrap.getFloat();
        Log.d(TAG, "Angle of Attack: " + f);
        float f2 = wrap.getFloat();
        Log.d(TAG, "Angle of Sideslip: " + f2);
        float f3 = wrap.getFloat();
        Log.d(TAG, "True Airspeed: " + f3);
        float f4 = wrap.getFloat();
        Log.d(TAG, "Indicated Airspeed: " + f4);
        float f5 = wrap.getFloat();
        Log.d(TAG, "Outside Air Temp: " + f5);
        float f6 = wrap.getFloat();
        Log.d(TAG, "U Wind: " + f6);
        float f7 = wrap.getFloat();
        Log.d(TAG, "V Wind: " + f7);
        this.altimeterSetting = wrap.getFloat();
        Log.d(TAG, "Altimeter Setting: " + this.altimeterSetting);
        float f8 = wrap.getFloat();
        Log.d(TAG, "Barometric Altitude: " + f8);
        float f9 = wrap.getFloat();
        Log.d(TAG, "Barometric Altitude Rate: " + f9);
        float f10 = wrap.getFloat();
        Log.d(TAG, "Pressure Altitude: " + f10);
        float f11 = wrap.getFloat();
        Log.d(TAG, "AGL Altitude: " + f11);
        float f12 = wrap.getFloat();
        Log.d(TAG, "WGS-84 Altitude: " + f12);
        float f13 = wrap.getFloat();
        Log.d(TAG, "U Ground: " + f13);
        float f14 = wrap.getFloat();
        Log.d(TAG, "V Ground: " + f14);
    }
}
