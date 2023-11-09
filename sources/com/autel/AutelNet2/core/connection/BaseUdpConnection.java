package com.autel.AutelNet2.core.connection;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.autel.AutelNet2.aircraft.flycontroller.FlyControllerManager2;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.interfaces.IConnectionListener;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.core.message.MsgHead;
import com.autel.AutelNet2.core.utils.MsgParser;
import com.autel.AutelNet2.core.utils.UdpConfig;
import com.autel.AutelNet2.utils.BytesUtils;
import com.autel.internal.network.abstracts.AbsUdpConnection;
import com.autel.util.log.AutelLog;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseUdpConnection extends AbsUdpConnection {
    private static final int READ_BUFFER_SIZE = 4096;
    private static final int REQUEST_CONNECT = 2001;
    private static final int REQUEST_DISCONNECT = 2002;
    private static final int REQUEST_RECONNECT = 2003;
    public static final int STATUS_CONNECTED = 2;
    public static final int STATUS_CONNECTING = 1;
    public static final int STATUS_DISCONNECTED = 0;
    private static final int TIMEOUT = 3000;
    private final String TAG = "BaseUdpConnection";
    /* access modifiers changed from: private */
    public Runnable checkOutTimeRunnable = new Runnable() {
        public void run() {
            try {
                if (BaseUdpConnection.this.isCheckOutTimeThreadRunning) {
                    if (BaseUdpConnection.this.lastMsgTime == 0 || System.currentTimeMillis() - BaseUdpConnection.this.lastMsgTime <= 3000) {
                        BaseUdpConnection.this.mHandler.postDelayed(this, 1000);
                        return;
                    }
                    AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "udp checkOutTimeRunnable timeout");
                    Log.e("BaseUdpConnection", "--------------Timeout ");
                    BaseUdpConnection.this.notifyComError("Timeout");
                }
            } catch (Exception e) {
                AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "udp checkOutTimeRunnable timeout Exception " + e.getMessage());
            }
        }
    };
    /* access modifiers changed from: private */
    public Runnable heartbeat = new Runnable() {
        public void run() {
            FlyControllerManager2.getInstance().setHeartBeat();
            if (BaseUdpConnection.this.mHandler != null) {
                BaseUdpConnection.this.mHandler.postDelayed(this, 1000);
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile boolean isCheckOutTimeThreadRunning = true;
    /* access modifiers changed from: private */
    public boolean isDisConnect = false;
    public volatile long lastMsgTime = 0;
    private final Runnable mConnectingTask = new Runnable() {
        public static final int TIMEOUT = 6;

        /* JADX INFO: finally extract failed */
        public void run() {
            Process.setThreadPriority(Process.myTid(), -16);
            try {
                if (BaseUdpConnection.this.mHandler != null) {
                    BaseUdpConnection.this.mHandler.postDelayed(BaseUdpConnection.this.checkOutTimeRunnable, 500);
                    BaseUdpConnection.this.mHandler.postDelayed(BaseUdpConnection.this.heartbeat, 1000);
                }
                if (BaseUdpConnection.this.mSendHandler != null && !BaseUdpConnection.this.mSendHandler.hasMessages(0) && !BaseUdpConnection.this.sendingTaskWorking) {
                    BaseUdpConnection.this.mSendHandler.sendEmptyMessage(0);
                }
                BaseUdpConnection.this.lastMsgTime = System.currentTimeMillis();
                BaseUdpConnection.this.notifyStartConnect();
                BaseUdpConnection.this.mConnectionStatus.set(2);
                AutelLog.debug_i("BaseUdpConnection", "建立UDP通信连接 数据接收线程开启 ");
                MsgParser msgParser = new MsgParser();
                byte[] bArr = null;
                short s = -1;
                short s2 = -1;
                loop0:
                while (true) {
                    int i = 0;
                    while (BaseUdpConnection.this.mConnectionStatus.get() != 0) {
                        try {
                            int access$700 = BaseUdpConnection.this.readDataBlock(msgParser.getBuffer());
                            msgParser.setLength(access$700);
                            if (access$700 > 0) {
                                BaseUdpConnection.this.lastMsgTime = System.currentTimeMillis();
                                MsgHead parseHead = msgParser.parseHead();
                                if (!msgParser.checkPacket(parseHead)) {
                                    AutelLog.debug_i("BaseUdpConnection", "UDP通信连接断开 数据接收线程关闭 ");
                                    return;
                                } else if (parseHead.msg_type == 350) {
                                    if (bArr == null) {
                                        bArr = new byte[1048576];
                                    }
                                    if (128 == (parseHead.flag & 128)) {
                                        s = parseHead.sequence;
                                        s2 = parseHead.package_id;
                                        i = 0;
                                    }
                                    if (s == parseHead.sequence) {
                                        short s3 = (short) (s2 + 1);
                                        if (s2 == parseHead.package_id) {
                                            byte[] arraySplit = BytesUtils.arraySplit(msgParser.getBuffer(), UdpConfig.HEAD_LENGTH, parseHead.length);
                                            System.arraycopy(arraySplit, 0, bArr, i, arraySplit.length);
                                            i += arraySplit.length;
                                            if (64 == (parseHead.flag & 64)) {
                                                byte[] bArr2 = new byte[i];
                                                System.arraycopy(bArr, 0, bArr2, 0, i);
                                                ((UdpConnectionImpl) BaseUdpConnection.this).parseData(msgParser.disPatch(parseHead, bArr2));
                                                s = (short) (s + 1);
                                            }
                                            s2 = s3;
                                        }
                                    }
                                    s = -1;
                                    s2 = 0;
                                } else {
                                    try {
                                        ((UdpConnectionImpl) BaseUdpConnection.this).parseData(msgParser.parsePacket(parseHead));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        Log.d("BaseUdpConnection", "Exception--->> " + e.getMessage());
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            AutelLog.debug_i("BaseUdpConnection", "udp readDataBlock Exception " + e2.getMessage());
                            BaseUdpConnection.this.notifyComError(e2.getMessage());
                            AutelLog.debug_i("BaseUdpConnection", "UDP通信连接断开 数据接收线程关闭 ");
                            return;
                        }
                    }
                    break loop0;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                AutelLog.debug_i("BaseUdpConnection", "openConnection exception ... " + e3.getMessage());
                AutelLog.debug_i(AutelLog.TMP_CONNECT_ATG, "udp openConnection Exception " + e3.getMessage());
                BaseUdpConnection.this.mHandler.sendEmptyMessageDelayed(2003, 2000);
            } catch (Throwable th) {
                AutelLog.debug_i("BaseUdpConnection", "UDP通信连接断开 数据接收线程关闭 ");
                throw th;
            }
            AutelLog.debug_i("BaseUdpConnection", "UDP通信连接断开 数据接收线程关闭 ");
        }
    };
    private final ConcurrentHashMap<String, IConnectionListener> mConnectionListeners = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final AtomicInteger mConnectionStatus = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<BaseMsgPacket> mPacketsToSend = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public Handler mSendHandler = null;
    /* access modifiers changed from: private */
    public final Runnable mSendingTask = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0159, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x015a, code lost:
            r1.printStackTrace();
            com.autel.util.log.AutelLog.debug_i("BaseUdpConnection", "send packet Exception " + r1.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0177, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0178, code lost:
            r12 = r3;
            r3 = null;
            r1 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0186, code lost:
            com.autel.AutelNet2.core.connection.BaseUdpConnection.access$800(r13.this$0, r1.getMessage());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0159 A[ExcHandler: Exception (r1v13 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:4:0x0025] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0186  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r13 = this;
                int r0 = android.os.Process.myTid()
                r1 = -16
                android.os.Process.setThreadPriority(r0, r1)
                com.autel.AutelNet2.core.connection.BaseUdpConnection r0 = com.autel.AutelNet2.core.connection.BaseUdpConnection.this
                r1 = 1
                boolean unused = r0.sendingTaskWorking = r1
                java.lang.String r0 = "BaseUdpConnection"
                java.lang.String r1 = "mSendingTask 数据发送线程开启 "
                com.autel.util.log.AutelLog.debug_i(r0, r1)
            L_0x0016:
                com.autel.AutelNet2.core.connection.BaseUdpConnection r1 = com.autel.AutelNet2.core.connection.BaseUdpConnection.this
                java.util.concurrent.atomic.AtomicInteger r1 = r1.mConnectionStatus
                int r1 = r1.get()
                if (r1 == 0) goto L_0x01a9
                r1 = 0
                r2 = 773(0x305, float:1.083E-42)
                com.autel.AutelNet2.core.connection.BaseUdpConnection r3 = com.autel.AutelNet2.core.connection.BaseUdpConnection.this     // Catch:{ IOException -> 0x0177, Exception -> 0x0159 }
                java.util.concurrent.LinkedBlockingQueue r3 = r3.mPacketsToSend     // Catch:{ IOException -> 0x0177, Exception -> 0x0159 }
                java.lang.Object r3 = r3.take()     // Catch:{ IOException -> 0x0177, Exception -> 0x0159 }
                com.autel.AutelNet2.core.message.BaseMsgPacket r3 = (com.autel.AutelNet2.core.message.BaseMsgPacket) r3     // Catch:{ IOException -> 0x0177, Exception -> 0x0159 }
                byte[] r1 = r3.encodePacket()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.AutelNet2.core.message.MsgHead r4 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r4 = r4.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r5 = " body-> "
                java.lang.String r6 = "tracking send -> "
                java.lang.String r7 = "send packet type->"
                java.lang.String r8 = "Tracking_Test"
                r9 = 2304(0x900, float:3.229E-42)
                r10 = 20
                if (r4 == r10) goto L_0x0094
                com.autel.AutelNet2.core.PacketDisPatcher r4 = com.autel.AutelNet2.core.PacketDisPatcher.getInstance()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                boolean r4 = r4.isDebug()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                if (r4 == 0) goto L_0x0094
                com.autel.AutelNet2.core.message.MsgHead r4 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r4 = r4.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                if (r4 != r9) goto L_0x0072
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.<init>()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.append(r6)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r11 = r3.getBodyString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.append(r11)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.util.log.AutelLog.debug_i(r8, r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                goto L_0x0094
            L_0x0072:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.<init>()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.append(r7)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.AutelNet2.core.message.MsgHead r11 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r11 = r11.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.append(r11)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.append(r5)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r11 = r3.getBodyString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.append(r11)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.util.log.AutelLog.debug_i(r0, r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
            L_0x0094:
                com.autel.AutelNet2.core.message.MsgHead r4 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r4 = r4.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r11 = " "
                if (r4 != r2) goto L_0x00cc
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.<init>()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r4 = "send sendInputStream type->"
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.AutelNet2.core.message.MsgHead r4 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r4 = r4.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r11)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r4 = r3.getBodyString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.util.log.AutelLog.m15082d(r0, r1)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.AutelNet2.core.connection.BaseUdpConnection r1 = com.autel.AutelNet2.core.connection.BaseUdpConnection.this     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.io.FileInputStream r4 = r3.loadFileInputStream()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.sendInputStream(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                goto L_0x00d1
            L_0x00cc:
                com.autel.AutelNet2.core.connection.BaseUdpConnection r4 = com.autel.AutelNet2.core.connection.BaseUdpConnection.this     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4.sendBuffer(r1)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
            L_0x00d1:
                com.autel.AutelNet2.core.message.MsgHead r1 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r1 = r1.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                if (r1 == r10) goto L_0x0016
                com.autel.AutelNet2.core.PacketDisPatcher r1 = com.autel.AutelNet2.core.PacketDisPatcher.getInstance()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                boolean r1 = r1.isDebug()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                if (r1 == 0) goto L_0x0127
                com.autel.AutelNet2.core.message.MsgHead r1 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r1 = r1.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                if (r1 != r9) goto L_0x0103
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.<init>()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r6)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r4 = r3.getBodyString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.util.log.AutelLog.debug_i(r8, r1)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                goto L_0x0016
            L_0x0103:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.<init>()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r7)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.AutelNet2.core.message.MsgHead r4 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r4 = r4.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r5)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r4 = r3.getBodyString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.util.log.AutelLog.debug_i(r0, r1)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                goto L_0x0016
            L_0x0127:
                com.autel.AutelNet2.core.message.MsgHead r1 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r1 = r1.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r4 = 350(0x15e, float:4.9E-43)
                if (r1 == r4) goto L_0x0016
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.<init>()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r4 = "send sendBuffer type->"
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.AutelNet2.core.message.MsgHead r4 = r3.getHead()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                short r4 = r4.msg_type     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r11)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r4 = r3.getBodyString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                r1.append(r4)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                com.autel.util.log.AutelLog.debug_i(r0, r1)     // Catch:{ IOException -> 0x0157, Exception -> 0x0159 }
                goto L_0x0016
            L_0x0157:
                r1 = move-exception
                goto L_0x017b
            L_0x0159:
                r1 = move-exception
                r1.printStackTrace()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "send packet Exception "
                r2.append(r3)
                java.lang.String r1 = r1.getMessage()
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                com.autel.util.log.AutelLog.debug_i(r0, r1)
                goto L_0x0016
            L_0x0177:
                r3 = move-exception
                r12 = r3
                r3 = r1
                r1 = r12
            L_0x017b:
                r1.printStackTrace()
                com.autel.AutelNet2.core.message.MsgHead r3 = r3.getHead()
                short r3 = r3.msg_type
                if (r3 != r2) goto L_0x018f
                com.autel.AutelNet2.core.connection.BaseUdpConnection r2 = com.autel.AutelNet2.core.connection.BaseUdpConnection.this
                java.lang.String r3 = r1.getMessage()
                r2.notifyComError(r3)
            L_0x018f:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "send packet IOException failed:"
                r2.append(r3)
                java.lang.String r1 = r1.getMessage()
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                com.autel.util.log.AutelLog.debug_i(r0, r1)
                goto L_0x0016
            L_0x01a9:
                java.lang.String r1 = "mSendingTask 数据发送线程关闭 "
                com.autel.util.log.AutelLog.debug_i(r0, r1)
                com.autel.AutelNet2.core.connection.BaseUdpConnection r0 = com.autel.AutelNet2.core.connection.BaseUdpConnection.this
                r1 = 0
                boolean unused = r0.sendingTaskWorking = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.AutelNet2.core.connection.BaseUdpConnection.C22572.run():void");
        }
    };
    private HandlerThread mSendingThread = null;
    private Thread mTaskThread;
    /* access modifiers changed from: private */
    public volatile boolean sendingTaskWorking = false;

    protected BaseUdpConnection() {
        try {
            openConnection(getUdpPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
        initHandler();
    }

    private void initHandler() {
        this.mHandlerThread = new HandlerThread("HeartBeat Thread");
        this.mSendingThread = new HandlerThread("SDK2.0 udp-Sending Thread");
        this.mHandlerThread.start();
        this.mSendingThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 2001:
                        BaseUdpConnection.this.doConnect();
                        return;
                    case BaseUdpConnection.REQUEST_DISCONNECT /*2002*/:
                        BaseUdpConnection.this.doDisconnect();
                        return;
                    case 2003:
                        if (!BaseUdpConnection.this.isDisConnect) {
                            BaseUdpConnection.this.doDisconnect();
                            BaseUdpConnection.this.doConnect();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.mSendHandler = new Handler(this.mSendingThread.getLooper()) {
            public void handleMessage(Message message) {
                BaseUdpConnection.this.mSendingTask.run();
            }
        };
    }

    /* access modifiers changed from: private */
    public void doConnect() {
        Log.e("BaseUdpConnection", "doConnect 1:");
        if (this.mConnectionStatus.compareAndSet(0, 1)) {
            this.isCheckOutTimeThreadRunning = true;
            Log.e("BaseUdpConnection", "doConnect 2:");
            Thread thread = new Thread(this.mConnectingTask, "SDK 2.0 udp-receive Thread");
            this.mTaskThread = thread;
            thread.start();
        }
    }

    /* access modifiers changed from: private */
    public void doDisconnect() {
        Log.e("BaseUdpConnection", "doDisconnect ---------");
        if (this.mConnectionStatus.get() != 0 && this.mTaskThread != null) {
            this.isCheckOutTimeThreadRunning = false;
            this.mConnectionStatus.set(0);
            Thread thread = this.mTaskThread;
            if (thread != null && thread.isAlive() && !this.mTaskThread.isInterrupted()) {
                this.mTaskThread.interrupt();
            }
            this.lastMsgTime = 0;
            PacketDisPatcher.getInstance().clearTimer();
        }
    }

    public void connect() {
        this.isDisConnect = false;
        Log.e("BaseUdpConnection", "connect :---------------");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(2001);
        }
    }

    public void disconnect() {
        this.isDisConnect = true;
        Log.e("BaseUdpConnection", "disconnect :---------------");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler.sendEmptyMessage(REQUEST_DISCONNECT);
        }
    }

    public int getConnectionStatus() {
        return this.mConnectionStatus.get();
    }

    public boolean sendPacket(BaseMsgPacket baseMsgPacket) {
        return this.mPacketsToSend.offer(baseMsgPacket);
    }

    public void registerConnectListener(String str, IConnectionListener iConnectionListener) {
        if (!this.mConnectionListeners.containsKey(str) && iConnectionListener != null) {
            this.mConnectionListeners.put(str, iConnectionListener);
            if (getConnectionStatus() == 2) {
                iConnectionListener.onConnected();
            }
        }
    }

    public void unRegisterConnectListener(String str) {
        this.mConnectionListeners.remove(str);
    }

    /* access modifiers changed from: private */
    public void notifyComError(String str) {
        PacketDisPatcher.getInstance().setAircraftConnect(false);
        Log.e("BaseUdpConnection", "notifyComError " + this.mConnectionListeners.size());
        if (!this.mConnectionListeners.isEmpty()) {
            for (IConnectionListener onConnectError : this.mConnectionListeners.values()) {
                onConnectError.onConnectError(str);
            }
        }
    }

    private void notifyConnected() {
        if (this.mConnectionStatus.get() != 2) {
            if (this.mConnectionStatus.get() == 1) {
                for (IConnectionListener onConnected : this.mConnectionListeners.values()) {
                    onConnected.onConnected();
                }
            }
            this.mConnectionStatus.set(2);
        }
    }

    private void notifyDisconnect() {
        Log.d("BaseUdpConnection", "notifyDisconnect " + this.mConnectionListeners.size());
        if (!this.mConnectionListeners.isEmpty()) {
            for (IConnectionListener onDisconnected : this.mConnectionListeners.values()) {
                onDisconnected.onDisconnected();
            }
        }
    }

    /* access modifiers changed from: private */
    public void notifyStartConnect() {
        if (!this.mConnectionListeners.isEmpty()) {
            for (IConnectionListener startConnect : this.mConnectionListeners.values()) {
                startConnect.startConnect();
            }
        }
    }
}
