package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.Loiter */
class Loiter extends GCSMessage {
    private final double altitude;
    private final double dted;
    private final double latitude;
    private final double longitude;
    private final double radiusLong;
    private final short radiusShort;

    public Loiter(byte[] bArr) {
        this.latitude = radiansToDegrees(getDouble(bArr[0], bArr[1], bArr[2], bArr[3], 1.0E-8d));
        this.longitude = radiansToDegrees(getDouble(bArr[4], bArr[5], bArr[6], bArr[7], 1.0E-8d));
        this.altitude = getDouble(bArr[8], bArr[9], 1.0d);
        this.radiusShort = (short) bArr[10];
        this.dted = getDouble(bArr[11], bArr[12], 1.0d);
        this.radiusLong = getDouble(bArr[13], bArr[14], 1.0d);
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public short getRadiusShort() {
        return this.radiusShort;
    }

    public double getDted() {
        return this.dted;
    }

    public double getRadiusLong() {
        return this.radiusLong;
    }
}
