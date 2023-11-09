package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.HashMap;
import java.util.Map;
import org.droidplanner.services.android.impl.core.MAVLink.command.doCmd.MavLinkDoCmds;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.Location;
import org.droidplanner.services.android.impl.core.gcs.roi.ROIEstimator;

public class FollowGuidedScan extends FollowAbove {
    public static final double DEFAULT_FOLLOW_ROI_ALTITUDE = 10.0d;
    public static final String EXTRA_FOLLOW_ROI_TARGET = "extra_follow_roi_target";
    private static final long TIMEOUT = 1000;
    private static final double sDefaultRoiAltitude = 10.0d;

    public FollowAlgorithm.FollowModes getType() {
        return FollowAlgorithm.FollowModes.GUIDED_SCAN;
    }

    public FollowGuidedScan(MavLinkDroneManager mavLinkDroneManager, Handler handler) {
        super(mavLinkDroneManager, handler);
    }

    public void updateAlgorithmParams(Map<String, ?> map) {
        LatLongAlt latLongAlt;
        super.updateAlgorithmParams(map);
        LatLong latLong = (LatLong) map.get("extra_follow_roi_target");
        if (latLong == null || (latLong instanceof LatLongAlt)) {
            latLongAlt = (LatLongAlt) latLong;
        } else {
            latLongAlt = new LatLongAlt(latLong, 10.0d);
        }
        getROIEstimator().updateROITarget(latLongAlt);
    }

    /* access modifiers changed from: protected */
    public ROIEstimator initROIEstimator(MavLinkDrone mavLinkDrone, Handler handler) {
        return new GuidedROIEstimator(mavLinkDrone, handler);
    }

    public Map<String, Object> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("extra_follow_roi_target", getROIEstimator().roiTarget);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public GuidedROIEstimator getROIEstimator() {
        return (GuidedROIEstimator) super.getROIEstimator();
    }

    private static class GuidedROIEstimator extends ROIEstimator {
        /* access modifiers changed from: private */
        public LatLongAlt roiTarget;

        public GuidedROIEstimator(MavLinkDrone mavLinkDrone, Handler handler) {
            super(mavLinkDrone, handler);
        }

        /* access modifiers changed from: package-private */
        public void updateROITarget(LatLongAlt latLongAlt) {
            this.roiTarget = latLongAlt;
            onLocationUpdate((Location) null);
        }

        /* access modifiers changed from: protected */
        public void updateROI() {
            if (this.roiTarget == null) {
                System.out.println("Cancelling ROI lock.");
                super.updateROI();
                return;
            }
            cqb.m12007b("ROI Target: " + this.roiTarget.toString(), new Object[0]);
            MavLinkDoCmds.setROI(this.drone, this.roiTarget, (ICommandListener) null);
            this.watchdog.postDelayed(this.watchdogCallback, FollowGuidedScan.TIMEOUT);
        }
    }
}
