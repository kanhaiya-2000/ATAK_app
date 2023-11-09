package com.autel.internal.sdk.camera.base;

import com.autel.common.camera.media.VideoStandard;
import com.o3dr.services.android.lib.drone.companion.solo.controller.SoloControllerUnits;

public enum CameraVideoResolutionAndFpsTemp {
    NTSC_4096_2160_p24("4096*2160p24", VideoStandard.NTSC),
    NTSC_3840_2160_p30("3840*2160p30", VideoStandard.NTSC),
    NTSC_3840_2160_p24("3840*2160p24", VideoStandard.NTSC),
    NTSC_2704_1520_p60("2704*1520p60", VideoStandard.NTSC),
    NTSC_2704_1520_p48("2704*1520p48", VideoStandard.NTSC),
    NTSC_2704_1520_p30("2704*1520p30", VideoStandard.NTSC),
    NTSC_2704_1520_p24("2704*1520p24", VideoStandard.NTSC),
    NTSC_1920_1080_p120("1920*1080p120", VideoStandard.NTSC),
    NTSC_1920_1080_p60("1920*1080p60", VideoStandard.NTSC),
    NTSC_1920_1080_p48("1920*1080p48", VideoStandard.NTSC),
    NTSC_1920_1080_p30("1920*1080p30", VideoStandard.NTSC),
    NTSC_1920_1080_p24("1920*1080p24", VideoStandard.NTSC),
    NTSC_1280_720_p60("1280*720p60", VideoStandard.NTSC),
    NTSC_1280_720_p240("1280*720p240", VideoStandard.NTSC),
    NTSC_1280_720_p120("1280*720p120", VideoStandard.NTSC),
    NTSC_1280_720_p48("1280*720p48", VideoStandard.NTSC),
    NTSC_1280_720_p30("1280*720p30", VideoStandard.NTSC),
    NTSC_1280_720_p24("1280*720p24", VideoStandard.NTSC),
    PAL_4096_2160_p25("4096*2160p25", VideoStandard.PAL),
    PAL_4096_2160_p24("4096*2160p24", VideoStandard.PAL),
    PAL_3840_2160_p25("3840*2160p25", VideoStandard.PAL),
    PAL_3840_2160_p24("3840*2160p24", VideoStandard.PAL),
    PAL_2704_1520_p50("2704*1520p50", VideoStandard.PAL),
    PAL_2704_1520_p48("2704*1520p48", VideoStandard.PAL),
    PAL_2704_1520_p25("2704*1520p25", VideoStandard.PAL),
    PAL_2704_1520_p24("2704*1520p24", VideoStandard.PAL),
    PAL_1920_1080_p50("1920*1080p50", VideoStandard.PAL),
    PAL_1920_1080_p48("1920*1080p48", VideoStandard.PAL),
    PAL_1920_1080_p25("1920*1080p25", VideoStandard.PAL),
    PAL_1920_1080_p24("1920*1080p24", VideoStandard.PAL),
    PAL_1280_720_p50("1280*720p50", VideoStandard.PAL),
    PAL_1280_720_p48("1280*720p48", VideoStandard.PAL),
    PAL_1280_720_p25("1280*720p25", VideoStandard.PAL),
    PAL_1280_720_p24("1280*720p24", VideoStandard.PAL),
    UNKNOWN(SoloControllerUnits.UNKNOWN, VideoStandard.PAL);
    
    private VideoStandard standard;
    private final String value;

    private CameraVideoResolutionAndFpsTemp(String str, VideoStandard videoStandard) {
        this.value = str;
        this.standard = videoStandard;
    }

    public String value() {
        return this.value;
    }

    public VideoStandard getStandard() {
        return this.standard;
    }

