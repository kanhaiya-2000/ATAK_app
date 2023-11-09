package com.autel.internal.flycontroller.xstar;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.flycontroller.FlyControllerConnectState;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.FlyControllerStatus;
import com.autel.common.flycontroller.GPSInfo;
import com.autel.common.flycontroller.xstar.XStarFlyControllerParameterRangeManager;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.flycontroller.AutelFlyControllerInitializeProxy;
import com.autel.internal.flycontroller.FlyControllerFactory;
import com.autel.sdk.flycontroller.p007rx.RxXStarFlyController;

public class XStarFlyControllerInitializeProxy extends AutelFlyControllerInitializeProxy implements XStarFlyControllerService4Initialize {
    private RxXStarFlyController mRxXStarFlyController;
    private XStarFlyControllerService xStarFlyControllerService;

    public XStarFlyControllerInitializeProxy(FlyControllerStatus flyControllerStatus, GPSInfo gPSInfo) {
        super(flyControllerStatus, gPSInfo);
    }

    public void setConnectStateListener(CallbackWithOneParam<FlyControllerConnectState> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.FlyControllerHeartBeatListener, callbackWithOneParam);
        XStarFlyControllerService xStarFlyControllerService2 = this.xStarFlyControllerService;
        if (xStarFlyControllerService2 != null) {
            xStarFlyControllerService2.setConnectStateListener(callbackWithOneParam);
        }
    }

    public void setFlyControllerInfoListener(CallbackWithOneParam<FlyControllerInfo> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.FlyControllerInfoListener, callbackWithOneParam);
        XStarFlyControllerService xStarFlyControllerService2 = this.xStarFlyControllerService;
        if (xStarFlyControllerService2 != null) {
            xStarFlyControllerService2.setFlyControllerInfoListener(callbackWithOneParam);
        }
    }

    public void setUltraSonicHeightInfoListener(CallbackWithOneParam<Float> callbackWithOneParam) {
        this.listenerManager.put(AutelListenerManager.FCUltraSonicHeightInfoListener, callbackWithOneParam);
        XStarFlyControllerService xStarFlyControllerService2 = this.xStarFlyControllerService;
        if (xStarFlyControllerService2 != null) {
            xStarFlyControllerService2.setUltraSonicHeightInfoListener(callbackWithOneParam);
        }
    }

    public XStarFlyControllerParameterRangeManager getParameterRangeManager() {
        return this.xStarFlyControllerService.getParameterRangeManager();
    }

    public RxXStarFlyController toRx() {
        if (this.mRxXStarFlyController == null) {
            this.mRxXStarFlyController = new RxXStarFlyControllerImpl(this);
        }
        return this.mRxXStarFlyController;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        XStarFlyControllerService createXStarFlyController = FlyControllerFactory.createXStarFlyController(autelServiceVersion);
        this.xStarFlyControllerService = createXStarFlyController;
        this.flyControllerService = createXStarFlyController;
        return this.xStarFlyControllerService;
    }

    /* access modifiers changed from: protected */
    public void initListener() {
        super.initListener();
        if (this.xStarFlyControllerService != null) {
            Object obj = this.listenerManager.get(AutelListenerManager.FlyControllerHeartBeatListener);
            if (obj instanceof CallbackWithTwoParams) {
                this.xStarFlyControllerService.setConnectStateListener((CallbackWithOneParam) obj);
            }
            Object obj2 = this.listenerManager.get(AutelListenerManager.FCUltraSonicHeightInfoListener);
            if (obj2 instanceof CallbackWithOneParam) {
                this.xStarFlyControllerService.setUltraSonicHeightInfoListener((CallbackWithOneParam) obj2);
            }
            Object obj3 = this.listenerManager.get(AutelListenerManager.FlyControllerWarningListener);
            if (obj3 instanceof CallbackWithTwoParams) {
                this.xStarFlyControllerService.setWarningListener((CallbackWithTwoParams) obj3);
            }
            Object obj4 = this.listenerManager.get(AutelListenerManager.FlyControllerInfoListener);
            if (obj4 instanceof CallbackWithOneParam) {
                this.xStarFlyControllerService.setFlyControllerInfoListener((CallbackWithOneParam) obj4);
            }
        }
    }
}
