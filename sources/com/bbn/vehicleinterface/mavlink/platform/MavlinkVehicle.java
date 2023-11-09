package com.bbn.vehicleinterface.mavlink.platform;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.tasks.route.OrbitPoint;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.tasks.route.WayPoint;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.bbn.ccast.mavlink.MavLinkThread;
import com.bbn.ccast.mavlink.MavlinkTransport;
import com.bbn.ccast.mavlink.Px4Dialect;
import com.bbn.vehicleinterface.types.GeoPosition;
import com.bbn.vehicleinterface.types.ResultCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MavlinkVehicle {
    private static final String TAG = "com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle";
    private UASRoute currentRoute;
    private MavLinkThread mavlinkThread;

    public interface InitializationCallback {
        void initializationFailed(String str);

        void initializeSuccess();
    }

    public MavLinkThread getMavLinkThread() {
        return this.mavlinkThread;
    }

    public enum NETWORK_TYPE {
        TCP(0),
        UDP(1),
        UDP_CLIENT(2),
        SERIAL(3);
        
        public int index;

        private NETWORK_TYPE(int i) {
            this.index = i;
        }
    }

    public MavlinkVehicle(MavlinkTransport mavlinkTransport) {
        MavLinkThread mavLinkThread = new MavLinkThread(mavlinkTransport);
        this.mavlinkThread = mavLinkThread;
        mavLinkThread.start();
    }

    public static void handleExceptionCallback(Exception exc, ResultCallback resultCallback) {
        if (resultCallback != null) {
            resultCallback.onError(exc.getMessage());
        }
    }

    public void arm(boolean z, final ResultCallback<Void> resultCallback) {
        try {
            this.mavlinkThread.armSafetyOff();
            this.mavlinkThread.sendArm(z, new MavLinkThread.ArmDisarmCallback() {
                public void armDisarmSuccess() {
                    ResultCallback resultCallback = resultCallback;
                    if (resultCallback != null) {
                        resultCallback.onResult(null);
                    }
                }

                public void armDisarmFailure(int i) {
                    MavlinkVehicle.this.handleErrorReason("Arm/Disarm Error", i, resultCallback);
                }
            });
        } catch (IOException e) {
            handleExceptionCallback(e, resultCallback);
        }
    }

    /* access modifiers changed from: private */
    public void handleErrorReason(String str, int i, ResultCallback resultCallback) {
        if (resultCallback != null) {
            resultCallback.onError(str + " Reason: " + i);
        }
    }

    public static void handleErrorReason(String str, String str2, ResultCallback resultCallback) {
        if (resultCallback != null) {
            resultCallback.onError(str + " Reason: " + str2);
        }
    }

    public void enterMissionMode(ResultCallback<Void> resultCallback) {
        int i = 1;
        if (this.currentRoute.getPointCnt() == 1) {
            UASPoint pointWithIndex = this.currentRoute.getPointWithIndex(1);
            if (pointWithIndex.getPointType() == UASPoint.POINTTYPE.ORBITPOINT) {
                OrbitPoint orbitPoint = (OrbitPoint) pointWithIndex;
                GeoPoint C = orbitPoint.C();
                float orbitRadius = orbitPoint.getOrbitRadius();
                if (!orbitPoint.getOrbitClockwise()) {
                    i = -1;
                }
                try {
                    this.mavlinkThread.orbit((float) C.getLatitude(), (float) C.getLongitude(), orbitPoint.getAGL(), orbitRadius * ((float) i));
                    return;
                } catch (Exception e) {
                    Log.e(TAG, "error", e);
                }
            } else if (pointWithIndex.getPointType() == UASPoint.POINTTYPE.WAYPOINT) {
                WayPoint wayPoint = (WayPoint) pointWithIndex;
                GeoPoint C2 = wayPoint.C();
                try {
                    this.mavlinkThread.moveGuided((float) C2.getLatitude(), (float) C2.getLongitude(), wayPoint.getAGL());
                    return;
                } catch (Exception e2) {
                    Log.e(TAG, "error", e2);
                }
            }
        }
        try {
            this.mavlinkThread.enterMissionMode(resultCallback);
            this.mavlinkThread.enterMissionMode(resultCallback);
        } catch (IOException e3) {
            handleExceptionCallback(e3, resultCallback);
        }
    }

    public boolean isConnected() {
        return this.mavlinkThread.isConnected();
    }

    public void exit() {
        Log.d(TAG, "exit()");
        this.mavlinkThread.interrupt();
        this.mavlinkThread.exit();
        this.mavlinkThread = null;
    }

    public static class InitializationParameters {
        public Double maxAltitudeMetersAgl;
        public Double minAltitudeMetersAgl;

        public static InitializationParameters createFromSingleAlt(Double d) {
            InitializationParameters initializationParameters = new InitializationParameters();
            initializationParameters.minAltitudeMetersAgl = d;
            return initializationParameters;
        }

        public static InitializationParameters createFromSingleAlt(float f) {
            InitializationParameters initializationParameters = new InitializationParameters();
            initializationParameters.minAltitudeMetersAgl = Double.valueOf((double) f);
            return initializationParameters;
        }
    }

    public ArrayList<UASPoint> getRoutePoints() {
        UASRoute uASRoute = this.currentRoute;
        if (uASRoute == null) {
            return null;
        }
        return uASRoute.getPoints();
    }

    public void flyRoute(RouteTask routeTask, ResultCallback<Void> resultCallback) {
        GeoPoint geoPosToGeoPoint = geoPosToGeoPoint(this.mavlinkThread.getDronePosition_HAL());
        this.currentRoute = routeTask.getRoute();
        if (this.mavlinkThread.isInMissionMode()) {
            try {
                this.mavlinkThread.enterPositionHoldMode();
            } catch (Exception unused) {
            }
        }
        int i = 1;
        if (this.currentRoute.getPointCnt() == 1) {
            UASPoint pointWithIndex = this.currentRoute.getPointWithIndex(1);
            try {
                this.mavlinkThread.sendSetROI(pointWithIndex.C().getLatitude(), pointWithIndex.C().getLongitude(), 0.0d);
            } catch (IOException e) {
                Log.e(TAG, "Error Sending ROI", e);
            }
            if (pointWithIndex.getPointType() == UASPoint.POINTTYPE.ORBITPOINT) {
                OrbitPoint orbitPoint = (OrbitPoint) pointWithIndex;
                if (orbitPoint.getOrbitCount() >= 100) {
                    GeoPoint C = orbitPoint.C();
                    float orbitRadius = orbitPoint.getOrbitRadius();
                    if (!orbitPoint.getOrbitClockwise()) {
                        i = -1;
                    }
                    try {
                        this.mavlinkThread.orbit((float) C.getLatitude(), (float) C.getLongitude(), orbitPoint.getAGL(), orbitRadius * ((float) i));
                        return;
                    } catch (Exception e2) {
                        Log.e(TAG, "error", e2);
                    }
                }
            } else if (pointWithIndex.getPointType() == UASPoint.POINTTYPE.WAYPOINT) {
                WayPoint wayPoint = (WayPoint) pointWithIndex;
                GeoPoint C2 = wayPoint.C();
                try {
                    this.mavlinkThread.moveGuided((float) C2.getLatitude(), (float) C2.getLongitude(), wayPoint.getAGL());
                    return;
                } catch (Exception e3) {
                    Log.e(TAG, "error", e3);
                }
            }
        }
        List<msg_mission_item> list = null;
        try {
            list = Px4Dialect.missionFromSimpleRoute(routeTask.copySimple(routeTask.getName() + ".simple", geoPosToGeoPoint, (GeoPoint) null, false));
        } catch (Exception e4) {
            handleExceptionCallback(e4, resultCallback);
            Log.e(TAG, "error", e4);
        }
        this.mavlinkThread.flyRoute(list, resultCallback);
    }

    public static GeoPoint geoPosToGeoPoint(GeoPosition geoPosition) {
        if (geoPosition == null) {
            return null;
        }
        return new GeoPoint(geoPosition.getLatitude(), geoPosition.getLongitude(), geoPosition.getAltitude(), GeoPoint.AltitudeReference.HAE);
    }
}
