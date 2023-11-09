package com.autel.common.mission.evo;

import com.autel.common.mission.xstar.WaypointFinishedAction;
import com.autel.internal.sdk.mission.VideoType;
import com.autel.internal.sdk.mission.evo2.OneShotVideoMissionWithUpdate;

public class OneShotVideoMission extends EvoMission {
    public int cycles;
    public WaypointFinishedAction finishedAction = WaypointFinishedAction.RETURN_HOME;
    public int moveDistance;
    public int moveSpeed;
    public int rotateDirection;
    public int rotateSpeed;
    public VideoType videoType = VideoType.UNKNOWN;

    public static OneShotVideoMission createMission() {
        return new OneShotVideoMissionWithUpdate();
    }

    protected OneShotVideoMission() {
    }
}
