package com.autel.camera.protocol.protocol20.interfaces;

import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.camera.protocol.protocol20.interfaces.xb008.CameraXb08Service;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.XT706.IrColor;
import com.autel.common.camera.XT706.IrPosition;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.media.DeFogParam;
import com.autel.common.camera.media.ImageRoiParam;
import com.autel.common.camera.media.SaveLocation;
import com.autel.common.camera.media.ShutterMode;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.visual.TrackMode;
import com.autel.common.camera.visual.TrackStateInfo;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.camera.xb015.PIVMode;

public interface CameraXT706 extends CameraXb08Service {
    void addCameraSystemStatusListener(String str, CallbackWithOneParam<CameraSystemStatus> callbackWithOneParam);

    void cancelTracking(CallbackWithNoParam callbackWithNoParam);

    void formatFlashMemoryCard(CallbackWithNoParam callbackWithNoParam);

    void getAlbumLocation(CallbackWithOneParam<CameraAllSettings.StorageType> callbackWithOneParam);

    void getDeFogParams(CallbackWithOneParam<DeFogParam> callbackWithOneParam);

    void getDisplayMode(CallbackWithOneParam<DisplayMode> callbackWithOneParam);

    void getFMCStatus(CallbackWithOneParam<CameraAllSettings.MMCStatus> callbackWithOneParam);

    void getFocusMFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam);

    void getHDRSetting(CallbackWithOneParam<Boolean> callbackWithOneParam);

    void getImageRoiParams(CallbackWithOneParam<ImageRoiParam> callbackWithOneParam);

    void getIrColor(CallbackWithOneParam<IrColor> callbackWithOneParam);

    void getIrPosition(CallbackWithOneParam<IrPosition> callbackWithOneParam);

    void getMotionDelayShotDuration(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getMotionDelayShotInterval(CallbackWithOneParam<Integer> callbackWithOneParam);

    void getMotionDelayShotKeepPhoto(CallbackWithOneParam<MotionPhotoInfo> callbackWithOneParam);

    void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam);

    void getShutterMode(CallbackWithOneParam<ShutterMode> callbackWithOneParam);

    void getTrackingState(CallbackWithOneParam<TrackStateInfo> callbackWithOneParam);

    void pauseMotionDelayShot(CallbackWithNoParam callbackWithNoParam);

    void resumeMotionDelayShot(CallbackWithNoParam callbackWithNoParam);

    void setAFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setAlbumSaveLocation(SaveLocation saveLocation, CallbackWithNoParam callbackWithNoParam);

    void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam);

    void setDeFogEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setDeFogStrength(int i, CallbackWithNoParam callbackWithNoParam);

    void setDisplayMode(DisplayMode displayMode, CallbackWithNoParam callbackWithNoParam);

    void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setHDREnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setImageRoiArea(int i, int i2, CallbackWithNoParam callbackWithNoParam);

    void setImageRoiEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setImageRoiStrength(int i, CallbackWithNoParam callbackWithNoParam);

    void setIrColor(IrColor irColor, CallbackWithNoParam callbackWithNoParam);

    void setIrFlushShutter(CallbackWithNoParam callbackWithNoParam);

    void setIrPosition(IrPosition irPosition, CallbackWithNoParam callbackWithNoParam);

    void setMFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam);

    void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam);

    void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam);

    void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam);

    void setProductSubtitleSNEnable(boolean z, CallbackWithNoParam callbackWithNoParam);

    void setShutterMode(ShutterMode shutterMode, CallbackWithNoParam callbackWithNoParam);

    void setTrackingGoalArea(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam);

    void setTrackingMode(TrackMode trackMode, CallbackWithNoParam callbackWithNoParam);

    void startMotionDelayShot(CallbackWithNoParam callbackWithNoParam);

    void stopMotionDelayShot(CallbackWithNoParam callbackWithNoParam);

    void takePhotoWithFocus(CallbackWithNoParam callbackWithNoParam);
}
