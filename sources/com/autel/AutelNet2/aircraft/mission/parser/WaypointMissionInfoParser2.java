package com.autel.AutelNet2.aircraft.mission.parser;

import com.autel.AutelNet2.aircraft.mission.message.MissionStatusPacket;
import com.autel.common.mission.xstar.Waypoint;
import com.autel.internal.sdk.mission.AutelWaypointRealTimeInfoInternal;
import java.util.ArrayList;
import java.util.List;

public class WaypointMissionInfoParser2 extends AutelWaypointRealTimeInfoInternal {
    private static WaypointMissionInfoParser2 mInstance;
    private List<Waypoint> mission_Autel_waypoints = new ArrayList();

    public void parseData(MissionStatusPacket missionStatusPacket) {
    }

    public static WaypointMissionInfoParser2 getInstance() {
        if (mInstance == null) {
            mInstance = new WaypointMissionInfoParser2();
        }
        return mInstance;
    }

    private WaypointMissionInfoParser2() {
    }

    public void setWaypoints(List<Waypoint> list) {
        this.mission_Autel_waypoints.clear();
        this.mission_Autel_waypoints.addAll(list);
    }

    public void clearWaypoints() {
        this.mission_Autel_waypoints.clear();
    }

    public Waypoint getWaypoint(int i) {
        if (i < 0 || i >= this.mission_Autel_waypoints.size()) {
            return null;
        }
        return this.mission_Autel_waypoints.get(i);
    }

    private void parseMsg(MissionStatusPacket missionStatusPacket) {
        int i = missionStatusPacket.seq;
        if (i >= 0 && i < this.mission_Autel_waypoints.size()) {
            setVelocitySpeed(missionStatusPacket.velocity_sp);
            setSeq(i);
            if (this.mission_Autel_waypoints.size() > 0 && this.mission_Autel_waypoints.get(i) != null) {
                setNextWaypointCoord(this.mission_Autel_waypoints.get(i).getAutelCoordinate3D());
            }
        }
    }
}
