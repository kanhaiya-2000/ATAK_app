package org.droidplanner.services.android.impl.core.mission.waypoints;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class LandImpl extends SpatialCoordItem {
    public LandImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
        setAltitude(0.0d);
    }

    public LandImpl(MissionImpl missionImpl) {
        this(missionImpl, new LatLong(0.0d, 0.0d));
    }

    public LandImpl(MissionImpl missionImpl, LatLong latLong) {
        super(missionImpl, new LatLongAlt(latLong, 0.0d));
    }

    public LandImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl, (LatLongAlt) null);
        unpackMAVMessage(msg_mission_item);
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        packMissionItem.get(0).command = 21;
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        super.unpackMAVMessage(msg_mission_item);
    }

    public MissionItemType getType() {
        return MissionItemType.LAND;
    }
}
