package com.google.common.collect;

import atakplugin.UASTool.cij;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;

@DoNotMock("Use Maps.difference")
public interface MapDifference<K, V> {

    @DoNotMock("Use Maps.difference")
    public interface ValueDifference<V> {
        boolean equals(@cij Object obj);

        int hashCode();

        V leftValue();

        V rightValue();
    }

    boolean areEqual();

    Map<K, ValueDifference<V>> entriesDiffering();

    Map<K, V> entriesInCommon();

    Map<K, V> entriesOnlyOnLeft();

    Map<K, V> entriesOnlyOnRight();

    boolean equals(@cij Object obj);

    int hashCode();
}
