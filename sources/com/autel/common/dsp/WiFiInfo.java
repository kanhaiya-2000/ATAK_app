package com.autel.common.dsp;

public class WiFiInfo {
    private String password;
    private String ssid;

    public WiFiInfo(String str, String str2) {
        this.ssid = str;
        this.password = str2;
    }

    public String getSSID() {
        return this.ssid;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return "ssid  =  " + this.ssid + "  password  " + this.password;
    }
}
