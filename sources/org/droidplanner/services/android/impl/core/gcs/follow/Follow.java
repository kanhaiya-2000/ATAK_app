package org.droidplanner.services.android.impl.core.gcs.follow;

import android.os.Bundle;
import android.os.Handler;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.drone.action.ControlActions;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.gcs.follow.FollowLocationSource;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.autopilot.apm.solo.ArduSolo;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint;
import org.droidplanner.services.android.impl.core.drone.variables.State;
import org.droidplanner.services.android.impl.core.gcs.follow.FollowAlgorithm;
import org.droidplanner.services.android.impl.core.gcs.location.Location;

public class Follow implements DroneInterfaces.OnDroneListener<MavLinkDrone>, Location.LocationReceiver {
    private static final String TAG = "Follow";
    private final MavLinkDroneManager droneMgr;
    private FollowAlgorithm followAlgorithm;
    private Location lastLocation;
    private final Location.LocationFinder locationFinder;
    private final LocationRelay mLocationRelay;
    private FollowLocationSource mLocationSource;
    private FollowStates state = FollowStates.FOLLOW_INVALID_STATE;

    public enum FollowStates {
        FOLLOW_INVALID_STATE,
        FOLLOW_DRONE_NOT_ARMED,
        FOLLOW_DRONE_DISCONNECTED,
        FOLLOW_START,
        FOLLOW_RUNNING,
        FOLLOW_END
    }

    public Follow(MavLinkDroneManager mavLinkDroneManager, Handler handler, Location.LocationFinder locationFinder2) {
        FollowAlgorithm followAlgorithm2;
        this.droneMgr = mavLinkDroneManager;
        MavLinkDrone mavLinkDrone = (MavLinkDrone) mavLinkDroneManager.getDrone();
        if (mavLinkDrone != null) {
            mavLinkDrone.addDroneListener(this);
        }
        if (mavLinkDrone instanceof ArduSolo) {
            followAlgorithm2 = FollowAlgorithm.FollowModes.SOLO_SHOT.getAlgorithmType(mavLinkDroneManager, handler);
        } else {
            followAlgorithm2 = FollowAlgorithm.FollowModes.LEASH.getAlgorithmType(mavLinkDroneManager, handler);
        }
        this.followAlgorithm = followAlgorithm2;
        this.locationFinder = locationFinder2;
        this.mLocationRelay = new LocationRelay();
    }

    public void enableFollowMe(FollowLocationSource followLocationSource) {
        if (!isEnabled()) {
            MavLinkDrone mavLinkDrone = (MavLinkDrone) this.droneMgr.getDrone();
            State state2 = mavLinkDrone != null ? mavLinkDrone.getState() : null;
            if (state2 == null) {
                cqb.m12012d("No drone for enableFollowMe(%s)", followLocationSource);
                this.state = FollowStates.FOLLOW_INVALID_STATE;
                return;
            } else if (!this.droneMgr.isConnected()) {
                this.state = FollowStates.FOLLOW_DRONE_DISCONNECTED;
            } else if (state2.isArmed()) {
                GuidedPoint.changeToGuidedMode(mavLinkDrone, (ICommandListener) null);
                this.state = FollowStates.FOLLOW_START;
                this.followAlgorithm.enableFollow();
                this.droneMgr.onAttributeEvent(AttributeEvent.FOLLOW_START, (Bundle) null);
            } else {
                this.state = FollowStates.FOLLOW_DRONE_NOT_ARMED;
            }
        }
        setLocationSource(followLocationSource);
    }

    public void disableFollowMe() {
        cqb.m12010c("disableFollowMe(): state=%s", this.state);
        this.followAlgorithm.disableFollow();
        setLocationSource(FollowLocationSource.NONE);
        this.lastLocation = null;
        if (isEnabled()) {
            this.state = FollowStates.FOLLOW_END;
            this.droneMgr.onAttributeEvent(AttributeEvent.FOLLOW_STOP, (Bundle) null);
        }
        if (GuidedPoint.isGuidedMode((MavLinkDrone) this.droneMgr.getDrone()) && this.followAlgorithm.getType() != FollowAlgorithm.FollowModes.SOLO_SHOT) {
            ((MavLinkDrone) this.droneMgr.getDrone()).executeAsyncAction(new Action(ControlActions.ACTION_SEND_BRAKE_VEHICLE), (ICommandListener) null);
        }
    }

    public boolean isEnabled() {
        return this.state == FollowStates.FOLLOW_RUNNING || this.state == FollowStates.FOLLOW_START;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        int i = C59991.f8642x7e1461ff[droneEventsType.ordinal()];
        if (i != 1) {
            if ((i == 2 || i == 3) && isEnabled()) {
                disableFollowMe();
            }
        } else if (isEnabled() && !GuidedPoint.isGuidedMode(mavLinkDrone)) {
            cqb.m12010c("Follow enabled, but current mode is not guided. Disable follow", new Object[0]);
            disableFollowMe();
        }
    }

