package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class ChangeSpeedImpl extends MissionCMD {
    private double speed = 5.0d;

    public ChangeSpeedImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public ChangeSpeedImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public ChangeSpeedImpl(MissionImpl missionImpl, double d) {
        super(missionImpl);
        this.speed = d;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 178;
        msg_mission_item.frame = 3;
        msg_mission_item.param2 = (float) this.speed;
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        this.speed = (double) msg_mission_item.param2;
    }

    public MissionItemType getType() {
        return MissionItemType.CHANGE_SPEED;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }
}
