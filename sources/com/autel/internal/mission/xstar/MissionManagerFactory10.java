package com.autel.internal.mission.xstar;

import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.xstar.FollowMission;
import com.autel.common.mission.xstar.OrbitMission;
import com.autel.common.mission.xstar.WaypointMission;
import com.autel.sdk.mission.MissionManager;
import com.autel.sdk10.AutelNet.AutelFlyController.parser.FlyControllerStatusInternalParser;

public class MissionManagerFactory10 {
    public static XStarFollowMissionManager createMissionManager(FollowMission followMission) {
        return new XStarFollowMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static XStarOrbitMissionManager createMissionManager(OrbitMission orbitMission) {
        return new XStarOrbitMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static XStarWaypointMissionManager createMissionManager(WaypointMission waypointMission) {
        return new XStarWaypointMissionManager(FlyControllerStatusInternalParser.getInstance_());
    }

    public static MissionManager createMissionManager(C2700AutelMission autelMission) {
        if (autelMission instanceof FollowMission) {
            return createMissionManager((FollowMission) autelMission);
        }
        if (autelMission instanceof OrbitMission) {
            return createMissionManager((OrbitMission) autelMission);
        }
        if (autelMission instanceof WaypointMission) {
            return createMissionManager((WaypointMission) autelMission);
        }
        return null;
    }
}
