package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000>\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001aA\u0010\u0006\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\b\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\t\u001a\u0002H\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0010\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u0011*\b\u0012\u0004\u0012\u0002H\r0\u0003\u001a8\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0010\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u001a\u0010\u0012\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0013j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0014¨\u0006\u0015"}, mo1538e = {"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/CollectionsKt", mo1541h = 1)
class aua extends atz {
    /* renamed from: a */
    public static final <R> List<R> m4685a(Iterable<?> iterable, Class<R> cls) {
        bfq.m6567f(iterable, "$this$filterIsInstance");
        bfq.m6567f(cls, "klass");
        return (List) ato.m4684a(iterable, new ArrayList(), cls);
    }

    /* renamed from: a */
    public static final <C extends Collection<? super R>, R> C m4684a(Iterable<?> iterable, C c, Class<R> cls) {
        bfq.m6567f(iterable, "$this$filterIsInstanceTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(cls, "klass");
        for (Object next : iterable) {
            if (cls.isInstance(next)) {
                c.add(next);
            }
        }
        return c;
    }

    /* renamed from: f */
    public static final <T> void m4688f(List<T> list) {
        bfq.m6567f(list, "$this$reverse");
        Collections.reverse(list);
    }

    /* renamed from: f */
    public static final <T extends Comparable<? super T>> SortedSet<T> m4687f(Iterable<? extends T> iterable) {
        bfq.m6567f(iterable, "$this$toSortedSet");
        return (SortedSet) ato.m4782c(iterable, new TreeSet());
    }

    /* renamed from: a */
    public static final <T> SortedSet<T> m4686a(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        bfq.m6567f(iterable, "$this$toSortedSet");
        bfq.m6567f(comparator, "comparator");
        return (SortedSet) ato.m4782c(iterable, new TreeSet(comparator));
    }
}
