package com.atakmap.android.uastool.r80d;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.aeryon.java.AdkInterface;
import com.aeryon.java.event.DiscoveryEvent;
import com.aeryon.java.event.EventListener;
import com.aeryon.java.types.Aircraft;
import com.aeryon.java.types.DeviceInfo;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.UASToolDropDownReceiver;
import com.atakmap.android.uastool.pagers.avahi.AvahiServiceInfo;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.utils.AvahiService;
import com.atakmap.coremap.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class R80dMonitor extends PlatformMonitor {
    private static final String TAG = "R80dMonitor";
    /* access modifiers changed from: private */
    public static final ReadWriteLock acLock = new ReentrantReadWriteLock();
    public static AvahiService avahiService;
    public static ArrayList<AvahiServiceInfo> mServiceInfo = new ArrayList<>();
    /* access modifiers changed from: private */
    public static boolean showIncompatibleWarningOnce = true;
    private final EventListener<DiscoveryEvent> discoveryEventListener = new EventListener<DiscoveryEvent>() {
        public void handleEvent(DiscoveryEvent discoveryEvent) {
            int i;
            boolean z;
            Log.d(EventListener.TAG, "R80d Received DiscoveryEvent in listener: " + discoveryEvent);
            final DeviceInfo deviceInfo = discoveryEvent.getDeviceInfo();
            String serial = deviceInfo.getSerial();
            boolean z2 = deviceInfo.getDeviceType() == DeviceInfo.ADK_DEVICE_TYPE.Aircraft;
            boolean z3 = deviceInfo.getDeviceType() == DeviceInfo.ADK_DEVICE_TYPE.BaseStation;
            String string = R80dMonitor.this.sharedPreferences.getString(R80dPrefHandler.PREF_PLATFORM_SERIAL, (String) null);
            int i2 = C20192.f8410x9d258df3[discoveryEvent.getType().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    Log.d(EventListener.TAG, "r80d CONNECTION LOST");
                    if (z2) {
                        R80dMonitor.acLock.writeLock().lock();
                        try {
                            R80dMonitor.this.items.clear();
                        } finally {
                            UASToolDropDownReceiver.toast("R80D Connection Lost", 0);
                            R80dMonitor.acLock.writeLock().unlock();
                        }
                    }
                }
            } else if (z2) {
                Aircraft aircraft = deviceInfo.getAircraft();
                try {
                    i = Integer.parseInt(serial);
                } catch (Exception unused) {
                    i = 0;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("uri", "ADK: " + deviceInfo.getVersion().toString());
                Iterator<AvahiServiceInfo> it = R80dMonitor.mServiceInfo.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getPort() == i) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    String name = deviceInfo.getDeviceType().name();
                    AvahiServiceInfo avahiServiceInfo = new AvahiServiceInfo(name, "ADK: " + deviceInfo.getVersion().toString(), i, hashMap);
                    avahiServiceInfo.setHost(deviceInfo.getHost());
                    R80dMonitor.mServiceInfo.add(avahiServiceInfo);
                    if (R80dMonitor.avahiService != null) {
                        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                            public void run() {
                                R80dMonitor.avahiService.listChanged();
                            }
                        });
                    }
                }
                if (string == null || string.isEmpty() || string.equals(serial)) {
                    UASToolDropDownReceiver.toast("R80D Found: " + deviceInfo.getHost() + " sn: " + deviceInfo.getSerial() + " ADK: " + deviceInfo.getVersion(), 0);
                    if (R80dMonitor.showIncompatibleWarningOnce && !deviceInfo.getVersion().toString().equals(AdkInterface.getADKVersion())) {
                        boolean unused2 = R80dMonitor.showIncompatibleWarningOnce = false;
                        ((Activity) MapView.getMapView().getContext()).runOnUiThread(new Runnable() {
                            public void run() {
                                UASToolDropDownReceiver instance = UASToolDropDownReceiver.getInstance();
                                instance.helpPopup("Incompatible Aircraft Firmware Version", "Warning: UASTool is designed to work with ADK Version " + AdkInterface.getADKVersion() + ". This aircraft is version " + deviceInfo.getVersion().toString() + ". Some features may not work, or may cause unexpected behavior. Proceed with caution");
                            }
                        });
                    }
                    R80dMonitor.acLock.writeLock().lock();
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("R80d Setting connected Aircraft =");
                        sb.append(aircraft == null ? "null" : "notnull");
                        Log.d(EventListener.TAG, sb.toString());
                        R80dUASItem r80dUASItem = new R80dUASItem("R80D_" + aircraft.getSerial(), "", true);
                        r80dUASItem.setConnection(aircraft);
                        R80dMonitor.this.items.add(r80dUASItem);
                    } finally {
                        R80dMonitor.acLock.writeLock().unlock();
                    }
                } else {
                    Log.d(EventListener.TAG, "R80d: skipped aircraft: " + serial + " serial not selected");
                }
            } else if (z3) {
                Log.d(EventListener.TAG, "Found baseStation, NoOp");
            }
        }
    };
    /* access modifiers changed from: private */
    public final List<UASItem> items = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final SharedPreferences sharedPreferences;
    private boolean shouldCaptureToStorage = false;

    public static void clearAvahiList() {
    }

    public R80dMonitor(Context context, SharedPreferences sharedPreferences2) {
        super(context, R80dUASItem.DISPLAY_NAME);
        this.sharedPreferences = sharedPreferences2;
    }

    public static ArrayList<AvahiServiceInfo> getAvailableDevices() {
        return mServiceInfo;
    }

    /* access modifiers changed from: protected */
    public List<UASItem> getDetectedUasList() {
        Log.v(TAG, "getDetectedUasList()");
        return this.items;
    }

    public void beginMonitoring(boolean z) {
        super.beginMonitoring(true);
        AdkInterface.init();
        AdkInterface.setDiscoveryListener(this.discoveryEventListener);
        AdkInterface.setMapViewContext(MapView.getMapView().getContext());
        mServiceInfo.clear();
        HashMap hashMap = new HashMap();
        hashMap.put("uri", "Connect to any/the first aircraft available");
        AvahiServiceInfo avahiServiceInfo = new AvahiServiceInfo("Any", "Connect to any/the first aircraft available", 0, hashMap);
        avahiServiceInfo.setHost("");
        mServiceInfo.add(avahiServiceInfo);
    }

    public void endMonitoring() {
        super.endMonitoring();
        for (UASItem next : this.items) {
            if (next instanceof R80dUASItem) {
                ((R80dUASItem) next).destroy();
            }
        }
        AdkInterface.destroy();
    }

    /* renamed from: com.atakmap.android.uastool.r80d.R80dMonitor$2 */
    /* synthetic */ class C20192 {

        /* renamed from: $SwitchMap$com$aeryon$java$event$DiscoveryEvent$DISCOVERY_EVENT_TYPE */
        static final /* synthetic */ int[] f8410x9d258df3;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.aeryon.java.event.DiscoveryEvent$DISCOVERY_EVENT_TYPE[] r0 = com.aeryon.java.event.DiscoveryEvent.DISCOVERY_EVENT_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8410x9d258df3 = r0
                com.aeryon.java.event.DiscoveryEvent$DISCOVERY_EVENT_TYPE r1 = com.aeryon.java.event.DiscoveryEvent.DISCOVERY_EVENT_TYPE.NEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8410x9d258df3     // Catch:{ NoSuchFieldError -> 0x001d }
                com.aeryon.java.event.DiscoveryEvent$DISCOVERY_EVENT_TYPE r1 = com.aeryon.java.event.DiscoveryEvent.DISCOVERY_EVENT_TYPE.LOST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8410x9d258df3     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.aeryon.java.event.DiscoveryEvent$DISCOVERY_EVENT_TYPE r1 = com.aeryon.java.event.DiscoveryEvent.DISCOVERY_EVENT_TYPE.UPDATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8410x9d258df3     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.aeryon.java.event.DiscoveryEvent$DISCOVERY_EVENT_TYPE r1 = com.aeryon.java.event.DiscoveryEvent.DISCOVERY_EVENT_TYPE.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.r80d.R80dMonitor.C20192.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public SharedPreferences prefs() {
        return this.sharedPreferences;
    }

    public boolean monitors(String str) {
        return this.platform.equals(str);
    }

    public void setCaptureToStorage(boolean z) {
        this.shouldCaptureToStorage = z;
    }

    public boolean getShouldCaptureToStorage() {
        return this.shouldCaptureToStorage;
    }

    public void setShouldCaptureToStorage(boolean z) {
        this.shouldCaptureToStorage = z;
    }
}
