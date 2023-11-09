package com.autel.sdk10.interfaces;

public interface IAutelConnectionStatusListener {
    void onConnect();

    void onDisconnect();

    void onReconnect();
}
