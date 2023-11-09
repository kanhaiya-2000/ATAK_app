package com.google.common.graph;

import atakplugin.UASTool.cij;
import java.util.Set;

public interface ValueGraph<N, V> extends BaseGraph<N> {
    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n);

    @cij
    V edgeValueOrDefault(EndpointPair<N> endpointPair, @cij V v);

    @cij
    V edgeValueOrDefault(N n, N n2, @cij V v);

    Set<EndpointPair<N>> edges();

    boolean equals(@cij Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    Set<EndpointPair<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<N> predecessors(N n);

    Set<N> successors(N n);
}
