package atakplugin.UASTool;

import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007"}, mo1538e = {"kotlin/sequences/SequencesKt___SequencesKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"})
public final class blw implements aum<T, K> {

    /* renamed from: a */
    final /* synthetic */ bku f2873a;

    /* renamed from: b */
    final /* synthetic */ bdl f2874b;

    public blw(bku<? extends T> bku, bdl bdl) {
        this.f2873a = bku;
        this.f2874b = bdl;
    }

    /* renamed from: a */
    public Iterator<T> mo1862a() {
        return this.f2873a.mo1859a();
    }

    /* renamed from: a */
    public K mo1861a(T t) {
        return this.f2874b.invoke(t);
    }
}
