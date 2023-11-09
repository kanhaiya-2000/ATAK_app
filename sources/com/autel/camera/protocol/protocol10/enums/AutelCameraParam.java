package com.autel.camera.protocol.protocol10.enums;

import com.autel.downloader.bean.DownloadTask;
import com.autel.internal.sdk.camera.base.AutelCameraSettingInternal;

public enum AutelCameraParam {
    CAMERA_PARAM_STATUS(DownloadTask.STATUS),
    CAMERA_PARAM_SETTING("setting"),
    CAMERA_PARAM_PHOTO_SIZE("photo_size"),
    CAMERA_PARAM_P_TYPE(AutelCameraSettingInternal.KEY_PHOTO_FOMART),
    CAMERA_PARAM_S_STYLE(AutelCameraSettingInternal.KEY_S_STYLE),
    CAMERA_PARAM_P_WB(AutelCameraSettingInternal.KEY_P_WB),
    CAMERA_PARAM_S_COLOR(AutelCameraSettingInternal.KEY_S_COLOR),
    CAMERA_PARAM_V_RESOLUTION("v_resolution"),
    CAMERA_PARAM_S_SYSTEM_TYPE(AutelCameraSettingInternal.KEY_S_SYSTEM_TYPE),
    CAMERA_PARAM_V_TYPE(AutelCameraSettingInternal.KEY_VIDEO_FOMART),
    CAMERA_PARAM_P_FLICKER("p_flicker");
    
    private final String value;

    private AutelCameraParam(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }
}
