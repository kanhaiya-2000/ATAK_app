package com.autel.internal.sdk.flycontroller;

public enum HeartBeatStatus {
    FIRST(0),
    NORMAL(1),
    STOP(2),
    ERROR(3),
    UNKNOWN(-1);
    
    private int value;

    private HeartBeatStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static HeartBeatStatus find(int i) {
        HeartBeatStatus heartBeatStatus = FIRST;
        if (heartBeatStatus.getValue() == i) {
            return heartBeatStatus;
        }
        HeartBeatStatus heartBeatStatus2 = NORMAL;
        if (heartBeatStatus2.getValue() == i) {
            return heartBeatStatus2;
        }
        HeartBeatStatus heartBeatStatus3 = STOP;
        if (heartBeatStatus3.getValue() == i) {
            return heartBeatStatus3;
        }
        HeartBeatStatus heartBeatStatus4 = ERROR;
        if (heartBeatStatus4.getValue() == i) {
            return heartBeatStatus4;
        }
        return null;
    }
}
