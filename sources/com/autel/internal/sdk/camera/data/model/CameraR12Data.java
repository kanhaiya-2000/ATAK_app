package com.autel.internal.sdk.camera.data.model;

import com.autel.internal.sdk.camera.data.base.CameraData;

public class CameraR12Data extends CameraData {
    private int Enable3DNR;
    private int EnableSubtitle;

    private static class CameraR12DataHolder {
        /* access modifiers changed from: private */
        public static final CameraR12Data s_instance = new CameraR12Data();

        private CameraR12DataHolder() {
        }
    }

    private CameraR12Data() {
    }

    public static CameraR12Data instance() {
        return CameraR12DataHolder.s_instance;
    }

    public int getEnableSubtitle() {
        return this.EnableSubtitle;
    }

    public void setEnableSubtitle(int i) {
        this.EnableSubtitle = i;
    }

    public int getEnable3DNR() {
        return this.Enable3DNR;
    }

    public void setEnable3DNR(int i) {
        this.Enable3DNR = i;
    }
}
