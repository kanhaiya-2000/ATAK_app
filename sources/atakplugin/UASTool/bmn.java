package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, mo1538e = {"kotlin/sequences/SubSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class bmn implements bgz, Iterator<T> {

    /* renamed from: a */
    final /* synthetic */ bmm f2908a;

    /* renamed from: b */
    private final Iterator<T> f2909b;

    /* renamed from: c */
    private int f2910c;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bmn(bmm bmm) {
        this.f2908a = bmm;
        this.f2909b = bmm.f2905a.mo1859a();
    }

    /* renamed from: a */
    public final Iterator<T> mo2774a() {
        return this.f2909b;
    }

    /* renamed from: a */
    public final void mo2775a(int i) {
        this.f2910c = i;
    }

    /* renamed from: b */
    public final int mo2776b() {
        return this.f2910c;
    }

    /* renamed from: c */
    private final void m7676c() {
        while (this.f2910c < this.f2908a.f2906b && this.f2909b.hasNext()) {
            this.f2909b.next();
            this.f2910c++;
        }
    }

    public boolean hasNext() {
        m7676c();
        return this.f2910c < this.f2908a.f2907c && this.f2909b.hasNext();
    }

    public T next() {
        m7676c();
        if (this.f2910c < this.f2908a.f2907c) {
            this.f2910c++;
            return this.f2909b.next();
        }
        throw new NoSuchElementException();
    }
}
