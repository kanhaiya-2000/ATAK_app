package com.atakmap.android.uastool.utils;

public class KLVUtils {
    public static short convertAltitude(double d) {
        return (short) ((int) ((d + 900.0d) * 3.2932160804d));
    }

    public static int convertLatitude(double d) {
        return Double.valueOf(d * 2.38609294111E7d).intValue();
    }

    public static int convertLongitude(double d) {
        return Double.valueOf(d * 1.19304647056E7d).intValue();
    }

    public static short calculateChecksum(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            i2++;
            i3 += (bArr[i2] & 255) << ((i2 % 2) * 8);
        }
        return (short) (65535 & i3);
    }

    public static int convertSensorAngle(double d) {
        return Double.valueOf(d * 364.0d).intValue();
    }

    public static long convertSensorRelativeAzimuth(double d) {
        return Double.valueOf(d * 1.19304647083E7d).longValue();
    }

    public static int convertSensorRelativeElevation(double d) {
        return Double.valueOf(d * 1.19304647083E7d).intValue();
    }

    public static int convertPlatformAzimuthAngle(double d) {
        return Double.valueOf(d * 182.0d).intValue();
    }

    public static short convertPlatformElevationAngle(double d) {
        return Double.valueOf(d * 1638.0d).shortValue();
    }
}
