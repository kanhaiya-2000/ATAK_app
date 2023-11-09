package com.atakmap.android.uastool.p000av;

import com.atakmap.android.uastool.MAVLink.enums.MAV_SYS_STATUS_SENSOR;
import com.google.common.primitives.Ints;

/* renamed from: com.atakmap.android.uastool.av.DownlinkDataLR */
class DownlinkDataLR extends GCSMessage {
    private final boolean autoland;
    private final boolean autolandLatched;
    private final short avionicsID;
    private final double avxTime;
    private final boolean battWarn;
    private final boolean battWarnCapable;
    private final boolean cameraPwr;
    private final int channel;
    private final boolean eepromFail;
    private final byte expStatusFlags1;
    private final byte expStatusFlags2;
    private final boolean fieldTCOff;
    private final int flightMode;
    private final double flightTime;
    private final boolean flying;
    private final boolean gndTrackStale;
    private final byte gpsCountdown;
    private final boolean gpsTimeout;
    private final boolean gyroCal;
    private final boolean inOrbit;
    private final boolean inOrbitStatus;
    private final boolean landing;
    private final boolean lowBattery;
    private final boolean magDevComp;
    private final boolean magXYCal;
    private final boolean magZCal;
    private final boolean missionGen;
    private final boolean mslAltitude;
    private final double originAltitude;
    private final double originLatitude;
    private final double originLongitude;
    private final boolean originSet;
    private final byte planeType;
    private final boolean rally;
    private final double rudderDeflection;
    private final double softwareVersion;
    private final int statusFlags;
    private final double targetAirspeed;
    private final double targetAltitude;
    private final double targetClimbRate;
    private final double targetLatitude;
    private final double targetLongitude;
    private final byte targetWaypoint;
    private final double uavTemperature;
    private final double uavVoltage;
    private final boolean ulTimeout;
    private final double uplinkFPS;
    private final boolean usingDTED;
    private final boolean videoSel;
    private final double windDirection;
    private final double windSpeed;

    public DownlinkDataLR(byte[] bArr) {
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
        this.gpsTimeout = (262144 & i) == 262144;
        this.flying = (131072 & i) == 131072;
        this.gndTrackStale = (65536 & i) == 65536;
        this.fieldTCOff = (32768 & i) == 32768;
        this.channel = (i & 30720) >> 11;
        this.missionGen = (i & 1024) == 1024;
        this.cameraPwr = (i & 128) == 128;
        this.videoSel = (i & 64) == 64;
        this.autoland = (i & 16) == 16;
        this.flightMode = i & 15;
        this.flightTime = getDouble(bArr[8], bArr[9], 1.0d);
        this.avionicsID = getShort(bArr[10], bArr[11]);
        this.planeType = bArr[12];
        this.softwareVersion = getDouble(bArr[13], bArr[14], 0.01d);
        this.uplinkFPS = getDouble((byte) 0, bArr[15], 1.0d);
        this.targetWaypoint = bArr[16];
        this.targetLatitude = radiansToDegrees(getDouble(bArr[17], bArr[18], bArr[19], bArr[20], 1.0E-8d));
        this.targetLongitude = radiansToDegrees(getDouble(bArr[21], bArr[22], bArr[23], bArr[24], 1.0E-8d));
        this.targetClimbRate = getDouble(bArr[25], bArr[26], 0.01d);
        this.targetAltitude = getDouble(bArr[27], bArr[28], 1.0d);
        this.targetAirspeed = getDouble(bArr[29], bArr[30], 0.01d);
        this.rudderDeflection = getDouble(bArr[31], bArr[32], 0.001d);
        this.uavVoltage = getDouble(bArr[33], bArr[34], 0.001d);
        this.uavTemperature = getDouble(bArr[35], bArr[36], 0.01d);
        this.originLatitude = radiansToDegrees(getDouble(bArr[37], bArr[38], bArr[39], bArr[40], 1.0E-8d));
        this.originLongitude = radiansToDegrees(getDouble(bArr[41], bArr[42], bArr[43], bArr[44], 1.0E-8d));
        this.originAltitude = getDouble(bArr[45], bArr[46], 1.0d);
        this.gpsCountdown = bArr[47];
        this.windSpeed = getDouble(bArr[48], bArr[49], 0.01d);
        this.windDirection = radiansToDegrees(getDouble(bArr[50], bArr[51], 0.001d));
        byte b = bArr[52];
        this.expStatusFlags1 = b;
        this.expStatusFlags2 = bArr[53];
        this.battWarn = (b & 128) > 0;
        this.battWarnCapable = (b & 64) > 0;
        this.inOrbit = (b & 8) > 0;
        this.inOrbitStatus = (4 & b) > 0 ? true : z;
    }

    public int getPlaneType() {
        return this.planeType;
    }

    public int getFlightMode() {
        return this.flightMode;
    }

    public byte getTargetWaypoint() {
        return this.targetWaypoint;
    }

    public double getTargetLatitude() {
        return this.targetLatitude;
    }

    public double getTargetLongitude() {
        return this.targetLongitude;
    }

    public double getTargetAltitude() {
        return this.targetAltitude;
    }

    public double getFlightTime() {
        return this.flightTime;
    }

    public double getTargetClimbRate() {
        return this.targetClimbRate;
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    public double getWindDirection() {
        return this.windDirection;
    }

    public double getTemperature() {
        return this.uavTemperature;
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

    public short getAvionicsID() {
        return this.avionicsID;
    }

    public double getSoftwareVersion() {
        return this.softwareVersion;
    }

    public double getUplinkFPS() {
        return this.uplinkFPS;
    }

    public double getTargetAirspeed() {
        return this.targetAirspeed;
    }

    public double getRudderDeflection() {
        return this.rudderDeflection;
    }

    public double getUavVoltage() {
        return this.uavVoltage;
    }

    public double getUavTemperature() {
        return this.uavTemperature;
    }

    public double getOriginLatitude() {
        return this.originLatitude;
    }

    public double getOriginLongitude() {
        return this.originLongitude;
    }

    public double getOriginAltitude() {
        return this.originAltitude;
    }

    public byte getGpsCountdown() {
        return this.gpsCountdown;
    }

    public byte getExpStatusFlags1() {
        return this.expStatusFlags1;
    }

    public byte getExpStatusFlags2() {
        return this.expStatusFlags2;
    }

    public boolean isBattWarn() {
        return this.battWarn;
    }

    public boolean isBattWarnCapable() {
        return this.battWarnCapable;
    }

    public boolean isInOrbit() {
        return this.inOrbit;
    }

    public boolean isInOrbitStatus() {
        return this.inOrbitStatus;
    }
}
