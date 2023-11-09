package com.autel.camera.protocol.protocol20.flir;

import com.autel.bean.camera.FlirCameraAllSettings;
import com.autel.camera.protocol.protocol20.base.BaseCamera20;
import com.autel.camera.protocol.protocol20.interfaces.flir.CameraFlirDuoService;
import com.autel.camera.protocol.protocol20.request.CameraFlirRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.flir.FLIRDisplayMode;
import com.autel.internal.sdk.camera.flir.FLIRIRMSXSetting;
import com.autel.internal.sdk.camera.flir.FLIRPhotoSetting;
import com.autel.internal.sdk.camera.flir.FLIRPipPosition;
import com.autel.internal.sdk.camera.flir.FLIRRecordSetting;
import com.autel.internal.sdk.camera.flir.IRColorMode;

public class FlirDuo extends BaseCamera20 implements CameraFlirDuoService {
    protected CameraFlirRequest request = new CameraFlirRequest();

    public void setDisplayMode(FLIRDisplayMode fLIRDisplayMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setDisplayMode(fLIRDisplayMode, callbackWithNoParam);
    }

    public void getDisplayMode(final CallbackWithOneParam<FLIRDisplayMode> callbackWithOneParam) {
        this.request.getDisplayMode(new CallbackWithOneParam<FlirCameraAllSettings.DisplayMode>() {
            public void onSuccess(FlirCameraAllSettings.DisplayMode displayMode) {
                FLIRDisplayMode fLIRDisplayMode;
                String displayMode2 = displayMode.getDisplayMode();
                if (FLIRDisplayMode.IR.getValue().equals(displayMode2)) {
                    fLIRDisplayMode = FLIRDisplayMode.IR;
                } else if (FLIRDisplayMode.NORMAL.getValue().equals(displayMode2)) {
                    fLIRDisplayMode = FLIRDisplayMode.NORMAL;
                } else if (FLIRDisplayMode.PICTURE_IN_PICTURE.getValue().equals(displayMode2)) {
                    fLIRDisplayMode = FLIRDisplayMode.PICTURE_IN_PICTURE;
                } else {
                    fLIRDisplayMode = FLIRDisplayMode.UNKNOWN;
                }
                callbackWithOneParam.onSuccess(fLIRDisplayMode);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setIRColorMode(IRColorMode iRColorMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setIRColorMode(iRColorMode, callbackWithNoParam);
    }

    public void getIRColorMode(final CallbackWithOneParam<IRColorMode> callbackWithOneParam) {
        this.request.getIRColorMode(new CallbackWithOneParam<FlirCameraAllSettings.IRColorPalette>() {
            public void onSuccess(FlirCameraAllSettings.IRColorPalette iRColorPalette) {
                IRColorMode iRColorMode;
                String iRColorPalette2 = iRColorPalette.getIRColorPalette();
                if (IRColorMode.HOT_METAL.getValue().equals(iRColorPalette2)) {
                    iRColorMode = IRColorMode.HOT_METAL;
                } else if (IRColorMode.WHITE_HOT.getValue().equals(iRColorPalette2)) {
                    iRColorMode = IRColorMode.WHITE_HOT;
                } else if (IRColorMode.RAINBOW.getValue().equals(iRColorPalette2)) {
                    iRColorMode = IRColorMode.RAINBOW;
                } else {
                    iRColorMode = IRColorMode.UNKNOWN;
                }
                callbackWithOneParam.onSuccess(iRColorMode);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setIRMSX(FLIRIRMSXSetting fLIRIRMSXSetting, CallbackWithNoParam callbackWithNoParam) {
        this.request.setIRMSX(fLIRIRMSXSetting, callbackWithNoParam);
    }

    public void getIRMSX(CallbackWithOneParam<FLIRIRMSXSetting> callbackWithOneParam) {
        this.request.getIRMSX(callbackWithOneParam);
    }

    public void setRecordingFormat(FLIRRecordSetting fLIRRecordSetting, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFlirRecordingSettings(fLIRRecordSetting, callbackWithNoParam);
    }

    public void getRecordingFormat(CallbackWithOneParam<FLIRRecordSetting> callbackWithOneParam) {
        this.request.getFlirRecordingSettings(callbackWithOneParam);
    }

    public void setPhotoFormat(FLIRPhotoSetting fLIRPhotoSetting, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFlirPhotoTakingSettings(fLIRPhotoSetting, callbackWithNoParam);
    }

    public void getPhotoFormat(CallbackWithOneParam<FLIRPhotoSetting> callbackWithOneParam) {
        this.request.getFlirPhotoTakingSettings(callbackWithOneParam);
    }

    public void setPipPosition(FLIRPipPosition fLIRPipPosition, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFLIRPipPosition(fLIRPipPosition, callbackWithNoParam);
    }

    public void getPipPosition(final CallbackWithOneParam<FLIRPipPosition> callbackWithOneParam) {
        this.request.getFLIRPipPosition(new CallbackWithOneParam<FlirCameraAllSettings.PipPosition>() {
            public void onSuccess(FlirCameraAllSettings.PipPosition pipPosition) {
                callbackWithOneParam.onSuccess(FLIRPipPosition.find(pipPosition.getPosition()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }
}
