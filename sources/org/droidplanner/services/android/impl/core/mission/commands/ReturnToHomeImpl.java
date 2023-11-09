package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class ReturnToHomeImpl extends MissionCMD {
    private double returnAltitude;

    public ReturnToHomeImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
        this.returnAltitude = 0.0d;
    }

    public ReturnToHomeImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public ReturnToHomeImpl(MissionImpl missionImpl) {
        super(missionImpl);
        this.returnAltitude = 0.0d;
    }

    public double getHeight() {
        return this.returnAltitude;
    }

    public void setHeight(double d) {
        this.returnAltitude = d;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 20;
        msg_mission_item.frame = 3;
        msg_mission_item.f8321z = (float) this.returnAltitude;
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        this.returnAltitude = (double) msg_mission_item.f8321z;
    }

    public MissionItemType getType() {
        return MissionItemType.RTL;
    }
}
