package com.o3dr.android.client.utils.connection;

import java.nio.ByteBuffer;

public interface IpConnectionListener {
    void onIpConnected();

    void onIpDisconnected();

    void onPacketReceived(ByteBuffer byteBuffer);
}
