package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(@cij Object obj);

    List<V> get(@cij K k);

    List<V> removeAll(@cij Object obj);

    List<V> replaceValues(K k, Iterable<? extends V> iterable);
}
