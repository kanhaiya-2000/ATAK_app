package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Handler;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.companion.solo.tlv.SoloMessageLocation;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.ArduSolo;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.SoloComp;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.Location;
import org.droidplanner.services.android.impl.core.gcs.roi.ROIEstimator;

public class FollowSoloShot extends FollowAlgorithm {
    private final LatLongAlt locationCoord;
    private final SoloMessageLocation locationSetter;
    private final SoloComp soloComp;

    public FollowSoloShot(MavLinkDroneManager mavLinkDroneManager, Handler handler) {
        super(mavLinkDroneManager, handler);
        LatLongAlt latLongAlt = new LatLongAlt(0.0d, 0.0d, 0.0d);
        this.locationCoord = latLongAlt;
        this.locationSetter = new SoloMessageLocation(latLongAlt);
        this.soloComp = ((ArduSolo) mavLinkDroneManager.getDrone()).getSoloComp();
    }

    public void enableFollow() {
        super.enableFollow();
        this.soloComp.enableFollowDataConnection();
    }

    public void disableFollow() {
        super.disableFollow();
        this.soloComp.disableFollowDataConnection();
    }

    /* access modifiers changed from: protected */
    public void processNewLocation(Location location) {
        if (location != null) {
            this.locationCoord.set(location.getCoord());
            this.locationSetter.setCoordinate(this.locationCoord);
            this.soloComp.updateFollowCenter(this.locationSetter);
        }
    }

    public FollowAlgorithm.FollowModes getType() {
        return FollowAlgorithm.FollowModes.SOLO_SHOT;
    }

    /* access modifiers changed from: protected */
    public ROIEstimator initROIEstimator(MavLinkDrone mavLinkDrone, Handler handler) {
        return new SoloROIEstimator(mavLinkDrone, handler, ((ArduSolo) mavLinkDrone).getSoloComp());
    }

    protected static class SoloROIEstimator extends ROIEstimator {
        private final LatLongAlt locationCoord;
        private final SoloMessageLocation locationSetter;
        private final SoloComp soloComp;

        /* access modifiers changed from: protected */
        public long getUpdatePeriod() {
            return 40;
        }

        public SoloROIEstimator(MavLinkDrone mavLinkDrone, Handler handler, SoloComp soloComp2) {
            super(mavLinkDrone, handler);
            LatLongAlt latLongAlt = new LatLongAlt(0.0d, 0.0d, 0.0d);
            this.locationCoord = latLongAlt;
            this.locationSetter = new SoloMessageLocation(latLongAlt);
            this.soloComp = soloComp2;
        }

        public void enableFollow() {
            this.isFollowEnabled.set(true);
        }

        public void disableFollow() {
            if (this.isFollowEnabled.compareAndSet(true, false)) {
                this.realLocation = null;
                disableWatchdog();
            }
        }

        /* access modifiers changed from: protected */
        public void sendUpdateROI(LatLong latLong) {
            this.locationCoord.set(latLong);
            this.locationSetter.setCoordinate(this.locationCoord);
            this.soloComp.updateFollowCenter(this.locationSetter);
        }
    }
}
