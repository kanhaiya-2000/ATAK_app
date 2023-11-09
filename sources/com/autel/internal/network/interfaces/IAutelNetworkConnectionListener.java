package com.autel.internal.network.interfaces;

public interface IAutelNetworkConnectionListener {
    void disconnect();

    void onUsbConnected();

    void onWifiConnected();
}
