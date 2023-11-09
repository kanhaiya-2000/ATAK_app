package com.autel.internal.video.core.decoder1;

import com.autel.internal.network.usb.proxy.AutelUSBHelper;

public final class PlayerIpConst {
    private static final String RTSP_HOST_USB = "tcpsink://127.0.0.1:1998";
    private static final String RTSP_HOST_WIFI = "rtsp://192.168.1.200:8557/PSIA/Streaming/channels/2?videoCodecType=H.264";

    private PlayerIpConst() {
    }

    public static String getAutelPlayerUrl() {
        return AutelUSBHelper.instance().isUsbOpened() ? "tcpsink://127.0.0.1:1998" : "rtsp://192.168.1.200:8557/PSIA/Streaming/channels/2?videoCodecType=H.264";
    }
}
