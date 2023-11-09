package com.atakmap.android.uastool.p000av;

import com.atakmap.android.uastool.MAVLink.enums.MAV_SYS_STATUS_SENSOR;
import com.google.common.primitives.Ints;

/* renamed from: com.atakmap.android.uastool.av.DownlinkDataHR */
class DownlinkDataHR extends GCSMessage {
    private final double accelX;
    private final double accelY;
    private final double accelZ;
    private final double airspeed;
    private final double altitude;
    private final boolean autoland;
    private final boolean autolandLatched;
    private final double avxTime;
    private final double bankAngle;
    private final boolean cameraPwr;
    private final int channel;
    private final double climbRate;
    private final boolean eepromFail;
    private final double elevatorDeflection;
    private final boolean fieldTCOff;
    private final int flightMode;
    private final boolean flying;
    private final boolean gndTrackStale;
    private final boolean gpsTimeout;
    private final boolean gyroCal;
    private final boolean landing;
    private final boolean lowBattery;
    private final boolean magDevComp;
    private final double magHeading;
    private final double magHeadingRaw;
    private final boolean magXYCal;
    private final boolean magZCal;
    private final boolean missionGen;
    private final boolean mslAltitude;
    private final boolean originSet;
    private final double pitchAngle;
    private final double pitchRate;
    private final boolean rally;
    private final double rollRate;
    private final double rudder;
    private final int statusFlags;
    private final double throttle;
    private final double turnRateCmd;
    private final boolean ulTimeout;
    private final boolean usingDTED;
    private final boolean videoSel;
    private final double yawRate;

    public DownlinkDataHR(byte[] bArr) {
        boolean z = false;
        this.avxTime = getDouble(bArr[0], bArr[1], bArr[2], bArr[3], 0.01d);
        int i = getInt(bArr[4], bArr[5], bArr[6], bArr[7]);
        this.statusFlags = i;
        this.eepromFail = (i & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        this.mslAltitude = (i & Ints.MAX_POWER_OF_TWO) == 1073741824;
        this.landing = (i & 536870912) == 536870912;
        this.usingDTED = (i & 268435456) == 268435456;
        this.magZCal = (i & 134217728) == 134217728;
        this.magXYCal = (i & 67108864) == 67108864;
        this.gyroCal = (i & MAV_SYS_STATUS_SENSOR.MAV_SYS_STATUS_SENSOR_BATTERY) == 33554432;
        this.originSet = (i & 16777216) == 16777216;
        this.magDevComp = (i & MAV_SYS_STATUS_SENSOR.MAV_SYS_STATUS_REVERSE_MOTOR) == 8388608;
        this.rally = (i & 4194304) == 4194304;
        this.autolandLatched = (i & 2097152) == 2097152;
        this.lowBattery = (i & 1048576) == 1048576;
        this.ulTimeout = (i & 524288) == 524288;
        this.gpsTimeout = (i & 262144) == 262144;
        this.flying = (i & 131072) == 131072;
        this.gndTrackStale = (i & 65536) == 65536;
        this.fieldTCOff = (i & 32768) == 32768;
        this.channel = (i & 30720) >> 11;
        this.missionGen = (i & 1024) == 1024;
        this.cameraPwr = (i & 128) == 128;
        this.videoSel = (i & 64) == 64;
        this.autoland = (i & 16) == 16 ? true : z;
        this.flightMode = i & 15;
        this.climbRate = getDouble(bArr[8], bArr[9], 0.01d);
        this.altitude = getDouble(bArr[10], bArr[11], 1.0d);
        this.airspeed = getDouble(bArr[12], bArr[13], 0.01d);
        double d = getDouble(bArr[14], bArr[15], 0.001d);
        this.magHeadingRaw = d;
        this.magHeading = radiansToDegrees(d);
        this.pitchAngle = radiansToDegrees(getDouble(bArr[16], bArr[17], 0.001d));
        this.bankAngle = radiansToDegrees(getDouble(bArr[18], bArr[19], 0.001d));
        this.yawRate = radiansToDegrees(getDouble(bArr[20], bArr[21], 0.001d));
        this.pitchRate = radiansToDegrees(getDouble(bArr[22], bArr[23], 0.001d));
        this.rollRate = radiansToDegrees(getDouble(bArr[24], bArr[25], 0.001d));
        this.rudder = radiansToDegrees(getDouble(bArr[26], bArr[27], 0.001d));
        this.elevatorDeflection = radiansToDegrees(getDouble(bArr[28], bArr[29], 0.001d));
        this.throttle = getDouble(bArr[30], bArr[31], 0.1d);
        this.turnRateCmd = radiansToDegrees(getDouble(bArr[32], bArr[33], 0.001d));
        this.accelX = getDouble(bArr[34], bArr[35], 0.001d);
        this.accelZ = getDouble(bArr[36], bArr[37], 0.001d);
        this.accelY = getDouble(bArr[38], bArr[39], 0.001d);
    }

    public double getPitchRate() {
        return this.pitchRate;
    }

    public double getRollRate() {
        return this.rollRate;
    }

    public double getYawRate() {
        return this.yawRate;
    }

    public double getPitch() {
        return this.pitchAngle;
    }

    public double getRoll() {
        return this.bankAngle;
    }

    public double getYaw() {
        return this.magHeading;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public double getMagHeadingRaw() {
        return this.magHeadingRaw;
    }

    public double getMagHeading() {
        return this.magHeading;
    }

    public double getAvxTime() {
        return this.avxTime;
    }

    public int getStatusFlags() {
        return this.statusFlags;
    }

    public boolean isEepromFail() {
        return this.eepromFail;
    }

    public boolean isMslAltitude() {
        return this.mslAltitude;
    }

    public boolean isLanding() {
        return this.landing;
    }

    public boolean isUsingDTED() {
        return this.usingDTED;
    }

    public boolean isMagZCal() {
        return this.magZCal;
    }

    public boolean isMagXYCal() {
        return this.magXYCal;
    }

    public boolean isGyroCal() {
        return this.gyroCal;
    }

    public boolean isOriginSet() {
        return this.originSet;
    }

    public boolean isMagDevComp() {
        return this.magDevComp;
    }

    public boolean isRally() {
        return this.rally;
    }

    public boolean isAutolandLatched() {
        return this.autolandLatched;
    }

    public boolean isLowBattery() {
        return this.lowBattery;
    }

    public boolean isUlTimeout() {
        return this.ulTimeout;
    }

    public boolean isGpsTimeout() {
        return this.gpsTimeout;
    }

    public boolean isFlying() {
        return this.flying;
    }

    public boolean isGndTrackStale() {
        return this.gndTrackStale;
    }

    public boolean isFieldTCOff() {
        return this.fieldTCOff;
    }

    public int getChannel() {
        return this.channel;
    }

    public boolean isMissionGen() {
        return this.missionGen;
    }

    public boolean isCameraPwr() {
        return this.cameraPwr;
    }

    public boolean isVideoSel() {
        return this.videoSel;
    }

    public boolean isAutoland() {
        return this.autoland;
    }

    public int getFlightMode() {
        return this.flightMode;
    }

    public double getClimbRate() {
        return this.climbRate;
    }

    public double getAirspeed() {
        return this.airspeed;
    }

    public double getPitchAngle() {
        return this.pitchAngle;
    }

    public double getBankAngle() {
        return this.bankAngle;
    }

    public double getRudder() {
        return this.rudder;
    }

    public double getElevatorDeflection() {
        return this.elevatorDeflection;
    }

    public double getThrottle() {
        return this.throttle;
    }

    public double getTurnRateCmd() {
        return this.turnRateCmd;
    }
}
