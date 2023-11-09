package com.autel.common.mission.evo;

import com.autel.common.mission.evo2.MotionDelayType;
import com.autel.common.mission.xstar.WaypointFinishedAction;

public class MotionDelayMission extends EvoMission {
    public WaypointFinishedAction finishedAction = WaypointFinishedAction.RETURN_HOME;
    public float horizontalSpeed;
    public MotionDelayType motionDelayType;
    public float rotateSpeed;
    public int totalTime;
    public float verticalSpeed;

    public static MotionDelayMission createMission() {
        return new MotionDelayMission();
    }

    protected MotionDelayMission() {
    }
}
