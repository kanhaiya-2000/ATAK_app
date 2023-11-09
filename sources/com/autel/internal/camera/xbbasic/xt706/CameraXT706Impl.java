package com.autel.internal.camera.xbbasic.xt706;

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
import com.autel.camera.protocol.protocol20.interfaces.CameraXT706;
import com.autel.camera.protocol.protocol20.request.BaseCameraRequest;
import com.autel.camera.protocol.protocol20.request.CameraFactory;
import com.autel.camera.protocol.protocol20.request.CameraHttpRequest;
import com.autel.camera.protocol.protocol20.xt706.C2568XT706;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.XT706.IrColor;
import com.autel.common.camera.XT706.IrPosition;
import com.autel.common.camera.XT706.IrTemperatureMode;
import com.autel.common.camera.XT706.IrTemperatureParams;
import com.autel.common.camera.XT706.IrTemperatureWarnParams;
import com.autel.common.camera.XT706.IrTemperatureWarningStatus;
import com.autel.common.camera.XT706.IrTempetureWarningParams;
import com.autel.common.camera.XT706.XT706CameraInfo;
import com.autel.common.camera.XT706.XT706ParameterRangeManager;
import com.autel.common.camera.XT706.XT706StateInfo;
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
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.data.CameraModelDataManager;
import com.autel.internal.sdk.camera.data.model.CameraFlirData;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.camera.media.PhotoSumImpl;
import com.autel.internal.sdk.camera.media.VideoSumImpl;
import com.autel.sdk.camera.p005rx.RxAutelXT706;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraXT706Impl extends BaseCamera20 implements CameraXT706Service {
    private static final String MediaInfoTag = "MediaInfo";
    protected XT706ParameterRangeManager XT706ParameterRangeManager;
    protected CameraXT706 cameraRequest = ((CameraXT706) CameraFactory.getCameraProduct(C2568XT706.class));
    final AtomicBoolean hasCallback = new AtomicBoolean(false);
    private CameraHttpRequest httpRequest = new CameraHttpRequest();
    /* access modifiers changed from: private */
    public CameraSkylineCalculator mCameraSkylineCalculator;
    /* access modifiers changed from: private */
    public volatile String sdCardStatus = MMCState.UNKNOWN.getValue();
    /* access modifiers changed from: private */
    public SkylinePositionDataImpl skylinePositionData;

    public RxAutelXT706 toRx() {
        return null;
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.cameraRequest.setHistogramListener(callbackWithOneParam);
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.cameraRequest.setAutoFocusStateListener(callbackWithTwoParams);
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setSpotMeteringArea(i, i2, callbackWithNoParam);
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setExposure(exposureCompensation, callbackWithNoParam);
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setISO(cameraISO, callbackWithNoParam);
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setShutter(shutterSpeed, callbackWithNoParam);
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        this.cameraRequest.getColorStyle(callbackWithOneParam);
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setWhiteBalance(whiteBalance, callbackWithNoParam);
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setColorStyle(colorStyle, callbackWithNoParam);
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.set3DNoiseReductionEnable(z, callbackWithNoParam);
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setAntiFlicker(antiFlicker, callbackWithNoParam);
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        this.cameraRequest.getAutoExposureLockState(callbackWithOneParam);
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (LensFocusMode.find(CameraXB015Data.instance().getFocusMode()) == LensFocusMode.MANUAL_FOCUS) {
            this.cameraRequest.getFocusMFSpotArea(callbackWithOneParam);
        } else {
            this.cameraRequest.getSpotMeteringArea(callbackWithOneParam);
        }
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        this.cameraRequest.getAntiFlicker(callbackWithOneParam);
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        this.cameraRequest.getWhiteBalance(callbackWithOneParam);
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        this.cameraRequest.getExposure(callbackWithOneParam);
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        this.cameraRequest.getShutter(callbackWithOneParam);
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        this.cameraRequest.getISO(callbackWithOneParam);
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        this.cameraRequest.getExposureMode(callbackWithOneParam);
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setPhotoStyle(photoStyleType, callbackWithNoParam);
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setPhotoStyle(i, i2, i3, callbackWithNoParam);
    }

    public void isHistogramStatusEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.isHistogramStatusEnable(callbackWithOneParam);
        }
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setVideoSubtitleEnable(z, callbackWithNoParam);
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.cameraRequest.isSubtitleEnable(callbackWithOneParam);
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        this.cameraRequest.getPhotoStyle(callbackWithOneParam);
    }

    public void setFocusMode(LensFocusMode lensFocusMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setFocusMode(lensFocusMode, callbackWithNoParam);
    }

    public void getFocusMode(CallbackWithOneParam<LensFocusMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getFocusMode(callbackWithOneParam);
        }
    }

    public void getFocusAFSpotArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getFocusAFSpotArea(callbackWithOneParam);
        }
    }

    public void getFocusDistance(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getFocusDistance(callbackWithOneParam);
        }
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setDigitalZoomScale(i, callbackWithNoParam);
    }

    public void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setPhotoAutoFocusMeter(i, i2, callbackWithNoParam);
    }

    public void setFocusDistance(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setManualFocusDistance(i, callbackWithNoParam);
    }

    public void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.startTakePhotoWithFocus(callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        this.cameraRequest.getPhotoAEBCount(callbackWithOneParam);
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        this.cameraRequest.getPhotoBurstCount(callbackWithOneParam);
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        this.cameraRequest.getPhotoTimelapseInterval(callbackWithOneParam);
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setExposureMode(exposureMode, callbackWithNoParam);
    }

    public void getVideoSum(final CallbackWithOneParam<VideoSum> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            if (CameraModelDataManager.instance().getBaseCameraData() instanceof CameraFlirData) {
                this.cameraRequest.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
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
                this.cameraRequest.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
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
                this.cameraRequest.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
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
                this.cameraRequest.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
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
                this.cameraRequest.getSDCardStatus(FlirCameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<FlirCameraAllSettings.SDCardStatus>() {
                    public void onSuccess(FlirCameraAllSettings.SDCardStatus sDCardStatus) {
                        callbackWithOneParam.onSuccess(Integer.valueOf((int) sDCardStatus.getCurrentRecordTime()));
                    }

                    public void onFailure(AutelError autelError) {
                        callbackWithOneParam.onFailure(autelError);
                    }
                });
            } else {
                this.cameraRequest.getSDCardStatus(CameraAllSettings.SDCardStatus.class, new CallbackWithOneParam<CameraAllSettings.SDCardStatus>() {
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
        if (this.hasCallback.compareAndSet(false, true)) {
            this.cameraRequest.getCameraAllSetting(CameraAllSettings.class, new CallbackWithOneParam<CameraAllSettings>() {
                public void onSuccess(final CameraAllSettings cameraAllSettings) {
                    CameraAllSettingsWithParser.instance().updateCameraSetting(cameraAllSettings);
                    CameraManager.instance().setParameterValid(true);
                    C37231 r0 = new XT706StateInfo() {
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
                            return PhotoAspectRatio.find(cameraAllSettings.getPhotoTakingSettings().getResolution(), CameraProduct.XT706);
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
                            C37241 r0 = new FlashCardStatus() {
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

                        public DisplayMode getDisplayMode() {
                            return DisplayMode.find(CameraXB015Data.instance().getDisplayMode());
                        }

                        public IrColor getIrColor() {
                            return IrColor.find(cameraAllSettings.getIrColor().getColor());
                        }

                        public IrPosition getIrPosition() {
                            return new IrPosition(cameraAllSettings.getIrPosition().getDeltaX(), cameraAllSettings.getIrPosition().getDeltaY());
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
                            return CameraProduct.XT706;
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
                    CameraXT706Impl.this.hasCallback.set(false);
                    callbackWithOneParam.onSuccess(r0);
                }

                public void onFailure(AutelError autelError) {
                    CameraXT706Impl.this.hasCallback.set(false);
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getVideoResolutionAndFrameRate(final CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getVideoEncoderConfiguration(0, new CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration>() {
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
        this.cameraRequest.setAspectRatio(photoAspectRatio.value(CameraProduct.XT706), new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setPicResolution(photoAspectRatio.value(CameraProduct.XT706));
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoFormat(final PhotoFormat photoFormat, final CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
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
        this.cameraRequest.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
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
        this.cameraRequest.setVideoFormat(videoFormat, new CallbackWithNoParam() {
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
        this.cameraRequest.setVideoStandard(videoStandard, new CallbackWithNoParam() {
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
            this.cameraRequest.getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
                public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                    callbackWithOneParam.onSuccess(PhotoAspectRatio.find(photoTakingSettings.getResolution(), CameraProduct.XT706));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setVideoEncoder(final VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setVideoEncoderConfiguration(0, new VideoEncoderConfiguration() {
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
            this.cameraRequest.getVideoEncoderConfiguration(0, new CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration>() {
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
        this.cameraRequest.setVideoRotation(videoRotation, new CallbackWithNoParam() {
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
        CameraXT706 cameraXT706 = this.cameraRequest;
        if (cameraXT706 != null) {
            cameraXT706.getVideoSourceConfiguration(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
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
        this.cameraRequest.setShutterMode(shutterMode, new CallbackWithNoParam() {
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
        this.cameraRequest.getShutterMode(new CallbackWithOneParam<ShutterMode>() {
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
        this.cameraRequest.setAFAssistFocusEnable(z, callbackWithNoParam);
    }

    public void getAFAssistFocusEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
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
        this.cameraRequest.setMFAssistFocusEnable(z, callbackWithNoParam);
    }

    public void getMFAssistFocusEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
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
        this.cameraRequest.setPIVMode(pIVMode, callbackWithNoParam);
    }

    public void getPIVMode(final CallbackWithOneParam<PIVMode> callbackWithOneParam) {
        this.cameraRequest.getRecordingSettings(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
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
        this.cameraRequest.setAutoPIVTimelapseInterval(videoSnapshotTimelapseInterval, new CallbackWithNoParam() {
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
        this.cameraRequest.setTrackingMode(z ? TrackMode.ENTER_TRACK : TrackMode.EXIT_TRACK, callbackWithNoParam);
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
                        CameraXT706Impl.this.getMediaMode(new CallbackWithOneParam<MediaMode>() {
                            public void onFailure(AutelError autelError) {
                            }

                            public void onSuccess(MediaMode mediaMode) {
                                CameraXT706Impl.this.skylinePositionData.skylineYPosition = CameraXT706Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
                                CameraXT706Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXT706Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
                                callbackWithOneParam.onSuccess(CameraXT706Impl.this.skylinePositionData);
                            }
                        });
                        return;
                    }
                    CameraXT706Impl.this.skylinePositionData.skylineYPosition = CameraXT706Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
                    CameraXT706Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXT706Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
                    callbackWithOneParam.onSuccess(CameraXT706Impl.this.skylinePositionData);
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
                    CameraXT706Impl.this.skylinePositionData.skylineYPosition = CameraXT706Impl.this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i3, i4);
                    CameraXT706Impl.this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = CameraXT706Impl.this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i4);
                    callbackWithOneParam2.onSuccess(CameraXT706Impl.this.skylinePositionData);
                }
            });
            return;
        }
        this.skylinePositionData.skylineYPosition = this.mCameraSkylineCalculator.getSkylineYInView(videoResolution, i2, i);
        this.skylinePositionData.heightDistanceBetweenSkylineAndValidBoundary = this.mCameraSkylineCalculator.getValidBoundaryDistanceInView(i);
        callbackWithOneParam.onSuccess(this.skylinePositionData);
    }

    public void setVideoEncodeFormat(final VideoEncodeFormat videoEncodeFormat, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setVideoEncoderConfiguration(0, new VideoEncoderConfiguration() {
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
            this.cameraRequest.getVideoEncoderConfiguration(0, new CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration>() {
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
        this.cameraRequest.setAlbumSaveLocation(saveLocation, callbackWithNoParam);
    }

    public void getAlbumLocation(final CallbackWithOneParam<SaveLocation> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getAlbumLocation(new CallbackWithOneParam<CameraAllSettings.StorageType>() {
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
            this.cameraRequest.getFMCStatus(new CallbackWithOneParam<CameraAllSettings.MMCStatus>() {
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
            this.cameraRequest.formatFlashMemoryCard(callbackWithNoParam);
        }
    }

    public void setDisplayMode(DisplayMode displayMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setDisplayMode(displayMode, callbackWithNoParam);
    }

    public void getDisplayMode(final CallbackWithOneParam<DisplayMode> callbackWithOneParam) {
        this.cameraRequest.getDisplayMode(new CallbackWithOneParam<DisplayMode>() {
            public void onSuccess(DisplayMode displayMode) {
                CameraXB015Data.instance().setDisplayMode(displayMode.value());
                callbackWithOneParam.onSuccess(displayMode);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVideoFormat(final CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getRecordingSettings(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
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
            this.cameraRequest.getVideoSourceConfiguration(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
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
        this.cameraRequest.getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                callbackWithOneParam.onSuccess(PhotoFormat.find(photoTakingSettings.getPicType()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setTemperatureWarningListener(final CallbackWithOneParam<IrTempetureWarningParams> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            BaseCameraRequest.instance().addCameraEventsListener(AutelListenerManager.TemperatureWarningListener, new CallbackWithOneParam<CameraEvents>() {
                public void onSuccess(CameraEvents cameraEvents) {
                    if (CameraConstant20.TempAlarm.equals(cameraEvents.getType())) {
                        IrTempetureWarningParams irTempetureWarningParams = new IrTempetureWarningParams();
                        irTempetureWarningParams.warningStatus = IrTemperatureWarningStatus.find(cameraEvents.getMap().get(CameraParamsConfig.param_Status));
                        irTempetureWarningParams.highxRatio = Float.parseFloat(cameraEvents.getMap().get("HotX"));
                        irTempetureWarningParams.highyRatio = Float.parseFloat(cameraEvents.getMap().get("HotY"));
                        irTempetureWarningParams.lowxRatio = Float.parseFloat(cameraEvents.getMap().get("ColdX"));
                        irTempetureWarningParams.lowyRatio = Float.parseFloat(cameraEvents.getMap().get("ColdY"));
                        callbackWithOneParam.onSuccess(irTempetureWarningParams);
                    }
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            BaseCameraRequest.instance().removeCameraEventsListener(AutelListenerManager.TemperatureWarningListener);
        }
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
        this.cameraRequest.setSettingChangedListener(callbackWithOneParam);
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
                    if (!CameraXT706Impl.this.sdCardStatus.equalsIgnoreCase(cameraSystemStatus.getMMCStatus())) {
                        String unused = CameraXT706Impl.this.sdCardStatus = cameraSystemStatus.getSDCardStatus();
                        callbackWithOneParam.onSuccess(MMCState.find(cameraSystemStatus.getMMCStatus()));
                    }
                }
            });
            return;
        }
        BaseCameraRequest.instance().removeCameraEventsListener("setFMCardStateListener");
    }

    public void setInfoListener(final CallbackWithOneParam<XT706CameraInfo> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            this.cameraRequest.addCameraSystemStatusListener(MediaInfoTag, (CallbackWithOneParam<CameraSystemStatus>) null);
        } else {
            this.cameraRequest.addCameraSystemStatusListener(MediaInfoTag, new CallbackWithOneParam<CameraSystemStatus>() {
                public void onSuccess(final CameraSystemStatus cameraSystemStatus) {
                    callbackWithOneParam.onSuccess(new XT706CameraInfo() {
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

                        public SDCardState getSDCardState() {
                            return SDCardState.find(cameraSystemStatus.getSDCardStatus());
                        }

                        public MMCState getMMCState() {
                            return MMCState.find(CameraXB015Data.instance().getMMCStatus());
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

                        public float getAverageTemperature() {
                            return cameraSystemStatus.getAverageTemp();
                        }

                        public float getCenterTemperature() {
                            return cameraSystemStatus.getCenterTemp();
                        }

                        public float getHighTemperature() {
                            return cameraSystemStatus.getHotTemp();
                        }

                        public float getHighX() {
                            return cameraSystemStatus.getHotX();
                        }

                        public float getHighY() {
                            return cameraSystemStatus.getHotY();
                        }

                        public float getLowTemperature() {
                            return cameraSystemStatus.getColdTemp();
                        }

                        public float getLowX() {
                            return cameraSystemStatus.getColdX();
                        }

                        public float getLowY() {
                            return cameraSystemStatus.getColdY();
                        }

                        public float getTouchTemperature() {
                            return cameraSystemStatus.getTouchTemp();
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

    public void setIrColor(IrColor irColor, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setIrColor(irColor, callbackWithNoParam);
    }

    public void getIrColor(final CallbackWithOneParam<IrColor> callbackWithOneParam) {
        this.cameraRequest.getIrColor(new CallbackWithOneParam<IrColor>() {
            public void onSuccess(IrColor irColor) {
                CameraXB015Data.instance().setIrColor(irColor.value());
                callbackWithOneParam.onSuccess(irColor);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setIrPosition(IrPosition irPosition, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setIrPosition(irPosition, callbackWithNoParam);
    }

    public void getIrPosition(final CallbackWithOneParam<IrPosition> callbackWithOneParam) {
        this.cameraRequest.getIrPosition(new CallbackWithOneParam<IrPosition>() {
            public void onSuccess(IrPosition irPosition) {
                CameraXB015Data.instance().setIrPosition(irPosition);
                callbackWithOneParam.onSuccess(irPosition);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setHDREnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.cameraRequest.setHDREnable(z, callbackWithNoParam);
        }
    }

    public void getHDREnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getHDRSetting(callbackWithOneParam);
        }
    }

    public void setDeFogEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.cameraRequest.setDeFogEnable(z, callbackWithNoParam);
        }
    }

    public void setDeFogStrength(int i, CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.cameraRequest.setDeFogStrength(i, callbackWithNoParam);
        }
    }

    public void getDeFogParams(CallbackWithOneParam<DeFogParam> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getDeFogParams(callbackWithOneParam);
        }
    }

    public void setImageRoiEnable(final boolean z, final CallbackWithNoParam callbackWithNoParam) {
        if (callbackWithNoParam != null) {
            this.cameraRequest.setImageRoiEnable(z, new CallbackWithNoParam() {
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
            this.cameraRequest.setImageRoiStrength(i, new CallbackWithNoParam() {
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
            this.cameraRequest.setImageRoiArea(i, i2, callbackWithNoParam);
        }
    }

    public void getImageRoiParams(final CallbackWithOneParam<ImageRoiParam> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraRequest.getImageRoiParams(new CallbackWithOneParam<ImageRoiParam>() {
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

    public void setFocusMFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setFocusMFSpotArea(i, i2, callbackWithNoParam);
    }

    public void getFocusMFSpotArea(final CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.cameraRequest.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
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

    public void setIrFlushShutter(CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setIrFlushShutter(callbackWithNoParam);
    }

    public void setIrTemperatureParams(IrTemperatureParams irTemperatureParams, CallbackWithNoParam callbackWithNoParam) {
        this.httpRequest.setIrTemperatureParams(irTemperatureParams, callbackWithNoParam);
    }

    public void getIrTemperatureParams(final CallbackWithOneParam<IrTemperatureParams> callbackWithOneParam) {
        this.httpRequest.getIrTemperatureParams(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                if (callbackWithOneParam != null) {
                    IrTemperatureParams irTemperatureParams = new IrTemperatureParams();
                    try {
                        JSONObject jSONObject = new JSONObject(baseCameraMsgParser.getParam("result"));
                        irTemperatureParams.temperatureMode = IrTemperatureMode.find(jSONObject.getString(CameraParamsConfig.param_TempMode));
                        irTemperatureParams.touchxRatio = (float) jSONObject.getDouble(CameraParamsConfig.param_TouchX);
                        irTemperatureParams.touchyRatio = (float) jSONObject.getDouble(CameraParamsConfig.param_TouchY);
                        irTemperatureParams.xRatio = (float) jSONObject.getDouble(CameraParamsConfig.param_RegionX);
                        irTemperatureParams.yRatio = (float) jSONObject.getDouble(CameraParamsConfig.param_RegionY);
                        irTemperatureParams.widthRatio = (float) jSONObject.getDouble(CameraParamsConfig.param_RegionW);
                        irTemperatureParams.heightRatio = (float) jSONObject.getDouble(CameraParamsConfig.param_RegionH);
                        callbackWithOneParam.onSuccess(irTemperatureParams);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                        if (callbackWithOneParam != null) {
                            callbackWithOneParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
                        }
                    }
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

    public void setIrTemperatureWarningParams(IrTemperatureWarnParams irTemperatureWarnParams, CallbackWithNoParam callbackWithNoParam) {
        this.httpRequest.setIrTemperatureWarningParams(irTemperatureWarnParams, callbackWithNoParam);
    }

    public void getIrTemperatureWarningParams(final CallbackWithOneParam<IrTemperatureWarnParams> callbackWithOneParam) {
        this.httpRequest.getIrTemperatureWarningParams(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                if (callbackWithOneParam != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(baseCameraMsgParser.getParam("result"));
                        IrTemperatureWarnParams irTemperatureWarnParams = new IrTemperatureWarnParams();
                        boolean z = true;
                        if (jSONObject.getInt(CameraParamsConfig.param_Enable) != 1) {
                            z = false;
                        }
                        irTemperatureWarnParams.enable = z;
                        irTemperatureWarnParams.highTemperature = jSONObject.getInt(CameraParamsConfig.param_HotThred) / 10;
                        irTemperatureWarnParams.lowTemperature = jSONObject.getInt(CameraParamsConfig.param_ColdThred) / 10;
                        callbackWithOneParam.onSuccess(irTemperatureWarnParams);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                        if (callbackWithOneParam != null) {
                            callbackWithOneParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
                        }
                    }
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

    public void setIrTemperatureEmit(int i, CallbackWithNoParam callbackWithNoParam) {
        this.httpRequest.setIrTemperatureEmit(i, callbackWithNoParam);
    }

    public void getIrTemperatureEmit(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.httpRequest.getIrTemperatureEmit(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                if (callbackWithOneParam != null) {
                    try {
                        callbackWithOneParam.onSuccess(Integer.valueOf(new JSONObject(baseCameraMsgParser.getParam("result")).getInt(CameraParamsConfig.param_Emit)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        callbackWithOneParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
                    }
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

    public void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setMotionDelayShotInterval(i, callbackWithNoParam);
    }

    public void getMotionDelayShotInterval(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.cameraRequest.getMotionDelayShotInterval(callbackWithOneParam);
    }

    public void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setMotionDelayShotDuration(i, callbackWithNoParam);
    }

    public void getMotionDelayShotDuration(CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.cameraRequest.getMotionDelayShotDuration(callbackWithOneParam);
    }

    public void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam) {
        this.cameraRequest.setMotionDelayShotKeepPhoto(rawFormat, callbackWithNoParam);
    }

    public void getMotionDelayShotKeepPhoto(CallbackWithOneParam<MotionPhotoInfo> callbackWithOneParam) {
        this.cameraRequest.getMotionDelayShotKeepPhoto(callbackWithOneParam);
    }

    public XT706ParameterRangeManager getParameterRangeManager() {
        if (this.XT706ParameterRangeManager == null) {
            this.XT706ParameterRangeManager = new XT706ParameterRangeManagerImpl();
        }
        return this.XT706ParameterRangeManager;
    }
}
