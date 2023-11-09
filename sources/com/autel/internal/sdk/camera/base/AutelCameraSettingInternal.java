package com.autel.internal.sdk.camera.base;

import android.text.TextUtils;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.AntiFlicker;
import com.autel.common.camera.media.AutoExposureLockState;
import com.autel.common.camera.media.CameraAperture;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.ColorStyle;
import com.autel.common.camera.media.ExposureCompensation;
import com.autel.common.camera.media.ExposureMode;
import com.autel.common.camera.media.FocusDistance;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoAspectRatio;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.ShutterSpeed;
import com.autel.common.camera.media.SpotMeteringArea;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.WhiteBalance;
import com.autel.common.camera.media.WhiteBalanceType;
import com.autel.internal.sdk.camera.CameraSetting;
import com.autel.internal.sdk.camera.util.PhotoStyleUtil;
import java.util.concurrent.ConcurrentHashMap;

public class AutelCameraSettingInternal implements CameraSetting {
    public static final String KEY_AE_LOCK = "ae_lock";
    public static final String KEY_AIRTEMP = "AirTemp";
    public static final String KEY_ANTI_FLICKER = "p_flicker";
    public static final String KEY_APERTUREVALUE = "ApertureValue";
    public static final String KEY_BURST_MODE = "burst_mode";
    public static final String KEY_CAMERA_CLOCK = "camera_clock";
    public static final String KEY_CAPTURE_MODE = "capture_mode";
    public static final String KEY_COLORTEMPERATURE = "ColorTemperature";
    public static final String KEY_C_MODEL = "c_model";
    public static final String KEY_C_NAME = "c_name";
    public static final String KEY_DELAYED_DURATION = "delayed_duration";
    public static final String KEY_DELAYED_INTERVAL = "delayed_interval";
    public static final String KEY_DELAYED_SAVE_OPT = "delayed_save_opt";
    public static final String KEY_EMISSIVITY = "Emissivity";
    public static final String KEY_FOCUSMODE = "FocusMode";
    public static final String KEY_FOCUSMODE_DISTANCE = "FocusMode_Distance";
    public static final String KEY_HARDWAREID = "HardwareId";
    public static final String KEY_HUMIDITY = "Humidity";
    public static final String KEY_IRCOLORPALETTE = "IRColorPalette";
    public static final String KEY_IRFILEFORMAT = "IRFileFormat";
    public static final String KEY_IRRECORDEDVIDEO = "IRRecordedVideo";
    public static final String KEY_MSXENABLE = "MSXEnable";
    public static final String KEY_MSXPOSX = "MSXPosX";
    public static final String KEY_MSXPOSY = "MSXPosY";
    public static final String KEY_MSXSTRENGTH = "MSXStrength";
    public static final String KEY_PANORAMA_ANGLE = "panorama_angle";
    public static final String KEY_PANORAMA_STEP = "panorama_step";
    public static final String KEY_PHOTO_FOMART = "p_type";
    public static final String KEY_PHOTO_SIZE = "photo_size";
    public static final String KEY_PIP_POSITION = "PipPosition";
    public static final String KEY_P_AEBNUM = "p_aebnum";
    public static final String KEY_P_EXPOSURE = "p_exposure";
    public static final String KEY_P_ISO = "p_iso";
    public static final String KEY_P_METER = "p_meter";
    public static final String KEY_P_SHUTTER = "p_shutter";
    public static final String KEY_P_WB = "p_wb";
    public static final String KEY_SERIALNUMBER = "SerialNumber";
    public static final String KEY_SKYCOND = "SkyCond";
    public static final String KEY_SLOW_MOTION_RESO = "slow_motion_reso";
    public static final String KEY_SLOW_PLAYBACK_SPEED = "slow_playback_speed";
    public static final String KEY_SPOTMETER = "SpotMeter";
    public static final String KEY_SPOT_METER = "location_meter";
    public static final String KEY_SUBJECTDISTANCE = "SubjectDistance";
    public static final String KEY_SUBTITLE_SWITCH = "subtitle_switch";
    public static final String KEY_S_COLOR = "s_color";
    public static final String KEY_S_DISCONN_RECORD = "s_disconn_record";
    public static final String KEY_S_FILENUM_WAY = "s_filenum_way";
    public static final String KEY_S_HISTO = "s_histo";
    public static final String KEY_S_MCTF = "s_mctf";
    public static final String KEY_S_SELFTIMER_COUNT = "s_selftimer_count";
    public static final String KEY_S_STYLE = "s_style";
    public static final String KEY_S_SYSTEM_TYPE = "s_system_type";
    public static final String KEY_S_VERSION = "s_version";
    public static final String KEY_S_ZOOMFACTOR = "s_zoomfactor";
    public static final String KEY_TEMPUNIT = "TempUnit";
    public static final String KEY_TIMELAPSE_MODE = "timelapse_mode";
    public static final String KEY_VIDEO_FOMART = "v_type";
    public static final String KEY_V_PIV = "v_piv";
    public static final String KEY_V_RESOLUTION = "v_resolution";
    protected static ConcurrentHashMap<String, String> paramsSettingMap = new ConcurrentHashMap<>();
    private static AutelCameraSettingInternal s_instance;

