package com.autel.common.dsp;

public enum DeviceType {
    DEV_UAV(1),
    DEV_DSP(2),
    DEV_DSP_RC(3),
    DEV_RC_PLAYER(4),
    DEV_ESC_PITCH(7),
    DEV_ESC_ROLL(8),
    DEV_ESC_YAW(9),
    DEV_BATTERY(10),
    DEV_GIMBAL(11),
    DEV_RC_ANDROID(13),
    DEV_RC(14),
    DEV_MOVIDIUS_1(25),
    DEV_CAMERA(33),
    ALL(255),
    UNKNOWN(-1);
    
    private final int value;

    private DeviceType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
