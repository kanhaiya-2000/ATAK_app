package com.google.common.util.concurrent;

import atakplugin.UASTool.cij;

public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(@cij V v);
}
