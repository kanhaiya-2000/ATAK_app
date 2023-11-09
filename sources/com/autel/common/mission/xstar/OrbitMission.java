package com.autel.common.mission.xstar;

import com.autel.common.mission.C2700AutelMission;
import com.autel.common.mission.OrbitFinishedAction;

public class OrbitMission extends C2700AutelMission {
    public OrbitFinishedAction finishedAction = OrbitFinishedAction.RETURN_HOME;
    public short laps;
    public double lat;
    public double lng;
    public float radius;
    public float speed;

    public String toString() {
        return "radius : " + this.radius + ", speed : " + this.speed + ", laps : " + this.laps + ", finishedAction : " + this.finishedAction + ", latitude : " + this.lat + ", longitude : " + this.lng;
    }
}
