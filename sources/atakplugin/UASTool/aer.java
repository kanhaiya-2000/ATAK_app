package atakplugin.UASTool;

import java.nio.ShortBuffer;

public class aer {

    /* renamed from: a */
    public static final boolean f717a = false;

    /* renamed from: a */
    public static void m771a(int i) {
    }

    /* renamed from: a */
    public static void m772a(String str) {
    }

    /* renamed from: a */
    public static void m773a(String str, Object... objArr) {
    }

    /* renamed from: b */
    public static void m777b(String str) {
    }

    /* renamed from: a */
    public static final void m775a(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", new Object[]{Integer.valueOf(iArr[i])});
                i++;
            }
            System.out.println();
        }
    }

    /* renamed from: a */
    public static final void m776a(short[] sArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", new Object[]{Short.valueOf(sArr[i])});
                i++;
            }
            System.out.println();
        }
    }

    /* renamed from: a */
    public static final void m774a(ShortBuffer shortBuffer) {
        for (int i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                System.out.printf("%3d, ", new Object[]{Short.valueOf(shortBuffer.get())});
            }
            System.out.println();
        }
    }

    /* renamed from: b */
    public static void m778b(short[] sArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", new Object[]{Short.valueOf(sArr[i])});
                i++;
            }
            System.out.println();
        }
    }
}
