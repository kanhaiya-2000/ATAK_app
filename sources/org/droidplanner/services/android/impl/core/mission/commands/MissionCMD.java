package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;

public abstract class MissionCMD extends MissionItemImpl {
    public MissionCMD(MissionImpl missionImpl) {
        super(missionImpl);
    }

    public MissionCMD(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public List<msg_mission_item> packMissionItem() {
        return super.packMissionItem();
    }
}
