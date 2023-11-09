package atakplugin.UASTool;

import java.util.Comparator;

/* renamed from: atakplugin.UASTool.db */
final class C0349db implements C0347da<T> {

    /* renamed from: a */
    final /* synthetic */ Comparator f4885a;

    C0349db(Comparator comparator) {
        this.f4885a = comparator;
    }

    /* renamed from: a */
    public T mo4893a(T t, T t2) {
        return this.f4885a.compare(t, t2) <= 0 ? t : t2;
    }
}
