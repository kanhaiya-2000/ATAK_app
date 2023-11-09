package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\t\u0010\f\u001a\u00020\rH\u0002J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, mo1538e = {"kotlin/sequences/IndexingSequence$iterator$1", "", "Lkotlin/collections/IndexedValue;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "kotlin-stdlib"})
public final class bkr implements bgz, Iterator<auq<? extends T>> {

    /* renamed from: a */
    final /* synthetic */ bkq f2830a;

    /* renamed from: b */
    private final Iterator<T> f2831b;

    /* renamed from: c */
    private int f2832c;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bkr(bkq bkq) {
        this.f2830a = bkq;
        this.f2831b = bkq.f2829a.mo1859a();
    }

    /* renamed from: a */
    public final Iterator<T> mo2715a() {
        return this.f2831b;
    }

    /* renamed from: a */
    public final void mo2716a(int i) {
        this.f2832c = i;
    }

    /* renamed from: b */
    public final int mo2717b() {
        return this.f2832c;
    }

    /* renamed from: c */
    public auq<T> next() {
        int i = this.f2832c;
        this.f2832c = i + 1;
        if (i < 0) {
            ato.m4612b();
        }
        return new auq<>(i, this.f2831b.next());
    }

    public boolean hasNext() {
        return this.f2831b.hasNext();
    }
}
