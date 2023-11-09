package com.atakmap.android.uastool.r80d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.aeryon.java.command.CommandStateCallback;
import com.aeryon.java.types.Aircraft;
import com.aeryon.java.types.BatteryStatus;
import com.aeryon.java.types.COMMAND_STATE;
import com.aeryon.java.types.CameraStream;
import com.aeryon.java.types.LwirPalette;
import com.aeryon.java.types.Orientation;
import com.aeryon.java.types.Position;
import com.aeryon.java.types.SensorType;
import com.aeryon.java.types.Vec3dLLA;
import com.aeryon.java.types.WAYPOINT_PLAY_MODE;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.maps.ao;
import com.atakmap.android.maps.av;
import com.atakmap.android.uastool.SettingsScreen;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASItemCapabilities;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.DJIReflector;
import com.atakmap.android.uastool.generic.IAircraftItem;
import com.atakmap.android.uastool.plugin.C1877R;
import com.atakmap.android.uastool.tasks.QuickTask;
import com.atakmap.android.uastool.tasks.TaskResponse;
import com.atakmap.android.uastool.tasks.UASTask;
import com.atakmap.android.uastool.tasks.UASTaskStore;
import com.atakmap.android.uastool.tasks.ltclc.LTCLCFOVCenterTask;
import com.atakmap.android.uastool.tasks.route.RouteTask;
import com.atakmap.android.uastool.tasks.route.UASPoint;
import com.atakmap.android.uastool.tasks.route.UASRoute;
import com.atakmap.android.uastool.trillium.TrilliumPrefHandler;
import com.atakmap.android.uastool.utils.FieldOfView;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public final class R80dUASItem extends UASItem {
    public static final String DETAIL_TAG = "_R80D_";
    public static final String DISPLAY_NAME = "R80D";
    /* access modifiers changed from: private */
    public static final String TAG = "R80dUASItem";
    private final ReentrantLock cameraControlLock = new ReentrantLock();
    public boolean cameraControlPending = false;
    boolean cameraHandlerInit = true;
    protected final ScheduledExecutorService cameraScheduler = Executors.newSingleThreadScheduledExecutor();
    protected Future<?> cameraSchedulerHandle = null;
    Aircraft.CameraStreamsCallback cameraStreamCallBack = new Aircraft.CameraStreamsCallback() {
        public void handleCameraStreams(CameraStream[] cameraStreamArr) {
            Log.d(R80dUASItem.TAG, "Callback for camera streams has been called! " + cameraStreamArr.length);
            R80dUASItem.this.cameraStreams.set(cameraStreamArr);
            SharedPreferences sharedPrefs = UASToolDropDownReceiver.getSharedPrefs();
            String string = sharedPrefs.getString(R80dPrefHandler.PREF_VIDEO_ID, R80dPrefHandler.DEFAULT_VIDEO_ID);
            Log.d(R80dUASItem.TAG, "Current Camera Stream: " + string);
            CameraStream cameraStream = null;
            for (CameraStream cameraStream2 : cameraStreamArr) {
                Log.d(R80dUASItem.TAG, cameraStream2.toString());
                if (cameraStream2.getName().endsWith(string)) {
                    if (!cameraStream2.getUrl().equals(sharedPrefs.getString(R80dPrefHandler.PREF_VIDEO_URI, R80dPrefHandler.DEFAULT_VIDEO_URI))) {
                        Log.d(R80dUASItem.TAG, "Updating Camera Stream to : " + cameraStream2.getUrl());
                        SharedPreferences.Editor edit = sharedPrefs.edit();
                        edit.putString(R80dPrefHandler.PREF_VIDEO_URI, cameraStream2.getUrl());
                        edit.putString(R80dPrefHandler.DEFAULT_VIDEO_ID, cameraStream2.getName());
                        edit.apply();
                    }
                    R80dUASItem.this.currentCameraStream = cameraStream2;
                    Log.d(R80dUASItem.TAG, "Current Camera Selected: " + cameraStream2.getUrl());
                    cameraStream = cameraStream2;
                }
            }
            if (cameraStream == null && cameraStreamArr.length > 0) {
                R80dUASItem.this.currentCameraStream = cameraStreamArr[0];
                SharedPreferences.Editor edit2 = sharedPrefs.edit();
                edit2.putString(R80dPrefHandler.PREF_VIDEO_URI, R80dUASItem.this.currentCameraStream.getUrl());
                edit2.apply();
            }
            UASToolDropDownReceiver.onUasItemStatusChanged();
            Log.d(R80dUASItem.TAG, "callback has set camera streams.");
        }
    };
    AtomicReference<CameraStream[]> cameraStreams = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public Aircraft connection;
    public CameraStream currentCameraStream;
    private boolean haveCameraControl = false;
    /* access modifiers changed from: private */
    public boolean haveNavControl = false;
    private final ReentrantLock navControlLock = new ReentrantLock();
    public boolean navControlPending = false;
    /* access modifiers changed from: private */
    public final CommandStateCallback paletteCallback = new CommandStateCallback() {
        public void callback(COMMAND_STATE command_state) {
            String command_state2 = command_state.toString();
            UASToolDropDownReceiver.toast("Palette State: " + command_state2, 0);
        }
    };
    av.a takeoffCallback;
    private long takeoffTime;
    /* access modifiers changed from: private */
    public final AtomicReference<Runnable> waitingCameraControlAuthCommand = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public final AtomicReference<Runnable> waitingControlAuthCommand = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public final CommandStateCallback zoomCallback = new CommandStateCallback() {
        public void callback(COMMAND_STATE command_state) {
            String command_state2 = command_state.toString();
            UASToolDropDownReceiver.toast("Zoom State: " + command_state2, 0);
        }
    };

    public boolean canZoomCamera() {
        return true;
    }

    public int getGoHomeBatteryPercent() {
        return 20;
    }

    public boolean hasGPS() {
        return true;
    }

    public boolean hasGimbalPitch() {
        return true;
    }

    public boolean isAircraftItemCapable() {
        return true;
    }

    public static void initStatic() {
        platformList.add(DISPLAY_NAME);
    }

    public Aircraft getConnection() {
        Aircraft aircraft = this.connection;
        if (aircraft == null || !aircraft.isValid()) {
            return null;
        }
        return this.connection;
    }

    public void setConnection(Aircraft aircraft) {
        this.connection = aircraft;
    }

    public void copy(UASItem uASItem) {
        super.copy(uASItem);
        if (uASItem instanceof R80dUASItem) {
            this.connection = ((R80dUASItem) uASItem).connection;
        }
        Aircraft connection2 = getConnection();
        if (connection2 != null) {
            if (connection2.isFlying()) {
                startConnection();
            }
            this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_SPEED_DEFAULT, Float.toString(this.connection.getCruiseSpeed()));
        }
    }

    public void startConnection() {
        this.takeoffTime = System.currentTimeMillis();
    }

    public R80dUASItem(ao aoVar, boolean z) {
        super(aoVar, z, DETAIL_TAG);
    }

    public R80dUASItem(String str, String str2, boolean z) {
        super(DETAIL_TAG, str, str2, DISPLAY_NAME, z);
        Log.d(TAG, "New R80d UAS Item");
    }

    /* access modifiers changed from: protected */
    public void setCapabilities() {
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SIGNAL_STRENGTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROTATION_MATRIX_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TIME_IN_FLIGHT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SETTINGS, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_VOLTAGE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_STOP, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_RTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_TASK, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_RADIUS, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_COUNT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_POINT_ORBIT_CLOCKWISE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ZOOM_CAMERA, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SIGNAL_STRENGTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_LTCLC, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_OPERATOR_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TIME_IN_FLIGHT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SETTINGS, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_CAMERA_SHOT, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ATTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_GROUNDSPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_BATTERY_LEVEL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HEADING, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_SPEED, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_HAL, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROUTE_OVERLAY_SHOW, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_ROTATION_MATRIX_AR, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_STOP, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_RTH, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_TASK, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_ALTITUDE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_REMOTE_QUICK_TASK, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_QUICK_FOLLOW, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_NEWROUTE, true);
        this.capabilities.put(UASItemCapabilities.CAPABILITY_TASK_EXISTROUTE, true);
        setGimbalCapabilities(-90.0f, 0.0f, 0.0f, 0.0f);
    }

    /* access modifiers changed from: protected */
    public void setPlatformValues() {
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_MIN, "3");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_MAX, "152.4");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_AGL_DEFAULT, "61");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MIN, "2.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_MAX, TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_VIDEO_BUFFERING);
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITRADIUS_DEFAULT, "10.0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MIN, "0");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_MAX, "10");
        this.platformValues.put(UASItemCapabilities.VALUE_ROUTE_ORBITCOUNT_DEFAULT, "1");
    }

    public SettingsScreen getPlatformSettingsScreen(LayoutInflater layoutInflater) {
        return (R80dSettingsScreen) layoutInflater.inflate(C1877R.layout.r80d_settings_layout, (ViewGroup) null);
    }

    public void runQuickTask(QuickTask quickTask) {
        if (quickTask.action == QuickTask.ACTION.STOP) {
            quickStop();
        } else {
            super.runQuickTask(quickTask);
        }
    }

    public void runTask(UASTask uASTask) {
        super.runTask(uASTask);
        if (uASTask != null) {
            int i = C208332.$SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE[uASTask.getTaskType().ordinal()];
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
        UASToolDropDownReceiver.toast("R80D tasking failed: NULL task", 0);
        Log.w(TAG, "R80D tasking failed: NULL task");
    }

    public void pauseTask(UASTask uASTask) {
        if (!sendRemoteTask(uASTask, QuickTask.ACTION.PAUSE)) {
            runAfterAuthoriziation(new Runnable() {
                public void run() {
                    Aircraft connection = R80dUASItem.this.getConnection();
                    if (connection == null || !connection.isFlying()) {
                        UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
                    } else {
                        connection.routePause();
                    }
                }
            });
        }
    }

    public void resumeTask(UASTask uASTask) {
        if (!sendRemoteTask(uASTask, QuickTask.ACTION.RESUME)) {
            runAfterAuthoriziation(new Runnable() {
                public void run() {
                    Aircraft connection = R80dUASItem.this.getConnection();
                    if (connection == null || !connection.isFlying()) {
                        UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
                    } else if (!connection.routeContinue()) {
                        UASToolDropDownReceiver.toast("Unable To continue, No active Route", 1);
                        R80dUASItem.this.cancelAllActiveTasks();
                    }
                }
            });
        }
    }

    public void stopTask(UASTask uASTask) {
        super.stopTask(uASTask);
        sendRemoteTask(uASTask, QuickTask.ACTION.STOP);
        setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
        runAfterAuthoriziation(new Runnable() {
            public void run() {
                Aircraft connection = R80dUASItem.this.getConnection();
                if (connection == null || !connection.isFlying()) {
                    UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
                } else {
                    connection.halt();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void runRouteTask(RouteTask routeTask) {
        WAYPOINT_PLAY_MODE waypoint_play_mode;
        ArrayList<UASPoint> arrayList;
        RouteTask routeTask2 = routeTask;
        Log.d(TAG, "runRouteTask(RouteTask routeTask)");
        UASRoute route = routeTask.getRoute();
        Vec3dLLA estimatedPosition = (getConnection() == null || getConnection().getPosition() == null) ? null : getConnection().getPosition().getEstimatedPosition();
        if (route.getPointCnt() == 1 && route.getPointWithIndex(1).getPointType() == UASPoint.POINTTYPE.ORBITPOINT) {
            arrayList = routeTask2.getSimpleRoute(getGeoPoint(), (GeoPoint) null, false).getPoints();
            waypoint_play_mode = WAYPOINT_PLAY_MODE.ADK_WAYPOINT_PLAY_MODE_ForwardLooping;
        } else if (route.getPointCnt() == 1 && route.getPointWithIndex(1).getPointType() == UASPoint.POINTTYPE.WAYPOINT) {
            arrayList = route.getPoints();
            if (estimatedPosition != null) {
                arrayList.get(0).setHAL((float) estimatedPosition.getAltitude());
            }
            waypoint_play_mode = WAYPOINT_PLAY_MODE.ADK_WAYPOINT_PLAY_MODE_Forward;
        } else {
            arrayList = routeTask2.getSimpleRoute(getGeoPoint(), (GeoPoint) null, false).getPoints();
            waypoint_play_mode = WAYPOINT_PLAY_MODE.ADK_WAYPOINT_PLAY_MODE_Forward;
        }
        final WAYPOINT_PLAY_MODE waypoint_play_mode2 = waypoint_play_mode;
        int size = arrayList.size();
        final Vec3dLLA[] vec3dLLAArr = new Vec3dLLA[size];
        double altitude = getHomePosition().getAltitude();
        for (int i = 0; i < size; i++) {
            UASPoint uASPoint = arrayList.get(i);
            vec3dLLAArr[i] = new Vec3dLLA(uASPoint.C().getLatitude(), uASPoint.C().getLongitude(), (double) (uASPoint.getHAL() == 0.0f ? uASPoint.getHAL(altitude) : uASPoint.getHAL()));
        }
        final C20844 r10 = new CommandStateCallback() {
            public void callback(COMMAND_STATE command_state) {
                int i = C208332.$SwitchMap$com$aeryon$java$types$COMMAND_STATE[command_state.ordinal()];
                if (i == 1) {
                    UASToolDropDownReceiver.toast("Route complete", 0);
                    R80dUASItem.this.cancelAllActiveTasks();
                } else if (i == 2) {
                    UASToolDropDownReceiver.toast("Route in progress...", 0);
                } else if (i == 3) {
                    UASToolDropDownReceiver.toast("Route: " + command_state.name(), 0);
                    R80dUASItem.this.cancelAllActiveTasks();
                }
            }
        };
        final double altitude2 = vec3dLLAArr[0].getAltitude();
        final double altitude3 = getGeoPoint().getAltitude() + altitude2;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Aircraft connection2 = getConnection();
        if (connection2 == null) {
            UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
        } else if (connection2.isFlying()) {
            final Aircraft aircraft = connection2;
            final Vec3dLLA[] vec3dLLAArr2 = vec3dLLAArr;
            final WAYPOINT_PLAY_MODE waypoint_play_mode3 = waypoint_play_mode2;
            final C20844 r5 = r10;
            runAfterAuthoriziation(new Runnable() {
                public void run() {
                    aircraft.flyRoute(vec3dLLAArr2, waypoint_play_mode3, r5);
                }
            });
        } else {
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final C20866 r0 = new Runnable() {
                public void run() {
                    UASToolDropDownReceiver.toast("Takeoff before Route: " + Utils.formatAlt(altitude2));
                    if (atomicBoolean2.get()) {
                        UASToolDropDownReceiver.toast("Manual Takeoff, Waiting 10 Seconds", 1);
                    }
                    connection2.takeoff(altitude2, atomicBoolean2.get(), new CommandStateCallback() {
                        public void callback(COMMAND_STATE command_state) {
                            String access$100 = R80dUASItem.TAG;
                            Log.d(access$100, "Takeoffcallback: " + command_state.name());
                            if (command_state == COMMAND_STATE.Failed) {
                                boolean unused = R80dUASItem.this.haveNavControl = false;
                                UASToolDropDownReceiver.toast("Quick takeoff: " + command_state.name(), 0);
                            }
                            int i = C208332.$SwitchMap$com$aeryon$java$types$COMMAND_STATE[command_state.ordinal()];
                            if (i == 1) {
                                R80dUASItem.this.takeoffCallback = new av.a() {
                                    public void onPointChanged(av avVar) {
                                        double abs = Math.abs(altitude3 - avVar.C().getAltitude());
                                        String access$100 = R80dUASItem.TAG;
                                        Log.d(access$100, "Relative Alt: " + abs);
                                        if (abs < 3.0d) {
                                            UASToolDropDownReceiver.toast("Takeoff Finished, Waiting");
                                            if (!(R80dUASItem.this.getMarker() == null || R80dUASItem.this.takeoffCallback == null)) {
                                                R80dUASItem.this.getMarker().b(R80dUASItem.this.takeoffCallback);
                                                R80dUASItem.this.takeoffCallback = null;
                                            }
                                            try {
                                                Thread.sleep(HeartBeat.HEARTBEAT_NORMAL_TIMEOUT);
                                            } catch (Exception e) {
                                                Log.d(R80dUASItem.TAG, "Takeoff error: ", e);
                                            }
                                            UASToolDropDownReceiver.toast("Takeoff Beginning Route");
                                            connection2.flyRoute(vec3dLLAArr, waypoint_play_mode2, r10);
                                        }
                                    }
                                };
                                R80dUASItem.this.getMarker().a(R80dUASItem.this.takeoffCallback);
                            } else if (i == 9 && R80dUASItem.this.getMarker() != null && R80dUASItem.this.takeoffCallback != null) {
                                R80dUASItem.this.getMarker().b(R80dUASItem.this.takeoffCallback);
                            }
                        }
                    });
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder.setTitle("Manual Takeoff?");
            builder.setMessage("Would you like to do manual initialization?");
            builder.setCancelable(true);
            builder.setPositiveButton("Manual", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    atomicBoolean.set(true);
                    R80dUASItem.this.runAfterAuthoriziation(r0);
                    dialogInterface.cancel();
                }
            });
            builder.setNeutralButton("Auto", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    atomicBoolean.set(false);
                    R80dUASItem.this.runAfterAuthoriziation(r0);
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        }
    }

    /* renamed from: com.atakmap.android.uastool.r80d.R80dUASItem$32 */
    /* synthetic */ class C208332 {
        static final /* synthetic */ int[] $SwitchMap$com$aeryon$java$types$COMMAND_STATE;
        static final /* synthetic */ int[] $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00c1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00cb */
        static {
            /*
                com.aeryon.java.types.COMMAND_STATE[] r0 = com.aeryon.java.types.COMMAND_STATE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$aeryon$java$types$COMMAND_STATE = r0
                r1 = 1
                com.aeryon.java.types.COMMAND_STATE r2 = com.aeryon.java.types.COMMAND_STATE.Complete     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.aeryon.java.types.COMMAND_STATE r3 = com.aeryon.java.types.COMMAND_STATE.Active     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.aeryon.java.types.COMMAND_STATE r4 = com.aeryon.java.types.COMMAND_STATE.NOT_CONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.aeryon.java.types.COMMAND_STATE r5 = com.aeryon.java.types.COMMAND_STATE.AUTH_FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x003e }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.AUTH_RELEASE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.None     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r7 = 6
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.ActiveWaiting     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7 = 7
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.Starting     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r7 = 8
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x006c }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.Failed     // Catch:{ NoSuchFieldError -> 0x006c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r7 = 9
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.Timeout     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r7 = 10
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r7 = 11
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.Cancelled     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r7 = 12
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r5 = $SwitchMap$com$aeryon$java$types$COMMAND_STATE     // Catch:{ NoSuchFieldError -> 0x009c }
                com.aeryon.java.types.COMMAND_STATE r6 = com.aeryon.java.types.COMMAND_STATE.AUTH_SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x009c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r7 = 13
                r5[r6] = r7     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE[] r5 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE = r5
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r6 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.ROUTE     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r1 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x00b7 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r5 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_FOVCENTER     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x00c1 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_REMOTE     // Catch:{ NoSuchFieldError -> 0x00c1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c1 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c1 }
            L_0x00c1:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x00cb }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.LTCLC_CANCEL     // Catch:{ NoSuchFieldError -> 0x00cb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cb }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00cb }
            L_0x00cb:
                int[] r0 = $SwitchMap$com$atakmap$android$uastool$tasks$UASTask$TASKTYPE     // Catch:{ NoSuchFieldError -> 0x00d5 }
                com.atakmap.android.uastool.tasks.UASTask$TASKTYPE r1 = com.atakmap.android.uastool.tasks.UASTask.TASKTYPE.QUICKFLY     // Catch:{ NoSuchFieldError -> 0x00d5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d5 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00d5 }
            L_0x00d5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.r80d.R80dUASItem.C208332.<clinit>():void");
        }
    }

    public void updateStatusData() {
        super.updateStatusData();
    }

    public void init() {
        super.init();
    }

    /* access modifiers changed from: protected */
    public void lookAtPoint(LTCLCFOVCenterTask lTCLCFOVCenterTask) {
        super.lookAtPoint(lTCLCFOVCenterTask);
        taskSensorToPoint(lTCLCFOVCenterTask.getPoint());
    }

    public void snapGimbal() {
        runAfterCameraAuthoriziation(new Runnable() {
            public void run() {
                Aircraft connection = R80dUASItem.this.getConnection();
                if (connection != null) {
                    connection.snapGimbal();
                }
            }
        });
    }

    public void resetGimbalPitchAndYaw() {
        if (!isConnected()) {
            super.resetGimbalPitchAndYaw();
        } else {
            resetGimbal();
        }
    }

    public void resetGimbal() {
        Aircraft connection2 = getConnection();
        if (connection2 != null) {
            connection2.setPose(90.0d, Double.NaN, this.currentCameraStream);
        }
    }

    public int getFlightTimeRemainingSeconds() {
        if (getConnection() != null) {
            return getConnection().getPowerStatus().getFlightTimeRemaining();
        }
        return ((int) getFlightTimeMins()) * 60;
    }

    public int getSignalRssi() {
        if (!isConnected()) {
            return super.getSignalRssi();
        }
        if (getConnection() == null) {
            return -100;
        }
        int rssi = getConnection().getRSSI();
        super.setSignalStrength(rssi);
        return rssi;
    }

    public double getBatteryPercent() {
        if (!this.isConnected) {
            return super.getBatteryPercent();
        }
        double d = 0.0d;
        if (getConnection() == null) {
            return 0.0d;
        }
        BatteryStatus[] batteryStatuses = getConnection().getBatteryStatuses();
        if (batteryStatuses.length < 4) {
            return 0.0d;
        }
        for (BatteryStatus chargeRemaining : batteryStatuses) {
            d += (double) chargeRemaining.getChargeRemaining();
        }
        double length = (d / ((double) batteryStatuses.length)) / 100.0d;
        super.setBatteryPercent(length);
        return length;
    }

    public double getSpeed() {
        if (getConnection() == null) {
            return 0.0d;
        }
        double nESpeed = getConnection().getVelocity().getNESpeed();
        super.setSpeed(nESpeed);
        return nESpeed;
    }

    public double getFlightTimeMins() {
        if (this.takeoffTime > 0) {
            return ((double) (System.currentTimeMillis() - this.takeoffTime)) / 60000.0d;
        }
        return 0.0d;
    }

    private int getZoomIncrement() {
        int maxZoom = (getConnection().getMaxZoom(this.currentCameraStream) + 0) / 3;
        if (maxZoom < 1) {
            return 1;
        }
        return maxZoom;
    }

    public void zoomIn() {
        final int zoom = getConnection().getZoom(this.currentCameraStream);
        final int zoomIncrement = getZoomIncrement();
        final int maxZoom = getConnection().getMaxZoom(this.currentCameraStream);
        runAfterCameraAuthoriziation(new Runnable() {
            public void run() {
                int i = zoom + zoomIncrement;
                int i2 = maxZoom;
                if (i > i2) {
                    i = i2;
                }
                R80dUASItem.this.getConnection().setZoom(R80dUASItem.this.currentCameraStream, i, R80dUASItem.this.zoomCallback);
            }
        });
    }

    public float getZoomLevel() {
        return (float) getConnection().getZoom(this.currentCameraStream);
    }

    public void zoomOut() {
        Aircraft connection2 = getConnection();
        if (connection2 != null) {
            int zoom = getConnection().getZoom(this.currentCameraStream) - getZoomIncrement();
            if (zoom < 0) {
                zoom = 0;
            }
            connection2.setZoom(this.currentCameraStream, zoom, this.zoomCallback);
        }
    }

    public float getZoomMax() {
        if (this.currentCameraStream == null) {
            super.getZoomMax();
        }
        Aircraft connection2 = getConnection();
        if (connection2 == null) {
            return 0.0f;
        }
        return (float) connection2.getMaxZoom(this.currentCameraStream);
    }

    public double getGimbalAngle() {
        Aircraft connection2;
        Orientation gimbalOrientation;
        if (!isDefault()) {
            return super.getGimbalAngle();
        }
        if (this.currentCameraStream == null || (connection2 = getConnection()) == null || (gimbalOrientation = connection2.getGimbalOrientation(this.currentCameraStream)) == null) {
            return 0.0d;
        }
        double yaw = gimbalOrientation.getEstimatedOrientation().getYaw();
        return yaw < 0.0d ? yaw + 360.0d : yaw;
    }

    public double getGimbalPitch() {
        Aircraft connection2;
        Orientation gimbalOrientation;
        if (!isDefault()) {
            return super.getGimbalPitch();
        }
        if (this.currentCameraStream == null || (connection2 = getConnection()) == null || (gimbalOrientation = connection2.getGimbalOrientation(this.currentCameraStream)) == null) {
            return 0.0d;
        }
        return -1.0d * (90.0d - gimbalOrientation.getEstimatedOrientation().getPitch());
    }

    public void taskSensorToPoint(final GeoPoint geoPoint) {
        final Aircraft connection2 = getConnection();
        if (connection2 != null && connection2 != null && this.currentCameraStream != null) {
            try {
                runAfterCameraAuthoriziation(new Runnable() {
                    public void run() {
                        UASToolDropDownReceiver.toast("Executing Gimbal Control FOV Center task.", 0);
                        connection2.lookAt(geoPoint.getLatitude(), geoPoint.getLongitude(), 0.0d, R80dUASItem.this.currentCameraStream);
                    }
                });
            } catch (Throwable th) {
                Log.e(TAG, "error", th);
            }
        }
    }

    public void getVideoStream() {
        Aircraft connection2 = getConnection();
        if (connection2 != null) {
            connection2.getCameraStreamsWithCallback(this.cameraStreamCallBack);
        }
    }

    public String getCameraURI(String str) {
        CameraStream[] cameraStreamArr = this.cameraStreams.get();
        if (cameraStreamArr == null) {
            return null;
        }
        for (CameraStream cameraStream : cameraStreamArr) {
            if (cameraStream.getUrl().contains(str)) {
                return cameraStream.getUrl();
            }
        }
        return null;
    }

    public CameraStream[] getCameraStreams() {
        return this.cameraStreams.get();
    }

    public GeoPoint getSPoIPoint() {
        try {
            this.fov = computeFov();
            onUasFovUpdate();
            if (!(this.fov == null || this.fov.center == null)) {
                return this.fov.center.get();
            }
        } catch (Exception e) {
            String str = TAG;
            Log.e(str, "ERROR COMPUTING SPoIPoint:" + e.getMessage());
        }
        return super.getSPoIPoint();
    }

    public void setSPoIPoint(GeoPoint geoPoint) {
        if (computeFov() != null && !computeFov().isValid()) {
            if (this.fov != null) {
                this.fov.center.set(geoPoint);
            } else {
                super.setSPoIPoint(geoPoint);
            }
        }
    }

    public void updateFOV(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        FieldOfView computeFov = computeFov();
        if (computeFov != null && !computeFov.isValid()) {
            super.updateFOV(d, d2, d3, d4, d5, d6, d7, d8);
        }
    }

    /* access modifiers changed from: private */
    public void runAfterAuthoriziation(Runnable runnable) {
        if (isNavAuthorized() && runnable != null) {
            runnable.run();
            this.waitingControlAuthCommand.set((Object) null);
        } else if (getConnection() != null) {
            this.waitingControlAuthCommand.set(runnable);
            requestNavigationControl();
        }
    }

    private void runAfterCameraAuthoriziation(Runnable runnable) {
        if (isPayloadAuthorized() && runnable != null) {
            runnable.run();
            this.waitingCameraControlAuthCommand.set((Object) null);
            this.waitingForLtclcTaskResponse = null;
        } else if (getConnection() != null) {
            this.waitingCameraControlAuthCommand.set(runnable);
            this.waitingForLtclcTaskResponse = "true";
            requestCameraControl();
        }
    }

    public void quickTakeoff(final int i) {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.TAKEOFF, (double) i)) {
            super.quickTakeoff(i);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            C205614 r7 = new Runnable() {
                public void run() {
                    Aircraft connection = R80dUASItem.this.getConnection();
                    R80dUASItem.this.startConnection();
                    if (connection != null) {
                        if (atomicBoolean.get()) {
                            UASToolDropDownReceiver.toast("Manual Takeoff, Waiting 10 Seconds", 1);
                        }
                        connection.takeoff((double) i, atomicBoolean.get(), new CommandStateCallback() {
                            public void callback(COMMAND_STATE command_state) {
                                if (command_state == COMMAND_STATE.Failed) {
                                    boolean unused = R80dUASItem.this.haveNavControl = false;
                                    UASToolDropDownReceiver.toast("Quick takeoff: " + command_state.name(), 0);
                                }
                            }
                        });
                        return;
                    }
                    UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
                }
            };
            Timer timer = new Timer();
            AlertDialog.Builder builder = new AlertDialog.Builder(MapView.getMapView().getContext());
            builder.setTitle("Takeoff Mode");
            builder.setMessage("Manual or Automatic Takeoff");
            builder.setCancelable(true);
            final int i2 = i;
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final Timer timer2 = timer;
            final C205614 r6 = r7;
            builder.setNeutralButton("Manual", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    R80dUASItem.super.quickTakeoff(i2);
                    atomicBoolean2.set(true);
                    timer2.cancel();
                    R80dUASItem.this.runAfterAuthoriziation(r6);
                    dialogInterface.cancel();
                }
            });
            builder.setPositiveButton("Auto", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    R80dUASItem.super.quickTakeoff(i2);
                    atomicBoolean2.set(false);
                    timer2.cancel();
                    R80dUASItem.this.runAfterAuthoriziation(r6);
                    dialogInterface.cancel();
                }
            });
            final AlertDialog.Builder builder2 = builder;
            final Timer timer3 = timer;
            final AtomicBoolean atomicBoolean3 = atomicBoolean;
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    final AlertDialog create = builder2.create();
                    create.show();
                    timer3.schedule(new TimerTask() {
                        public void run() {
                            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                                public void run() {
                                    create.cancel();
                                }
                            });
                            atomicBoolean3.set(false);
                            R80dUASItem.this.runAfterAuthoriziation(r6);
                        }
                    }, ConnectionType.DEFAULT_UDP_PING_PERIOD);
                }
            });
        }
    }

    public void quickLanding() {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.LAND)) {
            super.quickLanding();
            runAfterAuthoriziation(new Runnable() {
                public void run() {
                    Aircraft connection = R80dUASItem.this.getConnection();
                    if (connection == null || !connection.isFlying()) {
                        UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
                        return;
                    }
                    connection.landInPlace();
                    UASToolDropDownReceiver.toast("Quick landing in progress...", 0);
                }
            });
        }
    }

    public void quickStop() {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.STOP)) {
            super.quickStop();
            runAfterAuthoriziation(new Runnable() {
                public void run() {
                    Aircraft connection = R80dUASItem.this.getConnection();
                    if (connection == null) {
                        UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
                    } else if (connection.routePause()) {
                        UASTaskStore.getInstance().pauseRunningRoutes();
                    } else {
                        R80dUASItem.this.cancelAllActiveTasks();
                    }
                }
            });
        }
    }

    public void quickRTH() {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.RTH)) {
            super.quickRTH();
            runAfterAuthoriziation(new Runnable() {
                public void run() {
                    Aircraft connection = R80dUASItem.this.getConnection();
                    if (connection == null || !connection.isFlying()) {
                        UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
                        return;
                    }
                    R80dUASItem.this.cancelAllActiveTasks();
                    connection.returnToLanding();
                    UASToolDropDownReceiver.toast("Quick Return To Home in progress...", 0);
                }
            });
        }
    }

    public void quickAltitude(final int i) {
        if (!sendRemoteTask((UASTask) null, QuickTask.ACTION.ALTITUDE, (double) i)) {
            super.quickAltitude(i);
            runAfterAuthoriziation(new Runnable() {
                public void run() {
                    Aircraft connection = R80dUASItem.this.getConnection();
                    if (connection == null || !connection.isFlying()) {
                        UASToolDropDownReceiver.toast("No connected R80D UAS", 1);
                        return;
                    }
                    Vec3dLLA estimatedPosition = connection.getPosition().getEstimatedPosition();
                    connection.flyTo(estimatedPosition.getLatitude(), estimatedPosition.getLongitude(), (double) i, new CommandStateCallback() {
                        public void callback(COMMAND_STATE command_state) {
                        }
                    });
                }
            });
        }
    }

    public boolean isFlying() {
        if (!isDefault()) {
            return super.isFlying();
        }
        try {
            return getConnection().isFlying();
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

    private void runAuthorizationTask() {
        try {
            boolean isNavAuthorized = isNavAuthorized();
            if (this.haveNavControl != isNavAuthorized) {
                this.haveNavControl = isNavAuthorized;
                if (!isNavAuthorized) {
                    UASToolDropDownReceiver.toast("Navigation Control Lost ");
                    this.waitingCameraControlAuthCommand.set((Object) null);
                    this.navControlPending = false;
                    cancelAllActiveTasks();
                }
                UASToolDropDownReceiver.onUasItemStatusChanged();
            }
            boolean isPayloadAuthorized = isPayloadAuthorized();
            if (this.haveCameraControl != isPayloadAuthorized) {
                this.haveCameraControl = isPayloadAuthorized;
                super.onGimbalControlChanged(isPayloadAuthorized);
                UASToolDropDownReceiver.onUasItemStatusChanged();
            }
        } catch (Exception e) {
            Log.d(TAG, "Camera Scheduler Exception: ", e);
        }
    }

    public IAircraftItem getAircraftItem() {
        Vec3dLLA estimatedPosition;
        Aircraft connection2 = getConnection();
        if (connection2 == null || !connection2.isLiveConnected()) {
            return null;
        }
        IAircraftItem iAircraftItem = new IAircraftItem();
        runAuthorizationTask();
        if (this.cameraHandlerInit) {
            Log.d(TAG, "Running Camera Handler");
            this.cameraSchedulerHandle = this.cameraScheduler.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    try {
                        R80dUASItem.this.getVideoStream();
                    } catch (Exception e) {
                        Log.d(R80dUASItem.TAG, "Camera Scheduler Exception: ", e);
                    }
                }
            }, 0, HeartBeat.HEARTBEAT_NORMAL_TIMEOUT, TimeUnit.MILLISECONDS);
            this.cameraHandlerInit = false;
        }
        Position position = connection2.getPosition();
        if (!(position == null || (estimatedPosition = position.getEstimatedPosition()) == null)) {
            iAircraftItem.callsign = getCallsign();
            iAircraftItem.aclat = estimatedPosition.getLatitude();
            iAircraftItem.aclon = estimatedPosition.getLongitude();
            iAircraftItem.acalt = estimatedPosition.getAltitude();
            iAircraftItem.achal = estimatedPosition.getAltitude();
            iAircraftItem.acce = 30.0d;
            iAircraftItem.acle = 30.0d;
            iAircraftItem.speed = getSpeed();
        }
        Orientation orientation = getConnection().getOrientation();
        if (orientation != null) {
            iAircraftItem.acheading = orientation.getEstimatedOrientation().getYaw();
            if (iAircraftItem.acheading < 0.0d) {
                iAircraftItem.acheading += 360.0d;
            }
        }
        iAircraftItem.isFlying = isFlying();
        iAircraftItem.areMotorsOn = isFlying();
        iAircraftItem.platformId = getPlatformType();
        iAircraftItem.UID = getUid();
        Vec3dLLA homePosition = connection2.getHomePosition();
        if (homePosition != null) {
            iAircraftItem.homelat = homePosition.getLatitude();
            iAircraftItem.homelon = homePosition.getLongitude();
            iAircraftItem.homealt = ElevationManager.a(iAircraftItem.homelat, iAircraftItem.homelon, (ElevationManager.b) null);
        }
        CameraStream cameraStream = this.currentCameraStream;
        if (cameraStream != null) {
            iAircraftItem.sensorHFOV = cameraStream.getHorizontalFieldOfView();
            iAircraftItem.sensorVFOV = this.currentCameraStream.getVerticalFieldOfView();
            Orientation gimbalOrientation = connection2.getGimbalOrientation(this.currentCameraStream);
            if (gimbalOrientation != null) {
                if (this.currentCameraStream.getName().contains("front")) {
                    try {
                        iAircraftItem.sensorAzimuth = orientation.getEstimatedOrientation().getYaw();
                        iAircraftItem.sensorElevation = 66.0d - orientation.getEstimatedOrientation().getPitch();
                    } catch (Exception unused) {
                    }
                } else if (gimbalOrientation.getEstimatedOrientation() != null) {
                    iAircraftItem.sensorElevation = (90.0d - gimbalOrientation.getEstimatedOrientation().getPitch()) * -1.0d;
                    iAircraftItem.sensorAzimuth = gimbalOrientation.getEstimatedOrientation().getYaw();
                    if (iAircraftItem.sensorAzimuth < 0.0d) {
                        iAircraftItem.sensorAzimuth += 360.0d;
                    }
                    iAircraftItem.sensorRoll = gimbalOrientation.getEstimatedOrientation().getRoll();
                }
            }
        }
        iAircraftItem.battMax = 100;
        iAircraftItem.battRem = (int) (getBatteryPercent() * 100.0d);
        iAircraftItem.signalQuality = getSignalRssi();
        iAircraftItem.flightTimeRemaining = getFlightTimeRemainingSeconds();
        DJIReflector.updateAircraftItemWithDTED(iAircraftItem);
        DJIReflector.updateAircraftItemFOV(iAircraftItem);
        IAircraftItem iAircraftItem2 = iAircraftItem;
        updateGeoreference(iAircraftItem.aclat, iAircraftItem.aclon, iAircraftItem.acalt, iAircraftItem.sensorElevation, iAircraftItem.sensorAzimuth, iAircraftItem.sensorHFOV, iAircraftItem.sensorVFOV, iAircraftItem.homealt);
        return iAircraftItem2;
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

    /* access modifiers changed from: private */
    public void cancelAllActiveTasks() {
        setWayPointVisible((GeoPoint) null, -1.0d, (av.a) null);
        UASTask runningRoute = UASTaskStore.getInstance().getRunningRoute();
        if (!(runningRoute == null || runningRoute.getTaskSourceUid() == null)) {
            sendTaskResponse(runningRoute, TaskResponse.RESPONSETYPE.CANCELLED);
        }
        UASTaskStore.getInstance().stopRunningRoutes();
        if (getMarker() != null && this.takeoffCallback != null) {
            getMarker().b(this.takeoffCallback);
            this.takeoffCallback = null;
        }
    }

    public void setHomePosition(final GeoPoint geoPoint) {
        String str = TAG;
        Log.d(str, "setHomePositon: " + geoPoint.toString());
        runAfterAuthoriziation(new Runnable() {
            public void run() {
                Aircraft connection = R80dUASItem.this.getConnection();
                if (connection != null) {
                    connection.setHomePositionLLA(new Vec3dLLA(geoPoint.getLatitude(), geoPoint.getLongitude(), 0.0d), new CommandStateCallback() {
                        public void callback(COMMAND_STATE command_state) {
                            String command_state2 = command_state.toString();
                            String access$100 = R80dUASItem.TAG;
                            Log.d(access$100, "MoveHomePositon: " + command_state2);
                        }
                    });
                }
            }
        });
    }

    public int getVideoUIButtons() {
        if (isConnected()) {
            return C1877R.layout.video_ui_op_r80d_buttonbar;
        }
        return super.getVideoUIButtons();
    }

    public String getVideoUrl() {
        if (isConnected()) {
            return UASToolDropDownReceiver.getSharedPrefs().getString(R80dPrefHandler.PREF_VIDEO_URI, R80dPrefHandler.DEFAULT_VIDEO_URI);
        }
        return super.getVideoUrl();
    }

    public double getHeading() {
        if (!isDefault()) {
            return super.getHeading();
        }
        if (getConnection().getOrientation() == null) {
            return 0.0d;
        }
        double yaw = getConnection().getOrientation().getEstimatedOrientation().getYaw();
        return yaw < 0.0d ? yaw + 360.0d : yaw;
    }

    public double getPitch() {
        if (!isDefault()) {
            return super.getPitch();
        }
        if (getConnection().getOrientation() != null) {
            return getConnection().getOrientation().getEstimatedOrientation().getPitch();
        }
        return 0.0d;
    }

    public double getRoll() {
        if (!isDefault()) {
            return super.getRoll();
        }
        if (getConnection().getOrientation() != null) {
            return getConnection().getOrientation().getEstimatedOrientation().getRoll();
        }
        return 0.0d;
    }

    public double getYaw() {
        if (!isDefault()) {
            return super.getYaw();
        }
        if (getConnection().getOrientation() == null) {
            return 0.0d;
        }
        double yaw = getConnection().getOrientation().getEstimatedOrientation().getYaw();
        return yaw < 0.0d ? yaw + 360.0d : yaw;
    }

    public void setIrMode(String str) {
        final LwirPalette fromString = LwirPalette.fromString(str);
        final Aircraft connection2 = getConnection();
        if (connection2 != null) {
            runAfterCameraAuthoriziation(new Runnable() {
                public void run() {
                    connection2.setLwirPalette(R80dUASItem.this.currentCameraStream, fromString, R80dUASItem.this.paletteCallback);
                }
            });
        }
    }

    public LwirPalette getIrMode() {
        CameraStream cameraStream;
        Aircraft connection2 = getConnection();
        if (connection2 == null || (cameraStream = this.currentCameraStream) == null) {
            return LwirPalette.Unknown;
        }
        return connection2.getLwirPalette(cameraStream);
    }

    public void dispose() {
        ScheduledExecutorService scheduledExecutorService = this.cameraScheduler;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        super.dispose();
    }

    public static Aircraft getConnection(UASItem uASItem) {
        if (uASItem instanceof R80dUASItem) {
            return ((R80dUASItem) uASItem).getConnection();
        }
        return null;
    }

    public void cargoActuateLatch(final int i) {
        runAfterCameraAuthoriziation(new Runnable() {
            public void run() {
                new Thread(new Runnable() {
                    public void run() {
                        if (i == Aircraft.ADK_CARGO_LATCH_STATE_Open) {
                            UASToolDropDownReceiver.toast("Releasing Osprey", 0);
                        } else if (i == Aircraft.ADK_CARGO_LATCH_STATE_Closed) {
                            UASToolDropDownReceiver.toast("Closing Osprey", 0);
                        }
                        R80dUASItem.this.connection.cargoActuateLatch(i);
                    }
                }).start();
            }
        });
    }

    public int cargoLatchState() {
        return this.connection.cargoLatchState();
    }

    public SensorType getSensorType() {
        return getConnection().getSensorType(this.currentCameraStream);
    }

    public void setSensorType(final String str) {
        runAfterCameraAuthoriziation(new Runnable() {
            public void run() {
                new Thread(new Runnable() {
                    public void run() {
                        R80dUASItem.this.getConnection().setSensorType(R80dUASItem.this.currentCameraStream, SensorType.fromString(str));
                    }
                }).start();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void releaseCameraControl() {
        if (isPayloadAuthorized()) {
            UASToolDropDownReceiver.toast("Releasing Payload Control");
            getConnection().releaseCameraControl(new CommandStateCallback() {
                public void callback(COMMAND_STATE command_state) {
                }
            });
        }
    }

    public void releaseNavigationControl() {
        if (isNavAuthorized()) {
            UASToolDropDownReceiver.toast("Releasing Navigation Control");
            getConnection().releaseNavigationControl(new CommandStateCallback() {
                public void callback(COMMAND_STATE command_state) {
                }
            });
        }
    }

    public boolean isNavAuthorized() {
        Aircraft connection2 = getConnection();
        if (connection2 == null) {
            return false;
        }
        return connection2.isNavAuthorized();
    }

    public boolean isPayloadAuthorized() {
        Aircraft connection2 = getConnection();
        if (connection2 == null) {
            return false;
        }
        return connection2.isPayloadAuthorized();
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        synchronized (this) {
            releaseCameraControl();
            releaseNavigationControl();
            getConnection().destroy();
            setConnection((Aircraft) null);
        }
    }

    public void requestNavigationControl() {
        Log.d(TAG, "Request Nav Control");
        Aircraft connection2 = getConnection();
        if (connection2 != null) {
            UASToolDropDownReceiver.toast("Requesting Authorization");
            this.navControlPending = true;
            connection2.requestNavigationControl(new CommandStateCallback() {
                public void callback(COMMAND_STATE command_state) {
                    int i = C208332.$SwitchMap$com$aeryon$java$types$COMMAND_STATE[command_state.ordinal()];
                    if (i == 4) {
                        UASToolDropDownReceiver.toast("Authorization Denied");
                        R80dUASItem.this.waitingControlAuthCommand.set((Object) null);
                        R80dUASItem.this.navControlPending = false;
                        R80dUASItem.this.cancelAllActiveTasks();
                    } else if (i == 13) {
                        UASToolDropDownReceiver.toast("Authorization Granted");
                        Runnable runnable = (Runnable) R80dUASItem.this.waitingControlAuthCommand.get();
                        if (runnable != null) {
                            try {
                                ((Activity) MapView.getMapView().getContext()).runOnUiThread(runnable);
                            } catch (Exception e) {
                                Log.e(R80dUASItem.TAG, "Error Running Command", e);
                            }
                        }
                        R80dUASItem.this.waitingControlAuthCommand.set((Object) null);
                    }
                }
            });
        }
    }

    public void requestCameraControl() {
        Aircraft connection2 = getConnection();
        if (connection2 != null) {
            UASToolDropDownReceiver.toast("Requesting Camera Authorization");
            this.cameraControlPending = true;
            connection2.requestCameraControl(new CommandStateCallback() {
                public void callback(COMMAND_STATE command_state) {
                    int i = C208332.$SwitchMap$com$aeryon$java$types$COMMAND_STATE[command_state.ordinal()];
                    if (i == 4) {
                        UASToolDropDownReceiver.toast("Payload Authorization Denied");
                        R80dUASItem.this.waitingCameraControlAuthCommand.set((Object) null);
                        R80dUASItem.this.waitingForLtclcTaskResponse = null;
                        R80dUASItem.this.cameraControlPending = false;
                        UASToolDropDownReceiver.onUasItemStatusChanged();
                    } else if (i == 13) {
                        UASToolDropDownReceiver.toast("Payload Authorization Granted");
                        Runnable runnable = (Runnable) R80dUASItem.this.waitingCameraControlAuthCommand.get();
                        if (runnable != null) {
                            try {
                                ((Activity) MapView.getMapView().getContext()).runOnUiThread(runnable);
                            } catch (Exception e) {
                                Log.e(R80dUASItem.TAG, "Error Running Command", e);
                            }
                        }
                        R80dUASItem.this.waitingCameraControlAuthCommand.set((Object) null);
                        R80dUASItem.this.waitingForLtclcTaskResponse = null;
                        UASToolDropDownReceiver.onUasItemStatusChanged();
                    }
                }
            });
        }
    }

    public void onGimbalControlChanged(boolean z) {
        if (!isConnected()) {
            super.onGimbalControlChanged(z);
        } else if (!z) {
            releaseCameraControl();
            this.waitingForLtclcTaskResponse = null;
        } else {
            this.waitingForLtclcTaskResponse = "true";
            UASToolDropDownReceiver.onUasItemStatusChanged();
            runAfterCameraAuthoriziation((Runnable) null);
        }
    }
}
