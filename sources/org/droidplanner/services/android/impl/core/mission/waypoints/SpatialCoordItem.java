package org.droidplanner.services.android.impl.core.mission.waypoints;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLong;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;

public abstract class SpatialCoordItem extends MissionItemImpl {
    protected LatLongAlt coordinate;

    public SpatialCoordItem(MissionImpl missionImpl, LatLongAlt latLongAlt) {
        super(missionImpl);
        this.coordinate = latLongAlt;
    }

    public SpatialCoordItem(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
        if (missionItemImpl instanceof SpatialCoordItem) {
            this.coordinate = ((SpatialCoordItem) missionItemImpl).getCoordinate();
        } else {
            this.coordinate = new LatLongAlt(0.0d, 0.0d, 0.0d);
        }
    }

    public void setCoordinate(LatLongAlt latLongAlt) {
        this.coordinate = latLongAlt;
    }

    public LatLongAlt getCoordinate() {
        return this.coordinate;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.f8319x = (float) this.coordinate.getLatitude();
        msg_mission_item.f8320y = (float) this.coordinate.getLongitude();
        msg_mission_item.f8321z = (float) this.coordinate.getAltitude();
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        setCoordinate(new LatLongAlt((double) msg_mission_item.f8319x, (double) msg_mission_item.f8320y, (double) msg_mission_item.f8321z));
    }

    public void setAltitude(double d) {
        this.coordinate.setAltitude(d);
    }

    public void setPosition(LatLong latLong) {
        this.coordinate.set(latLong);
    }
}
