package com.atakmap.android.uastool.PD100;

import com.atakmap.coremap.log.Log;
import java.nio.ByteBuffer;

class VehicleSteeringCommand {
    private static final String TAG = "VehicleSteeringCommand";
    float altimeterSetting;
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

    public VehicleSteeringCommand(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        String buildTimestamp = Stanag4586Server.buildTimestamp(wrap.getDouble());
        Log.d(TAG, "TIMESTAMP: " + buildTimestamp);
        int i = wrap.getInt();
        Log.d(TAG, "Vehicle ID: " + i);
        int i2 = wrap.getInt();
        Log.d(TAG, "CUCS ID: " + i2);
        this.altitudeCommType = wrap.get();
        Log.d(TAG, "Altitude Command Type: " + Stanag4586Server.byteToHex(this.altitudeCommType));
        this.commAltitude = wrap.getFloat();
        Log.d(TAG, "Commanded Altitude: " + this.commAltitude);
        float f = wrap.getFloat();
        Log.d(TAG, "Commanded Vertical Speed: " + f);
        this.headCommType = wrap.get();
        Log.d(TAG, "Heading Command Type: " + Stanag4586Server.byteToHex(this.headCommType));
        this.commHeading = wrap.getFloat();
        Log.d(TAG, "Commanded Heading: " + this.commHeading);
        this.commCourse = wrap.getFloat();
        Log.d(TAG, "Commanded Course: " + this.commCourse);
        this.commTurnRate = wrap.getFloat();
        Log.d(TAG, "Commanded Turn Rate: " + this.commTurnRate);
        this.commRollRate = wrap.getFloat();
        Log.d(TAG, "Commanded Roll Rate: " + this.commRollRate);
        this.commRoll = wrap.getFloat();
        Log.d(TAG, "Commanded Roll: " + this.commRoll);
        this.commSpeed = wrap.getFloat();
        Log.d(TAG, "Commanded Speed: " + this.commSpeed);
        this.speedType = wrap.get();
        Log.d(TAG, "Speed Type: " + Stanag4586Server.byteToHex(this.speedType));
        short s = wrap.getShort();
        Log.d(TAG, "Commanded Waypoint Number: " + s);
        this.altimeterSetting = wrap.getFloat();
        Log.d(TAG, "Altimeter Setting: " + this.altimeterSetting);
        this.altitudeType = wrap.get();
        Log.d(TAG, "Altitude Type: " + Stanag4586Server.byteToHex(this.altitudeType));
        double d = wrap.getDouble();
        Log.d(TAG, "Loiter Position Latitude: " + d);
        double d2 = wrap.getDouble();
        Log.d(TAG, "Loiter Position Longitude: " + d2);
    }
}
