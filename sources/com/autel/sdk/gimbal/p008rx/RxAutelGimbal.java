package com.autel.sdk.gimbal.p008rx;

import com.autel.common.gimbal.GimbalVersionInfo;
import com.autel.common.gimbal.GimbalWorkMode;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.gimbal.rx.RxAutelGimbal */
public interface RxAutelGimbal {
    Observable<Boolean> getGimbalLimitUpward();

    Observable<GimbalWorkMode> getGimbalWorkMode();

    Observable<GimbalVersionInfo> getVersionInfo();

    Observable<Boolean> setGimbalLimitUpward(boolean z);

    Observable<Boolean> setGimbalWorkMode(GimbalWorkMode gimbalWorkMode);
}
