package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001aA\u0010\u0005\u001a\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\t\u001a&\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001\u001a8\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010¨\u0006\u0011"}, mo1538e = {"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "toSortedSet", "Ljava/util/SortedSet;", "T", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, mo1539f = "kotlin/sequences/SequencesKt", mo1541h = 1)
class bll extends blc {
    /* renamed from: a */
    public static final <R> bku<R> m7481a(bku<?> bku, Class<R> cls) {
        bfq.m6567f(bku, "$this$filterIsInstance");
        bfq.m6567f(cls, "klass");
        bku<R> j = bkx.m7591j(bku, new blm(cls));
        if (j != null) {
            return j;
        }
        throw new apx("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    /* renamed from: a */
    public static final <C extends Collection<? super R>, R> C m7482a(bku<?> bku, C c, Class<R> cls) {
        bfq.m6567f(bku, "$this$filterIsInstanceTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(cls, "klass");
        Iterator<?> a = bku.mo1859a();
        while (a.hasNext()) {
            Object next = a.next();
            if (cls.isInstance(next)) {
                c.add(next);
            }
        }
        return c;
    }

    /* renamed from: e */
    public static final <T extends Comparable<? super T>> SortedSet<T> m7484e(bku<? extends T> bku) {
        bfq.m6567f(bku, "$this$toSortedSet");
        return (SortedSet) bkx.m7564c(bku, new TreeSet());
    }

    /* renamed from: a */
    public static final <T> SortedSet<T> m7483a(bku<? extends T> bku, Comparator<? super T> comparator) {
        bfq.m6567f(bku, "$this$toSortedSet");
        bfq.m6567f(comparator, "comparator");
        return (SortedSet) bkx.m7564c(bku, new TreeSet(comparator));
    }
}
