package com.autel.camera.communication.tcp;

import com.autel.camera.communication.tcp.connection.CameraHeartBeatTcpImpl;

public class CameraHeartBeat extends CameraHeartBeatTcpImpl {
    public static CameraHeartBeat instance() {
        return CameraHeartBeatHolder.s_instance;
    }

    private static class CameraHeartBeatHolder {
        /* access modifiers changed from: private */
        public static final CameraHeartBeat s_instance = new CameraHeartBeat();

        private CameraHeartBeatHolder() {
        }
    }
}
