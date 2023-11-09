package com.bbn.ccast.mavlink;

import atakplugin.UASTool.C0827sg;
import com.atakmap.android.uastool.MAVLink.ardupilotmega.msg_mount_status;
import com.atakmap.android.uastool.MAVLink.common.msg_command_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_command_long;
import com.atakmap.android.uastool.MAVLink.common.msg_extended_sys_state;
import com.atakmap.android.uastool.MAVLink.common.msg_global_position_int;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.MAVLink.common.msg_set_position_target_global_int;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import com.atakmap.coremap.log.Log;
import com.bbn.ccast.mavlink.MavLinkDialectInterface;
import com.bbn.ccast.mavlink.MavLinkThread;
import com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle;
import com.bbn.vehicleinterface.types.GeoPosition;
import com.bbn.vehicleinterface.types.ResultCallback;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ArduPilotDialect implements MavLinkDialectInterface {
    /* access modifiers changed from: private */
    public static final String TAG = "ArduPilotDialect";
    AtomicBoolean isInTakeoffProcess = new AtomicBoolean(false);
    protected MavLinkThread mavlinkThread;

    public void orbit(float f, float f2, float f3, float f4) {
    }

    public ArduPilotDialect(MavLinkThread mavLinkThread) {
        this.mavlinkThread = mavLinkThread;
    }

    public void land() {
        Log.d(TAG, "land()");
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = this.mavlinkThread.getTargetSystem();
        msg_command_long.target_component = this.mavlinkThread.getTargetComponent();
        msg_command_long.command = 21;
        msg_command_long.confirmation = 0;
        this.mavlinkThread.sendMessage(msg_command_long);
    }

    /* access modifiers changed from: protected */
    public void sendTakeoff(Double d, boolean z, MavLinkThread.TakeoffCallback takeoffCallback) {
        String str = TAG;
        Log.d(str, "sendTakeoff(altitudeMetersAgl " + d + ")");
        this.mavlinkThread.setTakeoffCallback(takeoffCallback);
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = this.mavlinkThread.getTargetSystem();
        msg_command_long.target_component = 1;
        msg_command_long.command = 22;
        msg_command_long.confirmation = 0;
        msg_command_long.param1 = 0.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = 0.0f;
        msg_command_long.param5 = 0.0f;
        msg_command_long.param6 = 0.0f;
        msg_command_long.param7 = (float) d.intValue();
        this.mavlinkThread.sendMessage(msg_command_long);
        Log.d(str, "sent takeoff");
    }

    /* access modifiers changed from: protected */
    public void changetoGuided(MavLinkDialectInterface.CustomSoloMode customSoloMode) {
        String str = TAG;
        Log.d(str, "changetoGuided(CustomSoloMode " + customSoloMode.toString() + ")");
        try {
            this.mavlinkThread.sendChangeBaseAndCustomMode(9, Integer.valueOf(customSoloMode.getValue()), new ResultCallback<Void>() {
                public void onStart() {
                }

                public void onResult(Void voidR) {
                    try {
                        Thread.sleep(1500);
                        Log.d(ArduPilotDialect.TAG, "Mode change good");
                    } catch (Exception e) {
                        Log.e(ArduPilotDialect.TAG, "error", e);
                    }
                }

                public void onError(String str) {
                    Log.e(ArduPilotDialect.TAG, "Unable to change mode. ");
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
    }

    /* access modifiers changed from: protected */
    public void changetoGuided(MavLinkDialectInterface.CustomRoverMode customRoverMode) {
        String str = TAG;
        Log.d(str, "changetoGuided(CustomRoverMode " + customRoverMode.toString() + ")");
        try {
            this.mavlinkThread.sendChangeBaseAndCustomMode(9, Integer.valueOf(customRoverMode.getValue()), new ResultCallback<Void>() {
                public void onStart() {
                }

                public void onResult(Void voidR) {
                    try {
                        Thread.sleep(1500);
                        Log.d(ArduPilotDialect.TAG, "Mode change good");
                    } catch (Exception e) {
                        Log.e(ArduPilotDialect.TAG, "error", e);
                    }
                }

                public void onError(String str) {
                    Log.e(ArduPilotDialect.TAG, "Unable to change mode. ");
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
    }

    /* access modifiers changed from: protected */
    public void sendArmAndTakeoffHelper(final boolean z, final Double d, final MavLinkThread.TakeoffCallback takeoffCallback) {
        String str = TAG;
        Log.d(str, "sendArmAndTakeoffHelper(arm " + z + ")");
        try {
            this.mavlinkThread.sendArm(z, new MavLinkThread.ArmDisarmCallback() {
                public void armDisarmSuccess() {
                    try {
                        Thread.sleep(3500);
                        Log.d(ArduPilotDialect.TAG, "Arm good");
                        if (z) {
                            ArduPilotDialect.this.doTakeoff(d, takeoffCallback);
                        }
                    } catch (Exception e) {
                        Log.e(ArduPilotDialect.TAG, "error", e);
                    }
                }

                public void armDisarmFailure(int i) {
                    ArduPilotDialect.this.isInTakeoffProcess.set(false);
                    MavLinkThread.TakeoffCallback takeoffCallback = takeoffCallback;
                    if (takeoffCallback != null) {
                        takeoffCallback.onFailure(i);
                        Log.d(ArduPilotDialect.TAG, "arm bad");
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
    }

    public void startTakeoffProcess(Double d, MavLinkThread.TakeoffCallback takeoffCallback) {
        if (!this.isInTakeoffProcess.getAndSet(true)) {
            if (this.mavlinkThread.getCurrentMode() != ((long) MavLinkDialectInterface.CustomSoloMode.GUIDED.getValue())) {
                Log.d(TAG, "MVT. Changing to Guided");
                changetoGuided(MavLinkDialectInterface.CustomSoloMode.GUIDED);
            }
            if (this.mavlinkThread.isArmed()) {
                if (this.mavlinkThread.getCurrentMode() != ((long) MavLinkDialectInterface.CustomSoloMode.GUIDED.getValue())) {
                    Log.d(TAG, "MVT. Changing mode to then takeoff");
                    sendArmAndTakeoffHelper(false, d, takeoffCallback);
                    changetoGuided(MavLinkDialectInterface.CustomSoloMode.GUIDED);
                    sendArmAndTakeoffHelper(true, d, takeoffCallback);
                }
                Log.d(TAG, "MVT. Attempting doTakeoff");
                doTakeoff(d, takeoffCallback);
                return;
            }
            Log.d(TAG, "MVT. Arming first");
            sendArmAndTakeoffHelper(true, d, takeoffCallback);
        }
    }

    /* access modifiers changed from: protected */
    public void doTakeoff(Double d, final MavLinkThread.TakeoffCallback takeoffCallback) {
        try {
            sendTakeoff(d, true, new MavLinkThread.TakeoffCallback() {
                public void onSuccess() {
                    ArduPilotDialect.this.isInTakeoffProcess.set(false);
                    if (takeoffCallback != null) {
                        Log.d(ArduPilotDialect.TAG, "TO good");
                    }
                    takeoffCallback.onSuccess();
                }

                public void onFailure(int i) {
                    ArduPilotDialect.this.isInTakeoffProcess.set(false);
                    Log.d(ArduPilotDialect.TAG, "TO BAD");
                    if (takeoffCallback != null) {
                        Log.d(ArduPilotDialect.TAG, "TO Bad");
                        takeoffCallback.onFailure(i);
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "error", e);
            this.isInTakeoffProcess.set(false);
            if (takeoffCallback != null) {
                takeoffCallback.onFailure(-1);
            }
        }
    }

    public void moveGuided(float f, float f2, float f3) {
        changetoGuided(MavLinkDialectInterface.CustomSoloMode.GUIDED);
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.target_system = this.mavlinkThread.getTargetSystem();
        msg_mission_item.target_component = 1;
        msg_mission_item.command = 16;
        msg_mission_item.current = 2;
        msg_mission_item.autocontinue = 0;
        msg_mission_item.frame = 3;
        msg_mission_item.f8319x = f;
        msg_mission_item.f8320y = f2;
        msg_mission_item.f8321z = f3;
        this.mavlinkThread.sendMessage(msg_mission_item);
    }

    public static List<msg_mission_item> missionFromRoute(Double d, Double d2, List<GeoPosition> list, boolean z, boolean z2, boolean z3, boolean z4) {
        int i;
        LinkedList linkedList = new LinkedList();
        float altitude = (float) list.get(0).getAltitude();
        if (z) {
            msg_mission_item msg_mission_item = new msg_mission_item();
            msg_mission_item.command = 24;
            msg_mission_item.f8321z = altitude;
            msg_mission_item.seq = 0;
            msg_mission_item.autocontinue = 1;
            linkedList.add(msg_mission_item);
            i = 1;
        } else {
            i = 0;
        }
        if (z3) {
            msg_mission_item msg_mission_item2 = new msg_mission_item();
            msg_mission_item2.command = 16;
            msg_mission_item2.f8319x = d.floatValue();
            msg_mission_item2.f8320y = d2.floatValue();
            msg_mission_item2.f8321z = altitude;
            msg_mission_item2.frame = (short) (z4 ? 3 : 0);
            msg_mission_item2.seq = i;
            msg_mission_item2.autocontinue = 1;
            linkedList.add(msg_mission_item2);
            i++;
        }
        for (GeoPosition next : list) {
            msg_mission_item msg_mission_item3 = new msg_mission_item();
            msg_mission_item3.command = 16;
            msg_mission_item3.f8319x = (float) next.getLatitude();
            msg_mission_item3.f8320y = (float) next.getLongitude();
            msg_mission_item3.f8321z = (float) next.getAltitude();
            msg_mission_item3.frame = (short) (z4 ? 3 : 0);
            msg_mission_item3.seq = i;
            msg_mission_item3.autocontinue = 1;
            linkedList.add(msg_mission_item3);
            i++;
        }
        if (z2) {
            msg_mission_item msg_mission_item4 = new msg_mission_item();
            msg_mission_item4.command = 20;
            msg_mission_item4.seq = i;
            linkedList.add(msg_mission_item4);
        }
        return linkedList;
    }

    public static void main(String[] strArr) {
        final MavLinkThread mavLinkThread = new MavLinkThread(new TcpMavlinkTransport("127.0.0.1", 5762, false));
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
        mavLinkThread.initialize(false, new MavLinkThread.OnInitializationCallback() {
            public void onFinished(int i) {
                String access$000 = ArduPilotDialect.TAG;
                Log.d(access$000, "Initialization completed with " + i + " parameters");
                Log.d(ArduPilotDialect.TAG, "Trying a takeoff to 100m AGL");
                MavLinkThread.this.startTakeoffProcess(Double.valueOf(100.0d), new MavLinkThread.TakeoffCallback() {
                    public void onSuccess() {
                        Log.d(ArduPilotDialect.TAG, "Takeoff Success!!");
                    }

                    public void onFailure(int i) {
                        String access$000 = ArduPilotDialect.TAG;
                        Log.e(access$000, "Takeoff Failure: " + i);
                    }
                });
            }

            public void onProgressUpdate(int i, int i2) {
                String access$000 = ArduPilotDialect.TAG;
                Log.d(access$000, "Param Progress = " + ((((float) i2) / ((float) i)) * 100.0f) + "%");
            }

            public void onError(String str, Throwable th) {
                String access$000 = ArduPilotDialect.TAG;
                Log.e(access$000, "Initialization Error: " + str + ": " + th);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void changeMode(int i, ResultCallback resultCallback) {
        String str = TAG;
        Log.d(str, "changeMode(" + i + ")");
        try {
            this.mavlinkThread.sendChangeCustomMode(i);
        } catch (IOException e) {
            MavlinkVehicle.handleExceptionCallback(e, resultCallback);
        }
    }

    public boolean isInMissionMode() {
        return this.mavlinkThread.getCurrentMode() == ((long) MavLinkDialectInterface.CustomSoloMode.AUTO.getValue());
    }

    public void enterMissionMode(ResultCallback resultCallback) {
        try {
            this.mavlinkThread.sendChangeCustomMode(MavLinkDialectInterface.CustomSoloMode.AUTO.getValue());
        } catch (IOException e) {
            MavlinkVehicle.handleExceptionCallback(e, resultCallback);
        }
    }

    public void enterReturnToHomeMode(ResultCallback<Void> resultCallback) {
        try {
            this.mavlinkThread.sendChangeCustomMode(MavLinkDialectInterface.CustomSoloMode.RTL.getValue());
        } catch (IOException e) {
            MavlinkVehicle.handleExceptionCallback(e, resultCallback);
        }
    }

    public void handleTakeoffAck(msg_command_ack msg_command_ack) {
        String str = TAG;
        Log.d(str, "Takeoff ACK: " + msg_command_ack.result);
        MavLinkThread.TakeoffCallback andSet = this.mavlinkThread.takeoffCallback.getAndSet((Object) null);
        if (msg_command_ack.result == 0) {
            Log.d(str, "Takeoff Success");
            if (andSet != null) {
                andSet.onSuccess();
                return;
            }
            return;
        }
        Log.e(str, "Takeoff Failure: " + msg_command_ack.result);
        if (andSet != null) {
            andSet.onFailure(msg_command_ack.result);
        }
    }

    public void enterPositionHoldMode() {
        this.mavlinkThread.sendChangeCustomMode(MavLinkDialectInterface.CustomSoloMode.GUIDED.getValue());
    }

    public boolean inPositionHoldMode() {
        msg_heartbeat msg_heartbeat = (msg_heartbeat) this.mavlinkThread.getLatestMessage(msg_heartbeat.class);
        if (msg_heartbeat != null && msg_heartbeat.custom_mode == ((long) MavLinkDialectInterface.CustomSoloMode.GUIDED.getValue())) {
            return true;
        }
        return false;
    }

    static void requestDataStream(MavLinkThread mavLinkThread) {
        try {
            mavLinkThread.sendInitStream(1);
            mavLinkThread.sendInitStream(2);
            mavLinkThread.sendInitStream(3);
            mavLinkThread.sendInitStream(6);
            mavLinkThread.sendInitStream(10);
            mavLinkThread.sendInitStream(11);
            mavLinkThread.sendInitStream(12);
            msg_command_long msg_command_long = new msg_command_long();
            msg_command_long.command = MAV_CMD.MAV_CMD_GET_HOME_POSITION;
            msg_command_long.target_component = mavLinkThread.getTargetComponent();
            msg_command_long.target_system = mavLinkThread.getTargetSystem();
            mavLinkThread.sendMessage(msg_command_long);
            msg_command_long msg_command_long2 = new msg_command_long();
            msg_command_long2.command = MAV_CMD.MAV_CMD_SET_MESSAGE_INTERVAL;
            msg_command_long2.target_system = mavLinkThread.getTargetSystem();
            msg_command_long2.target_component = mavLinkThread.getTargetComponent();
            msg_command_long2.param1 = 245.0f;
            msg_command_long2.param2 = 2000000.0f;
            mavLinkThread.sendMessage(msg_command_long2);
        } catch (Exception e) {
            Log.d(TAG, "Unable to send stream request", e);
        }
    }

    /* renamed from: com.bbn.ccast.mavlink.ArduPilotDialect$6 */
    /* synthetic */ class C50956 {

        /* renamed from: $SwitchMap$com$bbn$ccast$mavlink$MavLinkDialectInterface$ParamSettings */
        static final /* synthetic */ int[] f8509xdbebb238;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings[] r0 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8509xdbebb238 = r0
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.MAX_ALT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8509xdbebb238     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.RETURN_ALT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.ArduPilotDialect.C50956.<clinit>():void");
        }
    }

    public String getParamName(MavLinkDialectInterface.ParamSettings paramSettings) {
        int i = C50956.f8509xdbebb238[paramSettings.ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "RTL_ALT";
        }
        return "GF_MAX_VER_DIST";
    }

    public MavLinkDialectInterface.GimbalPosePRYYa<Double> getCameraOrientation() {
        msg_mount_status msg_mount_status = (msg_mount_status) this.mavlinkThread.getLatestMessage(msg_mount_status.class);
        if (msg_mount_status == null) {
            return null;
        }
        MavLinkDialectInterface.GimbalPosePRYYa<Double> gimbalPosePRYYa = new MavLinkDialectInterface.GimbalPosePRYYa<>();
        gimbalPosePRYYa.pitch = Double.valueOf(((double) msg_mount_status.pointing_a) / -100.0d);
        gimbalPosePRYYa.roll = Double.valueOf(((double) msg_mount_status.pointing_b) / 100.0d);
        gimbalPosePRYYa.yaw = Double.valueOf(((double) msg_mount_status.pointing_c) / 100.0d);
        gimbalPosePRYYa.yawAbsolute = Double.valueOf(((double) msg_mount_status.pointing_c) / 100.0d);
        return gimbalPosePRYYa;
    }

    public void changeAltitude(float f) {
        String str = TAG;
        Log.d(str, "ChangeAltitude(" + f + ")");
        if (this.mavlinkThread.inAir()) {
            msg_global_position_int msg_global_position_int = (msg_global_position_int) this.mavlinkThread.getLatestMessage(msg_global_position_int.class);
            msg_set_position_target_global_int msg_set_position_target_global_int = new msg_set_position_target_global_int();
            msg_set_position_target_global_int.alt = f;
            msg_set_position_target_global_int.coordinate_frame = 3;
            msg_set_position_target_global_int.target_system = 1;
            msg_set_position_target_global_int.target_component = 1;
            msg_set_position_target_global_int.lat_int = msg_global_position_int.lat;
            msg_set_position_target_global_int.lon_int = msg_global_position_int.lon;
            msg_set_position_target_global_int.f8339vx = 0.0f;
            msg_set_position_target_global_int.f8340vy = 0.0f;
            msg_set_position_target_global_int.f8341vz = 0.0f;
            msg_set_position_target_global_int.afx = 0.0f;
            msg_set_position_target_global_int.afy = 0.0f;
            msg_set_position_target_global_int.afz = 0.0f;
            msg_set_position_target_global_int.yaw = 0.0f;
            msg_set_position_target_global_int.yaw_rate = 0.0f;
            msg_set_position_target_global_int.type_mask = 65528;
            this.mavlinkThread.sendMessage(msg_set_position_target_global_int);
            this.mavlinkThread.sendMessage(msg_set_position_target_global_int);
        }
    }

    public boolean inAir() {
        msg_extended_sys_state msg_extended_sys_state = (msg_extended_sys_state) this.mavlinkThread.getLatestMessage(msg_extended_sys_state.class);
        if (msg_extended_sys_state == null || msg_extended_sys_state.landed_state == 1 || msg_extended_sys_state.landed_state == 0) {
            return false;
        }
        return true;
    }

    public String getModeString() {
        int currentMode = (int) this.mavlinkThread.getCurrentMode();
        MavLinkDialectInterface.CustomSoloMode fromInt = MavLinkDialectInterface.CustomSoloMode.fromInt(currentMode);
        if (fromInt != null) {
            return fromInt.toString() + "_" + fromInt.getValue();
        }
        return "Mode_" + currentMode;
    }

    public void setMode(String str) {
        MavLinkDialectInterface.CustomSoloMode fromValue = MavLinkDialectInterface.CustomSoloMode.fromValue(str);
        if (fromValue != null) {
            try {
                this.mavlinkThread.sendChangeCustomMode(fromValue.getValue());
            } catch (IOException e) {
                String str2 = TAG;
                Log.d(str2, "Error changing Mode: " + str + ". ", e);
            }
        }
    }

    public String[] getModes() {
        return MavLinkDialectInterface.CustomSoloMode.names;
    }

    public void sendGimbalPosePRY(double d, double d2, double d3) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = this.mavlinkThread.getTargetSystem();
        msg_command_long.target_component = this.mavlinkThread.getTargetComponent();
        msg_command_long.command = 205;
        msg_command_long.param1 = (float) (d * -100.0d);
        msg_command_long.param2 = (float) (d2 * 100.0d);
        msg_command_long.param3 = (float) (d3 * 100.0d);
        msg_command_long.param4 = Float.NaN;
        msg_command_long.param5 = Float.NaN;
        msg_command_long.param6 = Float.NaN;
        msg_command_long.param7 = 2.0f;
        this.mavlinkThread.sendMessage(msg_command_long);
        this.mavlinkThread.sendMessage(msg_command_long);
        this.mavlinkThread.sendMessage(msg_command_long);
    }
}
