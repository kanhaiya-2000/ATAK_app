package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo1538e = {"Lkotlin/sequences/DropWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class bkh<T> implements bku<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final bku<T> f2804a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final bdl<T, Boolean> f2805b;

    public bkh(bku<? extends T> bku, bdl<? super T, Boolean> bdl) {
        bfq.m6567f(bku, "sequence");
        bfq.m6567f(bdl, "predicate");
        this.f2804a = bku;
        this.f2805b = bdl;
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        return new bki(this);
    }
}
