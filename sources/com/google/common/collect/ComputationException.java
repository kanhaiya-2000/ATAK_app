package com.google.common.collect;

import atakplugin.UASTool.cij;

@Deprecated
public class ComputationException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public ComputationException(@cij Throwable th) {
        super(th);
    }
}
