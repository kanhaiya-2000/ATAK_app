package com.autel.internal.sdk.camera.base;

public class AutelCamProCamera extends AutelCameraDevice {
    /* access modifiers changed from: protected */
    public String getCameraIP() {
        return "192.168.1.11";
    }

    /* access modifiers changed from: protected */
    public String getDeviceDir() {
        return "/CamPro/";
    }

    public int getType() {
        return 1;
    }

    public String getUrlThumb() {
        return "http://" + getIPPort() + "/thumbnail";
    }

    public String getUrlFileList() {
        return "http://" + getIPPort() + "/sdscan";
    }

    public String getFMCUrlThumb() {
        return "http://" + getIPPort() + "/mmcthumbnail";
    }

    public String getFMCUrlFileList() {
        return "http://" + getIPPort() + "/mmcscan";
    }
}
