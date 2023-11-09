package com.autel.sdk.gimbal;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.gimbal.GimbalParameterRangeManager;
import com.autel.common.gimbal.GimbalVersionInfo;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.sdk.gimbal.p008rx.RxAutelGimbal;

/* renamed from: com.autel.sdk.gimbal.AutelGimbal */
public interface C4931AutelGimbal {
    void getGimbalLimitUpward(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void getGimbalWorkMode(CallbackWithOneParam<GimbalWorkMode> callbackWithOneParam);

    GimbalParameterRangeManager getParameterRangeManager();

    void getVersionInfo(CallbackWithOneParam<GimbalVersionInfo> callbackWithOneParam);

    void setGimbalLimitUpward(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setGimbalWorkMode(GimbalWorkMode gimbalWorkMode, CallbackWithNoParam callbackWithNoParam);

    RxAutelGimbal toRx();
}
