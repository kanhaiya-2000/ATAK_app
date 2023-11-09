package com.autel.internal.sdk.mission;

import com.autel.common.mission.CurrentMissionState;

public class AutelMissionStateInternal implements MissionState {
    private int wp_mode = -100;

    /* access modifiers changed from: protected */
    public void setCurrentMissionState(int i) {
        this.wp_mode = i;
    }

    public CurrentMissionState getCurrentMissionState() {
        return CurrentMissionState.find(this.wp_mode);
    }

    public String toString() {
        return "wp_mode = " + this.wp_mode;
    }
}
