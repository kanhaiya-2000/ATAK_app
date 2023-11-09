package com.autel.common.dsp.evo;

public enum TransferMode {
    FLUENCY(0),
    NORMAL(1),
    HIGH_DEFINITION(2),
    UNKNOWN(-1);
    
    private int value;

    private TransferMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static TransferMode find(int i) {
        TransferMode transferMode = FLUENCY;
        if (transferMode.getValue() == i) {
            return transferMode;
        }
        TransferMode transferMode2 = NORMAL;
        if (transferMode2.getValue() == i) {
            return transferMode2;
        }
        TransferMode transferMode3 = HIGH_DEFINITION;
        if (transferMode3.getValue() == i) {
            return transferMode3;
        }
        return UNKNOWN;
    }
}
