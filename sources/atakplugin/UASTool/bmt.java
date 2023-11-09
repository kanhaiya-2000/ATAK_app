package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, mo1538e = {"kotlin/sequences/TransformingIndexedSequence$iterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class bmt implements bgz, Iterator<R> {

    /* renamed from: a */
    final /* synthetic */ bms f2924a;

    /* renamed from: b */
    private final Iterator<T> f2925b;

    /* renamed from: c */
    private int f2926c;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    bmt(bms bms) {
        this.f2924a = bms;
        this.f2925b = bms.f2922a.mo1859a();
    }

    /* renamed from: a */
    public final Iterator<T> mo2794a() {
        return this.f2925b;
    }

    /* renamed from: a */
    public final void mo2795a(int i) {
        this.f2926c = i;
    }

    /* renamed from: b */
    public final int mo2796b() {
        return this.f2926c;
    }

    public R next() {
        bdw a = this.f2924a.f2923b;
        int i = this.f2926c;
        this.f2926c = i + 1;
        if (i < 0) {
            ato.m4612b();
        }
        return a.mo2065a(Integer.valueOf(i), this.f2925b.next());
    }

    public boolean hasNext() {
        return this.f2925b.hasNext();
    }
}
