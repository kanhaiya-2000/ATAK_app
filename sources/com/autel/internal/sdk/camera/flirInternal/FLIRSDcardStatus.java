package com.autel.internal.sdk.camera.flirInternal;

import java.io.Serializable;

public class FLIRSDcardStatus implements Serializable {
    private String CardStatus;
    private int CurrentRecordTime;
    private int FreeSpace;
    private int RemainCaptureNum;
    private int RemainRecordTime;
    private int TotalRecordedTime;
    private int TotalSpace;

    public String getCardStatus() {
        return this.CardStatus;
    }

    public void setCardStatus(String str) {
        this.CardStatus = str;
    }

    public int getTotalSpace() {
        return this.TotalSpace;
    }

    public void setTotalSpace(int i) {
        this.TotalSpace = i;
    }

    public int getFreeSpace() {
        return this.FreeSpace;
    }

    public void setFreeSpace(int i) {
        this.FreeSpace = i;
    }

    public int getTotalRecordedTime() {
        return this.TotalRecordedTime;
    }

    public void setTotalRecordedTime(int i) {
        this.TotalRecordedTime = i;
    }

    public int getCurrentRecordTime() {
        return this.CurrentRecordTime;
    }

    public void setCurrentRecordTime(int i) {
        this.CurrentRecordTime = i;
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
}
