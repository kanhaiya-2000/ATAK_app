package com.autel.AutelNet2.aircraft.mission.controller;

import com.autel.AutelNet2.aircraft.base.CommandAckPacket;
import com.autel.AutelNet2.aircraft.flycontroller.engine.CommandInfoInternal;
import com.autel.AutelNet2.aircraft.mission.engine.WaypointActionInfo;
import com.autel.AutelNet2.aircraft.mission.engine.WaypointBean;
import com.autel.AutelNet2.aircraft.mission.message.WayPointInfoPacket;
import com.autel.AutelNet2.aircraft.mission.message.WaypointActionPacket;
import com.autel.AutelNet2.core.BaseController;
import com.autel.AutelNet2.core.PacketDisPatcher;
import com.autel.AutelNet2.core.message.BaseMsgPacket;
import com.autel.common.CallbackWithOneParam;

public class WayPointMissionManager2 extends BaseController<Integer> {
    private static final short REGISTER_COMMAND_TYPE = 263;
    private static final String REGISTER_MESSAGE_KEY = "WayPointMissionManager2";
    private static final short REGISTER_WAYPOINT_SETTINGS = 315;
    private static WayPointMissionManager2 instance_;

    public static synchronized WayPointMissionManager2 getInstance() {
        WayPointMissionManager2 wayPointMissionManager2;
        synchronized (WayPointMissionManager2.class) {
            if (instance_ == null) {
                instance_ = new WayPointMissionManager2();
            }
            wayPointMissionManager2 = instance_;
        }
        return wayPointMissionManager2;
    }

    private WayPointMissionManager2() {
        init();
    }

    public void setWaypointInfo(WaypointBean waypointBean) {
        sendPacket(new WayPointInfoPacket(waypointBean), (CallbackWithOneParam) null);
    }

    public void setWaypointActionInfo(WaypointActionInfo waypointActionInfo) {
        sendPacket(new WaypointActionPacket(waypointActionInfo), (CallbackWithOneParam) null);
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
        PacketDisPatcher.getInstance().registerReceiveListener(REGISTER_MESSAGE_KEY, 315, this);
    }

    public void destroy() {
        super.destroy();
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 263);
        PacketDisPatcher.getInstance().unRegisterReceiveListener(REGISTER_MESSAGE_KEY, 315);
    }

    public void onReceiveMessage(BaseMsgPacket baseMsgPacket) {
        CommandInfoInternal commandInfoInternal;
        if ((baseMsgPacket instanceof CommandAckPacket) && (commandInfoInternal = ((CommandAckPacket) baseMsgPacket).getCommandInfoInternal()) != null) {
            callbackSucc(baseMsgPacket.getType(), commandInfoInternal);
        }
    }
}
