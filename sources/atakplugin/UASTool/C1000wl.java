package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: atakplugin.UASTool.wl */
class C1000wl implements Iterator<E> {

    /* renamed from: a */
    final /* synthetic */ C0998wk f7492a;

    /* renamed from: b */
    private int f7493b;

    C1000wl(C0998wk wkVar) {
        this.f7492a = wkVar;
        this.f7493b = wkVar.f7491b;
    }

    public boolean hasNext() {
        return this.f7493b < this.f7492a.f7490a.length;
    }

    public E next() {
        if (this.f7493b < this.f7492a.f7490a.length) {
            E[] b = this.f7492a.f7490a;
            int i = this.f7493b;
            this.f7493b = i + 1;
            return b[i];
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
