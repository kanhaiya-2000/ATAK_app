package com.autel.common.mission.xstar;

import com.autel.common.mission.C2700AutelMission;
import java.util.List;

public class WaypointMission extends C2700AutelMission {
    public WaypointFinishedAction finishedAction = WaypointFinishedAction.RETURN_HOME;
    public int speed;
    public List<Waypoint> wpList;

    public String toString() {
        return "speed : " + this.speed + ", wpList : " + this.wpList + ", finishedAction : " + this.finishedAction;
    }
}
