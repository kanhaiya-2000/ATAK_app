package org.droidplanner.services.android.impl.core.mission.waypoints;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.util.ArrayList;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class CircleImpl extends SpatialCoordItem {
    private double radius = 10.0d;
    private int turns = 1;

    public CircleImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public CircleImpl(MissionImpl missionImpl, LatLongAlt latLongAlt) {
        super(missionImpl, latLongAlt);
    }

    public CircleImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl, (LatLongAlt) null);
        unpackMAVMessage(msg_mission_item);
    }

    public void setTurns(int i) {
        this.turns = Math.abs(i);
    }

    public void setRadius(double d) {
        this.radius = d;
    }

    public int getNumberOfTurns() {
        return this.turns;
    }

    public double getRadius() {
        return this.radius;
    }

    public List<msg_mission_item> packMissionItem() {
        ArrayList arrayList = new ArrayList();
        packSingleCircle(arrayList);
        return arrayList;
    }

    private void packSingleCircle(List<msg_mission_item> list) {
        msg_mission_item msg_mission_item = new msg_mission_item();
        list.add(msg_mission_item);
        msg_mission_item.autocontinue = 1;
        msg_mission_item.frame = 3;
        msg_mission_item.f8319x = (float) this.coordinate.getLatitude();
        msg_mission_item.f8320y = (float) this.coordinate.getLongitude();
        msg_mission_item.f8321z = (float) this.coordinate.getAltitude();
        msg_mission_item.command = 18;
        msg_mission_item.param1 = (float) Math.abs(this.turns);
        msg_mission_item.param3 = (float) this.radius;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        super.unpackMAVMessage(msg_mission_item);
        setTurns((int) msg_mission_item.param1);
        setRadius((double) msg_mission_item.param3);
    }

    public MissionItemType getType() {
        return MissionItemType.CIRCLE;
    }
}
