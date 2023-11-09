package com.autel.common.mission.evo;

import android.location.Location;
import com.autel.common.mission.FollowFinishedAction;
import com.autel.internal.sdk.mission.evo.EvoFollowMissionWithUpdate;

public class EvoFollowMission extends EvoMission {
    public boolean canInvertedFlight;
    public int customHeading;
    public FollowFinishedAction finishedAction = FollowFinishedAction.RETURN_HOME;
    public GroundFollowMode groundFollowMode = GroundFollowMode.UNKNOWN;
    public Location location;
    public FollowAttitudeMode mFollowAttitudeMode = FollowAttitudeMode.UNKNOWN;
    public FollowHeadingMode mFollowHeadingMode = FollowHeadingMode.UNKNOWN;
    public OrbitRotateDirection orbitDirection = OrbitRotateDirection.UNKNOWN;
    public int orbitRadius;
    public int orbitSpeed;

    protected EvoFollowMission() {
    }

    public static EvoFollowMission create() {
        return new EvoFollowMissionWithUpdate();
    }
}
