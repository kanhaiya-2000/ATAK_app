package com.bbn.ccast.mavlink;

import atakplugin.UASTool.C0827sg;
import com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_status;
import com.atakmap.android.uastool.MAVLink.common.msg_attitude;
import com.atakmap.android.uastool.MAVLink.common.msg_autopilot_version;
import com.atakmap.android.uastool.MAVLink.common.msg_battery_status;
import com.atakmap.android.uastool.MAVLink.common.msg_command_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_command_int;
import com.atakmap.android.uastool.MAVLink.common.msg_command_long;
import com.atakmap.android.uastool.MAVLink.common.msg_extended_sys_state;
import com.atakmap.android.uastool.MAVLink.common.msg_global_position_int;
import com.atakmap.android.uastool.MAVLink.common.msg_gps_raw_int;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import com.atakmap.android.uastool.MAVLink.common.msg_home_position;
import com.atakmap.android.uastool.MAVLink.common.msg_manual_control;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_clear_all;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_count;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item_int;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item_reached;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request_int;
import com.atakmap.android.uastool.MAVLink.common.msg_mount_orientation;
import com.atakmap.android.uastool.MAVLink.common.msg_param_request_list;
import com.atakmap.android.uastool.MAVLink.common.msg_param_set;
import com.atakmap.android.uastool.MAVLink.common.msg_param_value;
import com.atakmap.android.uastool.MAVLink.common.msg_ping;
import com.atakmap.android.uastool.MAVLink.common.msg_radio_status;
import com.atakmap.android.uastool.MAVLink.common.msg_request_data_stream;
import com.atakmap.android.uastool.MAVLink.common.msg_set_gps_global_origin;
import com.atakmap.android.uastool.MAVLink.common.msg_set_mode;
import com.atakmap.android.uastool.MAVLink.common.msg_set_position_target_global_int;
import com.atakmap.android.uastool.MAVLink.common.msg_set_position_target_local_ned;
import com.atakmap.android.uastool.MAVLink.common.msg_statustext;
import com.atakmap.android.uastool.MAVLink.common.msg_sys_status;
import com.atakmap.android.uastool.MAVLink.common.msg_timesync;
import com.atakmap.android.uastool.MAVLink.common.msg_vfr_hud;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.mavlink.MavLinkParameterChangedCallback;
import com.atakmap.android.uastool.mavlink.MavLinkTelemetryCallback;
import com.atakmap.coremap.log.Log;
import com.bbn.ccast.mavlink.MavLinkDialectInterface;
import com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle;
import com.bbn.vehicleinterface.types.GeoPosition;
import com.bbn.vehicleinterface.types.ResultCallback;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class MavLinkThread extends Thread {
    static final int MAX_PARAMETER_TIMEOUT_SEC = 40;
    /* access modifiers changed from: private */
    public static final String TAG = "MavLinkThread";
    protected AtomicReference<ArmDisarmCallback> armDisarmCallback = new AtomicReference<>((Object) null);
    private final AtomicInteger currentMessageId = new AtomicInteger(0);
    private final AtomicReference<List<msg_mission_item>> currentMission = new AtomicReference<>();
    private final AtomicInteger currentType = new AtomicInteger(-1);
    public boolean decay_control = false;
    private final AtomicReference<MavLinkDialectInterface> dialectInterfaceRef = new AtomicReference<>((Object) null);
    private final Thread heartBeatProducer;
    private final AtomicInteger highestMissionWaypointUploaded = new AtomicInteger(0);
    protected AtomicBoolean keepThisFromArming = new AtomicBoolean(false);
    private final AtomicLong lastMessgeReceived = new AtomicLong(0);
    final ClassToInstanceMap<MAVLinkMessage> latestMessages = MutableClassToInstanceMap.create(new HashMap());
    private ManualControlStruct manualControl;
    private final Thread manualControlProducer;
    private final Map<String, Float> mavlink_parameters = new ConcurrentHashMap();
    private int missionItemCount;
    private final ArrayList<MissionItemReachedCallback> missionItemReachedCallbackList = new ArrayList<>();
    private final AtomicReference<ModeChangeCallback> modeChangeCallback = new AtomicReference<>((Object) null);
    private float[] moveGuidedTarget;
    private final AtomicReference<Runnable> onUploadSuccess = new AtomicReference<>();
    private final ArrayList<MavLinkParameterChangedCallback> parameterChangedCallbackList = new ArrayList<>();
    private final AtomicBoolean shouldRun = new AtomicBoolean(true);
    private String status = "";
    protected AtomicReference<TakeoffCallback> takeoffCallback = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public final AtomicBoolean takeoffCancelledOrCompleted = new AtomicBoolean(false);
    private volatile Integer targetComponent = null;
    private volatile Integer targetSystem = null;
    private final ArrayList<MavLinkTelemetryCallback> telemetryCallbackList = new ArrayList<>();
    public AtomicInteger totalNumParams = new AtomicInteger(Integer.MAX_VALUE);
    MavlinkTransport transport = null;

    public interface ArmDisarmCallback {
        void armDisarmFailure(int i);

        void armDisarmSuccess();
    }

    public interface MissionItemReachedCallback {
        void onMissionItemReached(int i, int i2);
    }

    public interface ModeChangeCallback {
        void onModeChangeFailure(int i);

        void onModeChangeSuccess();
    }

    public interface OnInitializationCallback {
        void onError(String str, Throwable th);

        void onFinished(int i);

        void onProgressUpdate(int i, int i2);
    }

    public interface TakeoffCallback {
        void onFailure(int i);

        void onSuccess();
    }

    /* access modifiers changed from: protected */
    public short getTargetComponent() {
        return 1;
    }

    public static class ManualControlStruct {
        short pitch;
        short roll;
        short thrust;
        long time;
        short yaw;

        public ManualControlStruct() {
            init();
        }

        public void init() {
            this.roll = 0;
            this.pitch = 0;
            this.yaw = 0;
            this.thrust = 500;
            this.time = 0;
        }
    }

    public MavLinkThread(MavlinkTransport mavlinkTransport) {
        this.transport = mavlinkTransport;
        Thread thread = new Thread(new HeartBeatProducer(this));
        this.heartBeatProducer = thread;
        thread.start();
        Thread thread2 = new Thread(new ManualControlProducer(this));
        this.manualControlProducer = thread2;
        thread2.start();
    }

    public boolean isConnected() {
        MavlinkTransport mavlinkTransport = this.transport;
        return mavlinkTransport != null && mavlinkTransport.isConnected() && !isStale();
    }

    public boolean isStale() {
        return Long.valueOf(System.currentTimeMillis() - this.lastMessgeReceived.get()).longValue() > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A[Catch:{ IOException -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x000a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = "error"
            java.lang.String r1 = "Exception or end of Stream; nulling connection"
            java.util.concurrent.atomic.AtomicBoolean r2 = r9.shouldRun
            r3 = 1
            r2.set(r3)
        L_0x000a:
            java.util.concurrent.atomic.AtomicBoolean r2 = r9.shouldRun     // Catch:{ InterruptedException -> 0x00bd }
            boolean r2 = r2.get()     // Catch:{ InterruptedException -> 0x00bd }
            if (r2 == 0) goto L_0x00c4
            r4 = 3000(0xbb8, double:1.482E-320)
            com.bbn.ccast.mavlink.MavlinkTransport r2 = r9.transport     // Catch:{ IOException -> 0x006d }
            if (r2 == 0) goto L_0x0043
            boolean r2 = r2.isConnected()     // Catch:{ IOException -> 0x006d }
            if (r2 != 0) goto L_0x001f
            goto L_0x0043
        L_0x001f:
            com.atakmap.android.uastool.MAVLink.Parser r2 = new com.atakmap.android.uastool.MAVLink.Parser     // Catch:{ IOException -> 0x006d }
            r2.<init>()     // Catch:{ IOException -> 0x006d }
            r6 = 0
            r9.initialize(r3, r6)     // Catch:{ IOException -> 0x006d }
            r6 = 0
        L_0x0029:
            r7 = -1
            if (r6 <= r7) goto L_0x0052
            com.bbn.ccast.mavlink.MavlinkTransport r6 = r9.transport     // Catch:{ IOException -> 0x006d }
            int r6 = r6.read()     // Catch:{ IOException -> 0x006d }
            byte r7 = (byte) r6     // Catch:{ IOException -> 0x006d }
            com.atakmap.android.uastool.MAVLink.MAVLinkPacket r7 = r2.mavlink_parse_char(r7)     // Catch:{ IOException -> 0x006d }
            if (r7 == 0) goto L_0x0029
            com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage r7 = r7.unpack()     // Catch:{ IOException -> 0x006d }
            if (r7 == 0) goto L_0x0029
            r9._handleMessage(r7)     // Catch:{ IOException -> 0x006d }
            goto L_0x0029
        L_0x0043:
            java.lang.String r2 = TAG     // Catch:{ IOException -> 0x006d }
            java.lang.String r6 = "MAVLink transport is null or not connected... bailing."
            com.atakmap.coremap.log.Log.d(r2, r6)     // Catch:{ IOException -> 0x006d }
            java.lang.Thread.sleep(r4)     // Catch:{ IOException -> 0x006d }
            com.bbn.ccast.mavlink.MavlinkTransport r2 = r9.transport     // Catch:{ IOException -> 0x006d }
            r2.reconnect()     // Catch:{ IOException -> 0x006d }
        L_0x0052:
            java.lang.String r2 = TAG     // Catch:{ InterruptedException -> 0x00bd }
            com.atakmap.coremap.log.Log.d(r2, r1)     // Catch:{ InterruptedException -> 0x00bd }
            java.lang.Thread.sleep(r4)     // Catch:{ IOException -> 0x0064 }
            com.bbn.ccast.mavlink.MavlinkTransport r2 = r9.transport     // Catch:{ IOException -> 0x0064 }
            boolean r4 = r2 instanceof com.bbn.ccast.mavlink.TcpMavlinkTransport     // Catch:{ IOException -> 0x0064 }
            if (r4 != 0) goto L_0x000a
            r2.reconnect()     // Catch:{ IOException -> 0x0064 }
            goto L_0x000a
        L_0x0064:
            r2 = move-exception
        L_0x0065:
            java.lang.String r4 = TAG     // Catch:{ InterruptedException -> 0x00bd }
            com.atakmap.coremap.log.Log.e(r4, r0, r2)     // Catch:{ InterruptedException -> 0x00bd }
            goto L_0x000a
        L_0x006b:
            r2 = move-exception
            goto L_0x00a4
        L_0x006d:
            r2 = move-exception
            java.lang.String r6 = TAG     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r7.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r8 = "Unexpected exception encountered and handled in "
            r7.append(r8)     // Catch:{ all -> 0x006b }
            java.lang.Class r8 = r9.getClass()     // Catch:{ all -> 0x006b }
            java.lang.String r8 = r8.getSimpleName()     // Catch:{ all -> 0x006b }
            r7.append(r8)     // Catch:{ all -> 0x006b }
            java.lang.String r8 = " : "
            r7.append(r8)     // Catch:{ all -> 0x006b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x006b }
            com.atakmap.coremap.log.Log.d(r6, r7, r2)     // Catch:{ all -> 0x006b }
            com.atakmap.coremap.log.Log.d(r6, r1)     // Catch:{ InterruptedException -> 0x00bd }
            java.lang.Thread.sleep(r4)     // Catch:{ IOException -> 0x00a2 }
            com.bbn.ccast.mavlink.MavlinkTransport r2 = r9.transport     // Catch:{ IOException -> 0x00a2 }
            boolean r4 = r2 instanceof com.bbn.ccast.mavlink.TcpMavlinkTransport     // Catch:{ IOException -> 0x00a2 }
            if (r4 != 0) goto L_0x000a
            r2.reconnect()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x000a
        L_0x00a2:
            r2 = move-exception
            goto L_0x0065
        L_0x00a4:
            java.lang.String r3 = TAG     // Catch:{ InterruptedException -> 0x00bd }
            com.atakmap.coremap.log.Log.d(r3, r1)     // Catch:{ InterruptedException -> 0x00bd }
            java.lang.Thread.sleep(r4)     // Catch:{ IOException -> 0x00b6 }
            com.bbn.ccast.mavlink.MavlinkTransport r1 = r9.transport     // Catch:{ IOException -> 0x00b6 }
            boolean r3 = r1 instanceof com.bbn.ccast.mavlink.TcpMavlinkTransport     // Catch:{ IOException -> 0x00b6 }
            if (r3 != 0) goto L_0x00bc
            r1.reconnect()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00bc
        L_0x00b6:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ InterruptedException -> 0x00bd }
            com.atakmap.coremap.log.Log.e(r3, r0, r1)     // Catch:{ InterruptedException -> 0x00bd }
        L_0x00bc:
            throw r2     // Catch:{ InterruptedException -> 0x00bd }
        L_0x00bd:
            java.lang.String r0 = TAG
            java.lang.String r1 = "MavLinkThread Interrupted"
            com.atakmap.coremap.log.Log.d(r0, r1)
        L_0x00c4:
            java.lang.String r0 = TAG
            java.lang.String r1 = "MavLinkThread Ended"
            com.atakmap.coremap.log.Log.d(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.MavLinkThread.run():void");
    }

    public void exit() {
        Log.d(TAG, "exit()");
        try {
            this.heartBeatProducer.interrupt();
        } catch (Exception unused) {
            Log.d(TAG, "Could not interrupt heartbeatproducer");
        }
        try {
            this.manualControlProducer.interrupt();
        } catch (Exception unused2) {
            Log.d(TAG, "Could not interrupt manualControlproducer");
        }
        this.missionItemReachedCallbackList.clear();
        this.parameterChangedCallbackList.clear();
        synchronized (this.telemetryCallbackList) {
            this.telemetryCallbackList.clear();
        }
        this.shouldRun.set(false);
        interrupt();
        try {
            this.transport.close();
        } catch (IOException unused3) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[SYNTHETIC, Splitter:B:14:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T extends com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage> void sendMessage(final T r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.atakmap.android.uastool.MAVLink.MAVLinkPacket r0 = r6.pack()     // Catch:{ Exception -> 0x0012 }
            java.util.concurrent.atomic.AtomicInteger r1 = r5.currentMessageId     // Catch:{ Exception -> 0x000e }
            int r1 = r1.getAndIncrement()     // Catch:{ Exception -> 0x000e }
            r0.seq = r1     // Catch:{ Exception -> 0x000e }
            goto L_0x003d
        L_0x000e:
            r1 = move-exception
            goto L_0x0014
        L_0x0010:
            r6 = move-exception
            goto L_0x0054
        L_0x0012:
            r1 = move-exception
            r0 = 0
        L_0x0014:
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = "error"
            com.atakmap.coremap.log.Log.e(r2, r3, r1)     // Catch:{ all -> 0x0010 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r3.<init>()     // Catch:{ all -> 0x0010 }
            java.lang.String r4 = "%s - Error packing message: "
            r3.append(r4)     // Catch:{ all -> 0x0010 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0010 }
            r3.append(r1)     // Catch:{ all -> 0x0010 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0010 }
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0010 }
            r4 = 0
            r3[r4] = r2     // Catch:{ all -> 0x0010 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ all -> 0x0010 }
            com.atakmap.coremap.log.Log.d(r2, r1)     // Catch:{ all -> 0x0010 }
        L_0x003d:
            if (r0 != 0) goto L_0x0041
            monitor-exit(r5)
            return
        L_0x0041:
            byte[] r0 = r0.encodePacket()     // Catch:{ all -> 0x0010 }
            java.lang.Thread r1 = new java.lang.Thread     // Catch:{ all -> 0x0010 }
            com.bbn.ccast.mavlink.MavLinkThread$1 r2 = new com.bbn.ccast.mavlink.MavLinkThread$1     // Catch:{ all -> 0x0010 }
            r2.<init>(r0, r6)     // Catch:{ all -> 0x0010 }
            r1.<init>(r2)     // Catch:{ all -> 0x0010 }
            r1.start()     // Catch:{ all -> 0x0010 }
            monitor-exit(r5)
            return
        L_0x0054:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.MavLinkThread.sendMessage(com.atakmap.android.uastool.MAVLink.Messages.MAVLinkMessage):void");
    }

    public <T extends MAVLinkMessage> void sendMessages(List<T> list) {
        for (T sendMessage : list) {
            sendMessage(sendMessage);
        }
    }

    public boolean waitHeartbeat(Integer num) {
        long currentTimeMillis = System.currentTimeMillis();
        while (((long) num.intValue()) > System.currentTimeMillis() - currentTimeMillis) {
            if (this.targetSystem == null || this.targetComponent == null) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    Log.e(TAG, "error", e);
                }
            } else {
                Log.d(TAG, "Got heartbeat; done waiting");
                return true;
            }
        }
        Log.d(TAG, "Timeout waiting for heartbeat");
        return false;
    }

    /* access modifiers changed from: protected */
    public void _handleMessage(MAVLinkMessage mAVLinkMessage) {
        if (mAVLinkMessage.msgid == 0) {
            msg_heartbeat msg_heartbeat = (msg_heartbeat) mAVLinkMessage;
            short s = msg_heartbeat.autopilot;
            if (s != 3) {
                if (s != 12 && s != 20) {
                    return;
                }
                if (this.dialectInterfaceRef.compareAndSet((Object) null, new Px4Dialect(this))) {
                    String str = TAG;
                    Log.d(str, str + " : Detected PX4 flightstack.");
                }
            } else if (this.dialectInterfaceRef.compareAndSet((Object) null, new ArduPilotDialect(this))) {
                requestDataStream();
                String str2 = TAG;
                Log.d(str2, str2 + " : Detected ArduPilot flightstack.");
            }
            this.targetSystem = Integer.valueOf(msg_heartbeat.sysid);
            this.targetComponent = Integer.valueOf(msg_heartbeat.compid);
            this.currentType.set(msg_heartbeat.type);
            onHeartBeat(msg_heartbeat);
        } else if (mAVLinkMessage.msgid == 111) {
            msg_timesync msg_timesync = (msg_timesync) mAVLinkMessage;
            if (msg_timesync.ts1 != 0) {
                try {
                    sendTimeSync(msg_timesync.ts1);
                } catch (Exception e) {
                    Log.d(TAG, "Could not reply to timesync: ", e);
                }
            }
        } else if (mAVLinkMessage.msgid == 242) {
            onHomePositionUpdate((msg_home_position) mAVLinkMessage);
        } else if (mAVLinkMessage.msgid == 22) {
            onParamValue((msg_param_value) mAVLinkMessage);
        } else if (mAVLinkMessage.msgid == 33) {
            onGlobalPositionInt((msg_global_position_int) mAVLinkMessage);
        } else if (mAVLinkMessage.msgid == 40) {
            onRequestMissionItemNum(mAVLinkMessage, false);
        } else if (mAVLinkMessage.msgid == 51) {
            onRequestMissionItemNum(mAVLinkMessage, true);
        } else if (mAVLinkMessage.msgid != 73) {
            if (mAVLinkMessage.msgid == 47) {
                onMissionAck((msg_mission_ack) mAVLinkMessage);
            } else if (mAVLinkMessage.msgid == 77) {
                onCommandAck((msg_command_ack) mAVLinkMessage);
            } else if (mAVLinkMessage.msgid == 253) {
                msg_statustext msg_statustext = (msg_statustext) mAVLinkMessage;
                String str3 = TAG;
                Log.e(str3, "Mission ACK: " + ("MAVLINK_MSG_ID_STATUSTEXT - sysid:" + msg_statustext.sysid + " compid:" + msg_statustext.compid + " severity:" + msg_statustext.severity + " text:" + msg_statustext.getText()));
                onStatusText(msg_statustext);
            } else if (mAVLinkMessage.msgid == 265) {
                onMountOrientation((msg_mount_orientation) mAVLinkMessage);
            } else if (mAVLinkMessage.msgid == 158) {
                onMountStatus((msg_mount_status) mAVLinkMessage);
            } else if (mAVLinkMessage.msgid == 46) {
                onMissionItemReached(((msg_mission_item_reached) mAVLinkMessage).seq);
            }
        }
        handleMessage(mAVLinkMessage);
    }

    /* access modifiers changed from: protected */
    public void onHomePositionUpdate(msg_home_position msg_home_position) {
        handleMessage(msg_home_position);
        GeoPosition homePosition = getHomePosition();
        synchronized (this.telemetryCallbackList) {
            Iterator<MavLinkTelemetryCallback> it = this.telemetryCallbackList.iterator();
            while (it.hasNext()) {
                MavLinkTelemetryCallback next = it.next();
                if (next != null) {
                    try {
                        next.onHomePositonUpdate(homePosition.getLatitude(), homePosition.getLongitude(), homePosition.getAltitude());
                    } catch (Exception e) {
                        Log.e(TAG, "Error calling Telemetry Callback", e);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onParamValue(msg_param_value msg_param_value) {
        String param_Id = msg_param_value.getParam_Id();
        float f = msg_param_value.param_value;
        if (msg_param_value.param_type == 6) {
            try {
                f = (float) Float.floatToIntBits(msg_param_value.param_value);
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
        }
        this.totalNumParams.set(msg_param_value.param_count);
        this.mavlink_parameters.put(param_Id, Float.valueOf(f));
        Iterator<MavLinkParameterChangedCallback> it = this.parameterChangedCallbackList.iterator();
        while (it.hasNext()) {
            MavLinkParameterChangedCallback next = it.next();
            if (next != null) {
                try {
                    next.onParameterChanged(param_Id, Float.valueOf(f));
                } catch (Exception e2) {
                    Log.e(TAG, "Error calling paramChanged Callback", e2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onGlobalPositionInt(msg_global_position_int msg_global_position_int) {
        updateLatest(msg_global_position_int);
        GeoPosition dronePosition_MSL = getDronePosition_MSL();
        GeoPosition dronePosition_HAL = getDronePosition_HAL();
        float[] fArr = this.moveGuidedTarget;
        if (fArr != null && Math.abs(((double) fArr[0]) - dronePosition_MSL.getLatitude()) < 1.0E-5d && Math.abs(((double) this.moveGuidedTarget[1]) - dronePosition_MSL.getLongitude()) < 1.0E-5d) {
            this.missionItemCount = 1;
            onMissionItemReached(0);
            this.moveGuidedTarget = null;
        }
        synchronized (this.telemetryCallbackList) {
            Iterator<MavLinkTelemetryCallback> it = this.telemetryCallbackList.iterator();
            while (it.hasNext()) {
                MavLinkTelemetryCallback next = it.next();
                if (next != null) {
                    try {
                        next.onPositionUpdate(dronePosition_MSL.getLatitude(), dronePosition_MSL.getLongitude(), dronePosition_HAL.getAltitude(), dronePosition_MSL.getAltitude(), getYaw());
                    } catch (Exception e) {
                        String str = TAG;
                        Log.d(str, "onPositionUpdate: " + e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onHeartBeat(msg_heartbeat msg_heartbeat) {
        updateLatest(msg_heartbeat);
        synchronized (this.telemetryCallbackList) {
            Iterator<MavLinkTelemetryCallback> it = this.telemetryCallbackList.iterator();
            while (it.hasNext()) {
                MavLinkTelemetryCallback next = it.next();
                if (next != null) {
                    try {
                        next.onHeartBeat(isArmed(), this.dialectInterfaceRef.get().getModeString());
                    } catch (Exception e) {
                        Log.d(TAG, "onHeartBeat: ", e);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMountOrientation(msg_mount_orientation msg_mount_orientation) {
        msg_vfr_hud msg_vfr_hud;
        synchronized (this.telemetryCallbackList) {
            Iterator<MavLinkTelemetryCallback> it = this.telemetryCallbackList.iterator();
            while (it.hasNext()) {
                MavLinkTelemetryCallback next = it.next();
                try {
                    float f = msg_mount_orientation.yaw_absolute;
                    if (next != null) {
                        if ((Float.isNaN(f) || Float.isNaN(msg_mount_orientation.yaw)) && (msg_vfr_hud = (msg_vfr_hud) getLatestMessage(msg_vfr_hud.class)) != null) {
                            f = (float) msg_vfr_hud.heading;
                        }
                        next.onSensorAngleUpdate((double) msg_mount_orientation.pitch, (double) msg_mount_orientation.roll, (double) msg_mount_orientation.yaw, (double) f);
                    }
                } catch (Exception e) {
                    String str = TAG;
                    Log.d(str, "onSensorAngleUpdate: " + e.getLocalizedMessage());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMountStatus(msg_mount_status msg_mount_status) {
        synchronized (this.telemetryCallbackList) {
            Iterator<MavLinkTelemetryCallback> it = this.telemetryCallbackList.iterator();
            while (it.hasNext()) {
                MavLinkTelemetryCallback next = it.next();
                if (next != null) {
                    try {
                        next.onSensorAngleUpdate((double) ((-msg_mount_status.pointing_a) / 100), (double) (msg_mount_status.pointing_b / 100), (double) (msg_mount_status.pointing_c / 100), (double) (msg_mount_status.pointing_c / 100));
                    } catch (Exception e) {
                        String str = TAG;
                        Log.d(str, "onSensorAngleUpdate: " + e.getLocalizedMessage());
                    }
                }
            }
        }
    }

    private void onStatusText(msg_statustext msg_statustext) {
        UASToolDropDownReceiver.toast(msg_statustext.getText(), 0);
        String str = TAG;
        Log.d(str, "MavlinkThread -  Got status: " + msg_statustext.getText());
        this.status = msg_statustext.getText();
    }

    public String getStatusText() {
        return this.status;
    }

    private void onMissionItemReached(int i) {
        Iterator<MissionItemReachedCallback> it = this.missionItemReachedCallbackList.iterator();
        while (it.hasNext()) {
            it.next().onMissionItemReached(i, this.missionItemCount);
        }
    }

    private void onCommandAck(msg_command_ack msg_command_ack) {
        String str = TAG;
        Log.d(str, "Got a Command ACK command=" + msg_command_ack.command + " result=" + msg_command_ack.result);
        int i = msg_command_ack.command;
        if (i == 11) {
            handleModeChangeAck(msg_command_ack);
        } else if (i == 22) {
            handleTakeoffAck(msg_command_ack);
        } else if (i != 400) {
            Log.d(str, "Got a command ack for something we don't care about, command=" + msg_command_ack.command);
        } else {
            handleArmDisarmAck(msg_command_ack);
        }
    }

    private void handleModeChangeAck(msg_command_ack msg_command_ack) {
        ModeChangeCallback andSet = this.modeChangeCallback.getAndSet((Object) null);
        if (msg_command_ack.result == 0) {
            Log.d(TAG, "Got a successful mode change ACK");
            if (andSet != null) {
                andSet.onModeChangeSuccess();
                return;
            }
            return;
        }
        String str = TAG;
        Log.d(str, "Mode change failed with result: " + msg_command_ack.result);
        if (andSet != null) {
            andSet.onModeChangeFailure(msg_command_ack.result);
        }
    }

    public void returnToLaunch() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = getTargetSystem();
        msg_command_long.target_component = getTargetComponent();
        msg_command_long.command = 20;
        msg_command_long.confirmation = 0;
        sendMessage(msg_command_long);
        Log.d(TAG, "sent RTL");
    }

    private void handleArmDisarmAck(msg_command_ack msg_command_ack) {
        ArmDisarmCallback andSet = this.armDisarmCallback.getAndSet((Object) null);
        if (msg_command_ack.result == 0) {
            Log.d(TAG, "Arm success!");
            if (andSet != null) {
                andSet.armDisarmSuccess();
            }
        } else if (msg_command_ack.result == 2 || msg_command_ack.result == 4) {
            Log.d(TAG, "Arm failed");
            if (andSet != null) {
                andSet.armDisarmFailure(msg_command_ack.result);
            }
        } else {
            String str = TAG;
            Log.d(str, "Arm/Disarm event happened without handling: " + msg_command_ack);
        }
    }

    /* access modifiers changed from: protected */
    public void handleTakeoffAck(msg_command_ack msg_command_ack) {
        this.dialectInterfaceRef.get().handleTakeoffAck(msg_command_ack);
    }

    private void onMissionAck(msg_mission_ack msg_mission_ack) {
        Runnable runnable;
        String str = TAG;
        Log.d(str, "Got a Mission ACK " + msg_mission_ack.type);
        if (msg_mission_ack.type == 0 && this.currentMission.get() != null && this.highestMissionWaypointUploaded.get() + 1 == this.currentMission.get().size() && (runnable = this.onUploadSuccess.get()) != null) {
            runnable.run();
        }
    }

    private void onRequestMissionItemNum(MAVLinkMessage mAVLinkMessage, boolean z) {
        int i;
        if (z) {
            i = ((msg_mission_request_int) mAVLinkMessage).seq;
        } else {
            i = ((msg_mission_request) mAVLinkMessage).seq;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append(" Platform requested mission item");
        sb.append(z ? "[int] " : "[float] ");
        sb.append(i);
        Log.d(str, sb.toString());
        try {
            msg_mission_item msg_mission_item = (msg_mission_item) this.currentMission.get().get(i);
            int i2 = 0;
            if (z) {
                msg_mission_item_int msg_mission_item_int = new msg_mission_item_int();
                msg_mission_item_int.seq = i;
                msg_mission_item_int.f8322x = (int) (((double) msg_mission_item.f8319x) * 1.0E7d);
                msg_mission_item_int.f8323y = (int) (((double) msg_mission_item.f8320y) * 1.0E7d);
                msg_mission_item_int.f8324z = msg_mission_item.f8321z;
                msg_mission_item_int.command = msg_mission_item.command;
                msg_mission_item_int.target_system = (short) mAVLinkMessage.sysid;
                msg_mission_item_int.target_component = (short) mAVLinkMessage.compid;
                msg_mission_item_int.frame = msg_mission_item.frame;
                msg_mission_item_int.current = (short) (i == 0 ? 1 : 0);
                msg_mission_item_int.autocontinue = msg_mission_item.autocontinue;
                sendMessage(msg_mission_item_int);
                if (i == this.currentMission.get().size() - 1) {
                    msg_mission_count msg_mission_count = new msg_mission_count();
                    msg_mission_count.target_system = getTargetSystem();
                    msg_mission_count.target_component = getTargetComponent();
                    msg_mission_count.count = 0;
                    sendMessage(msg_mission_count);
                    sendMessage(msg_mission_count);
                }
            } else {
                msg_mission_item.seq = i;
                msg_mission_item.compid = 190;
                msg_mission_item.sysid = 1;
                msg_mission_item.target_system = (short) mAVLinkMessage.sysid;
                msg_mission_item.target_component = (short) mAVLinkMessage.compid;
                if (i == 0) {
                    i2 = 1;
                }
                msg_mission_item.current = (short) i2;
                sendMessage(msg_mission_item);
            }
        } catch (Exception e) {
            String str2 = TAG;
            Log.d(str2, "Exception responding to mission item request : " + e);
        }
        this.highestMissionWaypointUploaded.set(i);
    }

    /* access modifiers changed from: protected */
    public void handleMessage(MAVLinkMessage mAVLinkMessage) {
        this.lastMessgeReceived.set(System.currentTimeMillis());
        updateLatest(mAVLinkMessage);
    }

    public void sendRequestParams() {
        msg_param_request_list msg_param_request_list = new msg_param_request_list();
        msg_param_request_list.target_system = getTargetSystem();
        msg_param_request_list.target_component = getTargetComponent();
        sendMessage(msg_param_request_list);
        Log.d(TAG, "requesting parameter list");
    }

    public void sendRequestVideoStreamInformation() {
        msg_command_int msg_command_int = new msg_command_int();
        msg_command_int.target_system = getTargetSystem();
        msg_command_int.target_component = getTargetComponent();
        msg_command_int.command = 2504;
        msg_command_int.param1 = 0.0f;
        sendMessage(msg_command_int);
        Log.d(TAG, "requesting VideoStreamInformation");
    }

    /* access modifiers changed from: package-private */
    public void sendRequestProtocolVersion() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = getTargetSystem();
        msg_command_long.target_component = getTargetComponent();
        msg_command_long.param1 = 1.0f;
        msg_command_long.command = 519;
        sendMessage(msg_command_long);
        Log.d(TAG, "requesting parameter list");
    }

    /* access modifiers changed from: package-private */
    public void sendRequestAutoPilotCapabilities() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = getTargetSystem();
        msg_command_long.target_component = getTargetComponent();
        msg_command_long.param1 = 1.0f;
        msg_command_long.command = MAV_CMD.MAV_CMD_REQUEST_AUTOPILOT_CAPABILITIES;
        sendMessage(msg_command_long);
        Log.d(TAG, "requesting autopilot version");
    }

    public void sendInitStream(int i) {
        msg_request_data_stream msg_request_data_stream = new msg_request_data_stream();
        msg_request_data_stream.target_system = getTargetSystem();
        msg_request_data_stream.target_component = getTargetComponent();
        msg_request_data_stream.req_stream_id = (short) i;
        if (i == 0) {
            msg_request_data_stream.req_message_rate = 20;
        } else {
            msg_request_data_stream.req_message_rate = 2;
        }
        msg_request_data_stream.start_stop = 1;
        sendMessage(msg_request_data_stream);
        sendMessage(msg_request_data_stream);
    }

    public void sendMoveNEDVelocity(float f, float f2, float f3) {
        msg_set_position_target_global_int msg_set_position_target_global_int = new msg_set_position_target_global_int();
        msg_set_position_target_global_int.target_system = getTargetSystem();
        msg_set_position_target_global_int.target_component = getTargetComponent();
        msg_set_position_target_global_int.coordinate_frame = 6;
        msg_set_position_target_global_int.type_mask = 4039;
        msg_set_position_target_global_int.f8339vx = f;
        msg_set_position_target_global_int.f8340vy = f2;
        msg_set_position_target_global_int.f8341vz = f3;
        sendMessage(msg_set_position_target_global_int);
    }

    public void sendMoveNEDPosition(float f, float f2, float f3) {
        msg_set_position_target_local_ned msg_set_position_target_local_ned = new msg_set_position_target_local_ned();
        msg_set_position_target_local_ned.target_system = getTargetSystem();
        msg_set_position_target_local_ned.target_component = getTargetComponent();
        msg_set_position_target_local_ned.coordinate_frame = 6;
        msg_set_position_target_local_ned.type_mask = 3647;
        msg_set_position_target_local_ned.f8345x = f;
        msg_set_position_target_local_ned.f8346y = f2;
        msg_set_position_target_local_ned.f8347z = f3;
        sendMessage(msg_set_position_target_local_ned);
    }

    public void sendMoveBodyXYZ(float f, float f2, float f3) {
        msg_set_position_target_local_ned msg_set_position_target_local_ned = new msg_set_position_target_local_ned();
        msg_set_position_target_local_ned.target_system = getTargetSystem();
        msg_set_position_target_local_ned.target_component = getTargetComponent();
        msg_set_position_target_local_ned.coordinate_frame = 8;
        msg_set_position_target_local_ned.type_mask = 4039;
        msg_set_position_target_local_ned.f8342vx = f;
        msg_set_position_target_local_ned.f8343vy = f2;
        msg_set_position_target_local_ned.f8344vz = f3;
        sendMessage(msg_set_position_target_local_ned);
    }

    public void sendHeartbeat() {
        msg_heartbeat msg_heartbeat = new msg_heartbeat();
        msg_heartbeat.type = 6;
        msg_heartbeat.autopilot = 8;
        msg_heartbeat.system_status = 4;
        msg_heartbeat.base_mode = 192;
        msg_heartbeat.custom_mode = 0;
        msg_heartbeat.mavlink_version = 3;
        sendMessage(msg_heartbeat);
    }

    public void sendTimeSync(long j) {
        msg_timesync msg_timesync = new msg_timesync();
        msg_timesync.ts1 = j;
        msg_timesync.tc1 = System.currentTimeMillis();
        sendMessage(msg_timesync);
    }

    public void sendPing() {
        msg_ping msg_ping = new msg_ping();
        msg_ping.target_component = 1;
        msg_ping.target_system = 1;
        msg_ping.time_usec = System.currentTimeMillis();
        sendMessage(msg_ping);
    }

    public void sendLoiter(double d, double d2, double d3, double d4) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = getTargetSystem();
        msg_command_long.target_component = getTargetComponent();
        msg_command_long.command = 17;
        msg_command_long.confirmation = 0;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = (float) d;
        msg_command_long.param5 = (float) d2;
        msg_command_long.param6 = (float) d3;
        msg_command_long.param7 = (float) d4;
        sendMessage(msg_command_long);
    }

    public void setGeoFence(float f, float f2) {
        setParameter("FENCE_ENABLE", 1.0f, 2);
        setParameter("FENCE_TYPE", 3.0f, 2);
        setParameter("FENCE_ACTION", 1.0f, 2);
        setParameter("FENCE_RADIUS", f, 9);
        setParameter("FENCE_ALT_MAX", f2, 9);
    }

    public void sendSpin(float f, Float f2) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = getTargetSystem();
        msg_command_long.target_component = getTargetComponent();
        msg_command_long.command = MAV_CMD.MAV_CMD_NAV_SET_YAW_SPEED;
        msg_command_long.confirmation = 0;
        msg_command_long.param1 = f;
        msg_command_long.param2 = f2 != null ? f2.floatValue() : 0.01f;
        msg_command_long.param3 = 1.0f;
        String str = TAG;
        Log.d(str, "sendSpin Message " + msg_command_long);
        sendMessage(msg_command_long);
    }

    public void sendChangeCustomMode(int i, ModeChangeCallback modeChangeCallback2) {
        this.modeChangeCallback.set(modeChangeCallback2);
        sendChangeCustomMode(i);
    }

    public void sendChangeCustomMode(int i) {
        sendChangeBaseAndCustomMode(1, Integer.valueOf(i));
    }

    public void sendChangeBaseAndCustomMode(int i, Integer num) {
        msg_set_mode msg_set_mode = new msg_set_mode();
        msg_set_mode.target_system = getTargetSystem();
        msg_set_mode.base_mode = (short) i;
        if (num != null) {
            msg_set_mode.custom_mode = (long) num.intValue();
        }
        sendMessage(msg_set_mode);
    }

    public void sendChangeBaseAndCustomMode(int i, Integer num, ResultCallback<Void> resultCallback) {
        msg_set_mode msg_set_mode = new msg_set_mode();
        msg_set_mode.target_system = getTargetSystem();
        msg_set_mode.base_mode = (short) i;
        if (num != null) {
            msg_set_mode.custom_mode = (long) num.intValue();
        }
        sendMessage(msg_set_mode);
        resultCallback.onResult(null);
    }

    /* access modifiers changed from: protected */
    public short getTargetSystem() {
        if (this.targetSystem == null) {
            return 1;
        }
        return this.targetSystem.shortValue();
    }

    public int getPlatformType() {
        return this.currentType.get();
    }

    public long getCurrentMode() {
        msg_heartbeat msg_heartbeat = (msg_heartbeat) getLatestMessage(msg_heartbeat.class);
        if (msg_heartbeat != null) {
            return msg_heartbeat.custom_mode;
        }
        return 0;
    }

    public void sendArm(boolean z, ArmDisarmCallback armDisarmCallback2) {
        this.armDisarmCallback.set(armDisarmCallback2);
        sendArm(z);
    }

    public boolean isArmed() {
        msg_heartbeat msg_heartbeat = (msg_heartbeat) getLatestMessage(msg_heartbeat.class);
        if (msg_heartbeat != null && ((msg_heartbeat.base_mode & 128) >> 7) == 1) {
            return true;
        }
        return false;
    }

    public short getAutopilotType() {
        msg_heartbeat msg_heartbeat = (msg_heartbeat) getLatestMessage(msg_heartbeat.class);
        if (msg_heartbeat == null) {
            return -1;
        }
        return msg_heartbeat.autopilot;
    }

    public void preventFromArming(boolean z) {
        this.keepThisFromArming.set(z);
    }

    /* access modifiers changed from: protected */
    public void sendArm(boolean z) {
        ManualControlStruct manualControlStruct;
        if (this.keepThisFromArming.get()) {
            Log.d(TAG, "NOT arming because we actively prevented it with a STOP");
        } else if (isArmed() == z) {
            Log.d(TAG, "NOT arming because we're already in the correct state");
        } else {
            if (!z && (manualControlStruct = this.manualControl) != null) {
                manualControlStruct.thrust = 0;
            }
            float f = z ? 1.0f : 0.0f;
            msg_command_long msg_command_long = new msg_command_long();
            msg_command_long.target_system = 1;
            msg_command_long.target_component = 1;
            msg_command_long.command = 400;
            msg_command_long.confirmation = 0;
            msg_command_long.param1 = f;
            msg_command_long.param2 = 0.0f;
            msg_command_long.param3 = 0.0f;
            msg_command_long.param4 = 0.0f;
            msg_command_long.param5 = 0.0f;
            msg_command_long.param6 = 0.0f;
            msg_command_long.param7 = 0.0f;
            sendMessage(msg_command_long);
            Log.d(TAG, "sent arm");
        }
    }

    public void land() {
        ManualControlStruct manualControlStruct = this.manualControl;
        if (manualControlStruct != null) {
            manualControlStruct.init();
        }
        try {
            Thread.sleep(500);
        } catch (Exception unused) {
            Log.e(TAG, "Could not pause for landing");
        }
        this.dialectInterfaceRef.get().land();
    }

    public void setParameter_int(String str, int i) {
        msg_param_set msg_param_set = new msg_param_set();
        msg_param_set.target_system = 1;
        msg_param_set.target_component = 1;
        msg_param_set.setParam_Id(str);
        msg_param_set.param_value = Float.intBitsToFloat(i);
        msg_param_set.param_type = 6;
        sendMessage(msg_param_set);
        String str2 = TAG;
        Log.d(str2, "set parameter " + msg_param_set);
    }

    public void setParameter_float(String str, float f) {
        msg_param_set msg_param_set = new msg_param_set();
        msg_param_set.target_system = 1;
        msg_param_set.target_component = 1;
        msg_param_set.setParam_Id(str);
        msg_param_set.param_value = f;
        msg_param_set.param_type = 9;
        sendMessage(msg_param_set);
        String str2 = TAG;
        Log.d(str2, "set parameter " + msg_param_set);
    }

    public void setParameter(String str, float f, int i) {
        if (i == 9) {
            setParameter_float(str, f);
        } else if (i == 6) {
            setParameter_int(str, (int) f);
        }
    }

    /* access modifiers changed from: protected */
    public void setTakeoffCallback(TakeoffCallback takeoffCallback2) {
        this.takeoffCallback.set(takeoffCallback2);
    }

    public void startTakeoffProcess(Double d, TakeoffCallback takeoffCallback2) {
        this.manualControl = null;
        this.dialectInterfaceRef.get().startTakeoffProcess(d, takeoffCallback2);
    }

    public void sendClearMission() {
        msg_mission_clear_all msg_mission_clear_all = new msg_mission_clear_all();
        msg_mission_clear_all.target_system = getTargetSystem();
        msg_mission_clear_all.target_component = getTargetComponent();
        sendMessage(msg_mission_clear_all);
    }

    public void sendGimbalPoseLLA(double d, double d2, double d3, boolean z) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = 1;
        msg_command_long.target_component = 1;
        msg_command_long.command = 205;
        msg_command_long.param1 = Float.NaN;
        msg_command_long.param2 = Float.NaN;
        msg_command_long.param3 = Float.NaN;
        msg_command_long.param4 = (float) (d3 / 1000.0d);
        msg_command_long.param5 = (float) d;
        msg_command_long.param6 = (float) d2;
        msg_command_long.param7 = 4.0f;
        sendMessage(msg_command_long);
        sendMessage(msg_command_long);
        sendMessage(msg_command_long);
        if (!z) {
            try {
                Thread.sleep(1000);
                MavLinkDialectInterface.GimbalPosePRYYa<Double> cameraOrientation = getCameraOrientation();
                sendGimbalPosePRY(((Double) cameraOrientation.pitch).doubleValue(), ((Double) cameraOrientation.roll).doubleValue(), ((Double) cameraOrientation.yaw).doubleValue());
            } catch (Exception e) {
                Log.e(TAG, "Couldn't sleep", e);
            }
        }
    }

    public void sendGimbalPosePRY(double d, double d2, double d3) {
        this.dialectInterfaceRef.get().sendGimbalPosePRY(d, d2, d3);
    }

    public void sendSetROI(double d, double d2, double d3) {
        msg_command_int msg_command_int = new msg_command_int();
        if (Double.isNaN(d) || Double.isNaN(d2)) {
            MavLinkDialectInterface.GimbalPosePRYYa<Double> cameraOrientation = getCameraOrientation();
            msg_command_int.target_system = 1;
            msg_command_int.target_component = 1;
            msg_command_int.command = MAV_CMD.MAV_CMD_DO_SET_ROI_NONE;
            msg_command_int.frame = 0;
            msg_command_int.current = 1;
            msg_command_int.autocontinue = 0;
            msg_command_int.f8259x = Integer.MIN_VALUE;
            msg_command_int.f8260y = Integer.MIN_VALUE;
            msg_command_int.f8261z = Float.NaN;
            sendMessage(msg_command_int);
            sendMessage(msg_command_int);
            sendGimbalPosePRY(((Double) cameraOrientation.pitch).doubleValue(), ((Double) cameraOrientation.roll).doubleValue(), ((Double) cameraOrientation.yaw).doubleValue());
            return;
        }
        msg_home_position msg_home_position = (msg_home_position) getLatestMessage(msg_home_position.class);
        msg_command_int.target_system = 1;
        msg_command_int.target_component = 1;
        msg_command_int.command = 195;
        msg_command_int.frame = 0;
        msg_command_int.current = 1;
        msg_command_int.f8259x = (int) (d * 1.0E7d);
        msg_command_int.f8260y = (int) (d2 * 1.0E7d);
        if (msg_home_position == null) {
            msg_command_int.f8261z = 0.0f;
        } else {
            msg_command_int.f8261z = (float) (msg_home_position.altitude / 1000);
        }
        sendMessage(msg_command_int);
        sendMessage(msg_command_int);
    }

    public void sendSetBearing(double d, float f, boolean z, boolean z2) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = getTargetSystem();
        msg_command_long.target_component = getTargetComponent();
        msg_command_long.command = 115;
        msg_command_long.param1 = (float) d;
        msg_command_long.param2 = f;
        float f2 = 1.0f;
        msg_command_long.param3 = z ? 1.0f : -1.0f;
        if (z2) {
            f2 = 0.0f;
        }
        msg_command_long.param4 = f2;
        sendMessage(msg_command_long);
    }

    public void moveGuided(float f, float f2, float f3) {
        this.moveGuidedTarget = new float[]{f, f2, f3};
        this.dialectInterfaceRef.get().moveGuided(f, f2, f3);
    }

    public void orbit(float f, float f2, float f3, float f4) {
        this.dialectInterfaceRef.get().orbit(f, f2, f3, f4);
    }

    public boolean isInPositionHoldMode() {
        return this.dialectInterfaceRef.get().inPositionHoldMode();
    }

    public boolean isInMissionMode() {
        return this.dialectInterfaceRef.get().isInMissionMode();
    }

    public String getModeString() {
        if (this.dialectInterfaceRef.get() != null) {
            return this.dialectInterfaceRef.get().getModeString();
        }
        return Long.toString(getCurrentMode());
    }

    public void enterMissionMode(ResultCallback<Void> resultCallback) {
        this.dialectInterfaceRef.get().enterMissionMode(resultCallback);
    }

    public void enterReturnToHomeMode(ResultCallback<Void> resultCallback) {
        this.dialectInterfaceRef.get().enterReturnToHomeMode(resultCallback);
    }

    public void flyRoute(List<msg_mission_item> list, final ResultCallback<Void> resultCallback) {
        final float f = list.get(0).f8321z;
        try {
            this.missionItemCount = list.size();
            uploadMission(list, new Runnable() {
                public void run() {
                    Log.d(MavLinkThread.TAG, "MavlinkVehicle: Route mission uploaded successfully");
                    try {
                        MavLinkThread.this.ensureInitialized(MavlinkVehicle.InitializationParameters.createFromSingleAlt(f), new MavlinkVehicle.InitializationCallback() {
                            /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|4|5|8) */
                            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
                                r0 = move-exception;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
                                com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.handleExceptionCallback(r0, r4);
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
                                return;
                             */
                            /* JADX WARNING: Failed to process nested try/catch */
                            /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0008 */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public void initializeSuccess() {
                                /*
                                    r2 = this;
                                    r0 = 2000(0x7d0, double:9.88E-321)
                                    java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x0008 }
                                    goto L_0x0008
                                L_0x0006:
                                    r0 = move-exception
                                    goto L_0x0014
                                L_0x0008:
                                    com.bbn.ccast.mavlink.MavLinkThread$2 r0 = com.bbn.ccast.mavlink.MavLinkThread.C50972.this     // Catch:{ IOException -> 0x0006 }
                                    com.bbn.ccast.mavlink.MavLinkThread r0 = com.bbn.ccast.mavlink.MavLinkThread.this     // Catch:{ IOException -> 0x0006 }
                                    com.bbn.ccast.mavlink.MavLinkThread$2 r1 = com.bbn.ccast.mavlink.MavLinkThread.C50972.this     // Catch:{ IOException -> 0x0006 }
                                    com.bbn.vehicleinterface.types.ResultCallback r1 = r4     // Catch:{ IOException -> 0x0006 }
                                    r0.enterMissionMode(r1)     // Catch:{ IOException -> 0x0006 }
                                    goto L_0x001b
                                L_0x0014:
                                    com.bbn.ccast.mavlink.MavLinkThread$2 r1 = com.bbn.ccast.mavlink.MavLinkThread.C50972.this
                                    com.bbn.vehicleinterface.types.ResultCallback r1 = r4
                                    com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.handleExceptionCallback(r0, r1)
                                L_0x001b:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.MavLinkThread.C50972.C50981.initializeSuccess():void");
                            }

                            public void initializationFailed(String str) {
                                MavlinkVehicle.handleErrorReason("FlyRouteInitializationFailed", str, resultCallback);
                            }
                        }, resultCallback);
                    } catch (IOException e) {
                        MavlinkVehicle.handleExceptionCallback(e, resultCallback);
                    }
                }
            });
        } catch (IOException e) {
            MavlinkVehicle.handleExceptionCallback(e, resultCallback);
        }
    }

    private void takeoffAndNotify(final Double d, final TakeoffCallback takeoffCallback2) {
        this.takeoffCancelledOrCompleted.set(false);
        final C50993 r0 = new TakeoffCallback() {
            public void onSuccess() {
                MavLinkThread.this.takeoffCancelledOrCompleted.set(true);
                takeoffCallback2.onSuccess();
            }

            public void onFailure(int i) {
                String access$000 = MavLinkThread.TAG;
                Log.d(access$000, "Unable to takeoff " + i);
            }
        };
        new Thread() {
            public void run() {
                while (!MavLinkThread.this.inAir() && !MavLinkThread.this.takeoffCancelledOrCompleted.get()) {
                    try {
                        MavLinkThread.this.enterPositionHoldMode();
                        MavLinkThread.this.startTakeoffProcess(d, r0);
                        Thread.sleep(HeartBeat.HEARTBEAT_NORMAL_TIMEOUT);
                    } catch (Exception e) {
                        Log.e(MavLinkThread.TAG, "error", e);
                    }
                }
            }
        }.start();
    }

    public void enterPositionHoldMode() {
        ManualControlStruct manualControlStruct = this.manualControl;
        if (manualControlStruct != null) {
            manualControlStruct.init();
        }
        this.dialectInterfaceRef.get().enterPositionHoldMode();
    }

    public void changeAltitude(float f) {
        ManualControlStruct manualControlStruct = this.manualControl;
        if (manualControlStruct != null) {
            manualControlStruct.init();
        }
        this.dialectInterfaceRef.get().changeAltitude(f);
    }

    /* access modifiers changed from: private */
    public void ensureInitialized(MavlinkVehicle.InitializationParameters initializationParameters, final MavlinkVehicle.InitializationCallback initializationCallback, ResultCallback resultCallback) {
        if (!this.dialectInterfaceRef.get().inPositionHoldMode()) {
            this.dialectInterfaceRef.get().enterPositionHoldMode();
        }
        if (inAir() && initializationCallback != null) {
            initializationCallback.initializeSuccess();
        }
        takeoffAndNotify(initializationParameters.minAltitudeMetersAgl, new TakeoffCallback() {
            public void onSuccess() {
                MavlinkVehicle.InitializationCallback initializationCallback = initializationCallback;
                if (initializationCallback != null) {
                    initializationCallback.initializeSuccess();
                }
            }

            public void onFailure(int i) {
                MavlinkVehicle.InitializationCallback initializationCallback = initializationCallback;
                if (initializationCallback != null) {
                    initializationCallback.initializationFailed("error code: " + i);
                }
            }
        });
    }

    public void armSafetyOn() {
        sendChangeBaseAndCustomMode(128, 1);
    }

    public void armSafetyOff() {
        sendChangeBaseAndCustomMode(128, 0);
    }

    public void uploadMission(List<msg_mission_item> list, Runnable runnable) {
        String str = TAG;
        Log.d(str, "Clearing any existing missions");
        Log.d(str, "Setting current mission");
        this.currentMission.set(list);
        this.highestMissionWaypointUploaded.set(0);
        this.onUploadSuccess.set(runnable);
        Log.d(str, "Uploading Mission Count: " + list.size());
        msg_mission_count msg_mission_count = new msg_mission_count();
        msg_mission_count.target_system = getTargetSystem();
        msg_mission_count.target_component = getTargetComponent();
        msg_mission_count.count = list.size();
        sendMessage(msg_mission_count);
    }

    public void sendManualControl(short s, short s2, short s3, short s4, int i) {
        if (this.manualControl == null) {
            this.manualControl = new ManualControlStruct();
        }
        this.manualControl.roll = s;
        this.manualControl.pitch = s2;
        this.manualControl.yaw = s3;
        this.manualControl.thrust = s4;
        this.manualControl.time = System.currentTimeMillis();
        sendManualControl();
    }

    public boolean sendManualControl() {
        if (this.manualControl == null) {
            return false;
        }
        msg_manual_control msg_manual_control = new msg_manual_control();
        if (this.decay_control && System.currentTimeMillis() - this.manualControl.time > 800) {
            if (Math.abs(this.manualControl.roll) > 0) {
                ManualControlStruct manualControlStruct = this.manualControl;
                manualControlStruct.roll = (short) ((int) (((double) manualControlStruct.roll) * 0.98d));
            }
            if (Math.abs(this.manualControl.pitch) > 0) {
                ManualControlStruct manualControlStruct2 = this.manualControl;
                manualControlStruct2.pitch = (short) ((int) (((double) manualControlStruct2.pitch) * 0.98d));
            }
            if (Math.abs(this.manualControl.yaw) > 0) {
                ManualControlStruct manualControlStruct3 = this.manualControl;
                manualControlStruct3.yaw = (short) ((int) (((double) manualControlStruct3.yaw) * 0.98d));
            }
            if (Math.abs(this.manualControl.thrust - 500) > 0) {
                ManualControlStruct manualControlStruct4 = this.manualControl;
                manualControlStruct4.thrust = (short) ((int) ((((double) (manualControlStruct4.thrust - 500)) * 0.98d) + 500.0d));
            }
        }
        msg_manual_control.f8317y = this.manualControl.roll;
        msg_manual_control.f8316x = this.manualControl.pitch;
        msg_manual_control.f8315r = this.manualControl.yaw;
        msg_manual_control.f8318z = this.manualControl.thrust;
        msg_manual_control.buttons = 0;
        msg_manual_control.target = getTargetSystem();
        sendMessage(msg_manual_control);
        return true;
    }

    public boolean receivedAllParameters() {
        return this.mavlink_parameters.size() >= this.totalNumParams.get();
    }

    public void initialize(final boolean z, final OnInitializationCallback onInitializationCallback) {
        new Thread() {
            public void run() {
                try {
                    MavLinkThread.this.sendHeartbeat();
                    MavLinkThread.this.sendRequestAutoPilotCapabilities();
                    MavLinkThread.this.sendRequestProtocolVersion();
                    MavLinkThread.this.sendRequestVideoStreamInformation();
                    if (z) {
                        MavLinkThread.this.sendRequestParams();
                        OnInitializationCallback onInitializationCallback = onInitializationCallback;
                        if (onInitializationCallback != null) {
                            MavLinkThread.this.blockForParameters(40, onInitializationCallback);
                        }
                    } else {
                        OnInitializationCallback onInitializationCallback2 = onInitializationCallback;
                        if (onInitializationCallback2 != null) {
                            onInitializationCallback2.onFinished(0);
                        }
                    }
                    MavLinkThread.this.requestDataStream();
                } catch (IOException e) {
                    OnInitializationCallback onInitializationCallback3 = onInitializationCallback;
                    if (onInitializationCallback3 != null) {
                        onInitializationCallback3.onError("Initialization Exception", e);
                    }
                }
                Log.d(MavLinkThread.TAG, "Finished initialization.");
            }
        }.start();
    }

    public void setHomePosition(double d, double d2, double d3) {
        try {
            msg_home_position msg_home_position = (msg_home_position) getLatestMessage(msg_home_position.class);
            if (msg_home_position != null && Math.abs(msg_home_position.altitude / 1000) < 1) {
                d3 = (double) (msg_home_position.altitude / 1000);
            }
            msg_command_long msg_command_long = new msg_command_long();
            msg_command_long.target_component = getTargetComponent();
            msg_command_long.target_system = getTargetSystem();
            msg_command_long.command = 179;
            msg_command_long.confirmation = 0;
            msg_command_long.param1 = 0.0f;
            msg_command_long.param4 = 0.0f;
            msg_command_long.param5 = (float) d;
            msg_command_long.param6 = (float) d2;
            msg_command_long.param7 = (float) d3;
            sendMessage(msg_command_long);
        } catch (Exception unused) {
        }
    }

    public void setGpsGlobalOrigin(double d, double d2, double d3) {
        try {
            msg_set_gps_global_origin msg_set_gps_global_origin = new msg_set_gps_global_origin();
            msg_set_gps_global_origin.target_system = getTargetSystem();
            msg_set_gps_global_origin.latitude = (int) (d * 1.0E7d);
            msg_set_gps_global_origin.longitude = (int) (d2 * 1.0E7d);
            msg_set_gps_global_origin.altitude = ((int) d3) * 1000;
            sendMessage(msg_set_gps_global_origin);
            sendMessage(msg_set_gps_global_origin);
        } catch (Exception unused) {
        }
    }

    public void blockForParameters(int i, OnInitializationCallback onInitializationCallback) {
        long currentTimeMillis = System.currentTimeMillis();
        this.totalNumParams.set(0);
        while (!receivedAllParameters()) {
            if (System.currentTimeMillis() - currentTimeMillis <= ((long) (i * 1000))) {
                if (onInitializationCallback != null) {
                    onInitializationCallback.onProgressUpdate(this.totalNumParams.get(), getParameters().size());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException unused) {
                }
            } else if (onInitializationCallback != null) {
                onInitializationCallback.onError("Timeout fetching parameters", (Throwable) null);
                return;
            } else {
                return;
            }
        }
        if (onInitializationCallback != null) {
            onInitializationCallback.onFinished(getParameters().size());
        }
    }

    public Float getParamValue(String str) {
        return this.mavlink_parameters.get(str);
    }

    public Map<String, Float> getParameters() {
        return this.mavlink_parameters;
    }

    private <T extends MAVLinkMessage> void updateLatest(T t) {
        synchronized (this.latestMessages) {
            this.latestMessages.put(t.getClass(), t);
        }
    }

    public <T extends MAVLinkMessage> T getLatestMessage(Class<T> cls) {
        T t;
        synchronized (this.latestMessages) {
            MAVLinkMessage mAVLinkMessage = (MAVLinkMessage) this.latestMessages.get(cls);
            t = mAVLinkMessage != null ? (MAVLinkMessage) cls.cast(mAVLinkMessage) : null;
        }
        return t;
    }

    public boolean inAir() {
        return this.dialectInterfaceRef.get().inAir();
    }

    public boolean isTakingOff() {
        msg_extended_sys_state msg_extended_sys_state = (msg_extended_sys_state) getLatestMessage(msg_extended_sys_state.class);
        if (msg_extended_sys_state != null && msg_extended_sys_state.landed_state == 3) {
            return true;
        }
        return false;
    }

    public GeoPosition getDronePosition_HAL() {
        msg_global_position_int msg_global_position_int = (msg_global_position_int) getLatestMessage(msg_global_position_int.class);
        if (msg_global_position_int == null) {
            return null;
        }
        double pow = ((double) msg_global_position_int.lat) / Math.pow(10.0d, 7.0d);
        return new GeoPosition(pow, ((double) msg_global_position_int.lon) / Math.pow(10.0d, 7.0d), ((double) msg_global_position_int.relative_alt) / 1000.0d, GeoPosition.AltitudeReference.AGL);
    }

    public GeoPosition getDronePosition_MSL() {
        msg_global_position_int msg_global_position_int = (msg_global_position_int) getLatestMessage(msg_global_position_int.class);
        if (msg_global_position_int == null) {
            return null;
        }
        double pow = ((double) msg_global_position_int.lat) / Math.pow(10.0d, 7.0d);
        return new GeoPosition(pow, ((double) msg_global_position_int.lon) / Math.pow(10.0d, 7.0d), ((double) msg_global_position_int.alt) / 1000.0d, GeoPosition.AltitudeReference.MSL);
    }

    public GeoPosition getHomePosition() {
        msg_home_position msg_home_position = (msg_home_position) getLatestMessage(msg_home_position.class);
        if (msg_home_position == null) {
            return null;
        }
        double pow = ((double) msg_home_position.latitude) / Math.pow(10.0d, 7.0d);
        return new GeoPosition(pow, ((double) msg_home_position.longitude) / Math.pow(10.0d, 7.0d), ((double) msg_home_position.altitude) / 1000.0d, GeoPosition.AltitudeReference.MSL);
    }

    public void addMissionItemListener(MissionItemReachedCallback missionItemReachedCallback) {
        this.missionItemReachedCallbackList.add(missionItemReachedCallback);
    }

    public void removeMissionItemListener(MissionItemReachedCallback missionItemReachedCallback) {
        this.missionItemReachedCallbackList.remove(missionItemReachedCallback);
    }

    public void addSettingsListener(MavLinkParameterChangedCallback mavLinkParameterChangedCallback) {
        this.parameterChangedCallbackList.add(mavLinkParameterChangedCallback);
    }

    public void removeSettingsListener(MavLinkParameterChangedCallback mavLinkParameterChangedCallback) {
        this.parameterChangedCallbackList.remove(mavLinkParameterChangedCallback);
    }

    public void addTelemetryListener(MavLinkTelemetryCallback mavLinkTelemetryCallback) {
        synchronized (this.telemetryCallbackList) {
            this.telemetryCallbackList.add(mavLinkTelemetryCallback);
        }
    }

    public void removeTelemetryListener(MavLinkTelemetryCallback mavLinkTelemetryCallback) {
        synchronized (this.telemetryCallbackList) {
            this.telemetryCallbackList.remove(mavLinkTelemetryCallback);
        }
    }

    public String[] getModes() {
        return this.dialectInterfaceRef.get().getModes();
    }

    public void changeSpeed(float f) {
        msg_command_int msg_command_int = new msg_command_int();
        msg_command_int.target_system = 1;
        msg_command_int.target_component = 1;
        msg_command_int.current = 0;
        msg_command_int.autocontinue = 0;
        msg_command_int.command = 178;
        msg_command_int.param1 = 0.0f;
        msg_command_int.param2 = f;
        msg_command_int.param3 = -1.0f;
        msg_command_int.param4 = 0.0f;
        try {
            sendMessage(msg_command_int);
        } catch (IOException e) {
            Log.e(TAG, "error", e);
        }
    }

    public static void main(String[] strArr) {
        MavLinkThread mavLinkThread = new MavLinkThread(new UdpMavlinkTransport("0.0.0.0", 14550));
        mavLinkThread.start();
        boolean z = false;
        while (!z) {
            String str = TAG;
            Log.d(str, "Waiting for heartbeat");
            boolean waitHeartbeat = mavLinkThread.waitHeartbeat(Integer.valueOf(C0827sg.f6324a));
            Log.d(str, "Done waiting for heartbeat");
            z = waitHeartbeat;
        }
        String str2 = TAG;
        Log.d(str2, "Got Heartbeat!");
        Log.d(str2, "Initializing");
        mavLinkThread.initialize(false, new OnInitializationCallback() {
            public void onFinished(int i) {
                String access$000 = MavLinkThread.TAG;
                Log.d(access$000, "Initialization completed with " + i + " parameters");
            }

            public void onProgressUpdate(int i, int i2) {
                String access$000 = MavLinkThread.TAG;
                Log.d(access$000, "Param Progress = " + ((((float) i2) / ((float) i)) * 100.0f) + "%");
            }

            public void onError(String str, Throwable th) {
                String access$000 = MavLinkThread.TAG;
                Log.d(access$000, "Initialization Error: " + str + ": " + th);
            }
        });
    }

    public MavLinkDialectInterface.GimbalPosePRYYa<Double> getCameraOrientation() {
        return this.dialectInterfaceRef.get().getCameraOrientation();
    }

    protected static class HeartBeatProducer implements Runnable {
        private final MavLinkThread mavLinkThread;

        public HeartBeatProducer(MavLinkThread mavLinkThread2) {
            this.mavLinkThread = mavLinkThread2;
        }

        public void run() {
            Log.d(MavLinkThread.TAG, "Starting the Mavlink Heartbeat producer");
            try {
                System.currentTimeMillis();
                while (!Thread.interrupted()) {
                    try {
                        this.mavLinkThread.sendHeartbeat();
                        if (this.mavLinkThread.isConnected() && System.currentTimeMillis() % 40000 <= 1900) {
                            this.mavLinkThread.requestDataStream();
                        }
                    } catch (IOException e) {
                        Log.d(MavLinkThread.TAG, "Mavlink could not send heartbeat", e);
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException unused) {
                Log.d(MavLinkThread.TAG, "Hearbeat thread interrupted");
            }
        }
    }

    protected static class ManualControlProducer implements Runnable {
        private final MavLinkThread mavLinkThread;

        public ManualControlProducer(MavLinkThread mavLinkThread2) {
            this.mavLinkThread = mavLinkThread2;
        }

        public void run() {
            Log.d(MavLinkThread.TAG, "Starting the Mavlink ManualControl producer");
            try {
                System.currentTimeMillis();
                while (!Thread.interrupted()) {
                    try {
                        if (this.mavLinkThread.sendManualControl()) {
                            Thread.sleep(50);
                        }
                    } catch (IOException e) {
                        Log.d(MavLinkThread.TAG, "Mavlink could not send Manual Control", e);
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException unused) {
                Log.d(MavLinkThread.TAG, "Manual Control thread interrupted");
            }
        }
    }

    public String getParamName(MavLinkDialectInterface.ParamSettings paramSettings) {
        return this.dialectInterfaceRef.get() != null ? this.dialectInterfaceRef.get().getParamName(paramSettings) : "";
    }

    public void requestDataStream() {
        if (this.dialectInterfaceRef.get() != null && (this.dialectInterfaceRef.get() instanceof ArduPilotDialect)) {
            ArduPilotDialect.requestDataStream(this);
        }
    }

    public double getRoll() {
        msg_attitude msg_attitude = (msg_attitude) getLatestMessage(msg_attitude.class);
        if (msg_attitude != null) {
            return Math.toDegrees((double) msg_attitude.roll);
        }
        return Double.NaN;
    }

    public double getPitch() {
        msg_attitude msg_attitude = (msg_attitude) getLatestMessage(msg_attitude.class);
        if (msg_attitude != null) {
            return Math.toDegrees((double) msg_attitude.pitch);
        }
        return Double.NaN;
    }

    public double getYaw() {
        msg_attitude msg_attitude = (msg_attitude) getLatestMessage(msg_attitude.class);
        if (msg_attitude == null) {
            return Double.NaN;
        }
        double degrees = Math.toDegrees((double) msg_attitude.yaw);
        return degrees < 0.0d ? Math.floor(degrees + 360.0d) : degrees;
    }

    public double getHDop() {
        msg_gps_raw_int msg_gps_raw_int = (msg_gps_raw_int) getLatestMessage(msg_gps_raw_int.class);
        if (msg_gps_raw_int != null) {
            return (double) msg_gps_raw_int.eph;
        }
        return Double.NaN;
    }

    public double getVDop() {
        msg_gps_raw_int msg_gps_raw_int = (msg_gps_raw_int) getLatestMessage(msg_gps_raw_int.class);
        if (msg_gps_raw_int != null) {
            return (double) msg_gps_raw_int.epv;
        }
        return Double.NaN;
    }

    public int getNumGpsSatellites() {
        msg_gps_raw_int msg_gps_raw_int = (msg_gps_raw_int) getLatestMessage(msg_gps_raw_int.class);
        if (msg_gps_raw_int != null) {
            return msg_gps_raw_int.satellites_visible;
        }
        return 0;
    }

    public double getRssi() {
        msg_radio_status msg_radio_status = (msg_radio_status) getLatestMessage(msg_radio_status.class);
        if (msg_radio_status != null) {
            return (((double) msg_radio_status.remrssi) / 1.9d) - 127.0d;
        }
        return Double.NaN;
    }

    public double getBatteryPercent() {
        msg_battery_status msg_battery_status = (msg_battery_status) getLatestMessage(msg_battery_status.class);
        if (msg_battery_status != null) {
            return (double) msg_battery_status.battery_remaining;
        }
        return Double.NaN;
    }

    public double getBatteryVoltage() {
        msg_sys_status msg_sys_status = (msg_sys_status) getLatestMessage(msg_sys_status.class);
        if (msg_sys_status != null) {
            return (double) (msg_sys_status.voltage_battery / 1000);
        }
        return Double.NaN;
    }

    public double getCourse() {
        msg_gps_raw_int msg_gps_raw_int = (msg_gps_raw_int) getLatestMessage(msg_gps_raw_int.class);
        if (msg_gps_raw_int != null) {
            return ((double) msg_gps_raw_int.cog) / 100.0d;
        }
        return Double.NaN;
    }

    public double getHeading() {
        msg_global_position_int msg_global_position_int = (msg_global_position_int) getLatestMessage(msg_global_position_int.class);
        if (msg_global_position_int != null) {
            return ((double) msg_global_position_int.hdg) / 100.0d;
        }
        return Double.NaN;
    }

    public double getSpeed() {
        msg_global_position_int msg_global_position_int = (msg_global_position_int) getLatestMessage(msg_global_position_int.class);
        if (msg_global_position_int != null) {
            return Math.sqrt((double) (((msg_global_position_int.f8267vx * msg_global_position_int.f8267vx) + (msg_global_position_int.f8268vy * msg_global_position_int.f8268vy)) + (msg_global_position_int.f8269vz * msg_global_position_int.f8269vz))) / 100.0d;
        }
        return Double.NaN;
    }

    public void setMode(String str) {
        this.dialectInterfaceRef.get().setMode(str);
    }

    public String getPlatformSerial() {
        msg_autopilot_version msg_autopilot_version = (msg_autopilot_version) getLatestMessage(msg_autopilot_version.class);
        if (msg_autopilot_version == null) {
            return null;
        }
        try {
            String valueOf = String.valueOf(msg_autopilot_version.uid);
            if ("5283920058631409231".equals(valueOf)) {
                return null;
            }
            if ("1".equals(valueOf)) {
                return null;
            }
            return valueOf;
        } catch (Exception unused) {
            return null;
        }
    }

    public void setDialect(String str) {
        int i = C51048.f8510xbc182f08[MavLinkDialectInterface.dialectType.fromValue(str).ordinal()];
        if (i == 1) {
            Log.d(TAG, "Forcing ArduPilot flightstack.");
            this.dialectInterfaceRef.set(new ArduPilotDialect(this));
        } else if (i == 2) {
            Log.d(TAG, "Forcing PX4 flightstack.");
            this.dialectInterfaceRef.set(new Px4Dialect(this));
        }
    }

    /* renamed from: com.bbn.ccast.mavlink.MavLinkThread$8 */
    /* synthetic */ class C51048 {

        /* renamed from: $SwitchMap$com$bbn$ccast$mavlink$MavLinkDialectInterface$dialectType */
        static final /* synthetic */ int[] f8510xbc182f08;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bbn.ccast.mavlink.MavLinkDialectInterface$dialectType[] r0 = com.bbn.ccast.mavlink.MavLinkDialectInterface.dialectType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8510xbc182f08 = r0
                com.bbn.ccast.mavlink.MavLinkDialectInterface$dialectType r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.dialectType.APM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8510xbc182f08     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$dialectType r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.dialectType.PX4     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8510xbc182f08     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$dialectType r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.dialectType.AUTO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.MavLinkThread.C51048.<clinit>():void");
        }
    }

    public void startCompassCalibration() {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.command = 241;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 1.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = 0.0f;
        sendMessage(msg_command_long);
    }

    public void setZoomStep(int i) {
        if (i > 1) {
            i = 1;
        } else if (i < -1) {
            i = -1;
        }
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = getTargetSystem();
        msg_command_long.target_component = 100;
        msg_command_long.command = 531;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = (float) i;
        msg_command_long.param3 = Float.NaN;
        msg_command_long.param4 = Float.NaN;
        msg_command_long.param5 = Float.NaN;
        msg_command_long.param6 = Float.NaN;
        msg_command_long.param7 = Float.NaN;
        sendMessage(msg_command_long);
        sendMessage(msg_command_long);
    }

    public void setZoomContinuous(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < -1.0f) {
            f = -1.0f;
        }
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = getTargetSystem();
        msg_command_long.target_component = 100;
        msg_command_long.command = 531;
        msg_command_long.param1 = 1.0f;
        msg_command_long.param2 = f;
        msg_command_long.param3 = Float.NaN;
        msg_command_long.param4 = Float.NaN;
        msg_command_long.param5 = Float.NaN;
        msg_command_long.param6 = Float.NaN;
        msg_command_long.param7 = Float.NaN;
        sendMessage(msg_command_long);
        sendMessage(msg_command_long);
    }

    public boolean sendGimbalPitchYaw(short s, short s2) {
        msg_manual_control msg_manual_control = new msg_manual_control();
        msg_manual_control.f8317y = 0;
        msg_manual_control.f8316x = s;
        msg_manual_control.f8315r = s2;
        msg_manual_control.f8318z = 0;
        msg_manual_control.buttons = 0;
        msg_manual_control.target = 154;
        sendMessage(msg_manual_control);
        return true;
    }
}
