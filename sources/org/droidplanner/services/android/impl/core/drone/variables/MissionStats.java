package org.droidplanner.services.android.impl.core.drone.variables;

import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class MissionStats extends DroneVariable {
    private int currentWP = -1;
    private double distanceToWp = 0.0d;
    private int lastReachedWP = -1;

    public MissionStats(MavLinkDrone mavLinkDrone) {
        super(mavLinkDrone);
    }

    public void setDistanceToWp(double d) {
        this.distanceToWp = d;
    }

    public void setWpno(int i) {
        if (i != this.currentWP) {
            this.currentWP = i;
            this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.MISSION_WP_UPDATE);
        }
    }

    public void setLastReachedWaypointNumber(int i) {
        if (i != this.lastReachedWP) {
            this.lastReachedWP = i;
            this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.MISSION_WP_REACHED);
        }
    }

    public int getCurrentWP() {
        return this.currentWP;
    }

    public int getLastReachedWP() {
        return this.lastReachedWP;
    }

    public double getDistanceToWP() {
        return this.distanceToWp;
    }
}
