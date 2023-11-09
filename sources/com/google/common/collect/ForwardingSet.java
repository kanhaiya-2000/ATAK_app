package com.google.common.collect;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;

public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    /* access modifiers changed from: protected */
    public abstract Set<E> delegate();

    protected ForwardingSet() {
    }

    public boolean equals(@cij Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.removeAllImpl((Set<?>) this, (Collection<?>) (Collection) Preconditions.checkNotNull(collection));
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@cij Object obj) {
        return Sets.equalsImpl(this, obj);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return Sets.hashCodeImpl(this);
    }
}
