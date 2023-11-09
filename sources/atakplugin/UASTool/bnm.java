package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo1538e = {"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"})
public final class bnm {

    /* renamed from: a */
    private final String f3016a;

    /* renamed from: b */
    private final biq f3017b;

    /* renamed from: a */
    public static /* synthetic */ bnm m7777a(bnm bnm, String str, biq biq, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bnm.f3016a;
        }
        if ((i & 2) != 0) {
            biq = bnm.f3017b;
        }
        return bnm.mo2837a(str, biq);
    }

    /* renamed from: a */
    public final bnm mo2837a(String str, biq biq) {
        bfq.m6567f(str, "value");
        bfq.m6567f(biq, "range");
        return new bnm(str, biq);
    }

    /* renamed from: c */
    public final String mo2840c() {
        return this.f3016a;
    }

    /* renamed from: d */
    public final biq mo2841d() {
        return this.f3017b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bnm)) {
            return false;
        }
        bnm bnm = (bnm) obj;
        return bfq.m6552a((Object) this.f3016a, (Object) bnm.f3016a) && bfq.m6552a((Object) this.f3017b, (Object) bnm.f3017b);
    }

    public int hashCode() {
        String str = this.f3016a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        biq biq = this.f3017b;
        if (biq != null) {
            i = biq.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MatchGroup(value=" + this.f3016a + ", range=" + this.f3017b + ")";
    }

    public bnm(String str, biq biq) {
        bfq.m6567f(str, "value");
        bfq.m6567f(biq, "range");
        this.f3016a = str;
        this.f3017b = biq;
    }

    /* renamed from: a */
    public final String mo2838a() {
        return this.f3016a;
    }

    /* renamed from: b */
    public final biq mo2839b() {
        return this.f3017b;
    }
}
