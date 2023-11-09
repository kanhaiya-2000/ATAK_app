package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
    Map<K, Collection<V>> asMap();

    SortedSet<V> get(@cij K k);

    SortedSet<V> removeAll(@cij Object obj);

    SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
