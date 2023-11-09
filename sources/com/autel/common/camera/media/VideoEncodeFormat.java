package com.autel.common.camera.media;

public enum VideoEncodeFormat {
    H264("H264"),
    H265("H265"),
    UNKNOWN("Unknown");
    
    private final String value;

    private VideoEncodeFormat(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static VideoEncodeFormat find(String str) {
        VideoEncodeFormat videoEncodeFormat = H264;
        if (videoEncodeFormat.getValue().equalsIgnoreCase(str)) {
            return videoEncodeFormat;
        }
        VideoEncodeFormat videoEncodeFormat2 = H265;
        if (videoEncodeFormat2.getValue().equalsIgnoreCase(str)) {
            return videoEncodeFormat2;
        }
        return UNKNOWN;
    }
}
