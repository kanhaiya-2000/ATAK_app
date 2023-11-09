package com.atakmap.android.uastool.mavlink;

import android.content.Context;
import android.content.SharedPreferences;
import com.atakmap.android.maps.MapView;
import com.atakmap.android.uastool.UASItem;
import com.atakmap.android.uastool.plugin.PlatformMonitor;
import com.atakmap.android.uastool.prefs.UASToolPreferenceFragment;
import com.atakmap.android.uastool.utils.CaptureToStorage;
import com.atakmap.coremap.log.Log;
import com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.droidplanner.services.android.impl.core.drone.variables.HeartBeat;

public class MAVLinkMonitor extends PlatformMonitor {
    private static final String TAG = "com.atakmap.android.uastool.mavlink.MAVLinkMonitor";
    private static String currentUASItemUID;
    private static String defaultUASItemUID;
    private CaptureToStorage captureToStorage;
    private final SharedPreferences sharedPrefs;
    private final Map<String, Long> uasLastUpdate;
    private final Map<String, MAVLinkUASItem> uasList;
    private MavlinkVehicle vehicle;

    public MAVLinkMonitor(Context context, SharedPreferences sharedPreferences) {
        super(context, MAVLinkUASItem.DISPLAY_NAME);
        if (MapView.getMapView().getSelfMarker() != null) {
            defaultUASItemUID = MapView.getMapView().getSelfMarker().getUID() + ".MAVLINK";
        } else {
            defaultUASItemUID = UUID.randomUUID().toString();
        }
        this.sharedPrefs = sharedPreferences;
        this.uasList = new HashMap();
        this.uasLastUpdate = new HashMap();
        Log.d(TAG, "MAVLinkMonitor created.");
    }

