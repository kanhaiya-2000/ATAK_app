package atakplugin.UASTool;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, mo1538e = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"})
public final class bbh {
    /* renamed from: a */
    private static final int m6172a(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* renamed from: a */
    private static final long m6174a(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    /* renamed from: b */
    private static final int m6176b(int i, int i2, int i3) {
        return m6172a(m6172a(i, i3) - m6172a(i2, i3), i3);
    }

    /* renamed from: b */
    private static final long m6177b(long j, long j2, long j3) {
        return m6174a(m6174a(j, j3) - m6174a(j2, j3), j3);
    }

    /* renamed from: a */
    public static final int m6173a(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i >= i2) {
                return i2;
            }
            return i2 - m6176b(i2, i, i3);
        } else if (i3 < 0) {
            return i <= i2 ? i2 : i2 + m6176b(i, i2, -i3);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    /* renamed from: a */
    public static final long m6175a(long j, long j2, long j3) {
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i > 0) {
            if (j >= j2) {
                return j2;
            }
            return j2 - m6177b(j2, j, j3);
        } else if (i >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (j <= j2) {
            return j2;
        } else {
            return j2 + m6177b(j, j2, -j3);
        }
    }
}
