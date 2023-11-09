package com.autel.bean.camera;

public class CameraSystemStatus {
    private double ApertureValue;
    private int AverageTemp;
    private int BatteryLevel;
    private String CameraType;
    private int CenterTemp;
    private int ColdTemp;
    private float ColdX;
    private float ColdY;
    private String CurrentMode;
    private long CurrentRecordTime;
    private double ExposureValue;
    private int FovH = 680;
    private int FovV = 537;
    private long FreeSpace;
    private int HotTemp;
    private float HotX;
    private float HotY;
    private int ISOValue;
    private long IdentifyCode;
    private long MMCFreeSpace;
    private String MMCStatus;
    private long MMCTotalSpace;
    private String PanoramaState;
    private int PhotoIntervalMin;
    private String PivState;
    private String PrevPhotoTakingMode;
    private String PrevRecordMode;
    private int RemainCaptureNum;
    private long RemainRecordTime;
    private String SDCardStatus;
    private String ShutterSpeed;
    private String SystemStatus;
    private int Temperature;
    private long TotalRecordedTime;
    private long TotalSpace;
    private int TouchTemp;
    private int WiFiSignalStrength;
    private int ZoomValue;

    public float getAverageTemp() {
        return ((float) this.AverageTemp) / 10.0f;
    }

    public void setAverageTemp(int i) {
        this.AverageTemp = i;
    }

    public float getCenterTemp() {
        return ((float) this.CenterTemp) / 10.0f;
    }

    public void setCenterTemp(int i) {
        this.CenterTemp = i;
    }

    public float getHotTemp() {
        return ((float) this.HotTemp) / 10.0f;
    }

    public void setHotTemp(int i) {
        this.HotTemp = i;
    }

    public float getHotX() {
        return this.HotX;
    }

    public void setHotX(float f) {
        this.HotX = f;
    }

    public float getHotY() {
        return this.HotY;
    }

    public void setHotY(float f) {
        this.HotY = f;
    }

    public float getColdTemp() {
        return ((float) this.ColdTemp) / 10.0f;
    }

    public void setColdTemp(int i) {
        this.ColdTemp = i;
    }

    public float getColdX() {
        return this.ColdX;
    }

    public void setColdX(float f) {
        this.ColdX = f;
    }

    public float getColdY() {
        return this.ColdY;
    }

    public void setColdY(float f) {
        this.ColdY = f;
    }

    public float getTouchTemp() {
        return ((float) this.TouchTemp) / 10.0f;
    }

    public void setTouchTemp(int i) {
        this.TouchTemp = i;
    }

    public int getPhotoIntervalMin() {
        return this.PhotoIntervalMin;
    }

    public void setPhotoIntervalMin(int i) {
        this.PhotoIntervalMin = i;
    }

    public float getFovH() {
        return ((float) this.FovH) / 10.0f;
    }

    public void setFovH(int i) {
        this.FovH = i;
    }

    public float getFovV() {
        return ((float) this.FovV) / 10.0f;
    }

    public void setFovV(int i) {
        this.FovV = i;
    }

    public String getMMCStatus() {
        return this.MMCStatus;
    }

    public void setMMCStatus(String str) {
        this.MMCStatus = str;
    }

    public long getMMCTotalSpace() {
        return this.MMCTotalSpace;
    }

    public void setMMCTotalSpace(long j) {
        this.MMCTotalSpace = j;
    }

    public long getMMCFreeSpace() {
        return this.MMCFreeSpace;
    }

    public void setMMCFreeSpace(long j) {
        this.MMCFreeSpace = j;
    }

    public long getIdentifyCode() {
        return this.IdentifyCode;
    }

    public void setIdentifyCode(long j) {
        this.IdentifyCode = j;
    }

    public String getCameraType() {
        return this.CameraType;
    }

    public void setCameraType(String str) {
        this.CameraType = str;
    }

    public String getSystemStatus() {
        return this.SystemStatus;
    }

    public void setSystemStatus(String str) {
        this.SystemStatus = str;
    }

    public String getCurrentMode() {
        return this.CurrentMode;
    }

    public void setCurrentMode(String str) {
        this.CurrentMode = str;
    }

    public String getPrevRecordMode() {
        return this.PrevRecordMode;
    }

    public void setPrevRecordMode(String str) {
        this.PrevRecordMode = str;
    }

    public String getPrevPhotoTakingMode() {
        return this.PrevPhotoTakingMode;
    }

    public void setPrevPhotoTakingMode(String str) {
        this.PrevPhotoTakingMode = str;
    }

    public int getTemperature() {
        return this.Temperature;
    }

    public void setTemperature(int i) {
        this.Temperature = i;
    }

    public int getBatteryLevel() {
        return this.BatteryLevel;
    }

    public void setBatteryLevel(int i) {
        this.BatteryLevel = i;
    }

    public String getSDCardStatus() {
        return this.SDCardStatus;
    }

    public void setSDCardStatus(String str) {
        this.SDCardStatus = str;
    }

    public long getTotalSpace() {
        return this.TotalSpace;
    }

    public void setTotalSpace(long j) {
        this.TotalSpace = j;
    }

    public long getFreeSpace() {
        return this.FreeSpace;
    }

    public void setFreeSpace(long j) {
        this.FreeSpace = j;
    }

    public long getCurrentRecordTime() {
        return this.CurrentRecordTime;
    }

    public void setCurrentRecordTime(long j) {
        this.CurrentRecordTime = j;
    }

    public long getRemainRecordTime() {
        return this.RemainRecordTime;
    }

    public void setRemainRecordTime(long j) {
        this.RemainRecordTime = j;
    }

    public int getRemainCaptureNum() {
        return this.RemainCaptureNum;
    }

    public void setRemainCaptureNum(int i) {
        this.RemainCaptureNum = i;
    }

    public double getExposureValue() {
        return this.ExposureValue;
    }

    public void setExposureValue(double d) {
        this.ExposureValue = d;
    }

    public int getISOValue() {
        return this.ISOValue;
    }

    public void setISOValue(int i) {
        this.ISOValue = i;
    }

    public String getShutterSpeed() {
        return this.ShutterSpeed;
    }

    public void setShutterSpeed(String str) {
        this.ShutterSpeed = str;
    }

    public double getApertureValue() {
        return this.ApertureValue;
    }

    public void setApertureValue(double d) {
        this.ApertureValue = d;
    }

    public int getWiFiSignalStrength() {
        return this.WiFiSignalStrength;
    }

    public void setWiFiSignalStrength(int i) {
        this.WiFiSignalStrength = i;
    }

    public String getPanoramaState() {
        return this.PanoramaState;
    }

    public void setPanoramaState(String str) {
        this.PanoramaState = str;
    }

    public long getTotalRecordedTime() {
        return this.TotalRecordedTime;
    }

    public void setTotalRecordedTime(long j) {
        this.TotalRecordedTime = j;
    }

    public String getPivState() {
        return this.PivState;
    }

    public void setPivState(String str) {
        this.PivState = str;
    }

    public int getZoomValue() {
        return this.ZoomValue;
    }

    public void setZoomValue(int i) {
        this.ZoomValue = i;
    }
}
