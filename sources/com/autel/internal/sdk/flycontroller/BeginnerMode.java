package com.autel.internal.sdk.flycontroller;

public enum BeginnerMode {
    DISABLED(0),
    ENABLED(1),
    UNKNOWN(-1);
    
    private int value;

    private BeginnerMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static BeginnerMode find(int i) {
        BeginnerMode beginnerMode = DISABLED;
        if (beginnerMode.getValue() == i) {
            return beginnerMode;
        }
        BeginnerMode beginnerMode2 = ENABLED;
        if (beginnerMode2.getValue() == i) {
            return beginnerMode2;
        }
        return UNKNOWN;
    }
}