    public long getCameraTimeStamp() {
        return 0;
    }

    protected AutelCameraSettingInternal() {
    }

    public static AutelCameraSettingInternal instance() {
        if (s_instance == null) {
            s_instance = new AutelCameraSettingInternal();
        }
        return s_instance;
    }

    public ConcurrentHashMap<String, String> getParamsSettingMap() {
        return paramsSettingMap;
    }

    public VideoResolutionAndFps getVideoResolution() {
        VideoResolutionAndFps videoResolutionAndFps = new VideoResolutionAndFps();
        String str = "";
        videoResolutionAndFps.resolution = VideoResolution.find(paramsSettingMap.get("v_resolution") == null ? str : paramsSettingMap.get("v_resolution"));
        if (paramsSettingMap.get("v_resolution") != null) {
            str = paramsSettingMap.get("v_resolution");
        }
        videoResolutionAndFps.fps = VideoFps.find(str);
        return videoResolutionAndFps;
    }

    public PhotoAspectRatio getAspectRatio() {
        return PhotoAspectRatio.find(getPhotoSize());
    }

    public String getCameraNickName() {
        return getCameraName();
    }

    public SpotMeteringArea getSpotMeterLocation() {
        String spotMeter = getSpotMeter();
        SpotMeteringArea spotMeteringArea = new SpotMeteringArea();
        if (spotMeter != null && !"".equals(spotMeter)) {
            int intValue = Integer.valueOf(spotMeter).intValue();
            spotMeteringArea.f8467X = intValue / 10;
            spotMeteringArea.f8468Y = intValue % 10;
        }
        return spotMeteringArea;
    }

    public String getPhotoSize() {
        return paramsSettingMap.get("photo_size") == null ? "" : paramsSettingMap.get("photo_size");
    }

    public String getCameraName() {
        return paramsSettingMap.get("c_name") == null ? "" : paramsSettingMap.get("c_name");
    }

    public String getSpotMeter() {
        return paramsSettingMap.get("location_meter") == null ? "" : paramsSettingMap.get("location_meter");
    }

    public AntiFlicker getAntiFlicker() {
        return AntiFlicker.find(paramsSettingMap.get("p_flicker") == null ? "" : paramsSettingMap.get("p_flicker"));
    }

    public CameraProduct getCameraProductType() {
        return CameraProduct.find(getCameraModel());
    }

    public boolean isSubtitleSwitchEnable() {
        return "ON".equals(getSubtitleSwitch());
    }

    public String getCameraModel() {
        return paramsSettingMap.get("c_model") == null ? "" : paramsSettingMap.get("c_model");
    }

    public String getSubtitleSwitch() {
        return paramsSettingMap.get(KEY_SUBTITLE_SWITCH) == null ? "" : paramsSettingMap.get(KEY_SUBTITLE_SWITCH);
    }

    public String getCameraTime() {
        return paramsSettingMap.get(KEY_CAMERA_CLOCK) == null ? "" : paramsSettingMap.get(KEY_CAMERA_CLOCK);
    }

    public String getVideoPiv() {
        return paramsSettingMap.get(KEY_V_PIV) == null ? "" : paramsSettingMap.get(KEY_V_PIV);
    }

    public VideoFormat getVideoFormat() {
        return VideoFormat.find(paramsSettingMap.get(KEY_VIDEO_FOMART) == null ? "" : paramsSettingMap.get(KEY_VIDEO_FOMART));
    }

    public PhotoBurstCount getBurstNum() {
        return PhotoBurstCount.find(paramsSettingMap.get(KEY_BURST_MODE) == null ? "" : paramsSettingMap.get(KEY_BURST_MODE));
    }

