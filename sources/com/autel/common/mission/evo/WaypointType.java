package com.autel.common.mission.evo;

public enum WaypointType {
    STANDARD(0),
    CIRCLE_BY_NUMBER(6),
    MAPPING(9),
    HOVER(12),
    UNKNOWN(-1);
    
    private int value;

    private WaypointType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static WaypointType find(int i) {
        WaypointType waypointType = STANDARD;
        if (waypointType.value == i) {
            return waypointType;
        }
        WaypointType waypointType2 = CIRCLE_BY_NUMBER;
        if (waypointType2.value == i) {
            return waypointType2;
        }
        WaypointType waypointType3 = MAPPING;
        if (waypointType3.value == i) {
            return waypointType3;
        }
        WaypointType waypointType4 = HOVER;
        if (waypointType4.value == i) {
            return waypointType4;
        }
        return UNKNOWN;
    }
}
