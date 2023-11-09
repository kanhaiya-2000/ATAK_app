package com.autel.common.camera.base;

public enum CameraPattern {
    FREE_FLIGHT(0),
    MISSION_FLIGHT(1),
    INTELLIGENT_FLIGHT(2),
    DELAYED_PHOTOGRAPHY(3),
    VISUAL_ORBIT(4);
    
    private final int value;

    private CameraPattern(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
