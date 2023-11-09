package com.atakmap.android.uastool;

import android.content.Context;
import android.content.Intent;
import com.atakmap.android.uastool.utils.CaptureToStorage;
import com.atakmap.android.util.x;
import com.atakmap.coremap.log.Log;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class AeroReflector implements Runnable {
    private static final int DEFAULT_BUFFER_LENGTH = 65536;
    private static final int ICON_GREEN = x.a.n.a();
    private static final int ICON_RED = x.a.o.a();
    private static final int ICON_YELLOW = x.a.p.a();
    private static final long UPDATE_THRESHOLD = 250000;
    private final int NOTIFICATION_ID;
    private final String TAG = "AeroReflector";
    private boolean cancelled = false;
    private final CaptureToStorage captureToStorage;
    private final String dstIP;
    private final String dstNetwork;
    private final int dstPort;
    private MulticastSocket dstSocket;
    private final Context pluginContext;
    private long rxBytes;
    private final String srcIP;
    private final String srcNetwork;
    private final int srcPort;
    private MulticastSocket srcSocket;
    private long txBytes;

    public AeroReflector(Context context, int i, String str, int i2, String str2, String str3, int i3, String str4, boolean z) {
        this.pluginContext = context;
        this.NOTIFICATION_ID = i;
        this.srcIP = str;
        this.srcPort = i2;
        this.srcNetwork = str2;
        this.dstIP = str3;
        this.dstPort = i3;
        this.dstNetwork = str4;
        this.rxBytes = 0;
        this.txBytes = 0;
        CaptureToStorage captureToStorage2 = new CaptureToStorage("video");
        this.captureToStorage = captureToStorage2;
        captureToStorage2.setCaptureToStorage(z);
    }

    private void sendNotification(String str, String str2, int i) {
        x.a().a(this.NOTIFICATION_ID, i, str, str2, (Intent) null, false);
    }

    public void cancel() {
        this.cancelled = true;
        if (this.srcSocket != null) {
            sendNotification("AeroReflector", "Shutting down source socket", ICON_YELLOW);
            try {
                this.srcSocket.close();
            } catch (Exception e) {
                sendNotification("AeroReflector", "" + e, ICON_RED);
            }
        }
        if (this.dstSocket != null) {
            sendNotification("AeroReflector", "Shutting down destination socket", ICON_YELLOW);
            try {
                this.dstSocket.close();
            } catch (Exception e2) {
                sendNotification("AeroReflector", "" + e2, ICON_RED);
            }
        }
        this.rxBytes = 0;
        this.txBytes = 0;
    }

    public void run() {
        sendNotification("AeroReflector", "Start reflecting", ICON_GREEN);
        while (!this.cancelled) {
            try {
                copy();
            } catch (IOException e) {
                sendNotification("AeroReflector", "I/O exception", ICON_YELLOW);
                Log.e("AeroReflector", "I/O exception", e);
                if (!this.cancelled) {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e2) {
                        sendNotification("AeroReflector", "Reflection exception", ICON_YELLOW);
                        Log.e("AeroReflector", "Reflection exception", e2);
                    }
                }
            }
        }
        this.srcSocket = null;
        this.dstSocket = null;
        sendNotification("AeroReflector", "Finished reflecting", ICON_YELLOW);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: com.atakmap.comms.j$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: com.atakmap.comms.j$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void copy() {
        /*
            r15 = this;
            java.net.DatagramPacket r0 = new java.net.DatagramPacket
            r1 = 65536(0x10000, float:9.18355E-41)
            byte[] r2 = new byte[r1]
            r0.<init>(r2, r1)
            java.net.DatagramPacket r2 = new java.net.DatagramPacket
            byte[] r3 = new byte[r1]
            r2.<init>(r3, r1)
            java.lang.String r1 = r15.srcIP
            java.net.InetAddress r1 = java.net.InetAddress.getByName(r1)
            java.lang.String r3 = r15.dstIP
            java.net.InetAddress r3 = java.net.InetAddress.getByName(r3)
            java.io.File r4 = new java.io.File
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r6 = "atak"
            r4.<init>(r5, r6)
            com.atakmap.comms.j.a(r4)
            r4 = 1
            com.atakmap.comms.j.a(r4)
            android.content.Context r4 = r15.pluginContext
            com.atakmap.comms.j.a(r4)
            java.util.List r4 = com.atakmap.comms.j.a()
            java.util.Iterator r5 = r4.iterator()
            r6 = 0
            r7 = r6
        L_0x003d:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0060
            java.lang.Object r8 = r5.next()
            com.atakmap.comms.j$a r8 = (com.atakmap.comms.j.a) r8
            java.lang.String r9 = r8.b
            java.lang.String r10 = r15.srcNetwork
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0054
            r6 = r8
        L_0x0054:
            java.lang.String r9 = r8.b
            java.lang.String r10 = r15.dstNetwork
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x003d
            r7 = r8
            goto L_0x003d
        L_0x0060:
            boolean r5 = r4.isEmpty()
            r8 = 0
            if (r5 != 0) goto L_0x0070
            if (r6 != 0) goto L_0x0070
            java.lang.Object r5 = r4.get(r8)
            r6 = r5
            com.atakmap.comms.j$a r6 = (com.atakmap.comms.j.a) r6
        L_0x0070:
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x007f
            if (r7 != 0) goto L_0x007f
            java.lang.Object r4 = r4.get(r8)
            r7 = r4
            com.atakmap.comms.j$a r7 = (com.atakmap.comms.j.a) r7
        L_0x007f:
            java.net.MulticastSocket r4 = new java.net.MulticastSocket
            int r5 = r15.srcPort
            r4.<init>(r5)
            r15.srcSocket = r4
            java.net.MulticastSocket r4 = new java.net.MulticastSocket
            int r5 = r15.dstPort
            r4.<init>(r5)
            r15.dstSocket = r4
            boolean r1 = r1.isMulticastAddress()
            java.lang.String r4 = "AeroReflector"
            if (r1 == 0) goto L_0x00cd
            if (r6 != 0) goto L_0x00a6
            int r0 = ICON_RED
            java.lang.String r1 = "Source device cannot be found"
            r15.sendNotification(r4, r1, r0)
            r15.cancel()
            return
        L_0x00a6:
            java.net.NetworkInterface r1 = r6.a()
            if (r1 == 0) goto L_0x00c2
            boolean r5 = r1.isUp()
            if (r5 != 0) goto L_0x00b3
            goto L_0x00c2
        L_0x00b3:
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress
            java.lang.String r6 = r15.srcIP
            int r9 = r15.srcPort
            r5.<init>(r6, r9)
            java.net.MulticastSocket r6 = r15.srcSocket
            r6.joinGroup(r5, r1)
            goto L_0x00cd
        L_0x00c2:
            int r0 = ICON_RED
            java.lang.String r1 = "Source is down"
            r15.sendNotification(r4, r1, r0)
            r15.cancel()
            return
        L_0x00cd:
            boolean r1 = r3.isMulticastAddress()
            if (r1 == 0) goto L_0x0105
            if (r7 != 0) goto L_0x00e0
            int r0 = ICON_RED
            java.lang.String r1 = "Destination device cannot be found"
            r15.sendNotification(r4, r1, r0)
            r15.cancel()
            return
        L_0x00e0:
            java.net.NetworkInterface r1 = r7.a()
            if (r1 == 0) goto L_0x00fa
            boolean r5 = r1.isUp()
            if (r5 != 0) goto L_0x00ed
            goto L_0x00fa
        L_0x00ed:
            java.net.MulticastSocket r5 = r15.dstSocket
            r5.setNetworkInterface(r1)
            java.net.MulticastSocket r1 = r15.dstSocket
            r5 = 12
            r1.setTimeToLive(r5)
            goto L_0x0105
        L_0x00fa:
            int r0 = ICON_RED
            java.lang.String r1 = "Destination is down"
            r15.sendNotification(r4, r1, r0)
            r15.cancel()
            return
        L_0x0105:
            r5 = 250000(0x3d090, double:1.235164E-318)
        L_0x0108:
            r9 = r5
        L_0x0109:
            boolean r1 = r15.cancelled
            if (r1 != 0) goto L_0x01a1
            java.net.MulticastSocket r1 = r15.srcSocket
            r1.receive(r0)
            com.atakmap.android.uastool.utils.CaptureToStorage r1 = r15.captureToStorage
            r1.saveToFile((java.net.DatagramPacket) r0)
            r2.setAddress(r3)
            int r1 = r15.dstPort
            r2.setPort(r1)
            byte[] r1 = r0.getData()
            int r7 = r0.getLength()
            r2.setData(r1, r8, r7)
            long r11 = r15.txBytes
            int r1 = r0.getLength()
            long r13 = (long) r1
            long r11 = r11 + r13
            r15.txBytes = r11
            java.net.MulticastSocket r1 = r15.dstSocket
            r1.send(r2)
            long r11 = r15.rxBytes
            int r1 = r0.getLength()
            long r13 = (long) r1
            long r11 = r11 + r13
            r15.rxBytes = r11
            int r1 = r0.getLength()
            long r11 = (long) r1
            long r9 = r9 - r11
            r11 = 0
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 > 0) goto L_0x0109
            long r9 = r15.rxBytes
            long r11 = r15.txBytes
            java.lang.String r1 = "Received "
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x017a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            long r9 = r15.rxBytes
            r7.append(r9)
            java.lang.String r1 = " != Sent "
            r7.append(r1)
            long r9 = r15.txBytes
            r7.append(r9)
            java.lang.String r1 = r7.toString()
            int r7 = ICON_YELLOW
            r15.sendNotification(r4, r1, r7)
            goto L_0x019a
        L_0x017a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r1)
            long r9 = r15.rxBytes
            r7.append(r9)
            java.lang.String r1 = " / Sent "
            r7.append(r1)
            long r9 = r15.txBytes
            r7.append(r9)
            java.lang.String r1 = r7.toString()
            int r7 = ICON_GREEN
            r15.sendNotification(r4, r1, r7)
        L_0x019a:
            java.lang.String r1 = "Sent update"
            com.atakmap.coremap.log.Log.d(r4, r1)
            goto L_0x0108
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.AeroReflector.copy():void");
    }

    private DatagramPacket agregate(DatagramPacket datagramPacket, DatagramPacket datagramPacket2, DatagramPacket datagramPacket3, DatagramPacket datagramPacket4, DatagramPacket datagramPacket5) {
        byte[] data = datagramPacket2.getData();
        int length = datagramPacket2.getLength();
        byte[] data2 = datagramPacket3.getData();
        int length2 = datagramPacket3.getLength();
        byte[] data3 = datagramPacket4.getData();
        int length3 = datagramPacket4.getLength();
        byte[] data4 = datagramPacket5.getData();
        int length4 = datagramPacket5.getLength();
        int i = length + length2;
        int i2 = i + length3;
        int i3 = i2 + length4;
        byte[] bArr = new byte[i3];
        System.arraycopy(data, 0, bArr, 0, length);
        System.arraycopy(data2, 0, bArr, length, length2);
        System.arraycopy(data3, 0, bArr, i, length3);
        System.arraycopy(data4, 0, bArr, i2, length4);
        datagramPacket.setData(bArr);
        this.txBytes += (long) i3;
        return datagramPacket;
    }

    public void setCaptureToStorage(boolean z) {
        this.captureToStorage.setCaptureToStorage(z);
    }
}
