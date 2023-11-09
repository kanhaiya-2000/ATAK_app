package com.autel.camera.heartbeat.heartbeat10;

import android.util.Log;
import com.autel.camera.communication.tcp.CameraController;
import com.autel.camera.communication.tcp.CameraHeartBeat;
import com.autel.internal.network.interfaces.IConnectionListener;
import com.autel.internal.sdk.camera.base.ConnectConnectStatus;

public class CameraHeartBeat10 {
    private static final String TAG = "CameraHeartBeat10";

    private CameraHeartBeat10() {
    }

    public static CameraHeartBeat10 instance() {
        return CameraHeartBeat10Holder.s_instance;
    }

    public void unRegisterConnectListener(String str) {
        CameraHeartBeat.instance().unRegisterConnectListener(str);
    }

    public void registerConnectListener(String str, final IConnectionListener iConnectionListener) {
        CameraHeartBeat.instance().registerConnectListener(str, new IConnectionListener() {
            public void onConnectStatus(ConnectConnectStatus connectConnectStatus) {
                iConnectionListener.onConnectStatus(connectConnectStatus);
            }
        });
    }

    public void disconnect() {
        Log.e("AbsTcpConnection", "CameraHeratBeat10 disconnect--- ");
        CameraController.instance().disconnect();
        CameraHeartBeat.instance().disconnect();
    }

    private static class CameraHeartBeat10Holder {
        /* access modifiers changed from: private */
        public static final CameraHeartBeat10 s_instance = new CameraHeartBeat10();

        private CameraHeartBeat10Holder() {
        }
    }
}
