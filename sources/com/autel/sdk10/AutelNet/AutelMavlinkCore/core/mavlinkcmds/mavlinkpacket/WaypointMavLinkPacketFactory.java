package com.autel.sdk10.AutelNet.AutelMavlinkCore.core.mavlinkcmds.mavlinkpacket;

import com.MAVLink.Messages.MAVLinkPacket;
import com.MAVLink.Messages.ardupilotmega.msg_mission_ack;
import com.MAVLink.Messages.ardupilotmega.msg_mission_clear_all;
import com.MAVLink.Messages.ardupilotmega.msg_mission_count;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request;
import com.MAVLink.Messages.ardupilotmega.msg_mission_request_list;

public final class WaypointMavLinkPacketFactory {
    private WaypointMavLinkPacketFactory() {
    }

    public static MAVLinkPacket createSendWaypointAckPacket() {
        msg_mission_ack msg_mission_ack = new msg_mission_ack();
        msg_mission_ack.target_system = 1;
        msg_mission_ack.target_component = -66;
        msg_mission_ack.type = 0;
        return msg_mission_ack.pack();
    }

    public static MAVLinkPacket createRequestWayPointPacket(int i) {
        msg_mission_request msg_mission_request = new msg_mission_request();
        msg_mission_request.target_system = 1;
        msg_mission_request.target_component = -66;
        msg_mission_request.seq = (short) i;
        return msg_mission_request.pack();
    }

    public static MAVLinkPacket createRequestWaypointsListPacket() {
        msg_mission_request_list msg_mission_request_list = new msg_mission_request_list();
        msg_mission_request_list.target_system = 1;
        msg_mission_request_list.target_component = -66;
        return msg_mission_request_list.pack();
    }

    public static MAVLinkPacket createSendWaypointCountPacket(int i) {
        msg_mission_count msg_mission_count = new msg_mission_count();
        msg_mission_count.target_system = 1;
        msg_mission_count.target_component = -66;
        msg_mission_count.count = (short) i;
        return msg_mission_count.pack();
    }

    public static MAVLinkPacket clearAllWaypoint() {
        msg_mission_clear_all msg_mission_clear_all = new msg_mission_clear_all();
        msg_mission_clear_all.target_system = 1;
        msg_mission_clear_all.target_component = -66;
        return msg_mission_clear_all.pack();
    }
}
