package com.autel.camera.utils;

import com.autel.internal.network.usb.proxy.AutelUSBHelper;

public class IpConstantUtils {
    public static String getCameraHttpUrl() {
        return AutelUSBHelper.instance().isUsbOpened() ? IpConstant.CAMERA_HTTP_USB_CMD : IpConstant.CAMERA_HTTP_WIFI_CMD;
    }

    public static String getCameraHttpEventsUrl() {
        return AutelUSBHelper.instance().isUsbOpened() ? IpConstant.CAMERA_HTTP_USB_EVENTS : IpConstant.CAMERA_HTTP_WIFI_EVENTS;
    }

    public static String getCameraControlAddress() {
        return AutelUSBHelper.instance().isUsbOpened() ? "127.0.0.1" : "192.168.1.11";
    }
}
