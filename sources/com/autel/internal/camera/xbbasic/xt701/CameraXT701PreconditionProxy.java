package com.autel.internal.camera.xbbasic.xt701;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.RangePair;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.XT701.XT701CameraInfo;
import com.autel.common.camera.XT701.XT701ParameterRangeManager;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.MMCState;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MotionDelayShot;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.SettingEvent;
import com.autel.common.camera.base.WorkState;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.DeFogParam;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.FlashCardStatus;
import com.autel.common.camera.media.ImageRoiParam;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.LensFocusStatus;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.SaveLocation;
import com.autel.common.camera.media.ShutterMode;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SkylinePositionData;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.xb015.PIVMode;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.BaseCamera20PreconditionProxy;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.camera.util.ResolutionFpsSupportUtil;
import com.autel.sdk.camera.p005rx.RxAutelXT701;
import java.util.List;

public class CameraXT701PreconditionProxy extends BaseCamera20PreconditionProxy implements CameraXT701Service {
    private CameraXT701Service cameraXt701Service;

    public void connect() {
    }

    public void disconnect() {
    }

    public RxAutelXT701 toRx() {
        return null;
    }

    public CameraXT701PreconditionProxy(CameraXT701Service cameraXT701Service) {
        super(cameraXT701Service);
        this.cameraXt701Service = cameraXT701Service;
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.cameraXt701Service.setAutoFocusStateListener(callbackWithTwoParams);
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.cameraXt701Service.setHistogramListener(callbackWithOneParam);
    }

    public void setFocusMode(LensFocusMode lensFocusMode, CallbackWithNoParam callbackWithNoParam) {
        if (lensFocusMode != null) {
            this.cameraXt701Service.setFocusMode(lensFocusMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void getFocusMode(CallbackWithOneParam<LensFocusMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getFocusMode(callbackWithOneParam);
        }
    }

    public void getFocusAFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.cameraXt701Service.getFocusAFSpotArea(callbackWithOneParam);
    }

    public void getFocusDistance(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getFocusDistance(callbackWithOneParam);
        }
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        RangePair<Integer> digitalZoomScale = getParameterRangeManager().getDigitalZoomScale();
        if (i >= digitalZoomScale.getValueFrom().intValue() && i <= digitalZoomScale.getValueTo().intValue()) {
            this.cameraXt701Service.setDigitalZoomScale(i, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
        }
    }

    public void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setPhotoAutoFocusMeter(i, i2, callbackWithNoParam);
        if (CameraXB015Data.instance().isImageRoiStatus()) {
            this.cameraXt701Service.setImageRoiArea(i, i2, callbackWithNoParam);
        }
    }

    public void setFocusDistance(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setFocusDistance(i, callbackWithNoParam);
    }

