package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class SetServoImpl extends MissionCMD {
    private int channel;
    private int pwm;

    public SetServoImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public SetServoImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public SetServoImpl(MissionImpl missionImpl, int i, int i2) {
        super(missionImpl);
        this.channel = i;
        this.pwm = i2;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        this.channel = (int) msg_mission_item.param1;
        this.pwm = (int) msg_mission_item.param2;
    }

    public MissionItemType getType() {
        return MissionItemType.SET_SERVO;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 183;
        msg_mission_item.param1 = (float) this.channel;
        msg_mission_item.param2 = (float) this.pwm;
        return packMissionItem;
    }

    public int getPwm() {
        return this.pwm;
    }

    public int getChannel() {
        return this.channel;
    }

    public void setPwm(int i) {
        this.pwm = i;
    }

    public void setChannel(int i) {
        this.channel = i;
    }
}
