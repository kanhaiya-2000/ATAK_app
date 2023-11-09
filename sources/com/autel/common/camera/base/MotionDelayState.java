package com.autel.common.camera.base;

public enum MotionDelayState {
    STOP(0),
    PAUSE(1),
    TAKING(2),
    UNKNOWN(-1);
    
    private final int value;

    private MotionDelayState(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }

    public static MotionDelayState find(int i) {
        MotionDelayState motionDelayState = STOP;
        if (motionDelayState.value() == i) {
            return motionDelayState;
        }
        MotionDelayState motionDelayState2 = PAUSE;
        if (motionDelayState2.value() == i) {
            return motionDelayState2;
        }
        MotionDelayState motionDelayState3 = TAKING;
        if (motionDelayState3.value() == i) {
            return motionDelayState3;
        }
        return UNKNOWN;
    }
}
