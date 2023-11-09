package org.droidplanner.services.android.impl.core.MAVLink;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_ack;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_count;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_request_list;
import com.atakmap.android.uastool.MAVLink.common.msg_mission_set_current;
import com.o3dr.services.android.lib.model.ICommandListener;
import org.droidplanner.services.android.impl.core.drone.autopilot.MavLinkDrone;

public class MavLinkWaypoint {
    public static void sendAck(MavLinkDrone mavLinkDrone) {
        msg_mission_ack msg_mission_ack = new msg_mission_ack();
        msg_mission_ack.target_system = mavLinkDrone.getSysid();
        msg_mission_ack.target_component = mavLinkDrone.getCompid();
        msg_mission_ack.type = 0;
        mavLinkDrone.getMavClient().sendMessage(msg_mission_ack, (ICommandListener) null);
    }

    public static void requestWayPoint(MavLinkDrone mavLinkDrone, int i) {
        msg_mission_request msg_mission_request = new msg_mission_request();
        msg_mission_request.target_system = mavLinkDrone.getSysid();
        msg_mission_request.target_component = mavLinkDrone.getCompid();
        msg_mission_request.seq = i;
        mavLinkDrone.getMavClient().sendMessage(msg_mission_request, (ICommandListener) null);
    }

    public static void requestWaypointsList(MavLinkDrone mavLinkDrone) {
        msg_mission_request_list msg_mission_request_list = new msg_mission_request_list();
        msg_mission_request_list.target_system = mavLinkDrone.getSysid();
        msg_mission_request_list.target_component = mavLinkDrone.getCompid();
        mavLinkDrone.getMavClient().sendMessage(msg_mission_request_list, (ICommandListener) null);
    }

    public static void sendWaypointCount(MavLinkDrone mavLinkDrone, int i) {
        msg_mission_count msg_mission_count = new msg_mission_count();
        msg_mission_count.target_system = mavLinkDrone.getSysid();
        msg_mission_count.target_component = mavLinkDrone.getCompid();
        msg_mission_count.count = i;
        mavLinkDrone.getMavClient().sendMessage(msg_mission_count, (ICommandListener) null);
    }

    public static void sendSetCurrentWaypoint(MavLinkDrone mavLinkDrone, short s) {
        msg_mission_set_current msg_mission_set_current = new msg_mission_set_current();
        msg_mission_set_current.target_system = mavLinkDrone.getSysid();
        msg_mission_set_current.target_component = mavLinkDrone.getCompid();
        msg_mission_set_current.seq = s;
        mavLinkDrone.getMavClient().sendMessage(msg_mission_set_current, (ICommandListener) null);
    }
}
