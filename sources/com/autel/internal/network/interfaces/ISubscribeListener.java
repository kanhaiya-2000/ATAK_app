package com.autel.internal.network.interfaces;

public interface ISubscribeListener {
    void connect();

    void disconnect();

    void registerConnectListener(String str, IConnectionListener iConnectionListener);

    void unRegisterConnectListener(String str);
}
