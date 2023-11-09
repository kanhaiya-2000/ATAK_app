package org.droidplanner.services.android.impl.core.MAVLink;

import android.os.Handler;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_count;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_current;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item_reached;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.communication.model.DataLink;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class WaypointManager extends DroneVariable {
    private static final int RETRY_LIMIT = 3;
    private static final long TIMEOUT = 15000;
    private List<msg_mission_item> mission = new ArrayList();
    private int readIndex;
    private int retryIndex;
    private int retryTracker = 0;
    WaypointStates state = WaypointStates.IDLE;
    /* access modifiers changed from: private */
    public final Handler watchdog;
    private final Runnable watchdogCallback = new Runnable() {
        public void run() {
            WaypointManager waypointManager = WaypointManager.this;
            if (waypointManager.processTimeOut(WaypointManager.access$004(waypointManager))) {
                WaypointManager.this.watchdog.postDelayed(this, WaypointManager.TIMEOUT);
            }
        }
    };
    private int waypointCount;
    private DroneInterfaces.OnWaypointManagerListener wpEventListener;
    private int writeIndex;

    public enum WaypointEvent_Type {
        WP_UPLOAD,
        WP_DOWNLOAD,
        WP_RETRY,
        WP_CONTINUE,
        WP_TIMED_OUT
    }

    enum WaypointStates {
        IDLE,
        READ_REQUEST,
        READING_WP,
        WRITING_WP_COUNT,
        WRITING_WP,
        WAITING_WRITE_ACK
    }

    private void onCurrentWaypointUpdate(int i) {
    }

    public void onWaypointReached(int i) {
    }

    static /* synthetic */ int access$004(WaypointManager waypointManager) {
        int i = waypointManager.retryTracker + 1;
        waypointManager.retryTracker = i;
        return i;
    }

    public WaypointManager(MavLinkDrone mavLinkDrone, Handler handler) {
        super(mavLinkDrone);
        this.watchdog = handler;
    }

    public void setWaypointManagerListener(DroneInterfaces.OnWaypointManagerListener onWaypointManagerListener) {
        this.wpEventListener = onWaypointManagerListener;
    }

    private void startWatchdog() {
        stopWatchdog();
        this.retryTracker = 0;
        this.watchdog.postDelayed(this.watchdogCallback, TIMEOUT);
    }

    private void stopWatchdog() {
        this.watchdog.removeCallbacks(this.watchdogCallback);
    }

    public void getWaypoints() {
        if (this.state == WaypointStates.IDLE) {
            doBeginWaypointEvent(WaypointEvent_Type.WP_DOWNLOAD);
            this.readIndex = -1;
            this.state = WaypointStates.READ_REQUEST;
            MavLinkWaypoint.requestWaypointsList(this.myDrone);
            startWatchdog();
        }
    }

    public void writeWaypoints(List<msg_mission_item> list) {
        if (this.state == WaypointStates.IDLE && this.mission != null) {
            doBeginWaypointEvent(WaypointEvent_Type.WP_UPLOAD);
            this.mission.clear();
            this.mission.addAll(list);
            this.writeIndex = 0;
            this.state = WaypointStates.WRITING_WP_COUNT;
            MavLinkWaypoint.sendWaypointCount(this.myDrone, this.mission.size());
            startWatchdog();
        }
    }

    public void setCurrentWaypoint(int i) {
        if (this.mission != null) {
            MavLinkWaypoint.sendSetCurrentWaypoint(this.myDrone, (short) i);
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.MAVLink.WaypointManager$2 */
    /* synthetic */ class C59262 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$MAVLink$WaypointManager$WaypointStates */
        static final /* synthetic */ int[] f8619x62cc38b1;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.droidplanner.services.android.impl.core.MAVLink.WaypointManager$WaypointStates[] r0 = org.droidplanner.services.android.impl.core.MAVLink.WaypointManager.WaypointStates.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8619x62cc38b1 = r0
                org.droidplanner.services.android.impl.core.MAVLink.WaypointManager$WaypointStates r1 = org.droidplanner.services.android.impl.core.MAVLink.WaypointManager.WaypointStates.IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8619x62cc38b1     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.MAVLink.WaypointManager$WaypointStates r1 = org.droidplanner.services.android.impl.core.MAVLink.WaypointManager.WaypointStates.READ_REQUEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8619x62cc38b1     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.MAVLink.WaypointManager$WaypointStates r1 = org.droidplanner.services.android.impl.core.MAVLink.WaypointManager.WaypointStates.READING_WP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8619x62cc38b1     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.droidplanner.services.android.impl.core.MAVLink.WaypointManager$WaypointStates r1 = org.droidplanner.services.android.impl.core.MAVLink.WaypointManager.WaypointStates.WRITING_WP_COUNT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8619x62cc38b1     // Catch:{ NoSuchFieldError -> 0x003e }
                org.droidplanner.services.android.impl.core.MAVLink.WaypointManager$WaypointStates r1 = org.droidplanner.services.android.impl.core.MAVLink.WaypointManager.WaypointStates.WRITING_WP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8619x62cc38b1     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.droidplanner.services.android.impl.core.MAVLink.WaypointManager$WaypointStates r1 = org.droidplanner.services.android.impl.core.MAVLink.WaypointManager.WaypointStates.WAITING_WRITE_ACK     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.MAVLink.WaypointManager.C59262.<clinit>():void");
        }
    }

    public boolean processMessage(MAVLinkMessage mAVLinkMessage) {
        int i = C59262.f8619x62cc38b1[this.state.ordinal()];
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    this.state = WaypointStates.WRITING_WP;
                } else if (i != 5) {
                    if (i == 6 && mAVLinkMessage.msgid == 47) {
                        stopWatchdog();
                        this.myDrone.getMission().onWriteWaypoints((msg_mission_ack) mAVLinkMessage);
                        this.state = WaypointStates.IDLE;
                        doEndWaypointEvent(WaypointEvent_Type.WP_UPLOAD);
                        return true;
                    }
                }
                if (mAVLinkMessage.msgid == 40) {
                    startWatchdog();
                    processWaypointToSend((msg_mission_request) mAVLinkMessage);
                    doWaypointEvent(WaypointEvent_Type.WP_UPLOAD, this.writeIndex + 1, this.mission.size());
                    return true;
                }
            } else if (mAVLinkMessage.msgid == 39) {
                startWatchdog();
                processReceivedWaypoint((msg_mission_item) mAVLinkMessage);
                doWaypointEvent(WaypointEvent_Type.WP_DOWNLOAD, this.readIndex + 1, this.waypointCount);
                if (this.mission.size() < this.waypointCount) {
                    MavLinkWaypoint.requestWayPoint(this.myDrone, this.mission.size());
                } else {
                    stopWatchdog();
                    this.state = WaypointStates.IDLE;
                    MavLinkWaypoint.sendAck(this.myDrone);
                    this.myDrone.getMission().onMissionReceived(this.mission);
                    doEndWaypointEvent(WaypointEvent_Type.WP_DOWNLOAD);
                }
                return true;
            }
        } else if (mAVLinkMessage.msgid == 44) {
            this.waypointCount = ((msg_mission_count) mAVLinkMessage).count;
            this.mission.clear();
            startWatchdog();
            MavLinkWaypoint.requestWayPoint(this.myDrone, this.mission.size());
            this.state = WaypointStates.READING_WP;
            return true;
        }
        if (mAVLinkMessage.msgid == 46) {
            onWaypointReached(((msg_mission_item_reached) mAVLinkMessage).seq);
            return true;
        } else if (mAVLinkMessage.msgid != 42) {
            return false;
        } else {
            onCurrentWaypointUpdate(((msg_mission_current) mAVLinkMessage).seq);
            return true;
        }
    }

    public boolean processTimeOut(int i) {
        if (i >= 3) {
            this.state = WaypointStates.IDLE;
            doWaypointEvent(WaypointEvent_Type.WP_TIMED_OUT, this.retryIndex, 3);
            return false;
        }
        this.retryIndex++;
        doWaypointEvent(WaypointEvent_Type.WP_RETRY, this.retryIndex, 3);
        int i2 = C59262.f8619x62cc38b1[this.state.ordinal()];
        if (i2 == 2) {
            MavLinkWaypoint.requestWaypointsList(this.myDrone);
        } else if (i2 != 3) {
            if (i2 == 4) {
                MavLinkWaypoint.sendWaypointCount(this.myDrone, this.mission.size());
            } else if (i2 != 5) {
                if (i2 == 6) {
                    DataLink.DataLinkProvider<MAVLinkMessage> mavClient = this.myDrone.getMavClient();
                    List<msg_mission_item> list = this.mission;
                    mavClient.sendMessage(list.get(list.size() - 1), (ICommandListener) null);
                }
            } else if (this.writeIndex < this.mission.size()) {
                this.myDrone.getMavClient().sendMessage(this.mission.get(this.writeIndex), (ICommandListener) null);
            }
        } else if (this.mission.size() < this.waypointCount) {
            MavLinkWaypoint.requestWayPoint(this.myDrone, this.mission.size());
        }
        return true;
    }

    private void processWaypointToSend(msg_mission_request msg_mission_request) {
        int i = msg_mission_request.seq;
        this.writeIndex = i;
        msg_mission_item msg_mission_item = this.mission.get(i);
        msg_mission_item.target_system = this.myDrone.getSysid();
        msg_mission_item.target_component = this.myDrone.getCompid();
        this.myDrone.getMavClient().sendMessage(msg_mission_item, (ICommandListener) null);
        if (this.writeIndex + 1 >= this.mission.size()) {
            this.state = WaypointStates.WAITING_WRITE_ACK;
        }
    }

    private void processReceivedWaypoint(msg_mission_item msg_mission_item) {
        if (msg_mission_item.seq > this.readIndex) {
            this.readIndex = msg_mission_item.seq;
            this.mission.add(msg_mission_item);
        }
    }

    private void doBeginWaypointEvent(WaypointEvent_Type waypointEvent_Type) {
        this.retryIndex = 0;
        DroneInterfaces.OnWaypointManagerListener onWaypointManagerListener = this.wpEventListener;
        if (onWaypointManagerListener != null) {
            onWaypointManagerListener.onBeginWaypointEvent(waypointEvent_Type);
        }
    }

    private void doEndWaypointEvent(WaypointEvent_Type waypointEvent_Type) {
        if (this.retryIndex > 0) {
            doWaypointEvent(WaypointEvent_Type.WP_CONTINUE, this.retryIndex, 3);
        }
        this.retryIndex = 0;
        DroneInterfaces.OnWaypointManagerListener onWaypointManagerListener = this.wpEventListener;
        if (onWaypointManagerListener != null) {
            onWaypointManagerListener.onEndWaypointEvent(waypointEvent_Type);
        }
    }

    private void doWaypointEvent(WaypointEvent_Type waypointEvent_Type, int i, int i2) {
        this.retryIndex = 0;
        DroneInterfaces.OnWaypointManagerListener onWaypointManagerListener = this.wpEventListener;
        if (onWaypointManagerListener != null) {
            onWaypointManagerListener.onWaypointEvent(waypointEvent_Type, i, i2);
        }
    }
}
