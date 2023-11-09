package com.atakmap.android.uastool.pagers.video_ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.overlays.moasic.GLSurfaceLayer;
import com.atakmap.android.uastool.overlays.moasic.SurfaceLayer;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.observer.ObserverFmvComponent;
import com.atakmap.android.uastool.pagers.operator.OperatorControlFragment;
import com.atakmap.android.uastool.pagers.operator.PreviewTextureView;
import com.atakmap.android.uastool.pagers.status.StatusArrayList;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.uastool.utils.UASItemUtils;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.android.util.ae;
import com.atakmap.coremap.conversions.Angle;
import com.atakmap.coremap.conversions.AngleUtilities;
import com.atakmap.coremap.conversions.CoordinateFormat;
import com.atakmap.coremap.conversions.CoordinateFormatUtilities;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.layer.opengl.GLLayerFactory;
import java.text.DecimalFormat;
import java.util.Locale;

public abstract class VideoUIBase extends RelativeLayout implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String TAG = VideoUIBase.class.getSimpleName();
    public static final DecimalFormat noDecimalFormat = new DecimalFormat("#");
    public ControlFragment controlFragment;
    protected float currentPanX;
    protected float currentPanY;
    protected float currentScale;
    private GestureDetector gestureDetector;
    private final Runnable osdUpdateRunnable = new Runnable() {
        public void run() {
            VideoUIBase.this.updateOSDImpl();
        }
    };
    /* access modifiers changed from: protected */
    public UASToolPager parentPager;
    /* access modifiers changed from: protected */
    public Context pluginContext;
    private ScaleGestureDetector scaleDetector;
    private SharedPreferences sharedPrefs;
    protected float startSpan;
    /* access modifiers changed from: protected */
    public UASItem uasItem;
    protected float uiScale;

    public void broadcastStarted() {
    }

    public void broadcastStopped() {
    }

    public void onAccessoryChange() {
    }

    public void onGimbalControlChanged(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void showAR(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void showHealth(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void showMap(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void showOSD(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void showPip(boolean z) {
    }

    public void stopShowing() {
    }

    /* access modifiers changed from: protected */
    public abstract void updateOSDImpl();

    public final void updateOSD() {
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(this.osdUpdateRunnable);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public VideoUIBase(Context context) {
        super(context);
        this.pluginContext = context;
    }

    public VideoUIBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pluginContext = context;
    }

    public VideoUIBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pluginContext = context;
    }

    private ScaleGestureDetector getNewScaleGestureDetector(Context context) {
        return new ScaleGestureDetector(context, new ScaleGestureListener());
    }

    private class ScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleGestureListener() {
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            VideoUIBase.this.startSpan = scaleGestureDetector.getCurrentSpan();
            return true;
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan();
            VideoUIBase videoUIBase = VideoUIBase.this;
            videoUIBase.setScale((currentSpan - videoUIBase.startSpan) / VideoUIBase.this.startSpan);
            VideoUIBase.this.startSpan = currentSpan;
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            VideoUIBase.this.setScale((scaleGestureDetector.getCurrentSpan() - VideoUIBase.this.startSpan) / VideoUIBase.this.startSpan);
        }
    }

    private GestureDetector getNewGestureDetector(Context context) {
        return new GestureDetector(context, new GestureListener());
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return false;
        }

        private GestureListener() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoUIBase.this.setPan(f, f2);
            return true;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            VideoUIBase.this.resetScale();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            SharedPreferences sharedPrefs2 = UASToolDropDownReceiver.getSharedPrefs();
            this.sharedPrefs = sharedPrefs2;
            sharedPrefs2.registerOnSharedPreferenceChangeListener(this);
            float parseFloat = Float.parseFloat(this.sharedPrefs.getString(UIPreferenceFragment.PREF_UI_SCALE, UIPreferenceFragment.DEFAULT_UI_SCALE));
            this.uiScale = parseFloat;
            this.uiScale = parseFloat / 100.0f;
        }
        this.scaleDetector = getNewScaleGestureDetector(this.pluginContext);
        this.gestureDetector = getNewGestureDetector(this.pluginContext);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UASToolDropDownReceiver.getSharedPrefs().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void init(ControlFragment controlFragment2, UASToolPager uASToolPager, UASItem uASItem) {
        this.controlFragment = controlFragment2;
        this.parentPager = uASToolPager;
        this.uasItem = uASItem;
        this.currentScale = 1.0f;
        this.currentPanX = 0.0f;
        this.currentPanY = 0.0f;
        updateSize();
        if (!isInEditMode()) {
            setUIScale(Float.parseFloat(this.sharedPrefs.getString(UIPreferenceFragment.PREF_UI_SCALE, UIPreferenceFragment.DEFAULT_UI_SCALE)) / 100.0f);
        }
        showOSD(this.sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_OSD_ON, UIPreferenceFragment.DEFAULT_UI_OSD_ON.booleanValue()));
        showAR(this.sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_AR_ON, UIPreferenceFragment.DEFAULT_UI_AR_ON.booleanValue()));
    }

    /* access modifiers changed from: protected */
    public void updateSize() {
        isFullScreen();
    }

    public void toast(String str) {
        UASToolDropDownReceiver.toast(str);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isGimbalControlEnabled()) {
            return false;
        }
        if (motionEvent.getPointerCount() <= 1) {
            return this.gestureDetector.onTouchEvent(motionEvent);
        }
        this.scaleDetector.onTouchEvent(motionEvent);
        return true;
    }

    public boolean isOSDVisible() {
        return this.sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_OSD_ON, UIPreferenceFragment.DEFAULT_UI_OSD_ON.booleanValue());
    }

    public boolean isARVisible() {
        return this.sharedPrefs.getBoolean(UIPreferenceFragment.PREF_UI_AR_ON, UIPreferenceFragment.DEFAULT_UI_AR_ON.booleanValue());
    }

    public void resetScale() {
        this.currentScale = 0.0f;
        this.currentPanX = 0.0f;
        this.currentPanY = 0.0f;
        setScale(1.0f);
        setPan(this.currentPanX, this.currentPanY);
    }

    public void setScale(float f) {
        UASItem uASItem = this.uasItem;
        if (uASItem != null) {
            float f2 = this.currentScale + f;
            this.currentScale = f2;
            if (f2 < 1.0f) {
                this.currentScale = 1.0f;
            }
            if (uASItem.isDefault()) {
                PreviewTextureView previewTexture = UASToolDropDownReceiver.getInstance().getOperatorPager().getPreviewTexture();
                if (previewTexture != null) {
                    previewTexture.setScale(this.currentScale);
                    return;
                }
                return;
            }
            ObserverFmvComponent fMVComponent = UASToolDropDownReceiver.getInstance().getObserverPager().getFMVComponent();
            if (fMVComponent != null) {
                fMVComponent.setScale(this.currentScale);
            }
        }
    }

    public void setPan(float f, float f2) {
        UASItem uASItem = this.uasItem;
        if (uASItem != null) {
            this.currentPanX -= f;
            this.currentPanY += f2;
            if (uASItem.isDefault()) {
                PreviewTextureView previewTexture = UASToolDropDownReceiver.getInstance().getOperatorPager().getPreviewTexture();
                if (previewTexture != null) {
                    previewTexture.setPanOffset((int) this.currentPanX, (int) this.currentPanY);
                    return;
                }
                return;
            }
            ObserverFmvComponent fMVComponent = UASToolDropDownReceiver.getInstance().getObserverPager().getFMVComponent();
            if (fMVComponent != null) {
                fMVComponent.setPanOffset((int) this.currentPanX, (int) this.currentPanY);
            }
        }
    }

    public boolean isBroadcasting() {
        ControlFragment controlFragment2 = this.controlFragment;
        if (controlFragment2 instanceof OperatorControlFragment) {
            return ((OperatorControlFragment) controlFragment2).isBroadcasting();
        }
        return false;
    }

    public void toggleBroadcasting() {
        ControlFragment controlFragment2 = this.controlFragment;
        if (controlFragment2 instanceof OperatorControlFragment) {
            ((OperatorControlFragment) controlFragment2).onBroadcastChanged(!isBroadcasting(), new OperatorControlFragment.StatusChangeCallback() {
                public void onFinished(boolean z) {
                }
            });
        } else {
            toast("Broadcasting only available for Operators");
        }
    }

    public boolean isFullScreen() {
        if (isInEditMode() || UASToolDropDownReceiver.getInstance() == null) {
            return true;
        }
        return UASToolDropDownReceiver.getInstance().isFullscreenVideo();
    }

    public void setUIScale(float f) {
        this.uiScale = f;
        if (isFullScreen()) {
            setScaleX(this.uiScale);
            setScaleY(this.uiScale);
            return;
        }
        setScaleX(1.0f);
        setScaleY(1.0f);
    }

    public float getUIScale() {
        return this.uiScale;
    }

    public void toggleSize() {
        if (isFullScreen()) {
            UASToolDropDownReceiver.getInstance().resizeHalf();
        } else {
            UASToolDropDownReceiver.getInstance().resizeFull(this.parentPager);
        }
    }

    public void panTo() {
        UASToolDropDownReceiver.getInstance().panTo(this.uasItem);
    }

    public boolean isGimbalControlEnabled() {
        UASItem uASItem = this.uasItem;
        if (uASItem != null) {
            return uASItem.isGimbalControlEnabled();
        }
        return false;
    }

    public boolean toggleGimbalControl() {
        UASItem uASItem = this.uasItem;
        if (uASItem != null) {
            boolean z = !uASItem.isGimbalControlEnabled();
            this.controlFragment.onGimbalControlChanged(z);
            return z;
        }
        toast("Unable to toggle gimbal control - UAS is null");
        return false;
    }

    public synchronized void resetGimbal() {
        UASItem uASItem = this.uasItem;
        if (uASItem != null) {
            uASItem.resetGimbal();
        } else {
            toast("Unable to reset gimbal - UAS is null");
        }
    }

    public synchronized void snapGimbal() {
        UASItem uASItem = this.uasItem;
        if (uASItem == null) {
            toast("Unable to snap gimbal - UAS is null");
        } else if (uASItem.isConnected()) {
            this.uasItem.snapGimbal();
        } else {
            toast("Unable to snap gimbal as observer");
        }
    }

    public void zoomPlus() {
        UASItem uASItem = this.uasItem;
        if (uASItem == null) {
            toast("Unable to zoom camera - uas is null");
        } else if (!uASItem.isConnected()) {
            toast("Unable to zoom camera as observer");
        } else if (!this.uasItem.canZoomCamera()) {
        } else {
            if (this.uasItem.getZoomLevel() < this.uasItem.getZoomMax()) {
                this.uasItem.zoomIn();
            } else {
                toast("Camera at max zoom level");
            }
        }
    }

    public void zoomMinus() {
        UASItem uASItem = this.uasItem;
        if (uASItem == null) {
            toast("Unable to zoom camera - uas is null");
        } else if (!uASItem.isConnected()) {
            toast("Unable to zoom camera as observer");
        } else if (!this.uasItem.canZoomCamera()) {
        } else {
            if (this.uasItem.getZoomLevel() > this.uasItem.getZoomMin()) {
                this.uasItem.zoomOut();
            } else {
                toast("Camera at min zoom level");
            }
        }
    }

    public void cameraShot() {
        UASItem uASItem = this.uasItem;
        if (uASItem == null) {
            toast("Unable to camera shot - uas is null");
        } else if (uASItem.isConnected()) {
            UASToolDropDownReceiver.getInstance().camerashotSelected(this.uasItem);
        } else {
            toast("Unable to camera shot as observer");
        }
    }

    public void videoShotOnMapOverlay() {
        FieldOfView computeFov = StatusArrayList.getInstance().getDefaultUasItem().computeFov();
        String str = TAG;
        Log.d(str, "Field of View: " + computeFov);
        if (computeFov == null || !computeFov.isValid()) {
            UASToolDropDownReceiver.toast("could not add layer");
            return;
        }
        GLLayerFactory.a(GLSurfaceLayer.SPI);
        SurfaceLayer surfaceLayer = new SurfaceLayer(UASToolDropDownReceiver.getInstance().getPluginContext(), computeFov, "title", UASToolDropDownReceiver.getInstance().getOperatorPager().getOperatorControlFragment().getPreviewSnapshot(false, false));
        MapView.getMapView().a(MapView.a.c, surfaceLayer);
        surfaceLayer.setVisible(true);
        AtakBroadcast.a().a(new Intent("com.atakmap.android.maps.REFRESH_HIERARCHY"));
    }

    public void mapShot() {
        if (this.uasItem != null) {
            UASToolDropDownReceiver.getInstance().mapshotSelected(this.uasItem, this.controlFragment);
        } else {
            toast("Unable to map shot - uas is null");
        }
    }

    public Bitmap getBitmap() {
        return UASToolDropDownReceiver.loadBitmapFromView(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1472456180:
                if (str.equals(UIPreferenceFragment.PREF_UI_MINI_MAP_ON)) {
                    c = 0;
                    break;
                }
                break;
            case -760153924:
                if (str.equals(UIPreferenceFragment.PREF_UI_OSD_ON)) {
                    c = 1;
                    break;
                }
                break;
            case -740402491:
                if (str.equals(UIPreferenceFragment.PREF_UI_PIP_ON)) {
                    c = 2;
                    break;
                }
                break;
            case -176031825:
                if (str.equals(UIPreferenceFragment.PREF_UI_AR_ON)) {
                    c = 3;
                    break;
                }
                break;
            case -159853492:
                if (str.equals(UIPreferenceFragment.PREF_UI_SCALE)) {
                    c = 4;
                    break;
                }
                break;
            case 468941988:
                if (str.equals(UIPreferenceFragment.PREF_UI_HEALTH_ON)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                showMap(sharedPreferences.getBoolean(str, UIPreferenceFragment.DEFAULT_UI_MINI_MAP_ON.booleanValue()));
                return;
            case 1:
                showOSD(sharedPreferences.getBoolean(str, UIPreferenceFragment.DEFAULT_UI_OSD_ON.booleanValue()));
                return;
            case 2:
                showPip(sharedPreferences.getBoolean(str, UIPreferenceFragment.DEFAULT_UI_PIP_ON.booleanValue()));
                return;
            case 3:
                showAR(sharedPreferences.getBoolean(str, UIPreferenceFragment.DEFAULT_UI_AR_ON.booleanValue()));
                return;
            case 4:
                setUIScale(Float.parseFloat(sharedPreferences.getString(UIPreferenceFragment.PREF_UI_SCALE, UIPreferenceFragment.DEFAULT_UI_SCALE)) / 100.0f);
                return;
            case 5:
                showHealth(sharedPreferences.getBoolean(str, UIPreferenceFragment.DEFAULT_UI_HEALTH_ON.booleanValue()));
                return;
            default:
                return;
        }
    }

    public static String getAircraftCoordsDisplay(UASItem uASItem) {
        CoordinateFormat coordFormat = UASToolDropDownReceiver.getInstance().getCoordFormat();
        GeoPoint geoPoint = uASItem.getGeoPoint();
        return geoPoint != null ? CoordinateFormatUtilities.formatToShortString(geoPoint, coordFormat) : UASToolConstants.DASHES;
    }

    public static String getRaBToAircraftDisplay(UASItem uASItem) {
        return UASItemUtils.getRangeToAircraftDisplay(uASItem) + "  " + UASItemUtils.getBearingToAircraftDisplay(uASItem);
    }

    public static String getSPoICoordsDisplay(UASItem uASItem) {
        CoordinateFormat coordFormat = UASToolDropDownReceiver.getInstance().getCoordFormat();
        GeoPoint sPoIPoint = uASItem.getSPoIPoint();
        return sPoIPoint != null ? CoordinateFormatUtilities.formatToShortString(sPoIPoint, coordFormat) : UASToolConstants.DASHES;
    }

    public static String getSRaBToTargetDisplay(UASItem uASItem) {
        return UASItemUtils.getSlantRangeToTarget(uASItem) + "  " + UASItemUtils.getBearingToAircraftDisplay(uASItem);
    }

    public static String getGimbalPitchDisplay(UASItem uASItem) {
        return AngleUtilities.format(AngleUtilities.wrapDeg(uASItem.getGimbalPitch()), UASToolDropDownReceiver.getInstance().getBearingFormat(), false);
    }

    public static double getGimbalVFOV(UASItem uASItem) {
        return uASItem.getVFOV();
    }

    public static double getGimbalHFOV(UASItem uASItem) {
        return uASItem.getHFOV();
    }

    public static String getHeadingDisplay(UASItem uASItem) {
        Angle bearingFormat = UASToolDropDownReceiver.getInstance().getBearingFormat();
        double heading = uASItem.getHeading();
        if (heading < 0.0d) {
            heading += 360.0d;
        }
        return AngleUtilities.format(AngleUtilities.wrapDeg(heading), bearingFormat, true);
    }

    public static String getBatteryDisplay(UASItem uASItem) {
        return uASItem.getBatteryDisplay();
    }

    public static double getBatteryPercent(UASItem uASItem) {
        return uASItem.getBatteryPercent();
    }

    public static String getAltitudeDisplay(UASItem uASItem) {
        GeoPoint geoPoint = uASItem.getGeoPoint();
        return geoPoint != null ? UASToolDropDownReceiver.formatAltitude(geoPoint) : UASToolConstants.DASHES;
    }

    public static String getSignalStrengthDisplay(UASItem uASItem) {
        return uASItem.getSignalStrength().name();
    }

    public static String getSpeedDisplay(UASItem uASItem) {
        return ae.a().a(uASItem.getSpeed());
    }

    public static String getFlightTimeMinsDisplay(UASItem uASItem) {
        if (!uASItem.supportsTimeInFlight()) {
            return "--- min";
        }
        return noDecimalFormat.format(uASItem.getFlightTimeMins()) + " min";
    }

    public static String getFlightTimeRemainingMinsDisplay(UASItem uASItem) {
        return noDecimalFormat.format((long) (uASItem.getFlightTimeRemainingSeconds() / 60)) + " min";
    }

    public static String getObstacleRangeInchesDisplay(UASItem uASItem) {
        if (!uASItem.supportsObstacleRange()) {
            return "-- in";
        }
        double obstacleRangeInches = uASItem.getObstacleRangeInches();
        return String.format(Locale.US, "%.02f in", new Object[]{Double.valueOf(obstacleRangeInches)});
    }

    public static int getGoHomeBatteryPercent(UASItem uASItem) {
        return uASItem.getGoHomeBatteryPercent();
    }

    public static VideoUIBase getVideoUI(UASItem uASItem) {
        return (VideoUIBase) PluginLayoutInflater.inflate(UASToolDropDownReceiver.getInstance().getPluginContext(), uASItem.getVideoUI(), (ViewGroup) null);
    }
}
