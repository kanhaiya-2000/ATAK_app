package atakplugin.UASTool;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001a+\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\b\"\u0002H\u0002¢\u0006\u0002\u0010\t\u001aG\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u00022\u001a\u0010\n\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000bj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\f2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\b\"\u0002H\u0002¢\u0006\u0002\u0010\r¨\u0006\u000e"}, mo1538e = {"setOf", "", "T", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "sortedSetOf", "Ljava/util/TreeSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/SetsKt", mo1541h = 1)
class avl {
    /* renamed from: a */
    public static final <T> Set<T> m5089a(T t) {
        Set<T> singleton = Collections.singleton(t);
        bfq.m6554b(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }

    /* renamed from: a */
    public static final <T> TreeSet<T> m5091a(T... tArr) {
        bfq.m6567f(tArr, "elements");
        return (TreeSet) arv.m4134e(tArr, new TreeSet());
    }

    /* renamed from: a */
    public static final <T> TreeSet<T> m5090a(Comparator<? super T> comparator, T... tArr) {
        bfq.m6567f(comparator, "comparator");
        bfq.m6567f(tArr, "elements");
        return (TreeSet) arv.m4134e(tArr, new TreeSet(comparator));
    }
}
