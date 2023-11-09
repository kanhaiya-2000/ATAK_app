package com.autel.internal.sdk.camera.flir;

public enum IRFileFormat {
    MOV("MOV"),
    TIFF("TIFF"),
    UNKNOWN("UNKNOWN");
    
    private String value;

    private IRFileFormat(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static IRFileFormat find(String str) {
        IRFileFormat iRFileFormat = MOV;
        if (iRFileFormat.getValue().equals(str)) {
            return iRFileFormat;
        }
        IRFileFormat iRFileFormat2 = TIFF;
        return iRFileFormat2.getValue().equals(str) ? iRFileFormat2 : iRFileFormat;
    }
}
