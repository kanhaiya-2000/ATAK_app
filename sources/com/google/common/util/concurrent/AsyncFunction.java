package com.google.common.util.concurrent;

import atakplugin.UASTool.cij;

public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@cij I i);
}
