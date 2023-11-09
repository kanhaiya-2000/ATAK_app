package com.google.common.util.concurrent;

import atakplugin.UASTool.cij;

public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    protected ExecutionError() {
    }

    protected ExecutionError(@cij String str) {
        super(str);
    }

    public ExecutionError(@cij String str, @cij Error error) {
        super(str, error);
    }

    public ExecutionError(@cij Error error) {
        super(error);
    }
}
