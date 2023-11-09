package com.autel.common.mission.evo2;

import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.evo.EvoWaypoint;
import com.autel.common.mission.evo.WaypointAction;
import com.autel.common.mission.evo.WaypointBezierMode;
import com.autel.common.mission.evo.WaypointHeadingMode;
import com.autel.common.mission.evo.WaypointType;
import java.util.List;

public class Evo2Waypoint extends EvoWaypoint {
    public List<WaypointAction> actions;
    public WaypointBezierMode bezierMode = WaypointBezierMode.DISABLE;
    public int cameraPitch;
    public int cameraYaw;
    public int customHeadingDirection;
    public int flyDistance;
    public int flyTime;
    public WaypointHeadingMode headingMode = WaypointHeadingMode.INVALID;
    public int hoverTime;
    public boolean isAltitudePriority;
    public int param1;
    public int param2;
    public int param3;
    public int param4;
    public int param5;
    public int param6;
    public int param7;
    public int poiIndex = -1;
    public int speed;
    public float wSpeed;
    public WaypointType waypointType = WaypointType.STANDARD;

    public Evo2Waypoint(AutelCoordinate3D autelCoordinate3D) {
        super(autelCoordinate3D);
    }
}
