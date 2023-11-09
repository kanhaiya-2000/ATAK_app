package com.autel.internal.sdk.camera.flir;

public enum FLIRPipPosition {
    LEFT_TOP("LeftUp"),
    CENTER_TOP("MiddleUp"),
    RIGHT_TOP("RightUp"),
    RIGHT_CENTER("RightMiddle"),
    RIGHT_BOTTOM("RightDown"),
    CENTER_BOTTOM("MiddleDown"),
    LEFT_CENTER("LeftMiddle"),
    LEFT_DOWN("LeftDown"),
    CENTER("Central"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private FLIRPipPosition(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static FLIRPipPosition find(String str) {
        FLIRPipPosition fLIRPipPosition = LEFT_TOP;
        if (fLIRPipPosition.getValue().equals(str)) {
            return fLIRPipPosition;
        }
        FLIRPipPosition fLIRPipPosition2 = CENTER_TOP;
        if (fLIRPipPosition2.getValue().equals(str)) {
            return fLIRPipPosition2;
        }
        FLIRPipPosition fLIRPipPosition3 = RIGHT_TOP;
        if (fLIRPipPosition3.getValue().equals(str)) {
            return fLIRPipPosition3;
        }
        FLIRPipPosition fLIRPipPosition4 = RIGHT_CENTER;
        if (fLIRPipPosition4.getValue().equals(str)) {
            return fLIRPipPosition4;
        }
        FLIRPipPosition fLIRPipPosition5 = RIGHT_BOTTOM;
        if (fLIRPipPosition5.getValue().equals(str)) {
            return fLIRPipPosition5;
        }
        FLIRPipPosition fLIRPipPosition6 = CENTER_BOTTOM;
        if (fLIRPipPosition6.getValue().equals(str)) {
            return fLIRPipPosition6;
        }
        FLIRPipPosition fLIRPipPosition7 = LEFT_CENTER;
        if (fLIRPipPosition7.getValue().equals(str)) {
            return fLIRPipPosition7;
        }
        FLIRPipPosition fLIRPipPosition8 = LEFT_DOWN;
        if (fLIRPipPosition8.getValue().equals(str)) {
            return fLIRPipPosition8;
        }
        FLIRPipPosition fLIRPipPosition9 = CENTER;
        if (fLIRPipPosition9.getValue().equals(str)) {
            return fLIRPipPosition9;
        }
        return UNKNOWN;
    }
}
