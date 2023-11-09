package com.autel.sdk10.AutelNet.AutelMavlinkCore.engine;

import com.autel.internal.network.usb.proxy.AutelUSBHelper;

public final class MavlinkIpConst {
    public static final int FLY_HOST_PORT = 14550;
    private static final String FLY_ROUTE_HOST_USB_ADDR = "127.0.0.1";
    private static final String FLY_ROUTE_HOST_WIFI_ADDR = "192.168.1.2";
    private static final String FLY_RTSP_HOST_USB_ADDR = "127.0.0.1";
    private static final String FLY_RTSP_HOST_WIFI_ADDR = "192.168.1.200";

    private MavlinkIpConst() {
    }

    public static String getFlyRouteAddr() {
        return AutelUSBHelper.instance().isUsbOpened() ? "127.0.0.1" : "192.168.1.2";
    }

    public static String getFlyRtspAddr() {
        return AutelUSBHelper.instance().isUsbOpened() ? "127.0.0.1" : "192.168.1.200";
    }
}
