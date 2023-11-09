package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u000b"}, mo1538e = {"kotlin/sequences/MergingSequence$iterator$1", "", "iterator1", "getIterator1", "()Ljava/util/Iterator;", "iterator2", "getIterator2", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class bkt implements bgz, Iterator<V> {

    /* renamed from: a */
    final /* synthetic */ bks f2836a;

    /* renamed from: b */
    private final Iterator<T1> f2837b;

    /* renamed from: c */
    private final Iterator<T2> f2838c;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bkt(bks bks) {
        this.f2836a = bks;
        this.f2837b = bks.f2833a.mo1859a();
        this.f2838c = bks.f2834b.mo1859a();
    }

    /* renamed from: a */
    public final Iterator<T1> mo2722a() {
        return this.f2837b;
    }

    /* renamed from: b */
    public final Iterator<T2> mo2723b() {
        return this.f2838c;
    }

    public V next() {
        return this.f2836a.f2835c.mo2065a(this.f2837b.next(), this.f2838c.next());
    }

    public boolean hasNext() {
        return this.f2837b.hasNext() && this.f2838c.hasNext();
    }
}
