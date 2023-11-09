package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import com.o3dr.services.android.lib.coordinate.LatLong;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.Location;

public class FollowSplineAbove extends FollowAlgorithm {
    private final MavLinkDrone drone;

    public void processNewLocation(Location location) {
        LatLong latLong = new LatLong(location.getCoord());
        double speed = location.getSpeed();
        double radians = Math.toRadians(location.getBearing());
        this.drone.getGuidedPoint().newGuidedCoordAndVelocity(latLong, Math.cos(radians) * speed, Math.sin(radians) * speed, 0.0d);
    }

    public FollowAlgorithm.FollowModes getType() {
        return FollowAlgorithm.FollowModes.SPLINE_ABOVE;
    }

    public FollowSplineAbove(MavLinkDroneManager mavLinkDroneManager, Handler handler) {
        super(mavLinkDroneManager, handler);
        this.drone = (MavLinkDrone) mavLinkDroneManager.getDrone();
    }
}
