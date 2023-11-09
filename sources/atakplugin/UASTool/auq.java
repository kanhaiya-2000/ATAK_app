package atakplugin.UASTool;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo1538e = {"Lkotlin/collections/IndexedValue;", "T", "", "index", "", "value", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", "hashCode", "toString", "", "kotlin-stdlib"})
public final class auq<T> {

    /* renamed from: a */
    private final int f2277a;

    /* renamed from: b */
    private final T f2278b;

    /* renamed from: a */
    public static /* synthetic */ auq m4936a(auq auq, int i, T t, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = auq.f2277a;
        }
        if ((i2 & 2) != 0) {
            t = auq.f2278b;
        }
        return auq.mo1991a(i, t);
    }

    /* renamed from: a */
    public final auq<T> mo1991a(int i, T t) {
        return new auq<>(i, t);
    }

    /* renamed from: c */
    public final int mo1993c() {
        return this.f2277a;
    }

    /* renamed from: d */
    public final T mo1994d() {
        return this.f2278b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof auq) {
                auq auq = (auq) obj;
                if (!(this.f2277a == auq.f2277a) || !bfq.m6552a((Object) this.f2278b, (Object) auq.f2278b)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.f2277a * 31;
        T t = this.f2278b;
        return i + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.f2277a + ", value=" + this.f2278b + ")";
    }

    public auq(int i, T t) {
        this.f2277a = i;
        this.f2278b = t;
    }

    /* renamed from: a */
    public final int mo1990a() {
        return this.f2277a;
    }

    /* renamed from: b */
    public final T mo1992b() {
        return this.f2278b;
    }
}
