package com.google.common.base;

import atakplugin.UASTool.cij;

public interface Predicate<T> {
    boolean apply(@cij T t);

    boolean equals(@cij Object obj);
}
