package com.autel.internal.camera.xbbasic.xb015;

import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.bean.camera.FlirCameraAllSettings;
import com.autel.camera.hardware.BaseCameraAndGimbalHardware;
import com.autel.camera.hardware.CameraSkylineCalculator;
import com.autel.camera.hardware.XB015CameraAndGimbalHardware;
import com.autel.camera.protocol.protocol20.CameraManager;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.autel.camera.protocol.protocol20.entity.CameraAllSettingsWithParser;
import com.autel.camera.protocol.protocol20.interfaces.Xb015.CameraXb015;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.camera.protocol.protocol20.xb015.C2416Xb015;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.GimbalLockState;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.MeteringMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SkylinePositionData;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoBitrateType;
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoEncodeType;
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
import com.autel.common.camera.visual.TrackMode;
import com.autel.common.camera.xb015.PIVMode;
import com.autel.common.camera.xb015.RealTimeVideoResolution;
import com.autel.common.camera.xb015.XB015CameraInfo;
import com.autel.common.camera.xb015.XB015ParameterRangeManager;
import com.autel.common.camera.xb015.XB015StateInfo;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.BaseCamera20;
import com.autel.internal.camera.xbbasic.SkylinePositionDataImpl;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.model.CameraFlirData;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.camera.media.VideoSumImpl;
import com.autel.sdk.camera.p005rx.RxAutelXB015;

public class CameraXb015Impl extends BaseCamera20 implements CameraXb015Service {
    private static final String MediaInfoTag = "MediaInfo";
    /* access modifiers changed from: private */
    public CameraSkylineCalculator mCameraSkylineCalculator;
    protected CameraXb015 request = ((CameraXb015) CameraFactory.getCameraProduct(C2416Xb015.class));
    /* access modifiers changed from: private */
    public SkylinePositionDataImpl skylinePositionData;
    protected XB015ParameterRangeManager xb015ParameterRangeManager;

    public RxAutelXB015 toRx() {
        return null;
    }

