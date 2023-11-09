package com.google.common.base;

import atakplugin.UASTool.cij;

public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(@cij String str) {
        super(str);
    }

    public VerifyException(@cij Throwable th) {
        super(th);
    }

    public VerifyException(@cij String str, @cij Throwable th) {
        super(str, th);
    }
}
