package com.autel.sdk.camera;

import com.autel.common.CallbackWithNoParam;
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
import com.autel.sdk.camera.p005rx.RxAutelBaseCamera;

public interface AutelBaseCamera {
    void formatSDCard(CallbackWithNoParam callbackWithNoParam);

    void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getGpsCoordinateType(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getMediaMode(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    CameraProduct getProduct();

    void getSDCardFreeSpace(CallbackWithOneParam<Long> callbackWithOneParam);

    void getSDCardState(CallbackWithOneParam<SDCardState> callbackWithOneParam);

    void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam);

    void getVersion(CallbackWithOneParam<String> callbackWithOneParam);

    void getWorkState(CallbackWithOneParam<WorkState> callbackWithOneParam);

    void lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam);

    void resetDefaults(CallbackWithNoParam callbackWithNoParam);

    void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam);

    void setGpsCoordinateType(int i, CallbackWithNoParam callbackWithNoParam);

    void setMediaMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam);

    void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams);

    void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam);

    void startRecordVideo(CallbackWithNoParam callbackWithNoParam);

    void startTakePhoto(CallbackWithNoParam callbackWithNoParam);

    void stopRecordVideo(CallbackWithNoParam callbackWithNoParam);

    void stopTakePhoto(CallbackWithNoParam callbackWithNoParam);

    RxAutelBaseCamera toRx();
}
