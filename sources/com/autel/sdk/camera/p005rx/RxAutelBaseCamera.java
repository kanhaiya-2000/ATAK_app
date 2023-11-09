package com.autel.sdk.camera.p005rx;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.CameraPattern;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import io.reactivex.Observable;

/* renamed from: com.autel.sdk.camera.rx.RxAutelBaseCamera */
public interface RxAutelBaseCamera {
    Observable<Boolean> formatSDCard();

    Observable<Integer> getGpsCoordinateType();

    Observable<MediaMode> getMediaMode();

    Observable<CameraProduct> getProduct();

    Observable<Long> getSDCardFreeSpace();

    Observable<SDCardState> getSDCardStatus();

    Observable<BaseStateInfo> getStateInfo();

    Observable<String> getVersion();

    Observable<WorkState> getWorkStatus();

    Observable<Boolean> lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState);

    Observable<Boolean> resetDefaults();

    Observable<Boolean> setCameraPattern(CameraPattern cameraPattern);

    Observable<Boolean> setGpsCoordinateType(int i);

    Observable<Boolean> setMediaMode(MediaMode mediaMode);

    void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams);

    void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam);

    Observable<Boolean> startRecordVideo();

    Observable<Boolean> startTakePhoto();

    Observable<Boolean> stopRecordVideo();

    Observable<Boolean> stopTakePhoto();
}
