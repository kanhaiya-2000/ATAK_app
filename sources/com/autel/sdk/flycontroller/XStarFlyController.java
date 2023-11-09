package com.autel.sdk.flycontroller;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.flycontroller.FlyControllerConnectState;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.xstar.XStarFlyControllerParameterRangeManager;
import com.autel.sdk.flycontroller.p007rx.RxXStarFlyController;

public interface XStarFlyController extends C4930AutelFlyController {
    XStarFlyControllerParameterRangeManager getParameterRangeManager();

    void setConnectStateListener(CallbackWithOneParam<FlyControllerConnectState> callbackWithOneParam);

    void setFlyControllerInfoListener(CallbackWithOneParam<FlyControllerInfo> callbackWithOneParam);

    void setUltraSonicHeightInfoListener(CallbackWithOneParam<Float> callbackWithOneParam);

    RxXStarFlyController toRx();
}
