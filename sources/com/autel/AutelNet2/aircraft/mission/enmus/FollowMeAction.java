package com.autel.AutelNet2.aircraft.mission.enmus;

public enum FollowMeAction {
    START(22),
    END(23);
    
    private int value;

    private FollowMeAction(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
