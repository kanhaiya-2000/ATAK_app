package atakplugin.UASTool;

import java.util.Comparator;

/* renamed from: atakplugin.UASTool.ba */
final class C0134ba implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ C0391ei f2468a;

    C0134ba(C0391ei eiVar) {
        this.f2468a = eiVar;
    }

    public int compare(T t, T t2) {
        return ((Comparable) this.f2468a.apply(t)).compareTo((Comparable) this.f2468a.apply(t2));
    }
}
