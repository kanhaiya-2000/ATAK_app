package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class SetRelayImpl extends MissionCMD {
    private boolean enabled;
    private int relayNumber;

    public SetRelayImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public SetRelayImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public SetRelayImpl(MissionImpl missionImpl, int i, boolean z) {
        super(missionImpl);
        this.relayNumber = i;
        this.enabled = z;
    }

    public MissionItemType getType() {
        return MissionItemType.SET_RELAY;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        this.relayNumber = (int) msg_mission_item.param1;
        this.enabled = msg_mission_item.param2 != 0.0f;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 181;
        msg_mission_item.param1 = (float) this.relayNumber;
        msg_mission_item.param2 = this.enabled ? 1.0f : 0.0f;
        return packMissionItem;
    }

    public int getRelayNumber() {
        return this.relayNumber;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
