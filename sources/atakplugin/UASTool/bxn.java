package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 11}, mo1536c = {1, 0, 2}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo1538e = {"Lokio/SegmentPool;", "", "()V", "MAX_SIZE", "", "byteCount", "next", "Lokio/Segment;", "recycle", "", "segment", "take", "jvm"})
public final class bxn {

    /* renamed from: a */
    public static final long f4206a = 65536;

    /* renamed from: b */
    public static bxm f4207b;

    /* renamed from: c */
    public static long f4208c;

    /* renamed from: d */
    public static final bxn f4209d = new bxn();

    private bxn() {
    }

    @bcz
    /* renamed from: a */
    public static final bxm m10449a() {
        synchronized (f4209d) {
            bxm bxm = f4207b;
            if (bxm == null) {
                return new bxm();
            }
            f4207b = bxm.f4204f;
            bxm.f4204f = null;
            f4208c -= (long) 8192;
            return bxm;
        }
    }

    @bcz
    /* renamed from: a */
    public static final void m10450a(bxm bxm) {
        bfq.m6567f(bxm, "segment");
        if (!(bxm.f4204f == null && bxm.f4205g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!bxm.f4202d) {
            synchronized (f4209d) {
                long j = f4208c;
                long j2 = (long) 8192;
                if (j + j2 <= f4206a) {
                    f4208c = j + j2;
                    bxm.f4204f = f4207b;
                    bxm.f4201c = 0;
                    bxm.f4200b = bxm.f4201c;
                    f4207b = bxm;
                    aqr aqr = aqr.f2177a;
                }
            }
        }
    }
}
