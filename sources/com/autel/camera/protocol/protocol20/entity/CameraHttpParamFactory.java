package com.autel.camera.protocol.protocol20.entity;

import android.text.TextUtils;
import com.autel.bean.camera.CameraAllSettings;
import com.autel.common.camera.XT706.ImageMode;
import com.autel.common.camera.XT706.IrPosition;
import com.autel.common.camera.XT706.IrTemperatureMode;
import com.autel.common.camera.XT706.IrTemperatureParams;
import com.autel.common.camera.XT706.IrTemperatureWarnParams;
import com.autel.common.camera.base.ISOMode;
import com.autel.common.camera.base.RawFormat;
import com.autel.common.camera.media.LensFocusMode;
import com.autel.internal.sdk.camera.flir.FLIRSkyCondition;
import com.autel.internal.sdk.camera.flir.TemperatureUnit;
import com.autel.internal.sdk.camera.flirInternal.FLIRRadiometrySetting;
import com.autel.internal.sdk.camera.flirInternal.FlirRadiometrySettingInternal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraHttpParamFactory {

    /* renamed from: id */
    public static int f8461id;
    private static CameraHttpParamFactory mInstance;

    private CameraHttpParamFactory() {
        f8461id = 0;
    }

    public static CameraHttpParamFactory getInstance() {
        if (mInstance == null) {
            synchronized (CameraHttpParamFactory.class) {
                mInstance = new CameraHttpParamFactory();
            }
        }
        return mInstance;
    }

    public String buildStartFormatSDCard() {
        return buildParamByMap(CameraParamsConfig.method_StartFormatSDCard, (Map<String, Object>) null);
    }

    public String buildStartFormatFlashMemoryCard() {
        return buildParamByMap(CameraParamsConfig.method_StartFormatFMC, (Map<String, Object>) null);
    }

    public String buildStartFactoryReset() {
        return buildParamByMap(CameraParamsConfig.method_StartFactoryReset, (Map<String, Object>) null);
    }

    public String buildStartTakePhotos(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_PromptTone, 0);
        hashMap.put(CameraParamsConfig.param_FocusFirst, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_StartTakePhotos, hashMap);
    }

    public String buildStopTakePhotos() {
        return buildParamByMap(CameraParamsConfig.method_StopTakePhotos, (Map<String, Object>) null);
    }

    public String buildStartRecording() {
        return buildParamByMap(CameraParamsConfig.method_StartRecording, (Map<String, Object>) null);
    }

    public String buildStopRecording() {
        return buildParamByMap(CameraParamsConfig.method_StopRecording, (Map<String, Object>) null);
    }

    public String buildSetCameraFocusMode(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("Mode", str);
        }
        return buildParamByMap(CameraParamsConfig.method_SetFocus, hashMap);
    }

    public String buildSetCameraAFMeterMode(String str, int i, int i2) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("Mode", str);
            }
            jSONObject.put(CameraParamsConfig.param_X, i);
            jSONObject.put(CameraParamsConfig.param_Y, i2);
            jSONArray.put(jSONObject);
            jSONObject2.put(CameraParamsConfig.param_AF_Meter_Mode_SpotArea, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_AF_Meter_Mode, jSONObject2);
        return buildParamByMap(CameraParamsConfig.method_SetFocus, hashMap);
    }

    public String buildSetCameraMFMeterMode(int i, int i2) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_X, i);
            jSONObject.put(CameraParamsConfig.param_Y, i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_MFSpotArea, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetFocus, hashMap);
    }

    public String buildSetCameraFocusMFPosition(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("Mode", LensFocusMode.MANUAL_FOCUS.value());
        hashMap.put(CameraParamsConfig.param_MF_Meter_Mode_ObjectDistance, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetFocus, hashMap);
    }

    public String buildSetAFAssistFocusEnable(int i) {
        HashMap hashMap = new HashMap();
        if (-1 != i) {
            hashMap.put(CameraParamsConfig.param_AFAssistFocusEnable, Integer.valueOf(i));
        }
        return buildParamByMap(CameraParamsConfig.method_SetFocus, hashMap);
    }

    public String buildSetMFAssistFocusEnable(int i) {
        HashMap hashMap = new HashMap();
        if (-1 != i) {
            hashMap.put(CameraParamsConfig.param_MFAssistFocusEnable, Integer.valueOf(i));
        }
        return buildParamByMap(CameraParamsConfig.method_SetFocus, hashMap);
    }

    public String buildSetCameraZoomFactor(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_ZoomValue, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetZoomFactor, hashMap);
    }

    public String buildSetAudioSourceConfiguration(CameraAllSettings.AudioSourceConfiguration audioSourceConfiguration) {
        HashMap hashMap = new HashMap();
        if (audioSourceConfiguration.getRecordTone() != -1) {
            hashMap.put(CameraParamsConfig.param_RecordTone, Integer.valueOf(audioSourceConfiguration.getRecordTone()));
        }
        if (audioSourceConfiguration.getMicVolume() != -1) {
            hashMap.put(CameraParamsConfig.param_MicVolume, Integer.valueOf(audioSourceConfiguration.getMicVolume()));
        }
        if (audioSourceConfiguration.getSpeakerVolume() != -1) {
            hashMap.put(CameraParamsConfig.param_SpeakerVolume, Integer.valueOf(audioSourceConfiguration.getSpeakerVolume()));
        }
        if (audioSourceConfiguration.getEnableSpeaker() != -1) {
            hashMap.put(CameraParamsConfig.param_EnableSpeaker, Integer.valueOf(audioSourceConfiguration.getEnableSpeaker()));
        }
        if (audioSourceConfiguration.getCaptureTone() != -1) {
            hashMap.put(CameraParamsConfig.param_CaptureTone, Integer.valueOf(audioSourceConfiguration.getCaptureTone()));
        }
        return buildParamByMap(CameraParamsConfig.method_SetAudioSourceConfiguration, hashMap);
    }

    public String buildSetPhotoFormat(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(CameraParamsConfig.param_PicType, str);
        }
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetSingleModeSettings(int i, int i2) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_DelaySeconds, i);
            jSONObject.put(CameraParamsConfig.param_EnableHDR, i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_SingleModeSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetBurstSetting(int i) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_NumPhotosPerSecond, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_BurstModeSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetBurstAEBSetting(int i) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_NumPhotosAtOnce, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_AEBModeSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetLoopRecordSettings(int i) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_MaxRecordTime, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_LoopRecordSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetRecordingSettings, hashMap);
    }

    public String buildSetTimelapseModeSettings(double d, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_Interval, d);
            jSONObject.put(CameraParamsConfig.param_Duration, i);
            jSONObject.put(CameraParamsConfig.param_ComposeVideo, i3);
            jSONObject.put(CameraParamsConfig.param_VideoFramerate, i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_TimelapseModeSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetTimelapseModeSettingsInterval(double d) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_Interval, d);
            jSONObject.put(CameraParamsConfig.param_Enable, 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_TimelapseModeSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetDehazeEnable(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Status, z ? CameraParamsConfig.param_Enable : CameraParamsConfig.param_Disable);
        return buildParamByMap("SetDehazeSetting", hashMap);
    }

    public String buildSetDehazeStrength(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Strength, Integer.valueOf(i));
        return buildParamByMap("SetDehazeSetting", hashMap);
    }

    public String buildSetImageRoiEnable(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Status, z ? CameraParamsConfig.param_Enable : CameraParamsConfig.param_Disable);
        return buildParamByMap(CameraParamsConfig.param_SetImageRoiSetting, hashMap);
    }

    public String buildSetImageRoiStrength(int i) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(CameraParamsConfig.param_Strength, Integer.valueOf(i));
        return buildParamByMapForImageRoi(CameraParamsConfig.param_SetImageRoiSetting, hashMap, new JSONObject(hashMap2));
    }

    public String buildSetImageRoiSettingParams(int i, int i2) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(CameraParamsConfig.param_RectX, Integer.valueOf(i));
        hashMap2.put(CameraParamsConfig.param_RectY, Integer.valueOf(i2));
        return buildParamByMapForImageRoi(CameraParamsConfig.param_SetImageRoiSetting, hashMap, new JSONObject(hashMap2));
    }

    public String buildSetTimelapseModeSettingsDuration(int i) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_Duration, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_TimelapseModeSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetTimelapseModeSettingsVideoFrameRate(int i) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_VideoFramerate, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_TimelapseModeSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetTimelapseModeSettingsComposeVideo(int i) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraParamsConfig.param_ComposeVideo, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put(CameraParamsConfig.param_TimelapseModeSettings, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetPhotoTakingSettings, hashMap);
    }

    public String buildSetEnableSubtitle(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_EnableSubtitle, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetRecordingSettings, hashMap);
    }

    public String buildSetFileFormat(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(CameraParamsConfig.param_FileFormat, str);
        }
        return buildParamByMap(CameraParamsConfig.method_SetRecordingSettings, hashMap);
    }

    public String buildSetFileNamingMode(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("Mode", str);
        }
        return buildParamByMap(CameraParamsConfig.method_SetFileNamingMode, hashMap);
    }

    public String buildSetImageColor(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(CameraParamsConfig.param_Color, str);
        }
        return buildParamByMap(CameraParamsConfig.method_SetImageColor, hashMap);
    }

    public String buildSetWhiteBalance(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Mode", str);
        return buildParamByMap(CameraParamsConfig.method_SetWhiteBalance, hashMap);
    }

    public String buildSetWhiteBalance(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("Mode", str);
        hashMap.put("ColorTemperature", Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetWhiteBalance, hashMap);
    }

    public String buildSetImageStyle(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(CameraParamsConfig.param_Style, str);
        }
        return buildParamByMap(CameraParamsConfig.method_SetImageStyle, hashMap);
    }

    public String buildSetVideoSourceConfiguration(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Rotation, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetVideoSourceConfiguration, hashMap);
    }

    public String buildSetVideoStandard(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_VideoStandard, str);
        return buildParamByMap(CameraParamsConfig.method_SetVideoSourceConfiguration, hashMap);
    }

    public String buildSetAntiFlicker(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_AntiFlicker, str);
        return buildParamByMap(CameraParamsConfig.method_SetVideoSourceConfiguration, hashMap);
    }

    public String buildSetEnable3DNR(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Enable3DNR, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetVideoSourceConfiguration, hashMap);
    }

    public String buildSetVideoResolution(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_StreamId, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(CameraParamsConfig.param_Resolution, str);
        }
        return buildParamByMap(CameraParamsConfig.method_SetVideoEncoderConfiguration, hashMap);
    }

    public String buildSetShutter(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_SetShutter_Type, str);
        return buildParamByMap(CameraParamsConfig.method_SetShutter, hashMap);
    }

    public String buildSetStorageType(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_StorageType, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetStorageType, hashMap);
    }

    public String buildGetStorageType() {
        return buildParamByMap(CameraParamsConfig.method_GetStorageType, (Map<String, Object>) null);
    }

    public String buildProduceParametersEnable(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_EnableSubtitleSn, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.param_SetProduceParameters, hashMap);
    }

    public String buildGetShutter() {
        return buildParamByMap(CameraParamsConfig.method_GetShutter, (Map<String, Object>) null);
    }

    public String buildSetWiFiConfiguration(String str, String str2, int i, int i2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(CameraParamsConfig.param_SSID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(CameraParamsConfig.param_Password, str2);
        }
        hashMap.put(CameraParamsConfig.param_Band, Integer.valueOf(i));
        hashMap.put(CameraParamsConfig.param_FactoryMode, Integer.valueOf(i2));
        return buildParamByMap(CameraParamsConfig.method_SetWiFiConfiguration, hashMap);
    }

    public String buildSetVideoEncoderConfigurationParams(int i, CameraAllSettings.VideoEncoderConfiguration videoEncoderConfiguration) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_StreamId, Integer.valueOf(i));
        if (videoEncoderConfiguration.getResolution() != null) {
            hashMap.put(CameraParamsConfig.param_Resolution, videoEncoderConfiguration.getResolution());
        }
        if (videoEncoderConfiguration.getEncoding() != null) {
            hashMap.put(CameraParamsConfig.param_Encoding, videoEncoderConfiguration.getEncoding());
        }
        return buildParamByMap(CameraParamsConfig.method_SetVideoEncoderConfiguration, hashMap);
    }

    public String buildSetGoalArea(float f, float f2, float f3, float f4, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("StartX", Float.valueOf(f));
        hashMap.put("StartY", Float.valueOf(f2));
        hashMap.put("Width", Float.valueOf(f3));
        hashMap.put("Hight", Float.valueOf(f4));
        hashMap.put("TargetType", Integer.valueOf(i));
        return buildParamByMap("SetGoalArea", hashMap);
    }

    public String buildStopTrack() {
        return buildParamByMap("StopTracking", (Map<String, Object>) null);
    }

    public String buildGetTrackState() {
        return buildParamByMap("GetTrackStatus", (Map<String, Object>) null);
    }

    public String buildSetTrackMode(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        return buildParamByMap("SetTrackPattern", hashMap);
    }

    public String buildSetAutoSnapshot(int i, int i2) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        if (-1 != i) {
            try {
                jSONObject.put(CameraParamsConfig.param_Enable, i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (-1 != i2) {
            jSONObject.put(CameraParamsConfig.param_Interval, i2);
        }
        hashMap.put(CameraParamsConfig.param_AutoSnapshot, jSONObject);
        return buildParamByMap(CameraParamsConfig.method_SetRecordingSettings, hashMap);
    }

    private String buildParamByMap(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", str);
            if (map != null) {
                jSONObject.put("params", new JSONObject(map));
            }
            int i = f8461id + 1;
            f8461id = i;
            jSONObject.put("id", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private String buildParamByMapForImageRoi(String str, Map<String, Object> map, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("method", str);
            if (map != null) {
                JSONObject jSONObject3 = new JSONObject(map);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                jSONObject3.put("RoiRegion", jSONArray);
                jSONObject2.put("params", jSONObject3);
            }
            int i = f8461id + 1;
            f8461id = i;
            jSONObject2.put("id", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject2.toString();
    }

    public String buildSetRadiometrySettings(FLIRRadiometrySetting fLIRRadiometrySetting) {
        FlirRadiometrySettingInternal flirRadiometrySettingInternal = (FlirRadiometrySettingInternal) fLIRRadiometrySetting;
        HashMap hashMap = new HashMap();
        if (fLIRRadiometrySetting.getTempUnit() != TemperatureUnit.UNKNOWN) {
            hashMap.put(CameraParamsConfig.param_TempUnit, fLIRRadiometrySetting.getTempUnit().getValue());
        }
        if (flirRadiometrySettingInternal.isSpotMeterEnableValidate()) {
            hashMap.put("SpotMeter", Integer.valueOf(fLIRRadiometrySetting.isSpotMeterEnable() ? 1 : 0));
        }
        if (fLIRRadiometrySetting.getEmissivity() != -100) {
            hashMap.put("Emissivity", Integer.valueOf(fLIRRadiometrySetting.getEmissivity()));
        }
        if (fLIRRadiometrySetting.getAirTemp() != -100) {
            hashMap.put("AirTemp", Integer.valueOf(fLIRRadiometrySetting.getAirTemp()));
        }
        if (fLIRRadiometrySetting.getSkyCond() != FLIRSkyCondition.UNKNOWN) {
            hashMap.put("SkyCond", fLIRRadiometrySetting.getSkyCond().getValue());
        }
        if (fLIRRadiometrySetting.getHumidity() != -1) {
            hashMap.put("Humidity", Integer.valueOf(fLIRRadiometrySetting.getHumidity()));
        }
        if (fLIRRadiometrySetting.getSubjectDistance() != -1) {
            hashMap.put("SubjectDistance", Integer.valueOf(fLIRRadiometrySetting.getSubjectDistance()));
        }
        return buildParamByMap(CameraParamsConfig.method_SetRadiometrySettings, hashMap);
    }

    public String buildSetSportMeterEnable(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("SpotMeter", Integer.valueOf(z ? 1 : 0));
        return buildParamByMap(CameraParamsConfig.method_SetRadiometrySettings, hashMap);
    }

    public String buildSetDisplayMode(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_DisplayMode, str);
        return buildParamByMap(CameraParamsConfig.method_SetDisplayMode, hashMap);
    }

    public String buildSetIrColor(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Color, str);
        return buildParamByMap(CameraParamsConfig.method_SetIrColor, hashMap);
    }

    public String buildSetIrPosition(IrPosition irPosition) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_IrPosition_DeltaX, Integer.valueOf(irPosition.getDeltaX()));
        hashMap.put(CameraParamsConfig.param_IrPosition_DeltaY, Integer.valueOf(irPosition.getDeltaY()));
        return buildParamByMap(CameraParamsConfig.method_SetIrPosition, hashMap);
    }

    public String buildSetHDREnable(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Status, str);
        return buildParamByMap(CameraParamsConfig.method_SetHDRSetting, hashMap);
    }

    public String buildSetIrFlushShutter() {
        return buildParamByMap(CameraParamsConfig.method_SetIrFlushShutter, (Map<String, Object>) null);
    }

    public String buildStartMotionDelayShot() {
        return buildParamByMap(CameraParamsConfig.method_StartMotionDelayShot, (Map<String, Object>) null);
    }

    public String buildPauseMotionDelayShot() {
        return buildParamByMap(CameraParamsConfig.method_PauseMotionDelayShot, (Map<String, Object>) null);
    }

    public String buildResumeMotionDelayShot() {
        return buildParamByMap(CameraParamsConfig.method_ResumeMotionDelayShot, (Map<String, Object>) null);
    }

    public String buildStopMotionDelayShot() {
        return buildParamByMap(CameraParamsConfig.method_StopMotionDelayShot, (Map<String, Object>) null);
    }

    public String buildSetMotionDelayShotInterval(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Interval, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetMotionDelayShotInterval, hashMap);
    }

    public String buildGetMotionDelayShotInterval() {
        return buildParamByMap(CameraParamsConfig.method_GetMotionDelayShotInterval, (Map<String, Object>) null);
    }

    public String buildSetMotionDelayShotDuration(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Duration, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetMotionDelayShotDuration, hashMap);
    }

    public String buildGetMotionDelayShotDuration() {
        return buildParamByMap(CameraParamsConfig.method_GetMotionDelayShotDuration, (Map<String, Object>) null);
    }

    public String buildSetMotionDelayShotKeepPhoto(RawFormat rawFormat) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_PicType, rawFormat.value());
        return buildParamByMap(CameraParamsConfig.method_SetMotionDelayShotKeepPhoto, hashMap);
    }

    public String buildGetMotionDelayShotKeepPhoto() {
        return buildParamByMap(CameraParamsConfig.method_GetMotionDelayShotKeepPhoto, (Map<String, Object>) null);
    }

    public String buildSetCameraPattern(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_CameraPattern, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetCameraPattern, hashMap);
    }

    public String buildLockGimbalWhenTakePhoto(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_LockState, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetGimbalLockState, hashMap);
    }

    public String buildSetIrTemperatureParams(IrTemperatureParams irTemperatureParams) {
        HashMap hashMap = new HashMap();
        if (irTemperatureParams.temperatureMode != IrTemperatureMode.UNKNOWN) {
            hashMap.put(CameraParamsConfig.param_TempMode, irTemperatureParams.temperatureMode.value());
        }
        if (irTemperatureParams.touchxRatio != 0.0f) {
            hashMap.put(CameraParamsConfig.param_TouchX, Float.valueOf(irTemperatureParams.touchxRatio));
        }
        if (irTemperatureParams.touchyRatio != 0.0f) {
            hashMap.put(CameraParamsConfig.param_TouchY, Float.valueOf(irTemperatureParams.touchyRatio));
        }
        if (irTemperatureParams.xRatio != 0.0f) {
            hashMap.put(CameraParamsConfig.param_RegionX, Float.valueOf(irTemperatureParams.xRatio));
        }
        if (irTemperatureParams.yRatio != 0.0f) {
            hashMap.put(CameraParamsConfig.param_RegionY, Float.valueOf(irTemperatureParams.yRatio));
        }
        if (irTemperatureParams.widthRatio != 0.0f) {
            hashMap.put(CameraParamsConfig.param_RegionW, Float.valueOf(irTemperatureParams.widthRatio));
        }
        if (irTemperatureParams.heightRatio != 0.0f) {
            hashMap.put(CameraParamsConfig.param_RegionH, Float.valueOf(irTemperatureParams.heightRatio));
        }
        return buildParamByMap(CameraParamsConfig.method_SetIrTempAttr, hashMap);
    }

    public String buildGetIrTemperatureParams() {
        return buildParamByMap(CameraParamsConfig.method_GetIrTempAttr, (Map<String, Object>) null);
    }

    public String buildSetIrTemperatureWarningParams(IrTemperatureWarnParams irTemperatureWarnParams) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Enable, Boolean.valueOf(irTemperatureWarnParams.enable));
        hashMap.put(CameraParamsConfig.param_HotThred, Integer.valueOf(irTemperatureWarnParams.highTemperature * 10));
        hashMap.put(CameraParamsConfig.param_ColdThred, Integer.valueOf(irTemperatureWarnParams.lowTemperature * 10));
        return buildParamByMap(CameraParamsConfig.method_SetIrTempAlarm, hashMap);
    }

    public String buildGetIrTemperatureWarningParams() {
        return buildParamByMap(CameraParamsConfig.method_GetIrTempAlarm, (Map<String, Object>) null);
    }

    public String buildGetIrTemperatureEmit() {
        return buildParamByMap(CameraParamsConfig.method_GetIrTempEmit, (Map<String, Object>) null);
    }

    public String buildSetIrTemperatureEmit(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Emit, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetIrTempEmit, hashMap);
    }

    public String buildSetISOMode(ISOMode iSOMode) {
        HashMap hashMap = new HashMap();
        hashMap.put("Mode", iSOMode.value());
        return buildParamByMap(CameraParamsConfig.method_SetISOMode, hashMap);
    }

    public String buildGetISOMode() {
        return buildParamByMap(CameraParamsConfig.method_GetISOMode, (Map<String, Object>) null);
    }

    public String buildSetIrImageModeParams(ImageMode imageMode, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_ImageMode, Integer.valueOf(imageMode.value()));
        hashMap.put(CameraParamsConfig.param_Contrast, Integer.valueOf(i));
        hashMap.put(CameraParamsConfig.param_Lum, Integer.valueOf(i2));
        return buildParamByMap(CameraParamsConfig.method_SetIrImageMode, hashMap);
    }

    public String buildGetIrImageModeParams() {
        return buildParamByMap(CameraParamsConfig.method_GetIrImageMode, (Map<String, Object>) null);
    }

    public String buildSetIrEnhance(boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Enable, Integer.valueOf(z ? 1 : 0));
        hashMap.put(CameraParamsConfig.param_Strength, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetIrEnhance, hashMap);
    }

    public String buildGetIrEnhance() {
        return buildParamByMap(CameraParamsConfig.method_GetIrEnhance, (Map<String, Object>) null);
    }

    public String buildSetIrDeNoise(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Enable, Integer.valueOf(z ? 1 : 0));
        return buildParamByMap(CameraParamsConfig.method_SetIrNr, hashMap);
    }

    public String buildGetIrDeNoise() {
        return buildParamByMap(CameraParamsConfig.method_GetIrNr, (Map<String, Object>) null);
    }

    public String buildSetIrGain(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_Gain, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetIrGain, hashMap);
    }

    public String buildGetIrGain() {
        return buildParamByMap(CameraParamsConfig.method_GetIrGain, (Map<String, Object>) null);
    }

    public String buildSetIsoTherm(int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("Mode", Integer.valueOf(i));
        hashMap.put(CameraParamsConfig.param_HotThred, Integer.valueOf(i2 * 10));
        hashMap.put(CameraParamsConfig.param_ColdThred, Integer.valueOf(i3 * 10));
        return buildParamByMap(CameraParamsConfig.method_SetIrIsoTherm, hashMap);
    }

    public String buildGetIsoTherm() {
        return buildParamByMap(CameraParamsConfig.method_GetIrIsoTherm, (Map<String, Object>) null);
    }

    public String buildGetGpsCoordinateType() {
        return buildParamByMap(CameraParamsConfig.method_GetGPSMapDatum, (Map<String, Object>) null);
    }

    public String buildSetGpsCoordinateType(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(CameraParamsConfig.param_GPSMapDatum, Integer.valueOf(i));
        return buildParamByMap(CameraParamsConfig.method_SetGPSMapDatum, hashMap);
    }
}
