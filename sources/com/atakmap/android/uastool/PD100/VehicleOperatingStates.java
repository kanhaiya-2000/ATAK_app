package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class VehicleOperatingStates {
    private static final String TAG = "VehicleOperatingStates";
    byte altitudeCommType;
    byte altitudeType;
    float commAltitude;
    float commCourse;
    float commHeading;
    float commRoll;
    float commRollRate;
    float commSpeed;
    float commTurnRate;
    byte headCommType;
    byte speedType;

    public VehicleOperatingStates(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        this.commAltitude = wrap.getFloat();
        Log.d(TAG, "Commanded Altitude: " + this.commAltitude);
        this.altitudeType = wrap.get();
        Log.d(TAG, "Altitude Type: " + this.altitudeType);
        this.commHeading = wrap.getFloat();
        Log.d(TAG, "Commanded Heading: " + this.commHeading);
        this.commCourse = wrap.getFloat();
        Log.d(TAG, "Commanded Course: " + this.commCourse);
        this.commTurnRate = wrap.getFloat();
        Log.d(TAG, "Commanded Turn Rate: " + this.commTurnRate);
        this.commRollRate = wrap.getFloat();
        Log.d(TAG, "Commanded Roll Rate: " + this.commRollRate);
        this.commSpeed = wrap.getFloat();
        Log.d(TAG, "Commanded Speed: " + this.commSpeed);
        this.speedType = wrap.get();
        Log.d(TAG, "Speed Type: " + this.speedType);
        short s = wrap.getShort();
        Log.d(TAG, "Power Level: " + s);
        byte b = wrap.get();
        Log.d(TAG, "Flap Deployment Angle: " + b);
        byte b2 = wrap.get();
        Log.d(TAG, "Speed Brake Deployment Angle: " + b2);
        byte b3 = wrap.get();
        Log.d(TAG, "Landing Gear State: " + b3);
        float f = wrap.getFloat();
        Log.d(TAG, "Current Propulsion Energy Level: " + f);
        float f2 = wrap.getFloat();
        Log.d(TAG, "Current Propulsion Energy Usage Rate: " + f2);
        this.commRoll = wrap.getFloat();
        Log.d(TAG, "Commanded Roll: " + this.commRoll);
        this.altitudeCommType = wrap.get();
        Log.d(TAG, "Altitude Command Type: " + this.altitudeCommType);
        this.headCommType = wrap.get();
        Log.d(TAG, "Heading Command Type: " + this.headCommType);
    }
}
