package com.autel.internal.camera;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.DeviceInfo;
import com.autel.internal.camera.p001rx.RxAutelFlirDuo;
import com.autel.internal.sdk.camera.flir.FLIRDisplayMode;
import com.autel.internal.sdk.camera.flir.FLIRIRMSXSetting;
import com.autel.internal.sdk.camera.flir.FLIRPhotoSetting;
import com.autel.internal.sdk.camera.flir.FLIRPipPosition;
import com.autel.internal.sdk.camera.flir.FLIRRecordSetting;
import com.autel.internal.sdk.camera.flir.IRColorMode;
import com.autel.sdk.camera.AutelBaseCamera;

public interface AutelFlirDuo extends AutelBaseCamera {
    void getDeviceInformation(CallbackWithOneParam<DeviceInfo> callbackWithOneParam);

    void getDisplayMode(CallbackWithOneParam<FLIRDisplayMode> callbackWithOneParam);

    void getIRColorMode(CallbackWithOneParam<IRColorMode> callbackWithOneParam);

    void getIRMSX(CallbackWithOneParam<FLIRIRMSXSetting> callbackWithOneParam);

    void getPhotoFormat(CallbackWithOneParam<FLIRPhotoSetting> callbackWithOneParam);

    void getPipPosition(CallbackWithOneParam<FLIRPipPosition> callbackWithOneParam);

    void getRecordingFormat(CallbackWithOneParam<FLIRRecordSetting> callbackWithOneParam);

    void setDisplayMode(FLIRDisplayMode fLIRDisplayMode, CallbackWithNoParam callbackWithNoParam);

    void setIRColorMode(IRColorMode iRColorMode, CallbackWithNoParam callbackWithNoParam);

    void setIRMSX(FLIRIRMSXSetting fLIRIRMSXSetting, CallbackWithNoParam callbackWithNoParam);

    void setPhotoFormat(FLIRPhotoSetting fLIRPhotoSetting, CallbackWithNoParam callbackWithNoParam);

    void setPipPosition(FLIRPipPosition fLIRPipPosition, CallbackWithNoParam callbackWithNoParam);

    void setRecordingFormat(FLIRRecordSetting fLIRRecordSetting, CallbackWithNoParam callbackWithNoParam);

    RxAutelFlirDuo toRx();
}
