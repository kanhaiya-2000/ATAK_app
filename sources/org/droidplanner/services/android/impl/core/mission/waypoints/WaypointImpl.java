package org.droidplanner.services.android.impl.core.mission.waypoints;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.o3dr.services.android.lib.coordinate.LatLongAlt;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class WaypointImpl extends SpatialCoordItem {
    private double acceptanceRadius;
    private double delay;
    private boolean orbitCCW;
    private double orbitalRadius;
    private double yawAngle;

    public WaypointImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public WaypointImpl(MissionImpl missionImpl, LatLongAlt latLongAlt) {
        super(missionImpl, latLongAlt);
    }

    public WaypointImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl, (LatLongAlt) null);
        unpackMAVMessage(msg_mission_item);
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 16;
        msg_mission_item.param1 = (float) getDelay();
        msg_mission_item.param2 = (float) getAcceptanceRadius();
        msg_mission_item.param3 = (float) (isOrbitCCW() ? getOrbitalRadius() * -1.0d : getOrbitalRadius());
        msg_mission_item.param4 = (float) getYawAngle();
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        super.unpackMAVMessage(msg_mission_item);
        setDelay((double) msg_mission_item.param1);
        setAcceptanceRadius((double) msg_mission_item.param2);
        setOrbitCCW(msg_mission_item.param3 < 0.0f);
        setOrbitalRadius((double) Math.abs(msg_mission_item.param3));
        setYawAngle((double) msg_mission_item.param4);
    }

    public MissionItemType getType() {
        return MissionItemType.WAYPOINT;
    }

    public double getDelay() {
        return this.delay;
    }

    public void setDelay(double d) {
        this.delay = d;
    }

    public double getAcceptanceRadius() {
        return this.acceptanceRadius;
    }

    public void setAcceptanceRadius(double d) {
        this.acceptanceRadius = d;
    }

    public double getYawAngle() {
        return this.yawAngle;
    }

    public void setYawAngle(double d) {
        this.yawAngle = d;
    }

    public double getOrbitalRadius() {
        return this.orbitalRadius;
    }

    public void setOrbitalRadius(double d) {
        this.orbitalRadius = d;
    }

    public boolean isOrbitCCW() {
        return this.orbitCCW;
    }

    public void setOrbitCCW(boolean z) {
        this.orbitCCW = z;
    }
}
