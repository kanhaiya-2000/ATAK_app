package atakplugin.UASTool;

import indago.serialization.JsonKeyConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@aot(mo1534a = 5, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000@\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\b\u001a´\u0001\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\b¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001a¼\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\b\u001a|\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\b¢\u0006\u0002\u0010\u001c\u001aÕ\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u001026\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\b¢\u0006\u0002\u0010\u001e\u001a\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\b¢\u0006\u0002\u0010\u001f\u001a\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\b\u001a¡\u0001\u0010\"\u001a\u0002H\u0010\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\b¢\u0006\u0002\u0010#¨\u0006$"}, mo1538e = {"aggregate", "", "K", "R", "T", "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, mo1539f = "kotlin/collections/GroupingKt", mo1541h = 1)
class aup extends auo {
    /* renamed from: a */
    public static final <T, K, R> Map<K, R> m4929a(aum<T, ? extends K> aum, beb<? super K, ? super R, ? super T, ? super Boolean, ? extends R> beb) {
        bfq.m6567f(aum, "$this$aggregate");
        bfq.m6567f(beb, "operation");
        Map<K, R> linkedHashMap = new LinkedHashMap<>();
        Iterator<T> a = aum.mo1862a();
        while (a.hasNext()) {
            T next = a.next();
            Object a2 = aum.mo1861a(next);
            R r = linkedHashMap.get(a2);
            linkedHashMap.put(a2, beb.mo2304a(a2, r, next, Boolean.valueOf(r == null && !linkedHashMap.containsKey(a2))));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static final <T, K, R, M extends Map<? super K, R>> M m4934a(aum<T, ? extends K> aum, M m, beb<? super K, ? super R, ? super T, ? super Boolean, ? extends R> beb) {
        bfq.m6567f(aum, "$this$aggregateTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(beb, "operation");
        Iterator<T> a = aum.mo1862a();
        while (a.hasNext()) {
            T next = a.next();
            Object a2 = aum.mo1861a(next);
            Object obj = m.get(a2);
            m.put(a2, beb.mo2304a(a2, obj, next, Boolean.valueOf(obj == null && !m.containsKey(a2))));
        }
        return m;
    }

    /* renamed from: a */
    public static final <T, K, M extends Map<? super K, Integer>> M m4931a(aum<T, ? extends K> aum, M m) {
        bfq.m6567f(aum, "$this$eachCountTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        Iterator<T> a = aum.mo1862a();
        while (a.hasNext()) {
            Object a2 = aum.mo1861a(a.next());
            Object obj = m.get(a2);
            if (obj == null && !m.containsKey(a2)) {
                obj = 0;
            }
            m.put(a2, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return m;
    }

    /* renamed from: a */
    public static final <T, K, R> Map<K, R> m4927a(aum<T, ? extends K> aum, bdw<? super K, ? super T, ? extends R> bdw, bea<? super K, ? super R, ? super T, ? extends R> bea) {
        bfq.m6567f(aum, "$this$fold");
        bfq.m6567f(bdw, "initialValueSelector");
        bfq.m6567f(bea, "operation");
        Map<K, R> linkedHashMap = new LinkedHashMap<>();
        Iterator<T> a = aum.mo1862a();
        while (a.hasNext()) {
            T next = a.next();
            Object a2 = aum.mo1861a(next);
            R r = linkedHashMap.get(a2);
            if (r == null && !linkedHashMap.containsKey(a2)) {
                r = bdw.mo2065a(a2, next);
            }
            linkedHashMap.put(a2, bea.mo2214a(a2, r, next));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static final <T, K, R, M extends Map<? super K, R>> M m4932a(aum<T, ? extends K> aum, M m, bdw<? super K, ? super T, ? extends R> bdw, bea<? super K, ? super R, ? super T, ? extends R> bea) {
        bfq.m6567f(aum, "$this$foldTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdw, "initialValueSelector");
        bfq.m6567f(bea, "operation");
        Iterator<T> a = aum.mo1862a();
        while (a.hasNext()) {
            T next = a.next();
            Object a2 = aum.mo1861a(next);
            Object obj = m.get(a2);
            if (obj == null && !m.containsKey(a2)) {
                obj = bdw.mo2065a(a2, next);
            }
            m.put(a2, bea.mo2214a(a2, obj, next));
        }
        return m;
    }

    /* renamed from: a */
    public static final <T, K, R> Map<K, R> m4930a(aum<T, ? extends K> aum, R r, bdw<? super R, ? super T, ? extends R> bdw) {
        bfq.m6567f(aum, "$this$fold");
        bfq.m6567f(bdw, "operation");
        Map<K, R> linkedHashMap = new LinkedHashMap<>();
        Iterator<T> a = aum.mo1862a();
        while (a.hasNext()) {
            T next = a.next();
            Object a2 = aum.mo1861a(next);
            R r2 = linkedHashMap.get(a2);
            if (r2 == null && !linkedHashMap.containsKey(a2)) {
                r2 = r;
            }
            linkedHashMap.put(a2, bdw.mo2065a(r2, next));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    public static final <T, K, R, M extends Map<? super K, R>> M m4935a(aum<T, ? extends K> aum, M m, R r, bdw<? super R, ? super T, ? extends R> bdw) {
        bfq.m6567f(aum, "$this$foldTo");
        bfq.m6567f(m, JsonKeyConstants.DESTINATION);
        bfq.m6567f(bdw, "operation");
        Iterator<T> a = aum.mo1862a();
        while (a.hasNext()) {
            T next = a.next();
            Object a2 = aum.mo1861a(next);
            R r2 = m.get(a2);
            if (r2 == null && !m.containsKey(a2)) {
                r2 = r;
            }
            m.put(a2, bdw.mo2065a(r2, next));
        }
        return m;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [atakplugin.UASTool.bea, atakplugin.UASTool.bea<? super K, ? super S, ? super T, ? extends S>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S, K> java.util.Map<K, S> m4928a(atakplugin.UASTool.aum<T, ? extends K> r6, atakplugin.UASTool.bea<? super K, ? super S, ? super T, ? extends S> r7) {
        /*
            java.lang.String r0 = "$this$reduce"
            atakplugin.UASTool.bfq.m6567f(r6, r0)
            java.lang.String r0 = "operation"
            atakplugin.UASTool.bfq.m6567f(r7, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            java.util.Iterator r1 = r6.mo1862a()
        L_0x0015:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x003d
            java.lang.Object r2 = r1.next()
            java.lang.Object r3 = r6.mo1861a(r2)
            java.lang.Object r4 = r0.get(r3)
            if (r4 != 0) goto L_0x0031
            boolean r5 = r0.containsKey(r3)
            if (r5 != 0) goto L_0x0031
            r5 = 1
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            if (r5 == 0) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            java.lang.Object r2 = r7.mo2214a(r3, r4, r2)
        L_0x0039:
            r0.put(r3, r2)
            goto L_0x0015
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.aup.m4928a(atakplugin.UASTool.aum, atakplugin.UASTool.bea):java.util.Map");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [atakplugin.UASTool.bea, atakplugin.UASTool.bea<? super K, ? super S, ? super T, ? extends S>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S, K, M extends java.util.Map<? super K, S>> M m4933a(atakplugin.UASTool.aum<T, ? extends K> r5, M r6, atakplugin.UASTool.bea<? super K, ? super S, ? super T, ? extends S> r7) {
        /*
            java.lang.String r0 = "$this$reduceTo"
            atakplugin.UASTool.bfq.m6567f(r5, r0)
            java.lang.String r0 = "destination"
            atakplugin.UASTool.bfq.m6567f(r6, r0)
            java.lang.String r0 = "operation"
            atakplugin.UASTool.bfq.m6567f(r7, r0)
            java.util.Iterator r0 = r5.mo1862a()
        L_0x0013:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r5.mo1861a(r1)
            java.lang.Object r3 = r6.get(r2)
            if (r3 != 0) goto L_0x002f
            boolean r4 = r6.containsKey(r2)
            if (r4 != 0) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            java.lang.Object r1 = r7.mo2214a(r2, r3, r1)
        L_0x0037:
            r6.put(r2, r1)
            goto L_0x0013
        L_0x003b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: atakplugin.UASTool.aup.m4933a(atakplugin.UASTool.aum, java.util.Map, atakplugin.UASTool.bea):java.util.Map");
    }
}
