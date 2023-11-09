package com.autel.bean.dsp;

public class BandModeWidthInfo {
    private String BandMode;
    private String BandWidth;
    private int DisableSetBandMode;
    private int District;
    private int RCType;

    public int getRCType() {
        return this.RCType;
    }

    public void setRCType(int i) {
        this.RCType = i;
    }

    public int getDistrict() {
        return this.District;
    }

    public void setDistrict(int i) {
        this.District = i;
    }

    public int getDisableSetBandMode() {
        return this.DisableSetBandMode;
    }

    public void setDisableSetBandMode(int i) {
        this.DisableSetBandMode = i;
    }

    public String getBandMode() {
        return this.BandMode;
    }

    public void setBandMode(String str) {
        this.BandMode = str;
    }

    public String getBandWidth() {
        return this.BandWidth;
    }

    public void setBandWidth(String str) {
        this.BandWidth = str;
    }
}
