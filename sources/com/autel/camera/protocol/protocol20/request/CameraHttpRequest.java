package com.autel.camera.protocol.protocol20.request;

import android.text.TextUtils;
import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.Histogram;
import com.autel.bean.camera.StreamInfo;
import com.autel.camera.communication.http.events.CameraMessageDisPatcher;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.autel.camera.protocol.protocol20.entity.CameraEvents;
import com.autel.camera.protocol.protocol20.entity.CameraHttpParamFactory;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.camera.protocol.protocol20.entity.DehazeSetting;
import com.autel.camera.protocol.protocol20.entity.ImageRoiSetting;
import com.autel.camera.protocol.protocol20.entity.ShutterInternal;
import com.autel.camera.protocol.protocol20.entity.TrackingStatus;
import com.autel.camera.protocol.protocol20.parser.BaseRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.XT706.ImageMode;
import com.autel.common.camera.XT706.IrColor;
import com.autel.common.camera.XT706.IrPosition;
import com.autel.common.camera.XT706.IrTemperatureParams;
import com.autel.common.camera.XT706.IrTemperatureWarnParams;
import com.autel.common.camera.base.HDRStatus;
import com.autel.common.camera.base.ISOMode;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.IrGainMode;
import com.autel.common.camera.media.IrIsoThermMode;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.LensFocusStatus;
import com.autel.common.camera.media.MeteringMode;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.SaveLocation;
import com.autel.common.camera.media.ShutterMode;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.util.okhttp.utils.MessageParser;
import java.util.List;

public class CameraHttpRequest extends BaseRequest {
    public void setHistogramListener(final CallbackWithOneParam<Histogram> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            setHistogramStatusEnable(0, new CallbackWithNoParam() {
                public void onSuccess() {
                    CameraXB015Data.instance().setHistogramEnable(0);
                    CameraMessageDisPatcher.instance().unRegisterReceiveListener(CameraConstant20.CameraHistogramListener);
                }

                public void onFailure(AutelError autelError) {
                    CameraMessageDisPatcher.instance().unRegisterReceiveListener(CameraConstant20.CameraHistogramListener);
                }
            });
            CameraMessageDisPatcher.instance().unRegisterReceiveListener(CameraConstant20.CameraHistogramListener);
            return;
        }
        setHistogramStatusEnable(1, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraMessageDisPatcher.instance().registerReceiveListener(CameraConstant20.CameraHistogramListener, callbackWithOneParam);
            }

