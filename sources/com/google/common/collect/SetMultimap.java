package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface SetMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    Set<Map.Entry<K, V>> entries();

    boolean equals(@cij Object obj);

    Set<V> get(@cij K k);

    Set<V> removeAll(@cij Object obj);

    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
