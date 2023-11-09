package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.util.List;

public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
    /* access modifiers changed from: protected */
    public abstract ListMultimap<K, V> delegate();

    protected ForwardingListMultimap() {
    }

    public List<V> get(@cij K k) {
        return delegate().get(k);
    }

    public List<V> removeAll(@cij Object obj) {
        return delegate().removeAll(obj);
    }

    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues(k, iterable);
    }
}
