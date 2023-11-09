package com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces;

import com.autel.common.error.AutelError;

public interface IAutelFirmVersionCallback<T> {
    void onFailure(AutelError autelError);

    void onReceiveVersion(T t);
}
