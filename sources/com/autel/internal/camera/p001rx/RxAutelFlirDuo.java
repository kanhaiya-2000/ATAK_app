package com.autel.internal.camera.p001rx;

import com.autel.common.camera.base.DeviceInfo;
import com.autel.internal.sdk.camera.flir.FLIRDisplayMode;
import com.autel.internal.sdk.camera.flir.FLIRIRMSXSetting;
import com.autel.internal.sdk.camera.flir.FLIRPhotoSetting;
import com.autel.internal.sdk.camera.flir.FLIRPipPosition;
import com.autel.internal.sdk.camera.flir.FLIRRecordSetting;
import com.autel.internal.sdk.camera.flir.IRColorMode;
import com.autel.sdk.camera.p005rx.RxAutelBaseCamera;
import io.reactivex.Observable;

/* renamed from: com.autel.internal.camera.rx.RxAutelFlirDuo */
public interface RxAutelFlirDuo extends RxAutelBaseCamera {
    Observable<DeviceInfo> getDeviceInformation();

    Observable<FLIRDisplayMode> getDisplayMode();

    Observable<IRColorMode> getIRColorMode();

    Observable<FLIRIRMSXSetting> getIRMSX();

    Observable<FLIRPhotoSetting> getPhotoFormat();

    Observable<FLIRPipPosition> getPipPosition();

    Observable<FLIRRecordSetting> getRecordingFormat();

    Observable<Boolean> setDisplayMode(FLIRDisplayMode fLIRDisplayMode);

    Observable<Boolean> setIRColorMode(IRColorMode iRColorMode);

    Observable<Boolean> setIRMSX(FLIRIRMSXSetting fLIRIRMSXSetting);

    Observable<Boolean> setPhotoFormat(FLIRPhotoSetting fLIRPhotoSetting);

    Observable<Boolean> setPipPosition(FLIRPipPosition fLIRPipPosition);

    Observable<Boolean> setRecordingFormat(FLIRRecordSetting fLIRRecordSetting);
}
