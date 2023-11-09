package com.google.common.cache;

import atakplugin.UASTool.cij;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

@DoNotMock("Use CacheBuilder.newBuilder().build()")
public interface Cache<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K k, Callable<? extends V> callable);

    ImmutableMap<K, V> getAllPresent(Iterable<?> iterable);

    @cij
    V getIfPresent(Object obj);

    void invalidate(Object obj);

    void invalidateAll();

    void invalidateAll(Iterable<?> iterable);

    void put(K k, V v);

    void putAll(Map<? extends K, ? extends V> map);

    long size();

    CacheStats stats();
}
