package com.autel.internal.camera.xbbasic.xt701;

import android.util.Log;
import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.bean.camera.FlirCameraAllSettings;
import com.autel.camera.hardware.CameraSkylineCalculator;
import com.autel.camera.hardware.XB016CameraAndGimbalHardware;
import com.autel.camera.protocol.protocol20.CameraManager;
import com.autel.camera.protocol.protocol20.constant.CameraConstant20;
import com.autel.camera.protocol.protocol20.entity.CameraAllSettingsWithParser;
import com.autel.camera.protocol.protocol20.entity.CameraEvents;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.camera.protocol.protocol20.interfaces.CameraXT701;
import com.autel.camera.protocol.protocol20.request.BaseCameraRequest;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.camera.protocol.protocol20.xtbasic.C2630XT701;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.XT701.XT701CameraInfo;
import com.autel.common.camera.XT701.XT701ParameterRangeManager;
import com.autel.common.camera.XT701.XT701StateInfo;
import com.autel.common.camera.base.BaseStateInfo;
import com.autel.common.camera.base.GimbalLockState;
import com.autel.common.camera.base.MMCState;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MotionDelayShot;
import com.autel.common.camera.base.MotionDelayState;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.SettingEvent;
import com.autel.common.camera.base.WorkState;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.DeFogParam;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.FlashCardStatus;
import com.autel.common.camera.media.ImageRoiParam;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.LensFocusStatus;
import com.autel.common.camera.media.MeteringMode;
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
import com.autel.common.error.AutelError;
import com.autel.internal.AutelListenerManager;
import com.autel.internal.camera.BaseCamera20;
import com.autel.internal.camera.xbbasic.SkylinePositionDataImpl;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.model.CameraFlirData;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.camera.media.PhotoSumImpl;
import com.autel.internal.sdk.camera.media.VideoSumImpl;
import com.autel.sdk.camera.p005rx.RxAutelXT701;
import com.autel.util.log.AutelLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CameraXT701Impl extends BaseCamera20 implements CameraXT701Service {
    private static final String MediaInfoTag = "MediaInfo";
    protected XT701ParameterRangeManager XT701ParameterRangeManager;
    final AtomicBoolean hasCallback = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public CameraSkylineCalculator mCameraSkylineCalculator;
    protected CameraXT701 request = ((CameraXT701) CameraFactory.getCameraProduct(C2630XT701.class));
    /* access modifiers changed from: private */
    public volatile String sdCardStatus = MMCState.UNKNOWN.getValue();
    /* access modifiers changed from: private */
    public SkylinePositionDataImpl skylinePositionData;

    public RxAutelXT701 toRx() {
        return null;
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.request.setHistogramListener(callbackWithOneParam);
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.request.setAutoFocusStateListener(callbackWithTwoParams);
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

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.set3DNoiseReductionEnable(z, callbackWithNoParam);
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAntiFlicker(antiFlicker, callbackWithNoParam);
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        this.request.getAutoExposureLockState(callbackWithOneParam);
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (LensFocusMode.find(CameraXB015Data.instance().getFocusMode()) == LensFocusMode.MANUAL_FOCUS) {
            this.request.getFocusMFSpotArea(callbackWithOneParam);
        } else {
            this.request.getSpotMeteringArea(callbackWithOneParam);
        }
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

    public void isHistogramStatusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
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

    public void setFocusMode(LensFocusMode lensFocusMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFocusMode(lensFocusMode, callbackWithNoParam);
    }

    public void getFocusMode(CallbackWithOneParam<LensFocusMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getFocusMode(callbackWithOneParam);
        }
    }

    public void getFocusAFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getFocusAFSpotArea(callbackWithOneParam);
        }
    }

    public void getFocusDistance(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getFocusDistance(callbackWithOneParam);
        }
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setDigitalZoomScale(i, callbackWithNoParam);
    }

    public void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoAutoFocusMeter(i, i2, callbackWithNoParam);
    }

    public void setFocusDistance(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setManualFocusDistance(i, callbackWithNoParam);
    }

    public void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        this.request.startTakePhotoWithFocus(callbackWithNoParam);
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
        if (callbackWithOneParam != null) {
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
    }

    public void getLeftPhotoSum(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            if (CameraModelDataManager.instance().getBaseCameraData() instanceof CameraFlirData) {
                this.request.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
                    public void onSuccess(FlirCameraAllSettings.SDCardStatus sDCardStatus) {
                        PhotoSumImpl photoSumImpl = new PhotoSumImpl();
                        photoSumImpl.leftSum = sDCardStatus.getRemainCaptureNum();
                        callbackWithOneParam.onSuccess(Integer.valueOf(photoSumImpl.leftSum));
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                });
            } else {
                this.request.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
                    public void onSuccess(CameraAllSettings.SDCardStatus sDCardStatus) {
                        PhotoSumImpl photoSumImpl = new PhotoSumImpl();
                        photoSumImpl.leftSum = sDCardStatus.getRemainCaptureNum();
                        callbackWithOneParam.onSuccess(Integer.valueOf(photoSumImpl.leftSum));
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                });
            }
        }
    }

    public void getCurrentRecordTime(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
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
    }

    public void getStateInfo(final CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (CameraManager.instance().isParameterValid()) {
            AutelLog.debug_i("Camera", "getStateInfo- isParameterValid ---->>> true");
            callbackWithOneParam.onSuccess(new XT701StateInfo() {
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
                    return MeteringMode.find(CameraXB015Data.instance().getAFMode() != null ? CameraXB015Data.instance().getAFMode() : "");
                }

                public VideoFormat getVideoFormat() {
                    return VideoFormat.find(CameraXB015Data.instance().getVideoFileFormat());
                }

                public PhotoAspectRatio getPhotoAspectRatio() {
                    return PhotoAspectRatio.find(CameraXB015Data.instance().getPicResolution(), CameraProduct.XT701);
                }

                public PhotoFormat getPhotoFormat() {
                    return PhotoFormat.find(CameraXB015Data.instance().getPicType());
                }

                public int getDigitalZoomScale() {
                    return CameraXB015Data.instance().getZoomValue();
                }

                public VideoResolutionAndFps getVideoResolutionAndFrameRate() {
                    VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
                    videoResolutionAndFps.resolution = CameraXB015Data.instance().getVideoMainResolutionAndFps().resolution;
                    videoResolutionAndFps.fps = CameraXB015Data.instance().getVideoMainResolutionAndFps().fps;
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

                public VideoEncodeFormat getVideoEncodeFormat() {
                    if (CameraXB015Data.instance().getVideoEncoderConfiguration() == null || CameraXB015Data.instance().getVideoEncoderConfiguration().size() <= 0) {
                        return null;
                    }
                    return CameraXB015Data.instance().getVideoEncoderConfiguration().get(0).getEncoding();
                }

                public PIVMode getPIVMode() {
                    return CameraXB015Data.instance().getAutoSnapshotEnable() == 1 ? PIVMode.Auto : PIVMode.Manual;
                }

                public VideoSnapshotTimelapseInterval getAutoPIVTimelapseInterval() {
                    return VideoSnapshotTimelapseInterval.find(CameraXB015Data.instance().getAutoSnapshotInterval());
                }

                public LensFocusMode getFocusMode() {
                    return LensFocusMode.find(CameraXB015Data.instance().getFocusMode());
                }

                public int getFocusDistance() {
                    return CameraXB015Data.instance().getObjectDistance();
                }

                public ShutterMode getShutterMode() {
                    return ShutterMode.find(CameraXB015Data.instance().getShutterMode());
                }

                public SaveLocation getStorageType() {
                    return SaveLocation.find(CameraXB015Data.instance().getStorageType());
                }

                public FlashCardStatus getFlashCardStatus() {
                    return CameraXB015Data.instance().getFlashCardStatus();
                }

                public DeFogParam getDeFogParam() {
                    return new DeFogParam() {
                        public boolean isEnable() {
                            return CameraXB015Data.instance().isDeFogStatus();
                        }

                        public int getStrength() {
                            return CameraXB015Data.instance().getDeFogStrength();
                        }
                    };
                }

                public ImageRoiParam getImageRoiParam() {
                    return new ImageRoiParam() {
                        public boolean isEnable() {
                            return CameraXB015Data.instance().isImageRoiStatus();
                        }

                        public int getStrength() {
                            return CameraXB015Data.instance().getImageRoiStrength();
                        }
                    };
                }

                public String getLensModel() {
                    return CameraXB015Data.instance().getLensModel();
                }

                public CameraProduct getType() {
                    return CameraProduct.XT701;
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
                    return "getColorStyle : " + getColorStyle() + ", getWhiteBalance : " + getWhiteBalance() + ", getAutoExposureLockState : " + getAutoExposureLockState() + ", isHistogramEnable : " + isHistogramEnable() + ", getExposureMode : " + getExposureMode() + ", getPhotoStyle : " + getPhotoStyle() + ", isSubtitleEnable : " + isSubtitleEnable() + ", getAntiFlicker = " + getAntiFlicker() + ", getType : " + getType() + ", getWorkState : " + getWorkState() + ", getMediaMode : " + getMediaMode() + ", getVideoFormat = " + getVideoFormat() + ", getPhotoAspectRatio = " + getPhotoAspectRatio() + ", getPhotoFormat = " + getPhotoFormat() + ", getDigitalZoomScale = " + getDigitalZoomScale() + ", getVideoResolutionAndFrameRate = " + getVideoResolutionAndFrameRate() + ", getBurstCount = " + getBurstCount() + ", getAEBCount = " + getAEBCount() + ", getTimelapseInterval = " + getTimelapseInterval();
                }
            });
        } else if (this.hasCallback.compareAndSet(false, true)) {
            AutelLog.debug_i("Camera", "getStateInfo- isParameterValid ---->>> false");
            this.request.getCameraAllSetting(CameraAllSettings.class, new CallbackWithOneParam<CameraAllSettings>() {
                public void onSuccess(final CameraAllSettings cameraAllSettings) {
                    AutelLog.debug_i("Camera", "getStateInfo- CameraAllSettings ---->>> success");
                    CameraAllSettingsWithParser.instance().updateCameraSetting(cameraAllSettings);
                    CameraManager.instance().setParameterValid(true);
                    C32101 r0 = new XT701StateInfo() {
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

                        public VideoFormat getVideoFormat() {
                            return VideoFormat.find(cameraAllSettings.getRecordingSettings().getFileFormat());
                        }

                        public PhotoAspectRatio getPhotoAspectRatio() {
                            return PhotoAspectRatio.find(cameraAllSettings.getPhotoTakingSettings().getResolution(), CameraProduct.XT701);
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

                        public VideoEncodeFormat getVideoEncodeFormat() {
                            if (cameraAllSettings.getVideoEncoderConfiguration() == null || cameraAllSettings.getVideoEncoderConfiguration().size() <= 0) {
                                return null;
                            }
                            return VideoEncodeFormat.find(cameraAllSettings.getVideoEncoderConfiguration().get(0).getEncoding());
                        }

                        public PIVMode getPIVMode() {
                            return cameraAllSettings.getRecordingSettings().getAutoSnapshot().getEnable() == 1 ? PIVMode.Auto : PIVMode.Manual;
                        }

                        public VideoSnapshotTimelapseInterval getAutoPIVTimelapseInterval() {
                            return VideoSnapshotTimelapseInterval.find(cameraAllSettings.getRecordingSettings().getAutoSnapshot().getInterval());
                        }

                        public LensFocusMode getFocusMode() {
                            if (cameraAllSettings.getFocus() != null) {
                                return LensFocusMode.find(cameraAllSettings.getFocus().getMode());
                            }
                            return LensFocusMode.UNKNOWN;
                        }

                        public int getFocusDistance() {
                            if (cameraAllSettings.getFocus() != null) {
                                return cameraAllSettings.getFocus().getObjectDistance();
                            }
                            return -1;
                        }

                        public ShutterMode getShutterMode() {
                            return ShutterMode.find(cameraAllSettings.getShutter().getType());
                        }

                        public SaveLocation getStorageType() {
                            return SaveLocation.find(cameraAllSettings.getStorageType().StorageType);
                        }

                        public FlashCardStatus getFlashCardStatus() {
                            C32111 r0 = new FlashCardStatus() {
                                public MMCState getFlashCardStatus() {
                                    return MMCState.find(cameraAllSettings.getMMCStatus().getMMCStatus());
                                }

                                public long getTotalSpace() {
                                    return cameraAllSettings.getMMCStatus().getTotalSpace();
                                }

                                public long getFreeSpace() {
                                    return cameraAllSettings.getMMCStatus().getFreeSpace();
                                }

                                public long getCurrentRecordTime() {
                                    return cameraAllSettings.getMMCStatus().getCurrentRecordTime();
                                }

                                public int getRemainRecordTime() {
                                    return cameraAllSettings.getMMCStatus().getRemainRecordTime();
                                }

                                public int getRemainCaptureNum() {
                                    return cameraAllSettings.getMMCStatus().getRemainCaptureNum();
                                }
                            };
                            CameraXB015Data.instance().setFlashCardStatus(r0);
                            return r0;
                        }

                        public DeFogParam getDeFogParam() {
                            return new DeFogParam() {
                                public boolean isEnable() {
                                    return CameraParamsConfig.param_Enable.equals(cameraAllSettings.getDehazeSetting().getStatus());
                                }

                                public int getStrength() {
                                    return cameraAllSettings.getDehazeSetting().getStrength();
                                }
                            };
                        }

                        public ImageRoiParam getImageRoiParam() {
                            return new ImageRoiParam() {
                                public boolean isEnable() {
                                    return CameraParamsConfig.param_Enable.equals(cameraAllSettings.getImageRoiSetting().getStatus());
                                }

                                public int getStrength() {
                                    if (cameraAllSettings.getImageRoiSetting().getRoiRegion() == null || cameraAllSettings.getImageRoiSetting().getRoiRegion().size() <= 0) {
                                        return 0;
                                    }
                                    return cameraAllSettings.getImageRoiSetting().getRoiRegion().get(0).getStrength();
                                }
                            };
                        }

                        public String getLensModel() {
                            return cameraAllSettings.getDeviceInformation().getLensModel();
                        }

                        public CameraProduct getType() {
                            return CameraProduct.XT701;
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
                    };
                    CameraXT701Impl.this.hasCallback.set(false);
                    callbackWithOneParam.onSuccess(r0);
                }

                public void onFailure(AutelError autelError) {
                    CameraXT701Impl.this.hasCallback.set(false);
                    AutelLog.debug_i("Camera", "getStateInfo- onFailure ---->>> error: " + autelError.getDescription());
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

    public void setAspectRatio(final PhotoAspectRatio photoAspectRatio, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAspectRatio(photoAspectRatio.value(CameraProduct.XT701), new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setPicResolution(photoAspectRatio.value(CameraProduct.XT701));
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
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
                    callbackWithOneParam.onSuccess(PhotoAspectRatio.find(photoTakingSettings.getResolution(), CameraProduct.XT701));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setVideoEncoder(final VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
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

    public void getVideoEncoderConfiguration(final CallbackWithOneParam<VideoEncoderConfiguration> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getVideoEncoderConfiguration(0, new CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration>() {
                public void onSuccess(final CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration) {
                    callbackWithOneParam.onSuccess(new VideoEncoderConfiguration() {
                        public VideoEncodeFormat getEncoding() {
                            return VideoEncodeFormat.find(videoEncoderConfiguration.getEncoding());
                        }

                        public VideoResolutionAndFps getVideoResolutionAndFps() {
                            CameraXB015Data.instance().setVideoMainResolutionAndFps(VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution()));
                            return VideoResolutionAndFps.create(videoEncoderConfiguration.getResolution());
                        }

                        public int getQuality() {
                            return videoEncoderConfiguration.getQuality();
                        }

                        public int getIntervalOfIFrame() {
                            return videoEncoderConfiguration.getGovLength();
                        }

                        public int getBitrate() {
                            return videoEncoderConfiguration.getBitrate();
                        }

                        public VideoBitrateType getBitrateType() {
                            return VideoBitrateType.find(videoEncoderConfiguration.getBitrateType());
                        }

                        public VideoEncodeType getEncodeType() {
                            return VideoEncodeType.find(videoEncoderConfiguration.getProfile());
                        }

                        public String toString() {
                            return "VideoEncodeFormat : " + getEncoding() + ", getVideoMainResolutionAndFps : " + getVideoResolutionAndFps() + ", getQuality : " + getQuality() + ", getIntervalOfIFrame : " + getIntervalOfIFrame() + ", getBitrate : " + getBitrate() + ", getBitrateType : " + getBitrateType() + ", getEncodeType : " + getEncodeType();
                        }
                    });
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
        CameraXT701 cameraXT701 = this.request;
        if (cameraXT701 != null) {
            cameraXT701.getVideoSourceConfiguration(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
                public void onSuccess(CameraAllSettings.VideoSourceConfiguration videoSourceConfiguration) {
                    callbackWithOneParam.onSuccess(VideoRotation.find(videoSourceConfiguration.getRotation()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setShutterMode(final ShutterMode shutterMode, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setShutterMode(shutterMode, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setShutterMode(shutterMode.getValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getShutterMode(final CallbackWithOneParam<ShutterMode> callbackWithOneParam) {
        this.request.getShutterMode(new CallbackWithOneParam<ShutterMode>() {
            public void onSuccess(ShutterMode shutterMode) {
                CameraXB015Data.instance().setShutterMode(shutterMode.getValue());
                callbackWithOneParam.onSuccess(shutterMode);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setAFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAFAssistFocusEnable(z, callbackWithNoParam);
    }

    public void getAFAssistFocusEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
                public void onSuccess(CameraAllSettings.Focus focus) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    boolean z = true;
                    if (focus.getAFAssistFocusEnable() != 1) {
                        z = false;
                    }
                    callbackWithOneParam.onSuccess(Boolean.valueOf(z));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setMFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setMFAssistFocusEnable(z, callbackWithNoParam);
    }

    public void getMFAssistFocusEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
                public void onSuccess(CameraAllSettings.Focus focus) {
                    CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                    boolean z = true;
                    if (focus.getMFAssistFocusEnable() != 1) {
                        z = false;
                    }
                    callbackWithOneParam.onSuccess(Boolean.valueOf(z));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setPIVMode(PIVMode pIVMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPIVMode(pIVMode, callbackWithNoParam);
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
        this.request.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAutoSnapshotInterval(videoSnapshotTimelapseInterval.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void switchToPreviousPhotoMode(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        final MediaMode find = MediaMode.find(CameraXB015Data.instance().getPrevPhotoTakingMode());
        setMediaMode(find, new CallbackWithNoParam() {
            public void onSuccess() {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onSuccess(find);
                }
            }

            public void onFailure(AutelError autelError) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                if (callbackWithOneParam != null) {
                    callbackWithOneParam.onFailure(autelError);
                }
            }
        });
    }

    public void setTrackingModeEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setTrackingMode(z ? TrackMode.ENTER_TRACK : TrackMode.EXIT_TRACK, callbackWithNoParam);
    }

    public void getSkylinePositionData(final int i, final int i2, final CallbackWithOneParam<SkylinePositionData> callbackWithOneParam) {
        if (this.mCameraSkylineCalculator == null) {
            this.mCameraSkylineCalculator = new CameraSkylineCalculator(new XB016CameraAndGimbalHardware());
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
                        CameraXT701Impl.this.getMediaMode(new CallbackWithOneParam<MediaMode>() {
                            public void onFailure(AutelError autelError) {
                            }

                            public void onSuccess(MediaMode mediaMode) {
                                CameraXT701Impl.this.skylinePositionData.skylineYPosition = CameraXT701Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
                                CameraXT701Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXT701Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
                                callbackWithOneParam.onSuccess(CameraXT701Impl.this.skylinePositionData);
                            }
                        });
                        return;
                    }
                    CameraXT701Impl.this.skylinePositionData.skylineYPosition = CameraXT701Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
                    CameraXT701Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXT701Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
                    callbackWithOneParam.onSuccess(CameraXT701Impl.this.skylinePositionData);
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
                    CameraXT701Impl.this.skylinePositionData.skylineYPosition = CameraXT701Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i3, i4);
                    CameraXT701Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXT701Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i4);
                    callbackWithOneParam2.onSuccess(CameraXT701Impl.this.skylinePositionData);
                }
            });
            return;
        }
        this.skylinePositionData.skylineYPosition = this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
        this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
        callbackWithOneParam.onSuccess(this.skylinePositionData);
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

    public void setAlbumSaveLocation(SaveLocation saveLocation, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAlbumSaveLocation(saveLocation, callbackWithNoParam);
    }

    public void getAlbumLocation(final CallbackWithOneParam<SaveLocation> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getAlbumLocation(new CallbackWithOneParam<CameraAllSettings.StorageType>() {
                public void onSuccess(CameraAllSettings.StorageType storageType) {
                    CameraXB015Data.instance().setStorageType(storageType.StorageType);
                    callbackWithOneParam.onSuccess(SaveLocation.find(storageType.StorageType));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getFMCStatus(final CallbackWithOneParam<FlashCardStatus> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getFMCStatus(new CallbackWithOneParam<CameraAllSettings.MMCStatus>() {
                public void onSuccess(final CameraAllSettings.MMCStatus mMCStatus) {
                    callbackWithOneParam.onSuccess(new FlashCardStatus() {
                        public MMCState getFlashCardStatus() {
                            return MMCState.find(mMCStatus.getMMCStatus());
                        }

                        public long getTotalSpace() {
                            return mMCStatus.getTotalSpace();
                        }

                        public long getFreeSpace() {
                            return mMCStatus.getFreeSpace();
                        }

                        public long getCurrentRecordTime() {
                            return mMCStatus.getCurrentRecordTime();
                        }

                        public int getRemainRecordTime() {
                            return mMCStatus.getRemainRecordTime();
                        }

                        public int getRemainCaptureNum() {
                            return mMCStatus.getRemainCaptureNum();
                        }
                    });
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void formatFlashMemoryCard(CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.request.formatFlashMemoryCard(callbackWithNoParam);
        }
    }

    public void setHDREnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.request.setHDREnable(z, callbackWithNoParam);
        }
    }

    public void getHDREnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getHDRSetting(callbackWithOneParam);
        }
    }

    public void setDeFogEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.request.setDeFogEnable(z, callbackWithNoParam);
        }
    }

    public void setDeFogStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.request.setDeFogStrength(i, callbackWithNoParam);
        }
    }

    public void getDeFogParams(CallbackWithOneParam<DeFogParam> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getDeFogParams(callbackWithOneParam);
        }
    }

    public void setImageRoiEnable(final boolean z, final CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.request.setImageRoiEnable(z, new CallbackWithNoParam() {
                public void onSuccess() {
                    CameraXB015Data.instance().setImageRoiStatus(z);
                    callbackWithNoParam.onSuccess();
                }

                public void onFailure(AutelError autelError) {
                    callbackWithNoParam.onFailure(autelError);
                }
            });
        }
    }

    public void setImageRoiStrength(final int i, final CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.request.setImageRoiStrength(i, new CallbackWithNoParam() {
                public void onSuccess() {
                    CameraXB015Data.instance().setImageRoiStrength(i);
                    callbackWithNoParam.onSuccess();
                }

                public void onFailure(AutelError autelError) {
                    callbackWithNoParam.onFailure(autelError);
                }
            });
        }
    }

    public void setImageRoiArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.request.setImageRoiArea(i, i2, callbackWithNoParam);
        }
    }

    public void getImageRoiParams(final CallbackWithOneParam<ImageRoiParam> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.getImageRoiParams(new CallbackWithOneParam<ImageRoiParam>() {
                public void onSuccess(ImageRoiParam imageRoiParam) {
                    CameraXB015Data.instance().setImageRoiStatus(imageRoiParam.isEnable());
                    callbackWithOneParam.onSuccess(imageRoiParam);
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
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

    public void setFlashMemoryCardStateListener(CallbackWithOneParam<MMCState> callbackWithOneParam) {
        setFMCardStateListener(callbackWithOneParam);
    }

    public void setPhotoExposureListener(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BaseCameraRequest.instance().addCameraEventsListener(AutelListenerManager.PhotoExposureListener, new CallbackWithOneParam<CameraEvents>() {
                public void onSuccess(CameraEvents cameraEvents) {
                    if (!CameraConstant20.PhotoExposure.equals(cameraEvents.getType())) {
                        return;
                    }
                    if (cameraEvents.getMap().get(CameraParamsConfig.param_Status).equals("Overexposed")) {
                        callbackWithOneParam.onSuccess(true);
                    } else {
                        callbackWithOneParam.onSuccess(false);
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onSuccess(false);
                }
            });
        } else {
            BaseCameraRequest.instance().removeCameraEventsListener(AutelListenerManager.PhotoExposureListener);
        }
    }

    public void setAFCenterListener(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BaseCameraRequest.instance().addCameraEventsListener(AutelListenerManager.AFCenterListener, new CallbackWithOneParam<CameraEvents>() {
                public void onSuccess(CameraEvents cameraEvents) {
                    if (!CameraConstant20.AEAFSTATUSCHANGED.equals(cameraEvents.getType())) {
                        return;
                    }
                    if (cameraEvents.getMap().get("AEStatus").equals("Center")) {
                        callbackWithOneParam.onSuccess(true);
                    } else {
                        callbackWithOneParam.onSuccess(false);
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onSuccess(false);
                }
            });
        } else {
            BaseCameraRequest.instance().removeCameraEventsListener(AutelListenerManager.AFCenterListener);
        }
    }

    public void setMotionDelayShotListener(final CallbackWithOneParam<MotionDelayShot> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BaseCameraRequest.instance().addCameraEventsListener("MotionDelayShotListener", new CallbackWithOneParam<CameraEvents>() {
                public void onSuccess(final CameraEvents cameraEvents) {
                    if (CameraConstant20.MotionDelayShotStatus.equals(cameraEvents.getType())) {
                        try {
                            callbackWithOneParam.onSuccess(new MotionDelayShot() {
                                public MotionDelayState getMotionDelayState() {
                                    return MotionDelayState.find(Integer.valueOf(cameraEvents.getMap().get(CameraParamsConfig.param_Status)).intValue());
                                }

                                public int getPhotoTime() {
                                    return Integer.valueOf(cameraEvents.getMap().get("PhotoTime")).intValue();
                                }

                                public int getTotalPhotoTime() {
                                    return Integer.valueOf(cameraEvents.getMap().get("TotalPhotoTime")).intValue();
                                }

                                public int getPhotoNumber() {
                                    return Integer.valueOf(cameraEvents.getMap().get("PhotoNum")).intValue();
                                }

                                public int getTotalPhotoNumber() {
                                    return Integer.valueOf(cameraEvents.getMap().get("TotalPhotoNum")).intValue();
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            BaseCameraRequest.instance().removeCameraEventsListener("MotionDelayShotListener");
        }
    }

    public void setSettingChangedListener(CallbackWithOneParam<SettingEvent> callbackWithOneParam) {
        this.request.setSettingChangedListener(callbackWithOneParam);
    }

    private void setFMCardStateListener(final CallbackWithOneParam<MMCState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BaseCameraRequest.instance().addCameraEventsListener("setFMCardStateListener", new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(final CameraEvents cameraEvents) {
                    if (CameraConstant20.CAMERA_TYPE_FMC_STATUS.equals(cameraEvents.getType())) {
                        try {
                            CameraXB015Data.instance().setFlashCardStatus(new FlashCardStatus() {
                                public MMCState getFlashCardStatus() {
                                    return MMCState.find(cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FMC_STATUS));
                                }

                                public long getTotalSpace() {
                                    try {
                                        return Long.valueOf(cameraEvents.getMap().get("MMCTotalSpace")).longValue();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return 0;
                                    }
                                }

                                public long getFreeSpace() {
                                    try {
                                        return Long.valueOf(cameraEvents.getMap().get("MMCFreeSpace")).longValue();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return 0;
                                    }
                                }

                                public long getCurrentRecordTime() {
                                    try {
                                        return Long.valueOf(cameraEvents.getMap().get("CurrentRecordTime")).longValue();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return 0;
                                    }
                                }

                                public int getRemainRecordTime() {
                                    try {
                                        return Integer.valueOf(cameraEvents.getMap().get("RemainRecordTime")).intValue();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return 0;
                                    }
                                }

                                public int getRemainCaptureNum() {
                                    try {
                                        return Integer.valueOf(cameraEvents.getMap().get("RemainCaptureNum")).intValue();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return 0;
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Log.d("MMC_sdcard", "type:" + cameraEvents.getType() + " status:" + cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FMC_STATUS));
                        callbackWithOneParam.onSuccess(MMCState.find(cameraEvents.getMap().get(CameraConstant20.CAMERA_TYPE_FMC_STATUS)));
                    }
                }
            });
            BaseCameraRequest.instance().addCameraSystemStatusListener("setFMCameraSystemStatusListener", new CallbackWithOneParam<CameraSystemStatus>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(CameraSystemStatus cameraSystemStatus) {
                    if (CameraXT701Impl.this.sdCardStatus != null && !CameraXT701Impl.this.sdCardStatus.equalsIgnoreCase(cameraSystemStatus.getMMCStatus())) {
                        String unused = CameraXT701Impl.this.sdCardStatus = cameraSystemStatus.getMMCStatus();
                        callbackWithOneParam.onSuccess(MMCState.find(cameraSystemStatus.getMMCStatus()));
                    }
                }
            });
            return;
        }
        BaseCameraRequest.instance().removeCameraEventsListener("setFMCardStateListener");
        BaseCameraRequest.instance().removeCameraSystemStatusListener("setFMCameraSystemStatusListener");
    }

    public void setInfoListener(final CallbackWithOneParam<XT701CameraInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            this.request.addCameraSystemStatusListener(MediaInfoTag, (CallbackWithOneParam<CameraSystemStatus>) null);
        } else {
            this.request.addCameraSystemStatusListener(MediaInfoTag, new CallbackWithOneParam<CameraSystemStatus>() {
                public void onSuccess(final CameraSystemStatus cameraSystemStatus) {
                    callbackWithOneParam.onSuccess(new XT701CameraInfo() {
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

                        public CameraAperture getCameraAperture() {
                            double apertureValue = cameraSystemStatus.getApertureValue();
                            if (apertureValue >= 10.0d) {
                                return CameraAperture.find(String.valueOf((int) apertureValue));
                            }
                            return CameraAperture.find(String.valueOf(cameraSystemStatus.getApertureValue()));
                        }

                        public MMCState getMMCState() {
                            return MMCState.find(CameraXB015Data.instance().getMMCStatus());
                        }

                        public SDCardState getSDCardState() {
                            return SDCardState.find(cameraSystemStatus.getSDCardStatus());
                        }

                        public WorkState getWorkState() {
                            return WorkState.find(CameraXB015Data.instance().getSystemStatus());
                        }

                        public long getMMCTotalSpace() {
                            return CameraXB015Data.instance().getMMCTotalSpace();
                        }

                        public long getMMCFreeSpace() {
                            return CameraXB015Data.instance().getMMCFreeSpace();
                        }

                        public long getSDcardFreeSpace() {
                            return cameraSystemStatus.getFreeSpace();
                        }

                        public float getVerticalFOV() {
                            return cameraSystemStatus.getFovV();
                        }

                        public float getHorizontalFOV() {
                            return cameraSystemStatus.getFovH();
                        }

                        public int getPhotoIntervalMin() {
                            return cameraSystemStatus.getPhotoIntervalMin();
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

    public void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setManualFocusMeter(i, i2, callbackWithNoParam);
    }

    public void getFocusMFSpotArea(final CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.request.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
            public void onSuccess(CameraAllSettings.Focus focus) {
                SpotMeteringArea spotMeteringArea = new SpotMeteringArea();
                spotMeteringArea.f8467X = focus.getMFSpotArea().getX();
                spotMeteringArea.f8468Y = focus.getMFSpotArea().getY();
                callbackWithOneParam.onSuccess(spotMeteringArea);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setMotionDelayShotInterval(i, callbackWithNoParam);
    }

    public void getMotionDelayShotInterval(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getMotionDelayShotInterval(callbackWithOneParam);
    }

    public void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setMotionDelayShotDuration(i, callbackWithNoParam);
    }

    public void getMotionDelayShotDuration(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getMotionDelayShotDuration(callbackWithOneParam);
    }

    public void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam) {
        this.request.setMotionDelayShotKeepPhoto(rawFormat, callbackWithNoParam);
    }

    public void getMotionDelayShotKeepPhoto(CallbackWithOneParam<MotionPhotoInfo> callbackWithOneParam) {
        this.request.getMotionDelayShotKeepPhoto(callbackWithOneParam);
    }

    public XT701ParameterRangeManager getParameterRangeManager() {
        if (this.XT701ParameterRangeManager == null) {
            this.XT701ParameterRangeManager = new XT701ParameterRangeManagerImpl();
        }
        return this.XT701ParameterRangeManager;
    }
}
