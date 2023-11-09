package com.autel.common.flycontroller;

public enum LedPilotLamp {
    ALL_OFF(0),
    BACK_ONLY(1),
    FRONT_ONLY(2),
    ALL_ON(3),
    TAKE_PHOTO_GLINT(4),
    START_RECORD_GLINT(8),
    UNKNOWN(-1);
    
    private int value;

    private LedPilotLamp(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static LedPilotLamp find(int i) {
        LedPilotLamp ledPilotLamp = ALL_OFF;
        if (ledPilotLamp.getValue() == i) {
            return ledPilotLamp;
        }
        LedPilotLamp ledPilotLamp2 = BACK_ONLY;
        if (ledPilotLamp2.getValue() == i) {
            return ledPilotLamp2;
        }
        LedPilotLamp ledPilotLamp3 = FRONT_ONLY;
        if (ledPilotLamp3.getValue() == i) {
            return ledPilotLamp3;
        }
        LedPilotLamp ledPilotLamp4 = ALL_ON;
        if (ledPilotLamp4.getValue() == i) {
            return ledPilotLamp4;
        }
        LedPilotLamp ledPilotLamp5 = TAKE_PHOTO_GLINT;
        if (ledPilotLamp5.getValue() == i) {
            return ledPilotLamp5;
        }
        LedPilotLamp ledPilotLamp6 = START_RECORD_GLINT;
        if (ledPilotLamp6.getValue() == i) {
            return ledPilotLamp6;
        }
        return UNKNOWN;
    }
}
