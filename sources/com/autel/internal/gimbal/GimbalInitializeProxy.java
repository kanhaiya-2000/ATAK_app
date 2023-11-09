package com.autel.internal.gimbal;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalVersionInfo;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.internal.AutelInitializeProxy;

public abstract class GimbalInitializeProxy extends AutelInitializeProxy implements GimbalService4Initialize {
    protected GimbalService gimbalService;

    public void setGimbalLimitUpward(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.gimbalService.setGimbalLimitUpward(z, callbackWithNoParam);
        }
    }

    public void getGimbalLimitUpward(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.gimbalService.getGimbalLimitUpward(callbackWithOneParam);
        }
    }

    public void setGimbalWorkMode(GimbalWorkMode gimbalWorkMode, CallbackWithNoParam callbackWithNoParam) {
        if (!checkStateEnable(callbackWithNoParam)) {
            return;
        }
        if (GimbalWorkMode.UNKNOWN != gimbalWorkMode) {
            this.gimbalService.setGimbalWorkMode(gimbalWorkMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void getGimbalWorkMode(CallbackWithOneParam<GimbalWorkMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.gimbalService.getGimbalWorkMode(callbackWithOneParam);
        }
    }

    public void getVersionInfo(CallbackWithOneParam<GimbalVersionInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam) && callbackWithOneParam != null) {
            this.gimbalService.getVersionInfo(callbackWithOneParam);
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
            autelError = !this.stateManager.isProductConnected() ? AutelError.SDK_HAS_NOT_CONNECT_TO_AIRCRAFT : null;
        }
        if (!(autelError == null || failedCallback == null)) {
            failedCallback.onFailure(autelError);
        }
        return autelError == null;
    }
}
