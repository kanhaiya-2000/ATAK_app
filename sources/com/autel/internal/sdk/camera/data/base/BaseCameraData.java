package com.autel.internal.sdk.camera.data.base;

public class BaseCameraData {
    private int BatteryLevel;
    private String CameraMode;
    private String CardStatus;
    private String CurrentMode;
    private long CurrentRecordTime;
    private String DateTime;
    private String DeviceModel;
    private String DeviceType;
    private String FirmwareVersion;
    private long FreeSpace;
    private int GimbalLockState;
    private String HardwareId;
    private String LensSoftVersion;
    private String Manufacturer;
    private String PicResolution;
    private String PicType;
    private String PivState;
    private String PrevPhotoTakingMode;
    private String PrevRecordMode;
    private int ProtocolVersion;
    private int RemainCaptureNum;
    private int RemainRecordTime;
    private String SerialNumber;
    private String SystemStatus;
    private int Temperature;
    private int TimeZone;
    private long TotalSpace;

    public int getGimbalLockState() {
        return this.GimbalLockState;
    }

    public void setGimbalLockState(int i) {
        this.GimbalLockState = i;
    }

    public String getPivState() {
        return this.PivState;
    }

    public void setPivState(String str) {
        this.PivState = str;
    }

    public String getDeviceType() {
        return this.DeviceType;
    }

    public void setDeviceType(String str) {
        this.DeviceType = str;
    }

    public String getDeviceModel() {
        return this.DeviceModel;
    }

    public void setDeviceModel(String str) {
        this.DeviceModel = str;
    }

    public int getProtocolVersion() {
        return this.ProtocolVersion;
    }

    public void setProtocolVersion(int i) {
        this.ProtocolVersion = i;
    }

    public String getManufacturer() {
        return this.Manufacturer;
    }

    public void setManufacturer(String str) {
        this.Manufacturer = str;
    }

    public String getFirmwareVersion() {
        return this.FirmwareVersion;
    }

    public void setFirmwareVersion(String str) {
        this.FirmwareVersion = str;
    }

    public String getSerialNumber() {
        return this.SerialNumber;
    }

    public void setSerialNumber(String str) {
        this.SerialNumber = str;
    }

    public String getHardwareId() {
        return this.HardwareId;
    }

    public void setHardwareId(String str) {
        this.HardwareId = str;
    }

    public String getLensSoftVersion() {
        return this.LensSoftVersion;
    }

    public void setLensSoftVersion(String str) {
        this.LensSoftVersion = str;
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

    public String getCardStatus() {
        return this.CardStatus;
    }

    public void setCardStatus(String str) {
        this.CardStatus = str;
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

    public int getRemainRecordTime() {
        return this.RemainRecordTime;
    }

    public void setRemainRecordTime(int i) {
        this.RemainRecordTime = i;
    }

    public int getRemainCaptureNum() {
        return this.RemainCaptureNum;
    }

    public void setRemainCaptureNum(int i) {
        this.RemainCaptureNum = i;
    }

    public int getTimeZone() {
        return this.TimeZone;
    }

    public void setTimeZone(int i) {
        this.TimeZone = i;
    }

    public String getDateTime() {
        return this.DateTime;
    }

    public void setDateTime(String str) {
        this.DateTime = str;
    }

    public String getCameraMode() {
        return this.CameraMode;
    }

    public void setCameraMode(String str) {
        this.CameraMode = str;
    }

    public String getPicType() {
        return this.PicType;
    }

    public void setPicType(String str) {
        this.PicType = str;
    }

    public String getPicResolution() {
        return this.PicResolution;
    }

    public void setPicResolution(String str) {
        this.PicResolution = str;
    }
}
