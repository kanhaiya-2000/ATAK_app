package com.atakmap.android.uastool.mavlink;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.av;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.RouteDrawPoint;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.generic.JoystickListener;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.QuickTask;
import com.atakmap.android.uastool.tasks.TaskResponse;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCFOVCenterTask;
import com.atakmap.android.uastool.tasks.route.OrbitPoint;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.RouteTaskErrorList;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.trillium.TrilliumPrefHandler;
import com.atakmap.android.uastool.utils.ImagingGatherer;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.ae;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import com.atakmap.math.PointD;
import com.bbn.ccast.mavlink.MavLinkDialectInterface;
import com.bbn.ccast.mavlink.MavLinkThread;
import com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle;
import com.bbn.vehicleinterface.types.GeoPosition;
import com.bbn.vehicleinterface.types.ResultCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class MAVLinkUASItem extends UASItem implements SharedPreferences.OnSharedPreferenceChangeListener, MavLinkParameterChangedCallback, MavLinkTelemetryCallback, MavLinkThread.MissionItemReachedCallback {
    public static final String DETAIL_TAG = "_MAVLink_";
    public static final String DISPLAY_NAME = "MAVLink";
    private static JoystickListener joystickListener;
    boolean armedStatus = false;
    private float currentZoomLevel = 50.0f;
    boolean gimbalLockOn = false;
    private MavlinkVehicle mavlinkVehicle;
    private final AtomicReference<Float> maxAltitude = new AtomicReference<>(Float.valueOf(500.0f));
    private final AtomicReference<Float> maxSpeed = new AtomicReference<>(Float.valueOf(15.0f));
    private final AtomicReference<Float> minAltitude = new AtomicReference<>(Float.valueOf(2.5f));
    private final AtomicReference<Float> minSpeed = new AtomicReference<>(Float.valueOf(1.0f));
    private ImagingGatherer missionImaging = null;
    String modeStatus = "";

    public float getZoomMax() {
        return 100.0f;
    }

    public float getZoomMin() {
        return 0.0f;
    }

    public boolean isAircraftItemCapable() {
        return true;
    }

    public void onHomePositonUpdate(double d, double d2, double d3) {
    }

    public boolean setVirtualStickMode(boolean z) {
        return true;
    }

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public MAVLinkUASItem(ao aoVar, boolean z) {
        super(aoVar, z, DETAIL_TAG);
    }

    public MAVLinkUASItem(String str, String str2, boolean z) {
        super(DETAIL_TAG, str, str2, DISPLAY_NAME, z);
    }

    public void copy(UASItem uASItem) {
        super.copy(uASItem);
        if (uASItem instanceof MAVLinkUASItem) {
            setVehicle(((MAVLinkUASItem) uASItem).getVehicle());
        }
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_GOTOMODE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_FINISHACTION, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_RADIUS, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_COUNT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_CLOCKWISE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_GIMBAL_PITCH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ZOOM_CAMERA, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_GROUNDSPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HAL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_OVERLAY_SHOW, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROTATION_MATRIX_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SETTINGS, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ATTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_STOP, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_RTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_FOLLOW, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_TASK, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_QUICK_TASK, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_NEWROUTE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_EXISTROUTE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_PERIMETER, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_SURVEY, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_JOYSTICK_VIRTUAL, true);
    }

    /* access modifiers changed from: protected */
    public void setPlatformValues() {
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_SPEED_MIN, "1.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_SPEED_MAX, "15.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, "8.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_MIN, "3");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_MAX, "152.4");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_DEFAULT, "23.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MIN, "2.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MAX, TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_VIDEO_BUFFERING);
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_DEFAULT, "10.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MIN, "1.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MAX, "8.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_DEFAULT, "15.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_UNITSTYPE, OrbitPoint.ORBITSPEED_UNITS_LINEAR);
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MIN, "0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MAX, "10");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_DEFAULT, "1");
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return (MAVLinkSettingsScreen) layoutInflater.inflate(C1877R.layout.mavlink_settings_layout, (ViewGroup) null);
    }

    public ArrayList<RouteDrawPoint> getRouteDrawPoints() {
        ArrayList<RouteDrawPoint> arrayList = new ArrayList<>();
        if (this.uasMarker != null) {
            String metaString = this.uasMarker.getMetaString("waypoints", (String) null);
            if (!TextUtils.isEmpty(metaString)) {
                for (String split : metaString.split("\n")) {
                    arrayList.add(new RouteDrawPoint(split.split("\\s*,\\s*")));
                }
            }
        }
        return arrayList;
    }

    public void zoomIn() {
        setZoomStep(1);
    }

    public void zoomOut() {
        setZoomStep(-1);
    }

    public void setZoomStep(int i) {
        try {
            getMavLinkThread().setZoomStep(i);
        } catch (Exception e) {
            Log.e(TAG, "Error on zoom: ", e);
        }
    }

    public float getZoomLevel() {
        return this.currentZoomLevel;
    }

    private MavlinkVehicle getVehicle() {
        return this.mavlinkVehicle;
    }

    public void setVehicle(MavlinkVehicle mavlinkVehicle2) {
        unRegisterMavlinkListeners();
        this.mavlinkVehicle = mavlinkVehicle2;
        registerMavlinkListeners();
    }

    private void registerMavlinkListeners() {
        if (getMavLinkThread() != null) {
            try {
                getMavLinkThread().addSettingsListener(this);
                getMavLinkThread().addTelemetryListener(this);
                getMavLinkThread().addMissionItemListener(this);
            } catch (Exception e) {
                UASToolDropDownReceiver.toast("Error creating paramListener for Mavlink)", 0);
                Log.e(TAG, "Error creating paramListener for Mavlink)", e);
            }
            try {
                if (UASToolDropDownReceiver.getSharedPrefs().getBoolean(MAVLinkPrefHandler.PREF_MAVLINK_JOYSTICK_ENABLE, true)) {
                    JoystickListener joystickListener2 = joystickListener;
                    if (joystickListener2 != null) {
                        joystickListener2.dispose();
                    }
                    joystickListener = new JoystickListener(this);
                }
            } catch (Exception e2) {
                UASToolDropDownReceiver.toast("Error creating joystick listener for Mavlink", 0);
                Log.e(TAG, "Error creating paramListener for Mavlink)", e2);
            }
            UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
        }
    }

    private void unRegisterMavlinkListeners() {
        if (getMavLinkThread() != null) {
            try {
                this.mavlinkVehicle.getMavLinkThread().removeSettingsListener(this);
                this.mavlinkVehicle.getMavLinkThread().removeTelemetryListener(this);
                this.mavlinkVehicle.getMavLinkThread().removeMissionItemListener(this);
            } catch (Exception unused) {
                UASToolDropDownReceiver.toast("Error unregistering paramListener for Mavlink)", 0);
            }
            try {
                JoystickListener joystickListener2 = joystickListener;
                if (joystickListener2 != null) {
                    joystickListener2.dispose();
                    joystickListener = null;
                }
            } catch (Exception e) {
                UASToolDropDownReceiver.toast("Error creating joystick listener for Mavlink", 0);
                Log.e(TAG, "Error creating joystick listener for Mavlink", e);
            }
            UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    public void dispose() {
        unRegisterMavlinkListeners();
        super.dispose();
    }

    public MavLinkThread getMavLinkThread() {
        MavlinkVehicle vehicle = getVehicle();
        if (vehicle == null) {
            return null;
        }
        return vehicle.getMavLinkThread();
    }

    public UASItem.SIGNAL_STRENGTH getSignalStrength() {
        if (getMarker() != null) {
            return UASItem.SIGNAL_STRENGTH.OK;
        }
        return super.getSignalStrength();
    }

    public void runTask(UASTask uASTask) {
        super.runTask(uASTask);
        if (uASTask != null) {
            int i = C15533.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()];
            if (i == 1) {
                runRouteTask((RouteTask) uASTask);
            } else if (i == 2) {
                lookAtPoint((LTCLCFOVCenterTask) uASTask);
            } else if (!(i == 3 || i == 4)) {
                if (i != 5) {
                    UASToolDropDownReceiver.toast("Unable to run unknown task type: " + uASTask.getTaskType().name(), 0);
                } else {
                    runQuickTask((QuickTask) uASTask);
                }
            }
            if (uASTask.getTaskMessageUid() != null) {
                sendTaskResponse(uASTask, TaskResponse.RESPONSETYPE.EXECUTING);
                return;
            }
            return;
        }
        UASToolDropDownReceiver.toast("Mavlink tasking failed: NULL task", 0);
        Log.w(TAG, "Mavlink tasking failed: NULL task");
    }

    /* renamed from: com.atakmap.android.uastool.mavlink.MAVLinkUASItem$3 */
    /* synthetic */ class C15533 {
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE[] r0 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE = r0
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.ROUTE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_FOVCENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_REMOTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_CANCEL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.QUICKFLY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.mavlink.MAVLinkUASItem.C15533.<clinit>():void");
        }
    }

    public void pauseTask(UASTask uASTask) {
        if (!sendRemoteTask(uASTask, QuickTask.ACTION.PAUSE)) {
            enterLoiterMode();
        }
    }

    public void resumeTask(UASTask uASTask) {
        if (!sendRemoteTask(uASTask, QuickTask.ACTION.RESUME)) {
            MavlinkVehicle vehicle = getVehicle();
            if (vehicle == null) {
                UASToolDropDownReceiver.toast("Failed to Resume Task, no vehicle connected", 0);
            } else {
                vehicle.enterMissionMode(new ResultCallback());
            }
        }
    }

    public void stopTask(UASTask uASTask) {
        super.stopTask(uASTask);
        ImagingGatherer imagingGatherer = this.missionImaging;
        if (imagingGatherer != null) {
            imagingGatherer.stop();
            this.missionImaging = null;
        }
        sendRemoteTask(uASTask, QuickTask.ACTION.STOP);
        setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
        enterLoiterMode();
        UASTaskStore.getInstance().stopRunningRoutes(this);
        enterLoiterMode();
        if (uASTask.getTaskMessageUid() != null) {
            sendTaskResponse(uASTask, TaskResponse.RESPONSETYPE.CANCELLED);
        }
    }

    /* access modifiers changed from: protected */
    public void lookAtPoint(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
        super.lookAtPoint(lTCLCFOVCenterTask);
        taskSensorToPoint(lTCLCFOVCenterTask.getPoint());
    }

    public void taskSensorToPoint(GeoPoint geoPoint) {
        try {
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null && mavLinkThread.isConnected()) {
                if (getGimbalFollowController() != null && getGimbalFollowController().getFollowing() == null) {
                    UASToolDropDownReceiver.toast("Executing Gimbal Control FOV Center task.", 0);
                }
                double altitude = geoPoint.getAltitude();
                if (Double.isNaN(altitude)) {
                    altitude = ElevationManager.a(geoPoint.getLatitude(), geoPoint.getLongitude(), (ElevationManager.b) null);
                }
                if (Double.isNaN(altitude)) {
                    altitude = 0.0d;
                }
                this.gimbalLockOn = true;
                mavLinkThread.sendSetROI(geoPoint.getLatitude(), geoPoint.getLongitude(), altitude);
                UASToolDropDownReceiver.onUasItemStatusChanged();
                return;
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to execute LTCLCFOVCenterTask: ", e);
        }
        UASToolDropDownReceiver.toast("Failed to execute Gimbal Control FOV Center task.", 0);
    }

    public void resetGimbalPitchAndYaw() {
        if (!isConnected()) {
            super.resetGimbalPitchAndYaw();
            return;
        }
        try {
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null && mavLinkThread.isConnected()) {
                UASToolDropDownReceiver.toast("Set Gimbal ROI_NONE", 0);
                mavLinkThread.sendGimbalPosePRY(0.0d, 0.0d, 0.0d);
                return;
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to execute Gimbal ROI_NONE: ", e);
        }
        UASToolDropDownReceiver.toast("Failed to set Gimbal ROI_NONE.", 0);
    }

    public RouteTaskErrorList validateRouteTask(RouteTask routeTask) {
        UASPoint uASPoint;
        UASRoute uASRoute;
        String str;
        String str2;
        RouteTaskErrorList validateRouteTask = super.validateRouteTask(routeTask);
        if (validateRouteTask.errorType == RouteTaskErrorList.ErrorType.ERROR) {
            return validateRouteTask;
        }
        double capabilityValueDouble = getCapabilityValueDouble(this, getPlatformType(), UASItemCapabilities.VALUE_ROUTE_AGL_MIN, 3.0d);
        int i = 0;
        for (UASRoute route = routeTask.getRoute(); i < route.getPointCnt(); route = uASRoute) {
            int i2 = i + 1;
            UASPoint pointWithIndex = route.getPointWithIndex(i2);
            UASPoint pointWithIndex2 = route.getPointWithIndex(i);
            float speed = pointWithIndex.getSpeed();
            float agl = pointWithIndex.getAGL();
            GeoPoint C = pointWithIndex.C();
            if (pointWithIndex2 != null) {
                uASPoint = pointWithIndex;
                double distanceTo = pointWithIndex2.C().distanceTo(C);
                if (distanceTo > 900.0d) {
                    String str3 = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Route Point ");
                    sb.append(i2);
                    uASRoute = route;
                    sb.append(" ");
                    sb.append(distanceTo);
                    sb.append("m > 900m away from previous Route Point)");
                    Log.d(str3, sb.toString());
                    validateRouteTask.add("Point " + i2 + " range " + Utils.formatRange(distanceTo) + ">" + Utils.formatRange(900.0d) + " from Point " + i, RouteTaskErrorList.ErrorType.WARN);
                } else {
                    uASRoute = route;
                }
            } else {
                uASRoute = route;
                uASPoint = pointWithIndex;
            }
            if (getMaxAltitude() <= 0.0f || agl <= getMaxAltitude()) {
                str2 = ")";
                str = " Altitude ";
            } else {
                String str4 = TAG;
                Log.d(str4, "Route Point " + i2 + " Altitude " + agl + " exceeds maximum configured altitude (" + this.maxAltitude.get() + ")");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Point ");
                sb2.append(i2);
                sb2.append(" Altitude ");
                str2 = ")";
                str = " Altitude ";
                sb2.append(Utils.formatAlt((double) agl));
                sb2.append(">");
                sb2.append(Utils.formatAlt((double) this.maxAltitude.get().floatValue()));
                validateRouteTask.add(sb2.toString(), RouteTaskErrorList.ErrorType.WARN);
            }
            double d = (double) agl;
            if (d < capabilityValueDouble) {
                String str5 = TAG;
                Log.d(str5, "Route Point " + i2 + str + agl + " is lower than minimum configured safe altitude (" + capabilityValueDouble + str2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Point ");
                sb3.append(i2);
                sb3.append(str);
                sb3.append(Utils.formatAlt(d));
                sb3.append("<");
                sb3.append(Utils.formatAlt(capabilityValueDouble));
                validateRouteTask.add(sb3.toString(), RouteTaskErrorList.ErrorType.WARN);
            }
            if (speed > this.maxSpeed.get().floatValue()) {
                String str6 = TAG;
                Log.d(str6, "Route Point " + i2 + " Speed " + speed + " exceeds maximum configured speed (" + this.maxSpeed.get() + str2);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Point ");
                sb4.append(i2);
                sb4.append(" Speed ");
                sb4.append(ae.a().a((double) speed));
                sb4.append(">");
                sb4.append(ae.a().a((double) this.maxSpeed.get().floatValue()));
                validateRouteTask.add(sb4.toString(), RouteTaskErrorList.ErrorType.WARN);
            }
            if (uASPoint.getPointType().equals(UASPoint.POINTTYPE.ORBITPOINT)) {
                float orbitSpeed = ((OrbitPoint) uASPoint).getOrbitSpeed();
                if (orbitSpeed > this.maxSpeed.get().floatValue()) {
                    String str7 = TAG;
                    Log.d(str7, "OrbitPoint " + i2 + " Speed " + orbitSpeed + " exceeds maximum configured speed (" + this.maxSpeed.get() + str2);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Orbit ");
                    sb5.append(i2);
                    sb5.append(" Speed ");
                    sb5.append(ae.a().a((double) orbitSpeed));
                    sb5.append(">");
                    sb5.append(ae.a().a((double) this.maxSpeed.get().floatValue()));
                    validateRouteTask.add(sb5.toString(), RouteTaskErrorList.ErrorType.WARN);
                }
            }
            i = i2;
        }
        return validateRouteTask;
    }

    /* access modifiers changed from: protected */
    public void runRouteTask(RouteTask routeTask) {
        if (getVehicle() == null) {
            UASToolDropDownReceiver.toast("Failed to Run Task, no vehicle connected", 0);
            return;
        }
        ImagingGatherer imagingGatherer = this.missionImaging;
        if (imagingGatherer != null) {
            imagingGatherer.stop();
            this.missionImaging = null;
        }
        if (!(routeTask.getImageryInterval() == null || routeTask.getImageryInterval().floatValue() == 0.0f)) {
            this.missionImaging = new ImagingGatherer(this, UASToolDropDownReceiver.getInstance().getOperatorPager().getOperatorControlFragment(), routeTask.getImageryInterval());
        }
        getVehicle().flyRoute(routeTask, new ResultCallback<Void>() {
            public void onStart() {
            }

            public void onResult(Void voidR) {
                Log.d(MAVLinkUASItem.TAG, "Executing FlyRoute.");
            }

            public void onError(String str) {
                UASToolDropDownReceiver.toast("Failed FlyRoute.", 1);
                String access$100 = MAVLinkUASItem.TAG;
                Log.d(access$100, "Failed FlyRoute: " + str);
            }
        });
    }

    public float getMinAltitude() {
        return this.minAltitude.get().floatValue();
    }

    public float getMaxAltitude() {
        return this.maxAltitude.get().floatValue();
    }

    public void setMaxAltitude(Float f) {
        this.maxAltitude.set(f);
    }

    public float getMinSpeed() {
        return this.minSpeed.get().floatValue();
    }

    public float getMaxSpeed() {
        return this.maxSpeed.get().floatValue();
    }

    public void quickTakeoff(int i) {
        double d = (double) i;
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.TAKEOFF, d)) {
            super.quickTakeoff(i);
            cancelAllActiveTasks();
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread == null || !mavLinkThread.isConnected()) {
                UASToolDropDownReceiver.toast("No connected MAVLink UAS", 1);
                return;
            }
            mavLinkThread.startTakeoffProcess(Double.valueOf(d), new MavLinkThread.TakeoffCallback() {
                public void onFailure(int i) {
                }

                public void onSuccess() {
                }
            });
            UASToolDropDownReceiver.toast("Quick takeoff in progress...", 0);
        }
    }

    public void quickLanding() {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.LAND)) {
            super.quickLanding();
            cancelAllActiveTasks();
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread == null || !mavLinkThread.isConnected()) {
                UASToolDropDownReceiver.toast("No connected MAVLink UAS", 1);
                return;
            }
            try {
                mavLinkThread.land();
                UASToolDropDownReceiver.toast("Quick landing in progress...", 0);
            } catch (Exception e) {
                Log.d(TAG, "No connected MAVLink UAS", e);
                UASToolDropDownReceiver.toast("No connected MAVLink UAS", 1);
            }
        }
    }

    private void cancelAllActiveTasks() {
        ImagingGatherer imagingGatherer = this.missionImaging;
        if (imagingGatherer != null) {
            imagingGatherer.stop();
            this.missionImaging = null;
        }
        setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
        enterLoiterMode();
        UASTask runningRoute = UASTaskStore.getInstance().getRunningRoute(this);
        if (!(runningRoute == null || runningRoute.getTaskSourceUid() == null)) {
            sendTaskResponse(runningRoute, TaskResponse.RESPONSETYPE.CANCELLED);
        }
        UASTaskStore.getInstance().stopRunningRoutes(this);
    }

    public void quickStop() {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.QUICKSTOP)) {
            super.quickStop();
            enterLoiterMode();
            UASTaskStore.getInstance().pauseRunningRoutes();
            UASToolDropDownReceiver.toast("Quick stop in progress...", 0);
            UASTask runningRoute = UASTaskStore.getInstance().getRunningRoute(this);
            if (runningRoute != null && runningRoute.getTaskSourceUid() != null) {
                sendTaskResponse(runningRoute, TaskResponse.RESPONSETYPE.CANCELLED);
            }
        }
    }

    public void quickRTH() {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.RTH)) {
            super.quickRTH();
            cancelAllActiveTasks();
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null) {
                try {
                    if (mavLinkThread.isConnected()) {
                        mavLinkThread.enterReturnToHomeMode(new ResultCallback());
                        mavLinkThread.enterReturnToHomeMode(new ResultCallback());
                        return;
                    }
                } catch (Exception e) {
                    Log.d(TAG, "Could not Return to Home", e);
                }
            }
            UASToolDropDownReceiver.toast("No connected MAVLink UAS", 1);
        }
    }

    public void quickAltitude(int i) {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.ALTITUDE, (double) i)) {
            super.quickAltitude(i);
            cancelAllActiveTasks();
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null && mavLinkThread.isConnected()) {
                try {
                    mavLinkThread.changeAltitude((float) i);
                    UASToolDropDownReceiver.toast("Quick altitude in progress...", 0);
                    return;
                } catch (Exception e) {
                    Log.d(TAG, "Could not change Altitude: ", e);
                }
            }
            UASToolDropDownReceiver.toast("No connected MAVLink UAS", 1);
        }
    }

    public boolean isFlying() {
        if (!isDefault()) {
            return super.isFlying();
        }
        try {
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null) {
                return mavLinkThread.inAir();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean readyToTakeoff() {
        return !isFlying();
    }

    public boolean readyToLand() {
        return isFlying();
    }

    public void enterLoiterMode() {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread != null) {
            try {
                mavLinkThread.enterPositionHoldMode();
            } catch (Exception e) {
                Log.d(TAG, "Unable To enter Loiter Mode", e);
                UASToolDropDownReceiver.toast("Unable To enter Loiter Mode", 0);
            }
        }
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

    public void onParameterChanged(String str, Float f) {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_ALT).equals(str)) {
            this.maxAltitude.set(f);
        } else if (mavLinkThread.getParamName(MavLinkDialectInterface.ParamSettings.MAX_VEL).equals(str)) {
            this.maxSpeed.set(f);
            this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_SPEED_MAX, String.valueOf(f));
            this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MAX, String.valueOf(f));
        }
    }

    public void onMissionItemReached(int i, int i2) {
        ImagingGatherer imagingGatherer;
        if (i == i2 - 1) {
            cancelAllActiveTasks();
        }
        if (i == 4 && (imagingGatherer = this.missionImaging) != null) {
            imagingGatherer.start();
        }
    }

    public IAircraftItem getAircraftItem() {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread == null || !mavLinkThread.isConnected()) {
            return null;
        }
        IAircraftItem iAircraftItem = new IAircraftItem();
        iAircraftItem.callsign = getCallsign();
        if (mavLinkThread.getDronePosition_HAL() != null) {
            GeoPosition dronePosition_HAL = mavLinkThread.getDronePosition_HAL();
            iAircraftItem.aclat = dronePosition_HAL.getLatitude();
            iAircraftItem.aclon = dronePosition_HAL.getLongitude();
            iAircraftItem.acalt = dronePosition_HAL.getAltitude();
            iAircraftItem.achal = dronePosition_HAL.getAltitude();
            iAircraftItem.acce = 0.0d;
            iAircraftItem.acle = 0.0d;
        }
        iAircraftItem.speed = mavLinkThread.getSpeed();
        iAircraftItem.acheading = mavLinkThread.getYaw();
        if (iAircraftItem.acheading < 0.0d) {
            iAircraftItem.acheading += 360.0d;
        }
        try {
            iAircraftItem.isFlying = mavLinkThread.inAir();
        } catch (Exception unused) {
            iAircraftItem.isFlying = false;
        }
        iAircraftItem.platformId = getPlatformType();
        iAircraftItem.UID = getUid();
        GeoPosition homePosition = mavLinkThread.getHomePosition();
        if (homePosition != null) {
            iAircraftItem.homelat = homePosition.getLatitude();
            iAircraftItem.homelon = homePosition.getLongitude();
            iAircraftItem.homealt = ElevationManager.a(iAircraftItem.homelat, iAircraftItem.homelon, (ElevationManager.b) null);
        }
        MavLinkDialectInterface.GimbalPosePRYYa<Double> cameraOrientation = mavLinkThread.getCameraOrientation();
        if (cameraOrientation != null) {
            iAircraftItem.sensorAzimuth = ((Double) cameraOrientation.yawAbsolute).doubleValue();
            iAircraftItem.sensorElevation = ((Double) cameraOrientation.pitch).doubleValue();
            iAircraftItem.sensorRoll = 0.0d;
            iAircraftItem.sensorHFOV = 64.0d;
            iAircraftItem.sensorVFOV = 38.0d;
        }
        iAircraftItem.attitudePitch = mavLinkThread.getPitch();
        iAircraftItem.attitudeRoll = mavLinkThread.getRoll();
        iAircraftItem.attitudeYaw = mavLinkThread.getYaw();
        iAircraftItem.battVolt = mavLinkThread.getBatteryVoltage();
        iAircraftItem.battMax = 100;
        iAircraftItem.battRem = (int) mavLinkThread.getBatteryPercent();
        iAircraftItem.signalQuality = (int) mavLinkThread.getRssi();
        iAircraftItem.routePoints = getVehicle().getRoutePoints();
        UASToolDropDownReceiver.getInstance();
        PointD customFov = UASToolDropDownReceiver.getReflector().getCustomFov();
        if (customFov != null && customFov.x > 0.0d && customFov.y > 0.0d) {
            iAircraftItem.sensorHFOV = customFov.x;
            iAircraftItem.sensorVFOV = customFov.y;
        }
        Reflector.updateAircraftItemWithZeroZero(iAircraftItem);
        Reflector.updateAircraftItemWithDTED(iAircraftItem);
        Reflector.updateAircraftItemFOV(iAircraftItem);
        updateGeoreference(iAircraftItem.aclat, iAircraftItem.aclon, iAircraftItem.acalt, iAircraftItem.sensorElevation, iAircraftItem.sensorAzimuth, iAircraftItem.sensorHFOV, iAircraftItem.sensorVFOV, iAircraftItem.homealt);
        return iAircraftItem;
    }

    public void onPositionUpdate(double d, double d2, double d3, double d4, double d5) {
        GeoPosition homePosition;
        ao marker = getMarker();
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread != null && mavLinkThread.isConnected() && (homePosition = mavLinkThread.getHomePosition()) != null) {
            GeoPoint geoPoint = new GeoPoint(d, d2, ElevationManager.a(homePosition.getLatitude(), homePosition.getLongitude(), (ElevationManager.b) null) + d3, GeoPoint.AltitudeReference.HAE, 0.0d, 0.0d);
            if (marker != null) {
                synchronized (getMarker()) {
                    marker.a(geoPoint);
                    marker.setMetaDouble("track:course", d5);
                }
            }
        }
    }

    public void onSensorAngleUpdate(double d, double d2, double d3, double d4) {
        ao marker = getMarker();
        if (marker != null) {
            synchronized (marker) {
                setGimbalPitch(d);
                setGimbalAngle(d4);
            }
            super.onUasGeoreferenceUpdate(true);
        }
    }

    public void setManualControl(float[] fArr) {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread != null) {
            if (getGimbalLockOn() && ((double) Math.abs(fArr[2])) > 0.2d) {
                setGimbalLockOn(false);
            }
            try {
                mavLinkThread.sendManualControl((short) ((int) (fArr[0] * 1000.0f)), (short) ((int) (fArr[1] * -1000.0f)), (short) ((int) (fArr[2] * 1000.0f)), (short) ((int) ((fArr[3] * -500.0f) + 500.0f)), 0);
            } catch (Exception e) {
                Log.e(TAG, "Could not send manual control", e);
            }
        }
    }

    public void pitchGimbalDown() {
        try {
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null && mavLinkThread.isConnected()) {
                if (getGimbalLockOn()) {
                    setGimbalLockOn(false);
                }
                MavLinkDialectInterface.GimbalPosePRYYa<Double> cameraOrientation = mavLinkThread.getCameraOrientation();
                if (Double.isNaN(((Double) cameraOrientation.pitch).doubleValue())) {
                    cameraOrientation.pitch = Double.valueOf(0.0d);
                }
                mavLinkThread.sendGimbalPosePRY(((Double) cameraOrientation.pitch).doubleValue() - 3.0d, ((Double) cameraOrientation.roll).doubleValue(), ((Double) cameraOrientation.yaw).doubleValue());
            }
        } catch (Exception unused) {
        }
    }

    public void pitchGimbalUp() {
        try {
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null && mavLinkThread.isConnected()) {
                if (getGimbalLockOn()) {
                    setGimbalLockOn(false);
                }
                MavLinkDialectInterface.GimbalPosePRYYa<Double> cameraOrientation = mavLinkThread.getCameraOrientation();
                if (Double.isNaN(((Double) cameraOrientation.pitch).doubleValue())) {
                    cameraOrientation.pitch = Double.valueOf(0.0d);
                }
                mavLinkThread.sendGimbalPosePRY(((Double) cameraOrientation.pitch).doubleValue() + 3.0d, ((Double) cameraOrientation.roll).doubleValue(), ((Double) cameraOrientation.yaw).doubleValue());
            }
        } catch (Exception unused) {
        }
    }

    public void setHomePosition(GeoPoint geoPoint) {
        try {
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null && mavLinkThread.isConnected()) {
                double a = ElevationManager.a(geoPoint.getLatitude(), geoPoint.getLongitude(), (ElevationManager.b) null);
                if (Double.isNaN(a)) {
                    a = geoPoint.getAltitude();
                }
                mavLinkThread.setHomePosition(geoPoint.getLatitude(), geoPoint.getLongitude(), a);
            }
        } catch (Exception unused) {
            UASToolDropDownReceiver.toast("Unable to set Home Position");
        }
    }

    public int getVideoUIButtons() {
        if (isConnected()) {
            return C1877R.layout.video_ui_op_mavlink_buttonbar;
        }
        return super.getVideoUIButtons();
    }

    public String getVideoUrl() {
        String string;
        if (!isConnected()) {
            return super.getVideoUrl();
        }
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        if (sharedPrefs.getInt(MAVLinkPrefHandler.PREF_VIDEO_ACTIVE_URI, 1) == 2 && (string = sharedPrefs.getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI2, "")) != null && !string.trim().isEmpty()) {
            return string;
        }
        return sharedPrefs.getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI, MAVLinkPrefHandler.DEFAULT_VIDEO_SRC_URI);
    }

    public void toggleVideo() {
        SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
        int i = sharedPrefs.getInt(MAVLinkPrefHandler.PREF_VIDEO_ACTIVE_URI, 1);
        String string = sharedPrefs.getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI, MAVLinkPrefHandler.DEFAULT_VIDEO_SRC_URI);
        String string2 = sharedPrefs.getString(MAVLinkPrefHandler.PREF_VIDEO_SRC_URI2, "");
        SharedPreferences.Editor edit = sharedPrefs.edit();
        if (i == 1 && string2 != null && !string2.trim().isEmpty()) {
            UASToolDropDownReceiver.toast("Video: " + string2);
            edit.putInt(MAVLinkPrefHandler.PREF_VIDEO_ACTIVE_URI, 2);
        } else if (string2 == null || string2.trim().isEmpty()) {
            UASToolDropDownReceiver.toast("Video 2 not active");
            return;
        } else {
            UASToolDropDownReceiver.toast("Video: " + string);
            edit.putInt(MAVLinkPrefHandler.PREF_VIDEO_ACTIVE_URI, 1);
        }
        edit.apply();
    }

    public void sendArm(boolean z) {
        if (!z) {
            try {
                if (isFlying()) {
                    UASToolDropDownReceiver.toast("Disarming denied. Not Landed");
                    return;
                }
            } catch (IOException e) {
                Log.e(TAG, "error", e);
                return;
            }
        }
        getMavLinkThread().sendArm(z, (MavLinkThread.ArmDisarmCallback) null);
    }

    public boolean isArmed() {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread == null) {
            return false;
        }
        return mavLinkThread.isArmed();
    }

    public void onHeartBeat(boolean z, String str) {
        if (str == null) {
            str = "";
        }
        if (z != this.armedStatus || !str.equals(this.modeStatus)) {
            this.armedStatus = z;
            this.modeStatus = str;
            UASToolDropDownReceiver.onUasItemStatusChanged();
        }
    }

    public String[] getModes() {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread == null) {
            return new String[0];
        }
        return mavLinkThread.getModes();
    }

    public void setMode(String str) {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread != null) {
            mavLinkThread.setMode(str);
        }
    }

    public String getModeString() {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread == null) {
            return null;
        }
        return mavLinkThread.getModeString();
    }

    public boolean getGimbalLockOn() {
        return this.gimbalLockOn;
    }

    public void setGimbalLockOn(boolean z) {
        try {
            MavLinkThread mavLinkThread = getMavLinkThread();
            if (mavLinkThread != null && mavLinkThread.isConnected() && !z) {
                this.gimbalLockOn = false;
                mavLinkThread.sendSetROI(Double.NaN, Double.NaN, Double.NaN);
                UASToolDropDownReceiver.onUasItemStatusChanged();
            }
        } catch (Exception unused) {
        }
    }

    public double getHeading() {
        if (!isDefault()) {
            return super.getHeading();
        }
        return getMavLinkThread().getYaw();
    }

    public double getPitch() {
        if (!isDefault()) {
            return super.getPitch();
        }
        return getMavLinkThread().getPitch();
    }

    public double getRoll() {
        if (!isDefault()) {
            return super.getRoll();
        }
        return getMavLinkThread().getRoll();
    }

    public double getYaw() {
        if (!isDefault()) {
            return super.getYaw();
        }
        return getMavLinkThread().getYaw();
    }

    public short getAutoPilotType() {
        MavLinkThread mavLinkThread = getMavLinkThread();
        if (mavLinkThread == null) {
            return -1;
        }
        return mavLinkThread.getAutopilotType();
    }

    public void joystickPosition(float f, float f2, float f3, float f4) {
        setManualControl(new float[]{f3, f4 * -1.0f, f, f2 * -1.0f});
    }

    public void joystickGimbalPosition(float f, float f2) {
        try {
            getMavLinkThread().sendGimbalPitchYaw((short) ((int) (f * 1000.0f)), (short) ((int) (f2 * 1000.0f)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void continuousZoom(float f) {
        double d = (double) f;
        try {
            getMavLinkThread().setZoomContinuous(d >= 0.1d ? 1.0f : d <= -0.1d ? -1.0f : 0.0f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str.startsWith("uastool.mavlink.")) {
            str.hashCode();
            if (str.equals(MAVLinkPrefHandler.PREF_MAVLINK_JOYSTICK_DECAY)) {
                Log.d("DECAY", "DECAY on change: ");
                try {
                    getMavLinkThread().decay_control = sharedPreferences.getBoolean(MAVLinkPrefHandler.PREF_MAVLINK_JOYSTICK_DECAY, false);
                } catch (Exception unused) {
                }
            } else if (str.equals(MAVLinkPrefHandler.PREF_MAVLINK_JOYSTICK_ENABLE)) {
                JoystickListener joystickListener2 = joystickListener;
                if (joystickListener2 != null) {
                    joystickListener2.dispose();
                }
                if (UASToolDropDownReceiver.getSharedPrefs().getBoolean(MAVLinkPrefHandler.PREF_MAVLINK_JOYSTICK_ENABLE, true)) {
                    joystickListener = new JoystickListener(this);
                }
            }
        }
    }
}
