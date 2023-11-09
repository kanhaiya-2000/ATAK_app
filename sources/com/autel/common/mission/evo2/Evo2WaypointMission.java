package com.autel.common.mission.evo2;

import com.autel.common.mission.evo.EvoMission;
import java.util.List;

public class Evo2WaypointMission extends EvoMission {
    public int DoubleGridEnable;
    public double DroneAltitude;
    public double DroneLatitude;
    public double DroneLongitude;
    public int ExecuteIndex;
    public int ExecutePhotos;
    public String GUID;
    public float HorizontalFOV;
    public String MissionName;
    public int NumberVertexPoints;
    public int PhotoIntervalMin;
    public float VerticalFOV;
    public int altitudeType;
    public int autoAngel;
    public Evo2WaypointFinishedAction finishedAction = Evo2WaypointFinishedAction.RETURN_HOME;
    public int missionAction;
    public int totalDistance;
    public int totalFlyTime;
    public List<Vertex> vertexList;
    public List<Evo2Waypoint> wpList;
    public List<Poi> wpoiList;

    public String toString() {
        return "wpList : " + this.wpList + ", avoidanceMode : " + this.avoidanceMode + ", obstacleAvoidanceTimeout : " + this.obstacleAvoidanceTimeout + ", remoteControlLostSignalAction : " + this.remoteControlLostSignalAction + ", finishedAction : " + this.finishedAction;
    }
}
