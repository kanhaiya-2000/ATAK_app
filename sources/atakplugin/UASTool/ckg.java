package atakplugin.UASTool;

import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ckg {

    /* renamed from: a */
    static final /* synthetic */ boolean f4649a = true;

    /* renamed from: a */
    public static long m11678a(char c) {
        return ((long) c) & 255;
    }

    /* renamed from: b */
    public static int m11708b(char c) {
        return c & 255;
    }

    /* renamed from: b */
    public static long m11710b(byte b) {
        return ((long) b) & 255;
    }

    /* renamed from: b */
    public static long m11711b(int i) {
        return ((long) i) & 4294967295L;
    }

    /* renamed from: b */
    public static long m11712b(short s) {
        return ((long) s) & 65535;
    }

    /* renamed from: c */
    public static int m11722c(byte b) {
        return b & 255;
    }

    /* renamed from: c */
    public static int m11725c(short s) {
        return s & 65535;
    }

    /* renamed from: c */
    public static short m11726c(char c) {
        return (short) (c & 255);
    }

    /* renamed from: d */
    public static short m11734d(byte b) {
        return (short) (b & 255);
    }

    private ckg() {
        throw new Error("Do not instantiate");
    }

    /* renamed from: a */
    public static ByteBuffer m11693a(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    public static ByteBuffer m11694a(byte[] bArr, int i, int i2) {
        return ByteBuffer.wrap(bArr, i, i2);
    }

    /* renamed from: a */
    public static int m11676a(ByteBuffer byteBuffer) {
        return byteBuffer.getInt();
    }

    /* renamed from: b */
    public static short m11717b(ByteBuffer byteBuffer) {
        return byteBuffer.getShort();
    }

    /* renamed from: c */
    public static byte m11719c(ByteBuffer byteBuffer) {
        return byteBuffer.get();
    }

    /* renamed from: a */
    public static byte m11671a(ByteBuffer byteBuffer, int i) {
        return byteBuffer.get(i);
    }

    /* renamed from: a */
    public static ByteBuffer m11692a(ByteBuffer byteBuffer, byte[] bArr, int i, int i2) {
        return byteBuffer.get(bArr, i, i2);
    }

    /* renamed from: a */
    public static ByteBuffer m11686a(ByteBuffer byteBuffer, byte b) {
        return byteBuffer.put(b);
    }

    /* renamed from: a */
    public static ByteBuffer m11687a(ByteBuffer byteBuffer, int i, byte b) {
        return byteBuffer.put(i, b);
    }

    /* renamed from: a */
    public static IntBuffer m11695a(IntBuffer intBuffer, int i) {
        return intBuffer.put(i);
    }

    /* renamed from: a */
    public static IntBuffer m11696a(IntBuffer intBuffer, int i, int i2) {
        return intBuffer.put(i, i2);
    }

    /* renamed from: a */
    public static IntBuffer m11697a(IntBuffer intBuffer, int[] iArr) {
        return intBuffer.put(iArr);
    }

    /* renamed from: a */
    public static IntBuffer m11698a(IntBuffer intBuffer, int[] iArr, int i, int i2) {
        return intBuffer.put(iArr, i, i2);
    }

    /* renamed from: b */
    public static int m11709b(IntBuffer intBuffer, int i) {
        return intBuffer.get(i);
    }

    /* renamed from: a */
    public static ByteBuffer m11691a(ByteBuffer byteBuffer, short s) {
        return byteBuffer.putShort(s);
    }

    /* renamed from: a */
    public static ByteBuffer m11690a(ByteBuffer byteBuffer, int i, short s) {
        return byteBuffer.putShort(i, s);
    }

    /* renamed from: b */
    public static ByteBuffer m11714b(ByteBuffer byteBuffer, int i) {
        return byteBuffer.putInt(i);
    }

    /* renamed from: a */
    public static ByteBuffer m11688a(ByteBuffer byteBuffer, int i, int i2) {
        return byteBuffer.putInt(i, i2);
    }

    /* renamed from: a */
    public static ByteBuffer m11689a(ByteBuffer byteBuffer, int i, long j) {
        return byteBuffer.putLong(i, j);
    }

    /* renamed from: a */
    public static byte m11670a(RandomAccessFile randomAccessFile) {
        return randomAccessFile.readByte();
    }

    /* renamed from: b */
    public static char m11706b(RandomAccessFile randomAccessFile) {
        return randomAccessFile.readChar();
    }

    /* renamed from: c */
    public static short m11727c(RandomAccessFile randomAccessFile) {
        return randomAccessFile.readShort();
    }

    /* renamed from: d */
    public static int m11730d(RandomAccessFile randomAccessFile) {
        return randomAccessFile.readInt();
    }

    /* renamed from: e */
    public static long m11737e(RandomAccessFile randomAccessFile) {
        return randomAccessFile.readLong();
    }

    /* renamed from: a */
    public static int m11675a(RandomAccessFile randomAccessFile, byte[] bArr, int i, int i2) {
        return randomAccessFile.read(bArr, i, i2);
    }

    /* renamed from: a */
    public static void m11704a(RandomAccessFile randomAccessFile, byte[] bArr) {
        randomAccessFile.readFully(bArr);
    }

    /* renamed from: b */
    public static void m11718b(RandomAccessFile randomAccessFile, byte[] bArr, int i, int i2) {
        randomAccessFile.write(bArr, i, i2);
    }

    /* renamed from: a */
    public static void m11699a(RandomAccessFile randomAccessFile, byte b) {
        randomAccessFile.writeByte(m11722c(b));
    }

    /* renamed from: a */
    public static void m11700a(RandomAccessFile randomAccessFile, char c) {
        randomAccessFile.writeChar(m11708b(c));
    }

    /* renamed from: a */
    public static void m11703a(RandomAccessFile randomAccessFile, short s) {
        randomAccessFile.writeShort(m11725c(s));
    }

    /* renamed from: a */
    public static void m11701a(RandomAccessFile randomAccessFile, int i) {
        randomAccessFile.writeInt(i);
    }

    /* renamed from: a */
    public static void m11702a(RandomAccessFile randomAccessFile, long j) {
        randomAccessFile.writeLong(j);
    }

    /* renamed from: a */
    public static void m11705a(ByteBuffer byteBuffer, byte[] bArr) {
        byteBuffer.get(bArr);
    }

    /* renamed from: a */
    public static int m11674a(long j, long j2) {
        return Long.compare(j - Long.MIN_VALUE, j2 - Long.MIN_VALUE);
    }

    /* renamed from: a */
    public static int m11673a(int i, int i2) {
        return Integer.compare(i - 2147483648, i2 - 2147483648);
    }

    /* renamed from: a */
    public static int m11677a(short s, short s2) {
        return m11673a(m11725c(s), m11725c(s2));
    }

    /* renamed from: a */
    public static int m11672a(byte b, byte b2) {
        return m11673a(m11722c(b), m11722c(b2));
    }

    /* renamed from: a */
    public static String m11682a(long j) {
        return m11733d(j).toString();
    }

    /* renamed from: a */
    public static String m11683a(long j, int i) {
        return m11733d(j).toString(i);
    }

    /* renamed from: a */
    public static String m11681a(int i) {
        return Long.toString(m11711b(i));
    }

    /* renamed from: b */
    public static String m11713b(int i, int i2) {
        return Long.toString(m11711b(i), i2);
    }

    /* renamed from: a */
    public static String m11684a(short s) {
        return Long.toString(m11712b(s));
    }

    /* renamed from: a */
    public static String m11685a(short s, int i) {
        return Long.toString(m11712b(s), i);
    }

    /* renamed from: a */
    public static String m11679a(byte b) {
        return Long.toString(m11710b(b));
    }

    /* renamed from: a */
    public static String m11680a(byte b, int i) {
        return Long.toString(m11710b(b), i);
    }

    /* renamed from: d */
    private static BigInteger m11733d(long j) {
        if (j >= 0) {
            return BigInteger.valueOf(j);
        }
        return BigInteger.valueOf(m11711b((int) (j >>> 32))).shiftLeft(32).add(BigInteger.valueOf(m11711b((int) j)));
    }

    /* renamed from: e */
    public static float m11736e(byte b) {
        return m11733d(m11710b(b)).floatValue();
    }

    /* renamed from: d */
    public static float m11729d(short s) {
        return m11733d(m11712b(s)).floatValue();
    }

    /* renamed from: c */
    public static float m11721c(int i) {
        return m11733d(m11711b(i)).floatValue();
    }

    /* renamed from: b */
    public static float m11707b(long j) {
        return m11733d(j).floatValue();
    }

    /* renamed from: f */
    public static double m11738f(byte b) {
        return m11733d(m11710b(b)).doubleValue();
    }

    /* renamed from: e */
    public static double m11735e(short s) {
        return m11733d(m11712b(s)).doubleValue();
    }

    /* renamed from: d */
    public static double m11728d(int i) {
        return m11733d(m11711b(i)).doubleValue();
    }

    /* renamed from: c */
    public static double m11720c(long j) {
        return m11733d(j).doubleValue();
    }

    /* renamed from: a */
    public static byte m11669a(float f) {
        if (f4649a || f >= 0.0f) {
            return (byte) ((int) f);
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public static short m11716b(float f) {
        if (f4649a || f >= 0.0f) {
            return (short) ((int) f);
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public static int m11724c(float f) {
        if (f4649a || f >= 0.0f) {
            return (int) f;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public static long m11732d(float f) {
        if (f4649a || f >= 0.0f) {
            return (long) f;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static byte m11668a(double d) {
        if (f4649a || d >= 0.0d) {
            return (byte) ((int) d);
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public static short m11715b(double d) {
        if (f4649a || d >= 0.0d) {
            return (short) ((int) d);
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public static int m11723c(double d) {
        if (f4649a || d >= 0.0d) {
            return (int) d;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public static long m11731d(double d) {
        if (f4649a || d >= 0.0d) {
            return (long) d;
        }
        throw new AssertionError();
    }
}
