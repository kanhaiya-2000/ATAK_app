package com.autel.sdk.dsp.p006rx;

import com.autel.common.dsp.WiFiInfo;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.dsp.rx.RxXStarDsp */
public interface RxXStarDsp extends RxAutelDsp {
    Observable<WiFiInfo> getCurrentSSIDInfo();

    Observable<Boolean> isUSBEnable();

    void resetWifi();

    Observable<Boolean> updateNewSSIDInfo(String str, String str2);
}
