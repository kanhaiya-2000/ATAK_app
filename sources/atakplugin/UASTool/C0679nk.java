package atakplugin.UASTool;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.nk */
public final class C0679nk {
    /* renamed from: a */
    public static int m12492a(byte b) {
        return b < 0 ? b + 256 : b;
    }

    /* renamed from: a */
    public static long m12493a(ByteBuffer byteBuffer) {
        return (((long) m12499f(byteBuffer)) << 24) + (((long) m12499f(byteBuffer)) << 16) + (((long) m12499f(byteBuffer)) << 8) + (((long) m12499f(byteBuffer)) << 0);
    }

    /* renamed from: b */
    public static long m12495b(ByteBuffer byteBuffer) {
        long j = (long) byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    /* renamed from: c */
    public static int m12496c(ByteBuffer byteBuffer) {
        return (m12497d(byteBuffer) << 8) + 0 + m12492a(byteBuffer.get());
    }

    /* renamed from: d */
    public static int m12497d(ByteBuffer byteBuffer) {
        return (m12492a(byteBuffer.get()) << 8) + 0 + m12492a(byteBuffer.get());
    }

    /* renamed from: e */
    public static int m12498e(ByteBuffer byteBuffer) {
        return m12492a(byteBuffer.get()) + 0 + (m12492a(byteBuffer.get()) << 8);
    }

    /* renamed from: f */
    public static int m12499f(ByteBuffer byteBuffer) {
        return m12492a(byteBuffer.get());
    }

    /* renamed from: g */
    public static String m12500g(ByteBuffer byteBuffer) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            byte b = byteBuffer.get();
            if (b == 0) {
                return C0684np.m12527a(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(b);
        }
    }

    /* renamed from: a */
    public static String m12494a(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return C0684np.m12527a(bArr);
    }

    /* renamed from: h */
    public static long m12501h(ByteBuffer byteBuffer) {
        long b = (m12495b(byteBuffer) << 32) + 0;
        if (b >= 0) {
            return b + m12495b(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    /* renamed from: i */
    public static double m12502i(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((double) ((((0 | ((bArr[0] << Ascii.CAN) & -16777216)) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255))) / 65536.0d;
    }

    /* renamed from: j */
    public static double m12503j(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        return ((double) ((((0 | ((bArr[0] << Ascii.CAN) & -16777216)) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255))) / 1.073741824E9d;
    }

    /* renamed from: k */
    public static float m12504k(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        return ((float) ((short) (((short) (0 | ((bArr[0] << 8) & 65280))) | (bArr[1] & 255)))) / 256.0f;
    }

    /* renamed from: l */
    public static String m12505l(ByteBuffer byteBuffer) {
        int d = m12497d(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((d >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    /* renamed from: m */
    public static String m12506m(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, bxz.f4229a);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: n */
    public static long m12507n(ByteBuffer byteBuffer) {
        long d = ((long) m12497d(byteBuffer)) << 32;
        if (d >= 0) {
            return d + m12495b(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
}
