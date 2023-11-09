package com.autel.sdk10.AutelCommunity.engine;

public class AutelRegProductInfo {
    private String aircraftSerialNumber;
    private String deviceAlias;
    private String picPath;
    private String proCode;
    private String proRegTime;
    private String proSerialNo;
    private String proTypeName;

    public void setProSerialNo(String str) {
        this.proSerialNo = str;
    }

    public void setProRegTime(String str) {
        this.proRegTime = str;
    }

    public void setAircraftSerialNumber(String str) {
        this.aircraftSerialNumber = str;
    }

    public void setPicPath(String str) {
        this.picPath = str;
    }

    public void setProTypeName(String str) {
        this.proTypeName = str;
    }

    public String getProSerialNo() {
        return this.proSerialNo;
    }

    public String getProRegTime() {
        return this.proRegTime;
    }

    public String getAircraftSerialNumber() {
        return this.aircraftSerialNumber;
    }

    public String getPicPath() {
        return this.picPath;
    }

    public String getProTypeName() {
        return this.proTypeName;
    }

    public String getDeviceAlias() {
        return this.deviceAlias;
    }

    public void setDeviceAlias(String str) {
        this.deviceAlias = str;
    }

    public String getProCode() {
        return this.proCode;
    }

    public void setProCode(String str) {
        this.proCode = str;
    }
}
