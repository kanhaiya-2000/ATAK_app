package com.atakmap.android.uastool.p000av;

import com.atakmap.coremap.log.Log;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.atakmap.android.uastool.av.UplinkComm */
public class UplinkComm implements Runnable {
    private static final String TAG = "UplinkComm";
    private final ConcurrentLinkedQueue<GCSUplinkMessage> _messages = new ConcurrentLinkedQueue<>();
    private boolean cancelled = false;
    private final String destAddr = "192.168.0.4";
    private final int destPort = 5000;

    /* renamed from: ds */
    private DatagramSocket f8388ds;

    public UplinkComm() {
        try {
            this.f8388ds = new DatagramSocket();
        } catch (SocketException unused) {
        }
    }

    public void cancel() {
        this.cancelled = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        java.lang.Thread.sleep(125);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            boolean r0 = r2.cancelled     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            return
        L_0x0007:
            java.util.concurrent.ConcurrentLinkedQueue<com.atakmap.android.uastool.av.GCSUplinkMessage> r0 = r2._messages     // Catch:{ all -> 0x001b }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x001b }
            com.atakmap.android.uastool.av.GCSUplinkMessage r0 = (com.atakmap.android.uastool.p000av.GCSUplinkMessage) r0     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0014
            r2.send(r0)     // Catch:{ all -> 0x001b }
        L_0x0014:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            r0 = 125(0x7d, double:6.2E-322)
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x0000 }
            goto L_0x0000
        L_0x001b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.p000av.UplinkComm.run():void");
    }

    private void send(GCSUplinkMessage gCSUplinkMessage) {
        try {
            byte[] renderNativeFrame = gCSUplinkMessage.renderNativeFrame();
            this.f8388ds.send(new DatagramPacket(renderNativeFrame, renderNativeFrame.length, InetAddress.getByName("192.168.0.4"), 5000));
        } catch (Exception e) {
            Log.e(TAG, "Error during command request", e);
        }
    }

    public void AddToSend(GCSUplinkMessage gCSUplinkMessage) {
        this._messages.add(gCSUplinkMessage);
    }

    public void AddToSend(GCSUplinkMessageSet gCSUplinkMessageSet) {
        this._messages.addAll(gCSUplinkMessageSet.getSet());
    }
}
