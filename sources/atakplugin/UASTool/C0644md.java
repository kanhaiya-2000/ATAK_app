package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.md */
public class C0644md<T> implements Iterator<T> {

    /* renamed from: a */
    private final C0547ix<? extends T> f5259a;

    /* renamed from: b */
    private final C0442fr<? super T> f5260b;

    /* renamed from: c */
    private boolean f5261c;

    /* renamed from: d */
    private boolean f5262d;

    /* renamed from: e */
    private T f5263e;

    public C0644md(C0547ix<? extends T> ixVar, C0442fr<? super T> frVar) {
        this.f5259a = ixVar;
        this.f5260b = frVar;
    }

    public boolean hasNext() {
        if (!this.f5262d) {
            m12448a();
            this.f5262d = true;
        }
        return this.f5261c;
    }

    public T next() {
        if (!this.f5262d) {
            this.f5261c = hasNext();
        }
        if (this.f5261c) {
            this.f5262d = false;
            return this.f5263e;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    private void m12448a() {
        while (this.f5259a.hasNext()) {
            int a = this.f5259a.mo4987a();
            T next = this.f5259a.next();
            this.f5263e = next;
            if (this.f5260b.mo4920a(a, next)) {
                this.f5261c = true;
                return;
            }
        }
        this.f5261c = false;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }
}
