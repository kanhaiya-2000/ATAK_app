package com.autel.common.error;

public enum AutelErrorCode {
    TIMEOUT(8801),
    UNKNOWN(8802),
    DISCONNECTED(8803),
    COMMAND_FAILED(8804),
    SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED(8805),
    SDK_HAS_NOT_CONNECT_TO_AIRCRAFT(8806),
    SDK_HAS_NOT_CONNECT_TO_REMOTE_CONTROLLER(8807),
    SDK_HAS_NOT_CONNECT_TO_CAMERA(8808),
    SDK_APP_KEY_INVALIDATE(8809),
    COMMAND_PARAMS_IS_NULL(8810),
    COMMAND_PARAMS_ARE_INVALID(8811),
    COMMON_PARSER_PARAMETER_FAILED(8812),
    SDK_AUTHOR_NEED_NORMAL_LEVEL(8813),
    COMMON_SET_PARAMETER_FAILED(8814),
    COMMAND_PARAMS_ARE_OUT_OF_RANGE(8815),
    COMMAND_IS_NOT_SUPPORTED_FOR_CURRENT_VERSION(8816),
    COMMAND_CANCEL(8817),
    COMMAND_FAILED_JOIN_QUEUE(8818),
    FLY_BEGIN_MODE_CHANGE_FAILED_WHEN_FLYING(8500),
    FLY_CALIBRATE_COMPASS_FAILED_AS_GPS_UNAVAILABLE(8501),
    FLY_CALIBRATE_COMPASS_FAILED_AS_NOT_IN_DISARM_MODE(8502),
    FLY_UPLOAD_FILE_MD5_ERROR(8504),
    FLY_UPLOAD_FILE_NOT_ENOUGHT_SPACE(8505),
    FLY_UPLOAD_FILE_CREATE_FAILED(8506),
    FLY_UPLOAD_FILE_WRITE_FAILED(8507),
    FLY_UPLOAD_FILE_READ_FAILED(8508),
    FLY_UPLOAD_FILE_NOT_EXIST(8509),
    FLY_UPLOAD_FILE_MD5_SAME(8510),
    FLY_UPLOAD_FILE_MD5_NOT_SAME(8503),
    CAMERA_SPOT_METER_AE_NOT_UNLOCK(8401),
    CAMERA_SET_EXPOSURE_NOT_ON_AUTO_MODE(8402),
    CAMERA_SET_ISO_NOT_ON_MANUAL_MODE(8403),
    CAMERA_SET_IRIS_NOT_SUPPORT_IN_AUTO_MODE(8404),
    CAMERA_SET_SHUTTER_NOT_ON_MANUAL_MODE(8405),
    RESOLUTION_OR_FPS_IS_NOT_MATCH(8406),
    CAMERA_SET_ANTI_FLICKER_NOT_ON_AUTO_MODE(8407),
    CAMERA_MANUAL_FOCUS_DISTANCE_NOT_ON_FOCUS_MANUAL_MODE(8408),
    CAMERA_TAKEN_PHOTO_NOT_ON_PHOTO_MODE(8409),
    CAMERA_TAKEN_PHOTO_NOT_ON_IDLE(8410),
    CAMERA_RECORD_VIDEO_NOT_ON_VIDEO_MODE(8411),
    CAMERA_RECORD_VIDEO_NOT_ON_IDLE_STATE(8412),
    CAMERA_STOP_RECORD_VIDEO_NOT_ON_RECORD_STATE(8413),
    CAMERA_STOP_RECORD_VIDEO_NOT_ON_VIDEO_MODE(8414),
    CAMERA_STOP_TIMELAPSE_NOT_ON_TIMELAPSE_MODE(8415),
    CAMERA_SDCARD_FORMAT_NOT_ON_IDLE_MODE(8416),
    CAMERA_RESET_NOT_ON_IDLE_MODE(8417),
    CAMERA_STOP_TIMELAPSE_NOT_ON_CAPTURE_STATE(8418),
    CAMERA_SET_AE_LOCK_STATE_ON_MANUAL_GEAR(8419),
    CAMERA_SET_AE_LOCK_STATE_WITH_BAD_PARAMS(8420),
    CAMERA_SET_CAMERA_GEAR_WITH_APERTURE_PRIORITY_NOT_SUPPORT(8421),
    CAMERA_SET_IRIS_NOT_SUPPORT(8422),
    CAMERA_SET_ASPECT_RADIO_3_2_NOT_SUPPORT(8423),
    CAMERA_SET_CUSTOM_WHITE_BALANCE_NOT_MATCH_METHOD(8424),
    CAMERA_SET_CUSTOM_PHOTO_STYLE_NOT_MATCH_METHOD(8425),
    CAMERA_THE_METHOD_IS_NOT_SUPPORT(8426),
    CAMERA_SET_CUSTOM_WHITE_BALANCE_NOT_SUPPORT(8427),
    VIDEO_STREAM_CODEC_ALREADY_EXIST(8428),
    CAMERA_COLOR_TEMPERATURE_RANGE_OUT(8429),
    CAMERA_EXPOSURE_NOT_SUPPORT_APERTURE_PRIORITY(8430),
    CAMERA_TAKEN_PHOTO_NEED_NOT_ON_UNKNOWN_MODE(8431),
    CAMERA_TAKEN_PHOTO_NEED_RECORD_STATE_ON_VIDEO_MODE(8432),
    CAMERA_ANTI_FLICKER_ONLY_60Hz_FOR_VIDEO_FPS_OVER_100(8433),
    CAMERA_TAKEN_PHOTO_NOT_ALLOWED_IN_4KP_60FPS_H265(8434),
    CAMERA_THE_RESOLUTION_OR_FRAME_IS_NOT_SUPPORT(8435),
    CAMERA_SDCARD_STATE_NO_CARD(8201),
    CAMERA_SDCARD_STATE_CARD_ERROR(8202),
    CAMERA_SDCARD_STATE_CARD_FULL(8203),
    CAMERA_SDCARD_STATE_CARD_NOT_SUPPORT(8204),
    CAMERA_SDCARD_STATE_UNKNOWN_FS_FAT(8205),
    CAMERA_SDCARD_STATE_CARD_PROTECT(8206),
    CAMERA_SDCARD_STATE_LOW_SPEED_CARD(8207),
    DSP_UPDATE_SSID_IS_ILLEGAL(8301),
    DSP_UPDATE_WIFI_PWD_IS_ILLEGAL(8302),
    DSP_UPDATE_WIFI_PASSWORD_LENGTH_NOT_MATCH(8303),
    DSP_UPDATE_SSID_LENGTH_NOT_MATCH(8304),
    MISSION_TAKE_OFF_FAILED(8001),
    MISSION_YAW_RECOVER_FAILED(8002),
    MISSION_SET_FLY_SPEED_FAILED(8003),
    MISSION_GO_HOME_FAILED_WITH_BAD_MODE(8004),
    MISSION_GO_HOME_FAILED_WITH_INVALID_STATE(8005),
    MISSION_LAND_FAILED(8006),
    MISSION_CANCEL_LAND_FAILED(8007),
    MISSION_CANCEL_GO_HOME_FAILED(8008),
    MISSION_FLY_LOCATION_AS_HOME_FAILED_WITH_GPS(8009),
    MISSION_LOCATION_AS_HOME_FAILED_WITH_DISARM_OR_LANDING(8010),
    MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_MISSION_MODE(8011),
    MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_GO_HOME_STATE(8012),
    MISSION_PHONE_LOCATION_AS_HOME_FAILED_WITH_DISTANCE(8013),
    MISSION_OPERATE_NOT_ON_GPS_MODE(8014),
    MISSION_OPERATE_BATTERY_NOT_ON_NORMAL_CONDITION(8015),
    MISSION_OPERATE_ON_NO_FLY_ZONE(8016),
    MISSION_ORBIT_SET_MY_LOCATION_TO_ORBIT_ON_UPLOAD_ORBIT_FAILED(8017),
    MISSION_ORBIT_GET_ORBIT_NOT_ON_ORBIT_MODE(8018),
    MISSION_WAYPOINT_START_MISSION_FAILED_ON_UPLOAD_WAYPOINTS(8019),
    MISSION_WAYPOINT_START_MISSION_FAILED_ON_SET_STATE_WAY(8020),
    MISSION_HAS_NOT_PREPARED(8021),
    MISSION_FOLLOW_NEED_NOT_DOWNLOAD_FILE(8022),
    MISSION_DOWNLOAD_NEED_MISSION_MODE(8023),
    MISSION_WAYPOINT_OPERATE_NOT_ON_WAYPOINT_MODE(8024),
    MISSION_CURRENT_MISSION_IS_NULL(8025),
    MISSION_FOLLOW_REAL_TIME_IS_NOT_NEED(8026),
    MISSION_RESUME_NOT_FROM_PAUSE_STATE(8027),
    MISSION_PAUSE_NOT_FROM_START_OR_RESUME(8028),
    MISSION_START_CAN_NOT_FROM_EXECUTING(8029),
    MISSION_HAS_NOT_PREPARED_AS_SPEED_IS_OUT_OF_RANGE(8030),
    WAYPOINT_HAS_NOT_PREPARED_AS_HEIGHT_IS_OUT_OF_RANGE(8031),
    MISSION_HAS_NOT_PREPARED_AS_RANGE_IS_OUT_OF_RANGE(8032),
    MISSION_HAS_NOT_PREPARED_AS_RETURN_HEIGHT_IS_OUT_OF_RANGE(8033),
    WAYPOINT_OUT_OF_MAX_POINTS(8034),
    MISSION_HAS_NOT_PREPARED_AS_HOME_POINT_INVALID(8035),
    ALBUM_CAMERA_NOT_FIND(8100),
    ALBUM_HTTP_FETCH_SERVER_FAILED(8101),
    ALBUM_PARAMS_ARE_NULL(8102),
    AUTHOR_KEY_FETCH_FAILED(8104),
    FIRMWARE_UPGRADE_FAILED(8900),
    FIRMWARE_UPGRADE_FAILED_SEND_FILE(8901),
    FIRMWARE_UPGRADE_FAILED_DRONE_BATTERY_LOW(8902),
    FIRMWARE_UPGRADE_FAILED_RC_BATTERY_LOW(8903),
    FIRMWARE_UPGRADE_FAILED_MOTOR_IS_ARMED(8904),
    FIRMWARE_UPGRADE_FAILED_DISCONNECT(8905),
    FIRMWARE_UPGRADE_FAILED_NO_SDCARD(8906),
    FIRMWARE_UPGRADE_FAILED_SDCARD_ERROR(8907),
    FIRMWARE_UPGRADE_FAILED_SDCARD_FULL(8908),
    FIRMWARE_UPGRADE_FAILED_UNKNOWN_ERROR(8999);
    
    private int code;

    private AutelErrorCode(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public static AutelErrorCode find(int i) {
        AutelErrorCode autelErrorCode = TIMEOUT;
        if (autelErrorCode.getCode() == i) {
            return autelErrorCode;
        }
        AutelErrorCode autelErrorCode2 = DISCONNECTED;
        if (autelErrorCode2.getCode() == i) {
            return autelErrorCode2;
        }
        AutelErrorCode autelErrorCode3 = COMMAND_FAILED;
        if (autelErrorCode3.getCode() == i) {
            return autelErrorCode3;
        }
        return UNKNOWN;
    }
}
