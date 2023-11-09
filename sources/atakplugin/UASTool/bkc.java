package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.HashSet;
import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0014R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00028\u00010\nj\b\u0012\u0004\u0012\u00028\u0001`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo1538e = {"Lkotlin/sequences/DistinctIterator;", "T", "K", "Lkotlin/collections/AbstractIterator;", "source", "", "keySelector", "Lkotlin/Function1;", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "observed", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "computeNext", "", "kotlin-stdlib"})
final class bkc<T, K> extends arg<T> {

    /* renamed from: a */
    private final HashSet<K> f2794a = new HashSet<>();

    /* renamed from: b */
    private final Iterator<T> f2795b;

    /* renamed from: c */
    private final bdl<T, K> f2796c;

    public bkc(Iterator<? extends T> it, bdl<? super T, ? extends K> bdl) {
        bfq.m6567f(it, JsonKeyConstants.SOURCE);
        bfq.m6567f(bdl, "keySelector");
        this.f2795b = it;
        this.f2796c = bdl;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1711a() {
        while (this.f2795b.hasNext()) {
            T next = this.f2795b.next();
            if (this.f2794a.add(this.f2796c.invoke(next))) {
                mo1712a(next);
                return;
            }
        }
        mo1713b();
    }
}
