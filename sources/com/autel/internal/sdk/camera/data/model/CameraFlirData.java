package com.autel.internal.sdk.camera.data.model;

import com.autel.internal.sdk.camera.data.base.BaseCameraData;

public class CameraFlirData extends BaseCameraData {
    private int AirTemp;
    private int Captured;
    private String DisplayMode;
    private int Emissivity;
    private String FileFormat;
    private int Humidity;
    private String IRColorPalette;
    private int MsxEnable;
    private int MsxPosX;
    private int MsxPosY;
    private int MsxStrength;
    private String PicType;
    private String Position;
    private String RecordedVideo;
    private String SkyCond;
    private int SpotMeter;
    private int SubjectDistance;
    private int Supported;
    private String TempUnit;
    private int TimeLeft;
    private int TimelapseDuration;
    private int TimelapseInterval;

    private static class CameraFlirDataHolder {
        /* access modifiers changed from: private */
        public static final CameraFlirData s_instance = new CameraFlirData();

        private CameraFlirDataHolder() {
        }
    }

    private CameraFlirData() {
        this.SpotMeter = -1;
        this.Emissivity = -100;
        this.AirTemp = -100;
        this.Humidity = -1;
        this.SubjectDistance = -1;
    }

    public static CameraFlirData instance() {
        return CameraFlirDataHolder.s_instance;
    }

    public int getSupported() {
        return this.Supported;
    }

    public void setSupported(int i) {
        this.Supported = i;
    }

    public int getCaptured() {
        return this.Captured;
    }

    public void setCaptured(int i) {
        this.Captured = i;
    }

    public int getTimeLeft() {
        return this.TimeLeft;
    }

    public void setTimeLeft(int i) {
        this.TimeLeft = i;
    }

    public String getPicType() {
        return this.PicType;
    }

    public void setPicType(String str) {
        this.PicType = str;
    }

    public int getTimelapseInterval() {
        return this.TimelapseInterval;
    }

    public void setTimelapseInterval(int i) {
        this.TimelapseInterval = i;
    }

    public int getTimelapseDuration() {
        return this.TimelapseDuration;
    }

    public void setTimelapseDuration(int i) {
        this.TimelapseDuration = i;
    }

    public String getFileFormat() {
        return this.FileFormat;
    }

    public void setFileFormat(String str) {
        this.FileFormat = str;
    }

    public String getRecordedVideo() {
        return this.RecordedVideo;
    }

    public void setRecordedVideo(String str) {
        this.RecordedVideo = str;
    }

    public String getDisplayMode() {
        return this.DisplayMode;
    }

    public void setDisplayMode(String str) {
        this.DisplayMode = str;
    }

    public String getIRColorPalette() {
        return this.IRColorPalette;
    }

    public void setIRColorPalette(String str) {
        this.IRColorPalette = str;
    }

    public int getMsxEnable() {
        return this.MsxEnable;
    }

    public void setMsxEnable(int i) {
        this.MsxEnable = i;
    }

    public int getMsxStrength() {
        return this.MsxStrength;
    }

    public void setMsxStrength(int i) {
        this.MsxStrength = i;
    }

    public int getMsxPosX() {
        return this.MsxPosX;
    }

    public void setMsxPosX(int i) {
        this.MsxPosX = i;
    }

    public int getMsxPosY() {
        return this.MsxPosY;
    }

    public void setMsxPosY(int i) {
        this.MsxPosY = i;
    }

    public String getTempUnit() {
        return this.TempUnit;
    }

    public void setTempUnit(String str) {
        this.TempUnit = str;
    }

    public String getSkyCond() {
        return this.SkyCond;
    }

    public void setSkyCond(String str) {
        this.SkyCond = str;
    }

    public int getSpotMeter() {
        return this.SpotMeter;
    }

    public void setSpotMeter(int i) {
        this.SpotMeter = i;
    }

    public int getEmissivity() {
        return this.Emissivity;
    }

    public void setEmissivity(int i) {
        this.Emissivity = i;
    }

    public int getAirTemp() {
        return this.AirTemp;
    }

    public void setAirTemp(int i) {
        this.AirTemp = i;
    }

    public int getHumidity() {
        return this.Humidity;
    }

    public void setHumidity(int i) {
        this.Humidity = i;
    }

    public int getSubjectDistance() {
        return this.SubjectDistance;
    }

    public void setSubjectDistance(int i) {
        this.SubjectDistance = i;
    }

    public String getPosition() {
        return this.Position;
    }

    public void setPosition(String str) {
        this.Position = str;
    }
}
