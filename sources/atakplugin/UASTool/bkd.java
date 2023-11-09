package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo1538e = {"Lkotlin/sequences/DistinctSequence;", "T", "K", "Lkotlin/sequences/Sequence;", "source", "keySelector", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class bkd<T, K> implements bku<T> {

    /* renamed from: a */
    private final bku<T> f2797a;

    /* renamed from: b */
    private final bdl<T, K> f2798b;

    public bkd(bku<? extends T> bku, bdl<? super T, ? extends K> bdl) {
        bfq.m6567f(bku, JsonKeyConstants.SOURCE);
        bfq.m6567f(bdl, "keySelector");
        this.f2797a = bku;
        this.f2798b = bdl;
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        return new bkc<>(this.f2797a.mo1859a(), this.f2798b);
    }
}
