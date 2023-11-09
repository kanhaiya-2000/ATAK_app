package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.io.Serializable;

class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    @cij
    final K key;
    @cij
    final V value;

    ImmutableEntry(@cij K k, @cij V v) {
        this.key = k;
        this.value = v;
    }

    @cij
    public final K getKey() {
        return this.key;
    }

    @cij
    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
