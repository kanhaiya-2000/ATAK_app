package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.jd */
public final class C0560jd {
    private C0560jd() {
    }

    /* renamed from: atakplugin.UASTool.jd$b */
    public static abstract class C0562b implements Iterator<Integer> {
        /* renamed from: a */
        public abstract int mo2940a();

        /* renamed from: c */
        public Integer next() {
            return Integer.valueOf(mo2940a());
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    /* renamed from: atakplugin.UASTool.jd$c */
    public static abstract class C0563c implements Iterator<Long> {
        /* renamed from: a */
        public abstract long mo3698a();

        /* renamed from: c */
        public Long next() {
            return Long.valueOf(mo3698a());
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    /* renamed from: atakplugin.UASTool.jd$a */
    public static abstract class C0561a implements Iterator<Double> {
        /* renamed from: a */
        public abstract double mo2515a();

        /* renamed from: c */
        public Double next() {
            return Double.valueOf(mo2515a());
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
