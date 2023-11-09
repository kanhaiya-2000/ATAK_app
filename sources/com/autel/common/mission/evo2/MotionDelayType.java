package com.autel.common.mission.evo2;

public enum MotionDelayType {
    FREE(0),
    ORBIT(1),
    WAYPOINT(2),
    DIRECT(3),
    UNKNOWN(-1);
    
    private int value;

    private MotionDelayType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static MotionDelayType find(int i) {
        MotionDelayType motionDelayType = FREE;
        if (motionDelayType.getValue() == i) {
            return motionDelayType;
        }
        MotionDelayType motionDelayType2 = ORBIT;
        if (motionDelayType2.getValue() == i) {
            return motionDelayType2;
        }
        MotionDelayType motionDelayType3 = WAYPOINT;
        if (motionDelayType3.getValue() == i) {
            return motionDelayType3;
        }
        MotionDelayType motionDelayType4 = DIRECT;
        if (motionDelayType4.getValue() == i) {
            return motionDelayType4;
        }
        return UNKNOWN;
    }
}
