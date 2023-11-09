package atakplugin.UASTool;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u00000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a\u001f\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0004j\b\u0012\u0004\u0012\u0002H\u0002`\u0005\"\u0004\b\u0000\u0010\u0002H\b\u001a5\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0004j\b\u0012\u0004\u0012\u0002H\u0002`\u0005\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0007\"\u0002H\u0002¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\nj\b\u0012\u0004\u0012\u0002H\u0002`\u000b\"\u0004\b\u0000\u0010\u0002H\b\u001a5\u0010\t\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\nj\b\u0012\u0004\u0012\u0002H\u0002`\u000b\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0007\"\u0002H\u0002¢\u0006\u0002\u0010\f\u001a\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0004\b\u0000\u0010\u0002H\b\u001a+\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0007\"\u0002H\u0002¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\b\u001a+\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0007\"\u0002H\u0002¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a!\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\b¨\u0006\u0013"}, mo1538e = {"emptySet", "", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, mo1539f = "kotlin/collections/SetsKt", mo1541h = 1)
class avm extends avl {
    /* renamed from: a */
    public static final <T> Set<T> m5092a() {
        return auk.f2275a;
    }

    /* renamed from: b */
    public static final <T> Set<T> m5096b(T... tArr) {
        bfq.m6567f(tArr, "elements");
        return tArr.length > 0 ? arv.m4482v(tArr) : avk.m5092a();
    }

    /* renamed from: b */
    private static final <T> Set<T> m5094b() {
        return avk.m5092a();
    }

    /* renamed from: c */
    private static final <T> Set<T> m5097c() {
        return new LinkedHashSet<>();
    }

    /* renamed from: c */
    public static final <T> Set<T> m5098c(T... tArr) {
        bfq.m6567f(tArr, "elements");
        return (Set) arv.m4134e(tArr, new LinkedHashSet(auy.m4971a(tArr.length)));
    }

    /* renamed from: d */
    private static final <T> HashSet<T> m5099d() {
        return new HashSet<>();
    }

    /* renamed from: d */
    public static final <T> HashSet<T> m5100d(T... tArr) {
        bfq.m6567f(tArr, "elements");
        return (HashSet) arv.m4134e(tArr, new HashSet(auy.m4971a(tArr.length)));
    }

    /* renamed from: e */
    private static final <T> LinkedHashSet<T> m5101e() {
        return new LinkedHashSet<>();
    }

    /* renamed from: e */
    public static final <T> LinkedHashSet<T> m5102e(T... tArr) {
        bfq.m6567f(tArr, "elements");
        return (LinkedHashSet) arv.m4134e(tArr, new LinkedHashSet(auy.m4971a(tArr.length)));
    }

    /* renamed from: b */
    private static final <T> Set<T> m5095b(Set<? extends T> set) {
        return set != null ? set : avk.m5092a();
    }

    /* renamed from: a */
    public static final <T> Set<T> m5093a(Set<? extends T> set) {
        bfq.m6567f(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size == 0) {
            return avk.m5092a();
        }
        if (size != 1) {
            return set;
        }
        return avk.m5089a(set.iterator().next());
    }
}
