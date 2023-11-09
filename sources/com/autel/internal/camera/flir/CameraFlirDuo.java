package com.autel.internal.camera.flir;

import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.FlirCameraAllSettings;
import com.autel.camera.protocol.protocol20.flir.FlirDuo;
import com.autel.camera.protocol.protocol20.interfaces.flir.CameraFlirDuoService;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.DeviceInfo;
import com.autel.common.camera.base.ProtocolVersion;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.BaseCamera10;
import com.autel.internal.camera.p001rx.RxAutelFlirDuo;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.model.CameraFlirData;
import com.autel.internal.sdk.camera.flir.FLIRDisplayMode;
import com.autel.internal.sdk.camera.flir.FLIRIRMSXSetting;
import com.autel.internal.sdk.camera.flir.FLIRPhotoSetting;
import com.autel.internal.sdk.camera.flir.FLIRPipPosition;
import com.autel.internal.sdk.camera.flir.FLIRRecordSetting;
import com.autel.internal.sdk.camera.flir.IRColorMode;

public class CameraFlirDuo extends BaseCamera10 implements CameraFlirDuoService {
    private CameraFlirDuoService request = ((CameraFlirDuoService) CameraFactory.getCameraProduct(FlirDuo.class));

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
    }

    public RxAutelFlirDuo toRx() {
        return null;
    }

    public void setDisplayMode(FLIRDisplayMode fLIRDisplayMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setDisplayMode(fLIRDisplayMode, callbackWithNoParam);
    }

    public void getDisplayMode(CallbackWithOneParam<FLIRDisplayMode> callbackWithOneParam) {
        this.request.getDisplayMode(callbackWithOneParam);
    }

    public void setIRColorMode(IRColorMode iRColorMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setIRColorMode(iRColorMode, callbackWithNoParam);
    }

    public void getIRColorMode(CallbackWithOneParam<IRColorMode> callbackWithOneParam) {
        this.request.getIRColorMode(callbackWithOneParam);
    }

    public void setIRMSX(FLIRIRMSXSetting fLIRIRMSXSetting, CallbackWithNoParam callbackWithNoParam) {
        if (fLIRIRMSXSetting != null) {
            this.request.setIRMSX(fLIRIRMSXSetting, callbackWithNoParam);
        }
    }

    public void getIRMSX(CallbackWithOneParam<FLIRIRMSXSetting> callbackWithOneParam) {
        this.request.getIRMSX(callbackWithOneParam);
    }

    public void setRecordingFormat(FLIRRecordSetting fLIRRecordSetting, CallbackWithNoParam callbackWithNoParam) {
        if (fLIRRecordSetting != null) {
            this.request.setRecordingFormat(fLIRRecordSetting, callbackWithNoParam);
        }
    }

    public void getRecordingFormat(CallbackWithOneParam<FLIRRecordSetting> callbackWithOneParam) {
        this.request.getRecordingFormat(callbackWithOneParam);
    }

    public void setPhotoFormat(FLIRPhotoSetting fLIRPhotoSetting, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoFormat(fLIRPhotoSetting, callbackWithNoParam);
    }

    public void getPhotoFormat(CallbackWithOneParam<FLIRPhotoSetting> callbackWithOneParam) {
        this.request.getPhotoFormat(callbackWithOneParam);
    }

    public void getDeviceInformation(final CallbackWithOneParam<DeviceInfo> callbackWithOneParam) {
        this.request.getDeviceInformation(new CallbackWithOneParam<CameraAllSettings.DeviceInformation>() {
            public void onSuccess(final CameraAllSettings.DeviceInformation deviceInformation) {
                callbackWithOneParam.onSuccess(new DeviceInfo() {
                    public CameraProduct getCameraProduct() {
                        return CameraProduct.find(deviceInformation.getDeviceModel());
                    }

                    public ProtocolVersion getProtocolVersion() {
                        return ProtocolVersion.find(deviceInformation.getProtocolVersion() + "");
                    }

                    public String getFirmwareVersion() {
                        return deviceInformation.getFirmwareVersion();
                    }

                    public String getSerialNumber() {
                        return deviceInformation.getSerialNumber();
                    }

                    public String getHardwareId() {
                        return deviceInformation.getHardwareId();
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setPipPosition(FLIRPipPosition fLIRPipPosition, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPipPosition(fLIRPipPosition, callbackWithNoParam);
    }

    public void getPipPosition(CallbackWithOneParam<FLIRPipPosition> callbackWithOneParam) {
        this.request.getPipPosition(callbackWithOneParam);
    }

    public void getCurrentRecordTime(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            if (CameraModelDataManager.instance().getBaseCameraData() instanceof CameraFlirData) {
                this.request.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
                    public void onSuccess(FlirCameraAllSettings.SDCardStatus sDCardStatus) {
                        callbackWithOneParam.onSuccess(Integer.valueOf((int) sDCardStatus.getCurrentRecordTime()));
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                });
            } else {
                this.request.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
                    public void onSuccess(CameraAllSettings.SDCardStatus sDCardStatus) {
                        callbackWithOneParam.onSuccess(Integer.valueOf((int) sDCardStatus.getCurrentRecordTime()));
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                });
            }
        }
    }
}
