package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000h\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001aG\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\b\u001a$\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aG\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\b\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\b\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\b\u001aG\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\b\u001aY\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\n0\u0006H\b\u001ar\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011\"\u0010\b\u0003\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u0002H\u00110\u0015*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0016\u001a\u0002H\u00142$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\n0\u0006H\b¢\u0006\u0002\u0010\u0017\u001aG\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u001a\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00190\u0006H\b\u001aS\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\b\u001aY\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0011*\u00020\u001d*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0006H\b\u001ar\u0010\u001e\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0011*\u00020\u001d\"\u0010\b\u0003\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u0002H\u00110\u0015*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0016\u001a\u0002H\u00142 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0006H\b¢\u0006\u0002\u0010\u0017\u001al\u0010\u001f\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011\"\u0010\b\u0003\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u0002H\u00110\u0015*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0016\u001a\u0002H\u00142\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\b¢\u0006\u0002\u0010\u0017\u001ae\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110!*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\"\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\b\u001ai\u0010#\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u0010$\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070%j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`&H\b\u001ae\u0010'\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110!*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\"\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\b\u001af\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u0010$\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070%j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`&\u001a$\u0010)\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aG\u0010)\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\b\u001aV\u0010*\u001a\u0002H+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010+*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002H+2\u001e\u0010\u001a\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00190\u0006H\b¢\u0006\u0002\u0010,\u001a6\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030.0\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004¨\u0006/"}, mo1538e = {"all", "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "flatMap", "", "R", "transform", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "forEach", "", "action", "map", "mapNotNull", "", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "minBy", "minWith", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/MapsKt", mo1541h = 1)
class avc extends avb {
    /* renamed from: f */
    public static final <K, V> List<apc<K, V>> m5046f(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$toList");
        if (map.size() == 0) {
            return ato.m4604a();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return ato.m4604a();
        }
        Map.Entry next = it.next();
        if (!it.hasNext()) {
            return ato.m4586a(new apc(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new apc(next.getKey(), next.getValue()));
        do {
            Map.Entry next2 = it.next();
            arrayList.add(new apc(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    /* renamed from: i */
    public static final <K, V, R> List<R> m5050i(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> bdl) {
        bfq.m6567f(map, "$this$flatMap");
        bfq.m6567f(bdl, "transform");
        Collection arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            ato.m4652a(arrayList, (Iterable) bdl.invoke(invoke));
        }
        return (List) arrayList;
    }

    /* renamed from: a */
    public static final <K, V, R, C extends Collection<? super R>> C m5041a(Map<? extends K, ? extends V> map, C c, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> bdl) {
        bfq.m6567f(map, "$this$flatMapTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            ato.m4652a(c, (Iterable) bdl.invoke(invoke));
        }
        return c;
    }

    /* renamed from: j */
    public static final <K, V, R> List<R> m5052j(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        bfq.m6567f(map, "$this$map");
        bfq.m6567f(bdl, "transform");
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            arrayList.add(bdl.invoke(invoke));
        }
        return (List) arrayList;
    }

    /* renamed from: k */
    public static final <K, V, R> List<R> m5054k(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        bfq.m6567f(map, "$this$mapNotNull");
        bfq.m6567f(bdl, "transform");
        Collection arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            Object invoke2 = bdl.invoke(invoke);
            if (invoke2 != null) {
                arrayList.add(invoke2);
            }
        }
        return (List) arrayList;
    }

    /* renamed from: c */
    public static final <K, V, R, C extends Collection<? super R>> C m5044c(Map<? extends K, ? extends V> map, C c, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        bfq.m6567f(map, "$this$mapTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            c.add(bdl.invoke(invoke));
        }
        return c;
    }

    /* renamed from: l */
    public static final <K, V> boolean m5055l(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, Boolean> bdl) {
        bfq.m6567f(map, "$this$all");
        bfq.m6567f(bdl, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            if (!bdl.invoke(invoke).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static final <K, V> boolean m5047g(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$any");
        return !map.isEmpty();
    }

    /* renamed from: m */
    public static final <K, V> boolean m5056m(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, Boolean> bdl) {
        bfq.m6567f(map, "$this$any");
        bfq.m6567f(bdl, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            if (bdl.invoke(invoke).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    private static final <K, V> int m5051j(Map<? extends K, ? extends V> map) {
        return map.size();
    }

    /* renamed from: n */
    public static final <K, V> int m5057n(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, Boolean> bdl) {
        bfq.m6567f(map, "$this$count");
        bfq.m6567f(bdl, "predicate");
        int i = 0;
        if (map.isEmpty()) {
            return 0;
        }
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            if (bdl.invoke(invoke).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: o */
    public static final <K, V> void m5058o(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, aqr> bdl) {
        bfq.m6567f(map, "$this$forEach");
        bfq.m6567f(bdl, "action");
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            bdl.invoke(invoke);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.util.Map$Entry<K, V>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.util.Map$Entry<K, V>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <K, V, R extends java.lang.Comparable<? super R>> java.util.Map.Entry<K, V> m5062s(java.util.Map<? extends K, ? extends V> r5, atakplugin.UASTool.bdl<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> r6) {
        /*
            java.util.Set r5 = r5.entrySet()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            boolean r0 = r5.hasNext()
            if (r0 != 0) goto L_0x0012
            r5 = 0
            goto L_0x003d
        L_0x0012:
            java.lang.Object r0 = r5.next()
            boolean r1 = r5.hasNext()
            if (r1 != 0) goto L_0x001e
        L_0x001c:
            r5 = r0
            goto L_0x003d
        L_0x001e:
            java.lang.Object r1 = r6.invoke(r0)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
        L_0x0024:
            java.lang.Object r2 = r5.next()
            java.lang.Object r3 = r6.invoke(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r4 = r1.compareTo(r3)
            if (r4 >= 0) goto L_0x0036
            r0 = r2
            r1 = r3
        L_0x0036:
            boolean r2 = r5.hasNext()
            if (r2 != 0) goto L_0x0024
            goto L_0x001c
        L_0x003d:
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.avc.m5062s(java.util.Map, atakplugin.UASTool.bdl):java.util.Map$Entry");
    }

    /* renamed from: c */
    private static final <K, V> Map.Entry<K, V> m5045c(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) ato.m4780c(map.entrySet(), comparator);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.util.Map$Entry<K, V>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.util.Map$Entry<K, V>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <K, V, R extends java.lang.Comparable<? super R>> java.util.Map.Entry<K, V> m5059p(java.util.Map<? extends K, ? extends V> r5, atakplugin.UASTool.bdl<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> r6) {
        /*
            java.lang.String r0 = "$this$minBy"
            atakplugin.UASTool.bfq.m6567f(r5, r0)
            java.lang.String r0 = "selector"
            atakplugin.UASTool.bfq.m6567f(r6, r0)
            java.util.Set r5 = r5.entrySet()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
            boolean r0 = r5.hasNext()
            if (r0 != 0) goto L_0x001c
            r5 = 0
            goto L_0x0047
        L_0x001c:
            java.lang.Object r0 = r5.next()
            boolean r1 = r5.hasNext()
            if (r1 != 0) goto L_0x0028
        L_0x0026:
            r5 = r0
            goto L_0x0047
        L_0x0028:
            java.lang.Object r1 = r6.invoke(r0)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
        L_0x002e:
            java.lang.Object r2 = r5.next()
            java.lang.Object r3 = r6.invoke(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r4 = r1.compareTo(r3)
            if (r4 <= 0) goto L_0x0040
            r0 = r2
            r1 = r3
        L_0x0040:
            boolean r2 = r5.hasNext()
            if (r2 != 0) goto L_0x002e
            goto L_0x0026
        L_0x0047:
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.avc.m5059p(java.util.Map, atakplugin.UASTool.bdl):java.util.Map$Entry");
    }

    /* renamed from: b */
    public static final <K, V> Map.Entry<K, V> m5043b(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        bfq.m6567f(map, "$this$minWith");
        bfq.m6567f(comparator, "comparator");
        return (Map.Entry) ato.m4792d(map.entrySet(), comparator);
    }

    /* renamed from: h */
    public static final <K, V> boolean m5048h(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$none");
        return map.isEmpty();
    }

    /* renamed from: q */
    public static final <K, V> boolean m5060q(Map<? extends K, ? extends V> map, bdl<? super Map.Entry<? extends K, ? extends V>, Boolean> bdl) {
        bfq.m6567f(map, "$this$none");
        bfq.m6567f(bdl, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            if (bdl.invoke(invoke).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: r */
    public static final <K, V, M extends Map<? extends K, ? extends V>> M m5061r(M m, bdl<? super Map.Entry<? extends K, ? extends V>, aqr> bdl) {
        bfq.m6567f(m, "$this$onEach");
        bfq.m6567f(bdl, "action");
        for (Map.Entry invoke : m.entrySet()) {
            bdl.invoke(invoke);
        }
        return m;
    }

    /* renamed from: k */
    private static final <K, V> Iterable<Map.Entry<K, V>> m5053k(Map<? extends K, ? extends V> map) {
        return map.entrySet();
    }

    /* renamed from: i */
    public static final <K, V> bku<Map.Entry<K, V>> m5049i(Map<? extends K, ? extends V> map) {
        bfq.m6567f(map, "$this$asSequence");
        return ato.m4708J(map.entrySet());
    }

    /* renamed from: b */
    public static final <K, V, R, C extends Collection<? super R>> C m5042b(Map<? extends K, ? extends V> map, C c, bdl<? super Map.Entry<? extends K, ? extends V>, ? extends R> bdl) {
        bfq.m6567f(map, "$this$mapNotNullTo");
        bfq.m6567f(c, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdl, "transform");
        for (Map.Entry<? extends K, ? extends V> invoke : map.entrySet()) {
            Object invoke2 = bdl.invoke(invoke);
            if (invoke2 != null) {
                c.add(invoke2);
            }
        }
        return c;
    }
}
