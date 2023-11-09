package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum VideoResolution {
    Resolution_7680x4320("7680*4320"),
    Resolution_5760x3240("5760*3240"),
    Resolution_5472x3076("5472*3076"),
    Resolution_4800x2700("4800*2700"),
    Resolution_4096x2160("4096*2160"),
    Resolution_3840x2160("3840*2160"),
    Resolution_2720x1530("2720*1530"),
    Resolution_2720x1528("2720*1528"),
    Resolution_1920x1080("1920*1080"),
    Resolution_1280x720("1280*720"),
    Resolution_640x512("640*512"),
    Resolution_1280x1024("1280*1024"),
    UNKNOWN(SoloControllerUnits.UNKNOWN);
    
    private final String value;

    private VideoResolution(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public static VideoResolution find(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        String replace = str.replace("x", "*");
        VideoResolution videoResolution = Resolution_7680x4320;
        if (replace.contains(videoResolution.value)) {
            return videoResolution;
        }
        VideoResolution videoResolution2 = Resolution_5760x3240;
        if (replace.contains(videoResolution2.value)) {
            return videoResolution2;
        }
        VideoResolution videoResolution3 = Resolution_5472x3076;
        if (replace.contains(videoResolution3.value)) {
            return videoResolution3;
        }
        VideoResolution videoResolution4 = Resolution_4800x2700;
        if (replace.contains(videoResolution4.value)) {
            return videoResolution4;
        }
        VideoResolution videoResolution5 = Resolution_4096x2160;
        if (replace.contains(videoResolution5.value)) {
            return videoResolution5;
        }
        VideoResolution videoResolution6 = Resolution_3840x2160;
        if (replace.contains(videoResolution6.value)) {
            return videoResolution6;
        }
        VideoResolution videoResolution7 = Resolution_2720x1530;
        if (replace.contains(videoResolution7.value)) {
            return videoResolution7;
        }
        VideoResolution videoResolution8 = Resolution_1920x1080;
        if (replace.contains(videoResolution8.value)) {
            return videoResolution8;
        }
        VideoResolution videoResolution9 = Resolution_1280x720;
        if (replace.contains(videoResolution9.value)) {
            return videoResolution9;
        }
        VideoResolution videoResolution10 = Resolution_2720x1528;
        if (replace.contains(videoResolution10.value)) {
            return videoResolution10;
        }
        VideoResolution videoResolution11 = Resolution_640x512;
        if (replace.contains(videoResolution11.value)) {
            return videoResolution11;
        }
        return UNKNOWN;
    }
}
