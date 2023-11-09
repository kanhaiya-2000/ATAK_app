package com.autel.camera.heartbeat.heartbeat20;

import com.autel.camera.communication.http.connection.HttpConnectImpl;

public class CameraHeartBeat20 extends HttpConnectImpl {
    private CameraHeartBeat20() {
    }

    public static CameraHeartBeat20 instance() {
        return CameraHeartBeatManager20Holder.s_instance;
    }

    private static class CameraHeartBeatManager20Holder {
        /* access modifiers changed from: private */
        public static final CameraHeartBeat20 s_instance = new CameraHeartBeat20();

        private CameraHeartBeatManager20Holder() {
        }
    }
}
