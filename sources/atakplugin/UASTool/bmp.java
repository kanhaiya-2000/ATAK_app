package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, mo1538e = {"kotlin/sequences/TakeSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class bmp implements bgz, Iterator<T> {

    /* renamed from: a */
    final /* synthetic */ bmo f2913a;

    /* renamed from: b */
    private int f2914b;

    /* renamed from: c */
    private final Iterator<T> f2915c;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bmp(bmo bmo) {
        this.f2913a = bmo;
        this.f2914b = bmo.f2912b;
        this.f2915c = bmo.f2911a.mo1859a();
    }

    /* renamed from: a */
    public final int mo2780a() {
        return this.f2914b;
    }

    /* renamed from: a */
    public final void mo2781a(int i) {
        this.f2914b = i;
    }

    /* renamed from: b */
    public final Iterator<T> mo2782b() {
        return this.f2915c;
    }

    public T next() {
        int i = this.f2914b;
        if (i != 0) {
            this.f2914b = i - 1;
            return this.f2915c.next();
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return this.f2914b > 0 && this.f2915c.hasNext();
    }
}
