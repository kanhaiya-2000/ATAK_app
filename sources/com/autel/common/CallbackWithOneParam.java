package com.autel.common;

public interface CallbackWithOneParam<T> extends FailedCallback {
    void onSuccess(T t);
}
