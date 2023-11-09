package com.autel.sdk10.AutelNet.AutelRemoteController.engine;

import com.autel.internal.network.usb.proxy.AutelUSBHelper;

public final class RCIpConst {
    public static final int REMOTE_CONTROLLER_PORT = 14558;
    public static final int REMOTE_PORT = 8998;
    private static final String REMOTE_SOCKET_HOST_USB_ADDR = "127.0.0.1";
    private static final String REMOTE_SOCKET_HOST_WIFI_ADDR = "192.168.1.20";

    private RCIpConst() {
    }

    public static String getRemoteSocketAddr() {
        return AutelUSBHelper.instance().isUsbOpened() ? "127.0.0.1" : "192.168.1.20";
    }
}
