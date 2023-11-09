package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.location.Location;
import org.droidplanner.services.android.impl.core.gcs.roi.ROIEstimator;

public abstract class FollowAlgorithm {
    protected final MavLinkDroneManager droneMgr;
    private final AtomicBoolean isFollowEnabled = new AtomicBoolean(false);
    private final ROIEstimator roiEstimator;

    public abstract FollowModes getType();

    /* access modifiers changed from: protected */
    public abstract void processNewLocation(Location location);

    public void updateAlgorithmParams(Map<String, ?> map) {
    }

    public FollowAlgorithm(MavLinkDroneManager mavLinkDroneManager, Handler handler) {
        this.droneMgr = mavLinkDroneManager;
        this.roiEstimator = initROIEstimator((MavLinkDrone) mavLinkDroneManager.getDrone(), handler);
    }

    /* access modifiers changed from: protected */
    public boolean isFollowEnabled() {
        return this.isFollowEnabled.get();
    }

    public void enableFollow() {
        this.isFollowEnabled.set(true);
        ROIEstimator rOIEstimator = this.roiEstimator;
        if (rOIEstimator != null) {
            rOIEstimator.enableFollow();
        }
    }

    public void disableFollow() {
        ROIEstimator rOIEstimator;
        if (this.isFollowEnabled.compareAndSet(true, false) && (rOIEstimator = this.roiEstimator) != null) {
            rOIEstimator.disableFollow();
        }
    }

    /* access modifiers changed from: protected */
    public ROIEstimator initROIEstimator(MavLinkDrone mavLinkDrone, Handler handler) {
        return new ROIEstimator(mavLinkDrone, handler);
    }

    /* access modifiers changed from: protected */
    public ROIEstimator getROIEstimator() {
        return this.roiEstimator;
    }

    public final void onLocationReceived(Location location) {
        if (this.isFollowEnabled.get()) {
            ROIEstimator rOIEstimator = this.roiEstimator;
            if (rOIEstimator != null) {
                rOIEstimator.onLocationUpdate(location);
            }
            processNewLocation(location);
        }
    }

    public Map<String, Object> getParams() {
        return Collections.emptyMap();
    }

    public enum FollowModes {
        LEASH("Leash"),
        LEAD("Lead"),
        RIGHT("Right"),
        LEFT("Left"),
        CIRCLE("Orbit"),
        ABOVE("Above"),
        SPLINE_LEASH("Vector Leash"),
        SPLINE_ABOVE("Vector Above"),
        GUIDED_SCAN("Guided Scan"),
        LOOK_AT_ME("Look At Me"),
        SOLO_SHOT("Solo Follow Shot");
        
        private String name;

        private FollowModes(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }

        public FollowModes next() {
            return values()[(ordinal() + 1) % values().length];
        }

        public FollowAlgorithm getAlgorithmType(MavLinkDroneManager mavLinkDroneManager, Handler handler) {
            switch (this) {
                case LEAD:
                    return new FollowLead(mavLinkDroneManager, handler, 15.0d);
                case RIGHT:
                    return new FollowRight(mavLinkDroneManager, handler, 10.0d);
                case LEFT:
                    return new FollowLeft(mavLinkDroneManager, handler, 10.0d);
                case CIRCLE:
                    return new FollowCircle(mavLinkDroneManager, handler, 15.0d, 10.0d);
                case ABOVE:
                    return new FollowAbove(mavLinkDroneManager, handler);
                case SPLINE_LEASH:
                    return new FollowSplineLeash(mavLinkDroneManager, handler, 8.0d);
                case SPLINE_ABOVE:
                    return new FollowSplineAbove(mavLinkDroneManager, handler);
                case GUIDED_SCAN:
                    return new FollowGuidedScan(mavLinkDroneManager, handler);
                case LOOK_AT_ME:
                    return new FollowLookAtMe(mavLinkDroneManager, handler);
                case SOLO_SHOT:
                    return new FollowSoloShot(mavLinkDroneManager, handler);
                default:
                    return new FollowLeash(mavLinkDroneManager, handler, 8.0d);
            }
        }
    }
}
