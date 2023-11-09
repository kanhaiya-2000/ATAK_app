package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo1538e = {"Lkotlin/sequences/TransformingIndexedSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function2;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"})
public final class bms<T, R> implements bku<R> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final bku<T> f2922a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final bdw<Integer, T, R> f2923b;

    public bms(bku<? extends T> bku, bdw<? super Integer, ? super T, ? extends R> bdw) {
        bfq.m6567f(bku, "sequence");
        bfq.m6567f(bdw, "transformer");
        this.f2922a = bku;
        this.f2923b = bdw;
    }

    /* renamed from: a */
    public Iterator<R> mo1859a() {
        return new bmt(this);
    }
}
