package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.CenterFOV */
class CenterFOV extends GCSMessage {
    private final double avxTime;
    private final double depression;
    private final double dted;
    private final double heading;
    private final double latitude;
    private final double longitude;
    private final double range;
    private final double roll;

    public CenterFOV(byte[] bArr) {
        this.avxTime = getDouble(bArr[0], bArr[1], bArr[2], bArr[3], 0.01d);
        this.latitude = radiansToDegrees(getDouble(bArr[4], bArr[5], bArr[6], bArr[7], 1.0E-8d));
        this.longitude = radiansToDegrees(getDouble(bArr[8], bArr[9], bArr[10], bArr[11], 1.0E-8d));
        this.heading = radiansToDegrees(getDouble(bArr[12], bArr[13], 0.001d));
        this.depression = radiansToDegrees(getDouble(bArr[14], bArr[15], 0.001d));
        this.roll = radiansToDegrees(getDouble(bArr[16], bArr[17], 0.001d));
        this.range = getDouble(bArr[18], bArr[19], 1.0d);
        this.dted = getDouble(bArr[20], bArr[21], 1.0d);
    }

    public double getHeading() {
        return this.heading;
    }

    public double getDepression() {
        return this.depression;
    }

    public double getRoll() {
        return this.roll;
    }

    public double getRange() {
        return this.range;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getDted() {
        return this.dted;
    }
}
