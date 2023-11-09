package com.autel.internal.sdk.camera.base;

import android.text.TextUtils;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.base.WorkState;
import com.autel.common.camera.media.PhotoSum;
import com.autel.common.camera.media.VideoSum;
import com.autel.internal.sdk.camera.CameraStatus;
import com.autel.internal.sdk.camera.media.PhotoSumImpl;
import com.autel.internal.sdk.camera.media.VideoSumImpl;
import java.util.concurrent.ConcurrentHashMap;

public class AutelCameraStatusInternal implements CameraStatus {
    public static final String KEY_AE_LOCK = "ae_lock";
    public static final String KEY_ANTI_FLICKER = "p_flicker";
    public static final String KEY_APP_STATUS = "app_status";
    public static final String KEY_CARD_STATUS = "card_status";
    public static final String KEY_CURRENT_REC_TIME = "current_record_time";
    public static final String KEY_CURR_MODE = "curr_mode";
    public static final String KEY_C_MODEL = "c_model";
    public static final String KEY_C_NAME = "c_name";
    private static final String KEY_DISPLAY_MODE = "display_mode";
    public static final String KEY_DV_FS_P = "dv_fs_p";
    public static final String KEY_DV_FS_V = "dv_fs_v";
    public static final String KEY_PHOTO_SIZE = "photo_size";
    public static final String KEY_SD_FREE_SPACE = "sd_free_space";
    public static final String KEY_SPOT_METER = "location_meter";
    public static final String KEY_S_MCTF = "s_mctf";
    private static final String KEY_TOTALSPACE = "TotalSpace";
    public static final String KEY_V_RESOLUTION = "v_resolution";
    protected static ConcurrentHashMap<String, String> paramsStatusMap = new ConcurrentHashMap<>();
    private static AutelCameraStatusInternal s_instance;

    protected AutelCameraStatusInternal() {
    }

    public static AutelCameraStatusInternal instance() {
        if (s_instance == null) {
            s_instance = new AutelCameraStatusInternal();
        }
        return s_instance;
    }

    public ConcurrentHashMap<String, String> getParamsStatusMap() {
        return paramsStatusMap;
    }

    public WorkState getCameraStatus() {
        return WorkState.find(paramsStatusMap.get(KEY_APP_STATUS) == null ? "" : paramsStatusMap.get(KEY_APP_STATUS));
    }

    public SDCardState getSDCardStatus() {
        String str = paramsStatusMap.get(KEY_CARD_STATUS);
        if (str == null) {
            str = "";
        }
        return SDCardState.find(str);
    }

    public MediaMode getCurrentMode() {
        String str = paramsStatusMap.get(KEY_CURR_MODE);
        if (str == null) {
            str = "";
        }
        return MediaMode.find(str);
    }

    public String getPhotoSize() {
        return paramsStatusMap.get("photo_size");
    }

    public VideoSum getVideoNum() {
        VideoSumImpl videoSumImpl = new VideoSumImpl();
        String str = paramsStatusMap.get(KEY_DV_FS_V) == null ? "" : paramsStatusMap.get(KEY_DV_FS_V);
        if (!"".equals(str)) {
            String[] split = str.split("\\|");
            if (split.length == 2) {
                videoSumImpl.leftTime = Long.valueOf(split[0]).longValue();
                videoSumImpl.currentRecordingTime = (long) Integer.valueOf(split[1]).intValue();
            }
        }
        return videoSumImpl;
    }

    public PhotoSum getPhotoNum() {
        PhotoSumImpl photoSumImpl = new PhotoSumImpl();
        String str = paramsStatusMap.get(KEY_DV_FS_P) == null ? "" : paramsStatusMap.get(KEY_DV_FS_P);
        if (!"".equals(str)) {
            String[] split = str.split("\\|");
            if (split.length == 2) {
                photoSumImpl.sum = Integer.valueOf(split[1]).intValue();
                photoSumImpl.leftSum = Integer.valueOf(split[0]).intValue();
            }
        }
        return photoSumImpl;
    }

    public String getCameraName() {
        return paramsStatusMap.get("c_name");
    }

    public String getSpotMeter() {
        return paramsStatusMap.get("location_meter");
    }

    public String getAntiFlicker() {
        return paramsStatusMap.get("p_flicker");
    }

    public String getCameraModel() {
        return paramsStatusMap.get("c_model");
    }

    public long getSdFreeSpace() {
        String str = paramsStatusMap.get(KEY_SD_FREE_SPACE);
        if (str == null || "".equals(str)) {
            return 0;
        }
        return Long.valueOf(str).longValue();
    }

    public String setCameraStatus(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put(KEY_APP_STATUS, str);
    }

    public String setCardStatus(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put(KEY_CARD_STATUS, str);
    }

    public String setCurrentMode(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put(KEY_CURR_MODE, str);
    }

    public String setPhotoSize(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put("photo_size", str);
    }

    public String setVideoNum(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put(KEY_DV_FS_V, str);
    }

    public String setPhotoNum(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put(KEY_DV_FS_P, str);
    }

    public String setCameraName(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put("c_name", str);
    }

    public String setSpotMeter(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put("location_meter", str);
    }

    public String setAntiFlicker(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put("p_flicker", str);
    }

    public String setCameraModel(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put("c_model", str);
    }

    public String setSdFreeSpace(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return concurrentHashMap.put(KEY_SD_FREE_SPACE, str);
    }

    public String get3DDenoise() {
        return paramsStatusMap.get("s_mctf");
    }

    public void set3DDenoise(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put("s_mctf", str);
    }

    public void setCurrentRecordTime(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_CURRENT_REC_TIME, str);
    }

    public long getCurrentRecordTime() {
        String str = paramsStatusMap.get(KEY_CURRENT_REC_TIME);
        if (str == null || "".equals(str)) {
            return 0;
        }
        return Long.valueOf(str).longValue();
    }

    public String getCameraDisplayMode() {
        return paramsStatusMap.get(KEY_DISPLAY_MODE);
    }

    public void setCameraDisplayMode(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_DISPLAY_MODE, str);
    }

    public String getCameraTotalSpace() {
        return paramsStatusMap.get(KEY_TOTALSPACE);
    }

    public void setCameraTotalSpace(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = paramsStatusMap;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        concurrentHashMap.put(KEY_TOTALSPACE, str);
    }
}
