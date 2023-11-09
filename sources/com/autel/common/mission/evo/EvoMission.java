package com.autel.common.mission.evo;

import com.autel.common.mission.C2700AutelMission;

public class EvoMission extends C2700AutelMission {
    public ObstacleAvoidanceMode avoidanceMode = ObstacleAvoidanceMode.INVALID;
    public int obstacleAvoidanceTimeout;
    public RemoteControlLostSignalAction remoteControlLostSignalAction = RemoteControlLostSignalAction.INVALID;
}
