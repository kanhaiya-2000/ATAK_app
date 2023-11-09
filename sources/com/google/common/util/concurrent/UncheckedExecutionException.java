package com.google.common.util.concurrent;

import atakplugin.UASTool.cij;

public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    protected UncheckedExecutionException() {
    }

    protected UncheckedExecutionException(@cij String str) {
        super(str);
    }

    public UncheckedExecutionException(@cij String str, @cij Throwable th) {
        super(str, th);
    }

    public UncheckedExecutionException(@cij Throwable th) {
        super(th);
    }
}
