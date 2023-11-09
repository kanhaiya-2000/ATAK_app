package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.MissionWaypoint */
public class MissionWaypoint extends GCSMessage {
    private double altitude;
    private double dted;
    private double latitude;
    private double longitude;
    private int waypointType;

    public int getWaypointType() {
        return this.waypointType;
    }

    public double getLatitudeDegrees() {
        return radiansToDegrees(this.latitude * 1.0E-8d);
    }

    public double getLongitudeDegrees() {
        return radiansToDegrees(this.longitude * 1.0E-8d);
    }

    public double getLatitudeRadians() {
        return this.latitude * 1.0E-8d;
    }

    public double getLongitudeRadians() {
        return this.longitude * 1.0E-8d;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public double getDted() {
        return this.dted;
    }

    public void setWaypointType(int i) {
        this.waypointType = i;
    }

    public void setLatitude(double d) {
        this.latitude = Math.toRadians(d);
    }

    public void setLongitude(double d) {
        this.longitude = Math.toRadians(d);
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public void setDted(double d) {
        this.dted = d;
    }

    public MissionWaypoint() {
        this.waypointType = 0;
        this.latitude = 0.0d;
        this.longitude = 0.0d;
        this.altitude = 0.0d;
        this.dted = 0.0d;
    }

    public MissionWaypoint(byte[] bArr) {
        this.waypointType = bArr[0];
        this.latitude = getDouble(bArr[1], bArr[2], bArr[3], bArr[4], 1.0d);
        this.longitude = getDouble(bArr[5], bArr[6], bArr[7], bArr[8], 1.0d);
        this.altitude = getDouble(bArr[9], bArr[10], 1.0d);
        this.dted = getDouble(bArr[11], bArr[12], 1.0d);
    }
}
