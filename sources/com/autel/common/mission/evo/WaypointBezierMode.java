package com.autel.common.mission.evo;

public enum WaypointBezierMode {
    DISABLE(0),
    COUNTERCLOCKWISE(1),
    CLOCKWISE(2),
    UNKNOWN(-1);
    
    private int value;

    private WaypointBezierMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static WaypointBezierMode find(int i) {
        WaypointBezierMode waypointBezierMode = DISABLE;
        if (waypointBezierMode.value == i) {
            return waypointBezierMode;
        }
        WaypointBezierMode waypointBezierMode2 = COUNTERCLOCKWISE;
        if (waypointBezierMode2.value == i) {
            return waypointBezierMode2;
        }
        WaypointBezierMode waypointBezierMode3 = CLOCKWISE;
        if (waypointBezierMode3.value == i) {
            return waypointBezierMode3;
        }
        return UNKNOWN;
    }
}
