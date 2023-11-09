package atakplugin.UASTool;

import java.util.Comparator;

/* renamed from: atakplugin.UASTool.dc */
final class C0350dc implements C0347da<T> {

    /* renamed from: a */
    final /* synthetic */ Comparator f4886a;

    C0350dc(Comparator comparator) {
        this.f4886a = comparator;
    }

    /* renamed from: a */
    public T mo4893a(T t, T t2) {
        return this.f4886a.compare(t, t2) >= 0 ? t : t2;
    }
}
