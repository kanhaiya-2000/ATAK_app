package com.autel.sdk10.AutelNet.AutelFirmWareInfo.socket;

import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.autel.common.error.AutelError;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine.base.Version;
import com.autel.sdk10.AutelNet.AutelFirmWareInfo.interfaces.IAutelFirmVersionCallback;
import com.autel.sdk10.AutelNet.socket.TcpSocketBase;
import com.autel.util.log.AutelLog;
import com.autel.util.log.AutelLogTags;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirmVersionSocket extends TcpSocketBase {
    private IAutelFirmVersionCallback iAutelFirmVersionCallback;

    /* renamed from: ip */
    private String f8508ip;
    /* access modifiers changed from: private */
    public WeakReference<Socket> mSocket;
    /* access modifiers changed from: private */
    public BufferedWriter mWriter;
    private String msgstr;
    private int port;
    private ExecutorService socketThreadPool = Executors.newSingleThreadExecutor();

    public FirmVersionSocket(Version version, IAutelFirmVersionCallback iAutelFirmVersionCallback2) {
        this.f8508ip = version.getSocketIp();
        this.port = version.getSocketPort();
        this.msgstr = getRequestString(version.getMethodName(), version.getRequestId());
        this.iAutelFirmVersionCallback = iAutelFirmVersionCallback2;
        connectTcp();
    }

    /* access modifiers changed from: protected */
    public String getStrIP() {
        return this.f8508ip;
    }

    /* access modifiers changed from: protected */
    public int getPort() {
        return this.port;
    }

    /* access modifiers changed from: protected */
    public Socket getSocket() {
        WeakReference<Socket> weakReference = this.mSocket;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (Socket) this.mSocket.get();
    }

    /* access modifiers changed from: protected */
    public void connectTcp() {
        this.socketThreadPool.execute(new ConnectionRunnable());
    }

    /* access modifiers changed from: protected */
    public void setRecData(Object obj) {
        IAutelFirmVersionCallback iAutelFirmVersionCallback2 = this.iAutelFirmVersionCallback;
        if (iAutelFirmVersionCallback2 != null) {
            iAutelFirmVersionCallback2.onReceiveVersion(obj);
        }
        this.iAutelFirmVersionCallback = null;
    }

    /* access modifiers changed from: protected */
    public void disConnectTcp() {
        try {
            WeakReference<Socket> weakReference = this.mSocket;
            if (weakReference != null) {
                Socket socket = (Socket) weakReference.get();
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
                this.mSocket.clear();
            }
            this.mSocket = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void reconnect() {
        IAutelFirmVersionCallback iAutelFirmVersionCallback2 = this.iAutelFirmVersionCallback;
        if (iAutelFirmVersionCallback2 != null) {
            iAutelFirmVersionCallback2.onFailure(AutelError.COMMON_DISCONNECTED);
        }
    }

    /* access modifiers changed from: protected */
    public boolean sendMessage(Object obj) {
        int length = this.msgstr.getBytes().length;
        if (getSocket() == null) {
            return false;
        }
        Socket socket = (Socket) this.mSocket.get();
        if (socket.isClosed() || socket.isOutputShutdown() || this.mWriter == null) {
            return false;
        }
        byte[] bArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr[i] = (byte) (length >> (24 - (i * 8)));
            this.mWriter.write(bArr[i]);
        }
        this.mWriter.write(this.msgstr);
        this.mWriter.flush();
        AutelLog.m15084e(AutelLogTags.TAG, "send msg:" + obj);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getRequestString(java.lang.String r4, int r5) {
        /*
            r3 = this;
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0013 }
            r1.<init>()     // Catch:{ Exception -> 0x0013 }
            java.lang.String r2 = "method"
            r1.put(r2, r4)     // Catch:{ Exception -> 0x0011 }
            java.lang.String r4 = "id"
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0011 }
            goto L_0x0018
        L_0x0011:
            r4 = move-exception
            goto L_0x0015
        L_0x0013:
            r4 = move-exception
            r1 = r0
        L_0x0015:
            r4.printStackTrace()
        L_0x0018:
            if (r1 == 0) goto L_0x001e
            java.lang.String r0 = r1.toString()
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autel.sdk10.AutelNet.AutelFirmWareInfo.socket.FirmVersionSocket.getRequestString(java.lang.String, int):java.lang.String");
    }

    private class ConnectionRunnable implements Runnable {
        private ConnectionRunnable() {
        }

        public void run() {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(FirmVersionSocket.this.getStrIP(), FirmVersionSocket.this.getPort()), MAV_CMD.MAV_CMD_DO_VTOL_TRANSITION);
                socket.setKeepAlive(true);
                socket.setSoTimeout(MAV_CMD.MAV_CMD_DO_VTOL_TRANSITION);
                WeakReference unused = FirmVersionSocket.this.mSocket = new WeakReference(socket);
                BufferedWriter unused2 = FirmVersionSocket.this.mWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                FirmVersionSocket.this.sendMessage((Object) null);
                FirmVersionSocket.this.readData(socket);
            } catch (Exception e) {
                e.printStackTrace();
                FirmVersionSocket.this.handler.sendEmptyMessage(1);
            } catch (Throwable th) {
                FirmVersionSocket.this.disConnectTcp();
                throw th;
            }
            FirmVersionSocket.this.disConnectTcp();
        }
    }

    /* access modifiers changed from: private */
    public void readData(Socket socket) {
        if (socket != null) {
            InputStream inputStream = socket.getInputStream();
            byte[] bArr = new byte[1024];
            if (inputStream != null) {
                inputStream.read(bArr);
            }
            String str = new String(bArr);
            setRecData(str.substring(str.indexOf("{")));
        }
    }
}
