package atakplugin.UASTool;

import java.util.Comparator;

/* renamed from: atakplugin.UASTool.bf */
class C0149bf implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ Comparator f2599a;

    /* renamed from: b */
    final /* synthetic */ C0106aw f2600b;

    C0149bf(C0106aw awVar, Comparator comparator) {
        this.f2600b = awVar;
        this.f2599a = comparator;
    }

    public int compare(T t, T t2) {
        int compare = this.f2600b.f2326c.compare(t, t2);
        return compare != 0 ? compare : this.f2599a.compare(t, t2);
    }
}
