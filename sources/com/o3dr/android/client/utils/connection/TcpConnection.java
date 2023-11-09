package com.o3dr.android.client.utils.connection;

import android.os.Bundle;
import android.os.Handler;
import com.o3dr.android.client.utils.connection.AbstractIpConnection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import org.droidplanner.services.android.impl.utils.NetworkUtils;

public class TcpConnection extends AbstractIpConnection {
    private BufferedInputStream connIn;
    private BufferedOutputStream connOut;
    private final String serverIp;
    private final int serverPort;
    private Socket socket;

    public TcpConnection(Handler handler, String str, int i) {
        super(handler);
        this.serverIp = str;
        this.serverPort = i;
    }

    /* access modifiers changed from: protected */
    public void open(Bundle bundle) {
        InetAddress byName = InetAddress.getByName(this.serverIp);
        Socket socket2 = new Socket();
        this.socket = socket2;
        socket2.setReuseAddress(true);
        NetworkUtils.bindSocketToNetwork(bundle, this.socket);
        this.socket.connect(new InetSocketAddress(byName, this.serverPort), AbstractIpConnection.CONNECTION_TIMEOUT);
        this.connOut = new BufferedOutputStream(this.socket.getOutputStream());
        this.connIn = new BufferedInputStream(this.socket.getInputStream());
    }

    /* access modifiers changed from: protected */
    public int read(ByteBuffer byteBuffer) {
        return this.connIn.read(byteBuffer.array());
    }

    /* access modifiers changed from: protected */
    public void send(AbstractIpConnection.PacketData packetData) {
        this.connOut.write(packetData.data, 0, packetData.dataLength);
        this.connOut.flush();
    }

    /* access modifiers changed from: protected */
    public void close() {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.close();
        }
    }
}
