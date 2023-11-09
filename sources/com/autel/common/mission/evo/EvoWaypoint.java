package com.autel.common.mission.evo;

import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.xstar.Waypoint;
import java.util.List;

public class EvoWaypoint extends Waypoint {
    public List<WaypointAction> actions;
    public WaypointBezierMode bezierMode = WaypointBezierMode.DISABLE;
    public int cameraPitch;
    public int cameraYaw;
    public int customHeadingDirection;
    public double focusAltitude;
    public double focusLatitude;
    public double focusLongitude;
    public WaypointHeadingMode headingMode = WaypointHeadingMode.INVALID;
    public boolean isAltitudePriority;
    public int speed;
    public float wSpeed;
    public WaypointType waypointType = WaypointType.STANDARD;

    public EvoWaypoint(AutelCoordinate3D autelCoordinate3D) {
        super(autelCoordinate3D);
    }
}
