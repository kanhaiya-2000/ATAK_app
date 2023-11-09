package com.autel.common.dsp;

public enum AppActionParam {
    TRACKING(1),
    VIEWPOINT(2),
    ALBUM(3),
    UNKNOWN(-1);
    
    private final int value;

    private AppActionParam(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static AppActionParam find(int i) {
        AppActionParam appActionParam = TRACKING;
        if (appActionParam.value == i) {
            return appActionParam;
        }
        AppActionParam appActionParam2 = VIEWPOINT;
        if (appActionParam2.value == i) {
            return appActionParam2;
        }
        AppActionParam appActionParam3 = ALBUM;
        if (appActionParam3.value == i) {
            return appActionParam3;
        }
        return UNKNOWN;
    }
}
