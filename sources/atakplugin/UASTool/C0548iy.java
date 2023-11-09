package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.iy */
public class C0548iy<T> implements Iterator<T> {

    /* renamed from: a */
    private final Iterable<? extends T> f5032a;

    /* renamed from: b */
    private Iterator<? extends T> f5033b;

    public C0548iy(Iterable<? extends T> iterable) {
        this.f5032a = iterable;
    }

    /* renamed from: a */
    private void m12333a() {
        if (this.f5033b == null) {
            this.f5033b = this.f5032a.iterator();
        }
    }

    public boolean hasNext() {
        m12333a();
        return this.f5033b.hasNext();
    }

    public T next() {
        m12333a();
        return this.f5033b.next();
    }

    public void remove() {
        m12333a();
        this.f5033b.remove();
    }
}
