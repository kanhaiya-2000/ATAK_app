package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.util.MathUtils;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.Location;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;

public class FollowCircle extends FollowWithRadiusAlgorithm {
    private double circleAngle = 0.0d;
    private double circleStep = 2.0d;

    public FollowCircle(MavLinkDroneManager mavLinkDroneManager, Handler handler, double d, double d2) {
        super(mavLinkDroneManager, handler, d);
        this.circleStep = d2;
    }

    public FollowAlgorithm.FollowModes getType() {
        return FollowAlgorithm.FollowModes.CIRCLE;
    }

    public void processNewLocation(Location location) {
        LatLong newCoordFromBearingAndDistance = GeoTools.newCoordFromBearingAndDistance(new LatLong(location.getCoord()), this.circleAngle, this.radius);
        this.circleAngle = MathUtils.constrainAngle(this.circleAngle + this.circleStep);
        this.drone.getGuidedPoint().newGuidedCoord(newCoordFromBearingAndDistance);
    }
}