    public void onFollowNewLocation(android.location.Location location) {
        cqb.m12007b("onFollowNewLocation(%s)", location);
        Location gcsLocation = this.mLocationRelay.toGcsLocation(location);
        if (gcsLocation != null && this.mLocationSource == FollowLocationSource.CLIENT_SPECIFIED) {
            onLocationUpdate(gcsLocation);
        }
    }

    public void onLocationUpdate(Location location) {
        cqb.m12007b("onLocationUpdate(): lat/lng=%.4f/%.4f accurate=%s", Double.valueOf(location.getCoord().getLatitude()), Double.valueOf(location.getCoord().getLongitude()), Boolean.valueOf(location.isAccurate()));
        if (location.isAccurate()) {
            this.state = FollowStates.FOLLOW_RUNNING;
            this.lastLocation = location;
            cqb.m12007b("Sending location to followAlgorithm " + this.followAlgorithm, new Object[0]);
            this.followAlgorithm.onLocationReceived(location);
        } else {
            cqb.m12007b("Location not accurate", new Object[0]);
            this.state = FollowStates.FOLLOW_START;
        }
        this.droneMgr.onAttributeEvent(AttributeEvent.FOLLOW_UPDATE, (Bundle) null);
    }

    public void onLocationUnavailable() {
        disableFollowMe();
    }

    public void setAlgorithm(FollowAlgorithm followAlgorithm2) {
        cqb.m12010c("setAlgorithm(): algo=" + followAlgorithm2, new Object[0]);
        FollowAlgorithm followAlgorithm3 = this.followAlgorithm;
        if (!(followAlgorithm3 == null || followAlgorithm3 == followAlgorithm2)) {
            cqb.m12010c("%s.disableFollow()", followAlgorithm3);
            this.followAlgorithm.disableFollow();
        }
        this.followAlgorithm = followAlgorithm2;
        if (isEnabled()) {
            cqb.m12010c("%s.enableFollow()", this.followAlgorithm);
            this.followAlgorithm.enableFollow();
            Location location = this.lastLocation;
            if (location != null) {
                this.followAlgorithm.onLocationReceived(location);
            }
        }
        this.droneMgr.onAttributeEvent(AttributeEvent.FOLLOW_UPDATE, (Bundle) null);
    }

    public FollowAlgorithm getFollowAlgorithm() {
        return this.followAlgorithm;
    }

    public FollowStates getState() {
        return this.state;
    }

    private void setLocationSource(FollowLocationSource followLocationSource) {
        if (isEnabled() && this.mLocationSource != followLocationSource) {
            int i = C59991.f8641x6a78003c[followLocationSource.ordinal()];
            if (i == 1) {
                cqb.m12007b("Switch to client-specified locations", new Object[0]);
                this.locationFinder.disableLocationUpdates(TAG);
                this.mLocationRelay.onFollowStart();
            } else if (i != 2) {
                this.locationFinder.disableLocationUpdates(TAG);
            } else {
                cqb.m12007b("Switch to internal locations", new Object[0]);
                this.locationFinder.enableLocationUpdates(TAG, this);
            }
            this.mLocationSource = followLocationSource;
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.gcs.follow.Follow$1 */
    /* synthetic */ class C59991 {

        /* renamed from: $SwitchMap$com$o3dr$services$android$lib$gcs$follow$FollowLocationSource */
        static final /* synthetic */ int[] f8641x6a78003c;

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8642x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.o3dr.services.android.lib.gcs.follow.FollowLocationSource[] r0 = com.o3dr.services.android.lib.gcs.follow.FollowLocationSource.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8641x6a78003c = r0
                r1 = 1
                com.o3dr.services.android.lib.gcs.follow.FollowLocationSource r2 = com.o3dr.services.android.lib.gcs.follow.FollowLocationSource.CLIENT_SPECIFIED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8641x6a78003c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.o3dr.services.android.lib.gcs.follow.FollowLocationSource r3 = com.o3dr.services.android.lib.gcs.follow.FollowLocationSource.INTERNAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8641x6a78003c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.o3dr.services.android.lib.gcs.follow.FollowLocationSource r4 = com.o3dr.services.android.lib.gcs.follow.FollowLocationSource.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r3 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f8642x7e1461ff = r3
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r4 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f8642x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r3 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f8642x7e1461ff     // Catch:{ NoSuchFieldError -> 0x004d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.gcs.follow.Follow.C59991.<clinit>():void");
        }
    }
}
