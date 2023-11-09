package com.autel.sdk10.utils;

import atakplugin.UASTool.bxz;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class BytesUtils {
    public static byte getByte(int i) {
        return (byte) (i & 255);
    }

    public static byte[] getBytes(char c) {
        return new byte[]{(byte) c, (byte) (c >> 8)};
    }

    public static byte[] getBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & -16777216) >> 24)};
    }

    public static byte[] getBytes(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 56) & 255))};
    }

    public static byte[] getBytes(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s & 65280) >> 8)};
    }

    public static byte[] getBytesBig(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i & 255);
        bArr[2] = (byte) ((65280 & i) >> 8);
        bArr[1] = (byte) ((16711680 & i) >> 16);
        bArr[0] = (byte) ((i & -16777216) >> 24);
        return bArr;
    }

    public static byte[] getBytes_(short s) {
        return new byte[]{(byte) ((65280 & s) >> 8), (byte) (s & 255)};
    }

    public static int getInt(short s) {
        return s & 65535;
    }

    public static short getInt(byte b) {
        return (short) (b & 255);
    }

    public static int getSignedInt(short s) {
        return s;
    }

    public static short getSignedInt(byte b) {
        return (short) b;
    }

    public static byte getUnsignedBytes(short s) {
        return (byte) (s & 255);
    }

    public static byte[] getUnsignedBytes(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public static byte[] getUnsignedBytes(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255))};
    }

    private BytesUtils() {
    }

    public static byte[] arrayApend(byte[] bArr, byte b) {
        byte[] bArr2 = new byte[(bArr.length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[bArr.length] = b;
        return bArr2;
    }

    public static byte[] arrayComb(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] arrayPop(byte[] bArr, int i) {
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static byte[] arrayRemove(byte[] bArr, int i) {
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }

    public static byte[] arraycopy(byte[] bArr, byte[] bArr2) {
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static String byte2hex(byte b) {
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() != 1) {
            return hexString;
        }
        return "0" + hexString;
    }

    public static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(" ");
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    private static byte[] fillBytes(byte[] bArr, int i) {
        int length = i - bArr.length;
        return length > 0 ? arrayComb(bArr, new byte[length]) : bArr;
    }

    public static String getBinaryStrFromByte(byte b) {
        String str = "";
        for (int i = 0; i < 8; i++) {
            str = (b % 2) + str;
            b = (byte) (b >> 1);
        }
        return str;
    }

    public static String getBinaryStrFromByteArr(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + getBinaryStrFromByte(b);
        }
        return str;
    }

    public static byte[] getBytes(double d) {
        return getBytes(Double.doubleToLongBits(d));
    }

    public static byte[] getBytes(float f) {
        return getBytes(Float.floatToIntBits(f));
    }

    public static byte[] getBytes(String str) {
        return getBytes(str, "GBK");
    }

    public static byte[] getBytes(String str, String str2) {
        return str.getBytes(Charset.forName(str2));
    }

    public static double getDouble(byte[] bArr) {
        return ByteBuffer.wrap(fillBytes(bArr, 8)).order(ByteOrder.LITTLE_ENDIAN).getDouble();
    }

    public static float getFloat(byte[] bArr) {
        return ByteBuffer.wrap(fillBytes(bArr, 4)).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }

    public static int getInt(byte[] bArr) {
        return ByteBuffer.wrap(fillBytes(bArr, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public static long getLong(byte[] bArr) {
        return ByteBuffer.wrap(fillBytes(bArr, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    public static short getShort(byte[] bArr) {
        return ByteBuffer.wrap(fillBytes(bArr, 2)).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

    public static String getString(byte[] bArr) {
        int i = 0;
        while (true) {
            int length = bArr.length;
            if (bArr[i] == 0) {
                return getString(readBytes(bArr, 0, i), bxz.f4230b);
            }
            i++;
        }
    }

    public static String getString(byte[] bArr, String str) {
        return new String(bArr, Charset.forName(str));
    }

    public static byte[] getUnsignedBytes(double d) {
        return getUnsignedBytes(Double.doubleToLongBits(d));
    }

    public static byte[] getUnsignedBytes(float f) {
        return getUnsignedBytes(Float.floatToIntBits(f));
    }

    public static byte[] readBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i + i3];
        }
        return bArr2;
    }
}
