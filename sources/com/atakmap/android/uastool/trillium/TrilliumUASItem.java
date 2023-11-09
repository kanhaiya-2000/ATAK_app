package com.atakmap.android.uastool.trillium;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.TaskResponse;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCFOVCenterTask;
import com.atakmap.android.uastool.utils.Point3D;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.trilliumeng.android.orion.sdk.OrionSdk;

public class TrilliumUASItem extends UASItem {
    public static final String DETAIL_TAG = "_Trillium_";
    public static final String DISPLAY_NAME = "Trillium";
    private static PopupWindow subToolbar;
    private static LinearLayout subToolbarView;
    private OrionMode m_LastGimbalMode;

    public boolean canZoomCamera() {
        return true;
    }

    public float getZoomMin() {
        return 1.0f;
    }

    public boolean isAircraftItemCapable() {
        return true;
    }

    public void resetGimbalPitchAndYaw() {
    }

    /* access modifiers changed from: protected */
    public void setPlatformValues() {
    }

    public enum OrionMode {
        ORION_MODE_DISABLED(0),
        ORION_MODE_FAULT(1),
        ORION_MODE_RATE(16),
        ORION_MODE_GEO_RATE(17),
        ORION_MODE_FFC_AUTO(32),
        ORION_MODE_FFC(32),
        ORION_MODE_FFC_MANUAL(33),
        ORION_MODE_SCENE(48),
        ORION_MODE_TRACK(49),
        ORION_MODE_CALIBRATION(64),
        ORION_MODE_POSITION(80),
        ORION_MODE_POSITION_NO_LIMITS(81),
        ORION_MODE_GEOPOINT(96),
        ORION_MODE_PATH(112),
        ORION_MODE_DOWN(113),
        ORION_MODE_UNKNOWN(255);
        
        int value;

        private OrionMode(int i) {
            this.value = i;
        }
    }

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public TrilliumUASItem(ao aoVar, boolean z) {
        super(aoVar, z, DETAIL_TAG);
    }

