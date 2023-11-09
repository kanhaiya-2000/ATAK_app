package com.autel.internal.firmware;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.error.AutelError;
import com.autel.internal.AutelInitializeProxy;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.sdk.firmware.AircraftComponentSerialNumberVersionInfo;
import com.autel.internal.sdk.firmware.AircraftComponentVersionInfo;
import com.autel.internal.sdk.firmware.RemoteControllerSerialNumberVersionInfo;
import com.autel.internal.sdk.remotecontroller.RemoteControllerVersionPartInfo;

public class FirmwareInitializeProxy extends AutelInitializeProxy implements FirmwareService4Initialize {
    private FirmwareService firmwareService;

    /* access modifiers changed from: protected */
    public void initListener() {
    }

    public void getAircraftComponentVersion(CallbackWithOneParam<AircraftComponentVersionInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.firmwareService.getAircraftComponentVersion(callbackWithOneParam);
        }
    }

    public void getAircraftComponentSerialNumberVersion(CallbackWithOneParam<AircraftComponentSerialNumberVersionInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.firmwareService.getAircraftComponentSerialNumberVersion(callbackWithOneParam);
        }
    }

    public void getRemoteControllerVersion(CallbackWithOneParam<RemoteControllerVersionPartInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.firmwareService.getRemoteControllerVersion(callbackWithOneParam);
        }
    }

    public void getRemoteControllerSerialNumberVersion(CallbackWithOneParam<RemoteControllerSerialNumberVersionInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.firmwareService.getRemoteControllerSerialNumberVersion(callbackWithOneParam);
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

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        FirmwareService createFirmware = FirmwareInfoFactory.createFirmware(autelServiceVersion);
        this.firmwareService = createFirmware;
        return createFirmware;
    }
}
