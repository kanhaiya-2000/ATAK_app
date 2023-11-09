package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, mo1538e = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"})
public final class aqu {
    /* renamed from: a */
    public static final double m3024a(int i) {
        return ((double) (Integer.MAX_VALUE & i)) + (((double) ((i >>> 31) << 30)) * ((double) 2));
    }

    /* renamed from: a */
    public static final double m3025a(long j) {
        return (((double) (j >>> 11)) * ((double) 2048)) + ((double) (j & 2047));
    }

    /* renamed from: a */
    public static final int m3028a(long j, long j2) {
        return ((j ^ Long.MIN_VALUE) > (j2 ^ Long.MIN_VALUE) ? 1 : ((j ^ Long.MIN_VALUE) == (j2 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    /* renamed from: a */
    public static final int m3027a(int i, int i2) {
        return bfq.m6533a(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    /* renamed from: b */
    public static final int m3030b(int i, int i2) {
        return aqc.m2761b((int) ((((long) i) & 4294967295L) / (((long) i2) & 4294967295L)));
    }

    /* renamed from: c */
    public static final int m3034c(int i, int i2) {
        return aqc.m2761b((int) ((((long) i) & 4294967295L) % (((long) i2) & 4294967295L)));
    }

    /* renamed from: b */
    public static final long m3032b(long j, long j2) {
        if (j2 < 0) {
            return m3028a(j, j2) < 0 ? aqg.m2843b(0) : aqg.m2843b(1);
        }
        if (j >= 0) {
            return aqg.m2843b(j / j2);
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (m3028a(aqg.m2843b(j - (j3 * j2)), aqg.m2843b(j2)) < 0) {
            i = 0;
        }
        return aqg.m2843b(j3 + ((long) i));
    }

    /* renamed from: c */
    public static final long m3035c(long j, long j2) {
        if (j2 < 0) {
            return m3028a(j, j2) < 0 ? j : aqg.m2843b(j - j2);
        }
        if (j >= 0) {
            return aqg.m2843b(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (m3028a(aqg.m2843b(j3), aqg.m2843b(j2)) < 0) {
            j2 = 0;
        }
        return aqg.m2843b(j3 - j2);
    }

    /* renamed from: a */
    public static final int m3026a(double d) {
        if (Double.isNaN(d) || d <= m3024a(0)) {
            return 0;
        }
        if (d >= m3024a(-1)) {
            return -1;
        }
        double d2 = (double) Integer.MAX_VALUE;
        if (d <= d2) {
            return aqc.m2761b((int) d);
        }
        return aqc.m2761b(aqc.m2761b((int) (d - d2)) + aqc.m2761b(Integer.MAX_VALUE));
    }

    /* renamed from: b */
    public static final long m3031b(double d) {
        if (Double.isNaN(d) || d <= m3025a(0)) {
            return 0;
        }
        if (d >= m3025a(-1)) {
            return -1;
        }
        if (d < ((double) bfu.f2629b)) {
            return aqg.m2843b((long) d);
        }
        return aqg.m2843b(aqg.m2843b((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    /* renamed from: b */
    public static final String m3033b(long j) {
        return m3029a(j, 10);
    }

    /* renamed from: a */
    public static final String m3029a(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, bne.m7730a(i));
            bfq.m6554b(l, "java.lang.Long.toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = (long) i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, bne.m7730a(i));
        bfq.m6554b(l2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l2);
        String l3 = Long.toString(j4, bne.m7730a(i));
        bfq.m6554b(l3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}
