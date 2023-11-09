package com.autel.common.mission.evo2;

public enum Evo2WaypointFinishedAction {
    STOP_ON_LAST_POINT(1),
    RETURN_HOME(2),
    LAND_ON_LAST_POINT(3),
    RETURN_TO_FIRST_POINT(4),
    KEEP_ON_LAST_POINT(5),
    UNKNOWN(0);
    
    private int value;

    private Evo2WaypointFinishedAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static Evo2WaypointFinishedAction find(int i) {
        Evo2WaypointFinishedAction evo2WaypointFinishedAction = STOP_ON_LAST_POINT;
        if (evo2WaypointFinishedAction.value == i) {
            return evo2WaypointFinishedAction;
        }
        Evo2WaypointFinishedAction evo2WaypointFinishedAction2 = RETURN_HOME;
        if (evo2WaypointFinishedAction2.value == i) {
            return evo2WaypointFinishedAction2;
        }
        Evo2WaypointFinishedAction evo2WaypointFinishedAction3 = LAND_ON_LAST_POINT;
        if (evo2WaypointFinishedAction3.value == i) {
            return evo2WaypointFinishedAction3;
        }
        Evo2WaypointFinishedAction evo2WaypointFinishedAction4 = RETURN_TO_FIRST_POINT;
        if (evo2WaypointFinishedAction4.value == i) {
            return evo2WaypointFinishedAction4;
        }
        Evo2WaypointFinishedAction evo2WaypointFinishedAction5 = KEEP_ON_LAST_POINT;
        if (evo2WaypointFinishedAction5.value == i) {
            return evo2WaypointFinishedAction5;
        }
        return UNKNOWN;
    }
}
