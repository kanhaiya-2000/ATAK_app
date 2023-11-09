package com.autel.common.mission;

public enum MissionExecuteState {
    PREPARE(3),
    RUNNING(1),
    PAUSE(0),
    COMPLETED(2),
    CANCEL(4),
    HOVER(5),
    UNKNOWN(-1);
    
    int value;

    private MissionExecuteState(int i) {
        this.value = i;
    }

    public static MissionExecuteState find(int i) {
        MissionExecuteState missionExecuteState = PREPARE;
        if (missionExecuteState.value == i) {
            return missionExecuteState;
        }
        MissionExecuteState missionExecuteState2 = RUNNING;
        if (missionExecuteState2.value == i) {
            return missionExecuteState2;
        }
        MissionExecuteState missionExecuteState3 = COMPLETED;
        if (missionExecuteState3.value == i) {
            return missionExecuteState3;
        }
        MissionExecuteState missionExecuteState4 = CANCEL;
        if (missionExecuteState4.value == i) {
            return missionExecuteState4;
        }
        MissionExecuteState missionExecuteState5 = HOVER;
        if (missionExecuteState5.value == i) {
            return missionExecuteState5;
        }
        return UNKNOWN;
    }
}
