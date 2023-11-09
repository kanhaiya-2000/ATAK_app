package com.atakmap.android.uastool.trillium;

import android.content.Context;
import android.content.SharedPreferences;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.utils.CaptureToStorage;
import com.atakmap.coremap.log.Log;
import com.trilliumeng.android.orion.sdk.OrionSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class TrilliumMonitor extends PlatformMonitor {
    private static final String TAG = "com.atakmap.android.uastool.trillium.TrilliumMonitor";
    private static String defaultUASItemUID;
    private static OrionSdk orionSdk;
    private CaptureToStorage captureToStorage;
    private final SharedPreferences sharedPrefs;
    private final Map<String, Long> uasLastUpdate;
    private final Map<String, TrilliumUASItem> uasList;

    public static OrionSdk getOrionSdk() {
        return orionSdk;
    }

    public TrilliumMonitor(Context context, SharedPreferences sharedPreferences) {
        super(context, TrilliumUASItem.DISPLAY_NAME);
        if (MapView.getMapView().getSelfMarker() != null) {
            defaultUASItemUID = MapView.getMapView().getSelfMarker().getUID() + TrilliumUASItem.DISPLAY_NAME;
        } else {
            defaultUASItemUID = UUID.randomUUID().toString();
        }
        this.sharedPrefs = sharedPreferences;
        this.uasList = new HashMap();
        this.uasLastUpdate = new HashMap();
        Log.d(TAG, "Trillium Monitor created.");
    }

    public boolean monitors(String str) {
        return str.equals(TrilliumUASItem.DISPLAY_NAME);
    }

    public void setCaptureToStorage(boolean z) {
        CaptureToStorage captureToStorage2 = this.captureToStorage;
        if (captureToStorage2 != null) {
            captureToStorage2.setCaptureToStorage(z);
        }
    }

    public List<UASItem> getDetectedUasList() {
        String uid = getUID();
        if (uid != null) {
            onConnectionActivity(uid, getCallsign(), (String) null);
        }
        synchronized (this.uasList) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<Map.Entry<String, Long>> it = this.uasLastUpdate.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (currentTimeMillis - ((Long) next.getValue()).longValue() > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
                    this.uasList.remove(next.getKey());
                    String str = TAG;
                    Log.d(str, "Removed UASItem: " + ((String) next.getKey()));
                    it.remove();
                }
            }
        }
        String str2 = TAG;
        Log.d(str2, "uasList: " + this.uasList.toString());
        return new ArrayList(this.uasList.values());
    }

    public void beginMonitoring(boolean z) {
        super.beginMonitoring(z);
        Log.d(TAG, "Beginning Monitoring");
        this.captureToStorage = new CaptureToStorage(TrilliumUASItem.DISPLAY_NAME);
        setCaptureToStorage(z);
        Integer.parseInt(TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_PORT);
        String string = this.sharedPrefs.getString(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_PORT, TrilliumPrefHandler.DEFAULT_PLATFORM_TRILLIUM_PORT);
        this.sharedPrefs.getString(TrilliumPrefHandler.PREF_PLATFORM_TRILLIUM_IP, "127.0.0.1");
        try {
            Integer.parseInt(string);
        } catch (Exception unused) {
        }
        OrionSdk orionSdk2 = orionSdk;
        if (orionSdk2 != null) {
            orionSdk2.stop();
        }
        orionSdk = new OrionSdk();
    }

    public void endMonitoring() {
        super.endMonitoring();
        orionSdk.stop();
        orionSdk = null;
    }

    /* access modifiers changed from: protected */
    public void onConnectionActivity(String str, String str2, String str3) {
        synchronized (this.uasList) {
            if (!this.uasLastUpdate.containsKey(str)) {
                TrilliumUASItem trilliumUASItem = new TrilliumUASItem(str, str2, true);
                if (str3 != null && !str3.isEmpty()) {
                    trilliumUASItem.setModelName(str3);
                }
                this.uasList.put(str, trilliumUASItem);
                String str4 = TAG;
                Log.d(str4, "added uasitem: " + str);
            }
            this.uasLastUpdate.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public boolean isConnected() {
        return orionSdk.isConnected();
    }

    public void restart() {
        Log.d(TAG, "Restarting Trillium Monitor");
        endMonitoring();
        beginMonitoring(false);
    }

    public String getCallsign() {
        String str = "UAS-" + MapView.getMapView().getDeviceCallsign();
        String string = this.sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, (String) null);
        return (string == null || string.isEmpty()) ? str : string;
    }

    public String getUID() {
        OrionSdk orionSdk2 = orionSdk;
        if (orionSdk2 == null || !orionSdk2.isConnected()) {
            return null;
        }
        if (orionSdk.getAci() != null) {
            return orionSdk.getAci().UID;
        }
        return defaultUASItemUID;
    }
}
