package com.autel.sdk10.AutelNet.AutelDsp.wifi.connection;

import com.MAVLink.Messages.MAVLinkPayload;
import com.autel.sdk10.AutelNet.AutelDsp.wifi.info.AskBindSsidInfo;
import com.autel.sdk10.AutelNet.AutelDsp.wifi.info.BindSsidInfo;
import com.autel.sdk10.AutelNet.AutelDsp.wifi.interfaces.AutelSSIDConnectionInterface;
import com.autel.util.log.AutelLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SSIDConnection {
    public static final int CONNECTED = 2;
    public static final int CONNECTING = 1;
    private static final int CONNECTION_TIMEOUT = 20000;
    public static final int DISCONNECTED = 0;
    private static final int READ_BUFFER_SIZE = 4096;
    private final int REPLYLENGTH = 120;
    private ConcurrentHashMap<String, AutelSSIDConnectionInterface.BindSsidConnectionListener> bscListenerMaps = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<BindSsidInfo> mBindToSend = new LinkedBlockingQueue<>();
    private final Runnable mConnectingTask = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
            if (r1.isAlive() != false) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
            r1.interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
            if (r1.isAlive() != false) goto L_0x0059;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection r1 = com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.this     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                r1.openConnection()     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection r1 = com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.this     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                java.util.concurrent.atomic.AtomicInteger r1 = r1.mConnectionStatus     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                r2 = 2
                r1.set(r2)     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                java.lang.Thread r1 = new java.lang.Thread     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection r3 = com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.this     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                java.lang.Runnable r3 = r3.mSendingTask     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                java.lang.String r4 = "Sending Thread"
                r1.<init>(r3, r4)     // Catch:{ IOException -> 0x004a, all -> 0x0045 }
                r1.start()     // Catch:{ IOException -> 0x0043 }
                r0 = 4096(0x1000, float:5.74E-42)
                byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0043 }
            L_0x0024:
                com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection r3 = com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.this     // Catch:{ IOException -> 0x0043 }
                java.util.concurrent.atomic.AtomicInteger r3 = r3.mConnectionStatus     // Catch:{ IOException -> 0x0043 }
                int r3 = r3.get()     // Catch:{ IOException -> 0x0043 }
                if (r3 != r2) goto L_0x003c
                com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection r3 = com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.this     // Catch:{ IOException -> 0x0043 }
                int r3 = r3.readDataBlock(r0)     // Catch:{ IOException -> 0x0043 }
                com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection r4 = com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.this     // Catch:{ IOException -> 0x0043 }
                r4.handleData(r3, r0)     // Catch:{ IOException -> 0x0043 }
                goto L_0x0024
            L_0x003c:
                boolean r0 = r1.isAlive()
                if (r0 == 0) goto L_0x005c
                goto L_0x0059
            L_0x0043:
                r0 = move-exception
                goto L_0x004e
            L_0x0045:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L_0x0063
            L_0x004a:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L_0x004e:
                r0.printStackTrace()     // Catch:{ all -> 0x0062 }
                if (r1 == 0) goto L_0x005c
                boolean r0 = r1.isAlive()
                if (r0 == 0) goto L_0x005c
            L_0x0059:
                r1.interrupt()
            L_0x005c:
                com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection r0 = com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.this
                r0.disconnect()
                return
            L_0x0062:
                r0 = move-exception
            L_0x0063:
                if (r1 == 0) goto L_0x006e
                boolean r2 = r1.isAlive()
                if (r2 == 0) goto L_0x006e
                r1.interrupt()
            L_0x006e:
                com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection r1 = com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.this
                r1.disconnect()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection.C49671.run():void");
        }
    };
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Runnable mSendingTask = new Runnable() {
        public void run() {
            while (SSIDConnection.this.mConnectionStatus.get() == 2) {
                try {
                    BindSsidInfo bindSsidInfo = (BindSsidInfo) SSIDConnection.this.mBindToSend.take();
                    bindSsidInfo.pack();
                    try {
                        SSIDConnection.this.sendBuffer(bindSsidInfo.encodeInfo());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    };
    private Thread mTaskThread;
    private BufferedInputStream mavIn;
    private BufferedOutputStream mavOut;
    private String serverIP;
    private int serverPort;
    private Socket socket;

    public SSIDConnection() {
        loadPreferences();
    }

    /* access modifiers changed from: protected */
    public final void openConnection() {
        getTCPStream();
    }

    /* access modifiers changed from: protected */
    public final int readDataBlock(byte[] bArr) {
        if (bArr != null) {
            return this.mavIn.read(bArr);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void sendBuffer(byte[] bArr) {
        BufferedOutputStream bufferedOutputStream = this.mavOut;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.write(bArr);
            this.mavOut.flush();
        }
    }

    /* access modifiers changed from: protected */
    public final void loadPreferences() {
        this.serverIP = "192.168.1.20";
        this.serverPort = 9607;
    }

    /* access modifiers changed from: protected */
    public final void closeConnection() {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.close();
        }
    }

    private void getTCPStream() {
        InetAddress byName = InetAddress.getByName(this.serverIP);
        Socket socket2 = new Socket();
        this.socket = socket2;
        socket2.connect(new InetSocketAddress(byName, this.serverPort), CONNECTION_TIMEOUT);
        this.mavOut = new BufferedOutputStream(this.socket.getOutputStream());
        this.mavIn = new BufferedInputStream(this.socket.getInputStream());
    }

    public void addBindConnectionListener(String str, AutelSSIDConnectionInterface.BindSsidConnectionListener bindSsidConnectionListener) {
        this.bscListenerMaps.put(str, bindSsidConnectionListener);
    }

    public void removeBindConnectionListener(String str) {
        this.bscListenerMaps.remove(str);
    }

    public void removeAllBindConnectionListener() {
        this.bscListenerMaps.clear();
    }

    public void connect() {
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            Thread thread = new Thread(this.mConnectingTask, "SSIDConnection connect Thread");
            this.mTaskThread = thread;
            thread.start();
        }
    }

    public void disconnect() {
        AutelLog.m15083e("close connection data");
        if (this.mConnectionStatus.get() != 0 && this.mTaskThread != null) {
            try {
                this.mConnectionStatus.set(0);
                closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getConnectStatus() {
        return this.mConnectionStatus.get();
    }

    /* access modifiers changed from: private */
    public void handleData(int i, byte[] bArr) {
        if (i >= 1) {
            BindSsidInfo askBindSsidInfo = i > 120 ? new AskBindSsidInfo() : new BindSsidInfo();
            MAVLinkPayload mAVLinkPayload = new MAVLinkPayload();
            for (int i2 = 0; i2 < i; i2++) {
                mAVLinkPayload.add((byte) (bArr[i2] & 255));
            }
            if (i > 0) {
                askBindSsidInfo.unpack(mAVLinkPayload);
                reportReceivedMsg(askBindSsidInfo);
            }
        }
    }

    private void reportReceivedMsg(BindSsidInfo bindSsidInfo) {
        if (!this.bscListenerMaps.isEmpty()) {
            for (AutelSSIDConnectionInterface.BindSsidConnectionListener onReceiveMessage : this.bscListenerMaps.values()) {
                onReceiveMessage.onReceiveMessage(bindSsidInfo);
            }
        }
    }

    public void sendBindSsidAnsower(BindSsidInfo bindSsidInfo) {
        this.mBindToSend.offer(bindSsidInfo);
    }
}
