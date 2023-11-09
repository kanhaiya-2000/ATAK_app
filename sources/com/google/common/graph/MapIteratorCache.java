package com.google.common.graph;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MapIteratorCache<K, V> {
    /* access modifiers changed from: private */
    public final Map<K, V> backingMap;
    /* access modifiers changed from: private */
    @cij
    public volatile transient Map.Entry<K, V> cacheEntry;

    MapIteratorCache(Map<K, V> map) {
        this.backingMap = (Map) Preconditions.checkNotNull(map);
    }

    public final V put(@cij K k, @cij V v) {
        clearCache();
        return this.backingMap.put(k, v);
    }

    public final V remove(@cij Object obj) {
        clearCache();
        return this.backingMap.remove(obj);
    }

    public final void clear() {
        clearCache();
        this.backingMap.clear();
    }

    public V get(@cij Object obj) {
        V ifCached = getIfCached(obj);
        return ifCached != null ? ifCached : getWithoutCaching(obj);
    }

    public final V getWithoutCaching(@cij Object obj) {
        return this.backingMap.get(obj);
    }

    public final boolean containsKey(@cij Object obj) {
        return getIfCached(obj) != null || this.backingMap.containsKey(obj);
    }

    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() {
            public UnmodifiableIterator<K> iterator() {
                final Iterator it = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() {
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public K next() {
                        Map.Entry entry = (Map.Entry) it.next();
                        Map.Entry unused = MapIteratorCache.this.cacheEntry = entry;
                        return entry.getKey();
                    }
                };
            }

            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }

            public boolean contains(@cij Object obj) {
                return MapIteratorCache.this.containsKey(obj);
            }
        };
    }

    /* access modifiers changed from: protected */
    public V getIfCached(@cij Object obj) {
        Map.Entry<K, V> entry = this.cacheEntry;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    /* access modifiers changed from: protected */
    public void clearCache() {
        this.cacheEntry = null;
    }
}
