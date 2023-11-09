package com.autel.common;

public interface CallbackWithOneParamProgress<T> extends CallbackWithOneParam<T> {
    void onProgress(float f);
}
