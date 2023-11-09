package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, mo1538e = {"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class bkf implements bgz, Iterator<T> {

    /* renamed from: a */
    final /* synthetic */ bke f2801a;

    /* renamed from: b */
    private final Iterator<T> f2802b;

    /* renamed from: c */
    private int f2803c;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bkf(bke bke) {
        this.f2801a = bke;
        this.f2802b = bke.f2799a.mo1859a();
        this.f2803c = bke.f2800b;
    }

    /* renamed from: a */
    public final Iterator<T> mo2678a() {
        return this.f2802b;
    }

    /* renamed from: a */
    public final void mo2679a(int i) {
        this.f2803c = i;
    }

    /* renamed from: b */
    public final int mo2680b() {
        return this.f2803c;
    }

    /* renamed from: c */
    private final void m7379c() {
        while (this.f2803c > 0 && this.f2802b.hasNext()) {
            this.f2802b.next();
            this.f2803c--;
        }
    }

    public T next() {
        m7379c();
        return this.f2802b.next();
    }

    public boolean hasNext() {
        m7379c();
        return this.f2802b.hasNext();
    }
}
