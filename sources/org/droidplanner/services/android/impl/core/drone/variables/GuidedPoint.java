package org.droidplanner.services.android.impl.core.drone.variables;

import android.os.Handler;
import android.os.RemoteException;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.drone.attribute.AttributeType;
import com.o3dr.services.android.lib.drone.property.Altitude;
import com.o3dr.services.android.lib.drone.property.Gps;
import com.o3dr.services.android.lib.model.ICommandListener;
import com.o3dr.services.android.lib.model.SimpleCommandListener;
import org.droidplanner.services.android.impl.core.MAVLink.MavLinkCommands;
import org.droidplanner.services.android.impl.core.drone.DroneInterfaces;
import org.droidplanner.services.android.impl.core.drone.DroneVariable;
import org.droidplanner.services.android.impl.core.drone.autopilot.Drone;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class GuidedPoint extends DroneVariable implements DroneInterfaces.OnDroneListener<MavLinkDrone> {
    private double altitude = 0.0d;
    private LatLong coord = new LatLong(0.0d, 0.0d);
    private final Handler handler;
    private Runnable mPostInitializationTask;
    private GuidedStates state = GuidedStates.UNINITIALIZED;

    public enum GuidedStates {
        UNINITIALIZED,
        IDLE,
        ACTIVE
    }

    public GuidedPoint(MavLinkDrone mavLinkDrone, Handler handler2) {
        super(mavLinkDrone);
        this.handler = handler2;
        mavLinkDrone.addDroneListener(this);
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, MavLinkDrone mavLinkDrone) {
        int i = C59825.f8629x7e1461ff[droneEventsType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            if (isGuidedMode(this.myDrone)) {
                initialize();
            } else {
                disable();
            }
        } else if (i == 4 || i == 5) {
            disable();
        }
    }

    public static boolean isGuidedMode(MavLinkDrone mavLinkDrone) {
        if (mavLinkDrone == null) {
            return false;
        }
        int type = mavLinkDrone.getType();
        ApmModes mode = mavLinkDrone.getState().getMode();
        if (Type.isCopter(type)) {
            if (mode == ApmModes.ROTOR_GUIDED) {
                return true;
            }
            return false;
        } else if (Type.isPlane(type)) {
            if (mode == ApmModes.FIXED_WING_GUIDED) {
                return true;
            }
            return false;
        } else if (!Type.isRover(type)) {
            return false;
        } else {
            if (mode == ApmModes.ROVER_GUIDED || mode == ApmModes.ROVER_HOLD) {
                return true;
            }
            return false;
        }
    }

    public void pauseAtCurrentLocation(ICommandListener iCommandListener) {
        if (this.state == GuidedStates.UNINITIALIZED) {
            changeToGuidedMode(this.myDrone, iCommandListener);
            return;
        }
        newGuidedCoord(getGpsPosition());
        this.state = GuidedStates.IDLE;
    }

    private LatLong getGpsPosition() {
        return getGpsPosition(this.myDrone);
    }

    private static LatLong getGpsPosition(Drone drone) {
        Gps gps = (Gps) drone.getAttribute(AttributeType.GPS);
        if (gps == null) {
            return null;
        }
        return gps.getPosition();
    }

    public static void changeToGuidedMode(MavLinkDrone mavLinkDrone, ICommandListener iCommandListener) {
        State state2 = mavLinkDrone.getState();
        int type = mavLinkDrone.getType();
        if (Type.isCopter(type)) {
            state2.changeFlightMode(ApmModes.ROTOR_GUIDED, iCommandListener);
        } else if (Type.isPlane(type)) {
            forceSendGuidedPoint(mavLinkDrone, getGpsPosition(mavLinkDrone), getDroneAltConstrained(mavLinkDrone));
        } else if (Type.isRover(type)) {
            state2.changeFlightMode(ApmModes.ROVER_GUIDED, iCommandListener);
        }
    }

    public void doGuidedTakeoff(final double d, final ICommandListener iCommandListener) {
        if (Type.isCopter(this.myDrone.getType())) {
            this.coord = getGpsPosition();
            this.altitude = d;
            this.state = GuidedStates.IDLE;
            changeToGuidedMode(this.myDrone, new SimpleCommandListener() {
                public void onSuccess() {
                    MavLinkCommands.sendTakeoff(GuidedPoint.this.myDrone, d, iCommandListener);
                    GuidedPoint.this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.GUIDEDPOINT);
                }

                public void onError(int i) {
                    ICommandListener iCommandListener = iCommandListener;
                    if (iCommandListener != null) {
                        try {
                            iCommandListener.onError(i);
                        } catch (RemoteException e) {
                            cqb.m12015e(e, e.getMessage(), new Object[0]);
                        }
                    }
                }

                public void onTimeout() {
                    ICommandListener iCommandListener = iCommandListener;
                    if (iCommandListener != null) {
                        try {
                            iCommandListener.onTimeout();
                        } catch (RemoteException e) {
                            cqb.m12015e(e, e.getMessage(), new Object[0]);
                        }
                    }
                }
            });
        } else if (iCommandListener != null) {
            this.handler.post(new Runnable() {
                public void run() {
                    try {
                        iCommandListener.onError(3);
                    } catch (RemoteException e) {
                        cqb.m12015e(e, e.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    public void newGuidedCoord(LatLong latLong) {
        changeCoord(latLong);
    }

    public void newGuidedPosition(double d, double d2, double d3) {
        MavLinkCommands.sendGuidedPosition(this.myDrone, d, d2, d3);
    }

    public void newGuidedVelocity(double d, double d2, double d3) {
        MavLinkCommands.sendGuidedVelocity(this.myDrone, d, d2, d3);
    }

    public void newGuidedCoordAndVelocity(LatLong latLong, double d, double d2, double d3) {
        changeCoordAndVelocity(latLong, d, d2, d3);
    }

    public void changeGuidedAltitude(double d) {
        changeAlt(d);
    }

    public void forcedGuidedCoordinate(final LatLong latLong, ICommandListener iCommandListener) {
        if (!((Gps) this.myDrone.getAttribute(AttributeType.GPS)).has3DLock()) {
            postErrorEvent(this.handler, iCommandListener, 4);
        } else if (isInitialized()) {
            changeCoord(latLong);
            postSuccessEvent(this.handler, iCommandListener);
        } else {
            this.mPostInitializationTask = new Runnable() {
                public void run() {
                    GuidedPoint.this.changeCoord(latLong);
                }
            };
            changeToGuidedMode(this.myDrone, iCommandListener);
        }
    }

    public void forcedGuidedCoordinate(final LatLong latLong, final double d, ICommandListener iCommandListener) {
        if (!((Gps) this.myDrone.getAttribute(AttributeType.GPS)).has3DLock()) {
            postErrorEvent(this.handler, iCommandListener, 4);
        } else if (isInitialized()) {
            changeCoord(latLong);
            changeAlt(d);
            postSuccessEvent(this.handler, iCommandListener);
        } else {
            this.mPostInitializationTask = new Runnable() {
                public void run() {
                    GuidedPoint.this.changeCoord(latLong);
                    GuidedPoint.this.changeAlt(d);
                }
            };
            changeToGuidedMode(this.myDrone, iCommandListener);
        }
    }

    private void initialize() {
        if (this.state == GuidedStates.UNINITIALIZED) {
            this.coord = getGpsPosition();
            this.altitude = getDroneAltConstrained(this.myDrone);
            this.state = GuidedStates.IDLE;
            this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.GUIDEDPOINT);
        }
        Runnable runnable = this.mPostInitializationTask;
        if (runnable != null) {
            runnable.run();
            this.mPostInitializationTask = null;
        }
    }

    private void disable() {
        if (this.state != GuidedStates.UNINITIALIZED) {
            this.state = GuidedStates.UNINITIALIZED;
            this.myDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.GUIDEDPOINT);
        }
    }

    /* renamed from: org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$5 */
    /* synthetic */ class C59825 {

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$DroneInterfaces$DroneEventsType */
        static final /* synthetic */ int[] f8629x7e1461ff;

        /* renamed from: $SwitchMap$org$droidplanner$services$android$impl$core$drone$variables$GuidedPoint$GuidedStates */
        static final /* synthetic */ int[] f8630x3bace18d;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        static {
            /*
                org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$GuidedStates[] r0 = org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.GuidedStates.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8630x3bace18d = r0
                r1 = 1
                org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$GuidedStates r2 = org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.GuidedStates.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8630x3bace18d     // Catch:{ NoSuchFieldError -> 0x001d }
                org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$GuidedStates r3 = org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.GuidedStates.IDLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8630x3bace18d     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint$GuidedStates r4 = org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.GuidedStates.ACTIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType[] r3 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f8629x7e1461ff = r3
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r4 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_FIRST     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f8629x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0043 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r3 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_RESTORED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f8629x7e1461ff     // Catch:{ NoSuchFieldError -> 0x004d }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.MODE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = f8629x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0058 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f8629x7e1461ff     // Catch:{ NoSuchFieldError -> 0x0063 }
                org.droidplanner.services.android.impl.core.drone.DroneInterfaces$DroneEventsType r1 = org.droidplanner.services.android.impl.core.drone.DroneInterfaces.DroneEventsType.HEARTBEAT_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.core.drone.variables.GuidedPoint.C59825.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void changeAlt(double d) {
        int i = C59825.f8630x3bace18d[this.state.ordinal()];
        if (i == 2) {
            this.state = GuidedStates.ACTIVE;
        } else if (i != 3) {
            return;
        }
        this.altitude = d;
        sendGuidedPoint();
    }

    /* access modifiers changed from: private */
    public void changeCoord(LatLong latLong) {
        int i = C59825.f8630x3bace18d[this.state.ordinal()];
        if (i == 2) {
            this.state = GuidedStates.ACTIVE;
        } else if (i != 3) {
            return;
        }
        this.coord = latLong;
        sendGuidedPoint();
    }

    private void changeCoordAndVelocity(LatLong latLong, double d, double d2, double d3) {
        int i = C59825.f8630x3bace18d[this.state.ordinal()];
        if (i == 2) {
            this.state = GuidedStates.ACTIVE;
        } else if (i != 3) {
            return;
        }
        this.coord = latLong;
        sendGuidedPointAndVelocity(d, d2, d3);
    }

    private void sendGuidedPointAndVelocity(double d, double d2, double d3) {
        if (this.state == GuidedStates.ACTIVE) {
            forceSendGuidedPointAndVelocity(this.myDrone, this.coord, this.altitude, d, d2, d3);
        }
    }

    private void sendGuidedPoint() {
        if (this.state == GuidedStates.ACTIVE) {
            forceSendGuidedPoint(this.myDrone, this.coord, this.altitude);
        }
    }

    public static void forceSendGuidedPoint(MavLinkDrone mavLinkDrone, LatLong latLong, double d) {
        mavLinkDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.GUIDEDPOINT);
        if (latLong != null) {
            MavLinkCommands.setGuidedMode(mavLinkDrone, latLong.getLatitude(), latLong.getLongitude(), d);
        }
    }

    public static void forceSendGuidedPointAndVelocity(MavLinkDrone mavLinkDrone, LatLong latLong, double d, double d2, double d3, double d4) {
        MavLinkDrone mavLinkDrone2 = mavLinkDrone;
        mavLinkDrone.notifyDroneEvent(DroneInterfaces.DroneEventsType.GUIDEDPOINT);
        if (latLong != null) {
            MavLinkCommands.sendGuidedPositionAndVelocity(mavLinkDrone, latLong.getLatitude(), latLong.getLongitude(), d, d2, d3, d4);
        }
    }

    private static double getDroneAltConstrained(MavLinkDrone mavLinkDrone) {
        return Math.max(Math.floor(((Altitude) mavLinkDrone.getAttribute(AttributeType.ALTITUDE)).getAltitude()), (double) getDefaultMinAltitude(mavLinkDrone));
    }

    public LatLong getCoord() {
        return this.coord;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public boolean isActive() {
        return this.state == GuidedStates.ACTIVE;
    }

    public boolean isIdle() {
        return this.state == GuidedStates.IDLE;
    }

    public boolean isInitialized() {
        return this.state != GuidedStates.UNINITIALIZED;
    }

    public GuidedStates getState() {
        return this.state;
    }

    public static float getDefaultMinAltitude(MavLinkDrone mavLinkDrone) {
        int type = mavLinkDrone.getType();
        if (Type.isCopter(type)) {
            return 2.0f;
        }
        return Type.isPlane(type) ? 15.0f : 0.0f;
    }
}