    public static CameraVideoResolutionAndFpsTemp find(String str) {
        String replace = str.replace("x", "*");
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp = NTSC_4096_2160_p24;
        if (cameraVideoResolutionAndFpsTemp.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp2 = NTSC_3840_2160_p30;
        if (cameraVideoResolutionAndFpsTemp2.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp2;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp3 = NTSC_3840_2160_p24;
        if (cameraVideoResolutionAndFpsTemp3.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp3;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp4 = NTSC_2704_1520_p60;
        if (cameraVideoResolutionAndFpsTemp4.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp4;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp5 = NTSC_2704_1520_p48;
        if (cameraVideoResolutionAndFpsTemp5.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp5;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp6 = NTSC_2704_1520_p30;
        if (cameraVideoResolutionAndFpsTemp6.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp6;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp7 = NTSC_2704_1520_p24;
        if (cameraVideoResolutionAndFpsTemp7.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp7;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp8 = NTSC_1920_1080_p60;
        if (cameraVideoResolutionAndFpsTemp8.value().equals(replace) || cameraVideoResolutionAndFpsTemp8.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp8;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp9 = NTSC_1920_1080_p48;
        if (cameraVideoResolutionAndFpsTemp9.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp9;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp10 = NTSC_1920_1080_p30;
        if (cameraVideoResolutionAndFpsTemp10.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp10;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp11 = NTSC_1920_1080_p24;
        if (cameraVideoResolutionAndFpsTemp11.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp11;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp12 = NTSC_1280_720_p60;
        if (cameraVideoResolutionAndFpsTemp12.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp12;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp13 = NTSC_1280_720_p240;
        if (cameraVideoResolutionAndFpsTemp13.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp13;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp14 = NTSC_1280_720_p120;
        if (cameraVideoResolutionAndFpsTemp14.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp14;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp15 = NTSC_1280_720_p48;
        if (cameraVideoResolutionAndFpsTemp15.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp15;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp16 = NTSC_1280_720_p30;
        if (cameraVideoResolutionAndFpsTemp16.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp16;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp17 = NTSC_1280_720_p24;
        if (cameraVideoResolutionAndFpsTemp17.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp17;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp18 = PAL_4096_2160_p25;
        if (cameraVideoResolutionAndFpsTemp18.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp18;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp19 = PAL_4096_2160_p24;
        if (cameraVideoResolutionAndFpsTemp19.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp19;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp20 = PAL_3840_2160_p25;
        if (cameraVideoResolutionAndFpsTemp20.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp20;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp21 = PAL_3840_2160_p24;
        if (cameraVideoResolutionAndFpsTemp21.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp21;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp22 = PAL_2704_1520_p50;
        if (cameraVideoResolutionAndFpsTemp22.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp22;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp23 = PAL_2704_1520_p48;
        if (cameraVideoResolutionAndFpsTemp23.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp23;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp24 = PAL_2704_1520_p25;
        if (cameraVideoResolutionAndFpsTemp24.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp24;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp25 = PAL_2704_1520_p24;
        if (cameraVideoResolutionAndFpsTemp25.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp25;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp26 = PAL_1920_1080_p50;
        if (cameraVideoResolutionAndFpsTemp26.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp26;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp27 = PAL_1920_1080_p48;
        if (cameraVideoResolutionAndFpsTemp27.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp27;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp28 = PAL_1920_1080_p25;
        if (cameraVideoResolutionAndFpsTemp28.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp28;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp29 = PAL_1920_1080_p24;
        if (cameraVideoResolutionAndFpsTemp29.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp29;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp30 = PAL_1280_720_p50;
        if (cameraVideoResolutionAndFpsTemp30.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp30;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp31 = PAL_1280_720_p48;
        if (cameraVideoResolutionAndFpsTemp31.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp31;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp32 = PAL_1280_720_p25;
        if (cameraVideoResolutionAndFpsTemp32.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp32;
        }
        CameraVideoResolutionAndFpsTemp cameraVideoResolutionAndFpsTemp33 = PAL_1280_720_p24;
        if (cameraVideoResolutionAndFpsTemp33.value().equals(replace)) {
            return cameraVideoResolutionAndFpsTemp33;
        }
        return UNKNOWN;
    }
}
