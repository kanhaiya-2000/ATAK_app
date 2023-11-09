package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import com.atakmap.android.uastool.MAVLink.enums.MAV_CMD;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class EpmGripperImpl extends MissionCMD {
    private boolean release = true;

    public EpmGripperImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public EpmGripperImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public EpmGripperImpl(MissionImpl missionImpl, boolean z) {
        super(missionImpl);
        this.release = z;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = MAV_CMD.MAV_CMD_DO_GRIPPER;
        msg_mission_item.param2 = this.release ? 0.0f : 1.0f;
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        if (msg_mission_item.param2 == 1.0f) {
            this.release = false;
        } else if (msg_mission_item.param2 == 0.0f) {
            this.release = true;
        }
    }

    public MissionItemType getType() {
        return MissionItemType.EPM_GRIPPER;
    }

    public boolean isRelease() {
        return this.release;
    }

    public void setAsRelease(boolean z) {
        this.release = z;
    }
}
