package atakplugin.UASTool;

import atakplugin.UASTool.bgo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aW\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\b¨\u0006\r"}, mo1538e = {"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, mo1539f = "kotlin/collections/GroupingKt", mo1541h = 1)
class auo {
    /* renamed from: a */
    public static final <T, K> Map<K, Integer> m4925a(aum<T, ? extends K> aum) {
        bfq.m6567f(aum, "$this$eachCount");
        Map linkedHashMap = new LinkedHashMap();
        Iterator<T> a = aum.mo1862a();
        while (a.hasNext()) {
            Object a2 = aum.mo1861a(a.next());
            Object obj = linkedHashMap.get(a2);
            if (obj == null && !linkedHashMap.containsKey(a2)) {
                obj = new bgo.C0156f();
            }
            bgo.C0156f fVar = (bgo.C0156f) obj;
            fVar.f2666a++;
            linkedHashMap.put(a2, fVar);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry != null) {
                bgv.m6783w(entry).setValue(Integer.valueOf(((bgo.C0156f) entry.getValue()).f2666a));
            } else {
                throw new apx("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
        }
        return bgv.m6780t(linkedHashMap);
    }

    /* renamed from: a */
    private static final <K, V, R> Map<K, R> m4926a(Map<K, V> map, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                bgv.m6783w(entry).setValue(bdl.invoke(entry));
            } else {
                throw new apx("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
        }
        if (map != null) {
            return bgv.m6780t(map);
        }
        throw new apx("null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
    }
}
