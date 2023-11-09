package atakplugin.UASTool;

import java.util.Arrays;

/* renamed from: atakplugin.UASTool.ru */
class C0812ru {
    /* renamed from: a */
    static long m13462a(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    C0812ru() {
    }

    /* renamed from: a */
    static long[] m13464a(long... jArr) {
        Arrays.sort(jArr);
        return jArr;
    }

    /* renamed from: a */
    static boolean m13463a(long[] jArr, int i, int i2) {
        return Arrays.binarySearch(jArr, m13462a(i, i2)) >= 0;
    }
}
