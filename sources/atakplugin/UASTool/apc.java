package atakplugin.UASTool;

import java.io.Serializable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00060\u0003j\u0002`\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u000e\u0010\r\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, mo1538e = {"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class apc<A, B> implements Serializable {

    /* renamed from: a */
    private final A f2124a;

    /* renamed from: b */
    private final B f2125b;

    /* renamed from: a */
    public static /* synthetic */ apc m2581a(apc apc, A a, B b, int i, Object obj) {
        if ((i & 1) != 0) {
            a = apc.f2124a;
        }
        if ((i & 2) != 0) {
            b = apc.f2125b;
        }
        return apc.mo1543a(a, b);
    }

    /* renamed from: a */
    public final apc<A, B> mo1543a(A a, B b) {
        return new apc<>(a, b);
    }

    /* renamed from: c */
    public final A mo1546c() {
        return this.f2124a;
    }

    /* renamed from: d */
    public final B mo1547d() {
        return this.f2125b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof apc)) {
            return false;
        }
        apc apc = (apc) obj;
        return bfq.m6552a((Object) this.f2124a, (Object) apc.f2124a) && bfq.m6552a((Object) this.f2125b, (Object) apc.f2125b);
    }

    public int hashCode() {
        A a = this.f2124a;
        int i = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.f2125b;
        if (b != null) {
            i = b.hashCode();
        }
        return hashCode + i;
    }

    public apc(A a, B b) {
        this.f2124a = a;
        this.f2125b = b;
    }

    /* renamed from: a */
    public final A mo1544a() {
        return this.f2124a;
    }

    /* renamed from: b */
    public final B mo1545b() {
        return this.f2125b;
    }

    public String toString() {
        return '(' + this.f2124a + ", " + this.f2125b + ')';
    }
}
