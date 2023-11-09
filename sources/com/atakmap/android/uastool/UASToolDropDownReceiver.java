package com.atakmap.android.uastool;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Pair;
import android.util.Rational;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.PagerAdapter;
import atak.core.agl;
import com.atak.plugins.impl.PluginLayoutInflater;
import com.atakmap.android.dropdown.DropDownManager;
import com.atakmap.android.dropdown.DropDownReceiver;
import com.atakmap.android.dropdown.a;
import com.atakmap.android.ipc.AtakBroadcast;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ae;
import com.atakmap.android.maps.af;
import com.atakmap.android.maps.ai;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.o;
import com.atakmap.android.menu.MapMenuReceiver;
import com.atakmap.android.menu.k;
import com.atakmap.android.toolbar.ToolManagerBroadcastReceiver;
import com.atakmap.android.uastool.PD100.PD100Monitor;
import com.atakmap.android.uastool.PD100.PD100Reflector;
import com.atakmap.android.uastool.PD100.PD100UASItem;
import com.atakmap.android.uastool.dji.DJIMonitor;
import com.atakmap.android.uastool.dji.DJIReflector;
import com.atakmap.android.uastool.dji.DJIUASItem;
import com.atakmap.android.uastool.evo.EvoReflector;
import com.atakmap.android.uastool.evo.EvoUASItem;
import com.atakmap.android.uastool.flightlog.FlightLogScreen;
import com.atakmap.android.uastool.flightlog.FlightLogger;
import com.atakmap.android.uastool.generic.GenericReflector;
import com.atakmap.android.uastool.generic.GenericUASItem;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.indago.IndagoReflector;
import com.atakmap.android.uastool.indago.IndagoUASItem;
import com.atakmap.android.uastool.mavlink.MAVLinkReflector;
import com.atakmap.android.uastool.mavlink.MAVLinkUASItem;
import com.atakmap.android.uastool.overlays.OverlayScreen;
import com.atakmap.android.uastool.overlays.mapshot.MapShotController;
import com.atakmap.android.uastool.overlays.mapshot.MapShotRadialMenuFactory;
import com.atakmap.android.uastool.overlays.mapshot.UASToolMapLayerOverlay;
import com.atakmap.android.uastool.p000av.AvMonitor;
import com.atakmap.android.uastool.p000av.AvReflector;
import com.atakmap.android.uastool.p000av.AvUASItem;
import com.atakmap.android.uastool.pagers.ControlFragment;
import com.atakmap.android.uastool.pagers.LandingPager;
import com.atakmap.android.uastool.pagers.UASToolFragment;
import com.atakmap.android.uastool.pagers.UASToolPager;
import com.atakmap.android.uastool.pagers.observer.ObserverControlFragment;
import com.atakmap.android.uastool.pagers.observer.ObserverPager;
import com.atakmap.android.uastool.pagers.operator.OperatorControlFragment;
import com.atakmap.android.uastool.pagers.operator.OperatorPager;
import com.atakmap.android.uastool.pagers.status.StatusArrayList;
import com.atakmap.android.uastool.pagers.storedtasks.StoredTasksFragment;
import com.atakmap.android.uastool.pagers.video_ui.ArOverlayView;
import com.atakmap.android.uastool.pagers.video_ui.VideoUIBase;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.UIConstants;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.prefs.AtakPrefConstants;
import com.atakmap.android.uastool.prefs.CameraPreferenceFragment;
import com.atakmap.android.uastool.prefs.NetworkPreferenceFragment;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.prefs.UASToolPreferencesComponent;
import com.atakmap.android.uastool.prefs.UIPreferenceFragment;
import com.atakmap.android.uastool.prefs.UtilitiesPreferenceFragment;
import com.atakmap.android.uastool.quickbar.QuickTaskTool;
import com.atakmap.android.uastool.quickbar.Quickbar;
import com.atakmap.android.uastool.r80d.R80dReflector;
import com.atakmap.android.uastool.r80d.R80dUASItem;
import com.atakmap.android.uastool.tasks.TaskMessage;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.toastlog.ToastLogItem;
import com.atakmap.android.uastool.toastlog.ToastLogScreen;
import com.atakmap.android.uastool.trillium.TrilliumReflector;
import com.atakmap.android.uastool.trillium.TrilliumUASItem;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.uastool.utils.GLVideoConsumer;
import com.atakmap.android.uastool.utils.NetworkUtils;
import com.atakmap.android.uastool.utils.UASFOVVideoMapRenderer;
import com.atakmap.android.uastool.utils.UASToolConstants;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.android.user.g;
import com.atakmap.android.util.f;
import com.atakmap.comms.CommsMapComponent;
import com.atakmap.comms.e;
import com.atakmap.comms.j;
import com.atakmap.coremap.conversions.Angle;
import com.atakmap.coremap.conversions.CoordinateFormat;
import com.atakmap.coremap.conversions.Span;
import com.atakmap.coremap.cot.event.CotDetail;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.filesystem.FileSystemUtils;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.conversion.EGM96;
import com.atakmap.coremap.maps.conversion.GeomagneticField;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.coremap.maps.coords.GeoPointMetaData;
import com.atakmap.coremap.maps.coords.NorthReference;
import com.atakmap.coremap.maps.time.CoordinatedTime;
import com.atakmap.map.elevation.ElevationManager;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.o3dr.android.client.utils.FileUtils;
import com.partech.mobilevid.b;
import com.partech.mobilevid.c;
import com.partech.mobilevid.g;
import com.partech.mobilevid.h;
import indago.connection.VehicleConnection;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;
import org.json.JSONObject;

public class UASToolDropDownReceiver extends DropDownReceiver implements SharedPreferences.OnSharedPreferenceChangeListener, a.b, af.a, PlatformMonitor.OnUASDetectedListener, e.b {
    public static final boolean ALLOW_OP_DEBUG = false;
    private static final boolean DEFAULT_FLIGHTLOG_MODE = true;
    public static final String DEFAULT_PLATFORM = "None Selected";
    private static final int DEFAULT_PORT = 49000;
    private static final int DEFAULT_VIDEO_ENCODING_BITRATE = 700;
    private static final int DEFAULT_WOWZA_PORT = 1935;
    private static final int DEFAULT_WOWZA_PORT_SSL = 443;
    public static final String EDIT_UAS_ROUTE = "com.atakmap.android.uastool.EDIT_UAS_ROUTE";
    public static final String REJECT_UAS_TASK_POINT = "com.atakmap.android.uastool.REJECT_UAS_TASK_POINT";
    public static final String ROUTE_WAYPOINT_DELETE = "com.atakmap.android.uastool.ROUTE_WAYPOINT_DELETE";
    public static final String SELECT_UAS_OVERLAY = "com.atakmap.android.uastool.SELECT_UAS_OVERLAY";
    public static final String SHOW_UASTOOL = "com.atakmap.android.uastool.SHOW_UASTOOL";
    public static final String SHOW_UAS_LIST = "com.atakmap.android.uastool.SHOW_UAS_LIST";
    public static final String SHOW_UAS_ROUTE_DETAILS = "com.atakmap.android.uastool.SHOW_UAS_ROUTE_DETAILS";
    public static final String SHOW_UAS_TASK_LIST = "com.atakmap.android.uastool.SHOW_UAS_TASK_LIST";
    public static final String SHOW_WAYPOINT_DETAILS = "com.atakmap.android.uastool.SHOW_WAYPOINT_DETAILS";
    private static final String TAG = "UASToolDropDownReceiver";
    public static final String TOGGLE_UAS_ROUTE = "com.atakmap.android.uastool.TOGGLE_UAS_ROUTE";
    private static UASToolDropDownReceiver _instance;
    private static SharedPreferences sharedPrefs;
    private static final ArrayList<ToastLogItem> toastLogList = new ArrayList<>();
    private UASToolPager activePager = null;
    double currHeight = -1.0d;
    double currWidth = -1.0d;
    private Surface directorSourceSurface;
    private h encoder;
    /* access modifiers changed from: private */
    public FileObserver fileObserver;
    private boolean hasWarningBeenShown = false;
    private boolean isFullscreenVideo = false;
    /* access modifiers changed from: private */
    public final LandingPager landingPager;
    private final ViewGroup landingView;
    private final UASToolMapListener mapListener;
    private final MapShotController mapShotController;
    private final MapShotRadialMenuFactory mapShotRadialMenuFactory;
    /* access modifiers changed from: private */
    public final MapView mapView;
    private List<String> menuList = new ArrayList();
    /* access modifiers changed from: private */
    public final ObserverPager observerPager;
    private final ViewGroup observerView;
    private final c offscreenDirector;
    /* access modifiers changed from: private */
    public final OperatorPager operatorPager;
    private final ViewGroup operatorView;
    private PlatformMonitor platformMonitor = null;
    private final Context pluginContext;
    private boolean previewEnabled;
    /* access modifiers changed from: private */
    public final Quickbar quickbar;
    private Reflector reflector;
    /* access modifiers changed from: private */
    public int turnToOnOpen = -1;
    /* access modifiers changed from: private */
    public final ViewGroup uasToolView;
    private UASItem uasVideoItem;
    private Thread uasVideoMapOverlayThread;

    private int getVideoBroadcastImageFramerate() {
        return 30;
    }

    private void sendTaskDeliveryReceipt(CotEvent cotEvent, Bundle bundle) {
    }

    public void refreshFlightLogs() {
    }

