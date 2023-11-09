package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.DiagnosticData */
class DiagnosticData extends GCSMessage {
    private double actualLoiterLat;
    private double actualLoiterLon;
    private double cabinTemp;
    private double centerFoVLat;
    private double centerFoVLon;
    private int counter;
    private double course;
    private double dETrimmer;
    private double dTTrimmer;
    private short elevator;
    private double extrapolatedLat;
    private double extrapolatedLon;
    private int fromWaypoint;
    private double manualTrim;
    private short orbitRadius;
    private short rudderServo;

    public DiagnosticData(byte[] bArr) {
        if (bArr.length >= 45) {
            this.counter = getInt(bArr[0], bArr[1], bArr[2], bArr[3]);
            this.dETrimmer = getDouble(bArr[4], bArr[5], 0.001d);
            this.dTTrimmer = getDouble(bArr[6], bArr[7], 0.1d);
            this.course = radiansToDegrees(getDouble(bArr[8], bArr[9], 0.001d));
            this.fromWaypoint = bArr[10];
            this.manualTrim = radiansToDegrees(getDouble(bArr[11], bArr[12], 0.001d));
            this.rudderServo = getShort(bArr[13], bArr[14]);
            this.elevator = getShort(bArr[15], bArr[16]);
            this.extrapolatedLat = radiansToDegrees(getDouble(bArr[17], bArr[18], bArr[19], bArr[20], 1.0E-8d));
            this.extrapolatedLon = radiansToDegrees(getDouble(bArr[21], bArr[22], bArr[23], bArr[24], 1.0E-8d));
            this.actualLoiterLat = radiansToDegrees(getDouble(bArr[25], bArr[26], bArr[27], bArr[28], 1.0E-8d));
            this.actualLoiterLon = radiansToDegrees(getDouble(bArr[29], bArr[30], bArr[31], bArr[32], 1.0E-8d));
            this.centerFoVLat = radiansToDegrees(getDouble(bArr[33], bArr[34], bArr[35], bArr[36], 1.0E-8d));
            this.centerFoVLon = radiansToDegrees(getDouble(bArr[37], bArr[38], bArr[39], bArr[40], 1.0E-8d));
            this.cabinTemp = getDouble(bArr[41], bArr[42], 0.01d);
            this.orbitRadius = getShort(bArr[43], bArr[44]);
        }
    }
}
