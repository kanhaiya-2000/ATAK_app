package com.autel.bean.dsp;

public class ChannelInfo {
    private int Freq;
    private int Strength;

    public float getFreq() {
        return (float) (this.Freq / 10);
    }

    public void setFreq(int i) {
        this.Freq = i;
    }

    public int getStrength() {
        return this.Strength;
    }

    public void setStrength(int i) {
        this.Strength = i;
    }
}
