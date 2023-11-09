package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.mc */
public class C0643mc<T> implements Iterator<T> {

    /* renamed from: a */
    private final Iterator<? extends T> f5254a;

    /* renamed from: b */
    private final C0496hg<? super T> f5255b;

    /* renamed from: c */
    private boolean f5256c;

    /* renamed from: d */
    private boolean f5257d;

    /* renamed from: e */
    private T f5258e;

    public C0643mc(Iterator<? extends T> it, C0496hg<? super T> hgVar) {
        this.f5254a = it;
        this.f5255b = hgVar;
    }

    public boolean hasNext() {
        if (!this.f5257d) {
            m12447a();
            this.f5257d = true;
        }
        return this.f5256c;
    }

    public T next() {
        if (!this.f5257d) {
            this.f5256c = hasNext();
        }
        if (this.f5256c) {
            this.f5257d = false;
            return this.f5258e;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    private void m12447a() {
        while (this.f5254a.hasNext()) {
            T next = this.f5254a.next();
            this.f5258e = next;
            if (this.f5255b.test(next)) {
                this.f5256c = true;
                return;
            }
        }
        this.f5256c = false;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
