package com.atakmap.android.uastool.evo;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.atakmap.android.maps.ao;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCFOVCenterTask;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoCalculations;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.math.PointD;

public class EvoUASItem extends UASItem {
    public static final String DETAIL_TAG = "_Evo_";
    public static final String DISPLAY_NAME = "Evo";

    public float getZoomMax() {
        return 100.0f;
    }

    public float getZoomMin() {
        return 0.0f;
    }

    public boolean isAircraftItemCapable() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void lookAtPoint(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
    }

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public EvoUASItem(ao aoVar, boolean z) {
        super(aoVar, z, DETAIL_TAG);
    }

    public EvoUASItem(String str, String str2, boolean z) {
        super(DETAIL_TAG, str, str2, DISPLAY_NAME, z);
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ZOOM_CAMERA, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SIGNAL_STRENGTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_VOLTAGE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_GROUNDSPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HAL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROTATION_MATRIX_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ATTITUDE, true);
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return (EvoSettingsScreen) layoutInflater.inflate(C1877R.layout.evo_settings_layout, (ViewGroup) null);
    }

    public int getVideoUIButtons() {
        if (isConnected()) {
            return C1877R.layout.video_ui_op_evo_buttonbar;
        }
        return super.getVideoUIButtons();
    }

    public void taskSensorToPoint(GeoPoint geoPoint) {
        EvoMonitor.pitchYawGimbal(GeoCalculations.inclinationTo(getGeoPoint(), geoPoint), getGeoPoint().bearingTo(geoPoint));
    }

    public void zoomIn() {
        try {
            EvoMonitor.zoomIn();
        } catch (Exception e) {
            Log.e(TAG, "Could not Zoom in", e);
        }
    }

    public void zoomOut() {
        try {
            EvoMonitor.zoomOut();
        } catch (Exception e) {
            Log.e(TAG, "Could not Zoom out", e);
        }
    }

    public void updateStatusData() {
        super.updateStatusData();
    }

    public IAircraftItem getAircraftItem() {
        if (!EvoMonitor.isConnected()) {
            return null;
        }
        IAircraftItem copy = EvoMonitor.aci.copy();
        copy.acce = 30.0d;
        copy.acle = 30.0d;
        copy.acalt = copy.achal;
        copy.platformId = DISPLAY_NAME;
        copy.UID = getUid();
        copy.callsign = getCallsign();
        UASToolDropDownReceiver.getInstance();
        PointD customFov = UASToolDropDownReceiver.getReflector().getCustomFov();
        if (customFov != null && customFov.x > 0.0d && customFov.y > 0.0d) {
            copy.sensorHFOV = customFov.x;
            copy.sensorVFOV = customFov.y;
        }
        Reflector.updateAircraftItemWithZeroZero(copy);
        Reflector.updateAircraftItemWithDTED(copy);
        Reflector.updateAircraftItemFOV(copy);
        GeoPoint geoPoint = new GeoPoint(copy.aclat, copy.aclon, copy.acalt);
        if (this.uasMarker != null) {
            this.uasMarker.a(geoPoint);
        }
        setHFOV(copy.sensorHFOV);
        setVFOV(copy.sensorVFOV);
        setGimbalAngle(copy.sensorAzimuth);
        setGimbalPitch(copy.sensorElevation);
        setGimbalCapabilities(-90.0f, 0.0f, 0.0f, 0.0f);
        super.onUasGeoreferenceUpdate(true);
        return copy;
    }

    public void resetGimbal() {
        EvoMonitor.pitchGimbal(0.0d);
    }
}
