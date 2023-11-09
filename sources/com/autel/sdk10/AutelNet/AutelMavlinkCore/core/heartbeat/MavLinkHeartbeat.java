package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.heartbeat;

import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.ardupilotmega.msg_heartbeat;
import com.autel.sdk10.AutelNet.AutelMavlinkCore.controller.StarLinkClientManager;

public class MavLinkHeartbeat {
    private static final msg_heartbeat sMsg;
    private static final MAVLinkPacket sMsgPacket;

    static {
        msg_heartbeat msg_heartbeat = new msg_heartbeat();
        sMsg = msg_heartbeat;
        msg_heartbeat.type = 6;
        msg_heartbeat.autopilot = 0;
        sMsgPacket = msg_heartbeat.pack();
    }

    public static void sendMavHeartbeat() {
        StarLinkClientManager.getInstance_().sendMavPacket(sMsgPacket);
    }
}