    public TrilliumUASItem(String str, String str2, boolean z) {
        super(DETAIL_TAG, str, str2, DISPLAY_NAME, z);
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_GROUNDSPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROTATION_MATRIX_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SETTINGS, true);
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return (TrilliumSettingsScreen) layoutInflater.inflate(C1877R.layout.trillium_settings_layout, (ViewGroup) null);
    }

    public int getVideoUIButtons() {
        if (isConnected()) {
            return C1877R.layout.video_ui_op_trillium_buttonbar;
        }
        return super.getVideoUIButtons();
    }

    public PopupWindow getPlatformSubToolbar(Context context) {
        subToolbarView = (LinearLayout) LayoutInflater.from(context).inflate(C1877R.layout.toolbar_op_trillium_sub, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(context);
        subToolbar = popupWindow;
        popupWindow.setContentView(subToolbarView);
        return subToolbar;
    }

    public void runTask(UASTask uASTask) {
        super.runTask(uASTask);
        if (uASTask != null) {
            int i = C22231.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()];
            if (i == 1) {
                lookAtPoint((LTCLCFOVCenterTask) uASTask);
            } else if (!(i == 2 || i == 3)) {
                if (i == 4 || i == 5) {
                    UASToolDropDownReceiver.toast("Unsupported task type: " + uASTask.getTaskType().name(), 0);
                } else {
                    UASToolDropDownReceiver.toast("Unable to run unknown task type: " + uASTask.getTaskType().name(), 0);
                }
            }
            if (uASTask.getTaskMessageUid() != null) {
                sendTaskResponse(uASTask, TaskResponse.RESPONSETYPE.EXECUTING);
                return;
            }
            return;
        }
        UASToolDropDownReceiver.toast("trillium tasking failed: NULL task", 0);
        Log.w(TAG, "trillium tasking failed: NULL task");
    }

    /* renamed from: com.atakmap.android.uastool.trillium.TrilliumUASItem$1 */
    /* synthetic */ class C22231 {
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
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_FOVCENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_REMOTE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_CANCEL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.ROUTE     // Catch:{ NoSuchFieldError -> 0x0033 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.trillium.TrilliumUASItem.C22231.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void lookAtPoint(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
        super.lookAtPoint(lTCLCFOVCenterTask);
        taskSensorToPoint(lTCLCFOVCenterTask.getPoint());
    }

    public void taskSensorToPoint(GeoPoint geoPoint) {
        if (geoPoint != null && getCurrentGimbalMode() == OrionMode.ORION_MODE_GEOPOINT) {
            try {
                OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
                if (orionSdk != null) {
                    orionSdk.geoPoint(geoPoint.getLatitude(), geoPoint.getLongitude(), geoPoint.getAltitude());
                    UASToolDropDownReceiver.toast("Executing Gimbal Control FOV Center task.", 0);
                    return;
                }
            } catch (Exception e) {
                Log.d(TAG, "Failed to execute LTCLCFOVCenterTask: ", e);
            }
            UASToolDropDownReceiver.toast("Failed to execute Gimbal Control FOV Center task.", 0);
        }
    }

    public void taskSensorByDelta(Point3D point3D) {
        if (point3D != null && getCurrentGimbalMode() != OrionMode.ORION_MODE_GEOPOINT) {
            commandGimbalOffset(point3D.x * -1.0d, point3D.y);
        }
    }

    public void taskSensor(GeoPoint geoPoint, Point3D point3D) {
        if (getCurrentGimbalMode() == OrionMode.ORION_MODE_GEOPOINT) {
            taskSensorToPoint(geoPoint);
        } else {
            taskSensorByDelta(point3D);
        }
    }

    public void zoomIn() {
        try {
            OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
            if (orionSdk != null) {
                float zoom = orionSdk.getZoom();
                float maxZoom = orionSdk.maxZoom();
                float f = zoom * 1.3f;
                if (f <= maxZoom) {
                    maxZoom = f;
                }
                orionSdk.setZoom(maxZoom);
                UASToolDropDownReceiver.toast(String.format("Executing Gimbal Control Zoom IN to %.1f", new Object[]{Float.valueOf(maxZoom)}), 0);
                return;
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to execute Zoom: ", e);
        }
        UASToolDropDownReceiver.toast("Failed to execute Gimbal Control Zoom task.", 0);
    }

    public void zoomOut() {
        try {
            OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
            if (orionSdk != null) {
                float zoom = orionSdk.getZoom() / 1.3f;
                if (zoom < 1.0f) {
                    zoom = 1.0f;
                }
                orionSdk.setZoom(zoom);
                UASToolDropDownReceiver.toast(String.format("Executing Gimbal Control Zoom OUT to %.1f", new Object[]{Float.valueOf(zoom)}), 0);
                return;
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to execute Zoom: ", e);
        }
        UASToolDropDownReceiver.toast("Failed to execute Gimbal Control Zoom task.", 0);
    }

    public float getZoomLevel() {
        try {
            OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
            if (orionSdk != null) {
                return orionSdk.getZoom();
            }
            return 1.0f;
        } catch (Exception e) {
            Log.d(TAG, "Failed to query zoom level: ", e);
            return 1.0f;
        }
    }

    public float getZoomMax() {
        try {
            OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
            if (orionSdk != null) {
                return orionSdk.maxZoom();
            }
            return 1.0f;
        } catch (Exception e) {
            Log.d(TAG, "Failed to query zoom max: ", e);
            return 1.0f;
        }
    }

    public OrionMode getCurrentGimbalMode() {
        try {
            OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
            if (orionSdk != null) {
                for (OrionMode orionMode : OrionMode.values()) {
                    if (orionMode.value == orionSdk.currentMode()) {
                        return orionMode;
                    }
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to get current gimbal mode: ", e);
        }
        return OrionMode.ORION_MODE_UNKNOWN;
    }

    public void commandGimbalOffset(double d, double d2) {
        try {
            OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
            if (orionSdk != null && getCurrentGimbalMode() == OrionMode.ORION_MODE_SCENE) {
                orionSdk.commandGimbal(getCurrentGimbalMode().value, (float) (d * 2.0d), (float) (d2 * 2.0d), true, (float) 0.5d);
            }
        } catch (Exception e) {
            Log.d(TAG, "Failed to get current gimbal mode: ", e);
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

    public IAircraftItem getAircraftItem() {
        OrionSdk orionSdk = TrilliumMonitor.getOrionSdk();
        if (orionSdk == null) {
            return new IAircraftItem();
        }
        com.trilliumeng.android.orion.sdk.IAircraftItem aircraftItem = orionSdk.getAircraftItem();
        try {
            IAircraftItem iAircraftItem = new IAircraftItem();
            iAircraftItem.aclat = aircraftItem.aclat;
            iAircraftItem.aclon = aircraftItem.aclon;
            iAircraftItem.acalt = aircraftItem.acalt;
            iAircraftItem.achal = aircraftItem.achal;
            iAircraftItem.acce = aircraftItem.acce;
            iAircraftItem.acle = aircraftItem.acle;
            iAircraftItem.acheading = aircraftItem.acheading;
            iAircraftItem.spoilat = aircraftItem.spoilat;
            iAircraftItem.spoilon = aircraftItem.spoilon;
            iAircraftItem.spoialt = aircraftItem.spoialt;
            iAircraftItem.spoiBounds = aircraftItem.spoiBounds;
            iAircraftItem.homelat = aircraftItem.homelat;
            iAircraftItem.homelon = aircraftItem.homelon;
            iAircraftItem.homealt = aircraftItem.homealt;
            iAircraftItem.speed = aircraftItem.speed;
            iAircraftItem.slope = aircraftItem.slope;
            iAircraftItem.sensorAzimuth = aircraftItem.sensorAzimuth;
            iAircraftItem.sensorElevation = aircraftItem.sensorElevation;
            iAircraftItem.sensorRange = aircraftItem.sensorRange;
            iAircraftItem.sensorRoll = aircraftItem.sensorRoll;
            iAircraftItem.sensorHFOV = aircraftItem.sensorHFOV;
            iAircraftItem.sensorVFOV = aircraftItem.sensorVFOV;
            iAircraftItem.sensorNorth = aircraftItem.sensorNorth;
            iAircraftItem.battVolt = aircraftItem.battVolt;
            iAircraftItem.climbRate = aircraftItem.climbRate;
            iAircraftItem.attitudePitch = aircraftItem.attitudePitch;
            iAircraftItem.attitudeRoll = aircraftItem.attitudeRoll;
            iAircraftItem.attitudeYaw = aircraftItem.attitudeYaw;
            iAircraftItem.spinPitch = aircraftItem.spinPitch;
            iAircraftItem.spinRoll = aircraftItem.spinRoll;
            iAircraftItem.spinYaw = aircraftItem.spinYaw;
            iAircraftItem.battMax = aircraftItem.battMax;
            iAircraftItem.battRem = aircraftItem.battRem;
            iAircraftItem.signalQuality = aircraftItem.signalQuality;
            iAircraftItem.flightTime = aircraftItem.flightTime;
            iAircraftItem.goHomeBatteryPercent = aircraftItem.goHomeBatteryPercent;
            iAircraftItem.flightTimeRemaining = aircraftItem.flightTimeRemaining;
            iAircraftItem.hasGPS = aircraftItem.hasGPS;
            iAircraftItem.areMotorsOn = aircraftItem.areMotorsOn;
            iAircraftItem.isFlying = aircraftItem.isFlying;
            iAircraftItem.getThermal = aircraftItem.getThermal;
            iAircraftItem.UID = aircraftItem.UID;
            iAircraftItem.callsign = aircraftItem.callsign;
            iAircraftItem.sensorModel = aircraftItem.sensorModel;
            iAircraftItem.platformId = aircraftItem.platformId;
            OrionMode currentGimbalMode = getCurrentGimbalMode();
            if (this.m_LastGimbalMode != currentGimbalMode) {
                UASToolDropDownReceiver.onUasItemStatusChanged();
            }
            this.m_LastGimbalMode = currentGimbalMode;
            UASToolDropDownReceiver.getInstance();
            if (!UASToolDropDownReceiver.getSharedPrefs().getString(TrilliumPrefHandler.PREF_VIDEO_SRC_URI, "").equals(orionSdk.getVideoURI())) {
                UASToolDropDownReceiver.getInstance();
                SharedPreferences.Editor edit = UASToolDropDownReceiver.getSharedPrefs().edit();
                edit.putString(TrilliumPrefHandler.PREF_VIDEO_SRC_URI, orionSdk.getVideoURI());
                edit.apply();
            }
            Log.d(TAG, iAircraftItem.toString());
            iAircraftItem.callsign = getCallsign();
            iAircraftItem.hasGPS = true;
            iAircraftItem.acce = 30.0d;
            iAircraftItem.acle = 30.0d;
            iAircraftItem.platformId = DISPLAY_NAME;
            if (UASToolDropDownReceiver.getSharedPrefs().getString(TrilliumPrefHandler.PREF_CORNERS_SRC, "").equalsIgnoreCase("UASTool")) {
                Reflector.updateAircraftItemFOV(iAircraftItem);
            } else {
                UASToolDropDownReceiver.getInstance().updateAircraftItemCornersFromKlv(getFov(), iAircraftItem, false);
            }
            double d = iAircraftItem.aclat;
            double d2 = d;
            IAircraftItem iAircraftItem2 = iAircraftItem;
            IAircraftItem iAircraftItem3 = iAircraftItem2;
            updateGeoreference(d2, iAircraftItem.aclon, iAircraftItem.acalt, iAircraftItem.sensorElevation, iAircraftItem.sensorAzimuth, iAircraftItem.sensorHFOV, iAircraftItem.sensorVFOV, iAircraftItem2.homealt);
            return iAircraftItem3;
        } catch (Exception e) {
            Log.d(TAG, "Exception ", e);
            return new IAircraftItem();
        }
    }

    public void onPositionUpdate(double d, double d2, double d3, double d4, double d5) {
        ao marker = getMarker();
        GeoPoint geoPoint = new GeoPoint(d, d2, d3);
        if (marker != null) {
            synchronized (getMarker()) {
                marker.a(geoPoint);
                marker.setMetaDouble("track:course", d5);
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

    public String getVideoUrl() {
        if (isConnected()) {
            return UASToolDropDownReceiver.getSharedPrefs().getString(TrilliumPrefHandler.PREF_VIDEO_SRC_URI, (String) null);
        }
        return super.getVideoUrl();
    }
}
