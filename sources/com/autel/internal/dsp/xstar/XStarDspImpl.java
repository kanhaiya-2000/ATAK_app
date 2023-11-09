package com.autel.internal.dsp.xstar;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.dsp.WiFiInfo;
import com.autel.internal.autel.IAutelStateManager;
import com.autel.internal.dsp.Dsp10;
import com.autel.internal.network.usb.proxy.AutelUSBHelper;
import com.autel.sdk.dsp.p006rx.RxXStarDsp;
import com.autel.sdk10.AutelNet.AutelDsp.wifi.AutelDspWifiManager;
import com.autel.sdk10.AutelNet.AutelDsp.wifi.interfaces.AutelSSIDConnectionInterface;
import com.autel.sdk10.AutelNet.AutelRemoteController.controller.RemoteControllerManager;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCCommandMessage;
import com.autel.sdk10.interfaces.AutelCompletionCallback;

public class XStarDspImpl extends Dsp10 implements XStarDspService {
    /* access modifiers changed from: private */
    public WiFiInfo currentSSIDInfo;

    public RxXStarDsp toRx() {
        return null;
    }

    public void init(IAutelStateManager iAutelStateManager) {
        AutelDspWifiManager.openSsidConnection(new AutelSSIDConnectionInterface.OnSSIDConnectionlistener() {
            public void onRecSSIDInfo(String str, String str2) {
                WiFiInfo unused = XStarDspImpl.this.currentSSIDInfo = new WiFiInfo(str, str2);
            }
        });
    }

    public void updateNewSSIDInfo(final String str, final String str2, final CallbackWithNoParam callbackWithNoParam) {
        AutelDspWifiManager.updateNewSsidInfo(str, str2, new AutelSSIDConnectionInterface.OnSSIDUpdateNewSsidInfolistener() {
            public void onUpdateSucc() {
                if (callbackWithNoParam != null) {
                    WiFiInfo unused = XStarDspImpl.this.currentSSIDInfo = new WiFiInfo(str, str2);
                    callbackWithNoParam.onSuccess();
                }
            }
        });
    }

    public WiFiInfo getCurrentSSIDInfo() {
        return this.currentSSIDInfo;
    }

    public void resetWifi() {
        RCCommandMessage rCCommandMessage = new RCCommandMessage();
        rCCommandMessage.createRCResetWifi();
        RemoteControllerManager.getInstance().setICompletionCallbackWith(rCCommandMessage, (AutelCompletionCallback.ICompletionCallbackWith) null);
    }

    public boolean isUSBEnable() {
        return AutelUSBHelper.instance().isUsbOpened();
    }
}
