package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Parser;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.interfaces.IMavLinkConnectionListener;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MavLinkConnection {
    public static final int MAVLINK_CONNECTED = 2;
    public static final int MAVLINK_CONNECTING = 1;
    public static final int MAVLINK_DISCONNECTED = 0;
    private static final int MAX_PACKET_SEQUENCE = 255;
    public static final int MSG_CONNECT = 1001;
    public static final int MSG_DISCONNECT = 1002;
    private static final int READ_BUFFER_SIZE = 4096;
    public static int msgCount;
    private final String TAG = AutelLogTags.TAG_MAVLINK;
    private final Runnable mConnectingTask = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006d, code lost:
            if (r2.isAlive() != false) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ab, code lost:
            if (r2.isAlive() != false) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ad, code lost:
            r2.interrupt();
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x009c A[Catch:{ all -> 0x00b6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00a7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.lang.String r0 = "AUTEL_MAVLIVK"
                int r1 = android.os.Process.myTid()
                r2 = -16
                android.os.Process.setThreadPriority(r1, r2)
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r1 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this
                r1.loadPreferences()
                r1 = 0
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r2 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                r2.openConnection()     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r2 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                java.util.concurrent.atomic.AtomicInteger r2 = r2.mConnectionStatus     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                r3 = 2
                r2.set(r3)     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r2 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                r2.reportConnect()     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                java.lang.Thread r2 = new java.lang.Thread     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r4 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                java.lang.Runnable r4 = r4.mSendingTask     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                java.lang.String r5 = "MavLinkConnection-Sending Thread"
                r2.<init>(r4, r5)     // Catch:{ IOException -> 0x0074, all -> 0x0072 }
                r2.start()     // Catch:{ IOException -> 0x0070 }
                com.MAVLink.Parser r1 = new com.MAVLink.Parser     // Catch:{ IOException -> 0x0070 }
                r1.<init>()     // Catch:{ IOException -> 0x0070 }
                com.MAVLink.Messages.MAVLinkStats r4 = r1.stats     // Catch:{ IOException -> 0x0070 }
                r4.mavlinkResetStats()     // Catch:{ IOException -> 0x0070 }
                r4 = 4096(0x1000, float:5.74E-42)
                byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0070 }
                java.lang.String r5 = "fire mavlink connect receiver msg "
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ IOException -> 0x0070 }
            L_0x0048:
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r5 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this     // Catch:{ IOException -> 0x0070 }
                java.util.concurrent.atomic.AtomicInteger r5 = r5.mConnectionStatus     // Catch:{ IOException -> 0x0070 }
                int r5 = r5.get()     // Catch:{ IOException -> 0x0070 }
                if (r5 != r3) goto L_0x0064
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r5 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this     // Catch:{ IOException -> 0x0070 }
                int r5 = r5.readDataBlock(r4)     // Catch:{ IOException -> 0x0070 }
                int r6 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.msgCount     // Catch:{ IOException -> 0x0070 }
                int r6 = r6 + 1
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.msgCount = r6     // Catch:{ IOException -> 0x0070 }
                r8.handleData(r1, r5, r4)     // Catch:{ IOException -> 0x0070 }
                goto L_0x0048
            L_0x0064:
                java.lang.String r1 = "handleData msg finish disconnect "
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ IOException -> 0x0070 }
                boolean r0 = r2.isAlive()
                if (r0 == 0) goto L_0x00b0
                goto L_0x00ad
            L_0x0070:
                r1 = move-exception
                goto L_0x0078
            L_0x0072:
                r0 = move-exception
                goto L_0x00b8
            L_0x0074:
                r2 = move-exception
                r7 = r2
                r2 = r1
                r1 = r7
            L_0x0078:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
                r3.<init>()     // Catch:{ all -> 0x00b6 }
                java.lang.String r4 = "handleData msg finish IOException "
                r3.append(r4)     // Catch:{ all -> 0x00b6 }
                java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x00b6 }
                r3.append(r4)     // Catch:{ all -> 0x00b6 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b6 }
                com.autel.util.log.AutelLog.m15084e((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ all -> 0x00b6 }
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r0 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this     // Catch:{ all -> 0x00b6 }
                java.util.concurrent.atomic.AtomicInteger r0 = r0.mConnectionStatus     // Catch:{ all -> 0x00b6 }
                int r0 = r0.get()     // Catch:{ all -> 0x00b6 }
                if (r0 == 0) goto L_0x00a5
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r0 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this     // Catch:{ all -> 0x00b6 }
                java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00b6 }
                r0.reportComError(r1)     // Catch:{ all -> 0x00b6 }
            L_0x00a5:
                if (r2 == 0) goto L_0x00b0
                boolean r0 = r2.isAlive()
                if (r0 == 0) goto L_0x00b0
            L_0x00ad:
                r2.interrupt()
            L_0x00b0:
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r0 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this
                r0.disconnect()
                return
            L_0x00b6:
                r0 = move-exception
                r1 = r2
            L_0x00b8:
                if (r1 == 0) goto L_0x00c3
                boolean r2 = r1.isAlive()
                if (r2 == 0) goto L_0x00c3
                r1.interrupt()
            L_0x00c3:
                com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection r1 = com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.this
                r1.disconnect()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkconnection.MavLinkConnection.C50012.run():void");
        }

        private void handleData(Parser parser, int i, byte[] bArr) {
            MAVLinkMessage unpack;
            if (i >= 1) {
                for (int i2 = 0; i2 < i; i2++) {
                    MAVLinkPacket mavlink_parse_char = parser.mavlink_parse_char(bArr[i2] & 255);
                    if (!(mavlink_parse_char == null || (unpack = mavlink_parse_char.unpack()) == null)) {
                        MavLinkConnection.this.reportReceivedMessage(unpack);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    private Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    private final ConcurrentHashMap<String, IMavLinkConnectionListener> mListeners = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<MAVLinkPacket> mPacketsToSend = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public final Runnable mSendingTask = new Runnable() {
        public void run() {
            Process.setThreadPriority(Process.myTid(), -16);
            int i = 0;
            while (MavLinkConnection.this.mConnectionStatus.get() == 2) {
                try {
                    MAVLinkPacket mAVLinkPacket = (MAVLinkPacket) MavLinkConnection.this.mPacketsToSend.take();
                    mAVLinkPacket.seq = i;
                    try {
                        MavLinkConnection.this.sendBuffer(mAVLinkPacket.encodePacket());
                    } catch (IOException e) {
                        MavLinkConnection.this.reportComError(e.getMessage());
                    }
                    i = (i + 1) % 256;
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    MavLinkConnection.this.disconnect();
                    throw th;
                }
            }
            MavLinkConnection.this.disconnect();
        }
    };
    private Thread mTaskThread;

    /* access modifiers changed from: protected */
    public abstract void closeConnection();

    /* access modifiers changed from: protected */
    public abstract void loadPreferences();

    /* access modifiers changed from: protected */
    public abstract void openConnection();

    /* access modifiers changed from: protected */
    public abstract int readDataBlock(byte[] bArr);

    /* access modifiers changed from: protected */
    public abstract void sendBuffer(byte[] bArr);

    protected MavLinkConnection() {
        initHandler();
    }

    private void initHandler() {
        if (this.mHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("MavLinkConnection Thread");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
        }
        if (this.mHandler == null) {
            this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1001) {
                        MavLinkConnection.this.doConnect();
                    } else if (i == 1002) {
                        MavLinkConnection.this.doDisconnect();
                    }
                }
            };
        }
    }

    /* access modifiers changed from: private */
    public void doDisconnect() {
        if (this.mConnectionStatus.get() != 0 && this.mTaskThread != null) {
            try {
                this.mConnectionStatus.set(0);
                if (this.mTaskThread.isAlive() && !this.mTaskThread.isInterrupted()) {
                    this.mTaskThread.interrupt();
                }
                closeConnection();
                reportDisconnect();
            } catch (IOException e) {
                reportComError(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void doConnect() {
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            Log.d("MavlinkUdpSocket", "connect =====");
            Thread thread = new Thread(this.mConnectingTask, "MavLinkConnection-Connecting Thread");
            this.mTaskThread = thread;
            thread.start();
        }
    }

    public void connect() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(1001);
        }
    }

    public void disconnect() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler.sendEmptyMessage(1002);
        }
    }

    public boolean isConnected() {
        return getConnectionStatus() == 2;
    }

    public int getConnectionStatus() {
        return this.mConnectionStatus.get();
    }

    public void sendMavPacket(MAVLinkPacket mAVLinkPacket) {
        if (!this.mPacketsToSend.offer(mAVLinkPacket)) {
            AutelLog.m15084e(AutelLogTags.TAG_MAVLINK, "Unable to send mavlink packet. Packet queue is full!");
        }
    }

    public void addIMavLinkConnectionListener(String str, IMavLinkConnectionListener iMavLinkConnectionListener) {
        this.mListeners.put(str, iMavLinkConnectionListener);
        if (getConnectionStatus() == 2) {
            iMavLinkConnectionListener.onConnect();
        }
    }

    public void removeIMavLinkConnectionListener(String str) {
        this.mListeners.remove(str);
    }

    /* access modifiers changed from: private */
    public void reportComError(String str) {
        if (!this.mListeners.isEmpty()) {
            for (IMavLinkConnectionListener onComError : this.mListeners.values()) {
                onComError.onComError(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void reportConnect() {
        for (IMavLinkConnectionListener onConnect : this.mListeners.values()) {
            onConnect.onConnect();
        }
    }

    private void reportDisconnect() {
        if (!this.mListeners.isEmpty()) {
            for (IMavLinkConnectionListener onDisconnect : this.mListeners.values()) {
                onDisconnect.onDisconnect();
            }
        }
    }

    /* access modifiers changed from: private */
    public void reportReceivedMessage(MAVLinkMessage mAVLinkMessage) {
        if (!this.mListeners.isEmpty()) {
            for (IMavLinkConnectionListener onReceiveMessage : this.mListeners.values()) {
                onReceiveMessage.onReceiveMessage(mAVLinkMessage);
            }
        }
    }
}
