package atakplugin.UASTool;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000D\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005\u001aY\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0001\u0010\u00032*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\n\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005¢\u0006\u0002\u0010\u000b\u001a@\u0010\f\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\r2\u0006\u0010\u000e\u001a\u0002H\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0010H\b¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0001H\b\u001a2\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0000\u001a1\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\b\u001a:\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u001a@\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0019¨\u0006\u001a"}, mo1538e = {"mapOf", "", "K", "V", "pair", "Lkotlin/Pair;", "sortedMapOf", "Ljava/util/SortedMap;", "", "pairs", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "getOrPut", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toProperties", "Ljava/util/Properties;", "", "toSingletonMap", "toSingletonMapOrSelf", "toSortedMap", "comparator", "Ljava/util/Comparator;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/MapsKt", mo1541h = 1)
class ava extends auz {
    /* renamed from: a */
    public static final <K, V> Map<K, V> m4964a(apc<? extends K, ? extends V> apc) {
        bfq.m6567f(apc, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(apc.mo1544a(), apc.mo1545b());
        bfq.m6554b(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    /* renamed from: a */
    public static final <K, V> V m4963a(ConcurrentMap<K, V> concurrentMap, K k, bdk<? extends V> bdk) {
        bfq.m6567f(concurrentMap, "$this$getOrPut");
        bfq.m6567f(bdk, "defaultValue");
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V invoke = bdk.invoke();
        V putIfAbsent = concurrentMap.putIfAbsent(k, invoke);
        return putIfAbsent != null ? putIfAbsent : invoke;
    }

    /* renamed from: a */
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m4965a(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$toSortedMap");
        return new TreeMap<>(map);
    }

    /* renamed from: a */
    public static final <K, V> SortedMap<K, V> m4966a(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        bfq.m6567f(map, "$this$toSortedMap");
        bfq.m6567f(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    /* renamed from: a */
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m4967a(apc<? extends K, ? extends V>... apcArr) {
        bfq.m6567f(apcArr, "pairs");
        TreeMap treeMap = new TreeMap();
        auy.m4988a(treeMap, apcArr);
        return treeMap;
    }

    /* renamed from: c */
    private static final Properties m4969c(Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    /* renamed from: d */
    private static final <K, V> Map<K, V> m4970d(Map<K, ? extends V> map) {
        return auy.m4968b(map);
    }

    /* renamed from: b */
    public static final <K, V> Map<K, V> m4968b(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$toSingletonMap");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        bfq.m6554b(singletonMap, "java.util.Collections.singletonMap(key, value)");
        bfq.m6554b(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
