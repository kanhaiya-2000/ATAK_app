package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038VX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038VX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo1538e = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/ULong;", "getStart", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class bjd extends bjb implements bim<aqg> {

    /* renamed from: b */
    public static final C0177a f2773b = new C0177a((bfd) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final bjd f2774c = new bjd(-1, 0, (bfd) null);

    private bjd(long j, long j2) {
        super(j, j2, 1, (bfd) null);
    }

    public /* synthetic */ bjd(long j, long j2, bfd bfd) {
        this(j, j2);
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo2567a(Comparable comparable) {
        return mo2649a(((aqg) comparable).mo1631b());
    }

    /* renamed from: f */
    public aqg mo2569g() {
        return aqg.m2851c(mo2638a());
    }

    /* renamed from: h */
    public aqg mo2571i() {
        return aqg.m2851c(mo2639b());
    }

    /* renamed from: a */
    public boolean mo2649a(long j) {
        return aqu.m3028a(mo2638a(), j) <= 0 && aqu.m3028a(j, mo2639b()) <= 0;
    }

    /* renamed from: e */
    public boolean mo2642e() {
        return aqu.m3028a(mo2638a(), mo2639b()) > 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bjd) {
            if (!mo2642e() || !((bjd) obj).mo2642e()) {
                bjd bjd = (bjd) obj;
                if (!(mo2638a() == bjd.mo2638a() && mo2639b() == bjd.mo2639b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2642e()) {
            return -1;
        }
        return ((int) aqg.m2843b(mo2639b() ^ aqg.m2843b(mo2639b() >>> 32))) + (((int) aqg.m2843b(mo2638a() ^ aqg.m2843b(mo2638a() >>> 32))) * 31);
    }

    public String toString() {
        return aqg.m2838a(mo2638a()) + ".." + aqg.m2838a(mo2639b());
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo1538e = {"Lkotlin/ranges/ULongRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/ULongRange;", "getEMPTY", "()Lkotlin/ranges/ULongRange;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bjd$a */
    public static final class C0177a {
        private C0177a() {
        }

        public /* synthetic */ C0177a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bjd mo2652a() {
            return bjd.f2774c;
        }
    }
}
