package com.autel.common.flycontroller.visual;

public enum DynamicTrackMode {
    STOP_MODE(0),
    COMMON_MODE(1),
    PARALLEL_MODE(2),
    LOCKED_MODE(3),
    UNKNOWN(-1);
    
    int mode;

    private DynamicTrackMode(int i) {
        this.mode = i;
    }

    public int getMode() {
        return this.mode;
    }

    public static DynamicTrackMode findMode(int i) {
        DynamicTrackMode dynamicTrackMode = COMMON_MODE;
        if (dynamicTrackMode.getMode() == i) {
            return dynamicTrackMode;
        }
        DynamicTrackMode dynamicTrackMode2 = PARALLEL_MODE;
        if (dynamicTrackMode2.getMode() == i) {
            return dynamicTrackMode2;
        }
        DynamicTrackMode dynamicTrackMode3 = LOCKED_MODE;
        if (dynamicTrackMode3.getMode() == i) {
            return dynamicTrackMode3;
        }
        DynamicTrackMode dynamicTrackMode4 = STOP_MODE;
        if (dynamicTrackMode4.getMode() == i) {
            return dynamicTrackMode4;
        }
        return UNKNOWN;
    }
}
