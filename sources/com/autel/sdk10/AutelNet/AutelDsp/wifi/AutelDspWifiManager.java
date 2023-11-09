package com.autel.sdk10.AutelNet.AutelDsp.wifi;

import com.autel.sdk10.AutelNet.AutelDsp.wifi.connection.SSIDConnection;
import com.autel.sdk10.AutelNet.AutelDsp.wifi.info.BindSsidInfo;
import com.autel.sdk10.AutelNet.AutelDsp.wifi.interfaces.AutelSSIDConnectionInterface;

public final class AutelDspWifiManager {
    private static final byte FLAG_CHANGESSID = 5;
    private static final byte FLAG_CHANGESSID_OK = 6;
    private static final byte FLAG_QUERYSSID = 1;
    private static final String OPENSSDINCONNECTION_KEY = "OPENSSDINCONNECTION_KEY";
    private static final String UPDATENEWSSIDINFO_KEY = "UPDATENEWSSIDINFO_KEY";
    private static SSIDConnection ssidConnection;

    private AutelDspWifiManager() {
    }

    public static void openSsidConnection(final AutelSSIDConnectionInterface.OnSSIDConnectionlistener onSSIDConnectionlistener) {
        if (ssidConnection == null) {
            SSIDConnection sSIDConnection = new SSIDConnection();
            ssidConnection = sSIDConnection;
            sSIDConnection.addBindConnectionListener(OPENSSDINCONNECTION_KEY, new AutelSSIDConnectionInterface.BindSsidConnectionListener() {
                public void onReceiveMessage(BindSsidInfo bindSsidInfo) {
                    AutelSSIDConnectionInterface.OnSSIDConnectionlistener onSSIDConnectionlistener;
                    if (bindSsidInfo.getFlag() == 1 && (onSSIDConnectionlistener = AutelSSIDConnectionInterface.OnSSIDConnectionlistener.this) != null) {
                        onSSIDConnectionlistener.onRecSSIDInfo(bindSsidInfo.getRepeatSsid(), bindSsidInfo.getPwdString());
                    }
                }
            });
            ssidConnection.connect();
        }
    }

    public static void closeSsidConnection() {
        SSIDConnection sSIDConnection = ssidConnection;
        if (sSIDConnection != null) {
            sSIDConnection.removeAllBindConnectionListener();
            ssidConnection.disconnect();
            ssidConnection = null;
        }
    }

    public static void updateNewSsidInfo(String str, String str2, final AutelSSIDConnectionInterface.OnSSIDUpdateNewSsidInfolistener onSSIDUpdateNewSsidInfolistener) {
        BindSsidInfo bindSsidInfo = new BindSsidInfo();
        bindSsidInfo.setSSIDandPsw(str, str2);
        bindSsidInfo.setMac("00:01:22:33:44:55");
        bindSsidInfo.setFlag((byte) 5);
        SSIDConnection sSIDConnection = ssidConnection;
        if (sSIDConnection != null) {
            sSIDConnection.addBindConnectionListener(UPDATENEWSSIDINFO_KEY, new AutelSSIDConnectionInterface.BindSsidConnectionListener() {
                public void onReceiveMessage(BindSsidInfo bindSsidInfo) {
                    AutelSSIDConnectionInterface.OnSSIDUpdateNewSsidInfolistener onSSIDUpdateNewSsidInfolistener;
                    if (bindSsidInfo.getFlag() == 6 && (onSSIDUpdateNewSsidInfolistener = AutelSSIDConnectionInterface.OnSSIDUpdateNewSsidInfolistener.this) != null) {
                        onSSIDUpdateNewSsidInfolistener.onUpdateSucc();
                    }
                }
            });
            ssidConnection.sendBindSsidAnsower(bindSsidInfo);
        }
    }
}
