package com.autel.internal.sdk.mission;

public enum MissionStatus {
    START(1),
    CONTINUE(2),
    PAUSE(3),
    CANCEL(4),
    UNKNOWN(-1);
    
    private int value;

    private MissionStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static MissionStatus find(int i) {
        MissionStatus missionStatus = START;
        if (missionStatus.getValue() == i) {
            return missionStatus;
        }
        MissionStatus missionStatus2 = CONTINUE;
        if (missionStatus2.getValue() == i) {
            return missionStatus2;
        }
        MissionStatus missionStatus3 = PAUSE;
        if (missionStatus3.getValue() == i) {
            return missionStatus3;
        }
        MissionStatus missionStatus4 = CANCEL;
        if (missionStatus4.getValue() == i) {
            return missionStatus4;
        }
        return UNKNOWN;
    }
}
