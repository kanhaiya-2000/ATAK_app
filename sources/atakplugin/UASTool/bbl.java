package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo1538e = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"})
public final class bbl {
    /* renamed from: b */
    private static final int m6185b(int i, int i2, int i3) {
        int c = aqu.m3034c(i, i3);
        int c2 = aqu.m3034c(i2, i3);
        int a = aqu.m3027a(c, c2);
        int b = aqc.m2761b(c - c2);
        return a >= 0 ? b : aqc.m2761b(b + i3);
    }

    /* renamed from: b */
    private static final long m6186b(long j, long j2, long j3) {
        long c = aqu.m3035c(j, j3);
        long c2 = aqu.m3035c(j2, j3);
        int a = aqu.m3028a(c, c2);
        long b = aqg.m2843b(c - c2);
        return a >= 0 ? b : aqg.m2843b(b + j3);
    }

    /* renamed from: a */
    public static final int m6183a(int i, int i2, int i3) {
        if (i3 > 0) {
            if (aqu.m3027a(i, i2) >= 0) {
                return i2;
            }
            return aqc.m2761b(i2 - m6185b(i2, i, aqc.m2761b(i3)));
        } else if (i3 < 0) {
            return aqu.m3027a(i, i2) <= 0 ? i2 : aqc.m2761b(i2 + m6185b(i, i2, aqc.m2761b(-i3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    /* renamed from: a */
    public static final long m6184a(long j, long j2, long j3) {
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i > 0) {
            if (aqu.m3028a(j, j2) >= 0) {
                return j2;
            }
            return aqg.m2843b(j2 - m6186b(j2, j, aqg.m2843b(j3)));
        } else if (i >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (aqu.m3028a(j, j2) <= 0) {
            return j2;
        } else {
            return aqg.m2843b(j2 + m6186b(j, j2, aqg.m2843b(-j3)));
        }
    }
}
