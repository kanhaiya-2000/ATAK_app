package com.autel.common.mission.evo;

import com.autel.common.mission.MissionType;
import com.autel.common.mission.xstar.WaypointFinishedAction;
import com.autel.internal.sdk.mission.evo2.ImageStabilityMissionWithUpdate;

public class ImageStabilityMission extends EvoMission {
    public WaypointFinishedAction finishedAction = WaypointFinishedAction.RETURN_HOME;

    public static ImageStabilityMission createMission() {
        return new ImageStabilityMissionWithUpdate();
    }

    protected ImageStabilityMission() {
        this.missionType = MissionType.IMAGE_STABILITY;
    }
}
