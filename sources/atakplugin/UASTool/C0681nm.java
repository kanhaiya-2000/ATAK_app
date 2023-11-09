package atakplugin.UASTool;

import com.atakmap.android.uastool.MAVLink.enums.ACCELCAL_VEHICLE_POS;
import java.nio.ByteBuffer;

/* renamed from: atakplugin.UASTool.nm */
public final class C0681nm {

    /* renamed from: a */
    static final /* synthetic */ boolean f5336a = true;

    /* renamed from: a */
    public static void m12511a(ByteBuffer byteBuffer, long j) {
        if (f5336a || j >= 0) {
            byteBuffer.putLong(j);
            return;
        }
        throw new AssertionError("The given long is negative");
    }

    /* renamed from: b */
    public static void m12515b(ByteBuffer byteBuffer, long j) {
        if (f5336a || (j >= 0 && j <= 4294967296L)) {
            byteBuffer.putInt((int) j);
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + j + ")");
    }

    /* renamed from: c */
    public static void m12519c(ByteBuffer byteBuffer, long j) {
        if (f5336a || (j >= 0 && j <= 4294967296L)) {
            m12518c(byteBuffer, ((int) j) & 65535);
            m12518c(byteBuffer, (int) ((j >> 16) & 65535));
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + j + ")");
    }

    /* renamed from: a */
    public static void m12510a(ByteBuffer byteBuffer, int i) {
        int i2 = i & ACCELCAL_VEHICLE_POS.ACCELCAL_VEHICLE_POS_SUCCESS;
        m12514b(byteBuffer, i2 >> 8);
        m12521d(byteBuffer, i2);
    }

    /* renamed from: d */
    public static void m12522d(ByteBuffer byteBuffer, long j) {
        long j2 = j & 281474976710655L;
        m12514b(byteBuffer, (int) (j2 >> 32));
        m12515b(byteBuffer, j2 & 4294967295L);
    }

    /* renamed from: b */
    public static void m12514b(ByteBuffer byteBuffer, int i) {
        int i2 = i & 65535;
        m12521d(byteBuffer, i2 >> 8);
        m12521d(byteBuffer, i2 & 255);
    }

    /* renamed from: c */
    public static void m12518c(ByteBuffer byteBuffer, int i) {
        int i2 = i & 65535;
        m12521d(byteBuffer, i2 & 255);
        m12521d(byteBuffer, i2 >> 8);
    }

    /* renamed from: d */
    public static void m12521d(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: a */
    public static void m12509a(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 65536.0d);
        byteBuffer.put((byte) ((-16777216 & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: b */
    public static void m12513b(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 1.073741824E9d);
        byteBuffer.put((byte) ((-16777216 & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    /* renamed from: c */
    public static void m12517c(ByteBuffer byteBuffer, double d) {
        short s = (short) ((int) (d * 256.0d));
        byteBuffer.put((byte) ((65280 & s) >> 8));
        byteBuffer.put((byte) (s & 255));
    }

    /* renamed from: a */
    public static void m12512a(ByteBuffer byteBuffer, String str) {
        if (str.getBytes().length == 3) {
            int i = 0;
            for (int i2 = 0; i2 < 3; i2++) {
                i += (str.getBytes()[i2] - 96) << ((2 - i2) * 5);
            }
            m12514b(byteBuffer, i);
            return;
        }
        throw new IllegalArgumentException("\"" + str + "\" language string isn't exactly 3 characters long!");
    }

    /* renamed from: b */
    public static void m12516b(ByteBuffer byteBuffer, String str) {
        byte[] a = C0684np.m12528a(str);
        if (f5336a || a.length < 255) {
            m12521d(byteBuffer, a.length);
            byteBuffer.put(a);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public static void m12520c(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(C0684np.m12528a(str));
        m12521d(byteBuffer, 0);
    }

    /* renamed from: d */
    public static void m12523d(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(C0684np.m12528a(str));
        m12521d(byteBuffer, 0);
    }
}
