package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class DoJumpImpl extends MissionCMD {
    private int repeatCount;
    private int waypoint;

    public DoJumpImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public DoJumpImpl(MissionImpl missionImpl) {
        super(missionImpl);
    }

    public DoJumpImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public DoJumpImpl(MissionImpl missionImpl, int i, int i2) {
        super(missionImpl);
        this.waypoint = i;
        this.repeatCount = i2;
    }

    public int getWaypoint() {
        return this.waypoint;
    }

    public void setWaypoint(int i) {
        this.waypoint = i;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public void setRepeatCount(int i) {
        this.repeatCount = i;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        this.waypoint = (int) msg_mission_item.param1;
        this.repeatCount = (int) msg_mission_item.param2;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 177;
        msg_mission_item.param1 = (float) this.waypoint;
        msg_mission_item.param2 = (float) this.repeatCount;
        return packMissionItem;
    }

    public MissionItemType getType() {
        return MissionItemType.DO_JUMP;
    }
}