    public PhotoTimelapseInterval getTimelapseIntervalTime() {
        return PhotoTimelapseInterval.find(paramsSettingMap.get(KEY_TIMELAPSE_MODE) == null ? "" : paramsSettingMap.get(KEY_TIMELAPSE_MODE));
    }

    public VideoStandard getVideoStandard() {
        return VideoStandard.find(paramsSettingMap.get(KEY_S_SYSTEM_TYPE) == null ? "" : paramsSettingMap.get(KEY_S_SYSTEM_TYPE));
    }

    public String getVersion() {
        return paramsSettingMap.get(KEY_S_VERSION) == null ? "" : paramsSettingMap.get(KEY_S_VERSION);
    }

    public WhiteBalance getWhiteBalance() {
        WhiteBalance whiteBalance = new WhiteBalance();
        whiteBalance.type = WhiteBalanceType.find(paramsSettingMap.get(KEY_P_WB) == null ? "" : paramsSettingMap.get(KEY_P_WB));
        whiteBalance.colorTemperature = getCameraColorTemperature();
        return whiteBalance;
    }

    public ExposureCompensation getExposureValue() {
        return ExposureCompensation.find(getEv());
    }

    public ShutterSpeed getCameraShutter() {
        return ShutterSpeed.find(getShutter());
    }

    public String getMeterStatus() {
        return paramsSettingMap.get(KEY_P_METER) == null ? "" : paramsSettingMap.get(KEY_P_METER);
    }

    public String getEv() {
        return paramsSettingMap.get("p_exposure") == null ? "" : paramsSettingMap.get("p_exposure");
    }

    public String getShutter() {
        return paramsSettingMap.get(KEY_P_SHUTTER) == null ? "" : paramsSettingMap.get(KEY_P_SHUTTER);
    }

    public PhotoFormat getPhotoFormat() {
        return PhotoFormat.find(paramsSettingMap.get(KEY_PHOTO_FOMART) == null ? "" : paramsSettingMap.get(KEY_PHOTO_FOMART));
    }

    public PhotoAEBCount getAebNum() {
        return PhotoAEBCount.find(paramsSettingMap.get(KEY_P_AEBNUM) == null ? "" : paramsSettingMap.get(KEY_P_AEBNUM));
    }

    public String getDisconnectRecord() {
        return paramsSettingMap.get(KEY_S_DISCONN_RECORD) == null ? "" : paramsSettingMap.get(KEY_S_DISCONN_RECORD);
    }

    public CameraISO getISO() {
        return CameraISO.find(paramsSettingMap.get(KEY_P_ISO) == null ? "" : paramsSettingMap.get(KEY_P_ISO));
    }

    public boolean isHistogramStatusEnable() {
        return "ON".equals(getHistogramStatus());
    }

    public String getHistogramStatus() {
        return paramsSettingMap.get(KEY_S_HISTO) == null ? "" : paramsSettingMap.get(KEY_S_HISTO);
    }

    public PhotoStyle getPhotoStyle() {
        return PhotoStyleUtil.parserCustomPhotoStyle(paramsSettingMap.get(KEY_S_STYLE) == null ? "" : paramsSettingMap.get(KEY_S_STYLE));
    }

    public ColorStyle getThermalPalette() {
        return ColorStyle.find(getColor());
    }

    public ExposureMode getExposureMode() {
        return ExposureMode.find(getCaptureMode());
    }

    public boolean is3DDenoiseEnable() {
        return "ON".equals(get3DDennoise());
    }

    public String getFileIndex() {
        return paramsSettingMap.get(KEY_S_FILENUM_WAY) == null ? "" : paramsSettingMap.get(KEY_S_FILENUM_WAY);
    }

    public String getColor() {
        return paramsSettingMap.get(KEY_S_COLOR) == null ? "" : paramsSettingMap.get(KEY_S_COLOR);
    }

    public String getPanoramaAngle() {
        return paramsSettingMap.get(KEY_PANORAMA_ANGLE) == null ? "" : paramsSettingMap.get(KEY_PANORAMA_ANGLE);
    }

    public String getPanoramaStep() {
        return paramsSettingMap.get(KEY_PANORAMA_STEP) == null ? "" : paramsSettingMap.get(KEY_PANORAMA_STEP);
    }

