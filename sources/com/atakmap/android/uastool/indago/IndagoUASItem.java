package com.atakmap.android.uastool.indago;

import android.os.Handler;
import android.view.LayoutInflater;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.tasks.TaskResponse;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCFOVCenterTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCRemoteCancelTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCRemoteTask;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.conversion.EGM96;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import com.atakmap.math.PointD;
import indago.connection.ConnectionStateCallback;
import indago.connection.MessageReceivedCallback;
import indago.connection.VehicleConnection;
import indago.location.GeoLocation;
import indago.messages.EventMessage;
import indago.messages.HomeGeolocation;
import indago.messages.SavedFlightPlans;
import indago.messages.VehicleKinematicData;
import indago.messages.VehicleStatus;
import indago.messages.VideoGeolocation;
import indago.messages.VideoPoint;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public final class IndagoUASItem extends UASItem implements ConnectionStateCallback, MessageReceivedCallback {
    public static final String DETAIL_TAG = "_Indago_";
    public static final String DISPLAY_NAME = "Indago II/III (2020.2)";
    public static final String DISPLAY_NAME_SHORT = "Indago";
    private static final String TAG = "IndagoUASItem";
    private final AtomicReference<IAircraftItem> aci = new AtomicReference<>(new IAircraftItem());
    /* access modifiers changed from: private */
    public VehicleConnection connection = null;
    private final AtomicReference<GeoPoint> lastFrameCenter = new AtomicReference<>((Object) null);
    private final AtomicReference<HomeGeolocation> lastHomeGeolocation = new AtomicReference<>((Object) null);
    private final AtomicReference<VehicleKinematicData> lastKinematicUpdate = new AtomicReference<>((Object) null);
    private final AtomicReference<VehicleStatus> lastStatusUpdate = new AtomicReference<>((Object) null);
    private long lastUpdateTime;
    private final String tempUid = UUID.randomUUID().toString().substring(0, 4);

    private void runLTCLCCancelTask(LTCLCRemoteCancelTask lTCLCRemoteCancelTask) {
    }

    private void runLTCLCRemoteTask(LTCLCRemoteTask lTCLCRemoteTask) {
    }

    public boolean canZoomCamera() {
        return true;
    }

    public int getGoHomeBatteryPercent() {
        return 15;
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return null;
    }

    public boolean isAircraftItemCapable() {
        return true;
    }

    public void onEventMessageReceived(EventMessage eventMessage) {
    }

    public void onSavedFlightPlansMessageReceived(SavedFlightPlans savedFlightPlans) {
    }

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public VehicleConnection getConnection() {
        return this.connection;
    }

    public void setConnection(VehicleConnection vehicleConnection) {
        this.connection = vehicleConnection;
    }

    public IndagoUASItem(ao aoVar, boolean z) {
        super(aoVar, z, DETAIL_TAG);
    }

    public IndagoUASItem(String str, String str2, boolean z) {
        super(DETAIL_TAG, str, str2, DISPLAY_NAME_SHORT, z);
        Log.d(TAG, "New Indago UAS Item");
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_VOLTAGE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ATTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HAL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TIME_IN_FLIGHT, true);
    }

    public void onHomeGeolocationMessageReceived(HomeGeolocation homeGeolocation) {
        try {
            GeoLocation location = homeGeolocation.getLocation();
            if (location != null) {
                this.aci.get().homelat = location.getLat();
                this.aci.get().homelon = location.getLon();
                if (location.getMsl() != null) {
                    this.aci.get().homealt = EGM96.getHAE(location.getLat(), location.getLon(), location.getMsl().doubleValue());
                    return;
                }
                this.aci.get().homealt = ElevationManager.a(this.aci.get().homelat, this.aci.get().homelon, (ElevationManager.b) null);
            }
        } catch (Exception e) {
            Log.w(TAG, "Error pulling home position", e);
        }
    }

    public void onVideoGeolocationMessageReceived(VideoGeolocation videoGeolocation) {
        this.lastUpdateTime = System.currentTimeMillis();
        Log.v(TAG, "onVideoGeolocationMessageReceived;");
        if (videoGeolocation != null) {
            Set<VideoPoint> videoPoints = videoGeolocation.getVideoPoints();
            FieldOfView fieldOfView = new FieldOfView();
            if (videoPoints != null) {
                for (VideoPoint next : videoPoints) {
                    int i = C15113.$SwitchMap$indago$messages$VideoPointType[next.getType().ordinal()];
                    if (i == 1) {
                        fieldOfView.f8422tl = new PointD(next.getGeoLocation().getLat(), next.getGeoLocation().getLon());
                    } else if (i == 2) {
                        fieldOfView.f8423tr = new PointD(next.getGeoLocation().getLat(), next.getGeoLocation().getLon());
                    } else if (i == 3) {
                        fieldOfView.f8421br = new PointD(next.getGeoLocation().getLat(), next.getGeoLocation().getLon());
                    } else if (i == 4) {
                        fieldOfView.f8420bl = new PointD(next.getGeoLocation().getLat(), next.getGeoLocation().getLon());
                    } else if (i == 5) {
                        this.lastFrameCenter.set(geoPointFromGeolocation(next.getGeoLocation()));
                        if (next.getGeoLocation() != null) {
                            this.aci.get().spoilat = next.getGeoLocation().getLat();
                            this.aci.get().spoilon = next.getGeoLocation().getLon();
                            if (next.getGeoLocation().getMsl() != null) {
                                this.aci.get().spoialt = EGM96.getHAE(next.getGeoLocation().getLat(), next.getGeoLocation().getLon(), next.getGeoLocation().getMsl().doubleValue());
                            } else {
                                this.aci.get().spoialt = ElevationManager.a(next.getGeoLocation().getLat(), next.getGeoLocation().getLon(), (ElevationManager.b) null);
                            }
                        }
                    }
                }
            }
            if (fieldOfView.isValid()) {
                this.aci.get().spoiBounds = new double[]{fieldOfView.f8422tl.x, fieldOfView.f8422tl.y, fieldOfView.f8423tr.x, fieldOfView.f8423tr.y, fieldOfView.f8421br.x, fieldOfView.f8421br.y, fieldOfView.f8420bl.x, fieldOfView.f8420bl.y};
            }
            updateGeoreference(this.aci.get().aclat, this.aci.get().aclon, this.aci.get().acalt, this.aci.get().sensorElevation, this.aci.get().sensorAzimuth, this.aci.get().sensorHFOV, this.aci.get().sensorVFOV, this.aci.get().homealt);
        }
    }

    public void onVehicleKinematicMessageReceived(VehicleKinematicData vehicleKinematicData) {
        double d;
        this.lastUpdateTime = System.currentTimeMillis();
        Log.v(TAG, "Received Vehicle Kinematic Data; UID = " + this.tempUid);
        this.lastKinematicUpdate.set(vehicleKinematicData);
        if (vehicleKinematicData.getPosition() != null) {
            this.aci.get().aclat = vehicleKinematicData.getPosition().getLat();
            this.aci.get().aclon = vehicleKinematicData.getPosition().getLon();
            if (vehicleKinematicData.getPosition().getMsl() != null) {
                this.aci.get().acalt = EGM96.getHAE(this.aci.get().aclat, this.aci.get().aclon, vehicleKinematicData.getPosition().getMsl().doubleValue());
            }
            if (!Double.isNaN(this.aci.get().homealt)) {
                this.aci.get().achal = this.aci.get().acalt - this.aci.get().homealt;
            } else {
                this.aci.get().achal = Double.NaN;
            }
        }
        if (vehicleKinematicData.getGroundSpeed() != null) {
            this.aci.get().speed = this.lastKinematicUpdate.get().getGroundSpeed().computeMagnitude();
        } else {
            this.aci.get().speed = Double.NaN;
        }
        double d2 = 0.0d;
        if (this.lastKinematicUpdate.get().getRollPitchYaw() != null) {
            this.aci.get().acheading = vehicleKinematicData.getRollPitchYaw().getZ() % 360.0d;
            d = (this.lastKinematicUpdate.get().getRollPitchYaw().getZ() % 360.0d) + 0.0d;
            this.aci.get().attitudeYaw = vehicleKinematicData.getRollPitchYaw().getZ() % 360.0d;
            this.aci.get().attitudeRoll = vehicleKinematicData.getRollPitchYaw().getX();
            this.aci.get().attitudePitch = vehicleKinematicData.getRollPitchYaw().getY();
        } else {
            this.aci.get().acheading = Double.NaN;
            this.aci.get().attitudeRoll = Double.NaN;
            this.aci.get().attitudePitch = Double.NaN;
            d = 0.0d;
        }
        if (this.lastKinematicUpdate.get().getCameraFieldOfView() != null) {
            d += this.lastKinematicUpdate.get().getCameraFieldOfView().getGimbalAzimuth() % 360.0d;
            d2 = 0.0d + this.lastKinematicUpdate.get().getCameraFieldOfView().getGimbalElevation();
            indago.pose.FieldOfView videoFov = this.lastKinematicUpdate.get().getCameraFieldOfView().getVideoFov();
            if (videoFov != null) {
                this.aci.get().sensorHFOV = videoFov.getHorizontal();
                this.aci.get().sensorVFOV = videoFov.getVertical();
            } else {
                this.aci.get().sensorHFOV = 64.0d;
                this.aci.get().sensorVFOV = 38.0d;
            }
        }
        this.aci.get().sensorAzimuth = d;
        this.aci.get().sensorElevation = d2;
    }

    public void onVehicleStatusMessageReceived(VehicleStatus vehicleStatus) {
        String str = TAG;
        Log.v(str, "Vehicle Status Received; UID = " + this.tempUid);
        this.lastStatusUpdate.set(vehicleStatus);
        if (vehicleStatus != null) {
            this.aci.get().isFlying = vehicleStatus.getMotorsArmed();
            this.aci.get().areMotorsOn = vehicleStatus.getMotorsArmed();
            this.aci.get().battVolt = vehicleStatus.getBatteryVoltage().doubleValue();
            this.aci.get().battRem = vehicleStatus.getBatteryPercentRemaining().intValue();
            this.aci.get().battMax = 100;
            this.aci.get().flightTimeRemaining = vehicleStatus.getFlightTimeRemaining().intValue();
            return;
        }
        this.aci.get().isFlying = false;
        this.aci.get().areMotorsOn = false;
        this.aci.get().battVolt = Double.NaN;
        this.aci.get().battRem = Integer.MIN_VALUE;
        this.aci.get().battMax = Integer.MIN_VALUE;
        this.aci.get().flightTimeRemaining = Integer.MIN_VALUE;
    }

    public void onConnected(VehicleConnection vehicleConnection) {
        Log.d(TAG, "Connected to vehicle");
    }

    public void onDisconnected(VehicleConnection vehicleConnection, Throwable th) {
        Log.d(TAG, "Disconnected from vehicle, reconnecting");
        vehicleConnection.connect();
    }

    private void runLTCLCFOVCenterTask(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
        String str = TAG;
        Log.d(str, "INDAGO Received Gimbal Control lookAtTask from " + lTCLCFOVCenterTask.getUser());
        UASToolDropDownReceiver.toast("sensor looking at point (" + lTCLCFOVCenterTask.getUser() + ")...", 0);
        GeoPoint point = lTCLCFOVCenterTask.getPoint();
        this.connection.lookAtPosition(point.getLatitude(), point.getLongitude(), EGM96.getMSL(point));
    }

    /* access modifiers changed from: protected */
    public void lookAtPoint(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
        super.lookAtPoint(lTCLCFOVCenterTask);
        runLTCLCFOVCenterTask(lTCLCFOVCenterTask);
    }

    public int getFlightTimeRemainingSeconds() {
        return ((int) getFlightTimeMins()) * 60;
    }

    private static GeoPoint geoPointFromGeolocation(GeoLocation geoLocation) {
        double lat = geoLocation.getLat();
        double lon = geoLocation.getLon();
        Double msl = geoLocation.getMsl();
        if (msl != null) {
            return new GeoPoint(lat, lon, EGM96.getHAE(lat, lon, msl.doubleValue()), GeoPoint.AltitudeReference.HAE);
        }
        try {
            double a = ElevationManager.a(lat, lon, (ElevationManager.b) null);
            if (GeoPoint.isAltitudeValid(a)) {
                return new GeoPoint(lat, lon, a, GeoPoint.AltitudeReference.HAE);
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return new GeoPoint(lat, lon);
    }

    public UASItem.SIGNAL_STRENGTH getSignalStrength() {
        VehicleStatus vehicleStatus = this.lastStatusUpdate.get();
        if (vehicleStatus == null) {
            return super.getSignalStrength();
        }
        return vehicleStatus.getCommunicating() ? UASItem.SIGNAL_STRENGTH.GOOD : UASItem.SIGNAL_STRENGTH.BAD;
    }

    public void runTask(UASTask uASTask) {
        super.runTask(uASTask);
        if (uASTask != null) {
            int i = C15113.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()];
            if (i == 1) {
                runRouteTask((RouteTask) uASTask);
            } else if (i == 2) {
                lookAtPoint((LTCLCFOVCenterTask) uASTask);
            } else if (i == 3) {
                runLTCLCRemoteTask((LTCLCRemoteTask) uASTask);
            } else if (i != 4) {
                UASToolDropDownReceiver.toast("Unable to run unknown task type: " + uASTask.getTaskType().name(), 0);
            } else {
                runLTCLCCancelTask((LTCLCRemoteCancelTask) uASTask);
            }
            if (uASTask.getTaskMessageUid() != null) {
                sendTaskResponse(uASTask, TaskResponse.RESPONSETYPE.EXECUTING);
                return;
            }
            return;
        }
        UASToolDropDownReceiver.toast("Indago tasking failed: NULL task", 0);
        Log.w(TAG, "Indago tasking failed: NULL task");
    }

    /* renamed from: com.atakmap.android.uastool.indago.IndagoUASItem$3 */
    /* synthetic */ class C15113 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE;
        static final /* synthetic */ int[] $SwitchMap$indago$messages$VideoPointType;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        static {
            /*
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE[] r0 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE = r0
                r1 = 1
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r2 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.ROUTE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r3 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_FOVCENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r4 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_REMOTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r5 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_CANCEL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                indago.messages.VideoPointType[] r4 = indago.messages.VideoPointType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$indago$messages$VideoPointType = r4
                indago.messages.VideoPointType r5 = indago.messages.VideoPointType.UPPER_LEFT_CORNER     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$indago$messages$VideoPointType     // Catch:{ NoSuchFieldError -> 0x004e }
                indago.messages.VideoPointType r4 = indago.messages.VideoPointType.UPPER_RIGHT_CORNER     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$indago$messages$VideoPointType     // Catch:{ NoSuchFieldError -> 0x0058 }
                indago.messages.VideoPointType r1 = indago.messages.VideoPointType.LOWER_RIGHT_CORNER     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$indago$messages$VideoPointType     // Catch:{ NoSuchFieldError -> 0x0062 }
                indago.messages.VideoPointType r1 = indago.messages.VideoPointType.LOWER_LEFT_CORNER     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$indago$messages$VideoPointType     // Catch:{ NoSuchFieldError -> 0x006d }
                indago.messages.VideoPointType r1 = indago.messages.VideoPointType.FRAME_CENTER     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.indago.IndagoUASItem.C15113.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void runRouteTask(RouteTask routeTask) {
        UASToolDropDownReceiver.toast("Indao tasking failed: Not Implemented", 0);
    }

    public double getBatteryPercent() {
        VehicleStatus vehicleStatus = this.lastStatusUpdate.get();
        double intValue = (vehicleStatus == null || vehicleStatus.getBatteryPercentRemaining() == null) ? 0.0d : ((double) vehicleStatus.getBatteryPercentRemaining().intValue()) / 100.0d;
        setBatteryPercent(intValue);
        return intValue;
    }

    public double getSpeed() {
        VehicleKinematicData vehicleKinematicData = this.lastKinematicUpdate.get();
        if (vehicleKinematicData != null) {
            return vehicleKinematicData.getGroundSpeed().computeMagnitude();
        }
        return 0.0d;
    }

    public double getFlightTimeMins() {
        VehicleStatus vehicleStatus = this.lastStatusUpdate.get();
        return (double) ((vehicleStatus == null || vehicleStatus.getFlightTimeRemaining() == null) ? 0 : vehicleStatus.getFlightTimeRemaining().intValue());
    }

    public boolean hasGPS() {
        return this.lastKinematicUpdate.get() != null;
    }

    public void zoomIn() {
        this.connection.payloadConrol(0.0d, 0.0d, 25.0d);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                IndagoUASItem.this.connection.payloadConrol(0.0d, 0.0d, 0.0d);
            }
        }, 750);
    }

    public void zoomOut() {
        this.connection.payloadConrol(0.0d, 0.0d, -25.0d);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                IndagoUASItem.this.connection.payloadConrol(0.0d, 0.0d, 0.0d);
            }
        }, 750);
    }

    protected IndagoUASItem(String str, String str2, String str3, boolean z) {
        super(DETAIL_TAG, str, str2, str3, z);
    }

    public void taskSensorToPoint(GeoPoint geoPoint) {
        UASToolDropDownReceiver.toast("sensor looking at point...", 0);
        this.connection.lookAtPosition(geoPoint.getLatitude(), geoPoint.getLongitude(), EGM96.getMSL(geoPoint));
    }

    public void updateGeoreference(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        GeoPoint geoPoint = new GeoPoint(d, d2, d3);
        if (this.uasMarker != null) {
            this.uasMarker.a(geoPoint);
        }
        setHFOV(d6);
        setVFOV(d7);
        setGimbalPitch(d4);
        setGimbalAngle(d5);
        super.onUasGeoreferenceUpdate(true);
    }

    public IAircraftItem getAircraftItem() {
        if (this.lastUpdateTime - System.currentTimeMillis() > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
            Log.d(TAG, "Indago platform is not responding");
            this.connection.disconnect();
            return null;
        } else if (this.lastKinematicUpdate.get() == null || this.lastStatusUpdate == null) {
            return null;
        } else {
            this.aci.get().callsign = getCallsign();
            this.aci.get().platformId = getPlatformType();
            this.aci.get().UID = getUid();
            return this.aci.get().copy();
        }
    }

    public double getHeading() {
        try {
            return this.aci.get().acheading;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public double getRoll() {
        try {
            return this.aci.get().attitudeRoll;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public double getPitch() {
        try {
            return this.aci.get().attitudePitch;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public double getYaw() {
        try {
            return this.aci.get().attitudeYaw;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public String getVideoUrl() {
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(IndagoPrefHandler.PREF_SRC_IP, IndagoPrefHandler.DEFAULT_SRC_IP);
        String string2 = UASToolDropDownReceiver.getSharedPrefs().getString(IndagoPrefHandler.PREF_SRC_PORT, IndagoPrefHandler.DEFAULT_SRC_PORT);
        if (!isConnected()) {
            return super.getVideoUrl();
        }
        return "udp://" + string + ":" + string2;
    }
}
