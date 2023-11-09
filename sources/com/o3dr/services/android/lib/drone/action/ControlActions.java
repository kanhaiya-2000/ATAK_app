package com.o3dr.services.android.lib.drone.action;

public class ControlActions {
    public static final String ACTION_DO_GUIDED_TAKEOFF = "com.o3dr.services.android.action.DO_GUIDED_TAKEOFF";
    public static final String ACTION_ENABLE_MANUAL_CONTROL = "com.o3dr.services.android.lib.drone.action.control.ENABLE_MANUAL_CONTROL";
    public static final String ACTION_LOOK_AT_TARGET = "com.o3dr.services.android.lib.drone.action.control.action.LOOK_AT_TARGET";
    public static final String ACTION_SEND_BRAKE_VEHICLE = "com.o3dr.services.android.lib.drone.action.control.action.SEND_BRAKE_VEHICLE";
    public static final String ACTION_SEND_GUIDED_POINT = "com.o3dr.services.android.action.SEND_GUIDED_POINT";
    public static final String ACTION_SET_CONDITION_YAW = "com.o3dr.services.android.lib.drone.action.control.SET_CONDITION_YAW";
    public static final String ACTION_SET_GUIDED_ALTITUDE = "com.o3dr.services.android.action.SET_GUIDED_ALTITUDE";
    public static final String ACTION_SET_VELOCITY = "com.o3dr.services.android.lib.drone.action.control.SET_VELOCITY";
    public static final String EXTRA_ALTITUDE = "extra_altitude";
    public static final String EXTRA_DO_ENABLE = "extra_do_enable";
    public static final String EXTRA_FORCE_GUIDED_POINT = "extra_force_guided_point";
    public static final String EXTRA_GUIDED_POINT = "extra_guided_point";
    public static final String EXTRA_LOOK_AT_TARGET = "extra_look_at_target";
    public static final String EXTRA_VELOCITY_X = "extra_velocity_x";
    public static final String EXTRA_VELOCITY_Y = "extra_velocity_y";
    public static final String EXTRA_VELOCITY_Z = "extra_velocity_z";
    public static final String EXTRA_YAW_CHANGE_RATE = "extra_yaw_change_rate";
    public static final String EXTRA_YAW_IS_RELATIVE = "extra_yaw_is_relative";
    public static final String EXTRA_YAW_TARGET_ANGLE = "extra_yaw_target_angle";
    private static final String PACKAGE_NAME = "com.o3dr.services.android.lib.drone.action.control";

    private ControlActions() {
    }
}
