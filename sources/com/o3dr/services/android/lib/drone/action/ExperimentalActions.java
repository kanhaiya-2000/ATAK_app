package com.o3dr.services.android.lib.drone.action;

public class ExperimentalActions {
    public static final String ACTION_EPM_COMMAND = "com.o3dr.services.android.action.EPM_COMMAND";
    public static final String ACTION_SEND_MAVLINK_MESSAGE = "com.o3dr.services.android.action.SEND_MAVLINK_MESSAGE";
    public static final String ACTION_SET_RELAY = "com.o3dr.services.android.action.SET_RELAY";
    public static final String ACTION_SET_ROI = "com.o3dr.services.android.action.SET_ROI";
    public static final String ACTION_SET_SERVO = "com.o3dr.services.android.action.SET_SERVO";
    public static final String ACTION_START_VIDEO_STREAM_FOR_OBSERVER = "com.o3dr.services.android.action.camera.START_VIDEO_STREAM_FOR_OBSERVER";
    public static final String ACTION_STOP_VIDEO_STREAM_FOR_OBSERVER = "com.o3dr.services.android.action.camera.STOP_VIDEO_STREAM_FOR_OBSERVER";
    public static final String ACTION_TRIGGER_CAMERA = "com.o3dr.services.android.action.TRIGGER_CAMERA";
    public static final String EXTRA_EPM_RELEASE = "com.o3dr.services.androidextra_epm_release";
    public static final String EXTRA_IS_RELAY_ON = "extra_is_relay_on";
    public static final String EXTRA_MAVLINK_MESSAGE = "extra_mavlink_message";
    public static final String EXTRA_RELAY_NUMBER = "extra_relay_number";
    public static final String EXTRA_SERVO_CHANNEL = "extra_servo_channel";
    public static final String EXTRA_SERVO_PWM = "extra_servo_PWM";
    public static final String EXTRA_SET_ROI_LAT_LONG_ALT = "extra_set_roi_lat_long_alt";

    private ExperimentalActions() {
    }
}
