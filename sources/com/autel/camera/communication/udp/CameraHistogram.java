package com.autel.camera.communication.udp;

import com.autel.camera.communication.udp.connection.HistogramImpl;

public class CameraHistogram extends HistogramImpl {
    private CameraHistogram() {
    }

    private static class CameraHistogramHolder {
        /* access modifiers changed from: private */
        public static final CameraHistogram s_instance = new CameraHistogram();

        private CameraHistogramHolder() {
        }
    }

    public static CameraHistogram instance() {
        return CameraHistogramHolder.s_instance;
    }
}
