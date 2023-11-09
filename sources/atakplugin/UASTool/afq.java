package atakplugin.UASTool;

public class afq {
    /* renamed from: a */
    public static long m872a(long j, long j2) {
        while (true) {
            long j3 = j;
            j = j2;
            long j4 = j3;
            if (j <= 0) {
                return j4;
            }
            j2 = j4 % j;
        }
    }

    /* renamed from: a */
    public static int m871a(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i <= 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    /* renamed from: b */
    public static long m875b(long j, long j2) {
        return j * (j2 / m872a(j, j2));
    }

    /* renamed from: a */
    public static long m873a(long[] jArr) {
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            j = m875b(j, jArr[i]);
        }
        return j;
    }

    /* renamed from: b */
    public static int m874b(int i, int i2) {
        return i * (i2 / m871a(i, i2));
    }
}
