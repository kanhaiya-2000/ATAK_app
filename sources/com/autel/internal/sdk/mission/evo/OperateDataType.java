package com.autel.internal.sdk.mission.evo;

public enum OperateDataType {
    ALL(1),
    TASK(2),
    WAYPOINT(3),
    ACTION(4),
    ORBIT(5),
    CYLINER(6),
    PANORAMA(7),
    UNKNOWN(-1);
    
    private final int value;

    private OperateDataType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
