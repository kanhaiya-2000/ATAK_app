package com.autel.camera.protocol.protocol20.xt705;

import com.autel.bean.camera.CameraAllSettings;
import com.autel.bean.camera.CameraSystemStatus;
import com.autel.bean.camera.Histogram;
import com.autel.camera.protocol.protocol20.base.BaseCamera20;
import com.autel.camera.protocol.protocol20.entity.CameraParamsConfig;
import com.autel.camera.protocol.protocol20.entity.DehazeSetting;
import com.autel.camera.protocol.protocol20.entity.ImageRoiSetting;
import com.autel.camera.protocol.protocol20.entity.ShutterInternal;
import com.autel.camera.protocol.protocol20.entity.TrackingStatus;
import com.autel.camera.protocol.protocol20.interfaces.CameraXT705;
import com.autel.camera.protocol.protocol20.request.BaseCameraRequest;
import com.autel.camera.protocol.protocol20.request.CameraHttpRequest;
import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.base.HDRStatus;
import com.autel.common.camera.base.ISOMode;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MotionPhotoInfo;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.DeFogParam;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.ImageRoiParam;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.LensFocusStatus;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.SaveLocation;
import com.autel.common.camera.media.ShutterMode;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoEncoderConfiguration;
import com.autel.common.camera.media.VideoRotation;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.common.camera.visual.TrackMode;
import com.autel.common.camera.visual.TrackState;
import com.autel.common.camera.visual.TrackStateInfo;
import com.autel.common.camera.visual.TrackingTarget;
import com.autel.common.camera.xb015.PIVMode;
import com.autel.common.error.AutelError;
import com.autel.internal.sdk.camera.BaseCameraMsgParser;
import com.autel.internal.sdk.camera.data.model.CameraXB015Data;
import com.autel.internal.sdk.camera.xb008.FileNamingMode;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.autel.camera.protocol.protocol20.xt705.XT705 */
public class C2508XT705 extends BaseCamera20 implements CameraXT705 {
    private CameraHttpRequest request = new CameraHttpRequest();

    public void addCameraSystemStatusListener(String str, CallbackWithOneParam<CameraSystemStatus> callbackWithOneParam) {
        if (callbackWithOneParam == null) {
            BaseCameraRequest.instance().removeCameraSystemStatusListener(str);
        } else {
            BaseCameraRequest.instance().addCameraSystemStatusListener(str, callbackWithOneParam);
        }
    }

    public void setShutterMode(ShutterMode shutterMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setShutterMode(shutterMode, callbackWithNoParam);
    }

