package com.bbn.ccast.mavlink;

import com.atakmap.coremap.log.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.LinkedBlockingQueue;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class UdpMavlinkTransport extends MavlinkTransport {
    /* access modifiers changed from: private */
    public static final String TAG = "UdpMavlinkTransport";
    private long connectionTimeoutMillis = HeartBeat.HEARTBEAT_NORMAL_TIMEOUT;
    private long lastMessageTime;
    private Thread listenerThread;
    private int localPort = -1;
    private InetAddress remoteHost;
    private int remotePort = -1;
    private volatile DatagramSocket socket;
    private UdpInputStream udpInputStream;

    public OutputStream getOutputStream() {
        return null;
    }

    public InputStream getInputStream() {
        return this.udpInputStream;
    }

    protected static class UdpListener implements Runnable {
        private final int MAXBUF = 65507;
        private final UdpMavlinkTransport transport;

        public UdpListener(UdpMavlinkTransport udpMavlinkTransport) {
            this.transport = udpMavlinkTransport;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:(5:4|5|(2:7|(1:9)(3:10|24|22))|11|25)|22|2|1) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
            com.atakmap.coremap.log.Log.d(com.bbn.ccast.mavlink.UdpMavlinkTransport.access$000(), "Mavlink UDPListener Thread was interrupted");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0013 */
        /* JADX WARNING: Removed duplicated region for block: B:4:0x0019 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                r0 = 65507(0xffe3, float:9.1795E-41)
                byte[] r1 = new byte[r0]
                java.net.DatagramPacket r2 = new java.net.DatagramPacket
                r2.<init>(r1, r0)
                java.lang.String r0 = com.bbn.ccast.mavlink.UdpMavlinkTransport.TAG
                java.lang.String r1 = "Starting UDP listening."
                com.atakmap.coremap.log.Log.d(r0, r1)
            L_0x0013:
                boolean r0 = java.lang.Thread.interrupted()     // Catch:{ InterruptedException -> 0x0053 }
                if (r0 != 0) goto L_0x005c
                com.bbn.ccast.mavlink.UdpMavlinkTransport r0 = r4.transport     // Catch:{ SocketTimeoutException -> 0x0049, IOException -> 0x0039 }
                if (r0 == 0) goto L_0x0033
                java.net.DatagramSocket r0 = r0.getSocket()     // Catch:{ SocketTimeoutException -> 0x0049, IOException -> 0x0039 }
                if (r0 != 0) goto L_0x0024
                goto L_0x0033
            L_0x0024:
                com.bbn.ccast.mavlink.UdpMavlinkTransport r0 = r4.transport     // Catch:{ SocketTimeoutException -> 0x0049, IOException -> 0x0039 }
                java.net.DatagramSocket r0 = r0.getSocket()     // Catch:{ SocketTimeoutException -> 0x0049, IOException -> 0x0039 }
                r0.receive(r2)     // Catch:{ SocketTimeoutException -> 0x0049, IOException -> 0x0039 }
                com.bbn.ccast.mavlink.UdpMavlinkTransport r0 = r4.transport     // Catch:{ SocketTimeoutException -> 0x0049, IOException -> 0x0039 }
                r0.onUdpReceive(r2)     // Catch:{ SocketTimeoutException -> 0x0049, IOException -> 0x0039 }
                goto L_0x0013
            L_0x0033:
                r0 = 500(0x1f4, double:2.47E-321)
                java.lang.Thread.sleep(r0)     // Catch:{ SocketTimeoutException -> 0x0049, IOException -> 0x0039 }
                goto L_0x0013
            L_0x0039:
                r0 = move-exception
                java.lang.String r1 = com.bbn.ccast.mavlink.UdpMavlinkTransport.TAG     // Catch:{ InterruptedException -> 0x0053 }
                java.lang.String r3 = "error"
                com.atakmap.coremap.log.Log.e(r1, r3, r0)     // Catch:{ InterruptedException -> 0x0053 }
                r0 = 1000(0x3e8, double:4.94E-321)
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0013 }
                goto L_0x0013
            L_0x0049:
                java.lang.String r0 = com.bbn.ccast.mavlink.UdpMavlinkTransport.TAG     // Catch:{ InterruptedException -> 0x0053 }
                java.lang.String r1 = "Mavlink UPDSocketTimedout"
                com.atakmap.coremap.log.Log.d(r0, r1)     // Catch:{ InterruptedException -> 0x0053 }
                goto L_0x0013
            L_0x0053:
                java.lang.String r0 = com.bbn.ccast.mavlink.UdpMavlinkTransport.TAG
                java.lang.String r1 = "Mavlink UDPListener Thread was interrupted"
                com.atakmap.coremap.log.Log.d(r0, r1)
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.UdpMavlinkTransport.UdpListener.run():void");
        }
    }

    private void startListening() {
        Thread thread = this.listenerThread;
        if (thread != null) {
            thread.interrupt();
            this.listenerThread = null;
        }
        Thread thread2 = new Thread(new UdpListener(this));
        this.listenerThread = thread2;
        thread2.start();
    }

    public void connect() {
        reconnect();
    }

    private boolean isServerMode() {
        return this.localPort > 0;
    }

    public void reconnect() {
        if (this.socket == null || this.socket.isClosed()) {
            if (isServerMode()) {
                this.socket = new DatagramSocket(this.localPort);
            } else {
                this.socket = new DatagramSocket(14550);
            }
            this.socket.setSoTimeout(2000);
            startListening();
            String str = TAG;
            Log.d(str, "Creating socket on " + this.localPort);
        }
        this.socket.setReuseAddress(true);
    }

    public boolean isConnected() {
        return System.currentTimeMillis() - this.lastMessageTime <= getConnectionTimeoutMillis();
    }

    public void close() {
        Log.d(TAG, "Closing Mavlink UDPTransport");
        Thread thread = this.listenerThread;
        if (thread != null) {
            thread.interrupt();
        }
        UdpInputStream udpInputStream2 = this.udpInputStream;
        if (udpInputStream2 != null) {
            udpInputStream2.close();
        }
        if (this.socket != null) {
            this.socket.close();
            this.socket.disconnect();
        }
        this.socket = null;
    }

    public UdpMavlinkTransport(int i) {
        this.localPort = i;
        this.udpInputStream = new UdpInputStream();
        init();
    }

    public UdpMavlinkTransport(String str, int i) {
        this.remotePort = i;
        try {
            this.remoteHost = InetAddress.getByName(str);
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "Invalid Host: " + str, e);
        }
        init();
    }

    private void init() {
        this.udpInputStream = new UdpInputStream();
        try {
            reconnect();
        } catch (Exception e) {
            Log.e(TAG, "Could not create udpclient", e);
        }
    }

    public DatagramSocket getSocket() {
        return this.socket;
    }

    public void setLastMessageTime(long j) {
        this.lastMessageTime = j;
    }

    public long getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    public void setConnectionTimeoutMillis(long j) {
        this.connectionTimeoutMillis = j;
    }

    public void write(byte[] bArr) {
        if (this.socket == null) {
            try {
                close();
                reconnect();
            } catch (Exception unused) {
            }
            String str = TAG;
            Log.d(str, "ERROR SENDING PACKET to " + this.remoteHost + ":" + this.remotePort);
        } else if (this.remoteHost != null && this.remotePort >= 0) {
            try {
                this.socket.send(new DatagramPacket(bArr, bArr.length, this.remoteHost, this.remotePort));
            } catch (Exception e) {
                close();
                try {
                    reconnect();
                } catch (Exception unused2) {
                }
                Log.e(TAG, "Can not send message", e);
            }
        }
    }

    public void onUdpReceive(DatagramPacket datagramPacket) {
        try {
            this.udpInputStream.putBytes(datagramPacket.getData(), datagramPacket.getLength());
            if (isServerMode()) {
                this.remotePort = datagramPacket.getPort();
                this.remoteHost = datagramPacket.getAddress();
            }
            setLastMessageTime(System.currentTimeMillis());
        } catch (Exception e) {
            Log.d(TAG, "Error writing received packet to inputstream", e);
        }
    }

    private static class UdpInputStream extends InputStream {
        private final LinkedBlockingQueue<Byte> input;

        private UdpInputStream() {
            this.input = new LinkedBlockingQueue<>();
        }

        public synchronized void putBytes(byte[] bArr, int i) {
            if (this.input.remainingCapacity() >= bArr.length) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.input.put(Byte.valueOf(bArr[i2]));
                }
            }
        }

        public int read() {
            try {
                return this.input.take().byteValue() & 255;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                Log.d(UdpMavlinkTransport.TAG, "UdpInputStream Interrupted.");
                return -1;
            }
        }
    }
}
