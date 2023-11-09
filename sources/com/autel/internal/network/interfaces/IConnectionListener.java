package com.autel.internal.network.interfaces;

import com.autel.internal.sdk.camera.base.ConnectConnectStatus;

public interface IConnectionListener {
    void onConnectStatus(ConnectConnectStatus connectConnectStatus);
}
