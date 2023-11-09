package org.droidplanner.services.android.impl.core.drone.variables;

import android.os.Handler;
import atakplugin.UASTool.cqb;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class HeartBeat extends DroneVariable implements DroneInterfaces.OnDroneListener<MavLinkDrone> {
    protected static final int FIRST_HEARTBEAT = 0;
    private static final long HEARTBEAT_LOST_TIMEOUT = 15000;
    public static final long HEARTBEAT_NORMAL_TIMEOUT = 5000;
    public static final int INVALID_MAVLINK_VERSION = -1;
    protected static final int LOST_HEARTBEAT = 1;
    protected static final int NORMAL_HEARTBEAT = 2;
    private short compid = 1;
    protected int heartbeatState = 0;
    private short mMavlinkVersion = -1;
    private short sysid = 1;
    public final Handler watchdog;
    public final Runnable watchdogCallback = new Runnable() {
        public void run() {
            HeartBeat.this.onHeartbeatTimeout();
        }
    };

    public HeartBeat(MavLinkDrone mavLinkDrone, Handler handler) {
        super(mavLinkDrone);
        this.watchdog = handler;
        mavLinkDrone.addDroneListener(this);
    }

    public short getSysid() {
        return this.sysid;
    }

    public short getCompid() {
        return this.compid;
    }

    public short getMavlinkVersion() {
        return this.mMavlinkVersion;
    }

    public void onHeartbeat(MAVLinkMessage mAVLinkMessage) {
        msg_heartbeat msg_heartbeat = mAVLinkMessage instanceof msg_heartbeat ? (msg_heartbeat) mAVLinkMessage : null;
        if (msg_heartbeat != null) {
            this.sysid = validateToUnsignedByteRange(mAVLinkMessage.sysid);
            this.compid = validateToUnsignedByteRange(mAVLinkMessage.compid);
            this.mMavlinkVersion = msg_heartbeat.mavlink_version;
        }
        int i = this.heartbeatState;
        if (i != 0) {
            if (i == 1) {
                this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED);
            }
            this.heartbeatState = 2;
            restartWatchdog(HEARTBEAT_NORMAL_TIMEOUT);
        } else if (msg_heartbeat != null) {
            cqb.m12010c("Received first heartbeat.", new Object[0]);
            this.heartbeatState = 2;
            restartWatchdog(HEARTBEAT_NORMAL_TIMEOUT);
            this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST);
        }
    }

    public boolean hasHeartbeat() {
        return this.heartbeatState != 0;
    }

    public boolean isConnectionAlive() {
        return this.heartbeatState != 1;
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.variables.HeartBeat$2 */
    /* synthetic */ class C59842 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8631x7e1461ff;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f8631x7e1461ff = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        if (C59842.f8631x7e1461ff[droneEventsType.ordinal()] == 1) {
            notifyDisconnected();
        }
    }

    private void notifyDisconnected() {
        this.watchdog.removeCallbacks(this.watchdogCallback);
        this.heartbeatState = 0;
        this.mMavlinkVersion = -1;
    }

    /* access modifiers changed from: protected */
    public void onHeartbeatTimeout() {
        if (this.heartbeatState != 0) {
            this.heartbeatState = 1;
            restartWatchdog(HEARTBEAT_LOST_TIMEOUT);
            this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT);
            return;
        }
        cqb.m12010c("First heartbeat timeout.", new Object[0]);
        this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT);
    }

    /* access modifiers changed from: protected */
    public void restartWatchdog(long j) {
        this.watchdog.removeCallbacks(this.watchdogCallback);
        this.watchdog.postDelayed(this.watchdogCallback, j);
    }
}
