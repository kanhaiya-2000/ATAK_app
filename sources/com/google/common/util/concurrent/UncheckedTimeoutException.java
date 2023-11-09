package com.google.common.util.concurrent;

import atakplugin.UASTool.cij;

public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@cij String str) {
        super(str);
    }

    public UncheckedTimeoutException(@cij Throwable th) {
        super(th);
    }

    public UncheckedTimeoutException(@cij String str, @cij Throwable th) {
        super(str, th);
    }
}
