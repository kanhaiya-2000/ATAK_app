package com.google.common.graph;

import atakplugin.UASTool.cij;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;

final class EdgesConnecting<E> extends AbstractSet<E> {
    private final Map<?, E> nodeToOutEdge;
    private final Object targetNode;

    EdgesConnecting(Map<?, E> map, Object obj) {
        this.nodeToOutEdge = (Map) Preconditions.checkNotNull(map);
        this.targetNode = Preconditions.checkNotNull(obj);
    }

    public UnmodifiableIterator<E> iterator() {
        Object connectingEdge = getConnectingEdge();
        if (connectingEdge == null) {
            return ImmutableSet.m15175of().iterator();
        }
        return Iterators.singletonIterator(connectingEdge);
    }

    public int size() {
        return getConnectingEdge() == null ? 0 : 1;
    }

    public boolean contains(@cij Object obj) {
        Object connectingEdge = getConnectingEdge();
        return connectingEdge != null && connectingEdge.equals(obj);
    }

    @cij
    private E getConnectingEdge() {
        return this.nodeToOutEdge.get(this.targetNode);
    }
}
