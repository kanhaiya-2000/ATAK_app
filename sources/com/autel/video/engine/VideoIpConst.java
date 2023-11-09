package com.autel.video.engine;

import com.autel.internal.network.usb.proxy.AutelUSBHelper;

public final class VideoIpConst {
    public static final String RTSP_HOST_USB = "tcpsink://127.0.0.1:1998";
    public static final String RTSP_HOST_WIFI = "rtsp://192.168.1.200:8557/PSIA/Streaming/channels/2?videoCodecType=H.264";

    private VideoIpConst() {
    }

    public static String getRtspHostAddr() {
        return AutelUSBHelper.instance().isUsbOpened() ? "tcpsink://127.0.0.1:1998" : "rtsp://192.168.1.200:8557/PSIA/Streaming/channels/2?videoCodecType=H.264";
    }
}
