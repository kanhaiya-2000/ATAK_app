package org.droidplanner.services.android.impl.core.drone.variables;

import com.atakmap.android.uastool.mavlink.MAVLinkPrefHandler;
import java.util.ArrayList;
import java.util.List;

public enum ApmModes {
    FIXED_WING_MANUAL(0, "Manual", 1),
    FIXED_WING_CIRCLE(1, "Circle", 1),
    FIXED_WING_STABILIZE(2, "Stabilize", 1),
    FIXED_WING_TRAINING(3, "Training", 1),
    FIXED_WING_ACRO(4, "Acro", 1),
    FIXED_WING_FLY_BY_WIRE_A(5, "FBW A", 1),
    FIXED_WING_FLY_BY_WIRE_B(6, "FBW B", 1),
    FIXED_WING_CRUISE(7, "Cruise", 1),
    FIXED_WING_AUTOTUNE(8, "AutoTune", 1),
    FIXED_WING_AUTO(10, "Auto", 1),
    FIXED_WING_RTL(11, "RTL", 1),
    FIXED_WING_LOITER(12, "Loiter", 1),
    FIXED_WING_GUIDED(15, "Guided", 1),
    ROTOR_STABILIZE(0, "Stabilize", 2),
    ROTOR_ACRO(1, "Acro", 2),
    ROTOR_ALT_HOLD(2, "Alt Hold", 2),
    ROTOR_AUTO(3, "Auto", 2),
    ROTOR_GUIDED(4, "Guided", 2),
    ROTOR_LOITER(5, "Loiter", 2),
    ROTOR_RTL(6, "RTL", 2),
    ROTOR_CIRCLE(7, "Circle", 2),
    ROTOR_LAND(9, "Land", 2),
    ROTOR_TOY(11, "Drift", 2),
    ROTOR_SPORT(13, "Sport", 2),
    ROTOR_AUTOTUNE(15, "Autotune", 2),
    ROTOR_POSHOLD(16, "PosHold", 2),
    ROTOR_BRAKE(17, "Brake", 2),
    ROVER_MANUAL(0, "MANUAL", 10),
    ROVER_LEARNING(2, "LEARNING", 10),
    ROVER_STEERING(3, "STEERING", 10),
    ROVER_HOLD(4, "HOLD", 10),
    ROVER_AUTO(10, MAVLinkPrefHandler.DEFAULT_MAVLINK_DIALECT, 10),
    ROVER_RTL(11, "RTL", 10),
    ROVER_GUIDED(15, "GUIDED", 10),
    ROVER_INITIALIZING(16, "INITIALIZING", 10),
    UNKNOWN(-1, "Unknown", 0);
    
    private final String name;
    private final long number;
    private final int type;

    public static boolean isCopter(int i) {
        if (i == 2 || i == 4) {
            return true;
        }
        switch (i) {
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    private ApmModes(long j, String str, int i) {
        this.number = j;
        this.name = str;
        this.type = i;
    }

    public long getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public static ApmModes getMode(long j, int i) {
        if (isCopter(i)) {
            i = 2;
        }
        for (ApmModes apmModes : values()) {
            if (j == apmModes.getNumber() && i == apmModes.getType()) {
                return apmModes;
            }
        }
        return UNKNOWN;
    }

    public static ApmModes getMode(String str, int i) {
        if (isCopter(i)) {
            i = 2;
        }
        for (ApmModes apmModes : values()) {
            if (str.equals(apmModes.getName()) && i == apmModes.getType()) {
                return apmModes;
            }
        }
        return UNKNOWN;
    }

    public static List<ApmModes> getModeList(int i) {
        ArrayList arrayList = new ArrayList();
        if (isCopter(i)) {
            i = 2;
        }
        for (ApmModes apmModes : values()) {
            if (apmModes.getType() == i) {
                arrayList.add(apmModes);
            }
        }
        return arrayList;
    }

    public static boolean isValid(ApmModes apmModes) {
        return apmModes != UNKNOWN;
    }
}
