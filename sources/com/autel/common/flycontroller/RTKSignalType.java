package com.autel.common.flycontroller;

public enum RTKSignalType {
    NONE(0),
    RTK_M_STATION(1),
    RTK_NET(3),
    RTK_CUSTOM(4),
    UNKNOWN(-1);
    
    private int value;

    private RTKSignalType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static RTKSignalType find(int i) {
        RTKSignalType rTKSignalType = NONE;
        if (rTKSignalType.getValue() == i) {
            return rTKSignalType;
        }
        RTKSignalType rTKSignalType2 = RTK_M_STATION;
        if (rTKSignalType2.getValue() == i) {
            return rTKSignalType2;
        }
        RTKSignalType rTKSignalType3 = RTK_NET;
        if (rTKSignalType3.getValue() == i) {
            return rTKSignalType3;
        }
        RTKSignalType rTKSignalType4 = RTK_CUSTOM;
        if (rTKSignalType4.getValue() == i) {
            return rTKSignalType4;
        }
        return UNKNOWN;
    }
}
