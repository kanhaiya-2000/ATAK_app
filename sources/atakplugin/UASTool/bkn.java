package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, mo1538e = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class bkn implements bgz, Iterator<E> {

    /* renamed from: a */
    final /* synthetic */ bkm f2821a;

    /* renamed from: b */
    private final Iterator<T> f2822b;

    /* renamed from: c */
    private Iterator<? extends E> f2823c;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bkn(bkm bkm) {
        this.f2821a = bkm;
        this.f2822b = bkm.f2818a.mo1859a();
    }

    /* renamed from: a */
    public final Iterator<T> mo2702a() {
        return this.f2822b;
    }

    /* renamed from: a */
    public final void mo2703a(Iterator<? extends E> it) {
        this.f2823c = it;
    }

    /* renamed from: b */
    public final Iterator<E> mo2704b() {
        return this.f2823c;
    }

    public E next() {
        if (m7413c()) {
            Iterator<? extends E> it = this.f2823c;
            if (it == null) {
                bfq.m6538a();
            }
            return it.next();
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return m7413c();
    }

    /* renamed from: c */
    private final boolean m7413c() {
        Iterator<? extends E> it = this.f2823c;
        if (it != null && !it.hasNext()) {
            this.f2823c = null;
        }
        while (true) {
            if (this.f2823c == null) {
                if (this.f2822b.hasNext()) {
                    Iterator<? extends E> it2 = (Iterator) this.f2821a.f2820c.invoke(this.f2821a.f2819b.invoke(this.f2822b.next()));
                    if (it2.hasNext()) {
                        this.f2823c = it2;
                        break;
                    }
                } else {
                    return false;
                }
            } else {
                break;
            }
        }
        return true;
    }
}
