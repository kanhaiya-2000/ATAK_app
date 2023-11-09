package com.autel.AutelNet2.core.interfaces;

public interface IConnectionListener {
    void onConnectError(String str);

    void onConnected();

    void onDisconnected();

    void startConnect();
}
