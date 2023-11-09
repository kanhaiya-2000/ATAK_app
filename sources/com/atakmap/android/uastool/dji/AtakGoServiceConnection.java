package com.atakmap.android.uastool.dji;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Pair;
import com.atakmap.android.atakgo.dji.IDjiAtakInterface;
import com.atakmap.android.atakgo.dji.ITelemListener;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.Reflector;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.UASToolScreen;
import com.atakmap.android.uastool.pagers.operator.OperatorControlFragment;
import com.atakmap.android.uastool.pagers.video_ui.default_ui.ThermalData;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.prefs.DJIPreferenceFragment;
import com.atakmap.android.uastool.utils.Utils;
import com.atakmap.coremap.locale.LocaleUtil;
import com.atakmap.coremap.log.Log;
import com.atakmap.coremap.maps.coords.GeoPoint;
import com.atakmap.map.elevation.ElevationManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class AtakGoServiceConnection extends Service implements ServiceConnection, IBinder.DeathRecipient {
    private static final int AIDL_VERSION = 4;
    private static final String TAG = "AtakGoServiceConnection";
    /* access modifiers changed from: private */
    public static final ReentrantLock batteryLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static int flightTimeRemaining = -1;
    /* access modifiers changed from: private */
    public static int goHomeBatteryPercentage = -1;
    /* access modifiers changed from: private */
    public static final AtomicReference<Double> obstacleDistance = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */
    public static final AtomicBoolean onboardSdkEnabled = new AtomicBoolean(false);
    private final AtomicReference<Integer> currentRcMode;
    private final AtomicReference<Integer> desiredRcMode;
    /* access modifiers changed from: private */
    public Double droneAltAboveTakeoff;
    /* access modifiers changed from: private */
    public Double droneHomeLevel;
    /* access modifiers changed from: private */
    public Double droneLat;
    /* access modifiers changed from: private */
    public Double droneLon;
    private long lastRestartTime;
    /* access modifiers changed from: private */
    public Double sensorHFov;
    /* access modifiers changed from: private */
    public Double sensorHeading;
    /* access modifiers changed from: private */
    public Double sensorPitch;
    /* access modifiers changed from: private */
    public Double sensorVFov;
    private final AtomicReference<IDjiAtakInterface> service = new AtomicReference<>((Object) null);
    private final AtomicBoolean shouldRestart;
    private final ITelemListener.Stub telemBinder;
    /* access modifiers changed from: private */
    public final ReentrantLock telemLock = new ReentrantLock();

    public static class FlightTimeInfo {
        public int flightTimeRemainingSeconds;
        public int goHomeBatteryPercentage;
    }

    public AtakGoServiceConnection() {
        Double valueOf = Double.valueOf(Double.NaN);
        this.droneLat = valueOf;
        this.droneLon = valueOf;
        this.droneAltAboveTakeoff = valueOf;
        this.sensorPitch = valueOf;
        this.sensorHeading = valueOf;
        this.sensorHFov = valueOf;
        this.sensorVFov = valueOf;
        this.droneHomeLevel = valueOf;
        this.shouldRestart = new AtomicBoolean(true);
        this.desiredRcMode = new AtomicReference<>((Object) null);
        this.currentRcMode = new AtomicReference<>((Object) null);
        this.telemBinder = new ITelemListener.Stub() {
            public void onHomeUpdate(double d, double d2) {
                final double d3 = d;
                final double d4 = d2;
                new Thread(new Runnable() {
                    public void run() {
                        ElevationManager.b bVar = new ElevationManager.b();
                        bVar.e = 1;
                        bVar.g = true;
                        double a = ElevationManager.a(d3, d4, bVar);
                        Double valueOf = GeoPoint.isAltitudeValid(a) ? Double.valueOf(a) : null;
                        AtakGoServiceConnection.this.telemLock.lock();
                        try {
                            Double unused = AtakGoServiceConnection.this.droneHomeLevel = valueOf;
                        } finally {
                            AtakGoServiceConnection.this.telemLock.unlock();
                        }
                    }
                }).start();
            }

            public void onObstacleRangeUpdate(double d) {
                AtakGoServiceConnection.obstacleDistance.set(Double.valueOf(d));
            }

            public void onDiagnosticInfoUpdate(List<String> list) {
                UASToolDropDownReceiver.getInstance();
                Reflector reflector = UASToolDropDownReceiver.getReflector();
                if (reflector instanceof DJIReflector) {
                    ArrayList arrayList = new ArrayList();
                    for (String split : list) {
                        String[] split2 = split.split(" ", 2);
                        arrayList.add(new Pair(Integer.valueOf(Utils.parseInt(split2[0], 0)), split2[1]));
                    }
                    ((DJIReflector) reflector).updateDiagnosticInfo(arrayList);
                }
            }

            public void onPlatformConnected(String str, String str2, boolean z, float f, float f2, float f3, float f4, float f5, float f6) {
                AtakGoServiceConnection.this.initPlatform();
                AtakGoServiceConnection.this.checkRequestAtakGoPermissions();
                PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
                if (platformMonitor instanceof DJIMonitor) {
                    ((DJIMonitor) platformMonitor).handlePlatformConnect(str, str2, z, f, f2, f3, f4, f5, f6);
                }
            }

            public void accessoriesChanged() {
                UASToolDropDownReceiver.onUasItemStatusChanged();
            }

            public void onUASFileStateChange(String str) {
                DJIMonitor.onUASFileStateChange(str);
            }

            public void onUASFileRefreshComplete(boolean z, String str) {
                DJIMonitor.onUASFileRefreshComplete(z, str);
            }

            public void onUASFileLoadComplete(boolean z, String str) {
                DJIMonitor.onUASFileLoadComplete(z, str);
            }

            public void onUASFileDeleted(boolean z, String str, String str2) {
                DJIMonitor.onUASFileDeleted(z, str, str2);
            }

            public void onUASSoundPlaying(boolean z, String str, String str2) {
                DJIMonitor.onUASSoundPlaying(z, str, str2);
            }

            public void onUASSoundStopped(boolean z, String str) {
                DJIMonitor.onUASSoundStopped(z, str);
            }

            public void onUASPairingStopped() {
                UASToolScreen currentScreen = UASToolDropDownReceiver.getInstance().getActivePager().getCurrentFragment().getCurrentScreen();
                if (currentScreen instanceof DJIRCPairScreen) {
                    ((DJIRCPairScreen) currentScreen).onUASPairingStopped();
                }
            }

            public void formatSDCardDone(String str) {
                UASToolScreen currentScreen = UASToolDropDownReceiver.getInstance().getActivePager().getCurrentFragment().getCurrentScreen();
                if (currentScreen instanceof DJISettingsScreen) {
                    ((DJISettingsScreen) currentScreen).formatSDCardDone(str);
                }
            }

            public void formatInternalDone(String str) {
                UASToolScreen currentScreen = UASToolDropDownReceiver.getInstance().getActivePager().getCurrentFragment().getCurrentScreen();
                if (currentScreen instanceof DJISettingsScreen) {
                    ((DJISettingsScreen) currentScreen).formatInternalDone(str);
                }
            }

            public void pushBatteryInfo(int i, int i2) {
                Log.d(AtakGoServiceConnection.TAG, "Battery update triggered");
                if (AtakGoServiceConnection.batteryLock.tryLock()) {
                    try {
                        int unused = AtakGoServiceConnection.flightTimeRemaining = i;
                        int unused2 = AtakGoServiceConnection.goHomeBatteryPercentage = i2;
                        Log.d(AtakGoServiceConnection.TAG, "Battery updated to flight time: " + i + " goHomeAtPct: " + i2);
                    } finally {
                        AtakGoServiceConnection.batteryLock.unlock();
                    }
                }
            }

            public void onPlatformDisconnected() {
                PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
                if (platformMonitor instanceof DJIMonitor) {
                    ((DJIMonitor) platformMonitor).handlePlatformDisconnect(false);
                }
            }

            /* JADX INFO: finally extract failed */
            public void tryTelemUpdate(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
                if (AtakGoServiceConnection.this.telemLock.tryLock()) {
                    try {
                        if (!Double.isNaN(d)) {
                            Double unused = AtakGoServiceConnection.this.droneLat = Double.valueOf(d);
                        }
                        if (!Double.isNaN(d2)) {
                            Double unused2 = AtakGoServiceConnection.this.droneLon = Double.valueOf(d2);
                        }
                        if (!Double.isNaN(d3)) {
                            Double unused3 = AtakGoServiceConnection.this.droneAltAboveTakeoff = Double.valueOf(d3);
                        }
                        if (!Double.isNaN(d4)) {
                            Double unused4 = AtakGoServiceConnection.this.sensorPitch = Double.valueOf(d4);
                        }
                        if (!Double.isNaN(d5)) {
                            Double unused5 = AtakGoServiceConnection.this.sensorHeading = Double.valueOf(d5);
                        }
                        if (!Double.isNaN(d6)) {
                            Double unused6 = AtakGoServiceConnection.this.sensorHFov = Double.valueOf(d6);
                        }
                        if (!Double.isNaN(d7)) {
                            Double unused7 = AtakGoServiceConnection.this.sensorVFov = Double.valueOf(d7);
                        }
                        AtakGoServiceConnection.this.telemLock.unlock();
                        AtakGoServiceConnection.this.updateGeoreference();
                    } catch (Throwable th) {
                        AtakGoServiceConnection.this.telemLock.unlock();
                        throw th;
                    }
                }
            }

            public void onPwmChange(int i, int i2) {
                Log.d(AtakGoServiceConnection.TAG, String.format(Locale.US, "PWM Set: Pin #%d set to %d microseconds.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                UASToolDropDownReceiver.toast(String.format(Locale.US, "Pin #%d set to %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0);
            }

            public void onPwmSettingsInit(int i, int i2) {
                Log.d(AtakGoServiceConnection.TAG, String.format(LocaleUtil.US, "Pwm init: pin #%d set to frequency %dHz", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                UASToolDropDownReceiver.toast(String.format(LocaleUtil.US, "Pwm init: pin #%d set to frequency %dHz", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0);
                OnboardSdkHelper.getInstance().setPwmInitialized(true);
            }

            public void onOnboardSdkAvailable(boolean z) {
                AtakGoServiceConnection.onboardSdkEnabled.set(z);
            }

            public void onPositionUpdate(double d, double d2, double d3, double d4) {
                Log.d(AtakGoServiceConnection.TAG, String.format("Received position update lla: (%f, %f, %f), heading: %f", new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}));
                AtakGoServiceConnection.this.telemLock.lock();
                try {
                    Double unused = AtakGoServiceConnection.this.droneLat = Double.valueOf(d);
                    Double unused2 = AtakGoServiceConnection.this.droneLon = Double.valueOf(d2);
                    Double unused3 = AtakGoServiceConnection.this.droneAltAboveTakeoff = Double.valueOf(d3);
                    AtakGoServiceConnection.this.updateGeoreference();
                } finally {
                    AtakGoServiceConnection.this.telemLock.unlock();
                }
            }

            public void onSensorAngleUpdate(double d, double d2, double d3) {
                Log.d(AtakGoServiceConnection.TAG, String.format("Received sensor angle update... pitch: %f, roll: %f, yaw: %f", new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)}));
                AtakGoServiceConnection.this.telemLock.lock();
                try {
                    Double unused = AtakGoServiceConnection.this.sensorPitch = Double.valueOf(d);
                    Double unused2 = AtakGoServiceConnection.this.sensorHeading = Double.valueOf(d3);
                } finally {
                    AtakGoServiceConnection.this.telemLock.unlock();
                }
            }

            public void onSensorFieldOfViewUpdate(double d, double d2) {
                Log.d(AtakGoServiceConnection.TAG, String.format("Received sensor field of view update... hfov: %f, vfov: %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)}));
                AtakGoServiceConnection.this.telemLock.lock();
                try {
                    Double unused = AtakGoServiceConnection.this.sensorHFov = Double.valueOf(d);
                    Double unused2 = AtakGoServiceConnection.this.sensorVFov = Double.valueOf(d2);
                } finally {
                    AtakGoServiceConnection.this.telemLock.unlock();
                }
            }

            public void taskPrepared_aidl(int i, String str) {
                UASItem uASItem = UASToolDropDownReceiver.getInstance().getOperatorPager().getUASItem();
                if (uASItem != null) {
                    uASItem.preparedTaskProgress(i, str);
                    uASItem.startedTaskProgress(str);
                    return;
                }
                UASToolDropDownReceiver.toast("Unable to prepare task: no uas", 0);
            }

            public void taskRefused_aidl(String str) {
                UASItem uASItem = UASToolDropDownReceiver.getInstance().getOperatorPager().getUASItem();
                if (uASItem != null) {
                    uASItem.refusedTaskProgress(str);
                } else {
                    UASToolDropDownReceiver.toast("Unable to refuse task: no uas", 0);
                }
            }

            public void taskStageStarted_aidl(int i, String str, String str2) {
                UASItem uASItem = UASToolDropDownReceiver.getInstance().getOperatorPager().getUASItem();
                if (uASItem != null) {
                    uASItem.startTaskStageProgress(i, str, str2);
                } else {
                    UASToolDropDownReceiver.toast("Unable to start task stage: no uas", 0);
                }
            }

            public void taskStageUpdate_aidl(int i, int i2, String str, String str2) {
                UASItem uASItem = UASToolDropDownReceiver.getInstance().getOperatorPager().getUASItem();
                if (uASItem != null) {
                    uASItem.updateTaskStageProgress(i, i2, str, str2);
                } else {
                    UASToolDropDownReceiver.toast("Unable to update task stage: no uas", 0);
                }
            }

            public void taskStageCompleted_aidl(int i, String str, String str2) {
                UASItem uASItem = UASToolDropDownReceiver.getInstance().getOperatorPager().getUASItem();
                if (uASItem != null) {
                    uASItem.completedTaskStageProgress(i, str, str2);
                } else {
                    UASToolDropDownReceiver.toast("Unable to complete task stage: no uas", 0);
                }
            }

            public void taskFinished_aidl(String str, String str2) {
                UASItem uASItem = UASToolDropDownReceiver.getInstance().getOperatorPager().getUASItem();
                if (uASItem != null) {
                    uASItem.finishedTaskProgress(str, str2);
                } else {
                    UASToolDropDownReceiver.toast("Unable to finish task: no uas", 0);
                }
            }

            public void doMapshot() {
                UASItem uASItem = UASToolDropDownReceiver.getInstance().getOperatorPager().getUASItem();
                if (uASItem != null) {
                    OperatorControlFragment operatorControlFragment = UASToolDropDownReceiver.getInstance().getOperatorPager().getOperatorControlFragment();
                    if (operatorControlFragment != null) {
                        UASToolDropDownReceiver.getInstance().mapshotSelected(uASItem, operatorControlFragment);
                    } else {
                        UASToolDropDownReceiver.toast("Unable to perform mapshot: no ControlFragment");
                    }
                } else {
                    UASToolDropDownReceiver.toast("Unable to perform mapshot: no UAS");
                }
            }

            public void doCamerashot() {
                UASItem uASItem = UASToolDropDownReceiver.getInstance().getOperatorPager().getUASItem();
                if (uASItem != null) {
                    UASToolDropDownReceiver.getInstance().camerashotSelected(uASItem);
                } else {
                    UASToolDropDownReceiver.toast("Unable to perform camerashot: no UAS");
                }
            }

            public boolean getUASToolLDMStatus() {
                return UASToolDropDownReceiver.getSharedPrefs().getBoolean(DJIPreferenceFragment.DJIPREF_LDM_MODE, DJIPreferenceFragment.DJIPREF_LDM_MODE_DEFAULT.booleanValue());
            }
        };
        this.lastRestartTime = 0;
    }

    /* access modifiers changed from: private */
    public void updateGeoreference() {
        UASToolDropDownReceiver.getInstance();
        Reflector reflector = UASToolDropDownReceiver.getReflector();
        if (reflector instanceof DJIReflector) {
            DJIReflector dJIReflector = (DJIReflector) reflector;
            if (Double.isNaN(this.droneLat.doubleValue()) || Double.isNaN(this.droneLon.doubleValue()) || Double.isNaN(this.droneAltAboveTakeoff.doubleValue()) || Double.isNaN(this.sensorPitch.doubleValue()) || Double.isNaN(this.sensorHeading.doubleValue()) || Double.isNaN(this.sensorHFov.doubleValue()) || Double.isNaN(this.sensorVFov.doubleValue())) {
                Log.d(TAG, "BAD georef data - LAT: " + this.droneLat + "  LON: " + this.droneLon + "  ALT: " + this.droneAltAboveTakeoff + "  PITCH: " + this.sensorPitch + "  HEAD: " + this.sensorHeading + "  HFOV: " + this.sensorHFov + "  VFOV: " + this.sensorVFov);
                return;
            }
            this.telemLock.lock();
            try {
                dJIReflector.updateGeoreference(this.droneLat.doubleValue(), this.droneLon.doubleValue(), this.droneAltAboveTakeoff.doubleValue(), this.sensorPitch.doubleValue(), this.sensorHeading.doubleValue(), this.sensorHFov.doubleValue(), this.sensorVFov.doubleValue());
            } finally {
                this.telemLock.unlock();
            }
        } else {
            Log.d(TAG, "BAD reflector - not DJI");
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i(TAG, "onServiceConnected");
        Log.i(TAG, componentName.getClassName());
        this.service.set(IDjiAtakInterface.Stub.asInterface(iBinder));
        try {
            iBinder.linkToDeath(this, 0);
            int interfaceVersionNumber = this.service.get().getInterfaceVersionNumber();
            Log.i(TAG, "Got Service Call output: " + ("Version: " + interfaceVersionNumber));
            if (interfaceVersionNumber != 4) {
                UASToolDropDownReceiver.toast("Warning: AIDL Version of IDjiAtakInterface is " + interfaceVersionNumber + " but we are expecting " + 4 + " !");
                Log.w(TAG, "Warning: AIDL Version of IDjiAtakInterface is " + interfaceVersionNumber + " but we are expecting " + 4 + " !");
            }
            this.service.get().registerListener(this.telemBinder);
        } catch (RemoteException e) {
            Log.w(TAG, "Error calling remote service", e);
        }
    }

    private synchronized void checkRcMode(Context context) {
        try {
            Integer valueOf = Integer.valueOf(this.service.get().getRcMode());
            this.currentRcMode.set(valueOf);
            DJIPreferenceFragment.DJI_RCSTICK_MODE fromString = DJIPreferenceFragment.DJI_RCSTICK_MODE.fromString(UASToolDropDownReceiver.getSharedPrefs().getString(DJIPreferenceFragment.DJIPREF_RCSTICK_MODE, DJIPreferenceFragment.DJI_RCSTICK_MODE.getDefaultMode().toString()));
            if (fromString != null) {
                this.desiredRcMode.set(Integer.valueOf(fromString.getModeType()));
            }
            Integer num = this.desiredRcMode.get();
            if (!(num == null || num == valueOf)) {
                promptRcModeChange(context);
            }
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to fetch rc mode: ", e);
        }
        return;
    }

    private void promptRcModeChange(final Context context) {
        final Integer num = this.desiredRcMode.get();
        Integer num2 = this.currentRcMode.get();
        if (num != null && num2 != null && !num.equals(num2)) {
            ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                public void run() {
                    AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle("Joystick Mode Mismatch");
                    title.setMessage("The joystick mode in preferences doesn't match the mode set on the connected RC.Change the RC's joystick mode to Mode " + num + "?").setIcon(17301543).setPositiveButton("Yes, Change It", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AtakGoServiceConnection.this.setRcMode(num.intValue());
                        }
                    }).setNegativeButton("No, Do Nothing", (DialogInterface.OnClickListener) null).show();
                }
            });
        }
    }

    public synchronized void setRcMode(int i) {
        this.desiredRcMode.set(Integer.valueOf(i));
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.setRcMode(i);
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to set RC mode: ", e);
                UASToolDropDownReceiver.toast("Failed to set RC mode!", 1);
            }
        }
        return;
    }

    public IDjiAtakInterface getService() {
        return this.service.get();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Log.i(TAG, "onServiceDisconnected");
    }

    public IBinder onBind(Intent intent) {
        return this.telemBinder;
    }

    public boolean getOnboardSdkAvailable() {
        return onboardSdkEnabled.get();
    }

    public void binderDied() {
        try {
            PlatformMonitor platformMonitor = UASToolDropDownReceiver.getInstance().getPlatformMonitor();
            UASToolDropDownReceiver.toast("UAS Tool lost connection to ATAKGo", 0);
            if (platformMonitor instanceof DJIMonitor) {
                ((DJIMonitor) platformMonitor).handlePlatformDisconnect(true);
                if (System.currentTimeMillis() - this.lastRestartTime > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT && this.shouldRestart.get()) {
                    Log.d(TAG, "restarting... shouldRestart: " + this.shouldRestart.get());
                    ((DJIMonitor) platformMonitor).startAtakGo(this);
                    this.lastRestartTime = System.currentTimeMillis();
                }
            }
        } catch (Exception unused) {
            Log.d(TAG, "error the drop down receiver is now null");
        }
    }

    public void stopAutoRestarting() {
        this.shouldRestart.set(false);
    }

    public void startAutoRestarting() {
        this.shouldRestart.set(true);
    }

    public static FlightTimeInfo getFlightTimeInfo() {
        FlightTimeInfo flightTimeInfo = new FlightTimeInfo();
        ReentrantLock reentrantLock = batteryLock;
        reentrantLock.lock();
        try {
            flightTimeInfo.flightTimeRemainingSeconds = flightTimeRemaining;
            flightTimeInfo.goHomeBatteryPercentage = goHomeBatteryPercentage;
            reentrantLock.unlock();
            return flightTimeInfo;
        } catch (Throwable th) {
            batteryLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void initPlatform() {
        OnboardSdkHelper.getInstance().initPwm();
        obstacleDistance.set((Object) null);
        this.currentRcMode.set((Object) null);
        checkRcMode(MapView.getMapView().getContext());
    }

    public static Double getObstacleDistance() {
        return obstacleDistance.get();
    }

    public void checkRequestAtakGoPermissions() {
        try {
            boolean isPermissionsAccepted = getService().isPermissionsAccepted();
            Log.d(TAG, "PERMISSIONS ACCEPTED: " + isPermissionsAccepted);
            if (!isPermissionsAccepted) {
                ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        new AlertDialog.Builder(MapView.getMapView().getContext()).setTitle("Open ATAKGo").setMessage("ATAKGo is installed, but permissions have not been accepted. Click OK to run ATAK Go and accept the permissions.").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                try {
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName("com.atakmap.android.atakgo.dji", "com.atakmap.android.atakgo.main.AtakGoActivator"));
                                    MapView.getMapView().getContext().startActivity(intent);
                                } catch (Exception e) {
                                    UASToolDropDownReceiver.toast("Could not launch ATAKGo:" + e.getLocalizedMessage(), 0);
                                    Log.e(AtakGoServiceConnection.TAG, "Could not launch ATAKGo: ", e);
                                }
                            }
                        }).setNegativeButton("Ignore", (DialogInterface.OnClickListener) null).create().show();
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to request platform telemetry: ", e);
        }
    }

    public synchronized void toggleLEDs() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.toggleLEDs();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to toggle LEDs: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to toggle LEDs: ", e);
            }
        }
        return;
    }

    public synchronized void toggleLight() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.toggleLight();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to toggle spotlight: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to toggle spotlight: ", e);
            }
        }
        return;
    }

    public synchronized boolean hasSpotlight() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasSpotlight();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to query spotlight: ", e);
            }
        }
        return z;
    }

    public synchronized void spotlightBrightness(int i) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.spotlightBrightness(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to adjust spotlight brightness: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to adjust spotlight brightness: ", e);
            }
        }
        return;
    }

    public synchronized boolean hasBeacon() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasBeacon();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to query beacon: ", e);
            }
        }
        return z;
    }

    public synchronized boolean hasAuxLightTop() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasAuxLightTop();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to query auxiliary top light: ", e);
            }
        }
        return z;
    }

    public synchronized boolean hasAuxLightBottom() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasAuxLightBottom();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to query auxiliary bottom light: ", e);
            }
        }
        return z;
    }

    public synchronized void toggleAuxLightTop() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.toggleAuxLightTop();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to toggle auxiliary top light: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to toggle auxiliary top light: ", e);
            }
        }
        return;
    }

    public synchronized void toggleAuxLightBottom() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.toggleAuxLightBottom();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to toggle auxiliary bottom light: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to toggle auxiliary bottom light: ", e);
            }
        }
        return;
    }

    public synchronized boolean hasSpeaker() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasSpeaker();
            } catch (RemoteException unused) {
            }
        }
        return z;
    }

    public synchronized String getFileListState() {
        String str;
        str = "UNKNOWN";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getFileListState();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get speaker file list state: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized void refreshSoundList() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.refreshSoundList();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to refresh sound list: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized List<String> getLoadedSoundNames() {
        List<String> list;
        list = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                list = iDjiAtakInterface.getLoadedSoundNames();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to query loaded sound names: " + e.getLocalizedMessage(), 1);
            }
        }
        return list;
    }

    public synchronized boolean isSoundPlaying() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.isSoundPlaying();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed check if sound file is playing on UAS: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized void loadSound(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.loadSound(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to load sound to UAS: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized void playSound(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.playSound(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to play sound on UAS: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized void setCurrentSound(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.setCurrentSound(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set current sound on UAS: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized void stopSound() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.stopSound();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to stop sound on UAS: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized void deleteSound(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.deleteSound(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to delete sound file from UAS: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized String getPlayMode() {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getPlayMode();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get play mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized void setPlayMode(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.setPlayMode(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set play mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized int getSpeakerVolume() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getSpeakerVolume();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get speaker volume: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized void setSpeakerVolume(int i, boolean z) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.setSpeakerVolume(i, z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set speaker volume: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized boolean hasThermalCamera() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasThermalCamera();
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to query thermal camera: ", e);
            }
        }
        return z;
    }

    public synchronized void toggleThermal() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.toggleThermal();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to toggle thermal camera: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to toggle thermal camera: ", e);
            }
        }
        return;
    }

    public synchronized String getThermalPalette() {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getThermalPalette();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get thermal palette: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get thermal palette: ", e);
            }
        }
        return str;
    }

    public synchronized void setThermalPalette(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.setThermalPalette(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set thermal palette: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set thermal palette: ", e);
            }
        }
        return;
    }

    public synchronized String getThermalScene() {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getThermalScene();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get thermal scene: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get thermal scene: ", e);
            }
        }
        return str;
    }

    public synchronized void setThermalScene(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.setThermalScene(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set thermal scene: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set thermal scene: ", e);
            }
        }
        return;
    }

    public synchronized String getThermalGain() {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getThermalGain();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get thermal gain: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get thermal gain: ", e);
            }
        }
        return str;
    }

    public synchronized void setThermalGain(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.setThermalGain(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set thermal gain: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set thermal gain: ", e);
            }
        }
        return;
    }

    public synchronized String getThermalROI() {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getThermalROI();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get thermal roi: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get thermal roi: ", e);
            }
        }
        return str;
    }

    public synchronized void setThermalROI(String str) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.setThermalROI(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set thermal ROI: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set thermal ROI: ", e);
            }
        }
        return;
    }

    public synchronized String getThermalIsoTempUnits() {
        String str;
        str = "Celsius";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getThermalIsoTempUnits();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get isotherm temp units: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get isotherm temp units: ", e);
            }
        }
        return str;
    }

    public synchronized int getThermalIsoTempMin() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getThermalIsoTempMin();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get isotherm temp min: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get isotherm temp min: ", e);
            }
        }
        return i;
    }

    public synchronized int getThermalIsoTempMax() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getThermalIsoTempMax();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get isotherm temp max: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get isotherm temp max: ", e);
            }
        }
        return i;
    }

    public synchronized boolean getThermalIsoEnabled() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getThermalIsoEnabled();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get isotherm enabled: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get isotherm enabled: ", e);
            }
        }
        return z;
    }

    public synchronized int getThermalIsoTempLow() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getThermalIsoTempLow();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get isotherm temp low: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get isotherm temp low: ", e);
            }
        }
        return i;
    }

    public synchronized int getThermalIsoTempMid() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getThermalIsoTempMid();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get isotherm temp mid: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get isotherm temp mid: ", e);
            }
        }
        return i;
    }

    public synchronized int getThermalIsoTempHigh() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getThermalIsoTempHigh();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get isotherm temp high: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get isotherm temp high: ", e);
            }
        }
        return i;
    }

    public synchronized boolean setThermalIsoEnabled(boolean z) {
        boolean z2;
        z2 = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z2 = iDjiAtakInterface.setThermalIsoEnabled(z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set isotherm enabled: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set isotherm enabled: ", e);
            }
        }
        return z2;
    }

    public synchronized int setThermalIsoTempLow(int i) {
        int i2;
        i2 = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i2 = iDjiAtakInterface.setThermalIsoTempLow(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set isotherm temp low: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set isotherm temp low: ", e);
            }
        }
        return i2;
    }

    public synchronized int setThermalIsoTempMid(int i) {
        int i2;
        i2 = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i2 = iDjiAtakInterface.setThermalIsoTempMid(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set isotherm temp mid: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set isotherm temp mid: ", e);
            }
        }
        return i2;
    }

    public synchronized int setThermalIsoTempHigh(int i) {
        int i2;
        i2 = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i2 = iDjiAtakInterface.setThermalIsoTempHigh(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set isotherm temp high: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set isotherm temp high: ", e);
            }
        }
        return i2;
    }

    public synchronized boolean getThermalMetering() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getThermalMetering();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get thermal metering: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set get thermal metering: ", e);
            }
        }
        return z;
    }

    public synchronized boolean toggleThermalMetering() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.toggleThermalMetering();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to toggle thermal metering: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to set toggle thermal metering: ", e);
            }
        }
        return z;
    }

    public synchronized ThermalData getThermalData(String str) {
        ThermalData thermalData;
        thermalData = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                thermalData = iDjiAtakInterface.getThermalMeterData(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get thermal data: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to get thermal data: ", e);
            }
        }
        return thermalData;
    }

    public synchronized int getMSXLevel() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getMSXLevel();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get MSX level: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized int setMSXLevel(int i) {
        int i2;
        i2 = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i2 = iDjiAtakInterface.setMSXLevel(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set MSX level: " + e.getLocalizedMessage(), 1);
            }
        }
        return i2;
    }

    public synchronized void turnOnThermalMetering() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.turnOnThermalMetering();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to turn on thermal metering: " + e.getLocalizedMessage(), 1);
                Log.w(TAG, "Failed to turn on thermal metering: ", e);
            }
        }
        return;
    }

    public synchronized void startRCPairing() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.startRCPairing();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to start RC pairing: " + e.getLocalizedMessage(), 1);
            }
        } else {
            UASToolDropDownReceiver.toast("Unable to start RC pairing", 1);
        }
    }

    public synchronized void stopRCPairing() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.stopRCPairing();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to stop RC pairing: " + e.getLocalizedMessage(), 1);
            }
        } else {
            UASToolDropDownReceiver.toast("Unable to stop RC pairing", 1);
        }
    }

    public synchronized String getAccelState() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getAccelState();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Accel State: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized void startAccelCalib() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.startAccelCalib();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to start Accel Calib: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized String getAccelCalibStatus() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getAccelCalibStatus();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Accel State: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String getGyroState() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getGyroState();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Gyro State: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized void startGyroCalib() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.startGyroCalib();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to start Gyro Calib: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized String getGyroCalibStatus() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getGyroCalibStatus();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Gyro State: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String getCompassState() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getCompassState();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Compass State: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized void startCompassCalib() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.startCompassCalib();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to start Compass Calib: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized void stopCompassCalib() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.stopCompassCalib();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to stop Compass Calib: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized String getCompassCalibStatus() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getCompassCalibStatus();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Compass Calib Status: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String getGimbalMode() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getGimbalMode();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Gimbal Mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized void startGimbalCalib() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.startGimbalCalib();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to start Gimbal Calib: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized String getGimbalCalibStatus() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getGimbalCalibStatus();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Gimbal State: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized int getMaxAltitude() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getMaxAltitude();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Max Altitude: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized String setMaxAltitude(int i) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setMaxAltitude(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Max Altitude: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized int getMaxDistance() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getMaxDistance();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Max Distance: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized String setMaxDistance(int i) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setMaxDistance(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Max Distance: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setGoHomeBattPct(int i) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setGoHomeBattPct(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Go Home Battery %: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized int getGoHomeBattPct() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getGoHomeBattPct();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Go Home Battery %: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized String setGoHomeAlt(int i) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setGoHomeAlt(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Go Home Altitude: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized int getGoHomeAlt() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getGoHomeAlt();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Go Home Altitude: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized String setLandNowBattPct(int i) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setLandNowBattPct(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Land Now Battery %: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized int getLandNowBattPct() {
        int i;
        i = 0;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getLandNowBattPct();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Land Now Battery %: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized String setConnLossBehav(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setConnLossBehav(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Conn Loss Behavior: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized String getConnLossBehav() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getConnLossBehav();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Conn Loss Behavior: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setCollAvoid(boolean z) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setCollAvoid(z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Coll Avoid: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized boolean getCollAvoid() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getCollAvoid();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Coll Avoid: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized String setActiveAvoid(boolean z) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setActiveAvoid(z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Active Avoid: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized boolean getActiveAvoid() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getActiveAvoid();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Active Avoid: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized String setVisionPos(boolean z) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setVisionPos(z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Vision Pos: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized boolean getVisionPos() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getVisionPos();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Vision Pos: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized String setPrecLand(boolean z) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setPrecLand(z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Prec Land: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized boolean getPrecLand() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getPrecLand();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Prec Land: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized String setLandProt(boolean z) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setLandProt(z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Land Prot: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized boolean getLandProt() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getLandProt();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Land Prot: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized boolean hasWiFi() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasWiFi();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get hasWiFi: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized String getWiFiSSID() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getWiFiSSID();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get WiFi SSID: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setWiFiSSID(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setWiFiSSID(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set WiFi SSID: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized String getWiFiPassword() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getWiFiPassword();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get WiFi password: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setWiFiPassword(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setWiFiPassword(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set WiFi password: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized String getWiFiFrequencyBand() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getWiFiFrequencyBand();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get WiFi frequency band: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setWiFiFrequencyBand(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setWiFiFrequencyBand(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set WiFi frequency band: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized String getWiFiChannelMode() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getWiFiChannelMode();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get WiFi channel mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setWiFiChannelMode(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setWiFiChannelMode(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set WiFi channel mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized int getWiFiChannelNumber() {
        int i;
        i = -1;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getWiFiChannelNumber();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get WiFi channel number: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized int[] getWiFiChannelNumbers() {
        int[] iArr;
        iArr = new int[]{-1};
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iArr = iDjiAtakInterface.getWiFiChannelNumbers();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get WiFi channel numbers: " + e.getLocalizedMessage(), 1);
            }
        }
        return iArr;
    }

    public synchronized String setWiFiChannelNumber(int i) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setWiFiChannelNumber(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set WiFi channel number: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String getWiFiDataRate() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getWiFiDataRate();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get WiFi data rate: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setWiFiDataRate(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setWiFiDataRate(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set WiFi data rate: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized boolean hasOcuSync() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasOcuSync();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get hasOcuSync: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized String getOcuSyncChannelMode() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getOcuSyncChannelMode();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get OcuSync channel mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setOcuSyncChannelMode(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setOcuSyncChannelMode(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set OcuSync channel mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized String getOcuSyncChannelBandwidth() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getOcuSyncChannelBandwidth();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get OcuSync channel bandwidth: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String[] getOcuSyncChannelBandwidths() {
        String[] strArr;
        strArr = new String[]{"none"};
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                strArr = iDjiAtakInterface.getOcuSyncChannelBandwidths();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get OcuSync channel bandwidths: " + e.getLocalizedMessage(), 1);
            }
        }
        return strArr;
    }

    public synchronized String setOcuSyncChannelBandwidth(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setOcuSyncChannelBandwidth(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set OcuSync channel bandwidth: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized int getOcuSyncChannelNumber() {
        int i;
        i = -1;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getOcuSyncChannelNumber();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get OcuSync channel number: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized String setOcuSyncChannelNumber(int i) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setOcuSyncChannelNumber(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set OcuSync channel number: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized int[] getOcuSyncChannelNumberRange() {
        int[] iArr;
        iArr = new int[]{-1, -1};
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iArr = iDjiAtakInterface.getOcuSyncChannelNumberRange();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get OcuSync channel number range: " + e.getLocalizedMessage(), 1);
            }
        }
        return iArr;
    }

    public synchronized String getOcuSyncFrequencyBand() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getOcuSyncFrequencyBand();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get OcuSync frequency band: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String[] getOcuSyncFrequencyBands() {
        String[] strArr;
        strArr = new String[]{"none"};
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                strArr = iDjiAtakInterface.getOcuSyncFrequencyBands();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get OcuSync frequency bands: " + e.getLocalizedMessage(), 1);
            }
        }
        return strArr;
    }

    public synchronized String setOcuSyncFrequencyBand(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setOcuSyncFrequencyBand(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set OcuSync frequency band: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized boolean hasLightBridge() {
        boolean z;
        z = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasLightBridge();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get hasLightBridge: " + e.getLocalizedMessage(), 1);
            }
        }
        return z;
    }

    public synchronized String getLightBridgeChannelMode() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getLightBridgeChannelMode();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get LightBridge channel mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setLightBridgeChannelMode(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setLightBridgeChannelMode(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set LightBridge channel mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized int getLightBridgeChannelNumber() {
        int i;
        i = -1;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                i = iDjiAtakInterface.getLightBridgeChannelNumber();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get LightBridge channel number: " + e.getLocalizedMessage(), 1);
            }
        }
        return i;
    }

    public synchronized int[] getLightBridgeChannelNumberRange() {
        int[] iArr;
        iArr = new int[]{-1, -1};
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iArr = iDjiAtakInterface.getLightBridgeChannelNumberRange();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get LightBridge channel number range: " + e.getLocalizedMessage(), 1);
            }
        }
        return iArr;
    }

    public synchronized String setLightBridgeChannelNumber(int i) {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.setLightBridgeChannelNumber(i);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set LightBridge channel number: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String getLightBridgeDataRate() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getLightBridgeDataRate();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get LightBridge data rate: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setLightBridgeDataRate(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setLightBridgeDataRate(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set LightBridge data rate: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized String getLightBridgeTransmissionMode() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getLightBridgeTransmissionMode();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get LightBridge transmission mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String setLightBridgeTransmissionMode(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setLightBridgeTransmissionMode(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set LightBridge transmission mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized String getLightBridgeFrequencyBand() {
        String str;
        str = "";
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getLightBridgeFrequencyBand();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get LightBridge frequency band: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized String[] getLightBridgeFrequencyBands() {
        String[] strArr;
        strArr = new String[]{"none"};
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                strArr = iDjiAtakInterface.getLightBridgeFrequencyBands();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get LightBridge frequency bands: " + e.getLocalizedMessage(), 1);
            }
        }
        return strArr;
    }

    public synchronized String setLightBridgeFrequencyBand(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setLightBridgeFrequencyBand(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set LightBridge frequency band: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized List<String> getResFPSList() {
        List<String> list;
        list = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                list = iDjiAtakInterface.getResFPSList();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Res FPS List: " + e.getLocalizedMessage(), 1);
            }
        }
        return list;
    }

    public synchronized String setResFPS(String str) {
        String str2;
        str2 = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str2 = iDjiAtakInterface.setResFPS(str);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set Res FPS: " + e.getLocalizedMessage(), 1);
            }
        }
        return str2;
    }

    public synchronized String getResFPS() {
        String str;
        str = null;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                str = iDjiAtakInterface.getResFPS();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get Res FPS: " + e.getLocalizedMessage(), 1);
            }
        }
        return str;
    }

    public synchronized void formatSDCardStart() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.formatSDCardStart();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to start SD Card Format: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized void formatInternalStart() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.formatInternalStart();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to start Internal Storage Format: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized boolean setVirtualStickMode(boolean z) {
        boolean z2;
        z2 = false;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                z2 = iDjiAtakInterface.setVirtualStickMode(z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set virtual joystick mode: " + e.getLocalizedMessage(), 1);
            }
        }
        return z2;
    }

    public synchronized void joystickPosition(float f, float f2, float f3, float f4) {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.joystickPosition(f, f2, f3, f4);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to send joystick position: " + e.getLocalizedMessage(), 1);
            }
        }
        return;
    }

    public synchronized void register() {
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        if (iDjiAtakInterface != null) {
            try {
                iDjiAtakInterface.register();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to register: " + e.getLocalizedMessage(), 0);
            }
        }
        return;
    }

    public synchronized boolean isLDMSupported() {
        boolean z;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        z = false;
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.isLDMSupported();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to check is LDM supported: " + e.getLocalizedMessage(), 0);
            }
        }
        return z;
    }

    public synchronized boolean getLDMSupported() {
        boolean z;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        z = false;
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getLDMSupported();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to check get LDM supported: " + e.getLocalizedMessage(), 0);
            }
        }
        return z;
    }

    public synchronized boolean isLDMEnabled() {
        boolean z;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        z = false;
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.isLDMEnabled();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to check is LDM enabled: " + e.getLocalizedMessage(), 0);
            }
        }
        return z;
    }

    public synchronized boolean enableLDM(boolean z) {
        boolean z2;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        z2 = false;
        if (iDjiAtakInterface != null) {
            try {
                z2 = iDjiAtakInterface.enableLDM(z);
            } catch (RemoteException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to ");
                sb.append(z ? "enable" : "disable");
                sb.append(": ");
                sb.append(e.getLocalizedMessage());
                UASToolDropDownReceiver.toast(sb.toString(), 0);
            }
        }
        return z2;
    }

    public synchronized boolean getRestrictLandingGear() {
        boolean z;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        z = false;
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.getRestrictLandingGear();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get restrict landing gear: " + e.getLocalizedMessage(), 0);
            }
        }
        return z;
    }

    public synchronized boolean hasLandingGear() {
        boolean z;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        z = false;
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.hasLandingGear();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed check for landing gear: " + e.getLocalizedMessage(), 0);
            }
        }
        return z;
    }

    public synchronized boolean setRestrictLandingGear(boolean z) {
        boolean z2;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        z2 = false;
        if (iDjiAtakInterface != null) {
            try {
                z2 = iDjiAtakInterface.setRestrictLandingGear(z);
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to set restrict landing gear: " + e.getLocalizedMessage(), 0);
            }
        }
        return z2;
    }

    public synchronized boolean usesYUV() {
        boolean z;
        IDjiAtakInterface iDjiAtakInterface = this.service.get();
        z = false;
        if (iDjiAtakInterface != null) {
            try {
                z = iDjiAtakInterface.usesYUV();
            } catch (RemoteException e) {
                UASToolDropDownReceiver.toast("Failed to get usesYUV: " + e.getLocalizedMessage(), 0);
            }
        }
        return z;
    }
}
