package com.autel.common.dsp;

public class RFData {
    public float frequency;
    public int value;

    public RFData(float f, int i) {
        this.frequency = f;
        this.value = i;
    }

    public String toString() {
        return "frequency == " + this.frequency + "    value == " + this.value;
    }
}
