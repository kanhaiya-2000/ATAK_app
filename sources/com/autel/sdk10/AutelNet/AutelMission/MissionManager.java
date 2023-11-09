package com.autel.sdk10.AutelNet.AutelMission;

import com.autel.internal.sdk.mission.AutelOrbitRealTimeInfoInternal;
import com.autel.internal.sdk.mission.AutelWaypointRealTimeInfoInternal;
import com.autel.internal.sdk.mission.MissionState;
import com.autel.sdk10.AutelNet.AutelMission.info.AutelMissionInfo;
import com.autel.sdk10.AutelNet.AutelMission.parser.MissionInfoParser;
import com.autel.sdk10.AutelNet.AutelMission.parser.MissionStateParser;
import com.autel.sdk10.AutelNet.AutelMission.parser.OrbitMissionInfoParser;
import com.autel.sdk10.AutelNet.AutelMission.parser.WaypointMissionInfoInternalParser;
import com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelFollowMissionRequestManager;
import com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelMissionCommonRequestManager;
import com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelOrbitMissionRequestManager;
import com.autel.sdk10.AutelNet.AutelMission.requestmanager.AutelWaypointMissionRequestManager;

public final class MissionManager {
    private static AutelFollowMissionRequestManager followMeMissionRequestManager;
    private static AutelMissionCommonRequestManager missonCommonRequestManager;
    private static AutelOrbitMissionRequestManager orbitMissionRequestManager;
    private static AutelWaypointMissionRequestManager waypointMissionRequestManager;

    private MissionManager() {
    }

    public static AutelMissionCommonRequestManager getAutelMissonCommonRequestManager() {
        if (missonCommonRequestManager == null) {
            missonCommonRequestManager = new AutelMissionCommonRequestManager();
        }
        return missonCommonRequestManager;
    }

    public static AutelOrbitMissionRequestManager getAutelOrbitMissionRequestManager() {
        if (orbitMissionRequestManager == null) {
            orbitMissionRequestManager = new AutelOrbitMissionRequestManager();
        }
        return orbitMissionRequestManager;
    }

    public static AutelFollowMissionRequestManager getAutelFollowMissionRequestManager() {
        if (followMeMissionRequestManager == null) {
            followMeMissionRequestManager = new AutelFollowMissionRequestManager();
        }
        return followMeMissionRequestManager;
    }

    public static AutelWaypointMissionRequestManager getAutelWaypointMissionRequestManager() {
        if (waypointMissionRequestManager == null) {
            waypointMissionRequestManager = new AutelWaypointMissionRequestManager();
        }
        return waypointMissionRequestManager;
    }

    public static AutelMissionInfo getAutelMissionInfo() {
        return MissionInfoParser.getInstance_();
    }

    public static MissionInfoParser getAutelMissionInfoParser() {
        return MissionInfoParser.getInstance_();
    }

    public static MissionState getMissionState() {
        return MissionStateParser.getInstance_();
    }

    public static MissionStateParser getMissionStateParser() {
        return MissionStateParser.getInstance_();
    }

    public static AutelWaypointRealTimeInfoInternal getAutelWaypointRealtimeInfo() {
        return WaypointMissionInfoInternalParser.getInstance_();
    }

    public static WaypointMissionInfoInternalParser getAutelWaypointMissionInfoParser() {
        return WaypointMissionInfoInternalParser.getInstance_();
    }

    public static AutelOrbitRealTimeInfoInternal getAutelOrbitRealtimeInfo() {
        return OrbitMissionInfoParser.getInstance_();
    }

    public static OrbitMissionInfoParser getAutelOrbitMissionInfoParser() {
        return OrbitMissionInfoParser.getInstance_();
    }
}
