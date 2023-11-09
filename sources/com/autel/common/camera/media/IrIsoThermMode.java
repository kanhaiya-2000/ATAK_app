package com.autel.common.camera.media;

public enum IrIsoThermMode {
    OFF(0),
    PERSON(1),
    FIRE(2),
    CUSTOM(3),
    UNKNOWN(-1);
    
    private int value;

    private IrIsoThermMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static IrIsoThermMode find(int i) {
        IrIsoThermMode irIsoThermMode = OFF;
        if (irIsoThermMode.getValue() == i) {
            return irIsoThermMode;
        }
        IrIsoThermMode irIsoThermMode2 = PERSON;
        if (irIsoThermMode2.getValue() == i) {
            return irIsoThermMode2;
        }
        IrIsoThermMode irIsoThermMode3 = FIRE;
        if (irIsoThermMode3.getValue() == i) {
            return irIsoThermMode3;
        }
        IrIsoThermMode irIsoThermMode4 = CUSTOM;
        if (irIsoThermMode4.getValue() == i) {
            return irIsoThermMode4;
        }
        return UNKNOWN;
    }
}