    public String getCaptureMode() {
        return paramsSettingMap.get(KEY_CAPTURE_MODE) == null ? "" : paramsSettingMap.get(KEY_CAPTURE_MODE);
    }

    public String getSelftimerCount() {
        return paramsSettingMap.get(KEY_S_SELFTIMER_COUNT) == null ? "" : paramsSettingMap.get(KEY_S_SELFTIMER_COUNT);
    }

    public String getSlowDlayBackSpeed() {
        return paramsSettingMap.get(KEY_SLOW_PLAYBACK_SPEED) == null ? "" : paramsSettingMap.get(KEY_SLOW_PLAYBACK_SPEED);
    }

    public String getDelayedInterval() {
        return paramsSettingMap.get(KEY_DELAYED_INTERVAL);
    }

    public String getDelayedDuration() {
        return paramsSettingMap.get(KEY_DELAYED_DURATION);
    }

    public String getDelayedSaveOpt() {
        return paramsSettingMap.get(KEY_DELAYED_SAVE_OPT);
    }

    public String getSlowMotionReso() {
        return paramsSettingMap.get(KEY_SLOW_MOTION_RESO);
    }

    public String get3DDennoise() {
        return paramsSettingMap.get("s_mctf") == null ? "" : paramsSettingMap.get("s_mctf");
    }

    public void setVideoResolution(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("v_resolution", str);
    }

    public void setPhotoSize(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("photo_size", str);
    }

    public void setCameraName(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("c_name", str);
    }

    public void setSpotMeter(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("location_meter", str);
    }

    public void setAntiFlicker(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("p_flicker", str);
    }

    public void setCameraModel(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("c_model", str);
    }

    public void setAeLock(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("ae_lock", str);
    }

