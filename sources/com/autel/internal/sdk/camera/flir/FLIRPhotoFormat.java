package com.autel.internal.sdk.camera.flir;

public enum FLIRPhotoFormat {
    RJPG("RJPG"),
    RJPEG("RJPEG"),
    JPG_TIFF("JPG+TIFF"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private FLIRPhotoFormat(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static FLIRPhotoFormat find(String str) {
        FLIRPhotoFormat fLIRPhotoFormat = RJPG;
        if (fLIRPhotoFormat.getValue().equals(str)) {
            return fLIRPhotoFormat;
        }
        FLIRPhotoFormat fLIRPhotoFormat2 = RJPEG;
        if (fLIRPhotoFormat2.getValue().equals(str)) {
            return fLIRPhotoFormat2;
        }
        FLIRPhotoFormat fLIRPhotoFormat3 = JPG_TIFF;
        if (fLIRPhotoFormat3.getValue().equals(str)) {
            return fLIRPhotoFormat3;
        }
        return UNKNOWN;
    }
}
