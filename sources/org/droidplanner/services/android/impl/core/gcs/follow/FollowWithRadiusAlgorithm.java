package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import java.util.HashMap;
import java.util.Map;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;

public abstract class FollowWithRadiusAlgorithm extends FollowAlgorithm {
    public static final String EXTRA_FOLLOW_RADIUS = "extra_follow_radius";
    protected final MavLinkDrone drone;
    protected double radius;

    public FollowWithRadiusAlgorithm(MavLinkDroneManager mavLinkDroneManager, Handler handler, double d) {
        super(mavLinkDroneManager, handler);
        this.radius = d;
        this.drone = (MavLinkDrone) mavLinkDroneManager.getDrone();
    }

    public Map<String, Object> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("extra_follow_radius", Double.valueOf(this.radius));
        return hashMap;
    }

    public void updateAlgorithmParams(Map<String, ?> map) {
        super.updateAlgorithmParams(map);
        Double d = (Double) map.get("extra_follow_radius");
        if (d != null) {
            this.radius = Math.max(0.0d, d.doubleValue());
        }
    }
}
