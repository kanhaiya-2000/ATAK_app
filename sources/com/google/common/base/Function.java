package com.google.common.base;

import atakplugin.UASTool.cij;

public interface Function<F, T> {
    @cij
    T apply(@cij F f);

    boolean equals(@cij Object obj);
}
