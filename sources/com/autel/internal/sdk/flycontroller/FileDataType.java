package com.autel.internal.sdk.flycontroller;

public enum FileDataType {
    NFZ(2),
    ELEVATION(1);
    
    private int value;

    private FileDataType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
