package org.droidplanner.services.android.impl.core.mission;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.ArrayList;
import java.util.List;

public abstract class MissionItemImpl implements Comparable<MissionItemImpl> {
    protected MissionImpl missionImpl;

    public abstract MissionItemType getType();

    public abstract void unpackMAVMessage(msg_mission_item msg_mission_item);

    public MissionItemImpl(MissionImpl missionImpl2) {
        this.missionImpl = missionImpl2;
    }

    public MissionItemImpl(MissionItemImpl missionItemImpl) {
        this(missionItemImpl.missionImpl);
    }

    public List<msg_mission_item> packMissionItem() {
        ArrayList arrayList = new ArrayList();
        msg_mission_item msg_mission_item = new msg_mission_item();
        arrayList.add(msg_mission_item);
        msg_mission_item.autocontinue = 1;
        msg_mission_item.frame = 3;
        return arrayList;
    }

    public MissionImpl getMission() {
        return this.missionImpl;
    }

    public int compareTo(MissionItemImpl missionItemImpl) {
        return this.missionImpl.getOrder(this) - this.missionImpl.getOrder(missionItemImpl);
    }
}
