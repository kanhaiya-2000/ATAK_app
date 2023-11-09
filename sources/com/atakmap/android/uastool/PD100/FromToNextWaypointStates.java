package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class FromToNextWaypointStates {
    private static final String TAG = "FromToNextWaypointStates";
    byte altitudeType;
    byte speedType;

    public FromToNextWaypointStates(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        this.altitudeType = wrap.get();
        Log.d(TAG, "Altitude Type: " + this.altitudeType);
        this.speedType = wrap.get();
        Log.d(TAG, "Speed Type: " + this.speedType);
        double d = wrap.getDouble();
        Log.d(TAG, "From Waypoint Latitude: " + d);
        double d2 = wrap.getDouble();
        Log.d(TAG, "From Waypoint Longitude: " + d2);
        float f = wrap.getFloat();
        Log.d(TAG, "From Waypoint Altitude: " + f);
        double d3 = wrap.getDouble();
        Log.d(TAG, "From Waypoint Time: " + Stanag4586Server.buildTimestamp(d3));
        short s = wrap.getShort();
        Log.d(TAG, "From Waypoint Number: " + s);
        double d4 = wrap.getDouble();
        Log.d(TAG, "To Waypoint Latitude: " + d4);
        double d5 = wrap.getDouble();
        Log.d(TAG, "To Waypoint Longitude: " + d5);
        float f2 = wrap.getFloat();
        Log.d(TAG, "To Waypoint Altitude: " + f2);
        float f3 = wrap.getFloat();
        Log.d(TAG, "To Waypoint Speed: " + f3);
        double d6 = wrap.getDouble();
        Log.d(TAG, "To Waypoint Time: " + Stanag4586Server.buildTimestamp(d6));
        short s2 = wrap.getShort();
        Log.d(TAG, "To Waypoint Number: " + s2);
        double d7 = wrap.getDouble();
        Log.d(TAG, "Next Waypoint Latitude: " + d7);
        double d8 = wrap.getDouble();
        Log.d(TAG, "Next Waypoint Longitude: " + d8);
        float f4 = wrap.getFloat();
        Log.d(TAG, "Next Waypoint Altitude: " + f4);
        float f5 = wrap.getFloat();
        Log.d(TAG, "Next Waypoint Speed: " + f5);
        double d9 = wrap.getDouble();
        Log.d(TAG, "Next Waypoint Time: " + Stanag4586Server.buildTimestamp(d9));
        short s3 = wrap.getShort();
        Log.d(TAG, "Next Waypoint Number: " + s3);
    }
}
