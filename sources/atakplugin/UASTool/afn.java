package atakplugin.UASTool;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class afn<E> extends AbstractList<E> {

    /* renamed from: c */
    private static final afp f865c = afp.m867a(afn.class);

    /* renamed from: a */
    List<E> f866a;

    /* renamed from: b */
    Iterator<E> f867b;

    public afn(List<E> list, Iterator<E> it) {
        this.f866a = list;
        this.f867b = it;
    }

    /* renamed from: a */
    public List<E> mo591a() {
        return this.f866a;
    }

    /* renamed from: b */
    private void m865b() {
        f865c.mo574a("blowup running");
        while (this.f867b.hasNext()) {
            this.f866a.add(this.f867b.next());
        }
    }

    public E get(int i) {
        if (this.f866a.size() > i) {
            return this.f866a.get(i);
        }
        if (this.f867b.hasNext()) {
            this.f866a.add(this.f867b.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new afo(this);
    }

    public int size() {
        f865c.mo574a("potentially expensive size() call");
        m865b();
        return this.f866a.size();
    }
}
