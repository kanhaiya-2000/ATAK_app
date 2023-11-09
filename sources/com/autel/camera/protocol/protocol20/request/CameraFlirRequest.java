package com.autel.camera.protocol.protocol20.request;

import com.autel.bean.camera.FlirCameraAllSettings;
import com.autel.camera.protocol.protocol20.entity.CameraHttpParamFactory;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.camera.protocol.protocol20.parser.BaseRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.flir.FLIRDisplayMode;
import com.autel.internal.sdk.camera.flir.FLIRIRMSXSetting;
import com.autel.internal.sdk.camera.flir.FLIRPhotoFormat;
import com.autel.internal.sdk.camera.flir.FLIRPhotoSetting;
import com.autel.internal.sdk.camera.flir.FLIRPipPosition;
import com.autel.internal.sdk.camera.flir.FLIRRecordSetting;
import com.autel.internal.sdk.camera.flir.FLIRVideoRecordMode;
import com.autel.internal.sdk.camera.flir.IRColorMode;
import com.autel.internal.sdk.camera.flir.IRFileFormat;
import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;

public class CameraFlirRequest extends BaseRequest {
    public void setDisplayMode(FLIRDisplayMode fLIRDisplayMode, CallbackWithNoParam callbackWithNoParam) {
        FlirCameraAllSettings.DisplayMode displayMode = new FlirCameraAllSettings.DisplayMode();
        displayMode.setDisplayMode(fLIRDisplayMode.getValue());
        request(CameraParamsConfig.method_SetDisplayMode, displayMode, callbackWithNoParam);
    }

