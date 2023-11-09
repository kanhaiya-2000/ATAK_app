package com.autel.internal.sdk.upgrade;

import com.autel.common.CallbackWithOneParam;

public interface CallBackWithOneParamProgressFirmwareUpgrade<T> extends CallbackWithOneParam<T> {
    void onProgress(T t);
}
