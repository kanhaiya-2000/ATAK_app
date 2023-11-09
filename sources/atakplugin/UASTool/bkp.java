package atakplugin.UASTool;

import java.util.Iterator;
import java.util.NoSuchElementException;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, mo1538e = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class bkp implements bgz, Iterator<T> {

    /* renamed from: a */
    final /* synthetic */ bko f2826a;

    /* renamed from: b */
    private T f2827b;

    /* renamed from: c */
    private int f2828c = -2;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bkp(bko bko) {
        this.f2826a = bko;
    }

    /* renamed from: a */
    public final T mo2708a() {
        return this.f2827b;
    }

    /* renamed from: a */
    public final void mo2710a(T t) {
        this.f2827b = t;
    }

    /* renamed from: a */
    public final void mo2709a(int i) {
        this.f2828c = i;
    }

    /* renamed from: b */
    public final int mo2711b() {
        return this.f2828c;
    }

    /* renamed from: c */
    private final void m7420c() {
        T t;
        if (this.f2828c == -2) {
            t = this.f2826a.f2824a.invoke();
        } else {
            bdl b = this.f2826a.f2825b;
            T t2 = this.f2827b;
            if (t2 == null) {
                bfq.m6538a();
            }
            t = b.invoke(t2);
        }
        this.f2827b = t;
        this.f2828c = t == null ? 0 : 1;
    }

    public T next() {
        if (this.f2828c < 0) {
            m7420c();
        }
        if (this.f2828c != 0) {
            T t = this.f2827b;
            if (t != null) {
                this.f2828c = -1;
                return t;
            }
            throw new apx("null cannot be cast to non-null type T");
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        if (this.f2828c < 0) {
            m7420c();
        }
        return this.f2828c == 1;
    }
}
