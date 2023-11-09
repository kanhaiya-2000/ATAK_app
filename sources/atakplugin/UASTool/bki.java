package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, mo1538e = {"kotlin/sequences/DropWhileSequence$iterator$1", "", "dropState", "", "getDropState", "()I", "setDropState", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "drop", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class bki implements bgz, Iterator<T> {

    /* renamed from: a */
    final /* synthetic */ bkh f2806a;

    /* renamed from: b */
    private final Iterator<T> f2807b;

    /* renamed from: c */
    private int f2808c = -1;

    /* renamed from: d */
    private T f2809d;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bki(bkh bkh) {
        this.f2806a = bkh;
        this.f2807b = bkh.f2804a.mo1859a();
    }

    /* renamed from: a */
    public final Iterator<T> mo2684a() {
        return this.f2807b;
    }

    /* renamed from: a */
    public final void mo2685a(int i) {
        this.f2808c = i;
    }

    /* renamed from: b */
    public final int mo2687b() {
        return this.f2808c;
    }

    /* renamed from: a */
    public final void mo2686a(T t) {
        this.f2809d = t;
    }

    /* renamed from: c */
    public final T mo2688c() {
        return this.f2809d;
    }

    /* renamed from: d */
    private final void m7388d() {
        while (this.f2807b.hasNext()) {
            T next = this.f2807b.next();
            if (!((Boolean) this.f2806a.f2805b.invoke(next)).booleanValue()) {
                this.f2809d = next;
                this.f2808c = 1;
                return;
            }
        }
        this.f2808c = 0;
    }

    public T next() {
        if (this.f2808c == -1) {
            m7388d();
        }
        if (this.f2808c != 1) {
            return this.f2807b.next();
        }
        T t = this.f2809d;
        this.f2809d = null;
        this.f2808c = 0;
        return t;
    }

    public boolean hasNext() {
        if (this.f2808c == -1) {
            m7388d();
        }
        return this.f2808c == 1 || this.f2807b.hasNext();
    }
}
