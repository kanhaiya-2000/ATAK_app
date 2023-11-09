package com.autel.internal.sdk.camera.util;

import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.XT706.DisplayMode;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;

public class ResolutionFpsSupportUtil {
    private static String NTSCSupportResource_r12 = "4096*2160p24,3840*2160p30,3840*2160p24,2704*1520p60,2704*1520p48,2704*1520p30,2704*1520p24,1920*1080p120,1920*1080p60,1920*1080p48,1920*1080p30,1920*1080p24,1280*720p60,1280*720p240,1280*720p120,1280*720p48,1280*720p30,1280*720p24";
    private static String NTSCSupportResource_xb015 = "4096*2160p24,4096*2160p30,3840*2160p24,3840*2160p30,3840*2160p48,3840*2160p60,2720*1530p60,2720*1530p48,2720*1530p30,2720*1530p24,1920*1080p120,1920*1080p60,1920*1080p48,1920*1080p30,1920*1080p24,1280*720p240,1280*720p60,1280*720p48,1280*720p30,1280*720p24";
    private static String PALSupportResource_r12 = "4096*2160p25,4096*2160p24,3840*2160p25,3840*2160p24,2704*1520p50,2704*1520p48,2704*1520p25,2704*1520p24,1920*1080p50,1920*1080p48,1920*1080p25,1920*1080p24,1280*720p50,1280*720p48,1280*720p25,1280*720p24";
    private static String PALSupportResource_xb015 = "4096*2160p25,4096*2160p24,3840*2160p50,3840*2160p48,3840*2160p25,3840*2160p24,2720*1530p50,2720*1530p48,2720*1530p25,2720*1530p24,1920*1080p50,1920*1080p48,1920*1080p25,1920*1080p24,1280*720p50,1280*720p48,1280*720p25,1280*720p24";
    private static String SupportResource_xt701 = "7680*4320p24,7680*4320p25,5760*3240p24,5760*3240p25,5760*3240p30,3840*2160p24,3840*2160p25,3840*2160p30,3840*2160p30hdr,3840*2160p48,3840*2160p50,3840*2160p60,2720*1528p120,2720*1528p60,2720*1528p50,2720*1528p48,2720*1528p30,2720*1528p30hdr,2720*1528p25,2720*1528p24,1920*1080p240,1920*1080p120,1920*1080p60,1920*1080p60hdr,1920*1080p50,1920*1080p48,1920*1080p30,1920*1080p25,1920*1080p24,1280*720p240,1280*720p120,1280*720p120hdr,1280*720p60,1280*720p50,1280*720p48,1280*720p30,1280*720p25,1280*720p24";
    private static String SupportResource_xt705 = "5472*3076p30,5472*3076p25,5472*3076p24,4800*2700p60,4800*2700p50,4800*2700p48,4800*2700p30,4800*2700p25,4800*2700p24,4096*2160p60,4096*2160p50,4096*2160p48,4096*2160p24,4096*2160p25,4096*2160p30,3840*2160p60,3840*2160p50,3840*2160p48,3840*2160p24,3840*2160p25,3840*2160p30,2720*1528p120,2720*1528p60,2720*1528p50,2720*1528p48,2720*1528p30,2720*1528p25,2720*1528p24,1920*1080p120,1920*1080p60,1920*1080p50,1920*1080p48,1920*1080p30,1920*1080p25,1920*1080p24";
    private static String SupportResource_xt706 = "7680*4320p24,7680*4320p25,5760*3240p24,5760*3240p25,5760*3240p30,3840*2160p24,3840*2160p25,3840*2160p30,3840*2160p30hdr,3840*2160p48,3840*2160p50,3840*2160p60,2720*1528p120,2720*1528p60,2720*1528p50,2720*1528p48,2720*1528p30,2720*1528p30hdr,2720*1528p25,2720*1528p24,1920*1080p240,1920*1080p120,1920*1080p60,1920*1080p60hdr,1920*1080p50,1920*1080p48,1920*1080p30,1920*1080p25,1920*1080p24,1280*720p240,1280*720p120,1280*720p120hdr,1280*720p60,1280*720p50,1280*720p48,1280*720p30,1280*720p25,1280*720p24";

