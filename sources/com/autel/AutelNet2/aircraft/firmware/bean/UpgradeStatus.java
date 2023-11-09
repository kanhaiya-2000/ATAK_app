package com.autel.AutelNet2.aircraft.firmware.bean;

public class UpgradeStatus {
    private String UpdateReq;
    private int enUpdateDev;
    private int enUpdateSts;
    private String ucDevUpGradeFlag;
    private int ucPercent;
    private int ulVersion;
    private int usRetryCnt;

    public int getUlVersion() {
        return this.ulVersion;
    }

    public void setUlVersion(int i) {
        this.ulVersion = i;
    }

    public String getUcDevUpGradeFlag() {
        return this.ucDevUpGradeFlag;
    }

    public void setUcDevUpGradeFlag(String str) {
        this.ucDevUpGradeFlag = str;
    }

    public String getUpdateReq() {
        return this.UpdateReq;
    }

    public void setUpdateReq(String str) {
        this.UpdateReq = str;
    }

    public int getEnUpdateDev() {
        return this.enUpdateDev;
    }

    public void setEnUpdateDev(int i) {
        this.enUpdateDev = i;
    }

    public int getEnUpdateSts() {
        return this.enUpdateSts;
    }

    public void setEnUpdateSts(int i) {
        this.enUpdateSts = i;
    }

    public int getUcPercent() {
        return this.ucPercent;
    }

    public void setUcPercent(int i) {
        this.ucPercent = i;
    }

    public int getUsRetryCnt() {
        return this.usRetryCnt;
    }

    public void setUsRetryCnt(int i) {
        this.usRetryCnt = i;
    }
}
