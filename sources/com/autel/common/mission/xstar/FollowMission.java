package com.autel.common.mission.xstar;

import android.location.Location;
import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.FollowFinishedAction;
import com.autel.internal.sdk.mission.FollowMissionWithUpdate;

public class FollowMission extends C2700AutelMission {
    public FollowFinishedAction finishedAction = FollowFinishedAction.RETURN_HOME;
    public Location location;

    public void update(Location location2) {
    }

    protected FollowMission() {
    }

    public static FollowMission create() {
        return new FollowMissionWithUpdate();
    }

    public String toString() {
        return "latitude : " + this.location.getLatitude() + ", lon : " + this.location.getLongitude() + ",alt : " + this.location.getAltitude();
    }
}
