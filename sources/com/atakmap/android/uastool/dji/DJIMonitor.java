package com.atakmap.android.uastool.dji;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.RemoteException;
import android.text.TextUtils;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.dji.sound.OnUASSpeakerListener;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.coremap.cot.event.CotEvent;
import com.atakmap.coremap.log.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class DJIMonitor extends PlatformMonitor {
    public static final String ACTION_ATAKGO_CAMSHOT = "com.atakmap.android.atakgo.misc.action.CAMSHOT";
    public static final String ACTION_ATAKGO_MAPSHOT = "com.atakmap.android.atakgo.misc.action.MAPSHOT";
    public static final String ACTION_ATAKGO_TOAST = "com.atakmap.android.atakgo.misc.action.TOAST";
    public static final String ACTION_ATAKGO_TOGGLEBROADCAST = "com.atakmap.android.atakgo.misc.action.TOGGLEBROADCAST";
    public static final String ACTION_ATAKGO_TOGGLESCREEN = "com.atakmap.android.atakgo.misc.action.TOGGLESCREEN";
    public static final String ACTION_ATAKGO_TRIGGER01 = "com.atakmap.android.atakgo.misc.action.TRIGGER01";
    public static final String ACTION_ATAKGO_TRIGGER02 = "com.atakmap.android.atakgo.misc.action.TRIGGER02";
    private static final String EXIT_ATAKGO = "com.atakmap.android.atakgo.misc.action.EXIT";
    private static final String EXTRA_ATAKGO_DURATION = "com.atakmap.android.atakgo.misc.extra.DURATION";
    private static final String EXTRA_ATAKGO_MESSAGE = "com.atakmap.android.atakgo.misc.extra.MESSAGE";
    public static final String QUICKSOUND_DIR_PATH;
    public static final String SOUND_DIR_PATH;
    /* access modifiers changed from: private */
    public static final String TAG = DJIMonitor.class.getSimpleName();
    private static final ReentrantLock atakGoServiceLock = new ReentrantLock();
    private static AtakGoServiceConnection conn = null;
    public static final AtomicReference<String> uasFileListState = new AtomicReference<>("UNKNOWN");
    private static final ArrayList<OnUASSpeakerListener> uasSpeakerListeners = new ArrayList<>();
    private final BroadcastReceiver atakGoReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            char c = 65535;
            switch (action.hashCode()) {
                case -1224957500:
                    if (action.equals(DJIMonitor.ACTION_ATAKGO_TOGGLESCREEN)) {
                        c = 0;
                        break;
                    }
                    break;
                case -115676087:
                    if (action.equals(DJIMonitor.ACTION_ATAKGO_TOGGLEBROADCAST)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1782148483:
                    if (action.equals(DJIMonitor.ACTION_ATAKGO_TOAST)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    UASToolDropDownReceiver.getInstance().toggleScreenSize();
                    return;
                case 1:
                    UASToolDropDownReceiver.getInstance().toggleBroadcast();
                    return;
                case 2:
                    UASToolDropDownReceiver.toast(intent.getStringExtra(DJIMonitor.EXTRA_ATAKGO_MESSAGE), intent.getIntExtra(DJIMonitor.EXTRA_ATAKGO_DURATION, 0));
                    return;
                default:
                    UASToolDropDownReceiver.toast("Unknown intent from ATAKGo", 1);
                    return;
            }
        }
    };
    private DJIUASItem currentUasItem;
    private boolean hasATAKGo;
    private final SharedPreferences sharedPrefs;
    /* access modifiers changed from: private */
    public final List<UASItem> uasList;

    public void onIncomingCot(CotEvent cotEvent) {
    }

    public void setCaptureToStorage(boolean z) {
    }

    static {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "atak" + File.separator + "tools" + File.separator + "uastool" + File.separator + "speaker";
        SOUND_DIR_PATH = str;
        QUICKSOUND_DIR_PATH = str + File.separator + "quick" + File.separator;
    }

    public DJIMonitor(Context context, SharedPreferences sharedPreferences) {
        super(context, DJIUASItem.DISPLAY_NAME);
        this.sharedPrefs = sharedPreferences;
        this.uasList = new ArrayList();
        this.currentUasItem = null;
        checkDJISoundFile();
    }

    public static void onUASFileStateChange(String str) {
        uasFileListState.set(str);
        ArrayList<OnUASSpeakerListener> arrayList = uasSpeakerListeners;
        if (arrayList != null) {
            Iterator<OnUASSpeakerListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onUASFileStateChange(str);
            }
        }
    }

    public static void onUASFileRefreshComplete(boolean z, String str) {
        ArrayList<OnUASSpeakerListener> arrayList = uasSpeakerListeners;
        if (arrayList != null) {
            Iterator<OnUASSpeakerListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onUASFileRefreshComplete(z, str);
            }
        }
    }

    public static void onUASFileLoadComplete(boolean z, String str) {
        ArrayList<OnUASSpeakerListener> arrayList = uasSpeakerListeners;
        if (arrayList != null) {
            Iterator<OnUASSpeakerListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onUASFileUploadComplete(z, str);
            }
        }
    }

    public static void onUASFileDeleted(boolean z, String str, String str2) {
        ArrayList<OnUASSpeakerListener> arrayList = uasSpeakerListeners;
        if (arrayList != null) {
            Iterator<OnUASSpeakerListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onUASFileDeleted(z, str, str2);
            }
        }
    }

    public static void onUASSoundPlaying(boolean z, String str, String str2) {
        ArrayList<OnUASSpeakerListener> arrayList = uasSpeakerListeners;
        if (arrayList != null) {
            Iterator<OnUASSpeakerListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onUASSoundPlaying(z, str, str2);
            }
        }
    }

    public static void onUASSoundStopped(boolean z, String str) {
        ArrayList<OnUASSpeakerListener> arrayList = uasSpeakerListeners;
        if (arrayList != null) {
            Iterator<OnUASSpeakerListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onUASSoundStopped(z, str);
            }
        }
    }

    public static String getUASFileState() {
        return uasFileListState.get();
    }

    public static void addUASFileListener(OnUASSpeakerListener onUASSpeakerListener) {
        ArrayList<OnUASSpeakerListener> arrayList = uasSpeakerListeners;
        if (!arrayList.contains(onUASSpeakerListener)) {
            arrayList.add(onUASSpeakerListener);
        }
    }

    public static void removeUASFileListener(OnUASSpeakerListener onUASSpeakerListener) {
        uasSpeakerListeners.remove(onUASSpeakerListener);
    }

    private static boolean isATAKGoInstalled() {
        try {
            return MapView.getMapView().getContext().getPackageManager().getApplicationInfo("com.atakmap.android.atakgo.dji", 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public synchronized void beginMonitoring(boolean z) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_ATAKGO_TOAST);
        intentFilter.addAction(ACTION_ATAKGO_CAMSHOT);
        intentFilter.addAction(ACTION_ATAKGO_MAPSHOT);
        intentFilter.addAction(ACTION_ATAKGO_TOGGLESCREEN);
        intentFilter.addAction(ACTION_ATAKGO_TOGGLEBROADCAST);
        intentFilter.addAction(ACTION_ATAKGO_TRIGGER01);
        intentFilter.addAction(ACTION_ATAKGO_TRIGGER02);
        this.pluginContext.registerReceiver(this.atakGoReceiver, intentFilter);
        boolean isATAKGoInstalled = isATAKGoInstalled();
        this.hasATAKGo = isATAKGoInstalled;
        if (isATAKGoInstalled) {
            UASToolDropDownReceiver.toast("UAS Tool monitoring " + this.platform + " platforms", 0);
            connectToService();
            AtakGoServiceConnection serviceConnection = getServiceConnection();
            if (serviceConnection != null) {
                serviceConnection.startAutoRestarting();
            }
            this.schedulerHandle = this.scheduler.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    try {
                        if (DJIMonitor.this.uasList != null && DJIMonitor.this.uasDetectedListener != null) {
                            DJIMonitor.this.uasDetectedListener.onUASDetected(DJIMonitor.this.uasList);
                        }
                    } catch (Exception e) {
                        UASToolDropDownReceiver.toast("DJIMonitor crash", 1);
                        Log.e(DJIMonitor.TAG, "DJIMonitor crash: ", e);
                    }
                }
            }, 1000, 1000, TimeUnit.MILLISECONDS);
        } else {
            UASToolDropDownReceiver.toast("ATAK Go not installed for DJI monitoring", 1);
        }
    }

    public synchronized void handlePlatformConnect(String str, String str2, boolean z, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!listContains(str)) {
            DJIUASItem dJIUASItem = new DJIUASItem(str, getCallsign(), true);
            this.currentUasItem = dJIUASItem;
            this.uasList.add(dJIUASItem);
            AtakGoServiceConnection serviceConnection = getServiceConnection();
            if (serviceConnection != null) {
                uasFileListState.set(serviceConnection.getFileListState());
                serviceConnection.register();
            }
        }
        this.currentUasItem.setModelName(str2);
        this.currentUasItem.setCanZoomCamera(z);
        DJIUASItem dJIUASItem2 = this.currentUasItem;
        if (f == -1.0f) {
            f = 8000.0f;
        }
        dJIUASItem2.setMaxDistance(Float.valueOf(f));
        DJIUASItem dJIUASItem3 = this.currentUasItem;
        if (f2 == -1.0f) {
            f2 = 100.0f;
        }
        dJIUASItem3.setMaxAltitude(Float.valueOf(f2));
        this.currentUasItem.setGimbalCapabilities(f3, f4, f5, f6);
        applyCustomButtons();
    }

    private boolean listContains(String str) {
        for (UASItem uid : this.uasList) {
            if (uid.getUid().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void handlePlatformDisconnect(boolean z) {
        if (!z) {
            UASToolDropDownReceiver.toast("UAS Tool lost connection to platform", 0);
        }
        DJIUASItem dJIUASItem = this.currentUasItem;
        if (dJIUASItem != null) {
            this.uasList.remove(dJIUASItem);
            this.currentUasItem = null;
        }
    }

    private boolean connectToService() {
        return startAtakGo(new AtakGoServiceConnection());
    }

    public static AtakGoServiceConnection getServiceConnection() {
        ReentrantLock reentrantLock = atakGoServiceLock;
        reentrantLock.lock();
        try {
            AtakGoServiceConnection atakGoServiceConnection = conn;
            reentrantLock.unlock();
            return atakGoServiceConnection;
        } catch (Throwable th) {
            atakGoServiceLock.unlock();
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:2|3)|4|5|8|9|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        com.atakmap.coremap.log.Log.e(TAG, "error unregistering ATAKgoReceiver", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void endMonitoring() {
        /*
            r3 = this;
            boolean r0 = r3.hasATAKGo
            if (r0 == 0) goto L_0x0007
            r3.stopATAKGo()     // Catch:{ Exception -> 0x0007 }
        L_0x0007:
            android.content.Context r0 = r3.pluginContext     // Catch:{ Exception -> 0x000f }
            android.content.BroadcastReceiver r1 = r3.atakGoReceiver     // Catch:{ Exception -> 0x000f }
            r0.unregisterReceiver(r1)     // Catch:{ Exception -> 0x000f }
            goto L_0x0017
        L_0x000f:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "error unregistering ATAKgoReceiver"
            com.atakmap.coremap.log.Log.e(r1, r2, r0)
        L_0x0017:
            r3.stopATAKGo()     // Catch:{ Exception -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "error stopping ATAKgo"
            com.atakmap.coremap.log.Log.e(r1, r2, r0)
        L_0x0023:
            super.endMonitoring()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJIMonitor.endMonitoring():void");
    }

    public void stopATAKGo() {
        AtakGoServiceConnection serviceConnection = getServiceConnection();
        if (serviceConnection != null) {
            serviceConnection.stopAutoRestarting();
            try {
                serviceConnection.getService().stopAtakGo();
                if (this.pluginContext != null) {
                    this.pluginContext.unbindService(serviceConnection);
                }
            } catch (RemoteException | IllegalArgumentException e) {
                Log.e(TAG, "Failed to tell ATAKGo to stop: ", e);
            }
        }
        sendIntentATAKGo(new Intent(EXIT_ATAKGO));
    }

    public static boolean sendIntentATAKGo(Intent intent) {
        try {
            intent.setPackage("com.atakmap.android.atakgo.dji");
            MapView.getMapView().getContext().startService(intent);
            return true;
        } catch (Exception e) {
            UASToolDropDownReceiver.toast("UAS Tool had an error communicating with ATAKGo: " + e.getLocalizedMessage(), 1);
            return false;
        }
    }

    public boolean monitors(String str) {
        return str.equals(DJIUASItem.DISPLAY_NAME);
    }

    public synchronized List<UASItem> getDetectedUasList() {
        return this.uasList;
    }

    private String getCallsign() {
        String string = this.sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, "");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String str = "UAS-" + UASToolDropDownReceiver.getInstance().getMapView().getDeviceCallsign();
        return TextUtils.isEmpty(str) ? Integer.toString(new Random().nextInt(1000) + 1) : str;
    }

    public boolean startAtakGo(AtakGoServiceConnection atakGoServiceConnection) {
        String str = TAG;
        Log.d(str, "Connecting to ATAK Go Service");
        Intent intent = new Intent();
        ReentrantLock reentrantLock = atakGoServiceLock;
        reentrantLock.lock();
        try {
            conn = atakGoServiceConnection;
            intent.setClassName("com.atakmap.android.atakgo.dji", "com.atakmap.android.atakgo.main.DjiIntentService");
            boolean bindService = this.pluginContext.bindService(intent, atakGoServiceConnection, 1);
            reentrantLock.unlock();
            Log.d(str, "Binding to ATAK Go Service");
            return bindService;
        } catch (Throwable th) {
            atakGoServiceLock.unlock();
            throw th;
        }
    }

    private void applyCustomButtons() {
        DJIButtonsScreen.applyAllCustomButtons(this.sharedPrefs, this.pluginContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r0 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        if (r2 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004f, code lost:
        if (r0 != null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkDJISoundFile() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = SOUND_DIR_PATH
            java.lang.String r2 = "dji_test.wav"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x005e
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x005e }
            android.content.Context r2 = r5.pluginContext     // Catch:{ Exception -> 0x005e }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x005e }
            r3 = 2131296256(0x7f090000, float:1.8210424E38)
            java.io.InputStream r2 = r2.openRawResource(r3)     // Catch:{ Exception -> 0x005e }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x004a }
            r3.<init>(r0)     // Catch:{ all -> 0x004a }
        L_0x0024:
            int r0 = r2.read(r1)     // Catch:{ all -> 0x0038 }
            if (r0 <= 0) goto L_0x002f
            r4 = 0
            r3.write(r1, r4, r0)     // Catch:{ all -> 0x0038 }
            goto L_0x0024
        L_0x002f:
            r3.close()     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x005e
            r2.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x005e
        L_0x0038:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x003a }
        L_0x003a:
            r1 = move-exception
            if (r0 == 0) goto L_0x0046
            r3.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0049
        L_0x0041:
            r3 = move-exception
            r0.addSuppressed(r3)     // Catch:{ all -> 0x004a }
            goto L_0x0049
        L_0x0046:
            r3.close()     // Catch:{ all -> 0x004a }
        L_0x0049:
            throw r1     // Catch:{ all -> 0x004a }
        L_0x004a:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x004c }
        L_0x004c:
            r1 = move-exception
            if (r2 == 0) goto L_0x005d
            if (r0 == 0) goto L_0x005a
            r2.close()     // Catch:{ all -> 0x0055 }
            goto L_0x005d
        L_0x0055:
            r2 = move-exception
            r0.addSuppressed(r2)     // Catch:{ Exception -> 0x005e }
            goto L_0x005d
        L_0x005a:
            r2.close()     // Catch:{ Exception -> 0x005e }
        L_0x005d:
            throw r1     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.dji.DJIMonitor.checkDJISoundFile():void");
    }
}
