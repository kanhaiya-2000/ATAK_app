package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;

public class FollowLead extends FollowHeadingAngle {
    public FollowLead(MavLinkDroneManager mavLinkDroneManager, Handler handler, double d) {
        super(mavLinkDroneManager, handler, d, 0.0d);
    }

    public FollowAlgorithm.FollowModes getType() {
        return FollowAlgorithm.FollowModes.LEAD;
    }
}
