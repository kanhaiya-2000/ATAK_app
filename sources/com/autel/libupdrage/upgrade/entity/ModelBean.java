package com.autel.libupdrage.upgrade.entity;

public class ModelBean {
    private String BootloaderVersion;
    private String HardwareVersion;
    private String Item;
    private String SerialNumber = "SN/0000001";
    private String SoftwareVersion;
    private String Subtype = "none";

    public String getItem() {
        return this.Item;
    }

    public void setItem(String str) {
        this.Item = str;
    }

    public String getSubtype() {
        return this.Subtype;
    }

    public void setSubtype(String str) {
        this.Subtype = str;
    }

    public String getHardwareVersion() {
        return this.HardwareVersion;
    }

    public void setHardwareVersion(String str) {
        this.HardwareVersion = str;
    }

    public String getBootloaderVersion() {
        return this.BootloaderVersion;
    }

    public void setBootloaderVersion(String str) {
        this.BootloaderVersion = str;
    }

    public String getSerialNumber() {
        return this.SerialNumber;
    }

    public void setSerialNumber(String str) {
        this.SerialNumber = str;
    }

    public String getSoftwareVersion() {
        return this.SoftwareVersion;
    }

    public void setSoftwareVersion(String str) {
        this.SoftwareVersion = str;
    }
}
