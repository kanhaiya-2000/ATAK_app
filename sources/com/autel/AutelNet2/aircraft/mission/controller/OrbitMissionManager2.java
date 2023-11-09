package com.autel.AutelNet2.aircraft.mission.controller;

import com.autel.AutelNet2.aircraft.base.CommandAckPacket;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.aircraft.mission.engine.CylinderInfo;
import com.autel.AutelNet2.aircraft.mission.engine.OrbitInfo;
import com.autel.AutelNet2.aircraft.mission.message.CylinderMissionPacket;
import com.autel.AutelNet2.aircraft.mission.message.OrbitMissionPacket;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.mission.xstar.OrbitRealTimeInfo;

public class OrbitMissionManager2 extends BaseController<Integer> {
    private static final String REGISTER_MESSAGE_KEY = "OrbitMissionManager2";
    private static final short REGISTER_MESSAGE_TYPE = 263;
    private static OrbitMissionManager2 instance_;

    public static synchronized OrbitMissionManager2 getInstance() {
        OrbitMissionManager2 orbitMissionManager2;
        synchronized (OrbitMissionManager2.class) {
            if (instance_ == null) {
                instance_ = new OrbitMissionManager2();
            }
            orbitMissionManager2 = instance_;
        }
        return orbitMissionManager2;
    }

    private OrbitMissionManager2() {
        init();
    }

    public void orbitMission(OrbitInfo orbitInfo, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new OrbitMissionPacket(orbitInfo), callbackWithOneParam);
    }

    public void cylinderMission(CylinderInfo cylinderInfo, CallbackWithOneParam<Boolean> callbackWithOneParam) {
        sendPacket(new CylinderMissionPacket(cylinderInfo), callbackWithOneParam);
    }

    public void addRealTimeOrbitInfoListener(String str, CallbackWithOneParam<OrbitRealTimeInfo> callbackWithOneParam) {
        MissionStateManager.getInstance().addRealTimeInfoListener(1, str, callbackWithOneParam);
    }

    public void removeRealTimeOrbitInfoListener(String str) {
        MissionStateManager.getInstance().removeRealTimeInfoListener(1, str);
    }

    /* access modifiers changed from: protected */
    public void checkTimeOut() {
        super.checkTimeOut();
    }

    /* access modifiers changed from: protected */
    public Integer getTimeOutItem(BaseMsgPacket baseMsgPacket) {
        return Integer.valueOf(baseMsgPacket.getType());
    }

    public void init() {
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 263, this);
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 263);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        CommandInfoInternal commandInfoInternal;
        if ((baseMsgPacket instanceof CommandAckPacket) && (commandInfoInternal = ((CommandAckPacket) baseMsgPacket).getCommandInfoInternal()) != null) {
            int type = baseMsgPacket.getType();
            if (((CallbackWithOneParam) this.mListeners.get(Integer.valueOf(type))) != null) {
                callbackSucc(type, commandInfoInternal);
            }
        }
    }
}
