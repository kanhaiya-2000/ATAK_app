package com.autel.camera.protocol.protocol20;

public class CameraManager {
    private volatile boolean isParameterValid;
    private volatile String mCameraModel;

    private CameraManager() {
    }

    public static CameraManager instance() {
        return CameraManagerHolder.s_instance;
    }

    private static class CameraManagerHolder {
        /* access modifiers changed from: private */
        public static final CameraManager s_instance = new CameraManager();

        private CameraManagerHolder() {
        }
    }

    public String getCameraModel() {
        return this.mCameraModel;
    }

    public void setCameraModel(String str) {
        this.mCameraModel = str;
    }

    public boolean isParameterValid() {
        return this.isParameterValid;
    }

    public void setParameterValid(boolean z) {
        this.isParameterValid = z;
    }
}
