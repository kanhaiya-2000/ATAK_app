package com.autel.common.mission.evo;

public enum EvoWaypointFinishedAction {
    STOP_ON_LAST_POINT(1),
    RETURN_HOME(2),
    LAND_ON_LAST_POINT(3),
    RETURN_TO_FIRST_POINT(4),
    KEEP_ON_LAST_POINT(5),
    UNKNOWN(0);
    
    private int value;

    private EvoWaypointFinishedAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static EvoWaypointFinishedAction find(int i) {
        EvoWaypointFinishedAction evoWaypointFinishedAction = STOP_ON_LAST_POINT;
        if (evoWaypointFinishedAction.value == i) {
            return evoWaypointFinishedAction;
        }
        EvoWaypointFinishedAction evoWaypointFinishedAction2 = RETURN_HOME;
        if (evoWaypointFinishedAction2.value == i) {
            return evoWaypointFinishedAction2;
        }
        EvoWaypointFinishedAction evoWaypointFinishedAction3 = LAND_ON_LAST_POINT;
        if (evoWaypointFinishedAction3.value == i) {
            return evoWaypointFinishedAction3;
        }
        EvoWaypointFinishedAction evoWaypointFinishedAction4 = RETURN_TO_FIRST_POINT;
        if (evoWaypointFinishedAction4.value == i) {
            return evoWaypointFinishedAction4;
        }
        EvoWaypointFinishedAction evoWaypointFinishedAction5 = KEEP_ON_LAST_POINT;
        if (evoWaypointFinishedAction5.value == i) {
            return evoWaypointFinishedAction5;
        }
        return UNKNOWN;
    }
}
