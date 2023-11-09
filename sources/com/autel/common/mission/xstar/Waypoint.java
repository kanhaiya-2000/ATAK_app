package com.autel.common.mission.xstar;

import com.autel.common.mission.AutelCoordinate3D;

public class Waypoint implements Cloneable {
    private AutelCoordinate3D autelCoordinate3D;
    private double delay;

    public Waypoint(AutelCoordinate3D autelCoordinate3D2) {
        this.autelCoordinate3D = autelCoordinate3D2;
    }

    public void setDelay(double d) {
        this.delay = d;
    }

    public double getDelay() {
        return this.delay;
    }

    public void setAutelCoordinate3D(AutelCoordinate3D autelCoordinate3D2) {
        this.autelCoordinate3D = autelCoordinate3D2;
    }

    public AutelCoordinate3D getAutelCoordinate3D() {
        return this.autelCoordinate3D;
    }

    public Waypoint clone() {
        AutelCoordinate3D autelCoordinate3D2 = this.autelCoordinate3D;
        Waypoint waypoint = new Waypoint(autelCoordinate3D2 != null ? new AutelCoordinate3D(autelCoordinate3D2.getLatitude(), this.autelCoordinate3D.getLongitude(), this.autelCoordinate3D.getAltitude()) : null);
        waypoint.setDelay(this.delay);
        return waypoint;
    }

    public String toString() {
        return "delay : " + this.delay + ", autelCoordinate3D : {" + this.autelCoordinate3D + "}";
    }
}
