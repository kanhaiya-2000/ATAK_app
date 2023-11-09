package org.droidplanner.services.android.impl.core.gcs;

import android.os.Bundle;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import com.o3dr.services.android.lib.drone.attribute.AttributeEvent;
import com.o3dr.services.android.lib.drone.attribute.AttributeEventExtra;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.property.DroneAttribute;
import com.o3dr.services.android.lib.drone.property.Home;
import com.o3dr.services.android.lib.gcs.returnToMe.ReturnToMeState;
import com.o3dr.services.android.lib.model.AbstractCommandListener;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.action.Action;
import java.util.concurrent.atomic.AtomicBoolean;
import org.droidplanner.services.android.impl.core.MAVLink.command.doCmd.MavLinkDoCmds;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;
import org.droidplanner.services.android.impl.core.drone.manager.MavLinkDroneManager;
import org.droidplanner.services.android.impl.core.gcs.location.Location;
import org.droidplanner.services.android.impl.utils.CommonApiUtils;

public class ReturnToMe implements DroneInterfaces.OnDroneListener<MavLinkDrone>, Location.LocationReceiver {
    private static final String TAG = "ReturnToMe";
    public static final int UPDATE_MINIMAL_DISPLACEMENT = 5;
    /* access modifiers changed from: private */
    public static final Action requestHomeUpdateAction = new Action(MavLinkDrone.ACTION_REQUEST_HOME_UPDATE);
    private final DroneInterfaces.AttributeEventListener attributeListener;
    /* access modifiers changed from: private */
    public ICommandListener commandListener;
    private final ReturnToMeState currentState;
    /* access modifiers changed from: private */
    public final MavLinkDroneManager droneMgr;
    private final AtomicBoolean isEnabled = new AtomicBoolean(false);
    private final Location.LocationFinder locationFinder;

    public ReturnToMe(MavLinkDroneManager mavLinkDroneManager, Location.LocationFinder locationFinder2, DroneInterfaces.AttributeEventListener attributeEventListener) {
        this.droneMgr = mavLinkDroneManager;
        this.locationFinder = locationFinder2;
        this.attributeListener = attributeEventListener;
        this.currentState = new ReturnToMeState();
        ((MavLinkDrone) mavLinkDroneManager.getDrone()).addDroneListener(this);
    }

    public void enable(ICommandListener iCommandListener) {
        if (this.isEnabled.compareAndSet(false, true)) {
            this.commandListener = iCommandListener;
            Home home = getHome();
            if (home.isValid()) {
                this.currentState.setOriginalHomeLocation(home.getCoordinate());
            }
            cqb.m12010c("Enabling return to me.", new Object[0]);
            this.locationFinder.enableLocationUpdates(TAG, this);
            updateCurrentState(3);
        }
    }

    public void disable() {
        if (this.isEnabled.compareAndSet(true, false)) {
            cqb.m12010c("Disabling return to me.", new Object[0]);
            this.locationFinder.disableLocationUpdates(TAG);
            this.currentState.setCurrentHomeLocation((LatLongAlt) null);
            final LatLongAlt originalHomeLocation = this.currentState.getOriginalHomeLocation();
            if (originalHomeLocation != null) {
                MavLinkDoCmds.setVehicleHome((MavLinkDrone) this.droneMgr.getDrone(), originalHomeLocation, new AbstractCommandListener() {
                    public void onSuccess() {
                        cqb.m12010c("Updated vehicle home location to %s", originalHomeLocation.toString());
                        ((MavLinkDrone) ReturnToMe.this.droneMgr.getDrone()).executeAsyncAction(ReturnToMe.requestHomeUpdateAction, (ICommandListener) null);
                    }

                    public void onError(int i) {
                        cqb.m12014e("Unable to update vehicle home location: %d", Integer.valueOf(i));
                    }

                    public void onTimeout() {
                        cqb.m12012d("Vehicle home update timed out!", new Object[0]);
                    }
                });
            }
            updateCurrentState(0);
            this.commandListener = null;
        }
    }

    public void onLocationUpdate(Location location) {
        if (location.isAccurate()) {
            Home home = getHome();
            if (!home.isValid()) {
                updateCurrentState(3);
                return;
            }
            LatLongAlt coordinate = home.getCoordinate();
            final LatLongAlt coord = location.getCoord();
            float[] fArr = new float[3];
            android.location.Location.distanceBetween(coordinate.getLatitude(), coordinate.getLongitude(), coord.getLatitude(), coord.getLongitude(), fArr);
            if (fArr[0] >= 5.0f) {
                MavLinkDoCmds.setVehicleHome((MavLinkDrone) this.droneMgr.getDrone(), new LatLongAlt(coord.getLatitude(), coord.getLongitude(), coordinate.getAltitude()), new AbstractCommandListener() {
                    public void onSuccess() {
                        cqb.m12010c("Updated vehicle home location to %s", coord.toString());
                        ((MavLinkDrone) ReturnToMe.this.droneMgr.getDrone()).executeAsyncAction(ReturnToMe.requestHomeUpdateAction, (ICommandListener) null);
                        CommonApiUtils.postSuccessEvent(ReturnToMe.this.commandListener);
                        ReturnToMe.this.updateCurrentState(4);
                    }

                    public void onError(int i) {
                        cqb.m12014e("Unable to update vehicle home location: %d", Integer.valueOf(i));
                        CommonApiUtils.postErrorEvent(i, ReturnToMe.this.commandListener);
                        ReturnToMe.this.updateCurrentState(5);
                    }

                    public void onTimeout() {
                        cqb.m12012d("Vehicle home update timed out!", new Object[0]);
                        CommonApiUtils.postTimeoutEvent(ReturnToMe.this.commandListener);
                        ReturnToMe.this.updateCurrentState(5);
                    }
                });
                return;
            }
            return;
        }
        updateCurrentState(2);
    }

    private Home getHome() {
        return (Home) ((MavLinkDrone) this.droneMgr.getDrone()).getAttribute(AttributeType.HOME);
    }

    public void onLocationUnavailable() {
        if (this.isEnabled.get()) {
            updateCurrentState(1);
            disable();
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.gcs.ReturnToMe$3 */
    /* synthetic */ class C59983 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8640x7e1461ff;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r0 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8640x7e1461ff = r0
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8640x7e1461ff     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HOME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.gcs.ReturnToMe.C59983.<clinit>():void");
        }
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        int i = C59983.f8640x7e1461ff[droneEventsType.ordinal()];
        if (i == 1) {
            disable();
        } else if (i == 2 && this.isEnabled.get()) {
            LatLongAlt coordinate = getHome().getCoordinate();
            if (this.currentState.getOriginalHomeLocation() == null) {
                this.currentState.setOriginalHomeLocation(coordinate);
            } else {
                this.currentState.setCurrentHomeLocation(coordinate);
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateCurrentState(int i) {
        this.currentState.setState(i);
        if (this.attributeListener != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(AttributeEventExtra.EXTRA_RETURN_TO_ME_STATE, i);
            this.attributeListener.onAttributeEvent(AttributeEvent.RETURN_TO_ME_STATE_UPDATE, bundle);
        }
    }

    public DroneAttribute getState() {
        return this.currentState;
    }
}