    private UASToolDropDownReceiver(MapView mapView2, Context context) {
        super(mapView2);
        this.mapView = mapView2;
        this.pluginContext = context;
        MapShotRadialMenuFactory mapShotRadialMenuFactory2 = new MapShotRadialMenuFactory(getPluginContext());
        this.mapShotRadialMenuFactory = mapShotRadialMenuFactory2;
        MapShotController mapShotController2 = new MapShotController();
        this.mapShotController = mapShotController2;
        MapView.getMapView().getMapOverlayManager().g(new UASToolMapLayerOverlay(MapView.getMapView(), context));
        MapMenuReceiver.a().a(mapShotRadialMenuFactory2);
        AtakBroadcast.a(context);
        AtakBroadcast.DocumentedIntentFilter documentedIntentFilter = new AtakBroadcast.DocumentedIntentFilter();
        documentedIntentFilter.addAction(MapShotController.LAYER_VISIBILITY);
        documentedIntentFilter.addAction(MapShotController.LAYER_DELETE);
        AtakBroadcast.a().a(mapShotController2, documentedIntentFilter);
        AtakBroadcast.a(MapView.getMapView().getContext());
        this.offscreenDirector = new c();
        UIConstants.init(context);
        this.uasToolView = (ViewGroup) PluginLayoutInflater.inflate(context, C1877R.layout.uas_tool_layout, (ViewGroup) null);
        buildPlatformList();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mapView2.getContext());
        sharedPrefs = defaultSharedPreferences;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        try {
            String[] list = context.getAssets().list("menus");
            this.menuList = Arrays.asList(list == null ? new String[0] : list);
        } catch (IOException e) {
            Log.e(TAG, "error finding menus", e);
        }
        this.quickbar = (Quickbar) this.uasToolView.findViewById(C1877R.C1878id.quick_toolbar_layout);
        ViewGroup viewGroup = (ViewGroup) this.uasToolView.findViewById(C1877R.C1878id.landing_pager_layout);
        this.landingView = viewGroup;
        LandingPager landingPager2 = (LandingPager) viewGroup.findViewById(C1877R.C1878id.landing_pager);
        this.landingPager = landingPager2;
        landingPager2.setOffscreenPageLimit(2);
        ViewGroup viewGroup2 = (ViewGroup) this.uasToolView.findViewById(C1877R.C1878id.operator_pager_layout);
        this.operatorView = viewGroup2;
        OperatorPager operatorPager2 = (OperatorPager) viewGroup2.findViewById(C1877R.C1878id.operator_pager);
        this.operatorPager = operatorPager2;
        operatorPager2.setOffscreenPageLimit(4);
        ViewGroup viewGroup3 = (ViewGroup) this.uasToolView.findViewById(C1877R.C1878id.observer_pager_layout);
        this.observerView = viewGroup3;
        ObserverPager observerPager2 = (ObserverPager) viewGroup3.findViewById(C1877R.C1878id.observer_pager);
        this.observerPager = observerPager2;
        observerPager2.setOffscreenPageLimit(2);
        UASToolMapListener uASToolMapListener = new UASToolMapListener();
        this.mapListener = uASToolMapListener;
        addOnMapEventListener(this.mapShotController, "item_added");
        addOnMapEventListener(this.mapShotController, "item_removed");
        uASToolMapListener.addOnMapEventListener(this, "item_added");
        uASToolMapListener.addOnMapEventListener(this, "item_persist");
        uASToolMapListener.addOnMapEventListener(this, "item_refresh");
        CommsMapComponent.c().a(this);
        this.activePager = landingPager2;
        ToolManagerBroadcastReceiver.a().a(QuickTaskTool.TOOL_NAME, new QuickTaskTool(mapView2));
    }

    public static void sendIntentATAKGo(Intent intent) {
        DJIMonitor.sendIntentATAKGo(intent);
    }

    private void buildPlatformList() {
        DJIUASItem.initStatic();
        AvUASItem.initStatic();
        PD100UASItem.initStatic();
        IndagoUASItem.initStatic();
        MAVLinkUASItem.initStatic();
        R80dUASItem.initStatic();
        GenericUASItem.initStatic();
        TrilliumUASItem.initStatic();
        EvoUASItem.initStatic();
    }

    public static synchronized void initialize(MapView mapView2, Context context) {
        synchronized (UASToolDropDownReceiver.class) {
            if (_instance == null) {
                _instance = new UASToolDropDownReceiver(mapView2, context);
            }
            UASTaskStore.getInstance().resetTasks();
        }
    }

    public static synchronized UASToolDropDownReceiver getInstance() {
        UASToolDropDownReceiver uASToolDropDownReceiver;
        synchronized (UASToolDropDownReceiver.class) {
            uASToolDropDownReceiver = _instance;
        }
        return uASToolDropDownReceiver;
    }

    public c getOffscreenDirector() {
        return this.offscreenDirector;
    }

    private boolean toggleDirectorSource() {
        StringBuilder sb = new StringBuilder();
        sb.append("toggleDirectorSource ");
        sb.append(this.previewEnabled);
        sb.append(" ");
        sb.append(this.encoder != null);
        sb.append(" ");
        sb.append(this.reflector);
        Log.d(TAG, sb.toString());
        if (this.reflector == null) {
            return false;
        }
        if (this.previewEnabled) {
            if (this.directorSourceSurface == null) {
                try {
                    this.directorSourceSurface = new Surface(this.offscreenDirector.a());
                    Log.d(TAG, "Start feeding of director");
                } catch (agl e) {
                    Log.e(TAG, "Could not get input texture", e);
                    return false;
                }
            } else {
                Log.d(TAG, "Start feeding of director, but already started");
            }
            this.reflector.startPreview(this.directorSourceSurface);
            return true;
        }
        h hVar = this.encoder;
        if (hVar != null) {
            hVar.d();
            this.offscreenDirector.b(this.encoder);
            this.encoder = null;
        }
        this.reflector.stopPreview();
        Surface surface = this.directorSourceSurface;
        if (surface != null) {
            surface.release();
            this.directorSourceSurface = null;
        }
        Log.d(TAG, "Stopping feeding of director");
        return false;
    }

    public boolean setPreviewEnabled(boolean z) {
        ControlFragment.Screen screen = z ? ControlFragment.Screen.CONNECTING : ControlFragment.Screen.FAILED;
        OperatorPager operatorPager2 = this.operatorPager;
        if (operatorPager2 == null || operatorPager2.getOperatorControlFragment() == null) {
            ObserverPager observerPager2 = this.observerPager;
            if (!(observerPager2 == null || observerPager2.getObserverControlFragment() == null)) {
                this.observerPager.getObserverControlFragment().showScreen(screen);
            }
        } else {
            this.operatorPager.getOperatorControlFragment().showScreen(screen);
        }
        this.previewEnabled = z;
        return toggleDirectorSource() && z;
    }

    private b getEncoderConfig() {
        String str;
        try {
            g muxCallback = this.reflector.getMuxCallback();
            b.a videoBroadcastEncodingFormat = getVideoBroadcastEncodingFormat();
            String videoBroadcastPathSSL = getVideoBroadcastPathSSL(videoBroadcastEncodingFormat);
            String videoBroadcastDestinationIP = getVideoBroadcastDestinationIP();
            if (videoBroadcastDestinationIP != null) {
                if (!videoBroadcastDestinationIP.isEmpty()) {
                    String videoBroadcastDestinationPort = getVideoBroadcastDestinationPort();
                    if (videoBroadcastDestinationPort != null) {
                        if (!videoBroadcastDestinationPort.isEmpty()) {
                            int parseInt = Utils.parseInt(videoBroadcastDestinationPort, DEFAULT_PORT);
                            if (videoBroadcastEncodingFormat != b.a.c) {
                                if (videoBroadcastEncodingFormat != b.a.b) {
                                    if (videoBroadcastEncodingFormat == b.a.a) {
                                        str = null;
                                        return new b(getVideoBroadcastImageWidth(), getVideoBroadcastImageHeight(), getVideoBroadcastImageFramerate(), getVideoBroadcastImageBitrate(), videoBroadcastEncodingFormat, videoBroadcastDestinationIP, parseInt, str, getVideoOutboundInterfaceAddr(videoBroadcastEncodingFormat), 255, new com.partech.mobilevid.a() {
                                            /* renamed from: a */
                                            public void mo7857a(String str) {
                                                Log.e(UASToolDropDownReceiver.TAG, "mux fatal error: " + str);
                                                ((Activity) UASToolDropDownReceiver.this.mapView.getContext()).runOnUiThread(new Runnable() {
                                                    public void run() {
                                                        UASToolDropDownReceiver.toast("Error occurred during broadcasting: Weak or no network connection.", 1);
                                                        UASToolDropDownReceiver.this.updateUIOnBroadcastChange(false);
                                                        UASToolDropDownReceiver.this.stopEncoder();
                                                    }
                                                });
                                            }
                                        }, muxCallback);
                                    }
                                    toast("Unsupported encoding format", 1);
                                    return null;
                                }
                            }
                            if (videoBroadcastPathSSL == null) {
                                toast("Video Broadcast Identifier not configured.", 1);
                                return null;
                            }
                            str = videoBroadcastPathSSL;
                            return new b(getVideoBroadcastImageWidth(), getVideoBroadcastImageHeight(), getVideoBroadcastImageFramerate(), getVideoBroadcastImageBitrate(), videoBroadcastEncodingFormat, videoBroadcastDestinationIP, parseInt, str, getVideoOutboundInterfaceAddr(videoBroadcastEncodingFormat), 255, new com.partech.mobilevid.a() {
                                /* renamed from: a */
                                public void mo7857a(String str) {
                                    Log.e(UASToolDropDownReceiver.TAG, "mux fatal error: " + str);
                                    ((Activity) UASToolDropDownReceiver.this.mapView.getContext()).runOnUiThread(new Runnable() {
                                        public void run() {
                                            UASToolDropDownReceiver.toast("Error occurred during broadcasting: Weak or no network connection.", 1);
                                            UASToolDropDownReceiver.this.updateUIOnBroadcastChange(false);
                                            UASToolDropDownReceiver.this.stopEncoder();
                                        }
                                    });
                                }
                            }, muxCallback);
                        }
                    }
                    toast("Video destination port not configured.", 1);
                    return null;
                }
            }
            toast("Video destination IP not configured.", 1);
            return null;
        } catch (UnknownHostException unused) {
            Log.e(TAG, "Encoding destination host unknown!");
            return null;
        }
    }

    public void stopEncoder() {
        h hVar = this.encoder;
        if (hVar != null) {
            hVar.d();
            this.offscreenDirector.b(this.encoder);
            this.encoder = null;
            toggleDirectorSource();
        }
    }

    public void startEncoder() {
        if (this.encoder == null) {
            b encoderConfig = getEncoderConfig();
            if (encoderConfig != null) {
                try {
                    h hVar = new h(this.offscreenDirector.b(), encoderConfig, this.reflector.usesYUVTexture());
                    this.encoder = hVar;
                    try {
                        hVar.c();
                        this.offscreenDirector.a(this.encoder);
                        if (!toggleDirectorSource()) {
                            this.encoder = null;
                            throw new h.b("Failed to connect UAS to encoder");
                        }
                    } catch (h.b e) {
                        this.encoder = null;
                        throw e;
                    }
                } catch (agl e2) {
                    throw new h.b("Error getting source context", e2);
                }
            } else {
                throw new h.b("Could not get encoder config");
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateUIOnBroadcastChange(boolean z) {
        OperatorPager operatorPager2 = this.operatorPager;
        if (operatorPager2 != null) {
            operatorPager2.updateUIOnBroadcastChange(z);
        }
    }

    public Context getPluginContext() {
        return this.pluginContext;
    }

    public static SharedPreferences getSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(MapView.getMapView().getContext());
    }

    public PlatformMonitor getPlatformMonitor() {
        return this.platformMonitor;
    }

    public void resetUI() {
        UIPreferenceFragment.resetUI();
        OperatorControlFragment operatorControlFragment = getOperatorPager().getOperatorControlFragment();
        if (operatorControlFragment != null) {
            operatorControlFragment.switchVideoUI();
        }
        ObserverControlFragment observerControlFragment = getObserverPager().getObserverControlFragment();
        if (observerControlFragment != null) {
            observerControlFragment.switchVideoUI();
        }
    }

    public VideoUIBase getOperatorVideoUI() {
        OperatorPager operatorPager2 = this.operatorPager;
        if (operatorPager2 != null) {
            return operatorPager2.getVideoUI();
        }
        return null;
    }

    public VideoUIBase getObserverVideoUI() {
        ObserverPager observerPager2 = this.observerPager;
        if (observerPager2 != null) {
            return observerPager2.getVideoUI();
        }
        return null;
    }

    public ArOverlayView getOperatorArOverlay() {
        OperatorPager operatorPager2 = this.operatorPager;
        if (operatorPager2 != null) {
            return operatorPager2.getArOverlay();
        }
        return null;
    }

    public ArOverlayView getObserverArOverlay() {
        ObserverPager observerPager2 = this.observerPager;
        if (observerPager2 != null) {
            return observerPager2.getArOverlay();
        }
        return null;
    }

    public void addOnMapEventListener(af.a aVar, String str) {
        this.mapListener.addOnMapEventListener(aVar, str);
    }

    public void removeOnMapEventListener(af.a aVar, String str) {
        this.mapListener.removeOnMapEventListener(aVar, str);
    }

    public void onMapEvent(ae aeVar) {
        ai b = aeVar.b();
        if (!UASItem.isUASMapItem(b)) {
            return;
        }
        if (aeVar.a().equals("item_added")) {
            try {
                List<String> list = this.menuList;
                if (list.contains(b.getType() + FileUtils.CAMERA_FILENAME_EXT)) {
                    Context context = this.pluginContext;
                    b.setMetaString("menu", k.a(context, "menus/" + b.getType() + FileUtils.CAMERA_FILENAME_EXT));
                    return;
                }
                Log.d(TAG, "Menu not found for uas item type: " + b.getType());
            } catch (Exception e) {
                Log.d(TAG, "Menu load failed: " + b.getType(), e);
            }
        } else if (aeVar.a().equals("item_persist") || aeVar.a().equals("item_refresh")) {
            try {
                List<String> list2 = this.menuList;
                if (list2.contains(b.getType() + FileUtils.CAMERA_FILENAME_EXT)) {
                    Context context2 = this.pluginContext;
                    b.setMetaString("menu", k.a(context2, "menus/" + b.getType() + FileUtils.CAMERA_FILENAME_EXT));
                    return;
                }
                Log.d(TAG, "Menu not found for uas item type: " + b.getType());
            } catch (Exception e2) {
                Log.d(TAG, "Menu load failed: " + b.getType(), e2);
            }
        }
    }

    public void toggleScreenSize() {
        UASToolPager uASToolPager = this.activePager;
        OperatorPager operatorPager2 = this.operatorPager;
        if (uASToolPager != operatorPager2) {
            Log.w(TAG, "Unable to toggle screen: operator pager is not active");
        } else if (!operatorPager2.isOnVideoPage()) {
            Log.w(TAG, "Unable to toggle screen: operator pager is not showing video page");
        } else if (this.isFullscreenVideo) {
            resizeHalf();
        } else {
            resizeFull(this.activePager);
        }
    }

    public void resizeFull(UASToolPager uASToolPager) {
        this.activePager = uASToolPager;
        AtakBroadcast.a().a(new Intent("com.atakmap.android.tools.TOGGLE_ACTIONBAR").putExtra("show", false));
        if (isPortrait()) {
            if (Build.VERSION.SDK_INT >= 25) {
                this.mapView.setVisibility(0);
            }
            resize(1.0d, 1.0d);
            return;
        }
        if (Build.VERSION.SDK_INT >= 25) {
            this.mapView.setVisibility(8);
        }
        resize(1.0d, 1.0d);
    }

    public void resizeHalf() {
        AtakBroadcast.a().a(new Intent("com.atakmap.android.tools.TOGGLE_ACTIONBAR").putExtra("show", true));
        resize(0.5d, 1.0d);
    }

    public boolean isFullscreenVideo() {
        return this.isFullscreenVideo;
    }

    public UASItem findUASItem(String str) {
        return StatusArrayList.getInstance().findUASItem(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0117, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void startPlatformMonitor() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = getDefaultPlatform()     // Catch:{ all -> 0x0118 }
            com.atakmap.android.uastool.plugin.PlatformMonitor r1 = r5.platformMonitor     // Catch:{ all -> 0x0118 }
            r2 = 0
            if (r1 == 0) goto L_0x001d
            boolean r1 = r1.monitors(r0)     // Catch:{ all -> 0x0118 }
            if (r1 != 0) goto L_0x0018
            com.atakmap.android.uastool.plugin.PlatformMonitor r1 = r5.platformMonitor     // Catch:{ all -> 0x0118 }
            r1.endMonitoring()     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r2     // Catch:{ all -> 0x0118 }
            goto L_0x001d
        L_0x0018:
            com.atakmap.android.uastool.plugin.PlatformMonitor r1 = r5.platformMonitor     // Catch:{ all -> 0x0118 }
            r1.setPlatform(r0)     // Catch:{ all -> 0x0118 }
        L_0x001d:
            com.atakmap.android.uastool.plugin.PlatformMonitor r1 = r5.platformMonitor     // Catch:{ all -> 0x0118 }
            if (r1 != 0) goto L_0x0116
            r5.stopLocalCOT()     // Catch:{ all -> 0x0118 }
            r5.removeDefaultUAS()     // Catch:{ all -> 0x0118 }
            com.atakmap.android.uastool.Reflector r1 = r5.reflector     // Catch:{ all -> 0x0118 }
            if (r1 == 0) goto L_0x002e
            r1.destroy()     // Catch:{ all -> 0x0118 }
        L_0x002e:
            r1 = -1
            int r3 = r0.hashCode()     // Catch:{ all -> 0x0118 }
            r4 = 0
            switch(r3) {
                case -483022146: goto L_0x0089;
                case 65709: goto L_0x007f;
                case 67715: goto L_0x0075;
                case 70078: goto L_0x006a;
                case 2498234: goto L_0x0060;
                case 5899185: goto L_0x0056;
                case 1560992860: goto L_0x004c;
                case 1572507798: goto L_0x0042;
                case 1584505271: goto L_0x0038;
                default: goto L_0x0037;
            }     // Catch:{ all -> 0x0118 }
        L_0x0037:
            goto L_0x0092
        L_0x0038:
            java.lang.String r3 = "Generic"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 5
            goto L_0x0092
        L_0x0042:
            java.lang.String r3 = "Trillium"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 4
            goto L_0x0092
        L_0x004c:
            java.lang.String r3 = "MAVLink"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 3
            goto L_0x0092
        L_0x0056:
            java.lang.String r3 = "Indago II/III (2020.2)"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 6
            goto L_0x0092
        L_0x0060:
            java.lang.String r3 = "R80D"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 7
            goto L_0x0092
        L_0x006a:
            java.lang.String r3 = "Evo"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 8
            goto L_0x0092
        L_0x0075:
            java.lang.String r3 = "DJI"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 0
            goto L_0x0092
        L_0x007f:
            java.lang.String r3 = "BH3"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 2
            goto L_0x0092
        L_0x0089:
            java.lang.String r3 = "AV - Puma/Raven/Wasp"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0118 }
            if (r3 == 0) goto L_0x0092
            r1 = 1
        L_0x0092:
            switch(r1) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00e8;
                case 2: goto L_0x00dc;
                case 3: goto L_0x00d0;
                case 4: goto L_0x00c4;
                case 5: goto L_0x00ba;
                case 6: goto L_0x00ae;
                case 7: goto L_0x00a2;
                case 8: goto L_0x0098;
                default: goto L_0x0095;
            }     // Catch:{ all -> 0x0118 }
        L_0x0095:
            r5.platformMonitor = r2     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x0098:
            com.atakmap.android.uastool.evo.EvoMonitor r0 = new com.atakmap.android.uastool.evo.EvoMonitor     // Catch:{ all -> 0x0118 }
            android.content.Context r1 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            r0.<init>(r1)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r0     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x00a2:
            com.atakmap.android.uastool.r80d.R80dMonitor r0 = new com.atakmap.android.uastool.r80d.R80dMonitor     // Catch:{ all -> 0x0118 }
            android.content.Context r1 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            android.content.SharedPreferences r2 = sharedPrefs     // Catch:{ all -> 0x0118 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r0     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x00ae:
            com.atakmap.android.uastool.indago.IndagoMonitor r0 = new com.atakmap.android.uastool.indago.IndagoMonitor     // Catch:{ all -> 0x0118 }
            android.content.Context r1 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            android.content.SharedPreferences r2 = sharedPrefs     // Catch:{ all -> 0x0118 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r0     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x00ba:
            com.atakmap.android.uastool.generic.GenericMonitor r0 = new com.atakmap.android.uastool.generic.GenericMonitor     // Catch:{ all -> 0x0118 }
            android.content.Context r1 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            r0.<init>(r1)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r0     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x00c4:
            com.atakmap.android.uastool.trillium.TrilliumMonitor r0 = new com.atakmap.android.uastool.trillium.TrilliumMonitor     // Catch:{ all -> 0x0118 }
            android.content.Context r1 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            android.content.SharedPreferences r2 = sharedPrefs     // Catch:{ all -> 0x0118 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r0     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x00d0:
            com.atakmap.android.uastool.mavlink.MAVLinkMonitor r0 = new com.atakmap.android.uastool.mavlink.MAVLinkMonitor     // Catch:{ all -> 0x0118 }
            android.content.Context r1 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            android.content.SharedPreferences r2 = sharedPrefs     // Catch:{ all -> 0x0118 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r0     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x00dc:
            com.atakmap.android.uastool.PD100.PD100Monitor r0 = new com.atakmap.android.uastool.PD100.PD100Monitor     // Catch:{ all -> 0x0118 }
            android.content.Context r1 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            android.content.SharedPreferences r2 = sharedPrefs     // Catch:{ all -> 0x0118 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r0     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x00e8:
            com.atakmap.android.uastool.av.AvMonitor r1 = new com.atakmap.android.uastool.av.AvMonitor     // Catch:{ all -> 0x0118 }
            android.content.Context r2 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r1     // Catch:{ all -> 0x0118 }
            goto L_0x00fd
        L_0x00f2:
            com.atakmap.android.uastool.dji.DJIMonitor r0 = new com.atakmap.android.uastool.dji.DJIMonitor     // Catch:{ all -> 0x0118 }
            android.content.Context r1 = r5.pluginContext     // Catch:{ all -> 0x0118 }
            android.content.SharedPreferences r2 = sharedPrefs     // Catch:{ all -> 0x0118 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0118 }
            r5.platformMonitor = r0     // Catch:{ all -> 0x0118 }
        L_0x00fd:
            com.atakmap.android.uastool.plugin.PlatformMonitor r0 = r5.platformMonitor     // Catch:{ all -> 0x0118 }
            if (r0 != 0) goto L_0x0103
            monitor-exit(r5)
            return
        L_0x0103:
            r5.addDefaultUAS()     // Catch:{ all -> 0x0118 }
            com.atakmap.android.uastool.Reflector r0 = r5.buildReflector()     // Catch:{ all -> 0x0118 }
            r5.reflector = r0     // Catch:{ all -> 0x0118 }
            com.atakmap.android.uastool.plugin.PlatformMonitor r0 = r5.platformMonitor     // Catch:{ all -> 0x0118 }
            r0.setOnUASDetectedListener(r5)     // Catch:{ all -> 0x0118 }
            com.atakmap.android.uastool.plugin.PlatformMonitor r0 = r5.platformMonitor     // Catch:{ all -> 0x0118 }
            r0.beginMonitoring(r4)     // Catch:{ all -> 0x0118 }
        L_0x0116:
            monitor-exit(r5)
            return
        L_0x0118:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.UASToolDropDownReceiver.startPlatformMonitor():void");
    }

    private synchronized void stopPlatformMonitor() {
        PlatformMonitor platformMonitor2 = this.platformMonitor;
        if (platformMonitor2 != null) {
            platformMonitor2.endMonitoring();
            this.platformMonitor = null;
        }
    }

    private void addDefaultUAS() {
        StatusArrayList.getInstance().addDefaultUAS();
    }

    private void removeDefaultUAS() {
        StatusArrayList.getInstance().removeDefaultUAS();
        if (this.activePager != null) {
            this.quickbar.setUASItem((UASItem) null);
        }
    }

    public void onUASDetected(List<UASItem> list) {
        if (list != null) {
            UASItem defaultUasItem = StatusArrayList.getInstance().getDefaultUasItem();
            if (!list.isEmpty()) {
                UASItem uASItem = list.get(0);
                uASItem.setDefault(true);
                if (defaultUasItem != null) {
                    defaultUasItem.copy(uASItem);
                    if (!uASItem.equals(defaultUasItem) || !defaultUasItem.isConnected()) {
                        defaultUasItem.setConnected(true);
                        if ((uASItem instanceof IndagoUASItem) && (defaultUasItem instanceof IndagoUASItem)) {
                            Log.d(TAG, "Setting connection listener to default item");
                            VehicleConnection connection = ((IndagoUASItem) uASItem).getConnection();
                            IndagoUASItem indagoUASItem = (IndagoUASItem) defaultUasItem;
                            indagoUASItem.setConnection(connection);
                            connection.addMessageListener(indagoUASItem);
                        }
                        this.landingPager.gotUASConnection();
                        this.operatorPager.gotUASConnection();
                        this.observerPager.gotUASConnection();
                        startLocalCOT();
                        UASTaskStore.getInstance().gotUASConnection();
                    }
                    if (!uASItem.equals(defaultUasItem) || !defaultUasItem.isConnected()) {
                        if (uASItem.equals(defaultUasItem) && !defaultUasItem.isConnected() && FlightLogger.getInstance().isLogging()) {
                            FlightLogger.getInstance().stopLogger();
                        }
                    } else if (!FlightLogger.getInstance().isLogging()) {
                        FlightLogger.getInstance().setFlightLogEnabled(sharedPrefs.getBoolean(UtilitiesPreferenceFragment.PREF_LOG_FLIGHT_DATA, true));
                        FlightLogger.getInstance().startLogger(defaultUasItem);
                    }
                }
            } else if (defaultUasItem == null) {
                Log.d(TAG, "Missing default uas item");
            } else if (defaultUasItem.isConnected()) {
                defaultUasItem.setConnected(false);
                defaultUasItem.setUid(UASItem.NO_UID);
                this.landingPager.lostUASConnection();
                this.operatorPager.lostUASConnection();
                this.observerPager.lostUASConnection();
                stopLocalCOT();
                UASTaskStore.getInstance().lostUASConnection();
            }
        } else {
            Log.d(TAG, "Null uas list");
        }
    }

    public void showUAS(UASItem uASItem) {
        if (uASItem == null) {
            return;
        }
        if (!uASItem.isDefault()) {
            showObserver(uASItem);
        } else if (!uASItem.isConnected()) {
            toast("This default UAS is not connected yet", 0);
        } else {
            showOperator(uASItem);
        }
    }

    private Reflector buildReflector() {
        UASItem defaultUasItem = StatusArrayList.getInstance().getDefaultUasItem();
        if (defaultUasItem == null) {
            return null;
        }
        String str = defaultUasItem.PLATFORM_DETAIL_TAG;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1512533398:
                if (str.equals(AvUASItem.DETAIL_TAG)) {
                    c = 0;
                    break;
                }
                break;
            case -1497752602:
                if (str.equals(R80dUASItem.DETAIL_TAG)) {
                    c = 1;
                    break;
                }
                break;
            case -352237448:
                if (str.equals(GenericUASItem.DETAIL_TAG)) {
                    c = 2;
                    break;
                }
                break;
            case 14187786:
                if (str.equals(TrilliumUASItem.DETAIL_TAG)) {
                    c = 3;
                    break;
                }
                break;
            case 89833755:
                if (str.equals("_DJI_")) {
                    c = 4;
                    break;
                }
                break;
            case 89907008:
                if (str.equals(EvoUASItem.DETAIL_TAG)) {
                    c = 5;
                    break;
                }
                break;
            case 768142753:
                if (str.equals(PD100UASItem.DETAIL_TAG)) {
                    c = 6;
                    break;
                }
                break;
            case 1236656354:
                if (str.equals(MAVLinkUASItem.DETAIL_TAG)) {
                    c = 7;
                    break;
                }
                break;
            case 1671067510:
                if (str.equals(IndagoUASItem.DETAIL_TAG)) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AvReflector avReflector = new AvReflector(this.pluginContext, sharedPrefs, defaultUasItem);
                ((AvMonitor) this.platformMonitor).setReflector(avReflector);
                return avReflector;
            case 1:
                return new R80dReflector(this.pluginContext, sharedPrefs, defaultUasItem);
            case 2:
                return new GenericReflector(this.pluginContext, sharedPrefs, defaultUasItem);
            case 3:
                if (this.platformMonitor != null) {
                    return new TrilliumReflector(this.pluginContext, sharedPrefs, defaultUasItem);
                }
                return null;
            case 4:
                return new DJIReflector(this.pluginContext, sharedPrefs, defaultUasItem);
            case 5:
                return new EvoReflector(this.pluginContext, sharedPrefs, defaultUasItem);
            case 6:
                if (this.platformMonitor == null) {
                    return null;
                }
                PD100Reflector pD100Reflector = new PD100Reflector(this.pluginContext, sharedPrefs, defaultUasItem);
                ((PD100Monitor) this.platformMonitor).setReflector(pD100Reflector);
                return pD100Reflector;
            case 7:
                if (this.platformMonitor != null) {
                    return new MAVLinkReflector(this.pluginContext, sharedPrefs, defaultUasItem);
                }
                return null;
            case 8:
                return new IndagoReflector(this.pluginContext, sharedPrefs, defaultUasItem);
            default:
                return null;
        }
    }

    private void startLocalCOT() {
        Reflector reflector2 = this.reflector;
        if (reflector2 != null) {
            String startLocalCOT = reflector2.startLocalCOT();
            if (!TextUtils.isEmpty(startLocalCOT)) {
                toast(startLocalCOT, 0);
                return;
            }
            return;
        }
        toast("Unable to start sending local CoT - null reflector", 0);
    }

    private void stopLocalCOT() {
        Reflector reflector2 = this.reflector;
        if (reflector2 != null) {
            reflector2.stopLocalCOT();
        } else {
            Log.d(TAG, "UASDDR Unable to stop sending local CoT - null reflector");
        }
    }

    /* access modifiers changed from: private */
    public void showLanding() {
        UASToolPager uASToolPager = this.activePager;
        ObserverPager observerPager2 = this.observerPager;
        if (uASToolPager == observerPager2) {
            observerPager2.stop();
        }
        UASToolPager uASToolPager2 = this.activePager;
        OperatorPager operatorPager2 = this.operatorPager;
        if (uASToolPager2 == operatorPager2) {
            operatorPager2.stopShowing();
        }
        LandingPager landingPager2 = this.landingPager;
        this.activePager = landingPager2;
        landingPager2.setCurrentItem(0);
        this.landingView.setVisibility(0);
        this.operatorView.setVisibility(4);
        this.observerView.setVisibility(4);
        this.quickbar.setMode(Quickbar.MODE.LANDING);
        this.quickbar.setBackAsClose(true);
        this.quickbar.setUASItem((UASItem) null);
    }

    private void showOperator(UASItem uASItem) {
        OperatorPager operatorPager2 = this.operatorPager;
        this.activePager = operatorPager2;
        operatorPager2.initForShow(uASItem, this.reflector);
        this.landingView.setVisibility(4);
        this.operatorView.setVisibility(0);
        this.observerView.setVisibility(4);
        this.quickbar.setMode(Quickbar.MODE.OPERATOR);
        this.quickbar.setBackAsClose(false);
        this.quickbar.setUASItem(uASItem);
    }

    private void showObserver(UASItem uASItem) {
        ObserverPager observerPager2 = this.observerPager;
        this.activePager = observerPager2;
        observerPager2.setUASItem(uASItem);
        this.observerPager.init();
        this.landingView.setVisibility(4);
        this.operatorView.setVisibility(4);
        this.observerView.setVisibility(0);
        this.quickbar.setMode(uASItem.isGimbalControlEnabled() ? Quickbar.MODE.OBSERVER_CONTROL : Quickbar.MODE.OBSERVER);
        this.quickbar.setBackAsClose(false);
        this.quickbar.setUASItem(uASItem);
    }

    public void removeBroadcastUAS(UASItem uASItem) {
        if (this.observerView.getVisibility() == 0) {
            this.observerPager.removeBroadcastUAS(uASItem);
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (getDropDown() != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1866307870:
                    if (str.equals(UASToolPreferenceFragment.PREF_PLATFORM_DETECT)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1842490516:
                    if (str.equals(NetworkPreferenceFragment.PREF_BROADCAST_SIZE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1755444269:
                    if (str.equals(NetworkPreferenceFragment.PREF_DESTINATION_IP)) {
                        c = 2;
                        break;
                    }
                    break;
                case -508391650:
                    if (str.equals(NetworkPreferenceFragment.PREF_BROADCAST_BITRATE)) {
                        c = 3;
                        break;
                    }
                    break;
                case -240752771:
                    if (str.equals(UtilitiesPreferenceFragment.PREF_CAPTURE_TO_STORAGE)) {
                        c = 4;
                        break;
                    }
                    break;
                case 390435208:
                    if (str.equals(UASToolPreferenceFragment.PREF_CALLSIGN)) {
                        c = 5;
                        break;
                    }
                    break;
                case 876940902:
                    if (str.equals(NetworkPreferenceFragment.PREF_VIDEO_DEST_PORT_MULTICAST)) {
                        c = 6;
                        break;
                    }
                    break;
                case 940416045:
                    if (str.equals(NetworkPreferenceFragment.PREF_VIDEO_DEST_PORT)) {
                        c = 7;
                        break;
                    }
                    break;
                case 955000977:
                    if (str.equals(UtilitiesPreferenceFragment.PREF_LOG_FLIGHT_DATA)) {
                        c = 8;
                        break;
                    }
                    break;
                case 1074026004:
                    if (str.equals(NetworkPreferenceFragment.PREF_BROADCAST_PATH)) {
                        c = 9;
                        break;
                    }
                    break;
                case 1700963980:
                    if (str.equals(NetworkPreferenceFragment.PREF_DESTINATION_IP_MULTICAST)) {
                        c = 10;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    startPlatformMonitor();
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 7:
                case 9:
                case 10:
                    videoBroadcastAttributeChanged();
                    return;
                case 4:
                    PlatformMonitor platformMonitor2 = this.platformMonitor;
                    if (platformMonitor2 != null) {
                        platformMonitor2.setCaptureToStorage(sharedPrefs.getBoolean(UtilitiesPreferenceFragment.PREF_CAPTURE_TO_STORAGE, false));
                        return;
                    }
                    return;
                case 5:
                    callsignChanged(sharedPreferences.getString(str, (String) null));
                    return;
                case 8:
                    if (FlightLogger.getInstance() != null) {
                        FlightLogger.getInstance().setFlightLogEnabled(sharedPrefs.getBoolean(UtilitiesPreferenceFragment.PREF_LOG_FLIGHT_DATA, true));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void callsignChanged(String str) {
        this.landingPager.callsignChanged(str);
        this.operatorPager.callsignChanged(str);
        this.observerPager.callsignChanged(str);
    }

    public void initAndRunUASVideoMapOverlay(UASItem uASItem) {
        Thread thread = this.uasVideoMapOverlayThread;
        if (!(thread != null && thread.isAlive()) || this.uasVideoItem != uASItem) {
            destroyUASVideoOverlayRunner();
            this.uasVideoItem = uASItem;
            this.uasVideoMapOverlayThread = new Thread(new UASFOVVideoMapRenderer(uASItem));
            startUASVideoMapOverlay();
        }
    }

    private void startUASVideoMapOverlay() {
        Thread thread = this.uasVideoMapOverlayThread;
        if (thread != null) {
            thread.start();
        }
    }

    public void stopUASVideoMapOverlay() {
        try {
            Thread thread = this.uasVideoMapOverlayThread;
            if (thread != null) {
                thread.interrupt();
            }
        } catch (SecurityException unused) {
            Log.d(TAG, "Unable to stop video overlay thread - insufficient permissions");
        }
    }

    public void destroyUASVideoOverlayRunner() {
        stopUASVideoMapOverlay();
        this.uasVideoMapOverlayThread = null;
        this.uasVideoItem = null;
    }

    public boolean isUASVideoMapOverlayRunning() {
        Thread thread = this.uasVideoMapOverlayThread;
        if (thread == null) {
            return false;
        }
        return thread.isAlive();
    }

    public void onReceive(Context context, Intent intent) {
        UASTask task;
        String action = intent.getAction();
        if (action != null) {
            action.hashCode();
            char c = 65535;
            int i = 0;
            switch (action.hashCode()) {
                case -2114118613:
                    if (action.equals("com.atakmap.android.maps.toolbar.END_TOOL")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1670277271:
                    if (action.equals(ROUTE_WAYPOINT_DELETE)) {
                        c = 1;
                        break;
                    }
                    break;
                case -1539366212:
                    if (action.equals(SHOW_WAYPOINT_DETAILS)) {
                        c = 2;
                        break;
                    }
                    break;
                case -1470077402:
                    if (action.equals(EDIT_UAS_ROUTE)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1155433106:
                    if (action.equals(SHOW_UAS_LIST)) {
                        c = 4;
                        break;
                    }
                    break;
                case -59849564:
                    if (action.equals(REJECT_UAS_TASK_POINT)) {
                        c = 5;
                        break;
                    }
                    break;
                case 378045319:
                    if (action.equals(SHOW_UASTOOL)) {
                        c = 6;
                        break;
                    }
                    break;
                case 789571167:
                    if (action.equals(SELECT_UAS_OVERLAY)) {
                        c = 7;
                        break;
                    }
                    break;
                case 1371801712:
                    if (action.equals(TOGGLE_UAS_ROUTE)) {
                        c = 8;
                        break;
                    }
                    break;
                case 1947634760:
                    if (action.equals(SHOW_UAS_TASK_LIST)) {
                        c = 9;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    getMapView().post(new Runnable() {
                        public void run() {
                            DropDownManager.a().g();
                        }
                    });
                    intent.getStringExtra("routeId");
                    showDropDown(this.uasToolView);
                    return;
                case 1:
                    final String stringExtra = intent.getStringExtra(UASTask.COTDETAIL_UID);
                    ai b = this.mapView.getRootGroup().b(stringExtra);
                    if (b != null && (task = UASTaskStore.getInstance().getTask(intent.getStringExtra("route_uid"))) != null && (task instanceof RouteTask)) {
                        if (task.getState().equals(UASTask.STATE.RUNNING) || task.getState().equals(UASTask.STATE.PAUSED)) {
                            toast("Can't modify an active UAS Route", 0);
                            return;
                        }
                        final RouteTask routeTask = (RouteTask) task;
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.mapView.getContext());
                        builder.setTitle("Remove UAS Route Point");
                        builder.setMessage("Are you sure you want to remove " + b.getTitle() + "?");
                        builder.setCancelable(true);
                        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                UASPoint uASPoint;
                                PagerAdapter adapter;
                                PagerAdapter adapter2;
                                PagerAdapter adapter3;
                                UASRoute route = routeTask.getRoute();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= route.getPoints().size()) {
                                        uASPoint = null;
                                        break;
                                    } else if (route.getPoints().get(i2).getUID().equals(stringExtra)) {
                                        uASPoint = route.getPoints().get(i2);
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                if (uASPoint != null) {
                                    if (route.getPoints() == null || route.getPoints().size() <= 1) {
                                        UASToolDropDownReceiver.toast("Route must have at least 1 point", 0);
                                        return;
                                    }
                                    routeTask.hide();
                                    routeTask.removeRoutePoint(uASPoint);
                                    UASTaskStore.getInstance().saveTask(routeTask);
                                    routeTask.view((UASPoint) null, false);
                                    if (!(UASToolDropDownReceiver.this.landingPager == null || (adapter3 = UASToolDropDownReceiver.this.landingPager.getAdapter()) == null)) {
                                        for (int i3 = 0; i3 < adapter3.getCount(); i3++) {
                                            StoredTasksFragment item = UASToolDropDownReceiver.this.landingPager.getAdapter().getItem(i3);
                                            if (item instanceof StoredTasksFragment) {
                                                item.refreshList(false);
                                            }
                                        }
                                    }
                                    if (!(UASToolDropDownReceiver.this.operatorPager == null || (adapter2 = UASToolDropDownReceiver.this.operatorPager.getAdapter()) == null)) {
                                        for (int i4 = 0; i4 < adapter2.getCount(); i4++) {
                                            StoredTasksFragment item2 = UASToolDropDownReceiver.this.operatorPager.getAdapter().getItem(i4);
                                            if (item2 instanceof StoredTasksFragment) {
                                                item2.refreshList(false);
                                            }
                                        }
                                    }
                                    if (UASToolDropDownReceiver.this.observerPager != null && (adapter = UASToolDropDownReceiver.this.observerPager.getAdapter()) != null) {
                                        for (int i5 = 0; i5 < adapter.getCount(); i5++) {
                                            StoredTasksFragment item3 = UASToolDropDownReceiver.this.observerPager.getAdapter().getItem(i5);
                                            if (item3 instanceof StoredTasksFragment) {
                                                item3.refreshList(false);
                                            }
                                        }
                                    }
                                }
                            }
                        });
                        builder.create().show();
                        return;
                    }
                    return;
                case 2:
                    try {
                        if (this.observerView.getVisibility() == 0) {
                            if (!this.observerPager.onBackPressed()) {
                                showLanding();
                            }
                        } else if (this.operatorView.getVisibility() == 0 && !this.operatorPager.onBackPressed()) {
                            showLanding();
                        }
                        PagerAdapter adapter = this.landingPager.getAdapter();
                        if (adapter != null) {
                            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                                StoredTasksFragment item = this.landingPager.getAdapter().getItem(i2);
                                if (item instanceof StoredTasksFragment) {
                                    if (!isVisible()) {
                                        this.turnToOnOpen = i2;
                                        showDropDown(this.uasToolView);
                                    } else {
                                        this.landingPager.setCurrentItem(i2);
                                    }
                                    item.editPoint(intent.getStringExtra(UASTask.COTDETAIL_UID));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        toast("Error showing UAS Tool.", 0);
                        return;
                    }
                case 3:
                    try {
                        if (this.observerView.getVisibility() == 0) {
                            if (!this.observerPager.onBackPressed()) {
                                showLanding();
                            }
                        } else if (this.operatorView.getVisibility() == 0 && !this.operatorPager.onBackPressed()) {
                            showLanding();
                        }
                        PagerAdapter adapter2 = this.landingPager.getAdapter();
                        if (adapter2 != null) {
                            for (int i3 = 0; i3 < adapter2.getCount(); i3++) {
                                StoredTasksFragment item2 = this.landingPager.getAdapter().getItem(i3);
                                if (item2 instanceof StoredTasksFragment) {
                                    if (!isVisible()) {
                                        this.turnToOnOpen = i3;
                                        showDropDown(this.uasToolView);
                                    } else {
                                        this.landingPager.setCurrentItem(i3);
                                    }
                                    item2.editTask(intent.getStringExtra(UASTask.COTDETAIL_UID));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Exception unused2) {
                        toast("Error showing UAS Tool.", 0);
                        return;
                    }
                case 4:
                    if (isVisible()) {
                        toast("UAS Tool is already open", 0);
                        return;
                    }
                    try {
                        showDropDown(this.uasToolView);
                        showLanding();
                        return;
                    } catch (Exception unused3) {
                        toast("Error showing UAS Tool.", 0);
                        return;
                    }
                case 5:
                    intent.getStringExtra(UASTask.COTDETAIL_UID);
                    return;
                case 6:
                    showDropDown(this.uasToolView);
                    return;
                case 7:
                    try {
                        if (!this.uasToolView.isShown()) {
                            showDropDown(this.uasToolView);
                        }
                        showOverlaysScreen(findUASItem(intent.getStringExtra(UASTask.COTDETAIL_UID)));
                        return;
                    } catch (Exception unused4) {
                        toast("Error showing Overlays screen.", 0);
                        return;
                    }
                case 8:
                    UASItem findUASItem = findUASItem(intent.getStringExtra(UASTask.COTDETAIL_UID));
                    if (UASItem.checkCapability(findUASItem, findUASItem.getPlatformType(), UASItemCapabilities.CAPABILITY_ROUTE_OVERLAY_SHOW).booleanValue()) {
                        getInstance();
                        SharedPreferences.Editor edit = getSharedPrefs().edit();
                        try {
                            if (findUASItem.isRouteShowing()) {
                                findUASItem.hideRoute();
                                edit.putBoolean(UASToolPreferenceFragment.ROUTES_WAYPOINTS_OVERLAY, false);
                                findUASItem.getMarker().setMetaBoolean("cRouteVisible", false);
                            } else {
                                findUASItem.showRoute();
                                edit.putBoolean(UASToolPreferenceFragment.ROUTES_WAYPOINTS_OVERLAY, true);
                                findUASItem.getMarker().setMetaBoolean("cRouteVisible", true);
                            }
                        } catch (Exception e) {
                            toast(e.getMessage(), 0);
                        }
                        edit.apply();
                        return;
                    }
                    return;
                case 9:
                    break;
                default:
                    return;
            }
            while (i < this.landingPager.getAdapter().getCount()) {
                if (!(this.landingPager.getAdapter().getItem(i) instanceof StoredTasksFragment)) {
                    i++;
                } else if (!isVisible()) {
                    this.turnToOnOpen = i;
                    showDropDown(this.uasToolView);
                    return;
                } else {
                    this.landingPager.setCurrentItem(i);
                    return;
                }
            }
        }
    }

    public void refreshStoredTaskView() {
        MapView.getMapView().post(new Runnable() {
            public void run() {
                UASToolDropDownReceiver.this.landingPager.refreshStoredTasks();
            }
        });
    }

    private void showDropDown(View view) {
        showDropDown(view, 0.5d, 1.0d, 1.0d, 1.0d, false, false, this);
        setRetain(true);
        this.uasToolView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                UASToolDropDownReceiver.this.quickbar.init();
                UASToolDropDownReceiver.this.showLanding();
                if (UASToolDropDownReceiver.this.turnToOnOpen >= 0) {
                    UASToolDropDownReceiver.this.landingPager.setCurrentItem(UASToolDropDownReceiver.this.turnToOnOpen);
                    int unused = UASToolDropDownReceiver.this.turnToOnOpen = -1;
                }
                UASToolDropDownReceiver.this.startPlatformMonitor();
                UASToolDropDownReceiver.this.uasToolView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        setAssociationKey(UASToolPreferencesComponent.ASSOCIATION_KEY);
    }

    /* renamed from: a */
    public void mo7788a(boolean z) {
        UASToolPager uASToolPager = this.activePager;
        OperatorPager operatorPager2 = this.operatorPager;
        if (uASToolPager == operatorPager2) {
            operatorPager2.onDropDownVisible(z);
            if (z) {
                this.quickbar.setUASItem(this.operatorPager.getUASItem());
                return;
            }
            return;
        }
        ObserverPager observerPager2 = this.observerPager;
        if (uASToolPager == observerPager2) {
            observerPager2.onDropDownVisible(z);
            if (z) {
                this.quickbar.setUASItem(this.observerPager.getUASItem());
            }
        }
    }

    /* renamed from: d */
    public void mo7795d() {
        Log.d(TAG, "onDropDownClose()");
    }

    /* access modifiers changed from: private */
    public void shutdownServices() {
        stopUASVideoMapOverlay();
        destroyUASVideoOverlayRunner();
        stopLocalCOT();
        stopPlatformMonitor();
        StatusArrayList.getInstance().destroy();
        stopEncoder();
        setPreviewEnabled(false);
        Reflector reflector2 = this.reflector;
        if (reflector2 != null) {
            reflector2.stopPreview();
            this.reflector.destroy();
        }
        this.reflector = null;
        ArOverlayView operatorArOverlay = getOperatorArOverlay();
        if (operatorArOverlay != null) {
            operatorArOverlay.setUASItem((UASItem) null);
        }
        ArOverlayView observerArOverlay = getObserverArOverlay();
        if (observerArOverlay != null) {
            observerArOverlay.setUASItem((UASItem) null);
        }
        if (FlightLogger.getInstance().isLogging()) {
            FlightLogger.getInstance().stopLogger();
        }
        UASTaskStore.getInstance().resetTasks();
    }

    /* access modifiers changed from: protected */
    public void disposeImpl() {
        SharedPreferences sharedPreferences = sharedPrefs;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        }
        MapMenuReceiver.a().b(this.mapShotRadialMenuFactory);
        AtakBroadcast.a().a(this.mapShotController);
        shutdownServices();
        removeOnMapEventListener(this.mapShotController, "item_added");
        removeOnMapEventListener(this.mapShotController, "item_removed");
        this.mapListener.removeOnMapEventListener(this, "item_added");
        this.mapListener.removeOnMapEventListener(this, "item_persist");
        this.mapListener.removeOnMapEventListener(this, "item_refresh");
        this.offscreenDirector.d();
        ToolManagerBroadcastReceiver.a().a(QuickTaskTool.TOOL_NAME);
        LandingPager landingPager2 = this.landingPager;
        if (landingPager2 != null) {
            landingPager2.dispose();
        }
        OperatorPager operatorPager2 = this.operatorPager;
        if (operatorPager2 != null) {
            operatorPager2.dispose();
        }
        ObserverPager observerPager2 = this.observerPager;
        if (observerPager2 != null) {
            observerPager2.dispose();
        }
        Quickbar quickbar2 = this.quickbar;
        if (quickbar2 != null) {
            quickbar2.dispose();
        }
        CommsMapComponent.c().b(this);
    }

    /* renamed from: c */
    public void mo7793c() {
        Log.d(TAG, "onDropDownSelectionRemoved()");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (isPortrait() != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        if (r3.isFullscreenVideo != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        if (java.lang.Double.compare(r4, 1.0d) != 0) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        r3.isFullscreenVideo = true;
        r3.activePager.resizeFull();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r3.isFullscreenVideo == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (java.lang.Double.compare(r4, 0.5d) != 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r3.isFullscreenVideo = false;
        r3.activePager.resizeHalf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r3.isFullscreenVideo = false;
        r3.activePager.resizeHalf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        r4 = r3.quickbar;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004f, code lost:
        r4.updateUI();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7786a(double r4, double r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            double r0 = r3.currWidth     // Catch:{ all -> 0x0053 }
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x000f
            double r0 = r3.currHeight     // Catch:{ all -> 0x0053 }
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x000f
            monitor-exit(r3)     // Catch:{ all -> 0x0053 }
            return
        L_0x000f:
            r3.currWidth = r4     // Catch:{ all -> 0x0053 }
            r3.currHeight = r6     // Catch:{ all -> 0x0053 }
            monitor-exit(r3)     // Catch:{ all -> 0x0053 }
            boolean r6 = r3.isPortrait()
            r7 = 0
            if (r6 != 0) goto L_0x0044
            boolean r6 = r3.isFullscreenVideo
            if (r6 != 0) goto L_0x0030
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = java.lang.Double.compare(r4, r0)
            if (r6 != 0) goto L_0x0030
            r4 = 1
            r3.isFullscreenVideo = r4
            com.atakmap.android.uastool.pagers.UASToolPager r4 = r3.activePager
            r4.resizeFull()
            goto L_0x004b
        L_0x0030:
            boolean r6 = r3.isFullscreenVideo
            if (r6 == 0) goto L_0x004b
            r0 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r4 = java.lang.Double.compare(r4, r0)
            if (r4 != 0) goto L_0x004b
            r3.isFullscreenVideo = r7
            com.atakmap.android.uastool.pagers.UASToolPager r4 = r3.activePager
            r4.resizeHalf()
            goto L_0x004b
        L_0x0044:
            r3.isFullscreenVideo = r7
            com.atakmap.android.uastool.pagers.UASToolPager r4 = r3.activePager
            r4.resizeHalf()
        L_0x004b:
            com.atakmap.android.uastool.quickbar.Quickbar r4 = r3.quickbar
            if (r4 == 0) goto L_0x0052
            r4.updateUI()
        L_0x0052:
            return
        L_0x0053:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0053 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.UASToolDropDownReceiver.mo7786a(double, double):void");
    }

    /* access modifiers changed from: protected */
    public void onStateRequested(int i) {
        UASToolDropDownReceiver.super.onStateRequested(i);
    }

    public static void toast(final String str, final int i) {
        new Exception("bad toast");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    UASToolDropDownReceiver.logToast(str);
                    Toast.makeText(MapView.getMapView().getContext(), str, i).show();
                } catch (Exception e) {
                    Log.e(UASToolDropDownReceiver.TAG, "bad toast attempt", e);
                }
            }
        });
        FlightLogger.getInstance().writeMessageLog(str);
    }

    public static void toast(String str) {
        toast(str, 0);
    }

    /* access modifiers changed from: private */
    public static void logToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            ToastLogItem toastLogItem = new ToastLogItem(System.currentTimeMillis(), str);
            ArrayList<ToastLogItem> arrayList = toastLogList;
            synchronized (arrayList) {
                if (arrayList.size() >= 100) {
                    arrayList.remove(0);
                }
                arrayList.add(toastLogItem);
            }
            return;
        }
        Log.d(TAG, "Unable to save null/empty toast message");
    }

    public static List<ToastLogItem> getToastLog() {
        ArrayList arrayList;
        ArrayList<ToastLogItem> arrayList2 = toastLogList;
        synchronized (arrayList2) {
            arrayList = new ArrayList(arrayList2);
        }
        return arrayList;
    }

    public void helpPopup(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mapView.getContext());
        builder.setTitle("Help - " + str);
        builder.setMessage(str2);
        builder.setCancelable(true);
        builder.setNeutralButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    private void askToCloseWhileBroadcasting() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mapView.getContext());
        builder.setTitle("Broadcasting");
        builder.setMessage("Closing UAS Tool while broadcasting will stop the broadcast." + "\n\nContinue closing?");
        builder.setPositiveButton("Yes, Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UASToolDropDownReceiver.this.closeDropDown();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void askToCloseWhileControlling() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mapView.getContext());
        builder.setTitle("Controlling");
        builder.setMessage("Closing UAS Tool while controlling a broadcasting UAS will stop the control." + "\n\nContinue closing?");
        builder.setPositiveButton("Yes, Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UASToolDropDownReceiver.this.closeDropDown();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    public void askToClose() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mapView.getContext());
        builder.setTitle("Close UASTool");
        builder.setMessage("Closing UASTool might cause unexpected behavior if your UAS is flying." + "\n\nContinue closing?");
        builder.setPositiveButton("Shut Down UASTool", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UASToolDropDownReceiver.this.shutdownServices();
                UASToolDropDownReceiver.this.closeDropDown();
            }
        });
        builder.setNeutralButton("Run in background", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UASToolDropDownReceiver.this.closeDropDown();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void askToCloseWhileTasking() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mapView.getContext());
        builder.setTitle("Running Task");
        builder.setMessage("Closing UAS Tool while running a task may have unforeseen consequences." + "\n\nContinue closing?");
        builder.setPositiveButton("Close Now", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UASToolDropDownReceiver.this.closeDropDown();
            }
        });
        builder.setNeutralButton("Stop Task & Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                UASTaskStore.getInstance().stopRunningTasks();
                UASToolDropDownReceiver.this.closeDropDown();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    public void dismissFullscreen() {
        if (this.operatorView.getVisibility() == 0) {
            this.operatorPager.onBackPressed();
        }
        if (this.observerView.getVisibility() == 0) {
            this.observerPager.onBackPressed();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onBackButtonPressed() {
        /*
            r2 = this;
            android.view.ViewGroup r0 = r2.observerView
            int r0 = r0.getVisibility()
            r1 = 1
            if (r0 != 0) goto L_0x0016
            com.atakmap.android.uastool.pagers.observer.ObserverPager r0 = r2.observerPager
            boolean r0 = r0.onBackPressed()
            if (r0 != 0) goto L_0x0014
            r2.showLanding()
        L_0x0014:
            r0 = 1
            goto L_0x0030
        L_0x0016:
            android.view.ViewGroup r0 = r2.operatorView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x002a
            com.atakmap.android.uastool.pagers.operator.OperatorPager r0 = r2.operatorPager
            boolean r0 = r0.onBackPressed()
            if (r0 != 0) goto L_0x0014
            r2.showLanding()
            goto L_0x0014
        L_0x002a:
            com.atakmap.android.uastool.pagers.LandingPager r0 = r2.landingPager
            boolean r0 = r0.onBackPressed()
        L_0x0030:
            if (r0 != 0) goto L_0x0056
            com.atakmap.android.uastool.Reflector r0 = r2.reflector
            if (r0 == 0) goto L_0x0040
            boolean r0 = r0.isBroadcasting()
            if (r0 == 0) goto L_0x0040
            r2.askToCloseWhileBroadcasting()
            goto L_0x0057
        L_0x0040:
            com.atakmap.android.uastool.tasks.UASTaskStore r0 = com.atakmap.android.uastool.tasks.UASTaskStore.getInstance()
            java.util.ArrayList r0 = r0.getRunningTasks()
            if (r0 == 0) goto L_0x0054
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0054
            r2.askToCloseWhileTasking()
            goto L_0x0057
        L_0x0054:
            r1 = 0
            goto L_0x0057
        L_0x0056:
            r1 = r0
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.UASToolDropDownReceiver.onBackButtonPressed():boolean");
    }

    public OperatorPager getOperatorPager() {
        return this.operatorPager;
    }

    public ObserverPager getObserverPager() {
        return this.observerPager;
    }

    public void toggleBroadcast() {
        UASToolPager uASToolPager = this.activePager;
        OperatorPager operatorPager2 = this.operatorPager;
        if (uASToolPager == operatorPager2) {
            OperatorControlFragment operatorControlFragment = operatorPager2.getOperatorControlFragment();
            if (operatorControlFragment != null) {
                Reflector reflector2 = this.reflector;
                if (reflector2 == null) {
                    Log.w(TAG, "Unable to toggle broadcast: reflector is null");
                } else if (reflector2.isBroadcasting()) {
                    operatorControlFragment.stopBroadcast();
                } else {
                    operatorControlFragment.startBroadcast();
                }
            } else {
                Log.w(TAG, "Unable to toggle broadcast: operator control fragment is null");
            }
        } else {
            Log.w(TAG, "Unable to toggle broadcast: operator pager is not active");
        }
    }

    public static Reflector getReflector() {
        if (getInstance() == null) {
            return null;
        }
        return getInstance().reflector;
    }

    public static String sanitizeForWinTAK(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.trim().replaceAll(":", "-");
    }

    public static String getPicSavePath(String str, String str2) {
        File item = FileSystemUtils.getItem("attachments/" + str2);
        if (!item.exists() && !item.mkdir()) {
            Log.d(TAG, "Unable to make the attachment directory");
        }
        return new File(item, sanitizeForWinTAK("UASTool_" + str + "_" + getDateTime() + ".jpg")).toString();
    }

    /* access modifiers changed from: private */
    public View getATAKView() {
        return this.mapView.getRootView();
    }

    public void screenshotSelected(final UASItem uASItem) {
        new Handler().post(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
                r4 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
                if (r2 != null) goto L_0x0038;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                r5.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
                r5.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
                throw r4;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "UASToolDropDownReceiver"
                    r1 = 0
                    com.atakmap.android.uastool.UASToolDropDownReceiver r2 = com.atakmap.android.uastool.UASToolDropDownReceiver.this     // Catch:{ all -> 0x0082 }
                    android.view.View r2 = r2.getATAKView()     // Catch:{ all -> 0x0082 }
                    android.graphics.Bitmap r2 = com.atakmap.android.uastool.UASToolDropDownReceiver.loadBitmapFromView(r2)     // Catch:{ all -> 0x0082 }
                    java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0082 }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0082 }
                    java.lang.String r4 = "ss"
                    java.lang.String r3 = com.atakmap.android.uastool.UASToolDropDownReceiver.getPicSavePath(r4, r3)     // Catch:{ all -> 0x0082 }
                    java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0082 }
                    r4.<init>(r3)     // Catch:{ all -> 0x0082 }
                    java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0045 }
                    r5.<init>(r4)     // Catch:{ Exception -> 0x0045 }
                    android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0033 }
                    r6 = 90
                    r2.compress(r4, r6, r5)     // Catch:{ all -> 0x0033 }
                    r5.flush()     // Catch:{ all -> 0x0033 }
                    r5.close()     // Catch:{ Exception -> 0x0045 }
                    goto L_0x004b
                L_0x0033:
                    r2 = move-exception
                    throw r2     // Catch:{ all -> 0x0035 }
                L_0x0035:
                    r4 = move-exception
                    if (r2 == 0) goto L_0x0041
                    r5.close()     // Catch:{ all -> 0x003c }
                    goto L_0x0044
                L_0x003c:
                    r5 = move-exception
                    r2.addSuppressed(r5)     // Catch:{ Exception -> 0x0045 }
                    goto L_0x0044
                L_0x0041:
                    r5.close()     // Catch:{ Exception -> 0x0045 }
                L_0x0044:
                    throw r4     // Catch:{ Exception -> 0x0045 }
                L_0x0045:
                    r2 = move-exception
                    java.lang.String r4 = "error writing file"
                    com.atakmap.coremap.log.Log.e(r0, r4, r2)     // Catch:{ all -> 0x0082 }
                L_0x004b:
                    com.atakmap.android.uastool.UASItem r2 = r3     // Catch:{ all -> 0x0082 }
                    java.lang.String r2 = com.atakmap.android.uastool.UASToolDropDownReceiver.addEXIFData(r3, r2)     // Catch:{ all -> 0x0082 }
                    boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0082 }
                    if (r4 == 0) goto L_0x006d
                    com.atakmap.android.uastool.UASToolDropDownReceiver r2 = com.atakmap.android.uastool.UASToolDropDownReceiver.this     // Catch:{ all -> 0x0082 }
                    com.atakmap.android.uastool.UASItem r4 = r3     // Catch:{ all -> 0x0082 }
                    boolean r2 = r2.dropMarker(r3, r4)     // Catch:{ all -> 0x0082 }
                    if (r2 == 0) goto L_0x0067
                    java.lang.String r2 = "Screenshot success!"
                    com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r2, r1)     // Catch:{ all -> 0x0082 }
                    goto L_0x00a0
                L_0x0067:
                    java.lang.String r2 = "Screenshot failed to drop map marker."
                    com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r2, r1)     // Catch:{ all -> 0x0082 }
                    goto L_0x00a0
                L_0x006d:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
                    r3.<init>()     // Catch:{ all -> 0x0082 }
                    java.lang.String r4 = "Screenshot failed to write EXIF data: "
                    r3.append(r4)     // Catch:{ all -> 0x0082 }
                    r3.append(r2)     // Catch:{ all -> 0x0082 }
                    java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0082 }
                    com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r2, r1)     // Catch:{ all -> 0x0082 }
                    goto L_0x00a0
                L_0x0082:
                    r2 = move-exception
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Screenshot failed: "
                    r3.append(r4)
                    java.lang.String r4 = r2.getLocalizedMessage()
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    com.atakmap.android.uastool.UASToolDropDownReceiver.toast(r3, r1)
                    java.lang.String r1 = "error occured"
                    com.atakmap.coremap.log.Log.e(r0, r1, r2)
                L_0x00a0:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.UASToolDropDownReceiver.C118019.run():void");
            }
        });
    }

    public static Bitmap loadBitmapFromView(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(0, 0, view.getWidth(), view.getHeight());
        view.draw(canvas);
        return createBitmap;
    }

    public void mapshotSelected(UASItem uASItem, ControlFragment controlFragment) {
        int parseInt = Utils.parseInt(sharedPrefs.getString(CameraPreferenceFragment.PREF_CAMERA_MAPSHOT_SAVE_MODE, Integer.toString(3)), 3);
        final boolean z = parseInt == 0 || parseInt == 1;
        final boolean z2 = parseInt == 0 || parseInt == 2;
        if (!z && !z2 && (controlFragment instanceof OperatorControlFragment)) {
            GLVideoConsumer gLVideoConsumer = null;
            try {
                if (getReflector() != null) {
                    gLVideoConsumer = new GLVideoConsumer(getInstance().getOffscreenDirector().b(), getReflector().usesYUVTexture());
                } else {
                    gLVideoConsumer = new GLVideoConsumer(getInstance().getOffscreenDirector().b(), false);
                }
            } catch (agl e) {
                Log.e(TAG, "VideoConsumer init failed", e);
            }
            if (gLVideoConsumer != null) {
                try {
                    gLVideoConsumer.start();
                    getInstance().getOffscreenDirector().a(gLVideoConsumer);
                } catch (GLVideoConsumer.VideoConsumerException e2) {
                    Log.e(TAG, "VideoConsumer start failed", e2);
                }
                if (gLVideoConsumer != null) {
                    gLVideoConsumer.addBitmapUpdateListener(new GLVideoConsumer.BitmapUpdateListener(gLVideoConsumer, uASItem) {
                        private static final String TAG = "BitmapUpdateListener";
                        private static final String _debugMsg = "GLVideoConsumer released, listener removed and subordinate removed from offscreen director";
                        private final GLVideoConsumer consumer;
                        private volatile boolean gotFrame = false;
                        private final Lock lock = new ReentrantLock();
                        final /* synthetic */ GLVideoConsumer val$finalImageMonitor;
                        final /* synthetic */ UASItem val$uasItem;

                        {
                            this.val$finalImageMonitor = r2;
                            this.val$uasItem = r3;
                            this.consumer = r2;
                        }

                        public void onBitmapUpdate(final Bitmap bitmap) {
                            if (this.lock.tryLock()) {
                                try {
                                    if (!this.gotFrame) {
                                        MapView.getMapView().postDelayed(new Runnable() {
                                            public void run() {
                                                UASToolDropDownReceiver.this.dropMapshotMarker(C118220.this.val$uasItem, bitmap);
                                            }
                                        }, 1000);
                                    }
                                } finally {
                                    if (!this.gotFrame) {
                                        this.consumer.removeBitmapUpdateListener(this);
                                        this.gotFrame = true;
                                    }
                                    this.lock.unlock();
                                }
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void finalize() {
                            super.finalize();
                            this.consumer.stop();
                            UASToolDropDownReceiver.getInstance().getOffscreenDirector().b(this.consumer);
                            Log.d(TAG, _debugMsg);
                        }
                    });
                } else {
                    toast("Mapshot Failed!");
                }
            } else {
                throw new GLVideoConsumer.VideoConsumerException("Consumer init failed");
            }
        } else if (controlFragment == null || !controlFragment.previewSnapshotReady()) {
            toast("Mapshot Failed!");
        } else {
            final ControlFragment controlFragment2 = controlFragment;
            final UASItem uASItem2 = uASItem;
            MapView.getMapView().postDelayed(new Runnable() {
                public void run() {
                    Bitmap previewSnapshot = controlFragment2.getPreviewSnapshot(z, z2);
                    if (previewSnapshot != null) {
                        UASToolDropDownReceiver.this.dropMapshotMarker(uASItem2, previewSnapshot);
                    } else {
                        UASToolDropDownReceiver.toast("Unable to take mapshot: No video?");
                    }
                }
            }, 1000);
        }
    }

    public static void mapshotSelected(UASItem uASItem) {
        getInstance().mapshotSelected(uASItem, getControlFragment());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r2 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dropMapshotMarker(com.atakmap.android.uastool.UASItem r7, android.graphics.Bitmap r8) {
        /*
            r6 = this;
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "map"
            java.lang.String r1 = getPicSavePath(r1, r0)     // Catch:{ all -> 0x0093 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0093 }
            r2.<init>(r1)     // Catch:{ all -> 0x0093 }
            r3 = 1
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0039 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0039 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0027 }
            r5 = 90
            r8.compress(r2, r5, r4)     // Catch:{ all -> 0x0027 }
            r4.flush()     // Catch:{ all -> 0x0027 }
            r4.close()     // Catch:{ Exception -> 0x0039 }
            goto L_0x0059
        L_0x0027:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r5 = move-exception
            if (r2 == 0) goto L_0x0035
            r4.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0038
        L_0x0030:
            r4 = move-exception
            r2.addSuppressed(r4)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0038
        L_0x0035:
            r4.close()     // Catch:{ Exception -> 0x0039 }
        L_0x0038:
            throw r5     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r4.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r5 = "Mapshot failed: "
            r4.append(r5)     // Catch:{ all -> 0x0093 }
            java.lang.String r5 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0093 }
            r4.append(r5)     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0093 }
            toast(r4, r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = "UASToolDropDownReceiver"
            java.lang.String r5 = "Mapshot Error: "
            com.atakmap.coremap.log.Log.d(r4, r5, r2)     // Catch:{ all -> 0x0093 }
        L_0x0059:
            java.lang.String r2 = addEXIFData(r1, r7)     // Catch:{ all -> 0x0093 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0093 }
            if (r4 == 0) goto L_0x0079
            boolean r7 = r6.dropMarker(r0, r7)     // Catch:{ all -> 0x0093 }
            if (r7 == 0) goto L_0x0073
            java.lang.String r7 = "Mapshot success!"
            r0 = 0
            toast(r7, r0)     // Catch:{ all -> 0x0093 }
            r6.saveImageOnSDCard(r1)     // Catch:{ all -> 0x0093 }
            goto L_0x008d
        L_0x0073:
            java.lang.String r7 = "Mapshot failed to drop map marker."
            toast(r7, r3)     // Catch:{ all -> 0x0093 }
            goto L_0x008d
        L_0x0079:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r7.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = "Mapshot failed to write EXIF data: "
            r7.append(r0)     // Catch:{ all -> 0x0093 }
            r7.append(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0093 }
            toast(r7, r3)     // Catch:{ all -> 0x0093 }
        L_0x008d:
            if (r8 == 0) goto L_0x0092
            r8.recycle()
        L_0x0092:
            return
        L_0x0093:
            r7 = move-exception
            if (r8 == 0) goto L_0x0099
            r8.recycle()
        L_0x0099:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.UASToolDropDownReceiver.dropMapshotMarker(com.atakmap.android.uastool.UASItem, android.graphics.Bitmap):void");
    }

    public void camerashotSelected(UASItem uASItem) {
        if (!uASItem.isConnected()) {
            toast("Camera shot only for operators");
            return;
        }
        try {
            String uid = uASItem.getUid();
            String uuid = UUID.randomUUID().toString();
            String picSavePath = getPicSavePath("cam", uuid);
            if (uASItem.PLATFORM_DETAIL_TAG.equals("_DJI_")) {
                getPicPoint(uASItem);
                String str = Environment.getExternalStorageDirectory().toString() + "/atak/attachments/" + uuid + "/";
                FileObserver fileObserver2 = this.fileObserver;
                if (fileObserver2 != null) {
                    fileObserver2.stopWatching();
                    this.fileObserver = null;
                }
                final String str2 = picSavePath;
                final UASItem uASItem2 = uASItem;
                final String str3 = uuid;
                C118522 r4 = new FileObserver(str) {
                    public void onEvent(int i, String str) {
                        if (i == 128) {
                            UASToolDropDownReceiver.this.fileObserver.stopWatching();
                            String addEXIFData = UASToolDropDownReceiver.addEXIFData(str2, uASItem2);
                            if (!TextUtils.isEmpty(addEXIFData)) {
                                UASToolDropDownReceiver.toast("Camerashot failed to write EXIF data: " + addEXIFData, 1);
                            } else if (UASToolDropDownReceiver.this.dropMarker(str3, uASItem2)) {
                                UASToolDropDownReceiver.this.saveImageOnSDCard(str2);
                            } else {
                                UASToolDropDownReceiver.toast("Camerashot failed to drop map marker.", 1);
                            }
                        }
                    }
                };
                this.fileObserver = r4;
                r4.startWatching();
            }
            String takePicture = takePicture(uid, uuid, picSavePath);
            if (takePicture != null) {
                toast("Camerashot failed: " + takePicture, 1);
            }
        } catch (Throwable th) {
            toast("Camerashot failed: " + th.getLocalizedMessage(), 1);
            Log.e(TAG, "error occured", th);
        }
    }

    private String takePicture(String str, String str2, String str3) {
        Reflector reflector2 = this.reflector;
        return reflector2 != null ? reflector2.takePicture(str, str2, str3) : "Unable to take picture: Reflector is null.";
    }

    private static GeoPoint getPicPoint(UASItem uASItem) {
        return uASItem.getGeoPoint();
    }

    public static String addEXIFData(String str, UASItem uASItem) {
        if (uASItem != null) {
            GeoPoint picPoint = getPicPoint(uASItem);
            if (picPoint != null) {
                try {
                    String str2 = str;
                    ExifInterface exifInterface = new ExifInterface(str);
                    exifInterface.setAttribute(CameraParamsConfig.param_DateTime, getDateTime());
                    exifInterface.setAttribute("Make", "UAS Tool");
                    String string = sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, "");
                    if (TextUtils.isEmpty(string)) {
                        string = uASItem.getCallsign();
                    }
                    exifInterface.setAttribute("Model", string);
                    exifInterface.setAttribute("GPSAltitude", new Rational((int) EGM96.getMSL(picPoint), 1).toString());
                    exifInterface.setAttribute("GPSAltitudeRef", "0");
                    double latitude = picPoint.getLatitude();
                    String[] split = Location.convert(Math.abs(latitude), 2).split(":");
                    Rational rational = new Rational(Integer.parseInt(split[0]), 1);
                    Rational rational2 = new Rational(Integer.parseInt(split[1]), 1);
                    Pair<Integer, Integer> calculateRational = calculateRational(Double.parseDouble(split[2]));
                    Rational rational3 = new Rational(((Integer) calculateRational.first).intValue(), ((Integer) calculateRational.second).intValue());
                    exifInterface.setAttribute("GPSLatitude", rational.toString() + "," + rational2.toString() + "," + rational3.toString());
                    exifInterface.setAttribute("GPSLatitudeRef", latitude > 0.0d ? "N" : "S");
                    double longitude = picPoint.getLongitude();
                    String[] split2 = Location.convert(Math.abs(longitude), 2).split(":");
                    Rational rational4 = new Rational(Integer.parseInt(split2[0]), 1);
                    Rational rational5 = new Rational(Integer.parseInt(split2[1]), 1);
                    Pair<Integer, Integer> calculateRational2 = calculateRational(Double.parseDouble(split2[2]));
                    Rational rational6 = new Rational(((Integer) calculateRational2.first).intValue(), ((Integer) calculateRational2.second).intValue());
                    exifInterface.setAttribute("GPSLongitude", rational4.toString() + "," + rational5.toString() + "," + rational6.toString());
                    exifInterface.setAttribute("GPSLongitudeRef", longitude > 0.0d ? "E" : "W");
                    exifInterface.setAttribute("GPSImgDirection", new Rational((int) uASItem.getGimbalAngle(), 1).toString());
                    exifInterface.setAttribute("GPSImgDirectionRef", "M");
                    GeomagneticField geomagneticField = new GeomagneticField((float) picPoint.getLatitude(), (float) picPoint.getLongitude(), (float) EGM96.getMSL(picPoint), CoordinatedTime.currentDate().getTime());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(UASToolConstants.IMAGE_PITCH_EXIF, uASItem.getGimbalPitch());
                    jSONObject.put(UASToolConstants.IMAGE_ROLL_EXIF, uASItem.getGimbalRoll());
                    jSONObject.put(UASToolConstants.HORIZONTAL_FOV_EXIF, uASItem.getHFOV());
                    jSONObject.put(UASToolConstants.VERTICAL_FOV_EXIF, uASItem.getVFOV());
                    jSONObject.put(UASToolConstants.INCLINATION_EXIF, geomagneticField.getInclination());
                    exifInterface.setAttribute("UserComment", jSONObject.toString());
                    exifInterface.saveAttributes();
                    return null;
                } catch (Exception e) {
                    Log.d(TAG, "EXCEPTION in addEXIFData(): ", e);
                    return e.getLocalizedMessage();
                }
            } else {
                Log.d(TAG, "Null SPoI in addEXIFData()");
                return "Null SPoI adding EXIF data";
            }
        } else {
            Log.d(TAG, "Null UASItem in addEXIFData()");
            return "Null UASItem adding EXIF data";
        }
    }

    private static Pair<Integer, Integer> calculateRational(double d) {
        int i = 1;
        do {
            i *= 10;
        } while ((((double) i) * d) % 10.0d != 0.0d);
        int i2 = i / 10;
        return new Pair<>(Integer.valueOf((int) (d * ((double) i2))), Integer.valueOf(i2));
    }

    private boolean fixBadDJIAltitudeEXIF(String str, GeoPoint geoPoint, UASItem uASItem) {
        if (geoPoint != null) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                exifInterface.setAttribute(CameraParamsConfig.param_DateTime, getDateTime());
                exifInterface.setAttribute("Make", "UAS Tool");
                String string = sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, "");
                if (TextUtils.isEmpty(string)) {
                    string = uASItem.getCallsign();
                }
                exifInterface.setAttribute("Model", string);
                exifInterface.setAttribute("GPSAltitudeRef", "0");
                exifInterface.setAttribute("GPSAltitude", EGM96.getMSL(geoPoint) + "/1");
                exifInterface.saveAttributes();
                return true;
            } catch (Exception e) {
                Log.d(TAG, "EXCEPTION in fixBadDJIAltitudeEXIF(): ", e);
                return false;
            }
        } else {
            Log.d(TAG, "Null GeoPoint in fixBadDJIAltitudeEXIF()");
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean dropMarker(String str, UASItem uASItem) {
        GeoPoint picPoint = getPicPoint(uASItem);
        if (picPoint != null) {
            g.a aVar = new g.a(picPoint);
            aVar.b(str);
            aVar.f(false);
            aVar.a("b-i-x-i");
            ao a = aVar.a();
            if (a == null) {
                return false;
            }
            a.setMetaBoolean("removable", true);
            a.persist(this.mapView.getMapEventDispatcher(), (Bundle) null, getClass());
            o c = this.mapView.getRootGroup().c(MapShotController.UAS_GROUP_NAME);
            if (c == null) {
                c = new o(MapShotController.UAS_GROUP_NAME);
                this.mapView.getMapOverlayManager().f(new com.atakmap.android.overlay.b(this.mapView, c));
            }
            c.d(a);
            f.b(a, (String) null);
            return true;
        }
        toast("Unable to drop map marker for picture (no GPS?)", 1);
        return false;
    }

    public static String getDateTime() {
        Date date = new Date();
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);
        return date.toString();
    }

    public void saveImageOnSDCard(String str) {
        File file = new File(str);
        if (!file.exists()) {
            toast("Unable to save pic on SD card: source image doesn't exist", 1);
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory().toString() + "/uastool_images/");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            FileSystemUtils.copyFile(file, new File(file2.getAbsolutePath() + "/" + file.getName()));
        } catch (IOException e) {
            toast("Unable to copy pic to SD card: " + e.getLocalizedMessage(), 1);
        }
    }

    /* renamed from: a */
    public void mo7787a(CotEvent cotEvent, Bundle bundle) {
        if (cotEvent == null) {
            toast("Null CoT event", 1);
            return;
        }
        Log.d(TAG, "Handling Cot event " + cotEvent.getType());
        if (cotEvent.getUID().contains(TaskMessage.TASKMESSAGE_UID_TAG)) {
            if (cotEvent.getType().startsWith("t-")) {
                handleUasTaskRequest(cotEvent, bundle);
            } else if (cotEvent.getType().startsWith("y-")) {
                handleUasTaskResponse(cotEvent, bundle);
            } else {
                toast("Unknown Task Message CoT event type: " + cotEvent.getType(), 1);
            }
        }
        if (getPlatformMonitor() != null) {
            getPlatformMonitor().onIncomingCot(cotEvent);
        }
    }

    private void handleUasTaskRequest(CotEvent cotEvent, Bundle bundle) {
        UASTask buildTaskItem = buildTaskItem(cotEvent);
        if (buildTaskItem != null) {
            sendTaskDeliveryReceipt(cotEvent, bundle);
            handleReceivedTask(buildTaskItem);
            return;
        }
        toast("Bad task event received " + cotEvent.getType() + " from " + buildTaskItem.getUser(), 1);
        StringBuilder sb = new StringBuilder();
        sb.append("Bad task event received ");
        sb.append(cotEvent);
        Log.d(TAG, sb.toString());
    }

    private void handleReceivedTask(UASTask uASTask) {
        OperatorPager operatorPager2 = this.operatorPager;
        if (operatorPager2 != null) {
            operatorPager2.handleReceivedTask(uASTask);
            return;
        }
        toast("Unable to handle received task " + uASTask.getName() + " - Operator Pager is NULL", 1);
    }

    private void handleUasTaskResponse(CotEvent cotEvent, Bundle bundle) {
        handleWaitingTasks(cotEvent);
    }

    private void handleWaitingTasks(CotEvent cotEvent) {
        ObserverPager observerPager2 = this.observerPager;
        if (observerPager2 != null) {
            observerPager2.handleWaitingTasks(cotEvent);
        }
    }

    private UASTask buildTaskItem(CotEvent cotEvent) {
        UASTask buildTask;
        CotDetail detail = cotEvent.getDetail();
        CotDetail firstChildByName = detail.getFirstChildByName(0, UASTask.COTDETAIL_UASTASK);
        if (firstChildByName == null || (buildTask = UASTask.buildTask(firstChildByName)) == null) {
            return null;
        }
        buildTask.setTaskMessageUid(cotEvent.getUID());
        CotDetail firstChildByName2 = detail.getFirstChildByName(0, "request");
        if (firstChildByName2 != null) {
            buildTask.setTaskSourceUid(firstChildByName2.getAttribute("_notifyUid"));
        }
        buildTask.setTaskMessageUid(cotEvent.getUID());
        return buildTask;
    }

    public SharedPreferences getAtakPrefs() {
        return sharedPrefs;
    }

    public CoordinateFormat getCoordFormat() {
        return CoordinateFormat.find(sharedPrefs.getString(AtakPrefConstants.COORD_DISP_PREF, this.mapView.getContext().getString(2131624580)));
    }

    public Angle getBearingFormat() {
        return Angle.findFromValue(Integer.parseInt(sharedPrefs.getString(AtakPrefConstants.RAB_UNITS_PREF, String.valueOf(Angle.DEGREE.getValue()))));
    }

    public NorthReference getNorthReference() {
        NorthReference findFromValue = NorthReference.findFromValue(Integer.parseInt(sharedPrefs.getString(AtakPrefConstants.NORTH_REF_PREF, String.valueOf(NorthReference.MAGNETIC.getValue()))));
        return findFromValue != null ? findFromValue : NorthReference.MAGNETIC;
    }

    public static int getRangeFormat() {
        return Integer.parseInt(sharedPrefs.getString(AtakPrefConstants.RAB_UNIT_PREF, String.valueOf(1)));
    }

    private boolean useMulticastDefault() {
        if (!sharedPrefs.getBoolean(NetworkPreferenceFragment.PREF_VIDEO_DEST_LASTOCTET, true) || getVideoBroadcastEncodingFormat() != b.a.a) {
            return false;
        }
        return true;
    }

    public String getVideoBroadcastDestinationIP() {
        if (getVideoBroadcastEncodingFormat() == b.a.b || getVideoBroadcastEncodingFormat() == b.a.c) {
            return sharedPrefs.getString(NetworkPreferenceFragment.PREF_DESTINATION_IP, (String) null);
        }
        if (useMulticastDefault()) {
            return NetworkUtils.getDefaultMulticastIpAddress(this.pluginContext);
        }
        return sharedPrefs.getString(NetworkPreferenceFragment.PREF_DESTINATION_IP_MULTICAST, (String) null);
    }

    public String getVideoBroadcastDestinationPort() {
        b.a videoBroadcastEncodingFormat = getInstance().getVideoBroadcastEncodingFormat();
        if (videoBroadcastEncodingFormat == b.a.b) {
            String string = sharedPrefs.getString(NetworkPreferenceFragment.PREF_VIDEO_DEST_PORT, (String) null);
            if (string == null || string.isEmpty()) {
                return String.valueOf(DEFAULT_WOWZA_PORT);
            }
            return string;
        } else if (videoBroadcastEncodingFormat == b.a.c) {
            String string2 = sharedPrefs.getString(NetworkPreferenceFragment.PREF_VIDEO_DEST_PORT, (String) null);
            if (string2 == null || string2.isEmpty()) {
                return String.valueOf(DEFAULT_WOWZA_PORT_SSL);
            }
            return string2;
        } else {
            return useMulticastDefault() ? NetworkUtils.getDefaultMulticastPort() : sharedPrefs.getString(NetworkPreferenceFragment.PREF_VIDEO_DEST_PORT_MULTICAST, (String) null);
        }
    }

    public String getVideoBroadcastDestinationUrl() {
        String string = sharedPrefs.getString(NetworkPreferenceFragment.PREF_VIDEO_OBSERVER_URL, (String) null);
        if (useMulticastDefault()) {
            String defaultMulticastIpAddress = NetworkUtils.getDefaultMulticastIpAddress(this.pluginContext);
            String defaultMulticastPort = NetworkUtils.getDefaultMulticastPort();
            if (defaultMulticastIpAddress == null || defaultMulticastPort == null) {
                return string;
            }
            return "udp://" + defaultMulticastIpAddress + ":" + defaultMulticastPort + "/";
        } else if (string != null && !string.isEmpty()) {
            return string;
        } else {
            if (getVideoBroadcastEncodingFormat() == b.a.b || getVideoBroadcastEncodingFormat() == b.a.c) {
                String videoBroadcastDestinationIP = getVideoBroadcastDestinationIP();
                String valueOf = String.valueOf(DEFAULT_WOWZA_PORT);
                String videoBroadcastPath = getVideoBroadcastPath(getVideoBroadcastEncodingFormat());
                if (videoBroadcastDestinationIP == null || videoBroadcastPath == null || videoBroadcastPath.isEmpty()) {
                    return string;
                }
                return "rtsp://" + videoBroadcastDestinationIP + ":" + valueOf + "/" + videoBroadcastPath;
            }
            String videoBroadcastDestinationIP2 = getVideoBroadcastDestinationIP();
            String videoBroadcastDestinationPort = getVideoBroadcastDestinationPort();
            if (videoBroadcastDestinationIP2 == null || videoBroadcastDestinationPort == null) {
                return string;
            }
            return "udp://" + videoBroadcastDestinationIP2 + ":" + videoBroadcastDestinationPort + "/";
        }
    }

    public String buildDefaultVideoBroadcastPath() {
        return ("live/" + getCallsign()).trim().replaceAll("\\s+", "");
    }

    public String getCallsign() {
        String string = sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, (String) null);
        if (string != null && !string.isEmpty()) {
            return string;
        }
        return "UAS-" + getMapView().getDeviceCallsign();
    }

    public String getPlatform() {
        return sharedPrefs.getString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, "None Selected");
    }

    private int getVideoBroadcastImageWidth() {
        String string = sharedPrefs.getString(NetworkPreferenceFragment.PREF_BROADCAST_SIZE, this.pluginContext.getResources().getStringArray(C1877R.array.restreaming_size)[0]);
        return Utils.parseInt(string.substring(0, string.indexOf("x")), 640);
    }

    private int getVideoBroadcastImageHeight() {
        String string = sharedPrefs.getString(NetworkPreferenceFragment.PREF_BROADCAST_SIZE, this.pluginContext.getResources().getStringArray(C1877R.array.restreaming_size)[0]);
        return Utils.parseInt(string.substring(string.indexOf("x") + 1).replaceAll("[^0-9]", ""), 480);
    }

    private int getVideoBroadcastImageBitrate() {
        float f = sharedPrefs.getFloat(NetworkPreferenceFragment.PREF_BROADCAST_VIDEODATARATE, -1.0f);
        return f <= 0.0f ? Utils.parseInt(sharedPrefs.getString(NetworkPreferenceFragment.PREF_BROADCAST_BITRATE, Integer.toString(DEFAULT_VIDEO_ENCODING_BITRATE)), DEFAULT_VIDEO_ENCODING_BITRATE) * 1024 : (int) (f * 1024.0f * 1024.0f);
    }

    private b.a getVideoBroadcastEncodingFormat() {
        b.a aVar = b.a.a;
        if (!sharedPrefs.getString(NetworkPreferenceFragment.PREF_BROADCAST_DESTINATION, this.pluginContext.getResources().getStringArray(C1877R.array.video_destination)[0]).contains("Wowza")) {
            return aVar;
        }
        if (sharedPrefs.getBoolean(NetworkPreferenceFragment.PREF_BROADCAST_SSL, false)) {
            return b.a.c;
        }
        return b.a.b;
    }

    private String getVideoBroadcastPath(b.a aVar) {
        if (aVar == b.a.a) {
            return null;
        }
        String string = sharedPrefs.getString(NetworkPreferenceFragment.PREF_BROADCAST_PATH, (String) null);
        if (string == null || string.isEmpty()) {
            string = buildDefaultVideoBroadcastPath();
        }
        return string.trim().replaceAll("\\s+", "");
    }

    private String getVideoBroadcastPathSSL(b.a aVar) {
        String videoBroadcastPath = getVideoBroadcastPath(aVar);
        return videoBroadcastPath + "?tcp";
    }

    private String getVideoOutboundInterfaceAddr(b.a aVar) {
        NetworkInterface a;
        if (aVar == b.a.a) {
            try {
                if (InetAddress.getByName(getVideoBroadcastDestinationIP()).isMulticastAddress()) {
                    j.a aVar2 = null;
                    String string = sharedPrefs.getString(NetworkPreferenceFragment.PREF_VIDEO_DEST_ADAPTER, (String) null);
                    if (string != null && !string.isEmpty()) {
                        for (j.a aVar3 : j.a()) {
                            if (aVar3.b.equals(string)) {
                                aVar2 = aVar3;
                            }
                        }
                        if (!(aVar2 == null || (a = aVar2.a()) == null || !a.isUp())) {
                            for (InterfaceAddress address : a.getInterfaceAddresses()) {
                                InetAddress address2 = address.getAddress();
                                if (!address2.isLoopbackAddress() && (address2 instanceof Inet4Address) && !address2.getHostAddress().equals("0.0.0.0")) {
                                    return address2.getHostAddress();
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                Log.d(TAG, "Exception: " + e.getMessage());
            }
        }
        return b.a;
    }

    private void videoBroadcastAttributeChanged() {
        Reflector reflector2 = this.reflector;
        if (reflector2 != null && reflector2.isBroadcasting()) {
            stopEncoder();
            new Thread(new Runnable() {
                public void run() {
                    try {
                        UASToolDropDownReceiver.this.startEncoder();
                    } catch (h.b e) {
                        UASToolDropDownReceiver.toast("Video broadcast failed to restart: " + e.getMessage(), 1);
                        UASToolDropDownReceiver.this.updateUIOnBroadcastChange(false);
                    }
                }
            }).start();
        }
    }

    public void showStartupWarning() {
        if (!this.hasWarningBeenShown) {
            toast(this.pluginContext.getString(C1877R.string.uas_warning), 1);
            this.hasWarningBeenShown = true;
        }
    }

    public void showOverlaysScreen(UASItem uASItem) {
        if (uASItem != null) {
            OverlayScreen overlayScreen = (OverlayScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.overlay_layout, (ViewGroup) null);
            UASToolFragment currentFragment = this.activePager.getCurrentFragment();
            if (currentFragment != null) {
                currentFragment.setCurrentScreen(overlayScreen, uASItem, currentFragment);
            } else {
                toast("Unable to show Overlays screen: bad fragment", 0);
            }
        } else {
            toast("Unable to show Overlays screen: no connected uas", 0);
        }
    }

    public void showMessagesScreen() {
        List<ToastLogItem> toastLog = getToastLog();
        ToastLogScreen toastLogScreen = (ToastLogScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.toastlog_layout, (ViewGroup) null);
        toastLogScreen.setLogs(toastLog);
        UASToolFragment currentFragment = this.activePager.getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.setCurrentScreen(toastLogScreen, (UASItem) null, currentFragment);
        } else {
            toast("Unable to show Messages screen: bad fragment", 0);
        }
    }

    public void showFlightLogsScreen() {
        FlightLogScreen flightLogScreen = (FlightLogScreen) LayoutInflater.from(this.pluginContext).inflate(C1877R.layout.flight_log_layout, (ViewGroup) null);
        UASToolFragment currentFragment = this.activePager.getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.setCurrentScreen(flightLogScreen, (UASItem) null, currentFragment);
        } else {
            toast("Unable to show Flight Logs screen: bad fragment", 0);
        }
    }

    public void onFlyingStatusChanged(UASItem uASItem) {
        this.quickbar.updateUI();
    }

    public Quickbar getQuickbar() {
        return this.quickbar;
    }

    public boolean broadcastCot() {
        Reflector reflector2 = this.reflector;
        if (reflector2 == null || !reflector2.isBroadcasting()) {
            return sharedPrefs.getBoolean(UASToolPreferenceFragment.PREF_COT_BROADCAST, true);
        }
        return true;
    }

    public void panTo(UASItem uASItem) {
        if (uASItem != null) {
            GeoPoint geoPoint = uASItem.getGeoPoint();
            if (geoPoint == null) {
                if (uASItem.isDefault()) {
                    geoPoint = getMapView().getSelfMarker().C();
                } else if (uASItem.getParent() != null) {
                    geoPoint = uASItem.getParent().C();
                }
            }
            this.mapView.getMapController().panZoomTo(geoPoint, 5.0E-5d, false);
            return;
        }
        toast("Unable to pan: uas is null", 0);
    }

    public static String formatAltitude(GeoPoint geoPoint) {
        String str;
        String str2 = "-- " + getAltitudeUnits().getAbbrev() + " AGL";
        if (geoPoint == null || !geoPoint.isValid()) {
            return str2;
        }
        if (!getAltitudeAglOverride() || getAltitudeDisplayAgl()) {
            return com.atakmap.android.util.e.a(new GeoPointMetaData(geoPoint));
        }
        ElevationManager.b bVar = new ElevationManager.b();
        bVar.e = 1;
        bVar.g = true;
        double a = ElevationManager.a(geoPoint.getLatitude(), geoPoint.getLongitude(), bVar);
        if (!Double.isNaN(a)) {
            str = EGM96.formatAGL(EGM96.getAGL(geoPoint, a), getAltitudeUnits());
        } else {
            str = "-- " + getAltitudeUnits().getAbbrev() + " AGL";
        }
        return str;
    }

    public static boolean useAglAltitude() {
        return getAltitudeAglOverride() || getAltitudeDisplayAgl();
    }

    public static String getAltitudeUnitsFormatLabel() {
        String abbrev = getAltitudeUnits().getAbbrev();
        if (useAglAltitude()) {
            return abbrev + " HAL";
        }
        return abbrev + " " + getAltitudeDisplayPref();
    }

    public static Span getAltitudeUnits() {
        return Integer.parseInt(sharedPrefs.getString(AtakPrefConstants.ALT_UNIT_PREF, String.valueOf(0))) == 0 ? Span.FOOT : Span.METER;
    }

    public static String getAltitudeDisplayPref() {
        return sharedPrefs.getString(AtakPrefConstants.ALT_DISPLAY_PREF, "MSL");
    }

    public static boolean getAltitudeDisplayAgl() {
        return sharedPrefs.getBoolean(AtakPrefConstants.ALT_DISPLAY_AGL, false);
    }

    public static boolean getAltitudeAglOverride() {
        return sharedPrefs.getBoolean(UIPreferenceFragment.PREF_AGL_OVERRIDE, true);
    }

    public UASItem getDefaultUasItem() {
        return StatusArrayList.getInstance().getDefaultUasItem();
    }

    public UASToolPager getActivePager() {
        return this.activePager;
    }

    public static String getUASCallsign() {
        String string = sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String str = "UAS-" + getInstance().getMapView().getDeviceCallsign();
        return TextUtils.isEmpty(str) ? UASToolConstants.DASHES : str;
    }

    public static String getDefaultPlatform() {
        return getSharedPrefs().getString(UASToolPreferenceFragment.PREF_PLATFORM_DETECT, "None Selected");
    }

    public static void onUasItemStatusChanged() {
        if (getInstance() != null && getInstance().getOperatorVideoUI() != null) {
            getInstance().getOperatorVideoUI().onAccessoryChange();
        }
    }

    public static void onObserverUasItemStatusChanged() {
        VideoUIBase observerVideoUI;
        if (getInstance() != null && (observerVideoUI = getInstance().getObserverVideoUI()) != null) {
            observerVideoUI.onAccessoryChange();
        }
    }

    public static ControlFragment getControlFragment() {
        return getControlFragment((UASItem) null);
    }

    public static ControlFragment getControlFragment(UASItem uASItem) {
        UASToolDropDownReceiver instance = getInstance();
        if (instance == null) {
            return null;
        }
        if ((uASItem == null || uASItem.isConnected()) && instance.getOperatorPager() != null) {
            return instance.getOperatorPager().getOperatorControlFragment();
        }
        if (instance.getObserverPager() != null) {
            return instance.getObserverPager().getObserverControlFragment();
        }
        return null;
    }

    public void updateAircraftItemCornersFromKlv(FieldOfView fieldOfView, IAircraftItem iAircraftItem, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.reflector.lastSpoiUpdate > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
            Log.d("GenericDebug", "Too much time since last spoi update " + (currentTimeMillis - this.reflector.lastSpoiUpdate));
        } else if (this.reflector.spoiLocation != null) {
            if (z) {
                iAircraftItem.spoilat = this.reflector.spoiLocation.getLatitude();
                iAircraftItem.spoilon = this.reflector.spoiLocation.getLongitude();
                iAircraftItem.spoialt = this.reflector.spoiLocation.getAltitude();
            }
            if (fieldOfView != null && fieldOfView.isValid() && currentTimeMillis - fieldOfView.lastUpdateTime < HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
                iAircraftItem.initSpoiViewBounds();
                iAircraftItem.spoiBounds[0] = fieldOfView.f8422tl.x;
                iAircraftItem.spoiBounds[1] = fieldOfView.f8422tl.y;
                iAircraftItem.spoiBounds[2] = fieldOfView.f8423tr.x;
                iAircraftItem.spoiBounds[3] = fieldOfView.f8423tr.y;
                iAircraftItem.spoiBounds[4] = fieldOfView.f8421br.x;
                iAircraftItem.spoiBounds[5] = fieldOfView.f8421br.y;
                iAircraftItem.spoiBounds[6] = fieldOfView.f8420bl.x;
                iAircraftItem.spoiBounds[7] = fieldOfView.f8420bl.y;
            }
        }
    }

    public void showHeath() {
        this.landingPager.showPlatformHealth();
    }
}
