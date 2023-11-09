package atakplugin.UASTool;

import java.util.Iterator;
import java.util.List;

class afo implements Iterator<E> {

    /* renamed from: a */
    int f868a = 0;

    /* renamed from: b */
    final /* synthetic */ afn f869b;

    afo(afn afn) {
        this.f869b = afn;
    }

    public boolean hasNext() {
        return this.f868a < this.f869b.f866a.size() || this.f869b.f867b.hasNext();
    }

    public E next() {
        if (this.f868a < this.f869b.f866a.size()) {
            List<E> list = this.f869b.f866a;
            int i = this.f868a;
            this.f868a = i + 1;
            return list.get(i);
        }
        this.f869b.f866a.add(this.f869b.f867b.next());
        return next();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
