package atakplugin.UASTool;

import java.util.Iterator;

/* renamed from: atakplugin.UASTool.ix */
public class C0547ix<T> implements Iterator<T> {

    /* renamed from: a */
    private final Iterator<? extends T> f5029a;

    /* renamed from: b */
    private final int f5030b;

    /* renamed from: c */
    private int f5031c;

    public C0547ix(Iterator<? extends T> it) {
        this(0, 1, it);
    }

    public C0547ix(int i, int i2, Iterator<? extends T> it) {
        this.f5029a = it;
        this.f5030b = i2;
        this.f5031c = i;
    }

    /* renamed from: a */
    public int mo4987a() {
        return this.f5031c;
    }

    public boolean hasNext() {
        return this.f5029a.hasNext();
    }

    public T next() {
        T next = this.f5029a.next();
        this.f5031c += this.f5030b;
        return next;
    }

    public void remove() {
        this.f5029a.remove();
    }
}
