package com.google.common.util.concurrent;

import atakplugin.UASTool.cij;

final class Platform {
    static boolean isInstanceOfThrowableClass(@cij Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }

    private Platform() {
    }
}
