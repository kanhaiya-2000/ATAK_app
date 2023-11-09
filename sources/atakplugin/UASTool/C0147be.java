package atakplugin.UASTool;

import java.util.Comparator;

/* renamed from: atakplugin.UASTool.be */
final class C0147be implements Comparator<T> {

    /* renamed from: a */
    final /* synthetic */ boolean f2558a;

    /* renamed from: b */
    final /* synthetic */ Comparator f2559b;

    C0147be(boolean z, Comparator comparator) {
        this.f2558a = z;
        this.f2559b = comparator;
    }

    public int compare(T t, T t2) {
        if (t == null) {
            if (t2 == null) {
                return 0;
            }
            return this.f2558a ? -1 : 1;
        } else if (t2 != null) {
            Comparator comparator = this.f2559b;
            if (comparator == null) {
                return 0;
            }
            return comparator.compare(t, t2);
        } else if (this.f2558a) {
            return 1;
        } else {
            return -1;
        }
    }
}
