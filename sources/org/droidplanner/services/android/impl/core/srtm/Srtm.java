package org.droidplanner.services.android.impl.core.srtm;

public class Srtm {
    private static final int SRTM_NaN = -32768;
    private OnProgressListner listner;
    private SrtmData srtmData;

    public interface OnProgressListner {
        void onProgress(String str, int i);
    }

    public Srtm(String str) {
        this.srtmData = new SrtmData(str);
    }

    public int getData(double d, double d2) {
        try {
            return this.srtmData.load(d, d2, this.listner);
        } catch (Exception e) {
            e.printStackTrace();
            return SRTM_NaN;
        }
    }

    public void setListner(OnProgressListner onProgressListner) {
        this.listner = onProgressListner;
    }
}
