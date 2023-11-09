package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000:\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\b\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a,\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a\u001d\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0002¢\u0006\u0002\b\u0013\u001a@\u0010\u0014\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00100\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00160\u00150\u0001¨\u0006\u0017"}, mo1538e = {"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, mo1539f = "kotlin/collections/CollectionsKt", mo1541h = 1)
class ats extends atq {
    /* renamed from: a */
    private static final <T> Iterable<T> m4627a(bdk<? extends Iterator<? extends T>> bdk) {
        return new att(bdk);
    }

    /* renamed from: a */
    public static final <T> Integer m4626a(Iterable<? extends T> iterable) {
        bfq.m6567f(iterable, "$this$collectionSizeOrNull");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    /* renamed from: a */
    public static final <T> int m4625a(Iterable<? extends T> iterable, int i) {
        bfq.m6567f(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    /* renamed from: b */
    private static final <T> boolean m4630b(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    /* renamed from: a */
    public static final <T> Collection<T> m4628a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        bfq.m6567f(iterable, "$this$convertToSetForSetOperationWith");
        bfq.m6567f(iterable2, JsonKeyConstants.SOURCE);
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return ato.m4869r(iterable);
        }
        if ((iterable2 instanceof Collection) && ((Collection) iterable2).size() < 2) {
            return (Collection) iterable;
        }
        Collection<T> collection = (Collection) iterable;
        return m4630b(collection) ? ato.m4869r(iterable) : collection;
    }

    /* renamed from: b */
    public static final <T> Collection<T> m4629b(Iterable<? extends T> iterable) {
        bfq.m6567f(iterable, "$this$convertToSetForSetOperation");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return ato.m4869r(iterable);
        }
        Collection<T> collection = (Collection) iterable;
        return m4630b(collection) ? ato.m4869r(iterable) : collection;
    }

    /* renamed from: c */
    public static final <T> List<T> m4631c(Iterable<? extends Iterable<? extends T>> iterable) {
        bfq.m6567f(iterable, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        for (Iterable a : iterable) {
            ato.m4652a(arrayList, a);
        }
        return arrayList;
    }

    /* renamed from: d */
    public static final <T, R> apc<List<T>, List<R>> m4632d(Iterable<? extends apc<? extends T, ? extends R>> iterable) {
        bfq.m6567f(iterable, "$this$unzip");
        int a = ato.m4625a(iterable, 10);
        ArrayList arrayList = new ArrayList(a);
        ArrayList arrayList2 = new ArrayList(a);
        for (apc apc : iterable) {
            arrayList.add(apc.mo1544a());
            arrayList2.add(apc.mo1545b());
        }
        return apv.m2659a(arrayList, arrayList2);
    }
}
