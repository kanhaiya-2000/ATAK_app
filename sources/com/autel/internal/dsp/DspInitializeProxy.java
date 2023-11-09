package com.autel.internal.dsp;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.dsp.DspVersionInfo;
import com.autel.common.dsp.RFData;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelInitializeProxy;
import com.autel.sdk.dsp.p006rx.RxAutelDsp;
import java.util.List;

public abstract class DspInitializeProxy extends AutelInitializeProxy implements DspService4Initialize {
    protected DspService dspService;
    private RxAutelDsp mRxAutelDsp;

    public void getRFDataList(int i, CallbackWithOneParam<List<RFData>> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.dspService.getRFDataList(i, callbackWithOneParam);
        }
    }

    public void getCurrentRFData(int i, CallbackWithOneParam<RFData> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.dspService.getCurrentRFData(i, callbackWithOneParam);
        }
    }

    public void setCurrentRFData(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.dspService.setCurrentRFData(i, i2, callbackWithNoParam);
        }
    }

    public void getVersionInfo(CallbackWithOneParam<DspVersionInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.dspService.getVersionInfo(callbackWithOneParam);
        }
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
}
