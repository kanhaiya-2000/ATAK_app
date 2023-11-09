package org.droidplanner.services.android.impl.core.MAVLink.connection;

import android.content.Context;
import android.os.Bundle;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.droidplanner.services.android.impl.utils.NetworkUtils;

public abstract class TcpConnection extends MavLinkConnection {
    private static final int CONNECTION_TIMEOUT = 20000;
    private BufferedInputStream mavIn;
    private BufferedOutputStream mavOut;
    private String serverIP;
    private int serverPort;
    private Socket socket;

    public final int getConnectionType() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public abstract String loadServerIP();

    /* access modifiers changed from: protected */
    public abstract int loadServerPort();

    protected TcpConnection(Context context) {
        super(context);
    }

    public final void openConnection(Bundle bundle) {
        getTCPStream(bundle);
        onConnectionOpened(bundle);
    }

    public final int readDataBlock(byte[] bArr) {
        return this.mavIn.read(bArr);
    }

    public final void sendBuffer(byte[] bArr) {
        BufferedOutputStream bufferedOutputStream = this.mavOut;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.write(bArr);
            this.mavOut.flush();
        }
    }

    public final void loadPreferences() {
        this.serverIP = loadServerIP();
        this.serverPort = loadServerPort();
    }

    public final void closeConnection() {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.close();
        }
    }

    private void getTCPStream(Bundle bundle) {
        InetAddress byName = InetAddress.getByName(this.serverIP);
        Socket socket2 = new Socket();
        this.socket = socket2;
        NetworkUtils.bindSocketToNetwork(bundle, socket2);
        this.socket.connect(new InetSocketAddress(byName, this.serverPort), CONNECTION_TIMEOUT);
        this.mavOut = new BufferedOutputStream(this.socket.getOutputStream());
        this.mavIn = new BufferedInputStream(this.socket.getInputStream());
    }
}
