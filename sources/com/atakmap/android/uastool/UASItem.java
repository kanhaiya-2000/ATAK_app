package com.atakmap.android.uastool;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.atakmap.android.cot.CotMapComponent;
import com.atakmap.android.cotdetails.CoTInfoView;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ag;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.al;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.at;
import com.atakmap.android.maps.av;
import com.atakmap.android.maps.o;
import com.atakmap.android.overlay.b;
import com.atakmap.android.uastool.PD100.PD100UASItem;
import com.atakmap.android.uastool.PD100.UasC2Event;
import com.atakmap.android.uastool.dji.DJIUASItem;
import com.atakmap.android.uastool.evo.EvoUASItem;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.generic.GenericUASItem;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.indago.IndagoUASItem;
import com.atakmap.android.uastool.mavlink.MAVLinkUASItem;
import com.atakmap.android.uastool.p000av.AvUASItem;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.activetasks.ActiveTasksFragment;
import com.atakmap.android.uastool.pagers.status.StatusArrayList;
import com.atakmap.android.uastool.pagers.status.StatusMetaItem;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.TaskProgressListener;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ThermalData;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.UASHealthWidget;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.plugin.DroneMarkerDetailHandler;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.prefs.UtilitiesPreferenceFragment;
import com.atakmap.android.uastool.quickbar.Quickbar;
import com.atakmap.android.uastool.r80d.R80dUASItem;
import com.atakmap.android.uastool.tasks.QuickTask;
import com.atakmap.android.uastool.tasks.QuickTaskMarker;
import com.atakmap.android.uastool.tasks.TaskEdit;
import com.atakmap.android.uastool.tasks.TaskMessage;
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
import com.atakmap.android.uastool.tasks.route.WayPoint;
import com.atakmap.android.uastool.trillium.TrilliumUASItem;
import com.atakmap.android.uastool.utils.CameraInfo;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.uastool.utils.Point3D;
import com.atakmap.android.uastool.utils.UASItemUtils;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.android.uastool.utils.UasMapItemIconUtil;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.user.g;
import com.atakmap.android.util.j;
import com.atakmap.commoncommo.CoTSendMethod;
import com.atakmap.coremap.conversions.Angle;
import com.atakmap.coremap.conversions.AngleUtilities;
import com.atakmap.coremap.conversions.CoordinateFormatUtilities;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.assets.Icon;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import indago.serialization.JsonValueConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public abstract class UASItem implements ai.e {
    public static final String ACTIVE_ROUTE_GROUP_APPEND = " Active Route";
    public static final String NO_UID = "NO_UID";
    private static final int[] ROUTE_STYLES = {0, 1, 2};
    /* access modifiers changed from: protected */
    public static final String TAG = "UASItem";
    public static final String[] UAS_TYPES = {UASToolConstants.UAS_FIXED_TYPE, UASToolConstants.UAS_ROTARY_TYPE};
    protected static final ArrayList<String> platformList = new ArrayList<>();
    private static int routeStyleIndex = 0;
    protected boolean CAPABILITY_OBSERVER_AR;
    public final String PLATFORM_DETAIL_TAG;
    protected String callsign;
    protected Hashtable<String, Boolean> capabilities;
    protected ao crosshair;
    protected av.a crosshairChangedListener;
    al.b crosshairDeconflictionListener;
    public String currentLtclcTask;
    public String currentRemoteTask;
    private final FollowEudController followEudController;
    protected FieldOfView fov;
    protected final AtomicBoolean gimbalControlEnabled;
    private final FollowEudController gimbalFollowController;
    private double gimbalPitch;
    private double gimbalRoll;
    private double gimbalYaw;
    protected double horizontalFov;
    protected boolean isConnected;
    protected boolean isDefault;
    public boolean isRouteActive;
    protected boolean isRouteShowing;
    private int joyMsgCnt;
    protected GeoPoint location;
    private float maxPitch;
    private float maxYaw;
    private float minPitch;
    private float minYaw;
    protected String modelName;
    private final TreeMap<String, String> overlayMap;
    protected String platformType;
    protected Hashtable<String, String> platformValues;
    final AtomicBoolean pointChangedBlocked;
    protected QuickTaskMarker quickTaskMarker;
    private final int routeStyle;
    protected av.a spiChangedListener;
    protected List<StatusMetaItem> statusDataList;
    protected StatusMetaItem statusSummaryItem;
    protected ArrayList<TaskProgressListener> taskListeners;
    protected final Set<UasItemUpdateListener> uasItemUpdateListeners;
    protected ao uasMarker;
    protected String uid;
    protected double verticalFov;
    public String waitingForLtclcTaskResponse;

    public enum SIGNAL_STRENGTH {
        GOOD,
        OK,
        BAD
    }

    public interface UasItemUpdateListener {
        void onUasFovUpdate();

        void onUasGeoreferenceUpdate(boolean z);
    }

    public interface validateCallback {
        void onValidate();
    }

    public IAircraftItem getAircraftItem() {
        return null;
    }

    public UASHealthWidget.HEALTH getHealth() {
        return null;
    }

    public String getHealthText() {
        return null;
    }

    public String getHealthTitle() {
        return null;
    }

    public float getMaxAltitude() {
        return 0.0f;
    }

    public float getMaxDistance() {
        return 0.0f;
    }

    public float getMaxVideoDataRate() {
        return 0.0f;
    }

    public float getMinVideoDataRate() {
        return 0.0f;
    }

    public ArrayList<String> getMoreMenuStrings(boolean z) {
        return null;
    }

    public double getObstacleRangeInches() {
        return 0.0d;
    }

    public HealthScreen getPlatformHealthScreen(LayoutInflater layoutInflater) {
        return null;
    }

    public abstract SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater);

    public int getRequiredSdkVersion() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public ArrayList<RouteDrawPoint> getRouteDrawPoints() {
        return null;
    }

    public ThermalData getThermalData() {
        return null;
    }

    public String getType() {
        return UASToolConstants.UAS_ROTARY_TYPE;
    }

    public float getVideoDataRate() {
        return 0.0f;
    }

    public float getZoomLevel() {
        return 1.0f;
    }

    public float getZoomMax() {
        return 1.0f;
    }

    public float getZoomMin() {
        return 1.0f;
    }

    public boolean hasGPS() {
        return true;
    }

    public boolean isAircraftItemCapable() {
        return false;
    }

    public boolean isArmed() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void lookAtPoint(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
    }

    public void pitchGimbalDown() {
    }

    public void pitchGimbalUp() {
    }

    public boolean readyToLand() {
        return false;
    }

    public boolean readyToTakeoff() {
        return false;
    }

    public void sendArm(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
    }

    public void setManualControl(float[] fArr) {
    }

    public void setMaxAltitude(Float f) {
    }

    public void setMaxDistance(Float f) {
    }

    /* access modifiers changed from: protected */
    public void setPlatformValues() {
    }

    public void setVideoDataRate(float f) {
    }

    public void toggleVideo() {
    }

    public void unlockPlatform() {
    }

    public void zoomIn() {
    }

    public void zoomOut() {
    }

    public String getSafeName() {
        return this.platformType;
    }

    public static ArrayList<String> getPlatformList() {
        return platformList;
    }

    public static ArrayList<String> getSupportingPlatforms(String[] strArr, boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = platformList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int i = 0;
            for (String checkCapability : strArr) {
                if (checkCapability((UASItem) null, next, checkCapability).booleanValue()) {
                    i++;
                }
            }
            if (z && i == strArr.length) {
                arrayList.add(next);
            } else if (i > 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static ArrayList<String> getSupportedTaskNames(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] stringArray = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getStringArray(C1877R.array.task_type_caps);
        String[] stringArray2 = UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getStringArray(C1877R.array.task_type_names);
        for (int i = 0; i < stringArray.length; i++) {
            if (checkCapability((UASItem) null, str, stringArray[i]).booleanValue()) {
                arrayList.add(stringArray2[i]);
            }
        }
        return arrayList;
    }

    protected UASItem(String str, String str2, String str3, String str4, boolean z) {
        this.uasMarker = null;
        this.gimbalControlEnabled = new AtomicBoolean(false);
        this.waitingForLtclcTaskResponse = null;
        this.currentLtclcTask = null;
        this.currentRemoteTask = null;
        this.location = null;
        this.fov = new FieldOfView();
        this.verticalFov = 0.0d;
        this.horizontalFov = 0.0d;
        this.gimbalYaw = Double.NaN;
        this.gimbalPitch = Double.NaN;
        this.gimbalRoll = Double.NaN;
        this.CAPABILITY_OBSERVER_AR = true;
        this.overlayMap = new TreeMap<>();
        this.capabilities = new Hashtable<>();
        this.platformValues = new Hashtable<>();
        this.uasItemUpdateListeners = new HashSet();
        this.crosshair = new ao(UUID.randomUUID().toString() + "_MOVE_SPI");
        this.followEudController = new FollowEudController(this);
        this.gimbalFollowController = new FollowEudController(this);
        this.crosshairDeconflictionListener = new al.b() {
            public void onConflict(SortedSet<ai> sortedSet) {
                for (ai uid : sortedSet) {
                    if (uid.getUID().equals(UASItem.this.crosshair.getUID())) {
                        sortedSet.clear();
                        sortedSet.add(UASItem.this.crosshair);
                        return;
                    }
                }
            }
        };
        this.pointChangedBlocked = new AtomicBoolean(false);
        this.crosshairChangedListener = new av.a() {
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onPointChanged(com.atakmap.android.maps.av r14) {
                /*
                    r13 = this;
                    com.atakmap.android.uastool.UASItem r0 = com.atakmap.android.uastool.UASItem.this
                    java.util.concurrent.atomic.AtomicBoolean r0 = r0.pointChangedBlocked
                    boolean r0 = r0.get()
                    if (r0 == 0) goto L_0x000b
                    return
                L_0x000b:
                    com.atakmap.android.uastool.UASItem r0 = com.atakmap.android.uastool.UASItem.this     // Catch:{ Exception -> 0x001b }
                    com.atakmap.android.maps.av r0 = r0.getSpoIMapItem()     // Catch:{ Exception -> 0x001b }
                    com.atakmap.android.uastool.UASItem r1 = com.atakmap.android.uastool.UASItem.this     // Catch:{ Exception -> 0x001b }
                    com.atakmap.android.maps.av$a r1 = r1.spiChangedListener     // Catch:{ Exception -> 0x001b }
                    r0.b(r1)     // Catch:{ Exception -> 0x001b }
                    goto L_0x0022
                L_0x0019:
                    r14 = move-exception
                    goto L_0x0071
                L_0x001b:
                    java.lang.String r0 = com.atakmap.android.uastool.UASItem.TAG     // Catch:{ all -> 0x0019 }
                    java.lang.String r1 = "Could not remove Spoi listener, adding new one anyway"
                    com.atakmap.coremap.log.Log.w(r0, r1)     // Catch:{ all -> 0x0019 }
                L_0x0022:
                    com.atakmap.android.uastool.UASItem r0 = com.atakmap.android.uastool.UASItem.this
                    com.atakmap.android.maps.av r0 = r0.getSpoIMapItem()
                    com.atakmap.android.uastool.UASItem r1 = com.atakmap.android.uastool.UASItem.this
                    com.atakmap.android.maps.av$a r1 = r1.spiChangedListener
                    r0.a(r1)
                    com.atakmap.coremap.maps.coords.GeoPoint r0 = r14.C()
                    double r0 = r0.getLatitude()
                    com.atakmap.coremap.maps.coords.GeoPoint r2 = r14.C()
                    double r2 = r2.getLongitude()
                    r4 = 0
                    double r0 = com.atakmap.map.elevation.ElevationManager.a(r0, r2, r4)
                    boolean r2 = java.lang.Double.isNaN(r0)
                    if (r2 == 0) goto L_0x0052
                    r0 = 0
                    java.lang.String r1 = "Unable to get elevation of target point: Is DTED installed?"
                    com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r1, r0)
                    r0 = 0
                L_0x0052:
                    r10 = r0
                    com.atakmap.coremap.maps.coords.GeoPoint r0 = new com.atakmap.coremap.maps.coords.GeoPoint
                    com.atakmap.coremap.maps.coords.GeoPoint r1 = r14.C()
                    double r6 = r1.getLatitude()
                    com.atakmap.coremap.maps.coords.GeoPoint r14 = r14.C()
                    double r8 = r14.getLongitude()
                    com.atakmap.coremap.maps.coords.GeoPoint$AltitudeReference r12 = com.atakmap.coremap.maps.coords.GeoPoint.AltitudeReference.HAE
                    r5 = r0
                    r5.<init>(r6, r8, r10, r12)
                    com.atakmap.android.uastool.UASItem r14 = com.atakmap.android.uastool.UASItem.this
                    r14.taskSensor(r0, r4)
                    return
                L_0x0071:
                    com.atakmap.android.uastool.UASItem r0 = com.atakmap.android.uastool.UASItem.this
                    com.atakmap.android.maps.av r0 = r0.getSpoIMapItem()
                    com.atakmap.android.uastool.UASItem r1 = com.atakmap.android.uastool.UASItem.this
                    com.atakmap.android.maps.av$a r1 = r1.spiChangedListener
                    r0.a(r1)
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.UASItem.C11678.onPointChanged(com.atakmap.android.maps.av):void");
            }
        };
        this.spiChangedListener = new av.a() {
            public void onPointChanged(av avVar) {
                UASItem.this.pointChangedBlocked.set(true);
                UASItem.this.setCrossHairLocation(((ao) avVar).C());
                UASItem.this.pointChangedBlocked.set(false);
            }
        };
        this.joyMsgCnt = 100;
        this.PLATFORM_DETAIL_TAG = str;
        this.uid = str2;
        this.callsign = str3;
        this.platformType = str4;
        this.isConnected = z;
        this.isDefault = false;
        this.isRouteShowing = false;
        this.isRouteActive = false;
        this.modelName = "";
        int i = routeStyleIndex;
        this.routeStyle = i;
        int i2 = i + 1;
        routeStyleIndex = i2;
        if (i2 >= ROUTE_STYLES.length) {
            routeStyleIndex = 0;
        }
        setCapabilities();
        setPlatformValues();
        setOverlayMap();
        this.fov.invalidate();
        setupCrosshair();
        createStatusData();
        this.taskListeners = new ArrayList<>();
    }

    protected UASItem(ao aoVar, boolean z, String str) {
        this(str, aoVar.getMetaString(UASTask.COTDETAIL_UID, "UNKNOWN_UID"), aoVar.getMetaString(FlightLogger.LOG_CALLSIGN, "UNKNOWN_CALL"), aoVar.getMetaString("vehicle:type", GenericUASItem.DISPLAY_NAME), z);
        setMarker(aoVar);
    }

    public static UASItem buildItem(String str, String str2, String str3, boolean z) {
        if (str3 == null) {
            return null;
        }
        str3.hashCode();
        char c = 65535;
        switch (str3.hashCode()) {
            case -483022146:
                if (str3.equals(AvUASItem.DISPLAY_NAME)) {
                    c = 0;
                    break;
                }
                break;
            case 65709:
                if (str3.equals(PD100UASItem.DISPLAY_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case 67715:
                if (str3.equals(DJIUASItem.DISPLAY_NAME)) {
                    c = 2;
                    break;
                }
                break;
            case 70078:
                if (str3.equals(EvoUASItem.DISPLAY_NAME)) {
                    c = 3;
                    break;
                }
                break;
            case 2498234:
                if (str3.equals(R80dUASItem.DISPLAY_NAME)) {
                    c = 4;
                    break;
                }
                break;
            case 5899185:
                if (str3.equals(IndagoUASItem.DISPLAY_NAME)) {
                    c = 5;
                    break;
                }
                break;
            case 1560992860:
                if (str3.equals(MAVLinkUASItem.DISPLAY_NAME)) {
                    c = 6;
                    break;
                }
                break;
            case 1572507798:
                if (str3.equals(TrilliumUASItem.DISPLAY_NAME)) {
                    c = 7;
                    break;
                }
                break;
            case 1584505271:
                if (str3.equals(GenericUASItem.DISPLAY_NAME)) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new AvUASItem(str, str2, z);
            case 1:
                return new PD100UASItem(str, str2, z);
            case 2:
                return new DJIUASItem(str, str2, z);
            case 3:
                return new EvoUASItem(str, str2, z);
            case 4:
                return new R80dUASItem(str, str2, z);
            case 5:
                return new IndagoUASItem(str, str2, z);
            case 6:
                return new MAVLinkUASItem(str, str2, z);
            case 7:
                return new TrilliumUASItem(str, str2, z);
            case 8:
                return new GenericUASItem(str, str2, z);
            default:
                return null;
        }
    }

    public static UASItem buildItem(ao aoVar, boolean z) {
        String metaString = aoVar.getMetaString("vehicle:typeTag", (String) null);
        String str = TAG;
        Log.d(str, "Building item for " + metaString);
        if (metaString == null) {
            return null;
        }
        metaString.hashCode();
        char c = 65535;
        switch (metaString.hashCode()) {
            case -1512533398:
                if (metaString.equals(AvUASItem.DETAIL_TAG)) {
                    c = 0;
                    break;
                }
                break;
            case -1497752602:
                if (metaString.equals(R80dUASItem.DETAIL_TAG)) {
                    c = 1;
                    break;
                }
                break;
            case -352237448:
                if (metaString.equals(GenericUASItem.DETAIL_TAG)) {
                    c = 2;
                    break;
                }
                break;
            case 89833755:
                if (metaString.equals("_DJI_")) {
                    c = 3;
                    break;
                }
                break;
            case 89907008:
                if (metaString.equals(EvoUASItem.DETAIL_TAG)) {
                    c = 4;
                    break;
                }
                break;
            case 768142753:
                if (metaString.equals(PD100UASItem.DETAIL_TAG)) {
                    c = 5;
                    break;
                }
                break;
            case 1236656354:
                if (metaString.equals(MAVLinkUASItem.DETAIL_TAG)) {
                    c = 6;
                    break;
                }
                break;
            case 1671067510:
                if (metaString.equals(IndagoUASItem.DETAIL_TAG)) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new AvUASItem(aoVar, z);
            case 1:
                return new R80dUASItem(aoVar, z);
            case 2:
                return new GenericUASItem(aoVar, z);
            case 3:
                return new DJIUASItem(aoVar, z);
            case 4:
                return new EvoUASItem(aoVar, z);
            case 5:
                return new PD100UASItem(aoVar, z);
            case 6:
                return new MAVLinkUASItem(aoVar, z);
            case 7:
                return new IndagoUASItem(aoVar, z);
            default:
                return null;
        }
    }

    public List<StatusMetaItem> getStatusDataList() {
        return this.statusDataList;
    }

    private void createStatusData() {
        this.statusDataList = new ArrayList();
        for (StatusMetaItem.META_TYPE meta_type : StatusMetaItem.META_TYPE.values()) {
            if (meta_type.equals(StatusMetaItem.META_TYPE.ALTITUDE)) {
                if (hasCapability(UASItemCapabilities.CAPABILITY_ALTITUDE).booleanValue()) {
                    this.statusDataList.add(new StatusMetaItem(meta_type, ""));
                }
            } else if (meta_type.equals(StatusMetaItem.META_TYPE.HEADING)) {
                if (hasCapability(UASItemCapabilities.CAPABILITY_HEADING).booleanValue()) {
                    this.statusDataList.add(new StatusMetaItem(meta_type, ""));
                }
            } else if (meta_type.equals(StatusMetaItem.META_TYPE.SPEED)) {
                if (hasCapability(UASItemCapabilities.CAPABILITY_SPEED).booleanValue()) {
                    this.statusDataList.add(new StatusMetaItem(meta_type, ""));
                }
            } else if (meta_type.equals(StatusMetaItem.META_TYPE.BATTERY)) {
                if (hasCapability(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL).booleanValue()) {
                    this.statusDataList.add(new StatusMetaItem(meta_type, ""));
                }
            } else if (meta_type.equals(StatusMetaItem.META_TYPE.SIGNAL)) {
                if (hasCapability(UASItemCapabilities.CAPABILITY_SIGNAL_STRENGTH).booleanValue()) {
                    this.statusDataList.add(new StatusMetaItem(meta_type, ""));
                }
            } else if (meta_type.equals(StatusMetaItem.META_TYPE.TEMPERATURE)) {
                if (hasCapability(UASItemCapabilities.CAPABILITY_TEMPERATURE).booleanValue()) {
                    this.statusDataList.add(new StatusMetaItem(meta_type, ""));
                }
            } else if (meta_type.equals(StatusMetaItem.META_TYPE.WIND)) {
                if (hasCapability(UASItemCapabilities.CAPABILITY_WIND_SPEED).booleanValue()) {
                    this.statusDataList.add(new StatusMetaItem(meta_type, ""));
                }
            } else if (meta_type.equals(StatusMetaItem.META_TYPE.PITCH)) {
                if (hasCapability(UASItemCapabilities.CAPABILITY_ATTITUDE).booleanValue()) {
                    this.statusDataList.add(new StatusMetaItem(meta_type, ""));
                }
            } else if (!meta_type.equals(StatusMetaItem.META_TYPE.ERROR)) {
                this.statusDataList.add(new StatusMetaItem(meta_type, ""));
            }
        }
    }

    /* access modifiers changed from: protected */
    public StatusMetaItem getExistingStatusData(StatusMetaItem.META_TYPE meta_type, String str) {
        for (StatusMetaItem next : this.statusDataList) {
            if (next.getType().equals(meta_type) && !TextUtils.isEmpty(str) && next.getLabel().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void updateStatusData() {
        String str;
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            for (StatusMetaItem next : this.statusDataList) {
                switch (C115410.f8373x417c107a[next.getType().ordinal()]) {
                    case 1:
                        next.setMeta(CoordinateFormatUtilities.formatToString(aoVar.C(), UASToolDropDownReceiver.getInstance().getCoordFormat()));
                        break;
                    case 2:
                        next.setMeta(DroneMarkerDetailHandler.format(aoVar, "event:hae"));
                        break;
                    case 3:
                        next.setMeta(DroneMarkerDetailHandler.format(aoVar, "track:course"));
                        break;
                    case 4:
                        next.setMeta(DroneMarkerDetailHandler.format(aoVar, "track:speed"));
                        break;
                    case 5:
                        next.setMeta(DroneMarkerDetailHandler.format(aoVar, "vehicle:battery"));
                        break;
                    case 6:
                        next.setMeta(getSignalStrength().name());
                        break;
                    case 7:
                        next.setMeta(UASItemUtils.getSlantRangeToTarget(this) + " " + UASItemUtils.getBearingToTarget(this));
                        break;
                    case 8:
                        next.setMeta(UASItemUtils.getRangeToAircraftDisplay(this) + " " + UASItemUtils.getBearingToAircraftDisplay(this));
                        break;
                    case 9:
                        next.setMeta(getPlatformType() + " " + getModelName());
                        break;
                    case 10:
                        if (isDefault()) {
                            str = MapView.getMapView().getDeviceCallsign();
                        } else {
                            ao parent = getParent();
                            str = parent != null ? parent.getMetaString("title", (String) null) : "UNKNOWN";
                        }
                        next.setMeta(str);
                        break;
                    case 11:
                        next.setMeta(DroneMarkerDetailHandler.format(aoVar, "environment:windDirection") + " / " + DroneMarkerDetailHandler.format(aoVar, "environment:windSpeed"));
                        break;
                    case 12:
                        next.setMeta(DroneMarkerDetailHandler.format(aoVar, "environment:temperature"));
                        break;
                    case 13:
                        break;
                    case 14:
                        next.setMeta(aoVar.getUID());
                        break;
                    default:
                        String str2 = TAG;
                        Log.d(str2, "Unknown metadata type: " + next.getType());
                        break;
                }
            }
        }
    }

    public String getStatusSummary() {
        StatusMetaItem statusMetaItem = this.statusSummaryItem;
        if (statusMetaItem != null) {
            return statusMetaItem.getSummary();
        }
        if (isDefault()) {
            return getPlatformType() + " " + getModelName();
        }
        ao parent = getParent();
        String metaString = parent != null ? parent.getMetaString("title", (String) null) : "UNKNOWN";
        return metaString + " - " + getPlatformType();
    }

    public StatusMetaItem getStatusSummaryItem() {
        return this.statusSummaryItem;
    }

    public void setStatusSummaryItem(StatusMetaItem statusMetaItem) {
        this.statusSummaryItem = statusMetaItem;
    }

    public boolean isUnlockable() {
        return hasCapability(UASItemCapabilities.CAPABILITY_UNLOCKABLE).booleanValue();
    }

    public boolean hasSettings() {
        return hasCapability(UASItemCapabilities.CAPABILITY_SETTINGS).booleanValue();
    }

    private void setupCrosshair() {
        Icon.Builder builder = new Icon.Builder();
        builder.setImageUri(0, "asset:/icons/outline.png");
        builder.setAnchor(24, 24);
        this.crosshair.a(builder.build());
        this.crosshair.setZOrder(-10000.0d);
        this.crosshair.setTitle("");
        this.crosshair.setVisible(false);
        this.crosshair.setMovable(true);
        this.crosshair.setClickable(true);
        this.crosshair.setMetaString("how", "h-e");
        this.crosshair.setTouchable(true);
        this.crosshair.setEditable(true);
        this.crosshair.setMetaBoolean("removable", true);
        this.crosshair.setMetaBoolean("movable", true);
        this.crosshair.setMetaBoolean("clickable", true);
    }

    public static ag getUASToolGroup() {
        ag d = UASToolDropDownReceiver.getInstance().getMapView().getRootGroup().d("UASTool");
        return d == null ? UASToolDropDownReceiver.getInstance().getMapView().getRootGroup().a("UASTool") : d;
    }

    public void setCrossHairLocation(GeoPoint geoPoint) {
        this.crosshair.a(geoPoint);
    }

    public ao getCrosshair() {
        return this.crosshair;
    }

    public void setCrosshairVisible(boolean z) {
        this.crosshair.setVisible(z);
        try {
            av spoIMapItem = getSpoIMapItem();
            if (spoIMapItem != null) {
                this.crosshair.a(spoIMapItem.C());
            } else {
                this.crosshair.a(getGeoPoint());
            }
        } catch (Exception unused) {
        }
        if (z) {
            getUASToolGroup().d(this.crosshair);
            MapView.getMapView().getMapTouchController().a(this.crosshairDeconflictionListener);
            return;
        }
        getUASToolGroup().g(this.crosshair);
        MapView.getMapView().getMapTouchController().b(this.crosshairDeconflictionListener);
    }

    public void setWayPointVisible(GeoPoint geoPoint, double d, av.a aVar) {
        if (this.quickTaskMarker == null) {
            this.quickTaskMarker = new QuickTaskMarker(this);
        }
        this.quickTaskMarker.setWayPointVisible(geoPoint, d, aVar);
    }

    public void setTempTargetLocation(GeoPoint geoPoint) {
        if (geoPoint == null) {
            UASToolDropDownReceiver.toast("Unable to place target marker", 0);
            return;
        }
        g.a aVar = new g.a(geoPoint);
        aVar.b(UUID.randomUUID().toString() + "_TARGET_SPI");
        aVar.a("shape_marker");
        aVar.a(Color.parseColor("#9ceded"));
        aVar.f(false);
        aVar.d(true);
        aVar.e(false);
        ao a = aVar.a();
        if (a != null) {
            a.setVisible(false);
            a.setEditable(false);
            a.setMovable(false);
            a.setClickable(false);
            a.setTouchable(false);
            a.b(false);
            a.c(false);
            a.setZOrder(-100001.0d);
            a.setMetaLong("autoStaleDuration", HeartBeat.HEARTBEAT_NORMAL_TIMEOUT);
            a.a(UasMapItemIconUtil.buildIcon(C1877R.drawable.crosshair, UasMapItemIconUtil.ICON_SIZE.SMALL, UasMapItemIconUtil.ICON_ANCHOR.MIDDLE_CENTER, Color.parseColor("#9ceded")));
            MapView mapView = MapView.getMapView();
            ag d = mapView.getRootGroup().d("UASTool");
            if (d == null) {
                d = mapView.getRootGroup().a("UASTool");
            }
            d.d(a);
            a.setVisible(true);
        }
    }

    private void setOverlayMap() {
        if (hasCapability(UASItemCapabilities.CAPABILITY_ALTITUDE).booleanValue()) {
            this.overlayMap.put("Altitude", "event:hae");
        }
        if (hasCapability(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL).booleanValue()) {
            this.overlayMap.put("Battery", "vehicle:battery");
        }
        if (hasCapability(UASItemCapabilities.CAPABILITY_HEADING).booleanValue()) {
            this.overlayMap.put("Heading", "track:course");
        }
        if (hasCapability(UASItemCapabilities.CAPABILITY_TEMPERATURE).booleanValue()) {
            this.overlayMap.put("Temperature", "environment:temperature");
        }
        if (hasCapability(UASItemCapabilities.CAPABILITY_WIND_SPEED).booleanValue()) {
            this.overlayMap.put("Wind Speed", "environment:windSpeed");
        }
        if (hasCapability(UASItemCapabilities.CAPABILITY_GROUNDSPEED).booleanValue()) {
            this.overlayMap.put("Ground Speed", "track:speed");
        }
        if (hasCapability(UASItemCapabilities.CAPABILITY_HAL).booleanValue()) {
            this.overlayMap.put("Height Above Launch", "vehicle:hal");
        }
        if (hasCapability(UASItemCapabilities.CAPABILITY_ATTITUDE).booleanValue()) {
            this.overlayMap.put("Pitch", "attitude:pitch");
        }
    }

    public TreeMap<String, String> getOverlayTypes() {
        return this.overlayMap;
    }

    public boolean hasOverlayMetaValue(String str) {
        for (String equals : this.overlayMap.values()) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setPlatformValue(String str, String str2) {
        this.platformValues.put(str, str2);
    }

    public void init() {
        this.minPitch = 0.0f;
        this.maxPitch = 0.0f;
        this.minYaw = 0.0f;
        this.maxYaw = 0.0f;
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.addOnMetadataChangedListener(this);
        }
    }

    public static void showMeta(ai aiVar) {
        HashMap hashMap = new HashMap();
        aiVar.getMetaData(hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = TAG;
            Log.d(str, entry.getKey() + " = " + entry.getValue());
        }
    }

    public static boolean isUASMapItem(ai aiVar) {
        if (aiVar.getType().equals(UASToolConstants.UAS_FIXED_TYPE) || aiVar.getType().equals(UASToolConstants.UAS_ROTARY_TYPE)) {
            return usesExtendedCoT(aiVar);
        }
        return false;
    }

    public static boolean isUASHomeMapItem(ai aiVar) {
        return aiVar.getType().equals(UASToolConstants.UAS_HOME_TYPE);
    }

    private static boolean usesExtendedCoT(ai aiVar) {
        CotDetail cotDetail;
        if (!aiVar.getMetaBoolean("_uastool:extendedCot", false)) {
            Map metaMap = aiVar.getMetaMap("opaque-details");
            if (metaMap == null) {
                return false;
            }
            for (Map.Entry entry : metaMap.entrySet()) {
                if (!((String) entry.getKey()).equals(UasC2Event.UASToolDetail.detailName) || (cotDetail = (CotDetail) entry.getValue()) == null || !cotDetail.getAttribute("extendedCot").equals("true")) {
                }
            }
            return false;
        }
        return true;
    }

    public Boolean hasCapability(String str) {
        Boolean bool = this.capabilities.containsKey(str) ? this.capabilities.get(str) : null;
        if (bool == null) {
            return false;
        }
        return bool;
    }

    private String getCapabilityValue(String str) {
        if (this.platformValues.containsKey(str)) {
            return this.platformValues.get(str);
        }
        return null;
    }

    public static double getCapabilityValueDouble(UASItem uASItem, String str, String str2, double d) {
        if (uASItem == null) {
            uASItem = buildItem(NO_UID, "", str, false);
        }
        if (uASItem.getCapabilityValue(str2) == null) {
            return d;
        }
        return Utils.parseDouble(uASItem.getCapabilityValue(str2), d);
    }

    public static int getCapabilityValueInt(UASItem uASItem, String str, String str2, int i) {
        if (uASItem == null) {
            uASItem = buildItem(NO_UID, "", str, false);
        }
        return Utils.parseInt(uASItem.getCapabilityValue(str2), i);
    }

    public static String getCapabilityValueString(UASItem uASItem, String str, String str2, String str3) {
        if (uASItem == null) {
            uASItem = buildItem(NO_UID, "", str, false);
        }
        String capabilityValue = uASItem.getCapabilityValue(str2);
        return capabilityValue == null ? str3 : capabilityValue;
    }

    public static Boolean checkCapability(UASItem uASItem, String str, String str2) {
        if (uASItem == null) {
            uASItem = buildItem(NO_UID, "", str, false);
        }
        if (uASItem == null) {
            return false;
        }
        return uASItem.hasCapability(str2);
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getCallsign() {
        if (this.isDefault) {
            return this.callsign;
        }
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return aoVar.getMetaString(FlightLogger.LOG_CALLSIGN, "Unknown");
        }
        return "Unknown";
    }

    public void setCallsign(String str) {
        this.callsign = str;
        if (TextUtils.isEmpty(str)) {
            String str2 = "UAS-" + UASToolDropDownReceiver.getInstance().getMapView().getDeviceCallsign();
            this.callsign = str2;
            if (TextUtils.isEmpty(str2)) {
                this.callsign = UASToolConstants.DASHES;
            }
        }
    }

    public String getPlatformType() {
        return this.platformType;
    }

    public void setPlatformType(String str) {
        this.platformType = str;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void setConnected(boolean z) {
        this.isConnected = z;
        if (!z) {
            dispose();
        }
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean z) {
        this.isDefault = z;
    }

    public boolean isRouteShowing() {
        return this.isRouteShowing;
    }

    /* access modifiers changed from: protected */
    public void setRouteShowing(boolean z) {
        this.isRouteShowing = z;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setMarker(ao aoVar) {
        ao aoVar2 = this.uasMarker;
        if (aoVar2 == null || !aoVar2.equals(aoVar)) {
            ao aoVar3 = this.uasMarker;
            if (aoVar3 != null) {
                aoVar3.removeOnMetadataChangedListener(this);
            }
            this.uasMarker = aoVar;
            aoVar.addOnMetadataChangedListener(this);
        }
    }

    public ao getMarker() {
        return this.uasMarker;
    }

    public boolean isStale() {
        ao aoVar = this.uasMarker;
        if (aoVar == null) {
            return true;
        }
        return aoVar.getMetaBoolean("stale", false);
    }

    public ao getParent() {
        String metaString;
        ao b;
        ao aoVar = this.uasMarker;
        if (aoVar == null || (metaString = aoVar.getMetaString("parent_uid", "")) == null || MapView.getMapView() == null || MapView.getMapView().getRootGroup() == null || (b = MapView.getMapView().getRootGroup().b(metaString)) == null) {
            return null;
        }
        return b;
    }

    public int getSignalRssi() {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return aoVar.getMetaInteger("_radio:rssi", -100);
        }
        return -100;
    }

    public int getSignalStrengthImageId(boolean z) {
        int signalRssi = getSignalRssi();
        return signalRssi > -80 ? z ? C1877R.drawable.signal_3_shadow : C1877R.drawable.signal_3 : signalRssi > -85 ? z ? C1877R.drawable.signal_2_shadow : C1877R.drawable.signal_2 : signalRssi > -90 ? z ? C1877R.drawable.signal_1_shadow : C1877R.drawable.signal_1 : z ? C1877R.drawable.signal_0_shadow : C1877R.drawable.signal_0;
    }

    public Drawable getUASIcon() {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return CoTInfoView.a(aoVar, MapView.getMapView());
        }
        return null;
    }

    public int getIconColor() {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return aoVar.getIconColor();
        }
        return -1;
    }

    public double getBatteryPercent() {
        ao aoVar = this.uasMarker;
        if (aoVar == null) {
            return 0.0d;
        }
        return this.uasMarker.getMetaDouble("vehicle:batteryRemainingCapacity", 0.0d) / aoVar.getMetaDouble("vehicle:batteryMaxCapacity", 100.0d);
    }

    public String getBatteryDisplay() {
        String string = UASToolDropDownReceiver.getSharedPrefs().getString(UIPreferenceFragment.PREF_BATTERY_LEVEL_UNITS, UASToolDropDownReceiver.getInstance().getPluginContext().getResources().getStringArray(C1877R.array.battery_level_units)[0]);
        if (hasCapability(UASItemCapabilities.CAPABILITY_BATTERY_VOLTAGE).booleanValue() && string != null && string.equals("Voltage")) {
            return getBatteryVoltText();
        }
        return ((int) (getBatteryPercent() * 100.0d)) + "%";
    }

    public void setBatteryPercent(double d) {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.setMetaDouble("vehicle:batteryMaxCapacity", 100.0d);
            this.uasMarker.getMetaDouble("vehicle:batteryRemainingCapacity", d);
        }
    }

    public String getBatteryVoltText() {
        if (this.uasMarker == null) {
            return "";
        }
        if (!this.platformType.equals(PD100UASItem.DISPLAY_NAME)) {
            return DroneMarkerDetailHandler.format(this.uasMarker, "vehicle:voltage");
        }
        return String.format("%03.1f%%", new Object[]{Double.valueOf((this.uasMarker.getMetaDouble("vehicle:batteryRemainingCapacity", 0.0d) / this.uasMarker.getMetaDouble("vehicle:batteryMaxCapacity", 0.0d)) * 100.0d)});
    }

    public double getSpeed() {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return aoVar.getMetaDouble("track:speed", 0.0d);
        }
        return 0.0d;
    }

    public void setSpeed(double d) {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.setMetaDouble("track:speed", d);
        }
    }

    public double getFlightTimeMins() {
        ao aoVar = this.uasMarker;
        return ((double) (aoVar != null ? aoVar.getMetaInteger("vehicle:flightTime", 1) : 0)) / 60.0d;
    }

    public void setLocation(GeoPoint geoPoint) {
        this.location = geoPoint;
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.a(geoPoint);
        }
    }

    public GeoPoint getGeoPoint() {
        GeoPoint geoPoint;
        if (isConnected() && (geoPoint = this.location) != null) {
            return geoPoint;
        }
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return aoVar.C();
        }
        return null;
    }

    public void setSPoIPoint(GeoPoint geoPoint) {
        this.fov.center.set(geoPoint);
    }

    public GeoPoint getSPoIPoint() {
        FieldOfView fieldOfView = this.fov;
        if (fieldOfView == null || fieldOfView.center == null) {
            return null;
        }
        if (this.fov.center.get() != null) {
            return this.fov.center.get();
        }
        if (this.uasMarker != null) {
            try {
                av a = UASToolDropDownReceiver.getInstance().getMapView().getRootGroup().c("SPIs").a("parent_uid", this.uasMarker.getUID());
                if (a != null) {
                    return a.C();
                }
            } catch (NullPointerException unused) {
            }
        }
        return null;
    }

    public av getSpoIMapItem() {
        if (this.uasMarker == null) {
            return null;
        }
        try {
            return UASToolDropDownReceiver.getInstance().getMapView().getRootGroup().c("SPIs").a("parent_uid", this.uasMarker.getUID());
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public int getRouteStyle() {
        return this.routeStyle;
    }

    public boolean equals(Object obj) {
        if (obj instanceof UASItem) {
            UASItem uASItem = (UASItem) obj;
            return !TextUtils.isEmpty(uASItem.getUid()) && uASItem.getUid().equals(this.uid);
        }
    }

    public boolean isMyMarker(ao aoVar) {
        if (aoVar != null) {
            String metaString = aoVar.getMetaString(UASTask.COTDETAIL_UID, "");
            return !TextUtils.isEmpty(metaString) && metaString.equals(this.uid);
        }
    }

    public String toString() {
        return this.callsign;
    }

    public void showRoute() {
        String str = getCallsign() + ACTIVE_ROUTE_GROUP_APPEND;
        ArrayList<RouteDrawPoint> routeDrawPoints = getRouteDrawPoints();
        if (routeDrawPoints == null || routeDrawPoints.size() <= 0) {
            Log.e(TAG, "No waypoints for " + getCallsign());
            return;
        }
        o d = MapView.getMapView().getRootGroup().d("UAS Routes");
        if (d == null) {
            d = new o("UAS Routes", "uas_routes", true);
            MapView.getMapView().getMapOverlayManager().g(new b(MapView.getMapView(), d, "android.resource://" + UASToolDropDownReceiver.getInstance().getPluginContext().getPackageName() + "/" + C1877R.drawable.uas_route));
        }
        ag d2 = d.d(str);
        if (d2 == null) {
            d2 = d.a(str);
        }
        String[] strArr = new String[routeDrawPoints.size()];
        Iterator<RouteDrawPoint> it = routeDrawPoints.iterator();
        int i = 0;
        while (it.hasNext()) {
            RouteDrawPoint next = it.next();
            try {
                GeoPoint geoPoint = r9;
                GeoPoint geoPoint2 = new GeoPoint(Double.parseDouble(next.getLat()), Double.parseDouble(next.getLon()), Double.parseDouble(next.getHae()));
                String name = next.getName();
                UASPoint fromScratch = WayPoint.fromScratch(this, i, geoPoint, this.platformType);
                if (next.getOrbitRad() != null && !next.getOrbitRad().equals(JsonValueConstants.VERSION)) {
                    fromScratch = OrbitPoint.fromScratch(this, i, geoPoint, this.platformType);
                    ((OrbitPoint) fromScratch).setOrbitRadius(Float.parseFloat(next.getOrbitRad()));
                    j circle = UASRoute.getCircle(geoPoint, (double) Float.parseFloat(next.getOrbitRad()), TaskEdit.viewColor);
                    circle.setTitle(next.getName() + " circle");
                    d2.d(circle);
                }
                fromScratch.a(fromScratch.getIcon(UasMapItemIconUtil.ICON_SIZE.SMALL, TaskEdit.viewColor));
                try {
                    ao asATAKMarker = fromScratch.getAsATAKMarker(true, false);
                    asATAKMarker.setMetaString(FlightLogger.LOG_CALLSIGN, name);
                    asATAKMarker.setTitle(name);
                    asATAKMarker.a(fromScratch.getIcon(UasMapItemIconUtil.ICON_SIZE.SMALL, TaskEdit.viewColor));
                    strArr[i] = asATAKMarker.getUID();
                    i++;
                    d2.d(asATAKMarker);
                } catch (NumberFormatException unused) {
                }
            } catch (NumberFormatException unused2) {
                Log.e(TAG, "error parsing wp: " + next.getLat() + "," + next.getLon() + " " + next.getHae());
            }
        }
        Intent intent = new Intent();
        intent.putExtra("uidArray", strArr);
        intent.putExtra(UASTask.COTDETAIL_COLOR, TaskEdit.viewColor);
        at.a().a(MapView.getMapView().getContext(), intent);
        this.isRouteShowing = true;
    }

    public boolean hasRouteToShow() {
        ArrayList<RouteDrawPoint> routeDrawPoints = getRouteDrawPoints();
        return routeDrawPoints != null && routeDrawPoints.size() > 0;
    }

    public void hideRoute() {
        ag d = MapView.getMapView().getRootGroup().d("UAS Routes");
        if (d != null) {
            ag d2 = d.d(getCallsign() + ACTIVE_ROUTE_GROUP_APPEND);
            if (d2 != null) {
                d.b(d2);
                this.isRouteShowing = false;
            }
        }
    }

    public boolean canZoomCamera() {
        return hasCapability(UASItemCapabilities.CAPABILITY_ZOOM_CAMERA).booleanValue();
    }

    public void setCanZoomCamera(boolean z) {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ZOOM_CAMERA, Boolean.valueOf(z));
    }

    public UASTask getCurrentTask() {
        return UASTaskStore.getInstance().getRunningRoute(this);
    }

    private void toast(String str, int i) {
        UASToolDropDownReceiver.toast(str, i);
    }

    public boolean supportsTaskProgress() {
        return hasCapability(UASItemCapabilities.CAPABILITY_TASK_PROGRESS).booleanValue();
    }

    public void addTaskListener(TaskProgressListener taskProgressListener) {
        if (taskProgressListener != null && !this.taskListeners.contains(taskProgressListener)) {
            this.taskListeners.add(taskProgressListener);
        }
    }

    public void removeTaskListener(TaskProgressListener taskProgressListener) {
        if (taskProgressListener != null) {
            this.taskListeners.remove(taskProgressListener);
        }
    }

    public void removeAllTaskListeners() {
        this.taskListeners.clear();
    }

    public void preparedTaskProgress(int i, String str) {
        Iterator<TaskProgressListener> it = this.taskListeners.iterator();
        while (it.hasNext()) {
            TaskProgressListener next = it.next();
            if (next != null) {
                next.taskPrepared(i, str);
            } else {
                toast("Null listener in UASItem.prepareTaskProgress()", 0);
            }
        }
    }

    public void startedTaskProgress(String str) {
        Iterator<TaskProgressListener> it = this.taskListeners.iterator();
        while (it.hasNext()) {
            TaskProgressListener next = it.next();
            if (next != null) {
                next.taskStarted(str);
            } else {
                toast("Null listener in UASItem.startedTaskProgress()", 0);
            }
        }
    }

    public void refusedTaskProgress(String str) {
        Iterator<TaskProgressListener> it = this.taskListeners.iterator();
        while (it.hasNext()) {
            TaskProgressListener next = it.next();
            if (next != null) {
                next.taskRefused(str);
            } else {
                toast("Null listener in UASItem.refusedTask()", 0);
            }
        }
        if (getCurrentTask() != null) {
            toast("Task refused - " + str, 1);
            stopTask(getCurrentTask());
            return;
        }
        toast("Task refused, but no task running", 1);
    }

    public void startTaskStageProgress(int i, String str, String str2) {
        Iterator<TaskProgressListener> it = this.taskListeners.iterator();
        while (it.hasNext()) {
            TaskProgressListener next = it.next();
            if (next != null) {
                next.taskStageStarted(i, str);
                if (!TextUtils.isEmpty(str2)) {
                    toast("Task stage " + i + " started with error: " + str2, 0);
                }
            } else {
                toast("Null listener in UASItem.startTaskStageProgress()", 0);
            }
        }
    }

    public void updateTaskStageProgress(int i, int i2, String str, String str2) {
        Iterator<TaskProgressListener> it = this.taskListeners.iterator();
        while (it.hasNext()) {
            TaskProgressListener next = it.next();
            if (next != null) {
                next.taskStageUpdate(i, i2, str);
                if (!TextUtils.isEmpty(str2)) {
                    toast("Task stage " + i + " update with error: " + str2, 0);
                }
            } else {
                toast("Null listener in UASItem.updateTaskStageProgress()", 0);
            }
        }
    }

    public void completedTaskStageProgress(int i, String str, String str2) {
        Iterator<TaskProgressListener> it = this.taskListeners.iterator();
        while (it.hasNext()) {
            TaskProgressListener next = it.next();
            if (next != null) {
                next.taskStageCompleted(i, str);
                if (!TextUtils.isEmpty(str2)) {
                    toast("Task stage " + i + " completed with error: " + str2, 0);
                }
            } else {
                toast("Null listener in UASItem.completedTaskStageProgress()", 0);
            }
        }
    }

    public void finishedTaskProgress(String str, String str2) {
        Iterator<TaskProgressListener> it = this.taskListeners.iterator();
        while (it.hasNext()) {
            TaskProgressListener next = it.next();
            if (next != null) {
                next.taskFinished(str);
            }
        }
        if (getCurrentTask() != null) {
            if (!TextUtils.isEmpty(str2)) {
                toast("Task finished with error: " + str2, 0);
            } else if (getFollowEudController() != null && getFollowEudController().getFollowing() == null) {
                toast(str, 0);
            }
            stopTask(getCurrentTask());
        }
    }

    public void runTask(UASTask uASTask) {
        if (uASTask != null) {
            int i = C115410.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()];
        }
    }

    public void pauseTask(UASTask uASTask) {
        UASToolDropDownReceiver.toast("Pause task is not yet implemented for this UAS type: " + this.platformType, 1);
    }

    public void resumeTask(UASTask uASTask) {
        UASToolDropDownReceiver.toast("Resume task is not yet implemented for this UAS type: " + this.platformType, 1);
    }

    public void stopTask(UASTask uASTask) {
        uASTask.setState(UASTask.STATE.STORED);
    }

    public void sendTask(UASTask uASTask) {
        sendTaskMessage(uASTask);
    }

    public String sendTaskMode(UASTask uASTask) {
        return sendTaskMessage(uASTask);
    }

    private String sendTaskMessage(UASTask uASTask) {
        ao parent = getParent();
        if (parent != null) {
            TaskMessage taskMessage = new TaskMessage(this, uASTask);
            String[] strArr = {parent.getUID()};
            Bundle bundle = new Bundle();
            bundle.putStringArray("toUIDs", strArr);
            CotMapComponent.h().a(taskMessage, bundle, CoTSendMethod.ANY);
            String str = TAG;
            Log.d(str, "Sent task message: " + uASTask.getName());
            UASToolDropDownReceiver.toast("Sent task message: " + uASTask.getName(), 0);
            return taskMessage.getUID();
        }
        UASToolDropDownReceiver.toast("Unable to send task message - NULL parent", 0);
        return null;
    }

    public void sendTaskResponse(UASTask uASTask, TaskResponse.RESPONSETYPE responsetype) {
        if (uASTask.getTaskMessageUid() != null && uASTask.getTaskSourceUid() != null) {
            TaskResponse taskResponse = new TaskResponse(this, uASTask, responsetype);
            String[] strArr = {uASTask.getTaskSourceUid()};
            Bundle bundle = new Bundle();
            bundle.putStringArray("toUIDs", strArr);
            CotMapComponent.h().a(taskResponse, bundle, CoTSendMethod.ANY);
            String str = TAG;
            Log.d(str, "Sent task response: " + responsetype.name());
            UASToolDropDownReceiver.toast("Sent task response: " + responsetype.name(), 0);
        }
    }

    public static boolean getLtclcModeTask(String str) {
        String taskSourceUid;
        UASTask ltCLCTask = UASTaskStore.getInstance().getLtCLCTask();
        if (ltCLCTask == null || !ltCLCTask.getTaskType().equals(UASTask.TASKTYPE.LTCLC_REMOTE) || (taskSourceUid = ltCLCTask.getTaskSourceUid()) == null || !taskSourceUid.equals(str)) {
            return false;
        }
        return true;
    }

    public void handleLtclcTask(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
        if (lTCLCFOVCenterTask.getTaskType() == UASTask.TASKTYPE.LTCLC_FOVCENTER) {
            lookAtPoint(lTCLCFOVCenterTask);
            return;
        }
        UASToolDropDownReceiver.toast("Unable to handle Gimbal Control task " + lTCLCFOVCenterTask.getName() + " from " + lTCLCFOVCenterTask.getUser() + " - unknown task type: " + lTCLCFOVCenterTask.getTaskType().name(), 1);
    }

    public void handleQuickTask(QuickTask quickTask) {
        if (quickTask.getTaskType() == UASTask.TASKTYPE.QUICKFLY) {
            runQuickTask(quickTask);
            return;
        }
        UASToolDropDownReceiver.toast("Unable to handle UAS Control task " + quickTask.getName() + " from " + quickTask.getUser() + " - unknown task type: " + quickTask.getTaskType().name(), 1);
    }

    public void runQuickTask(QuickTask quickTask) {
        if (!hasCapability(UASItemCapabilities.CAPABILITY_REMOTE_QUICK_TASK).booleanValue()) {
            UASToolDropDownReceiver.toast("Quick task not implemented", 0);
            return;
        }
        UASTask runningRoute = UASTaskStore.getInstance().getRunningRoute();
        switch (C115410.$SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION[quickTask.action.ordinal()]) {
            case 1:
                quickOrbit(quickTask);
                return;
            case 2:
                quickFlyTo(quickTask);
                return;
            case 3:
                quickTakeoff((int) quickTask.getAltitudeAgl());
                return;
            case 4:
                quickLanding();
                return;
            case 5:
                quickRTH();
                return;
            case 6:
                stopTask(runningRoute);
                return;
            case 7:
                pauseTask(runningRoute);
                return;
            case 8:
                resumeTask(runningRoute);
                return;
            case 9:
                quickAltitude((int) quickTask.getAltitudeAgl());
                return;
            case 10:
                quickStop();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo7557a(ai aiVar, String str) {
        if ((aiVar instanceof ao) && str.equals("waypoints")) {
            try {
                if (this.isRouteShowing) {
                    hideRoute();
                    showRoute();
                }
            } catch (Exception e) {
                Log.e(TAG, "Exception encountered", e);
            }
        }
    }

    public boolean hasGimbalPitch() {
        return (this.minPitch == 0.0f || this.maxPitch == 0.0f) ? false : true;
    }

    public void snapGimbal() {
        if (!hasGimbalPitch()) {
            UASToolDropDownReceiver.toast("This UAS does not support gimbal snap", 0);
        }
    }

    public void pitchGimbal(double d) {
        if (!hasGimbalPitch()) {
            UASToolDropDownReceiver.toast("This UAS does not support gimbal pitch", 0);
        }
    }

    public boolean hasGimbalYaw() {
        return (this.minYaw == 0.0f || this.maxYaw == 0.0f) ? false : true;
    }

    public int getFlightTimeRemainingSeconds() {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return aoVar.getMetaInteger("vehicle:flightTimeRemaining", -1);
        }
        return -1;
    }

    public int getGoHomeBatteryPercent() {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return aoVar.getMetaInteger("vehicle:goHomeBatteryPercent", -1);
        }
        return -1;
    }

    public String getVideoUrl() {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            return aoVar.getMetaString("videoUrl", (String) null);
        }
        return null;
    }

    public boolean isBroadcastingVideo() {
        if (isDefault()) {
            UASToolDropDownReceiver.getInstance();
            if (UASToolDropDownReceiver.getReflector() != null) {
                return UASToolDropDownReceiver.getReflector().isBroadcasting();
            }
        }
        return !TextUtils.isEmpty(getVideoUrl());
    }

    public double getGimbalAngle() {
        if (!Double.isNaN(this.gimbalYaw)) {
            return this.gimbalYaw;
        }
        if (getMarker() == null) {
            return -1.0d;
        }
        double metaDouble = getMarker().getMetaDouble("sensor:azimuth", -1.0d);
        if (Double.isNaN(metaDouble)) {
            return -1.0d;
        }
        return metaDouble;
    }

    public void setGimbalAngle(double d) {
        this.gimbalYaw = d;
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.setMetaDouble("sensor:azimuth", d);
        }
    }

    public double getGimbalPitch() {
        if (!Double.isNaN(this.gimbalPitch)) {
            return this.gimbalPitch;
        }
        if (getMarker() == null) {
            return 0.0d;
        }
        double metaDouble = getMarker().getMetaDouble("sensor:elevation", 0.0d);
        if (Double.isNaN(metaDouble)) {
            return 0.0d;
        }
        return metaDouble;
    }

    public void setGimbalPitch(double d) {
        this.gimbalPitch = d;
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.setMetaDouble("sensor:elevation", d);
        }
    }

    public double getGimbalRoll() {
        if (!Double.isNaN(this.gimbalRoll)) {
            return this.gimbalRoll;
        }
        if (getMarker() == null) {
            return 0.0d;
        }
        double metaDouble = getMarker().getMetaDouble("sensor:roll", 0.0d);
        if (Double.isNaN(metaDouble)) {
            return 0.0d;
        }
        return metaDouble;
    }

    public void setGimbalRoll(double d) {
        this.gimbalRoll = d;
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.setMetaDouble("sensor:roll", d);
        }
    }

    public void copy(UASItem uASItem) {
        setCanZoomCamera(uASItem.canZoomCamera());
        setMaxDistance(Float.valueOf(uASItem.getMaxDistance()));
        setMaxAltitude(Float.valueOf(uASItem.getMaxAltitude()));
        setUid(uASItem.getUid());
        if (uASItem.getCallsign().equals(((UASItem) StatusArrayList.getInstance().get(0)).callsign)) {
            setCallsign(uASItem.getCallsign());
        }
        setModelName(uASItem.getModelName());
        setPlatformType(uASItem.getPlatformType());
        setGimbalCapabilities(uASItem.minPitch, uASItem.maxPitch, uASItem.minYaw, uASItem.maxYaw);
        this.platformValues = uASItem.platformValues;
        this.capabilities = uASItem.capabilities;
    }

    public void resetGimbal() {
        UASToolDropDownReceiver.getInstance().getOperatorArOverlay().resetGimbal();
    }

    public void setGimbalCapabilities(float f, float f2, float f3, float f4) {
        this.minPitch = f;
        this.maxPitch = f2;
        this.minYaw = f3;
        this.maxYaw = f4;
    }

    public double getHFOV() {
        if (isConnected() && !Double.isNaN(this.horizontalFov)) {
            return this.horizontalFov;
        }
        if (this.horizontalFov == 0.0d && getMarker() != null) {
            double metaDouble = getMarker().getMetaDouble("sensor:fov", -1.0d);
            if (metaDouble < 0.0d || Double.isNaN(metaDouble)) {
                return 0.0d;
            }
            return metaDouble;
        }
        return 0.0d;
    }

    public void setHFOV(double d) {
        this.horizontalFov = d;
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.setMetaDouble("sensor:fov", d);
        }
    }

    public double getVFOV() {
        if (isConnected() && !Double.isNaN(this.verticalFov)) {
            return this.verticalFov;
        }
        if (this.verticalFov == 0.0d && getMarker() != null) {
            double metaDouble = getMarker().getMetaDouble("sensor:vfov", -1.0d);
            if (metaDouble < 0.0d || Double.isNaN(metaDouble)) {
                return 0.0d;
            }
            return metaDouble;
        }
        return 0.0d;
    }

    public void setVFOV(double d) {
        this.verticalFov = d;
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.setMetaDouble("sensor:vfov", d);
        }
    }

    public SIGNAL_STRENGTH getSignalStrength() {
        int signalRssi = getSignalRssi();
        if (signalRssi > -60) {
            return SIGNAL_STRENGTH.GOOD;
        }
        if (signalRssi > -80) {
            return SIGNAL_STRENGTH.OK;
        }
        return SIGNAL_STRENGTH.BAD;
    }

    public void setSignalStrength(int i) {
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.setMetaInteger("_radio:rssi", i);
        }
    }

    public boolean supportsCameraShot() {
        return hasCapability(UASItemCapabilities.CAPABILITY_CAMERA_SHOT).booleanValue();
    }

    public boolean supportsBatteryLevel() {
        return hasCapability(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL).booleanValue();
    }

    public boolean supportsSignalStrength() {
        return hasCapability(UASItemCapabilities.CAPABILITY_SIGNAL_STRENGTH).booleanValue();
    }

    public boolean supportsGimbalControl() {
        if (isConnected()) {
            return hasCapability(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC).booleanValue();
        }
        return hasCapability(UASItemCapabilities.CAPABILITY_REMOTE_LTCLC).booleanValue();
    }

    public boolean supportsAR() {
        if (isConnected()) {
            return hasCapability(UASItemCapabilities.CAPABILITY_OPERATOR_AR).booleanValue();
        }
        return this.CAPABILITY_OBSERVER_AR;
    }

    public boolean supportsTimeInFlight() {
        return hasCapability(UASItemCapabilities.CAPABILITY_TIME_IN_FLIGHT).booleanValue();
    }

    public boolean supportsObstacleRange() {
        return hasCapability(UASItemCapabilities.CAPABILITY_OBSTACLE_RANGE).booleanValue();
    }

    public boolean supportsAltitude() {
        return hasCapability(UASItemCapabilities.CAPABILITY_ALTITUDE).booleanValue();
    }

    public boolean supportsAttitude() {
        return hasCapability(UASItemCapabilities.CAPABILITY_ATTITUDE).booleanValue();
    }

    public boolean supportsUASHeading() {
        return hasCapability(UASItemCapabilities.CAPABILITY_HEADING).booleanValue();
    }

    public boolean supportsSpeed() {
        return hasCapability(UASItemCapabilities.CAPABILITY_SPEED).booleanValue();
    }

    public boolean supportsThermalMetering() {
        return hasCapability(UASItemCapabilities.CAPABILITY_THERMAL_METERING).booleanValue();
    }

    public static boolean supportsControllerPairing() {
        String defaultPlatform = UASToolDropDownReceiver.getDefaultPlatform();
        UASItem buildItem = !TextUtils.isEmpty(defaultPlatform) ? buildItem(NO_UID, UASToolDropDownReceiver.getUASCallsign(), defaultPlatform, false) : null;
        if (buildItem != null) {
            return buildItem.hasCapability(UASItemCapabilities.CAPABILITY_CONTROLLER_PAIRING).booleanValue();
        }
        return false;
    }

    public void pairController() {
        UASToolDropDownReceiver.toast("Controller pairing not supported");
    }

    public boolean supportsVideoDataRate() {
        return hasCapability(UASItemCapabilities.CAPABILITY_VIDEO_DATARATE).booleanValue();
    }

    public boolean supportsVirtualJoystick() {
        return hasCapability(UASItemCapabilities.CAPABILITY_JOYSTICK_VIRTUAL).booleanValue();
    }

    public boolean supportsHealth() {
        return hasCapability(UASItemCapabilities.CAPABILITY_HEALTH).booleanValue();
    }

    /* access modifiers changed from: protected */
    public void onUasGeoreferenceUpdate(boolean z) {
        for (UasItemUpdateListener onUasGeoreferenceUpdate : this.uasItemUpdateListeners) {
            onUasGeoreferenceUpdate.onUasGeoreferenceUpdate(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onUasFovUpdate() {
        for (UasItemUpdateListener onUasFovUpdate : this.uasItemUpdateListeners) {
            onUasFovUpdate.onUasFovUpdate();
        }
    }

    public void addUasItemUpdateListener(UasItemUpdateListener uasItemUpdateListener) {
        this.uasItemUpdateListeners.add(uasItemUpdateListener);
    }

    public void removeUasItemUpdateListener(UasItemUpdateListener uasItemUpdateListener) {
        this.uasItemUpdateListeners.remove(uasItemUpdateListener);
    }

    public void updateFOV(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        GeoPoint sPoIPoint = getSPoIPoint();
        if (sPoIPoint == null) {
            sPoIPoint = getGeoPoint();
        }
        double altitude = sPoIPoint != null ? sPoIPoint.getAltitude() : 0.0d;
        ElevationManager.b bVar = new ElevationManager.b();
        bVar.e = 1;
        bVar.g = true;
        double a = ElevationManager.a(d, d2, bVar);
        GeoPoint geoPoint = new GeoPoint(d, d2, !Double.isNaN(a) ? a : altitude);
        double a2 = ElevationManager.a(d3, d4, bVar);
        GeoPoint geoPoint2 = new GeoPoint(d3, d4, !Double.isNaN(a2) ? a2 : altitude);
        double a3 = ElevationManager.a(d5, d6, bVar);
        if (Double.isNaN(a3)) {
            a3 = altitude;
        }
        GeoPoint geoPoint3 = new GeoPoint(d5, d6, a3);
        double a4 = ElevationManager.a(d7, d8, bVar);
        if (!Double.isNaN(a4)) {
            altitude = a4;
        }
        GeoPoint geoPoint4 = new GeoPoint(d7, d8, altitude);
        FieldOfView fieldOfView = new FieldOfView();
        this.fov = fieldOfView;
        fieldOfView.f8422tl = FieldOfView.geoPointToPointD(geoPoint);
        this.fov.f8423tr = FieldOfView.geoPointToPointD(geoPoint2);
        this.fov.f8421br = FieldOfView.geoPointToPointD(geoPoint3);
        this.fov.f8420bl = FieldOfView.geoPointToPointD(geoPoint4);
        this.fov.lastUpdateTime = System.currentTimeMillis();
        onUasFovUpdate();
    }

    public FieldOfView getFov() {
        return this.fov;
    }

    public FieldOfView computeFov() {
        return FieldOfView.computeFov(getGeoPoint(), getGimbalPitch(), getGimbalAngle(), getVFOV(), getHFOV(), true);
    }

    public void taskSensorToPoint(GeoPoint geoPoint) {
        UASToolDropDownReceiver.toast("Unable to task sensor - platform does not support Gimbal Control", 0);
        Log.w(TAG, "Unable to task sensor - platform does not support Gimbal Control");
    }

    public void taskSensorByDelta(Point3D point3D) {
        UASToolDropDownReceiver.toast("Unable to task sensor - platform does not support Gimbal Control by FOV", 0);
        Log.w(TAG, "Unable to task sensor - platform does not support Gimbal Control by FOV");
    }

    public void taskSensor(GeoPoint geoPoint, Point3D point3D) {
        if (!this.isConnected) {
            String str = TAG;
            Log.d(str, "Gimbal Control got geopoint from click: " + geoPoint.toStringRepresentation());
            sendLtclcLookAtPoint(geoPoint);
        } else if (geoPoint != null) {
            taskSensorToPoint(geoPoint);
        } else if (point3D != null) {
            taskSensorByDelta(point3D);
        } else {
            UASToolDropDownReceiver.toast("Unable to task sensor - no valid target", 0);
        }
    }

    public void resetGimbalPitchAndYaw() {
        if (isConnected()) {
            UASToolDropDownReceiver.toast("Unable to reset gimbal", 0);
            Log.w(TAG, "Unable to reset gimbal");
        }
    }

    public boolean isFlying() {
        ao marker = getMarker();
        if (marker != null) {
            return marker.getMetaBoolean("vehicle:isFlying", false);
        }
        return false;
    }

    public boolean sendRemoteFlyTo(GeoPoint geoPoint, double d) {
        if (isDefault() || !hasCapability(UASItemCapabilities.CAPABILITY_REMOTE_QUICK_TASK).booleanValue()) {
            return false;
        }
        String makeMessageUid = TaskMessage.makeMessageUid();
        String deviceUid = MapView.getDeviceUid();
        QuickTask quickTask = new QuickTask(makeMessageUid, deviceUid, MapView.getMapView().getDeviceCallsign() + "_QuickFlyTo", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED);
        quickTask.setPoint(geoPoint);
        quickTask.setAction(QuickTask.ACTION.WAYPOINT);
        quickTask.setAltitudeAgl(getAGL_relative());
        sendTask(quickTask);
        try {
            UASToolDropDownReceiver.getInstance().getObserverPager().getObserverControlFragment().setCurrentRemoteTask(quickTask.getUID());
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean sendRemoteOrbit(GeoPoint geoPoint, double d, double d2, boolean z) {
        if (isDefault() || !hasCapability(UASItemCapabilities.CAPABILITY_REMOTE_QUICK_TASK).booleanValue()) {
            return false;
        }
        String makeMessageUid = TaskMessage.makeMessageUid();
        String deviceUid = MapView.getDeviceUid();
        QuickTask quickTask = new QuickTask(makeMessageUid, deviceUid, MapView.getMapView().getDeviceCallsign() + "_QuickOrbit", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED);
        quickTask.setPoint(geoPoint);
        quickTask.setAction(QuickTask.ACTION.ORBIT);
        quickTask.setOrbitRadius(d);
        quickTask.setAltitudeAgl(d2);
        quickTask.setOrbitCW(z);
        sendTask(quickTask);
        try {
            UASToolDropDownReceiver.getInstance().getObserverPager().getObserverControlFragment().setCurrentRemoteTask(quickTask.getUID());
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public boolean sendRemoteTask(UASTask uASTask, QuickTask.ACTION action) {
        return sendRemoteTask(uASTask, action, Double.NaN);
    }

    public boolean sendRemoteTask(UASTask uASTask, QuickTask.ACTION action, double d) {
        if (isDefault() || !hasCapability(UASItemCapabilities.CAPABILITY_REMOTE_QUICK_TASK).booleanValue()) {
            return false;
        }
        String uuid = uASTask == null ? UUID.randomUUID().toString() : uASTask.getTaskMessageUid();
        String deviceUid = MapView.getDeviceUid();
        QuickTask quickTask = new QuickTask(uuid, deviceUid, MapView.getMapView().getDeviceCallsign() + "_" + action.getCotValue(), getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED);
        quickTask.setAction(action);
        quickTask.setAltitudeAgl(d);
        sendTask(quickTask);
        return true;
    }

    public void quickTakeoff(int i) {
        if (getCurrentTask() != null) {
            finishedTaskProgress("Task ended", (String) null);
        }
    }

    public void quickLanding() {
        if (getCurrentTask() != null) {
            finishedTaskProgress("Task ended", (String) null);
        }
    }

    public void quickStop() {
        getCurrentTask();
    }

    public void quickRTH() {
        if (getCurrentTask() != null) {
            finishedTaskProgress("Task ended", (String) null);
        }
    }

    public void quickAltitude(int i) {
        if (getCurrentTask() != null) {
            finishedTaskProgress("Task ended", (String) null);
        }
    }

    public void quickFlyTo(GeoPoint geoPoint, double d) {
        GeoPoint geoPoint2 = new GeoPoint(getGeoPoint(), GeoPoint.Access.READ_WRITE);
        if (!Double.isNaN(d)) {
            geoPoint2.set(geoPoint.getLatitude(), geoPoint.getLongitude());
        } else {
            geoPoint2.set(geoPoint.getLatitude(), geoPoint.getLongitude(), getGeoPoint().getAltitude());
            d = getGeoPoint().getAltitude() - getHomePosition().getAltitude();
        }
        String uuid = UUID.randomUUID().toString();
        String deviceUid = MapView.getDeviceUid();
        QuickTask quickTask = new QuickTask(uuid, deviceUid, MapView.getMapView().getDeviceCallsign() + "_QuickFlyTo", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED);
        quickTask.setPoint(geoPoint2);
        quickTask.setAltitudeAgl(d);
        quickFlyTo(quickTask);
    }

    public void quickFlyTo(final QuickTask quickTask) {
        UASTask currentTask = getCurrentTask();
        if (currentTask != null) {
            if (!(currentTask instanceof RouteTask) || ((RouteTask) currentTask).getIsQuickTask()) {
                finishedTaskProgress("Task ended", (String) null);
            } else {
                UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment().changeTaskState(getCurrentTask(), UASTask.STATE.QUEUED);
            }
        }
        final UASRoute makeQuickFlyTo = UASRoute.makeQuickFlyTo(this, quickTask.getPoint(), quickTask.getAltitudeAgl());
        final RouteTask routeTask = new RouteTask(makeQuickFlyTo, UUID.randomUUID().toString(), UASToolDropDownReceiver.getInstance().getCallsign(), "Quick FlyToRouteTask", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.QUEUED, "#FFFFFF", true);
        routeTask.setTaskSourceUid(quickTask.getTaskSourceUid());
        routeTask.setTaskMessageUid(quickTask.getUID());
        routeTask.setDeleteOnCompletion(true);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                final ActiveTasksFragment activeTasksFragment = UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment();
                UASItem.this.validateRouteTask(routeTask, new validateCallback() {
                    public void onValidate() {
                        if (!UASItem.this.sendRemoteFlyTo(quickTask.getPoint(), quickTask.getAltitudeAgl())) {
                            UASTaskStore.getInstance().stopRunningRoutes(UASItem.this);
                            activeTasksFragment.changeTaskState(routeTask, UASTask.STATE.RUNNING);
                            UASItem.this.setWayPointVisible(quickTask.getPoint(), -1.0d, new av.a() {
                                public void onPointChanged(av avVar) {
                                    GeoPoint geoPoint = new GeoPoint(avVar.C().getLatitude(), avVar.C().getLongitude(), UASItem.this.getGeoPoint().getAltitude());
                                    UASItem.this.quickTaskMarker.mo10277a(geoPoint);
                                    if (routeTask.getTaskSourceUid() != null) {
                                        UASItem.this.sendTaskResponse(routeTask, TaskResponse.RESPONSETYPE.CANCELLED);
                                        routeTask.setTaskSourceUid((String) null);
                                    }
                                    makeQuickFlyTo.getPointWithIndex(1).a(geoPoint);
                                    UASItem.this.validateRouteTask(routeTask, new validateCallback() {
                                        public void onValidate() {
                                            UASItem.this.runTask(routeTask);
                                        }
                                    });
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    public void quickOrbit(GeoPoint geoPoint, double d, double d2, boolean z) {
        if (!hasCapability(UASItemCapabilities.CAPABILITY_QUICK_TASK).booleanValue()) {
            UASToolDropDownReceiver.toast("Quick orbit not available for this UAS platform", 0);
            return;
        }
        GeoPoint geoPoint2 = new GeoPoint(getGeoPoint(), GeoPoint.Access.READ_WRITE);
        if (!Double.isNaN(d2)) {
            geoPoint2.set(geoPoint.getLatitude(), geoPoint.getLongitude());
        } else {
            geoPoint2.set(geoPoint.getLatitude(), geoPoint.getLongitude(), getGeoPoint().getAltitude());
            d2 = getGeoPoint().getAltitude() - getHomePosition().getAltitude();
        }
        String uuid = UUID.randomUUID().toString();
        String deviceUid = MapView.getDeviceUid();
        QuickTask quickTask = new QuickTask(uuid, deviceUid, MapView.getMapView().getDeviceCallsign() + "_QuickOrbit", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED);
        quickTask.setPoint(geoPoint2);
        quickTask.setAltitudeAgl(d2);
        quickTask.setOrbitRadius(d);
        quickTask.setOrbitCW(z);
        quickOrbit(quickTask);
    }

    public void quickOrbit(QuickTask quickTask) {
        if (getCurrentTask() != null) {
            finishedTaskProgress("Task ended", (String) null);
        }
        final UASRoute makeQuickOrbit = UASRoute.makeQuickOrbit(this, quickTask.getPoint(), quickTask.getOrbitRadius(), quickTask.getAltitudeAgl(), quickTask.isOrbitClockwise());
        final RouteTask routeTask = new RouteTask(makeQuickOrbit, UUID.randomUUID().toString(), UASToolDropDownReceiver.getInstance().getCallsign(), "Quick OrbitRouteTask", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.QUEUED, "#FFFFFF", true);
        routeTask.setTaskSourceUid(quickTask.getTaskSourceUid());
        routeTask.setTaskMessageUid(quickTask.getUID());
        routeTask.setDeleteOnCompletion(true);
        final QuickTask quickTask2 = quickTask;
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                final ActiveTasksFragment activeTasksFragment = UASToolDropDownReceiver.getInstance().getOperatorPager().getActiveTasksFragment();
                UASItem.this.validateRouteTask(routeTask, new validateCallback() {
                    public void onValidate() {
                        if (!UASItem.this.sendRemoteOrbit(quickTask2.getPoint(), quickTask2.getOrbitRadius(), quickTask2.getAltitudeAgl(), quickTask2.isOrbitClockwise())) {
                            UASTaskStore.getInstance().stopRunningRoutes(UASItem.this);
                            activeTasksFragment.changeTaskState(routeTask, UASTask.STATE.RUNNING);
                            routeTask.hide();
                            UASItem.this.setWayPointVisible(quickTask2.getPoint(), quickTask2.getOrbitRadius(), new av.a() {
                                public void onPointChanged(av avVar) {
                                    GeoPoint geoPoint = new GeoPoint(avVar.C().getLatitude(), avVar.C().getLongitude(), UASItem.this.getGeoPoint().getAltitude());
                                    UASItem.this.quickTaskMarker.mo10277a(geoPoint);
                                    if (routeTask.getTaskSourceUid() != null) {
                                        UASItem.this.sendTaskResponse(routeTask, TaskResponse.RESPONSETYPE.CANCELLED);
                                        routeTask.setTaskSourceUid((String) null);
                                    }
                                    makeQuickOrbit.getPointWithIndex(1).a(geoPoint);
                                    UASItem.this.validateRouteTask(routeTask, new validateCallback() {
                                        public void onValidate() {
                                            UASItem.this.runTask(routeTask);
                                        }
                                    });
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    public double getHeading() {
        try {
            return getMarker().getMetaDouble("track:course", 0.0d);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public double getPitch() {
        try {
            return getMarker().getMetaDouble("attitude:pitch", 0.0d);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public double getRoll() {
        try {
            return getMarker().getMetaDouble("attitude:roll", 0.0d);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public double getYaw() {
        try {
            return getMarker().getMetaDouble("attitude:yaw", 0.0d);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public boolean supportsMatrixAr() {
        return hasCapability(UASItemCapabilities.CAPABILITY_ROTATION_MATRIX_AR).booleanValue();
    }

    public static double getAgl(GeoPoint geoPoint, double d, double d2) {
        double a = ElevationManager.a(geoPoint.getLatitude(), geoPoint.getLongitude(), (ElevationManager.b) null);
        return Double.isNaN(a) ? d2 : d - a;
    }

    public void validateRouteTask(RouteTask routeTask, final validateCallback validatecallback) {
        RouteTaskErrorList validateRouteTask = validateRouteTask(routeTask);
        StringBuilder sb = new StringBuilder();
        for (String append : validateRouteTask.errorList) {
            sb.append(append);
            sb.append("\n");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
        int i = C115410.f8374xd4a72929[validateRouteTask.errorType.ordinal()];
        if (i == 1) {
            builder.setTitle("Route Warning").setCancelable(false).setMessage(sb.toString()).setNegativeButton("Cancel+Fix", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setPositiveButton("Ignore+Run", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    validatecallback.onValidate();
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        } else if (i == 2) {
            builder.setTitle("Route Error").setCancelable(false).setMessage(sb.toString()).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();
        } else if (i == 3) {
            validatecallback.onValidate();
        }
    }

    /* renamed from: com.atakmap.android.uastool.UASItem$10 */
    /* synthetic */ class C115410 {

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$pagers$status$StatusMetaItem$META_TYPE */
        static final /* synthetic */ int[] f8373x417c107a;
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION;
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE;

        /* renamed from: $SwitchMap$com$atakmap$android$uastool$tasks$route$RouteTaskErrorList$ErrorType */
        static final /* synthetic */ int[] f8374xd4a72929;

        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|(2:41|42)|43|(2:45|46)|47|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|(2:41|42)|43|(2:45|46)|47|49|50|(2:51|52)|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|(2:41|42)|43|(2:45|46)|47|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|(2:41|42)|43|(2:45|46)|47|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|(2:41|42)|43|(2:45|46)|47|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|(2:41|42)|43|(2:45|46)|47|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|(2:41|42)|43|45|46|47|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|1|2|3|5|6|7|9|10|11|13|14|15|16|(2:17|18)|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|(2:41|42)|43|45|46|47|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|(3:81|82|84)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(71:0|1|2|3|5|6|7|9|10|11|13|14|15|16|(2:17|18)|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|52|53|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|84) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00ae */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00e7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00f1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00fb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0105 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x010f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x0119 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0123 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x012f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x013b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0147 */
        static {
            /*
                com.atakmap.android.uastool.tasks.route.RouteTaskErrorList$ErrorType[] r0 = com.atakmap.android.uastool.tasks.route.RouteTaskErrorList.ErrorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8374xd4a72929 = r0
                r1 = 1
                com.atakmap.android.uastool.tasks.route.RouteTaskErrorList$ErrorType r2 = com.atakmap.android.uastool.tasks.route.RouteTaskErrorList.ErrorType.WARN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f8374xd4a72929     // Catch:{ NoSuchFieldError -> 0x001d }
                com.atakmap.android.uastool.tasks.route.RouteTaskErrorList$ErrorType r3 = com.atakmap.android.uastool.tasks.route.RouteTaskErrorList.ErrorType.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f8374xd4a72929     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.atakmap.android.uastool.tasks.route.RouteTaskErrorList$ErrorType r4 = com.atakmap.android.uastool.tasks.route.RouteTaskErrorList.ErrorType.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.atakmap.android.uastool.tasks.QuickTask$ACTION[] r3 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION = r3
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r4 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.ORBIT     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r4 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x004d }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r4 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                r3 = 4
                int[] r4 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r5 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.LAND     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                r4 = 5
                int[] r5 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r6 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.RTH     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                r5 = 6
                int[] r6 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x006e }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r7 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.STOP     // Catch:{ NoSuchFieldError -> 0x006e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                r6 = 7
                int[] r7 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r8 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.PAUSE     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                r7 = 8
                int[] r8 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0085 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r9 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.RESUME     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                r8 = 9
                int[] r9 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x0091 }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r10 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.ALTITUDE     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                r9 = 10
                int[] r10 = $SwitchMap$com$atakmap$android$uastool$tasks$QuickTask$ACTION     // Catch:{ NoSuchFieldError -> 0x009d }
                com.atakmap.android.uastool.tasks.QuickTask$ACTION r11 = com.atakmap.android.uastool.tasks.QuickTask.ACTION.QUICKSTOP     // Catch:{ NoSuchFieldError -> 0x009d }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE[] r10 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.values()
                int r10 = r10.length
                int[] r10 = new int[r10]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE = r10
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r11 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.QUICKFLY     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r10[r11] = r1     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                int[] r10 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x00b8 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r11 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_FOVCENTER     // Catch:{ NoSuchFieldError -> 0x00b8 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r10[r11] = r0     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE[] r10 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.values()
                int r10 = r10.length
                int[] r10 = new int[r10]
                f8373x417c107a = r10
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r11 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.LOCATION     // Catch:{ NoSuchFieldError -> 0x00c9 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c9 }
                r10[r11] = r1     // Catch:{ NoSuchFieldError -> 0x00c9 }
            L_0x00c9:
                int[] r1 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x00d3 }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r10 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.ALTITUDE     // Catch:{ NoSuchFieldError -> 0x00d3 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d3 }
                r1[r10] = r0     // Catch:{ NoSuchFieldError -> 0x00d3 }
            L_0x00d3:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x00dd }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.HEADING     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x00e7 }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.SPEED     // Catch:{ NoSuchFieldError -> 0x00e7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e7 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00e7 }
            L_0x00e7:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x00f1 }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.BATTERY     // Catch:{ NoSuchFieldError -> 0x00f1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f1 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00f1 }
            L_0x00f1:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x00fb }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.SIGNAL     // Catch:{ NoSuchFieldError -> 0x00fb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fb }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00fb }
            L_0x00fb:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x0105 }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.TGT_SRB     // Catch:{ NoSuchFieldError -> 0x0105 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0105 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0105 }
            L_0x0105:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x010f }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.UAS_RB     // Catch:{ NoSuchFieldError -> 0x010f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x010f }
            L_0x010f:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x0119 }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.MODEL     // Catch:{ NoSuchFieldError -> 0x0119 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0119 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0119 }
            L_0x0119:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x0123 }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.OPERATOR     // Catch:{ NoSuchFieldError -> 0x0123 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0123 }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x0123 }
            L_0x0123:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x012f }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.WIND     // Catch:{ NoSuchFieldError -> 0x012f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012f }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012f }
            L_0x012f:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x013b }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x013b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x013b }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x013b }
            L_0x013b:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x0147 }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.ERROR     // Catch:{ NoSuchFieldError -> 0x0147 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0147 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0147 }
            L_0x0147:
                int[] r0 = f8373x417c107a     // Catch:{ NoSuchFieldError -> 0x0153 }
                com.atakmap.android.uastool.pagers.status.StatusMetaItem$META_TYPE r1 = com.atakmap.android.uastool.pagers.status.StatusMetaItem.META_TYPE.UID     // Catch:{ NoSuchFieldError -> 0x0153 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0153 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0153 }
            L_0x0153:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.UASItem.C115410.<clinit>():void");
        }
    }

    public RouteTaskErrorList validateRouteTask(RouteTask routeTask) {
        double d;
        RouteTaskErrorList routeTaskErrorList = new RouteTaskErrorList();
        if (isDefault() && !isConnected()) {
            Log.e(TAG, "No Connected UAS");
            routeTaskErrorList.add("No Connected UAS", RouteTaskErrorList.ErrorType.ERROR);
            return routeTaskErrorList;
        } else if (getHomePosition() == null) {
            Log.e(TAG, "No home position, can not determine altitude AGL of waypoints");
            routeTaskErrorList.add("No home position, can not determine altitude AGL of waypoints", RouteTaskErrorList.ErrorType.WARN);
            return routeTaskErrorList;
        } else {
            UASRoute route = routeTask.getRoute();
            String string = UASToolDropDownReceiver.getSharedPrefs().getString(UtilitiesPreferenceFragment.PREF_DANGER_LOW_ALT, UtilitiesPreferenceFragment.DEFAULT_DANGER_LOW_ALT);
            try {
                d = Double.parseDouble(string);
            } catch (Exception unused) {
                String str = TAG;
                Log.d(str, "Error parsing danger low altitude: " + string + "m");
                d = Double.parseDouble(UtilitiesPreferenceFragment.DEFAULT_DANGER_LOW_ALT);
            }
            double altitude = getHomePosition().getAltitude();
            Iterator<UASPoint> it = route.getPoints().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UASPoint next = it.next();
                if (Double.isNaN(ElevationManager.a(next.C().getLatitude(), next.C().getLongitude(), (ElevationManager.b) null))) {
                    routeTaskErrorList.add("No DTED for route location.", RouteTaskErrorList.ErrorType.WARN);
                    routeTaskErrorList.add("Skipping elevation check.", RouteTaskErrorList.ErrorType.WARN);
                    break;
                }
                double agl = getAgl(next.C(), ((double) next.getHAL()) + altitude, (double) next.getHAL());
                if (agl < d) {
                    String format = String.format("Route point %d: %s AGL < %s AGL ", new Object[]{Integer.valueOf(next.getIndex()), Utils.formatAlt(agl), Utils.formatAlt(d)});
                    Log.e(TAG, format);
                    routeTaskErrorList.add(format, RouteTaskErrorList.ErrorType.WARN);
                }
            }
            return routeTaskErrorList;
        }
    }

    public double getAGL_relative() {
        GeoPoint homePosition = getHomePosition();
        GeoPoint geoPoint = getGeoPoint();
        if (homePosition == null || geoPoint == null) {
            return Double.NaN;
        }
        return geoPoint.getAltitude() - homePosition.getAltitude();
    }

    public GeoPoint getHomePosition() {
        ao marker = getMarker();
        if (marker == null) {
            return null;
        }
        ao b = MapView.getMapView().getRootGroup().b("HOME." + marker.getUID());
        if (b == null || b.C() == null) {
            return null;
        }
        return b.C();
    }

    public void sendLtclcLookAtPoint(GeoPoint geoPoint) {
        if (geoPoint != null) {
            String uuid = UUID.randomUUID().toString();
            String deviceUid = MapView.getDeviceUid();
            LTCLCFOVCenterTask lTCLCFOVCenterTask = new LTCLCFOVCenterTask(uuid, deviceUid, MapView.getMapView().getDeviceCallsign() + "_GimbalControlFOVCenter", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED);
            lTCLCFOVCenterTask.setPoint(geoPoint);
            sendTask(lTCLCFOVCenterTask);
            return;
        }
        UASToolDropDownReceiver.toast("Unable to send Gimbal Control FOV Center Request - look at point is NULL", 0);
    }

    public void onGimbalControlChanged(final boolean z) {
        setGimbalControlEnabled(z);
        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
            public void run() {
                UASItem.this.setCrosshairVisible(z);
                ControlFragment controlFragment = UASToolDropDownReceiver.getControlFragment(UASItem.this);
                if (controlFragment != null) {
                    if (controlFragment.getVideoUI() != null) {
                        controlFragment.getVideoUI().onGimbalControlChanged(z);
                    }
                    ArOverlayView arOverlay = controlFragment.getArOverlay();
                    if (arOverlay != null) {
                        arOverlay.setControlEnabled(z);
                    }
                }
                ao spoIMapItem = UASItem.this.getSpoIMapItem();
                ao crosshair = UASItem.this.getCrosshair();
                if (spoIMapItem != null) {
                    if (z) {
                        crosshair.a(UASItem.this.crosshairChangedListener);
                        spoIMapItem.a(UASItem.this.spiChangedListener);
                    } else {
                        crosshair.b(UASItem.this.crosshairChangedListener);
                        spoIMapItem.b(UASItem.this.spiChangedListener);
                    }
                }
                if (!UASItem.this.isConnected() && UASItem.this.hasCapability(UASItemCapabilities.CAPABILITY_REMOTE_QUICK_TASK).booleanValue()) {
                    if (z) {
                        UASToolDropDownReceiver.getInstance().getQuickbar().setMode(Quickbar.MODE.OBSERVER_CONTROL);
                    } else {
                        UASToolDropDownReceiver.getInstance().getQuickbar().setMode(Quickbar.MODE.OBSERVER);
                    }
                }
            }
        });
        if (isConnected()) {
            UASToolDropDownReceiver.onUasItemStatusChanged();
        } else {
            UASToolDropDownReceiver.onObserverUasItemStatusChanged();
        }
    }

    public boolean getRouteActive() {
        return this.isRouteActive;
    }

    public void setRouteActive(boolean z) {
        this.isRouteActive = z;
    }

    public void changeIcon() {
        toast("Change uas icon image and color not yet implemented", 0);
    }

    public Double distanceToMe() {
        GeoPoint geoPoint = getGeoPoint();
        GeoPoint C = MapView.getMapView().getSelfMarker().C();
        if (geoPoint == null || C == null) {
            return Double.valueOf(Double.MAX_VALUE);
        }
        return Double.valueOf(geoPoint.distanceTo(C));
    }

    public void dispose() {
        this.modelName = "";
        this.gimbalControlEnabled.set(false);
        setCrosshairVisible(false);
        setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
        getGimbalFollowController().stopFollowing();
        getFollowEudController().stopFollowing();
        ao aoVar = this.uasMarker;
        if (aoVar != null) {
            aoVar.removeOnMetadataChangedListener(this);
            this.uasMarker = null;
        }
    }

    public FollowEudController getFollowEudController() {
        return this.followEudController;
    }

    public FollowEudController getGimbalFollowController() {
        return this.gimbalFollowController;
    }

    public boolean isGimbalControlEnabled() {
        return this.gimbalControlEnabled.get();
    }

    public void setGimbalControlEnabled(boolean z) {
        this.gimbalControlEnabled.set(z);
    }

    public String getRollAngle(Angle angle) {
        return getMarker() != null ? AngleUtilities.format(getMarker().getMetaDouble("attitude:roll", 0.0d), angle, false) : UASToolConstants.DASHES;
    }

    public String getPitchAngle(Angle angle) {
        return getMarker() != null ? AngleUtilities.format(getMarker().getMetaDouble("attitude:pitch", 0.0d), angle, false) : UASToolConstants.DASHES;
    }

    public void setAttitude(double d, double d2, double d3) {
        ao marker = getMarker();
        if (marker != null) {
            marker.setMetaDouble("attitude:pitch", d2);
            marker.setMetaDouble("attitude:roll", d);
            marker.setMetaDouble("attitude:yaw", d3);
            marker.setMetaDouble("track:course", d3);
        }
    }

    public List<CameraInfo> getCameraInfo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CameraInfo("Default", 6.3d, 4.7d, 12.0d, 4.73d, true));
        return arrayList;
    }

    public int getVideoUIButtons() {
        return isConnected() ? C1877R.layout.video_ui_op_none_bottombar : C1877R.layout.video_ui_ob_none_bottombar;
    }

    public int getVideoUI() {
        return isDefault() ? UASToolDropDownReceiver.getInstance().isFullscreenVideo() ? C1877R.layout.video_ui_operator_full_layout : C1877R.layout.video_ui_operator_half_layout : UASToolDropDownReceiver.getInstance().isFullscreenVideo() ? C1877R.layout.video_ui_observer_full_layout : C1877R.layout.video_ui_observer_half_layout;
    }

    public void handleMoreMenu(String str) {
        toast("Unknown menu item: " + str, 0);
    }

    public void sendLtclcRemoteRequest() {
        String uuid = UUID.randomUUID().toString();
        String deviceUid = MapView.getDeviceUid();
        this.waitingForLtclcTaskResponse = sendTaskMode(new LTCLCRemoteTask(uuid, deviceUid, MapView.getMapView().getDeviceCallsign() + "_GimbalControlMode", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED));
    }

    public void sendLtclcRemoteCancel() {
        String uuid = UUID.randomUUID().toString();
        String deviceUid = MapView.getDeviceUid();
        sendTask(new LTCLCRemoteCancelTask(uuid, deviceUid, MapView.getMapView().getDeviceCallsign() + "_GimbalControlCancel", getPlatformType(), UASTask.PRIORITY.NORMAL, UASTask.STATE.STORED));
        setGimbalControlEnabled(false);
        try {
            UASToolDropDownReceiver.getInstance().getObserverPager().getObserverControlFragment().onGimbalControlChanged(false);
        } catch (Exception unused) {
        }
    }

    public boolean isLtclcRemoteRequestPending() {
        return this.waitingForLtclcTaskResponse != null;
    }

    public boolean setVirtualStickMode(boolean z) {
        String str = TAG;
        Log.d(str, "Virtual Joystick Mode not implemented for platform " + this.platformType);
        return false;
    }

    public void joystickUpIncr() {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickUpCont(boolean z) {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickForwardIncr() {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickForwardCont(boolean z) {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickDownIncr() {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickDownCont(boolean z) {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickBackwardIncr() {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickBackwardCont(boolean z) {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickYawLeftIncr() {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickYawLeftCont(boolean z) {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickPanLeftIncr() {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickPanLeftCont(boolean z) {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickYawRightIncr() {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickYawRightCont(boolean z) {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickPanRightIncr() {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickPanRightCont(boolean z) {
        toast("Joystick Buttons not implemented for platform " + this.platformType, 0);
    }

    public void joystickPosition(float f, float f2, float f3, float f4) {
        int i = this.joyMsgCnt + 1;
        this.joyMsgCnt = i;
        if (i > 100) {
            this.joyMsgCnt = 0;
            toast("Joystick Dual Sticks not implemented for platform " + this.platformType, 0);
        }
    }
}
