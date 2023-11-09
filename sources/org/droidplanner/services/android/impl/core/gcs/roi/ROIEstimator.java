package org.droidplanner.services.android.impl.core.gcs.roi;

import android.os.Handler;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.model.ICommandListener;
import java.util.concurrent.atomic.AtomicBoolean;
import org.droidplanner.services.android.impl.core.MAVLink.command.doCmd.MavLinkDoCmds;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.gcs.location.Location;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;

public class ROIEstimator implements Location.LocationReceiver {
    private static final int TIMEOUT = 100;
    protected final MavLinkDrone drone;
    protected final AtomicBoolean isFollowEnabled = new AtomicBoolean(false);
    protected Location realLocation;
    protected long timeOfLastLocation;
    protected Handler watchdog;
    protected Runnable watchdogCallback = new Runnable() {
        public void run() {
            ROIEstimator.this.updateROI();
        }
    };

    /* access modifiers changed from: protected */
    public long getUpdatePeriod() {
        return 100;
    }

    public ROIEstimator(MavLinkDrone mavLinkDrone, Handler handler) {
        this.watchdog = handler;
        this.drone = mavLinkDrone;
    }

    public void enableFollow() {
        MavLinkDoCmds.resetROI(this.drone, (ICommandListener) null);
        this.isFollowEnabled.set(true);
    }

    public void disableFollow() {
        if (this.isFollowEnabled.compareAndSet(true, false)) {
            this.realLocation = null;
            MavLinkDoCmds.resetROI(this.drone, (ICommandListener) null);
            disableWatchdog();
        }
    }

    public final void onLocationUpdate(Location location) {
        if (this.isFollowEnabled.get()) {
            this.realLocation = location;
            this.timeOfLastLocation = System.currentTimeMillis();
            disableWatchdog();
            updateROI();
        }
    }

    public void onLocationUnavailable() {
        disableWatchdog();
    }

    /* access modifiers changed from: protected */
    public void disableWatchdog() {
        this.watchdog.removeCallbacks(this.watchdogCallback);
    }

    /* access modifiers changed from: protected */
    public void updateROI() {
        Location location = this.realLocation;
        if (location != null) {
            sendUpdateROI(GeoTools.newCoordFromBearingAndDistance(location.getCoord(), this.realLocation.getBearing(), (this.realLocation.getSpeed() * ((double) (System.currentTimeMillis() - this.timeOfLastLocation))) / 1000.0d));
            if (this.realLocation.getSpeed() > 0.0d) {
                this.watchdog.postDelayed(this.watchdogCallback, getUpdatePeriod());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sendUpdateROI(LatLong latLong) {
        MavLinkDoCmds.setROI(this.drone, new LatLongAlt(latLong.getLatitude(), latLong.getLongitude(), 0.0d), (ICommandListener) null);
    }

    public boolean isFollowEnabled() {
        return this.isFollowEnabled.get();
    }
}
