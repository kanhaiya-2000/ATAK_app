package com.google.common.collect;

import atakplugin.UASTool.cij;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@cij Object obj, @cij Object obj2);

    boolean containsKey(@cij Object obj);

    boolean containsValue(@cij Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@cij Object obj);

    Collection<V> get(@cij K k);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    Multiset<K> keys();

    boolean put(@cij K k, @cij V v);

    boolean putAll(Multimap<? extends K, ? extends V> multimap);

    boolean putAll(@cij K k, Iterable<? extends V> iterable);

    boolean remove(@cij Object obj, @cij Object obj2);

    Collection<V> removeAll(@cij Object obj);

    Collection<V> replaceValues(@cij K k, Iterable<? extends V> iterable);

    int size();

    Collection<V> values();
}
