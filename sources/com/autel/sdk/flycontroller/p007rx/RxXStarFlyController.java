package com.autel.sdk.flycontroller.p007rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.flycontroller.FlyControllerConnectState;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.xstar.XStarFlyControllerParameterRangeManager;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.flycontroller.rx.RxXStarFlyController */
public interface RxXStarFlyController extends RxAutelFlyController {
    Observable<XStarFlyControllerParameterRangeManager> getParameterRangeManager();

    void setConnectStateListener(CallbackWithOneParam<FlyControllerConnectState> callbackWithOneParam);

    void setFlyControllerInfoListener(CallbackWithOneParam<FlyControllerInfo> callbackWithOneParam);

    void setUltraSonicHeightInfoListener(CallbackWithOneParam<Float> callbackWithOneParam);
}
