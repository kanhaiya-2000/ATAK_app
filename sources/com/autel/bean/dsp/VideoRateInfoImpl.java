package com.autel.bean.dsp;

import com.autel.common.dsp.evo.FrameRateInfo;

public class VideoRateInfoImpl implements FrameRateInfo {
    private int BitRate;
    private int FrameRate;
    private int IframeEnable;
    private int Resolution;

    public int getBitRate() {
        return this.BitRate;
    }

    public void setBitRate(int i) {
        this.BitRate = i;
    }

    public int getFrameRate() {
        return this.FrameRate;
    }

    public boolean isIFrameEnable() {
        return this.IframeEnable == 1;
    }

    public void setFrameRate(int i) {
        this.FrameRate = i;
    }

    public int getIframeEnable() {
        return this.IframeEnable;
    }

    public void setIframeEnable(int i) {
        this.IframeEnable = i;
    }

    public int getResolution() {
        return this.Resolution;
    }

    public void setResolution(int i) {
        this.Resolution = i;
    }

    public String toString() {
        return " BitRate=" + this.BitRate + " FrameRate=" + this.FrameRate + " IframeEnable=" + this.IframeEnable + " Resolution=" + this.Resolution;
    }
}
