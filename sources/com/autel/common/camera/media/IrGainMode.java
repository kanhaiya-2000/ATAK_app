package com.autel.common.camera.media;

public enum IrGainMode {
    HIGH(0),
    LOW(1),
    AUTO(2),
    UNKNOWN(-1);
    
    private int value;

    private IrGainMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static IrGainMode find(int i) {
        IrGainMode irGainMode = HIGH;
        if (irGainMode.getValue() == i) {
            return irGainMode;
        }
        IrGainMode irGainMode2 = AUTO;
        if (irGainMode2.getValue() == i) {
            return irGainMode2;
        }
        return UNKNOWN;
    }
}
