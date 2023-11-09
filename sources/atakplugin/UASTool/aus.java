package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class aus<T> implements bgz, Iterator<auq<? extends T>> {

    /* renamed from: a */
    private int f2280a;

    /* renamed from: b */
    private final Iterator<T> f2281b;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public aus(Iterator<? extends T> it) {
        bfq.m6567f(it, "iterator");
        this.f2281b = it;
    }

    public final boolean hasNext() {
        return this.f2281b.hasNext();
    }

    /* renamed from: a */
    public final auq<T> next() {
        int i = this.f2280a;
        this.f2280a = i + 1;
        if (i < 0) {
            ato.m4612b();
        }
        return new auq<>(i, this.f2281b.next());
    }
}
