package com.atakmap.android.uastool.p000av;

import com.google.common.base.Ascii;

/* renamed from: com.atakmap.android.uastool.av.GCSMessage */
class GCSMessage {
    static double getDouble(byte b, byte b2, byte b3, byte b4, double d) {
        return ((double) (((b & 255) << Ascii.CAN) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255))) * d;
    }

    static int getInt(byte b, byte b2, byte b3, byte b4) {
        return ((b & 255) << Ascii.CAN) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    static short getShort(byte b, byte b2) {
        return (short) (((b & 255) << 8) | (b2 & 255));
    }

    public static boolean hasXid(byte b) {
        return b == -2 || b == -1;
    }

    public static double radiansToDegrees(double d) {
        return (d * 180.0d) / 3.141592653589793d;
    }

    GCSMessage() {
    }

    public static double getDouble(byte b, byte b2, double d) {
        return getDouble(b, b2, (byte) 0, (byte) 0, d) / Math.pow(2.0d, 16.0d);
    }

    public static int parseXid(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0 || i < 1) {
            return 0;
        }
        return bArr[0];
    }
}
