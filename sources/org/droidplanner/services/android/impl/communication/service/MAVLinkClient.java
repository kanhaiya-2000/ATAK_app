package org.droidplanner.services.android.impl.communication.service;

import android.content.Context;
import android.os.Bundle;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.MAVLinkPacket;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.Objects;
import org.droidplanner.services.android.impl.communication.connection.AndroidMavLinkConnection;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnectionListener;
import org.droidplanner.services.android.impl.core.drone.manager.DroneCommandTracker;

public class MAVLinkClient implements DataLink.DataLinkProvider<MAVLinkMessage> {
    private static final int DEFAULT_COMP_ID = 190;
    private static final int DEFAULT_SYS_ID = 255;
    private static final int MAX_PACKET_SEQUENCE = 255;
    private DroneCommandTracker commandTracker;
    private final ConnectionParameter connParams;
    private final Context context;
    /* access modifiers changed from: private */
    public final DataLink.DataLinkListener<MAVLinkPacket> listener;
    private final MavLinkConnectionListener mConnectionListener = new MavLinkConnectionListener() {
        public void onReceivePacket(MAVLinkPacket mAVLinkPacket) {
            MAVLinkClient.this.listener.notifyReceivedData(mAVLinkPacket);
        }

        public void onConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
            MAVLinkClient.this.listener.onConnectionStatus(linkConnectionStatus);
            String statusCode = linkConnectionStatus.getStatusCode();
            statusCode.hashCode();
            if (statusCode.equals(LinkConnectionStatus.DISCONNECTED)) {
                MAVLinkClient.this.closeConnection();
            }
        }
    };
    private AndroidMavLinkConnection mavlinkConn;
    private int packetSeqNumber = 0;

    public MAVLinkClient(Context context2, DataLink.DataLinkListener<MAVLinkPacket> dataLinkListener, ConnectionParameter connectionParameter, DroneCommandTracker droneCommandTracker) {
        this.context = context2;
        this.listener = dataLinkListener;
        Objects.requireNonNull(connectionParameter, "Invalid connection parameter argument.");
        this.connParams = connectionParameter;
        this.commandTracker = droneCommandTracker;
    }

    private int getConnectionStatus() {
        AndroidMavLinkConnection androidMavLinkConnection = this.mavlinkConn;
        if (androidMavLinkConnection == null) {
            return 0;
        }
        return androidMavLinkConnection.getConnectionStatus();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0122, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0124, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void openConnection() {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.isConnected()     // Catch:{ all -> 0x0125 }
            if (r0 != 0) goto L_0x0123
            boolean r0 = r13.isConnecting()     // Catch:{ all -> 0x0125 }
            if (r0 == 0) goto L_0x000f
            goto L_0x0123
        L_0x000f:
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x0125 }
            com.o3dr.services.android.lib.drone.connection.ConnectionParameter r1 = r13.connParams     // Catch:{ all -> 0x0125 }
            int r1 = r1.getConnectionType()     // Catch:{ all -> 0x0125 }
            com.o3dr.services.android.lib.drone.connection.ConnectionParameter r2 = r13.connParams     // Catch:{ all -> 0x0125 }
            android.os.Bundle r2 = r2.getParamsBundle()     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.communication.connection.AndroidMavLinkConnection r3 = r13.mavlinkConn     // Catch:{ all -> 0x0125 }
            r4 = 0
            r5 = 1
            r6 = 0
            if (r3 != 0) goto L_0x00d6
            if (r1 == 0) goto L_0x00bd
            if (r1 == r5) goto L_0x009d
            r3 = 2
            if (r1 == r3) goto L_0x0077
            r3 = 3
            if (r1 == r3) goto L_0x0060
            r3 = 101(0x65, float:1.42E-43)
            if (r1 == r3) goto L_0x0043
            java.lang.String r0 = "Unrecognized connection type: %s"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0125 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0125 }
            r2[r6] = r1     // Catch:{ all -> 0x0125 }
            atakplugin.UASTool.cqb.m12014e(r0, r2)     // Catch:{ all -> 0x0125 }
            monitor-exit(r13)
            return
        L_0x0043:
            java.lang.String r3 = "Creating solo connection"
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0125 }
            atakplugin.UASTool.cqb.m12010c(r3, r7)     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "extra_solo_link_id"
            java.lang.String r3 = r2.getString(r3, r4)     // Catch:{ all -> 0x0125 }
            java.lang.String r7 = "extra_solo_link_password"
            java.lang.String r7 = r2.getString(r7, r4)     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.communication.connection.SoloConnection r8 = new org.droidplanner.services.android.impl.communication.connection.SoloConnection     // Catch:{ all -> 0x0125 }
            android.content.Context r9 = r13.context     // Catch:{ all -> 0x0125 }
            r8.<init>(r9, r3, r7)     // Catch:{ all -> 0x0125 }
            r13.mavlinkConn = r8     // Catch:{ all -> 0x0125 }
            goto L_0x00d6
        L_0x0060:
            java.lang.String r3 = "extra_bluetooth_address"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.communication.connection.BluetoothConnection r7 = new org.droidplanner.services.android.impl.communication.connection.BluetoothConnection     // Catch:{ all -> 0x0125 }
            android.content.Context r8 = r13.context     // Catch:{ all -> 0x0125 }
            r7.<init>(r8, r3)     // Catch:{ all -> 0x0125 }
            r13.mavlinkConn = r7     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "Connecting over bluetooth."
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0125 }
            atakplugin.UASTool.cqb.m12010c(r3, r7)     // Catch:{ all -> 0x0125 }
            goto L_0x00d6
        L_0x0077:
            java.lang.String r3 = "extra_tcp_server_ip"
            java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0125 }
            java.lang.String r7 = "extra_tcp_server_port"
            r8 = 5763(0x1683, float:8.076E-42)
            int r7 = r2.getInt(r7, r8)     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.communication.connection.AndroidTcpConnection r8 = new org.droidplanner.services.android.impl.communication.connection.AndroidTcpConnection     // Catch:{ all -> 0x0125 }
            android.content.Context r9 = r13.context     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r10 = new org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler     // Catch:{ all -> 0x0125 }
            android.content.Context r11 = r13.context     // Catch:{ all -> 0x0125 }
            r10.<init>(r11)     // Catch:{ all -> 0x0125 }
            r8.<init>(r9, r3, r7, r10)     // Catch:{ all -> 0x0125 }
            r13.mavlinkConn = r8     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "Connecting over tcp."
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0125 }
            atakplugin.UASTool.cqb.m12010c(r3, r7)     // Catch:{ all -> 0x0125 }
            goto L_0x00d6
        L_0x009d:
            java.lang.String r3 = "extra_udp_server_port"
            r7 = 14550(0x38d6, float:2.0389E-41)
            int r3 = r2.getInt(r3, r7)     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.communication.connection.AndroidUdpConnection r7 = new org.droidplanner.services.android.impl.communication.connection.AndroidUdpConnection     // Catch:{ all -> 0x0125 }
            android.content.Context r8 = r13.context     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r9 = new org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler     // Catch:{ all -> 0x0125 }
            android.content.Context r10 = r13.context     // Catch:{ all -> 0x0125 }
            r9.<init>(r10)     // Catch:{ all -> 0x0125 }
            r7.<init>(r8, r3, r9)     // Catch:{ all -> 0x0125 }
            r13.mavlinkConn = r7     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "Connecting over udp."
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0125 }
            atakplugin.UASTool.cqb.m12010c(r3, r7)     // Catch:{ all -> 0x0125 }
            goto L_0x00d6
        L_0x00bd:
            java.lang.String r3 = "extra_usb_baud_rate"
            r7 = 57600(0xe100, float:8.0715E-41)
            int r3 = r2.getInt(r3, r7)     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.communication.connection.usb.UsbConnection r7 = new org.droidplanner.services.android.impl.communication.connection.usb.UsbConnection     // Catch:{ all -> 0x0125 }
            android.content.Context r8 = r13.context     // Catch:{ all -> 0x0125 }
            r7.<init>(r8, r3)     // Catch:{ all -> 0x0125 }
            r13.mavlinkConn = r7     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "Connecting over usb."
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x0125 }
            atakplugin.UASTool.cqb.m12010c(r3, r7)     // Catch:{ all -> 0x0125 }
        L_0x00d6:
            org.droidplanner.services.android.impl.communication.connection.AndroidMavLinkConnection r3 = r13.mavlinkConn     // Catch:{ all -> 0x0125 }
            org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnectionListener r7 = r13.mConnectionListener     // Catch:{ all -> 0x0125 }
            r3.addMavLinkConnectionListener(r0, r7)     // Catch:{ all -> 0x0125 }
            if (r1 != r5) goto L_0x0114
            java.lang.String r0 = "extra_udp_ping_receiver_ip"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x0125 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0125 }
            if (r1 != 0) goto L_0x0114
            java.net.InetAddress r8 = java.net.InetAddress.getByName(r0)     // Catch:{ UnknownHostException -> 0x010c }
            java.lang.String r0 = "extra_udp_ping_receiver_port"
            int r9 = r2.getInt(r0)     // Catch:{ UnknownHostException -> 0x010c }
            java.lang.String r0 = "extra_udp_ping_period"
            r10 = 10000(0x2710, double:4.9407E-320)
            long r10 = r2.getLong(r0, r10)     // Catch:{ UnknownHostException -> 0x010c }
            java.lang.String r0 = "extra_udp_ping_payload"
            byte[] r12 = r2.getByteArray(r0)     // Catch:{ UnknownHostException -> 0x010c }
            org.droidplanner.services.android.impl.communication.connection.AndroidMavLinkConnection r0 = r13.mavlinkConn     // Catch:{ UnknownHostException -> 0x010c }
            r7 = r0
            org.droidplanner.services.android.impl.communication.connection.AndroidUdpConnection r7 = (org.droidplanner.services.android.impl.communication.connection.AndroidUdpConnection) r7     // Catch:{ UnknownHostException -> 0x010c }
            r7.addPingTarget(r8, r9, r10, r12)     // Catch:{ UnknownHostException -> 0x010c }
            goto L_0x0114
        L_0x010c:
            r0 = move-exception
            java.lang.String r1 = "Unable to resolve UDP ping server ip address."
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0125 }
            atakplugin.UASTool.cqb.m12015e(r0, r1, r2)     // Catch:{ all -> 0x0125 }
        L_0x0114:
            org.droidplanner.services.android.impl.communication.connection.AndroidMavLinkConnection r0 = r13.mavlinkConn     // Catch:{ all -> 0x0125 }
            int r0 = r0.getConnectionStatus()     // Catch:{ all -> 0x0125 }
            if (r0 != 0) goto L_0x0121
            org.droidplanner.services.android.impl.communication.connection.AndroidMavLinkConnection r0 = r13.mavlinkConn     // Catch:{ all -> 0x0125 }
            r0.connect(r4)     // Catch:{ all -> 0x0125 }
        L_0x0121:
            monitor-exit(r13)
            return
        L_0x0123:
            monitor-exit(r13)
            return
        L_0x0125:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.communication.service.MAVLinkClient.openConnection():void");
    }

    public synchronized void closeConnection() {
        if (!isDisconnected()) {
            this.mavlinkConn.removeMavLinkConnectionListener(toString());
            if (this.mavlinkConn.getMavLinkConnectionListenersCount() == 0) {
                cqb.m12010c("Disconnecting...", new Object[0]);
                this.mavlinkConn.disconnect();
            }
            this.listener.onConnectionStatus(new LinkConnectionStatus(LinkConnectionStatus.DISCONNECTED, (Bundle) null));
        }
    }

    public Bundle getConnectionExtras() {
        AndroidMavLinkConnection androidMavLinkConnection = this.mavlinkConn;
        if (androidMavLinkConnection == null) {
            return null;
        }
        return androidMavLinkConnection.getConnectionExtras();
    }

    public synchronized void sendMessage(MAVLinkMessage mAVLinkMessage, ICommandListener iCommandListener) {
        sendMavMessage(mAVLinkMessage, 255, 190, iCommandListener);
    }

    /* access modifiers changed from: protected */
    public void sendMavMessage(MAVLinkMessage mAVLinkMessage, int i, int i2, ICommandListener iCommandListener) {
        if (!isDisconnected() && mAVLinkMessage != null) {
            MAVLinkPacket pack = mAVLinkMessage.pack();
            pack.sysid = i;
            pack.compid = i2;
            pack.seq = this.packetSeqNumber;
            this.mavlinkConn.sendMavPacket(pack);
            this.packetSeqNumber = (this.packetSeqNumber + 1) % 256;
            DroneCommandTracker droneCommandTracker = this.commandTracker;
            if (droneCommandTracker != null && iCommandListener != null) {
                droneCommandTracker.onCommandSubmitted(mAVLinkMessage, iCommandListener);
            }
        }
    }

    public synchronized boolean isDisconnected() {
        return getConnectionStatus() == 0;
    }

    public synchronized boolean isConnected() {
        return getConnectionStatus() == 2;
    }

    private boolean isConnecting() {
        return getConnectionStatus() == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void registerForTLogLogging(java.lang.String r2, android.net.Uri r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r1)
            return
        L_0x0005:
            boolean r0 = r1.isConnecting()     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x0011
            boolean r0 = r1.isConnected()     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
        L_0x0011:
            org.droidplanner.services.android.impl.communication.connection.AndroidMavLinkConnection r0 = r1.mavlinkConn     // Catch:{ all -> 0x0018 }
            r0.addLoggingPath(r2, r3)     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r1)
            return
        L_0x0018:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.communication.service.MAVLinkClient.registerForTLogLogging(java.lang.String, android.net.Uri):void");
    }

    public synchronized void unregisterForTLogLogging(String str) {
        if (isConnecting() || isConnected()) {
            this.mavlinkConn.removeLoggingPath(str);
        }
    }
}
