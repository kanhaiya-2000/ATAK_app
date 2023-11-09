package com.autel.internal.network.interfaces;

import android.net.NetworkInfo;

public interface IAutelWifiConnectStatusListener {
    void onReceive(NetworkInfo networkInfo);
}
