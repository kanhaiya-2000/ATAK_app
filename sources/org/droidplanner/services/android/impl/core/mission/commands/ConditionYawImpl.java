package org.droidplanner.services.android.impl.core.mission.commands;

import com.atakmap.android.uastool.MAVLink.common.msg_mission_item;
import java.util.List;
import org.droidplanner.services.android.impl.core.helpers.geoTools.GeoTools;
import org.droidplanner.services.android.impl.core.mission.MissionImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemImpl;
import org.droidplanner.services.android.impl.core.mission.MissionItemType;

public class ConditionYawImpl extends MissionCMD {
    private double angle = 0.0d;
    private double angularSpeed = 0.0d;
    private boolean isRelative = false;

    public ConditionYawImpl(MissionItemImpl missionItemImpl) {
        super(missionItemImpl);
    }

    public ConditionYawImpl(msg_mission_item msg_mission_item, MissionImpl missionImpl) {
        super(missionImpl);
        unpackMAVMessage(msg_mission_item);
    }

    public ConditionYawImpl(MissionImpl missionImpl, double d, boolean z) {
        super(missionImpl);
        setAngle(d);
        setRelative(z);
    }

    public List<msg_mission_item> packMissionItem() {
        List<msg_mission_item> packMissionItem = super.packMissionItem();
        msg_mission_item msg_mission_item = packMissionItem.get(0);
        msg_mission_item.command = 115;
        msg_mission_item.param1 = (float) GeoTools.warpToPositiveAngle(this.angle);
        msg_mission_item.param2 = (float) Math.abs(this.angularSpeed);
        float f = 1.0f;
        msg_mission_item.param3 = this.angularSpeed < 0.0d ? 1.0f : -1.0f;
        if (!this.isRelative) {
            f = 0.0f;
        }
        msg_mission_item.param4 = f;
        return packMissionItem;
    }

    public void unpackMAVMessage(msg_mission_item msg_mission_item) {
        int i = 1;
        this.isRelative = msg_mission_item.param4 != 0.0f;
        this.angle = (double) msg_mission_item.param1;
        float f = msg_mission_item.param2;
        if (msg_mission_item.param3 > 0.0f) {
            i = -1;
        }
        this.angularSpeed = (double) (f * ((float) i));
    }

    public MissionItemType getType() {
        return MissionItemType.CONDITION_YAW;
    }

    public void setAngle(double d) {
        this.angle = d;
    }

    public void setRelative(boolean z) {
        this.isRelative = z;
    }

    public void setAngularSpeed(double d) {
        this.angularSpeed = d;
    }

    public double getAngle() {
        return this.angle;
    }

    public double getAngularSpeed() {
        return this.angularSpeed;
    }

    public boolean isRelative() {
        return this.isRelative;
    }
}
