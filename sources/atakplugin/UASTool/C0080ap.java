package atakplugin.UASTool;

import java.util.Collections;
import java.util.Map;

/* renamed from: atakplugin.UASTool.ap */
final class C0080ap implements C0530il<Map<K, V>> {
    C0080ap() {
    }

    /* renamed from: a */
    public Map<K, V> apply(Map<K, V> map) {
        C0293ca.m10960a(map.keySet());
        C0293ca.m10960a(map.values());
        return Collections.unmodifiableMap(map);
    }
}
