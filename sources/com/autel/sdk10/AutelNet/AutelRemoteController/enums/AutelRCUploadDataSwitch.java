package com.autel.sdk10.AutelNet.AutelRemoteController.enums;

public enum AutelRCUploadDataSwitch {
    CLOSE(0),
    OPEN(1);
    
    private int value;

    private AutelRCUploadDataSwitch(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
