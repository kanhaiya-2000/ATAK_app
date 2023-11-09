package atakplugin.UASTool;

import java.util.Comparator;

/* renamed from: atakplugin.UASTool.ay */
final class C0109ay implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ Comparator f2371a;

    /* renamed from: b */
    final /* synthetic */ Comparator f2372b;

    C0109ay(Comparator comparator, Comparator comparator2) {
        this.f2371a = comparator;
        this.f2372b = comparator2;
    }

    public int compare(T t, T t2) {
        int compare = this.f2371a.compare(t, t2);
        return compare != 0 ? compare : this.f2372b.compare(t, t2);
    }
}
