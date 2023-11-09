package com.google.common.graph;

import atakplugin.UASTool.cij;
import java.util.Iterator;
import java.util.Set;

interface GraphConnections<N, V> {
    void addPredecessor(N n, V v);

    V addSuccessor(N n, V v);

    Set<N> adjacentNodes();

    Iterator<EndpointPair<N>> incidentEdgeIterator(N n);

    Set<N> predecessors();

    void removePredecessor(N n);

    V removeSuccessor(N n);

    Set<N> successors();

    @cij
    V value(N n);
}
