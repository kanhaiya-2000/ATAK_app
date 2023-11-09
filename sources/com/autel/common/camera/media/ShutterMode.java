package com.autel.common.camera.media;

public enum ShutterMode {
    MECHANICAL("Mechanical"),
    ELECTRONIC("Electronic"),
    UNKNOWN("Unknown");
    
    private String value;

    private ShutterMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static ShutterMode find(String str) {
        ShutterMode shutterMode = MECHANICAL;
        if (shutterMode.getValue().equals(str)) {
            return shutterMode;
        }
        ShutterMode shutterMode2 = ELECTRONIC;
        if (shutterMode2.getValue().equals(str)) {
            return shutterMode2;
        }
        return UNKNOWN;
    }
}
