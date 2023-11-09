package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.util.Map;
import java.util.Set;

public interface BiMap<K, V> extends Map<K, V> {
    @cij
    V forcePut(@cij K k, @cij V v);

    BiMap<V, K> inverse();

    @cij
    V put(@cij K k, @cij V v);

    void putAll(Map<? extends K, ? extends V> map);

    Set<V> values();
}
