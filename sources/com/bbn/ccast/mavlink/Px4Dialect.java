package com.bbn.ccast.mavlink;

import com.atakmap.android.uastool.MAVLink.common.msg_command_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_command_int;
import com.atakmap.android.uastool.MAVLink.common.msg_command_long;
import com.atakmap.android.uastool.MAVLink.common.msg_extended_sys_state;
import com.atakmap.android.uastool.MAVLink.common.msg_global_position_int;
import com.atakmap.android.uastool.MAVLink.common.msg_heartbeat;
import com.atakmap.android.uastool.MAVLink.common.msg_home_position;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.MAVLink.common.msg_mount_orientation;
import com.atakmap.android.uastool.MAVLink.common.msg_vfr_hud;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.bbn.ccast.mavlink.MavLinkDialectInterface;
import com.bbn.ccast.mavlink.MavLinkThread;
import com.bbn.vehicleinterface.types.ResultCallback;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Px4Dialect implements MavLinkDialectInterface {
    public static final int PX4_AUTO_BASE_MODE_FLAGS = 29;
    public static final String TAG = "com.bbn.ccast.mavlink.Px4Dialect";
    private final MavLinkThread mavLinkThread;

    public enum PX4_CUSTOM_MODE {
        NONE(0),
        MANUAL(1),
        ALTCTL(2),
        POSCTL(3),
        AUTO(4),
        ACRO(5),
        OFFBOARD(6),
        STABILIZED(7),
        RATTITUDE(8),
        SIMPLE(9),
        UNKNOWN(-1);
        
        public static final PX4_CUSTOM_MODE[] values = null;
        int val;

        static {
            values = values();
        }

        private PX4_CUSTOM_MODE(int i) {
            this.val = i;
        }

        public static PX4_CUSTOM_MODE fromInt(int i) {
            try {
                PX4_CUSTOM_MODE[] px4_custom_modeArr = values;
                if (i < px4_custom_modeArr.length) {
                    return px4_custom_modeArr[i];
                }
            } catch (Exception unused) {
            }
            return UNKNOWN;
        }
    }

    public enum PX4_CUSTOM_AUTO_SUBMODE {
        NONE(0),
        READY(1),
        TAKEOFF(2),
        LOITER(3),
        MISSION(4),
        RTL(5),
        LAND(6),
        RTGS(7),
        FOLLOW_TARGET(8),
        PRECLAND(9);
        
        public static final PX4_CUSTOM_AUTO_SUBMODE[] values = null;
        int val;

        static {
            values = values();
        }

        private PX4_CUSTOM_AUTO_SUBMODE(int i) {
            this.val = i;
        }

        public static PX4_CUSTOM_AUTO_SUBMODE fromInt(int i) {
            try {
                PX4_CUSTOM_AUTO_SUBMODE[] px4_custom_auto_submodeArr = values;
                if (i < px4_custom_auto_submodeArr.length) {
                    return px4_custom_auto_submodeArr[i];
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    enum SimplePx4Mode {
        MANUAL(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.MANUAL, PX4_CUSTOM_AUTO_SUBMODE.NONE)),
        STABILIZED(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.STABILIZED, PX4_CUSTOM_AUTO_SUBMODE.NONE)),
        ACRO(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.ACRO, PX4_CUSTOM_AUTO_SUBMODE.NONE)),
        RATTITUDE(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.RATTITUDE, PX4_CUSTOM_AUTO_SUBMODE.NONE)),
        ALTCTL(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.ALTCTL, PX4_CUSTOM_AUTO_SUBMODE.NONE)),
        OFFBOARD(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.OFFBOARD, PX4_CUSTOM_AUTO_SUBMODE.NONE)),
        POSCTL(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.POSCTL, PX4_CUSTOM_AUTO_SUBMODE.NONE)),
        HOLD(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.LOITER)),
        MISSION(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.MISSION)),
        RTL(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.RTL)),
        FOLLOW_TARGET(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.FOLLOW_TARGET)),
        TAKEOFF(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.TAKEOFF)),
        LAND(Px4Dialect.buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.LAND));
        
        public static final String[] names = null;
        public static final SimplePx4Mode[] values = null;
        private final long value;

        static {
            SimplePx4Mode[] values2 = values();
            values = values2;
            names = new String[values2.length];
            int i = 0;
            while (true) {
                SimplePx4Mode[] simplePx4ModeArr = values;
                if (i < simplePx4ModeArr.length) {
                    names[i] = simplePx4ModeArr[i].name();
                    i++;
                } else {
                    return;
                }
            }
        }

        private SimplePx4Mode(int i) {
            this.value = (long) i;
        }

        public long getValue() {
            return this.value;
        }

        public static SimplePx4Mode fromLong(long j) {
            try {
                for (SimplePx4Mode simplePx4Mode : values()) {
                    if (simplePx4Mode.value == j) {
                        return simplePx4Mode;
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        public static SimplePx4Mode fromValue(String str) {
            if (str == null) {
                return null;
            }
            for (SimplePx4Mode simplePx4Mode : values()) {
                if (simplePx4Mode.name().equals(str)) {
                    return simplePx4Mode;
                }
            }
            return null;
        }
    }

    public Px4Dialect(MavLinkThread mavLinkThread2) {
        this.mavLinkThread = mavLinkThread2;
    }

    public void land() {
        this.mavLinkThread.sendChangeBaseAndCustomMode(29, Integer.valueOf(buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.LAND)));
    }

    /* access modifiers changed from: private */
    public static int buildPx4CustomMode(PX4_CUSTOM_MODE px4_custom_mode, PX4_CUSTOM_AUTO_SUBMODE px4_custom_auto_submode) {
        return (px4_custom_mode.val << 16) | (px4_custom_auto_submode.val << 24);
    }

    private PX4_CUSTOM_MODE getPx4CustomMode(long j) {
        return PX4_CUSTOM_MODE.fromInt((int) ((j >> 16) & 255));
    }

    private PX4_CUSTOM_AUTO_SUBMODE getPx4CustomAutoSubMode(long j) {
        return PX4_CUSTOM_AUTO_SUBMODE.fromInt((int) ((j >> 24) & 255));
    }

    public void handleTakeoffAck(msg_command_ack msg_command_ack) {
        String str = TAG;
        Log.d(str, "Takeoff ACK: " + msg_command_ack.result);
        MavLinkThread.TakeoffCallback andSet = this.mavLinkThread.takeoffCallback.getAndSet((Object) null);
        if (msg_command_ack.result == 0) {
            Log.d(str, "Takeoff Success, arming...");
            try {
                this.mavLinkThread.sendArm(true);
                Thread.sleep(10);
                this.mavLinkThread.sendArm(true);
            } catch (IOException | InterruptedException unused) {
            }
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
        if (this.mavLinkThread.isArmed()) {
            if (this.mavLinkThread.isInMissionMode()) {
                this.mavLinkThread.sendChangeBaseAndCustomMode(29, Integer.valueOf(buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.LOITER)));
                return;
            }
            changeAltitude(Float.NaN);
            changeAltitude(((float) ((msg_global_position_int) this.mavLinkThread.getLatestMessage(msg_global_position_int.class)).relative_alt) / 1000.0f);
        }
    }

    public boolean inPositionHoldMode() {
        msg_heartbeat msg_heartbeat = (msg_heartbeat) this.mavLinkThread.getLatestMessage(msg_heartbeat.class);
        if (msg_heartbeat == null) {
            return false;
        }
        boolean z = ((((msg_heartbeat.base_mode & 4) != 0) && (msg_heartbeat.base_mode & 8) != 0) && (msg_heartbeat.base_mode & 16) != 0) && (msg_heartbeat.base_mode & 1) != 0;
        boolean z2 = ((long) buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.LOITER)) == msg_heartbeat.custom_mode;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public void startTakeoffProcess(Double d, MavLinkThread.TakeoffCallback takeoffCallback) {
        float f;
        try {
            f = (float) (((msg_home_position) this.mavLinkThread.getLatestMessage(msg_home_position.class)).altitude / 1000);
        } catch (Exception unused) {
            f = 0.0f;
        }
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = this.mavLinkThread.getTargetSystem();
        msg_command_long.target_component = this.mavLinkThread.getTargetComponent();
        msg_command_long.command = 22;
        msg_command_long.confirmation = 0;
        msg_command_long.param1 = -1.0f;
        msg_command_long.param2 = 0.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = Float.NaN;
        msg_command_long.param5 = Float.NaN;
        msg_command_long.param6 = Float.NaN;
        msg_command_long.param7 = ((float) d.doubleValue()) + f;
        try {
            this.mavLinkThread.sendMessage(msg_command_long);
        } catch (Exception unused2) {
            takeoffCallback.onFailure(-1);
        }
        takeoffCallback.onSuccess();
    }

    public void moveGuided(float f, float f2, float f3) {
        float f4;
        try {
            f4 = (float) (((msg_home_position) this.mavLinkThread.getLatestMessage(msg_home_position.class)).altitude / 1000);
        } catch (Exception unused) {
            f4 = 0.0f;
        }
        msg_command_int msg_command_int = new msg_command_int();
        msg_command_int.target_system = this.mavLinkThread.getTargetSystem();
        msg_command_int.target_component = this.mavLinkThread.getTargetComponent();
        msg_command_int.frame = 0;
        msg_command_int.current = 0;
        msg_command_int.autocontinue = 0;
        msg_command_int.command = 192;
        msg_command_int.param1 = -1.0f;
        msg_command_int.param2 = 1.0f;
        msg_command_int.param3 = 0.0f;
        msg_command_int.param4 = Float.NaN;
        msg_command_int.f8259x = (int) (((double) f) * Math.pow(10.0d, 7.0d));
        msg_command_int.f8260y = (int) (((double) f2) * Math.pow(10.0d, 7.0d));
        msg_command_int.f8261z = f4 + f3;
        String str = TAG;
        Log.d(str, String.format("%s - Constructed do_reposition command", new Object[]{str}));
        this.mavLinkThread.sendMessage(msg_command_int);
        this.mavLinkThread.sendMessage(msg_command_int);
        Log.d(str, String.format("%s - Sent moveGuided to (%f, %f, %f)", new Object[]{str, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}));
    }

    public void orbit(float f, float f2, float f3, float f4) {
        float f5;
        try {
            f5 = (float) (((msg_home_position) this.mavLinkThread.getLatestMessage(msg_home_position.class)).altitude / 1000);
        } catch (Exception unused) {
            f5 = 0.0f;
        }
        msg_command_int msg_command_int = new msg_command_int();
        msg_command_int.target_system = this.mavLinkThread.getTargetSystem();
        msg_command_int.target_component = this.mavLinkThread.getTargetComponent();
        msg_command_int.frame = 0;
        msg_command_int.current = 0;
        msg_command_int.autocontinue = 0;
        msg_command_int.command = 34;
        msg_command_int.param1 = f4;
        msg_command_int.param2 = Float.NaN;
        msg_command_int.param3 = 0.0f;
        msg_command_int.param4 = Float.NaN;
        msg_command_int.f8259x = (int) (((double) f) * Math.pow(10.0d, 7.0d));
        msg_command_int.f8260y = (int) (((double) f2) * Math.pow(10.0d, 7.0d));
        msg_command_int.f8261z = f3 + f5;
        String str = TAG;
        Log.d(str, String.format("%s - Constructed do_orbit command", new Object[]{str}));
        this.mavLinkThread.sendMessage(msg_command_int);
        this.mavLinkThread.sendMessage(msg_command_int);
        Log.d(str, String.format("%s - Sent doOrbit to (%f, %f, %f, %f)", new Object[]{str, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}));
    }

    public boolean isInMissionMode() {
        return this.mavLinkThread.getCurrentMode() == ((long) buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.MISSION));
    }

    public void enterMissionMode(ResultCallback<Void> resultCallback) {
        this.mavLinkThread.sendChangeBaseAndCustomMode(29, Integer.valueOf(buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.MISSION)), resultCallback);
    }

    public void enterReturnToHomeMode(ResultCallback<Void> resultCallback) {
        this.mavLinkThread.sendChangeBaseAndCustomMode(29, Integer.valueOf(buildPx4CustomMode(PX4_CUSTOM_MODE.AUTO, PX4_CUSTOM_AUTO_SUBMODE.RTL)), resultCallback);
    }

    /* renamed from: com.bbn.ccast.mavlink.Px4Dialect$1 */
    /* synthetic */ class C51051 {

        /* renamed from: $SwitchMap$com$bbn$ccast$mavlink$MavLinkDialectInterface$ParamSettings */
        static final /* synthetic */ int[] f8511xdbebb238;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings[] r0 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8511xdbebb238 = r0
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.TAKEOFF_ALT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.GEOFENCE_ACTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.MAX_DIST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.MAX_ALT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x003e }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.MAX_VEL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.RETURN_ALT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.DATALINK_LOST_ACTION     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.DATALINK_LOST_WITHRC_ACTION     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x006c }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.LOW_BATTERY_ACTION     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.BATERY_CRITCAL_PERCENT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.BATERY_EMERGENCY_PERCENT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.BATTERY_LOW_PERCENT     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x009c }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.CRUSE_VEL     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8511xdbebb238     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.bbn.ccast.mavlink.MavLinkDialectInterface$ParamSettings r1 = com.bbn.ccast.mavlink.MavLinkDialectInterface.ParamSettings.MAX_MANUAL_VEL     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.Px4Dialect.C51051.<clinit>():void");
        }
    }

    public String getParamName(MavLinkDialectInterface.ParamSettings paramSettings) {
        switch (C51051.f8511xdbebb238[paramSettings.ordinal()]) {
            case 1:
                return "MIS_TAKEOFF_ALT";
            case 2:
                return "GF_ACTION";
            case 3:
                return "GF_MAX_HOR_DIST";
            case 4:
                return "GF_MAX_VER_DIST";
            case 5:
                return "MPC_XY_VEL_MAX";
            case 6:
                return "RTL_RETURN_ALT";
            case 7:
                return "NAV_DLL_ACT";
            case 8:
                return "NAV_RCL_ACT";
            case 9:
                return "COM_LOW_BAT_ACT";
            case 10:
                return "BAT_CRIT_THR";
            case 11:
                return "BAT_EMERGEN_THR";
            case 12:
                return "BAT_LOW_THR";
            case 13:
                return "MPC_XY_CRUISE";
            case 14:
                return "MPC_VEL_MANUAL";
            default:
                return null;
        }
    }

    public static List<msg_mission_item> missionFromSimpleRoute(RouteTask routeTask) {
        UASRoute route = routeTask.getRoute();
        LinkedList linkedList = new LinkedList();
        UASPoint.FINISH_ACTION finish_action = UASPoint.FINISH_ACTION.NO_ACTION;
        int i = 0;
        double d = 0.0d;
        int i2 = 0;
        while (i < route.getPointCnt()) {
            int i3 = i + 1;
            UASPoint pointWithIndex = route.getPointWithIndex(i3);
            if (pointWithIndex == null) {
                Log.e(TAG, "Warning: Null item " + i + " in route point List, skipping");
            } else {
                Integer gimbalPitch = pointWithIndex.getGimbalPitch();
                if (gimbalPitch != null) {
                    linkedList.add(getMountControl((double) gimbalPitch.intValue(), 0.0d, 0.0d, i2));
                    i2++;
                }
                float speed = pointWithIndex.getSpeed();
                double d2 = (double) speed;
                if (d != d2) {
                    if (speed > 0.0f) {
                        linkedList.add(getSpeedChange(speed, i2));
                        i2++;
                    }
                    d = d2;
                }
                int i4 = i2;
                linkedList.add(getNavWayPoint(pointWithIndex.C().getLatitude(), pointWithIndex.C().getLongitude(), (double) pointWithIndex.getAGL(), i4));
                finish_action = pointWithIndex.getFinishAction();
                i2 = i4 + 1;
            }
            i = i3;
        }
        UASPoint pointWithIndex2 = route.getPointWithIndex(1);
        GeoPoint C = pointWithIndex2.C();
        UASPoint pointWithIndex3 = route.getPointWithIndex(route.getPointCnt());
        GeoPoint C2 = pointWithIndex3.C();
        if (!(finish_action == null || UASPoint.FINISH_ACTION.NO_ACTION == finish_action)) {
            if (UASPoint.FINISH_ACTION.GO_HOME_LAND == finish_action) {
                linkedList.add(getRTH(i2));
            } else if (UASPoint.FINISH_ACTION.HOVER_AT_FIRST_WAYPOINT == finish_action) {
                if (Math.abs(pointWithIndex2.getAGL() - pointWithIndex3.getAGL()) > 1.0f && C2.distanceTo(C) > 1.0d) {
                    linkedList.add(getNavWayPoint(C2.getLatitude(), C2.getLongitude(), (double) pointWithIndex2.getAGL(), i2));
                    i2++;
                }
                linkedList.add(getNavWayPoint(C.getLatitude(), C.getLongitude(), (double) pointWithIndex2.getAGL(), i2));
            } else if (UASPoint.FINISH_ACTION.LAND_AT_LAST == finish_action) {
                linkedList.add(getLand(C2.getLatitude(), C2.getLongitude(), i2));
            }
        }
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0279 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x027a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.atakmap.android.uastool.MAVLink.common.msg_mission_item> missionFromRoute(com.atakmap.coremap.maps.coords.GeoPoint r34, com.atakmap.android.uastool.tasks.route.RouteTask r35) {
        /*
            r1 = r34
            com.atakmap.android.uastool.tasks.route.UASRoute r2 = r35.getRoute()
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r7 = 1
            com.atakmap.android.uastool.tasks.route.UASPoint r0 = r2.getPointWithIndex(r7)     // Catch:{ Exception -> 0x0055 }
            float r0 = r0.getAGL()     // Catch:{ Exception -> 0x0055 }
            double r8 = (double) r0     // Catch:{ Exception -> 0x0055 }
            double r10 = r34.getAltitude()     // Catch:{ Exception -> 0x0055 }
            double r10 = r10 - r8
            double r8 = java.lang.Math.abs(r10)     // Catch:{ Exception -> 0x0055 }
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0053
            com.atakmap.android.uastool.tasks.route.UASPoint r0 = r2.getPointWithIndex(r7)     // Catch:{ Exception -> 0x0055 }
            com.atakmap.coremap.maps.coords.GeoPoint r0 = r0.C()     // Catch:{ Exception -> 0x0055 }
            double r8 = r1.distanceTo(r0)     // Catch:{ Exception -> 0x0055 }
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0053
            double r8 = r34.getLatitude()     // Catch:{ Exception -> 0x0055 }
            double r10 = r34.getLongitude()     // Catch:{ Exception -> 0x0055 }
            com.atakmap.android.uastool.tasks.route.UASPoint r0 = r2.getPointWithIndex(r7)     // Catch:{ Exception -> 0x0055 }
            float r0 = r0.getAGL()     // Catch:{ Exception -> 0x0055 }
            double r12 = (double) r0
            r14 = 0
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r0 = getNavWayPoint(r8, r10, r12, r14)     // Catch:{ Exception -> 0x004f }
            r3.add(r0)     // Catch:{ Exception -> 0x004f }
            r0 = 1
            goto L_0x005f
        L_0x004f:
            r0 = move-exception
            r8 = r0
            r0 = 1
            goto L_0x0058
        L_0x0053:
            r0 = 0
            goto L_0x005f
        L_0x0055:
            r0 = move-exception
            r8 = r0
            r0 = 0
        L_0x0058:
            java.lang.String r9 = TAG
            java.lang.String r10 = "error"
            com.atakmap.coremap.log.Log.e(r9, r10, r8)
        L_0x005f:
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0063:
            int r14 = r2.getPointCnt()
            r15 = 1065353216(0x3f800000, float:1.0)
            if (r11 >= r14) goto L_0x0277
            int r14 = r11 + 1
            com.atakmap.android.uastool.tasks.route.UASPoint r16 = r2.getPointWithIndex(r14)
            float r6 = r16.getSpeed()
            double r8 = (double) r6
            int r18 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r18 == 0) goto L_0x008d
            r12 = 0
            int r12 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x0089
            int r12 = r0 + 1
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r0 = getSpeedChange(r6, r0)
            r3.add(r0)
            r0 = r12
        L_0x0089:
            r24 = r0
            r12 = r8
            goto L_0x008f
        L_0x008d:
            r24 = r0
        L_0x008f:
            com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r0 = r16.getPointType()
            com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r6 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.WAYPOINT
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x011c
            r0 = r16
            com.atakmap.android.uastool.tasks.route.WayPoint r0 = (com.atakmap.android.uastool.tasks.route.WayPoint) r0
            java.lang.String r6 = r0.getGotoMode()
            java.lang.String r8 = "Safely"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x00e4
            com.atakmap.android.uastool.tasks.route.UASPoint r6 = r2.getPointWithIndex(r11)
            if (r6 == 0) goto L_0x00e4
            float r8 = r6.getAGL()
            float r9 = r16.getAGL()
            float r8 = r8 - r9
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r8 <= 0) goto L_0x00e4
            com.atakmap.coremap.maps.coords.GeoPoint r8 = r6.C()
            double r18 = r8.getLatitude()
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r6.C()
            double r20 = r6.getLongitude()
            float r6 = r16.getAGL()
            double r8 = (double) r6
            int r6 = r24 + 1
            r22 = r8
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r8 = getNavWayPoint(r18, r20, r22, r24)
            r3.add(r8)
            r24 = r6
        L_0x00e4:
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r16.C()
            double r18 = r6.getLatitude()
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r16.C()
            double r20 = r6.getLongitude()
            float r6 = r16.getAGL()
            double r8 = (double) r6
            int r6 = r24 + 1
            r22 = r8
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r8 = getNavWayPoint(r18, r20, r22, r24)
            r3.add(r8)
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r8 = r0.getFinishAction()
            if (r8 == 0) goto L_0x0119
            int r8 = r2.getPointCnt()
            int r8 = r8 - r7
            if (r11 != r8) goto L_0x0119
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r0 = r0.getFinishAction()
            java.lang.String r10 = r0.getCotValue()
        L_0x0119:
            r0 = r6
            goto L_0x0272
        L_0x011c:
            com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r0 = r16.getPointType()
            com.atakmap.android.uastool.tasks.route.UASPoint$POINTTYPE r6 = com.atakmap.android.uastool.tasks.route.UASPoint.POINTTYPE.ORBITPOINT
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0270
            r0 = r16
            com.atakmap.android.uastool.tasks.route.OrbitPoint r0 = (com.atakmap.android.uastool.tasks.route.OrbitPoint) r0
            com.atakmap.android.uastool.tasks.route.UASPoint r6 = r2.getPointWithIndex(r11)
            if (r6 == 0) goto L_0x0165
            float r8 = r6.getAGL()
            float r9 = r16.getAGL()
            float r8 = r8 - r9
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r8 <= 0) goto L_0x0165
            com.atakmap.coremap.maps.coords.GeoPoint r8 = r6.C()
            double r18 = r8.getLatitude()
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r6.C()
            double r20 = r6.getLongitude()
            float r6 = r16.getAGL()
            double r8 = (double) r6
            int r6 = r24 + 1
            r22 = r8
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r8 = getNavWayPoint(r18, r20, r22, r24)
            r3.add(r8)
            r24 = r6
        L_0x0165:
            com.atakmap.android.uastool.tasks.route.UASPoint r6 = r2.getPointWithIndex(r11)
            if (r6 == 0) goto L_0x017d
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r6.C()
            com.atakmap.coremap.maps.coords.GeoPoint r8 = r0.C()
            float r9 = r0.getOrbitRadius()
            double r12 = (double) r9
            int r6 = com.atakmap.android.uastool.tasks.route.OrbitPoint.closestOrbitPoint(r6, r8, r12)
            goto L_0x018e
        L_0x017d:
            if (r1 == 0) goto L_0x018d
            com.atakmap.coremap.maps.coords.GeoPoint r6 = r0.C()
            float r8 = r0.getOrbitRadius()
            double r8 = (double) r8
            int r6 = com.atakmap.android.uastool.tasks.route.OrbitPoint.closestOrbitPoint(r1, r6, r8)
            goto L_0x018e
        L_0x018d:
            r6 = 0
        L_0x018e:
            boolean r8 = r0.getOrbitClockwise()
            if (r8 == 0) goto L_0x01e4
            r8 = r6
            r31 = r24
        L_0x0197:
            int r9 = r0.getOrbitCount()
            int r9 = r9 * 360
            int r9 = r9 + r6
            if (r8 > r9) goto L_0x01e1
            com.atakmap.coremap.maps.coords.GeoPoint r9 = r16.C()
            int r12 = r8 % 360
            double r12 = (double) r12
            float r15 = r0.getOrbitRadius()
            double r4 = (double) r15
            com.atakmap.coremap.maps.coords.GeoPoint r4 = com.atakmap.coremap.maps.coords.GeoCalculations.pointAtDistance(r9, r12, r4)
            double r25 = r4.getLatitude()
            double r27 = r4.getLongitude()
            float r4 = r16.getAGL()
            double r4 = (double) r4
            int r9 = r31 + 1
            r29 = r4
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r4 = getNavWayPoint(r25, r27, r29, r31)
            r3.add(r4)
            if (r8 != 0) goto L_0x01da
            float r4 = r0.getOrbitSpeed()
            int r5 = r9 + 1
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r4 = getSpeedChange(r4, r9)
            r3.add(r4)
            r31 = r5
            goto L_0x01dc
        L_0x01da:
            r31 = r9
        L_0x01dc:
            int r8 = r8 + 30
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0197
        L_0x01e1:
            r33 = r31
            goto L_0x0236
        L_0x01e4:
            int r4 = r0.getOrbitCount()
            int r4 = r4 * 360
            int r4 = r4 + r6
            r26 = r24
        L_0x01ed:
            if (r4 < r6) goto L_0x0234
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r16.C()
            int r8 = r4 % 360
            double r8 = (double) r8
            float r12 = r0.getOrbitRadius()
            double r12 = (double) r12
            com.atakmap.coremap.maps.coords.GeoPoint r5 = com.atakmap.coremap.maps.coords.GeoCalculations.pointAtDistance(r5, r8, r12)
            double r20 = r5.getLatitude()
            double r22 = r5.getLongitude()
            float r5 = r16.getAGL()
            double r8 = (double) r5
            int r5 = r26 + 1
            r24 = r8
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r8 = getNavWayPoint(r20, r22, r24, r26)
            r3.add(r8)
            int r8 = r0.getOrbitCount()
            int r8 = r8 * 360
            if (r4 != r8) goto L_0x022f
            float r8 = r0.getOrbitSpeed()
            int r9 = r5 + 1
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r5 = getSpeedChange(r8, r5)
            r3.add(r5)
            r26 = r9
            goto L_0x0231
        L_0x022f:
            r26 = r5
        L_0x0231:
            int r4 = r4 + -30
            goto L_0x01ed
        L_0x0234:
            r33 = r26
        L_0x0236:
            com.atakmap.coremap.maps.coords.GeoPoint r4 = r16.C()
            double r27 = r4.getLatitude()
            com.atakmap.coremap.maps.coords.GeoPoint r4 = r16.C()
            double r29 = r4.getLongitude()
            float r4 = r16.getAGL()
            double r4 = (double) r4
            int r6 = r33 + 1
            r31 = r4
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r4 = getNavWayPoint(r27, r29, r31, r33)
            r3.add(r4)
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r4 = r0.getFinishAction()
            if (r4 == 0) goto L_0x026c
            int r4 = r2.getPointCnt()
            int r4 = r4 - r7
            if (r11 != r4) goto L_0x026c
            com.atakmap.android.uastool.tasks.route.UASPoint$FINISH_ACTION r0 = r0.getFinishAction()
            java.lang.String r0 = r0.getCotValue()
            r10 = r0
        L_0x026c:
            r0 = r6
            r12 = 0
            goto L_0x0272
        L_0x0270:
            r0 = r24
        L_0x0272:
            r11 = r14
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0063
        L_0x0277:
            if (r10 != 0) goto L_0x027a
            return r3
        L_0x027a:
            com.atakmap.android.uastool.tasks.route.UASPoint r1 = r2.getPointWithIndex(r7)
            com.atakmap.coremap.maps.coords.GeoPoint r4 = r1.C()
            int r5 = r2.getPointCnt()
            com.atakmap.android.uastool.tasks.route.UASPoint r2 = r2.getPointWithIndex(r5)
            com.atakmap.coremap.maps.coords.GeoPoint r5 = r2.C()
            r10.hashCode()
            r6 = -1
            int r8 = r10.hashCode()
            switch(r8) {
                case -621557446: goto L_0x02b0;
                case 771100307: goto L_0x02a5;
                case 1055129501: goto L_0x029a;
                default: goto L_0x0299;
            }
        L_0x0299:
            goto L_0x02ba
        L_0x029a:
            java.lang.String r7 = "Go Home and Land"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x02a3
            goto L_0x02ba
        L_0x02a3:
            r6 = 2
            goto L_0x02ba
        L_0x02a5:
            java.lang.String r8 = "Land at Last Waypoint"
            boolean r8 = r10.equals(r8)
            if (r8 != 0) goto L_0x02ae
            goto L_0x02ba
        L_0x02ae:
            r6 = 1
            goto L_0x02ba
        L_0x02b0:
            java.lang.String r7 = "Hover at First Waypoint"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x02b9
            goto L_0x02ba
        L_0x02b9:
            r6 = 0
        L_0x02ba:
            switch(r6) {
                case 0: goto L_0x02d6;
                case 1: goto L_0x02c6;
                case 2: goto L_0x02be;
                default: goto L_0x02bd;
            }
        L_0x02bd:
            goto L_0x0321
        L_0x02be:
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r0 = getRTH(r0)
            r3.add(r0)
            goto L_0x0321
        L_0x02c6:
            double r1 = r5.getLatitude()
            double r4 = r5.getLongitude()
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r0 = getLand(r1, r4, r0)
            r3.add(r0)
            goto L_0x0321
        L_0x02d6:
            float r6 = r1.getAGL()
            float r2 = r2.getAGL()
            float r6 = r6 - r2
            float r2 = java.lang.Math.abs(r6)
            int r2 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r2 <= 0) goto L_0x030c
            double r6 = r5.distanceTo(r4)
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x030c
            double r11 = r5.getLatitude()
            double r13 = r5.getLongitude()
            float r2 = r1.getAGL()
            double r5 = (double) r2
            int r2 = r0 + 1
            r15 = r5
            r17 = r0
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r0 = getNavWayPoint(r11, r13, r15, r17)
            r3.add(r0)
            r11 = r2
            goto L_0x030d
        L_0x030c:
            r11 = r0
        L_0x030d:
            double r5 = r4.getLatitude()
            double r7 = r4.getLongitude()
            float r0 = r1.getAGL()
            double r9 = (double) r0
            com.atakmap.android.uastool.MAVLink.common.msg_mission_item r0 = getNavWayPoint(r5, r7, r9, r11)
            r3.add(r0)
        L_0x0321:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbn.ccast.mavlink.Px4Dialect.missionFromRoute(com.atakmap.coremap.maps.coords.GeoPoint, com.atakmap.android.uastool.tasks.route.RouteTask):java.util.List");
    }

    protected static msg_mission_item getNavWayPoint(double d, double d2, double d3, int i) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.command = 16;
        msg_mission_item.param4 = Float.NaN;
        msg_mission_item.f8319x = (float) d;
        msg_mission_item.f8320y = (float) d2;
        msg_mission_item.f8321z = (float) d3;
        msg_mission_item.frame = 3;
        msg_mission_item.seq = i;
        msg_mission_item.autocontinue = 1;
        return msg_mission_item;
    }

    protected static msg_mission_item getSpeedChange(float f, int i) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.command = 178;
        msg_mission_item.param1 = 0.0f;
        msg_mission_item.param2 = f;
        msg_mission_item.param3 = -1.0f;
        msg_mission_item.param4 = 0.0f;
        msg_mission_item.frame = 2;
        msg_mission_item.f8319x = 0.0f;
        msg_mission_item.f8320y = 0.0f;
        msg_mission_item.f8321z = 0.0f;
        msg_mission_item.seq = i;
        msg_mission_item.current = 0;
        msg_mission_item.autocontinue = 1;
        return msg_mission_item;
    }

    protected static msg_mission_item getRTH(int i) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.command = 20;
        msg_mission_item.frame = 2;
        msg_mission_item.seq = i;
        return msg_mission_item;
    }

    protected static msg_mission_item getLand(double d, double d2, int i) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.command = 21;
        msg_mission_item.seq = i;
        msg_mission_item.param1 = 0.0f;
        msg_mission_item.param3 = 0.0f;
        msg_mission_item.param2 = 0.0f;
        msg_mission_item.param4 = Float.NaN;
        msg_mission_item.f8319x = (float) d;
        msg_mission_item.f8320y = (float) d2;
        msg_mission_item.f8321z = 0.0f;
        msg_mission_item.frame = 3;
        msg_mission_item.current = 0;
        msg_mission_item.autocontinue = 1;
        return msg_mission_item;
    }

    protected static msg_mission_item getMountControl(double d, double d2, double d3, int i) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.command = 205;
        msg_mission_item.seq = i;
        msg_mission_item.param1 = (float) (-d);
        msg_mission_item.param2 = (float) d2;
        msg_mission_item.param3 = (float) d3;
        msg_mission_item.param4 = Float.NaN;
        msg_mission_item.f8319x = Float.NaN;
        msg_mission_item.f8320y = Float.NaN;
        msg_mission_item.f8321z = 2.0f;
        msg_mission_item.frame = 2;
        msg_mission_item.current = 0;
        msg_mission_item.autocontinue = 1;
        return msg_mission_item;
    }

    public MavLinkDialectInterface.GimbalPosePRYYa<Double> getCameraOrientation() {
        msg_mount_orientation msg_mount_orientation = (msg_mount_orientation) this.mavLinkThread.getLatestMessage(msg_mount_orientation.class);
        if (msg_mount_orientation == null) {
            return null;
        }
        MavLinkDialectInterface.GimbalPosePRYYa<Double> gimbalPosePRYYa = new MavLinkDialectInterface.GimbalPosePRYYa<>();
        gimbalPosePRYYa.roll = Double.valueOf((double) msg_mount_orientation.roll);
        gimbalPosePRYYa.pitch = Double.valueOf((double) msg_mount_orientation.pitch);
        gimbalPosePRYYa.yaw = Double.valueOf((double) msg_mount_orientation.yaw);
        gimbalPosePRYYa.yawAbsolute = Double.valueOf((double) msg_mount_orientation.yaw_absolute);
        if (Double.isNaN(((Double) gimbalPosePRYYa.roll).doubleValue())) {
            gimbalPosePRYYa.roll = Double.valueOf(0.0d);
        }
        if (Double.isNaN(((Double) gimbalPosePRYYa.pitch).doubleValue())) {
            gimbalPosePRYYa.pitch = Double.valueOf(0.0d);
        }
        if (!Double.isNaN(((Double) gimbalPosePRYYa.yaw).doubleValue()) && !Double.isNaN(((Double) gimbalPosePRYYa.yawAbsolute).doubleValue())) {
            return gimbalPosePRYYa;
        }
        gimbalPosePRYYa.yaw = Double.valueOf(0.0d);
        gimbalPosePRYYa.yawAbsolute = Double.valueOf(0.0d);
        msg_vfr_hud msg_vfr_hud = (msg_vfr_hud) this.mavLinkThread.getLatestMessage(msg_vfr_hud.class);
        if (msg_vfr_hud == null) {
            return gimbalPosePRYYa;
        }
        gimbalPosePRYYa.yawAbsolute = Double.valueOf((double) msg_vfr_hud.heading);
        return gimbalPosePRYYa;
    }

    public void changeAltitude(float f) {
        float f2;
        try {
            f2 = (float) (((msg_home_position) this.mavLinkThread.getLatestMessage(msg_home_position.class)).altitude / 1000);
        } catch (Exception unused) {
            f2 = 0.0f;
        }
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = this.mavLinkThread.getTargetSystem();
        msg_command_long.target_component = this.mavLinkThread.getTargetComponent();
        msg_command_long.command = 192;
        msg_command_long.param1 = -1.0f;
        msg_command_long.param2 = 1.0f;
        msg_command_long.param3 = 0.0f;
        msg_command_long.param4 = Float.NaN;
        msg_command_long.param5 = Float.NaN;
        msg_command_long.param6 = Float.NaN;
        msg_command_long.param7 = f + f2;
        msg_command_long.confirmation = 0;
        this.mavLinkThread.sendMessage(msg_command_long);
        this.mavLinkThread.sendMessage(msg_command_long);
    }

    public boolean inAir() {
        msg_extended_sys_state msg_extended_sys_state = (msg_extended_sys_state) this.mavLinkThread.getLatestMessage(msg_extended_sys_state.class);
        if (msg_extended_sys_state == null || msg_extended_sys_state.landed_state == 1 || msg_extended_sys_state.landed_state == 0) {
            return false;
        }
        return true;
    }

    public String getModeString() {
        SimplePx4Mode fromLong = SimplePx4Mode.fromLong(this.mavLinkThread.getCurrentMode());
        if (fromLong == null) {
            return "UNKNOWN";
        }
        return fromLong.toString();
    }

    public void setMode(String str) {
        SimplePx4Mode fromValue = SimplePx4Mode.fromValue(str);
        if (fromValue != null) {
            try {
                this.mavLinkThread.sendChangeCustomMode((int) fromValue.getValue());
            } catch (IOException e) {
                String str2 = TAG;
                Log.d(str2, "Error changing Mode: " + str + ". ", e);
            }
        }
    }

    public String[] getModes() {
        return SimplePx4Mode.names;
    }

    public void sendGimbalPosePRY(double d, double d2, double d3) {
        msg_command_long msg_command_long = new msg_command_long();
        msg_command_long.target_system = this.mavLinkThread.getTargetSystem();
        msg_command_long.target_component = this.mavLinkThread.getTargetComponent();
        msg_command_long.command = 205;
        msg_command_long.param1 = (float) d;
        msg_command_long.param2 = (float) d2;
        msg_command_long.param3 = (float) d3;
        msg_command_long.param4 = Float.NaN;
        msg_command_long.param5 = Float.NaN;
        msg_command_long.param6 = Float.NaN;
        msg_command_long.param7 = 2.0f;
        this.mavLinkThread.sendMessage(msg_command_long);
        this.mavLinkThread.sendMessage(msg_command_long);
        this.mavLinkThread.sendMessage(msg_command_long);
    }
}
