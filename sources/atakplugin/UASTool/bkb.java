package atakplugin.UASTool;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0007*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo1538e = {"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"})
public final class bkb<T> implements bku<T> {

    /* renamed from: a */
    private final AtomicReference<bku<T>> f2793a;

    public bkb(bku<? extends T> bku) {
        bfq.m6567f(bku, "sequence");
        this.f2793a = new AtomicReference<>(bku);
    }

    /* renamed from: a */
    public Iterator<T> mo1859a() {
        bku andSet = this.f2793a.getAndSet((Object) null);
        if (andSet != null) {
            return andSet.mo1859a();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
