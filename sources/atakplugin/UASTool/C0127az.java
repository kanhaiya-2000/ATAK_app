package atakplugin.UASTool;

import java.util.Comparator;

/* renamed from: atakplugin.UASTool.az */
final class C0127az implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ C0391ei f2411a;

    /* renamed from: b */
    final /* synthetic */ Comparator f2412b;

    C0127az(C0391ei eiVar, Comparator comparator) {
        this.f2411a = eiVar;
        this.f2412b = comparator;
    }

    public int compare(T t, T t2) {
        return this.f2412b.compare(this.f2411a.apply(t), this.f2411a.apply(t2));
    }
}
