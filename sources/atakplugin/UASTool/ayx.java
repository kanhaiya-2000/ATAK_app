package atakplugin.UASTool;

import java.util.Collection;
import java.util.Iterator;

@aot(mo1534a = 1, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001f\u0010\b\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0002\u0004\n\u0002\b\t¨\u0006\u0012"}, mo1538e = {"Lkotlin/coroutines/experimental/SequenceBuilder;", "T", "", "()V", "yield", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "yieldAll", "elements", "", "(Ljava/lang/Iterable;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "iterator", "", "(Ljava/util/Iterator;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "sequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-coroutines"})
public abstract class ayx<T> {
    /* renamed from: a */
    public abstract Object mo2186a(T t, ayp<? super aqr> ayp);

    /* renamed from: a */
    public abstract Object mo2187a(Iterator<? extends T> it, ayp<? super aqr> ayp);

    /* renamed from: a */
    public final Object mo2185a(Iterable<? extends T> iterable, ayp<? super aqr> ayp) {
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            return mo2187a(iterable.iterator(), ayp);
        }
        return aqr.f2177a;
    }

    /* renamed from: a */
    public final Object mo2184a(bku<? extends T> bku, ayp<? super aqr> ayp) {
        return mo2187a(bku.mo1859a(), ayp);
    }
}
