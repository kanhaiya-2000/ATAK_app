package com.autel.camera.protocol.protocol20.interfaces;

import com.autel.bean.camera.CameraSystemStatus;
import com.autel.camera.protocol.protocol20.interfaces.xb008.CameraXb08Service;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.media.ShutterMode;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.visual.TrackMode;
import com.autel.common.camera.visual.TrackStateInfo;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.camera.xb015.PIVMode;

public interface CameraXb016 extends CameraXb08Service {
    void addCameraSystemStatusListener(String str, CallbackWithOneParam<CameraSystemStatus> callbackWithOneParam);

    void cancelTracking(CallbackWithNoParam callbackWithNoParam);

    void getFocusMFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam);

    void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam);

    void getShutterMode(CallbackWithOneParam<ShutterMode> callbackWithOneParam);

    void getTrackingState(CallbackWithOneParam<TrackStateInfo> callbackWithOneParam);

    void setAFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setMFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam);

    void setProductSubtitleSNEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setShutterMode(ShutterMode shutterMode, CallbackWithNoParam callbackWithNoParam);

    void setTrackingGoalArea(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam);

    void setTrackingMode(TrackMode trackMode, CallbackWithNoParam callbackWithNoParam);

    void takePhotoWithFocus(CallbackWithNoParam callbackWithNoParam);
}
