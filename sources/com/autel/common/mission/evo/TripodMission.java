package com.autel.common.mission.evo;

import com.autel.common.mission.xstar.WaypointFinishedAction;
import com.autel.internal.sdk.mission.evo2.TripodMissionWithUpdate;

public class TripodMission extends EvoMission {
    public WaypointFinishedAction finishedAction = WaypointFinishedAction.RETURN_HOME;
    public float horizontalSpeed;
    public float rotateSpeed;
    public float verticalSpeed;

    public static TripodMission createMission() {
        return new TripodMissionWithUpdate();
    }

    protected TripodMission() {
    }
}
