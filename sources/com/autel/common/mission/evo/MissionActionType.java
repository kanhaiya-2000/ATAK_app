package com.autel.common.mission.evo;

public enum MissionActionType {
    INVALID(0),
    TAKE_PHOTO(1),
    START_RECORD(2),
    STOP_RECORD(3),
    CAMERA_PITCH(7),
    START_TIME_LAPSE_SHOOT(11),
    START_DISTANCE_SHOOT(12),
    UNKNOWN(0);
    
    private int value;

    private MissionActionType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static MissionActionType find(int i) {
        MissionActionType missionActionType = INVALID;
        if (missionActionType.getValue() == i) {
            return missionActionType;
        }
        MissionActionType missionActionType2 = TAKE_PHOTO;
        if (missionActionType2.getValue() == i) {
            return missionActionType2;
        }
        MissionActionType missionActionType3 = START_RECORD;
        if (missionActionType3.getValue() == i) {
            return missionActionType3;
        }
        MissionActionType missionActionType4 = STOP_RECORD;
        if (missionActionType4.getValue() == i) {
            return missionActionType4;
        }
        MissionActionType missionActionType5 = CAMERA_PITCH;
        if (missionActionType5.getValue() == i) {
            return missionActionType5;
        }
        MissionActionType missionActionType6 = START_DISTANCE_SHOOT;
        if (missionActionType6.getValue() == i) {
            return missionActionType6;
        }
        MissionActionType missionActionType7 = START_TIME_LAPSE_SHOOT;
        if (missionActionType7.getValue() == i) {
            return missionActionType7;
        }
        return UNKNOWN;
    }
}
