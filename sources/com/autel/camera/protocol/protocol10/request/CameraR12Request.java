package com.autel.camera.protocol.protocol10.request;

import com.autel.camera.protocol.protocol10.engine.CameraCommandMsgFactory;
import com.autel.camera.protocol.protocol10.parser.BaseRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.base.AutelSwitchState;

public class CameraR12Request extends BaseRequest {
    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraSpotMeter(String.valueOf(i2) + String.valueOf(i)), callbackWithNoParam);
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraEV(exposureCompensation.getValue()), callbackWithNoParam);
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraIso(cameraISO.getValue()), callbackWithNoParam);
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraShutter(shutterSpeed.getValue()), callbackWithNoParam);
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraColor(colorStyle.value10()), callbackWithNoParam);
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraWB(whiteBalance.type.value10()), callbackWithNoParam);
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraVideoSize(videoResolutionAndFps.toString()), callbackWithNoParam);
    }

    public void setAspectRatio(String str, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraPhotoSize(str), callbackWithNoParam);
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraPhotoType(photoFormat.value()), callbackWithNoParam);
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraSystem(videoStandard.value()), callbackWithNoParam);
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraVideoType(videoFormat.value()), callbackWithNoParam);
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createAebNum(photoAEBCount.value()), callbackWithNoParam);
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createTimelapseNum(photoTimelapseInterval.value()), callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraBurstNum(photoBurstCount.value()), callbackWithNoParam);
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraVideoSubtitle((z ? AutelSwitchState.ON : AutelSwitchState.OFF).value()), callbackWithNoParam);
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PhotoStyleType.Custom.value());
        stringBuffer.append(",");
        stringBuffer.append(i);
        stringBuffer.append(",");
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        request(CameraCommandMsgFactory.createSetCameraPhotoStyle(stringBuffer.toString()), callbackWithNoParam);
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraPhotoStyle(photoStyleType.value()), callbackWithNoParam);
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraGear(exposureMode), callbackWithNoParam);
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraAELock(autoExposureLockState.value()), callbackWithNoParam);
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCameraFlicker(antiFlicker.value10()), callbackWithNoParam);
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createSetCamera3DDenoise((z ? AutelSwitchState.ON : AutelSwitchState.OFF).value()), callbackWithNoParam);
    }

    public void setHistogramStatusEnable(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraHisto(autelSwitchState), callbackWithNoParam);
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraCommandMsgFactory.createCameraZoomFactor(String.valueOf(i)), callbackWithNoParam);
    }

    public void getCurrentRecordTimeSeconds(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        query(CameraCommandMsgFactory.createCameraCurrentVideoTime(), callbackWithOneParam);
    }
}
