package com.autel.internal.camera.r12;

import com.autel.camera.protocol.protocol10.constant.CameraConstant10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraSettingWithParser10;
import com.autel.camera.protocol.protocol10.engine.AutelCameraStatusWithParser10;
import com.autel.camera.protocol.protocol10.engine.CameraEvents;
import com.autel.camera.protocol.protocol10.interfaces.r12.AutelR12Service;
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
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoSum;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.r12.R12CameraInfo;
import com.autel.common.camera.r12.R12ParameterRangeManager;
import com.autel.common.camera.r12.R12StateInfo;
import com.autel.common.error.AutelError;
import com.autel.internal.camera.BaseCamera10;
import com.autel.internal.sdk.camera.r12.R12CameraInfoImpl;
import com.autel.sdk.camera.p005rx.RxAutelR12;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraR12 extends BaseCamera10 implements CameraR12Service {
    private static final String MediaInfoTag = "MediaInfo";
    /* access modifiers changed from: private */
    public AutelR12Service cameraR12 = new com.autel.camera.protocol.protocol10.r12.CameraR12();
    /* access modifiers changed from: private */
    public R12CameraInfoImpl r12CameraInfo = new R12CameraInfoImpl();
    private R12ParameterRangeManagerImpl rangeManager;

    public RxAutelR12 toRx() {
        return null;
    }

    public void setInfoListener(final CallbackWithOneParam<R12CameraInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.addCameraEventsListener(MediaInfoTag, new CallbackWithOneParam<CameraEvents>() {
                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }

                public void onSuccess(CameraEvents cameraEvents) {
                    if (CameraConstant10.CAMERA_TYPE_CAMERA_EXPOSURE_PARAM.equals(cameraEvents.getType())) {
                        String param = cameraEvents.getParam();
                        HashMap hashMap = new HashMap();
                        try {
                            JSONArray jSONArray = new JSONArray(param);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                for (int i2 = 0; i2 < jSONObject.names().length(); i2++) {
                                    if (jSONObject.keys().hasNext()) {
                                        String str = (String) jSONObject.names().get(i2);
                                        hashMap.put(str, jSONObject.getString(str));
                                    }
                                }
                            }
                            CameraR12.this.r12CameraInfo.shutterSpeed = ShutterSpeed.find((String) hashMap.get("shutter"));
                            CameraR12.this.r12CameraInfo.iso = CameraISO.find((String) hashMap.get("iso"));
                            CameraR12.this.r12CameraInfo.exposureCompensation = AutelCameraSettingWithParser10.instance().getExposureValue();
                            AutelCameraSettingWithParser10.instance().setIso(CameraR12.this.r12CameraInfo.iso.getValue());
                            AutelCameraSettingWithParser10.instance().setShutter(CameraR12.this.r12CameraInfo.shutterSpeed.getValue());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        callbackWithOneParam.onSuccess(CameraR12.this.r12CameraInfo);
                    } else if (CameraConstant10.KEY_CAMERA_LUMABIAS.equals(cameraEvents.getType())) {
                        String param2 = cameraEvents.getParam();
                        CameraR12.this.r12CameraInfo.exposureCompensation = ExposureCompensation.find(param2);
                        CameraR12.this.r12CameraInfo.shutterSpeed = AutelCameraSettingWithParser10.instance().getCameraShutter();
                        CameraR12.this.r12CameraInfo.iso = AutelCameraSettingWithParser10.instance().getISO();
                        AutelCameraSettingWithParser10.instance().setEv(CameraR12.this.r12CameraInfo.exposureCompensation.getValue());
                        callbackWithOneParam.onSuccess(CameraR12.this.r12CameraInfo);
                    }
                }
            });
        } else {
            this.cameraR12.addCameraEventsListener(MediaInfoTag, (CallbackWithOneParam<CameraEvents>) null);
        }
    }

    public void setHistogramListener(CallbackWithOneParam<int[]> callbackWithOneParam) {
        this.cameraR12.setHistogramListener(callbackWithOneParam);
    }

    public void setSpotMeteringArea(int i, int i2, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setSpotMeteringArea(i, i2, callbackWithNoParam);
    }

    public void setAutoExposureLockState(AutoExposureLockState autoExposureLockState, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setAutoExposureLockState(autoExposureLockState, callbackWithNoParam);
    }

    public void setExposure(ExposureCompensation exposureCompensation, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setExposure(exposureCompensation, callbackWithNoParam);
    }

    public void setISO(CameraISO cameraISO, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setISO(cameraISO, callbackWithNoParam);
    }

    public void setShutter(ShutterSpeed shutterSpeed, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setShutter(shutterSpeed, callbackWithNoParam);
    }

    public void setWhiteBalance(WhiteBalance whiteBalance, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setWhiteBalance(whiteBalance, callbackWithNoParam);
    }

    public void setColorStyle(ColorStyle colorStyle, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setColorStyle(colorStyle, callbackWithNoParam);
    }

    public void set3DNoiseReductionEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.set3DNoiseReductionEnable(z, callbackWithNoParam);
    }

    public void is3DNoiseReductionEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.is3DNoiseReductionEnable(callbackWithOneParam);
        }
    }

    public void setAntiFlicker(AntiFlicker antiFlicker, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setAntiFlicker(antiFlicker, callbackWithNoParam);
    }

    public void getAutoExposureLockState(CallbackWithOneParam<AutoExposureLockState> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getAutoExposureLockState(callbackWithOneParam);
        }
    }

    public void getSpotMeteringArea(CallbackWithOneParam<SpotMeteringArea> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getSpotMeteringArea(callbackWithOneParam);
        }
    }

    public void getAntiFlicker(CallbackWithOneParam<AntiFlicker> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getAntiFlicker(callbackWithOneParam);
        }
    }

    public void getWhiteBalance(CallbackWithOneParam<WhiteBalance> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getWhiteBalance(callbackWithOneParam);
        }
    }

    public void getExposure(CallbackWithOneParam<ExposureCompensation> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getExposure(callbackWithOneParam);
        }
    }

    public void getShutter(CallbackWithOneParam<ShutterSpeed> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getShutter(callbackWithOneParam);
        }
    }

    public void getISO(CallbackWithOneParam<CameraISO> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getISO(callbackWithOneParam);
        }
    }

    public void isHistogramEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.isHistogramStatusEnable(callbackWithOneParam);
        }
    }

    public void getColorStyle(CallbackWithOneParam<ColorStyle> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getColorStyle(callbackWithOneParam);
        }
    }

    public void getExposureMode(CallbackWithOneParam<ExposureMode> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getExposureMode(callbackWithOneParam);
        }
    }

    public void setExposureMode(ExposureMode exposureMode, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setExposureMode(exposureMode, callbackWithNoParam);
    }

    public void setPhotoStyle(PhotoStyleType photoStyleType, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setPhotoStyle(photoStyleType, callbackWithNoParam);
    }

    public void setPhotoStyle(int i, int i2, int i3, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setPhotoStyle(i, i2, i3, callbackWithNoParam);
    }

    public void setVideoSubtitleEnable(boolean z, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setVideoSubtitleEnable(z, callbackWithNoParam);
    }

    public void setPhotoBurstCount(PhotoBurstCount photoBurstCount, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setPhotoBurstCount(photoBurstCount, callbackWithNoParam);
    }

    public void setPhotoTimelapseInterval(PhotoTimelapseInterval photoTimelapseInterval, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setPhotoTimelapseInterval(photoTimelapseInterval, callbackWithNoParam);
    }

    public void setPhotoAEBCount(PhotoAEBCount photoAEBCount, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setPhotoAEBCount(photoAEBCount, callbackWithNoParam);
    }

    public void isSubtitleEnable(CallbackWithOneParam<Boolean> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.isSubtitleEnable(callbackWithOneParam);
        }
    }

    public void getPhotoBurstCount(CallbackWithOneParam<PhotoBurstCount> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getPhotoBurstCount(callbackWithOneParam);
        }
    }

    public void getPhotoTimelapseInterval(CallbackWithOneParam<PhotoTimelapseInterval> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getPhotoTimelapseInterval(callbackWithOneParam);
        }
    }

    public void getLeftRecordTime(final CallbackWithOneParam<Long> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getVideoSum(new CallbackWithOneParam<VideoSum>() {
                public void onSuccess(VideoSum videoSum) {
                    callbackWithOneParam.onSuccess(Long.valueOf(videoSum.getLeftTime()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getPhotoSum(final CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getPhotoSum(new CallbackWithOneParam<PhotoSum>() {
                public void onSuccess(PhotoSum photoSum) {
                    callbackWithOneParam.onSuccess(Integer.valueOf(photoSum.getCount()));
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void getCurrentRecordTime(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getCurrentRecordTimeSeconds(callbackWithOneParam);
        }
    }

    public void getStateInfo(final CallbackWithOneParam<BaseStateInfo> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getCameraStatus(new CallbackWithOneParam<AutelCameraStatusWithParser10>() {
                public void onSuccess(final AutelCameraStatusWithParser10 autelCameraStatusWithParser10) {
                    CameraR12.this.cameraR12.getCameraSettings(new CallbackWithOneParam<AutelCameraSettingWithParser10>() {
                        public void onSuccess(final AutelCameraSettingWithParser10 autelCameraSettingWithParser10) {
                            callbackWithOneParam.onSuccess(new R12StateInfo() {
                                public ColorStyle getColorStyle() {
                                    return ColorStyle.find(autelCameraSettingWithParser10.getColor());
                                }

                                public WhiteBalance getWhiteBalance() {
                                    return autelCameraSettingWithParser10.getWhiteBalance();
                                }

                                public AutoExposureLockState getAutoExposureLockState() {
                                    return autelCameraSettingWithParser10.getAutoExposureLockState();
                                }

                                public boolean isHistogramEnable() {
                                    return autelCameraSettingWithParser10.isHistogramStatusEnable();
                                }

                                public ExposureMode getExposureMode() {
                                    return autelCameraSettingWithParser10.getExposureMode();
                                }

                                public PhotoStyle getPhotoStyle() {
                                    return autelCameraSettingWithParser10.getPhotoStyle();
                                }

                                public boolean isSubtitleEnable() {
                                    return autelCameraSettingWithParser10.isSubtitleSwitchEnable();
                                }

                                public AntiFlicker getAntiFlicker() {
                                    return autelCameraSettingWithParser10.getAntiFlicker();
                                }

                                public VideoStandard getVideoStandard() {
                                    return autelCameraSettingWithParser10.getVideoStandard();
                                }

                                public VideoFormat getVideoFormat() {
                                    return autelCameraSettingWithParser10.getVideoFormat();
                                }

                                public PhotoAspectRatio getPhotoAspectRatio() {
                                    return autelCameraSettingWithParser10.getAspectRatio();
                                }

                                public PhotoFormat getPhotoFormat() {
                                    return autelCameraSettingWithParser10.getPhotoFormat();
                                }

                                public int getDigitalZoomScale() {
                                    return autelCameraSettingWithParser10.getDigitalZoomScale();
                                }

                                public VideoResolutionAndFps getVideoResolutionAndFrameRate() {
                                    return autelCameraSettingWithParser10.getVideoResolution();
                                }

                                public PhotoBurstCount getBurstCount() {
                                    return autelCameraSettingWithParser10.getBurstNum();
                                }

                                public PhotoAEBCount getAEBCount() {
                                    return autelCameraSettingWithParser10.getAebNum();
                                }

                                public PhotoTimelapseInterval getTimelapseInterval() {
                                    return autelCameraSettingWithParser10.getTimelapseIntervalTime();
                                }

                                public CameraProduct getType() {
                                    return CameraProduct.R12;
                                }

                                public WorkState getWorkState() {
                                    return autelCameraStatusWithParser10.getCameraStatus();
                                }

                                public MediaMode getMediaMode() {
                                    return autelCameraStatusWithParser10.getCurrentMode();
                                }

                                public SDCardState getSDCardState() {
                                    return autelCameraStatusWithParser10.getSDCardStatus();
                                }

                                public GimbalLockState getGimbalLockState() {
                                    return GimbalLockState.UNLOCK;
                                }

                                public String toString() {
                                    return "getColorStyle : " + getColorStyle() + ", getWhiteBalance : " + getWhiteBalance() + ", getAutoExposureLockState : " + getAutoExposureLockState() + ", isHistogramEnable : " + isHistogramEnable() + ", getExposureMode : " + getExposureMode() + ", getPhotoStyle : " + getPhotoStyle() + ", isSubtitleEnable : " + isSubtitleEnable() + ", getAntiFlicker = " + getAntiFlicker() + ", getType : " + getType() + ", getWorkState : " + getWorkState() + ", getMediaMode : " + getMediaMode() + ", getVideoFormat = " + getVideoFormat() + ", getPhotoAspectRatio = " + getPhotoAspectRatio() + ", getPhotoFormat = " + getPhotoFormat() + ", getDigitalZoomScale = " + getDigitalZoomScale() + ", getVideoResolutionAndFrameRate = " + getVideoResolutionAndFrameRate() + ", getBurstCount = " + getBurstCount() + ", getAEBCount = " + getAEBCount() + ", getTimelapseInterval = " + getTimelapseInterval();
                                }
                            });
                        }

                        public void onFailure(AutelError autelError) {
                            callbackWithOneParam.onFailure(autelError);
                        }
                    });
                }

                public void onFailure(AutelError autelError) {
                    callbackWithOneParam.onFailure(autelError);
                }
            });
        }
    }

    public void setVideoFormat(VideoFormat videoFormat, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setVideoFormat(videoFormat, callbackWithNoParam);
    }

    public void getVideoResolutionAndFrameRate(CallbackWithOneParam<VideoResolutionAndFps> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getVideoResolutionAndFrameRate(callbackWithOneParam);
        }
    }

    public void getDigitalZoomScale(CallbackWithOneParam<Integer> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getDigitalZoomScale(callbackWithOneParam);
        }
    }

    public void setDigitalZoomScale(int i, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setDigitalZoomScale(i, callbackWithNoParam);
    }

    public R12ParameterRangeManager getParameterRangeManager() {
        if (this.rangeManager == null) {
            this.rangeManager = new R12ParameterRangeManagerImpl();
        }
        return this.rangeManager;
    }

    public void getAspectRatio(CallbackWithOneParam<PhotoAspectRatio> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getAspectRatio(callbackWithOneParam);
        }
    }

    public void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolutionAndFps, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setVideoResolutionAndFrameRate(videoResolutionAndFps, callbackWithNoParam);
    }

    public void getVideoFormat(CallbackWithOneParam<VideoFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getVideoFormat(callbackWithOneParam);
        }
    }

    public void setVideoStandard(VideoStandard videoStandard, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setVideoStandard(videoStandard, callbackWithNoParam);
    }

    public void getVideoStandard(CallbackWithOneParam<VideoStandard> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getVideoStandard(callbackWithOneParam);
        }
    }

    public void setPhotoFormat(PhotoFormat photoFormat, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setPhotoFormat(photoFormat, callbackWithNoParam);
    }

    public void getPhotoFormat(CallbackWithOneParam<PhotoFormat> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getPhotoFormat(callbackWithOneParam);
        }
    }

    public void setAspectRatio(PhotoAspectRatio photoAspectRatio, CallbackWithNoParam callbackWithNoParam) {
        this.cameraR12.setAspectRatio(photoAspectRatio.value(CameraProduct.R12), callbackWithNoParam);
    }

    public void getPhotoAEBCount(CallbackWithOneParam<PhotoAEBCount> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getPhotoAEBCount(callbackWithOneParam);
        }
    }

    public void getPhotoStyle(CallbackWithOneParam<PhotoStyle> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.cameraR12.getPhotoStyle(callbackWithOneParam);
        }
    }
}
