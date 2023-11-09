package com.atakmap.android.uastool.dji;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.atakmap.android.atakgo.dji.IDjiAtakInterface;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.av;
import com.atakmap.android.uastool.HealthScreen;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.RouteDrawPoint;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.pagers.status.StatusMetaItem;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ThermalData;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.UASHealthWidget;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.QuickTask;
import com.atakmap.android.uastool.tasks.TaskResponse;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCFOVCenterTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCRemoteCancelTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCRemoteTask;
import com.atakmap.android.uastool.tasks.route.OrbitPoint;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.RouteTaskErrorList;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.utils.CameraInfo;
import com.atakmap.android.uastool.utils.KLVQueue;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.util.a;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.math.PointD;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class DJIUASItem extends UASItem implements SharedPreferences.OnSharedPreferenceChangeListener {
    private static final long AIRCRAFT_CACHE_LIFETIME = 750;
    public static final String DETAIL_TAG = "_DJI_";
    public static final String DISPLAY_NAME = "DJI";
    private IAircraftItem cachedAircraft;
    private long cachedAircraftStaleTime;
    private long currentTime;
    private float currentZoomLvl = 1.0f;
    private ArrayList<Pair<Integer, String>> diagnosticsInfo = null;
    private boolean hadFirstFail = false;
    private long lastDiagnosticsUpdate = 0;
    private long lastFailTime = 0;
    protected Float maxFlightAltitude = Float.valueOf(500.0f);
    private Float maxFlightDistance = Float.valueOf(8000.0f);
    private boolean snapToHorizon = false;
    private String thermalUnits = null;

    private void runLTCLCCancelTask(LTCLCRemoteCancelTask lTCLCRemoteCancelTask) {
    }

    private void runLTCLCRemoteTask(LTCLCRemoteTask lTCLCRemoteTask) {
    }

    public String getHealthText() {
        return "I am healthy";
    }

    public String getHealthTitle() {
        return null;
    }

    public KLVQueue getKLVQueue() {
        return null;
    }

    public ArrayList<String> getMoreMenuStrings(boolean z) {
        return null;
    }

    public boolean isAircraftItemCapable() {
        return true;
    }

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public static HashMap<String, String> getDetailAttrs() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("homelat", "String");
        hashMap.put("homelon", "String");
        hashMap.put(UASPoint.COTDETAIL_GIMBALPITCH, "String");
        hashMap.put("gimbalroll", "String");
        hashMap.put("gimbalyaw", "String");
        hashMap.put("spoiuid", "String");
        return hashMap;
    }

    public DJIUASItem(ao aoVar, boolean z) {
        super(aoVar, z, "_DJI_");
        UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
    }

    public DJIUASItem(String str, String str2, boolean z) {
        super("_DJI_", str, str2, DISPLAY_NAME, z);
        UASToolDropDownReceiver.getSharedPrefs().registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        if (str.equals(DJIThermalSettingsLayout.PREF_UNITS)) {
            this.thermalUnits = getThermalUnits();
        }
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_LOOKATPOINT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_TAKEOFF, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_FLIGHTMODE, false);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_GOTOMODE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_FINISHACTION, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_RADIUS, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_COUNT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_CLOCKWISE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ZOOM_CAMERA, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SIGNAL_STRENGTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TIME_IN_FLIGHT, true);
        a.j();
        this.capabilities.put(UASItemCapabilities.CAPABILITY_UNLOCKABLE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SETTINGS, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_CAMERA_SHOT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_VOLTAGE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OBSTACLE_RANGE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ATTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_GROUNDSPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HAL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_OVERLAY_SHOW, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROTATION_MATRIX_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_THERMAL_METERING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_CONTROLLER_PAIRING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_VIDEO_DATARATE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_JOYSTICK_VIRTUAL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEALTH, false);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_STOP, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_RTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_FOLLOW, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_TASK, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_QUICK_TASK, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_PROGRESS, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_NEWROUTE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_EXISTROUTE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_PERIMETER, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ATTITUDE, true);
    }

    /* access modifiers changed from: protected */
    public void setPlatformValues() {
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_SPEED_MIN, "1.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_SPEED_MAX, "15.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, "8.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_MIN, "5.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_MAX, "500.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_DEFAULT, "61.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MIN, "5.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MAX, "500.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_DEFAULT, "10.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MIN, "1.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_MAX, "36.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_DEFAULT, "18.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITSPEED_UNITSTYPE, OrbitPoint.ORBITSPEED_UNITS_ANGULAR);
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MIN, "0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MAX, "1000");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_DEFAULT, "1");
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return (DJISettingsScreen) layoutInflater.inflate(C1877R.layout.dji_settings_layout, (ViewGroup) null);
    }

    public HealthScreen getPlatformHealthScreen(LayoutInflater layoutInflater) {
        return (DJIHealthScreen) layoutInflater.inflate(C1877R.layout.dji_health_layout, (ViewGroup) null);
    }

    public UASHealthWidget.HEALTH getHealth() {
        return UASHealthWidget.HEALTH.GOOD;
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

    private void toast(String str) {
        UASToolDropDownReceiver.toast(str, 0);
    }

    public void updateStatusData() {
        ArrayList<Pair<Integer, String>> arrayList;
        int i;
        super.updateStatusData();
        if (isDefault() && isConnected() && (arrayList = this.diagnosticsInfo) != null && !arrayList.isEmpty()) {
            int i2 = 0;
            boolean z = System.currentTimeMillis() - this.lastDiagnosticsUpdate < ConnectionType.DEFAULT_UDP_PING_PERIOD;
            Iterator<Pair<Integer, String>> it = this.diagnosticsInfo.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                StatusMetaItem existingStatusData = getExistingStatusData(StatusMetaItem.META_TYPE.ERROR, String.valueOf(next.first));
                if (existingStatusData != null) {
                    existingStatusData.setMeta((String) next.second);
                    this.statusDataList.remove(existingStatusData);
                    if (z) {
                        existingStatusData.setColor(-65536);
                        i = i2 + 1;
                        this.statusDataList.add(i2, existingStatusData);
                    } else {
                        existingStatusData.setColor(-1);
                        this.statusDataList.add(existingStatusData);
                    }
                } else {
                    StatusMetaItem statusMetaItem = new StatusMetaItem(StatusMetaItem.META_TYPE.ERROR, String.valueOf(next.first), (String) next.second);
                    if (z) {
                        statusMetaItem.setColor(-65536);
                        i = i2 + 1;
                        this.statusDataList.add(i2, statusMetaItem);
                    } else {
                        statusMetaItem.setColor(-1);
                        this.statusDataList.add(statusMetaItem);
                    }
                }
                i2 = i;
            }
        }
    }

    public int getSignalStrengthImageId(boolean z) {
        if (this.uasMarker != null) {
            int metaInteger = this.uasMarker.getMetaInteger("_radio:rssi", 0);
            if (metaInteger >= 75) {
                return z ? C1877R.drawable.signal_3_shadow : C1877R.drawable.signal_3;
            }
            if (metaInteger >= 50) {
                return z ? C1877R.drawable.signal_2_shadow : C1877R.drawable.signal_2;
            }
            if (metaInteger >= 25) {
                return z ? C1877R.drawable.signal_1_shadow : C1877R.drawable.signal_1;
            }
            if (z) {
                return C1877R.drawable.signal_0_shadow;
            }
        }
        return C1877R.drawable.signal_0;
    }

    public double getFlightTimeMins() {
        return (this.uasMarker != null ? (double) this.uasMarker.getMetaInteger("vehicle:flightTime", 1) : 0.0d) / 60.0d;
    }

    public boolean hasGPS() {
        if (this.uasMarker != null) {
            return this.uasMarker.getMetaBoolean("_radio:gps", false);
        }
        return false;
    }

    public void zoomIn() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.getService().zoomIn();
            }
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
        }
    }

    public void zoomOut() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.getService().zoomOut();
            }
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
        }
    }

    public float getZoomLevel() {
        return this.currentZoomLvl;
    }

    private float getZoomLevelAIDL() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().getZoomLevel();
            }
            return 1.0f;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return 1.0f;
        }
    }

    public boolean getCanZoomCamera() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().getCanZoom();
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public float getZoomMin() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().getZoomMin();
            }
            return 1.0f;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return 1.0f;
        }
    }

    public float getZoomMax() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().getZoomMax();
            }
            return 1.0f;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return 1.0f;
        }
    }

    private static float round(double d, int i) {
        int pow = (int) Math.pow(10.0d, (double) i);
        return ((float) Math.round(d * ((double) pow))) / ((float) pow);
    }

    public void runTask(UASTask uASTask) {
        super.runTask(uASTask);
        if (uASTask != null) {
            int i = C14471.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()];
            if (i == 1) {
                runRouteTask((RouteTask) uASTask);
            } else if (i == 2) {
                runQuickTask((QuickTask) uASTask);
            } else if (i == 3) {
                runLTCLCFOVCenterTask((LTCLCFOVCenterTask) uASTask);
            } else if (i == 4) {
                runLTCLCRemoteTask((LTCLCRemoteTask) uASTask);
            } else if (i != 5) {
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
        UASToolDropDownReceiver.toast("DJI tasking failed: NULL task", 0);
        Log.w(TAG, "DJI tasking failed: NULL task");
    }

    /* renamed from: com.atakmap.android.uastool.dji.DJIUASItem$1 */
    /* synthetic */ class C14471 {
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
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.QUICKFLY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_FOVCENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_REMOTE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_CANCEL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJIUASItem.C14471.<clinit>():void");
        }
    }

    public RouteTaskErrorList validateRouteTask(RouteTask routeTask) {
        RouteTaskErrorList validateRouteTask = super.validateRouteTask(routeTask);
        if (validateRouteTask.errorType == RouteTaskErrorList.ErrorType.ERROR) {
            return validateRouteTask;
        }
        Iterator<UASPoint> it = routeTask.getRoute().getPoints().iterator();
        while (it.hasNext()) {
            UASPoint next = it.next();
            if (next.getHAL() < 0.0f && next.getGotoMode().equals(UASPoint.GOTO_SAFELY)) {
                String format = String.format("Route point %d \"%s\" too low (%s) increase altitude or change go to mode to \"Point to Point\"", new Object[]{Integer.valueOf(next.getIndex()), next.getName(), Utils.formatAlt((double) next.getAGL())});
                Log.e(TAG, format);
                validateRouteTask.add(format, RouteTaskErrorList.ErrorType.WARN);
            }
        }
        return validateRouteTask;
    }

    /* access modifiers changed from: protected */
    public void runRouteTask(RouteTask routeTask) {
        UASRoute route = routeTask.getRoute();
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            try {
                serviceConnection.getService().runRouteTask_aidl(route);
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to run route task: ", e);
            }
        }
    }

    public void pauseTask(UASTask uASTask) {
        AtakGoServiceConnection serviceConnection;
        if (!sendRemoteTask(uASTask, QuickTask.ACTION.PAUSE) && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            try {
                serviceConnection.getService().pauseTask_aidl();
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to task platform to look at point: ", e);
            }
        }
    }

    public void resumeTask(UASTask uASTask) {
        AtakGoServiceConnection serviceConnection;
        if (!sendRemoteTask(uASTask, QuickTask.ACTION.RESUME) && (serviceConnection = DJIMonitor.getServiceConnection()) != null) {
            try {
                serviceConnection.getService().resumeTask_aidl();
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to task platform to look at point: ", e);
            }
        }
    }

    public void stopTask(UASTask uASTask) {
        super.stopTask(uASTask);
        sendRemoteTask(uASTask, QuickTask.ACTION.QUICKSTOP);
        setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            try {
                serviceConnection.getService().stopTask_aidl();
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to task platform to look at point: ", e);
            }
        }
        if (uASTask.getTaskMessageUid() != null) {
            sendTaskResponse(uASTask, TaskResponse.RESPONSETYPE.CANCELLED);
        }
    }

    /* access modifiers changed from: protected */
    public void lookAtPoint(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
        super.lookAtPoint(lTCLCFOVCenterTask);
        runLTCLCFOVCenterTask(lTCLCFOVCenterTask);
    }

    private void runLTCLCFOVCenterTask(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
        IDjiAtakInterface service;
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null && (service = serviceConnection.getService()) != null) {
                GeoPoint point = lTCLCFOVCenterTask.getPoint();
                double latitude = point.getLatitude();
                double longitude = point.getLongitude();
                double altitude = point.getAltitude();
                GeoPoint geoPoint = getGeoPoint();
                service.lookAtPoint(latitude, longitude, altitude, geoPoint.getLatitude(), geoPoint.getLongitude(), geoPoint.getAltitude());
                UASToolDropDownReceiver.toast("Executing Gimbal Control FOV Center task.", 0);
            }
        } catch (Exception e) {
            UASToolDropDownReceiver.toast("Failed to execute Gimbal Control FOV Center task.", 1);
            Log.d(TAG, "Failed to execute LTCLCFOVCenterTask: ", e);
        }
    }

    public float getMaxDistance() {
        return this.maxFlightDistance.floatValue();
    }

    public void setMaxDistance(Float f) {
        this.maxFlightDistance = f;
    }

    public float getMaxAltitude() {
        return this.maxFlightAltitude.floatValue();
    }

    public void setMaxAltitude(Float f) {
        this.maxFlightAltitude = f;
        setPlatformValue(UASItemCapabilities.VALUE_ROUTE_AGL_MAX, String.valueOf(f));
    }

    public void snapGimbal() {
        boolean z = this.snapToHorizon;
        double d = z ? 0.0d : -90.0d;
        this.snapToHorizon = !z;
        pitchGimbal(d);
    }

    public void pitchGimbal(double d) {
        if (hasGimbalPitch()) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                try {
                    serviceConnection.getService().pitchGimbal(d);
                } catch (RemoteException e) {
                    Log.e(TAG, "Failed to task platform to look at point: ", e);
                }
            }
        } else {
            UASToolDropDownReceiver.toast("This DJI UAS does not support gimbal pitch", 0);
        }
    }

    public double getObstacleRangeInches() {
        if (!isConnected()) {
            return 0.0d;
        }
        Double obstacleDistance = AtakGoServiceConnection.getObstacleDistance();
        if (obstacleDistance == null) {
            obstacleDistance = Double.valueOf(0.0d);
        }
        return obstacleDistance.doubleValue();
    }

    public void updateGeoreference(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9;
        boolean z;
        if (Double.isNaN(d8) || d8 == 0.0d) {
            z = false;
            d9 = d3;
        } else {
            z = true;
            d9 = d3 + d8;
        }
        setLocation(new GeoPoint(d, d2, d9));
        setHFOV(d6);
        setVFOV(d7);
        setGimbalPitch(d4);
        setGimbalAngle(d5);
        super.onUasGeoreferenceUpdate(z);
    }

    public void taskSensorToPoint(GeoPoint geoPoint) {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            try {
                serviceConnection.getService().lookAtPoint(geoPoint.getLatitude(), geoPoint.getLongitude(), geoPoint.getAltitude(), getGeoPoint().getLatitude(), getGeoPoint().getLongitude(), getGeoPoint().getAltitude());
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to move sensor: " + e.getLocalizedMessage(), 1);
                Log.e(TAG, "Failed to move sensor: ", e);
            }
        }
    }

    public void updateDiagnosticInfo(ArrayList<Pair<Integer, String>> arrayList) {
        this.lastDiagnosticsUpdate = System.currentTimeMillis();
        this.diagnosticsInfo = arrayList;
    }

    public void unlockPlatform() {
        IDjiAtakInterface service;
        if (!Utils.isSecureAtakVersion()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.atakmap.android.atakgo.dji", "com.atakmap.android.atakgo.main.AtakGoActivator"));
            MapView.getMapView().getContext().startActivity(intent);
            return;
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null && (service = serviceConnection.getService()) != null) {
            try {
                service.setPlatformActivated(true);
                UASToolDropDownReceiver.toast("Activating UAS...", 0);
            } catch (RemoteException unused) {
                UASToolDropDownReceiver.toast("Activate UAS Failed.", 0);
            }
            try {
                service.unlockPlatform();
                UASToolDropDownReceiver.toast("Unlocking UAS...", 0);
            } catch (RemoteException unused2) {
                UASToolDropDownReceiver.toast("Unlock UAS Failed.", 0);
            }
        }
    }

    public void resetGimbalPitchAndYaw() {
        if (!isConnected()) {
            super.resetGimbalPitchAndYaw();
            return;
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        try {
            UASToolDropDownReceiver.toast("resetting gimbal...", 0);
            if (serviceConnection != null) {
                serviceConnection.getService().resetGimbal();
            }
        } catch (RemoteException e) {
            UASToolDropDownReceiver.toast("Failed to reset gimbal: " + e.getLocalizedMessage(), 1);
            Log.e(TAG, "Failed to reset gimbal: ", e);
        }
    }

    public boolean isFlying() {
        if (!isDefault()) {
            return super.isFlying();
        }
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().isFlying();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean areMotorsOn() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().areMotorsOn();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean readyToTakeoff() {
        return !isFlying() && !areMotorsOn();
    }

    public boolean readyToLand() {
        return isFlying();
    }

    public void quickTakeoff(int i) {
        super.quickTakeoff(i);
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.TAKEOFF, (double) i)) {
            cancelAllActiveTasks();
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                try {
                    serviceConnection.getService().quickTakeoff_aidl(i);
                } catch (RemoteException e) {
                    UASToolDropDownReceiver.toast("Failed DJI quick takeoff: " + e.getLocalizedMessage(), 0);
                    Log.e(TAG, "Failed DJI quick takeoff", e);
                }
            }
        }
    }

    public void quickLanding() {
        super.quickLanding();
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.LAND)) {
            cancelAllActiveTasks();
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                try {
                    serviceConnection.getService().quickLanding_aidl();
                } catch (RemoteException e) {
                    UASToolDropDownReceiver.toast("Failed DJI quick landing: " + e.getLocalizedMessage(), 0);
                    Log.e(TAG, "Failed DJI quick landing", e);
                }
            }
        }
    }

    public void quickStop() {
        super.quickStop();
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.STOP)) {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                try {
                    serviceConnection.getService().pauseTask_aidl();
                    UASTaskStore.getInstance().pauseRunningRoutes();
                } catch (RemoteException e) {
                    UASToolDropDownReceiver.toast("Failed DJI quick stop: " + e.getLocalizedMessage(), 0);
                    Log.e(TAG, "Failed DJI quick stop", e);
                }
            }
            UASTask runningRoute = UASTaskStore.getInstance().getRunningRoute(this);
            if (runningRoute != null && runningRoute.getTaskSourceUid() != null) {
                sendTaskResponse(runningRoute, TaskResponse.RESPONSETYPE.CANCELLED);
            }
        }
    }

    public void quickRTH() {
        super.quickRTH();
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.RTH)) {
            cancelAllActiveTasks();
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                try {
                    serviceConnection.getService().quickRTH_aidl();
                } catch (RemoteException e) {
                    UASToolDropDownReceiver.toast("Failed DJI quick return to home: " + e.getLocalizedMessage(), 0);
                    Log.e(TAG, "Failed DJI quick return to home", e);
                }
            }
        }
    }

    public void quickAltitude(int i) {
        super.quickLanding();
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.ALTITUDE, (double) i)) {
            cancelAllActiveTasks();
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                try {
                    serviceConnection.getService().quickAltitude_aidl(i);
                } catch (RemoteException e) {
                    UASToolDropDownReceiver.toast("Failed DJI quick altitude: " + e.getLocalizedMessage(), 0);
                    Log.e(TAG, "Failed DJI quick altitude", e);
                }
            }
        }
    }

    private void cancelAllActiveTasks() {
        setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
        enterLoiterMode();
        UASTask runningRoute = UASTaskStore.getInstance().getRunningRoute(this);
        if (!(runningRoute == null || runningRoute.getTaskSourceUid() == null)) {
            sendTaskResponse(runningRoute, TaskResponse.RESPONSETYPE.CANCELLED);
        }
        UASTaskStore.getInstance().stopRunningRoutes(this);
    }

    private void enterLoiterMode() {
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            try {
                serviceConnection.getService().stopTask_aidl();
            } catch (RemoteException e) {
                Log.e(TAG, "Failed to task platform to stopTask: ", e);
            }
        }
    }

    public IAircraftItem getAircraftItem() {
        long currentTimeMillis = System.currentTimeMillis();
        IAircraftItem iAircraftItem = this.cachedAircraft;
        if (iAircraftItem != null && currentTimeMillis < this.cachedAircraftStaleTime) {
            return iAircraftItem;
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            try {
                IAircraftItem aircraftItem = serviceConnection.getService().getAircraftItem();
                if (aircraftItem == null) {
                    return null;
                }
                aircraftItem.callsign = this.callsign;
                UASToolDropDownReceiver.getInstance();
                Reflector reflector = UASToolDropDownReceiver.getReflector();
                if (reflector == null) {
                    return null;
                }
                PointD customFov = reflector.getCustomFov();
                if (customFov == null || customFov.x <= 0.0d || customFov.y <= 0.0d) {
                    float zoomLevelAIDL = getZoomLevelAIDL();
                    this.currentZoomLvl = zoomLevelAIDL;
                    if (zoomLevelAIDL > 0.0f) {
                        aircraftItem.sensorHFOV /= (double) this.currentZoomLvl;
                        aircraftItem.sensorVFOV /= (double) this.currentZoomLvl;
                    }
                } else {
                    aircraftItem.sensorHFOV = customFov.x;
                    aircraftItem.sensorVFOV = customFov.y;
                }
                Reflector.updateAircraftItemWithDTED(aircraftItem);
                Reflector.updateAircraftItemWithSelfMarker(aircraftItem);
                Reflector.updateAircraftItemFOV(aircraftItem);
                aircraftItem.platformId = DISPLAY_NAME;
                this.cachedAircraft = aircraftItem;
                this.cachedAircraftStaleTime = currentTimeMillis + AIRCRAFT_CACHE_LIFETIME;
                return aircraftItem;
            } catch (Exception e) {
                Log.e(TAG, "Failed to request platform telemetry: ", e);
                long currentTimeMillis2 = System.currentTimeMillis();
                this.currentTime = currentTimeMillis2;
                if (!this.hadFirstFail) {
                    this.hadFirstFail = true;
                    toast("Failed to request platform telemetry");
                } else if (currentTimeMillis2 - this.lastFailTime > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
                    toast("Failed to request platform telemetry");
                }
                this.lastFailTime = this.currentTime;
            }
        }
        return null;
    }

    public List<CameraInfo> getCameraInfo() {
        List<CameraInfo> cameraInfo = super.getCameraInfo();
        cameraInfo.add(new CameraInfo("MavicPro", 6.3d, 4.7d, 12.0d, 26.0d, true));
        cameraInfo.add(new CameraInfo("Mavic2Dual-EO", 6.3d, 4.7d, 12.0d, 24.0d, true));
        cameraInfo.add(new CameraInfo("Mavic2Zoom-FullZoomOut", 6.3d, 4.7d, 12.0d, 24.0d, true));
        cameraInfo.add(new CameraInfo("Mavic2Zoom-FullZoomIn", 6.3d, 4.7d, 12.0d, 48.0d, true));
        return cameraInfo;
    }

    public int getVideoUIButtons() {
        if (isConnected()) {
            return C1877R.layout.video_ui_op_dji_buttonbar;
        }
        return super.getVideoUIButtons();
    }

    public void handleMoreMenu(String str) {
        UASToolDropDownReceiver.toast("Unknown menu item: " + str, 0);
    }

    public String getThermalUnits() {
        return UASToolDropDownReceiver.getSharedPrefs().getString(DJIThermalSettingsLayout.PREF_UNITS, UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getStringArray(C1877R.array.dji_thermal_units)[0]);
    }

    public ThermalData getThermalData() {
        if (this.thermalUnits == null) {
            this.thermalUnits = getThermalUnits();
        }
        AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
        if (serviceConnection != null) {
            return serviceConnection.getThermalData(this.thermalUnits);
        }
        return null;
    }

    public void pairController() {
        UASToolFragment currentFragment = UASToolDropDownReceiver.getInstance().getActivePager().getCurrentFragment();
        currentFragment.setCurrentScreen((DJIRCPairScreen) LayoutInflater.from(UASToolDropDownReceiver.getInstance().getPluginContext()).inflate(C1877R.layout.dji_rc_pair_screen, (ViewGroup) null), this, currentFragment);
    }

    public double getHeading() {
        return super.getHeading();
    }

    public double getPitch() {
        return super.getPitch();
    }

    public double getRoll() {
        return super.getRoll();
    }

    public double getYaw() {
        return super.getYaw();
    }

    public double getHFOV() {
        if (getMarker() != null) {
            double metaDouble = getMarker().getMetaDouble("sensor:fov", -1.0d);
            if (metaDouble >= 0.0d && !Double.isNaN(metaDouble)) {
                float f = this.currentZoomLvl;
                return f > 0.0f ? metaDouble / ((double) f) : metaDouble;
            }
        }
        return 0.0d;
    }

    public double getVFOV() {
        if (getMarker() != null) {
            double metaDouble = getMarker().getMetaDouble("sensor:vfov", -1.0d);
            if (metaDouble >= 0.0d && !Double.isNaN(metaDouble)) {
                float f = this.currentZoomLvl;
                return f > 0.0f ? metaDouble / ((double) f) : metaDouble;
            }
        }
        return 0.0d;
    }

    public float getVideoDataRate() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().getVideoDataRate();
            }
            return 0.0f;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return 0.0f;
        }
    }

    public void setVideoDataRate(float f) {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.getService().setVideoDataRate(f);
            }
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
        }
    }

    public float getMinVideoDataRate() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().getMinVideoDataRate();
            }
            return 0.0f;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return 0.0f;
        }
    }

    public float getMaxVideoDataRate() {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().getMaxVideoDataRate();
            }
            return 0.0f;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return 0.0f;
        }
    }

    public boolean setVirtualStickMode(boolean z) {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                return serviceConnection.getService().setVirtualStickMode(z);
            }
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    public void joystickPosition(float f, float f2, float f3, float f4) {
        try {
            AtakGoServiceConnection serviceConnection = DJIMonitor.getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.getService().joystickPosition(f, f2, f3, f4);
            }
        } catch (RemoteException e) {
            Log.e(TAG, e.toString());
        }
    }
}
