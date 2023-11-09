package com.autel.camera.communication;

import com.autel.util.log.AutelLog;

public class CameraConnection {
    private static CameraConnection s_instance;

    public void resetDisconnect() {
    }

    private CameraConnection() {
    }

    public static CameraConnection instance() {
        if (s_instance == null) {
            s_instance = new CameraConnection();
        }
        return s_instance;
    }

    public void connect() {
        AutelLog.m15082d("camera_connect1", "camera fire connect");
    }

    public void disconnect() {
        AutelLog.m15082d("AbsTcpConnection", "CameraConnection disconnect");
    }
}
