package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class TakeoffImpl extends MissionCMD {
    public static final double DEFAULT_TAKEOFF_ALTITUDE = 10.0d;
    private double finishedAlt = 10.0d;
    private double pitch = 0.0d;

    public TakeoffImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public TakeoffImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public TakeoffImpl(MissionImpl missionImpl, double d) {
        super(missionImpl);
        this.finishedAlt = d;
        this.pitch = 0.0d;
    }

    public TakeoffImpl(MissionImpl missionImpl, double d, double d2) {
        super(missionImpl);
        this.finishedAlt = d;
        this.pitch = d2;
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 22;
        msg_mission_item.frame = 3;
        msg_mission_item.f8321z = (float) this.finishedAlt;
        double d = this.pitch;
        if (d > 0.0d) {
            msg_mission_item.param1 = (float) d;
        }
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        this.finishedAlt = (double) msg_mission_item.f8321z;
        this.pitch = (double) msg_mission_item.param1;
    }

    public MissionItemType getType() {
        return MissionItemType.TAKEOFF;
    }

    public double getFinishedAlt() {
        return this.finishedAlt;
    }

    public void setFinishedAlt(double d) {
        this.finishedAlt = d;
    }

    public double getPitch() {
        return this.pitch;
    }

    public void setPitch(double d) {
        this.pitch = d;
    }
}
