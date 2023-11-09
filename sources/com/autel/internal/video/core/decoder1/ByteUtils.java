package com.autel.internal.video.core.decoder1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteUtils {
    public static long getLong(byte[] bArr) {
        return ByteBuffer.wrap(fillBytes(bArr, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    public static int getInt(byte[] bArr) {
        return ByteBuffer.wrap(fillBytes(bArr, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    private static byte[] fillBytes(byte[] bArr, int i) {
        int length = i - bArr.length;
        return length > 0 ? arrayComb(bArr, new byte[length]) : bArr;
    }

    public static byte[] arrayComb(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }
}
