package com.autel.internal.sdk.mission;

import com.autel.common.mission.FollowFinishedAction;
import com.autel.common.mission.OrbitFinishedAction;
import com.autel.common.mission.xstar.WaypointFinishedAction;

public enum MissionFinishedAction {
    HOVER(0),
    RETURN_HOME(1),
    RETURN_TO_MY_LOCATION(2),
    UNKNOWN(-1);
    
    private int value;

    private MissionFinishedAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static MissionFinishedAction find(int i) {
        MissionFinishedAction missionFinishedAction = HOVER;
        if (missionFinishedAction.getValue() == i) {
            return missionFinishedAction;
        }
        MissionFinishedAction missionFinishedAction2 = RETURN_HOME;
        if (missionFinishedAction2.getValue() == i) {
            return missionFinishedAction2;
        }
        MissionFinishedAction missionFinishedAction3 = RETURN_TO_MY_LOCATION;
        if (missionFinishedAction3.getValue() == i) {
            return missionFinishedAction3;
        }
        return UNKNOWN;
    }

    public static MissionFinishedAction convert(FollowFinishedAction followFinishedAction) {
        if (followFinishedAction == FollowFinishedAction.RETURN_HOME) {
            return RETURN_HOME;
        }
        if (followFinishedAction == FollowFinishedAction.RETURN_TO_MY_LOCATION) {
            return RETURN_TO_MY_LOCATION;
        }
        return UNKNOWN;
    }

    public static MissionFinishedAction convert(OrbitFinishedAction orbitFinishedAction) {
        if (orbitFinishedAction == OrbitFinishedAction.RETURN_HOME) {
            return RETURN_HOME;
        }
        if (orbitFinishedAction == OrbitFinishedAction.HOVER) {
            return HOVER;
        }
        return UNKNOWN;
    }

    public static MissionFinishedAction convert(WaypointFinishedAction waypointFinishedAction) {
        if (waypointFinishedAction == WaypointFinishedAction.RETURN_HOME) {
            return RETURN_HOME;
        }
        if (waypointFinishedAction == WaypointFinishedAction.HOVER) {
            return HOVER;
        }
        return UNKNOWN;
    }
}
