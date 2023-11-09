package com.autel.common.mission.evo;

public enum WaypointHeadingMode {
    INVALID(0),
    FORWARD_TO_NEXT_POINT(1),
    KEEP_ORIGIN_DIRECTION(2),
    CUSTOM_DIRECTION(3),
    CUSTOM_FREE(4),
    UNKNOWN(-1);
    
    private int value;

    private WaypointHeadingMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static WaypointHeadingMode find(int i) {
        WaypointHeadingMode waypointHeadingMode = INVALID;
        if (waypointHeadingMode.value == i) {
            return waypointHeadingMode;
        }
        WaypointHeadingMode waypointHeadingMode2 = FORWARD_TO_NEXT_POINT;
        if (waypointHeadingMode2.value == i) {
            return waypointHeadingMode2;
        }
        WaypointHeadingMode waypointHeadingMode3 = KEEP_ORIGIN_DIRECTION;
        if (waypointHeadingMode3.value == i) {
            return waypointHeadingMode3;
        }
        WaypointHeadingMode waypointHeadingMode4 = CUSTOM_DIRECTION;
        if (waypointHeadingMode4.value == i) {
            return waypointHeadingMode4;
        }
        WaypointHeadingMode waypointHeadingMode5 = CUSTOM_FREE;
        if (waypointHeadingMode5.value == i) {
            return waypointHeadingMode5;
        }
        return UNKNOWN;
    }
}
