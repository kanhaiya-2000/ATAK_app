package com.autel.internal.sdk.camera.data.base;

import com.autel.common.camera.media.VideoResolutionAndFps;

public class CameraData extends BaseCameraData {
    private int AeLocked;
    private int AebNumPerSecond;
    private String AntiFlicker;
    private String AudioEncoding;
    private int Bitrate;
    private int Brightness;
    private int BurstNumPerSecond;
    private String CameraGear;
    private int Contrast;
    private int EnableSubtitle;
    private int HistogramEnable;
    private int Hue;
    private String ImageColor;
    private double ImageExposure;
    private int ImageISO;
    private int Location_X;
    private int Location_Y;
    private int SampleRate;
    private int Saturation;
    private int Sharpness;
    private String Shutter;
    private String Style;
    private int TimelapseInterval;
    private String VideoFileFormat;
    private String VideoMainEncoding;
    private String VideoOtherEncoding;
    private int VideoRotation;
    private String VideoStandard;
    private int WBColorTemperature;
    private String WhiteBalanceMode;
    private int ZoomValue;
    private VideoResolutionAndFps videoMainResolutionAndFps = new VideoResolutionAndFps();
    private VideoResolutionAndFps videoOtherResolutionAndFps = new VideoResolutionAndFps();

    public int getVideoRotation() {
        return this.VideoRotation;
    }

    public void setVideoRotation(int i) {
        this.VideoRotation = i;
    }

    public String getAntiFlicker() {
        return this.AntiFlicker;
    }

    public void setAntiFlicker(String str) {
        this.AntiFlicker = str;
    }

    public String getVideoStandard() {
        return this.VideoStandard;
    }

    public void setVideoStandard(String str) {
        this.VideoStandard = str;
    }

    public String getAudioEncoding() {
        return this.AudioEncoding;
    }

    public void setAudioEncoding(String str) {
        this.AudioEncoding = str;
    }

    public int getBitrate() {
        return this.Bitrate;
    }

    public void setBitrate(int i) {
        this.Bitrate = i;
    }

    public int getSampleRate() {
        return this.SampleRate;
    }

    public void setSampleRate(int i) {
        this.SampleRate = i;
    }

    public int getHistogramEnable() {
        return this.HistogramEnable;
    }

    public void setHistogramEnable(int i) {
        this.HistogramEnable = i;
    }

    public int getLocation_X() {
        return this.Location_X;
    }

    public void setLocation_X(int i) {
        this.Location_X = i;
    }

    public int getLocation_Y() {
        return this.Location_Y;
    }

    public void setLocation_Y(int i) {
        this.Location_Y = i;
    }

    public String getStyle() {
        return this.Style;
    }

    public void setStyle(String str) {
        this.Style = str;
    }

    public int getBrightness() {
        return this.Brightness;
    }

    public void setBrightness(int i) {
        this.Brightness = i;
    }

    public int getContrast() {
        return this.Contrast;
    }

    public void setContrast(int i) {
        this.Contrast = i;
    }

    public int getSaturation() {
        return this.Saturation;
    }

    public void setSaturation(int i) {
        this.Saturation = i;
    }

    public int getHue() {
        return this.Hue;
    }

    public void setHue(int i) {
        this.Hue = i;
    }

    public int getSharpness() {
        return this.Sharpness;
    }

    public void setSharpness(int i) {
        this.Sharpness = i;
    }

    public String getWhiteBalanceMode() {
        return this.WhiteBalanceMode;
    }

    public void setWhiteBalanceMode(String str) {
        this.WhiteBalanceMode = str;
    }

    public int getWBColorTemperature() {
        return this.WBColorTemperature;
    }

    public void setWBColorTemperature(int i) {
        this.WBColorTemperature = i;
    }

    public String getImageColor() {
        return this.ImageColor;
    }

    public void setImageColor(String str) {
        this.ImageColor = str;
    }

    public double getImageExposure() {
        return this.ImageExposure;
    }

    public void setImageExposure(double d) {
        this.ImageExposure = d;
    }

    public int getImageISO() {
        return this.ImageISO;
    }

    public void setImageISO(int i) {
        this.ImageISO = i;
    }

    public String getCameraGear() {
        return this.CameraGear;
    }

    public void setCameraGear(String str) {
        this.CameraGear = str;
    }

    public int getAeLocked() {
        return this.AeLocked;
    }

    public void setAeLocked(int i) {
        this.AeLocked = i;
    }

    public String getShutter() {
        return this.Shutter;
    }

    public void setShutter(String str) {
        this.Shutter = str;
    }

    public int getZoomValue() {
        return this.ZoomValue;
    }

    public void setZoomValue(int i) {
        this.ZoomValue = i;
    }

    public String getVideoFileFormat() {
        return this.VideoFileFormat;
    }

    public void setVideoFileFormat(String str) {
        this.VideoFileFormat = str;
    }

    public int getEnableSubtitle() {
        return this.EnableSubtitle;
    }

    public void setEnableSubtitle(int i) {
        this.EnableSubtitle = i;
    }

    public int getBurstNumPerSecond() {
        return this.BurstNumPerSecond;
    }

    public void setBurstNumPerSecond(int i) {
        this.BurstNumPerSecond = i;
    }

    public int getAebNumPerSecond() {
        return this.AebNumPerSecond;
    }

    public void setAebNumPerSecond(int i) {
        this.AebNumPerSecond = i;
    }

    public int getTimelapseInterval() {
        return this.TimelapseInterval;
    }

    public void setTimelapseInterval(int i) {
        this.TimelapseInterval = i;
    }

    public VideoResolutionAndFps getVideoMainResolutionAndFps() {
        return this.videoMainResolutionAndFps;
    }

    public void setVideoMainResolutionAndFps(VideoResolutionAndFps videoResolutionAndFps) {
        this.videoMainResolutionAndFps = videoResolutionAndFps;
    }

    public String getVideoMainEncoding() {
        return this.VideoMainEncoding;
    }

    public void setVideoMainEncoding(String str) {
        this.VideoMainEncoding = str;
    }

    public String getVideoOtherEncoding() {
        return this.VideoOtherEncoding;
    }

    public void setVideoOtherEncoding(String str) {
        this.VideoOtherEncoding = str;
    }

    public VideoResolutionAndFps getVideoOtherResolutionAndFps() {
        return this.videoOtherResolutionAndFps;
    }

    public void setVideoOtherResolutionAndFps(VideoResolutionAndFps videoResolutionAndFps) {
        this.videoOtherResolutionAndFps = videoResolutionAndFps;
    }
}
