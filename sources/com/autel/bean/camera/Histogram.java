package com.autel.bean.camera;

public class Histogram {
    private Object[] PixelsPerLevel;
    private int TotalPixels;

    public int getTotalPixels() {
        return this.TotalPixels;
    }

    public void setTotalPixels(int i) {
        this.TotalPixels = i;
    }

    public Object[] getPixelsPerLevel() {
        return this.PixelsPerLevel;
    }

    public void setPixelsPerLevel(Object[] objArr) {
        this.PixelsPerLevel = objArr;
    }

    public int[] getHistogramData() {
        int[] iArr = new int[64];
        if (this.PixelsPerLevel == null) {
            return iArr;
        }
        int i = 0;
        while (true) {
            Object[] objArr = this.PixelsPerLevel;
            if (i >= objArr.length || i >= 64) {
                return iArr;
            }
            iArr[i] = (int) Math.abs(((Double) objArr[i]).doubleValue());
            i++;
        }
        return iArr;
    }
}
