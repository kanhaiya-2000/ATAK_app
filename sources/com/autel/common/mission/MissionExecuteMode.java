package com.autel.common.mission;

public enum MissionExecuteMode {
    TAKE_OFF(1),
    GOING_FIRST(2),
    IN_MISSION(3),
    GOING_LANDING(4),
    LANDING(5),
    HOVER(6),
    UNKNOWN(-1);
    
    int value;

    private MissionExecuteMode(int i) {
        this.value = i;
    }

    public static MissionExecuteMode find(int i) {
        MissionExecuteMode missionExecuteMode = TAKE_OFF;
        if (missionExecuteMode.value == i) {
            return missionExecuteMode;
        }
        MissionExecuteMode missionExecuteMode2 = GOING_FIRST;
        if (missionExecuteMode2.value == i) {
            return missionExecuteMode2;
        }
        MissionExecuteMode missionExecuteMode3 = IN_MISSION;
        if (missionExecuteMode3.value == i) {
            return missionExecuteMode3;
        }
        MissionExecuteMode missionExecuteMode4 = GOING_LANDING;
        if (missionExecuteMode4.value == i) {
            return missionExecuteMode4;
        }
        MissionExecuteMode missionExecuteMode5 = LANDING;
        if (missionExecuteMode5.value == i) {
            return missionExecuteMode5;
        }
        MissionExecuteMode missionExecuteMode6 = HOVER;
        if (missionExecuteMode6.value == i) {
            return missionExecuteMode6;
        }
        return UNKNOWN;
    }
}
