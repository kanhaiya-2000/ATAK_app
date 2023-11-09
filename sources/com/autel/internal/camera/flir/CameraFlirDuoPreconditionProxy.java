package com.autel.internal.camera.flir;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.FailedCallback;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.DeviceInfo;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.BaseCamera20PreconditionProxy;
import com.autel.internal.camera.p001rx.RxAutelFlirDuo;
import com.autel.internal.sdk.camera.flir.FLIRDisplayMode;
import com.autel.internal.sdk.camera.flir.FLIRIRMSXSetting;
import com.autel.internal.sdk.camera.flir.FLIRPhotoSetting;
import com.autel.internal.sdk.camera.flir.FLIRPipPosition;
import com.autel.internal.sdk.camera.flir.FLIRRecordSetting;
import com.autel.internal.sdk.camera.flir.IRColorMode;

public class CameraFlirDuoPreconditionProxy extends BaseCamera20PreconditionProxy implements CameraFlirDuoService {
    private CameraFlirDuoService cameraFlirService;

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
    }

    public RxAutelFlirDuo toRx() {
        return null;
    }

    public CameraFlirDuoPreconditionProxy(CameraFlirDuoService cameraFlirDuoService) {
        super(cameraFlirDuoService);
        this.cameraFlirService = cameraFlirDuoService;
    }

    public void setDisplayMode(FLIRDisplayMode fLIRDisplayMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraFlirService.setDisplayMode(fLIRDisplayMode, callbackWithNoParam);
    }

    public void getDisplayMode(CallbackWithOneParam<FLIRDisplayMode> callbackWithOneParam) {
        this.cameraFlirService.getDisplayMode(callbackWithOneParam);
    }

    public void setIRColorMode(IRColorMode iRColorMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraFlirService.setIRColorMode(iRColorMode, callbackWithNoParam);
    }

    public void getIRColorMode(CallbackWithOneParam<IRColorMode> callbackWithOneParam) {
        this.cameraFlirService.getIRColorMode(callbackWithOneParam);
    }

    public void setIRMSX(FLIRIRMSXSetting fLIRIRMSXSetting, CallbackWithNoParam callbackWithNoParam) {
        this.cameraFlirService.setIRMSX(fLIRIRMSXSetting, callbackWithNoParam);
    }

    public void getIRMSX(CallbackWithOneParam<FLIRIRMSXSetting> callbackWithOneParam) {
        this.cameraFlirService.getIRMSX(callbackWithOneParam);
    }

    public void setRecordingFormat(FLIRRecordSetting fLIRRecordSetting, CallbackWithNoParam callbackWithNoParam) {
        this.cameraFlirService.setRecordingFormat(fLIRRecordSetting, callbackWithNoParam);
    }

    public void getRecordingFormat(CallbackWithOneParam<FLIRRecordSetting> callbackWithOneParam) {
        this.cameraFlirService.getRecordingFormat(callbackWithOneParam);
    }

    public void setPhotoFormat(FLIRPhotoSetting fLIRPhotoSetting, CallbackWithNoParam callbackWithNoParam) {
        this.cameraFlirService.setPhotoFormat(fLIRPhotoSetting, callbackWithNoParam);
    }

    public void getPhotoFormat(CallbackWithOneParam<FLIRPhotoSetting> callbackWithOneParam) {
        this.cameraFlirService.getPhotoFormat(callbackWithOneParam);
    }

    public void getDeviceInformation(CallbackWithOneParam<DeviceInfo> callbackWithOneParam) {
        this.cameraFlirService.getDeviceInformation(callbackWithOneParam);
    }

    public void setPipPosition(FLIRPipPosition fLIRPipPosition, CallbackWithNoParam callbackWithNoParam) {
        if (!isNull(fLIRPipPosition, callbackWithNoParam)) {
            this.cameraFlirService.setPipPosition(fLIRPipPosition, callbackWithNoParam);
        }
    }

    public void getPipPosition(CallbackWithOneParam<FLIRPipPosition> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraFlirService.getPipPosition(callbackWithOneParam);
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraFlirService.getCurrentRecordTime(callbackWithOneParam);
        }
    }

    private boolean isNull(Object obj, FailedCallback failedCallback) {
        if (obj != null) {
            return false;
        }
        if (failedCallback == null) {
            return true;
        }
        failedCallback.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        return true;
    }
}
