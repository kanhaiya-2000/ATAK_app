package com.autel.camera.protocol.protocol20.request;

import android.text.format.Time;
import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.camera.communication.http.events.CameraMessageDisPatcher;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.autel.camera.protocol.protocol20.entity.CameraDeviceStatus;
import com.autel.camera.protocol.protocol20.entity.CameraEvents;
import com.autel.camera.protocol.protocol20.entity.CameraHttpParamFactory;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.camera.protocol.protocol20.parser.BaseRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.base.CameraPattern;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.base.AutelSwitchState;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class BaseCameraRequest extends BaseRequest {
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, CallbackWithOneParam> mCameraEventsListeners;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, CallbackWithOneParam> mCameraStatusListeners;

    private BaseCameraRequest() {
        this.mCameraEventsListeners = new ConcurrentHashMap<>();
        this.mCameraStatusListeners = new ConcurrentHashMap<>();
        initRegisterListener();
    }

    public static BaseCameraRequest instance() {
        return BaseCameraRequestHolder.s_instance;
    }

    private static class BaseCameraRequestHolder {
        /* access modifiers changed from: private */
        public static final BaseCameraRequest s_instance = new BaseCameraRequest();

        private BaseCameraRequestHolder() {
        }
    }

    public void addCameraEventsListener(String str, CallbackWithOneParam<CameraEvents> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.mCameraEventsListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeCameraEventsListener(String str) {
        this.mCameraEventsListeners.remove(str);
    }

    public void addCameraSystemStatusListener(String str, CallbackWithOneParam<CameraSystemStatus> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.mCameraStatusListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeCameraSystemStatusListener(String str) {
        this.mCameraStatusListeners.remove(str);
    }

    private void removeCameraListener() {
        CameraMessageDisPatcher.instance().unRegisterReceiveListener(CameraConstant20.CameraEventsListener);
        CameraMessageDisPatcher.instance().unRegisterReceiveListener(CameraConstant20.SystemStatusListener);
    }

    public void getCameraSystemStatus(CallbackWithOneParam<CameraAllSettings.SystemStatus> callbackWithOneParam) {
        if (checkCallBack(callbackWithOneParam)) {
            query(CameraParamsConfig.method_GetSystemStatus, CameraAllSettings.SystemStatus.class, callbackWithOneParam);
        }
    }

    public void getCameraDeviceInformation(CallbackWithOneParam<CameraAllSettings.DeviceInformation> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetDeviceInformation, CameraAllSettings.DeviceInformation.class, callbackWithOneParam);
    }

    public void getSystemDateAndTime(CallbackWithOneParam<CameraAllSettings.SystemDateAndTime> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetSystemDateAndTime, CameraAllSettings.SystemDateAndTime.class, callbackWithOneParam);
    }

    public <T> void getCameraAllSettings(Class<T> cls, CallbackWithOneParam<T> callbackWithOneParam) {
        if (checkCallBack(callbackWithOneParam)) {
            query(CameraParamsConfig.method_GetAllSettings, cls, callbackWithOneParam);
        }
    }

    public <T> void getSDCardStatus(Class<T> cls, CallbackWithOneParam<T> callbackWithOneParam) {
        if (checkCallBack(callbackWithOneParam)) {
            query(CameraParamsConfig.method_GetSDCardStatus, cls, callbackWithOneParam);
        }
    }

    public void setCameraCurrentDate(CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.SystemDateAndTime systemDateAndTime = new CameraAllSettings.SystemDateAndTime();
        Time time = new Time();
        time.setToNow();
        String format = time.format("%Y-%m-%d %H:%M:%S");
        systemDateAndTime.setTimeZone(TimeZone.getDefault().getRawOffset() / 1000);
        systemDateAndTime.setDateTime(format);
        request(CameraParamsConfig.method_SetSystemDateAndTime, systemDateAndTime, callbackWithNoParam);
    }

    public void setCameraMode(MediaMode mediaMode, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            CameraAllSettings.CameraMode cameraMode = new CameraAllSettings.CameraMode();
            cameraMode.setMode(mediaMode.getValue20());
            request(CameraParamsConfig.method_SetCameraMode, cameraMode, callbackWithNoParam);
        }
    }

    public void setCameraAspectRatio(String str, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            CameraAllSettings.PhotoTakingSettings photoTakingSettings = new CameraAllSettings.PhotoTakingSettings();
            photoTakingSettings.setResolution(str);
            request(CameraParamsConfig.method_SetPhotoTakingSettings, photoTakingSettings, callbackWithNoParam);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildSetPhotoFormat(photoFormat.value()), callbackWithNoParam);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            String videoResolutionAndFps2 = videoResolutionAndFps.toString();
            if (videoResolutionAndFps2.contains("*")) {
                videoResolutionAndFps2 = videoResolutionAndFps2.replace("*", "x");
            }
            request(CameraHttpParamFactory.getInstance().buildSetVideoResolution(0, videoResolutionAndFps2), callbackWithNoParam);
        }
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildSetFileFormat(videoFormat.value()), callbackWithNoParam);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildSetVideoStandard(videoStandard.value()), callbackWithNoParam);
        }
    }

    public void takePhoto(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildStartTakePhotos(i), callbackWithNoParam);
        }
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildStartRecording(), callbackWithNoParam);
        }
    }

    public void stopRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildStopRecording(), callbackWithNoParam);
        }
    }

    public void stopTimelapse(CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildStopTakePhotos(), callbackWithNoParam);
        }
    }

    public void formatSDCard(CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildStartFormatSDCard(), callbackWithNoParam);
        }
    }

    public void resetCamera(CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildStartFactoryReset(), callbackWithNoParam);
        }
    }

    public void getDeviceStatus(CallbackWithOneParam<CameraDeviceStatus> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetDeviceStatus, CameraDeviceStatus.class, callbackWithOneParam);
    }

    private void initRegisterListener() {
        CameraMessageDisPatcher.instance().registerReceiveListener(CameraConstant20.CameraEventsListener, new CallbackWithOneParam<CameraEvents>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(CameraEvents cameraEvents) {
                BaseCameraRequest baseCameraRequest = BaseCameraRequest.this;
                baseCameraRequest.callbackListener(baseCameraRequest.mCameraEventsListeners, cameraEvents);
            }
        });
        CameraMessageDisPatcher.instance().registerReceiveListener(CameraConstant20.SystemStatusListener, new CallbackWithOneParam<CameraSystemStatus>() {
            public void onFailure(AutelError autelError) {
            }

            public void onSuccess(CameraSystemStatus cameraSystemStatus) {
                BaseCameraRequest baseCameraRequest = BaseCameraRequest.this;
                baseCameraRequest.callbackListener(baseCameraRequest.mCameraStatusListeners, cameraSystemStatus);
            }
        });
    }

    /* access modifiers changed from: private */
    public <T> void callbackListener(ConcurrentHashMap<String, CallbackWithOneParam> concurrentHashMap, T t) {
        if (!concurrentHashMap.isEmpty()) {
            for (CallbackWithOneParam onSuccess : concurrentHashMap.values()) {
                onSuccess.onSuccess(t);
            }
        }
    }

    public void setCameraPattern(CameraPattern cameraPattern, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildSetCameraPattern(cameraPattern.value()), callbackWithNoParam);
        }
    }

    public void lockGimbalWhenTakePhoto(AutelSwitchState autelSwitchState, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildLockGimbalWhenTakePhoto(autelSwitchState == AutelSwitchState.ON ? 1 : 0), callbackWithNoParam);
        }
    }

    public void setGpsCoordinateType(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildSetGpsCoordinateType(i), callbackWithNoParam);
        }
    }

    public void getGpsCoordinateType(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        if (checkCallBack(callbackWithOneParam)) {
            request(CameraHttpParamFactory.getInstance().buildGetGpsCoordinateType(), callbackWithOneParam);
        }
    }
}
