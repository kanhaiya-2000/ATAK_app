package com.autel.common.camera.media;

public enum VideoRotation {
    ROTATION_0(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(270),
    UNKNOWN(-1);
    
    private int value;

    private VideoRotation(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static VideoRotation find(int i) {
        VideoRotation videoRotation = ROTATION_0;
        if (videoRotation.getValue() == i) {
            return videoRotation;
        }
        VideoRotation videoRotation2 = ROTATION_90;
        if (videoRotation2.getValue() == i) {
            return videoRotation2;
        }
        VideoRotation videoRotation3 = ROTATION_180;
        if (videoRotation3.getValue() == i) {
            return videoRotation3;
        }
        VideoRotation videoRotation4 = ROTATION_270;
        if (videoRotation4.getValue() == i) {
            return videoRotation4;
        }
        return UNKNOWN;
    }
}
