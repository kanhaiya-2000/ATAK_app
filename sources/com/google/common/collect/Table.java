package com.google.common.collect;

import atakplugin.UASTool.cij;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@DoNotMock("Use ImmutableTable, HashBasedTable, or another implementation")
public interface Table<R, C, V> {

    public interface Cell<R, C, V> {
        boolean equals(@cij Object obj);

        @cij
        C getColumnKey();

        @cij
        R getRowKey();

        @cij
        V getValue();

        int hashCode();
    }

    Set<Cell<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C c);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@cij Object obj, @cij Object obj2);

    boolean containsColumn(@cij Object obj);

    boolean containsRow(@cij Object obj);

    boolean containsValue(@cij Object obj);

    boolean equals(@cij Object obj);

    V get(@cij Object obj, @cij Object obj2);

    int hashCode();

    boolean isEmpty();

    @cij
    V put(R r, C c, V v);

    void putAll(Table<? extends R, ? extends C, ? extends V> table);

    @cij
    V remove(@cij Object obj, @cij Object obj2);

    Map<C, V> row(R r);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
