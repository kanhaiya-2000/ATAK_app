package com.autel.internal.sdk.camera.flir;

public enum FLIRDisplayMode {
    NORMAL("Visible"),
    PICTURE_IN_PICTURE("PictureInPicture"),
    IR("IR"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private FLIRDisplayMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
