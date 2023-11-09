package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, mo1538e = {"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class bit extends bir implements bim<Long> {

    /* renamed from: b */
    public static final C0172a f2752b = new C0172a((bfd) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final bit f2753c = new bit(1, 0);

    public bit(long j, long j2) {
        super(j, j2, 1);
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo2567a(Comparable comparable) {
        return mo2619a(((Number) comparable).longValue());
    }

    /* renamed from: f */
    public Long mo2569g() {
        return Long.valueOf(mo2607a());
    }

    /* renamed from: h */
    public Long mo2571i() {
        return Long.valueOf(mo2608b());
    }

    /* renamed from: a */
    public boolean mo2619a(long j) {
        return mo2607a() <= j && j <= mo2608b();
    }

    /* renamed from: e */
    public boolean mo2611e() {
        return mo2607a() > mo2608b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof bit) {
            if (!mo2611e() || !((bit) obj).mo2611e()) {
                bit bit = (bit) obj;
                if (!(mo2607a() == bit.mo2607a() && mo2608b() == bit.mo2608b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2611e()) {
            return -1;
        }
        return (int) ((((long) 31) * (mo2607a() ^ (mo2607a() >>> 32))) + (mo2608b() ^ (mo2608b() >>> 32)));
    }

    public String toString() {
        return mo2607a() + ".." + mo2608b();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo1538e = {"Lkotlin/ranges/LongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/LongRange;", "getEMPTY", "()Lkotlin/ranges/LongRange;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bit$a */
    public static final class C0172a {
        private C0172a() {
        }

        public /* synthetic */ C0172a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bit mo2622a() {
            return bit.f2753c;
        }
    }
}
