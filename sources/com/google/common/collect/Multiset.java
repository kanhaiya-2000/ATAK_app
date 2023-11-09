package com.google.common.collect;

import atakplugin.UASTool.cij;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    int add(@cij E e, int i);

    boolean add(E e);

    boolean contains(@cij Object obj);

    boolean containsAll(Collection<?> collection);

    int count(@cij Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@cij Object obj);

    int hashCode();

    Iterator<E> iterator();

    int remove(@cij Object obj, int i);

    boolean remove(@cij Object obj);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<?> collection);

    int setCount(E e, int i);

    boolean setCount(E e, int i, int i2);

    int size();

    String toString();
}
