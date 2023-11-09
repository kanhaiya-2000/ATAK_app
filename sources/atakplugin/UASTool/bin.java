package atakplugin.UASTool;

import atakplugin.UASTool.bim;
import java.lang.Comparable;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, mo1538e = {"Lkotlin/ranges/ComparableRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "start", "endInclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndInclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
class bin<T extends Comparable<? super T>> implements bim<T> {

    /* renamed from: a */
    private final T f2732a;

    /* renamed from: b */
    private final T f2733b;

    public bin(T t, T t2) {
        bfq.m6567f(t, "start");
        bfq.m6567f(t2, "endInclusive");
        this.f2732a = t;
        this.f2733b = t2;
    }

    /* renamed from: a */
    public boolean mo2567a(T t) {
        bfq.m6567f(t, "value");
        return bim.C0168a.m7046a(this, t);
    }

    /* renamed from: e */
    public boolean mo2558e() {
        return bim.C0168a.m7045a(this);
    }

    /* renamed from: g */
    public T mo2569g() {
        return this.f2732a;
    }

    /* renamed from: i */
    public T mo2571i() {
        return this.f2733b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bin) {
            if (!mo2558e() || !((bin) obj).mo2558e()) {
                bin bin = (bin) obj;
                if (!bfq.m6552a((Object) mo2569g(), (Object) bin.mo2569g()) || !bfq.m6552a((Object) mo2571i(), (Object) bin.mo2571i())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo2558e()) {
            return -1;
        }
        return (mo2569g().hashCode() * 31) + mo2571i().hashCode();
    }

    public String toString() {
        return mo2569g() + ".." + mo2571i();
    }
}
