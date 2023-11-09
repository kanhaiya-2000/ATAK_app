package atakplugin.UASTool;

import java.util.Comparator;

public class byg implements Comparator {

    /* renamed from: a */
    private final byf f4238a;

    public byg() {
        this.f4238a = null;
    }

    public byg(byf byf) {
        this.f4238a = byf;
    }

    public int compare(Object obj, Object obj2) {
        try {
            return ((Comparable) this.f4238a.mo4073b(obj)).compareTo((Comparable) this.f4238a.mo4073b(obj2));
        } catch (byd unused) {
            return 0;
        }
    }
}
