package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class bkk<T> implements bku<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final bku<T> f2811a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final boolean f2812b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final bdl<T, Boolean> f2813c;

    public bkk(bku<? extends T> bku, boolean z, bdl<? super T, Boolean> bdl) {
        bfq.m6567f(bku, "sequence");
        bfq.m6567f(bdl, "predicate");
        this.f2811a = bku;
        this.f2812b = z;
        this.f2813c = bdl;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bkk(bku bku, boolean z, bdl bdl, int i, bfd bfd) {
        this(bku, (i & 2) != 0 ? true : z, bdl);
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        return new bkl(this);
    }
}
