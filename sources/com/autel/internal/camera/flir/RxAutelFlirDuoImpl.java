package com.autel.internal.camera.flir;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.DeviceInfo;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.internal.camera.AutelFlirDuo;
import com.autel.internal.camera.RxAutelBaseCameraImpl;
import com.autel.internal.camera.p001rx.RxAutelFlirDuo;
import com.autel.internal.sdk.camera.flir.FLIRDisplayMode;
import com.autel.internal.sdk.camera.flir.FLIRIRMSXSetting;
import com.autel.internal.sdk.camera.flir.FLIRPhotoSetting;
import com.autel.internal.sdk.camera.flir.FLIRPipPosition;
import com.autel.internal.sdk.camera.flir.FLIRRecordSetting;
import com.autel.internal.sdk.camera.flir.IRColorMode;
import io.reactivex.Observable;

public class RxAutelFlirDuoImpl extends RxAutelBaseCameraImpl implements RxAutelFlirDuo {
    AutelFlirDuo mAutelFlirDuo;

    public Observable<Boolean> formatSDCard() {
        return null;
    }

    public Observable<DeviceInfo> getDeviceInformation() {
        return null;
    }

    public Observable<FLIRDisplayMode> getDisplayMode() {
        return null;
    }

    public Observable<IRColorMode> getIRColorMode() {
        return null;
    }

    public Observable<FLIRIRMSXSetting> getIRMSX() {
        return null;
    }

    public Observable<MediaMode> getMediaMode() {
        return null;
    }

    public Observable<FLIRPhotoSetting> getPhotoFormat() {
        return null;
    }

    public Observable<FLIRPipPosition> getPipPosition() {
        return null;
    }

    public Observable<CameraProduct> getProduct() {
        return null;
    }

    public Observable<FLIRRecordSetting> getRecordingFormat() {
        return null;
    }

    public Observable<Long> getSDCardFreeSpace() {
        return null;
    }

    public Observable<SDCardState> getSDCardStatus() {
        return null;
    }

    public Observable<String> getVersion() {
        return null;
    }

    public Observable<WorkState> getWorkStatus() {
        return null;
    }

    public Observable<Boolean> resetDefaults() {
        return null;
    }

    public Observable<Boolean> setDisplayMode(FLIRDisplayMode fLIRDisplayMode) {
        return null;
    }

    public Observable<Boolean> setIRColorMode(IRColorMode iRColorMode) {
        return null;
    }

    public Observable<Boolean> setIRMSX(FLIRIRMSXSetting fLIRIRMSXSetting) {
        return null;
    }

    public Observable<Boolean> setMediaMode(MediaMode mediaMode) {
        return null;
    }

    public void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
    }

    public void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams) {
    }

    public Observable<Boolean> setPhotoFormat(FLIRPhotoSetting fLIRPhotoSetting) {
        return null;
    }

    public Observable<Boolean> setPipPosition(FLIRPipPosition fLIRPipPosition) {
        return null;
    }

    public Observable<Boolean> setRecordingFormat(FLIRRecordSetting fLIRRecordSetting) {
        return null;
    }

    public void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam) {
    }

    public Observable<Boolean> startRecordVideo() {
        return null;
    }

    public Observable<Boolean> startTakePhoto() {
        return null;
    }

    public Observable<Boolean> stopRecordVideo() {
        return null;
    }

    public Observable<Boolean> stopTakePhoto() {
        return null;
    }

    public RxAutelFlirDuoImpl(AutelFlirDuo autelFlirDuo) {
        super(autelFlirDuo);
        this.mAutelFlirDuo = autelFlirDuo;
    }
}
