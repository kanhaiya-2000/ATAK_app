package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class PayloadSteeringCommand {
    private static final String TAG = "PayloadSteeringCommand";
    float altitude;
    byte altitudeType;
    double latitude;
    double longitude;
    private final int stationNum;

    public PayloadSteeringCommand(byte[] bArr) {
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
        float f = wrap.getFloat();
        Log.d(TAG, "Set Center Azimuth Angle: " + f);
        float f2 = wrap.getFloat();
        Log.d(TAG, "Set Center Elevation Angle: " + f2);
        byte b = wrap.get();
        Log.d(TAG, "Set Zoom: " + b);
        float f3 = wrap.getFloat();
        Log.d(TAG, "Set Horizontal Field of View: " + f3);
        float f4 = wrap.getFloat();
        Log.d(TAG, "Set Vertical Field of View: " + f4);
        float f5 = wrap.getFloat();
        Log.d(TAG, "Set Horizontal Slew Rate: " + f5);
        float f6 = wrap.getFloat();
        Log.d(TAG, "Set Vertical Slew Rate: " + f6);
        this.latitude = wrap.getDouble();
        Log.d(TAG, "Latitude: " + this.latitude);
        this.longitude = wrap.getDouble();
        Log.d(TAG, "Longitude: " + this.longitude);
        this.altitude = wrap.getFloat();
        Log.d(TAG, "Altitude: " + this.altitude);
        this.altitudeType = wrap.get();
        Log.d(TAG, "ALtitude Type: " + this.altitudeType);
        byte b2 = wrap.get();
        Log.d(TAG, "Set Focus: " + b2);
        byte b3 = wrap.get();
        Log.d(TAG, "Focus Type: " + b3);
    }
}
