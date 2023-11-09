package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038VX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038VX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo1538e = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/UInt;", "getStart", "contains", "", "value", "contains-WZ4Q5Ns", "(I)Z", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class bja extends biy implements bim<aqc> {

    /* renamed from: b */
    public static final C0175a f2763b = new C0175a((bfd) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final bja f2764c = new bja(-1, 0, (bfd) null);

    private bja(int i, int i2) {
        super(i, i2, 1, (bfd) null);
    }

    public /* synthetic */ bja(int i, int i2, bfd bfd) {
        this(i, i2);
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo2567a(Comparable comparable) {
        return mo2634a(((aqc) comparable).mo1603b());
    }

    /* renamed from: f */
    public aqc mo2569g() {
        return aqc.m2770c(mo2623a());
    }

    /* renamed from: h */
    public aqc mo2571i() {
        return aqc.m2770c(mo2624b());
    }

    /* renamed from: a */
    public boolean mo2634a(int i) {
        return aqu.m3027a(mo2623a(), i) <= 0 && aqu.m3027a(i, mo2624b()) <= 0;
    }

    /* renamed from: e */
    public boolean mo2627e() {
        return aqu.m3027a(mo2623a(), mo2624b()) > 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bja) {
            if (!mo2627e() || !((bja) obj).mo2627e()) {
                bja bja = (bja) obj;
                if (!(mo2623a() == bja.mo2623a() && mo2624b() == bja.mo2624b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2627e()) {
            return -1;
        }
        return (mo2623a() * 31) + mo2624b();
    }

    public String toString() {
        return aqc.m2757a(mo2623a()) + ".." + aqc.m2757a(mo2624b());
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo1538e = {"Lkotlin/ranges/UIntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.bja$a */
    public static final class C0175a {
        private C0175a() {
        }

        public /* synthetic */ C0175a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final bja mo2637a() {
            return bja.f2764c;
        }
    }
}