            public void onFailure(AutelError autelError) {
                CameraMessageDisPatcher.instance().unRegisterReceiveListener(CameraConstant20.CameraHistogramListener);
            }
        });
    }

    private void setHistogramStatusEnable(int i, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.HistogramSettings histogramSettings = new CameraAllSettings.HistogramSettings();
        histogramSettings.setEnable(i);
        request(CameraParamsConfig.method_SetHistogramSettings, histogramSettings, callbackWithNoParam);
    }

    public void setAutoFocusStateListener(String str, final CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        if (callbackWithTwoParams != null) {
            addCameraEventsListener(str, new CallbackWithOneParam<CameraEvents>() {
                public void onSuccess(CameraEvents cameraEvents) {
                    if (CameraConstant20.AutoFocus.equals(cameraEvents.getType())) {
                        String str = cameraEvents.getMap().get("Position");
                        if (!TextUtils.isEmpty(str)) {
                            callbackWithTwoParams.onSuccess(LensFocusStatus.find(cameraEvents.getMap().get("State")), MessageParser.getObjectList(str, SpotMeteringArea.class));
                        }
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithTwoParams.onFailure(autelError);
                }
            });
        } else {
            BaseCameraRequest.instance().removeCameraEventsListener(str);
        }
    }

    public void addCameraEventsListener(String str, CallbackWithOneParam<CameraEvents> callbackWithOneParam) {
        BaseCameraRequest.instance().addCameraEventsListener(str, callbackWithOneParam);
    }

    public void setFocusAFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.Focus.AFMeter.SpotArea spotArea = new CameraAllSettings.Focus.AFMeter.SpotArea();
        spotArea.setX(i);
        spotArea.setY(i2);
        request(CameraParamsConfig.method_SetFocus, spotArea, callbackWithNoParam);
    }

    public void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.Focus.MFSpotArea mFSpotArea = new CameraAllSettings.Focus.MFSpotArea();
        mFSpotArea.setX(i);
        mFSpotArea.setY(i2);
        request(CameraParamsConfig.method_SetFocus, mFSpotArea, callbackWithNoParam);
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.AELock aELock = new CameraAllSettings.AELock();
        aELock.setLocked(autoExposureLockState == AutoExposureLockState.LOCK ? 1 : 0);
        request(CameraParamsConfig.method_SetAELock, aELock, callbackWithNoParam);
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.ImageExposure imageExposure = new CameraAllSettings.ImageExposure();
        imageExposure.setExposure(Double.parseDouble(exposureCompensation.getValue20()));
        request(CameraParamsConfig.method_SetImageExposure, imageExposure, callbackWithNoParam);
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.ImageISO imageISO = new CameraAllSettings.ImageISO();
        imageISO.setISO(Integer.parseInt(cameraISO.getValue()));
        request(CameraParamsConfig.method_SetImageISO, imageISO, callbackWithNoParam);
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.ShutterSpeed shutterSpeed2 = new CameraAllSettings.ShutterSpeed();
        shutterSpeed2.setShutter(shutterSpeed.getValue());
        request(CameraParamsConfig.method_SetShutterSpeed, shutterSpeed2, callbackWithNoParam);
    }

    public void getColorStyle(CallbackWithOneParam<CameraAllSettings.ImageColor> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetImageColor, CameraAllSettings.ImageColor.class, callbackWithOneParam);
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        if (WhiteBalanceType.CUSTOM == whiteBalance.type) {
            request(CameraHttpParamFactory.getInstance().buildSetWhiteBalance(whiteBalance.type.value20(), whiteBalance.colorTemperature), callbackWithNoParam);
        } else {
            request(CameraHttpParamFactory.getInstance().buildSetWhiteBalance(whiteBalance.type.value20()), callbackWithNoParam);
        }
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetImageColor(colorStyle.value20()), callbackWithNoParam);
    }

    public void getAutoExposureLockState(CallbackWithOneParam<CameraAllSettings.AELock> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetAELock, CameraAllSettings.AELock.class, callbackWithOneParam);
    }

    public void getAntiFlicker(CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetVideoSourceConfiguration, CameraAllSettings.VideoSourceConfiguration.class, callbackWithOneParam);
    }

    public void getWhiteBalance(CallbackWithOneParam<CameraAllSettings.WhiteBalance> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetWhiteBalance, CameraAllSettings.WhiteBalance.class, callbackWithOneParam);
    }

    public void getExposure(CallbackWithOneParam<CameraAllSettings.ImageExposure> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetImageExposure, CameraAllSettings.ImageExposure.class, callbackWithOneParam);
    }

    public void getShutter(CallbackWithOneParam<CameraAllSettings.ShutterSpeed> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetShutterSpeed, CameraAllSettings.ShutterSpeed.class, callbackWithOneParam);
    }

    public void getISO(CallbackWithOneParam<CameraAllSettings.ImageISO> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetImageISO, CameraAllSettings.ImageISO.class, callbackWithOneParam);
    }

    public void getExposureMode(CallbackWithOneParam<CameraAllSettings.CameraGear> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetCameraGear, CameraAllSettings.CameraGear.class, callbackWithOneParam);
    }

    public void isHistogramStatusEnable(CallbackWithOneParam<CameraAllSettings.HistogramSettings> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetHistogramSettings, CameraAllSettings.HistogramSettings.class, callbackWithOneParam);
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetEnableSubtitle(z ? 1 : 0), callbackWithNoParam);
    }

    public void isSubtitleEnable(CallbackWithOneParam<CameraAllSettings.RecordingSettings> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetRecordingSettings, CameraAllSettings.RecordingSettings.class, callbackWithOneParam);
    }

    public void getPhotoStyle(CallbackWithOneParam<CameraAllSettings.ImageStyle> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetImageStyle, CameraAllSettings.ImageStyle.class, callbackWithOneParam);
    }

    public void setIRIS(CameraAperture cameraAperture, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.IRIS iris = new CameraAllSettings.IRIS();
        iris.setIrisValue(Double.parseDouble(cameraAperture.getValue()));
        request(CameraParamsConfig.method_SetIRIS, iris, callbackWithNoParam);
    }

    public void getIRIS(CallbackWithOneParam<CameraAllSettings.IRIS> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetIRIS, CameraAllSettings.IRIS.class, callbackWithOneParam);
    }

    public void setFocusMode(LensFocusMode lensFocusMode, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetCameraFocusMode(lensFocusMode.value()), callbackWithNoParam);
    }

    public void getFocusMode(CallbackWithOneParam<CameraAllSettings.Focus> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetFocus, CameraAllSettings.Focus.class, callbackWithOneParam);
    }

    public void getFocusDistance(CallbackWithOneParam<CameraAllSettings.Focus> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetFocus, CameraAllSettings.Focus.class, callbackWithOneParam);
    }

    public void getColorTemperature(CallbackWithOneParam<CameraAllSettings.WhiteBalance> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetWhiteBalance, CameraAllSettings.WhiteBalance.class, callbackWithOneParam);
    }

    public void getDigitalZoomScale(CallbackWithOneParam<CameraAllSettings.ZoomFactor> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetZoomFactor, CameraAllSettings.ZoomFactor.class, callbackWithOneParam);
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.ZoomFactor zoomFactor = new CameraAllSettings.ZoomFactor();
        zoomFactor.setZoomValue(i);
        request(CameraParamsConfig.method_SetZoomFactor, zoomFactor, callbackWithNoParam);
    }

    public void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetCameraAFMeterMode(MeteringMode.SPOT.value(), i, i2), callbackWithNoParam);
    }

    public void setManualFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetCameraMFMeterMode(i, i2), callbackWithNoParam);
    }

    public void setManualFocusDistance(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetCameraFocusMFPosition(i), callbackWithNoParam);
    }

    public void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildStartTakePhotos(1), callbackWithNoParam);
    }

    public void getPhotoTakingSettings(CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetPhotoTakingSettings, CameraAllSettings.PhotoTakingSettings.class, callbackWithOneParam);
    }

    public void setCameraAFAssistFocusEnable(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetAFAssistFocusEnable(i), callbackWithNoParam);
    }

    public void setCameraMFAssistFocusEnable(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetMFAssistFocusEnable(i), callbackWithNoParam);
    }

    public void getRecordingSettings(CallbackWithOneParam<CameraAllSettings.RecordingSettings> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetRecordingSettings, CameraAllSettings.RecordingSettings.class, callbackWithOneParam);
    }

    public void getVideoSourceConfiguration(CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetVideoSourceConfiguration, CameraAllSettings.VideoSourceConfiguration.class, callbackWithOneParam);
    }

    public void getVideoSourceConfigurationOptions(CallbackWithOneParam<CameraAllSettings.VideoSourceConfigurationOptions> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetVideoSourceConfigurationOptions, CameraAllSettings.VideoSourceConfigurationOptions.class, callbackWithOneParam);
    }

    public void getVideoEncoderConfiguration(int i, CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetVideoEncoderConfiguration, new StreamInfo(i), CameraAllSettings.VideoEncoderConfiguration.class, callbackWithOneParam);
    }

    public void getCameraFocus(CallbackWithOneParam<CameraAllSettings.Focus> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetFocus, CameraAllSettings.Focus.class, callbackWithOneParam);
    }

    public void getSpotMeteringArea(CallbackWithOneParam<CameraAllSettings.LocationMeter> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetLocationMeter, CameraAllSettings.LocationMeter.class, callbackWithOneParam);
    }

    public void getPictureInVideoStatus(CallbackWithOneParam<CameraAllSettings.PictureInVideoStatus> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetPictureInVideoStatus, CameraAllSettings.PictureInVideoStatus.class, callbackWithOneParam);
    }

    public void getCameraMode(CallbackWithOneParam<CameraAllSettings.CameraMode> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetCameraMode, CameraAllSettings.CameraMode.class, callbackWithOneParam);
    }

    public void getCameraAutoExposureState(CallbackWithOneParam<CameraAllSettings.AELock> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetAELock, CameraAllSettings.AELock.class, callbackWithOneParam);
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.LocationMeter locationMeter = new CameraAllSettings.LocationMeter();
        locationMeter.setX(i);
        locationMeter.setY(i2);
        request(CameraParamsConfig.method_SetLocationMeter, locationMeter, callbackWithNoParam);
    }

    /* renamed from: com.autel.camera.protocol.protocol20.request.CameraHttpRequest$4 */
    /* synthetic */ class C23874 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$media$AutoExposureLockState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.autel.common.camera.media.AutoExposureLockState[] r0 = com.autel.common.camera.media.AutoExposureLockState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$media$AutoExposureLockState = r0
                com.autel.common.camera.media.AutoExposureLockState r1 = com.autel.common.camera.media.AutoExposureLockState.LOCK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$camera$media$AutoExposureLockState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.media.AutoExposureLockState r1 = com.autel.common.camera.media.AutoExposureLockState.UNLOCK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.camera.protocol.protocol20.request.CameraHttpRequest.C23874.<clinit>():void");
        }
    }

    public void setCameraAutoExposureState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        int i = 1;
        if (C23874.$SwitchMap$com$autel$common$camera$media$AutoExposureLockState[autoExposureLockState.ordinal()] != 1) {
            i = 0;
        }
        CameraAllSettings.AELock aELock = new CameraAllSettings.AELock();
        aELock.setLocked(i);
        request(CameraParamsConfig.method_SetAELock, aELock, callbackWithNoParam);
    }

    public void setCameraCustomPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.ImageStyle imageStyle = new CameraAllSettings.ImageStyle();
        imageStyle.setStyle(PhotoStyleType.Custom.value());
        imageStyle.setContrast(i);
        imageStyle.setSaturation(i2);
        imageStyle.setSharpness(i3);
        request(CameraParamsConfig.method_SetImageStyle, imageStyle, callbackWithNoParam);
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetImageStyle(photoStyleType.value()), callbackWithNoParam);
    }

    public void setFileNamingMode(String str, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetFileNamingMode(str), callbackWithNoParam);
    }

    public void setAudioSourceConfiguration(CameraAllSettings.AudioSourceConfiguration audioSourceConfiguration, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetAudioSourceConfiguration(audioSourceConfiguration), callbackWithNoParam);
    }

    public void setSingleModeSettings(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetSingleModeSettings(i, i2), callbackWithNoParam);
    }

    public void setLoopRecordSettings(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetLoopRecordSettings(i), callbackWithNoParam);
    }

    public void setTimelapseModeSettings(double d, int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetTimelapseModeSettings(d, i, i2, i3), callbackWithNoParam);
    }

    public void setTimelapseModeSettingsDuration(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetTimelapseModeSettingsDuration(i), callbackWithNoParam);
    }

    public void setTimelapseModeSettingsVideoFrameRate(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetTimelapseModeSettingsVideoFrameRate(i), callbackWithNoParam);
    }

    public void setTimelapseModeSettingsComposeVideo(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetTimelapseModeSettingsComposeVideo(i), callbackWithNoParam);
    }

    public void setVideoSourceConfiguration(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetVideoSourceConfiguration(i), callbackWithNoParam);
    }

    public void setWiFiConfiguration(String str, String str2, int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetWiFiConfiguration(str, str2, i, i2), callbackWithNoParam);
    }

    public void setVideoEncoderConfiguration(int i, CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetVideoEncoderConfigurationParams(i, videoEncoderConfiguration), callbackWithNoParam);
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetEnable3DNR(z ? 1 : 0), callbackWithNoParam);
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetAntiFlicker(antiFlicker.value20()), callbackWithNoParam);
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.CameraGear cameraGear = new CameraAllSettings.CameraGear();
        cameraGear.setGear(exposureMode.value20());
        request(CameraParamsConfig.method_SetCameraGear, cameraGear, callbackWithNoParam);
    }

    public void setPhotoBurstCount(int i, CallbackWithNoParam callbackWithNoParam) {
        if (checkCallBack(callbackWithNoParam)) {
            request(CameraHttpParamFactory.getInstance().buildSetBurstSetting(i), callbackWithNoParam);
        }
    }

    public void setPhotoTimelapseInterval(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetTimelapseModeSettingsInterval((double) i), callbackWithNoParam);
    }

    public void setDehazeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetDehazeEnable(z), callbackWithNoParam);
    }

    public void setDehazeStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetDehazeStrength(i), callbackWithNoParam);
    }

    public void getDehazeSetting(CallbackWithOneParam<DehazeSetting> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetDehazeSetting, DehazeSetting.class, callbackWithOneParam);
    }

    public void setImageRoiEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetImageRoiEnable(z), callbackWithNoParam);
    }

    public void setImageRoiStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetImageRoiStrength(i), callbackWithNoParam);
    }

    public void setImageRoiSettingParams(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetImageRoiSettingParams(i, i2), callbackWithNoParam);
    }

    public void getImageRoiSetting(CallbackWithOneParam<ImageRoiSetting> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetImageRoiSetting, ImageRoiSetting.class, callbackWithOneParam);
    }

    public void setPhotoAEBCount(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetBurstAEBSetting(i), callbackWithNoParam);
    }

    public void setAutoSnapshotEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetAutoSnapshot(z ? 1 : 0, -1), callbackWithNoParam);
    }

    public void setAutoSnapshotInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetAutoSnapshot(-1, videoSnapshotTimelapseInterval.value()), callbackWithNoParam);
    }

    public void setCurrentRealResolution(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        String videoResolutionAndFps2 = videoResolutionAndFps.toString();
        if (videoResolutionAndFps2.contains("*")) {
            videoResolutionAndFps2 = videoResolutionAndFps2.replace("*", "x");
        }
        request(CameraHttpParamFactory.getInstance().buildSetVideoResolution(1, videoResolutionAndFps2), callbackWithNoParam);
    }

    public void setTrackingGoalArea(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam) {
        if (trackingTarget != null) {
            request(CameraHttpParamFactory.getInstance().buildSetGoalArea(trackingTarget.xRatio, trackingTarget.yRatio, trackingTarget.widthRatio, trackingTarget.heightRatio, 1), callbackWithNoParam);
        }
    }

    public void stopTracking(CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildStopTrack(), callbackWithNoParam);
    }

    public void setTrackingMode(String str, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetTrackMode(str), callbackWithNoParam);
    }

    public void getTrackingMode(CallbackWithOneParam<TrackingStatus> callbackWithOneParam) {
        query("GetTrackStatus", TrackingStatus.class, callbackWithOneParam);
    }

    public void setShutterMode(ShutterMode shutterMode, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetShutter(shutterMode.getValue()), callbackWithNoParam);
    }

    public void setProduceParametersEnable(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildProduceParametersEnable(i), callbackWithNoParam);
    }

    public void getShutterMode(CallbackWithOneParam<ShutterInternal> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetShutter, ShutterInternal.class, callbackWithOneParam);
    }

    public void setAlbumSaveLocation(SaveLocation saveLocation, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetStorageType(saveLocation.getValue()), callbackWithNoParam);
    }

    public void getAlbumLocation(CallbackWithOneParam<CameraAllSettings.StorageType> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetStorageType, CameraAllSettings.StorageType.class, callbackWithOneParam);
    }

    public void getFMCStatus(CallbackWithOneParam<CameraAllSettings.MMCStatus> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetMMCStatus, CameraAllSettings.MMCStatus.class, callbackWithOneParam);
    }

    public void formatFMC(CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildStartFormatFlashMemoryCard(), callbackWithNoParam);
    }

    public void setDisplayMode(DisplayMode displayMode, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetDisplayMode(displayMode.value()), callbackWithNoParam);
    }

    public void getDisplayMode(CallbackWithOneParam<CameraAllSettings.DisplayMode> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetDisplayMode, CameraAllSettings.DisplayMode.class, callbackWithOneParam);
    }

    public void setIrColor(IrColor irColor, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrColor(irColor.value()), callbackWithNoParam);
    }

    public void getIrColor(CallbackWithOneParam<CameraAllSettings.IrColor> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetIrColor, CameraAllSettings.IrColor.class, callbackWithOneParam);
    }

    public void setIrPosition(IrPosition irPosition, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrPosition(irPosition), callbackWithNoParam);
    }

    public void getIrPosition(CallbackWithOneParam<CameraAllSettings.IrPosition> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetIrPosition, CameraAllSettings.IrPosition.class, callbackWithOneParam);
    }

    public void setHDREnable(HDRStatus hDRStatus, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetHDREnable(hDRStatus.value()), callbackWithNoParam);
    }

    public void getHDREnable(CallbackWithOneParam<CameraAllSettings.HDRSetting> callbackWithOneParam) {
        query(CameraParamsConfig.method_GetHDRSetting, CameraAllSettings.HDRSetting.class, callbackWithOneParam);
    }

    public void setIrFlushShutter(CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrFlushShutter(), callbackWithNoParam);
    }

    public void startMotionDelayShot(CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildStartMotionDelayShot(), callbackWithNoParam);
    }

    public void stopMotionDelayShot(CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildStopMotionDelayShot(), callbackWithNoParam);
    }

    public void pauseMotionDelayShot(CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildPauseMotionDelayShot(), callbackWithNoParam);
    }

    public void resumeMotionDelayShot(CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildResumeMotionDelayShot(), callbackWithNoParam);
    }

    public void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetMotionDelayShotInterval(i), callbackWithNoParam);
    }

    public void getMotionDelayShotInterval(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetMotionDelayShotInterval(), callbackWithOneParam);
    }

    public void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetMotionDelayShotDuration(i), callbackWithNoParam);
    }

    public void getMotionDelayShotDuration(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetMotionDelayShotDuration(), callbackWithOneParam);
    }

    public void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetMotionDelayShotKeepPhoto(rawFormat), callbackWithNoParam);
    }

    public void getMotionDelayShotKeepPhoto(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetMotionDelayShotKeepPhoto(), callbackWithOneParam);
    }

    public void setIrTemperatureParams(IrTemperatureParams irTemperatureParams, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrTemperatureParams(irTemperatureParams), callbackWithNoParam);
    }

    public void getIrTemperatureParams(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetIrTemperatureParams(), callbackWithOneParam);
    }

    public void setIrTemperatureWarningParams(IrTemperatureWarnParams irTemperatureWarnParams, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrTemperatureWarningParams(irTemperatureWarnParams), callbackWithNoParam);
    }

    public void getIrTemperatureWarningParams(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetIrTemperatureWarningParams(), callbackWithOneParam);
    }

    public void getIrTemperatureEmit(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetIrTemperatureEmit(), callbackWithOneParam);
    }

    public void setIrTemperatureEmit(int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrTemperatureEmit(i), callbackWithNoParam);
    }

    public void setISOMode(ISOMode iSOMode, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetISOMode(iSOMode), callbackWithNoParam);
    }

    public void getISOMode(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetISOMode(), callbackWithOneParam);
    }

    public void setIrImageMode(ImageMode imageMode, int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrImageModeParams(imageMode, i, i2), callbackWithNoParam);
    }

    public void getIrImageMode(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetIrImageModeParams(), callbackWithOneParam);
    }

    public void setIrEnhance(boolean z, int i, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrEnhance(z, i), callbackWithNoParam);
    }

    public void getIrEnhance(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetIrEnhance(), callbackWithOneParam);
    }

    public void setIrDeNoise(boolean z, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrDeNoise(z), callbackWithNoParam);
    }

    public void getIrDeNoise(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetIrDeNoise(), callbackWithOneParam);
    }

    public void setIrGain(IrGainMode irGainMode, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIrGain(irGainMode.getValue()), callbackWithNoParam);
    }

    public void getIrGain(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetIrGain(), callbackWithOneParam);
    }

    public void setIrIsoTherm(IrIsoThermMode irIsoThermMode, int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        request(CameraHttpParamFactory.getInstance().buildSetIsoTherm(irIsoThermMode.getValue(), i, i2), callbackWithNoParam);
    }

    public void getIrIsoTherm(CallbackWithOneParam<BaseCameraMsgParser> callbackWithOneParam) {
        request(CameraHttpParamFactory.getInstance().buildGetIsoTherm(), callbackWithOneParam);
    }
}