    public void setInfoListener(final CallbackWithOneParam<XB015CameraInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            this.request.addCameraSystemStatusListener(MediaInfoTag, (CallbackWithOneParam<CameraSystemStatus>) null);
        } else {
            this.request.addCameraSystemStatusListener(MediaInfoTag, new CallbackWithOneParam<CameraSystemStatus>() {
                public void onSuccess(final CameraSystemStatus cameraSystemStatus) {
                    callbackWithOneParam.onSuccess(new XB015CameraInfo() {
                        public int getTemperature() {
                            return cameraSystemStatus.getTemperature();
                        }

                        public ExposureCompensation getExposureCompensation() {
                            return ExposureCompensation.find(String.valueOf(cameraSystemStatus.getExposureValue()));
                        }

                        public CameraISO getISO() {
                            return CameraISO.find(String.valueOf(cameraSystemStatus.getISOValue()));
                        }

                        public ShutterSpeed getShutterSpeed() {
                            return ShutterSpeed.find(cameraSystemStatus.getShutterSpeed());
                        }

                        public long getCurrentRecordTime() {
                            return cameraSystemStatus.getCurrentRecordTime();
                        }

                        public long getTotalTimeCanRecord() {
                            return cameraSystemStatus.getRemainRecordTime();
                        }

                        public int getPhotoSumCanTake() {
                            return cameraSystemStatus.getRemainCaptureNum();
                        }

                        public int getZoomScale() {
                            return cameraSystemStatus.getZoomValue();
                        }

                        public String toString() {
                            return "getTemperature : " + getTemperature() + ", getExposureCompensation : " + getExposureCompensation() + ", getISO : " + getISO() + ", getShutterSpeed : " + getShutterSpeed() + ", getCurrentRecordTime : " + getCurrentRecordTime() + ", getTotalTimeCanRecord : " + getTotalTimeCanRecord() + ", getPhotoSumCanTake : " + getPhotoSumCanTake();
                        }
                    });
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.request.setHistogramListener(callbackWithOneParam);
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setSpotMeteringArea(i, i2, callbackWithNoParam);
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposure(exposureCompensation, callbackWithNoParam);
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        this.request.setISO(cameraISO, callbackWithNoParam);
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        this.request.setShutter(shutterSpeed, callbackWithNoParam);
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        this.request.getColorStyle(callbackWithOneParam);
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        this.request.setWhiteBalance(whiteBalance, callbackWithNoParam);
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        this.request.setColorStyle(colorStyle, callbackWithNoParam);
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAntiFlicker(antiFlicker, callbackWithNoParam);
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        this.request.getAutoExposureLockState(callbackWithOneParam);
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.request.getSpotMeteringArea(callbackWithOneParam);
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        this.request.getAntiFlicker(callbackWithOneParam);
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        this.request.getWhiteBalance(callbackWithOneParam);
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        this.request.getExposure(callbackWithOneParam);
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        this.request.getShutter(callbackWithOneParam);
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        this.request.getISO(callbackWithOneParam);
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        this.request.getExposureMode(callbackWithOneParam);
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoStyle(photoStyleType, callbackWithNoParam);
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoStyle(i, i2, i3, callbackWithNoParam);
    }

    public void isHistogramEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.isHistogramStatusEnable(callbackWithOneParam);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoSubtitleEnable(z, callbackWithNoParam);
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.request.isSubtitleEnable(callbackWithOneParam);
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        this.request.getPhotoStyle(callbackWithOneParam);
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setDigitalZoomScale(i, callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        this.request.getPhotoAEBCount(callbackWithOneParam);
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        this.request.getPhotoBurstCount(callbackWithOneParam);
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        this.request.getPhotoTimelapseInterval(callbackWithOneParam);
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposureMode(exposureMode, callbackWithNoParam);
    }

    public void getVideoSum(final CallbackWithOneParam<VideoSum> callbackWithOneParam) {
        if (CameraModelDataManager.instance().getBaseCameraData() instanceof CameraFlirData) {
            this.request.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
                public void onSuccess(FlirCameraAllSettings.SDCardStatus sDCardStatus) {
                    VideoSumImpl videoSumImpl = new VideoSumImpl();
                    videoSumImpl.currentRecordingTime = sDCardStatus.getCurrentRecordTime();
                    videoSumImpl.leftTime = (long) sDCardStatus.getRemainRecordTime();
                    callbackWithOneParam.onSuccess(videoSumImpl);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            this.request.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
                public void onSuccess(CameraAllSettings.SDCardStatus sDCardStatus) {
                    VideoSumImpl videoSumImpl = new VideoSumImpl();
                    videoSumImpl.currentRecordingTime = sDCardStatus.getCurrentRecordTime();
                    videoSumImpl.leftTime = (long) sDCardStatus.getRemainRecordTime();
                    callbackWithOneParam.onSuccess(videoSumImpl);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getLeftPhotoSum(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (CameraModelDataManager.instance().getBaseCameraData() instanceof CameraFlirData) {
            this.request.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
                public void onSuccess(FlirCameraAllSettings.SDCardStatus sDCardStatus) {
                    callbackWithOneParam.onSuccess(Integer.valueOf(sDCardStatus.getRemainCaptureNum()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            this.request.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
                public void onSuccess(CameraAllSettings.SDCardStatus sDCardStatus) {
                    callbackWithOneParam.onSuccess(Integer.valueOf(sDCardStatus.getRemainCaptureNum()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getCurrentRecordTime(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (CameraModelDataManager.instance().getBaseCameraData() instanceof CameraFlirData) {
            this.request.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
                public void onSuccess(FlirCameraAllSettings.SDCardStatus sDCardStatus) {
                    callbackWithOneParam.onSuccess(Integer.valueOf((int) sDCardStatus.getCurrentRecordTime()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            this.request.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
                public void onSuccess(CameraAllSettings.SDCardStatus sDCardStatus) {
                    callbackWithOneParam.onSuccess(Integer.valueOf((int) sDCardStatus.getCurrentRecordTime()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getStateInfo(final CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (CameraManager.instance().isParameterValid()) {
            callbackWithOneParam.onSuccess(new XB015StateInfo() {
                public ColorStyle getColorStyle() {
                    return ColorStyle.find(CameraXB015Data.instance().getImageColor());
                }

                public WhiteBalance getWhiteBalance() {
                    WhiteBalance whiteBalance = new WhiteBalance();
                    whiteBalance.type = WhiteBalanceType.find(CameraXB015Data.instance().getWhiteBalanceMode());
                    whiteBalance.colorTemperature = CameraXB015Data.instance().getWBColorTemperature();
                    return whiteBalance;
                }

                public AutoExposureLockState getAutoExposureLockState() {
                    return CameraXB015Data.instance().getAeLocked() == 1 ? AutoExposureLockState.LOCK : AutoExposureLockState.UNLOCK;
                }

                public boolean isHistogramEnable() {
                    return CameraXB015Data.instance().getHistogramEnable() == 1;
                }

                public ExposureMode getExposureMode() {
                    return ExposureMode.find(CameraXB015Data.instance().getCameraGear());
                }

                public PhotoStyle getPhotoStyle() {
                    PhotoStyle photoStyle = new PhotoStyle();
                    photoStyle.contrast = CameraXB015Data.instance().getContrast();
                    photoStyle.brightness = CameraXB015Data.instance().getBrightness();
                    photoStyle.hue = CameraXB015Data.instance().getHue();
                    photoStyle.saturation = CameraXB015Data.instance().getSaturation();
                    photoStyle.sharpness = CameraXB015Data.instance().getSharpness();
                    photoStyle.type = PhotoStyleType.find(CameraXB015Data.instance().getStyle());
                    return photoStyle;
                }

                public boolean isSubtitleEnable() {
                    return CameraXB015Data.instance().getEnableSubtitle() == 1;
                }

                public AntiFlicker getAntiFlicker() {
                    return AntiFlicker.find(CameraXB015Data.instance().getAntiFlicker());
                }

                public MeteringMode getMeteringMode() {
                    return MeteringMode.UNKNOWN;
                }

                public VideoStandard getVideoStandard() {
                    return VideoStandard.find(CameraXB015Data.instance().getVideoStandard());
                }

                public VideoFormat getVideoFormat() {
                    return VideoFormat.find(CameraXB015Data.instance().getVideoFileFormat());
                }

                public PhotoAspectRatio getPhotoAspectRatio() {
                    return PhotoAspectRatio.find(CameraXB015Data.instance().getPicResolution(), CameraProduct.XB015);
                }

                public PhotoFormat getPhotoFormat() {
                    return PhotoFormat.find(CameraXB015Data.instance().getPicType());
                }

                public int getDigitalZoomScale() {
                    return CameraXB015Data.instance().getZoomValue();
                }

                public VideoResolutionAndFps getVideoResolutionAndFrameRate() {
                    VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
                    VideoFps videoFps = null;
                    videoResolutionAndFps.resolution = CameraXB015Data.instance().getVideoMainResolutionAndFps() == null ? null : CameraXB015Data.instance().getVideoMainResolutionAndFps().resolution;
                    if (CameraXB015Data.instance().getVideoMainResolutionAndFps() != null) {
                        videoFps = CameraXB015Data.instance().getVideoMainResolutionAndFps().fps;
                    }
                    videoResolutionAndFps.fps = videoFps;
                    return videoResolutionAndFps;
                }

                public PhotoBurstCount getBurstCount() {
                    return PhotoBurstCount.find(String.valueOf(CameraXB015Data.instance().getBurstNumPerSecond()));
                }

                public PhotoAEBCount getAEBCount() {
                    return PhotoAEBCount.find(String.valueOf(CameraXB015Data.instance().getAebNumPerSecond()));
                }

                public PhotoTimelapseInterval getTimelapseInterval() {
                    return PhotoTimelapseInterval.find(String.valueOf(CameraXB015Data.instance().getTimelapseInterval()));
                }

                public PIVMode getPIVMode() {
                    return CameraXB015Data.instance().getAutoSnapshotEnable() == 1 ? PIVMode.Auto : PIVMode.Manual;
                }

                public VideoSnapshotTimelapseInterval getAutoPIVTimelapseInterval() {
                    return VideoSnapshotTimelapseInterval.find(CameraXB015Data.instance().getAutoSnapshotInterval());
                }

                public VideoEncodeFormat getVideoEncodeFormat() {
                    if (CameraXB015Data.instance().getVideoEncoderConfiguration() == null || CameraXB015Data.instance().getVideoEncoderConfiguration().size() <= 0) {
                        return null;
                    }
                    return CameraXB015Data.instance().getVideoEncoderConfiguration().get(0).getEncoding();
                }

                public CameraProduct getType() {
                    return CameraProduct.XB015;
                }

                public WorkState getWorkState() {
                    WorkState find = WorkState.find(CameraXB015Data.instance().getSystemStatus());
                    return (!WorkState.RECORD.equals(find) || !CameraConstant20.TAKING_PHOTO.equals(CameraXB015Data.instance().getPivState())) ? find : WorkState.RECORD_PHOTO_TAKING;
                }

                public MediaMode getMediaMode() {
                    return MediaMode.find(CameraXB015Data.instance().getCurrentMode());
                }

                public SDCardState getSDCardState() {
                    return SDCardState.find(CameraXB015Data.instance().getCardStatus());
                }

                public GimbalLockState getGimbalLockState() {
                    return GimbalLockState.find(CameraXB015Data.instance().getGimbalLockState());
                }

                public String toString() {
                    return "getColorStyle : " + getColorStyle() + ", getWhiteBalance : " + getWhiteBalance() + ", getAutoExposureLockState : " + getAutoExposureLockState() + ", isHistogramEnable : " + isHistogramEnable() + ", getExposureMode : " + getExposureMode() + ", getPhotoStyle : " + getPhotoStyle() + ", isSubtitleEnable : " + isSubtitleEnable() + ", getAntiFlicker = " + getAntiFlicker() + ", getType : " + getType() + ", getWorkState : " + getWorkState() + ", getMediaMode : " + getMediaMode() + ", getVideoFormat = " + getVideoFormat() + ", getPhotoAspectRatio = " + getPhotoAspectRatio() + ", getPhotoFormat = " + getPhotoFormat() + ", getDigitalZoomScale = " + getDigitalZoomScale() + ", getVideoResolutionAndFrameRate = " + getVideoResolutionAndFrameRate() + ", getBurstCount = " + getBurstCount() + ", getAEBCount = " + getAEBCount() + ", getTimelapseInterval = " + getTimelapseInterval() + ", PIVMode = " + getPIVMode() + ", getPIVTimeLapse = " + getAutoPIVTimelapseInterval();
                }
            });
        } else {
            this.request.getCameraAllSetting(CameraAllSettings.class, new CallbackWithOneParam<CameraAllSettings>() {
                public void onSuccess(final CameraAllSettings cameraAllSettings) {
                    CameraAllSettingsWithParser.instance().updateCameraSetting(cameraAllSettings);
                    CameraManager.instance().setParameterValid(true);
                    callbackWithOneParam.onSuccess(new XB015StateInfo() {
                        public ColorStyle getColorStyle() {
                            return ColorStyle.find(cameraAllSettings.getImageColor().getColor());
                        }

                        public WhiteBalance getWhiteBalance() {
                            WhiteBalance whiteBalance = new WhiteBalance();
                            whiteBalance.type = WhiteBalanceType.find(cameraAllSettings.getWhiteBalance().getMode());
                            whiteBalance.colorTemperature = cameraAllSettings.getWhiteBalance().getColorTemperature();
                            return whiteBalance;
                        }

                        public AutoExposureLockState getAutoExposureLockState() {
                            return cameraAllSettings.getAELock().getLocked() == 1 ? AutoExposureLockState.LOCK : AutoExposureLockState.UNLOCK;
                        }

                        public boolean isHistogramEnable() {
                            return cameraAllSettings.getHistogramSettings().getEnable() == 1;
                        }

                        public ExposureMode getExposureMode() {
                            return ExposureMode.find(cameraAllSettings.getCameraGear().getGear());
                        }

                        public PhotoStyle getPhotoStyle() {
                            CameraAllSettings.ImageStyle imageStyle = cameraAllSettings.getImageStyle();
                            PhotoStyle photoStyle = new PhotoStyle();
                            photoStyle.contrast = imageStyle.getContrast();
                            photoStyle.brightness = imageStyle.getBrightness();
                            photoStyle.hue = imageStyle.getHue();
                            photoStyle.saturation = imageStyle.getSaturation();
                            photoStyle.sharpness = imageStyle.getSharpness();
                            photoStyle.type = PhotoStyleType.find(imageStyle.getStyle());
                            return photoStyle;
                        }

                        public boolean isSubtitleEnable() {
                            return cameraAllSettings.getRecordingSettings().getEnableSubtitle() == 1;
                        }

                        public AntiFlicker getAntiFlicker() {
                            return AntiFlicker.find(cameraAllSettings.getVideoSourceConfiguration().getAntiFlicker());
                        }

                        public MeteringMode getMeteringMode() {
                            return MeteringMode.find(cameraAllSettings.getFocus().getAFMeter() != null ? cameraAllSettings.getFocus().getAFMeter().getMode() : "");
                        }

                        public VideoStandard getVideoStandard() {
                            return VideoStandard.find(cameraAllSettings.getVideoSourceConfiguration().getVideoStandard());
                        }

                        public VideoFormat getVideoFormat() {
                            return VideoFormat.find(cameraAllSettings.getRecordingSettings().getFileFormat());
                        }

                        public PhotoAspectRatio getPhotoAspectRatio() {
                            return PhotoAspectRatio.find(cameraAllSettings.getPhotoTakingSettings().getResolution(), CameraProduct.XB015);
                        }

                        public PhotoFormat getPhotoFormat() {
                            return PhotoFormat.find(cameraAllSettings.getPhotoTakingSettings().getPicType());
                        }

                        public int getDigitalZoomScale() {
                            return cameraAllSettings.getZoomFactor().getZoomValue();
                        }

                        public VideoResolutionAndFps getVideoResolutionAndFrameRate() {
                            VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
                            String resolution = cameraAllSettings.getVideoEncoderConfiguration().get(0).getResolution();
                            int indexOf = resolution.indexOf("p");
                            String substring = resolution.substring(0, indexOf);
                            String substring2 = resolution.substring(indexOf);
                            videoResolutionAndFps.resolution = VideoResolution.find(substring);
                            videoResolutionAndFps.fps = VideoFps.find(substring2);
                            return videoResolutionAndFps;
                        }

                        public PhotoBurstCount getBurstCount() {
                            return PhotoBurstCount.find(String.valueOf(cameraAllSettings.getPhotoTakingSettings().getBurstModeSettings().getNumPhotosPerSecond()));
                        }

                        public PhotoAEBCount getAEBCount() {
                            return PhotoAEBCount.find(String.valueOf(cameraAllSettings.getPhotoTakingSettings().getAEBModeSettings().getNumPhotosAtOnce()));
                        }

                        public PhotoTimelapseInterval getTimelapseInterval() {
                            return PhotoTimelapseInterval.find(String.valueOf(cameraAllSettings.getPhotoTakingSettings().getTimelapseModeSettings().getInterval()));
                        }

                        public PIVMode getPIVMode() {
                            return cameraAllSettings.getRecordingSettings().getAutoSnapshot().getEnable() == 1 ? PIVMode.Auto : PIVMode.Manual;
                        }

                        public VideoSnapshotTimelapseInterval getAutoPIVTimelapseInterval() {
                            return VideoSnapshotTimelapseInterval.find(cameraAllSettings.getRecordingSettings().getAutoSnapshot().getInterval());
                        }

                        public VideoEncodeFormat getVideoEncodeFormat() {
                            if (cameraAllSettings.getVideoEncoderConfiguration() == null || cameraAllSettings.getVideoEncoderConfiguration().size() <= 0) {
                                return null;
                            }
                            return VideoEncodeFormat.find(cameraAllSettings.getVideoEncoderConfiguration().get(0).getEncoding());
                        }

                        public CameraProduct getType() {
                            return CameraProduct.XB015;
                        }

                        public WorkState getWorkState() {
                            WorkState find = WorkState.find(cameraAllSettings.getSystemStatus().getSystemStatus());
                            return (!WorkState.RECORD.equals(find) || !CameraConstant20.TAKING_PHOTO.equals(cameraAllSettings.getSystemStatus().getPivState())) ? find : WorkState.RECORD_PHOTO_TAKING;
                        }

                        public MediaMode getMediaMode() {
                            return MediaMode.find(cameraAllSettings.getSystemStatus().getCurrentMode());
                        }

                        public SDCardState getSDCardState() {
                            return SDCardState.find(cameraAllSettings.getSDCardStatus().getCardStatus());
                        }

                        public GimbalLockState getGimbalLockState() {
                            if (cameraAllSettings.getGimbalLockState() != null) {
                                return GimbalLockState.find(cameraAllSettings.getGimbalLockState().getLockState());
                            }
                            return GimbalLockState.UNLOCK;
                        }

                        public String toString() {
                            return "getColorStyle : " + getColorStyle() + ", getWhiteBalance : " + getWhiteBalance() + ", getAutoExposureLockState : " + getAutoExposureLockState() + ", isHistogramEnable : " + isHistogramEnable() + ", getExposureMode : " + getExposureMode() + ", getPhotoStyle : " + getPhotoStyle() + ", isSubtitleEnable : " + isSubtitleEnable() + ", getAntiFlicker = " + getAntiFlicker() + ", getType : " + getType() + ", getWorkState : " + getWorkState() + ", getMediaMode : " + getMediaMode() + ", getVideoFormat = " + getVideoFormat() + ", getPhotoAspectRatio = " + getPhotoAspectRatio() + ", getPhotoFormat = " + getPhotoFormat() + ", getDigitalZoomScale = " + getDigitalZoomScale() + ", getVideoResolutionAndFrameRate = " + getVideoResolutionAndFrameRate() + ", getBurstCount = " + getBurstCount() + ", getAEBCount = " + getAEBCount() + ", getTimelapseInterval = " + getTimelapseInterval() + ", PIVMode = " + getPIVMode() + ", getPIVTimeLapse = " + getAutoPIVTimelapseInterval();
                        }
                    });
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getVideoResolutionAndFrameRate(final CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getVideoEncoderConfiguration(0, new CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration>() {
                public void onSuccess(CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration) {
                    VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
                    String resolution = videoEncoderConfiguration.getResolution();
                    int indexOf = resolution.indexOf("p");
                    String substring = resolution.substring(0, indexOf);
                    String substring2 = resolution.substring(indexOf);
                    videoResolutionAndFps.resolution = VideoResolution.find(substring);
                    videoResolutionAndFps.fps = VideoFps.find(substring2);
                    callbackWithOneParam.onSuccess(videoResolutionAndFps);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setPhotoFormat(final PhotoFormat photoFormat, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setPicType(photoFormat.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setVideoResolutionAndFrameRate(final VideoResolutionAndFps videoResolutionAndFps, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setVideoMainResolutionAndFps(videoResolutionAndFps);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setVideoFormat(final VideoFormat videoFormat, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoFormat(videoFormat, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setVideoFileFormat(videoFormat.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setVideoStandard(final VideoStandard videoStandard, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoStandard(videoStandard, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setVideoStandard(videoStandard.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getAspectRatio(final CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
                public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                    callbackWithOneParam.onSuccess(PhotoAspectRatio.find(photoTakingSettings.getResolution(), CameraProduct.XB015));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setVideoEncodeFormat(final VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoEncoderConfiguration(0, new VideoEncoderConfiguration() {
            public int getBitrate() {
                return 0;
            }

            public VideoBitrateType getBitrateType() {
                return null;
            }

            public VideoEncodeType getEncodeType() {
                return null;
            }

            public int getIntervalOfIFrame() {
                return 0;
            }

            public int getQuality() {
                return 0;
            }

            public VideoResolutionAndFps getVideoResolutionAndFps() {
                return null;
            }

            public VideoEncodeFormat getEncoding() {
                return videoEncodeFormat;
            }
        }, callbackWithNoParam);
    }

    public void getVideoEncodeFormat(final CallbackWithOneParam<VideoEncodeFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getVideoEncoderConfiguration(0, new CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration>() {
                public void onSuccess(CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration) {
                    callbackWithOneParam.onSuccess(VideoEncodeFormat.find(videoEncoderConfiguration.getEncoding()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setVideoRotation(final VideoRotation videoRotation, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoRotation(videoRotation, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setVideoRotation(videoRotation.getValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getVideoRotation(final CallbackWithOneParam<VideoRotation> callbackWithOneParam) {
        this.request.getVideoSourceConfiguration(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
            public void onSuccess(CameraAllSettings.VideoSourceConfiguration videoSourceConfiguration) {
                callbackWithOneParam.onSuccess(VideoRotation.find(videoSourceConfiguration.getRotation()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getRealTimeVideoResolution(final CallbackWithOneParam<RealTimeVideoResolution> callbackWithOneParam) {
        this.request.getVideoEncoderConfiguration(1, new CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration>() {
            public void onSuccess(CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration) {
                String resolution = videoEncoderConfiguration.getResolution();
                if (resolution == null) {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                } else if (resolution.contains("1080")) {
                    callbackWithOneParam.onSuccess(RealTimeVideoResolution.P_1920X1080);
                } else if (resolution.contains("720")) {
                    callbackWithOneParam.onSuccess(RealTimeVideoResolution.P_1280X720);
                } else {
                    callbackWithOneParam.onSuccess(RealTimeVideoResolution.UNKNOWN);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    /* renamed from: com.autel.internal.camera.xbbasic.xb015.CameraXb015Impl$32 */
    /* synthetic */ class C301932 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$xb015$RealTimeVideoResolution;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.autel.common.camera.xb015.RealTimeVideoResolution[] r0 = com.autel.common.camera.xb015.RealTimeVideoResolution.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$xb015$RealTimeVideoResolution = r0
                com.autel.common.camera.xb015.RealTimeVideoResolution r1 = com.autel.common.camera.xb015.RealTimeVideoResolution.P_1280X720     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$autel$common$camera$xb015$RealTimeVideoResolution     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.xb015.RealTimeVideoResolution r1 = com.autel.common.camera.xb015.RealTimeVideoResolution.P_1920X1080     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.camera.xbbasic.xb015.CameraXb015Impl.C301932.<clinit>():void");
        }
    }

    public void setRealTimeVideoResolution(RealTimeVideoResolution realTimeVideoResolution, CallbackWithNoParam callbackWithNoParam) {
        VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
        int i = C301932.$SwitchMap$com$autel$common$camera$xb015$RealTimeVideoResolution[realTimeVideoResolution.ordinal()];
        if (i == 1) {
            videoResolutionAndFps.resolution = VideoResolution.Resolution_1280x720;
        } else if (i == 2) {
            videoResolutionAndFps.resolution = VideoResolution.Resolution_1920x1080;
        }
        videoResolutionAndFps.fps = VideoFps.FrameRate_24ps;
        this.request.setCurrentRealResolution(videoResolutionAndFps, callbackWithNoParam);
    }

    public void setPIVMode(final PIVMode pIVMode, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoSnapshotEnable(pIVMode == PIVMode.Auto, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAutoSnapshotEnable(pIVMode == PIVMode.Auto ? 1 : 0);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getPIVMode(final CallbackWithOneParam<PIVMode> callbackWithOneParam) {
        this.request.getRecordingSettings(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
            public void onSuccess(CameraAllSettings.RecordingSettings recordingSettings) {
                CameraAllSettings.RecordingSettings.AutoSnapshot autoSnapshot = recordingSettings.getAutoSnapshot();
                if (autoSnapshot == null) {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    return;
                }
                CameraXB015Data.instance().setAutoSnapshotEnable(recordingSettings.getAutoSnapshot().getEnable());
                CameraXB015Data.instance().setAutoSnapshotInterval(recordingSettings.getAutoSnapshot().getInterval());
                callbackWithOneParam.onSuccess(autoSnapshot.getEnable() == 1 ? PIVMode.Auto : PIVMode.Manual);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setAutoPIVTimelapseInterval(final VideoSnapshotTimelapseInterval videoSnapshotTimelapseInterval, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoSnapshotInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAutoSnapshotInterval(videoSnapshotTimelapseInterval.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getAutoPIVTimelapseInterval(final CallbackWithOneParam<VideoSnapshotTimelapseInterval> callbackWithOneParam) {
        this.request.getRecordingSettings(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
            public void onSuccess(CameraAllSettings.RecordingSettings recordingSettings) {
                CameraAllSettings.RecordingSettings.AutoSnapshot autoSnapshot = recordingSettings.getAutoSnapshot();
                if (autoSnapshot == null) {
                    callbackWithOneParam.onFailure(AutelError.COMMAND_FAILED);
                    return;
                }
                CameraXB015Data.instance().setAutoSnapshotInterval(autoSnapshot.getInterval());
                callbackWithOneParam.onSuccess(VideoSnapshotTimelapseInterval.find(autoSnapshot.getInterval()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void switchToPreviousPhotoMode(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        final MediaMode find = MediaMode.find(CameraXB015Data.instance().getPrevPhotoTakingMode());
        setMediaMode(find, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithOneParam.onSuccess(find);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVideoFormat(final CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getRecordingSettings(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
                public void onSuccess(CameraAllSettings.RecordingSettings recordingSettings) {
                    CameraXB015Data.instance().setVideoFileFormat(recordingSettings.getFileFormat());
                    callbackWithOneParam.onSuccess(VideoFormat.find(recordingSettings.getFileFormat()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getVideoStandard(final CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getVideoSourceConfiguration(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
                public void onSuccess(CameraAllSettings.VideoSourceConfiguration videoSourceConfiguration) {
                    CameraXB015Data.instance().setVideoStandard(videoSourceConfiguration.getVideoStandard());
                    callbackWithOneParam.onSuccess(VideoStandard.find(videoSourceConfiguration.getVideoStandard()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getPhotoFormat(final CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        this.request.getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                callbackWithOneParam.onSuccess(PhotoFormat.find(photoTakingSettings.getPicType()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setTrackingMode(z ? TrackMode.ENTER_TRACK : TrackMode.EXIT_TRACK, callbackWithNoParam);
    }

    public void getSkylinePositionData(final int i, final int i2, final CallbackWithOneParam<SkylinePositionData> callbackWithOneParam) {
        if (this.mCameraSkylineCalculator == null) {
            if (!(BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL instanceof XB015CameraAndGimbalHardware)) {
                BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL = new XB015CameraAndGimbalHardware();
            }
            this.mCameraSkylineCalculator = new CameraSkylineCalculator(BaseCameraAndGimbalHardware._BaseCameraAndGimbalHardwareIMPL);
            this.skylinePositionData = new SkylinePositionDataImpl();
        }
        VideoResolutionAndFps videoMainResolutionAndFps = CameraXB015Data.instance().getVideoMainResolutionAndFps();
        if (videoMainResolutionAndFps == null) {
            getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess(VideoResolutionAndFps videoResolutionAndFps) {
                    final VideoResolution videoResolution = videoResolutionAndFps.resolution;
                    if (MediaMode.find(CameraXB015Data.instance().getCameraMode()) == MediaMode.UNKNOWN) {
                        CameraXb015Impl.this.getMediaMode(new CallbackWithOneParam<MediaMode>() {
                            public void onFailure(AutelError autelError) {
                            }

                            public void onSuccess(MediaMode mediaMode) {
                                CameraXb015Impl.this.skylinePositionData.skylineYPosition = CameraXb015Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
                                CameraXb015Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXb015Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
                                callbackWithOneParam.onSuccess(CameraXb015Impl.this.skylinePositionData);
                            }
                        });
                        return;
                    }
                    CameraXb015Impl.this.skylinePositionData.skylineYPosition = CameraXb015Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
                    CameraXb015Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXb015Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
                    callbackWithOneParam.onSuccess(CameraXb015Impl.this.skylinePositionData);
                }
            });
            return;
        }
        final VideoResolution videoResolution = videoMainResolutionAndFps.resolution;
        if (MediaMode.find(CameraXB015Data.instance().getCameraMode()) == MediaMode.UNKNOWN) {
            final int i3 = i2;
            final int i4 = i;
            final CallbackWithOneParam<SkylinePositionData> callbackWithOneParam2 = callbackWithOneParam;
            getMediaMode(new CallbackWithOneParam<MediaMode>() {
                public void onFailure(AutelError autelError) {
                }

                public void onSuccess(MediaMode mediaMode) {
                    CameraXb015Impl.this.skylinePositionData.skylineYPosition = CameraXb015Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i3, i4);
                    CameraXb015Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXb015Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i4);
                    callbackWithOneParam2.onSuccess(CameraXb015Impl.this.skylinePositionData);
                }
            });
            return;
        }
        this.skylinePositionData.skylineYPosition = this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
        this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
        callbackWithOneParam.onSuccess(this.skylinePositionData);
    }

    public void setAspectRatio(final PhotoAspectRatio photoAspectRatio, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAspectRatio(photoAspectRatio.value(CameraProduct.XB015), new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setPicResolution(photoAspectRatio.value(CameraProduct.XB015));
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public XB015ParameterRangeManager getParameterRangeManager() {
        if (this.xb015ParameterRangeManager == null) {
            this.xb015ParameterRangeManager = new XB015ParameterRangeManagerImpl();
        }
        return this.xb015ParameterRangeManager;
    }
}
