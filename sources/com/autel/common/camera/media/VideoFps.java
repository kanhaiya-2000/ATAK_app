package com.autel.common.camera.media;

import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum VideoFps {
    FrameRate_9ps("p9", 9),
    FrameRate_24ps("p24", 24),
    FrameRate_25ps("p25", 25),
    FrameRate_30ps("p30", 30),
    FrameRate_30ps_HDR("p30hdr", 30),
    FrameRate_48ps("p48", 48),
    FrameRate_50ps("p50", 50),
    FrameRate_60ps("p60", 60),
    FrameRate_60ps_HDR("p60hdr", 60),
    FrameRate_120ps("p120", 120),
    FrameRate_120ps_HDR("p120hdr", 120),
    FrameRate_240ps("p240", 240),
    UNKNOWN(SoloControllerUnits.UNKNOWN, -1);
    
    private final int fps;
    private final String value;

    private VideoFps(String str, int i) {
        this.value = str;
        this.fps = i;
    }

    public String value() {
        return this.value;
    }

    public int fps() {
        return this.fps;
    }

    public static VideoFps find(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        VideoFps videoFps = FrameRate_9ps;
        if (str.equals(videoFps.value)) {
            return videoFps;
        }
        VideoFps videoFps2 = FrameRate_24ps;
        if (str.equals(videoFps2.value)) {
            return videoFps2;
        }
        VideoFps videoFps3 = FrameRate_25ps;
        if (str.equals(videoFps3.value)) {
            return videoFps3;
        }
        VideoFps videoFps4 = FrameRate_30ps;
        if (str.equals(videoFps4.value)) {
            return videoFps4;
        }
        VideoFps videoFps5 = FrameRate_48ps;
        if (str.equals(videoFps5.value)) {
            return videoFps5;
        }
        VideoFps videoFps6 = FrameRate_50ps;
        if (str.equals(videoFps6.value)) {
            return videoFps6;
        }
        VideoFps videoFps7 = FrameRate_60ps;
        if (str.equals(videoFps7.value)) {
            return videoFps7;
        }
        VideoFps videoFps8 = FrameRate_120ps;
        if (str.equals(videoFps8.value)) {
            return videoFps8;
        }
        VideoFps videoFps9 = FrameRate_240ps;
        if (str.contains(videoFps9.value)) {
            return videoFps9;
        }
        VideoFps videoFps10 = FrameRate_30ps_HDR;
        if (str.contains(videoFps10.value)) {
            return videoFps10;
        }
        VideoFps videoFps11 = FrameRate_60ps_HDR;
        if (str.contains(videoFps11.value)) {
            return videoFps11;
        }
        VideoFps videoFps12 = FrameRate_120ps_HDR;
        if (str.contains(videoFps12.value)) {
            return videoFps12;
        }
        return UNKNOWN;
    }

    public static VideoFps find(int i) {
        if (-1 == i) {
            return UNKNOWN;
        }
        VideoFps videoFps = FrameRate_24ps;
        if (i == videoFps.fps) {
            return videoFps;
        }
        VideoFps videoFps2 = FrameRate_25ps;
        if (i == videoFps2.fps) {
            return videoFps2;
        }
        VideoFps videoFps3 = FrameRate_30ps;
        if (i == videoFps3.fps) {
            return videoFps3;
        }
        VideoFps videoFps4 = FrameRate_48ps;
        if (i == videoFps4.fps) {
            return videoFps4;
        }
        VideoFps videoFps5 = FrameRate_50ps;
        if (i == videoFps5.fps) {
            return videoFps5;
        }
        VideoFps videoFps6 = FrameRate_60ps;
        if (i == videoFps6.fps) {
            return videoFps6;
        }
        VideoFps videoFps7 = FrameRate_120ps;
        if (i == videoFps7.fps) {
            return videoFps7;
        }
        VideoFps videoFps8 = FrameRate_240ps;
        if (i == videoFps8.fps) {
            return videoFps8;
        }
        VideoFps videoFps9 = FrameRate_30ps_HDR;
        if (i == videoFps9.fps) {
            return videoFps9;
        }
        VideoFps videoFps10 = FrameRate_60ps_HDR;
        if (i == videoFps10.fps) {
            return videoFps10;
        }
        VideoFps videoFps11 = FrameRate_120ps_HDR;
        if (i == videoFps11.fps) {
            return videoFps11;
        }
        return UNKNOWN;
    }
}
