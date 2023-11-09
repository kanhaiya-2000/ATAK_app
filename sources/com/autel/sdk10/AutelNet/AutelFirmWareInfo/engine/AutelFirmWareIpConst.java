package com.autel.sdk10.AutelNet.AutelFirmWareInfo.engine;

import com.autel.internal.network.usb.proxy.AutelUSBHelper;
import com.autel.sdk10.AutelNet.AutelRemoteController.engine.RCIpConst;

public final class AutelFirmWareIpConst {
    private static final String FIRMVERSION_SOCKET_HOST_AIRCRAFT_ADDR = "192.168.1.200";
    public static int FIRMVERSION_SOCKET_HOST_AIRCRAFT_PORT = 23353;
    public static int FIRMVERSION_SOCKET_HOST_REMOTE_PORT = 23354;
    private static final String FIRMVERSION_SOCKET_HOST_USB_ADDR = "127.0.0.1";

    private AutelFirmWareIpConst() {
    }

    public static String getFirmVersionAircraftComponentSocketAddr() {
        return AutelUSBHelper.instance().isUsbOpened() ? "127.0.0.1" : "192.168.1.200";
    }

    public static String getFirmVersionRCSocketAddr() {
        return RCIpConst.getRemoteSocketAddr();
    }
}
