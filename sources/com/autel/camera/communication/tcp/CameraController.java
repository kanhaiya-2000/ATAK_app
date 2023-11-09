package com.autel.camera.communication.tcp;

import com.autel.camera.communication.tcp.connection.CameraControllerTcpImpl;

public class CameraController extends CameraControllerTcpImpl {
    private volatile int isTcpCameraToken;

    private CameraController() {
        this.isTcpCameraToken = -1;
    }

    public static CameraController instance() {
        return CameraControllerHolder.s_instance;
    }

    private static class CameraControllerHolder {
        /* access modifiers changed from: private */
        public static final CameraController s_instance = new CameraController();

        private CameraControllerHolder() {
        }
    }

    public int getTcpCameraToken() {
        return this.isTcpCameraToken;
    }

    public void setTcpCameraToken(int i) {
        this.isTcpCameraToken = i;
    }
}
