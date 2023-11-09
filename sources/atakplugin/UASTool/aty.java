package atakplugin.UASTool;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000^\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001a9\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001a(\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\n¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\n\u001a)\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\n\u001a(\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\n¢\u0006\u0002\u0010\u0013\u001a.\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\n\u001a)\u0010\u0015\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\n\u001a-\u0010\u0016\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0018\u001a&\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\b¢\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001c\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\b\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010\u001c\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a-\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\u001a.\u0010\u001e\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0017*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001dH\b\u001a*\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a*\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f\u001a\u0015\u0010\u001f\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0002\b \u001a \u0010!\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0007\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020%\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\"\u001a\u00020#H\u0007¨\u0006&"}, mo1538e = {"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "shuffle", "random", "Lkotlin/random/Random;", "shuffled", "", "kotlin-stdlib"}, mo1539f = "kotlin/collections/CollectionsKt", mo1541h = 1)
class aty extends atx {
    /* renamed from: a */
    private static final <T> boolean m4653a(Collection<? extends T> collection, T t) {
        if (collection != null) {
            return bgv.m6771k(collection).remove(t);
        }
        throw new apx("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    /* renamed from: a */
    private static final <T> boolean m4654a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return bgv.m6771k(collection).removeAll(collection2);
        }
        throw new apx("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    /* renamed from: b */
    private static final <T> boolean m4663b(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return bgv.m6771k(collection).retainAll(collection2);
        }
        throw new apx("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @anx(mo1516a = "Use removeAt(index) instead.", mo1517b = @C0081api(mo1552a = "removeAt(index)", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: a */
    private static final <T> T m4646a(List<T> list, int i) {
        return list.remove(i);
    }

    /* renamed from: b */
    private static final <T> void m4658b(Collection<? super T> collection, T t) {
        bfq.m6567f(collection, "$this$plusAssign");
        collection.add(t);
    }

    /* renamed from: d */
    private static final <T> void m4671d(Collection<? super T> collection, Iterable<? extends T> iterable) {
        bfq.m6567f(collection, "$this$plusAssign");
        ato.m4652a(collection, iterable);
    }

    /* renamed from: d */
    private static final <T> void m4672d(Collection<? super T> collection, T[] tArr) {
        bfq.m6567f(collection, "$this$plusAssign");
        ato.m4655a(collection, tArr);
    }

    /* renamed from: d */
    private static final <T> void m4670d(Collection<? super T> collection, bku<? extends T> bku) {
        bfq.m6567f(collection, "$this$plusAssign");
        ato.m4651a(collection, bku);
    }

    /* renamed from: c */
    private static final <T> void m4666c(Collection<? super T> collection, T t) {
        bfq.m6567f(collection, "$this$minusAssign");
        collection.remove(t);
    }

    /* renamed from: e */
    private static final <T> void m4674e(Collection<? super T> collection, Iterable<? extends T> iterable) {
        bfq.m6567f(collection, "$this$minusAssign");
        ato.m4662b(collection, iterable);
    }

    /* renamed from: e */
    private static final <T> void m4675e(Collection<? super T> collection, T[] tArr) {
        bfq.m6567f(collection, "$this$minusAssign");
        ato.m4664b(collection, tArr);
    }

    /* renamed from: e */
    private static final <T> void m4673e(Collection<? super T> collection, bku<? extends T> bku) {
        bfq.m6567f(collection, "$this$minusAssign");
        ato.m4661b(collection, bku);
    }

    /* renamed from: a */
    public static final <T> boolean m4652a(Collection<? super T> collection, Iterable<? extends T> iterable) {
        bfq.m6567f(collection, "$this$addAll");
        bfq.m6567f(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static final <T> boolean m4651a(Collection<? super T> collection, bku<? extends T> bku) {
        bfq.m6567f(collection, "$this$addAll");
        bfq.m6567f(bku, "elements");
        Iterator<? extends T> a = bku.mo1859a();
        boolean z = false;
        while (a.hasNext()) {
            if (collection.add(a.next())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static final <T> boolean m4655a(Collection<? super T> collection, T[] tArr) {
        bfq.m6567f(collection, "$this$addAll");
        bfq.m6567f(tArr, "elements");
        return collection.addAll(arv.m3276d(tArr));
    }

    /* renamed from: a */
    public static final <T> boolean m4649a(Iterable<? extends T> iterable, bdl<? super T, Boolean> bdl) {
        bfq.m6567f(iterable, "$this$removeAll");
        bfq.m6567f(bdl, "predicate");
        return m4650a(iterable, bdl, true);
    }

    /* renamed from: b */
    public static final <T> boolean m4659b(Iterable<? extends T> iterable, bdl<? super T, Boolean> bdl) {
        bfq.m6567f(iterable, "$this$retainAll");
        bfq.m6567f(bdl, "predicate");
        return m4650a(iterable, bdl, false);
    }

    /* renamed from: a */
    private static final <T> boolean m4650a(Iterable<? extends T> iterable, bdl<? super T, Boolean> bdl, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (bdl.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    /* renamed from: a */
    public static final <T> boolean m4656a(List<T> list, bdl<? super T, Boolean> bdl) {
        bfq.m6567f(list, "$this$removeAll");
        bfq.m6567f(bdl, "predicate");
        return m4657a(list, bdl, true);
    }

    /* renamed from: b */
    public static final <T> boolean m4665b(List<T> list, bdl<? super T, Boolean> bdl) {
        bfq.m6567f(list, "$this$retainAll");
        bfq.m6567f(bdl, "predicate");
        return m4657a(list, bdl, false);
    }

    /* renamed from: a */
    private static final <T> boolean m4657a(List<T> list, bdl<? super T, Boolean> bdl, boolean z) {
        int i;
        if (list instanceof RandomAccess) {
            int a = ato.m4592a(list);
            if (a >= 0) {
                int i2 = 0;
                i = 0;
                while (true) {
                    T t = list.get(i2);
                    if (bdl.invoke(t).booleanValue() != z) {
                        if (i != i2) {
                            list.set(i, t);
                        }
                        i++;
                    }
                    if (i2 == a) {
                        break;
                    }
                    i2++;
                }
            } else {
                i = 0;
            }
            if (i >= list.size()) {
                return false;
            }
            int a2 = ato.m4592a(list);
            if (a2 < i) {
                return true;
            }
            while (true) {
                list.remove(a2);
                if (a2 == i) {
                    return true;
                }
                a2--;
            }
        } else if (list != null) {
            return m4650a(bgv.m6766h(list), bdl, z);
        } else {
            throw new apx("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
    }

    /* renamed from: b */
    public static final <T> boolean m4662b(Collection<? super T> collection, Iterable<? extends T> iterable) {
        bfq.m6567f(collection, "$this$removeAll");
        bfq.m6567f(iterable, "elements");
        return bgv.m6771k(collection).removeAll(ato.m4628a(iterable, (Iterable<? extends T>) collection));
    }

    /* renamed from: b */
    public static final <T> boolean m4661b(Collection<? super T> collection, bku<? extends T> bku) {
        bfq.m6567f(collection, "$this$removeAll");
        bfq.m6567f(bku, "elements");
        Collection p = bkx.m7603p(bku);
        return (p.isEmpty() ^ true) && collection.removeAll(p);
    }

    /* renamed from: b */
    public static final <T> boolean m4664b(Collection<? super T> collection, T[] tArr) {
        bfq.m6567f(collection, "$this$removeAll");
        bfq.m6567f(tArr, "elements");
        return ((tArr.length == 0) ^ true) && collection.removeAll(arv.m4420s(tArr));
    }

    /* renamed from: c */
    public static final <T> boolean m4668c(Collection<? super T> collection, Iterable<? extends T> iterable) {
        bfq.m6567f(collection, "$this$retainAll");
        bfq.m6567f(iterable, "elements");
        return bgv.m6771k(collection).retainAll(ato.m4628a(iterable, (Iterable<? extends T>) collection));
    }

    /* renamed from: c */
    public static final <T> boolean m4669c(Collection<? super T> collection, T[] tArr) {
        bfq.m6567f(collection, "$this$retainAll");
        bfq.m6567f(tArr, "elements");
        if (!(tArr.length == 0)) {
            return collection.retainAll(arv.m4420s(tArr));
        }
        return m4660b(collection);
    }

    /* renamed from: c */
    public static final <T> boolean m4667c(Collection<? super T> collection, bku<? extends T> bku) {
        bfq.m6567f(collection, "$this$retainAll");
        bfq.m6567f(bku, "elements");
        Collection p = bkx.m7603p(bku);
        if (!p.isEmpty()) {
            return collection.retainAll(p);
        }
        return m4660b(collection);
    }

    /* renamed from: b */
    private static final boolean m4660b(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    /* renamed from: a */
    public static final <T> void m4648a(List<T> list, bic bic) {
        bfq.m6567f(list, "$this$shuffle");
        bfq.m6567f(bic, "random");
        for (int a = ato.m4592a(list); a >= 1; a--) {
            int b = bic.mo2529b(a + 1);
            T t = list.get(a);
            list.set(a, list.get(b));
            list.set(b, t);
        }
    }

    /* renamed from: a */
    public static final <T> List<T> m4647a(Iterable<? extends T> iterable, bic bic) {
        bfq.m6567f(iterable, "$this$shuffled");
        bfq.m6567f(bic, "random");
        List<T> t = ato.m4874t(iterable);
        ato.m4648a(t, bic);
        return t;
    }
}
