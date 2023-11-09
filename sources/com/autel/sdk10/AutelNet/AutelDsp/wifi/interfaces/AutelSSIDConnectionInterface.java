package com.autel.sdk10.AutelNet.AutelDsp.wifi.interfaces;

import com.autel.sdk10.AutelNet.AutelDsp.wifi.info.BindSsidInfo;

public class AutelSSIDConnectionInterface {

    public interface BindSsidConnectionListener {
        void onReceiveMessage(BindSsidInfo bindSsidInfo);
    }

    public interface OnSSIDConnectionlistener {
        void onRecSSIDInfo(String str, String str2);
    }

    public interface OnSSIDUpdateNewSsidInfolistener {
        void onUpdateSucc();
    }
}
