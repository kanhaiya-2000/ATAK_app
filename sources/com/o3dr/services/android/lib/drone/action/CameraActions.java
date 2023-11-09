package com.o3dr.services.android.lib.drone.action;

public class CameraActions {
    public static final String ACTION_START_VIDEO_STREAM = "com.o3dr.services.android.lib.drone.companion.solo.action.camera.START_VIDEO_STREAM";
    public static final String ACTION_STOP_VIDEO_STREAM = "com.o3dr.services.android.lib.drone.companion.solo.action.camera.STOP_VIDEO_STREAM";
    public static final String EXTRA_VIDEO_DISPLAY = "extra_video_display";
    public static final String EXTRA_VIDEO_ENABLE_LOCAL_RECORDING = "extra_video_enable_local_recording";
    public static final String EXTRA_VIDEO_LOCAL_RECORDING_FILENAME = "extra_video_local_recording_filename";
    public static final String EXTRA_VIDEO_PROPERTIES = "extra_video_properties";
    public static final String EXTRA_VIDEO_PROPS_UDP_PORT = "extra_video_props_udp_port";
    public static final String EXTRA_VIDEO_TAG = "extra_video_tag";
    private static final String PACKAGE_NAME = "com.o3dr.services.android.lib.drone.companion.solo.action.camera";

    private CameraActions() {
    }
}
