package com.autel.common.error;

public class AutelError {
    public static final AutelError ALBUM_CAMERA_NOT_FIND = new AutelError(AutelErrorCode.ALBUM_CAMERA_NOT_FIND, "The camera is not found");
    public static final AutelError ALBUM_PARAMS_ARE_NULL = new AutelError(AutelErrorCode.ALBUM_PARAMS_ARE_NULL, "The input parameters are null");
    public static final AutelError CAMERA_ANTI_FLICKER_ONLY_60Hz_FOR_VIDEO_FPS_OVER_100 = new AutelError(AutelErrorCode.CAMERA_ANTI_FLICKER_ONLY_60Hz_FOR_VIDEO_FPS_OVER_100, "In the video mode, only 60 Hz can be used for the anti-flicker when the frame rate is over 100fps");
    public static final AutelError CAMERA_COLOR_TEMPERATURE_RANGE_OUT = new AutelError(AutelErrorCode.CAMERA_COLOR_TEMPERATURE_RANGE_OUT, "The Color Temperature is out of range");
    public static final AutelError CAMERA_EXPOSURE_NOT_SUPPORT_APERTURE_PRIORITY = new AutelError(AutelErrorCode.CAMERA_EXPOSURE_NOT_SUPPORT_APERTURE_PRIORITY, "The aperture priority is not supported for the current camera type");
    public static final AutelError CAMERA_RESET_NOT_ON_IDLE_MODE = new AutelError(AutelErrorCode.CAMERA_RESET_NOT_ON_IDLE_MODE, "Needs an idle working state to reset the camera");
    public static final AutelError CAMERA_SDCARD_FORMAT_NOT_ON_IDLE_MODE = new AutelError(AutelErrorCode.CAMERA_SDCARD_FORMAT_NOT_ON_IDLE_MODE, "Needs an idle mode formatting SD card ");
    public static final AutelError CAMERA_SDCARD_STATE_CARD_ERROR = new AutelError(AutelErrorCode.CAMERA_SDCARD_STATE_CARD_ERROR, "The SD card is broken");
    public static final AutelError CAMERA_SDCARD_STATE_CARD_FULL = new AutelError(AutelErrorCode.CAMERA_SDCARD_STATE_CARD_FULL, "The SD card is full");
    public static final AutelError CAMERA_SDCARD_STATE_CARD_NOT_SUPPORT = new AutelError(AutelErrorCode.CAMERA_SDCARD_STATE_CARD_NOT_SUPPORT, "The SD card is not supported");
    public static final AutelError CAMERA_SDCARD_STATE_CARD_PROTECT = new AutelError(AutelErrorCode.CAMERA_SDCARD_STATE_CARD_PROTECT, "The SD card is protected");
    public static final AutelError CAMERA_SDCARD_STATE_NO_CARD = new AutelError(AutelErrorCode.CAMERA_SDCARD_STATE_NO_CARD, "No SD card in the camera");
    public static final AutelError CAMERA_SDCARD_STATE_UNKNOWN_FS_FAT = new AutelError(AutelErrorCode.CAMERA_SDCARD_STATE_UNKNOWN_FS_FAT, "The unknown file system format of the SD card");
    public static final AutelError CAMERA_SET_AE_LOCK_STATE_ON_MANUAL_GEAR = new AutelError(AutelErrorCode.CAMERA_SET_AE_LOCK_STATE_ON_MANUAL_GEAR, "Do not set AE state in Manual Exposure Mode");
    public static final AutelError CAMERA_SET_AE_LOCK_STATE_WITH_BAD_PARAMS = new AutelError(AutelErrorCode.CAMERA_SET_AE_LOCK_STATE_WITH_BAD_PARAMS, "Should only use lock or unlock state to set AE");
    public static final AutelError CAMERA_SET_ANTIFLICKER_NOT_ON_AUTO_MODE = new AutelError(AutelErrorCode.CAMERA_SET_ANTI_FLICKER_NOT_ON_AUTO_MODE, "The camera anti-flicker needs to be set in Auto Exposure Mode");
    public static final AutelError CAMERA_SET_CUSTOM_PHOTO_STYLE_NOT_MATCH_METHOD = new AutelError(AutelErrorCode.CAMERA_SET_CUSTOM_PHOTO_STYLE_NOT_MATCH_METHOD, "Should set the camera custom photo style using setCameraCustomPhotoStyle method");
    public static final AutelError CAMERA_SET_EXPOSURE_NOT_ON_AUTO_MODE = new AutelError(AutelErrorCode.CAMERA_SET_EXPOSURE_NOT_ON_AUTO_MODE, "The camera exposure value needs to be set in Auto Exposure Mode");
    public static final AutelError CAMERA_SET_ISO_NOT_ON_MANUAL_MODE = new AutelError(AutelErrorCode.CAMERA_SET_ISO_NOT_ON_MANUAL_MODE, "The camera ISO needs to be set in Manual Exposure Mode");
    public static final AutelError CAMERA_SET_SHUTTER_NOT_ON_MANUAL_MODE = new AutelError(AutelErrorCode.CAMERA_SET_SHUTTER_NOT_ON_MANUAL_MODE, "The camera shutter needs to be set in Manual Exposure Mode");
    public static final AutelError CAMERA_SPOT_METER_AE_NOT_UNLOCK = new AutelError(AutelErrorCode.CAMERA_SPOT_METER_AE_NOT_UNLOCK, "Needs to unlock the auto exposure when setting the spot metering for the camera");
    public static final AutelError CAMERA_START_RECORD_NOT_ON_IDLE_STATE = new AutelError(AutelErrorCode.CAMERA_RECORD_VIDEO_NOT_ON_IDLE_STATE, "Needs an idle status to start recording videos");
    public static final AutelError CAMERA_START_RECORD_NOT_ON_VIDEO_MODE = new AutelError(AutelErrorCode.CAMERA_RECORD_VIDEO_NOT_ON_VIDEO_MODE, "Needs the recording mode to record videos ");
    public static final AutelError CAMERA_STOP_RECORD_NOT_ON_RECORD_STATE = new AutelError(AutelErrorCode.CAMERA_STOP_RECORD_VIDEO_NOT_ON_RECORD_STATE, "Needs a record status to stop recording videos ");
    public static final AutelError CAMERA_STOP_RECORD_NOT_ON_VIDEO_MODE = new AutelError(AutelErrorCode.CAMERA_STOP_RECORD_VIDEO_NOT_ON_VIDEO_MODE, "Needs a video Media Mode to stop recording videos ");
    public static final AutelError CAMERA_STOP_TIMELAPSE_NOT_ON_CAPTURE_STATE = new AutelError(AutelErrorCode.CAMERA_STOP_TIMELAPSE_NOT_ON_CAPTURE_STATE, "Needs a capture state to stop timelapse");
    public static final AutelError CAMERA_STOP_TIMELAPSE_NOT_ON_TIMELAPSE_MODE = new AutelError(AutelErrorCode.CAMERA_STOP_TIMELAPSE_NOT_ON_TIMELAPSE_MODE, "Needs a timelapse Media Mode to stop timelapse");
    public static final AutelError CAMERA_TAKEN_PHOTO_NEED_NOT_ON_UNKNOWN_MODE = new AutelError(AutelErrorCode.CAMERA_TAKEN_PHOTO_NEED_NOT_ON_UNKNOWN_MODE, "Unable to take photos in the unknown mode");
    public static final AutelError CAMERA_TAKEN_PHOTO_NEED_RECORD_STATE_ON_VIDEO_MODE = new AutelError(AutelErrorCode.CAMERA_TAKEN_PHOTO_NEED_RECORD_STATE_ON_VIDEO_MODE, "Taking photos during the recording needs to choose the recording mode");
    public static final AutelError CAMERA_TAKEN_PHOTO_NOT_ALLOWED_IN_4KP_60FPS_H265 = new AutelError(AutelErrorCode.CAMERA_TAKEN_PHOTO_NOT_ALLOWED_IN_4KP_60FPS_H265, "Not able to take photos when 4K RESOLUTION and 60FPS are activated, if you choose H.265 as an Video Encoding Format");
    public static final AutelError CAMERA_TAKEN_PHOTO_NOT_ON_IDLE_STATE = new AutelError(AutelErrorCode.CAMERA_TAKEN_PHOTO_NOT_ON_IDLE, "Needs an idle status when starting to taking photos");
    public static final AutelError CAMERA_TAKEN_PHOTO_NOT_ON_PHOTO_MODE = new AutelError(AutelErrorCode.CAMERA_TAKEN_PHOTO_NOT_ON_PHOTO_MODE, "Taking photos needs to choose the shooting mode");
    public static final AutelError CAMERA_THE_RESOLUTION_OR_FRAME_IS_NOT_SUPPORT = new AutelError(AutelErrorCode.CAMERA_THE_RESOLUTION_OR_FRAME_IS_NOT_SUPPORT, "This resolution or rate is not supported");
    public static final AutelError COMMAND_FAILED = new AutelError(AutelErrorCode.COMMAND_FAILED, "The command failed");
    public static final AutelError COMMAND_FAILED_JOIN_QUEUE = new AutelError(AutelErrorCode.COMMAND_FAILED_JOIN_QUEUE, "The command is failed when data join the queue");
    public static final AutelError COMMAND_IS_NOT_SUPPORTED_FOR_CURRENT_VERSION = new AutelError(AutelErrorCode.COMMAND_IS_NOT_SUPPORTED_FOR_CURRENT_VERSION, "The current version does not support this command");
    public static final AutelError COMMAND_PARAMS_ARE_INVALID = new AutelError(AutelErrorCode.COMMAND_PARAMS_ARE_INVALID, "The command parameters are invalid");
    public static final AutelError COMMAND_PARAMS_ARE_NULL = new AutelError(AutelErrorCode.COMMAND_FAILED, "The command parameters are null");
    public static final AutelError COMMAND_PARAMS_ARE_OUT_OF_RANGE = new AutelError(AutelErrorCode.COMMAND_PARAMS_ARE_OUT_OF_RANGE, "The command parameters are out of range");
    public static final AutelError COMMAND_UNKNOWN = new AutelError(AutelErrorCode.COMMAND_FAILED, "With an unknown state the command is invalid");
    public static final AutelError COMMON_CANCEL = new AutelError(AutelErrorCode.COMMAND_CANCEL, "The command is canceled");
    public static final AutelError COMMON_DISCONNECTED = new AutelError(AutelErrorCode.DISCONNECTED, "Disconnected");
    public static final AutelError COMMON_PARSER_PARAMETER_FAILED = new AutelError(AutelErrorCode.COMMON_PARSER_PARAMETER_FAILED, "The parser command is failed");
    public static final AutelError COMMON_TIMEOUT = new AutelError(AutelErrorCode.TIMEOUT, "The execution of this process has timed out");
    public static final AutelError COMMON_UNKNOWN = new AutelError(AutelErrorCode.UNKNOWN, "Server error");
    public static final AutelError DSP_UPDATE_SSID_IS_ILLEGAL = new AutelError(AutelErrorCode.DSP_UPDATE_SSID_IS_ILLEGAL, "The Wi-Fi name is illegal");
    public static final AutelError DSP_UPDATE_SSID_LENGTH_NOT_MATCH = new AutelError(AutelErrorCode.DSP_UPDATE_SSID_LENGTH_NOT_MATCH, "The Wi-Fi name must be between 8 to 16 characters");
    public static final AutelError DSP_UPDATE_WIFI_PASSWORD_LENGTH_NOT_MATCH = new AutelError(AutelErrorCode.DSP_UPDATE_WIFI_PASSWORD_LENGTH_NOT_MATCH, "The Wi-Fi password must be between 8 to 16 characters");
    public static final AutelError DSP_UPDATE_WIFI_PWD_IS_ILLEGAL = new AutelError(AutelErrorCode.DSP_UPDATE_WIFI_PWD_IS_ILLEGAL, "The Wi-Fi password is illegal");
    public static final AutelError FLY_BEGIN_MODE_CHANGE_FAILED_WHEN_FLYING = new AutelError(AutelErrorCode.FLY_BEGIN_MODE_CHANGE_FAILED_WHEN_FLYING, "Failed to switch the beginner mode during the flight");
    public static final AutelError FLY_CALIBRATE_COMPASS_FAILED_AS_GPS_UNAVAILABLE = new AutelError(AutelErrorCode.FLY_CALIBRATE_COMPASS_FAILED_AS_GPS_UNAVAILABLE, "Unable to calibrate the compass when GPS signal is not available");
    public static final AutelError FLY_CALIBRATE_COMPASS_FAILED_AS_NOT_IN_DISARM_MODE = new AutelError(AutelErrorCode.FLY_CALIBRATE_COMPASS_FAILED_AS_NOT_IN_DISARM_MODE, "The compass can only be calibrated when the aircraft is disarmed");
    public static final AutelError FLY_UPLOAD_FILE_CREATE_FAILED = new AutelError(AutelErrorCode.FLY_UPLOAD_FILE_CREATE_FAILED, "Failed to switch the beginner mode during the flight");
    public static final AutelError FLY_UPLOAD_FILE_MD5_ERROR = new AutelError(AutelErrorCode.FLY_UPLOAD_FILE_MD5_ERROR, "Failed to switch the beginner mode during the flight");
    public static final AutelError FLY_UPLOAD_FILE_MD5_NOT_SAME = new AutelError(AutelErrorCode.FLY_UPLOAD_FILE_MD5_NOT_SAME, "Failed to switch the beginner mode during the flight");
    public static final AutelError FLY_UPLOAD_FILE_MD5_SAME = new AutelError(AutelErrorCode.FLY_UPLOAD_FILE_MD5_SAME, "Failed to switch the beginner mode during the flight");
    public static final AutelError FLY_UPLOAD_FILE_NOT_ENOUGHT_SPACE = new AutelError(AutelErrorCode.FLY_UPLOAD_FILE_NOT_ENOUGHT_SPACE, "Failed to switch the beginner mode during the flight");
    public static final AutelError FLY_UPLOAD_FILE_NOT_EXIST = new AutelError(AutelErrorCode.FLY_UPLOAD_FILE_NOT_EXIST, "Failed to switch the beginner mode during the flight");
    public static final AutelError FLY_UPLOAD_FILE_READ_FAILED = new AutelError(AutelErrorCode.FLY_UPLOAD_FILE_READ_FAILED, "Failed to switch the beginner mode during the flight");
    public static final AutelError FLY_UPLOAD_FILE_WRITE_FAILED = new AutelError(AutelErrorCode.FLY_UPLOAD_FILE_WRITE_FAILED, "Failed to switch the beginner mode during the flight");
    public static final AutelError MISSION_CANCEL_LAND_FAILED = new AutelError(AutelErrorCode.MISSION_CANCEL_LAND_FAILED, "The aircraft can cancel land only when landing");
    public static final AutelError MISSION_CURRENT_MISSION_IS_NULL = new AutelError(AutelErrorCode.MISSION_CURRENT_MISSION_IS_NULL, "The current mission is empty");
    public static final AutelError MISSION_DOWNLOAD_NEED_MISSION_MODE = new AutelError(AutelErrorCode.MISSION_DOWNLOAD_NEED_MISSION_MODE, "The mission information can only be downloaded in the mission mode");
    public static final AutelError MISSION_FOLLOW_NEED_NOT_DOWNLOAD_FILE = new AutelError(AutelErrorCode.MISSION_FOLLOW_NEED_NOT_DOWNLOAD_FILE, "A follow mission does not need to download data");
    public static final AutelError MISSION_FOLLOW_REAL_TIME_IS_NOT_NEED = new AutelError(AutelErrorCode.MISSION_FOLLOW_REAL_TIME_IS_NOT_NEED, "A follow mission does not need to monitor the real time information");
    public static final AutelError MISSION_GO_HOME_FAILED_WITH_BAD_MODE = new AutelError(AutelErrorCode.MISSION_GO_HOME_FAILED_WITH_BAD_MODE, "Unable to go home in LANDING | MOTOR_SPINNING | DISARM mode");
    public static final AutelError MISSION_GO_HOME_FAILED_WITH_INVALID_STATE = new AutelError(AutelErrorCode.MISSION_GO_HOME_FAILED_WITH_INVALID_STATE, "Unable to go home when GPS | Home Point | Compass is invalid");
    public static final AutelError MISSION_HAS_NOT_PREPARED = new AutelError(AutelErrorCode.MISSION_HAS_NOT_PREPARED, "A mission has not been prepared");
    public static final AutelError MISSION_HAS_NOT_PREPARED_AS_HOME_POINT_INVALID = new AutelError(AutelErrorCode.MISSION_HAS_NOT_PREPARED_AS_HOME_POINT_INVALID, "A mission has not been prepared since the home point is invalid");
    public static final AutelError MISSION_HAS_NOT_PREPARED_AS_RANGE_IS_OUT_OF_RANGE = new AutelError(AutelErrorCode.MISSION_HAS_NOT_PREPARED_AS_RANGE_IS_OUT_OF_RANGE, "A mission has not been prepared since the aircraft flight range is out of range");
    public static final AutelError MISSION_HAS_NOT_PREPARED_AS_RETURN_HEIGHT_IS_OUT_OF_RANGE = new AutelError(AutelErrorCode.MISSION_HAS_NOT_PREPARED_AS_RETURN_HEIGHT_IS_OUT_OF_RANGE, "A mission has not been prepared since the return height is out of range");
    public static final AutelError MISSION_HAS_NOT_PREPARED_AS_SPEED_IS_OUT_OF_RANGE = new AutelError(AutelErrorCode.MISSION_HAS_NOT_PREPARED_AS_SPEED_IS_OUT_OF_RANGE, "A mission has not been prepared since the speed is out of range");
    public static final AutelError MISSION_LAND_FAILED = new AutelError(AutelErrorCode.MISSION_LAND_FAILED, "The land mission is failed because the aircraft has already landed");
    public static final AutelError MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_GO_HOME_STATE = new AutelError(AutelErrorCode.MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_GO_HOME_STATE, "Unable to set the location since the home point in a go home state");
    public static final AutelError MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_MISSION_MODE = new AutelError(AutelErrorCode.MISSION_LOCATION_AS_HOME_FAILED_SHOULD_NOT_ON_MISSION_MODE, "Unable to set the location since the home point in the mission mode(such as Orbit|Follow|Waypoint)");
    public static final AutelError MISSION_LOCATION_AS_HOME_FAILED_WITH_DISARM_OR_LANDING = new AutelError(AutelErrorCode.MISSION_LOCATION_AS_HOME_FAILED_WITH_DISARM_OR_LANDING, "Cannot set the location since the home point in disarm|landing mode");
    public static final AutelError MISSION_LOCATION_AS_HOME_FAILED_WITH_GPS = new AutelError(AutelErrorCode.MISSION_FLY_LOCATION_AS_HOME_FAILED_WITH_GPS, "Failed to set fly location since the home point with invalid GPS");
    public static final AutelError MISSION_PHONE_LOCATION_AS_HOME_FAILED_WITH_DISTANCE = new AutelError(AutelErrorCode.MISSION_PHONE_LOCATION_AS_HOME_FAILED_WITH_DISTANCE, "Failed to set the phone location since the home point with distance over 5000m");
    public static final AutelError MISSION_TAKE_OFF_FAILED = new AutelError(AutelErrorCode.MISSION_TAKE_OFF_FAILED, "The aircraft only can take off in GPS and MOTOR SPINNING mode");
    public static final AutelError RESOLUTION_OR_FPS_IS_NOT_MATCH = new AutelError(AutelErrorCode.RESOLUTION_OR_FPS_IS_NOT_MATCH, "The current video standard does not support the resolution and fps");
    public static final AutelError SDK_AUTHOR_NEED_MORE_THAN_DISABLE = new AutelError(AutelErrorCode.SDK_APP_KEY_INVALIDATE, "The SDK permission needs limit and normal levels");
    public static final AutelError SDK_AUTHOR_NEED_NORMAL_LEVEL = new AutelError(AutelErrorCode.SDK_AUTHOR_NEED_NORMAL_LEVEL, "The SDK permission needs a normal level");
    public static final AutelError SDK_HAS_NOT_CONNECT_TO_AIRCRAFT = new AutelError(AutelErrorCode.SDK_HAS_NOT_CONNECT_TO_AIRCRAFT, "The aircraft has not been connected");
    public static final AutelError SDK_HAS_NOT_CONNECT_TO_CAMERA = new AutelError(AutelErrorCode.SDK_HAS_NOT_CONNECT_TO_CAMERA, "The camera has not been connected");
    public static final AutelError SDK_HAS_NOT_CONNECT_TO_REMOTE_CONTROLLER = new AutelError(AutelErrorCode.SDK_HAS_NOT_CONNECT_TO_REMOTE_CONTROLLER, "The remote controller has not been connected");
    public static final AutelError SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED = new AutelError(AutelErrorCode.SDK_MODULE_SERVICE_HAS_NOT_BEEN_INITIALIZED, "The SDK init is failed since the communication to the aircraft has not been built up");
    public static final AutelError TAKE_PHOTO_FAILED = new AutelError(AutelErrorCode.COMMAND_FAILED, "The take photo is failed");
    public static final AutelError WAYPOINT_HAS_NOT_PREPARED_AS_HEIGHT_IS_OUT_OF_RANGE = new AutelError(AutelErrorCode.WAYPOINT_HAS_NOT_PREPARED_AS_HEIGHT_IS_OUT_OF_RANGE, "A waypoint mission has not been prepared since the height is out of range");
    public static final AutelError WAYPOINT_OUT_OF_MAX_POINTS = new AutelError(AutelErrorCode.WAYPOINT_OUT_OF_MAX_POINTS, "Waypoint is out of max points");
    protected AutelErrorCode errCode;
    protected String mDescription;

    protected AutelError() {
    }

    private AutelError(String str) {
        this.mDescription = str;
    }

    public AutelError(AutelErrorCode autelErrorCode, String str) {
        this.mDescription = str;
        this.errCode = autelErrorCode;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public AutelErrorCode getErrCode() {
        return this.errCode;
    }
}
