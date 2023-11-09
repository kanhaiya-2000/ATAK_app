package com.bbn.ccast.mavlink;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpMavlinkTransport extends MavlinkTransport {
    private String host;
    private int port;
    private boolean shouldListen;
    private volatile Socket socket;

    private TcpMavlinkTransport() {
    }

    public InputStream getInputStream() {
        if (getSocket() == null) {
            return null;
        }
        return this.socket.getInputStream();
    }

    public OutputStream getOutputStream() {
        if (getSocket() == null) {
            return null;
        }
        return this.socket.getOutputStream();
    }

    public void setHost(String str) {
        this.host = str;
    }

    public String getHost() {
        return this.host;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public int getPort() {
        return this.port;
    }

    public void setShouldListen(boolean z) {
        this.shouldListen = z;
    }

    public boolean getShouldListen() {
        return this.shouldListen;
    }

    public void setSocket(Socket socket2) {
        this.socket = socket2;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void connect() {
        reconnect();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reconnect() {
        /*
            r4 = this;
            boolean r0 = r4.getShouldListen()
            if (r0 == 0) goto L_0x0043
            java.net.ServerSocket r0 = new java.net.ServerSocket     // Catch:{ Exception -> 0x002b }
            int r1 = r4.getPort()     // Catch:{ Exception -> 0x002b }
            r0.<init>(r1)     // Catch:{ Exception -> 0x002b }
            java.net.Socket r1 = r0.accept()     // Catch:{ all -> 0x0019 }
            r4.socket = r1     // Catch:{ all -> 0x0019 }
            r0.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x0052
        L_0x0019:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x001b }
        L_0x001b:
            r2 = move-exception
            if (r1 == 0) goto L_0x0027
            r0.close()     // Catch:{ all -> 0x0022 }
            goto L_0x002a
        L_0x0022:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ Exception -> 0x002b }
            goto L_0x002a
        L_0x0027:
            r0.close()     // Catch:{ Exception -> 0x002b }
        L_0x002a:
            throw r2     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to listen on MAVLink socket: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.println(r2)
            throw r0
        L_0x0043:
            java.net.Socket r0 = new java.net.Socket
            java.lang.String r1 = r4.getHost()
            int r2 = r4.getPort()
            r0.<init>(r1, r2)
            r4.socket = r0
        L_0x0052:
            java.net.Socket r0 = r4.socket
            r4.setSocket(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.TcpMavlinkTransport.reconnect():void");
    }

    public void close() {
        if (this.socket != null) {
            this.socket.close();
        }
        setSocket((Socket) null);
    }

    public boolean isConnected() {
        return getSocket() != null && getSocket().isConnected();
    }

    public TcpMavlinkTransport(String str, int i, boolean z) {
        this();
        setHost(str);
        setPort(i);
        setShouldListen(z);
    }
}
