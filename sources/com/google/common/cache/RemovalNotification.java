package com.google.common.cache;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;

public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public static <K, V> RemovalNotification<K, V> create(@cij K k, @cij V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    private RemovalNotification(@cij K k, @cij V v, RemovalCause removalCause) {
        super(k, v);
        this.cause = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
