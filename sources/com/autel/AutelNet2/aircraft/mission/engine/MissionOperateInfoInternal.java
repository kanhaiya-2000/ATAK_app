package com.autel.AutelNet2.aircraft.mission.engine;

import com.autel.internal.sdk.mission.evo.MissionOperateType;
import com.autel.internal.sdk.mission.evo.OperateDataType;

public class MissionOperateInfoInternal {
    private int OperateType;
    private int param1;
    private int param2;
    private int param3;

    public MissionOperateType getOperateType() {
        return MissionOperateType.find(this.OperateType);
    }

    public void setOperateType(MissionOperateType missionOperateType) {
        this.OperateType = missionOperateType.getValue();
    }

    public int getParam1() {
        return this.param1;
    }

    public void setParam1(OperateDataType operateDataType) {
        this.param1 = operateDataType.getValue();
    }

    public int getParam2() {
        return this.param2;
    }

    public void setParam2(int i) {
        this.param2 = i;
    }

    public int getParam3() {
        return this.param3;
    }

    public void setParam3(int i) {
        this.param3 = i;
    }
}
