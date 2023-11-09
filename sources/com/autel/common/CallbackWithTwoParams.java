package com.autel.common;

public interface CallbackWithTwoParams<T, D> extends FailedCallback {
    void onSuccess(T t, D d);
}
