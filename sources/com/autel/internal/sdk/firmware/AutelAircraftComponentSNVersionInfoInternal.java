package com.autel.internal.sdk.firmware;

public class AutelAircraftComponentSNVersionInfoInternal extends AutelVersionInfo implements AircraftComponentSerialNumberVersionInfo {
    private String Battery;
    private String FMU;
    private String Gimbal;

    public void setGimbal(String str) {
        this.Gimbal = str;
    }

    public String getGimbal() {
        return this.Gimbal;
    }

    public void setFMU(String str) {
        this.FMU = str;
    }

    public String getFMU() {
        return this.FMU;
    }

    public void setBattery(String str) {
        this.Battery = str;
    }

    public String getBattery() {
        return this.Battery;
    }

    public String getGimbalSerialNumber() {
        return getGimbal();
    }

    public String getFlightControlSerialNumber() {
        return getFMU();
    }

    public String getBatterySerialNumber() {
        return getBattery();
    }

    public String toString() {
        return "Gimbal:" + this.Gimbal + ", FMU:" + this.FMU + ", Battery:" + this.Battery;
    }
}
