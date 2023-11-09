package com.autel.camera.protocol.protocol10.engine;

public class HistogramInfo {
    private int[] data;
    private int pixels;

    public int[] getData() {
        return this.data;
    }

    public void setData(int[] iArr) {
        this.data = iArr;
    }

    public int getPixels() {
        return this.pixels;
    }

    public void setPixels(int i) {
        this.pixels = i;
    }
}
