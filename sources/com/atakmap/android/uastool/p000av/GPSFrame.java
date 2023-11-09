package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.GPSFrame */
class GPSFrame extends GCSMessage {
    private final double altitude;
    private final double avxTime;
    private final int[] carrierToNoise;
    private final double climbRate;
    private final double course;
    private final int day;
    private final boolean fixValid;
    private final int hour;
    private final double latitude;
    private final double longitude;
    private final boolean lowBackupBattery;
    private final double magneticDeviation;
    private final double magneticDeviationRaw;
    private final int minute;
    private final int month;
    private final int navSolution;
    private final boolean pCode;
    private final int second;
    private final double speed;
    private final int year;

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public double getClimbRate() {
        return this.climbRate;
    }

    public double getCourse() {
        return this.course;
    }

    public double getSpeed() {
        return this.speed;
    }

    public GPSFrame(byte[] bArr) {
        boolean z = true;
        this.avxTime = getDouble(bArr[0], bArr[1], bArr[2], bArr[3], 0.01d);
        this.lowBackupBattery = (bArr[4] & 128) > 0;
        this.pCode = (bArr[4] & '@') > 0;
        this.fixValid = (bArr[4] & ' ') <= 0 ? false : z;
        this.navSolution = bArr[4] & 7;
        this.month = bArr[5];
        this.day = bArr[6];
        this.year = getShort(bArr[7], bArr[8]);
        this.hour = bArr[9];
        this.minute = bArr[10];
        this.second = bArr[11];
        this.latitude = radiansToDegrees(getDouble(bArr[12], bArr[13], bArr[14], bArr[15], 1.0E-8d));
        this.longitude = radiansToDegrees(getDouble(bArr[16], bArr[17], bArr[18], bArr[19], 1.0E-8d));
        this.altitude = getDouble(bArr[20], bArr[21], 1.0d);
        this.speed = getDouble(bArr[22], bArr[23], 0.01d);
        this.climbRate = getDouble(bArr[24], bArr[25], 0.01d);
        this.course = radiansToDegrees(getDouble(bArr[26], bArr[27], 0.001d));
        double d = getDouble(bArr[28], bArr[29], 0.001d);
        this.magneticDeviationRaw = d;
        this.magneticDeviation = radiansToDegrees(d);
        this.carrierToNoise = new int[12];
        for (int i = 0; i < 12; i++) {
            this.carrierToNoise[i] = bArr[i + 30];
        }
    }

    public double getMagneticDeviationRaw() {
        return this.magneticDeviationRaw;
    }

    public double getMagneticDeviation() {
        return this.magneticDeviation;
    }

    public double getAvxTime() {
        return this.avxTime;
    }

    public boolean isLowBackupBattery() {
        return this.lowBackupBattery;
    }

    public boolean ispCode() {
        return this.pCode;
    }

    public boolean isFixValid() {
        return this.fixValid;
    }

    public int getNavSolution() {
        return this.navSolution;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public int[] getCarrierToNoise() {
        return this.carrierToNoise;
    }
}