    public static boolean isNTSCSupport(CameraProduct cameraProduct, VideoResolution videoResolution, VideoFps videoFps) {
        if (videoResolution == null || videoFps == null) {
            return false;
        }
        int i = C48971.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()];
        if (i == 1) {
            String str = NTSCSupportResource_r12;
            return str.contains(videoResolution.value() + videoFps.value());
        } else if (i != 2) {
            return false;
        } else {
            String str2 = NTSCSupportResource_xb015;
            return str2.contains(videoResolution.value() + videoFps.value());
        }
    }

    public static boolean isPALSupport(CameraProduct cameraProduct, VideoResolution videoResolution, VideoFps videoFps) {
        if (videoResolution == null || videoFps == null) {
            return false;
        }
        int i = C48971.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()];
        if (i == 1) {
            String str = PALSupportResource_r12;
            return str.contains(videoResolution.value() + videoFps.value());
        } else if (i != 2) {
            return false;
        } else {
            String str2 = PALSupportResource_xb015;
            return str2.contains(videoResolution.value() + videoFps.value());
        }
    }

    public static boolean isSupport(CameraProduct cameraProduct, VideoResolution videoResolution, VideoFps videoFps) {
        if (videoResolution == null || videoFps == null) {
            return false;
        }
        int i = C48971.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()];
        if (i == 1) {
            String str = PALSupportResource_r12;
            return str.contains(videoResolution.value() + videoFps.value());
        } else if (i == 2) {
            String str2 = PALSupportResource_xb015;
            return str2.contains(videoResolution.value() + videoFps.value());
        } else if (i == 3) {
            String str3 = SupportResource_xt701;
            return str3.contains(videoResolution.value() + videoFps.value());
        } else if (i == 4) {
            String str4 = SupportResource_xt705;
            return str4.contains(videoResolution.value() + videoFps.value());
        } else if (i != 5) {
            return false;
        } else {
            String str5 = SupportResource_xt706;
            return str5.contains(videoResolution.value() + videoFps.value());
        }
    }

    public static VideoResolutionAndFps[] NTSCSupport(CameraProduct cameraProduct) {
        int i = C48971.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()];
        if (i == 1) {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_120ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_240ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_120ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_24ps)};
        } else if (i != 2) {
            return new VideoResolutionAndFps[0];
        } else {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_120ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_240ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_24ps)};
        }
    }

    public static VideoResolutionAndFps[] PALSupport(CameraProduct cameraProduct) {
        int i = C48971.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()];
        if (i == 1) {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_24ps)};
        } else if (i != 2) {
            return new VideoResolutionAndFps[0];
        } else {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_24ps)};
        }
    }

    public static VideoResolutionAndFps[] Support(CameraProduct cameraProduct) {
        int i = C48971.$SwitchMap$com$autel$common$camera$CameraProduct[cameraProduct.ordinal()];
        if (i == 1) {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_24ps)};
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_5472x3076, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_5472x3076, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_5472x3076, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_4800x2700, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_4800x2700, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_4800x2700, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_4800x2700, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_4800x2700, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_4800x2700, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_120ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_120ps)};
                } else if (i != 5) {
                    return new VideoResolutionAndFps[0];
                }
            }
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_7680x4320, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_7680x4320, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_5760x3240, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_5760x3240, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_5760x3240, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_30ps_HDR), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_30ps_HDR), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_120ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_60ps_HDR), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_120ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_240ps)};
        } else {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_4096x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1530, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_24ps)};
        }
    }

    /* renamed from: com.autel.internal.sdk.camera.util.ResolutionFpsSupportUtil$1 */
    /* synthetic */ class C48971 {
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$CameraProduct;
        static final /* synthetic */ int[] $SwitchMap$com$autel$common$camera$XT706$DisplayMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        static {
            /*
                com.autel.common.camera.XT706.DisplayMode[] r0 = com.autel.common.camera.XT706.DisplayMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$autel$common$camera$XT706$DisplayMode = r0
                r1 = 1
                com.autel.common.camera.XT706.DisplayMode r2 = com.autel.common.camera.XT706.DisplayMode.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$autel$common$camera$XT706$DisplayMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.autel.common.camera.XT706.DisplayMode r3 = com.autel.common.camera.XT706.DisplayMode.PICTURE_IN_PICTURE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$autel$common$camera$XT706$DisplayMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.autel.common.camera.XT706.DisplayMode r4 = com.autel.common.camera.XT706.DisplayMode.IR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$autel$common$camera$XT706$DisplayMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.autel.common.camera.XT706.DisplayMode r5 = com.autel.common.camera.XT706.DisplayMode.OVERLAP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.autel.common.camera.CameraProduct[] r4 = com.autel.common.camera.CameraProduct.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$autel$common$camera$CameraProduct = r4
                com.autel.common.camera.CameraProduct r5 = com.autel.common.camera.CameraProduct.R12     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x004e }
                com.autel.common.camera.CameraProduct r4 = com.autel.common.camera.CameraProduct.XB015     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT701     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT705     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$com$autel$common$camera$CameraProduct     // Catch:{ NoSuchFieldError -> 0x006d }
                com.autel.common.camera.CameraProduct r1 = com.autel.common.camera.CameraProduct.XT706     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.autel.internal.sdk.camera.util.ResolutionFpsSupportUtil.C48971.<clinit>():void");
        }
    }

    public static VideoResolutionAndFps[] SupportXT706(DisplayMode displayMode) {
        int i = C48971.$SwitchMap$com$autel$common$camera$XT706$DisplayMode[displayMode.ordinal()];
        if (i == 1) {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_7680x4320, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_7680x4320, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_5760x3240, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_5760x3240, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_5760x3240, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_30ps_HDR), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_3840x2160, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_30ps_HDR), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_2720x1528, VideoFps.FrameRate_120ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_24ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_25ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_48ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_50ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_60ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_60ps_HDR), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_120ps), new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_240ps)};
        } else if (i == 2) {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_1920x1080, VideoFps.FrameRate_30ps), new VideoResolutionAndFps(VideoResolution.Resolution_1280x720, VideoFps.FrameRate_30ps)};
        } else if (i == 3) {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_640x512, VideoFps.FrameRate_30ps)};
        } else if (i != 4) {
            return new VideoResolutionAndFps[0];
        } else {
            return new VideoResolutionAndFps[]{new VideoResolutionAndFps(VideoResolution.Resolution_1280x1024, VideoFps.FrameRate_30ps)};
        }
    }
}