    public void startTakePhoto(CallbackWithNoParam callbackWithNoParam) {
        SDCardState find = SDCardState.find(getSdCardStatus());
        boolean z = true;
        if (CameraXB015Data.instance().getStorageType() != 1) {
            z = false;
        }
        FlashCardStatus flashCardStatus = CameraXB015Data.instance().getFlashCardStatus();
        if (z) {
            if (flashCardStatus.getFlashCardStatus() != MMCState.CARD_READY) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(flashCardStatus.getFlashCardStatus().getError());
                    return;
                }
                return;
            }
        } else if (!(find == SDCardState.CARD_READY || find == SDCardState.LOW_SPEED_CARD)) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(find.getError());
                return;
            }
            return;
        }
        WorkState find2 = WorkState.find(getWorkStatus());
        MediaMode find3 = MediaMode.find(getCameraMode());
        if (MediaMode.BURST == find3 || MediaMode.AEB == find3 || MediaMode.SINGLE == find3 || MediaMode.TIMELAPSE == find3 || MediaMode.HDR == find3 || MediaMode.MFNR == find3) {
            if (WorkState.IDLE != find2) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ON_IDLE_STATE);
                    return;
                }
                return;
            }
        } else if (MediaMode.VIDEO == find3) {
            VideoEncodeFormat find4 = VideoEncodeFormat.find(CameraXB015Data.instance().getVideoMainEncoding());
            VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
            if (videoMainResolutionAndFps.resolution == VideoResolution.Resolution_4096x2160 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_60ps && find4 == VideoEncodeFormat.H265) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ALLOWED_IN_4KP_60FPS_H265);
                return;
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NEED_NOT_ON_UNKNOWN_MODE);
            return;
        } else {
            return;
        }
        this.cameraXt701Service.startTakePhoto(callbackWithNoParam);
    }

    public void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        SDCardState find = SDCardState.find(getSdCardStatus());
        boolean z = true;
        if (CameraXB015Data.instance().getStorageType() != 1) {
            z = false;
        }
        FlashCardStatus flashCardStatus = CameraXB015Data.instance().getFlashCardStatus();
        if (z) {
            if (flashCardStatus.getFlashCardStatus() != MMCState.CARD_READY) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(flashCardStatus.getFlashCardStatus().getError());
                    return;
                }
                return;
            }
        } else if (!(find == SDCardState.CARD_READY || find == SDCardState.LOW_SPEED_CARD)) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(find.getError());
                return;
            }
            return;
        }
        WorkState find2 = WorkState.find(getWorkStatus());
        MediaMode find3 = MediaMode.find(getCameraMode());
        if (MediaMode.BURST == find3 || MediaMode.AEB == find3 || MediaMode.SINGLE == find3 || MediaMode.TIMELAPSE == find3) {
            if (WorkState.IDLE != find2) {
                if (callbackWithNoParam != null) {
                    callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ON_IDLE_STATE);
                    return;
                }
                return;
            }
        } else if (MediaMode.VIDEO == find3) {
            VideoEncodeFormat find4 = VideoEncodeFormat.find(CameraXB015Data.instance().getVideoMainEncoding());
            VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
            if (videoMainResolutionAndFps.resolution == VideoResolution.Resolution_4096x2160 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_60ps && find4 == VideoEncodeFormat.H265) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ALLOWED_IN_4KP_60FPS_H265);
                return;
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NEED_NOT_ON_UNKNOWN_MODE);
            return;
        } else {
            return;
        }
        this.cameraXt701Service.startTakePhotoWithFocus(callbackWithNoParam);
    }

    public void startRecordVideo(CallbackWithNoParam callbackWithNoParam) {
        if (MediaMode.VIDEO == MediaMode.find(getCameraMode())) {
            if (WorkState.IDLE == WorkState.find(getWorkStatus())) {
                SDCardState find = SDCardState.find(getSdCardStatus());
                boolean z = true;
                if (CameraXB015Data.instance().getStorageType() != 1) {
                    z = false;
                }
                FlashCardStatus flashCardStatus = CameraXB015Data.instance().getFlashCardStatus();
                if (z) {
                    if (flashCardStatus.getFlashCardStatus() != MMCState.CARD_READY) {
                        if (callbackWithNoParam != null) {
                            callbackWithNoParam.onFailure(flashCardStatus.getFlashCardStatus().getError());
                            return;
                        }
                        return;
                    }
                } else if (!(find == SDCardState.CARD_READY || find == SDCardState.LOW_SPEED_CARD)) {
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(find.getError());
                        return;
                    }
                    return;
                }
                this.cameraXt701Service.startRecordVideo(callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_START_RECORD_NOT_ON_IDLE_STATE);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_START_RECORD_NOT_ON_VIDEO_MODE);
        }
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        if (exposureMode != null) {
            this.cameraXt701Service.setExposureMode(exposureMode, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        XT701ParameterRangeManager parameterRangeManager = getParameterRangeManager();
        RangePair<Integer> spotMeteringAreaNoX = parameterRangeManager.getSpotMeteringAreaNoX();
        RangePair<Integer> spotMeteringAreaNoY = parameterRangeManager.getSpotMeteringAreaNoY();
        if (i >= spotMeteringAreaNoX.getValueFrom().intValue() && i <= spotMeteringAreaNoX.getValueTo().intValue() && i2 >= spotMeteringAreaNoY.getValueFrom().intValue() && i2 <= spotMeteringAreaNoY.getValueTo().intValue()) {
            this.cameraXt701Service.setSpotMeteringArea(i, i2, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
        }
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        if (autoExposureLockState == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (AutoExposureLockState.LOCK == autoExposureLockState || AutoExposureLockState.UNLOCK == autoExposureLockState) {
            this.cameraXt701Service.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_SET_AE_LOCK_STATE_WITH_BAD_PARAMS);
        }
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        if (exposureCompensation != null) {
            this.cameraXt701Service.setExposure(exposureCompensation, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        if (cameraISO != null) {
            this.cameraXt701Service.setISO(cameraISO, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        if (shutterSpeed == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (ShutterSpeed.UNKNOWN != shutterSpeed) {
            ExposureMode find = ExposureMode.find(CameraXB015Data.instance().getCameraGear());
            if (find != ExposureMode.Manual && find != ExposureMode.ShutterPriority && callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.CAMERA_SET_SHUTTER_NOT_ON_MANUAL_MODE);
            } else if (getParameterRangeManager().getCameraShutterSpeed().contains(shutterSpeed) || callbackWithNoParam == null) {
                this.cameraXt701Service.setShutter(shutterSpeed, callbackWithNoParam);
            } else {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_INVALID);
        }
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        if (whiteBalance != null) {
            if (whiteBalance.type == WhiteBalanceType.CUSTOM) {
                RangePair<Integer> colorTemperature = getParameterRangeManager().getColorTemperature();
                if (whiteBalance.colorTemperature < colorTemperature.getValueFrom().intValue() || whiteBalance.colorTemperature > colorTemperature.getValueTo().intValue()) {
                    if (callbackWithNoParam != null) {
                        callbackWithNoParam.onFailure(AutelError.CAMERA_COLOR_TEMPERATURE_RANGE_OUT);
                        return;
                    }
                    return;
                }
            }
            this.cameraXt701Service.setWhiteBalance(whiteBalance, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        if (colorStyle != null) {
            this.cameraXt701Service.setColorStyle(colorStyle, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.set3DNoiseReductionEnable(z, callbackWithNoParam);
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        if (antiFlicker != null) {
            ExposureMode find = ExposureMode.find(CameraXB015Data.instance().getCameraGear());
            if (find == ExposureMode.Auto || find == ExposureMode.AperturePriority) {
                if (MediaMode.VIDEO == MediaMode.find(getCameraMode())) {
                    VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
                    if (!(videoMainResolutionAndFps.fps == null || videoMainResolutionAndFps.fps.fps() <= 100 || antiFlicker == AntiFlicker.ANTI_FLICKER_60HZ)) {
                        if (callbackWithNoParam != null) {
                            callbackWithNoParam.onFailure(AutelError.CAMERA_ANTI_FLICKER_ONLY_60Hz_FOR_VIDEO_FPS_OVER_100);
                            return;
                        }
                        return;
                    }
                }
                this.cameraXt701Service.setAntiFlicker(antiFlicker, callbackWithNoParam);
            } else if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
            }
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getAutoExposureLockState(callbackWithOneParam);
        }
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getSpotMeteringArea(callbackWithOneParam);
        }
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getAntiFlicker(callbackWithOneParam);
        }
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getWhiteBalance(callbackWithOneParam);
        }
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getExposure(callbackWithOneParam);
        }
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getShutter(callbackWithOneParam);
        }
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getISO(callbackWithOneParam);
        }
    }

    public void isHistogramStatusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXt701Service.isHistogramStatusEnable(callbackWithOneParam);
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getColorStyle(callbackWithOneParam);
        }
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getExposureMode(callbackWithOneParam);
        }
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        if (photoStyleType == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (PhotoStyleType.Custom != photoStyleType) {
            this.cameraXt701Service.setPhotoStyle(photoStyleType, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_SET_CUSTOM_PHOTO_STYLE_NOT_MATCH_METHOD);
        }
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        if (i >= -3 && i <= 3 && i2 >= -3 && i2 <= 3 && i3 >= -3 && i3 <= 3) {
            this.cameraXt701Service.setPhotoStyle(i, i2, i3, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_OUT_OF_RANGE);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setVideoSubtitleEnable(z, callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        if (photoBurstCount != null) {
            this.cameraXt701Service.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        if (photoTimelapseInterval != null) {
            this.cameraXt701Service.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        if (photoAEBCount != null) {
            this.cameraXt701Service.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXt701Service.isSubtitleEnable(callbackWithOneParam);
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getPhotoBurstCount(callbackWithOneParam);
        }
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getPhotoTimelapseInterval(callbackWithOneParam);
        }
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getPhotoAEBCount(callbackWithOneParam);
        }
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getPhotoStyle(callbackWithOneParam);
        }
    }

    public void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam) {
        if (photoAspectRatio != null) {
            this.cameraXt701Service.setAspectRatio(photoAspectRatio, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (photoFormat != null) {
            this.cameraXt701Service.setPhotoFormat(photoFormat, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        if (videoResolutionAndFps == null) {
            if (callbackWithNoParam != null) {
                callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
            }
        } else if (ResolutionFpsSupportUtil.isSupport(CameraProduct.XT701, videoResolutionAndFps.resolution, videoResolutionAndFps.fps)) {
            this.cameraXt701Service.setVideoResolutionAndFrameRate(videoResolutionAndFps, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.RESOLUTION_OR_FPS_IS_NOT_MATCH);
        }
    }

    public void setVideoEncoder(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        if (videoEncodeFormat != null) {
            this.cameraXt701Service.setVideoEncoder(videoEncodeFormat, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void getVideoEncoderConfiguration(CallbackWithOneParam<VideoEncoderConfiguration> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getVideoEncoderConfiguration(callbackWithOneParam);
        }
    }

    public void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setVideoRotation(videoRotation, callbackWithNoParam);
    }

    public void getVideoRotation(CallbackWithOneParam<VideoRotation> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getVideoRotation(callbackWithOneParam);
        }
    }

    public void setShutterMode(ShutterMode shutterMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setShutterMode(shutterMode, callbackWithNoParam);
    }

    public void getShutterMode(CallbackWithOneParam<ShutterMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getShutterMode(callbackWithOneParam);
        }
    }

    public void setAFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setAFAssistFocusEnable(z, callbackWithNoParam);
    }

    public void getAFAssistFocusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXt701Service.getAFAssistFocusEnable(callbackWithOneParam);
    }

    public void setMFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setMFAssistFocusEnable(z, callbackWithNoParam);
    }

    public void getMFAssistFocusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXt701Service.getMFAssistFocusEnable(callbackWithOneParam);
    }

    public void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setPIVMode(pIVMode, callbackWithNoParam);
    }

    public void getPIVMode(CallbackWithOneParam<PIVMode> callbackWithOneParam) {
        this.cameraXt701Service.getPIVMode(callbackWithOneParam);
    }

    public void setAutoPIVTimelapseInterval(VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, callbackWithNoParam);
    }

    public void switchToPreviousPhotoMode(CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.cameraXt701Service.switchToPreviousPhotoMode(callbackWithOneParam);
    }

    public void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setTrackingModeEnable(z, callbackWithNoParam);
    }

    public void getSkylinePositionData(int i, int i2, CallbackWithOneParam<SkylinePositionData> callbackWithOneParam) {
        this.cameraXt701Service.getSkylinePositionData(i, i2, callbackWithOneParam);
    }

    public void setVideoEncodeFormat(VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setVideoEncodeFormat(videoEncodeFormat, callbackWithNoParam);
    }

    public void getVideoEncodeFormat(CallbackWithOneParam<VideoEncodeFormat> callbackWithOneParam) {
        this.cameraXt701Service.getVideoEncodeFormat(callbackWithOneParam);
    }

    public void setAlbumSaveLocation(SaveLocation saveLocation, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setAlbumSaveLocation(saveLocation, callbackWithNoParam);
    }

    public void getAlbumLocation(CallbackWithOneParam<SaveLocation> callbackWithOneParam) {
        this.cameraXt701Service.getAlbumLocation(callbackWithOneParam);
    }

    public void getFMCStatus(CallbackWithOneParam<FlashCardStatus> callbackWithOneParam) {
        this.cameraXt701Service.getFMCStatus(callbackWithOneParam);
    }

    public void formatFlashMemoryCard(CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.formatFlashMemoryCard(callbackWithNoParam);
    }

    public void setHDREnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        VideoEncodeFormat find = VideoEncodeFormat.find(CameraXB015Data.instance().getVideoMainEncoding());
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        if (videoMainResolutionAndFps.resolution == VideoResolution.Resolution_4096x2160 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_60ps && find == VideoEncodeFormat.H265) {
            callbackWithNoParam.onFailure(AutelError.CAMERA_TAKEN_PHOTO_NOT_ALLOWED_IN_4KP_60FPS_H265);
            return;
        }
        PhotoAspectRatio find2 = PhotoAspectRatio.find(CameraXB015Data.instance().getPicResolution());
        MediaMode find3 = MediaMode.find(getCameraMode());
        if (MediaMode.SINGLE == find3 && find2 == PhotoAspectRatio.Aspect_16_9_HDR) {
            this.cameraXt701Service.setHDREnable(z, callbackWithNoParam);
        } else if (MediaMode.VIDEO == find3 && ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_3840x2160 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_30ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_3840x2160 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_25ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_2720x1528 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_30ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_2720x1528 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_60ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_2720x1528 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_50ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_2720x1528 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_48ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_3840x2160 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_24ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_2720x1528 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_25ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_2720x1528 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_24ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_1920x1080 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_60ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_1920x1080 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_50ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_1920x1080 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_48ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_1920x1080 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_30ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_1920x1080 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_25ps) || ((videoMainResolutionAndFps.resolution == VideoResolution.Resolution_1920x1080 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_24ps) || (videoMainResolutionAndFps.resolution == VideoResolution.Resolution_1280x720 && videoMainResolutionAndFps.fps == VideoFps.FrameRate_120ps))))))))))))))))) {
            this.cameraXt701Service.setHDREnable(z, callbackWithNoParam);
        } else {
            callbackWithNoParam.onFailure(AutelError.CAMERA_THE_RESOLUTION_OR_FRAME_IS_NOT_SUPPORT);
        }
    }

    public void getHDREnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXt701Service.getHDREnable(callbackWithOneParam);
    }

    public void setDeFogEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setDeFogEnable(z, callbackWithNoParam);
    }

    public void setDeFogStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setDeFogStrength(i, callbackWithNoParam);
    }

    public void getDeFogParams(CallbackWithOneParam<DeFogParam> callbackWithOneParam) {
        this.cameraXt701Service.getDeFogParams(callbackWithOneParam);
    }

    public void setImageRoiEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setImageRoiEnable(z, callbackWithNoParam);
    }

    public void setImageRoiStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setImageRoiStrength(i, callbackWithNoParam);
    }

    public void setImageRoiArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setImageRoiArea(i, i2, callbackWithNoParam);
    }

    public void getImageRoiParams(CallbackWithOneParam<ImageRoiParam> callbackWithOneParam) {
        this.cameraXt701Service.getImageRoiParams(callbackWithOneParam);
    }

    public void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setFocusMFSpotArea(i, i2, callbackWithNoParam);
    }

    public void getFocusMFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.cameraXt701Service.getFocusMFSpotArea(callbackWithOneParam);
    }

    public void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setMotionDelayShotInterval(i, callbackWithNoParam);
    }

    public void getMotionDelayShotInterval(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.cameraXt701Service.getMotionDelayShotInterval(callbackWithOneParam);
    }

    public void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setMotionDelayShotDuration(i, callbackWithNoParam);
    }

    public void getMotionDelayShotDuration(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.cameraXt701Service.getMotionDelayShotDuration(callbackWithOneParam);
    }

    public void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam) {
        this.cameraXt701Service.setMotionDelayShotKeepPhoto(rawFormat, callbackWithNoParam);
    }

    public void getMotionDelayShotKeepPhoto(CallbackWithOneParam<MotionPhotoInfo> callbackWithOneParam) {
        this.cameraXt701Service.getMotionDelayShotKeepPhoto(callbackWithOneParam);
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        if (videoFormat != null) {
            this.cameraXt701Service.setVideoFormat(videoFormat, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        if (videoStandard != null) {
            this.cameraXt701Service.setVideoStandard(videoStandard, callbackWithNoParam);
        } else if (callbackWithNoParam != null) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_PARAMS_ARE_NULL);
        }
    }

    public void getVideoSum(CallbackWithOneParam<VideoSum> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getVideoSum(callbackWithOneParam);
        }
    }

    public void getLeftPhotoSum(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getLeftPhotoSum(callbackWithOneParam);
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getCurrentRecordTime(callbackWithOneParam);
        }
    }

    public void getStateInfo(CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getStateInfo(callbackWithOneParam);
        }
    }

    public void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getVideoResolutionAndFrameRate(callbackWithOneParam);
        }
    }

    public void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getAspectRatio(callbackWithOneParam);
        }
    }

    public void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getVideoFormat(callbackWithOneParam);
        }
    }

    public void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getVideoStandard(callbackWithOneParam);
        }
    }

    public void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraXt701Service.getPhotoFormat(callbackWithOneParam);
        }
    }

    public void setFlashMemoryCardStateListener(CallbackWithOneParam<MMCState> callbackWithOneParam) {
        this.cameraXt701Service.setFlashMemoryCardStateListener(callbackWithOneParam);
    }

    public void setPhotoExposureListener(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXt701Service.setPhotoExposureListener(callbackWithOneParam);
    }

    public void setAFCenterListener(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraXt701Service.setAFCenterListener(callbackWithOneParam);
    }

    public void setMotionDelayShotListener(CallbackWithOneParam<MotionDelayShot> callbackWithOneParam) {
        this.cameraXt701Service.setMotionDelayShotListener(callbackWithOneParam);
    }

    public void setSettingChangedListener(CallbackWithOneParam<SettingEvent> callbackWithOneParam) {
        this.cameraXt701Service.setSettingChangedListener(callbackWithOneParam);
    }

    public void setInfoListener(CallbackWithOneParam<XT701CameraInfo> callbackWithOneParam) {
        this.cameraXt701Service.setInfoListener(callbackWithOneParam);
    }

    public XT701ParameterRangeManager getParameterRangeManager() {
        return this.cameraXt701Service.getParameterRangeManager();
    }
}
