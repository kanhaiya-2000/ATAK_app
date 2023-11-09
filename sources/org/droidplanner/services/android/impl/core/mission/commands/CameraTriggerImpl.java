package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class CameraTriggerImpl extends MissionCMD {
    private double distance = 0.0d;

    public CameraTriggerImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public CameraTriggerImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public CameraTriggerImpl(MissionImpl missionImpl, double d) {
        super(missionImpl);
        this.distance = d;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 206;
        msg_mission_item.param1 = (float) this.distance;
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        this.distance = (double) msg_mission_item.param1;
    }

    public MissionItemType getType() {
        return MissionItemType.CAMERA_TRIGGER;
    }

    public double getTriggerDistance() {
        return this.distance;
    }

    public void setTriggerDistance(double d) {
        this.distance = d;
    }
}
