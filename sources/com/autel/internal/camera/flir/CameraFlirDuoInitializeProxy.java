package com.autel.internal.camera.flir;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.DeviceInfo;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.AutelModuleService;
import com.autel.internal.AutelServiceVersion;
import com.autel.internal.camera.BaseCameraInitializeProxy;
import com.autel.internal.camera.CameraFactory;
import com.autel.internal.camera.p001rx.RxAutelFlirDuo;
import com.autel.internal.sdk.camera.flir.FLIRDisplayMode;
import com.autel.internal.sdk.camera.flir.FLIRIRMSXSetting;
import com.autel.internal.sdk.camera.flir.FLIRPhotoSetting;
import com.autel.internal.sdk.camera.flir.FLIRPipPosition;
import com.autel.internal.sdk.camera.flir.FLIRRecordSetting;
import com.autel.internal.sdk.camera.flir.IRColorMode;

public class CameraFlirDuoInitializeProxy extends BaseCameraInitializeProxy implements CameraFlirDuoService4Initialize {
    protected CameraFlirDuoService cameraFlirService;
    RxAutelFlirDuo mRxAutelFlirDuo;

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
    }

    public CameraFlirDuoInitializeProxy(AutelListenerManager autelListenerManager) {
        this.listenerManager = autelListenerManager;
    }

    /* access modifiers changed from: protected */
    public AutelModuleService buildConnection(AutelServiceVersion autelServiceVersion) {
        CameraFlirDuoService createFlir = CameraFactory.createFlir(autelServiceVersion);
        this.cameraFlirService = createFlir;
        this.cameraService = createFlir;
        return this.cameraFlirService;
    }

    public void setDisplayMode(FLIRDisplayMode fLIRDisplayMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraFlirService.setDisplayMode(fLIRDisplayMode, callbackWithNoParam);
        }
    }

    public void getDisplayMode(CallbackWithOneParam<FLIRDisplayMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirService.getDisplayMode(callbackWithOneParam);
        }
    }

    public void setIRColorMode(IRColorMode iRColorMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraFlirService.setIRColorMode(iRColorMode, callbackWithNoParam);
        }
    }

    public void getIRColorMode(CallbackWithOneParam<IRColorMode> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirService.getIRColorMode(callbackWithOneParam);
        }
    }

    public void setIRMSX(FLIRIRMSXSetting fLIRIRMSXSetting, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraFlirService.setIRMSX(fLIRIRMSXSetting, callbackWithNoParam);
        }
    }

    public void getIRMSX(CallbackWithOneParam<FLIRIRMSXSetting> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirService.getIRMSX(callbackWithOneParam);
        }
    }

    public void setRecordingFormat(FLIRRecordSetting fLIRRecordSetting, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraFlirService.setRecordingFormat(fLIRRecordSetting, callbackWithNoParam);
        }
    }

    public void getRecordingFormat(CallbackWithOneParam<FLIRRecordSetting> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirService.getRecordingFormat(callbackWithOneParam);
        }
    }

    public void setPhotoFormat(FLIRPhotoSetting fLIRPhotoSetting, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraFlirService.setPhotoFormat(fLIRPhotoSetting, callbackWithNoParam);
        }
    }

    public void getPhotoFormat(CallbackWithOneParam<FLIRPhotoSetting> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirService.getPhotoFormat(callbackWithOneParam);
        }
    }

    public void getDeviceInformation(CallbackWithOneParam<DeviceInfo> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirService.getDeviceInformation(callbackWithOneParam);
        }
    }

    public void setPipPosition(FLIRPipPosition fLIRPipPosition, CallbackWithNoParam callbackWithNoParam) {
        if (checkStateEnable(callbackWithNoParam)) {
            this.cameraFlirService.setPipPosition(fLIRPipPosition, callbackWithNoParam);
        }
    }

    public void getPipPosition(CallbackWithOneParam<FLIRPipPosition> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirService.getPipPosition(callbackWithOneParam);
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (checkStateEnable(callbackWithOneParam)) {
            this.cameraFlirService.getCurrentRecordTime(callbackWithOneParam);
        }
    }

    public RxAutelFlirDuo toRx() {
        if (this.mRxAutelFlirDuo == null) {
            this.mRxAutelFlirDuo = new RxAutelFlirDuoImpl(this);
        }
        return this.mRxAutelFlirDuo;
    }
}
