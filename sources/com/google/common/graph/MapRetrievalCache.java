package com.google.common.graph;

import atakplugin.UASTool.cij;
import java.util.Map;

class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    @cij
    private volatile transient CacheEntry<K, V> cacheEntry1;
    @cij
    private volatile transient CacheEntry<K, V> cacheEntry2;

    MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    public V get(@cij Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        V withoutCaching = getWithoutCaching(obj);
        if (withoutCaching != null) {
            addToCache(obj, withoutCaching);
        }
        return withoutCaching;
    }

    /* access modifiers changed from: protected */
    public V getIfCached(@cij Object obj) {
        V ifCached = super.getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        CacheEntry<K, V> cacheEntry = this.cacheEntry1;
        if (cacheEntry != null && cacheEntry.key == obj) {
            return cacheEntry.value;
        }
        CacheEntry<K, V> cacheEntry3 = this.cacheEntry2;
        if (cacheEntry3 == null || cacheEntry3.key != obj) {
            return null;
        }
        addToCache(cacheEntry3);
        return cacheEntry3.value;
    }

    /* access modifiers changed from: protected */
    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    private void addToCache(K k, V v) {
        addToCache(new CacheEntry(k, v));
    }

    private void addToCache(CacheEntry<K, V> cacheEntry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = cacheEntry;
    }

    private static final class CacheEntry<K, V> {
        final K key;
        final V value;

        CacheEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
}
