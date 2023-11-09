package com.autel.internal.dsp.xstar;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.FailedCallback;
import com.autel.common.dsp.WiFiInfo;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.dsp.DspFactory;
import com.autel.internal.dsp.DspInitializeProxy;
import com.autel.sdk.dsp.p006rx.RxXStarDsp;

public class XStarDspInitializeProxy extends DspInitializeProxy implements XStarDspService4Initialize {
    private XStarDspService mDspService;
    private RxXStarDsp mRxXStarDsp;

    /* access modifiers changed from: protected */
    public void initListener() {
    }

    public void updateNewSSIDInfo(String str, String str2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.mDspService.updateNewSSIDInfo(str, str2, callbackWithNoParam);
        }
    }

    public WiFiInfo getCurrentSSIDInfo() {
        XStarDspService xStarDspService;
        if (!isSdkValidate() || (xStarDspService = this.mDspService) == null) {
            return null;
        }
        return xStarDspService.getCurrentSSIDInfo();
    }

    /* access modifiers changed from: protected */
    public boolean checkStateEnable(FailedCallback failedCallback) {
        AutelError autelError;
        if (!this.hasInit || this.stateManager == null) {
            autelError = AutelError.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED;
        } else if (!this.stateManager.isSdkValidate()) {
            autelError = AutelError.SDK_AUTHOR_NEED_MORE_THAN_DISABLE;
        } else {
            autelError = !this.stateManager.isRemoteControllerConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_REMOTE_CONTROLLER : null;
        }
        if (!(autelError == null || failedCallback == null)) {
            failedCallback.onFailure(autelError);
        }
        return autelError == null;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        XStarDspService createXStarDspService = DspFactory.createXStarDspService();
        this.mDspService = createXStarDspService;
        return createXStarDspService;
    }

    public void resetWifi() {
        if (this.mDspService != null && isSdkValidate()) {
            this.mDspService.resetWifi();
        }
    }

    public boolean isUSBEnable() {
        return this.mDspService.isUSBEnable();
    }

    public RxXStarDsp toRx() {
        if (this.mRxXStarDsp == null) {
            this.mRxXStarDsp = new RxXStarDspImpl(this);
        }
        return this.mRxXStarDsp;
    }
}
