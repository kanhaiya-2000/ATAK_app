package com.autel.internal.flycontroller.xstar;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.FlyControllerConnectState;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.xstar.XStarFlyControllerParameterRangeManager;
import com.autel.internal.flycontroller.RxAutelFlyControllerImpl;
import com.autel.internal.sdk.p002rx.RxLock;
import com.autel.sdk.flycontroller.XStarFlyController;
import com.autel.sdk.flycontroller.p007rx.RxXStarFlyController;
import io.reactivex.Observable;

public class RxXStarFlyControllerImpl extends RxAutelFlyControllerImpl implements RxXStarFlyController {
    /* access modifiers changed from: private */
    public XStarFlyController mXStarFlyController;

    public RxXStarFlyControllerImpl(XStarFlyController xStarFlyController) {
        super(xStarFlyController);
        this.mXStarFlyController = xStarFlyController;
    }

    public void setConnectStateListener(CallbackWithOneParam<FlyControllerConnectState> callbackWithOneParam) {
        this.mXStarFlyController.setConnectStateListener(callbackWithOneParam);
    }

    public void setFlyControllerInfoListener(CallbackWithOneParam<FlyControllerInfo> callbackWithOneParam) {
        this.mXStarFlyController.setFlyControllerInfoListener(callbackWithOneParam);
    }

    public void setUltraSonicHeightInfoListener(CallbackWithOneParam<Float> callbackWithOneParam) {
        this.mXStarFlyController.setUltraSonicHeightInfoListener(callbackWithOneParam);
    }

    public Observable<XStarFlyControllerParameterRangeManager> getParameterRangeManager() {
        return new RxLock<XStarFlyControllerParameterRangeManager>() {
            /* access modifiers changed from: protected */
            public void run() {
                XStarFlyControllerParameterRangeManager parameterRangeManager = RxXStarFlyControllerImpl.this.mXStarFlyController.getParameterRangeManager();
                if (RxXStarFlyControllerImpl.this.mXStarFlyController == null) {
                    setException(AutelError.COMMAND_FAILED);
                } else {
                    setData(parameterRangeManager);
                }
            }
        }.fire();
    }
}
