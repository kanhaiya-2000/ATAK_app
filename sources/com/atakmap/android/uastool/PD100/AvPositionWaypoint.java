package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class AvPositionWaypoint {
    private static final String TAG = "AvPositionWaypoint";
    short wyPtNum;

    public AvPositionWaypoint(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        this.wyPtNum = wrap.getShort();
        Log.d(TAG, "Waypoint Number: " + this.wyPtNum);
        double d = wrap.getDouble();
        Log.d(TAG, "Waypoint to Latitude or Relative Y: " + d);
        double d2 = wrap.getDouble();
        Log.d(TAG, "Waypoint to Longitude or Relative X: " + d2);
        byte b = wrap.get();
        Log.d(TAG, "Location Type: " + b);
        float f = wrap.getFloat();
        Log.d(TAG, "Waypoint to Altitude: " + f);
        byte b2 = wrap.get();
        Log.d(TAG, "Waypoint Altitude Type: " + b2);
        byte b3 = wrap.get();
        Log.d(TAG, "ALtitude Change Behaviour: " + b3);
        float f2 = wrap.getFloat();
        Log.d(TAG, "Waypoint to Speed: " + f2);
        byte b4 = wrap.get();
        Log.d(TAG, "Waypoint Speed Type: " + b4);
        short s = wrap.getShort();
        Log.d(TAG, "Next Waypoint: " + s);
        short s2 = wrap.getShort();
        Log.d(TAG, "Contigency Waypoint A: " + s2);
        short s3 = wrap.getShort();
        Log.d(TAG, "Contigency Waypoint B: " + s3);
        double d3 = wrap.getDouble();
        Log.d(TAG, "Arrival Time: " + Stanag4586Server.buildTimestamp(d3));
        byte b5 = wrap.get();
        Log.d(TAG, "Turn Type: " + b5);
        byte b6 = wrap.get();
        Log.d(TAG, "Waypoint Type: " + b6);
        byte b7 = wrap.get();
        Log.d(TAG, "Limit Type: " + b7);
        short s4 = wrap.getShort();
        Log.d(TAG, "Loop Limit: " + s4);
    }
}
