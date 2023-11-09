package com.autel.camera.protocol.protocol10.interfaces.base;

import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraStatusWithParser10;
import com.autel.camera.protocol.protocol10.engine.CameraEvents;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.CameraPattern;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;

public interface AutelCameraBase {
    void addCameraEventsListener(String str, CallbackWithOneParam<CameraEvents> callbackWithOneParam);

    void formatSDCard(CallbackWithNoParam callbackWithNoParam);

    void getCameraSettings(CallbackWithOneParam<AutelCameraSettingWithParser10> callbackWithOneParam);

    void getCameraStatus(CallbackWithOneParam<AutelCameraStatusWithParser10> callbackWithOneParam);

    void getMediaMode(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    CameraProduct getProduct();

    void getSDCardFreeSpace(CallbackWithOneParam<Long> callbackWithOneParam);

    void getSDCardStatus(CallbackWithOneParam<SDCardState> callbackWithOneParam);

    void getTimeStamp(CallbackWithOneParam<Long> callbackWithOneParam);

    void getVersion(CallbackWithOneParam<String> callbackWithOneParam);

    void getWorkStatus(CallbackWithOneParam<WorkState> callbackWithOneParam);

    void resetDefaults(CallbackWithNoParam callbackWithNoParam);

    void setCameraCurrentDate(CallbackWithNoParam callbackWithNoParam);

    void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam);

    void setConnectStateListener(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setMediaMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam);

    void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams);

    void setSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam);

    void startRecordVideo(CallbackWithNoParam callbackWithNoParam);

    void startTakePhoto(CallbackWithNoParam callbackWithNoParam);

    void stopRecordVideo(CallbackWithNoParam callbackWithNoParam);

    void stopTakePhoto(CallbackWithNoParam callbackWithNoParam);
}
