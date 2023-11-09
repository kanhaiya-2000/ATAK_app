package com.autel.common.mission.evo;

import java.util.List;

public class EvoWaypointMission extends EvoMission {
    public EvoWaypointFinishedAction finishedAction = EvoWaypointFinishedAction.RETURN_HOME;
    public List<EvoWaypoint> wpList;

    public String toString() {
        return "wpList : " + this.wpList + ", avoidanceMode : " + this.avoidanceMode + ", obstacleAvoidanceTimeout : " + this.obstacleAvoidanceTimeout + ", remoteControlLostSignalAction : " + this.remoteControlLostSignalAction + ", finishedAction : " + this.finishedAction;
    }
}
