package com.autel.internal.sdk.camera.base;

import android.os.Environment;
import com.autel.internal.network.usb.proxy.AutelUSBHelper;

public abstract class AutelCameraDevice {
    /* access modifiers changed from: protected */
    public abstract String getCameraIP();

    /* access modifiers changed from: protected */
    public abstract String getDeviceDir();

    public abstract String getFMCUrlFileList();

    public abstract String getFMCUrlThumb();

    public abstract int getType();

    public abstract String getUrlFileList();

    public abstract String getUrlThumb();

    public final String getUrlOrigin() {
        return "http://" + getIPPort();
    }

    public final String getPlayUrlOrigin() {
        return "http://" + getPlayIPPort();
    }

    public final String getIPPort() {
        if (AutelUSBHelper.instance().isUsbOpened()) {
            return "127.0.0.1:8081";
        }
        return getCameraIP();
    }

    public final String getPlayIPPort() {
        if (AutelUSBHelper.instance().isUsbOpened()) {
            return "127.0.0.1:8081";
        }
        return getCameraIP();
    }

    public final String getCacheDir(int i) {
        String deviceDir = getDeviceDir();
        if (i == 10) {
            deviceDir = deviceDir + "Thumb0/";
        } else if (i == 20) {
            deviceDir = deviceDir + "Thumb1/";
        } else if (i == 30) {
            deviceDir = deviceDir + "Photo/";
        } else if (i == 40) {
            deviceDir = deviceDir + "Video/";
        } else if (i == 50) {
            deviceDir = deviceDir + "Temp/";
        }
        return Environment.getExternalStorageDirectory() + "/NewStarLink" + deviceDir;
    }
}
