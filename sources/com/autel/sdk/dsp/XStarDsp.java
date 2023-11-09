package com.autel.sdk.dsp;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.dsp.WiFiInfo;
import com.autel.sdk.dsp.p006rx.RxXStarDsp;

public interface XStarDsp extends C4929AutelDsp {
    WiFiInfo getCurrentSSIDInfo();

    boolean isUSBEnable();

    void resetWifi();

    RxXStarDsp toRx();

    void updateNewSSIDInfo(String str, String str2, CallbackWithNoParam callbackWithNoParam);
}
