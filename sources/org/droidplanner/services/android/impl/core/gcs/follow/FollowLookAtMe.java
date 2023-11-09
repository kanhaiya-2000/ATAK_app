package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.Location;

public class FollowLookAtMe extends FollowAlgorithm {
    /* access modifiers changed from: protected */
    public void processNewLocation(Location location) {
    }

    public FollowLookAtMe(MavLinkDroneManager mavLinkDroneManager, Handler handler) {
        super(mavLinkDroneManager, handler);
    }

    public FollowAlgorithm.FollowModes getType() {
        return FollowAlgorithm.FollowModes.LOOK_AT_ME;
    }
}
