package com.autel.internal.sdk.camera.data;

import com.autel.internal.sdk.camera.data.base.BaseCameraData;

public class CameraModelDataManager {
    private volatile BaseCameraData baseCameraData;

    private CameraModelDataManager() {
    }

    private static class CameraModelDataManagerHolder {
        /* access modifiers changed from: private */
        public static final CameraModelDataManager s_instance = new CameraModelDataManager();

        private CameraModelDataManagerHolder() {
        }
    }

    public static CameraModelDataManager instance() {
        return CameraModelDataManagerHolder.s_instance;
    }

    public BaseCameraData getBaseCameraData() {
        return this.baseCameraData;
    }

    public void setBaseCameraData(BaseCameraData baseCameraData2) {
        this.baseCameraData = baseCameraData2;
    }
}