    public void getShutterMode(final CallbackWithOneParam<ShutterMode> callbackWithOneParam) {
        this.request.getShutterMode(new CallbackWithOneParam<ShutterInternal>() {
            public void onSuccess(ShutterInternal shutterInternal) {
                callbackWithOneParam.onSuccess(ShutterMode.find(shutterInternal.getType()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setAFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setCameraAFAssistFocusEnable(z ? 1 : 0, callbackWithNoParam);
    }

    public void setMFAssistFocusEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setCameraMFAssistFocusEnable(z ? 1 : 0, callbackWithNoParam);
    }

    public void takePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        BaseCameraRequest.instance().takePhoto(1, callbackWithNoParam);
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
                } else {
                    callbackWithOneParam.onSuccess(autoSnapshot.getEnable() == 1 ? PIVMode.Auto : PIVMode.Manual);
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setTrackingGoalArea(TrackingTarget trackingTarget, CallbackWithNoParam callbackWithNoParam) {
        this.request.setTrackingGoalArea(trackingTarget, callbackWithNoParam);
    }

    public void cancelTracking(CallbackWithNoParam callbackWithNoParam) {
        this.request.stopTracking(callbackWithNoParam);
    }

    public void setTrackingMode(TrackMode trackMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setTrackingMode(trackMode.getValue(), callbackWithNoParam);
    }

    public void getTrackingState(final CallbackWithOneParam<TrackStateInfo> callbackWithOneParam) {
        this.request.getTrackingMode(new CallbackWithOneParam<TrackingStatus>() {
            public void onSuccess(TrackingStatus trackingStatus) {
                TrackStateInfo trackStateInfo = new TrackStateInfo();
                trackStateInfo.trackMode = TrackMode.find(trackingStatus.getAction());
                trackStateInfo.trackState = TrackState.find(trackingStatus.getState());
                callbackWithOneParam.onSuccess(trackStateInfo);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setProductSubtitleSNEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setProduceParametersEnable(z ? 1 : 0, callbackWithNoParam);
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

    public void setAlbumSaveLocation(final SaveLocation saveLocation, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAlbumSaveLocation(saveLocation, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setStorageType(saveLocation.getValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getAlbumLocation(CallbackWithOneParam<CameraAllSettings.StorageType> callbackWithOneParam) {
        this.request.getAlbumLocation(callbackWithOneParam);
    }

    public void getFMCStatus(CallbackWithOneParam<CameraAllSettings.MMCStatus> callbackWithOneParam) {
        this.request.getFMCStatus(callbackWithOneParam);
    }

    public void formatFlashMemoryCard(CallbackWithNoParam callbackWithNoParam) {
        this.request.formatFMC(callbackWithNoParam);
    }

    public void setHDREnable(final boolean z, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setHDREnable(z ? HDRStatus.Enable : HDRStatus.Disable, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setHdrStatus(z ? HDRStatus.Enable : HDRStatus.Disable);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getHDRSetting(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.request.getHDREnable(new CallbackWithOneParam<CameraAllSettings.HDRSetting>() {
            public void onSuccess(CameraAllSettings.HDRSetting hDRSetting) {
                CameraXB015Data.instance().setHdrStatus(hDRSetting.getValue().equals(CameraParamsConfig.param_Enable) ? HDRStatus.Enable : HDRStatus.Disable);
                callbackWithOneParam.onSuccess(Boolean.valueOf(hDRSetting.getValue().equals(CameraParamsConfig.param_Enable)));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setDeFogEnable(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setDehazeEnable(z, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setDeFogStrength(int i, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setDehazeStrength(i, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getDeFogParams(final CallbackWithOneParam<DeFogParam> callbackWithOneParam) {
        this.request.getDehazeSetting(new CallbackWithOneParam<DehazeSetting>() {
            public void onSuccess(final DehazeSetting dehazeSetting) {
                callbackWithOneParam.onSuccess(new DeFogParam() {
                    public boolean isEnable() {
                        return dehazeSetting.getStatus().equals(CameraParamsConfig.param_Enable);
                    }

                    public int getStrength() {
                        return dehazeSetting.getStrength();
                    }
                });
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setImageRoiEnable(boolean z, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setImageRoiEnable(z, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setImageRoiStrength(int i, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setImageRoiStrength(i, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setImageRoiArea(int i, int i2, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setImageRoiSettingParams(i, i2, new CallbackWithNoParam() {
            public void onSuccess() {
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getImageRoiParams(final CallbackWithOneParam<ImageRoiParam> callbackWithOneParam) {
        this.request.getImageRoiSetting(new CallbackWithOneParam<ImageRoiSetting>() {
            public void onSuccess(final ImageRoiSetting imageRoiSetting) {
                callbackWithOneParam.onSuccess(new ImageRoiParam() {
                    public boolean isEnable() {
                        return imageRoiSetting.getStatus().equals(CameraParamsConfig.param_Enable);
                    }

                    public int getStrength() {
                        if (imageRoiSetting.getRoiRegion() == null || imageRoiSetting.getRoiRegion().size() <= 0) {
                            return 0;
                        }
                        return imageRoiSetting.getRoiRegion().get(0).getStrength();
                    }
                });
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

    public void setHistogramListener(final CallbackWithOneParam<int[]> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.request.setHistogramListener(new CallbackWithOneParam<Histogram>() {
                public void onSuccess(Histogram histogram) {
                    callbackWithOneParam.onSuccess(histogram.getHistogramData());
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        } else {
            this.request.setHistogramListener((CallbackWithOneParam<Histogram>) null);
        }
    }

    public void setAutoFocusStateListener(CallbackWithTwoParams<LensFocusStatus, List<SpotMeteringArea>> callbackWithTwoParams) {
        this.request.setAutoFocusStateListener("setAutoFocusStateListener", callbackWithTwoParams);
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setSpotMeteringArea(i, i2, callbackWithNoParam);
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        this.request.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
    }

    public void setExposure(final ExposureCompensation exposureCompensation, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposure(exposureCompensation, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setImageExposure(Double.parseDouble(exposureCompensation.getValue20()));
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setISO(final CameraISO cameraISO, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setISO(cameraISO, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setImageISO(Integer.valueOf(cameraISO.getValue()).intValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setShutter(final ShutterSpeed shutterSpeed, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setShutter(shutterSpeed, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setShutter(shutterSpeed.getValue());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getColorStyle(final CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        this.request.getColorStyle(new CallbackWithOneParam<CameraAllSettings.ImageColor>() {
            public void onSuccess(CameraAllSettings.ImageColor imageColor) {
                CameraXB015Data.instance().setImageColor(imageColor.getColor());
                callbackWithOneParam.onSuccess(ColorStyle.find(imageColor.getColor()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setWhiteBalance(final WhiteBalance whiteBalance, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setWhiteBalance(whiteBalance, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setWhiteBalanceMode(whiteBalance.type.value20());
                CameraXB015Data.instance().setWBColorTemperature(whiteBalance.colorTemperature);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setColorStyle(final ColorStyle colorStyle, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setColorStyle(colorStyle, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setImageColor(colorStyle.value20());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.set3DNoiseReductionEnable(z, callbackWithNoParam);
    }

    public void setAntiFlicker(final AntiFlicker antiFlicker, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setAntiFlicker(antiFlicker, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAntiFlicker(antiFlicker.value20());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getAutoExposureLockState(final CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        this.request.getAutoExposureLockState(new CallbackWithOneParam<CameraAllSettings.AELock>() {
            public void onSuccess(CameraAllSettings.AELock aELock) {
                callbackWithOneParam.onSuccess(AutoExposureLockState.find((aELock.getLocked() == 1 ? AutoExposureLockState.LOCK : AutoExposureLockState.UNLOCK).value()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getSpotMeteringArea(final CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.request.getSpotMeteringArea(new CallbackWithOneParam<CameraAllSettings.LocationMeter>() {
            public void onSuccess(CameraAllSettings.LocationMeter locationMeter) {
                SpotMeteringArea spotMeteringArea = new SpotMeteringArea();
                spotMeteringArea.f8467X = locationMeter.getX();
                spotMeteringArea.f8468Y = locationMeter.getY();
                callbackWithOneParam.onSuccess(spotMeteringArea);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getAntiFlicker(final CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        this.request.getAntiFlicker(new CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration>() {
            public void onSuccess(CameraAllSettings.VideoSourceConfiguration videoSourceConfiguration) {
                callbackWithOneParam.onSuccess(AntiFlicker.find(videoSourceConfiguration.getAntiFlicker()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getWhiteBalance(final CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        this.request.getWhiteBalance(new CallbackWithOneParam<CameraAllSettings.WhiteBalance>() {
            public void onSuccess(CameraAllSettings.WhiteBalance whiteBalance) {
                WhiteBalance whiteBalance2 = new WhiteBalance();
                whiteBalance2.type = WhiteBalanceType.find(whiteBalance.getMode());
                whiteBalance2.colorTemperature = whiteBalance.getColorTemperature();
                callbackWithOneParam.onSuccess(whiteBalance2);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getExposure(final CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        this.request.getExposure(new CallbackWithOneParam<CameraAllSettings.ImageExposure>() {
            public void onSuccess(CameraAllSettings.ImageExposure imageExposure) {
                callbackWithOneParam.onSuccess(ExposureCompensation.find(String.valueOf(imageExposure.getExposure())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getShutter(final CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        this.request.getShutter(new CallbackWithOneParam<CameraAllSettings.ShutterSpeed>() {
            public void onSuccess(CameraAllSettings.ShutterSpeed shutterSpeed) {
                callbackWithOneParam.onSuccess(ShutterSpeed.find(shutterSpeed.getShutter()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getISO(final CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        this.request.getISO(new CallbackWithOneParam<CameraAllSettings.ImageISO>() {
            public void onSuccess(CameraAllSettings.ImageISO imageISO) {
                callbackWithOneParam.onSuccess(CameraISO.find(String.valueOf(imageISO.getISO())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getExposureMode(final CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        this.request.getExposureMode(new CallbackWithOneParam<CameraAllSettings.CameraGear>() {
            public void onSuccess(CameraAllSettings.CameraGear cameraGear) {
                CameraXB015Data.instance().setCameraGear(cameraGear.getGear());
                callbackWithOneParam.onSuccess(ExposureMode.find(cameraGear.getGear()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoStyle(photoStyleType, callbackWithNoParam);
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        this.request.setCameraCustomPhotoStyle(i, i2, i3, callbackWithNoParam);
    }

    public void isHistogramStatusEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.request.isHistogramStatusEnable(new CallbackWithOneParam<CameraAllSettings.HistogramSettings>() {
            public void onSuccess(CameraAllSettings.HistogramSettings histogramSettings) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                boolean z = true;
                if (histogramSettings.getEnable() != 1) {
                    z = false;
                }
                callbackWithOneParam.onSuccess(Boolean.valueOf(z));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoSubtitleEnable(z, callbackWithNoParam);
    }

    public void isSubtitleEnable(final CallbackWithOneParam<Boolean> callbackWithOneParam) {
        this.request.isSubtitleEnable(new CallbackWithOneParam<CameraAllSettings.RecordingSettings>() {
            public void onSuccess(CameraAllSettings.RecordingSettings recordingSettings) {
                CallbackWithOneParam callbackWithOneParam = callbackWithOneParam;
                boolean z = true;
                if (recordingSettings.getEnableSubtitle() != 1) {
                    z = false;
                }
                callbackWithOneParam.onSuccess(Boolean.valueOf(z));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoStyle(final CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        this.request.getPhotoStyle(new CallbackWithOneParam<CameraAllSettings.ImageStyle>() {
            public void onSuccess(CameraAllSettings.ImageStyle imageStyle) {
                PhotoStyle photoStyle = new PhotoStyle();
                photoStyle.contrast = imageStyle.getContrast();
                photoStyle.brightness = imageStyle.getBrightness();
                photoStyle.hue = imageStyle.getHue();
                photoStyle.saturation = imageStyle.getSaturation();
                photoStyle.sharpness = imageStyle.getSharpness();
                photoStyle.type = PhotoStyleType.find(imageStyle.getStyle());
                callbackWithOneParam.onSuccess(photoStyle);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setCameraAperture(CameraAperture cameraAperture, CallbackWithNoParam callbackWithNoParam) {
        this.request.setIRIS(cameraAperture, callbackWithNoParam);
    }

    public void getCameraAperture(final CallbackWithOneParam<CameraAperture> callbackWithOneParam) {
        this.request.getIRIS(new CallbackWithOneParam<CameraAllSettings.IRIS>() {
            public void onSuccess(CameraAllSettings.IRIS iris) {
                double irisValue = iris.getIrisValue();
                if (irisValue >= 10.0d) {
                    callbackWithOneParam.onSuccess(CameraAperture.find(String.valueOf(irisValue)));
                } else {
                    callbackWithOneParam.onSuccess(CameraAperture.find(String.valueOf(iris.getIrisValue())));
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setFocusMode(final LensFocusMode lensFocusMode, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setFocusMode(lensFocusMode, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setFocusMode(lensFocusMode.value());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setExposureMode(final ExposureMode exposureMode, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setExposureMode(exposureMode, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setCameraGear(exposureMode.value20());
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getFocusMode(final CallbackWithOneParam<LensFocusMode> callbackWithOneParam) {
        this.request.getFocusMode(new CallbackWithOneParam<CameraAllSettings.Focus>() {
            public void onSuccess(CameraAllSettings.Focus focus) {
                callbackWithOneParam.onSuccess(LensFocusMode.find(focus.getMode()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getFocusDistance(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getFocusDistance(new CallbackWithOneParam<CameraAllSettings.Focus>() {
            public void onSuccess(CameraAllSettings.Focus focus) {
                CameraXB015Data.instance().setFocusMode(focus.getMode());
                CameraXB015Data.instance().setObjectDistance(focus.getObjectDistance());
                callbackWithOneParam.onSuccess(Integer.valueOf(focus.getObjectDistance()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getColorTemperature(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getColorTemperature(new CallbackWithOneParam<CameraAllSettings.WhiteBalance>() {
            public void onSuccess(CameraAllSettings.WhiteBalance whiteBalance) {
                callbackWithOneParam.onSuccess(Integer.valueOf(whiteBalance.getColorTemperature()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getDigitalZoomScale(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getDigitalZoomScale(new CallbackWithOneParam<CameraAllSettings.ZoomFactor>() {
            public void onSuccess(CameraAllSettings.ZoomFactor zoomFactor) {
                callbackWithOneParam.onSuccess(Integer.valueOf(zoomFactor.getZoomValue()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setDigitalZoomScale(i, callbackWithNoParam);
    }

    public void setPhotoAutoFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setPhotoAutoFocusMeter(i, i2, callbackWithNoParam);
    }

    public void setManualFocusMeter(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setManualFocusMeter(i, i2, callbackWithNoParam);
    }

    public void setManualFocusDistance(final int i, final CallbackWithNoParam callbackWithNoParam) {
        this.request.setManualFocusDistance(i, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setFocusMode(LensFocusMode.MANUAL_FOCUS.value());
                CameraXB015Data.instance().setObjectDistance(i);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void startTakePhotoWithFocus(CallbackWithNoParam callbackWithNoParam) {
        this.request.startTakePhotoWithFocus(callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, final CallbackWithNoParam callbackWithNoParam) {
        if (PhotoBurstCount.UNKNOWN == photoBurstCount) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            return;
        }
        final int intValue = Integer.valueOf(photoBurstCount.value20()).intValue();
        this.request.setPhotoBurstCount(intValue, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setBurstNumPerSecond(intValue);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, final CallbackWithNoParam callbackWithNoParam) {
        if (photoTimelapseInterval == PhotoTimelapseInterval.UNKNOWN) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            return;
        }
        final int intValue = Integer.valueOf(photoTimelapseInterval.value20()).intValue();
        this.request.setPhotoTimelapseInterval(intValue, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setTimelapseInterval(intValue);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, final CallbackWithNoParam callbackWithNoParam) {
        if (PhotoAEBCount.UNKNOWN == photoAEBCount) {
            callbackWithNoParam.onFailure(AutelError.COMMAND_FAILED);
            return;
        }
        final int intValue = Integer.valueOf(photoAEBCount.value20()).intValue();
        this.request.setPhotoAEBCount(intValue, new CallbackWithNoParam() {
            public void onSuccess() {
                CameraXB015Data.instance().setAebNumPerSecond(intValue);
                callbackWithNoParam.onSuccess();
            }

            public void onFailure(AutelError autelError) {
                callbackWithNoParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoAEBCount(final CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                callbackWithOneParam.onSuccess(PhotoAEBCount.find(String.valueOf(photoTakingSettings.getAEBModeSettings().getNumPhotosAtOnce())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoBurstCount(final CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                callbackWithOneParam.onSuccess(PhotoBurstCount.find(String.valueOf(photoTakingSettings.getBurstModeSettings().getNumPhotosPerSecond())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getPhotoTimelapseInterval(final CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        getPhotoTakingSettings(new CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings>() {
            public void onSuccess(CameraAllSettings.PhotoTakingSettings photoTakingSettings) {
                callbackWithOneParam.onSuccess(PhotoTimelapseInterval.find(String.valueOf(photoTakingSettings.getTimelapseModeSettings().getInterval())));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getVideoEncoderConfiguration(int i, CallbackWithOneParam<CameraAllSettings.VideoEncoderConfiguration> callbackWithOneParam) {
        this.request.getVideoEncoderConfiguration(i, callbackWithOneParam);
    }

    public void getPhotoTakingSettings(CallbackWithOneParam<CameraAllSettings.PhotoTakingSettings> callbackWithOneParam) {
        this.request.getPhotoTakingSettings(callbackWithOneParam);
    }

    public void getRecordingSettings(CallbackWithOneParam<CameraAllSettings.RecordingSettings> callbackWithOneParam) {
        this.request.getRecordingSettings(callbackWithOneParam);
    }

    public void getVideoSourceConfiguration(CallbackWithOneParam<CameraAllSettings.VideoSourceConfiguration> callbackWithOneParam) {
        this.request.getVideoSourceConfiguration(callbackWithOneParam);
    }

    public void getVideoSourceConfigurationOptions(CallbackWithOneParam<CameraAllSettings.VideoSourceConfigurationOptions> callbackWithOneParam) {
        this.request.getVideoSourceConfigurationOptions(callbackWithOneParam);
    }

    public void getCameraFocus(final CallbackWithOneParam<CameraAllSettings.Focus> callbackWithOneParam) {
        this.request.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
            public void onSuccess(CameraAllSettings.Focus focus) {
                CameraXB015Data.instance().setFocusMode(focus.getMode());
                CameraXB015Data.instance().setAFAssistFocusEnable(focus.getAFAssistFocusEnable());
                CameraXB015Data.instance().setMFAssistFocusEnable(focus.getMFAssistFocusEnable());
                CameraXB015Data.instance().setObjectDistance(focus.getObjectDistance());
                callbackWithOneParam.onSuccess(focus);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getFocusAFSpotArea(final CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        this.request.getCameraFocus(new CallbackWithOneParam<CameraAllSettings.Focus>() {
            public void onSuccess(CameraAllSettings.Focus focus) {
                SpotMeteringArea spotMeteringArea = new SpotMeteringArea();
                spotMeteringArea.f8467X = focus.getAFMeter().getSpotArea().get(0).getX();
                spotMeteringArea.f8468Y = focus.getAFMeter().getSpotArea().get(0).getY();
                callbackWithOneParam.onSuccess(spotMeteringArea);
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getCameraMode(final CallbackWithOneParam<MediaMode> callbackWithOneParam) {
        this.request.getCameraMode(new CallbackWithOneParam<CameraAllSettings.CameraMode>() {
            public void onSuccess(CameraAllSettings.CameraMode cameraMode) {
                callbackWithOneParam.onSuccess(MediaMode.find(cameraMode.getMode()));
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }

    public void getCameraAutoExposureState(CallbackWithOneParam<CameraAllSettings.AELock> callbackWithOneParam) {
        this.request.getCameraAutoExposureState(callbackWithOneParam);
    }

    public void setFocusAFSpotArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFocusAFSpotArea(i, i2, callbackWithNoParam);
    }

    public void setFileNamingMode(FileNamingMode fileNamingMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setFileNamingMode(fileNamingMode.getValue(), callbackWithNoParam);
    }

    public void setVideoRotation(VideoRotation videoRotation, CallbackWithNoParam callbackWithNoParam) {
        this.request.setVideoSourceConfiguration(videoRotation.getValue(), callbackWithNoParam);
    }

    public void setVideoEncoderConfiguration(int i, VideoEncoderConfiguration videoEncoderConfiguration, CallbackWithNoParam callbackWithNoParam) {
        CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration2 = new CameraAllSettings.VideoEncoderConfiguration();
        if (videoEncoderConfiguration.getEncoding() != null) {
            videoEncoderConfiguration2.setEncoding(videoEncoderConfiguration.getEncoding().getValue());
        }
        if (videoEncoderConfiguration.getVideoResolutionAndFps() != null) {
            videoEncoderConfiguration2.setResolution(videoEncoderConfiguration.getVideoResolutionAndFps().toString());
        }
        this.request.setVideoEncoderConfiguration(i, videoEncoderConfiguration2, callbackWithNoParam);
    }

    public void startMotionDelayShot(CallbackWithNoParam callbackWithNoParam) {
        this.request.startMotionDelayShot(callbackWithNoParam);
    }

    public void stopMotionDelayShot(CallbackWithNoParam callbackWithNoParam) {
        this.request.stopMotionDelayShot(callbackWithNoParam);
    }

    public void pauseMotionDelayShot(CallbackWithNoParam callbackWithNoParam) {
        this.request.pauseMotionDelayShot(callbackWithNoParam);
    }

    public void resumeMotionDelayShot(CallbackWithNoParam callbackWithNoParam) {
        this.request.resumeMotionDelayShot(callbackWithNoParam);
    }

    public void setMotionDelayShotInterval(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setMotionDelayShotInterval(i, callbackWithNoParam);
    }

    public void getMotionDelayShotInterval(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getMotionDelayShotInterval(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                if (callbackWithOneParam != null) {
                    try {
                        callbackWithOneParam.onSuccess(Integer.valueOf(new JSONObject(baseCameraMsgParser.getParam("result")).getInt(CameraParamsConfig.param_Interval)));
                    } catch (JSONException e) {
                        e.printStackTrace();
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

    public void setMotionDelayShotDuration(int i, CallbackWithNoParam callbackWithNoParam) {
        this.request.setMotionDelayShotDuration(i, callbackWithNoParam);
    }

    public void getMotionDelayShotDuration(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        this.request.getMotionDelayShotDuration(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                if (callbackWithOneParam != null) {
                    try {
                        callbackWithOneParam.onSuccess(Integer.valueOf(new JSONObject(baseCameraMsgParser.getParam("result")).getInt(CameraParamsConfig.param_Duration)));
                    } catch (JSONException e) {
                        e.printStackTrace();
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

    public void setMotionDelayShotKeepPhoto(RawFormat rawFormat, CallbackWithNoParam callbackWithNoParam) {
        this.request.setMotionDelayShotKeepPhoto(rawFormat, callbackWithNoParam);
    }

    public void getMotionDelayShotKeepPhoto(final CallbackWithOneParam<MotionPhotoInfo> callbackWithOneParam) {
        this.request.getMotionDelayShotKeepPhoto(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(final BaseCameraMsgParser baseCameraMsgParser) {
                if (baseCameraMsgParser != null) {
                    callbackWithOneParam.onSuccess(new MotionPhotoInfo() {
                        public boolean isEnable() {
                            try {
                                if (new JSONObject(baseCameraMsgParser.getParam("result")).getInt(CameraParamsConfig.param_Enable) == 1) {
                                    return true;
                                }
                                return false;
                            } catch (JSONException e) {
                                e.printStackTrace();
                                return false;
                            }
                        }

                        public RawFormat getRawFormat() {
                            try {
                                return RawFormat.find(new JSONObject(baseCameraMsgParser.getParam("result")).getString(CameraParamsConfig.param_PicType));
                            } catch (JSONException e) {
                                e.printStackTrace();
                                return RawFormat.UNKNOWN;
                            }
                        }
                    });
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

    public void setISOMode(ISOMode iSOMode, CallbackWithNoParam callbackWithNoParam) {
        this.request.setISOMode(iSOMode, callbackWithNoParam);
    }

    public void getISOMode(final CallbackWithOneParam<ISOMode> callbackWithOneParam) {
        this.request.getISOMode(new CallbackWithOneParam<BaseCameraMsgParser>() {
            public void onSuccess(BaseCameraMsgParser baseCameraMsgParser) {
                if (callbackWithOneParam != null) {
                    try {
                        callbackWithOneParam.onSuccess(ISOMode.find(new JSONObject(baseCameraMsgParser.getParam("result")).getString("Mode")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        callbackWithOneParam.onFailure(AutelError.COMMON_PARSER_PARAMETER_FAILED);
                    }
                }
            }

            public void onFailure(AutelError autelError) {
                callbackWithOneParam.onFailure(autelError);
            }
        });
    }
}
