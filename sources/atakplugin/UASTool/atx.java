package atakplugin.UASTool;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\b¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\b\u001a!\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\b\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0007\u001a&\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a \u0010\f\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a3\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00100\u000fH\b\u001a5\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0012j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0013H\b\u001a2\u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0012j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0013¨\u0006\u0015"}, mo1538e = {"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "shuffled", "", "", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, mo1539f = "kotlin/collections/CollectionsKt", mo1541h = 1)
class atx extends atw {
    @anx(mo1516a = "Use sortWith(comparator) instead.", mo1517b = @C0081api(mo1552a = "this.sortWith(comparator)", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: b */
    private static final <T> void m4642b(List<T> list, Comparator<? super T> comparator) {
        throw new aov((String) null, 1, (bfd) null);
    }

    @anx(mo1516a = "Use sortWith(Comparator(comparison)) instead.", mo1517b = @C0081api(mo1552a = "this.sortWith(Comparator(comparison))", mo1553b = {}), mo1518c = any.ERROR)
    /* renamed from: a */
    private static final <T> void m4638a(List<T> list, bdw<? super T, ? super T, Integer> bdw) {
        throw new aov((String) null, 1, (bfd) null);
    }

    /* renamed from: c */
    public static final <T extends Comparable<? super T>> void m4643c(List<T> list) {
        bfq.m6567f(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    /* renamed from: a */
    public static final <T> void m4640a(List<T> list, Comparator<? super T> comparator) {
        bfq.m6567f(list, "$this$sortWith");
        bfq.m6567f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    /* renamed from: a */
    private static final <T> void m4639a(List<T> list, T t) {
        Collections.fill(list, t);
    }

    /* renamed from: d */
    private static final <T> void m4644d(List<T> list) {
        Collections.shuffle(list);
    }

    /* renamed from: a */
    private static final <T> void m4641a(List<T> list, Random random) {
        Collections.shuffle(list, random);
    }

    /* renamed from: e */
    public static final <T> List<T> m4645e(Iterable<? extends T> iterable) {
        bfq.m6567f(iterable, "$this$shuffled");
        List<T> t = ato.m4874t(iterable);
        Collections.shuffle(t);
        return t;
    }

    /* renamed from: a */
    public static final <T> List<T> m4637a(Iterable<? extends T> iterable, Random random) {
        bfq.m6567f(iterable, "$this$shuffled");
        bfq.m6567f(random, "random");
        List<T> t = ato.m4874t(iterable);
        Collections.shuffle(t, random);
        return t;
    }
}
