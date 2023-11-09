package com.autel.camera.protocol.protocol20.interfaces.base;

import com.autel.bean.camera.CameraAllSettings;
import com.autel.camera.protocol.protocol20.entity.CameraDeviceStatus;
import com.autel.camera.protocol.protocol20.entity.CameraEvents;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.CameraPattern;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.SettingEvent;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.internal.sdk.camera.base.AutelSwitchState;

public interface AutelCameraBase {
    void addCameraEventsListener(String str, CallbackWithOneParam<CameraEvents> callbackWithOneParam);

    void formatSDCard(CallbackWithNoParam callbackWithNoParam);

    <T> void getCameraAllSetting(Class<T> cls, CallbackWithOneParam<T> callbackWithOneParam);

    void getCameraDeviceStatus(CallbackWithOneParam<CameraDeviceStatus> callbackWithOneParam);

    void getCameraSystemStatus(CallbackWithOneParam<CameraAllSettings.SystemStatus> callbackWithOneParam);

    void getDeviceInformation(CallbackWithOneParam<CameraAllSettings.DeviceInformation> callbackWithOneParam);

    CameraProduct getProduct();

    <T> void getSDCardStatus(Class<T> cls, CallbackWithOneParam<T> callbackWithOneParam);

    void lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam);

    void resetDefaults(CallbackWithNoParam callbackWithNoParam);

    void setAspectRatio(String str, CallbackWithNoParam callbackWithNoParam);

    void setCameraCurrentDate(CallbackWithNoParam callbackWithNoParam);

    void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam);

    void setConnectStateListener(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void setMediaMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam);

    void setMediaModeListener(CallbackWithOneParam<MediaMode> callbackWithOneParam);

    void setMediaStateListener(CallbackWithTwoParams<MediaStatus, String> callbackWithTwoParams);

    void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam);

    void setSetSDCardStateListener(CallbackWithOneParam<SDCardState> callbackWithOneParam);

    void setSettingChangedListener(CallbackWithOneParam<SettingEvent> callbackWithOneParam);

    void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam);

    void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam);

    void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam);

    void startRecordVideo(CallbackWithNoParam callbackWithNoParam);

    void startTakePhoto(CallbackWithNoParam callbackWithNoParam);

    void stopRecordVideo(CallbackWithNoParam callbackWithNoParam);

    void stopTakePhoto(CallbackWithNoParam callbackWithNoParam);
}
