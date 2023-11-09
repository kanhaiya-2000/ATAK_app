package com.autel.common.gimbal;

public enum GimbalRollAngleAdjust {
    PLUS(1),
    MINUS(2),
    RESET(3),
    QUERY(4),
    UNKNOWN(-1);
    
    private int value;

    private GimbalRollAngleAdjust(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static GimbalRollAngleAdjust find(int i) {
        GimbalRollAngleAdjust gimbalRollAngleAdjust = PLUS;
        if (gimbalRollAngleAdjust.getValue() == i) {
            return gimbalRollAngleAdjust;
        }
        GimbalRollAngleAdjust gimbalRollAngleAdjust2 = MINUS;
        if (gimbalRollAngleAdjust2.getValue() == i) {
            return gimbalRollAngleAdjust2;
        }
        GimbalRollAngleAdjust gimbalRollAngleAdjust3 = RESET;
        if (gimbalRollAngleAdjust3.getValue() == i) {
            return gimbalRollAngleAdjust3;
        }
        GimbalRollAngleAdjust gimbalRollAngleAdjust4 = QUERY;
        if (gimbalRollAngleAdjust4.getValue() == i) {
            return gimbalRollAngleAdjust4;
        }
        return null;
    }
}
