package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import com.o3dr.services.android.lib.coordinate.LatLong;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.Location;

public class FollowAbove extends FollowAlgorithm {
    protected final MavLinkDrone drone;

    public FollowAbove(MavLinkDroneManager mavLinkDroneManager, Handler handler) {
        super(mavLinkDroneManager, handler);
        this.drone = (MavLinkDrone) mavLinkDroneManager.getDrone();
    }

    public FollowAlgorithm.FollowModes getType() {
        return FollowAlgorithm.FollowModes.ABOVE;
    }

    /* access modifiers changed from: protected */
    public void processNewLocation(Location location) {
        this.drone.getGuidedPoint().newGuidedCoord(new LatLong(location.getCoord()));
    }
}
