package atakplugin.UASTool;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, mo1538e = {"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, mo1539f = "kotlin/collections/SetsKt", mo1541h = 1)
class avn extends avm {
    /* renamed from: a */
    public static final <T> Set<T> m5105a(Set<? extends T> set, T t) {
        bfq.m6567f(set, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(auy.m4971a(set.size()));
        boolean z = false;
        for (Object next : set) {
            boolean z2 = true;
            if (!z && bfq.m6552a(next, (Object) t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public static final <T> Set<T> m5106a(Set<? extends T> set, T[] tArr) {
        bfq.m6567f(set, "$this$minus");
        bfq.m6567f(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        ato.m4664b(linkedHashSet, tArr);
        return linkedHashSet;
    }

    /* renamed from: a */
    public static final <T> Set<T> m5104a(Set<? extends T> set, Iterable<? extends T> iterable) {
        bfq.m6567f(set, "$this$minus");
        bfq.m6567f(iterable, "elements");
        Iterable iterable2 = set;
        Collection<? extends T> a = ato.m4628a(iterable, (Iterable<? extends T>) iterable2);
        if (a.isEmpty()) {
            return ato.m4877u(iterable2);
        }
        if (a instanceof Set) {
            Collection linkedHashSet = new LinkedHashSet();
            for (Object next : iterable2) {
                if (!a.contains(next)) {
                    linkedHashSet.add(next);
                }
            }
            return (Set) linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(a);
        return linkedHashSet2;
    }

    /* renamed from: a */
    public static final <T> Set<T> m5103a(Set<? extends T> set, bku<? extends T> bku) {
        bfq.m6567f(set, "$this$minus");
        bfq.m6567f(bku, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        ato.m4661b(linkedHashSet, bku);
        return linkedHashSet;
    }

    /* renamed from: c */
    private static final <T> Set<T> m5111c(Set<? extends T> set, T t) {
        return avk.m5105a(set, t);
    }

    /* renamed from: b */
    public static final <T> Set<T> m5109b(Set<? extends T> set, T t) {
        bfq.m6567f(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(auy.m4971a(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    /* renamed from: b */
    public static final <T> Set<T> m5110b(Set<? extends T> set, T[] tArr) {
        bfq.m6567f(set, "$this$plus");
        bfq.m6567f(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(auy.m4971a(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        ato.m4655a(linkedHashSet, tArr);
        return linkedHashSet;
    }

    /* renamed from: b */
    public static final <T> Set<T> m5108b(Set<? extends T> set, Iterable<? extends T> iterable) {
        int i;
        bfq.m6567f(set, "$this$plus");
        bfq.m6567f(iterable, "elements");
        Integer a = ato.m4626a(iterable);
        if (a != null) {
            i = set.size() + a.intValue();
        } else {
            i = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(auy.m4971a(i));
        linkedHashSet.addAll(set);
        ato.m4652a(linkedHashSet, iterable);
        return linkedHashSet;
    }

    /* renamed from: b */
    public static final <T> Set<T> m5107b(Set<? extends T> set, bku<? extends T> bku) {
        bfq.m6567f(set, "$this$plus");
        bfq.m6567f(bku, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(auy.m4971a(set.size() * 2));
        linkedHashSet.addAll(set);
        ato.m4651a(linkedHashSet, bku);
        return linkedHashSet;
    }

    /* renamed from: d */
    private static final <T> Set<T> m5112d(Set<? extends T> set, T t) {
        return avk.m5109b(set, t);
    }
}
