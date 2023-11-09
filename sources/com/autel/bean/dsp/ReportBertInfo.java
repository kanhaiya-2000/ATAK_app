package com.autel.bean.dsp;

public class ReportBertInfo {
    private int DownRate;
    private int LossPackages;
    private int UpRate;
    private int VideoRate;

    public int getLossPackages() {
        return this.LossPackages;
    }

    public void setLossPackages(int i) {
        this.LossPackages = i;
    }

    public int getDownRate() {
        return this.DownRate;
    }

    public void setDownRate(int i) {
        this.DownRate = i;
    }

    public int getUpRate() {
        return this.UpRate;
    }

    public void setUpRate(int i) {
        this.UpRate = i;
    }

    public int getVideoRate() {
        return this.VideoRate;
    }

    public void setVideoRate(int i) {
        this.VideoRate = i;
    }

    public String toString() {
        return "LossPackages=" + this.LossPackages + " DownRate=" + this.DownRate + " UpRate=" + this.UpRate + " VideoRate=" + this.VideoRate;
    }
}