    public void getDisplayMode(final CallbackWithOneParam<FlirCameraAllSettings.DisplayMode> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetDisplayMode, FlirCameraAllSettings.DisplayMode.class, new CallbackWithOneParam<FlirCameraAllSettings.DisplayMode>() {
            public void onSuccess(FlirCameraAllSettings.DisplayMode displayMode) {
                CameraFlirRequest.this.callbackSuccess(callbackWithOneParam, displayMode);
            }

            public void onFailure(AutelError autelError) {
                CameraFlirRequest.this.callbackFailed(callbackWithOneParam);
            }
        });
    }

    public void setIRColorMode(IRColorMode iRColorMode, CallbackWithNoParam callbackWithNoParam) {
        FlirCameraAllSettings.IRColorPalette iRColorPalette = new FlirCameraAllSettings.IRColorPalette();
        iRColorPalette.setIRColorPalette(iRColorMode.getValue());
        request(CameraParamsConfig.method_SetIRColorPalette, iRColorPalette, callbackWithNoParam);
    }

    public void getIRColorMode(CallbackWithOneParam<FlirCameraAllSettings.IRColorPalette> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetIRColorPalette, FlirCameraAllSettings.IRColorPalette.class, callbackWithOneParam);
    }

    public void setIRMSX(FLIRIRMSXSetting fLIRIRMSXSetting, CallbackWithNoParam callbackWithNoParam) {
        FlirCameraAllSettings.MSXSettings mSXSettings = new FlirCameraAllSettings.MSXSettings();
        mSXSettings.setPosX(fLIRIRMSXSetting.getPosX());
        mSXSettings.setPosY(fLIRIRMSXSetting.getPosY());
        mSXSettings.setStrength(fLIRIRMSXSetting.getStrength());
        request(CameraParamsConfig.method_SetMSXSettings, mSXSettings, callbackWithNoParam);
    }

    public void getIRMSX(final CallbackWithOneParam<FLIRIRMSXSetting> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetMSXSettings, FlirCameraAllSettings.MSXSettings.class, new CallbackWithOneParam<FlirCameraAllSettings.MSXSettings>() {
            public void onSuccess(FlirCameraAllSettings.MSXSettings mSXSettings) {
                FLIRIRMSXSetting fLIRIRMSXSetting = new FLIRIRMSXSetting();
                boolean z = true;
                if (mSXSettings.getEnable() != 1) {
                    z = false;
                }
                fLIRIRMSXSetting.setEnable(z);
                fLIRIRMSXSetting.setStrength(mSXSettings.getStrength());
                fLIRIRMSXSetting.setPosX(mSXSettings.getPosX());
                fLIRIRMSXSetting.setPosY(mSXSettings.getPosY());
                CameraFlirRequest.this.callbackSuccess(callbackWithOneParam, fLIRIRMSXSetting);
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setFlirRecordingSettings(FLIRRecordSetting fLIRRecordSetting, CallbackWithNoParam callbackWithNoParam) {
        FlirCameraAllSettings.RecordingSettings recordingSettings = new FlirCameraAllSettings.RecordingSettings();
        recordingSettings.setFileFormat(fLIRRecordSetting.getFileFormat().getValue());
        recordingSettings.setRecordedVideo(fLIRRecordSetting.getRecordVideoMode().getValue());
        request(CameraParamsConfig.method_SetRecordingSettings, recordingSettings, callbackWithNoParam);
    }

    public void getFlirRecordingSettings(final CallbackWithOneParam<FLIRRecordSetting> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetRecordingSettings, FlirCameraAllSettings.RecordingSettings.class, new CallbackWithOneParam<FlirCameraAllSettings.RecordingSettings>() {
            public void onSuccess(FlirCameraAllSettings.RecordingSettings recordingSettings) {
                IRFileFormat find = IRFileFormat.find(recordingSettings.getFileFormat());
                FLIRVideoRecordMode find2 = FLIRVideoRecordMode.find(recordingSettings.getFileFormat());
                FLIRRecordSetting fLIRRecordSetting = new FLIRRecordSetting();
                fLIRRecordSetting.setFileFormat(find);
                fLIRRecordSetting.setRecordVideoMode(find2);
                CameraFlirRequest.this.callbackSuccess(callbackWithOneParam, fLIRRecordSetting);
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setFlirPhotoTakingSettings(FLIRPhotoSetting fLIRPhotoSetting, CallbackWithNoParam callbackWithNoParam) {
        FlirCameraAllSettings.PhotoTakingSettings photoTakingSettings = new FlirCameraAllSettings.PhotoTakingSettings();
        FlirCameraAllSettings.PhotoTakingSettings.TimelapseModeSettings timelapseModeSettings = new FlirCameraAllSettings.PhotoTakingSettings.TimelapseModeSettings();
        timelapseModeSettings.setDuration(fLIRPhotoSetting.getDuration());
        timelapseModeSettings.setInterval(fLIRPhotoSetting.getInterval());
        photoTakingSettings.setPicType(fLIRPhotoSetting.getFormat().getValue());
        photoTakingSettings.setTimelapseModeSettings(timelapseModeSettings);
        request(CameraParamsConfig.method_SetPhotoTakingSettings, photoTakingSettings, callbackWithNoParam);
    }

    public void getFlirPhotoTakingSettings(final CallbackWithOneParam<FLIRPhotoSetting> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetPhotoTakingSettings, FlirCameraAllSettings.PhotoTakingSettings.class, new CallbackWithOneParam<FlirCameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(FlirCameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                FLIRPhotoFormat find = FLIRPhotoFormat.find(photoTakingSettings.getPicType());
                FLIRPhotoSetting fLIRPhotoSetting = new FLIRPhotoSetting();
                fLIRPhotoSetting.setFormat(find);
                fLIRPhotoSetting.setInterval(photoTakingSettings.getTimelapseModeSettings().getInterval());
                fLIRPhotoSetting.setDuration(photoTakingSettings.getTimelapseModeSettings().getDuration());
                CameraFlirRequest.this.callbackSuccess(callbackWithOneParam, fLIRPhotoSetting);
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setRadiometrySettings(FLIRRadiometrySetting fLIRRadiometrySetting, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetRadiometrySettings(fLIRRadiometrySetting), callbackWithNoParam);
    }

    public void setFlirSportMeterEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetSportMeterEnable(z), callbackWithNoParam);
    }

    public void getRadiometrySettings(CallbackWithOneParam<FlirCameraAllSettings.RadiometrySettings> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetRadiometrySettings, FlirCameraAllSettings.RadiometrySettings.class, callbackWithOneParam);
    }

    public void getFlirSDcardStatus(final CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetSDCardStatus, FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
            public void onSuccess(FlirCameraAllSettings.SDCardStatus sDCardStatus) {
                CameraFlirRequest.this.callbackSuccess(callbackWithOneParam, sDCardStatus);
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setFLIRPipPosition(FLIRPipPosition fLIRPipPosition, CallbackWithNoParam callbackWithNoParam) {
        FlirCameraAllSettings.PipPosition pipPosition = new FlirCameraAllSettings.PipPosition();
        pipPosition.setPosition(fLIRPipPosition.getValue());
        request(CameraParamsConfig.method_SetPipPosition, pipPosition, callbackWithNoParam);
    }

    public void getFLIRPipPosition(CallbackWithOneParam<FlirCameraAllSettings.PipPosition> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetPipPosition, FlirCameraAllSettings.PipPosition.class, callbackWithOneParam);
    }
}
