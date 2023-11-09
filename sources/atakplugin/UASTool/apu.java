package atakplugin.UASTool;

import java.io.Serializable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0010\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00012\b\b\u0002\u0010\b\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001c"}, mo1538e = {"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class apu<A, B, C> implements Serializable {

    /* renamed from: a */
    private final A f2137a;

    /* renamed from: b */
    private final B f2138b;

    /* renamed from: c */
    private final C f2139c;

    /* renamed from: a */
    public static /* synthetic */ apu m2651a(apu apu, A a, B b, C c, int i, Object obj) {
        if ((i & 1) != 0) {
            a = apu.f2137a;
        }
        if ((i & 2) != 0) {
            b = apu.f2138b;
        }
        if ((i & 4) != 0) {
            c = apu.f2139c;
        }
        return apu.mo1565a(a, b, c);
    }

    /* renamed from: a */
    public final apu<A, B, C> mo1565a(A a, B b, C c) {
        return new apu<>(a, b, c);
    }

    /* renamed from: d */
    public final A mo1569d() {
        return this.f2137a;
    }

    /* renamed from: e */
    public final B mo1570e() {
        return this.f2138b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof apu)) {
            return false;
        }
        apu apu = (apu) obj;
        return bfq.m6552a((Object) this.f2137a, (Object) apu.f2137a) && bfq.m6552a((Object) this.f2138b, (Object) apu.f2138b) && bfq.m6552a((Object) this.f2139c, (Object) apu.f2139c);
    }

    /* renamed from: f */
    public final C mo1572f() {
        return this.f2139c;
    }

    public int hashCode() {
        A a = this.f2137a;
        int i = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.f2138b;
        int hashCode2 = (hashCode + (b != null ? b.hashCode() : 0)) * 31;
        C c = this.f2139c;
        if (c != null) {
            i = c.hashCode();
        }
        return hashCode2 + i;
    }

    public apu(A a, B b, C c) {
        this.f2137a = a;
        this.f2138b = b;
        this.f2139c = c;
    }

    /* renamed from: a */
    public final A mo1566a() {
        return this.f2137a;
    }

    /* renamed from: b */
    public final B mo1567b() {
        return this.f2138b;
    }

    /* renamed from: c */
    public final C mo1568c() {
        return this.f2139c;
    }

    public String toString() {
        return '(' + this.f2137a + ", " + this.f2138b + ", " + this.f2139c + ')';
    }
}
