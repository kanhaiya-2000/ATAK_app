package com.google.common.graph;

import atakplugin.UASTool.cij;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;

abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    AbstractBaseGraph() {
    }

    /* access modifiers changed from: protected */
    public long edgeCount() {
        long j = 0;
        for (Object degree : nodes()) {
            j += (long) degree(degree);
        }
        Preconditions.checkState((1 & j) == 0);
        return j >>> 1;
    }

    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() {
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.m15233of(AbstractBaseGraph.this);
            }

            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            public boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            public boolean contains(@cij Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!AbstractBaseGraph.this.isOrderingCompatible(endpointPair) || !AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) || !AbstractBaseGraph.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }
        };
    }

    public Set<EndpointPair<N>> incidentEdges(N n) {
        Preconditions.checkNotNull(n);
        Preconditions.checkArgument(nodes().contains(n), "Node %s is not an element of this graph.", (Object) n);
        return new IncidentEdgeSet<N>(this, n) {
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                if (this.graph.isDirected()) {
                    return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors(this.node).iterator(), new Function<N, EndpointPair<N>>() {
                        public EndpointPair<N> apply(N n) {
                            return EndpointPair.ordered(n, C54162.this.node);
                        }
                    }), Iterators.transform(Sets.difference(this.graph.successors(this.node), ImmutableSet.m15176of(this.node)).iterator(), new Function<N, EndpointPair<N>>() {
                        public EndpointPair<N> apply(N n) {
                            return EndpointPair.ordered(C54162.this.node, n);
                        }
                    })));
                }
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function<N, EndpointPair<N>>() {
                    public EndpointPair<N> apply(N n) {
                        return EndpointPair.unordered(C54162.this.node, n);
                    }
                }));
            }
        };
    }

    public int degree(N n) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors(n).size(), successors(n).size());
        }
        Set adjacentNodes = adjacentNodes(n);
        return IntMath.saturatedAdd(adjacentNodes.size(), (!allowsSelfLoops() || !adjacentNodes.contains(n)) ? 0 : 1);
    }

    public int inDegree(N n) {
        return isDirected() ? predecessors(n).size() : degree(n);
    }

    public int outDegree(N n) {
        return isDirected() ? successors(n).size() : degree(n);
    }

    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        return nodes().contains(n) && successors(n).contains(n2);
    }

    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        N nodeV = endpointPair.nodeV();
        if (!nodes().contains(nodeU) || !successors(nodeU).contains(nodeV)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    /* access modifiers changed from: protected */
    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }
}