    public boolean monitors(String str) {
        return str.equals(MAVLinkUASItem.DISPLAY_NAME);
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
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, Long>> it = this.uasLastUpdate.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (currentTimeMillis - ((Long) next.getValue()).longValue() > HeartBeat.HEARTBEAT_NORMAL_TIMEOUT) {
                this.uasList.remove(next.getKey());
                currentUASItemUID = null;
                String str = TAG;
                Log.d(str, "Removed UASItem: " + ((String) next.getKey()));
                it.remove();
            }
        }
        return new ArrayList(this.uasList.values());
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d9 A[Catch:{ Exception -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ff A[Catch:{ Exception -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x004e A[Catch:{ Exception -> 0x0117 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void beginMonitoring(boolean r12) {
        /*
            r11 = this;
            super.beginMonitoring(r12)
            java.lang.String r0 = TAG
            java.lang.String r1 = "Beginning Monitoring"
            com.atakmap.coremap.log.Log.d(r0, r1)
            com.atakmap.android.uastool.utils.CaptureToStorage r0 = new com.atakmap.android.uastool.utils.CaptureToStorage
            java.lang.String r1 = "mavlink"
            r0.<init>(r1)
            r11.captureToStorage = r0
            r11.setCaptureToStorage(r12)
            java.lang.String r12 = "14550"
            int r0 = java.lang.Integer.parseInt(r12)
            android.content.SharedPreferences r1 = r11.sharedPrefs
            java.lang.String r2 = "uastool.mavlink.pref_platform_port"
            java.lang.String r12 = r1.getString(r2, r12)
            android.content.SharedPreferences r1 = r11.sharedPrefs
            java.lang.String r2 = "uastool.mavlink.pref_platform_ip"
            java.lang.String r3 = "127.0.0.1"
            java.lang.String r1 = r1.getString(r2, r3)
            android.content.SharedPreferences r2 = r11.sharedPrefs
            java.lang.String r3 = "uastool.mavlink.pref_dialect"
            java.lang.String r4 = "AUTO"
            java.lang.String r2 = r2.getString(r3, r4)
            int r0 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            android.content.SharedPreferences r12 = r11.sharedPrefs     // Catch:{ Exception -> 0x0117 }
            java.lang.String r3 = "uastool.mavlink.pref_network_type"
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle$NETWORK_TYPE r4 = com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.NETWORK_TYPE.TCP     // Catch:{ Exception -> 0x0117 }
            java.lang.String r4 = r4.name()     // Catch:{ Exception -> 0x0117 }
            java.lang.String r12 = r12.getString(r3, r4)     // Catch:{ Exception -> 0x0117 }
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle r3 = r11.vehicle     // Catch:{ Exception -> 0x0117 }
            if (r3 == 0) goto L_0x0051
            r3.exit()     // Catch:{ Exception -> 0x0117 }
        L_0x0051:
            int[] r3 = com.atakmap.android.uastool.mavlink.MAVLinkMonitor.C15141.f8393x659d5eb4     // Catch:{ Exception -> 0x0117 }
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle$NETWORK_TYPE r12 = com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.NETWORK_TYPE.valueOf(r12)     // Catch:{ Exception -> 0x0117 }
            int r12 = r12.ordinal()     // Catch:{ Exception -> 0x0117 }
            r12 = r3[r12]     // Catch:{ Exception -> 0x0117 }
            r3 = 2
            r4 = 0
            if (r12 == r3) goto L_0x00d9
            r3 = 3
            java.lang.String r5 = ":"
            if (r12 == r3) goto L_0x00b0
            r3 = 4
            if (r12 == r3) goto L_0x0092
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle r12 = new com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle     // Catch:{ Exception -> 0x0117 }
            com.bbn.ccast.mavlink.TcpMavlinkTransport r3 = new com.bbn.ccast.mavlink.TcpMavlinkTransport     // Catch:{ Exception -> 0x0117 }
            r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x0117 }
            r12.<init>(r3)     // Catch:{ Exception -> 0x0117 }
            r11.vehicle = r12     // Catch:{ Exception -> 0x0117 }
            java.lang.String r12 = TAG     // Catch:{ Exception -> 0x0117 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0117 }
            r3.<init>()     // Catch:{ Exception -> 0x0117 }
            java.lang.String r6 = "Connecting to TCP vehicle at "
            r3.append(r6)     // Catch:{ Exception -> 0x0117 }
            r3.append(r1)     // Catch:{ Exception -> 0x0117 }
            r3.append(r5)     // Catch:{ Exception -> 0x0117 }
            r3.append(r0)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0117 }
            com.atakmap.coremap.log.Log.d(r12, r0)     // Catch:{ Exception -> 0x0117 }
            goto L_0x00fb
        L_0x0092:
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle r12 = new com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle     // Catch:{ Exception -> 0x0117 }
            com.bbn.ccast.mavlink.SerialMavlinkTransport r0 = new com.bbn.ccast.mavlink.SerialMavlinkTransport     // Catch:{ Exception -> 0x0117 }
            java.lang.String r6 = "ttyS0"
            r7 = 57600(0xe100, float:8.0715E-41)
            r8 = 8
            r9 = 0
            r10 = 1
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0117 }
            r12.<init>(r0)     // Catch:{ Exception -> 0x0117 }
            r11.vehicle = r12     // Catch:{ Exception -> 0x0117 }
            java.lang.String r12 = TAG     // Catch:{ Exception -> 0x0117 }
            java.lang.String r0 = "Connecting to Serial vehicle at /dev/ttyS0 57600 8N1"
            com.atakmap.coremap.log.Log.d(r12, r0)     // Catch:{ Exception -> 0x0117 }
            goto L_0x00fb
        L_0x00b0:
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle r12 = new com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle     // Catch:{ Exception -> 0x0117 }
            com.bbn.ccast.mavlink.UdpMavlinkTransport r3 = new com.bbn.ccast.mavlink.UdpMavlinkTransport     // Catch:{ Exception -> 0x0117 }
            r3.<init>(r1, r0)     // Catch:{ Exception -> 0x0117 }
            r12.<init>(r3)     // Catch:{ Exception -> 0x0117 }
            r11.vehicle = r12     // Catch:{ Exception -> 0x0117 }
            java.lang.String r12 = TAG     // Catch:{ Exception -> 0x0117 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0117 }
            r3.<init>()     // Catch:{ Exception -> 0x0117 }
            java.lang.String r6 = "Connecting to UDP_Client vehicle at "
            r3.append(r6)     // Catch:{ Exception -> 0x0117 }
            r3.append(r1)     // Catch:{ Exception -> 0x0117 }
            r3.append(r5)     // Catch:{ Exception -> 0x0117 }
            r3.append(r0)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0117 }
            com.atakmap.coremap.log.Log.d(r12, r0)     // Catch:{ Exception -> 0x0117 }
            goto L_0x00fb
        L_0x00d9:
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle r12 = new com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle     // Catch:{ Exception -> 0x0117 }
            com.bbn.ccast.mavlink.UdpMavlinkTransport r1 = new com.bbn.ccast.mavlink.UdpMavlinkTransport     // Catch:{ Exception -> 0x0117 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0117 }
            r12.<init>(r1)     // Catch:{ Exception -> 0x0117 }
            r11.vehicle = r12     // Catch:{ Exception -> 0x0117 }
            java.lang.String r12 = TAG     // Catch:{ Exception -> 0x0117 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0117 }
            r1.<init>()     // Catch:{ Exception -> 0x0117 }
            java.lang.String r3 = "Listening for UDP vehicle at 0.0.0.0:"
            r1.append(r3)     // Catch:{ Exception -> 0x0117 }
            r1.append(r0)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0117 }
            com.atakmap.coremap.log.Log.d(r12, r0)     // Catch:{ Exception -> 0x0117 }
        L_0x00fb:
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle r12 = r11.vehicle     // Catch:{ Exception -> 0x0117 }
            if (r12 == 0) goto L_0x0116
            com.bbn.ccast.mavlink.MavLinkThread r12 = r12.getMavLinkThread()     // Catch:{ Exception -> 0x0117 }
            r12.setDialect(r2)     // Catch:{ Exception -> 0x0117 }
            com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle r12 = r11.vehicle     // Catch:{ Exception -> 0x0117 }
            com.bbn.ccast.mavlink.MavLinkThread r12 = r12.getMavLinkThread()     // Catch:{ Exception -> 0x0117 }
            android.content.SharedPreferences r0 = r11.sharedPrefs     // Catch:{ Exception -> 0x0117 }
            java.lang.String r1 = "uastool.mavlink.pref_joystick_decay"
            boolean r0 = r0.getBoolean(r1, r4)     // Catch:{ Exception -> 0x0117 }
            r12.decay_control = r0     // Catch:{ Exception -> 0x0117 }
        L_0x0116:
            return
        L_0x0117:
            r12 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r1 = "Failed to create MavlinkVehicle: "
            com.atakmap.coremap.log.Log.e(r0, r1, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.mavlink.MAVLinkMonitor.beginMonitoring(boolean):void");
    }

    /* renamed from: com.atakmap.android.uastool.mavlink.MAVLinkMonitor$1 */
    /* synthetic */ class C15141 {

        /* renamed from: $SwitchMap$com$bbn$vehicleinterface$mavlink$platform$MavlinkVehicle$NETWORK_TYPE */
        static final /* synthetic */ int[] f8393x659d5eb4;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle$NETWORK_TYPE[] r0 = com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.NETWORK_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8393x659d5eb4 = r0
                com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle$NETWORK_TYPE r1 = com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.NETWORK_TYPE.TCP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8393x659d5eb4     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle$NETWORK_TYPE r1 = com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.NETWORK_TYPE.UDP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8393x659d5eb4     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle$NETWORK_TYPE r1 = com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.NETWORK_TYPE.UDP_CLIENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8393x659d5eb4     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle$NETWORK_TYPE r1 = com.bbn.vehicleinterface.mavlink.platform.MavlinkVehicle.NETWORK_TYPE.SERIAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.atakmap.android.uastool.mavlink.MAVLinkMonitor.C15141.<clinit>():void");
        }
    }

    public void endMonitoring() {
        super.endMonitoring();
        MavlinkVehicle mavlinkVehicle = this.vehicle;
        if (mavlinkVehicle != null) {
            mavlinkVehicle.exit();
        }
        this.vehicle = null;
    }

    /* access modifiers changed from: protected */
    public void onConnectionActivity(String str, String str2, String str3) {
        synchronized (this.uasList) {
            if (!this.uasLastUpdate.containsKey(str)) {
                MAVLinkUASItem mAVLinkUASItem = new MAVLinkUASItem(str, str2, true);
                if (str3 != null && !str3.isEmpty()) {
                    mAVLinkUASItem.setModelName(str3);
                }
                mAVLinkUASItem.setVehicle(this.vehicle);
                this.uasList.put(str, mAVLinkUASItem);
                String str4 = TAG;
                Log.d(str4, "added uasitem: " + str);
                currentUASItemUID = str;
            }
            this.uasLastUpdate.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void restart() {
        Log.d(TAG, "Restarting MAVLink Monitor");
        endMonitoring();
        beginMonitoring(false);
    }

    public String getCallsign() {
        String str = "UAS-" + MapView.getMapView().getDeviceCallsign();
        String string = this.sharedPrefs.getString(UASToolPreferenceFragment.PREF_CALLSIGN, (String) null);
        return (string == null || string.isEmpty()) ? str : string;
    }

    public String getUID() {
        MavlinkVehicle mavlinkVehicle = this.vehicle;
        if (mavlinkVehicle == null) {
            return "";
        }
        if (mavlinkVehicle.getMavLinkThread() == null || !this.vehicle.getMavLinkThread().isConnected()) {
            return null;
        }
        String platformSerial = this.vehicle.getMavLinkThread().getPlatformSerial();
        return platformSerial == null ? defaultUASItemUID : platformSerial;
    }
}
