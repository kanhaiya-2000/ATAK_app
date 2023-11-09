package atakplugin.UASTool;

import java.util.Map;

@aot(mo1534a = 2, mo1535b = {1, 1, 15}, mo1536c = {1, 0, 3}, mo1537d = {"\u0000.\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n¢\u0006\u0002\u0010\n\u001a@\u0010\u0000\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\b¢\u0006\u0004\b\f\u0010\n\u001aO\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u000b\b\u0001\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\n¢\u0006\u0004\b\r\u0010\n\u001aF\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u0002H\u0002H\n¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, mo1538e = {"getValue", "V1", "V", "", "", "Lkotlin/internal/Exact;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "getVarContravariant", "getVar", "setValue", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"})
public final class auv {
    /* renamed from: a */
    private static final <V, V1 extends V> V1 m4947a(Map<? super String, ? extends V> map, Object obj, bjr<?> bjr) {
        bfq.m6567f(map, "$this$getValue");
        return auy.m4959a(map, bjr.getName());
    }

    /* renamed from: b */
    private static final <V, V1 extends V> V1 m4949b(Map<? super String, ? extends V> map, Object obj, bjr<?> bjr) {
        bfq.m6567f(map, "$this$getValue");
        return auy.m4959a(map, bjr.getName());
    }

    @anx(mo1516a = "Use getValue() with two type parameters instead", mo1518c = any.ERROR)
    /* renamed from: c */
    private static final <V> V m4950c(Map<? super String, ? super V> map, Object obj, bjr<?> bjr) {
        return auy.m4959a(map, bjr.getName());
    }

    /* renamed from: a */
    private static final <V> void m4948a(Map<? super String, ? super V> map, Object obj, bjr<?> bjr, V v) {
        bfq.m6567f(map, "$this$setValue");
        map.put(bjr.getName(), v);
    }
}
