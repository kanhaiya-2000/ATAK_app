package com.autel.sdk10.AutelNet.AutelMission.utils;

import com.MAVLink.Messages.ardupilotmega.msg_mission_item;
import com.autel.common.mission.AutelCoordinate3D;
import com.autel.common.mission.xstar.Waypoint;
import java.util.ArrayList;
import java.util.Iterator;

public final class TransformUtils {
    private TransformUtils() {
    }

    public static ArrayList<Waypoint> msg_mission_item2WaypointList(ArrayList<msg_mission_item> arrayList) {
        ArrayList<Waypoint> arrayList2 = new ArrayList<>();
        Iterator<msg_mission_item> it = arrayList.iterator();
        while (it.hasNext()) {
            msg_mission_item next = it.next();
            Waypoint waypoint = new Waypoint(new AutelCoordinate3D((double) next.f8185x, (double) next.f8186y, (double) next.f8187z));
            waypoint.setDelay((double) next.param1);
            arrayList2.add(waypoint);
        }
        return arrayList2;
    }

    public static msg_mission_item Waypoint2msg_mission_item(Waypoint waypoint) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.command = 16;
        msg_mission_item.param1 = (float) waypoint.getDelay();
        msg_mission_item.param2 = 5.0f;
        msg_mission_item.param3 = 0.0f;
        msg_mission_item.param4 = 0.0f;
        msg_mission_item.current = 0;
        msg_mission_item.autocontinue = 1;
        msg_mission_item.target_component = -66;
        msg_mission_item.target_system = 1;
        msg_mission_item.frame = 3;
        msg_mission_item.f8185x = (float) waypoint.getAutelCoordinate3D().getLatitude();
        msg_mission_item.f8186y = (float) waypoint.getAutelCoordinate3D().getLongitude();
        msg_mission_item.f8187z = (float) waypoint.getAutelCoordinate3D().getAltitude();
        return msg_mission_item;
    }

    public static msg_mission_item Waypoint2msg_mission_item(Waypoint waypoint, int i, int i2) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        msg_mission_item.command = 16;
        msg_mission_item.param1 = (float) waypoint.getDelay();
        msg_mission_item.param2 = 5.0f;
        msg_mission_item.param3 = 0.0f;
        msg_mission_item.param4 = 0.0f;
        msg_mission_item.current = (byte) i2;
        msg_mission_item.autocontinue = 1;
        msg_mission_item.target_component = -66;
        msg_mission_item.target_system = 1;
        msg_mission_item.seq = (short) i;
        msg_mission_item.frame = 3;
        msg_mission_item.f8185x = (float) waypoint.getAutelCoordinate3D().getLatitude();
        msg_mission_item.f8186y = (float) waypoint.getAutelCoordinate3D().getLongitude();
        msg_mission_item.f8187z = (float) waypoint.getAutelCoordinate3D().getAltitude();
        return msg_mission_item;
    }
}
