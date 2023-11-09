package com.atakmap.android.uastool.p000av;

/* renamed from: com.atakmap.android.uastool.av.ZoomData */
class ZoomData {
    private final double hfov;
    private final double vfov;
    private final int zoomIndex;

    public ZoomData(int i, double d, double d2) {
        this.zoomIndex = i;
        this.hfov = d;
        this.vfov = d2;
    }

    public int getZoomIndex() {
        return this.zoomIndex;
    }

    public double getHfov() {
        return this.hfov;
    }

    public double getVfov() {
        return this.vfov;
    }
}
