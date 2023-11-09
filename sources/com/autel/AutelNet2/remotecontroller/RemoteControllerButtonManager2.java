package com.autel.AutelNet2.remotecontroller;

import com.autel.AutelNet2.core.AbstractHandlerController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.interfaces.IReceiveMessageListener;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.AutelNet2.remotecontroller.message.RCButtonPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import java.util.concurrent.ConcurrentHashMap;

public class RemoteControllerButtonManager2 extends AbstractHandlerController implements IReceiveMessageListener {
    private static final String REGISTER_MESSAGE_KEY = "RemoteControllerButtonManager2";
    private static final short REGISTER_MESSAGE_TYPE = 1024;
    private static final String TAG = "RemoteControllerButton";
    private static RemoteControllerButtonManager2 instance_;
    private final ConcurrentHashMap<String, CallbackWithOneParam<RemoteControllerNavigateButtonEvent>> mRCButtonDataListeners = new ConcurrentHashMap<>();

    public static synchronized RemoteControllerButtonManager2 getInstance() {
        RemoteControllerButtonManager2 remoteControllerButtonManager2;
        synchronized (RemoteControllerButtonManager2.class) {
            if (instance_ == null) {
                instance_ = new RemoteControllerButtonManager2();
            }
            remoteControllerButtonManager2 = instance_;
        }
        return remoteControllerButtonManager2;
    }

    private RemoteControllerButtonManager2() {
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 1024, this);
    }

    public void destroy() {
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 1024);
    }

    public void registeRCButtonMessageListener(String str, CallbackWithOneParam<RemoteControllerNavigateButtonEvent> callbackWithOneParam) {
        if (callbackWithOneParam != null && str != null) {
            PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 1024, this);
            this.mRCButtonDataListeners.put(str, callbackWithOneParam);
        }
    }

    public void unRegisteRCButtonMessageListener(String str) {
        this.mRCButtonDataListeners.remove(str);
        if (this.mRCButtonDataListeners.isEmpty()) {
            destroy();
        }
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        iteratorCallback(this.mRCButtonDataListeners, ((RCButtonPacket) baseMsgPacket).getAutelRCControlBtnEvent());
    }
}
