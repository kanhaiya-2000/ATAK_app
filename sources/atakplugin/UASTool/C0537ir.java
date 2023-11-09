package atakplugin.UASTool;

import atakplugin.UASTool.C0539it;
import atakplugin.UASTool.C0560jd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: atakplugin.UASTool.ir */
public final class C0537ir {
    private C0537ir() {
    }

    /* renamed from: a */
    public static <T> List<T> m12282a(Iterator<? extends T> it) {
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static <T, R> R[] m12286a(Iterator<? extends T> it, C0450fx<R[]> fxVar) {
        List<T> a = m12282a(it);
        int size = a.size();
        C0533in.m12277a((long) size);
        Object[] array = a.toArray(C0533in.m12278a(size, (E[]) new Object[0]));
        R[] rArr = (Object[]) fxVar.mo4892b(size);
        System.arraycopy(array, 0, rArr, 0, size);
        return rArr;
    }

    /* renamed from: a */
    public static int[] m12284a(C0560jd.C0562b bVar) {
        C0539it.C0541b bVar2 = new C0539it.C0541b();
        while (bVar.hasNext()) {
            bVar2.mo4921a(bVar.mo2940a());
        }
        return (int[]) bVar2.mo4981f();
    }

    /* renamed from: a */
    public static long[] m12285a(C0560jd.C0563c cVar) {
        C0539it.C0542c cVar2 = new C0539it.C0542c();
        while (cVar.hasNext()) {
            cVar2.mo4927a(cVar.mo3698a());
        }
        return (long[]) cVar2.mo4981f();
    }

    /* renamed from: a */
    public static double[] m12283a(C0560jd.C0561a aVar) {
        C0539it.C0540a aVar2 = new C0539it.C0540a();
        while (aVar.hasNext()) {
            aVar2.mo4899a(aVar.mo2515a());
        }
        return (double[]) aVar2.mo4981f();
    }
}
