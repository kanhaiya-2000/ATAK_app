package com.autel.sdk10.products.requestmanager;

import com.autel.internal.network.NetworkManager;
import com.autel.internal.network.interfaces.IAutelNetworkConnectionListener;
import com.autel.internal.sdk.AutelBaseApplication;
import com.autel.internal.sdk.heartbeat.IAutelHeartBeatListener;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.core.heartbeat.HeartbeatManager;

public class AutelProductRequestManager {
    public static void addIAutelHeartBeatListener(String str, IAutelHeartBeatListener iAutelHeartBeatListener) {
        HeartbeatManager.getInstance().addIAutelHeartBeatListener(str, iAutelHeartBeatListener);
    }

    public static void removeIAutelHeartBeatListener(String str) {
        HeartbeatManager.getInstance().removeIAutelHeartBeatListener(str);
    }

    public static void addIAutelNetworkConnectionListener(String str, IAutelNetworkConnectionListener iAutelNetworkConnectionListener) {
        NetworkManager.getInstance(AutelBaseApplication.getAppContext()).addIAutelNetworkConnectionListener(str, iAutelNetworkConnectionListener);
    }

    public static void removeIAutelNetworkConnectionListener(String str) {
        NetworkManager.getInstance(AutelBaseApplication.getAppContext()).removeIAutelNetworkConnectionListener(str);
    }
}
