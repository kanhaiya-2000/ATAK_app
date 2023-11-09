package org.droidplanner.services.android.impl.utils.connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.droidplanner.services.android.impl.core.MAVLink.connection.MavLinkConnection;

public class WifiConnectionHandler {
    public static final String EXTRA_SCAN_RESULT = "extra_scan_result";
    public static final String EXTRA_SSID = "extra_ssid";
    public static final String EXTRA_SSID_PASSWORD = "extra_ssid_password";
    public static final String SOLO_LINK_WIFI_PREFIX = "SoloLink_";
    private static final IntentFilter intentFilter;
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r8, android.content.Intent r9) {
            /*
                r7 = this;
                java.lang.String r0 = r9.getAction()
                int r1 = r0.hashCode()
                r2 = -1
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                switch(r1) {
                    case -1875733435: goto L_0x002f;
                    case -343630553: goto L_0x0025;
                    case 233521600: goto L_0x001b;
                    case 1878357501: goto L_0x0011;
                    default: goto L_0x0010;
                }
            L_0x0010:
                goto L_0x0039
            L_0x0011:
                java.lang.String r1 = "android.net.wifi.SCAN_RESULTS"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0039
                r0 = 0
                goto L_0x003a
            L_0x001b:
                java.lang.String r1 = "android.net.wifi.supplicant.STATE_CHANGE"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0039
                r0 = 1
                goto L_0x003a
            L_0x0025:
                java.lang.String r1 = "android.net.wifi.STATE_CHANGE"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0039
                r0 = 2
                goto L_0x003a
            L_0x002f:
                java.lang.String r1 = "android.net.wifi.WIFI_STATE_CHANGED"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0039
                r0 = 3
                goto L_0x003a
            L_0x0039:
                r0 = -1
            L_0x003a:
                if (r0 == 0) goto L_0x0128
                if (r0 == r5) goto L_0x00e4
                if (r0 == r4) goto L_0x0042
                goto L_0x0135
            L_0x0042:
                java.lang.String r0 = "networkInfo"
                android.os.Parcelable r0 = r9.getParcelableExtra(r0)
                android.net.NetworkInfo r0 = (android.net.NetworkInfo) r0
                if (r0 != 0) goto L_0x004f
                android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.DISCONNECTED
                goto L_0x0053
            L_0x004f:
                android.net.NetworkInfo$State r1 = r0.getState()
            L_0x0053:
                int[] r2 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.C60163.$SwitchMap$android$net$NetworkInfo$State
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 0
                if (r1 == r5) goto L_0x0099
                if (r1 == r4) goto L_0x008b
                if (r1 == r3) goto L_0x0064
                goto L_0x0135
            L_0x0064:
                int r9 = android.os.Build.VERSION.SDK_INT
                r1 = 21
                if (r9 < r1) goto L_0x007d
                android.net.NetworkInfo$DetailedState r9 = r0.getDetailedState()
                if (r9 == 0) goto L_0x007d
                android.net.NetworkInfo$DetailedState r0 = android.net.NetworkInfo.DetailedState.VERIFYING_POOR_LINK
                if (r9 != r0) goto L_0x007d
                java.lang.String r8 = org.droidplanner.services.android.impl.utils.NetworkUtils.getCurrentWifiLink(r8)
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r9 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                r9.updateNetworkIfNecessary(r8, r2)
            L_0x007d:
                java.lang.Object[] r8 = new java.lang.Object[r6]
                java.lang.String r9 = "Connecting to wifi network."
                atakplugin.UASTool.cqb.m12007b(r9, r8)
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r8 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                r8.notifyWifiConnecting()
                goto L_0x0135
            L_0x008b:
                java.lang.Object[] r8 = new java.lang.Object[r6]
                java.lang.String r9 = "Disconnected from wifi network."
                atakplugin.UASTool.cqb.m12010c(r9, r8)
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r8 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                r8.notifyWifiDisconnected()
                goto L_0x0135
            L_0x0099:
                java.lang.String r8 = "wifiInfo"
                android.os.Parcelable r8 = r9.getParcelableExtra(r8)
                android.net.wifi.WifiInfo r8 = (android.net.wifi.WifiInfo) r8
                java.lang.String r8 = r8.getSSID()
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = "Connected to "
                r9.append(r0)
                r9.append(r8)
                java.lang.String r9 = r9.toString()
                java.lang.Object[] r0 = new java.lang.Object[r6]
                atakplugin.UASTool.cqb.m12010c(r9, r0)
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r9 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                android.net.wifi.WifiManager r9 = r9.wifiMgr
                android.net.DhcpInfo r9 = r9.getDhcpInfo()
                if (r9 == 0) goto L_0x00d5
                java.lang.Object[] r0 = new java.lang.Object[r5]
                java.lang.String r9 = r9.toString()
                r0[r6] = r9
                java.lang.String r9 = "Dhcp info: %s"
                atakplugin.UASTool.cqb.m12010c(r9, r0)
                goto L_0x00dc
            L_0x00d5:
                java.lang.Object[] r9 = new java.lang.Object[r6]
                java.lang.String r0 = "Dhcp info is not available."
                atakplugin.UASTool.cqb.m12012d(r0, r9)
            L_0x00dc:
                if (r8 == 0) goto L_0x0135
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r9 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                r9.updateNetworkIfNecessary(r8, r2)
                goto L_0x0135
            L_0x00e4:
                java.lang.String r0 = "newState"
                android.os.Parcelable r0 = r9.getParcelableExtra(r0)
                android.net.wifi.SupplicantState r0 = (android.net.wifi.SupplicantState) r0
                java.lang.String r8 = org.droidplanner.services.android.impl.utils.NetworkUtils.getCurrentWifiLink(r8)
                java.lang.String r1 = "supplicantError"
                int r9 = r9.getIntExtra(r1, r2)
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
                r1[r6] = r2
                r1[r5] = r0
                r1[r4] = r8
                java.lang.String r0 = "Supplicant state changed error %s with state %s and ssid %s"
                atakplugin.UASTool.cqb.m12007b(r0, r1)
                if (r9 != r5) goto L_0x0135
                boolean r9 = org.droidplanner.services.android.impl.utils.NetworkUtils.isSoloNetwork(r8)
                if (r9 == 0) goto L_0x0135
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r9 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                r9.notifyWifiConnectionFailed()
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r9 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                android.net.wifi.WifiConfiguration r8 = r9.getWifiConfigs(r8)
                if (r8 == 0) goto L_0x0135
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r9 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                android.net.wifi.WifiManager r9 = r9.wifiMgr
                int r8 = r8.networkId
                r9.removeNetwork(r8)
                goto L_0x0135
            L_0x0128:
                org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler r8 = org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.this
                android.net.wifi.WifiManager r9 = r8.wifiMgr
                java.util.List r9 = r9.getScanResults()
                r8.notifyWifiScanResultsAvailable(r9)
            L_0x0135:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.C60141.onReceive(android.content.Context, android.content.Intent):void");
        }
    };
    /* access modifiers changed from: private */
    public final ConnectivityManager connMgr;
    private final AtomicReference<String> connectedWifi = new AtomicReference<>("");
    private final Context context;
    private WifiConnectionListener listener;
    private final Object netReq;
    private final Object netReqCb;
    /* access modifiers changed from: private */
    public final WifiManager wifiMgr;

    public interface WifiConnectionListener {
        void onWifiConnected(String str, Bundle bundle);

        void onWifiConnecting();

        void onWifiConnectionFailed(LinkConnectionStatus linkConnectionStatus);

        void onWifiDisconnected(String str);

        void onWifiScanResultsAvailable(List<ScanResult> list);
    }

    static {
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter = intentFilter2;
        intentFilter2.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter2.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter2.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter2.addAction("android.net.wifi.supplicant.STATE_CHANGE");
    }

    /* renamed from: org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler$3 */
    /* synthetic */ class C60163 {
        static final /* synthetic */ int[] $SwitchMap$android$net$NetworkInfo$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.net.NetworkInfo$State[] r0 = android.net.NetworkInfo.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$net$NetworkInfo$State = r0
                android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$net$NetworkInfo$State     // Catch:{ NoSuchFieldError -> 0x001d }
                android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$android$net$NetworkInfo$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler.C60163.<clinit>():void");
        }
    }

    public WifiConnectionHandler(Context context2) {
        this.context = context2;
        this.wifiMgr = (WifiManager) context2.getSystemService("wifi");
        this.connMgr = (ConnectivityManager) context2.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 21) {
            this.netReq = new NetworkRequest.Builder().addCapability(14).addCapability(12).addCapability(13).addCapability(15).addTransportType(1).build();
            this.netReqCb = new ConnectivityManager.NetworkCallback() {
                private void getNetworkInfo(Network network) {
                    if (network == null) {
                        cqb.m12010c("Network is null.", new Object[0]);
                        return;
                    }
                    cqb.m12010c("Network: %s, active : %s", network, Boolean.valueOf(WifiConnectionHandler.this.connMgr.isDefaultNetworkActive()));
                    cqb.m12010c("Network link properties: %s", WifiConnectionHandler.this.connMgr.getLinkProperties(network).toString());
                    cqb.m12010c("Network capabilities: %s", WifiConnectionHandler.this.connMgr.getNetworkCapabilities(network));
                }

                public void onAvailable(Network network) {
                    String access$800 = WifiConnectionHandler.this.getCurrentWifiLink();
                    if (!WifiConnectionHandler.isSoloWifi(access$800)) {
                        try {
                            WifiConnectionHandler.this.connMgr.unregisterNetworkCallback(this);
                        } catch (IllegalArgumentException e) {
                            cqb.m12013d(e, "Network callback was not registered.", new Object[0]);
                        }
                    } else {
                        cqb.m12010c("Network %s is available", network);
                        getNetworkInfo(network);
                        Bundle bundle = new Bundle(1);
                        bundle.putParcelable(MavLinkConnection.EXTRA_NETWORK, network);
                        WifiConnectionHandler.this.notifyWifiConnected(access$800, bundle);
                    }
                }

                public void onLosing(Network network, int i) {
                    cqb.m12012d("Losing network %s", network);
                }

                public void onLost(Network network) {
                    cqb.m12012d("Lost network %s", network);
                }
            };
            return;
        }
        this.netReq = null;
        this.netReqCb = null;
    }

    public void setListener(WifiConnectionListener wifiConnectionListener) {
        this.listener = wifiConnectionListener;
    }

    public void start() {
        this.context.registerReceiver(this.broadcastReceiver, intentFilter);
    }

    public void stop() {
        try {
            this.context.unregisterReceiver(this.broadcastReceiver);
        } catch (IllegalArgumentException e) {
            cqb.m12013d(e, "Receiver was not registered.", new Object[0]);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                this.connMgr.unregisterNetworkCallback((ConnectivityManager.NetworkCallback) this.netReqCb);
            } catch (IllegalArgumentException e2) {
                cqb.m12013d(e2, "Network callback was not registered.", new Object[0]);
            }
        }
    }

    public boolean refreshWifiAPs() {
        cqb.m12007b("Querying wifi access points.", new Object[0]);
        WifiManager wifiManager = this.wifiMgr;
        if (wifiManager == null) {
            return false;
        }
        if (wifiManager.isWifiEnabled() || this.wifiMgr.setWifiEnabled(true)) {
            return this.wifiMgr.startScan();
        }
        Toast.makeText(this.context, "Unable to activate Wi-Fi!", 1).show();
        return false;
    }

    public boolean isOnNetwork(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.equalsIgnoreCase(getCurrentWifiLink());
        }
        throw new IllegalArgumentException("Invalid wifi ssid " + str);
    }

    public boolean isConnected(String str, Bundle bundle) {
        Network network;
        NetworkCapabilities networkCapabilities;
        if (!isOnNetwork(str)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        if (bundle == null) {
            network = null;
        } else {
            network = (Network) bundle.getParcelable(MavLinkConnection.EXTRA_NETWORK);
        }
        if (network == null || (networkCapabilities = this.connMgr.getNetworkCapabilities(network)) == null || !networkCapabilities.hasTransport(1)) {
            return false;
        }
        return true;
    }

    public List<ScanResult> getScanResults() {
        return this.wifiMgr.getScanResults();
    }

    private ScanResult getScanResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (ScanResult next : this.wifiMgr.getScanResults()) {
            if (next.SSID.equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public int connectToWifi(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return -4;
        }
        ScanResult scanResult = (ScanResult) bundle.getParcelable(EXTRA_SCAN_RESULT);
        if (scanResult == null) {
            String string = bundle.getString(EXTRA_SSID);
            if (TextUtils.isEmpty(string)) {
                return -4;
            }
            ScanResult scanResult2 = getScanResult(string);
            if (scanResult2 == null) {
                cqb.m12010c("No matching scan result was found for id %s", string);
                return -2;
            }
            scanResult = scanResult2;
        }
        cqb.m12007b("Connecting to wifi " + scanResult.SSID, new Object[0]);
        if (isConnected(scanResult.SSID, bundle)) {
            cqb.m12007b("Already connected to " + scanResult.SSID, new Object[0]);
            notifyWifiConnected(scanResult.SSID, bundle);
            return 0;
        } else if (isOnNetwork(scanResult.SSID)) {
            updateNetworkIfNecessary(scanResult.SSID, bundle);
            return 0;
        } else {
            WifiConfiguration wifiConfigs = getWifiConfigs(scanResult.SSID);
            if (wifiConfigs == null) {
                String string2 = bundle.getString(EXTRA_SSID_PASSWORD);
                cqb.m12007b("Connecting to closed wifi network.", new Object[0]);
                if (TextUtils.isEmpty(string2)) {
                    return -4;
                }
                if (!connectToClosedWifi(scanResult, string2)) {
                    return -7;
                }
                this.wifiMgr.saveConfiguration();
                wifiConfigs = getWifiConfigs(scanResult.SSID);
            }
            if (wifiConfigs == null) {
                return -7;
            }
            this.wifiMgr.enableNetwork(wifiConfigs.networkId, true);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public WifiConfiguration getWifiConfigs(String str) {
        List<WifiConfiguration> configuredNetworks = this.wifiMgr.getConfiguredNetworks();
        if (configuredNetworks == null) {
            return null;
        }
        for (WifiConfiguration next : configuredNetworks) {
            if (next.SSID != null) {
                String str2 = next.SSID;
                if (str2.equals("\"" + str + "\"")) {
                    return next;
                }
            }
        }
        return null;
    }

    private boolean connectToClosedWifi(ScanResult scanResult, String str) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + scanResult.SSID + "\"";
        wifiConfiguration.preSharedKey = "\"" + str + "\"";
        if (this.wifiMgr.addNetwork(wifiConfiguration) != -1) {
            return true;
        }
        cqb.m12014e("Unable to add wifi configuration for %s", scanResult.SSID);
        return false;
    }

    private static String trimWifiSsid(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("\"", "");
    }

    /* access modifiers changed from: private */
    public String getCurrentWifiLink() {
        return getCurrentWifiLink(this.wifiMgr);
    }

    public static String getCurrentWifiLink(WifiManager wifiManager) {
        String str;
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            str = null;
        } else {
            str = connectionInfo.getSSID();
        }
        return trimWifiSsid(str);
    }

    public static boolean isSoloWifi(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("SoloLink_");
    }

    /* access modifiers changed from: private */
    public void updateNetworkIfNecessary(String str, Bundle bundle) {
        String trimWifiSsid = trimWifiSsid(str);
        if (isConnected(str, bundle)) {
            notifyWifiConnected(str, bundle);
        } else if (isSoloWifi(trimWifiSsid)) {
            cqb.m12010c("Requesting route to sololink network", new Object[0]);
            if (Build.VERSION.SDK_INT >= 21) {
                this.connMgr.requestNetwork((NetworkRequest) this.netReq, (ConnectivityManager.NetworkCallback) this.netReqCb);
            } else {
                notifyWifiConnected(trimWifiSsid, bundle);
            }
        } else {
            notifyWifiConnected(trimWifiSsid, bundle);
        }
    }

    /* access modifiers changed from: private */
    public void notifyWifiConnected(String str, Bundle bundle) {
        WifiConnectionListener wifiConnectionListener = this.listener;
        if (wifiConnectionListener != null) {
            wifiConnectionListener.onWifiConnected(str, bundle);
        }
    }

    /* access modifiers changed from: private */
    public void notifyWifiConnecting() {
        WifiConnectionListener wifiConnectionListener = this.listener;
        if (wifiConnectionListener != null) {
            wifiConnectionListener.onWifiConnecting();
        }
    }

    /* access modifiers changed from: private */
    public void notifyWifiDisconnected() {
        WifiConnectionListener wifiConnectionListener = this.listener;
        if (wifiConnectionListener != null) {
            wifiConnectionListener.onWifiDisconnected(this.connectedWifi.get());
        }
        this.connectedWifi.set("");
    }

    /* access modifiers changed from: private */
    public void notifyWifiScanResultsAvailable(List<ScanResult> list) {
        WifiConnectionListener wifiConnectionListener = this.listener;
        if (wifiConnectionListener != null) {
            wifiConnectionListener.onWifiScanResultsAvailable(list);
        }
    }

    /* access modifiers changed from: private */
    public void notifyWifiConnectionFailed() {
        if (this.listener != null) {
            this.listener.onWifiConnectionFailed(LinkConnectionStatus.newFailedConnectionStatus(-4, (String) null));
        }
    }
}
