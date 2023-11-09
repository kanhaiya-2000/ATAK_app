package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, mo1538e = {"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class bmv implements bgz, Iterator<R> {

    /* renamed from: a */
    final /* synthetic */ bmu f2929a;

    /* renamed from: b */
    private final Iterator<T> f2930b;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bmv(bmu bmu) {
        this.f2929a = bmu;
        this.f2930b = bmu.f2927a.mo1859a();
    }

    /* renamed from: a */
    public final Iterator<T> mo2801a() {
        return this.f2930b;
    }

    public R next() {
        return this.f2929a.f2928b.invoke(this.f2930b.next());
    }

    public boolean hasNext() {
        return this.f2930b.hasNext();
    }
}
