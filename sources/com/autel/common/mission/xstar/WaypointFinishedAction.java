package com.autel.common.mission.xstar;

public enum WaypointFinishedAction {
    HOVER(0),
    RETURN_HOME(1),
    UNKNOWN(-1);
    
    private int value;

    private WaypointFinishedAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static WaypointFinishedAction find(int i) {
        WaypointFinishedAction waypointFinishedAction = HOVER;
        if (waypointFinishedAction.getValue() == i) {
            return waypointFinishedAction;
        }
        WaypointFinishedAction waypointFinishedAction2 = RETURN_HOME;
        if (waypointFinishedAction2.getValue() == i) {
            return waypointFinishedAction2;
        }
        return UNKNOWN;
    }
}
