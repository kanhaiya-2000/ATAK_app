package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, mo1538e = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class biq extends bio implements bim<Integer> {

    /* renamed from: b */
    public static final C0170a f2742b = new C0170a((bfd) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final biq f2743c = new biq(1, 0);

    public biq(int i, int i2) {
        super(i, i2, 1);
    }

    /* renamed from: a */
    public /* synthetic */ boolean mo2567a(Comparable comparable) {
        return mo2603a(((Number) comparable).intValue());
    }

    /* renamed from: f */
    public Integer mo2569g() {
        return Integer.valueOf(mo2591a());
    }

    /* renamed from: h */
    public Integer mo2571i() {
        return Integer.valueOf(mo2592b());
    }

    /* renamed from: a */
    public boolean mo2603a(int i) {
        return mo2591a() <= i && i <= mo2592b();
    }

    /* renamed from: e */
    public boolean mo2595e() {
        return mo2591a() > mo2592b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof biq) {
            if (!mo2595e() || !((biq) obj).mo2595e()) {
                biq biq = (biq) obj;
                if (!(mo2591a() == biq.mo2591a() && mo2592b() == biq.mo2592b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2595e()) {
            return -1;
        }
        return (mo2591a() * 31) + mo2592b();
    }

    public String toString() {
        return mo2591a() + ".." + mo2592b();
    }

    @aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo1538e = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"})
    /* renamed from: atakplugin.UASTool.biq$a */
    public static final class C0170a {
        private C0170a() {
        }

        public /* synthetic */ C0170a(bfd bfd) {
            this();
        }

        /* renamed from: a */
        public final biq mo2606a() {
            return biq.f2743c;
        }
    }
}
