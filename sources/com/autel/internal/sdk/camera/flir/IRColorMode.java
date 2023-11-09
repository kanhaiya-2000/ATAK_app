package com.autel.internal.sdk.camera.flir;

public enum IRColorMode {
    HOT_METAL("HotMetal"),
    WHITE_HOT("WhiteHot"),
    RAINBOW("Rainbow"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private IRColorMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