    public void setSubtitleSwitch(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_SUBTITLE_SWITCH, str);
    }

    public void setCameraTime(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_CAMERA_CLOCK, str);
    }

    public void setVideoPiv(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_V_PIV, str);
    }

    public void setVideoFomart(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_VIDEO_FOMART, str);
    }

    public void setBurstNum(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_BURST_MODE, str);
    }

    public void setTimelapseIntervalTime(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_TIMELAPSE_MODE, str);
    }

    public void setVideoStandard(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_SYSTEM_TYPE, str);
    }

    public void setCameraVersion(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_VERSION, str);
    }

    public void setCameraWhiteBalance(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_P_WB, str);
    }

    public void setCameraColorTemperature(int i) {
        paramsSettingMap.put("ColorTemperature", String.valueOf(i));
    }

    public void setMeterStatus(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_P_METER, str);
    }

    public void setEv(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("p_exposure", str);
    }

    public void setShutter(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_P_SHUTTER, str);
    }

    public void setPhotoFomart(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_PHOTO_FOMART, str);
    }

    public void setAebNum(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_P_AEBNUM, str);
    }

    public void setDisconnctRecord(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_DISCONN_RECORD, str);
    }

    public void setIso(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_P_ISO, str);
    }

    public void setHistogram(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_HISTO, str);
    }

    public void setStyle(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_STYLE, str);
    }

    public void setFileNumIndex(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_FILENUM_WAY, str);
    }

    public void setColor(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_COLOR, str);
    }

    public void setPanoramaAngle(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_PANORAMA_ANGLE, str);
    }

    public void setPanoramaStep(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_PANORAMA_STEP, str);
    }

    public void setCaptureMode(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_CAPTURE_MODE, str);
    }

    public void setSelftimerCount(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_SELFTIMER_COUNT, str);
    }

    public String setSlowPlaybackSpeed(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put(KEY_SLOW_PLAYBACK_SPEED, str);
    }

    public void setDelayedInterval(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_DELAYED_INTERVAL, str);
    }

    public void setDelayedDuration(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_DELAYED_DURATION, str);
    }

    public void setDelayedSaveOpt(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_DELAYED_SAVE_OPT, str);
    }

    public void setSlowMotionReso(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_SLOW_MOTION_RESO, str);
    }

    public void set3DDenoise(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("s_mctf", str);
    }

    public void setCameraZoomFactor(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_S_ZOOMFACTOR, str);
    }

    public int getDigitalZoomScale() {
        String str = paramsSettingMap.get(KEY_S_ZOOMFACTOR);
        if (str == null || "".equals(str)) {
            return 0;
        }
        return Integer.valueOf(str).intValue();
    }

    public CameraAperture getCameraApertureValue() {
        return CameraAperture.find(getCameraIrisValue());
    }

    public void setCameraIrisValue(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_APERTUREVALUE, str);
    }

    public String getCameraIrisValue() {
        return paramsSettingMap.get(KEY_APERTUREVALUE);
    }

    public void setCameraFocusMode(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_FOCUSMODE, str);
    }

    public LensFocusMode getCameraFocusMode() {
        return LensFocusMode.find(paramsSettingMap.get(KEY_FOCUSMODE));
    }

    public void setCameraFocusDistance(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_FOCUSMODE_DISTANCE, str);
    }

    public FocusDistance getCameraFocusDistance() {
        return FocusDistance.find(paramsSettingMap.get(KEY_FOCUSMODE_DISTANCE));
    }

    public int getCameraColorTemperature() {
        if (paramsSettingMap.get("ColorTemperature") != null) {
            return Integer.valueOf(paramsSettingMap.get("ColorTemperature")).intValue();
        }
        return 0;
    }

    public AutoExposureLockState getAutoExposureLockState() {
        return AutoExposureLockState.find(paramsSettingMap.get("ae_lock") == null ? "" : paramsSettingMap.get("ae_lock"));
    }

    public void setCameraSerialNumber(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_SERIALNUMBER, str);
    }

    public String getCameraSerialNumber() {
        return paramsSettingMap.get(KEY_SERIALNUMBER);
    }

    public void setIRColorPalette(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_IRCOLORPALETTE, str);
    }

    public String getIRColorPalette() {
        return paramsSettingMap.get(KEY_IRCOLORPALETTE);
    }

    public void setMSXEnable(boolean z) {
        paramsSettingMap.put(KEY_MSXENABLE, String.valueOf(z));
    }

    public boolean getMSXEnable() {
        return paramsSettingMap.get(KEY_MSXENABLE) != null && Boolean.getBoolean(paramsSettingMap.get(KEY_MSXENABLE));
    }

    public void setMSXStrength(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_MSXSTRENGTH, str);
    }

    public String getMSXStrength() {
        return paramsSettingMap.get(KEY_MSXSTRENGTH);
    }

    public void setMSXPosX(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_MSXPOSX, str);
    }

    public String getMSXPosX() {
        return paramsSettingMap.get(KEY_MSXPOSX);
    }

    public void setMSXPosY(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_MSXPOSY, str);
    }

    public String getMSXPosY() {
        return paramsSettingMap.get(KEY_MSXPOSY);
    }

    public void setIRFileFormat(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_IRFILEFORMAT, str);
    }

    public String getIRFileFormat() {
        return paramsSettingMap.get(KEY_IRFILEFORMAT);
    }

    public void setIRRecordVideo(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_IRRECORDEDVIDEO, str);
    }

    public String getIRRecordVideo() {
        return paramsSettingMap.get(KEY_IRRECORDEDVIDEO);
    }

    public void setTempUnit(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_TEMPUNIT, str);
    }

    public String getTempUnit() {
        return paramsSettingMap.get(KEY_TEMPUNIT);
    }

    public void setSportMeter(String str) {
        paramsSettingMap.put("SpotMeter", str);
    }

    public String getSportmeter() {
        return paramsSettingMap.get("SpotMeter");
    }

    public void setEmissivity(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("Emissivity", str);
    }

    public String getEmissivity() {
        return paramsSettingMap.get("Emissivity");
    }

    public void setAirTemp(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("AirTemp", str);
    }

    public String getAirTemp() {
        return paramsSettingMap.get("AirTemp");
    }

    public void setSkyCond(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("SkyCond", str);
    }

    public String getSkyCond() {
        return paramsSettingMap.get("SkyCond");
    }

    public void setHumidity(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("Humidity", str);
    }

    public String getHumidity() {
        return paramsSettingMap.get("Humidity");
    }

    public void setSubjectDistance(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("SubjectDistance", str);
    }

    public String getSubjectDistance() {
        return paramsSettingMap.get("SubjectDistance");
    }

    public void setHardwareId(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_HARDWAREID, str);
    }

    public String getHardwareId() {
        return paramsSettingMap.get(KEY_HARDWAREID);
    }

    public void setPipPosition(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsSettingMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_PIP_POSITION, str);
    }

    public String getPipPosition() {
        return paramsSettingMap.get(KEY_PIP_POSITION);
    }
}
