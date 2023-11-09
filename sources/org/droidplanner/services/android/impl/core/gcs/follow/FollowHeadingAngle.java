package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import com.o3dr.services.android.lib.coordinate.LatLong;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.location.Location;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;

public abstract class FollowHeadingAngle extends FollowWithRadiusAlgorithm {
    protected double angleOffset;
    protected final MavLinkDrone drone;

    protected FollowHeadingAngle(MavLinkDroneManager mavLinkDroneManager, Handler handler, double d, double d2) {
        super(mavLinkDroneManager, handler, d);
        this.angleOffset = d2;
        this.drone = (MavLinkDrone) mavLinkDroneManager.getDrone();
    }

    public void processNewLocation(Location location) {
        this.drone.getGuidedPoint().newGuidedCoord(GeoTools.newCoordFromBearingAndDistance(new LatLong(location.getCoord()), location.getBearing() + this.angleOffset, this.radius));
    }
}
