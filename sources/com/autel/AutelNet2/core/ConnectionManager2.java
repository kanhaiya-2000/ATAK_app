package com.autel.AutelNet2.core;

import com.autel.AutelNet2.core.connection.UdpConnectionImpl;

public class ConnectionManager2 extends UdpConnectionImpl {
    private static final String TAG = "UdpConnectionManager";
    private static ConnectionManager2 instance_;

    public static synchronized ConnectionManager2 getInstance_() {
        ConnectionManager2 connectionManager2;
        synchronized (ConnectionManager2.class) {
            if (instance_ == null) {
                instance_ = new ConnectionManager2();
            }
            connectionManager2 = instance_;
        }
        return connectionManager2;
    }
}
