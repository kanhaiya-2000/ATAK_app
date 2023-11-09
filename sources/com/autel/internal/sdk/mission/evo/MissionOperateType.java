package com.autel.internal.sdk.mission.evo;

public enum MissionOperateType {
    REQUEST_TASK(0),
    QUERY_TASK_SUC(1),
    CLEAR_TASK(2),
    REQUEST_EXECUTE_TASK(3),
    REQUEST_STOP_TASK(4),
    REQUEST_PAUSE_TASK(5),
    REQUEST_COUNTINE_TASK(6),
    TASK_DATA_SEND_SUC(7),
    UNKNOWN(-1);
    
    private final int value;

    private MissionOperateType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static MissionOperateType find(int i) {
        MissionOperateType missionOperateType = REQUEST_TASK;
        if (missionOperateType.getValue() == i) {
            return missionOperateType;
        }
        MissionOperateType missionOperateType2 = QUERY_TASK_SUC;
        if (missionOperateType2.getValue() == i) {
            return missionOperateType2;
        }
        MissionOperateType missionOperateType3 = CLEAR_TASK;
        if (missionOperateType3.getValue() == i) {
            return missionOperateType3;
        }
        MissionOperateType missionOperateType4 = REQUEST_EXECUTE_TASK;
        if (missionOperateType4.getValue() == i) {
            return missionOperateType4;
        }
        MissionOperateType missionOperateType5 = REQUEST_STOP_TASK;
        if (missionOperateType5.getValue() == i) {
            return missionOperateType5;
        }
        MissionOperateType missionOperateType6 = REQUEST_PAUSE_TASK;
        if (missionOperateType6.getValue() == i) {
            return missionOperateType6;
        }
        MissionOperateType missionOperateType7 = REQUEST_COUNTINE_TASK;
        if (missionOperateType7.getValue() == i) {
            return missionOperateType7;
        }
        return UNKNOWN;
    }
}
