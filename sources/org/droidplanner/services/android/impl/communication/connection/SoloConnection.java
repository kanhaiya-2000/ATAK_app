package org.droidplanner.services.android.impl.communication.connection;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import atakplugin.UASTool.cqb;
import com.o3dr.services.android.lib.drone.connection.ConnectionParameter;
import com.o3dr.services.android.lib.drone.connection.ConnectionType;
import com.o3dr.services.android.lib.gcs.link.LinkConnectionStatus;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.droidplanner.services.android.impl.utils.connection.WifiConnectionHandler;

public class SoloConnection extends AndroidMavLinkConnection implements WifiConnectionHandler.WifiConnectionListener {
    private static final int SOLO_UDP_PORT = 14550;
    private final AndroidUdpConnection dataLink;
    private final String soloLinkId;
    private final String soloLinkPassword;
    private final WifiConnectionHandler wifiHandler;

    public SoloConnection(Context context, String str, String str2) {
        super(context);
        WifiConnectionHandler wifiConnectionHandler = new WifiConnectionHandler(context);
        this.wifiHandler = wifiConnectionHandler;
        wifiConnectionHandler.setListener(this);
        this.soloLinkId = str;
        this.soloLinkPassword = str2;
        this.dataLink = new AndroidUdpConnection(context, 14550) {
            /* access modifiers changed from: protected */
            public void onConnectionOpened(Bundle bundle) {
                SoloConnection.this.onConnectionOpened(bundle);
            }

            /* access modifiers changed from: protected */
            public void onConnectionStatus(LinkConnectionStatus linkConnectionStatus) {
                SoloConnection.this.onConnectionStatus(linkConnectionStatus);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void openConnection(Bundle bundle) {
        if (TextUtils.isEmpty(this.soloLinkId)) {
            onConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(-4, "Invalid connection credentials!"));
            return;
        }
        this.wifiHandler.start();
        checkScanResults(this.wifiHandler.getScanResults());
    }

    private void refreshWifiAps() {
        if (!this.wifiHandler.refreshWifiAPs()) {
            onConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(-1, "Unable to refresh wifi access points"));
        }
    }

    /* access modifiers changed from: protected */
    public int readDataBlock(byte[] bArr) {
        return this.dataLink.readDataBlock(bArr);
    }

    /* access modifiers changed from: protected */
    public void sendBuffer(byte[] bArr) {
        this.dataLink.sendBuffer(bArr);
    }

    /* access modifiers changed from: protected */
    public void closeConnection() {
        this.wifiHandler.stop();
        this.dataLink.closeConnection();
    }

    /* access modifiers changed from: protected */
    public void loadPreferences() {
        this.dataLink.loadPreferences();
    }

    public int getConnectionType() {
        return this.dataLink.getConnectionType();
    }

    public void onWifiConnected(String str, Bundle bundle) {
        if (isConnecting() && str.equalsIgnoreCase(this.soloLinkId)) {
            try {
                this.dataLink.openConnection(bundle);
            } catch (IOException e) {
                reportIOException(e);
                cqb.m12015e(e, e.getMessage(), new Object[0]);
            }
        }
    }

    public void onWifiConnecting() {
        onConnectionStatus(new LinkConnectionStatus(LinkConnectionStatus.CONNECTING, (Bundle) null));
    }

    public void onWifiDisconnected(String str) {
        if (str.equalsIgnoreCase(this.soloLinkId)) {
            onConnectionStatus(new LinkConnectionStatus(LinkConnectionStatus.DISCONNECTED, (Bundle) null));
        }
    }

    public void onWifiScanResultsAvailable(List<ScanResult> list) {
        checkScanResults(list);
    }

    public void onWifiConnectionFailed(LinkConnectionStatus linkConnectionStatus) {
        onConnectionStatus(linkConnectionStatus);
    }

    private void checkScanResults(List<ScanResult> list) {
        if (isConnecting()) {
            ScanResult scanResult = null;
            Iterator<ScanResult> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ScanResult next = it.next();
                if (next.SSID.equalsIgnoreCase(this.soloLinkId)) {
                    scanResult = next;
                    break;
                }
            }
            if (scanResult != null) {
                try {
                    Bundle bundle = new Bundle();
                    Bundle connectionExtras = getConnectionExtras();
                    if (connectionExtras != null && !connectionExtras.isEmpty()) {
                        bundle.putAll(connectionExtras);
                    }
                    bundle.putParcelable(WifiConnectionHandler.EXTRA_SCAN_RESULT, scanResult);
                    bundle.putString(WifiConnectionHandler.EXTRA_SSID_PASSWORD, this.soloLinkPassword);
                    int connectToWifi = this.wifiHandler.connectToWifi(bundle);
                    if (connectToWifi != 0) {
                        onConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(connectToWifi, "Unable to connect to the target wifi " + this.soloLinkId));
                    }
                } catch (IllegalArgumentException e) {
                    cqb.m12015e(e, e.getMessage(), new Object[0]);
                    onConnectionStatus(LinkConnectionStatus.newFailedConnectionStatus(-7, e.getMessage()));
                }
            } else {
                refreshWifiAps();
            }
        }
    }

    private boolean isConnecting() {
        return getConnectionStatus() == 1;
    }

    public static boolean isUdpSoloConnection(Context context, ConnectionParameter connectionParameter) {
        Bundle paramsBundle;
        if (connectionParameter == null || connectionParameter.getConnectionType() != 1 || (paramsBundle = connectionParameter.getParamsBundle()) == null) {
            return false;
        }
        int i = paramsBundle.getInt(ConnectionType.EXTRA_UDP_SERVER_PORT, 14550);
        if (!WifiConnectionHandler.isSoloWifi(WifiConnectionHandler.getCurrentWifiLink((WifiManager) context.getSystemService("wifi"))) || i != 14550) {
            return false;
        }
        return true;
    }

    public static ConnectionParameter getSoloConnectionParameterFromUdp(Context context, ConnectionParameter connectionParameter) {
        if (context == null) {
            return null;
        }
        String currentWifiLink = WifiConnectionHandler.getCurrentWifiLink((WifiManager) context.getSystemService("wifi"));
        if (WifiConnectionHandler.isSoloWifi(currentWifiLink)) {
            return ConnectionParameter.newSoloConnection(currentWifiLink, (String) null, connectionParameter.getTLogLoggingUri(), connectionParameter.getEventsDispatchingPeriod());
        }
        return null;
    }
}
