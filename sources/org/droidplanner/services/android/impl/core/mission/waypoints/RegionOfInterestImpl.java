package org.droidplanner.services.android.impl.core.mission.waypoints;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class RegionOfInterestImpl extends SpatialCoordItem {
    public RegionOfInterestImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public RegionOfInterestImpl(MissionImpl missionImpl, LatLongAlt latLongAlt) {
        super(missionImpl, latLongAlt);
    }

    public RegionOfInterestImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl, (LatLongAlt) null);
        unpackMAVMessage(msg_mission_item);
    }

    public boolean isReset() {
        return this.coordinate.getLatitude() == 0.0d && this.coordinate.getLongitude() == 0.0d && this.coordinate.getAltitude() == 0.0d;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        packMissionItem.get(0).command = 201;
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        super.unpackMAVMessage(msg_mission_item);
    }

    public MissionItemType getType() {
        return MissionItemType.ROI;
    }
}
