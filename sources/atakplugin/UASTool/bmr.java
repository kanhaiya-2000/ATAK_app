package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, mo1538e = {"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class bmr implements bgz, Iterator<T> {

    /* renamed from: a */
    final /* synthetic */ bmq f2918a;

    /* renamed from: b */
    private final Iterator<T> f2919b;

    /* renamed from: c */
    private int f2920c = -1;

    /* renamed from: d */
    private T f2921d;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bmr(bmq bmq) {
        this.f2918a = bmq;
        this.f2919b = bmq.f2916a.mo1859a();
    }

    /* renamed from: a */
    public final Iterator<T> mo2786a() {
        return this.f2919b;
    }

    /* renamed from: a */
    public final void mo2787a(int i) {
        this.f2920c = i;
    }

    /* renamed from: b */
    public final int mo2789b() {
        return this.f2920c;
    }

    /* renamed from: a */
    public final void mo2788a(T t) {
        this.f2921d = t;
    }

    /* renamed from: c */
    public final T mo2790c() {
        return this.f2921d;
    }

    /* renamed from: d */
    private final void m7691d() {
        if (this.f2919b.hasNext()) {
            T next = this.f2919b.next();
            if (((Boolean) this.f2918a.f2917b.invoke(next)).booleanValue()) {
                this.f2920c = 1;
                this.f2921d = next;
                return;
            }
        }
        this.f2920c = 0;
    }

    public T next() {
        if (this.f2920c == -1) {
            m7691d();
        }
        if (this.f2920c != 0) {
            T t = this.f2921d;
            this.f2921d = null;
            this.f2920c = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        if (this.f2920c == -1) {
            m7691d();
        }
        return this.f2920c == 1;
    }
}
