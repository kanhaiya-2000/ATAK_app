package com.autel.AutelNet2.aircraft.camera;

import com.autel.AutelNet2.aircraft.camera.message.CameraStatusPacket;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.util.log.AutelLog;
import java.util.concurrent.ConcurrentHashMap;

public class CameraManager2 extends BaseController<Integer> {
    private static final String TAG = "CameraManager2";
    private final ConcurrentHashMap<String, CallbackWithOneParam> mCameraStatusListeners;

    private CameraManager2() {
        this.mCameraStatusListeners = new ConcurrentHashMap<>();
        init();
    }

    public static CameraManager2 instance() {
        return CameraManager2Holder.s_instance;
    }

    static class CameraManager2Holder {
        public static CameraManager2 s_instance = new CameraManager2();

        CameraManager2Holder() {
        }
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(TAG, 25, this);
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener(TAG, 25);
    }

    public void setCameraEventsListener(String str, CallbackWithOneParam<String> callbackWithOneParam) {
        if (callbackWithOneParam != null) {
            this.mCameraStatusListeners.put(str, callbackWithOneParam);
        }
    }

    public void removeCameraEventsListener(String str) {
        this.mCameraStatusListeners.remove(str);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        ConcurrentHashMap<String, CallbackWithOneParam> concurrentHashMap;
        AutelLog.m15090w(TAG, "onReceiveMessage----->>> " + baseMsgPacket.toString());
        if ((baseMsgPacket instanceof CameraStatusPacket) && (concurrentHashMap = this.mCameraStatusListeners) != null) {
            for (CallbackWithOneParam onSuccess : concurrentHashMap.values()) {
                onSuccess.onSuccess(((CameraStatusPacket) baseMsgPacket).getResponse());
            }
        }
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        return Integer.valueOf(baseMsgPacket.getType());
    }
}
