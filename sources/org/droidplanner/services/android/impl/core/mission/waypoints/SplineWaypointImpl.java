package org.droidplanner.services.android.impl.core.mission.waypoints;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class SplineWaypointImpl extends SpatialCoordItem {
    private double delay;

    public SplineWaypointImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public SplineWaypointImpl(MissionImpl missionImpl, LatLongAlt latLongAlt) {
        super(missionImpl, latLongAlt);
    }

    public SplineWaypointImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl, (LatLongAlt) null);
        unpackMAVMessage(msg_mission_item);
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 82;
        msg_mission_item.param1 = (float) this.delay;
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        super.unpackMAVMessage(msg_mission_item);
        setDelay((double) msg_mission_item.param1);
    }

    public MissionItemType getType() {
        return MissionItemType.SPLINE_WAYPOINT;
    }

    public double getDelay() {
        return this.delay;
    }

    public void setDelay(double d) {
        this.delay = d;
    }
}
