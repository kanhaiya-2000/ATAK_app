package com.bbn.ccast.mavlink;

import com.atakmap.android.uastool.MAVLink.common.msg_command_ack;
import com.bbn.ccast.mavlink.MavLinkThread;
import com.bbn.vehicleinterface.types.ResultCallback;

public interface MavLinkDialectInterface {
    public static final int MAV_AUTOPILOT_SARCOS = 20;

    public enum ParamSettings {
        TAKEOFF_ALT,
        GEOFENCE_ACTION,
        MAX_DIST,
        MAX_ALT,
        MAX_VEL,
        RETURN_ALT,
        DATALINK_LOST_ACTION,
        DATALINK_LOST_WITHRC_ACTION,
        LOW_BATTERY_ACTION,
        BATERY_CRITCAL_PERCENT,
        BATERY_EMERGENCY_PERCENT,
        BATTERY_LOW_PERCENT,
        CRUSE_VEL,
        MAX_MANUAL_VEL
    }

    void changeAltitude(float f);

    void enterMissionMode(ResultCallback<Void> resultCallback);

    void enterPositionHoldMode();

    void enterReturnToHomeMode(ResultCallback<Void> resultCallback);

    GimbalPosePRYYa<Double> getCameraOrientation();

    String getModeString();

    String[] getModes();

    String getParamName(ParamSettings paramSettings);

    void handleTakeoffAck(msg_command_ack msg_command_ack);

    boolean inAir();

    boolean inPositionHoldMode();

    boolean isInMissionMode();

    void land();

    void moveGuided(float f, float f2, float f3);

    void orbit(float f, float f2, float f3, float f4);

    void sendGimbalPosePRY(double d, double d2, double d3);

    void setMode(String str);

    void startTakeoffProcess(Double d, MavLinkThread.TakeoffCallback takeoffCallback);

    public enum MavModeFlag {
        MAV_MODE_FLAG_SAFETY_ARMED(128),
        MAV_MODE_FLAG_MANUAL_INPUT_ENABLED(64),
        MAV_MODE_FLAG_HIL_ENABLED(32),
        MAV_MODE_FLAG_STABILIZE_ENABLED(16),
        MAV_MODE_FLAG_GUIDED_ENABLED(8),
        MAV_MODE_FLAG_AUTO_ENABLED(4),
        MAV_MODE_FLAG_TEST_ENABLED(2),
        MAV_MODE_FLAG_CUSTOM_MODE_ENABLED(1);
        
        private final int value;

        private MavModeFlag(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum CustomRoverMode {
        MANUAL(0),
        ACRO(1),
        LEARNING(2),
        STEERING(3),
        HOLD(4),
        LOITER(5),
        AUTO(10),
        RTL(11),
        SMART_RTL(12),
        GUIDED(15),
        INITIALISING(16);
        
        private final int value;

        private CustomRoverMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum CustomSoloMode {
        STABILIZE(0),
        ACRO(1),
        ALT_HOLD(2),
        AUTO(3),
        GUIDED(4),
        LOITER(5),
        RTL(6),
        CIRCLE(7),
        POSITION(8),
        LAND(9),
        OF_LOITER(10),
        DRIFT(11),
        MODE_12(12),
        SPORT(13),
        FLIP(14),
        AUTOTUNE(15),
        POSHOLD(16),
        BRAKE(17),
        THROW(18),
        AVOID_ADSB(19),
        GUIDED_NO_GPS(20),
        SMART_RTL(21),
        FLOWHOLD(22);
        
        public static final String[] names = null;
        public static final CustomSoloMode[] values = null;
        private final int value;

        static {
            CustomSoloMode[] values2 = values();
            values = values2;
            names = new String[values2.length];
            int i = 0;
            while (true) {
                CustomSoloMode[] customSoloModeArr = values;
                if (i < customSoloModeArr.length) {
                    names[i] = customSoloModeArr[i].name();
                    i++;
                } else {
                    return;
                }
            }
        }

        private CustomSoloMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static CustomSoloMode fromInt(int i) {
            try {
                CustomSoloMode[] customSoloModeArr = values;
                if (i < customSoloModeArr.length) {
                    return customSoloModeArr[i];
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        public static CustomSoloMode fromValue(String str) {
            if (str == null) {
                return null;
            }
            for (CustomSoloMode customSoloMode : values()) {
                if (customSoloMode.name().equals(str)) {
                    return customSoloMode;
                }
            }
            return null;
        }
    }

    public static class GimbalPosePRYYa<Type> {
        private boolean defaults;
        public Type pitch;
        private Type pitchDef;
        public Type roll;
        private Type rollDef;
        public Type yaw;
        public Type yawAbsolute;
        private Type yawAbsoluteDef;
        private Type yawDef;

        public GimbalPosePRYYa() {
            this.defaults = false;
        }

        public GimbalPosePRYYa(Type type, Type type2, Type type3, Type type4) {
            this.defaults = false;
            this.defaults = true;
            this.roll = type;
            this.pitch = type2;
            this.yaw = type3;
            this.yawAbsolute = type4;
        }

        public void init() {
            if (this.defaults) {
                this.roll = this.rollDef;
                this.pitch = this.pitchDef;
                this.yaw = this.yawDef;
                this.yawAbsolute = this.yawAbsoluteDef;
            }
        }

        public String toString() {
            return "roll=" + this.roll + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", yawAbsolute=" + this.yawAbsolute;
        }
    }

    public enum dialectType {
        AUTO(0),
        PX4(1),
        APM(2);
        
        public static final String[] names = null;
        public static final dialectType[] values = null;
        public int index;

        static {
            int i;
            dialectType[] values2 = values();
            values = values2;
            names = new String[values2.length];
            while (true) {
                dialectType[] dialecttypeArr = values;
                if (i < dialecttypeArr.length) {
                    names[i] = dialecttypeArr[i].name();
                    i++;
                } else {
                    return;
                }
            }
        }

        private dialectType(int i) {
            this.index = i;
        }

        public static dialectType fromValue(String str) {
            if (str == null) {
                return AUTO;
            }
            for (dialectType dialecttype : values()) {
                if (dialecttype.name().equals(str)) {
                    return dialecttype;
                }
            }
            return AUTO;
        }
    }
}
